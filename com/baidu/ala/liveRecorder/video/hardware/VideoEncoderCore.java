package com.baidu.ala.liveRecorder.video.hardware;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.baidu.ala.liveRecorder.video.hardware.TextureEncoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public class VideoEncoderCore {
    private static final int DEFAULT_FRAME_RATE = 15;
    private static final int DEFAULT_IFRAME_INTERVAL = 2;
    private static final int LEN = 512000;
    private static final String MIME_TYPE = "video/avc";
    private static final int MIN_STEP_REQ_KEYFRAME_MS = 500;
    private static final boolean REQUEST_BASELINE_PROFILE = true;
    private static final String TAG = "VideoEncoderCore";
    private static final boolean VERBOSE = false;
    private MediaCodec.BufferInfo mBufferInfo;
    private TextureEncoder.EncodeConfig mEncodeConfig;
    private MediaCodec mEncoder;
    private int mFrameCount;
    private int mFrameFps;
    private long mFrameFpsTS;
    private Surface mInputSurface;
    private long mLastKeyFrameTS;
    private long mLastReqKeyFrameTS;
    private OutputCallback mOutputCallback;
    private Bundle mReqKeyFrameParams;
    private byte[] mH264Buffer = new byte[LEN];
    private int mH264MetaSize = 0;
    private byte[] mH264MetaBuff = null;

    /* loaded from: classes6.dex */
    public interface OutputCallback {
        public static final int KEY_FRAME = 2;
        public static final int MC_ENCODER_CONFIGURE_ERR = 1;
        public static final int MC_ENCODER_EXCEPTION_ERR = 2;
        public static final int MC_ENCODER_TIMEOUT_ERR = 2;
        public static final int MC_ENCODER_UNKNOW_ERR = 3;
        public static final int NONE_KYE_FRAME = 4;

        void onCodecConfig(byte[] bArr, int i, int i2);

        void onCodecData(byte[] bArr, int i, int i2, int i3, long j);

        void onCodecError(int i);

        void onFormatChanged(MediaFormat mediaFormat);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [153=7, 154=7] */
    @TargetApi(19)
    public VideoEncoderCore(TextureEncoder.EncodeConfig encodeConfig, OutputCallback outputCallback) {
        try {
            try {
                try {
                    try {
                        try {
                            this.mBufferInfo = new MediaCodec.BufferInfo();
                            this.mOutputCallback = outputCallback;
                            this.mEncodeConfig = TextureEncoder.EncodeConfig.CloneObj(encodeConfig);
                            checkTextureEncoderConfig(this.mEncodeConfig);
                            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, this.mEncodeConfig.isLandscape ? this.mEncodeConfig.encodeHeight : this.mEncodeConfig.encodeWidth, this.mEncodeConfig.isLandscape ? this.mEncodeConfig.encodeWidth : this.mEncodeConfig.encodeHeight);
                            createVideoFormat.setInteger("color-format", 2130708361);
                            createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.mEncodeConfig.encodeBitrate);
                            createVideoFormat.setInteger("frame-rate", this.mEncodeConfig.H264FPS);
                            createVideoFormat.setInteger("i-frame-interval", this.mEncodeConfig.H264GOP);
                            this.mEncoder = MediaCodec.createEncoderByType(MIME_TYPE);
                            this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                            this.mInputSurface = this.mEncoder.createInputSurface();
                            this.mEncoder.start();
                            this.mReqKeyFrameParams = new Bundle();
                            this.mReqKeyFrameParams.putInt("request-sync", 0);
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (this.mOutputCallback != null) {
                                this.mOutputCallback.onCodecError(1);
                            }
                        }
                    } catch (MediaCodec.CryptoException e2) {
                        e2.printStackTrace();
                        if (this.mOutputCallback != null) {
                            this.mOutputCallback.onCodecError(1);
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    if (this.mOutputCallback != null) {
                        this.mOutputCallback.onCodecError(1);
                    }
                }
            } catch (IllegalStateException e4) {
                e4.printStackTrace();
                if (this.mOutputCallback != null) {
                    this.mOutputCallback.onCodecError(1);
                }
            }
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
            if (this.mOutputCallback != null) {
                this.mOutputCallback.onCodecError(1);
            }
        } catch (NullPointerException e6) {
            e6.printStackTrace();
            if (this.mOutputCallback != null) {
                this.mOutputCallback.onCodecError(1);
            }
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    @TargetApi(16)
    public void release() {
        try {
            if (this.mEncoder != null) {
                this.mEncoder.stop();
                this.mEncoder.release();
                this.mEncoder = null;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @TargetApi(18)
    public void drainEncoder(boolean z) {
        if (z) {
            try {
                this.mEncoder.signalEndOfInputStream();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (this.mOutputCallback != null) {
                        this.mOutputCallback.onFormatChanged(this.mEncoder.getOutputFormat());
                    }
                } else if (dequeueOutputBuffer < 0) {
                    Log.w(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    checkIfRequestKeyFrame();
                    byteBuffer.position(0);
                    int capacity = byteBuffer.capacity();
                    byteBuffer.get(this.mH264Buffer, 0, LEN < this.mBufferInfo.size - byteBuffer.position() ? LEN : this.mBufferInfo.size - byteBuffer.position());
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        captureH264MetaData(this.mH264Buffer, this.mBufferInfo, capacity);
                        if (this.mOutputCallback != null) {
                            this.mOutputCallback.onCodecConfig(this.mH264MetaBuff, 0, this.mBufferInfo.size);
                        }
                    } else if ((this.mBufferInfo.flags & 1) != 0) {
                        if ((this.mBufferInfo.flags & 2) != 0) {
                            captureH264MetaData(this.mH264Buffer, this.mBufferInfo, capacity);
                            if (this.mOutputCallback != null) {
                                this.mOutputCallback.onCodecConfig(this.mH264MetaBuff, 0, this.mBufferInfo.size);
                            }
                        }
                        packageH264Keyframe(this.mH264Buffer, this.mBufferInfo);
                        if (this.mOutputCallback != null) {
                            this.mOutputCallback.onCodecData(this.mH264MetaBuff, 0, this.mBufferInfo.size + this.mH264MetaSize, 2, this.mBufferInfo.presentationTimeUs / 1000);
                        }
                    } else if (this.mOutputCallback != null) {
                        this.mOutputCallback.onCodecData(this.mH264Buffer, 0, this.mBufferInfo.size, 4, this.mBufferInfo.presentationTimeUs / 1000);
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (!z) {
                            Log.w(TAG, "reached end of stream unexpectedly");
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            if (this.mOutputCallback != null) {
                this.mOutputCallback.onCodecError(2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (this.mOutputCallback != null) {
                this.mOutputCallback.onCodecError(2);
            }
        }
    }

    private void checkIfRequestKeyFrame() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mFrameFpsTS == 0) {
            this.mFrameFpsTS = currentTimeMillis;
            this.mFrameFps = 0;
        }
        if (this.mFrameFpsTS + 1000 > currentTimeMillis) {
            this.mFrameFps++;
        } else {
            this.mFrameFps = 0;
            this.mFrameFpsTS = currentTimeMillis;
        }
        if ((this.mBufferInfo.flags & 1) != 0) {
            z = true;
        } else if ((this.mBufferInfo.flags & 2) != 0) {
            z = false;
        } else if ((this.mBufferInfo.flags & 8) != 0) {
            z = false;
        } else {
            if ((this.mBufferInfo.flags & 1) != 0) {
            }
            z = false;
        }
        if (z) {
            this.mFrameCount = 0;
            this.mLastKeyFrameTS = currentTimeMillis;
        } else {
            this.mFrameCount++;
        }
        if (this.mLastKeyFrameTS + (this.mEncodeConfig.H264GOP * 1000) < currentTimeMillis && Build.VERSION.SDK_INT >= 19) {
            try {
                if (this.mLastReqKeyFrameTS + 500 > currentTimeMillis) {
                    this.mLastReqKeyFrameTS = currentTimeMillis;
                    this.mEncoder.setParameters(this.mReqKeyFrameParams);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(16)
    private void captureH264MetaData(byte[] bArr, MediaCodec.BufferInfo bufferInfo, int i) {
        this.mH264MetaSize = bufferInfo.size;
        if (this.mH264MetaBuff == null || this.mH264MetaBuff.length < i) {
            this.mH264MetaBuff = new byte[i];
        }
        System.arraycopy(bArr, 0, this.mH264MetaBuff, 0, bufferInfo.size);
    }

    @TargetApi(16)
    private void packageH264Keyframe(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        System.arraycopy(bArr, bufferInfo.offset, this.mH264MetaBuff, this.mH264MetaSize, bufferInfo.size);
    }

    @TargetApi(16)
    private int selectProfile(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < codecCapabilities.profileLevels.length; i++) {
            if (codecCapabilities.profileLevels[i].profile == 8) {
                z2 = true;
            } else if (codecCapabilities.profileLevels[i].profile == 2) {
                z = true;
            }
        }
        if (z2) {
            return 8;
        }
        return z ? 2 : 1;
    }

    private void checkTextureEncoderConfig(TextureEncoder.EncodeConfig encodeConfig) {
        if (encodeConfig.encodeWidth == 0 || encodeConfig.encodeHeight == 0) {
            Log.e(TAG, "checkTextureEncoderConfig config encodeWidth " + encodeConfig.encodeWidth + " encodeHeight " + encodeConfig.encodeHeight);
        }
        if (encodeConfig.encodeBitrate < 1024) {
            Log.e(TAG, "checkTextureEncoderConfig config encodeBitrate " + encodeConfig.encodeBitrate);
        }
        if (encodeConfig.H264FPS == 0 || encodeConfig.H264FPS > 25) {
            Log.e(TAG, "checkTextureEncoderConfig config H264FPS " + encodeConfig.H264FPS);
        }
        if (encodeConfig.H264GOP == 0 || encodeConfig.H264GOP > 10) {
            Log.e(TAG, "checkTextureEncoderConfig config H264GOP " + encodeConfig.H264GOP);
        }
    }

    public void setOutputCallback(OutputCallback outputCallback) {
        this.mOutputCallback = outputCallback;
    }

    public TextureEncoder.EncodeConfig getEncodeConfig() {
        return this.mEncodeConfig;
    }
}

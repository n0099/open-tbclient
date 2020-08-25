package com.baidu.rtc.camera.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.baidu.fsg.face.liveness.video.f;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class d {
    private a bNt;
    private MediaCodec.BufferInfo mBufferInfo;
    private MediaCodec mEncoder;
    private int mFrameCount;
    private int mFrameFps;
    private long mFrameFpsTS;
    private Surface mInputSurface;
    private long mLastKeyFrameTS;
    private long mLastReqKeyFrameTS;
    private Bundle mReqKeyFrameParams;
    private byte[] mH264Buffer = new byte[512000];
    private int mH264MetaSize = 0;
    private byte[] mH264MetaBuff = null;

    /* loaded from: classes11.dex */
    public interface a {
        void onCodecConfig(byte[] bArr, int i, int i2);

        void onCodecData(byte[] bArr, int i, int i2, int i3, long j);

        void onCodecError(int i);

        void onFormatChanged(MediaFormat mediaFormat);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [148=7, 149=7] */
    @TargetApi(19)
    public d(a aVar) {
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                this.mBufferInfo = new MediaCodec.BufferInfo();
                                this.bNt = aVar;
                                b WF = b.WF();
                                a(WF);
                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(f.b, WF.isLandscape ? WF.encodeHeight : WF.encodeWidth, WF.isLandscape ? WF.encodeWidth : WF.encodeHeight);
                                createVideoFormat.setInteger("color-format", 2130708361);
                                createVideoFormat.setInteger("bitrate", WF.encodeBitrate);
                                createVideoFormat.setInteger("frame-rate", WF.H264FPS);
                                createVideoFormat.setInteger("i-frame-interval", WF.H264GOP);
                                this.mEncoder = MediaCodec.createEncoderByType(f.b);
                                this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                                this.mInputSurface = this.mEncoder.createInputSurface();
                                this.mEncoder.start();
                                this.mReqKeyFrameParams = new Bundle();
                                this.mReqKeyFrameParams.putInt("request-sync", 0);
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                                if (this.bNt != null) {
                                    this.bNt.onCodecError(1);
                                }
                            }
                        } catch (IllegalArgumentException e2) {
                            e2.printStackTrace();
                            if (this.bNt != null) {
                                this.bNt.onCodecError(1);
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (this.bNt != null) {
                            this.bNt.onCodecError(1);
                        }
                    }
                } catch (MediaCodec.CryptoException e4) {
                    e4.printStackTrace();
                    if (this.bNt != null) {
                        this.bNt.onCodecError(1);
                    }
                }
            } catch (NullPointerException e5) {
                e5.printStackTrace();
                if (this.bNt != null) {
                    this.bNt.onCodecError(1);
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            if (this.bNt != null) {
                this.bNt.onCodecError(1);
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
                    if (this.bNt != null) {
                        this.bNt.onFormatChanged(this.mEncoder.getOutputFormat());
                    }
                } else if (dequeueOutputBuffer < 0) {
                    Log.w("VideoEncoderCore", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    checkIfRequestKeyFrame();
                    byteBuffer.position(0);
                    int capacity = byteBuffer.capacity();
                    byteBuffer.get(this.mH264Buffer, 0, 512000 < this.mBufferInfo.size - byteBuffer.position() ? 512000 : this.mBufferInfo.size - byteBuffer.position());
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        captureH264MetaData(this.mH264Buffer, this.mBufferInfo, capacity);
                        if (this.bNt != null) {
                            this.bNt.onCodecConfig(this.mH264MetaBuff, 0, this.mBufferInfo.size);
                        }
                    } else if ((this.mBufferInfo.flags & 1) != 0) {
                        if ((this.mBufferInfo.flags & 2) != 0) {
                            captureH264MetaData(this.mH264Buffer, this.mBufferInfo, capacity);
                            if (this.bNt != null) {
                                this.bNt.onCodecConfig(this.mH264MetaBuff, 0, this.mBufferInfo.size);
                            }
                        }
                        packageH264Keyframe(this.mH264Buffer, this.mBufferInfo);
                        if (this.bNt != null) {
                            this.bNt.onCodecData(this.mH264MetaBuff, 0, this.mBufferInfo.size + this.mH264MetaSize, 2, this.mBufferInfo.presentationTimeUs / 1000);
                        }
                    } else if (this.bNt != null) {
                        this.bNt.onCodecData(this.mH264Buffer, 0, this.mBufferInfo.size, 4, this.mBufferInfo.presentationTimeUs / 1000);
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        if (!z) {
                            Log.w("VideoEncoderCore", "reached end of stream unexpectedly");
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            if (this.bNt != null) {
                this.bNt.onCodecError(2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (this.bNt != null) {
                this.bNt.onCodecError(2);
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
        if (this.mLastKeyFrameTS + (b.WF().H264GOP * 1000) < currentTimeMillis && Build.VERSION.SDK_INT >= 19) {
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

    private void a(b bVar) {
        if (bVar.encodeWidth == 0 || bVar.encodeHeight == 0) {
            Log.e("VideoEncoderCore", "checkTextureEncoderConfig config encodeWidth " + bVar.encodeWidth + " encodeHeight " + bVar.encodeHeight);
        }
        if (bVar.encodeBitrate < 1024) {
            Log.e("VideoEncoderCore", "checkTextureEncoderConfig config encodeBitrate " + bVar.encodeBitrate);
        }
        if (bVar.H264FPS == 0 || bVar.H264FPS > 25) {
            Log.e("VideoEncoderCore", "checkTextureEncoderConfig config H264FPS " + bVar.H264FPS);
        }
        if (bVar.H264GOP == 0 || bVar.H264GOP > 10) {
            Log.e("VideoEncoderCore", "checkTextureEncoderConfig config H264GOP " + bVar.H264GOP);
        }
    }

    public void a(a aVar) {
        this.bNt = aVar;
    }
}

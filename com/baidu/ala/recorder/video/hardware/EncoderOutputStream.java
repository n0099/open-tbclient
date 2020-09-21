package com.baidu.ala.recorder.video.hardware;

import android.media.MediaCodec;
import android.os.Bundle;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class EncoderOutputStream {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT = 500000;
    private static final int LEN = 307200;
    private static final int STATUS_RUNNING = 0;
    private static final int STATUS_STOP = 1;
    private OnEncoderError mErrorCallback;
    private MediaCodec mMediaCodec;
    private OnEncoderOutput mOutput;
    private volatile int mStatus = 0;
    private ByteBuffer mBuffer = null;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private int mCapacity = 0;
    private Thread mThread = null;
    private volatile int mRetryCount = 0;
    private byte[] mKeyFrameBuffer = null;
    private int mH264MetaSize = 0;
    private byte[] buffer = new byte[307200];
    private long mLastTime = 0;
    private long mNoStreamTime = 0;
    private long mTryAgainStatusCount = 0;
    private volatile boolean mHasStream = false;
    private long mLastIFrameTime = 0;
    private Runnable mPumpRunnable = new Runnable() { // from class: com.baidu.ala.recorder.video.hardware.EncoderOutputStream.1
        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            IllegalStateException illegalStateException;
            ByteBuffer[] byteBufferArr;
            int dequeueOutputBuffer;
            ByteBuffer[] byteBufferArr2;
            try {
                if (EncoderOutputStream.this.mLastTime == 0) {
                    EncoderOutputStream.this.mLastTime = System.currentTimeMillis();
                    EncoderOutputStream.this.mNoStreamTime = System.currentTimeMillis();
                }
                EncoderOutputStream.this.mHasStream = true;
                ByteBuffer[] outputBuffers = EncoderOutputStream.this.mMediaCodec.getOutputBuffers();
                while (EncoderOutputStream.this.mStatus == 0) {
                    try {
                        if (System.currentTimeMillis() - EncoderOutputStream.this.mNoStreamTime <= 10000) {
                            if (System.currentTimeMillis() - EncoderOutputStream.this.mLastTime > 5000) {
                                BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "get data overtime, try count:" + EncoderOutputStream.this.mTryAgainStatusCount);
                                EncoderOutputStream.this.mLastTime = System.currentTimeMillis();
                                EncoderOutputStream.this.mTryAgainStatusCount = 0L;
                            }
                        } else {
                            BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "encoder error, retry init:" + EncoderOutputStream.this.mRetryCount);
                            EncoderOutputStream.access$508(EncoderOutputStream.this);
                            EncoderOutputStream.this.mHasStream = false;
                            EncoderOutputStream.this.mNoStreamTime = System.currentTimeMillis();
                            EncoderOutputStream.this.mStatus = 1;
                        }
                        dequeueOutputBuffer = EncoderOutputStream.this.mMediaCodec.dequeueOutputBuffer(EncoderOutputStream.this.mBufferInfo, 500000L);
                        if (dequeueOutputBuffer >= 0) {
                            EncoderOutputStream.this.mHasStream = true;
                            EncoderOutputStream.this.mLastTime = System.currentTimeMillis();
                            EncoderOutputStream.this.mNoStreamTime = System.currentTimeMillis();
                            EncoderOutputStream.this.mBuffer = outputBuffers[dequeueOutputBuffer];
                            EncoderOutputStream.this.mBuffer.position(0);
                            EncoderOutputStream.this.mCapacity = EncoderOutputStream.this.mBuffer.capacity();
                            EncoderOutputStream.this.mBuffer.get(EncoderOutputStream.this.buffer, 0, 307200 < EncoderOutputStream.this.mBufferInfo.size - EncoderOutputStream.this.mBuffer.position() ? 307200 : EncoderOutputStream.this.mBufferInfo.size - EncoderOutputStream.this.mBuffer.position());
                            if ((EncoderOutputStream.this.mBufferInfo.flags & 1) != 0) {
                                EncoderOutputStream.this.mLastIFrameTime = System.currentTimeMillis();
                                if ((EncoderOutputStream.this.mBufferInfo.flags & 2) != 0) {
                                    EncoderOutputStream.this.captureH264MetaData(EncoderOutputStream.this.buffer, EncoderOutputStream.this.mBufferInfo, EncoderOutputStream.this.mCapacity);
                                }
                                EncoderOutputStream.this.packageH264Keyframe(EncoderOutputStream.this.buffer, EncoderOutputStream.this.mBufferInfo);
                                if (EncoderOutputStream.this.mOutput != null) {
                                    EncoderOutputStream.this.mOutput.onEncode(EncoderOutputStream.this.mKeyFrameBuffer, EncoderOutputStream.this.mH264MetaSize + EncoderOutputStream.this.mBufferInfo.size, false, true, EncoderOutputStream.this.mBufferInfo.presentationTimeUs);
                                }
                            } else if ((EncoderOutputStream.this.mBufferInfo.flags & 2) != 0) {
                                EncoderOutputStream.this.captureH264MetaData(EncoderOutputStream.this.buffer, EncoderOutputStream.this.mBufferInfo, EncoderOutputStream.this.mCapacity);
                            } else if (EncoderOutputStream.this.mOutput != null) {
                                EncoderOutputStream.this.mOutput.onEncode(EncoderOutputStream.this.buffer, EncoderOutputStream.this.mBufferInfo.size, false, false, EncoderOutputStream.this.mBufferInfo.presentationTimeUs);
                            }
                            EncoderOutputStream.this.mTryAgainStatusCount = 0L;
                            EncoderOutputStream.this.mRetryCount = 0;
                            byteBufferArr2 = outputBuffers;
                        } else if (dequeueOutputBuffer == -3) {
                            byteBufferArr2 = EncoderOutputStream.this.mMediaCodec.getOutputBuffers();
                        } else if (dequeueOutputBuffer == -2) {
                            byteBufferArr2 = outputBuffers;
                        } else if (dequeueOutputBuffer == -1) {
                            EncoderOutputStream.access$608(EncoderOutputStream.this);
                            byteBufferArr2 = outputBuffers;
                        } else {
                            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                                BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, BdStatsConstant.StatsType.ERROR, "unkown error: " + dequeueOutputBuffer);
                            }
                            byteBufferArr2 = outputBuffers;
                        }
                    } catch (IllegalStateException e) {
                        illegalStateException = e;
                        byteBufferArr = outputBuffers;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        if (EncoderOutputStream.this.mBuffer != null) {
                            EncoderOutputStream.this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            EncoderOutputStream.this.mBuffer = null;
                        }
                        if (System.currentTimeMillis() - EncoderOutputStream.this.mLastIFrameTime >= 2000) {
                            EncoderOutputStream.this.mLastIFrameTime = System.currentTimeMillis();
                            Bundle bundle = new Bundle();
                            bundle.putInt("request-sync", 0);
                            EncoderOutputStream.this.mMediaCodec.setParameters(bundle);
                        }
                        Thread.sleep(1L);
                        outputBuffers = byteBufferArr2;
                    } catch (IllegalStateException e2) {
                        illegalStateException = e2;
                        byteBufferArr = byteBufferArr2;
                        BdLog.d("EncoderStreamException:" + illegalStateException.getMessage());
                        BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, "exception", illegalStateException.getMessage());
                        outputBuffers = byteBufferArr;
                    } catch (Throwable th3) {
                        th = th3;
                        outputBuffers = byteBufferArr2;
                        BdLog.d("EncoderStreamException:" + th.getMessage());
                        BdStatisticsManager.getInstance().newDebug("AlaLiveEncoder", 0L, null, "exception", th.getMessage());
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            EncoderOutputStream.this.mHasStream = false;
        }
    };

    /* loaded from: classes12.dex */
    public interface OnEncoderError {
        public static final int ERROR_CODE_NEED_CHANGE_ENCODER = 2;
        public static final int ERROR_CODE_NEED_REINIT_ENCODER = 1;

        void onError(int i, String str);
    }

    /* loaded from: classes12.dex */
    public interface OnEncoderOutput {
        void onEncode(byte[] bArr, int i, boolean z, boolean z2, long j);
    }

    static /* synthetic */ int access$508(EncoderOutputStream encoderOutputStream) {
        int i = encoderOutputStream.mRetryCount;
        encoderOutputStream.mRetryCount = i + 1;
        return i;
    }

    static /* synthetic */ long access$608(EncoderOutputStream encoderOutputStream) {
        long j = encoderOutputStream.mTryAgainStatusCount;
        encoderOutputStream.mTryAgainStatusCount = 1 + j;
        return j;
    }

    public EncoderOutputStream(MediaCodec mediaCodec) {
        this.mMediaCodec = null;
        this.mMediaCodec = mediaCodec;
    }

    public void start(int i) {
        this.mRetryCount = i;
        this.mHasStream = false;
        if (this.mThread != null) {
            stop();
        }
        this.mStatus = 0;
        this.mThread = new Thread(this.mPumpRunnable);
        this.mThread.start();
    }

    public void stop() {
        this.mStatus = 1;
        this.mHasStream = false;
        if (this.mThread != null) {
            this.mThread.interrupt();
            this.mThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void captureH264MetaData(byte[] bArr, MediaCodec.BufferInfo bufferInfo, int i) {
        this.mH264MetaSize = bufferInfo.size;
        if (this.mKeyFrameBuffer == null || this.mKeyFrameBuffer.length < i) {
            this.mKeyFrameBuffer = new byte[i];
        }
        System.arraycopy(bArr, 0, this.mKeyFrameBuffer, 0, bufferInfo.size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void packageH264Keyframe(byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        System.arraycopy(bArr, bufferInfo.offset, this.mKeyFrameBuffer, this.mH264MetaSize, bufferInfo.size);
    }

    public void setOutput(OnEncoderOutput onEncoderOutput) {
        this.mOutput = onEncoderOutput;
    }

    public OnEncoderOutput getOutputCallback() {
        return this.mOutput;
    }

    public void setEncodeErrorCallback(OnEncoderError onEncoderError) {
        this.mErrorCallback = onEncoderError;
    }

    public boolean hasStream() {
        return this.mHasStream;
    }
}

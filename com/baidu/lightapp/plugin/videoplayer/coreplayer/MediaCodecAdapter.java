package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class MediaCodecAdapter {
    private static final String TAG = "MediaCodecAdapter";
    private MediaCodec mCodec;
    private ByteBuffer[] mCodecInputBuffers;
    private String mCodecName;
    private ByteBuffer[] mCodecOutputBuffers;
    private MediaFormat mCurrentMediaFormat;
    private String mMimeType;
    private int mVideoHeight;
    private int mVideoWidth;
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private ByteBuffer mSpsBuffer = null;
    private ByteBuffer mPpsBuffer = null;
    private final int MEDIA_CODEC_ERROR_EXCEPTION = -2000;

    public MediaCodecAdapter(String str, String str2, int i, int i2) {
        this.mCodec = null;
        CyberPlayerLog.w(TAG, "Create MediaCodecAdapter, mimetype=" + str + ", codecname=" + str2 + ", width=" + i + ", height=" + i2);
        this.mMimeType = str;
        this.mCodecName = str2;
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mCodec = MediaCodec.createDecoderByType(str);
    }

    public static String bytes2HexString(byte[] bArr) {
        int length = bArr.length < 100 ? bArr.length : 100;
        String str = "";
        for (int i = 0; i < length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSupportedCodecName(String str, int i, int i2, boolean z) {
        String[] supportedTypes;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        CyberPlayerLog.w(TAG, "getSupportedCOdecNameFor : mime=" + str + ", profile=" + i + ", level=" + i2);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (z) {
                if (!codecInfoAt.isEncoder()) {
                    continue;
                }
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equals(str)) {
                        try {
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType(str2).profileLevels) {
                                if (str2.equals(str) && codecProfileLevel.level >= i2) {
                                    CyberPlayerLog.w(TAG, "Find Supported Codec, codec name=" + codecInfoAt.getName() + ", mimetype=" + str2 + ", profile=" + codecProfileLevel.profile + ", level=" + codecProfileLevel.level);
                                    return codecInfoAt.getName();
                                }
                            }
                            continue;
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                    }
                }
                continue;
            } else {
                if (codecInfoAt.isEncoder()) {
                    continue;
                }
                while (r1 < r6) {
                }
                continue;
            }
        }
        return null;
    }

    public void configAndStart(Object obj) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
        if (this.mSpsBuffer != null && this.mPpsBuffer != null) {
            createVideoFormat.setByteBuffer("csd-0", this.mSpsBuffer);
            createVideoFormat.setByteBuffer("csd-1", this.mPpsBuffer);
        }
        bytes2HexString(this.mSpsBuffer.array());
        bytes2HexString(this.mPpsBuffer.array());
        this.mCodec.configure(createVideoFormat, (Surface) obj, (MediaCrypto) null, 0);
        this.mCodec.start();
        this.mCodecInputBuffers = this.mCodec.getInputBuffers();
        this.mCodecOutputBuffers = this.mCodec.getOutputBuffers();
    }

    public int dequeueInputBuffer(long j) {
        if (this.mCodec == null) {
            return -1;
        }
        CyberPlayerLog.v(TAG, "dequeueInputBuffer:" + j);
        try {
            return this.mCodec.dequeueInputBuffer(j);
        } catch (IllegalStateException e) {
            return -2000;
        }
    }

    public int dequeueOutputBuffer(long j) {
        if (this.mCodec == null) {
            return -1;
        }
        try {
            int dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(this.mBufferInfo, j);
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer == -3) {
                    this.mCodecOutputBuffers = this.mCodec.getOutputBuffers();
                    CyberPlayerLog.w(TAG, "output buffers have changed.");
                } else if (dequeueOutputBuffer == -2) {
                    this.mCurrentMediaFormat = this.mCodec.getOutputFormat();
                    CyberPlayerLog.w(TAG, "output format has changed to " + this.mCurrentMediaFormat.toString());
                }
            }
            CyberPlayerLog.v(TAG, "dequeueOutputBuffer");
            return dequeueOutputBuffer;
        } catch (IllegalStateException e) {
            return -2000;
        }
    }

    public int getCurrentOutputBufferFlag() {
        return this.mBufferInfo.flags;
    }

    public int getCurrentOutputBufferSize() {
        return this.mBufferInfo.size;
    }

    public Object getInputByteBuffer(int i) {
        if (this.mCodec == null) {
            return null;
        }
        CyberPlayerLog.v(TAG, "getInputByteBuffer");
        return this.mCodecInputBuffers[i];
    }

    public Object getOutputByteBuffer(int i) {
        if (this.mCodec == null) {
            return null;
        }
        return this.mCodecOutputBuffers[i];
    }

    public int getOutputFormatColorFormat() {
        if (this.mCurrentMediaFormat != null) {
            return this.mCurrentMediaFormat.getInteger("color-format");
        }
        return 0;
    }

    public int getOutputFormatHeight() {
        if (this.mCurrentMediaFormat != null) {
            return this.mCurrentMediaFormat.getInteger("height");
        }
        return 0;
    }

    public int getOutputFormatWidth() {
        if (this.mCurrentMediaFormat != null) {
            return this.mCurrentMediaFormat.getInteger("width");
        }
        return 0;
    }

    public boolean isStreamEOF() {
        return this.mCodec == null || (this.mBufferInfo.flags & 4) != 0;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        if (this.mCodec == null) {
            return;
        }
        CyberPlayerLog.v(TAG, "queueInputBuffer");
        try {
            this.mCodec.queueInputBuffer(i, i2, i3, j, i4);
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to queue iput buffer " + e.toString());
        }
    }

    public void releaseOutputBuffer(int i, boolean z) {
        if (this.mCodec == null) {
            return;
        }
        this.mCodec.releaseOutputBuffer(i, z);
    }

    public void setSpsAndPPs(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return;
        }
        this.mSpsBuffer = ByteBuffer.allocate(bArr.length);
        this.mPpsBuffer = ByteBuffer.allocate(bArr2.length);
        this.mSpsBuffer.put(bArr);
        this.mSpsBuffer.position(0);
        this.mPpsBuffer.put(bArr2);
        this.mPpsBuffer.position(0);
    }

    public void stopAndReleaseCodec() {
        if (this.mCodec != null) {
            this.mCodec.stop();
            this.mCodec.release();
            this.mCodec = null;
        }
    }
}

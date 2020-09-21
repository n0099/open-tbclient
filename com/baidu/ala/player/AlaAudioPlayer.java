package com.baidu.ala.player;

import android.media.AudioTrack;
import com.baidu.ala.helper.AlaAudioBuffer;
import com.baidu.ala.helper.StreamConfig;
import com.baidu.ala.ndk.AudioProcessModule;
import com.baidu.live.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public class AlaAudioPlayer {
    private static final int BUFFER_LENGTH = 4096;
    private static final boolean ENABLE_FRAGMENT = false;
    private static final String TAG = "LIVE_SDK_JNI";
    private AlaAudioBuffer mAudioBuffer;
    private AudioTrack mAudioTrack;
    private int mChannels;
    private int mFramesPerBuffer;
    private volatile boolean mIsEnableACE;
    private ByteBuffer mNativeBuffer;
    private int[] mNativeLenArr;
    private int[] mNativePosArr;
    private byte[] mRtcBuffer;
    private int mSampleRate;

    public AlaAudioPlayer() {
        this(44100, 4, false);
    }

    public AlaAudioPlayer(int i, int i2, boolean z) {
        boolean z2;
        int i3 = 0;
        this.mAudioTrack = null;
        this.mIsEnableACE = false;
        this.mSampleRate = 0;
        this.mChannels = 0;
        this.mFramesPerBuffer = 256;
        this.mAudioBuffer = null;
        this.mRtcBuffer = null;
        this.mNativeBuffer = null;
        this.mNativePosArr = new int[1];
        this.mNativeLenArr = new int[1];
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mIsEnableACE = z;
        try {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.release();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mAudioBuffer = new AlaAudioBuffer();
        this.mRtcBuffer = new byte[4096];
        this.mNativeBuffer = ByteBuffer.allocateDirect(4096);
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, 2);
        if (!z) {
            i3 = 3;
            z2 = true;
        } else {
            try {
                if (StreamConfig.useOpenSLES()) {
                    i3 = 3;
                    z2 = false;
                } else {
                    AudioProcessModule.sharedInstance().setRenderBuffer(this.mNativeBuffer, 1.4f);
                    z2 = true;
                }
            } catch (IllegalArgumentException e2) {
                this.mAudioTrack = null;
                BdLog.e(e2.getMessage());
                return;
            }
        }
        BdLog.e("LIVE_SDK_JNIaudio stream type=" + i3);
        if (z2) {
            this.mFramesPerBuffer = (i / 100) * 2;
            this.mAudioTrack = new AudioTrack(i3, i, i2, 2, minBufferSize, 1);
        }
    }

    public int getCurAudioStreamType(boolean z) {
        if (!z || StreamConfig.useOpenSLES()) {
            return 3;
        }
        return 0;
    }

    public void writeData(byte[] bArr, int i, int i2) {
        if (this.mIsEnableACE) {
            writeDataForACE(bArr, i, i2);
        } else if (bArr != null && bArr.length != 0 && this.mAudioTrack != null && this.mAudioTrack.getState() != 0) {
            try {
                int playState = this.mAudioTrack.getPlayState();
                if (playState != 3) {
                    this.mAudioTrack.play();
                    playState = this.mAudioTrack.getPlayState();
                }
                if (playState == 3) {
                    this.mAudioTrack.write(bArr, i, i2);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void stopAndRelease() {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
                this.mRtcBuffer = null;
                this.mAudioBuffer = null;
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.mAudioTrack = null;
        }
    }

    private void writeDataForACE(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length != 0 && this.mAudioTrack != null && this.mAudioTrack.getState() != 0) {
            try {
                int playState = this.mAudioTrack.getPlayState();
                if (playState != 3) {
                    this.mAudioTrack.play();
                    playState = this.mAudioTrack.getPlayState();
                }
                if (playState == 3) {
                    try {
                        this.mNativeBuffer.rewind();
                        this.mNativeBuffer.put(bArr, i, i2);
                        this.mNativePosArr[0] = 0;
                        this.mNativeLenArr[0] = i2;
                        if (AudioProcessModule.sharedInstance().updateRenderBuffer(this.mNativePosArr, this.mNativeLenArr) != 0) {
                            BdLog.e("AudioProcessModule.updateRenderBuffer failed");
                        }
                        this.mAudioTrack.write(this.mNativeBuffer.array(), this.mNativeBuffer.arrayOffset(), i2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}

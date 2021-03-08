package com.baidu.ala.ndk;
/* loaded from: classes5.dex */
public class AlaAudioFrame {
    private static final int CHANNEL_NB = 1;
    private static final int SAMPLE_RATE = 44100;
    public int sampleRate = 44100;
    public int channels = 1;
    public int length = 0;
    public byte[] bytes = null;
    public long pts = 0;
    public long dts = 0;

    public void setupConfig(int i, int i2) {
        this.sampleRate = i;
        this.channels = isMono(i2) ? 1 : 2;
    }

    public void fillAudioData(byte[] bArr, int i) {
        this.bytes = bArr;
        this.length = i;
        this.pts = AlaNdkAdapter.getMediaStreamTS(false);
        this.dts = AlaNdkAdapter.getMediaStreamTS(false);
    }

    public static boolean isMono(int i) {
        return 16 == i || 4 == i;
    }
}

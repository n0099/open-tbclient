package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate St;
    private int Sr = -1;
    private int Ss;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate pC() {
        if (St == null) {
            St = new BdSoundGate();
        }
        return St;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        pC().a(i, 0.0f, d.bi(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Ss = i;
        this.Sr = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Ss;
    }

    public void release() {
        if (this.Sr > 0) {
            close(this.Sr);
            this.Sr = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Sr, sArr, sArr2);
    }
}

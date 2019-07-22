package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate TG;
    private int TD = -1;
    private int TF;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qd() {
        if (TG == null) {
            TG = new BdSoundGate();
        }
        return TG;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qd().a(i, 0.0f, d.bj(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.TF = i;
        this.TD = getChanger(i, f, f2, f3);
    }

    public int qe() {
        return this.TF;
    }

    public void release() {
        if (this.TD > 0) {
            close(this.TD);
            this.TD = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.TD, sArr, sArr2);
    }
}

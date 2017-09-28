package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate Jm;
    private int Jk = -1;
    private int Jl;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lE() {
        if (Jm == null) {
            Jm = new BdSoundGate();
        }
        return Jm;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lE().a(i, 0.0f, d.aR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Jl = i;
        this.Jk = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Jl;
    }

    public void release() {
        if (this.Jk > 0) {
            close(this.Jk);
            this.Jk = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Jk, sArr, sArr2);
    }
}

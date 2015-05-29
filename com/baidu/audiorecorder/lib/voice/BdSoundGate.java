package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Kc;
    private int Ka = -1;
    private int Kb;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate oh() {
        if (Kc == null) {
            Kc = new BdSoundGate();
        }
        return Kc;
    }

    private BdSoundGate() {
    }

    public void k(int i, int i2) {
        oh().a(i, 0.0f, f.aF(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Kb = i;
        this.Ka = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Kb;
    }

    public void release() {
        if (this.Ka > 0) {
            close(this.Ka);
            this.Ka = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Ka, sArr, sArr2);
    }
}

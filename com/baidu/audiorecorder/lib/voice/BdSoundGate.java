package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ld;
    private int Lb = -1;
    private int Lc;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate on() {
        if (Ld == null) {
            Ld = new BdSoundGate();
        }
        return Ld;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        on().a(i, 0.0f, f.aO(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Lc = i;
        this.Lb = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Lc;
    }

    public void release() {
        if (this.Lb > 0) {
            close(this.Lb);
            this.Lb = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Lb, sArr, sArr2);
    }
}

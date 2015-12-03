package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Ky;
    private int Kw = -1;
    private int Kx;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate ov() {
        if (Ky == null) {
            Ky = new BdSoundGate();
        }
        return Ky;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        ov().a(i, 0.0f, f.aI(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Kx = i;
        this.Kw = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Kx;
    }

    public void release() {
        if (this.Kw > 0) {
            close(this.Kw);
            this.Kw = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Kw, sArr, sArr2);
    }
}

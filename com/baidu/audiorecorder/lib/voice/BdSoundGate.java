package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate Lk;
    private int Li = -1;
    private int Lj;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate og() {
        if (Lk == null) {
            Lk = new BdSoundGate();
        }
        return Lk;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        og().a(i, 0.0f, f.aN(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Lj = i;
        this.Li = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Lj;
    }

    public void release() {
        if (this.Li > 0) {
            close(this.Li);
            this.Li = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Li, sArr, sArr2);
    }
}

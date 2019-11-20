package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate Cw;
    private int Cu = -1;
    private int Cv;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate kY() {
        if (Cw == null) {
            Cw = new BdSoundGate();
        }
        return Cw;
    }

    private BdSoundGate() {
    }

    public void l(int i, int i2) {
        kY().a(i, 0.0f, d.ay(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Cv = i;
        this.Cu = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Cv;
    }

    public void release() {
        if (this.Cu > 0) {
            close(this.Cu);
            this.Cu = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Cu, sArr, sArr2);
    }
}

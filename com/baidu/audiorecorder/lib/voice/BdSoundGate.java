package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate Jz;
    private int Jx = -1;
    private int Jy;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lB() {
        if (Jz == null) {
            Jz = new BdSoundGate();
        }
        return Jz;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lB().a(i, 0.0f, d.aN(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.Jy = i;
        this.Jx = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.Jy;
    }

    public void release() {
        if (this.Jx > 0) {
            close(this.Jx);
            this.Jx = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Jx, sArr, sArr2);
    }
}

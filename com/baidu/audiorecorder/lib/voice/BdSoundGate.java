package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate VB;
    private int VA;
    private int Vz = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate qN() {
        if (VB == null) {
            VB = new BdSoundGate();
        }
        return VB;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        qN().a(i, 0.0f, d.bq(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.VA = i;
        this.Vz = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.VA;
    }

    public void release() {
        if (this.Vz > 0) {
            close(this.Vz);
            this.Vz = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Vz, sArr, sArr2);
    }
}

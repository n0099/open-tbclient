package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate SW;
    private int SU = -1;
    private int SV;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate pL() {
        if (SW == null) {
            SW = new BdSoundGate();
        }
        return SW;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        pL().a(i, 0.0f, d.bx(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.SV = i;
        this.SU = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.SV;
    }

    public void release() {
        if (this.SU > 0) {
            close(this.SU);
            this.SU = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.SU, sArr, sArr2);
    }
}

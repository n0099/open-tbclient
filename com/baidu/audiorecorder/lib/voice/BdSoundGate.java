package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes6.dex */
public class BdSoundGate {
    private static BdSoundGate CY;
    private int CW = -1;
    private int CX;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate kY() {
        if (CY == null) {
            CY = new BdSoundGate();
        }
        return CY;
    }

    private BdSoundGate() {
    }

    public void n(int i, int i2) {
        kY().a(i, 0.0f, d.ay(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.CX = i;
        this.CW = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.CX;
    }

    public void release() {
        if (this.CW > 0) {
            close(this.CW);
            this.CW = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.CW, sArr, sArr2);
    }
}

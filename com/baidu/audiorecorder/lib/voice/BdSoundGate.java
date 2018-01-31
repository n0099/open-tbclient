package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axD;
    private int axB = -1;
    private int axC;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tc() {
        if (axD == null) {
            axD = new BdSoundGate();
        }
        return axD;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tc().a(i, 0.0f, d.dR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.axC = i;
        this.axB = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axC;
    }

    public void release() {
        if (this.axB > 0) {
            close(this.axB);
            this.axB = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axB, sArr, sArr2);
    }
}

package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axB;
    private int axA;
    private int axz = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tb() {
        if (axB == null) {
            axB = new BdSoundGate();
        }
        return axB;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tb().a(i, 0.0f, d.dR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.axA = i;
        this.axz = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axA;
    }

    public void release() {
        if (this.axz > 0) {
            close(this.axz);
            this.axz = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axz, sArr, sArr2);
    }
}

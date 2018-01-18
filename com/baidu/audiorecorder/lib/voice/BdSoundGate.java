package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axA;
    private int axy = -1;
    private int axz;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tb() {
        if (axA == null) {
            axA = new BdSoundGate();
        }
        return axA;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tb().a(i, 0.0f, d.dR(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.axz = i;
        this.axy = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axz;
    }

    public void release() {
        if (this.axy > 0) {
            close(this.axy);
            this.axy = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axy, sArr, sArr2);
    }
}

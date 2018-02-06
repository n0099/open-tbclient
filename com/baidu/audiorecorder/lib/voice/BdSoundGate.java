package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axC;
    private int axA = -1;
    private int axB;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tb() {
        if (axC == null) {
            axC = new BdSoundGate();
        }
        return axC;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tb().b(i, 0.0f, d.dS(i2), 0.0f);
    }

    public void b(int i, float f, float f2, float f3) {
        this.axB = i;
        this.axA = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axB;
    }

    public void release() {
        if (this.axA > 0) {
            close(this.axA);
            this.axA = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axA, sArr, sArr2);
    }
}

package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate KZ;
    private int KX = -1;
    private int KY;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lK() {
        if (KZ == null) {
            KZ = new BdSoundGate();
        }
        return KZ;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lK().a(i, 0.0f, d.aP(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.KY = i;
        this.KX = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.KY;
    }

    public void release() {
        if (this.KX > 0) {
            close(this.KX);
            this.KX = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.KX, sArr, sArr2);
    }
}

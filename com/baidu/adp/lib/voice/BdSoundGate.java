package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate oB;
    private int iK;
    private int oA = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate fK() {
        if (oB == null) {
            oB = new BdSoundGate();
        }
        return oB;
    }

    private BdSoundGate() {
    }

    public void c(int i, int i2) {
        fK().a(i, 0.0f, o.ad(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.iK = i;
        this.oA = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.iK;
    }

    public void release() {
        if (this.oA > 0) {
            close(this.oA);
            this.oA = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.oA, sArr, sArr2);
    }
}

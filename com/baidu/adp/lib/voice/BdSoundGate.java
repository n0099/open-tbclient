package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate oC;
    private int iE;
    private int oB = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate fI() {
        if (oC == null) {
            oC = new BdSoundGate();
        }
        return oC;
    }

    private BdSoundGate() {
    }

    public void b(int i, int i2) {
        fI().a(i, 0.0f, o.V(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.iE = i;
        this.oB = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.iE;
    }

    public void release() {
        if (this.oB > 0) {
            close(this.oB);
            this.oB = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.oB, sArr, sArr2);
    }
}

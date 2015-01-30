package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate oG;
    private int iM;
    private int oF = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate fJ() {
        if (oG == null) {
            oG = new BdSoundGate();
        }
        return oG;
    }

    private BdSoundGate() {
    }

    public void c(int i, int i2) {
        fJ().a(i, 0.0f, o.ai(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.iM = i;
        this.oF = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.iM;
    }

    public void release() {
        if (this.oF > 0) {
            close(this.oF);
            this.oF = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.oF, sArr, sArr2);
    }
}

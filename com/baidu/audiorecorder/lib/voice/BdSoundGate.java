package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes3.dex */
public class BdSoundGate {
    private static BdSoundGate SJ;
    private int SG = -1;
    private int SH;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate pK() {
        if (SJ == null) {
            SJ = new BdSoundGate();
        }
        return SJ;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        pK().a(i, 0.0f, d.bi(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.SH = i;
        this.SG = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.SH;
    }

    public void release() {
        if (this.SG > 0) {
            close(this.SG);
            this.SG = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.SG, sArr, sArr2);
    }
}

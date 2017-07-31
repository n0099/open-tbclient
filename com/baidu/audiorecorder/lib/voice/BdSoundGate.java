package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate KX;
    private int KV = -1;
    private int KW;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lL() {
        if (KX == null) {
            KX = new BdSoundGate();
        }
        return KX;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lL().a(i, 0.0f, d.aP(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.KW = i;
        this.KV = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.KW;
    }

    public void release() {
        if (this.KV > 0) {
            close(this.KV);
            this.KV = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.KV, sArr, sArr2);
    }
}

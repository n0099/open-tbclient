package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes18.dex */
public class BdSoundGate {
    private static BdSoundGate aal;
    private int aak = -1;
    private int blockSize;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int through(int i, short[] sArr, short[] sArr2);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate sh() {
        if (aal == null) {
            aal = new BdSoundGate();
        }
        return aal;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        sh().a(i, 0.0f, d.bd(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.blockSize = i;
        this.aak = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void release() {
        if (this.aak > 0) {
            close(this.aak);
            this.aak = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.aak, sArr, sArr2);
    }
}

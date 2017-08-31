package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate IU;
    private int IS = -1;
    private int IT;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate lC() {
        if (IU == null) {
            IU = new BdSoundGate();
        }
        return IU;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        lC().a(i, 0.0f, d.aN(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.IT = i;
        this.IS = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.IT;
    }

    public void release() {
        if (this.IS > 0) {
            close(this.IS);
            this.IS = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.IS, sArr, sArr2);
    }
}

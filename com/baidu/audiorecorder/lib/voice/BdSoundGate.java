package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate BB;
    private int BA;
    private int Bz = -1;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate kt() {
        if (BB == null) {
            BB = new BdSoundGate();
        }
        return BB;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        kt().a(i, 0.0f, f.aA(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.BA = i;
        this.Bz = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.BA;
    }

    public void release() {
        if (this.Bz > 0) {
            close(this.Bz);
            this.Bz = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.Bz, sArr, sArr2);
    }
}

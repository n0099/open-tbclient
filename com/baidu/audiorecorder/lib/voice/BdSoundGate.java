package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate BC;
    private int BA = -1;
    private int BB;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate kw() {
        if (BC == null) {
            BC = new BdSoundGate();
        }
        return BC;
    }

    private BdSoundGate() {
    }

    public void m(int i, int i2) {
        kw().a(i, 0.0f, f.aB(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.BB = i;
        this.BA = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.BB;
    }

    public void release() {
        if (this.BA > 0) {
            close(this.BA);
            this.BA = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.BA, sArr, sArr2);
    }
}

package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class BdSoundGate {
    private static BdSoundGate axt;
    private int axr = -1;
    private int axs;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate tb() {
        if (axt == null) {
            axt = new BdSoundGate();
        }
        return axt;
    }

    private BdSoundGate() {
    }

    public void init(int i, int i2) {
        tb().b(i, 0.0f, d.dS(i2), 0.0f);
    }

    public void b(int i, float f, float f2, float f3) {
        this.axs = i;
        this.axr = getChanger(i, f, f2, f3);
    }

    public int getBlockSize() {
        return this.axs;
    }

    public void release() {
        if (this.axr > 0) {
            close(this.axr);
            this.axr = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.axr, sArr, sArr2);
    }
}

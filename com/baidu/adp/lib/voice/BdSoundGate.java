package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class BdSoundGate {
    private static BdSoundGate c;
    private int a = -1;
    private int b;

    private native void close(int i);

    private native int getChanger(int i, float f, float f2, float f3);

    private native int throughMono(int i, short[] sArr, short[] sArr2);

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate a() {
        if (c == null) {
            c = new BdSoundGate();
        }
        return c;
    }

    private BdSoundGate() {
    }

    public void a(int i, int i2) {
        a().a(i, 0.0f, d.a(i2), 0.0f);
    }

    public void a(int i, float f, float f2, float f3) {
        this.b = i;
        this.a = getChanger(i, f, f2, f3);
    }

    public int b() {
        return this.b;
    }

    public void c() {
        if (this.a > 0) {
            close(this.a);
            this.a = -1;
        }
    }

    public void a(short[] sArr, short[] sArr2) {
        throughMono(this.a, sArr, sArr2);
    }
}

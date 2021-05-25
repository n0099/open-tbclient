package com.baidu.audiorecorder.lib.voice;

import d.a.f.a.a.d;
/* loaded from: classes.dex */
public class BdSoundGate {

    /* renamed from: c  reason: collision with root package name */
    public static BdSoundGate f4184c;

    /* renamed from: a  reason: collision with root package name */
    public int f4185a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f4186b;

    static {
        System.loadLibrary("sound_gate");
    }

    public static BdSoundGate b() {
        if (f4184c == null) {
            f4184c = new BdSoundGate();
        }
        return f4184c;
    }

    private native void close(int i2);

    private native int getChanger(int i2, float f2, float f3, float f4);

    private native int through(int i2, short[] sArr, short[] sArr2);

    private native int throughMono(int i2, short[] sArr, short[] sArr2);

    public int a() {
        return this.f4186b;
    }

    public void c(int i2, float f2, float f3, float f4) {
        this.f4186b = i2;
        this.f4185a = getChanger(i2, f2, f3, f4);
    }

    public void d(int i2, int i3) {
        b().c(i2, 0.0f, d.a(i3), 0.0f);
    }

    public void e() {
        int i2 = this.f4185a;
        if (i2 > 0) {
            close(i2);
            this.f4185a = -1;
        }
    }

    public void f(short[] sArr, short[] sArr2) {
        throughMono(this.f4185a, sArr, sArr2);
    }
}

package com.baidu.android.defense.b;
/* loaded from: classes.dex */
public final class c {
    private String a;
    private String b;
    private int c;

    public final String a() {
        return this.b;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final int b() {
        return this.c;
    }

    public final String toString() {
        return "ManageItem: mPackageName =" + this.b + " mVersionCode =" + this.c + " mApkPath =" + this.a;
    }
}

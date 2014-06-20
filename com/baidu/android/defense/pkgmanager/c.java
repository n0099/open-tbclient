package com.baidu.android.defense.pkgmanager;
/* loaded from: classes.dex */
public final class c {
    private String a;
    private String b;
    private int c;

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        return "ManageItem: mPackageName =" + this.b + " mVersionCode =" + this.c + " mApkPath =" + this.a;
    }
}

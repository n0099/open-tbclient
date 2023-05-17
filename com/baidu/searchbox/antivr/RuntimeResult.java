package com.baidu.searchbox.antivr;
/* loaded from: classes3.dex */
public class RuntimeResult {
    public boolean a;
    public String b;
    public String c;
    public String d;

    public void a() {
        this.a = false;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String getHookName() {
        return this.d;
    }

    public String getHostPkgName() {
        return this.b;
    }

    public String getUidPkgs() {
        return this.c;
    }

    public boolean isInVirtual() {
        return this.a;
    }
}

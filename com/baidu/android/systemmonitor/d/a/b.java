package com.baidu.android.systemmonitor.d.a;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private String f685a = null;
    private String b = null;
    private int c = -1;

    public String a() {
        return this.f685a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.f685a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[name=").append(this.f685a).append(",value=").append(this.b).append(",type=").append(this.c).append("]");
        return sb.toString();
    }
}

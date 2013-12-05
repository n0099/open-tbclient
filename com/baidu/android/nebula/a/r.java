package com.baidu.android.nebula.a;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private long f659a = -1;
    private long b = -1;
    private int c = 100;
    private int d = -10;
    private int e = 10;
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private int h = 0;

    public ArrayList a() {
        return this.f;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f659a = j;
    }

    public void a(ArrayList arrayList) {
        this.f = arrayList;
    }

    public void b() {
        this.h++;
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(long j) {
        this.b = j;
    }

    public void b(ArrayList arrayList) {
        this.g = arrayList;
    }

    public boolean c() {
        return this.h >= 5;
    }

    public void d() {
        this.h = 0;
    }

    public ArrayList e() {
        return this.g;
    }

    public int f() {
        return this.e;
    }

    public long g() {
        return this.f659a;
    }

    public long h() {
        return this.b;
    }

    public int i() {
        return this.d;
    }

    public int j() {
        return this.c;
    }

    public void k() {
        this.d = -10;
        this.f.clear();
        this.g.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("[mMaxUpdloadAppsNum=").append(this.c).append("]mResponseStatus=").append(this.d).append("]mChannelId=").append(this.b).append("]mNeedsToken=").append(this.f659a).append("]mRandomCheckAppsSize=").append(this.e).append("[mRetSuccesslist=").append(this.g).append("[mRetFailedlist=").append(this.f).append("]]");
        return sb.toString();
    }
}

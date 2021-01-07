package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4583a;

    /* renamed from: b  reason: collision with root package name */
    private String f4584b;
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> c = new ArrayList<>();
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> d = new ArrayList<>();
    private int e;
    private int f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> a() {
        return this.c;
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> arrayList) {
        this.c = arrayList;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> b() {
        return this.d;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b> arrayList) {
        this.d = arrayList;
    }

    public String c() {
        return this.f4583a;
    }

    public void a(String str) {
        this.f4583a = str;
    }

    public void b(String str) {
        this.f4584b = str;
    }

    public int d() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int e() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f4583a + ", guideText=" + this.f4584b + ", stepLength=" + this.e + ", uid=" + this.f + "]";
    }
}

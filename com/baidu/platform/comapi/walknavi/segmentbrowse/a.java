package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a {
    private String a;
    private String b;
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> c = new ArrayList<>();
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> d = new ArrayList<>();
    private int e;
    private int f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> a() {
        return this.c;
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.c = arrayList;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> b() {
        return this.d;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.d = arrayList;
    }

    public String c() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
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
        return "WRouteMessageModel [iconName=" + this.a + ", guideText=" + this.b + ", stepLength=" + this.e + ", uid=" + this.f + "]";
    }
}

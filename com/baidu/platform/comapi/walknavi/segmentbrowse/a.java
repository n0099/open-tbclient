package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10155a;

    /* renamed from: b  reason: collision with root package name */
    public String f10156b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10157c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10158d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public int f10159e;

    /* renamed from: f  reason: collision with root package name */
    public int f10160f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> a() {
        return this.f10157c;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> b() {
        return this.f10158d;
    }

    public String c() {
        return this.f10155a;
    }

    public int d() {
        return this.f10159e;
    }

    public int e() {
        return this.f10160f;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f10155a + ", guideText=" + this.f10156b + ", stepLength=" + this.f10159e + ", uid=" + this.f10160f + "]";
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10157c = arrayList;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10158d = arrayList;
    }

    public void a(String str) {
        this.f10155a = str;
    }

    public void b(String str) {
        this.f10156b = str;
    }

    public void a(int i) {
        this.f10159e = i;
    }

    public void b(int i) {
        this.f10160f = i;
    }
}

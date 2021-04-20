package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f9713a;

    /* renamed from: b  reason: collision with root package name */
    public String f9714b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f9715c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f9716d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public int f9717e;

    /* renamed from: f  reason: collision with root package name */
    public int f9718f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> a() {
        return this.f9715c;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> b() {
        return this.f9716d;
    }

    public String c() {
        return this.f9713a;
    }

    public int d() {
        return this.f9717e;
    }

    public int e() {
        return this.f9718f;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f9713a + ", guideText=" + this.f9714b + ", stepLength=" + this.f9717e + ", uid=" + this.f9718f + "]";
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f9715c = arrayList;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f9716d = arrayList;
    }

    public void a(String str) {
        this.f9713a = str;
    }

    public void b(String str) {
        this.f9714b = str;
    }

    public void a(int i) {
        this.f9717e = i;
    }

    public void b(int i) {
        this.f9718f = i;
    }
}

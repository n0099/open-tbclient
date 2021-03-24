package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10154a;

    /* renamed from: b  reason: collision with root package name */
    public String f10155b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10156c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10157d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public int f10158e;

    /* renamed from: f  reason: collision with root package name */
    public int f10159f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> a() {
        return this.f10156c;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> b() {
        return this.f10157d;
    }

    public String c() {
        return this.f10154a;
    }

    public int d() {
        return this.f10158e;
    }

    public int e() {
        return this.f10159f;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f10154a + ", guideText=" + this.f10155b + ", stepLength=" + this.f10158e + ", uid=" + this.f10159f + "]";
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10156c = arrayList;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10157d = arrayList;
    }

    public void a(String str) {
        this.f10154a = str;
    }

    public void b(String str) {
        this.f10155b = str;
    }

    public void a(int i) {
        this.f10158e = i;
    }

    public void b(int i) {
        this.f10159f = i;
    }
}

package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10073a;

    /* renamed from: b  reason: collision with root package name */
    public String f10074b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10075c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f10076d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public int f10077e;

    /* renamed from: f  reason: collision with root package name */
    public int f10078f;

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> a() {
        return this.f10075c;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> b() {
        return this.f10076d;
    }

    public String c() {
        return this.f10073a;
    }

    public int d() {
        return this.f10077e;
    }

    public int e() {
        return this.f10078f;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f10073a + ", guideText=" + this.f10074b + ", stepLength=" + this.f10077e + ", uid=" + this.f10078f + "]";
    }

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10075c = arrayList;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f10076d = arrayList;
    }

    public void a(String str) {
        this.f10073a = str;
    }

    public void b(String str) {
        this.f10074b = str;
    }

    public void a(int i2) {
        this.f10077e = i2;
    }

    public void b(int i2) {
        this.f10078f = i2;
    }
}

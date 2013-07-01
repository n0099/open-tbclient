package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKPoiResult {

    /* renamed from: a  reason: collision with root package name */
    private int f513a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.f = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.f513a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList arrayList) {
        this.e = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ArrayList arrayList) {
        this.g = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        this.d = i;
    }

    public ArrayList getAllPoi() {
        return this.f;
    }

    public MKCityListInfo getCityListInfo(int i) {
        if (this.g != null) {
            return (MKCityListInfo) this.g.get(i);
        }
        return null;
    }

    public int getCityListNum() {
        if (this.g != null) {
            return this.g.size();
        }
        return 0;
    }

    public int getCurrentNumPois() {
        return this.b;
    }

    public ArrayList getMultiPoiResult() {
        return this.e;
    }

    public int getNumPages() {
        return this.c;
    }

    public int getNumPois() {
        return this.f513a;
    }

    public int getPageIndex() {
        return this.d;
    }

    public MKPoiInfo getPoi(int i) {
        if (this.f != null) {
            return (MKPoiInfo) this.f.get(i);
        }
        return null;
    }
}

package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKLine {
    public static final int LINE_TYPE_BUS = 0;
    public static final int LINE_TYPE_SUBWAY = 1;

    /* renamed from: a  reason: collision with root package name */
    ArrayList f509a;
    private int b;
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private MKPoiInfo h;
    private MKPoiInfo i;
    private ArrayList j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKPoiInfo mKPoiInfo) {
        this.h = mKPoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.j = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MKPoiInfo mKPoiInfo) {
        this.i = mKPoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        this.f = str;
    }

    public int getDistance() {
        return this.c;
    }

    public MKPoiInfo getGetOffStop() {
        return this.i;
    }

    public MKPoiInfo getGetOnStop() {
        return this.h;
    }

    public int getNumViaStops() {
        return this.b;
    }

    public ArrayList getPoints() {
        return this.j;
    }

    public String getTitle() {
        return this.e;
    }

    public int getType() {
        return this.d;
    }

    public String getUid() {
        return this.f;
    }
}

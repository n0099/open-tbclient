package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKRoute {
    public static final int ROUTE_TYPE_BUS_LINE = 3;
    public static final int ROUTE_TYPE_DRIVING = 1;
    public static final int ROUTE_TYPE_UNKNOW = 0;
    public static final int ROUTE_TYPE_WALKING = 2;

    /* renamed from: a  reason: collision with root package name */
    ArrayList f514a;
    private int b;
    private int c;
    private int d;
    private GeoPoint e;
    private GeoPoint f;
    private ArrayList g;
    private ArrayList h;
    private String i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.e = geoPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.i = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.h = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(GeoPoint geoPoint) {
        this.f = geoPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList arrayList) {
        this.g = arrayList;
    }

    public ArrayList getArrayPoints() {
        return this.g;
    }

    public int getDistance() {
        return this.c;
    }

    public GeoPoint getEnd() {
        return this.f;
    }

    public int getIndex() {
        return this.b;
    }

    public int getNumSteps() {
        if (this.h != null) {
            return this.h.size();
        }
        return 0;
    }

    public int getRouteType() {
        return this.d;
    }

    public GeoPoint getStart() {
        return this.e;
    }

    public MKStep getStep(int i) {
        if (this.h != null) {
            return (MKStep) this.h.get(i);
        }
        return null;
    }
}

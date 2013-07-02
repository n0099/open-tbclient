package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKTransitRoutePlan {
    private int a;
    private String b;
    private ArrayList c;
    private ArrayList d;
    private GeoPoint e;
    private GeoPoint f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.e = geoPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(GeoPoint geoPoint) {
        this.f = geoPoint;
    }

    public String getContent() {
        return this.b;
    }

    public int getDistance() {
        return this.a;
    }

    public GeoPoint getEnd() {
        return this.f;
    }

    public MKLine getLine(int i) {
        if (this.d != null) {
            return (MKLine) this.d.get(i);
        }
        return null;
    }

    public int getNumLines() {
        if (this.d != null) {
            return this.d.size();
        }
        return 0;
    }

    public int getNumRoute() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    public MKRoute getRoute(int i) {
        if (this.c != null) {
            return (MKRoute) this.c.get(i);
        }
        return null;
    }

    public GeoPoint getStart() {
        return this.e;
    }

    public void setLine(ArrayList arrayList) {
        this.d = arrayList;
    }
}

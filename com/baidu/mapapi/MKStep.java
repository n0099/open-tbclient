package com.baidu.mapapi;
/* loaded from: classes.dex */
public class MKStep {

    /* renamed from: a  reason: collision with root package name */
    private GeoPoint f517a;
    private String b;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.f517a = geoPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.b = str;
    }

    public String getContent() {
        return this.b;
    }

    public GeoPoint getPoint() {
        return this.f517a;
    }
}

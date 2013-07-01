package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKRoutePlan {

    /* renamed from: a  reason: collision with root package name */
    private int f515a;
    private ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f515a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public int getDistance() {
        return this.f515a;
    }

    public int getNumRoutes() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    public MKRoute getRoute(int i) {
        if (this.b != null) {
            return (MKRoute) this.b.get(i);
        }
        return null;
    }
}

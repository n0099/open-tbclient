package com.baidu.mapapi.walknavi.params;
/* loaded from: classes20.dex */
public enum RouteNodeType {
    LOCATION(1),
    KEYWORD(2);
    
    private int a;

    RouteNodeType(int i) {
        this.a = i;
    }

    public int getNativeType() {
        return this.a;
    }
}

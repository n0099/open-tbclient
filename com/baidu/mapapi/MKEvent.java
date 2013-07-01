package com.baidu.mapapi;
/* loaded from: classes.dex */
public class MKEvent {
    public static final int ERROR_LOCATION_FAILED = 200;
    public static final int ERROR_NETWORK_CONNECT = 2;
    public static final int ERROR_NETWORK_DATA = 3;
    public static final int ERROR_PERMISSION_DENIED = 300;
    public static final int ERROR_RESULT_NOT_FOUND = 100;
    public static final int ERROR_ROUTE_ADDR = 4;
    public static final int MKEVENT_BUS_DETAIL = 15;
    public static final int MKEVENT_MAP_MOVE_FINISH = 14;
    public static final int MKEVENT_POIRGCSHAREURL = 17;
    public static final int MKEVENT_POI_DETAIL = 18;
    public static final int MKEVENT_SUGGESTION = 16;

    /* renamed from: a  reason: collision with root package name */
    int f508a;
    int b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MKEvent(int i, int i2, int i3) {
        this.f508a = 0;
        this.b = 0;
        this.c = 0;
        this.f508a = i;
        this.b = i2;
        this.c = i3;
    }
}

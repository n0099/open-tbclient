package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes15.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2828a;

    /* renamed from: b  reason: collision with root package name */
    String f2829b;
    ArrayList<String> c;

    /* loaded from: classes15.dex */
    public enum SwitchFloorError {
        SWITCH_OK,
        FLOOR_INFO_ERROR,
        FLOOR_OVERLFLOW,
        FOCUSED_ID_ERROR,
        SWITCH_ERROR
    }

    public MapBaseIndoorMapInfo() {
    }

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        this.f2828a = mapBaseIndoorMapInfo.f2828a;
        this.f2829b = mapBaseIndoorMapInfo.f2829b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2828a = str;
        this.f2829b = str2;
        this.c = arrayList;
    }

    public String getCurFloor() {
        return this.f2829b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f2828a;
    }
}

package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2016a;
    String b;
    ArrayList<String> c;

    /* loaded from: classes7.dex */
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
        this.f2016a = mapBaseIndoorMapInfo.f2016a;
        this.b = mapBaseIndoorMapInfo.b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2016a = str;
        this.b = str2;
        this.c = arrayList;
    }

    public String getCurFloor() {
        return this.b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f2016a;
    }
}

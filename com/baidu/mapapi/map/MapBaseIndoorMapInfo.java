package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2014a;
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
        this.f2014a = mapBaseIndoorMapInfo.f2014a;
        this.b = mapBaseIndoorMapInfo.b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2014a = str;
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
        return this.f2014a;
    }
}

package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2725a;

    /* renamed from: b  reason: collision with root package name */
    String f2726b;
    ArrayList<String> c;

    /* loaded from: classes6.dex */
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
        this.f2725a = mapBaseIndoorMapInfo.f2725a;
        this.f2726b = mapBaseIndoorMapInfo.f2726b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2725a = str;
        this.f2726b = str2;
        this.c = arrayList;
    }

    public String getCurFloor() {
        return this.f2726b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f2725a;
    }
}

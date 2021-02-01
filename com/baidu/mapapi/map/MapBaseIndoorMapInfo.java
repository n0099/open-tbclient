package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2723a;

    /* renamed from: b  reason: collision with root package name */
    String f2724b;
    ArrayList<String> c;

    /* loaded from: classes4.dex */
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
        this.f2723a = mapBaseIndoorMapInfo.f2723a;
        this.f2724b = mapBaseIndoorMapInfo.f2724b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2723a = str;
        this.f2724b = str2;
        this.c = arrayList;
    }

    public String getCurFloor() {
        return this.f2724b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f2723a;
    }
}

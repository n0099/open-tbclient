package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class MapBaseIndoorMapInfo {
    private static final String d = MapBaseIndoorMapInfo.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2829a;

    /* renamed from: b  reason: collision with root package name */
    String f2830b;
    ArrayList<String> c;

    /* loaded from: classes3.dex */
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
        this.f2829a = mapBaseIndoorMapInfo.f2829a;
        this.f2830b = mapBaseIndoorMapInfo.f2830b;
        this.c = mapBaseIndoorMapInfo.c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f2829a = str;
        this.f2830b = str2;
        this.c = arrayList;
    }

    public String getCurFloor() {
        return this.f2830b;
    }

    public ArrayList<String> getFloors() {
        return this.c;
    }

    public String getID() {
        return this.f2829a;
    }
}

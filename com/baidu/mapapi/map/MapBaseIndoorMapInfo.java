package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7166d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f7167a;

    /* renamed from: b  reason: collision with root package name */
    public String f7168b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f7169c;

    /* loaded from: classes2.dex */
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
        this.f7167a = mapBaseIndoorMapInfo.f7167a;
        this.f7168b = mapBaseIndoorMapInfo.f7168b;
        this.f7169c = mapBaseIndoorMapInfo.f7169c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f7167a = str;
        this.f7168b = str2;
        this.f7169c = arrayList;
    }

    public String getCurFloor() {
        return this.f7168b;
    }

    public ArrayList<String> getFloors() {
        return this.f7169c;
    }

    public String getID() {
        return this.f7167a;
    }
}

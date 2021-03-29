package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6889d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6890a;

    /* renamed from: b  reason: collision with root package name */
    public String f6891b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6892c;

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
        this.f6890a = mapBaseIndoorMapInfo.f6890a;
        this.f6891b = mapBaseIndoorMapInfo.f6891b;
        this.f6892c = mapBaseIndoorMapInfo.f6892c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6890a = str;
        this.f6891b = str2;
        this.f6892c = arrayList;
    }

    public String getCurFloor() {
        return this.f6891b;
    }

    public ArrayList<String> getFloors() {
        return this.f6892c;
    }

    public String getID() {
        return this.f6890a;
    }
}

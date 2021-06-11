package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6925d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6926a;

    /* renamed from: b  reason: collision with root package name */
    public String f6927b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6928c;

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
        this.f6926a = mapBaseIndoorMapInfo.f6926a;
        this.f6927b = mapBaseIndoorMapInfo.f6927b;
        this.f6928c = mapBaseIndoorMapInfo.f6928c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6926a = str;
        this.f6927b = str2;
        this.f6928c = arrayList;
    }

    public String getCurFloor() {
        return this.f6927b;
    }

    public ArrayList<String> getFloors() {
        return this.f6928c;
    }

    public String getID() {
        return this.f6926a;
    }
}

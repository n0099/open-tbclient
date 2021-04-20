package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6924d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6925a;

    /* renamed from: b  reason: collision with root package name */
    public String f6926b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6927c;

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
        this.f6925a = mapBaseIndoorMapInfo.f6925a;
        this.f6926b = mapBaseIndoorMapInfo.f6926b;
        this.f6927c = mapBaseIndoorMapInfo.f6927c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6925a = str;
        this.f6926b = str2;
        this.f6927c = arrayList;
    }

    public String getCurFloor() {
        return this.f6926b;
    }

    public ArrayList<String> getFloors() {
        return this.f6927c;
    }

    public String getID() {
        return this.f6925a;
    }
}

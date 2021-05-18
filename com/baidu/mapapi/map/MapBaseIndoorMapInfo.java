package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6982d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6983a;

    /* renamed from: b  reason: collision with root package name */
    public String f6984b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6985c;

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
        this.f6983a = mapBaseIndoorMapInfo.f6983a;
        this.f6984b = mapBaseIndoorMapInfo.f6984b;
        this.f6985c = mapBaseIndoorMapInfo.f6985c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6983a = str;
        this.f6984b = str2;
        this.f6985c = arrayList;
    }

    public String getCurFloor() {
        return this.f6984b;
    }

    public ArrayList<String> getFloors() {
        return this.f6985c;
    }

    public String getID() {
        return this.f6983a;
    }
}

package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6888d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6889a;

    /* renamed from: b  reason: collision with root package name */
    public String f6890b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6891c;

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
        this.f6889a = mapBaseIndoorMapInfo.f6889a;
        this.f6890b = mapBaseIndoorMapInfo.f6890b;
        this.f6891c = mapBaseIndoorMapInfo.f6891c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6889a = str;
        this.f6890b = str2;
        this.f6891c = arrayList;
    }

    public String getCurFloor() {
        return this.f6890b;
    }

    public ArrayList<String> getFloors() {
        return this.f6891c;
    }

    public String getID() {
        return this.f6889a;
    }
}

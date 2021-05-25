package com.baidu.mapapi.map;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6882d = "MapBaseIndoorMapInfo";

    /* renamed from: a  reason: collision with root package name */
    public String f6883a;

    /* renamed from: b  reason: collision with root package name */
    public String f6884b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f6885c;

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
        this.f6883a = mapBaseIndoorMapInfo.f6883a;
        this.f6884b = mapBaseIndoorMapInfo.f6884b;
        this.f6885c = mapBaseIndoorMapInfo.f6885c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f6883a = str;
        this.f6884b = str2;
        this.f6885c = arrayList;
    }

    public String getCurFloor() {
        return this.f6884b;
    }

    public ArrayList<String> getFloors() {
        return this.f6885c;
    }

    public String getID() {
        return this.f6883a;
    }
}

package com.baidu.mapapi.map;
/* loaded from: classes15.dex */
public class MapCustomStyleOptions {

    /* renamed from: a  reason: collision with root package name */
    private String f2831a;

    /* renamed from: b  reason: collision with root package name */
    private String f2832b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.f2832b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.f2832b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f2831a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f2831a = str;
        return this;
    }
}

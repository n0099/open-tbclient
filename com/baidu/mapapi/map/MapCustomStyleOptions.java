package com.baidu.mapapi.map;
/* loaded from: classes3.dex */
public class MapCustomStyleOptions {

    /* renamed from: a  reason: collision with root package name */
    private String f2832a;

    /* renamed from: b  reason: collision with root package name */
    private String f2833b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.f2833b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.f2833b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f2832a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f2832a = str;
        return this;
    }
}

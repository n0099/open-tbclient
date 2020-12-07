package com.baidu.mapapi.map;
/* loaded from: classes26.dex */
public class MapCustomStyleOptions {

    /* renamed from: a  reason: collision with root package name */
    private String f2020a;
    private String b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f2020a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f2020a = str;
        return this;
    }
}

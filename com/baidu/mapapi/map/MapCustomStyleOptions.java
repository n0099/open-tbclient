package com.baidu.mapapi.map;
/* loaded from: classes3.dex */
public class MapCustomStyleOptions {
    private String a;
    private String b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.a = str;
        return this;
    }
}

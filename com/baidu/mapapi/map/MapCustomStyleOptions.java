package com.baidu.mapapi.map;
/* loaded from: classes3.dex */
public class MapCustomStyleOptions {
    public String a;
    public String b;

    public String getCustomMapStyleId() {
        return this.b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.a;
    }

    public MapCustomStyleOptions customStyleId(String str) {
        this.b = str;
        return this;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.a = str;
        return this;
    }
}

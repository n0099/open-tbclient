package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements a {
    private final int Tc;
    private HashMap Tg;
    private int floor;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.Tc = i;
        this.refreshCount = i2;
        this.pid = str;
        this.floor = i3;
        this.width = i4;
        this.height = i5;
    }

    public static a a(int i, int i2, String str, int i3, int i4, int i5) {
        return new c(i, i2, str, i3, i4, i5);
    }

    @Override // com.baidu.afd.videopaster.a
    public int width() {
        return this.width;
    }

    @Override // com.baidu.afd.videopaster.a
    public int height() {
        return this.height;
    }

    @Override // com.baidu.afd.videopaster.a
    public String pZ() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int pM() {
        return this.Tc;
    }

    @Override // com.baidu.afd.videopaster.a
    public int pO() {
        return this.floor;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> pP() {
        return this.Tg;
    }

    @Override // com.baidu.afd.videopaster.a
    public void l(HashMap hashMap) {
        this.Tg = hashMap;
    }
}

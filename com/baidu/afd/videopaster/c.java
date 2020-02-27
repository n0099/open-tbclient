package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements a {
    private final int Df;
    private int Dj;
    private HashMap Dk;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.Df = i;
        this.refreshCount = i2;
        this.pid = str;
        this.Dj = i3;
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
    public String kS() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int kF() {
        return this.Df;
    }

    @Override // com.baidu.afd.videopaster.a
    public int kH() {
        return this.Dj;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> kI() {
        return this.Dk;
    }

    @Override // com.baidu.afd.videopaster.a
    public void j(HashMap hashMap) {
        this.Dk = hashMap;
    }
}

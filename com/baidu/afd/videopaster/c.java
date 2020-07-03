package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c implements a {
    private int XA;
    private HashMap XB;
    private final int Xx;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.Xx = i;
        this.refreshCount = i2;
        this.pid = str;
        this.XA = i3;
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
    public String pT() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int pG() {
        return this.Xx;
    }

    @Override // com.baidu.afd.videopaster.a
    public int pI() {
        return this.XA;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> pJ() {
        return this.XB;
    }

    @Override // com.baidu.afd.videopaster.a
    public void w(HashMap hashMap) {
        this.XB = hashMap;
    }
}

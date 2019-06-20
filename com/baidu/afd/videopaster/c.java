package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements a {
    private final int QM;
    private int QR;
    private HashMap QS;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.QM = i;
        this.refreshCount = i2;
        this.pid = str;
        this.QR = i3;
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
    public String oU() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int oH() {
        return this.QM;
    }

    @Override // com.baidu.afd.videopaster.a
    public int oJ() {
        return this.QR;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> oK() {
        return this.QS;
    }

    @Override // com.baidu.afd.videopaster.a
    public void k(HashMap hashMap) {
        this.QS = hashMap;
    }
}

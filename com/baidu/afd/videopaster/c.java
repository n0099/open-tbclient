package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c implements a {
    private final int CF;
    private int CJ;
    private HashMap CK;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.CF = i;
        this.refreshCount = i2;
        this.pid = str;
        this.CJ = i3;
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
    public String kC() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int kp() {
        return this.CF;
    }

    @Override // com.baidu.afd.videopaster.a
    public int kr() {
        return this.CJ;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> ks() {
        return this.CK;
    }

    @Override // com.baidu.afd.videopaster.a
    public void j(HashMap hashMap) {
        this.CK = hashMap;
    }
}

package com.baidu.afd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements g {
    private final int IJ;
    private final int IK;
    private final int IL;
    private final String IM;
    private HashMap IO;
    private int floor;
    private final String tabName;

    private c(int i, int i2, int i3, String str, String str2, int i4) {
        this.IJ = i;
        this.IK = i2;
        this.IL = i3;
        this.IM = str;
        this.tabName = str2;
        this.floor = i4;
    }

    public static g a(int i, int i2, int i3, String str, String str2, int i4) {
        return new c(i, i2, i3, str, str2, i4);
    }

    @Override // com.baidu.afd.g
    public int lq() {
        return this.IJ;
    }

    @Override // com.baidu.afd.g
    public int lr() {
        return this.IK;
    }

    @Override // com.baidu.afd.g
    public int ls() {
        return this.floor;
    }

    @Override // com.baidu.afd.g
    public Map<String, String> lt() {
        return this.IO;
    }

    @Override // com.baidu.afd.g
    public void h(HashMap hashMap) {
        this.IO = hashMap;
    }
}

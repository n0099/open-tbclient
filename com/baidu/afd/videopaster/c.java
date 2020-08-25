package com.baidu.afd.videopaster;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class c implements a {
    private final int XV;
    private HashMap XY;
    private int floor;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.XV = i;
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
    public String rt() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int rg() {
        return this.XV;
    }

    @Override // com.baidu.afd.videopaster.a
    public int ri() {
        return this.floor;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> rj() {
        return this.XY;
    }

    @Override // com.baidu.afd.videopaster.a
    public void u(HashMap hashMap) {
        this.XY = hashMap;
        if (!this.XY.containsKey("iadex")) {
            hashMap.put("iadex", com.baidu.tbadk.util.c.bvd());
        }
    }
}

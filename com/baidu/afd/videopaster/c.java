package com.baidu.afd.videopaster;

import com.baidu.tbadk.util.AdExtParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {
    private final int aas;
    private HashMap aav;
    private int floor;
    private final int height;
    private final String pid;
    private final int refreshCount;
    private final int width;

    private c(int i, int i2, String str, int i3, int i4, int i5) {
        this.aas = i;
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
    public String rc() {
        return this.pid;
    }

    @Override // com.baidu.afd.videopaster.a
    public int qP() {
        return this.aas;
    }

    @Override // com.baidu.afd.videopaster.a
    public int qR() {
        return this.floor;
    }

    @Override // com.baidu.afd.videopaster.a
    public Map<String, String> qS() {
        return this.aav;
    }

    @Override // com.baidu.afd.videopaster.a
    public void u(HashMap hashMap) {
        this.aav = hashMap;
        if (!this.aav.containsKey(AdExtParam.KEY_IADEX)) {
            hashMap.put(AdExtParam.KEY_IADEX, com.baidu.tbadk.util.c.bIA());
        }
    }
}

package com.baidu.ar.lua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c {
    private boolean rW = false;
    private boolean rX = false;

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 103:
                this.rX = true;
                return;
            case 104:
                this.rW = true;
                return;
            default:
                return;
        }
    }

    public void b(b bVar) {
        bVar.c(this);
    }

    public void dY() {
        this.rW = false;
        this.rX = false;
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(103, 104);
    }

    public void release() {
        dY();
    }
}

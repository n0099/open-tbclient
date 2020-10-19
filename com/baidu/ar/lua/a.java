package com.baidu.ar.lua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class a implements c {
    private boolean sC = false;
    private boolean sD = false;

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 103:
                this.sD = true;
                return;
            case 104:
                this.sC = true;
                return;
            default:
                return;
        }
    }

    public void b(b bVar) {
        bVar.c(this);
    }

    public void fk() {
        this.sC = false;
        this.sD = false;
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(103, 104);
    }

    public void release() {
        fk();
    }
}

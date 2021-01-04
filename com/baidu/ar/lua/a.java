package com.baidu.ar.lua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements c {
    private boolean sT = false;
    private boolean sU = false;

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 103:
                this.sU = true;
                return;
            case 104:
                this.sT = true;
                return;
            default:
                return;
        }
    }

    public void b(b bVar) {
        bVar.c(this);
    }

    public void fj() {
        this.sT = false;
        this.sU = false;
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(103, 104);
    }

    public void release() {
        fj();
    }
}

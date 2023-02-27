package com.baidu.ar.lua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a implements c {
    public boolean sT = false;
    public boolean sU = false;

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 103) {
            this.sU = true;
        } else if (i != 104) {
        } else {
            this.sT = true;
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

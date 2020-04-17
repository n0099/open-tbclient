package com.baidu.ar.lua;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: rx  reason: collision with root package name */
    private boolean f986rx = false;
    private boolean ry = false;

    @Override // com.baidu.ar.lua.c
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        switch (i) {
            case 103:
                this.ry = true;
                return;
            case 104:
                this.f986rx = true;
                return;
            default:
                return;
        }
    }

    public void b(b bVar) {
        bVar.c(this);
    }

    public void dI() {
        this.f986rx = false;
        this.ry = false;
    }

    @Override // com.baidu.ar.lua.c
    public List<Integer> n() {
        return Arrays.asList(103, 104);
    }

    public void release() {
        dI();
    }
}

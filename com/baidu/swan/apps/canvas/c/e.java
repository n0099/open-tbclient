package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> amr;
    private j amu;

    public e(String str) {
        super(str);
        this.amr = new ArrayList();
        this.amu = new j(str);
        this.amr.add(this.amu);
    }

    public boolean wA() {
        return this.amu.wA();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wB() {
        return this.amr;
    }

    public boolean wC() {
        return true;
    }
}

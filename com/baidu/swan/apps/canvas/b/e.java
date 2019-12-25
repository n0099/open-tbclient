package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bcl;
    private j bco;

    public e(String str) {
        super(str);
        this.bcl = new ArrayList();
        this.bco = new j(str);
        this.bcl.add(this.bco);
    }

    public boolean HG() {
        return this.bco.HG();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> HH() {
        return this.bcl;
    }

    public boolean HI() {
        return true;
    }
}

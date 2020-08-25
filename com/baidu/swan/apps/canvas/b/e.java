package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> caa;
    private j cad;

    public e(String str) {
        super(str);
        this.caa = new ArrayList();
        this.cad = new j(str);
        this.caa.add(this.cad);
    }

    public int acO() {
        return this.cad.acO();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> acP() {
        return this.caa;
    }

    public boolean acQ() {
        return true;
    }
}

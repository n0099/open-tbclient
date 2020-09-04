package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cae;
    private j cah;

    public e(String str) {
        super(str);
        this.cae = new ArrayList();
        this.cah = new j(str);
        this.cae.add(this.cah);
    }

    public int acO() {
        return this.cah.acO();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> acP() {
        return this.cae;
    }

    public boolean acQ() {
        return true;
    }
}

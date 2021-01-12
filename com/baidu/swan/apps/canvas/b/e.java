package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cIi;
    private j cIl;

    public e(String str) {
        super(str);
        this.cIi = new ArrayList();
        this.cIl = new j(str);
        this.cIi.add(this.cIl);
    }

    public int aks() {
        return this.cIl.aks();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akt() {
        return this.cIi;
    }

    public boolean aku() {
        return true;
    }
}

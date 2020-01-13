package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bda;
    private j bdd;

    public e(String str) {
        super(str);
        this.bda = new ArrayList();
        this.bdd = new j(str);
        this.bda.add(this.bdd);
    }

    public boolean Ic() {
        return this.bdd.Ic();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Id() {
        return this.bda;
    }

    public boolean Ie() {
        return true;
    }
}

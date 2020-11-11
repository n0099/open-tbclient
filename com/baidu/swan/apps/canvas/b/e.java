package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cCR;
    private j cCU;

    public e(String str) {
        super(str);
        this.cCR = new ArrayList();
        this.cCU = new j(str);
        this.cCR.add(this.cCU);
    }

    public int akC() {
        return this.cCU.akC();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akD() {
        return this.cCR;
    }

    public boolean akE() {
        return true;
    }
}

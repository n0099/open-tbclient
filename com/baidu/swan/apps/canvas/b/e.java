package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cwY;
    private j cxb;

    public e(String str) {
        super(str);
        this.cwY = new ArrayList();
        this.cxb = new j(str);
        this.cwY.add(this.cxb);
    }

    public int aic() {
        return this.cxb.aic();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> aid() {
        return this.cwY;
    }

    public boolean aie() {
        return true;
    }
}

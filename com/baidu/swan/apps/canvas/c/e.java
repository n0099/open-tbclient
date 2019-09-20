package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> anF;
    private j anI;

    public e(String str) {
        super(str);
        this.anF = new ArrayList();
        this.anI = new j(str);
        this.anF.add(this.anI);
    }

    public boolean ya() {
        return this.anI.ya();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> yb() {
        return this.anF;
    }

    public boolean yc() {
        return true;
    }
}

package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> amm;
    private j amp;

    public e(String str) {
        super(str);
        this.amm = new ArrayList();
        this.amp = new j(str);
        this.amm.add(this.amp);
    }

    public boolean wB() {
        return this.amp.wB();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wC() {
        return this.amm;
    }

    public boolean wD() {
        return true;
    }
}

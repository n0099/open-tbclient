package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bUs;
    private j bUv;

    public e(String str) {
        super(str);
        this.bUs = new ArrayList();
        this.bUv = new j(str);
        this.bUs.add(this.bUv);
    }

    public int WI() {
        return this.bUv.WI();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> WJ() {
        return this.bUs;
    }

    public boolean WK() {
        return true;
    }
}

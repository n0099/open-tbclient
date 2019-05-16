package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> amE;
    private j amH;

    public e(String str) {
        super(str);
        this.amE = new ArrayList();
        this.amH = new j(str);
        this.amE.add(this.amH);
    }

    public boolean xs() {
        return this.amH.xs();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> xt() {
        return this.amE;
    }

    public boolean xu() {
        return true;
    }
}

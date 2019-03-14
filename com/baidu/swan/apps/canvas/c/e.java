package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> amn;
    private j amq;

    public e(String str) {
        super(str);
        this.amn = new ArrayList();
        this.amq = new j(str);
        this.amn.add(this.amq);
    }

    public boolean wB() {
        return this.amq.wB();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wC() {
        return this.amn;
    }

    public boolean wD() {
        return true;
    }
}

package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cId;
    private j cIg;

    public e(String str) {
        super(str);
        this.cId = new ArrayList();
        this.cIg = new j(str);
        this.cId.add(this.cIg);
    }

    public int anc() {
        return this.cIg.anc();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> and() {
        return this.cId;
    }

    public boolean ane() {
        return true;
    }
}

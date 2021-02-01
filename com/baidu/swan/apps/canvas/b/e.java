package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends a {
    private j cKB;
    private List<com.baidu.swan.apps.canvas.a.a.a> cKy;

    public e(String str) {
        super(str);
        this.cKy = new ArrayList();
        this.cKB = new j(str);
        this.cKy.add(this.cKB);
    }

    public int akQ() {
        return this.cKB.akQ();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akR() {
        return this.cKy;
    }

    public boolean akS() {
        return true;
    }
}

package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> ams;
    private j amv;

    public e(String str) {
        super(str);
        this.ams = new ArrayList();
        this.amv = new j(str);
        this.ams.add(this.amv);
    }

    public boolean wA() {
        return this.amv.wA();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> wB() {
        return this.ams;
    }

    public boolean wC() {
        return true;
    }
}

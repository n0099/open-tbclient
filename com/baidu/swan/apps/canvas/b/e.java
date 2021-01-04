package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cMU;
    private j cMX;

    public e(String str) {
        super(str);
        this.cMU = new ArrayList();
        this.cMX = new j(str);
        this.cMU.add(this.cMX);
    }

    public int aol() {
        return this.cMX.aol();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> aom() {
        return this.cMU;
    }

    public boolean aon() {
        return true;
    }
}

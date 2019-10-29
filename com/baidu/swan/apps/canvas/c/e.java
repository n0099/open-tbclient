package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> aGW;
    private j aGZ;

    public e(String str) {
        super(str);
        this.aGW = new ArrayList();
        this.aGZ = new j(str);
        this.aGW.add(this.aGZ);
    }

    public boolean CV() {
        return this.aGZ.CV();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> CW() {
        return this.aGW;
    }

    public boolean CX() {
        return true;
    }
}

package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> aGE;
    private j aGH;

    public e(String str) {
        super(str);
        this.aGE = new ArrayList();
        this.aGH = new j(str);
        this.aGE.add(this.aGH);
    }

    public boolean CW() {
        return this.aGH.CW();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> CX() {
        return this.aGE;
    }

    public boolean CY() {
        return true;
    }
}

package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bhE;
    private j bhH;

    public e(String str) {
        super(str);
        this.bhE = new ArrayList();
        this.bhH = new j(str);
        this.bhE.add(this.bhH);
    }

    public boolean Kw() {
        return this.bhH.Kw();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Kx() {
        return this.bhE;
    }

    public boolean Ky() {
        return true;
    }
}

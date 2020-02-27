package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bhp;
    private j bhs;

    public e(String str) {
        super(str);
        this.bhp = new ArrayList();
        this.bhs = new j(str);
        this.bhp.add(this.bhs);
    }

    public boolean Kr() {
        return this.bhs.Kr();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ks() {
        return this.bhp;
    }

    public boolean Kt() {
        return true;
    }
}

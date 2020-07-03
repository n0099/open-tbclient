package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bTA;
    private j bTD;

    public e(String str) {
        super(str);
        this.bTA = new ArrayList();
        this.bTD = new j(str);
        this.bTA.add(this.bTD);
    }

    public boolean Wb() {
        return this.bTD.Wb();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Wc() {
        return this.bTA;
    }

    public boolean Wd() {
        return true;
    }
}

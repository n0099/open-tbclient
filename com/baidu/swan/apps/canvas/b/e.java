package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bOM;
    private j bOP;

    public e(String str) {
        super(str);
        this.bOM = new ArrayList();
        this.bOP = new j(str);
        this.bOM.add(this.bOP);
    }

    public boolean UV() {
        return this.bOP.UV();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> UW() {
        return this.bOM;
    }

    public boolean UX() {
        return true;
    }
}

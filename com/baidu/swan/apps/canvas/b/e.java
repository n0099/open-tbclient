package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> ccf;
    private j cci;

    public e(String str) {
        super(str);
        this.ccf = new ArrayList();
        this.cci = new j(str);
        this.ccf.add(this.cci);
    }

    public int adx() {
        return this.cci.adx();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> ady() {
        return this.ccf;
    }

    public boolean adz() {
        return true;
    }
}

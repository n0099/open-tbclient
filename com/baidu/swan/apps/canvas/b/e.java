package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cBh;
    private j cBk;

    public e(String str) {
        super(str);
        this.cBh = new ArrayList();
        this.cBk = new j(str);
        this.cBh.add(this.cBk);
    }

    public int ajU() {
        return this.cBk.ajU();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> ajV() {
        return this.cBh;
    }

    public boolean ajW() {
        return true;
    }
}

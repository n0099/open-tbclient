package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bFU;
    private j bFX;

    public e(String str) {
        super(str);
        this.bFU = new ArrayList();
        this.bFX = new j(str);
        this.bFU.add(this.bFX);
    }

    public boolean Sj() {
        return this.bFX.Sj();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Sk() {
        return this.bFU;
    }

    public boolean Sl() {
        return true;
    }
}

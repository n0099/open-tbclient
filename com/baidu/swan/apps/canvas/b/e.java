package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bFP;
    private j bFS;

    public e(String str) {
        super(str);
        this.bFP = new ArrayList();
        this.bFS = new j(str);
        this.bFP.add(this.bFS);
    }

    public boolean Sk() {
        return this.bFS.Sk();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Sl() {
        return this.bFP;
    }

    public boolean Sm() {
        return true;
    }
}

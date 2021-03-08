package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cLY;
    private j cMb;

    public e(String str) {
        super(str);
        this.cLY = new ArrayList();
        this.cMb = new j(str);
        this.cLY.add(this.cMb);
    }

    public int akT() {
        return this.cMb.akT();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> akU() {
        return this.cLY;
    }

    public boolean akV() {
        return true;
    }
}

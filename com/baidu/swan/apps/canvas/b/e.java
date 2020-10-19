package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> cow;
    private j coz;

    public e(String str) {
        super(str);
        this.cow = new ArrayList();
        this.coz = new j(str);
        this.cow.add(this.coz);
    }

    public int agi() {
        return this.coz.agi();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> agj() {
        return this.cow;
    }

    public boolean agk() {
        return true;
    }
}

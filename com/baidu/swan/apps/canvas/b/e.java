package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bhr;
    private j bhu;

    public e(String str) {
        super(str);
        this.bhr = new ArrayList();
        this.bhu = new j(str);
        this.bhr.add(this.bhu);
    }

    public boolean Kt() {
        return this.bhu.Kt();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ku() {
        return this.bhr;
    }

    public boolean Kv() {
        return true;
    }
}

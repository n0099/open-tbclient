package com.baidu.swan.apps.canvas.b;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> bhq;
    private j bht;

    public e(String str) {
        super(str);
        this.bhq = new ArrayList();
        this.bht = new j(str);
        this.bhq.add(this.bht);
    }

    public boolean Kt() {
        return this.bht.Kt();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> Ku() {
        return this.bhq;
    }

    public boolean Kv() {
        return true;
    }
}

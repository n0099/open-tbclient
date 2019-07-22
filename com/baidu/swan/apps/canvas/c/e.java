package com.baidu.swan.apps.canvas.c;

import com.baidu.swan.apps.canvas.a.a.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends a {
    private List<com.baidu.swan.apps.canvas.a.a.a> anh;
    private j ank;

    public e(String str) {
        super(str);
        this.anh = new ArrayList();
        this.ank = new j(str);
        this.anh.add(this.ank);
    }

    public boolean xW() {
        return this.ank.xW();
    }

    public List<com.baidu.swan.apps.canvas.a.a.a> xX() {
        return this.anh;
    }

    public boolean xY() {
        return true;
    }
}

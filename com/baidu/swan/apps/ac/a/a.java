package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a bGg;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.bGg = aVar;
    }

    public boolean isShow() {
        return this.bGg != null && "show".equals(this.bGg.getAction());
    }
}

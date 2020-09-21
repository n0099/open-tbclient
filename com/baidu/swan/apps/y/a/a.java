package com.baidu.swan.apps.y.a;
/* loaded from: classes3.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cGs;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cGs = aVar;
    }

    public boolean isShow() {
        return this.cGs != null && "show".equals(this.cGs.getAction());
    }
}

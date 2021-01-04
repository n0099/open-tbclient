package com.baidu.swan.apps.y.a;
/* loaded from: classes9.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a drf;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.drf = aVar;
    }

    public boolean isShow() {
        return this.drf != null && "show".equals(this.drf.getAction());
    }
}

package com.baidu.swan.apps.y.a;
/* loaded from: classes9.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a doC;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.doC = aVar;
    }

    public boolean isShow() {
        return this.doC != null && "show".equals(this.doC.getAction());
    }
}

package com.baidu.swan.apps.aa.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cpE;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cpE = aVar;
    }

    public boolean isShow() {
        return this.cpE != null && "show".equals(this.cpE.getAction());
    }
}

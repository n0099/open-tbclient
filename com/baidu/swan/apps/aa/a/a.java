package com.baidu.swan.apps.aa.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cus;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cus = aVar;
    }

    public boolean isShow() {
        return this.cus != null && "show".equals(this.cus.getAction());
    }
}

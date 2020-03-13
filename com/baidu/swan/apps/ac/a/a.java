package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a bFV;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.bFV = aVar;
    }

    public boolean isShow() {
        return this.bFV != null && "show".equals(this.bFV.getAction());
    }
}

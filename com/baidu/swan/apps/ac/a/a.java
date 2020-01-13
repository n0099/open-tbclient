package com.baidu.swan.apps.ac.a;
/* loaded from: classes10.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a bBN;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.bBN = aVar;
    }

    public boolean isShow() {
        return this.bBN != null && "show".equals(this.bBN.getAction());
    }
}

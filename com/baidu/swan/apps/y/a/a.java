package com.baidu.swan.apps.y.a;
/* loaded from: classes7.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a dfh;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.dfh = aVar;
    }

    public boolean isShow() {
        return this.dfh != null && "show".equals(this.dfh.getAction());
    }
}

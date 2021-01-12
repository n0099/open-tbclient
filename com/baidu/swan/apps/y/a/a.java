package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a dmp;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.dmp = aVar;
    }

    public boolean isShow() {
        return this.dmp != null && "show".equals(this.dmp.getAction());
    }
}

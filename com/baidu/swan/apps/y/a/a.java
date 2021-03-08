package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a dqe;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.dqe = aVar;
    }

    public boolean isShow() {
        return this.dqe != null && "show".equals(this.dqe.getAction());
    }
}

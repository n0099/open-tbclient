package com.baidu.swan.apps.z.a;
/* loaded from: classes7.dex */
public class a extends c {
    private com.baidu.swan.apps.res.widget.dialog.a cwu;

    public a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        super(5);
        this.cwu = aVar;
    }

    public boolean isShow() {
        return this.cwu != null && "show".equals(this.cwu.getAction());
    }
}

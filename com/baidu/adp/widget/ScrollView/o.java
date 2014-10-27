package com.baidu.adp.widget.ScrollView;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.d implements b {
    private boolean wC;

    public o(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void ib() {
        E(this.wC);
        if (this.wC) {
            this.wC = false;
        }
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void hE() {
        this.wC = true;
        super.hE();
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void hF() {
        this.wC = false;
        super.hF();
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public void ic() {
        this.wC = false;
        super.F(true);
    }

    @Override // com.baidu.adp.widget.ListView.d
    public View c(String str, String str2, String str3) {
        return super.c(str, str2, str3);
    }

    @Override // com.baidu.adp.widget.ScrollView.b
    public View getRealView() {
        return hB();
    }
}

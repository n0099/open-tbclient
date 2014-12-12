package com.baidu.tbadk.c;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.a WC;
    private com.baidu.tbadk.core.frameworkData.a WD;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.WC = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.WD = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a aC(boolean z) {
        return z ? this.WC : this.WD;
    }
}

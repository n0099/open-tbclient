package com.baidu.tbadk.c;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.a Xe;
    private com.baidu.tbadk.core.frameworkData.a Xf;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Xe = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Xf = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a aE(boolean z) {
        return z ? this.Xe : this.Xf;
    }
}

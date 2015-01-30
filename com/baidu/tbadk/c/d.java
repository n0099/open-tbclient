package com.baidu.tbadk.c;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.a Xh;
    private com.baidu.tbadk.core.frameworkData.a Xi;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Xh = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.Xi = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a aE(boolean z) {
        return z ? this.Xh : this.Xi;
    }
}

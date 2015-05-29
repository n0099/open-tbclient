package com.baidu.tbadk.b;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.c ait;
    private com.baidu.tbadk.core.frameworkData.c aiu;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.b.b
    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.c cVar) {
        this.ait = cVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.c cVar) {
        this.aiu = cVar;
    }

    public com.baidu.tbadk.core.frameworkData.c aR(boolean z) {
        return z ? this.ait : this.aiu;
    }
}

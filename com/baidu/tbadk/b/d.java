package com.baidu.tbadk.b;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.a ahs;
    private com.baidu.tbadk.core.frameworkData.a aht;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.b.b
    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.ahs = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.aht = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a aK(boolean z) {
        return z ? this.ahs : this.aht;
    }
}

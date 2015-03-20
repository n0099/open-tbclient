package com.baidu.tbadk.b;

import android.view.View;
/* loaded from: classes.dex */
public class d extends b {
    private com.baidu.tbadk.core.frameworkData.a ahk;
    private com.baidu.tbadk.core.frameworkData.a ahl;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.b.b
    public void e(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.ahk = aVar;
    }

    public void b(com.baidu.tbadk.core.frameworkData.a aVar) {
        this.ahl = aVar;
    }

    public com.baidu.tbadk.core.frameworkData.a aK(boolean z) {
        return z ? this.ahk : this.ahl;
    }
}

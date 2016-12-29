package com.baidu.tbadk.core.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.afu = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.afu.we();
    }
}

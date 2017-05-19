package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayoutNew amm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ThreadCommentAndPraiseInfoLayoutNew threadCommentAndPraiseInfoLayoutNew) {
        this.amm = threadCommentAndPraiseInfoLayoutNew;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.amm.wB();
    }
}

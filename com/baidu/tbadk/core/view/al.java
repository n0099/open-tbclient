package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout amM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.amM = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.amM.wP();
    }
}

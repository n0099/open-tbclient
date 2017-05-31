package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class al implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.alU = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.alU.wx();
    }
}

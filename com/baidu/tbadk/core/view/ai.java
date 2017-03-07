package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout alQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.alQ = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.alQ.wU();
    }
}

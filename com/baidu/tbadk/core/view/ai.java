package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ame;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ame = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ame.xq();
    }
}

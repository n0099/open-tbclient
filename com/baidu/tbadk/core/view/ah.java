package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout agx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.agx = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.agx.wx();
    }
}

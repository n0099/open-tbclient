package com.baidu.tbadk.core.view;

import android.view.View;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ThreadCommentAndPraiseInfoLayout ahk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        this.ahk = threadCommentAndPraiseInfoLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ahk.wC();
    }
}

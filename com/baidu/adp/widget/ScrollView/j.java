package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements i {
    final /* synthetic */ BdPullRefreshScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.i
    public final void a() {
        b bVar;
        this.a.u = false;
        BdPullRefreshScrollView bdPullRefreshScrollView = this.a;
        BdPullRefreshScrollView.State state = BdPullRefreshScrollView.State.RESET;
        bVar = this.a.n;
        bdPullRefreshScrollView.a(state, bVar);
    }
}

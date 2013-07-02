package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j {
    final /* synthetic */ BdPullRefreshScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        c cVar;
        this.a.u = false;
        BdPullRefreshScrollView bdPullRefreshScrollView = this.a;
        BdPullRefreshScrollView.State state = BdPullRefreshScrollView.State.RESET;
        cVar = this.a.n;
        bdPullRefreshScrollView.a(state, cVar);
    }
}

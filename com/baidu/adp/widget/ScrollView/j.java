package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f596a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.i
    public void a() {
        b bVar;
        this.f596a.u = false;
        BdPullRefreshScrollView bdPullRefreshScrollView = this.f596a;
        BdPullRefreshScrollView.State state = BdPullRefreshScrollView.State.RESET;
        bVar = this.f596a.n;
        bdPullRefreshScrollView.a(state, bVar);
    }
}

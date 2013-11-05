package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f587a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        c cVar;
        this.f587a.u = false;
        BdPullRefreshScrollView bdPullRefreshScrollView = this.f587a;
        BdPullRefreshScrollView.State state = BdPullRefreshScrollView.State.RESET;
        cVar = this.f587a.n;
        bdPullRefreshScrollView.a(state, cVar);
    }
}

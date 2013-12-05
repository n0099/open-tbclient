package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f597a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.i
    public void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        b bVar;
        b bVar2;
        n nVar;
        n nVar2;
        state = this.f597a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.f597a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.f597a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                bVar = this.f597a.n;
                bdPullRefreshScrollView.a(state3, bVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.f597a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        bVar2 = this.f597a.n;
        bdPullRefreshScrollView2.a(state4, bVar2);
        nVar = this.f597a.t;
        if (nVar != null) {
            nVar2 = this.f597a.t;
            nVar2.a();
        }
    }
}

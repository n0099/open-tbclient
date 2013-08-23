package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f497a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        c cVar;
        c cVar2;
        n nVar;
        n nVar2;
        state = this.f497a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.f497a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.f497a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                cVar = this.f497a.n;
                bdPullRefreshScrollView.a(state3, cVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.f497a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        cVar2 = this.f497a.n;
        bdPullRefreshScrollView2.a(state4, cVar2);
        nVar = this.f497a.t;
        if (nVar != null) {
            nVar2 = this.f497a.t;
            nVar2.a();
        }
    }
}

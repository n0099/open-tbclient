package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* loaded from: classes.dex */
final class l implements i {
    final /* synthetic */ BdPullRefreshScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.i
    public final void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        b bVar;
        b bVar2;
        n nVar;
        n unused;
        state = this.a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                bVar = this.a.o;
                bdPullRefreshScrollView.a(state3, bVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        bVar2 = this.a.o;
        bdPullRefreshScrollView2.a(state4, bVar2);
        nVar = this.a.s;
        if (nVar != null) {
            unused = this.a.s;
        }
    }
}

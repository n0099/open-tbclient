package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ BdPullRefreshScrollView Dh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.Dh = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void kB() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.b bVar;
        BdPullRefreshScrollView.b bVar2;
        state = this.Dh.CL;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.Dh.CL;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.Dh;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.Dh.CX;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.Dh;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.Dh.CX;
        bdPullRefreshScrollView2.a(state4, aVar2);
        bVar = this.Dh.Da;
        if (bVar != null) {
            bVar2 = this.Dh.Da;
            bVar2.kV();
        }
    }
}

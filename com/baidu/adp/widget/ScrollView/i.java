package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ BdPullRefreshScrollView IT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.IT = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void ns() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        k kVar;
        k kVar2;
        state = this.IT.Iw;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.IT.Iw;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.IT;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.IT.IJ;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.IT;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.IT.IJ;
        bdPullRefreshScrollView2.a(state4, aVar2);
        kVar = this.IT.IM;
        if (kVar != null) {
            kVar2 = this.IT.IM;
            kVar2.nP();
        }
    }
}

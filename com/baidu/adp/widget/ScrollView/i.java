package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ BdPullRefreshScrollView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.IZ = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nB() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.b bVar;
        BdPullRefreshScrollView.b bVar2;
        state = this.IZ.IB;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.IZ.IB;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.IZ;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.IZ.IO;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.IZ;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.IZ.IO;
        bdPullRefreshScrollView2.a(state4, aVar2);
        bVar = this.IZ.IR;
        if (bVar != null) {
            bVar2 = this.IZ.IR;
            bVar2.nX();
        }
    }
}

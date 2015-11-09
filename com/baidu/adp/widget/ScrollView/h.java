package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements g {
    final /* synthetic */ BdPullRefreshScrollView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.IZ = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nB() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.a aVar3;
        BdPullRefreshScrollView.a aVar4;
        state = this.IZ.IB;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.IZ.IB;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.IZ;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.IZ.IN;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.IZ;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.IZ.IN;
        bdPullRefreshScrollView2.a(state4, aVar2);
        aVar3 = this.IZ.IS;
        if (aVar3 != null) {
            aVar4 = this.IZ.IS;
            aVar4.nW();
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ BdPullRefreshScrollView IY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.IY = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nA() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.b bVar;
        BdPullRefreshScrollView.b bVar2;
        state = this.IY.IA;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.IY.IA;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.IY;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.IY.IN;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.IY;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.IY.IN;
        bdPullRefreshScrollView2.a(state4, aVar2);
        bVar = this.IY.IQ;
        if (bVar != null) {
            bVar2 = this.IY.IQ;
            bVar2.nW();
        }
    }
}

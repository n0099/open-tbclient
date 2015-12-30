package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements g {
    final /* synthetic */ BdPullRefreshScrollView JG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.JG = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nf() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.a aVar3;
        BdPullRefreshScrollView.a aVar4;
        state = this.JG.Jk;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.JG.Jk;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.JG;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.JG.Jv;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.JG;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.JG.Jv;
        bdPullRefreshScrollView2.a(state4, aVar2);
        aVar3 = this.JG.JA;
        if (aVar3 != null) {
            aVar4 = this.JG.JA;
            aVar4.nA();
        }
    }
}

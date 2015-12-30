package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ BdPullRefreshScrollView JG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.JG = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nf() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.b bVar;
        BdPullRefreshScrollView.b bVar2;
        state = this.JG.Jk;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.JG.Jk;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.JG;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.JG.Jw;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.JG;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.JG.Jw;
        bdPullRefreshScrollView2.a(state4, aVar2);
        bVar = this.JG.Jz;
        if (bVar != null) {
            bVar2 = this.JG.Jz;
            bVar2.nB();
        }
    }
}

package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements g {
    final /* synthetic */ BdPullRefreshScrollView Jb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.Jb = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void nb() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        j jVar;
        j jVar2;
        state = this.Jb.IF;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.Jb.IF;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.Jb;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.Jb.IQ;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.Jb;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.Jb.IQ;
        bdPullRefreshScrollView2.a(state4, aVar2);
        jVar = this.Jb.IV;
        if (jVar != null) {
            jVar2 = this.Jb.IV;
            jVar2.nx();
        }
    }
}

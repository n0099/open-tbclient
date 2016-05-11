package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements g {
    final /* synthetic */ BdPullRefreshScrollView As;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.As = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.g
    public void jE() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        a aVar;
        a aVar2;
        BdPullRefreshScrollView.a aVar3;
        BdPullRefreshScrollView.a aVar4;
        state = this.As.zV;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.As.zV;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.As;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                aVar = this.As.Ah;
                bdPullRefreshScrollView.a(state3, aVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.As;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        aVar2 = this.As.Ah;
        bdPullRefreshScrollView2.a(state4, aVar2);
        aVar3 = this.As.Am;
        if (aVar3 != null) {
            aVar4 = this.As.Am;
            aVar4.ka();
        }
    }
}

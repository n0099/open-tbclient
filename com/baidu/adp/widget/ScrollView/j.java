package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements h {
    final /* synthetic */ BdPullRefreshScrollView wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.wz = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.h
    public void hU() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        b bVar;
        b bVar2;
        l lVar;
        l lVar2;
        state = this.wz.wd;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.wz.wd;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.wz;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                bVar = this.wz.wo;
                bdPullRefreshScrollView.a(state3, bVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.wz;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        bVar2 = this.wz.wo;
        bdPullRefreshScrollView2.a(state4, bVar2);
        lVar = this.wz.wt;
        if (lVar != null) {
            lVar2 = this.wz.wt;
            lVar2.iy();
        }
    }
}

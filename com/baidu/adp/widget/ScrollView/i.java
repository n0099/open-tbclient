package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h {
    final /* synthetic */ BdPullRefreshScrollView wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.wz = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.h
    public void hU() {
        b bVar;
        this.wz.wu = false;
        BdPullRefreshScrollView bdPullRefreshScrollView = this.wz;
        BdPullRefreshScrollView.State state = BdPullRefreshScrollView.State.RESET;
        bVar = this.wz.wo;
        bdPullRefreshScrollView.a(state, bVar);
    }
}

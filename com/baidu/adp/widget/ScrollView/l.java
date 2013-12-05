package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f598a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.i
    public void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        b bVar;
        b bVar2;
        o oVar;
        o oVar2;
        state = this.f598a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.f598a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.f598a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                bVar = this.f598a.o;
                bdPullRefreshScrollView.a(state3, bVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.f598a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        bVar2 = this.f598a.o;
        bdPullRefreshScrollView2.a(state4, bVar2);
        oVar = this.f598a.s;
        if (oVar != null) {
            oVar2 = this.f598a.s;
            oVar2.a();
        }
    }
}

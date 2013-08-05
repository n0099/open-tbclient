package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f480a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f480a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        c cVar;
        c cVar2;
        o oVar;
        o oVar2;
        state = this.f480a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.f480a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.f480a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                cVar = this.f480a.o;
                bdPullRefreshScrollView.a(state3, cVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.f480a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        cVar2 = this.f480a.o;
        bdPullRefreshScrollView2.a(state4, cVar2);
        oVar = this.f480a.s;
        if (oVar != null) {
            oVar2 = this.f480a.s;
            oVar2.a();
        }
    }
}

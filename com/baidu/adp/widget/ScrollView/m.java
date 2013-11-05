package com.baidu.adp.widget.ScrollView;

import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdPullRefreshScrollView f589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.f589a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        BdPullRefreshScrollView.State state;
        BdPullRefreshScrollView.State state2;
        c cVar;
        c cVar2;
        p pVar;
        p pVar2;
        state = this.f589a.c;
        if (state != BdPullRefreshScrollView.State.RELEASE_TO_REFRESH) {
            state2 = this.f589a.c;
            if (state2 == BdPullRefreshScrollView.State.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.f589a;
                BdPullRefreshScrollView.State state3 = BdPullRefreshScrollView.State.RESET;
                cVar = this.f589a.o;
                bdPullRefreshScrollView.a(state3, cVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.f589a;
        BdPullRefreshScrollView.State state4 = BdPullRefreshScrollView.State.REFRESHING;
        cVar2 = this.f589a.o;
        bdPullRefreshScrollView2.a(state4, cVar2);
        pVar = this.f589a.s;
        if (pVar != null) {
            pVar2 = this.f589a.s;
            pVar2.a();
        }
    }
}

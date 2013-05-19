package com.baidu.adp.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements j {
    final /* synthetic */ BdPullRefreshScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        s sVar;
        s sVar2;
        c cVar;
        c cVar2;
        p pVar;
        p pVar2;
        sVar = this.a.c;
        if (sVar != s.RELEASE_TO_REFRESH) {
            sVar2 = this.a.c;
            if (sVar2 == s.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.a;
                s sVar3 = s.RESET;
                cVar = this.a.o;
                bdPullRefreshScrollView.a(sVar3, cVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.a;
        s sVar4 = s.REFRESHING;
        cVar2 = this.a.o;
        bdPullRefreshScrollView2.a(sVar4, cVar2);
        pVar = this.a.s;
        if (pVar != null) {
            pVar2 = this.a.s;
            pVar2.a();
        }
    }
}

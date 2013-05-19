package com.baidu.adp.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements j {
    final /* synthetic */ BdPullRefreshScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdPullRefreshScrollView bdPullRefreshScrollView) {
        this.a = bdPullRefreshScrollView;
    }

    @Override // com.baidu.adp.widget.ScrollView.j
    public void a() {
        s sVar;
        s sVar2;
        c cVar;
        c cVar2;
        o oVar;
        o oVar2;
        sVar = this.a.c;
        if (sVar != s.RELEASE_TO_REFRESH) {
            sVar2 = this.a.c;
            if (sVar2 == s.PULL_TO_REFRESH) {
                BdPullRefreshScrollView bdPullRefreshScrollView = this.a;
                s sVar3 = s.RESET;
                cVar = this.a.n;
                bdPullRefreshScrollView.a(sVar3, cVar);
                return;
            }
            return;
        }
        BdPullRefreshScrollView bdPullRefreshScrollView2 = this.a;
        s sVar4 = s.REFRESHING;
        cVar2 = this.a.n;
        bdPullRefreshScrollView2.a(sVar4, cVar2);
        oVar = this.a.t;
        if (oVar != null) {
            oVar2 = this.a.t;
            oVar2.a();
        }
    }
}

package com.baidu.loginshare;

import com.baidu.share.IShareListener;
import com.baidu.share.ShareModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements IShareListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.share.IShareListener
    public void onShareEvent(ShareModel shareModel) {
        String str = shareModel.mAction;
        if (e.a(str)) {
            if (g.c().equals(str)) {
                this.a.a(shareModel);
            } else if (g.d().equals(str)) {
                this.a.b(shareModel);
            } else if (g.a().equals(str)) {
                this.a.c(shareModel);
            } else if (g.b().equals(str)) {
                this.a.d(shareModel);
            }
        }
    }
}

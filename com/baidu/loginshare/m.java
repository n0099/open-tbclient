package com.baidu.loginshare;

import com.baidu.share.IShareListener;
import com.baidu.share.ShareModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements IShareListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.f955a = bVar;
    }

    @Override // com.baidu.share.IShareListener
    public void onShareEvent(ShareModel shareModel) {
        String str = shareModel.mAction;
        if (e.a(str)) {
            if (g.c().equals(str)) {
                this.f955a.a(shareModel);
            } else if (g.d().equals(str)) {
                this.f955a.b(shareModel);
            } else if (g.a().equals(str)) {
                this.f955a.c(shareModel);
            } else if (g.b().equals(str)) {
                this.f955a.d(shareModel);
            }
        }
    }
}

package com.baidu.mobads.g;

import com.baidu.mobads.g.q;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements q.a {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.mobads.g.q.a
    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
        }
    }
}

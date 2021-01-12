package com.baidu.mobads.g;

import com.baidu.mobads.g.q;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class j implements q.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f3336a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f3336a = gVar;
    }

    @Override // com.baidu.mobads.g.q.a
    public void a(String str) {
        try {
            this.f3336a.b();
            this.f3336a.a(str);
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
        }
    }
}

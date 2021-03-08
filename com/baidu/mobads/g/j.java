package com.baidu.mobads.g;

import com.baidu.mobads.g.q;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements q.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2392a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f2392a = gVar;
    }

    @Override // com.baidu.mobads.g.q.a
    public void a(String str) {
        try {
            this.f2392a.b();
            this.f2392a.a(str);
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
        }
    }
}

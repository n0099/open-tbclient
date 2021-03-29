package com.baidu.mobads.g;

import com.baidu.mobads.g.q;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class j implements q.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f8288a;

    public j(g gVar) {
        this.f8288a = gVar;
    }

    @Override // com.baidu.mobads.g.q.a
    public void a(String str) {
        try {
            this.f8288a.b();
            this.f8288a.a(str);
        } catch (Throwable th) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(th);
        }
    }
}

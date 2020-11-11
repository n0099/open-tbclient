package com.baidu.mobads.production;

import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.event.IXAdEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k implements g.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.f2418a = bVar;
    }

    @Override // com.baidu.mobads.g.g.c
    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    b.f2394a = BaiduXAdSDKContext.mApkLoader.h();
                    if (b.f2394a != null) {
                        this.f2418a.r();
                    }
                }
            } catch (Exception e) {
                com.baidu.mobads.utils.m.a().e(e);
                com.baidu.mobads.c.a.a().a("async apk on load exception: " + e.toString());
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        this.f2418a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR));
    }
}

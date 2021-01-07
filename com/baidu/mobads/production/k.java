package com.baidu.mobads.production;

import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.event.IXAdEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements g.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.f3495a = bVar;
    }

    @Override // com.baidu.mobads.g.g.c
    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    b.f3467a = BaiduXAdSDKContext.mApkLoader.h();
                    if (b.f3467a != null) {
                        this.f3495a.r();
                    }
                }
            } catch (Exception e) {
                com.baidu.mobads.utils.m.a().e(e);
                com.baidu.mobads.c.a.a().a("async apk on load exception: " + e.toString());
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        this.f3495a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_ERROR));
    }
}

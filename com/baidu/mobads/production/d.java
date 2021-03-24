package com.baidu.mobads.production;

import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.utils.q;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d implements g.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8454a;

    public d(a aVar) {
        this.f8454a = aVar;
    }

    @Override // com.baidu.mobads.g.g.c
    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    IXAdContainerFactory h2 = BaiduXAdSDKContext.mApkLoader.h();
                    a.f8434b = h2;
                    if (h2 != null) {
                        this.f8454a.b();
                        return;
                    }
                }
            } catch (Exception e2) {
                HashMap hashMap = new HashMap();
                hashMap.put("error_message", "async apk on load exception: " + e2.toString());
                this.f8454a.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
                q.a().e(e2);
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("error_message", "回调onLoad,succcess=" + z);
        this.f8454a.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap2));
    }
}

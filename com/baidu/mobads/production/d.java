package com.baidu.mobads.production;

import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.utils.q;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class d implements g.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3443a = aVar;
    }

    @Override // com.baidu.mobads.g.g.c
    public void a(boolean z) {
        if (z) {
            try {
                if (BaiduXAdSDKContext.mApkLoader != null) {
                    a.f3435b = BaiduXAdSDKContext.mApkLoader.h();
                    if (a.f3435b != null) {
                        this.f3443a.b();
                    }
                }
            } catch (Exception e) {
                HashMap hashMap = new HashMap();
                hashMap.put("error_message", "async apk on load exception: " + e.toString());
                this.f3443a.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap));
                q.a().e(e);
                return;
            }
        }
        BaiduXAdSDKContext.mApkLoader = null;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("error_message", "回调onLoad,succcess=" + z);
        this.f3443a.dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_ERROR, hashMap2));
    }
}

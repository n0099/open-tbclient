package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f8215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f8216b;

    public f(e eVar, IOAdEvent iOAdEvent) {
        this.f8216b = eVar;
        this.f8215a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaiduHybridAdViewListener baiduHybridAdViewListener;
        BaiduHybridAdViewListener baiduHybridAdViewListener2;
        com.baidu.mobads.production.c.a aVar;
        if (IXAdEvent.AD_LOADED.equals(this.f8215a.getType())) {
            aVar = this.f8216b.f8214a.f8116c;
            aVar.start();
        } else if (IXAdEvent.AD_STARTED.equals(this.f8215a.getType())) {
            baiduHybridAdViewListener2 = this.f8216b.f8214a.f8115b;
            baiduHybridAdViewListener2.onAdShow(0, null);
        } else if (IXAdEvent.AD_ERROR.equals(this.f8215a.getType())) {
        } else {
            if ("AdUserClick".equals(this.f8215a.getType())) {
                baiduHybridAdViewListener = this.f8216b.f8214a.f8115b;
                baiduHybridAdViewListener.onAdClick(0, null);
                return;
            }
            IXAdEvent.AD_USER_CLOSE.equals(this.f8215a.getType());
        }
    }
}

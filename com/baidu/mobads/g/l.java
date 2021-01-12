package com.baidu.mobads.g;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f3339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f3339a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        com.baidu.mobads.openad.d.a aVar;
        com.baidu.mobads.openad.d.a aVar2;
        com.baidu.mobads.openad.d.a aVar3;
        try {
            IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
            double d = this.f3339a.f3337a ? g.f3334b.f3324a : 0.0d;
            if (this.f3339a.f3337a) {
            }
            m mVar = new m(this, d);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("v", "" + d);
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.MODEL));
            hashMap.put(IXAdRequestInfo.BDR, XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.VERSION.SDK));
            str = g.i;
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(str, hashMap), "");
            cVar.e = 1;
            this.f3339a.f3338b.j = new com.baidu.mobads.openad.d.a();
            aVar = this.f3339a.f3338b.j;
            aVar.addEventListener("URLLoader.Load.Complete", mVar);
            aVar2 = this.f3339a.f3338b.j;
            aVar2.addEventListener("URLLoader.Load.Error", mVar);
            aVar3 = this.f3339a.f3338b.j;
            aVar3.a(cVar);
        } catch (Exception e) {
        }
    }
}

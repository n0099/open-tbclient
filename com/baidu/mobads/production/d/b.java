package com.baidu.mobads.production.d;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
/* loaded from: classes7.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2402a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        context = this.f2402a.f;
        commonUtils.getBaiduMapsInfo(context);
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context2 = this.f2402a.f;
        systemUtils.getCUID(context2);
        IXAdSystemUtils systemUtils2 = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context3 = this.f2402a.f;
        systemUtils2.getCell(context3);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
        IXAdSystemUtils systemUtils3 = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context4 = this.f2402a.f;
        systemUtils3.getWIFI(context4);
        IXAdSystemUtils systemUtils4 = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context5 = this.f2402a.f;
        systemUtils4.getGPS(context5);
        IXAdSystemUtils systemUtils5 = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context6 = this.f2402a.f;
        systemUtils5.getNetType(context6);
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getAppSDC();
        XAdSDKFoundationFacade.getInstance().getSystemUtils().getMem();
        IXAdSystemUtils systemUtils6 = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        context7 = this.f2402a.f;
        systemUtils6.getAndroidId(context7);
        e commonUtils2 = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        context8 = this.f2402a.f;
        commonUtils2.createRequestId(context8, "");
    }
}

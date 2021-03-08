package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2445a = aVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        this.f2445a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f2445a.a(iOAdEvent, "");
            return;
        }
        String message = iOAdEvent.getMessage();
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", message, "");
        this.f2445a.c(message);
    }
}

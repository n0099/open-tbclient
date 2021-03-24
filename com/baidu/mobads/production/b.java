package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class b implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8441a;

    public b(a aVar) {
        this.f8441a = aVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        this.f8441a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f8441a.a(iOAdEvent, "");
            return;
        }
        String message = iOAdEvent.getMessage();
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", message, "");
        this.f8441a.c(message);
    }
}

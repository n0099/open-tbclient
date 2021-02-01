package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class b implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3436a = aVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        this.f3436a.k();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.f3436a.a(iOAdEvent, "");
            return;
        }
        String message = iOAdEvent.getMessage();
        XAdSDKFoundationFacade.getInstance().getErrorCode().printErrorMessage("", message, "");
        this.f3436a.c(message);
    }
}

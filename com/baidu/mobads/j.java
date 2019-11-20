package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements IOAdEventListener {
    final /* synthetic */ d aAm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.aAm = dVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        e eVar;
        eVar = this.aAm.aAg;
        if (eVar != null) {
            XAdSDKFoundationFacade.getInstance().getCommonUtils().a((Runnable) new k(this, iOAdEvent));
        }
    }
}

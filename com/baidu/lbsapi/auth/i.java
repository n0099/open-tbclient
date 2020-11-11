package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f1840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f1840a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        a.a("handleMessage !!");
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.f;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        a.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}

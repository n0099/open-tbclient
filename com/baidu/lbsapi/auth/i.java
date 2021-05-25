package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6308a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f6308a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        a.a("handleMessage !!");
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.f6287f;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        a.a("handleMessage listener = " + lBSAuthManagerListener);
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}

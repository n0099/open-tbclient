package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LBSAuthManager f6557a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LBSAuthManager lBSAuthManager, Looper looper) {
        super(looper);
        this.f6557a = lBSAuthManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Hashtable hashtable;
        if (a.f6542a) {
            a.a("handleMessage !!");
        }
        String string = message.getData().getString("listenerKey");
        hashtable = LBSAuthManager.f6537f;
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) hashtable.get(string);
        if (a.f6542a) {
            a.a("handleMessage listener = " + lBSAuthManagerListener);
        }
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}

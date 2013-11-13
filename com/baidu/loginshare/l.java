package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.ShareAssistant;
import com.baidu.share.ShareModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.f948a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Token token;
        Context context;
        Context context2;
        try {
            sleep(100L);
            token = this.f948a.e;
            if (token == null) {
                context = this.f948a.f941a;
                if (context != null) {
                    ShareModel shareModel = new ShareModel();
                    shareModel.mAction = g.a();
                    context2 = this.f948a.f941a;
                    ShareAssistant.a(context2).share(shareModel);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class E extends HttpHandlerWrap {
    final /* synthetic */ SapiCallBack a;
    final /* synthetic */ G b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(G g, Looper looper, SapiCallBack sapiCallBack) {
        super(looper);
        this.b = g;
        this.a = sapiCallBack;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        if (i == -203) {
            this.a.onSystemError(i);
        } else {
            this.b.b(this.a, str);
        }
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        this.b.b(this.a, str);
    }
}

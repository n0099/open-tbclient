package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.utils.SapiDataEncryptor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class z extends HttpHandlerWrap {
    final /* synthetic */ SapiCallBack a;
    final /* synthetic */ boolean b;
    final /* synthetic */ SapiDataEncryptor c;
    final /* synthetic */ G d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(G g, Looper looper, SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        super(looper);
        this.d = g;
        this.a = sapiCallBack;
        this.b = z;
        this.c = sapiDataEncryptor;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        super.onFailure(th, i, str);
        if (i == -201) {
            this.a.onNetworkFailed();
        } else {
            this.a.onSystemError(i);
        }
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        super.onSuccess(i, str);
        G g = this.d;
        g.a(g.b(str), this.a, str, this.b, this.c);
    }
}

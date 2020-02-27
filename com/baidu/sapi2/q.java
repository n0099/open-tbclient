package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class q extends HttpHandlerWrap {
    final /* synthetic */ G a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(G g, Looper looper) {
        super(looper);
        this.a = g;
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        super.onFailure(th, i, str);
    }

    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        super.onSuccess(i, str);
    }
}

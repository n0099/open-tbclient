package cn.jpush.android.ui;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
/* loaded from: classes3.dex */
final class d implements DialogInterface.OnClickListener {
    final /* synthetic */ SslErrorHandler a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.cancel();
    }
}

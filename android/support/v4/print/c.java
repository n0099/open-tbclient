package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class c extends PrintDocumentAdapter {
    final /* synthetic */ String ce;
    final /* synthetic */ int cg;
    final /* synthetic */ a ch;
    final /* synthetic */ Uri ci;
    Bitmap mBitmap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, Uri uri, int i) {
        this.ch = aVar;
        this.ce = str;
        this.ci = uri;
        this.cg = i;
    }
}

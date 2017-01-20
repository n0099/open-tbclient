package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class c extends PrintDocumentAdapter {
    final /* synthetic */ String cc;
    final /* synthetic */ int ce;
    final /* synthetic */ a cf;
    final /* synthetic */ Uri cg;
    Bitmap mBitmap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, Uri uri, int i) {
        this.cf = aVar;
        this.cc = str;
        this.cg = uri;
        this.ce = i;
    }
}

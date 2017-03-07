package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class c extends PrintDocumentAdapter {
    final /* synthetic */ String jM;
    final /* synthetic */ int jO;
    final /* synthetic */ a jP;
    final /* synthetic */ Uri jQ;
    Bitmap mBitmap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, Uri uri, int i) {
        this.jP = aVar;
        this.jM = str;
        this.jQ = uri;
        this.jO = i;
    }
}

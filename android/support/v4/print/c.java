package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class c extends PrintDocumentAdapter {
    Bitmap mBitmap = null;
    final /* synthetic */ String mb;
    final /* synthetic */ int md;
    final /* synthetic */ a mf;
    final /* synthetic */ Uri mg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, Uri uri, int i) {
        this.mf = aVar;
        this.mb = str;
        this.mg = uri;
        this.md = i;
    }
}

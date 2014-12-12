package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class g extends PrintDocumentAdapter {
    final /* synthetic */ String aU;
    final /* synthetic */ int aW;
    final /* synthetic */ e aX;
    final /* synthetic */ Uri aY;
    Bitmap mBitmap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, String str, Uri uri, int i) {
        this.aX = eVar;
        this.aU = str;
        this.aY = uri;
        this.aW = i;
    }
}

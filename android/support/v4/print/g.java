package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* loaded from: classes.dex */
class g extends PrintDocumentAdapter {
    final /* synthetic */ String aV;
    final /* synthetic */ int aX;
    final /* synthetic */ e aY;
    final /* synthetic */ Uri aZ;
    Bitmap mBitmap = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, String str, Uri uri, int i) {
        this.aY = eVar;
        this.aV = str;
        this.aZ = uri;
        this.aX = i;
    }
}

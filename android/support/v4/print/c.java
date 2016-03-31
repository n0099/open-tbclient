package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends PrintDocumentAdapter {
    Bitmap mBitmap = null;
    final /* synthetic */ String mc;
    final /* synthetic */ int mf;
    final /* synthetic */ a mg;
    final /* synthetic */ Uri mh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, Uri uri, int i) {
        this.mg = aVar;
        this.mc = str;
        this.mh = uri;
        this.mf = i;
    }
}

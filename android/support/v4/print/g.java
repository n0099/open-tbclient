package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.print.PrintDocumentAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends PrintDocumentAdapter {
    final /* synthetic */ String lZ;
    Bitmap mBitmap = null;
    final /* synthetic */ int mb;
    final /* synthetic */ e mc;
    final /* synthetic */ Uri md;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, String str, Uri uri, int i) {
        this.mc = eVar;
        this.lZ = str;
        this.md = uri;
        this.mb = i;
    }
}

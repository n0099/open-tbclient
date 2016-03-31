package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintManager;
/* loaded from: classes.dex */
class a {
    final Context mContext;
    BitmapFactory.Options mb = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int lZ = 2;
    int ma = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.mContext = context;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public void setColorMode(int i) {
        this.lZ = i;
    }

    public void setOrientation(int i) {
        this.ma = i;
    }

    public int getOrientation() {
        return this.ma;
    }

    public int getColorMode() {
        return this.lZ;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        if (bitmap != null) {
            int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new b(this, str, bitmap, i), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.lZ).build());
        }
    }

    public void printBitmap(String str, Uri uri) {
        c cVar = new c(this, str, uri, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.lZ);
        if (this.ma == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.ma == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, cVar, builder.build());
    }
}

package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    final Context mContext;
    BitmapFactory.Options cd = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int ca = 2;
    int cc = 1;

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
        this.ca = i;
    }

    public void setOrientation(int i) {
        this.cc = i;
    }

    public int getOrientation() {
        return this.cc;
    }

    public int getColorMode() {
        return this.ca;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        if (bitmap != null) {
            int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new b(this, str, bitmap, i), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.ca).build());
        }
    }

    public void printBitmap(String str, Uri uri) {
        c cVar = new c(this, str, uri, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.ca);
        if (this.cc == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.cc == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, cVar, builder.build());
    }
}

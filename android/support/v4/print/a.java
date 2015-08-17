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
    BitmapFactory.Options ma = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int lY = 2;
    int lZ = 1;

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
        this.lY = i;
    }

    public void setOrientation(int i) {
        this.lZ = i;
    }

    public int getOrientation() {
        return this.lZ;
    }

    public int getColorMode() {
        return this.lY;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        if (bitmap != null) {
            int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new b(this, str, bitmap, i), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.lY).build());
        }
    }

    public void printBitmap(String str, Uri uri) {
        c cVar = new c(this, str, uri, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.lY);
        if (this.lZ == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.lZ == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, cVar, builder.build());
    }
}

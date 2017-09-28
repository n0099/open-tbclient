package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
class a {
    final Context mContext;
    BitmapFactory.Options jK = null;
    private final Object mLock = new Object();
    int mScaleMode = 2;
    int jJ = 2;
    int mOrientation = 1;

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
        this.jJ = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getColorMode() {
        return this.jJ;
    }

    public void printBitmap(final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            final int i = this.mScaleMode;
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.MediaSize mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new PrintDocumentAdapter() { // from class: android.support.v4.print.a.1
            }, new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.jJ).build());
        }
    }

    public void printBitmap(final String str, final Uri uri) throws FileNotFoundException {
        final int i = this.mScaleMode;
        PrintDocumentAdapter printDocumentAdapter = new PrintDocumentAdapter() { // from class: android.support.v4.print.a.2
            Bitmap mBitmap = null;
        };
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.jJ);
        if (this.mOrientation == 1) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (this.mOrientation == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, printDocumentAdapter, builder.build());
    }
}

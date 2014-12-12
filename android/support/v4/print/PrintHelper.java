package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
/* loaded from: classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    d aQ;

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.aQ = new b(context);
        } else {
            this.aQ = new c();
        }
    }

    public void setScaleMode(int i) {
        this.aQ.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.aQ.getScaleMode();
    }

    public void setColorMode(int i) {
        this.aQ.setColorMode(i);
    }

    public int getColorMode() {
        return this.aQ.getColorMode();
    }

    public void setOrientation(int i) {
        this.aQ.setOrientation(i);
    }

    public int getOrientation() {
        return this.aQ.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.aQ.printBitmap(str, bitmap);
    }

    public void printBitmap(String str, Uri uri) {
        this.aQ.printBitmap(str, uri);
    }
}

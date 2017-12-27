package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.print.PrintHelperKitkat;
import java.io.FileNotFoundException;
/* loaded from: classes2.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    g Ao;

    /* loaded from: classes2.dex */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    /* loaded from: classes2.dex */
    interface g {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* loaded from: classes2.dex */
    private static final class f implements g {
        int As;
        int At;
        int mScaleMode;

        private f() {
            this.mScaleMode = 2;
            this.As = 2;
            this.At = 1;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getColorMode() {
            return this.As;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setColorMode(int i) {
            this.As = i;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setOrientation(int i) {
            this.At = i;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getOrientation() {
            return this.At;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }
    }

    /* loaded from: classes2.dex */
    private static class d<RealHelper extends PrintHelperKitkat> implements g {
        private final RealHelper Ap;

        protected d(RealHelper realhelper) {
            this.Ap = realhelper;
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setScaleMode(int i) {
            this.Ap.setScaleMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getScaleMode() {
            return this.Ap.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setColorMode(int i) {
            this.Ap.setColorMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getColorMode() {
            return this.Ap.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void setOrientation(int i) {
            this.Ap.setOrientation(i);
        }

        @Override // android.support.v4.print.PrintHelper.g
        public int getOrientation() {
            return this.Ap.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void printBitmap(String str, Bitmap bitmap, final OnPrintFinishCallback onPrintFinishCallback) {
            PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback2 = null;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback2 = new PrintHelperKitkat.OnPrintFinishCallback() { // from class: android.support.v4.print.PrintHelper.d.1
                    @Override // android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.Ap.a(str, bitmap, onPrintFinishCallback2);
        }

        @Override // android.support.v4.print.PrintHelper.g
        public void printBitmap(String str, Uri uri, final OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            PrintHelperKitkat.OnPrintFinishCallback onPrintFinishCallback2 = null;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback2 = new PrintHelperKitkat.OnPrintFinishCallback() { // from class: android.support.v4.print.PrintHelper.d.2
                    @Override // android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback
                    public void onFinish() {
                        onPrintFinishCallback.onFinish();
                    }
                };
            }
            this.Ap.a(str, uri, onPrintFinishCallback2);
        }
    }

    /* loaded from: classes2.dex */
    private static final class e extends d<PrintHelperKitkat> {
        e(Context context) {
            super(new PrintHelperKitkat(context));
        }
    }

    /* loaded from: classes2.dex */
    private static final class a extends d<android.support.v4.print.a> {
        a(Context context) {
            super(new android.support.v4.print.a(context));
        }
    }

    /* loaded from: classes2.dex */
    private static final class b extends d<android.support.v4.print.b> {
        b(Context context) {
            super(new android.support.v4.print.b(context));
        }
    }

    /* loaded from: classes2.dex */
    private static final class c extends d<android.support.v4.print.c> {
        c(Context context) {
            super(new android.support.v4.print.c(context));
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.Ao = new c(context);
                return;
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.Ao = new b(context);
                return;
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.Ao = new a(context);
                return;
            } else {
                this.Ao = new e(context);
                return;
            }
        }
        this.Ao = new f();
    }

    public void setScaleMode(int i) {
        this.Ao.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.Ao.getScaleMode();
    }

    public void setColorMode(int i) {
        this.Ao.setColorMode(i);
    }

    public int getColorMode() {
        return this.Ao.getColorMode();
    }

    public void setOrientation(int i) {
        this.Ao.setOrientation(i);
    }

    public int getOrientation() {
        return this.Ao.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.Ao.printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.Ao.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.Ao.printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.Ao.printBitmap(str, uri, onPrintFinishCallback);
    }
}

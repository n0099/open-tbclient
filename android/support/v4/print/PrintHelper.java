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
    c lW;

    /* loaded from: classes.dex */
    interface c {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap);

        void printBitmap(String str, Uri uri);

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* loaded from: classes.dex */
    private static final class b implements c {
        int lY;
        int lZ;
        int mScaleMode;

        private b() {
            this.mScaleMode = 2;
            this.lY = 2;
            this.lZ = 1;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.lY;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.lY = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.lZ = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.lZ;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Bitmap bitmap) {
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Uri uri) {
        }
    }

    /* loaded from: classes.dex */
    private static final class a implements c {
        private final android.support.v4.print.a lX;

        a(Context context) {
            this.lX = new android.support.v4.print.a(context);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.lX.setScaleMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getScaleMode() {
            return this.lX.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.lX.setColorMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.lX.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.lX.setOrientation(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.lX.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Bitmap bitmap) {
            this.lX.printBitmap(str, bitmap);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Uri uri) {
            this.lX.printBitmap(str, uri);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.lW = new a(context);
        } else {
            this.lW = new b();
        }
    }

    public void setScaleMode(int i) {
        this.lW.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.lW.getScaleMode();
    }

    public void setColorMode(int i) {
        this.lW.setColorMode(i);
    }

    public int getColorMode() {
        return this.lW.getColorMode();
    }

    public void setOrientation(int i) {
        this.lW.setOrientation(i);
    }

    public int getOrientation() {
        return this.lW.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.lW.printBitmap(str, bitmap);
    }

    public void printBitmap(String str, Uri uri) {
        this.lW.printBitmap(str, uri);
    }
}

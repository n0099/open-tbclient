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
    c bY;

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
        int ca;
        int cc;
        int mScaleMode;

        private b() {
            this.mScaleMode = 2;
            this.ca = 2;
            this.cc = 1;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.ca;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.ca = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.cc = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.cc;
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
        private final android.support.v4.print.a bZ;

        a(Context context) {
            this.bZ = new android.support.v4.print.a(context);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.bZ.setScaleMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getScaleMode() {
            return this.bZ.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.bZ.setColorMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.bZ.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.bZ.setOrientation(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.bZ.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Bitmap bitmap) {
            this.bZ.printBitmap(str, bitmap);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Uri uri) {
            this.bZ.printBitmap(str, uri);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.bY = new a(context);
        } else {
            this.bY = new b();
        }
    }

    public void setScaleMode(int i) {
        this.bY.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.bY.getScaleMode();
    }

    public void setColorMode(int i) {
        this.bY.setColorMode(i);
    }

    public int getColorMode() {
        return this.bY.getColorMode();
    }

    public void setOrientation(int i) {
        this.bY.setOrientation(i);
    }

    public int getOrientation() {
        return this.bY.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.bY.printBitmap(str, bitmap);
    }

    public void printBitmap(String str, Uri uri) {
        this.bY.printBitmap(str, uri);
    }
}

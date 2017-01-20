package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    c bX;

    /* loaded from: classes.dex */
    interface c {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap);

        void printBitmap(String str, Uri uri) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* loaded from: classes.dex */
    private static final class b implements c {
        int bZ;
        int mOrientation;
        int mScaleMode;

        private b() {
            this.mScaleMode = 2;
            this.bZ = 2;
            this.mOrientation = 1;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.bZ;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.bZ = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.mOrientation;
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
        private final android.support.v4.print.a bY;

        a(Context context) {
            this.bY = new android.support.v4.print.a(context);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.bY.setScaleMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getScaleMode() {
            return this.bY.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.bY.setColorMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.bY.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.bY.setOrientation(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.bY.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Bitmap bitmap) {
            this.bY.printBitmap(str, bitmap);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Uri uri) throws FileNotFoundException {
            this.bY.printBitmap(str, uri);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.bX = new a(context);
        } else {
            this.bX = new b();
        }
    }

    public void setScaleMode(int i) {
        this.bX.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.bX.getScaleMode();
    }

    public void setColorMode(int i) {
        this.bX.setColorMode(i);
    }

    public int getColorMode() {
        return this.bX.getColorMode();
    }

    public void setOrientation(int i) {
        this.bX.setOrientation(i);
    }

    public int getOrientation() {
        return this.bX.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.bX.printBitmap(str, bitmap);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.bX.printBitmap(str, uri);
    }
}

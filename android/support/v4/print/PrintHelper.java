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
    c jI;

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
        int jK;
        int mOrientation;
        int mScaleMode;

        private b() {
            this.mScaleMode = 2;
            this.jK = 2;
            this.mOrientation = 1;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.jK;
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.jK = i;
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
        private final android.support.v4.print.a jJ;

        a(Context context) {
            this.jJ = new android.support.v4.print.a(context);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setScaleMode(int i) {
            this.jJ.setScaleMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getScaleMode() {
            return this.jJ.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setColorMode(int i) {
            this.jJ.setColorMode(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getColorMode() {
            return this.jJ.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void setOrientation(int i) {
            this.jJ.setOrientation(i);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public int getOrientation() {
            return this.jJ.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Bitmap bitmap) {
            this.jJ.printBitmap(str, bitmap);
        }

        @Override // android.support.v4.print.PrintHelper.c
        public void printBitmap(String str, Uri uri) throws FileNotFoundException {
            this.jJ.printBitmap(str, uri);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.jI = new a(context);
        } else {
            this.jI = new b();
        }
    }

    public void setScaleMode(int i) {
        this.jI.setScaleMode(i);
    }

    public int getScaleMode() {
        return this.jI.getScaleMode();
    }

    public void setColorMode(int i) {
        this.jI.setColorMode(i);
    }

    public int getColorMode() {
        return this.jI.getColorMode();
    }

    public void setOrientation(int i) {
        this.jI.setOrientation(i);
    }

    public int getOrientation() {
        return this.jI.getOrientation();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.jI.printBitmap(str, bitmap);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.jI.printBitmap(str, uri);
    }
}

package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> bA = new WeakHashMap<>();

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (bA) {
            displayManagerCompat = bA.get(context);
            if (displayManagerCompat == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new a(context);
                } else {
                    displayManagerCompat = new b(context);
                }
                bA.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    /* loaded from: classes.dex */
    private static class b extends DisplayManagerCompat {
        private final WindowManager bC;

        public b(Context context) {
            this.bC = (WindowManager) context.getSystemService("window");
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            Display defaultDisplay = this.bC.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return new Display[]{this.bC.getDefaultDisplay()};
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    /* loaded from: classes.dex */
    private static class a extends DisplayManagerCompat {
        private final Object bB;

        public a(Context context) {
            this.bB = android.support.v4.hardware.display.a.o(context);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            return android.support.v4.hardware.display.a.a(this.bB, i);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return android.support.v4.hardware.display.a.c(this.bB);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return android.support.v4.hardware.display.a.b(this.bB, str);
        }
    }
}

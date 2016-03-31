package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> ly = new WeakHashMap<>();

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (ly) {
            displayManagerCompat = ly.get(context);
            if (displayManagerCompat == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new a(context);
                } else {
                    displayManagerCompat = new b(context);
                }
                ly.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    /* loaded from: classes.dex */
    private static class b extends DisplayManagerCompat {
        private final WindowManager lB;

        public b(Context context) {
            this.lB = (WindowManager) context.getSystemService("window");
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            Display defaultDisplay = this.lB.getDefaultDisplay();
            if (defaultDisplay.getDisplayId() == i) {
                return defaultDisplay;
            }
            return null;
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return new Display[]{this.lB.getDefaultDisplay()};
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return str == null ? getDisplays() : new Display[0];
        }
    }

    /* loaded from: classes.dex */
    private static class a extends DisplayManagerCompat {
        private final Object lA;

        public a(Context context) {
            this.lA = android.support.v4.hardware.display.a.o(context);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display getDisplay(int i) {
            return android.support.v4.hardware.display.a.a(this.lA, i);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays() {
            return android.support.v4.hardware.display.a.c(this.lA);
        }

        @Override // android.support.v4.hardware.display.DisplayManagerCompat
        public Display[] getDisplays(String str) {
            return android.support.v4.hardware.display.a.b(this.lA, str);
        }
    }
}

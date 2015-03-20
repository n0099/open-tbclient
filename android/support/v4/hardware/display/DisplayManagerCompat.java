package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> ly = new WeakHashMap<>();

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String str);

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
}

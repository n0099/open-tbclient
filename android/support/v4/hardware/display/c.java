package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
/* loaded from: classes.dex */
final class c {
    public static Object y(Context context) {
        return context.getSystemService("display");
    }

    public static Display a(Object obj, int i) {
        return ((DisplayManager) obj).getDisplay(i);
    }

    public static Display[] b(Object obj) {
        return ((DisplayManager) obj).getDisplays();
    }

    public static Display[] a(Object obj, String str) {
        return ((DisplayManager) obj).getDisplays(str);
    }
}

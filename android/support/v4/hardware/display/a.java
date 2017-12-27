package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
/* loaded from: classes2.dex */
final class a {
    public static Object S(Context context) {
        return context.getSystemService("display");
    }

    public static Display a(Object obj, int i) {
        return ((DisplayManager) obj).getDisplay(i);
    }

    public static Display[] j(Object obj) {
        return ((DisplayManager) obj).getDisplays();
    }

    public static Display[] c(Object obj, String str) {
        return ((DisplayManager) obj).getDisplays(str);
    }
}

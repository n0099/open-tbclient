package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
class d {
    private static Method ws;
    private static boolean wt;
    private static Method wu;
    private static boolean wv;

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        if (!wt) {
            try {
                ws = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                ws.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            wt = true;
        }
        if (ws != null) {
            try {
                ws.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                ws = null;
            }
        }
        return false;
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (!wv) {
            try {
                wu = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                wu.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            wv = true;
        }
        if (wu != null) {
            try {
                return ((Integer) wu.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                wu = null;
            }
        }
        return -1;
    }
}

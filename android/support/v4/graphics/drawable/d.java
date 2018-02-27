package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
class d {
    private static Method wr;
    private static boolean ws;
    private static Method wt;
    private static boolean wu;

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        if (!ws) {
            try {
                wr = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                wr.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            ws = true;
        }
        if (wr != null) {
            try {
                wr.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                wr = null;
            }
        }
        return false;
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (!wu) {
            try {
                wt = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                wt.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            wu = true;
        }
        if (wt != null) {
            try {
                return ((Integer) wt.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                wt = null;
            }
        }
        return -1;
    }
}

package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
class PopupWindowCompatApi21 {
    private static Field sOverlapAnchorField;

    static {
        try {
            sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            sOverlapAnchorField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        if (sOverlapAnchorField != null) {
            try {
                sOverlapAnchorField.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        if (sOverlapAnchorField != null) {
            try {
                return ((Boolean) sOverlapAnchorField.get(popupWindow)).booleanValue();
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }
}

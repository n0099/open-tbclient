package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class ViewGroupUtils {
    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewGroupOverlayApi18(viewGroup);
        }
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
        }
    }
}

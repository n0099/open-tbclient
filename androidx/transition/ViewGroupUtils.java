package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes14.dex */
class ViewGroupUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewGroupOverlayApi18(viewGroup) : ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.suppressLayout(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.suppressLayout(viewGroup, z);
        }
    }

    private ViewGroupUtils() {
    }
}

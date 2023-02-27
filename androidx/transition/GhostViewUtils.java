package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class GhostViewUtils {
    @Nullable
    public static GhostView addGhost(@NonNull View view2, @NonNull ViewGroup viewGroup, @Nullable Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return GhostViewPlatform.addGhost(view2, viewGroup, matrix);
        }
        return GhostViewPort.addGhost(view2, viewGroup, matrix);
    }

    public static void removeGhost(View view2) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.removeGhost(view2);
        } else {
            GhostViewPort.removeGhost(view2);
        }
    }
}

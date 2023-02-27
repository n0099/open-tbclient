package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class TooltipCompat {
    public static void setTooltipText(@NonNull View view2, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setTooltipText(charSequence);
        } else {
            TooltipCompatHandler.setTooltipText(view2, charSequence);
        }
    }
}

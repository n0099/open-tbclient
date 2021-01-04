package androidx.transition;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
/* loaded from: classes15.dex */
interface ViewOverlayImpl {
    void add(@NonNull Drawable drawable);

    void clear();

    void remove(@NonNull Drawable drawable);
}

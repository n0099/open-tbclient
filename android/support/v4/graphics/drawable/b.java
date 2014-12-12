package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
interface b {
    boolean isAutoMirrored(Drawable drawable);

    void jumpToCurrentState(Drawable drawable);

    void setAutoMirrored(Drawable drawable, boolean z);
}

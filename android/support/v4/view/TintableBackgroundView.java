package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* loaded from: classes2.dex */
public interface TintableBackgroundView {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}

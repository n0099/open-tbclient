package com.baidu.searchbox.suspensionwindow;

import android.support.annotation.NonNull;
import android.view.View;
/* loaded from: classes13.dex */
public abstract class IFloatWindow {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dismiss();

    public abstract String getTag();

    public abstract View getView();

    public abstract float getX();

    public abstract float getY();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void setTag(@NonNull String str);

    public abstract void show();

    public abstract void updateX(float f);

    public abstract void updateX(int i, float f);

    public abstract void updateY(float f);

    public abstract void updateY(int i, float f);
}

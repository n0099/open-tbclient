package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i2) {
        this.mEdgeEffect.onAbsorb(i2);
        return true;
    }

    @Deprecated
    public boolean onPull(float f2) {
        this.mEdgeEffect.onPull(f2);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i2, int i3) {
        this.mEdgeEffect.setSize(i2, i3);
    }

    @Deprecated
    public boolean onPull(float f2, float f3) {
        onPull(this.mEdgeEffect, f2, f3);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }
}

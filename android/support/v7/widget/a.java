package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class a extends Drawable {
    final ActionBarContainer JT;

    public a(ActionBarContainer actionBarContainer) {
        this.JT = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.JT.Ka) {
            if (this.JT.JZ != null) {
                this.JT.JZ.draw(canvas);
                return;
            }
            return;
        }
        if (this.JT.Iw != null) {
            this.JT.Iw.draw(canvas);
        }
        if (this.JT.JY != null && this.JT.Kb) {
            this.JT.JY.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }
}

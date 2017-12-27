package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class a extends Drawable {
    final ActionBarContainer JU;

    public a(ActionBarContainer actionBarContainer) {
        this.JU = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.JU.Kb) {
            if (this.JU.Ka != null) {
                this.JU.Ka.draw(canvas);
                return;
            }
            return;
        }
        if (this.JU.Ix != null) {
            this.JU.Ix.draw(canvas);
        }
        if (this.JU.JZ != null && this.JU.Kc) {
            this.JU.JZ.draw(canvas);
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

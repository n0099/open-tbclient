package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
class a extends Drawable {
    final ActionBarContainer JO;

    public a(ActionBarContainer actionBarContainer) {
        this.JO = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.JO.JV) {
            if (this.JO.JU != null) {
                this.JO.JU.draw(canvas);
                return;
            }
            return;
        }
        if (this.JO.Ir != null) {
            this.JO.Ir.draw(canvas);
        }
        if (this.JO.JT != null && this.JO.JW) {
            this.JO.JT.draw(canvas);
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

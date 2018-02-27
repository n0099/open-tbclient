package android.support.v7.widget;

import android.graphics.Outline;
/* loaded from: classes2.dex */
class b extends a {
    public b(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.JO.JV) {
            if (this.JO.JU != null) {
                this.JO.JU.getOutline(outline);
            }
        } else if (this.JO.Ir != null) {
            this.JO.Ir.getOutline(outline);
        }
    }
}

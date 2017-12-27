package android.support.v7.widget;

import android.graphics.Outline;
/* loaded from: classes2.dex */
class b extends a {
    public b(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.JU.Kb) {
            if (this.JU.Ka != null) {
                this.JU.Ka.getOutline(outline);
            }
        } else if (this.JU.Ix != null) {
            this.JU.Ix.getOutline(outline);
        }
    }
}

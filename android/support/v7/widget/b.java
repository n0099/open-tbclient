package android.support.v7.widget;

import android.graphics.Outline;
/* loaded from: classes2.dex */
class b extends a {
    public b(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.JT.Ka) {
            if (this.JT.JZ != null) {
                this.JT.JZ.getOutline(outline);
            }
        } else if (this.JT.Iw != null) {
            this.JT.Iw.getOutline(outline);
        }
    }
}

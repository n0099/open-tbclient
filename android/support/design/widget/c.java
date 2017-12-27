package android.support.design.widget;

import android.graphics.Outline;
/* loaded from: classes2.dex */
class c extends b {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.lQ);
        outline.setOval(this.lQ);
    }
}

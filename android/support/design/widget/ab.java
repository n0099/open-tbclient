package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: classes2.dex */
class ab extends ImageButton {
    private int sU;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sU = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        b(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.sU = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getUserSetVisibility() {
        return this.sU;
    }
}

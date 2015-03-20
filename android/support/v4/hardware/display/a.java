package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
/* loaded from: classes.dex */
class a extends DisplayManagerCompat {
    private final Object lA;

    public a(Context context) {
        this.lA = c.y(context);
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display getDisplay(int i) {
        return c.a(this.lA, i);
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display[] getDisplays() {
        return c.b(this.lA);
    }

    @Override // android.support.v4.hardware.display.DisplayManagerCompat
    public Display[] getDisplays(String str) {
        return c.a(this.lA, str);
    }
}

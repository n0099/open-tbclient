package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class ab extends aa {

    /* renamed from: a  reason: collision with root package name */
    private Method f337a;
    private Field b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab() {
        try {
            this.f337a = View.class.getDeclaredMethod("getDisplayList", null);
        } catch (NoSuchMethodException e) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
        }
        try {
            this.b = View.class.getDeclaredField("mRecreateDisplayList");
            this.b.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
        }
    }

    @Override // android.support.v4.widget.aa, android.support.v4.widget.z
    public void a(SlidingPaneLayout slidingPaneLayout, View view) {
        if (this.f337a != null && this.b != null) {
            try {
                this.b.setBoolean(view, true);
                this.f337a.invoke(view, null);
            } catch (Exception e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.a(slidingPaneLayout, view);
            return;
        }
        view.invalidate();
    }
}

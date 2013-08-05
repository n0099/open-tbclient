package android.support.v4.app;

import android.app.Activity;
import android.util.Log;
/* loaded from: classes.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f281a = {16843531};

    public static Object a(Object obj, Activity activity, int i) {
        Object gVar = obj == null ? new g(activity) : obj;
        g gVar2 = (g) gVar;
        if (gVar2.f282a != null) {
            try {
                gVar2.b.invoke(activity.getActionBar(), Integer.valueOf(i));
            } catch (Exception e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return gVar;
    }
}

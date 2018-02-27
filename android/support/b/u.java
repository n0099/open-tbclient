package android.support.b;

import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class u {
    private static x va;

    static {
        if (Build.VERSION.SDK_INT < 19) {
            va = new w();
        } else {
            va = new y();
        }
    }

    public static void a(ViewGroup viewGroup, n nVar) {
        va.a(viewGroup, nVar == null ? null : nVar.uR);
    }
}

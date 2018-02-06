package android.support.b;

import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class u {
    private static x vb;

    static {
        if (Build.VERSION.SDK_INT < 19) {
            vb = new w();
        } else {
            vb = new y();
        }
    }

    public static void a(ViewGroup viewGroup, n nVar) {
        vb.a(viewGroup, nVar == null ? null : nVar.uS);
    }
}

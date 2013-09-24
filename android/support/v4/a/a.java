package android.support.v4.a;

import android.os.Build;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class a {
    public static <T> Parcelable.Creator<T> a(c<T> cVar) {
        if (Build.VERSION.SDK_INT >= 13) {
            e.a(cVar);
        }
        return new b(cVar);
    }
}

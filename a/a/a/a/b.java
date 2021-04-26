package a.a.a.a;

import a.a.a.a.x.f.g.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b implements FunNativeAd {

    /* renamed from: a  reason: collision with root package name */
    public final String f1004a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b f1005b;

    public b(String str) {
        this.f1004a = str;
        this.f1005b = new d.b(str);
    }

    public abstract void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener);

    @Override // com.fun.ad.sdk.FunNativeAd
    public final void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        if (context == null || viewGroup == null || list == null || funAdInteractionListener == null) {
            throw new IllegalArgumentException();
        }
        this.f1005b.c();
        a(context, viewGroup, list, list2, funAdInteractionListener);
    }
}

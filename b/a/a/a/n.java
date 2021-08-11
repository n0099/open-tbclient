package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import b.a.a.a.u.h;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
/* loaded from: classes.dex */
public interface n {
    void a();

    boolean a(Context context, FunAdSlot funAdSlot);

    h.a b();

    FunSplashAd b(Activity activity, ViewGroup viewGroup, String str);

    boolean c();

    boolean c(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater);

    b.a.a.a.w.p d();

    void d(o oVar);

    FunNativeAd getNativeAd(Context context, String str);
}

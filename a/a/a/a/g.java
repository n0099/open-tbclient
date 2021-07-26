package a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
/* loaded from: classes.dex */
public interface g {
    FunNativeAd a(Context context);

    void a();

    void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    <T extends ViewGroup> boolean a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater);

    boolean b();
}

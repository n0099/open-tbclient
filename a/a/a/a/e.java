package a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class e implements FunAdFactory {

    /* renamed from: c  reason: collision with root package name */
    public static e f1021c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<s, f>> f1022a;

    /* renamed from: b  reason: collision with root package name */
    public final o f1023b;

    public e() {
        this.f1022a = new HashMap();
        this.f1023b = new o(new HashMap());
    }

    public e(o oVar) {
        this.f1022a = new HashMap();
        this.f1023b = oVar;
        f1021c = this;
    }

    public final f a(String str) {
        synchronized (this.f1022a) {
            s b2 = i.b(str);
            if (b2 == null) {
                return null;
            }
            Map<s, f> map = this.f1022a.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f1022a.put(str, map);
            }
            f fVar = map.get(b2);
            if (fVar == null) {
                fVar = b2.f1096a.a(this.f1023b);
                map.put(b2, fVar);
            }
            return fVar;
        }
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        f a2 = a(str);
        if (a2 != null) {
            a2.a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater);
            return;
        }
        a.a.a.a.x.d.a("No Loader found for sid:%s", str);
        funAdInteractionListener.onAdError(str);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        synchronized (this.f1022a) {
            s b2 = i.b(str);
            if (b2 == null) {
                a.a.a.a.x.d.b("No SlotId found for sid:%s when destroyAd", str);
                return;
            }
            Map<s, f> map = this.f1022a.get(str);
            if (map == null) {
                a.a.a.a.x.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                return;
            }
            HashSet hashSet = new HashSet();
            for (s sVar : map.keySet()) {
                map.get(sVar).a();
                if (!b2.equals(sVar)) {
                    a.a.a.a.x.d.a("Remove redundant loader for sid:%s", str);
                    hashSet.add(sVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                map.remove((s) it.next());
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        f a2 = a(str);
        if (a2 == null) {
            a.a.a.a.x.d.a("No Loader found for sid:%s", str);
            return null;
        }
        return a2.a(context);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        f a2 = a(str);
        if (a2 == null) {
            a.a.a.a.x.d.a("No Loader found for sid:%s", str);
            return false;
        }
        return a2.b();
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        f a2 = a(funAdSlot.getSid());
        if (a2 != null) {
            a2.a(context, funAdSlot, funAdLoadListener);
            return;
        }
        a.a.a.a.x.d.a("No Loader found for sid:%s", funAdSlot.getSid());
        funAdLoadListener.onError(funAdSlot.getSid());
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        a(activity, str, funAdInteractionListener, viewGroup, null);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        a(activity, str, funAdInteractionListener, null, funNativeAdInflater);
    }
}

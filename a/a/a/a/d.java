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
public final class d implements FunAdFactory {

    /* renamed from: c  reason: collision with root package name */
    public static d f1018c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<q, e>> f1019a;

    /* renamed from: b  reason: collision with root package name */
    public final m f1020b;

    public d() {
        this.f1019a = new HashMap();
        this.f1020b = new m(new HashMap());
    }

    public d(m mVar) {
        this.f1019a = new HashMap();
        this.f1020b = mVar;
        f1018c = this;
    }

    public final e a(String str) {
        synchronized (this.f1019a) {
            q b2 = h.b(str);
            if (b2 == null) {
                return null;
            }
            Map<q, e> map = this.f1019a.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f1019a.put(str, map);
            }
            e eVar = map.get(b2);
            if (eVar == null) {
                eVar = b2.f1081a.a(this.f1020b);
                map.put(b2, eVar);
            }
            return eVar;
        }
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        e a2 = a(str);
        if (a2 != null) {
            a2.a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater);
            return;
        }
        a.a.a.a.v.d.a("No Loader found for sid:%s", str);
        funAdInteractionListener.onAdError(str);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        synchronized (this.f1019a) {
            q b2 = h.b(str);
            if (b2 == null) {
                a.a.a.a.v.d.b("No SlotId found for sid:%s when destroyAd", str);
                return;
            }
            Map<q, e> map = this.f1019a.get(str);
            if (map == null) {
                a.a.a.a.v.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                return;
            }
            HashSet hashSet = new HashSet();
            for (q qVar : map.keySet()) {
                map.get(qVar).a();
                if (!b2.equals(qVar)) {
                    a.a.a.a.v.d.a("Remove redundant loader for sid:%s", str);
                    hashSet.add(qVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                map.remove((q) it.next());
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        e a2 = a(str);
        if (a2 == null) {
            a.a.a.a.v.d.a("No Loader found for sid:%s", str);
            return null;
        }
        return a2.a(context);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        e a2 = a(str);
        if (a2 == null) {
            a.a.a.a.v.d.a("No Loader found for sid:%s", str);
            return false;
        }
        return a2.b();
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        e a2 = a(funAdSlot.getSid());
        if (a2 != null) {
            a2.a(context, funAdSlot, funAdLoadListener);
            return;
        }
        a.a.a.a.v.d.a("No Loader found for sid:%s", funAdSlot.getSid());
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

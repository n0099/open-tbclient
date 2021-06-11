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
public final class f implements FunAdFactory {

    /* renamed from: c  reason: collision with root package name */
    public static f f1023c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<t, g>> f1024a;

    /* renamed from: b  reason: collision with root package name */
    public final p f1025b;

    public f() {
        this.f1024a = new HashMap();
        this.f1025b = new p(new HashMap());
    }

    public f(p pVar) {
        this.f1024a = new HashMap();
        this.f1025b = pVar;
        f1023c = this;
    }

    public final g a(String str) {
        synchronized (this.f1024a) {
            t b2 = j.b(str);
            if (b2 == null) {
                return null;
            }
            Map<t, g> map = this.f1024a.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f1024a.put(str, map);
            }
            g gVar = map.get(b2);
            if (gVar == null) {
                gVar = b2.f1099a.a(this.f1025b);
                map.put(b2, gVar);
            }
            return gVar;
        }
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        g a2 = a(str);
        if (a2 != null) {
            a2.a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater);
            return;
        }
        a.a.a.a.y.d.a("No Loader found for sid:%s", str);
        funAdInteractionListener.onAdError(str);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        synchronized (this.f1024a) {
            t b2 = j.b(str);
            if (b2 == null) {
                a.a.a.a.y.d.b("No SlotId found for sid:%s when destroyAd", str);
                return;
            }
            Map<t, g> map = this.f1024a.get(str);
            if (map == null) {
                a.a.a.a.y.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                return;
            }
            HashSet hashSet = new HashSet();
            for (t tVar : map.keySet()) {
                map.get(tVar).a();
                if (!b2.equals(tVar)) {
                    a.a.a.a.y.d.a("Remove redundant loader for sid:%s", str);
                    hashSet.add(tVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                map.remove((t) it.next());
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        g a2 = a(str);
        if (a2 == null) {
            a.a.a.a.y.d.a("No Loader found for sid:%s", str);
            return null;
        }
        return a2.a(context);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        g a2 = a(str);
        if (a2 == null) {
            a.a.a.a.y.d.a("No Loader found for sid:%s", str);
            return false;
        }
        return a2.b();
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        g a2 = a(funAdSlot.getSid());
        if (a2 != null) {
            a2.a(context, funAdSlot, funAdLoadListener);
            return;
        }
        a.a.a.a.y.d.a("No Loader found for sid:%s", funAdSlot.getSid());
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

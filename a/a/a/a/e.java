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
/* loaded from: classes4.dex */
public final class e implements FunAdFactory {
    public static e zr;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Map<r, f>> f961a;
    public final n zs;

    public e() {
        this.f961a = new HashMap();
        this.zs = new n(new HashMap());
    }

    public e(n nVar) {
        this.f961a = new HashMap();
        this.zs = nVar;
        zr = this;
    }

    public final void a(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, ViewGroup viewGroup, FunNativeAdInflater funNativeAdInflater) {
        f aZ = aZ(str);
        if (aZ != null) {
            aZ.a(activity, viewGroup, str, funAdInteractionListener, funNativeAdInflater);
            return;
        }
        a.a.a.a.v.d.a("No Loader found for sid:%s", str);
        funAdInteractionListener.onAdError(str);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        synchronized (this.f961a) {
            r ba = i.ba(str);
            if (ba == null) {
                a.a.a.a.v.d.b("No SlotId found for sid:%s when destroyAd", str);
                return;
            }
            Map<r, f> map = this.f961a.get(str);
            if (map == null) {
                a.a.a.a.v.d.b("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                return;
            }
            HashSet hashSet = new HashSet();
            for (r rVar : map.keySet()) {
                map.get(rVar).a();
                if (!ba.equals(rVar)) {
                    a.a.a.a.v.d.a("Remove redundant loader for sid:%s", str);
                    hashSet.add(rVar);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                map.remove((r) it.next());
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd getNativeAd(Context context, String str) {
        f aZ = aZ(str);
        if (aZ == null) {
            a.a.a.a.v.d.a("No Loader found for sid:%s", str);
            return null;
        }
        return aZ.F(context);
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        f aZ = aZ(str);
        if (aZ == null) {
            a.a.a.a.v.d.a("No Loader found for sid:%s", str);
            return false;
        }
        return aZ.b();
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        f aZ = aZ(funAdSlot.getSid());
        if (aZ != null) {
            aZ.a(context, funAdSlot, funAdLoadListener);
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

    public final f aZ(String str) {
        HashMap hashMap;
        f fVar;
        synchronized (this.f961a) {
            r ba = i.ba(str);
            if (ba == null) {
                fVar = null;
            } else {
                Map<r, f> map = this.f961a.get(str);
                if (map == null) {
                    HashMap hashMap2 = new HashMap();
                    this.f961a.put(str, hashMap2);
                    hashMap = hashMap2;
                } else {
                    hashMap = map;
                }
                fVar = hashMap.get(ba);
                if (fVar == null) {
                    fVar = ba.zP.a(this.zs);
                    hashMap.put(ba, fVar);
                }
            }
        }
        return fVar;
    }
}

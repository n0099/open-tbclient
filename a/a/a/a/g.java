package a.a.a.a;

import a.a.a.a.a.d;
import a.a.a.a.a.e;
import a.a.a.a.v.f.g.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes4.dex */
public final class g implements f {
    public final Map<e.a, l> c;
    public final a.a.a.a.a.d zt;
    public final a.a.a.a.v.f.g.d zu;
    public c zv;
    public FunAdInteractionListener zw;

    /* renamed from: a  reason: collision with root package name */
    public final Random f962a = new Random();
    public final Handler g = new a(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            int i = message.what;
            if (i == 100) {
                c cVar = (c) message.obj;
                c cVar2 = g.this.zv;
                if (cVar2 != null && cVar2 == cVar && (funAdLoadListener = cVar.zA) != null) {
                    a.a.a.a.a.d dVar = g.this.zt;
                    a.a.a.a.v.d.b("callback onError(%s) because of timeout(%d)", dVar.b, Long.valueOf(dVar.d));
                    funAdLoadListener.onError(g.this.zt.b);
                    cVar.zA = null;
                }
            } else if (i == 101) {
                c cVar3 = (c) message.obj;
                c cVar4 = g.this.zv;
                if (cVar4 == null || cVar4 != cVar3) {
                    return;
                }
                synchronized (cVar3) {
                    if (cVar3.c) {
                        cVar3.a(cVar3.zA);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ FunAdInteractionListener zy;

        public b(FunAdInteractionListener funAdInteractionListener) {
            this.zy = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zy.onAdError(g.this.zt.b);
        }
    }

    public g(a.a.a.a.a.d dVar, n nVar) {
        this.zt = dVar;
        this.zu = new d.b(dVar.b);
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.zt.e) {
            for (d.a aVar : bVar.c) {
                l b2 = nVar.b(aVar.BG);
                if (b2 != null) {
                    b2.a(new d(aVar));
                    hashMap.put(aVar.BG, b2);
                }
            }
        }
        this.c = Collections.unmodifiableMap(hashMap);
    }

    @Override // a.a.a.a.f
    public FunNativeAd F(Context context) {
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        l b2 = b(z, arrayList);
        while (b2 != null) {
            FunNativeAd nativeAd = b2.getNativeAd(context, this.zt.b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(b2);
            b2 = b(z, arrayList);
        }
        a.a.a.a.v.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.zt.b);
        return null;
    }

    public final l a(d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return this.c.get(aVar.BG);
    }

    @Override // a.a.a.a.f
    public synchronized void a() {
        this.g.removeMessages(100);
        this.zw = null;
        c cVar = this.zv;
        if (cVar != null) {
            cVar.zA = null;
            this.zv = null;
        }
        for (l lVar : this.c.values()) {
            lVar.a();
        }
    }

    @Override // a.a.a.a.f
    public boolean b() {
        for (l lVar : this.c.values()) {
            if (lVar.c()) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public class d implements m {
        public final d.a zC;

        public d(d.a aVar) {
            this.zC = aVar;
        }

        @Override // a.a.a.a.m
        public void a(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdShowError(str2, aVar.d, aVar.c, aVar.BI.b, i, str);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(gVar.zt.b);
            }
        }

        @Override // a.a.a.a.m
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdLoad(str, aVar.d, aVar.c, aVar.BI.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdClicked(str, aVar.d, aVar.c, aVar.BI.b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(gVar.zt.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdClose(str, aVar.d, aVar.c, aVar.BI.b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(gVar.zt.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdShow(str, aVar.d, aVar.c, aVar.BI.b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(gVar.zt.b);
            }
        }

        @Override // a.a.a.a.m
        public void onError(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdLoadError(str2, aVar.d, aVar.c, aVar.BI.b, i, str);
            }
            c cVar = g.this.zv;
            if (cVar != null) {
                cVar.a(this.zC, i, str);
            }
        }

        @Override // a.a.a.a.m
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onAdLoaded(str, aVar.d, aVar.c, aVar.BI.b);
            }
            c cVar = g.this.zv;
            if (cVar != null) {
                cVar.b(this.zC);
            }
        }

        @Override // a.a.a.a.m
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.zt.b;
                e.a aVar = this.zC.BG;
                adCallback.onRewardedVideo(str, aVar.d, aVar.c, aVar.BI.b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(gVar.zt.b);
            }
        }
    }

    @Override // a.a.a.a.f
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        ArrayList arrayList;
        boolean z;
        boolean z2;
        l a2;
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.zu.a();
        this.g.removeMessages(101);
        this.g.removeMessages(100);
        a.a.a.a.a.d dVar = this.zt;
        if (dVar == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (d.b bVar : dVar.e) {
                d.a aVar = (d.a) a.a.a.a.a.a(this.f962a, bVar.c, null);
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList2, new h(this));
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            a.a.a.a.v.d.b("No selected adIds found for sid:%s", dVar.b);
            funAdLoadListener.onError(dVar.b);
        } else {
            c cVar = new c(funAdLoadListener, arrayList);
            this.zv = cVar;
            cVar.b = System.currentTimeMillis();
            Message obtainMessage = g.this.g.obtainMessage(100);
            obtainMessage.obj = cVar;
            g gVar = g.this;
            gVar.g.sendMessageDelayed(obtainMessage, gVar.zt.d);
            g gVar2 = g.this;
            if (gVar2.zt.c > 0) {
                Message obtainMessage2 = gVar2.g.obtainMessage(101);
                obtainMessage2.obj = cVar;
                g gVar3 = g.this;
                gVar3.g.sendMessageDelayed(obtainMessage2, gVar3.zt.c);
            }
            a.a.a.a.v.d.a("Start load for sid:%s", dVar.b);
            for (int i = 0; i < arrayList.size(); i++) {
                d.a aVar2 = (d.a) arrayList.get(i);
                l a3 = a(aVar2);
                if (a3 == null) {
                    z = true;
                } else if (a3.c()) {
                    this.zv.b(aVar2);
                } else {
                    a3.b(context, funAdSlot);
                    z = false;
                }
                Iterator<d.a> it = aVar2.BH.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = z;
                        break;
                    }
                    d.a next = it.next();
                    if (next != aVar2 && (a2 = a(next)) != null && a2.c()) {
                        this.zv.b(next);
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    this.zv.a(aVar2, 0, "F1:No ready loader found");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b> f963a = new ArrayList();
        public long b;
        public boolean c;
        public FunAdLoadListener zA;

        public c(FunAdLoadListener funAdLoadListener, List<d.a> list) {
            this.zA = funAdLoadListener;
            for (d.a aVar : list) {
                this.f963a.add(aVar.BH);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            if (funAdLoadListener != null) {
                funAdLoadListener.onAdLoaded(g.this.zt.b);
                this.zA = null;
                g.this.g.removeMessages(100);
                g.this.g.removeMessages(101);
            }
        }

        public synchronized void b(d.a aVar) {
            d.b bVar;
            int indexOf;
            this.c = true;
            e.a aVar2 = aVar.BG;
            a.a.a.a.v.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.BH.b), aVar2.d, aVar2.c);
            FunAdLoadListener funAdLoadListener = this.zA;
            if (funAdLoadListener != null && !this.f963a.isEmpty() && (indexOf = this.f963a.indexOf((bVar = aVar.BH))) >= 0) {
                this.f963a.remove(indexOf);
                if (g.this.zt.c > 0 && System.currentTimeMillis() - this.b < g.this.zt.c) {
                    while (true) {
                        int i = indexOf - 1;
                        if (i < 0) {
                            a.a.a.a.v.d.a("callback onAdLoaded(%s) because max priority adId is loaded.", g.this.zt.b);
                            a(funAdLoadListener);
                            break;
                        } else if (this.f963a.get(i).b != bVar.b) {
                            break;
                        } else {
                            indexOf = i;
                        }
                    }
                } else {
                    a(funAdLoadListener);
                }
            }
        }

        public synchronized void a(d.a aVar, int i, String str) {
            e.a aVar2 = aVar.BG;
            a.a.a.a.v.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i), str, Integer.valueOf(aVar.BH.b), aVar2.d, aVar2.c);
            this.f963a.remove(aVar.BH);
            FunAdLoadListener funAdLoadListener = this.zA;
            if (funAdLoadListener != null && this.f963a.isEmpty()) {
                a.a.a.a.v.d.b("callback onError(%s) as all group failed to load", g.this.zt.b);
                funAdLoadListener.onError(g.this.zt.b);
                this.zA = null;
            }
        }
    }

    public final l b(boolean z, List<l> list) {
        a.a.a.a.c.p hr;
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.zt.e) {
            for (d.a aVar : bVar.c) {
                l a2 = a(aVar);
                if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((hr = a2.hr()) != null && hr.f960a))) {
                    List list2 = (List) hashMap.get(bVar);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(bVar, list2);
                    }
                    list2.add(aVar);
                }
            }
        }
        return a((d.a) a.a.a.a.a.a(this.f962a, (List) hashMap.get((d.b) a.a.a.a.a.a(this.f962a, new ArrayList(hashMap.keySet()), null)), null));
    }

    @Override // a.a.a.a.f
    public <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.zu.a("ldr_sh_start");
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        l b2 = b(z, arrayList);
        this.zw = funAdInteractionListener;
        while (b2 != null) {
            if (b2.a(activity, t, str, funNativeAdInflater)) {
                return;
            }
            arrayList.add(b2);
            b2 = b(z, arrayList);
        }
        a.a.a.a.v.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.zt.b);
        this.g.post(new b(funAdInteractionListener));
    }
}

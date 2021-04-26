package a.a.a.a;

import a.a.a.a.u.d;
import a.a.a.a.u.e;
import a.a.a.a.x.f.g.d;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.u.d f1025b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.a, m> f1026c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.x.f.g.d f1027d;

    /* renamed from: e  reason: collision with root package name */
    public c f1028e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1029f;

    /* renamed from: a  reason: collision with root package name */
    public final Random f1024a = new Random();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1030g = new a(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            int i2 = message.what;
            boolean z = false;
            if (i2 == 100) {
                c cVar = (c) message.obj;
                c cVar2 = g.this.f1028e;
                if (cVar2 == null || cVar2 != cVar || (funAdLoadListener = cVar.f1036c) == null) {
                    return;
                }
                a.a.a.a.u.d dVar = g.this.f1025b;
                a.a.a.a.x.d.b("callback onError(%s) because of timeout(%d)", dVar.f1320b, Long.valueOf(dVar.f1322d));
                funAdLoadListener.onError(g.this.f1025b.f1320b);
                cVar.a();
            } else if (i2 == 101) {
                c cVar3 = (c) message.obj;
                c cVar4 = g.this.f1028e;
                if (cVar4 == null || cVar4 != cVar3) {
                    return;
                }
                synchronized (cVar3) {
                    synchronized (cVar3) {
                        Iterator<Map.Entry<d.b, Integer>> it = cVar3.f1034a.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (it.next().getValue().intValue() == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
                if (z) {
                    cVar3.a(cVar3.f1036c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1032a;

        public b(FunAdInteractionListener funAdInteractionListener) {
            this.f1032a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1032a.onAdError(g.this.f1025b.f1320b);
        }
    }

    public g(a.a.a.a.u.d dVar, o oVar) {
        this.f1025b = dVar;
        this.f1027d = new d.c(dVar.f1320b);
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1025b.f1323e) {
            for (d.a aVar : bVar.f1329c) {
                m a2 = oVar.a(aVar.f1326d);
                if (a2 != null) {
                    a2.a(new d(aVar));
                    hashMap.put(aVar.f1326d, a2);
                }
            }
        }
        this.f1026c = Collections.unmodifiableMap(hashMap);
    }

    public final m a(d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return this.f1026c.get(aVar.f1326d);
    }

    @Override // a.a.a.a.f
    public FunNativeAd a(Context context) {
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            m a2 = a(z, arrayList);
            if (a2 == null) {
                a.a.a.a.x.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.f1025b.f1320b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1025b.f1320b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // a.a.a.a.f
    public synchronized void a() {
        this.f1030g.removeMessages(100);
        this.f1029f = null;
        c cVar = this.f1028e;
        if (cVar != null) {
            cVar.a();
            this.f1028e = null;
        }
        for (m mVar : this.f1026c.values()) {
            mVar.a();
        }
    }

    @Override // a.a.a.a.f
    public <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.f1027d.c();
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        m a2 = a(z, arrayList);
        this.f1029f = funAdInteractionListener;
        while (a2 != null) {
            if (a2.a(activity, t, str, funNativeAdInflater)) {
                return;
            }
            arrayList.add(a2);
            a2 = a(z, arrayList);
        }
        a.a.a.a.x.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1025b.f1320b);
        this.f1030g.post(new b(funAdInteractionListener));
    }

    @Override // a.a.a.a.f
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        m a2;
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.f1027d.b();
        this.f1030g.removeMessages(101);
        this.f1030g.removeMessages(100);
        a.a.a.a.u.d dVar = this.f1025b;
        ArrayList arrayList = null;
        if (dVar != null) {
            ArrayList arrayList2 = new ArrayList();
            for (d.b bVar : dVar.f1323e) {
                d.a aVar = (d.a) a.a.a.a.a.a(this.f1024a, bVar.f1329c, null);
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList2, new h(this));
            arrayList = arrayList2;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            c cVar = new c(funAdLoadListener, arrayList);
            this.f1028e = cVar;
            cVar.f1035b = System.currentTimeMillis();
            Message obtainMessage = g.this.f1030g.obtainMessage(100);
            obtainMessage.obj = cVar;
            g gVar = g.this;
            gVar.f1030g.sendMessageDelayed(obtainMessage, gVar.f1025b.f1322d);
            g gVar2 = g.this;
            if (gVar2.f1025b.f1321c > 0) {
                Message obtainMessage2 = gVar2.f1030g.obtainMessage(101);
                obtainMessage2.obj = cVar;
                g gVar3 = g.this;
                gVar3.f1030g.sendMessageDelayed(obtainMessage2, gVar3.f1025b.f1321c);
            }
            a.a.a.a.x.d.a("Start load for sid:%s", dVar.f1320b);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.a aVar2 = (d.a) arrayList.get(i2);
                m a3 = a(aVar2);
                if (a3 == null) {
                    z = true;
                } else if (a3.c()) {
                    cVar.a(aVar2);
                } else {
                    a3.a(context, funAdSlot);
                    z = false;
                }
                Iterator<d.a> it = aVar2.f1327e.f1329c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.a next = it.next();
                    if (next != aVar2 && (a2 = a(next)) != null && a2.c()) {
                        cVar.a(next);
                        z = false;
                        break;
                    }
                }
                if (z) {
                    cVar.a(aVar2, 0, "F1:No ready loader found");
                }
            }
            return;
        }
        a.a.a.a.x.d.b("No selected adIds found for sid:%s", dVar.f1320b);
        funAdLoadListener.onError(dVar.f1320b);
    }

    @Override // a.a.a.a.f
    public boolean b() {
        for (m mVar : this.f1026c.values()) {
            if (mVar.c()) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<d.b, Integer> f1034a = new LinkedHashMap<>();

        /* renamed from: b  reason: collision with root package name */
        public long f1035b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f1036c;

        public c(FunAdLoadListener funAdLoadListener, List<d.a> list) {
            this.f1036c = funAdLoadListener;
            for (d.a aVar : list) {
                this.f1034a.put(aVar.f1327e, 0);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            if (funAdLoadListener != null) {
                funAdLoadListener.onAdLoaded(g.this.f1025b.f1320b);
                a();
            }
        }

        public final synchronized void b(FunAdLoadListener funAdLoadListener) {
            boolean z = true;
            int i2 = -1;
            for (Map.Entry<d.b, Integer> entry : this.f1034a.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue != -1) {
                    d.b key = entry.getKey();
                    if (i2 < 0) {
                        i2 = key.f1328b;
                    } else if (i2 != key.f1328b) {
                        return;
                    }
                    if (intValue != 0) {
                        if (intValue == 1) {
                            a.a.a.a.x.d.a("callback onAdLoaded(%s) because max priority adId is loaded", g.this.f1025b.f1320b);
                            a(funAdLoadListener);
                            return;
                        }
                        throw new IllegalStateException("Unknown value:" + intValue);
                    }
                    z = false;
                }
            }
            if (z) {
                a.a.a.a.x.d.b("callback onError(%s) as all group failed to load", g.this.f1025b.f1320b);
                funAdLoadListener.onError(g.this.f1025b.f1320b);
            }
        }

        public synchronized void a(d.a aVar) {
            e.a aVar2 = aVar.f1326d;
            a.a.a.a.x.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1327e.f1328b), aVar2.f1335d, aVar2.f1334c);
            FunAdLoadListener funAdLoadListener = this.f1036c;
            if (funAdLoadListener == null) {
                return;
            }
            d.b bVar = aVar.f1327e;
            if (this.f1034a.containsKey(bVar)) {
                this.f1034a.put(bVar, 1);
                if (g.this.f1025b.f1321c > 0 && System.currentTimeMillis() - this.f1035b < g.this.f1025b.f1321c) {
                    b(funAdLoadListener);
                    return;
                }
                a(funAdLoadListener);
            }
        }

        public synchronized void a(d.a aVar, int i2, String str) {
            e.a aVar2 = aVar.f1326d;
            a.a.a.a.x.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f1327e.f1328b), aVar2.f1335d, aVar2.f1334c);
            if (this.f1034a.containsKey(aVar.f1327e)) {
                this.f1034a.put(aVar.f1327e, -1);
                FunAdLoadListener funAdLoadListener = this.f1036c;
                if (funAdLoadListener == null) {
                    return;
                }
                b(funAdLoadListener);
            }
        }

        public void a() {
            this.f1036c = null;
            g.this.f1030g.removeMessages(100, this);
            g.this.f1030g.removeMessages(101, this);
        }
    }

    /* loaded from: classes.dex */
    public class d implements n {

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1038a;

        public d(d.a aVar) {
            this.f1038a = aVar;
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdShowError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i2, str);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.f1029f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(gVar.f1025b.f1320b);
            }
        }

        @Override // a.a.a.a.n
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdLoad(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdClicked(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.f1029f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(gVar.f1025b.f1320b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdClose(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.f1029f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(gVar.f1025b.f1320b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdShow(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.f1029f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(gVar.f1025b.f1320b);
            }
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdLoadError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i2, str);
            }
            c cVar = g.this.f1028e;
            if (cVar != null) {
                cVar.a(this.f1038a, i2, str);
            }
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onAdLoaded(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            c cVar = g.this.f1028e;
            if (cVar != null) {
                cVar.a(this.f1038a);
            }
        }

        @Override // a.a.a.a.n
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = g.this.f1025b.f1320b;
                e.a aVar = this.f1038a.f1326d;
                adCallback.onRewardedVideo(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            g gVar = g.this;
            FunAdInteractionListener funAdInteractionListener = gVar.f1029f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(gVar.f1025b.f1320b);
            }
        }
    }

    public final m a(boolean z, List<m> list) {
        a.a.a.a.w.p d2;
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1025b.f1323e) {
            for (d.a aVar : bVar.f1329c) {
                m a2 = a(aVar);
                if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((d2 = a2.d()) != null && d2.f1358a))) {
                    List list2 = (List) hashMap.get(bVar);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(bVar, list2);
                    }
                    list2.add(aVar);
                }
            }
        }
        return a((d.a) a.a.a.a.a.a(this.f1024a, (List) hashMap.get((d.b) a.a.a.a.a.a(this.f1024a, new ArrayList(hashMap.keySet()), null)), null));
    }
}

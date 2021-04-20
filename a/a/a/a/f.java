package a.a.a.a;

import a.a.a.a.s.d;
import a.a.a.a.s.e;
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
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.s.d f1022b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.a, k> f1023c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.v.f.g.d f1024d;

    /* renamed from: e  reason: collision with root package name */
    public c f1025e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1026f;

    /* renamed from: a  reason: collision with root package name */
    public final Random f1021a = new Random();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1027g = new a(Looper.getMainLooper());

    /* loaded from: classes.dex */
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
                c cVar2 = f.this.f1025e;
                if (cVar2 == null || cVar2 != cVar || (funAdLoadListener = cVar.f1034d) == null) {
                    return;
                }
                a.a.a.a.s.d dVar = f.this.f1022b;
                a.a.a.a.v.d.b("callback onError(%s) because of timeout(%d)", dVar.f1306b, Long.valueOf(dVar.f1308d));
                funAdLoadListener.onError(f.this.f1022b.f1306b);
                cVar.a();
            } else if (i == 101) {
                c cVar3 = (c) message.obj;
                c cVar4 = f.this.f1025e;
                if (cVar4 == null || cVar4 != cVar3) {
                    return;
                }
                synchronized (cVar3) {
                    if (cVar3.f1033c) {
                        cVar3.a(cVar3.f1034d);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1029a;

        public b(FunAdInteractionListener funAdInteractionListener) {
            this.f1029a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1029a.onAdError(f.this.f1022b.f1306b);
        }
    }

    public f(a.a.a.a.s.d dVar, m mVar) {
        this.f1022b = dVar;
        this.f1024d = new d.c(dVar.f1306b);
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1022b.f1309e) {
            for (d.a aVar : bVar.f1315c) {
                k a2 = mVar.a(aVar.f1312d);
                if (a2 != null) {
                    a2.a(new d(aVar));
                    hashMap.put(aVar.f1312d, a2);
                }
            }
        }
        this.f1023c = Collections.unmodifiableMap(hashMap);
    }

    public final k a(d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return this.f1023c.get(aVar.f1312d);
    }

    @Override // a.a.a.a.e
    public FunNativeAd a(Context context) {
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            k a2 = a(z, arrayList);
            if (a2 == null) {
                a.a.a.a.v.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.f1022b.f1306b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1022b.f1306b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // a.a.a.a.e
    public synchronized void a() {
        this.f1027g.removeMessages(100);
        this.f1026f = null;
        c cVar = this.f1025e;
        if (cVar != null) {
            cVar.a();
            this.f1025e = null;
        }
        for (k kVar : this.f1023c.values()) {
            kVar.a();
        }
    }

    @Override // a.a.a.a.e
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        k a2;
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.f1024d.a();
        this.f1027g.removeMessages(101);
        this.f1027g.removeMessages(100);
        a.a.a.a.s.d dVar = this.f1022b;
        ArrayList arrayList = null;
        if (dVar != null) {
            ArrayList arrayList2 = new ArrayList();
            for (d.b bVar : dVar.f1309e) {
                d.a aVar = (d.a) a.a.a.a.a.a(this.f1021a, bVar.f1315c, null);
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList2, new g(this));
            arrayList = arrayList2;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            c cVar = new c(funAdLoadListener, arrayList);
            this.f1025e = cVar;
            cVar.f1032b = System.currentTimeMillis();
            Message obtainMessage = f.this.f1027g.obtainMessage(100);
            obtainMessage.obj = cVar;
            f fVar = f.this;
            fVar.f1027g.sendMessageDelayed(obtainMessage, fVar.f1022b.f1308d);
            f fVar2 = f.this;
            if (fVar2.f1022b.f1307c > 0) {
                Message obtainMessage2 = fVar2.f1027g.obtainMessage(101);
                obtainMessage2.obj = cVar;
                f fVar3 = f.this;
                fVar3.f1027g.sendMessageDelayed(obtainMessage2, fVar3.f1022b.f1307c);
            }
            a.a.a.a.v.d.a("Start load for sid:%s", dVar.f1306b);
            for (int i = 0; i < arrayList.size(); i++) {
                d.a aVar2 = (d.a) arrayList.get(i);
                k a3 = a(aVar2);
                if (a3 == null) {
                    z = true;
                } else if (a3.c()) {
                    cVar.a(aVar2);
                } else {
                    a3.a(context, funAdSlot);
                    z = false;
                }
                Iterator<d.a> it = aVar2.f1313e.f1315c.iterator();
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
        a.a.a.a.v.d.b("No selected adIds found for sid:%s", dVar.f1306b);
        funAdLoadListener.onError(dVar.f1306b);
    }

    @Override // a.a.a.a.e
    public boolean b() {
        for (k kVar : this.f1023c.values()) {
            if (kVar.c()) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<d.b> f1031a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public long f1032b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1033c;

        /* renamed from: d  reason: collision with root package name */
        public FunAdLoadListener f1034d;

        public c(FunAdLoadListener funAdLoadListener, List<d.a> list) {
            this.f1034d = funAdLoadListener;
            for (d.a aVar : list) {
                this.f1031a.add(aVar.f1313e);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            if (funAdLoadListener != null) {
                funAdLoadListener.onAdLoaded(f.this.f1022b.f1306b);
                a();
            }
        }

        public synchronized void a(d.a aVar) {
            this.f1033c = true;
            e.a aVar2 = aVar.f1312d;
            a.a.a.a.v.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1313e.f1314b), aVar2.f1321d, aVar2.f1320c);
            FunAdLoadListener funAdLoadListener = this.f1034d;
            if (funAdLoadListener == null) {
                return;
            }
            if (this.f1031a.isEmpty()) {
                return;
            }
            d.b bVar = aVar.f1313e;
            int indexOf = this.f1031a.indexOf(bVar);
            if (indexOf < 0) {
                return;
            }
            this.f1031a.remove(indexOf);
            if (f.this.f1022b.f1307c > 0 && System.currentTimeMillis() - this.f1032b < f.this.f1022b.f1307c) {
                do {
                    indexOf--;
                    if (indexOf < 0) {
                        a.a.a.a.v.d.a("callback onAdLoaded(%s) because max priority adId is loaded.", f.this.f1022b.f1306b);
                        a(funAdLoadListener);
                        return;
                    }
                } while (this.f1031a.get(indexOf).f1314b == bVar.f1314b);
                return;
            }
            a(funAdLoadListener);
        }

        public synchronized void a(d.a aVar, int i, String str) {
            e.a aVar2 = aVar.f1312d;
            a.a.a.a.v.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i), str, Integer.valueOf(aVar.f1313e.f1314b), aVar2.f1321d, aVar2.f1320c);
            this.f1031a.remove(aVar.f1313e);
            FunAdLoadListener funAdLoadListener = this.f1034d;
            if (funAdLoadListener != null && this.f1031a.isEmpty()) {
                if (this.f1033c) {
                    f.this.f1027g.removeMessages(101);
                    a(funAdLoadListener);
                    return;
                }
                a.a.a.a.v.d.b("callback onError(%s) as all group failed to load", f.this.f1022b.f1306b);
                funAdLoadListener.onError(f.this.f1022b.f1306b);
                a();
            }
        }

        public void a() {
            this.f1034d = null;
            f.this.f1027g.removeMessages(100, this);
            f.this.f1027g.removeMessages(101, this);
        }
    }

    /* loaded from: classes.dex */
    public class d implements l {

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1036a;

        public d(d.a aVar) {
            this.f1036a = aVar;
        }

        @Override // a.a.a.a.l
        public void a(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdShowError(str2, aVar.f1321d, aVar.f1320c, aVar.k.f1316b, i, str);
            }
            f fVar = f.this;
            FunAdInteractionListener funAdInteractionListener = fVar.f1026f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(fVar.f1022b.f1306b);
            }
        }

        @Override // a.a.a.a.l
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdLoad(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdClicked(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
            f fVar = f.this;
            FunAdInteractionListener funAdInteractionListener = fVar.f1026f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(fVar.f1022b.f1306b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdClose(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
            f fVar = f.this;
            FunAdInteractionListener funAdInteractionListener = fVar.f1026f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(fVar.f1022b.f1306b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdShow(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
            f fVar = f.this;
            FunAdInteractionListener funAdInteractionListener = fVar.f1026f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(fVar.f1022b.f1306b);
            }
        }

        @Override // a.a.a.a.l
        public void onError(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdLoadError(str2, aVar.f1321d, aVar.f1320c, aVar.k.f1316b, i, str);
            }
            c cVar = f.this.f1025e;
            if (cVar != null) {
                cVar.a(this.f1036a, i, str);
            }
        }

        @Override // a.a.a.a.l
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onAdLoaded(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
            c cVar = f.this.f1025e;
            if (cVar != null) {
                cVar.a(this.f1036a);
            }
        }

        @Override // a.a.a.a.l
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = f.this.f1022b.f1306b;
                e.a aVar = this.f1036a.f1312d;
                adCallback.onRewardedVideo(str, aVar.f1321d, aVar.f1320c, aVar.k.f1316b);
            }
            f fVar = f.this;
            FunAdInteractionListener funAdInteractionListener = fVar.f1026f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(fVar.f1022b.f1306b);
            }
        }
    }

    public final k a(boolean z, List<k> list) {
        a.a.a.a.u.o d2;
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1022b.f1309e) {
            for (d.a aVar : bVar.f1315c) {
                k a2 = a(aVar);
                if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((d2 = a2.d()) != null && d2.f1343a))) {
                    List list2 = (List) hashMap.get(bVar);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(bVar, list2);
                    }
                    list2.add(aVar);
                }
            }
        }
        return a((d.a) a.a.a.a.a.a(this.f1021a, (List) hashMap.get((d.b) a.a.a.a.a.a(this.f1021a, new ArrayList(hashMap.keySet()), null)), null));
    }

    @Override // a.a.a.a.e
    public <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.f1024d.a("ldr_sh_start");
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        k a2 = a(z, arrayList);
        this.f1026f = funAdInteractionListener;
        while (a2 != null) {
            if (a2.a(activity, t, str, funNativeAdInflater)) {
                return;
            }
            arrayList.add(a2);
            a2 = a(z, arrayList);
        }
        a.a.a.a.v.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1022b.f1306b);
        this.f1027g.post(new b(funAdInteractionListener));
    }
}

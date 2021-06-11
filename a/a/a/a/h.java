package a.a.a.a;

import a.a.a.a.v.d;
import a.a.a.a.v.e;
import a.a.a.a.y.f.g.d;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
public final class h implements g {

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.v.d f1027b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.a, n> f1028c;

    /* renamed from: d  reason: collision with root package name */
    public final a.a.a.a.y.f.g.d f1029d;

    /* renamed from: f  reason: collision with root package name */
    public d f1031f;

    /* renamed from: g  reason: collision with root package name */
    public FunAdInteractionListener f1032g;

    /* renamed from: a  reason: collision with root package name */
    public final Random f1026a = new Random();

    /* renamed from: e  reason: collision with root package name */
    public final f f1030e = new c(this, null);

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1033h = new a(Looper.getMainLooper());

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
                d dVar = (d) message.obj;
                d dVar2 = h.this.f1031f;
                if (dVar2 == null || dVar2 != dVar || (funAdLoadListener = dVar.f1040c) == null) {
                    return;
                }
                a.a.a.a.v.d dVar3 = h.this.f1027b;
                a.a.a.a.y.d.b("callback onError(%s) because of timeout(%d)", dVar3.f1328b, Long.valueOf(dVar3.f1330d));
                funAdLoadListener.onError(h.this.f1027b.f1328b);
                dVar.a();
            } else if (i2 == 101) {
                d dVar4 = (d) message.obj;
                d dVar5 = h.this.f1031f;
                if (dVar5 == null || dVar5 != dVar4) {
                    return;
                }
                synchronized (dVar4) {
                    synchronized (dVar4) {
                        Iterator<Map.Entry<d.b, Integer>> it = dVar4.f1038a.entrySet().iterator();
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
                    dVar4.a(dVar4.f1040c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdInteractionListener f1035a;

        public b(FunAdInteractionListener funAdInteractionListener) {
            this.f1035a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1035a.onAdError(h.this.f1027b.f1328b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public c() {
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this();
        }

        public n a(boolean z, List<n> list) {
            a.a.a.a.x.p d2;
            HashMap hashMap = new HashMap();
            for (d.b bVar : h.this.f1027b.f1331e) {
                for (d.a aVar : bVar.f1337c) {
                    n a2 = h.this.a(aVar);
                    if (a2 != null && !list.contains(a2) && a2.c() && (!z || ((d2 = a2.d()) != null && d2.f1366a))) {
                        List list2 = (List) hashMap.get(bVar);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            hashMap.put(bVar, list2);
                        }
                        list2.add(aVar);
                    }
                }
            }
            return h.this.a((d.a) a.a.a.a.a.a(h.this.f1026a, (List) hashMap.get((d.b) a.a.a.a.a.a(h.this.f1026a, new ArrayList(hashMap.keySet()), (s<q>) null)), (s<q>) null));
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    public h(a.a.a.a.v.d dVar, p pVar) {
        this.f1027b = dVar;
        this.f1029d = new d.c(dVar.f1328b);
        HashMap hashMap = new HashMap();
        for (d.b bVar : this.f1027b.f1331e) {
            for (d.a aVar : bVar.f1337c) {
                n a2 = pVar.a(aVar.f1334d);
                if (a2 != null) {
                    a2.a(new e(aVar));
                    hashMap.put(aVar.f1334d, a2);
                }
            }
        }
        this.f1028c = Collections.unmodifiableMap(hashMap);
    }

    public final n a(d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return this.f1028c.get(aVar.f1334d);
    }

    @Override // a.a.a.a.g
    public FunNativeAd a(Context context) {
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        while (true) {
            n a2 = ((c) this.f1030e).a(z, arrayList);
            if (a2 == null) {
                a.a.a.a.y.d.b("getNativeAd for sid:%s with No ready pidLoader found", this.f1027b.f1328b);
                return null;
            }
            FunNativeAd nativeAd = a2.getNativeAd(context, this.f1027b.f1328b);
            if (nativeAd != null) {
                return nativeAd;
            }
            arrayList.add(a2);
        }
    }

    @Override // a.a.a.a.g
    public synchronized void a() {
        this.f1033h.removeMessages(100);
        this.f1032g = null;
        d dVar = this.f1031f;
        if (dVar != null) {
            dVar.a();
            this.f1031f = null;
        }
        for (n nVar : this.f1028c.values()) {
            nVar.a();
        }
    }

    @Override // a.a.a.a.g
    public <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.f1029d.c();
        boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
        ArrayList arrayList = new ArrayList();
        n a2 = ((c) this.f1030e).a(z, arrayList);
        this.f1032g = funAdInteractionListener;
        while (a2 != null) {
            if (a2.a(activity, t, str, funNativeAdInflater)) {
                return;
            }
            arrayList.add(a2);
            a2 = ((c) this.f1030e).a(z, arrayList);
        }
        a.a.a.a.y.d.b("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.f1027b.f1328b);
        this.f1033h.post(new b(funAdInteractionListener));
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        n a2;
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.f1029d.b();
        this.f1033h.removeMessages(101);
        this.f1033h.removeMessages(100);
        a.a.a.a.v.d dVar = this.f1027b;
        ArrayList arrayList = null;
        if (dVar != null) {
            ArrayList arrayList2 = new ArrayList();
            for (d.b bVar : dVar.f1331e) {
                d.a aVar = (d.a) a.a.a.a.a.a(this.f1026a, bVar.f1337c, (s<q>) null);
                if (aVar != null) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList2, new i(this));
            arrayList = arrayList2;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            d dVar2 = new d(funAdLoadListener, arrayList);
            this.f1031f = dVar2;
            dVar2.f1039b = System.currentTimeMillis();
            Message obtainMessage = h.this.f1033h.obtainMessage(100);
            obtainMessage.obj = dVar2;
            h hVar = h.this;
            hVar.f1033h.sendMessageDelayed(obtainMessage, hVar.f1027b.f1330d);
            h hVar2 = h.this;
            if (hVar2.f1027b.f1329c > 0) {
                Message obtainMessage2 = hVar2.f1033h.obtainMessage(101);
                obtainMessage2.obj = dVar2;
                h hVar3 = h.this;
                hVar3.f1033h.sendMessageDelayed(obtainMessage2, hVar3.f1027b.f1329c);
            }
            a.a.a.a.y.d.a("Start load for sid:%s", dVar.f1328b);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.a aVar2 = (d.a) arrayList.get(i2);
                n a3 = a(aVar2);
                if (a3 == null) {
                    z = true;
                } else if (a3.c()) {
                    dVar2.a(aVar2);
                } else {
                    a3.a(context, funAdSlot);
                    z = false;
                }
                Iterator<d.a> it = aVar2.f1335e.f1337c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.a next = it.next();
                    if (next != aVar2 && (a2 = a(next)) != null && a2.c()) {
                        dVar2.a(next);
                        z = false;
                        break;
                    }
                }
                if (z) {
                    dVar2.a(aVar2, 0, "F1:No ready loader found");
                }
            }
            return;
        }
        a.a.a.a.y.d.b("No selected adIds found for sid:%s", dVar.f1328b);
        funAdLoadListener.onError(dVar.f1328b);
    }

    @Override // a.a.a.a.g
    public boolean b() {
        for (n nVar : this.f1028c.values()) {
            if (nVar.c()) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<d.b, Integer> f1038a = new LinkedHashMap<>();

        /* renamed from: b  reason: collision with root package name */
        public long f1039b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdLoadListener f1040c;

        public d(FunAdLoadListener funAdLoadListener, List<d.a> list) {
            this.f1040c = funAdLoadListener;
            for (d.a aVar : list) {
                this.f1038a.put(aVar.f1335e, 0);
            }
        }

        public final void a(FunAdLoadListener funAdLoadListener) {
            if (funAdLoadListener != null) {
                funAdLoadListener.onAdLoaded(h.this.f1027b.f1328b);
                a();
            }
        }

        public final synchronized void b(FunAdLoadListener funAdLoadListener) {
            boolean z = true;
            int i2 = -1;
            for (Map.Entry<d.b, Integer> entry : this.f1038a.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue != -1) {
                    d.b key = entry.getKey();
                    if (i2 < 0) {
                        i2 = key.f1336b;
                    } else if (i2 != key.f1336b) {
                        return;
                    }
                    if (intValue != 0) {
                        if (intValue == 1) {
                            a.a.a.a.y.d.a("callback onAdLoaded(%s) because max priority adId is loaded", h.this.f1027b.f1328b);
                            a(funAdLoadListener);
                            return;
                        }
                        throw new IllegalStateException("Unknown value:" + intValue);
                    }
                    z = false;
                }
            }
            if (z) {
                a.a.a.a.y.d.b("callback onError(%s) as all group failed to load", h.this.f1027b.f1328b);
                funAdLoadListener.onError(h.this.f1027b.f1328b);
            }
        }

        public synchronized void a(d.a aVar) {
            e.a aVar2 = aVar.f1334d;
            a.a.a.a.y.d.a("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(aVar.f1335e.f1336b), aVar2.f1343d, aVar2.f1342c);
            FunAdLoadListener funAdLoadListener = this.f1040c;
            if (funAdLoadListener == null) {
                return;
            }
            d.b bVar = aVar.f1335e;
            if (this.f1038a.containsKey(bVar)) {
                this.f1038a.put(bVar, 1);
                if (h.this.f1027b.f1329c > 0 && System.currentTimeMillis() - this.f1039b < h.this.f1027b.f1329c) {
                    b(funAdLoadListener);
                    return;
                }
                a(funAdLoadListener);
            }
        }

        public synchronized void a(d.a aVar, int i2, String str) {
            e.a aVar2 = aVar.f1334d;
            a.a.a.a.y.d.a("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(aVar.f1335e.f1336b), aVar2.f1343d, aVar2.f1342c);
            if (this.f1038a.containsKey(aVar.f1335e)) {
                this.f1038a.put(aVar.f1335e, -1);
                FunAdLoadListener funAdLoadListener = this.f1040c;
                if (funAdLoadListener == null) {
                    return;
                }
                b(funAdLoadListener);
            }
        }

        public void a() {
            this.f1040c = null;
            h.this.f1033h.removeMessages(100, this);
            h.this.f1033h.removeMessages(101, this);
        }
    }

    /* loaded from: classes.dex */
    public class e implements o {

        /* renamed from: a  reason: collision with root package name */
        public final d.a f1042a;

        public e(d.a aVar) {
            this.f1042a = aVar;
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            h hVar = h.this;
            FunAdInteractionListener funAdInteractionListener = hVar.f1032g;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(hVar.f1027b.f1328b);
            }
        }

        @Override // a.a.a.a.o
        public void b() {
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            h hVar = h.this;
            FunAdInteractionListener funAdInteractionListener = hVar.f1032g;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(hVar.f1027b.f1328b);
            }
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            h hVar = h.this;
            FunAdInteractionListener funAdInteractionListener = hVar.f1032g;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(hVar.f1027b.f1328b);
            }
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            h hVar = h.this;
            FunAdInteractionListener funAdInteractionListener = hVar.f1032g;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(hVar.f1027b.f1328b);
            }
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            d dVar = h.this.f1031f;
            if (dVar != null) {
                dVar.a(this.f1042a, i2, str);
            }
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            d dVar = h.this.f1031f;
            if (dVar != null) {
                dVar.a(this.f1042a);
            }
        }

        @Override // a.a.a.a.o
        public void a() {
            h hVar = h.this;
            FunAdInteractionListener funAdInteractionListener = hVar.f1032g;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(hVar.f1027b.f1328b);
            }
        }
    }
}

package a.a.a.a;

import a.a.a.a.s.c;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.s.c f1046a;

    /* renamed from: b  reason: collision with root package name */
    public final a.a.a.a.v.f.g.d f1047b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<e.a, k> f1048c;

    /* renamed from: e  reason: collision with root package name */
    public c f1050e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1051f;

    /* renamed from: d  reason: collision with root package name */
    public final Random f1049d = new Random();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1052g = new a(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(i iVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 100) {
                return;
            }
            c cVar = (c) message.obj;
            if (cVar == null) {
                a.a.a.a.v.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
            } else {
                cVar.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements p<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1053a;

        public b(List list) {
            this.f1053a = list;
        }

        public boolean a(Object obj) {
            k kVar = i.this.f1048c.get(((c.a) obj).f1317d);
            List list = this.f1053a;
            return (list == null || !list.contains(kVar)) && kVar != null && kVar.c();
        }
    }

    public i(a.a.a.a.s.c cVar, m mVar) {
        this.f1046a = cVar;
        this.f1047b = new d.C0006d(cVar.f1313b);
        HashMap hashMap = new HashMap();
        for (c.b bVar : cVar.f1314c) {
            for (c.a aVar : bVar.f1319c) {
                k a2 = mVar.a(aVar.f1317d);
                if (a2 != null) {
                    a2.a(new d(aVar));
                    hashMap.put(aVar.f1317d, a2);
                }
            }
        }
        this.f1048c = Collections.unmodifiableMap(hashMap);
    }

    public final k a(c.b bVar, List<k> list) {
        c.a aVar = (c.a) a.a.a.a.a.a(this.f1049d, bVar.f1319c, new b(list));
        if (aVar == null) {
            return null;
        }
        return this.f1048c.get(aVar.f1317d);
    }

    @Override // a.a.a.a.e
    public FunNativeAd a(Context context) {
        for (c.b bVar : this.f1046a.f1314c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                k a2 = a(bVar, arrayList);
                if (a2 != null) {
                    FunNativeAd nativeAd = a2.getNativeAd(context, this.f1046a.f1313b);
                    if (nativeAd != null) {
                        return nativeAd;
                    }
                    arrayList.add(a2);
                }
            }
        }
        return null;
    }

    @Override // a.a.a.a.e
    public synchronized void a() {
        this.f1052g.removeMessages(100);
        c cVar = this.f1050e;
        if (cVar != null) {
            cVar.c();
        }
        this.f1050e = null;
        this.f1051f = null;
        for (c.b bVar : this.f1046a.f1314c) {
            for (c.a aVar : bVar.f1319c) {
                k kVar = this.f1048c.get(aVar.f1317d);
                if (kVar != null) {
                    kVar.a();
                }
            }
        }
    }

    @Override // a.a.a.a.e
    public synchronized <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.f1047b.a("ldr_sh_start");
        this.f1051f = funAdInteractionListener;
        for (c.b bVar : this.f1046a.f1314c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                k a2 = a(bVar, arrayList);
                if (a2 != null) {
                    if (a2.a(activity, t, str, funNativeAdInflater)) {
                        return;
                    }
                    arrayList.add(a2);
                }
            }
        }
        funAdInteractionListener.onAdError(this.f1046a.f1313b);
        this.f1051f = null;
        a.a.a.a.v.d.b("showFailed for SerialSlotId(%s), because no ready loader found", this.f1046a.f1313b);
    }

    @Override // a.a.a.a.e
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.f1052g.removeMessages(100);
        c cVar = this.f1050e;
        if (cVar != null) {
            cVar.c();
        }
        this.f1047b.a();
        if (this.f1046a.f1314c.isEmpty()) {
            a.a.a.a.v.d.b("No groups found in SerialSlotId(%s)", this.f1046a.f1313b);
            funAdLoadListener.onError(this.f1046a.f1313b);
            return;
        }
        c cVar2 = new c(context, funAdSlot, this.f1046a.f1314c.iterator(), funAdLoadListener);
        this.f1050e = cVar2;
        cVar2.b();
    }

    @Override // a.a.a.a.e
    public synchronized boolean b() {
        boolean z;
        Iterator<c.b> it = this.f1046a.f1314c.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            for (c.a aVar : it.next().f1319c) {
                k kVar = this.f1048c.get(aVar.f1317d);
                if (kVar != null && kVar.c()) {
                    z = true;
                    break loop0;
                }
            }
        }
        return z;
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1055a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1056b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<c.b> f1057c;

        /* renamed from: d  reason: collision with root package name */
        public FunAdLoadListener f1058d;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<c.a> f1059e = new HashSet<>();

        public c(Context context, FunAdSlot funAdSlot, Iterator<c.b> it, FunAdLoadListener funAdLoadListener) {
            this.f1058d = funAdLoadListener;
            this.f1055a = context;
            this.f1056b = funAdSlot;
            this.f1057c = it;
        }

        public final boolean a() {
            if (this.f1057c.hasNext() || !this.f1059e.isEmpty()) {
                return false;
            }
            if (this.f1058d != null) {
                a.a.a.a.v.d.a("All loader load failed, callback onError(%s)", i.this.f1046a.f1313b);
                this.f1058d.onError(i.this.f1046a.f1313b);
                c();
            }
            return true;
        }

        public void b() {
            synchronized (i.this) {
                if (i.this.f1050e != this) {
                    return;
                }
                if (this.f1058d == null) {
                    a.a.a.a.v.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                } else if (!a()) {
                    if (!this.f1057c.hasNext()) {
                        a.a.a.a.v.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                        return;
                    }
                    c.b next = this.f1057c.next();
                    if (next.f1319c.isEmpty()) {
                        a.a.a.a.v.d.b("There is an empty group in SerialSid(%s)", i.this.f1046a.f1313b);
                        b();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (c.a aVar : next.f1319c) {
                        k kVar = i.this.f1048c.get(aVar.f1317d);
                        if (kVar != null) {
                            this.f1059e.add(aVar);
                            if (kVar.c()) {
                                a(aVar);
                                return;
                            }
                            arrayList.add(kVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        a.a.a.a.v.d.b("No group which ready to load found in SerialSid(%s)", i.this.f1046a.f1313b);
                        b();
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).a(this.f1055a, this.f1056b);
                    }
                    i.this.f1052g.removeMessages(100);
                    i.this.f1052g.sendMessageDelayed(i.this.f1052g.obtainMessage(100, this), next.f1318b);
                }
            }
        }

        public void c() {
            synchronized (i.this) {
                this.f1058d = null;
                this.f1059e.clear();
                if (i.this.f1050e == this) {
                    i.this.f1050e = null;
                }
            }
        }

        public void a(c.a aVar) {
            synchronized (i.this) {
                if (i.this.f1050e != this) {
                    return;
                }
                FunAdLoadListener funAdLoadListener = this.f1058d;
                if (funAdLoadListener == null) {
                    return;
                }
                if (this.f1059e.remove(aVar)) {
                    funAdLoadListener.onAdLoaded(i.this.f1046a.f1313b);
                    c();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements l {

        /* renamed from: a  reason: collision with root package name */
        public final c.a f1061a;

        public d(c.a aVar) {
            this.f1061a = aVar;
        }

        @Override // a.a.a.a.l
        public void a(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdShowError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i, str);
            }
            i iVar = i.this;
            FunAdInteractionListener funAdInteractionListener = iVar.f1051f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(iVar.f1046a.f1313b);
            }
        }

        @Override // a.a.a.a.l
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdLoad(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdClicked(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            i iVar = i.this;
            FunAdInteractionListener funAdInteractionListener = iVar.f1051f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(iVar.f1046a.f1313b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdClose(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            i iVar = i.this;
            FunAdInteractionListener funAdInteractionListener = iVar.f1051f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(iVar.f1046a.f1313b);
            }
        }

        @Override // a.a.a.a.l
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdShow(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            i iVar = i.this;
            FunAdInteractionListener funAdInteractionListener = iVar.f1051f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(iVar.f1046a.f1313b);
            }
        }

        @Override // a.a.a.a.l
        public void onError(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdLoadError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i, str);
            }
            c cVar = i.this.f1050e;
            if (cVar != null) {
                c.a aVar2 = this.f1061a;
                synchronized (i.this) {
                    if (i.this.f1050e == cVar && cVar.f1059e.remove(aVar2) && cVar.f1058d != null && !cVar.a() && cVar.f1059e.isEmpty()) {
                        i.this.f1052g.removeMessages(100);
                        i.this.f1052g.obtainMessage(100, cVar).sendToTarget();
                    }
                }
            }
        }

        @Override // a.a.a.a.l
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onAdLoaded(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            c cVar = i.this.f1050e;
            if (cVar != null) {
                cVar.a(this.f1061a);
            }
        }

        @Override // a.a.a.a.l
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = i.this.f1046a.f1313b;
                e.a aVar = this.f1061a.f1317d;
                adCallback.onRewardedVideo(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            i iVar = i.this;
            FunAdInteractionListener funAdInteractionListener = iVar.f1051f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(iVar.f1046a.f1313b);
            }
        }
    }
}

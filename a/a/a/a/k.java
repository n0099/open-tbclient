package a.a.a.a;

import a.a.a.a.v.c;
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
public class k implements g {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.v.c f1052a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, n> f1053b;

    /* renamed from: d  reason: collision with root package name */
    public d.C0006d f1055d;

    /* renamed from: e  reason: collision with root package name */
    public c f1056e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1057f;

    /* renamed from: c  reason: collision with root package name */
    public final Random f1054c = new Random();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1058g = new a(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(k kVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 100) {
                return;
            }
            c cVar = (c) message.obj;
            if (cVar == null) {
                a.a.a.a.y.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
            } else {
                cVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements s<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1059a;

        public b(List list) {
            this.f1059a = list;
        }

        public boolean a(Object obj) {
            n nVar = k.this.f1053b.get(((c.a) obj).f1325d);
            List list = this.f1059a;
            return (list == null || !list.contains(nVar)) && nVar != null && nVar.c();
        }
    }

    public k(a.a.a.a.v.c cVar, p pVar) {
        this.f1052a = cVar;
        HashMap hashMap = new HashMap();
        for (c.b bVar : cVar.f1322c) {
            for (c.a aVar : bVar.f1327c) {
                n a2 = pVar.a(aVar.f1325d);
                if (a2 != null) {
                    a2.a(new d(aVar));
                    hashMap.put(aVar.f1325d, a2);
                }
            }
        }
        this.f1053b = Collections.unmodifiableMap(hashMap);
    }

    public final n a(c.b bVar, List<n> list) {
        c.a aVar = (c.a) a.a.a.a.a.a(this.f1054c, bVar.f1327c, new b(list));
        if (aVar == null) {
            return null;
        }
        return this.f1053b.get(aVar.f1325d);
    }

    @Override // a.a.a.a.g
    public FunNativeAd a(Context context) {
        for (c.b bVar : this.f1052a.f1322c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                n a2 = a(bVar, arrayList);
                if (a2 != null) {
                    FunNativeAd nativeAd = a2.getNativeAd(context, this.f1052a.f1321b);
                    if (nativeAd != null) {
                        return nativeAd;
                    }
                    arrayList.add(a2);
                }
            }
        }
        return null;
    }

    @Override // a.a.a.a.g
    public synchronized void a() {
        this.f1058g.removeMessages(100);
        c cVar = this.f1056e;
        if (cVar != null) {
            cVar.b();
        }
        this.f1056e = null;
        this.f1057f = null;
        for (c.b bVar : this.f1052a.f1322c) {
            for (c.a aVar : bVar.f1327c) {
                n nVar = this.f1053b.get(aVar.f1325d);
                if (nVar != null) {
                    nVar.a();
                }
            }
        }
    }

    @Override // a.a.a.a.g
    public synchronized <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        if (this.f1055d == null) {
            this.f1055d = new d.C0006d(this.f1052a.f1321b);
        }
        this.f1055d.c();
        this.f1057f = funAdInteractionListener;
        for (c.b bVar : this.f1052a.f1322c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                n a2 = a(bVar, arrayList);
                if (a2 != null) {
                    if (a2.a(activity, t, str, funNativeAdInflater)) {
                        return;
                    }
                    arrayList.add(a2);
                }
            }
        }
        funAdInteractionListener.onAdError(this.f1052a.f1321b);
        this.f1057f = null;
        a.a.a.a.y.d.b("showFailed for SerialSlotId(%s), because no ready loader found", this.f1052a.f1321b);
    }

    @Override // a.a.a.a.g
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        d.C0006d c0006d = new d.C0006d(this.f1052a.f1321b);
        this.f1058g.removeMessages(100);
        if (this.f1056e != null) {
            c0006d.a(true);
            this.f1056e.b();
        } else {
            c0006d.a(false);
        }
        if (this.f1052a.f1322c.isEmpty()) {
            a.a.a.a.y.d.b("No groups found in SerialSlotId(%s)", this.f1052a.f1321b);
            c0006d.a(-1, -100);
            funAdLoadListener.onError(this.f1052a.f1321b);
            return;
        }
        this.f1055d = c0006d;
        c cVar = new c(context, funAdSlot, this.f1052a.f1322c.iterator(), funAdLoadListener, c0006d);
        this.f1056e = cVar;
        cVar.a();
    }

    @Override // a.a.a.a.g
    public synchronized boolean b() {
        boolean z;
        Iterator<c.b> it = this.f1052a.f1322c.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            for (c.a aVar : it.next().f1327c) {
                n nVar = this.f1053b.get(aVar.f1325d);
                if (nVar != null && nVar.c()) {
                    z = true;
                    break loop0;
                }
            }
        }
        return z;
    }

    /* loaded from: classes.dex */
    public class d implements o {

        /* renamed from: a  reason: collision with root package name */
        public final c.a f1070a;

        public d(c.a aVar) {
            this.f1070a = aVar;
        }

        @Override // a.a.a.a.o
        public void a(int i2, String str) {
            k kVar = k.this;
            FunAdInteractionListener funAdInteractionListener = kVar.f1057f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(kVar.f1052a.f1321b);
            }
        }

        @Override // a.a.a.a.o
        public void b() {
        }

        @Override // a.a.a.a.o
        public void onAdClicked() {
            k kVar = k.this;
            FunAdInteractionListener funAdInteractionListener = kVar.f1057f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(kVar.f1052a.f1321b);
            }
        }

        @Override // a.a.a.a.o
        public void onAdClose() {
            k kVar = k.this;
            FunAdInteractionListener funAdInteractionListener = kVar.f1057f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(kVar.f1052a.f1321b);
            }
        }

        @Override // a.a.a.a.o
        public void onAdShow() {
            k kVar = k.this;
            FunAdInteractionListener funAdInteractionListener = kVar.f1057f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(kVar.f1052a.f1321b);
            }
        }

        @Override // a.a.a.a.o
        public void onError(int i2, String str) {
            FunAdLoadListener funAdLoadListener;
            c cVar = k.this.f1056e;
            if (cVar != null) {
                c.a aVar = this.f1070a;
                synchronized (k.this) {
                    if (k.this.f1056e == cVar && cVar.f1065e.remove(aVar) && (funAdLoadListener = cVar.f1068h) != null) {
                        if (!cVar.f1063c.hasNext() && cVar.f1065e.isEmpty()) {
                            a.a.a.a.y.d.a("All loader load failed, callback onError(%s)", k.this.f1052a.f1321b);
                            cVar.f1064d.a(cVar.f1067g, -103);
                            funAdLoadListener.onError(k.this.f1052a.f1321b);
                            cVar.b();
                        } else if (cVar.f1065e.isEmpty()) {
                            k.this.f1058g.removeMessages(100, cVar);
                            k.this.f1058g.obtainMessage(100, cVar).sendToTarget();
                        }
                    }
                }
            }
        }

        @Override // a.a.a.a.o
        public void onLoaded() {
            c cVar = k.this.f1056e;
            if (cVar != null) {
                cVar.a(this.f1070a);
            }
        }

        @Override // a.a.a.a.o
        public void a() {
            k kVar = k.this;
            FunAdInteractionListener funAdInteractionListener = kVar.f1057f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(kVar.f1052a.f1321b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1061a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1062b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<c.b> f1063c;

        /* renamed from: d  reason: collision with root package name */
        public final d.C0006d f1064d;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1066f;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f1068h;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<c.a> f1065e = new HashSet<>();

        /* renamed from: g  reason: collision with root package name */
        public int f1067g = 0;

        public c(Context context, FunAdSlot funAdSlot, Iterator<c.b> it, FunAdLoadListener funAdLoadListener, d.C0006d c0006d) {
            this.f1068h = funAdLoadListener;
            this.f1061a = context;
            this.f1062b = funAdSlot;
            this.f1063c = it;
            this.f1064d = c0006d;
        }

        public void a() {
            synchronized (k.this) {
                FunAdLoadListener funAdLoadListener = this.f1068h;
                if (this.f1066f) {
                    this.f1067g++;
                    this.f1066f = false;
                }
                int i2 = this.f1067g;
                if (this.f1068h == null) {
                    a.a.a.a.y.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                    this.f1064d.a(i2, -1);
                } else if (k.this.f1056e != this) {
                    this.f1064d.a(i2, -101);
                    funAdLoadListener.onError(k.this.f1052a.f1321b);
                    b();
                } else if (!this.f1063c.hasNext() && this.f1065e.isEmpty()) {
                    this.f1064d.a(i2, -102);
                    a.a.a.a.y.d.a("All loader load failed, callback onError(%s)", k.this.f1052a.f1321b);
                    funAdLoadListener.onError(k.this.f1052a.f1321b);
                    b();
                } else if (!this.f1063c.hasNext()) {
                    a.a.a.a.y.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                } else {
                    c.b next = this.f1063c.next();
                    this.f1066f = true;
                    if (next.f1327c.isEmpty()) {
                        a.a.a.a.y.d.b("There is an empty group in SerialSid(%s)", k.this.f1052a.f1321b);
                        this.f1064d.a(i2, null, -1000);
                        a();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (c.a aVar : next.f1327c) {
                        n nVar = k.this.f1053b.get(aVar.f1325d);
                        if (nVar != null) {
                            this.f1065e.add(aVar);
                            if (nVar.c()) {
                                this.f1064d.a(i2, aVar.f1325d.f1343d, 0);
                                a(aVar);
                                return;
                            }
                            arrayList.add(nVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        a.a.a.a.y.d.b("No group which ready to load found in SerialSid(%s)", k.this.f1052a.f1321b);
                        this.f1064d.a(i2, null, -1001);
                        a();
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        n nVar2 = (n) it.next();
                        this.f1064d.a(i2, nVar2.b().f1343d, nVar2.a(this.f1061a, this.f1062b) ? 1 : 2);
                    }
                    k.this.f1058g.removeMessages(100, this);
                    k.this.f1058g.sendMessageDelayed(k.this.f1058g.obtainMessage(100, this), next.f1326b);
                }
            }
        }

        public void b() {
            synchronized (k.this) {
                k.this.f1058g.removeMessages(100, this);
                this.f1068h = null;
                this.f1065e.clear();
                if (k.this.f1056e == this) {
                    k.this.f1056e = null;
                }
            }
        }

        public void a(c.a aVar) {
            synchronized (k.this) {
                if (k.this.f1056e != this) {
                    return;
                }
                FunAdLoadListener funAdLoadListener = this.f1068h;
                if (funAdLoadListener == null) {
                    return;
                }
                if (this.f1065e.remove(aVar)) {
                    d.C0006d c0006d = this.f1064d;
                    int i2 = this.f1067g;
                    String str = aVar.f1325d.f1343d;
                    if (c0006d != null) {
                        c0006d.a("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(k.this.f1052a.f1321b);
                        b();
                        return;
                    }
                    throw null;
                }
            }
        }
    }
}

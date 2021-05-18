package a.a.a.a;

import a.a.a.a.u.c;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class j implements f {

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.u.c f1048a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, m> f1049b;

    /* renamed from: d  reason: collision with root package name */
    public d.C0005d f1051d;

    /* renamed from: e  reason: collision with root package name */
    public c f1052e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdInteractionListener f1053f;

    /* renamed from: c  reason: collision with root package name */
    public final Random f1050c = new Random();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f1054g = new a(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(j jVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 100) {
                return;
            }
            c cVar = (c) message.obj;
            if (cVar == null) {
                a.a.a.a.x.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
            } else {
                cVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements r<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1055a;

        public b(List list) {
            this.f1055a = list;
        }

        public boolean a(Object obj) {
            m mVar = j.this.f1049b.get(((c.a) obj).f1317d);
            List list = this.f1055a;
            return (list == null || !list.contains(mVar)) && mVar != null && mVar.c();
        }
    }

    public j(a.a.a.a.u.c cVar, o oVar) {
        this.f1048a = cVar;
        HashMap hashMap = new HashMap();
        for (c.b bVar : cVar.f1314c) {
            for (c.a aVar : bVar.f1319c) {
                m a2 = oVar.a(aVar.f1317d);
                if (a2 != null) {
                    a2.a(new d(aVar));
                    hashMap.put(aVar.f1317d, a2);
                }
            }
        }
        this.f1049b = Collections.unmodifiableMap(hashMap);
    }

    public final m a(c.b bVar, List<m> list) {
        c.a aVar = (c.a) a.a.a.a.a.a(this.f1050c, bVar.f1319c, new b(list));
        if (aVar == null) {
            return null;
        }
        return this.f1049b.get(aVar.f1317d);
    }

    @Override // a.a.a.a.f
    public FunNativeAd a(Context context) {
        for (c.b bVar : this.f1048a.f1314c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                m a2 = a(bVar, arrayList);
                if (a2 != null) {
                    FunNativeAd nativeAd = a2.getNativeAd(context, this.f1048a.f1313b);
                    if (nativeAd != null) {
                        return nativeAd;
                    }
                    arrayList.add(a2);
                }
            }
        }
        return null;
    }

    @Override // a.a.a.a.f
    public synchronized void a() {
        this.f1054g.removeMessages(100);
        c cVar = this.f1052e;
        if (cVar != null) {
            cVar.b();
        }
        this.f1052e = null;
        this.f1053f = null;
        for (c.b bVar : this.f1048a.f1314c) {
            for (c.a aVar : bVar.f1319c) {
                m mVar = this.f1049b.get(aVar.f1317d);
                if (mVar != null) {
                    mVar.a();
                }
            }
        }
    }

    @Override // a.a.a.a.f
    public synchronized <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        if (this.f1051d == null) {
            this.f1051d = new d.C0005d(this.f1048a.f1313b);
        }
        this.f1051d.c();
        this.f1053f = funAdInteractionListener;
        for (c.b bVar : this.f1048a.f1314c) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                m a2 = a(bVar, arrayList);
                if (a2 != null) {
                    if (a2.a(activity, t, str, funNativeAdInflater)) {
                        return;
                    }
                    arrayList.add(a2);
                }
            }
        }
        funAdInteractionListener.onAdError(this.f1048a.f1313b);
        this.f1053f = null;
        a.a.a.a.x.d.b("showFailed for SerialSlotId(%s), because no ready loader found", this.f1048a.f1313b);
    }

    @Override // a.a.a.a.f
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        d.C0005d c0005d = new d.C0005d(this.f1048a.f1313b);
        this.f1054g.removeMessages(100);
        if (this.f1052e != null) {
            c0005d.a(true);
            this.f1052e.b();
        } else {
            c0005d.a(false);
        }
        if (this.f1048a.f1314c.isEmpty()) {
            a.a.a.a.x.d.b("No groups found in SerialSlotId(%s)", this.f1048a.f1313b);
            c0005d.a(-1, -100);
            funAdLoadListener.onError(this.f1048a.f1313b);
            return;
        }
        this.f1051d = c0005d;
        c cVar = new c(context, funAdSlot, this.f1048a.f1314c.iterator(), funAdLoadListener, c0005d);
        this.f1052e = cVar;
        cVar.a();
    }

    @Override // a.a.a.a.f
    public synchronized boolean b() {
        boolean z;
        Iterator<c.b> it = this.f1048a.f1314c.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            for (c.a aVar : it.next().f1319c) {
                m mVar = this.f1049b.get(aVar.f1317d);
                if (mVar != null && mVar.c()) {
                    z = true;
                    break loop0;
                }
            }
        }
        return z;
    }

    /* loaded from: classes.dex */
    public class d implements n {

        /* renamed from: a  reason: collision with root package name */
        public final c.a f1066a;

        public d(c.a aVar) {
            this.f1066a = aVar;
        }

        @Override // a.a.a.a.n
        public void a(int i2, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdShowError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i2, str);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.f1053f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(jVar.f1048a.f1313b);
            }
        }

        @Override // a.a.a.a.n
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdLoad(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdClicked(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.f1053f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(jVar.f1048a.f1313b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdClose(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.f1053f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(jVar.f1048a.f1313b);
            }
        }

        @Override // a.a.a.a.n
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdShow(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.f1053f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(jVar.f1048a.f1313b);
            }
        }

        @Override // a.a.a.a.n
        public void onError(int i2, String str) {
            FunAdLoadListener funAdLoadListener;
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdLoadError(str2, aVar.f1335d, aVar.f1334c, aVar.k.f1330b, i2, str);
            }
            c cVar = j.this.f1052e;
            if (cVar != null) {
                c.a aVar2 = this.f1066a;
                synchronized (j.this) {
                    if (j.this.f1052e == cVar && cVar.f1061e.remove(aVar2) && (funAdLoadListener = cVar.f1064h) != null) {
                        if (!cVar.f1059c.hasNext() && cVar.f1061e.isEmpty()) {
                            a.a.a.a.x.d.a("All loader load failed, callback onError(%s)", j.this.f1048a.f1313b);
                            cVar.f1060d.a(cVar.f1063g, -103);
                            funAdLoadListener.onError(j.this.f1048a.f1313b);
                            cVar.b();
                        } else if (cVar.f1061e.isEmpty()) {
                            j.this.f1054g.removeMessages(100, cVar);
                            j.this.f1054g.obtainMessage(100, cVar).sendToTarget();
                        }
                    }
                }
            }
        }

        @Override // a.a.a.a.n
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onAdLoaded(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            c cVar = j.this.f1052e;
            if (cVar != null) {
                cVar.a(this.f1066a);
            }
        }

        @Override // a.a.a.a.n
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.f1048a.f1313b;
                e.a aVar = this.f1066a.f1317d;
                adCallback.onRewardedVideo(str, aVar.f1335d, aVar.f1334c, aVar.k.f1330b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.f1053f;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(jVar.f1048a.f1313b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1057a;

        /* renamed from: b  reason: collision with root package name */
        public final FunAdSlot f1058b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<c.b> f1059c;

        /* renamed from: d  reason: collision with root package name */
        public final d.C0005d f1060d;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1062f;

        /* renamed from: h  reason: collision with root package name */
        public FunAdLoadListener f1064h;

        /* renamed from: e  reason: collision with root package name */
        public final HashSet<c.a> f1061e = new HashSet<>();

        /* renamed from: g  reason: collision with root package name */
        public int f1063g = 0;

        public c(Context context, FunAdSlot funAdSlot, Iterator<c.b> it, FunAdLoadListener funAdLoadListener, d.C0005d c0005d) {
            this.f1064h = funAdLoadListener;
            this.f1057a = context;
            this.f1058b = funAdSlot;
            this.f1059c = it;
            this.f1060d = c0005d;
        }

        public void a() {
            synchronized (j.this) {
                FunAdLoadListener funAdLoadListener = this.f1064h;
                if (this.f1062f) {
                    this.f1063g++;
                    this.f1062f = false;
                }
                int i2 = this.f1063g;
                if (this.f1064h == null) {
                    a.a.a.a.x.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                    this.f1060d.a(i2, -1);
                } else if (j.this.f1052e != this) {
                    this.f1060d.a(i2, -101);
                    funAdLoadListener.onError(j.this.f1048a.f1313b);
                    b();
                } else if (!this.f1059c.hasNext() && this.f1061e.isEmpty()) {
                    this.f1060d.a(i2, -102);
                    a.a.a.a.x.d.a("All loader load failed, callback onError(%s)", j.this.f1048a.f1313b);
                    funAdLoadListener.onError(j.this.f1048a.f1313b);
                    b();
                } else if (!this.f1059c.hasNext()) {
                    a.a.a.a.x.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                } else {
                    c.b next = this.f1059c.next();
                    this.f1062f = true;
                    if (next.f1319c.isEmpty()) {
                        a.a.a.a.x.d.b("There is an empty group in SerialSid(%s)", j.this.f1048a.f1313b);
                        this.f1060d.a(i2, null, -1000);
                        a();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (c.a aVar : next.f1319c) {
                        m mVar = j.this.f1049b.get(aVar.f1317d);
                        if (mVar != null) {
                            this.f1061e.add(aVar);
                            if (mVar.c()) {
                                this.f1060d.a(i2, aVar.f1317d.f1335d, 0);
                                a(aVar);
                                return;
                            }
                            arrayList.add(mVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        a.a.a.a.x.d.b("No group which ready to load found in SerialSid(%s)", j.this.f1048a.f1313b);
                        this.f1060d.a(i2, null, -1001);
                        a();
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        m mVar2 = (m) it.next();
                        this.f1060d.a(i2, mVar2.b().f1335d, mVar2.a(this.f1057a, this.f1058b) ? 1 : 2);
                    }
                    j.this.f1054g.removeMessages(100, this);
                    j.this.f1054g.sendMessageDelayed(j.this.f1054g.obtainMessage(100, this), next.f1318b);
                }
            }
        }

        public void b() {
            synchronized (j.this) {
                j.this.f1054g.removeMessages(100, this);
                this.f1064h = null;
                this.f1061e.clear();
                if (j.this.f1052e == this) {
                    j.this.f1052e = null;
                }
            }
        }

        public void a(c.a aVar) {
            synchronized (j.this) {
                if (j.this.f1052e != this) {
                    return;
                }
                FunAdLoadListener funAdLoadListener = this.f1064h;
                if (funAdLoadListener == null) {
                    return;
                }
                if (this.f1061e.remove(aVar)) {
                    d.C0005d c0005d = this.f1060d;
                    int i2 = this.f1063g;
                    String str = aVar.f1317d.f1335d;
                    if (c0005d != null) {
                        c0005d.a("ldr_ld_succeed", "layer", Integer.valueOf(i2), "stype", str);
                        funAdLoadListener.onAdLoaded(j.this.f1048a.f1313b);
                        b();
                        return;
                    }
                    throw null;
                }
            }
        }
    }
}

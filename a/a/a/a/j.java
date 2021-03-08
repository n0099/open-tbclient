package a.a.a.a;

import a.a.a.a.a.c;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes4.dex */
public class j implements f {
    public final a.a.a.a.v.f.g.d b;
    public final Map<e.a, l> c;
    public final a.a.a.a.a.c zG;
    public c zI;
    public FunAdInteractionListener zw;
    public final Random zH = new Random();
    public final Handler g = new a(this, Looper.getMainLooper());

    /* loaded from: classes4.dex */
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
                a.a.a.a.v.d.a("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
            } else {
                cVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q<c.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f965a;

        public b(List list) {
            this.f965a = list;
        }

        public boolean a(Object obj) {
            l lVar = j.this.c.get(((c.a) obj).BG);
            List list = this.f965a;
            return (list == null || !list.contains(lVar)) && lVar != null && lVar.c();
        }
    }

    public j(a.a.a.a.a.c cVar, n nVar) {
        this.zG = cVar;
        this.b = new d.c(cVar.b);
        HashMap hashMap = new HashMap();
        for (c.b bVar : cVar.c) {
            for (c.a aVar : bVar.c) {
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
        for (c.b bVar : this.zG.c) {
            ArrayList arrayList = new ArrayList();
            l a2 = a(bVar, arrayList);
            while (a2 != null) {
                FunNativeAd nativeAd = a2.getNativeAd(context, this.zG.b);
                if (nativeAd != null) {
                    return nativeAd;
                }
                arrayList.add(a2);
                a2 = a(bVar, arrayList);
            }
        }
        return null;
    }

    public final l a(c.b bVar, List<l> list) {
        c.a aVar = (c.a) a.a.a.a.a.a(this.zH, bVar.c, new b(list));
        if (aVar == null) {
            return null;
        }
        return this.c.get(aVar.BG);
    }

    @Override // a.a.a.a.f
    public synchronized void a() {
        this.g.removeMessages(100);
        c cVar = this.zI;
        if (cVar != null) {
            cVar.c();
        }
        this.zI = null;
        this.zw = null;
        for (c.b bVar : this.zG.c) {
            for (c.a aVar : bVar.c) {
                l lVar = this.c.get(aVar.BG);
                if (lVar != null) {
                    lVar.a();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        r9.onAdError(r5.zG.b);
        r5.zw = null;
        a.a.a.a.v.d.b("showFailed for SerialSlotId(%s), because no ready loader found", r5.zG.b);
     */
    @Override // a.a.a.a.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends ViewGroup> void a(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        this.b.a("ldr_sh_start");
        this.zw = funAdInteractionListener;
        Iterator<c.b> it = this.zG.c.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            c.b next = it.next();
            ArrayList arrayList = new ArrayList();
            l a2 = a(next, arrayList);
            while (a2 != null) {
                if (a2.a(activity, t, str, funNativeAdInflater)) {
                    break loop0;
                }
                arrayList.add(a2);
                a2 = a(next, arrayList);
            }
        }
    }

    @Override // a.a.a.a.f
    public synchronized void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        if (funAdLoadListener == null) {
            throw new IllegalArgumentException();
        }
        this.g.removeMessages(100);
        c cVar = this.zI;
        if (cVar != null) {
            cVar.c();
        }
        this.b.a();
        if (this.zG.c.isEmpty()) {
            a.a.a.a.v.d.b("No groups found in SerialSlotId(%s)", this.zG.b);
            funAdLoadListener.onError(this.zG.b);
        } else {
            c cVar2 = new c(context, funAdSlot, this.zG.c.iterator(), funAdLoadListener);
            this.zI = cVar2;
            cVar2.b();
        }
    }

    @Override // a.a.a.a.f
    public synchronized boolean b() {
        boolean z;
        Iterator<c.b> it = this.zG.c.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            for (c.a aVar : it.next().c) {
                l lVar = this.c.get(aVar.BG);
                if (lVar != null && lVar.c()) {
                    z = true;
                    break loop0;
                }
            }
        }
        return z;
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public final Context f966a;
        public final HashSet<c.a> e = new HashSet<>();
        public FunAdLoadListener zA;
        public final FunAdSlot zK;
        public final Iterator<c.b> zL;

        public c(Context context, FunAdSlot funAdSlot, Iterator<c.b> it, FunAdLoadListener funAdLoadListener) {
            this.zA = funAdLoadListener;
            this.f966a = context;
            this.zK = funAdSlot;
            this.zL = it;
        }

        public final boolean a() {
            if (this.zL.hasNext() || !this.e.isEmpty()) {
                return false;
            }
            if (this.zA != null) {
                a.a.a.a.v.d.a("All loader load failed, callback onError(%s)", j.this.zG.b);
                this.zA.onError(j.this.zG.b);
                c();
                return true;
            }
            return true;
        }

        public void b() {
            synchronized (j.this) {
                if (j.this.zI == this) {
                    if (this.zA != null) {
                        if (a()) {
                            return;
                        }
                        if (!this.zL.hasNext()) {
                            a.a.a.a.v.d.a("All loader already started, just wait for the loader callback", new Object[0]);
                            return;
                        }
                        c.b next = this.zL.next();
                        if (next.c.isEmpty()) {
                            a.a.a.a.v.d.b("There is an empty group in SerialSid(%s)", j.this.zG.b);
                            b();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (c.a aVar : next.c) {
                            l lVar = j.this.c.get(aVar.BG);
                            if (lVar != null) {
                                this.e.add(aVar);
                                if (lVar.c()) {
                                    a(aVar);
                                    return;
                                }
                                arrayList.add(lVar);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((l) it.next()).b(this.f966a, this.zK);
                            }
                            j.this.g.removeMessages(100);
                            j.this.g.sendMessageDelayed(j.this.g.obtainMessage(100, this), next.b);
                            return;
                        }
                        a.a.a.a.v.d.b("No group which ready to load found in SerialSid(%s)", j.this.zG.b);
                        b();
                        return;
                    }
                    a.a.a.a.v.d.a("Give up load by LoadHandler with listener already recycled", new Object[0]);
                }
            }
        }

        public void c() {
            synchronized (j.this) {
                this.zA = null;
                this.e.clear();
                if (j.this.zI == this) {
                    j.this.zI = null;
                }
            }
        }

        public void a(c.a aVar) {
            synchronized (j.this) {
                if (j.this.zI == this) {
                    FunAdLoadListener funAdLoadListener = this.zA;
                    if (funAdLoadListener != null) {
                        if (!this.e.remove(aVar)) {
                            return;
                        }
                        funAdLoadListener.onAdLoaded(j.this.zG.b);
                        c();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements m {
        public final c.a zN;

        public d(c.a aVar) {
            this.zN = aVar;
        }

        @Override // a.a.a.a.m
        public void a(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdShowError(str2, aVar.d, aVar.c, aVar.BI.b, i, str);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdError(jVar.zG.b);
            }
        }

        @Override // a.a.a.a.m
        public void b() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdLoad(str, aVar.d, aVar.c, aVar.BI.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdClicked() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdClicked(str, aVar.d, aVar.c, aVar.BI.b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClicked(jVar.zG.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdClose() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdClose(str, aVar.d, aVar.c, aVar.BI.b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(jVar.zG.b);
            }
        }

        @Override // a.a.a.a.m
        public void onAdShow() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdShow(str, aVar.d, aVar.c, aVar.BI.b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdShow(jVar.zG.b);
            }
        }

        @Override // a.a.a.a.m
        public void onError(int i, String str) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str2 = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdLoadError(str2, aVar.d, aVar.c, aVar.BI.b, i, str);
            }
            c cVar = j.this.zI;
            if (cVar != null) {
                c.a aVar2 = this.zN;
                synchronized (j.this) {
                    if (j.this.zI == cVar && cVar.e.remove(aVar2) && cVar.zA != null && !cVar.a() && cVar.e.isEmpty()) {
                        j.this.g.removeMessages(100);
                        j.this.g.obtainMessage(100, cVar).sendToTarget();
                    }
                }
            }
        }

        @Override // a.a.a.a.m
        public void onLoaded() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onAdLoaded(str, aVar.d, aVar.c, aVar.BI.b);
            }
            c cVar = j.this.zI;
            if (cVar != null) {
                cVar.a(this.zN);
            }
        }

        @Override // a.a.a.a.m
        public void a() {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                String str = j.this.zG.b;
                e.a aVar = this.zN.BG;
                adCallback.onRewardedVideo(str, aVar.d, aVar.c, aVar.BI.b);
            }
            j jVar = j.this;
            FunAdInteractionListener funAdInteractionListener = jVar.zw;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onRewardedVideo(jVar.zG.b);
            }
        }
    }
}

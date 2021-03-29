package com.baidu.mobads.nativecpu.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.k;
import com.baidu.mobads.production.l;
import com.baidu.mobads.production.p;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a extends com.baidu.mobads.production.a {
    public Object A;
    public HashMap<String, Object> B;
    public AtomicBoolean C;
    public int D;
    public int E;
    public int[] F;
    public boolean G;
    public IOAdEventListener H;
    public String I;
    public q J;
    public c z;

    /* renamed from: com.baidu.mobads.nativecpu.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0108a extends d {
        public C0108a(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
            super(context, activity, slotType);
        }

        @Override // com.baidu.mobads.vo.d
        public HashMap<String, String> a() {
            HashMap<String, String> hashMap = new HashMap<>();
            if (a.this.B.size() > 0) {
                for (String str : a.this.B.keySet()) {
                    Object obj = a.this.B.get(str);
                    if (obj instanceof String) {
                        hashMap.put(str, (String) obj);
                    }
                }
            }
            return hashMap;
        }
    }

    public a(Context context, String str) {
        super(context);
        this.B = new HashMap<>();
        this.C = new AtomicBoolean(false);
        this.J = q.a();
        setActivity(context);
        this.I = str;
    }

    private void s() {
        Object obj;
        c cVar;
        IOAdEventListener iOAdEventListener = this.H;
        if (iOAdEventListener == null || (obj = this.A) == null || (cVar = this.z) == null) {
            return;
        }
        cVar.a(obj, "addEventListener", IXAdEvent.AD_LOADED, iOAdEventListener);
        this.z.a(this.A, "addEventListener", "AdEmptyList", this.H);
        this.z.a(this.A, "addEventListener", IXAdEvent.AD_ERROR, this.H);
        this.z.a(this.A, "addEventListener", "AdUserClick", this.H);
        this.z.a(this.A, "addEventListener", "AdStatusChange", this.H);
        this.z.a(this.A, "addEventListener", "vdieoCacheSucc", this.H);
        this.z.a(this.A, "addEventListener", "vdieoCacheFailed", this.H);
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public List<Object> b() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll((List) this.z.b(this.A, "getAllAdList", new Object[0]));
        } catch (Throwable th) {
            this.J.d(th.getMessage());
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
    }

    @Override // com.baidu.mobads.production.a
    public void d() {
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public IXAdRequestInfo getAdRequestInfo() {
        return this.k;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
    }

    public void a(IOAdEventListener iOAdEventListener) {
        this.H = iOAdEventListener;
    }

    @Override // com.baidu.mobads.production.a
    public void a(IXAdResponseInfo iXAdResponseInfo) {
        try {
            l();
            Context applicationContext = getApplicationContext();
            Activity activity = getActivity();
            l lVar = new l(this.f8439f, this);
            C0108a c0108a = new C0108a(applicationContext, activity, IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU);
            this.k = c0108a;
            k kVar = new k(this.f8439f, activity, c0108a.d(), null, lVar, getAdResponseInfo(), null);
            c a2 = c.a(this.f8439f, "com.baidu.mobads.container.nativecpu.interfaces.RCPUAdProd");
            this.z = a2;
            this.A = a2.a(new Class[]{IXAdContainerContext.class, String.class}, kVar, this.I);
            s();
            this.z.a(this.A, "loadAd", Integer.valueOf(this.E), Integer.valueOf(this.D), this.F, Boolean.valueOf(this.G), this.B);
            this.C.set(this.A != null);
        } catch (Throwable th) {
            this.J.d(th);
        }
    }

    public void a(int i, int i2, int[] iArr, boolean z, Map<String, Object> map) {
        try {
            this.B.clear();
            if (map != null) {
                this.B.putAll(map);
            }
            if (this.C.get() && this.z != null) {
                s();
                this.z.a(this.A, "loadAd", Integer.valueOf(i), Integer.valueOf(i2), iArr, Boolean.valueOf(z), this.B);
                return;
            }
            this.E = i;
            this.D = i2;
            this.F = iArr;
            this.G = z;
            addEventListener(IXAdEvent.AD_ERROR, this.H);
            m();
            a((com.baidu.mobads.openad.b.b) null, (p) null, 0);
        } catch (Throwable th) {
            this.J.d(th);
        }
    }

    public void a(int i) {
        try {
            this.m = i;
            if (this.z != null) {
                this.z.a(this.A, "setTimeoutMillis", Integer.valueOf(i));
            }
        } catch (Throwable th) {
            this.J.d(th);
        }
    }

    public void a() {
        try {
            removeAllListeners();
            if (this.z != null) {
                this.z.a(this.A, "removeAllListeners", new Object[0]);
            }
        } catch (Throwable th) {
            this.J.d(th);
        }
    }

    @Override // com.baidu.mobads.production.a
    public void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        try {
            a(this.f8439f);
            setAdResponseInfo(new com.baidu.mobads.vo.c("{'ad':[{'id':99999999,'url':'http://127.0.0.1', type='CPUNative'}],'n':1}"));
        } catch (Throwable th) {
            this.J.d(th);
        }
        a("XAdMouldeLoader native-cpu dummy requesting success");
    }
}

package com.baidu.swan.apps.setting;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ae.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.a.e;
import com.baidu.swan.apps.setting.oauth.g;
import com.baidu.swan.apps.storage.b.e;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e aUd;
    public final String aUe;
    private final Set<b> aUf;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> aUg;
    public final com.baidu.swan.apps.an.c.c aUh;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void Nk();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.aUf = new HashSet();
        this.aUg = new HashMap();
        this.aUh = new com.baidu.swan.apps.an.c.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.aUe = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.aUg.clear();
    }

    public void M(Activity activity) {
    }

    private e Nf() {
        if (this.aUd == null) {
            this.aUd = new e(this.aUe);
        }
        return this.aUd;
    }

    public void clear() {
        Nf().edit().clear().apply();
    }

    public void Ng() {
        Nf().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        Nf().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        Nf().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return Nf().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return Nf().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.d.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: c */
            public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Jf()) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) false);
                } else if (eVar.aUS != 0) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(eVar.aUS > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.d.a
                        /* renamed from: a */
                        public void D(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.aUW));
                        }
                    });
                }
            }
        });
    }

    public void c(String str, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e> aVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>>) aVar, (com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.a(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) eVar);
                }
            });
        }
    }

    public boolean hm(String str) {
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Jf()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e fN = com.baidu.swan.apps.network.c.b.a.fN(str);
        return (fN == null || fN.forbidden || !fN.Nu()) ? false : true;
    }

    public void b(Activity activity, String str, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        a(activity, str, true, false, aVar);
    }

    public void a(Activity activity, String str, boolean z, boolean z2, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        b(activity, str, z, z2, aVar);
    }

    private void b(Activity activity, final String str, boolean z, boolean z2, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.aUg.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.Np()) {
            bVar.g(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().wA().a(activity, z, str, z2);
        this.aUg.put(str, a);
        a.g(aVar).g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<b.d> gVar) {
                a.this.aUg.remove(str);
            }
        });
        this.aUh.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(g<b.d> gVar) {
                        finish();
                    }
                });
                a.No();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.d.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0174a<a>) new AbstractC0174a<com.baidu.swan.apps.an.d.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0174a
            /* renamed from: f */
            public void I(com.baidu.swan.apps.an.d.a<ResulT> aVar2) {
                aVar2.D(result);
            }
        });
    }

    public boolean Nh() {
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).LQ();
            return false;
        }
        vJ.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.aUf.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.aUf.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.aUf.clear();
    }

    public synchronized void Ni() {
        this.aUg.clear();
        this.aUh.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0174a<CallBackT> abstractC0174a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0174a<a>) abstractC0174a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0174a<CallBackT> abstractC0174a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0174a.I(callbackt);
            }
        });
    }

    public void Nj() {
        a((Collection) this.aUf, (AbstractC0174a) new AbstractC0174a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0174a
            /* renamed from: c */
            public void I(b bVar) {
                bVar.Nk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0174a<CallBackT> {
        abstract void I(CallBackT callbackt);

        private AbstractC0174a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.aUh.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().wA().a(activity, aVar, bundle).g(aVar2).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).No();
            }
        });
    }
}

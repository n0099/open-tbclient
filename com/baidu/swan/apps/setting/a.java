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
    private e bnn;
    public final String bno;
    private final Set<b> bnp;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> bnq;
    public final com.baidu.swan.apps.an.c.c bnr;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void Sg();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.bnp = new HashSet();
        this.bnq = new HashMap();
        this.bnr = new com.baidu.swan.apps.an.c.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.bno = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.bnq.clear();
    }

    public void L(Activity activity) {
    }

    private e Sb() {
        if (this.bnn == null) {
            this.bnn = new e(this.bno);
        }
        return this.bnn;
    }

    public void clear() {
        Sb().edit().clear().apply();
    }

    public void Sc() {
        Sb().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        Sb().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        Sb().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return Sb().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return Sb().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.d.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: c */
            public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Oe()) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) false);
                } else if (eVar.boc != 0) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(eVar.boc > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.d.a
                        /* renamed from: a */
                        public void B(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.bog));
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
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) eVar);
                }
            });
        }
    }

    public boolean hR(String str) {
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Oe()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e gu = com.baidu.swan.apps.network.c.b.a.gu(str);
        return (gu == null || gu.forbidden || !gu.Sq()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.bnq.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.Sl()) {
            bVar.g(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.Rt().bka.get().AY().Bz().a(activity, z, str, z2);
        this.bnq.put(str, a);
        a.g(aVar).g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<b.d> gVar) {
                a.this.bnq.remove(str);
            }
        });
        this.bnr.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(g<b.d> gVar) {
                        finish();
                    }
                });
                a.Sk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.d.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0215a<a>) new AbstractC0215a<com.baidu.swan.apps.an.d.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0215a
            /* renamed from: f */
            public void G(com.baidu.swan.apps.an.d.a<ResulT> aVar2) {
                aVar2.B(result);
            }
        });
    }

    public boolean Sd() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            d.i(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).QO();
            return false;
        }
        AI.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.bnp.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.bnp.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.bnp.clear();
    }

    public synchronized void Se() {
        this.bnq.clear();
        this.bnr.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0215a<CallBackT> abstractC0215a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0215a<a>) abstractC0215a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0215a<CallBackT> abstractC0215a) {
        e(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0215a.G(callbackt);
            }
        });
    }

    public void Sf() {
        a((Collection) this.bnp, (AbstractC0215a) new AbstractC0215a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0215a
            /* renamed from: c */
            public void G(b bVar) {
                bVar.Sg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0215a<CallBackT> {
        abstract void G(CallBackT callbackt);

        private AbstractC0215a() {
        }
    }

    private static void e(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.bnr.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.Rt().bka.get().AY().Bz().a(activity, aVar, bundle).g(aVar2).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).Sk();
            }
        });
    }
}

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
    private e aUB;
    public final String aUC;
    private final Set<b> aUD;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> aUE;
    public final com.baidu.swan.apps.an.c.c aUF;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void No();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.aUD = new HashSet();
        this.aUE = new HashMap();
        this.aUF = new com.baidu.swan.apps.an.c.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.aUC = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.aUE.clear();
    }

    public void M(Activity activity) {
    }

    private e Nj() {
        if (this.aUB == null) {
            this.aUB = new e(this.aUC);
        }
        return this.aUB;
    }

    public void clear() {
        Nj().edit().clear().apply();
    }

    public void Nk() {
        Nj().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        Nj().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        Nj().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return Nj().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return Nj().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.d.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: c */
            public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Jj()) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) false);
                } else if (eVar.aVq != 0) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(eVar.aVq > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.d.a
                        /* renamed from: a */
                        public void D(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.aVu));
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

    public boolean ho(String str) {
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Jj()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e fP = com.baidu.swan.apps.network.c.b.a.fP(str);
        return (fP == null || fP.forbidden || !fP.Ny()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.aUE.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.Nt()) {
            bVar.g(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.Mz().aRo.get().wd().wE().a(activity, z, str, z2);
        this.aUE.put(str, a);
        a.g(aVar).g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<b.d> gVar) {
                a.this.aUE.remove(str);
            }
        });
        this.aUF.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.4
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
                a.Ns();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.d.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0188a<a>) new AbstractC0188a<com.baidu.swan.apps.an.d.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0188a
            /* renamed from: f */
            public void I(com.baidu.swan.apps.an.d.a<ResulT> aVar2) {
                aVar2.D(result);
            }
        });
    }

    public boolean Nl() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).LU();
            return false;
        }
        vN.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.aUD.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.aUD.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.aUD.clear();
    }

    public synchronized void Nm() {
        this.aUE.clear();
        this.aUF.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0188a<CallBackT> abstractC0188a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0188a<a>) abstractC0188a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0188a<CallBackT> abstractC0188a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0188a.I(callbackt);
            }
        });
    }

    public void Nn() {
        a((Collection) this.aUD, (AbstractC0188a) new AbstractC0188a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0188a
            /* renamed from: c */
            public void I(b bVar) {
                bVar.No();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0188a<CallBackT> {
        abstract void I(CallBackT callbackt);

        private AbstractC0188a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.aUF.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.Mz().aRo.get().wd().wE().a(activity, aVar, bundle).g(aVar2).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).Ns();
            }
        });
    }
}

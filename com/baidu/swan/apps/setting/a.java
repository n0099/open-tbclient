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
    private e aTt;
    public final String aTu;
    private final Set<b> aTv;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> aTw;
    public final com.baidu.swan.apps.an.c.c aTx;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void Mw();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.aTv = new HashSet();
        this.aTw = new HashMap();
        this.aTx = new com.baidu.swan.apps.an.c.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.aTu = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.aTw.clear();
    }

    public void J(Activity activity) {
    }

    private e Mr() {
        if (this.aTt == null) {
            this.aTt = new e(this.aTu);
        }
        return this.aTt;
    }

    public void clear() {
        Mr().edit().clear().apply();
    }

    public void Ms() {
        Mr().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        Mr().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        Mr().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return Mr().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return Mr().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.d.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: c */
            public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Is()) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) false);
                } else if (eVar.aUi != 0) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(eVar.aUi > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.d.a
                        /* renamed from: a */
                        public void D(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.aUm));
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

    public boolean hg(String str) {
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Is()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e fJ = com.baidu.swan.apps.network.c.b.a.fJ(str);
        return (fJ == null || fJ.forbidden || !fJ.MF()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.aTw.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.MB()) {
            bVar.g(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.LH().aQg.get().vy().vZ().a(activity, z, str, z2);
        this.aTw.put(str, a);
        a.g(aVar).g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void D(g<b.d> gVar) {
                a.this.aTw.remove(str);
            }
        });
        this.aTx.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.4
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
                a.MA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.d.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0177a<a>) new AbstractC0177a<com.baidu.swan.apps.an.d.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0177a
            /* renamed from: f */
            public void I(com.baidu.swan.apps.an.d.a<ResulT> aVar2) {
                aVar2.D(result);
            }
        });
    }

    public boolean Mt() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).Ld();
            return false;
        }
        vi.dO("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.aTv.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.aTv.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.aTv.clear();
    }

    public synchronized void Mu() {
        this.aTw.clear();
        this.aTx.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0177a<CallBackT> abstractC0177a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0177a<a>) abstractC0177a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0177a<CallBackT> abstractC0177a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0177a.I(callbackt);
            }
        });
    }

    public void Mv() {
        a((Collection) this.aTv, (AbstractC0177a) new AbstractC0177a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0177a
            /* renamed from: c */
            public void I(b bVar) {
                bVar.Mw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0177a<CallBackT> {
        abstract void I(CallBackT callbackt);

        private AbstractC0177a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.aTx.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.LH().aQg.get().vy().vZ().a(activity, aVar, bundle).g(aVar2).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void D(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).MA();
            }
        });
    }
}

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
    private e aQB;
    public final String aQC;
    private final Set<b> aQD;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> aQE;
    public final com.baidu.swan.apps.an.b.c aQF;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void JY();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.aQD = new HashSet();
        this.aQE = new HashMap();
        this.aQF = new com.baidu.swan.apps.an.b.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.aQC = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.aQE.clear();
    }

    public void I(Activity activity) {
    }

    private e JT() {
        if (this.aQB == null) {
            this.aQB = new e(this.aQC);
        }
        return this.aQB;
    }

    public void clear() {
        JT().edit().clear().apply();
    }

    public void JU() {
        JT().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        JT().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        JT().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return JT().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return JT().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.c.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: c */
            public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Gj()) {
                    a.this.a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a>) aVar, (com.baidu.swan.apps.an.c.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a>) aVar, (com.baidu.swan.apps.an.c.a) false);
                } else if (eVar.aRp != 0) {
                    a.this.a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a>) aVar, (com.baidu.swan.apps.an.c.a) Boolean.valueOf(eVar.aRp > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.c.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.c.a
                        /* renamed from: a */
                        public void D(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a>) aVar, (com.baidu.swan.apps.an.c.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.aRt));
                        }
                    });
                }
            }
        });
    }

    public void c(String str, final com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e> aVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>>) aVar, (com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.a(str, new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: c */
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.an.c.a>) aVar, (com.baidu.swan.apps.an.c.a) eVar);
                }
            });
        }
    }

    public void b(Activity activity, String str, com.baidu.swan.apps.an.c.a<g<b.d>> aVar) {
        a(activity, str, true, false, aVar);
    }

    public void a(Activity activity, String str, boolean z, boolean z2, com.baidu.swan.apps.an.c.a<g<b.d>> aVar) {
        b(activity, str, z, z2, aVar);
    }

    private void b(Activity activity, final String str, boolean z, boolean z2, com.baidu.swan.apps.an.c.a<g<b.d>> aVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.aQE.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.Kd()) {
            bVar.c(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.Jo().aNZ.get().uP().uT().a(activity, z, str, z2);
        this.aQE.put(str, a);
        a.c(aVar).c(new com.baidu.swan.apps.an.c.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
            /* renamed from: a */
            public void D(g<b.d> gVar) {
                a.this.aQE.remove(str);
            }
        });
        this.aQF.b(new com.baidu.swan.apps.an.b.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.c(new com.baidu.swan.apps.an.c.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.c.a
                    /* renamed from: a */
                    public void D(g<b.d> gVar) {
                        finish();
                    }
                });
                a.Kc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.c.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0170a<a>) new AbstractC0170a<com.baidu.swan.apps.an.c.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0170a
            /* renamed from: b */
            public void I(com.baidu.swan.apps.an.c.a<ResulT> aVar2) {
                aVar2.D(result);
            }
        });
    }

    public boolean JV() {
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            d.l(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).IK();
            return false;
        }
        uz.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqJ, com.baidu.swan.apps.core.c.e.aqL).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.aQD.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.aQD.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.aQD.clear();
    }

    public synchronized void JW() {
        this.aQE.clear();
        this.aQF.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0170a<CallBackT> abstractC0170a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0170a<a>) abstractC0170a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0170a<CallBackT> abstractC0170a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0170a.I(callbackt);
            }
        });
    }

    public void JX() {
        a((Collection) this.aQD, (AbstractC0170a) new AbstractC0170a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0170a
            /* renamed from: c */
            public void I(b bVar) {
                bVar.JY();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0170a<CallBackT> {
        abstract void I(CallBackT callbackt);

        private AbstractC0170a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.aQF.b(new com.baidu.swan.apps.an.b.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.Jo().aNZ.get().uP().uT().a(activity, aVar, bundle).c(aVar2).c(new com.baidu.swan.apps.an.c.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.c.a
                    /* renamed from: a */
                    public void D(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).Kc();
            }
        });
    }
}

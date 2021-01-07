package com.baidu.swan.apps.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.d.c;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.a.f;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.storage.c.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dKV;
    public final String dKW;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> dKX;
    public final c dKY;
    private final Set<b> dcQ;
    public final String name;

    /* loaded from: classes9.dex */
    public interface b {
        void aNW();
    }

    public a(e eVar) {
        super(eVar);
        this.dcQ = new HashSet();
        this.dKX = new HashMap();
        this.dKY = new c();
        this.name = com.baidu.swan.apps.storage.b.f(eVar);
        this.dKW = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.dKX.clear();
    }

    public void L(Activity activity) {
    }

    private g aNR() {
        if (this.dKV == null) {
            this.dKV = new g(this.dKW, false);
        }
        return this.dKV;
    }

    public void clear() {
        aNR().edit().clear().apply();
    }

    public void aNS() {
        aNR().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aNR().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aNR().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aNR().putLong(str, j);
    }

    public void remove(String str) {
        this.dKV.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aNR().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aNR().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aNR().getLong(str, j);
    }

    public void b(Context context, String str, com.baidu.swan.apps.ao.e.b<h<b.d>> bVar) {
        a(context, str, false, bVar);
    }

    public void a(final Context context, final String str, final boolean z, final com.baidu.swan.apps.ao.e.b<h<b.d>> bVar) {
        e(str, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: c */
            public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ad.a.a.aIM()) {
                    hVar.aOt();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar);
                    return;
                }
                boolean z3 = eVar == null;
                com.baidu.swan.apps.console.c.bs("SwanAppSetting", "isResultNull = " + z3);
                if (z3 || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                    return;
                }
                if (z) {
                    if (eVar.dLO <= 0) {
                        z2 = true;
                    }
                } else if (eVar.dLO == 0) {
                    z2 = true;
                }
                if (z2) {
                    a.this.b(context, str, z, new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void L(h<b.d> hVar2) {
                            a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar2);
                        }
                    });
                    return;
                }
                if (eVar.dLO > 0) {
                    hVar.aOt();
                    hVar.mData = new b.d(true, null);
                } else {
                    hVar.a(new OAuthException(10003));
                }
                a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar);
            }
        });
    }

    public void e(String str, final com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>>) bVar, (com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.b(str, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: c */
                public void L(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) eVar);
                }
            });
        }
    }

    public boolean tm(String str) {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aIM()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e qV = com.baidu.swan.apps.network.c.b.a.qV(str);
        return (qV == null || qV.forbidden || !qV.aOi()) ? false : true;
    }

    public void b(Context context, String str, boolean z, com.baidu.swan.apps.ao.e.b<h<b.d>> bVar) {
        a(context, str, z, true, false, bVar);
    }

    public void a(Context context, String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.ao.e.b<h<b.d>> bVar) {
        b(context, str, z, z2, z3, bVar);
    }

    private void b(Context context, final String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.ao.e.b<h<b.d>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.dKX.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aOd()) {
            bVar2.A(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a2 = d.aMh().aMj().ajO().alH().a(context, z, z2, new String[]{str}, null, z3);
        this.dKX.put(str, a2);
        a2.A(bVar).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                a.this.dKX.remove(str);
            }
        });
        this.dKY.b(new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a2.A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(h<b.d> hVar) {
                        finish();
                    }
                });
                a2.aOc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.ao.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0483a<a>) new AbstractC0483a<com.baidu.swan.apps.ao.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0483a
            /* renamed from: x */
            public void Z(com.baidu.swan.apps.ao.e.b<ResulT> bVar2) {
                bVar2.L(result);
            }
        });
    }

    public boolean aNT() {
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt == null) {
            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).aLT();
            return false;
        }
        ajt.nv("navigateTo").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("authority", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.dcQ.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.dcQ.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.dcQ.clear();
    }

    public synchronized void aNU() {
        this.dKX.clear();
        this.dKY.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0483a<CallBackT> abstractC0483a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0483a<a>) abstractC0483a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0483a<CallBackT> abstractC0483a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0483a.Z(callbackt);
            }
        });
    }

    public void aNV() {
        a((Collection) this.dcQ, (AbstractC0483a) new AbstractC0483a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0483a
            /* renamed from: c */
            public void Z(b bVar) {
                bVar.aNW();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public abstract class AbstractC0483a<CallBackT> {
        abstract void Z(CallBackT callbackt);

        private AbstractC0483a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.ao.e.b<h<f.c>> bVar) {
        this.dKY.b(new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.aMh().aMj().ajO().alH().a(activity, aVar, bundle).A(bVar).A(new com.baidu.swan.apps.ao.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(h<f.c> hVar) {
                        finish();
                    }
                }).aOc();
            }
        });
    }
}

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
/* loaded from: classes8.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dJO;
    public final String dJP;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> dJQ;
    public final c dJR;
    private final Set<b> dbO;
    public final String name;

    /* loaded from: classes8.dex */
    public interface b {
        void aKy();
    }

    public a(e eVar) {
        super(eVar);
        this.dbO = new HashSet();
        this.dJQ = new HashMap();
        this.dJR = new c();
        this.name = com.baidu.swan.apps.storage.b.f(eVar);
        this.dJP = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.dJQ.clear();
    }

    public void F(Activity activity) {
    }

    private g aKt() {
        if (this.dJO == null) {
            this.dJO = new g(this.dJP, false);
        }
        return this.dJO;
    }

    public void clear() {
        aKt().edit().clear().apply();
    }

    public void aKu() {
        aKt().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aKt().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aKt().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aKt().putLong(str, j);
    }

    public void remove(String str) {
        this.dJO.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aKt().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aKt().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aKt().getLong(str, j);
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
            public void N(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ad.a.a.aFq()) {
                    hVar.aKV();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar);
                    return;
                }
                boolean z3 = eVar == null;
                com.baidu.swan.apps.console.c.bl("SwanAppSetting", "isResultNull = " + z3);
                if (z3 || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                    return;
                }
                if (z) {
                    if (eVar.dKH <= 0) {
                        z2 = true;
                    }
                } else if (eVar.dKH == 0) {
                    z2 = true;
                }
                if (z2) {
                    a.this.b(context, str, z, new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void N(h<b.d> hVar2) {
                            a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) hVar2);
                        }
                    });
                    return;
                }
                if (eVar.dKH > 0) {
                    hVar.aKV();
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
                public void N(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.ao.e.b>) bVar, (com.baidu.swan.apps.ao.e.b) eVar);
                }
            });
        }
    }

    public boolean sB(String str) {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aFq()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e qj = com.baidu.swan.apps.network.c.b.a.qj(str);
        return (qj == null || qj.forbidden || !qj.aKK()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.dJQ.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aKF()) {
            bVar2.A(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a2 = d.aIJ().aIL().agv().aio().a(context, z, z2, new String[]{str}, null, z3);
        this.dJQ.put(str, a2);
        a2.A(bVar).A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<b.d> hVar) {
                a.this.dJQ.remove(str);
            }
        });
        this.dJR.b(new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a2.A(new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void N(h<b.d> hVar) {
                        finish();
                    }
                });
                a2.aKE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.ao.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0469a<a>) new AbstractC0469a<com.baidu.swan.apps.ao.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0469a
            /* renamed from: x */
            public void ab(com.baidu.swan.apps.ao.e.b<ResulT> bVar2) {
                bVar2.N(result);
            }
        });
    }

    public boolean aKv() {
        com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga == null) {
            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).aIv();
            return false;
        }
        aga.mJ("navigateTo").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("authority", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.dbO.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.dbO.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.dbO.clear();
    }

    public synchronized void aKw() {
        this.dJQ.clear();
        this.dJR.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0469a<CallBackT> abstractC0469a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0469a<a>) abstractC0469a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0469a<CallBackT> abstractC0469a) {
        e(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0469a.ab(callbackt);
            }
        });
    }

    public void aKx() {
        a((Collection) this.dbO, (AbstractC0469a) new AbstractC0469a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0469a
            /* renamed from: c */
            public void ab(b bVar) {
                bVar.aKy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public abstract class AbstractC0469a<CallBackT> {
        abstract void ab(CallBackT callbackt);

        private AbstractC0469a() {
        }
    }

    private static void e(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.ao.e.b<h<f.c>> bVar) {
        this.dJR.b(new com.baidu.swan.apps.ao.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.aIJ().aIL().agv().aio().a(activity, aVar, bundle).A(bVar).A(new com.baidu.swan.apps.ao.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void N(h<f.c> hVar) {
                        finish();
                    }
                }).aKE();
            }
        });
    }
}

package com.baidu.swan.apps.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.d.c;
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
/* loaded from: classes25.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<b> cXV;
    private g dCr;
    public final String dCs;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> dCt;
    public final c dCu;
    public final String name;

    /* loaded from: classes25.dex */
    public interface b {
        void aLF();
    }

    public a(e eVar) {
        super(eVar);
        this.cXV = new HashSet();
        this.dCt = new HashMap();
        this.dCu = new c();
        this.name = com.baidu.swan.apps.storage.b.f(eVar);
        this.dCs = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.dCt.clear();
    }

    public void K(Activity activity) {
    }

    private g aLA() {
        if (this.dCr == null) {
            this.dCr = new g(this.dCs, false);
        }
        return this.dCr;
    }

    public void clear() {
        aLA().edit().clear().apply();
    }

    public void aLB() {
        aLA().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aLA().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aLA().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aLA().putLong(str, j);
    }

    public void remove(String str) {
        this.dCr.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aLA().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aLA().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aLA().getLong(str, j);
    }

    public void b(Context context, String str, com.baidu.swan.apps.ap.e.b<h<b.d>> bVar) {
        a(context, str, false, bVar);
    }

    public void a(final Context context, final String str, final boolean z, final com.baidu.swan.apps.ap.e.b<h<b.d>> bVar) {
        e(str, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: c */
            public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ad.a.a.aHs()) {
                    hVar.aMc();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar);
                    return;
                }
                boolean z3 = eVar == null;
                com.baidu.swan.apps.console.c.bt("SwanAppSetting", "isResultNull = " + z3);
                if (z3 || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                    return;
                }
                if (z) {
                    if (eVar.dDk <= 0) {
                        z2 = true;
                    }
                } else if (eVar.dDk == 0) {
                    z2 = true;
                }
                if (z2) {
                    a.this.b(context, str, z, new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(h<b.d> hVar2) {
                            a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar2);
                        }
                    });
                    return;
                }
                if (eVar.dDk > 0) {
                    hVar.aMc();
                    hVar.mData = new b.d(true, null);
                } else {
                    hVar.a(new OAuthException(10003));
                }
                a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar);
            }
        });
    }

    public void e(String str, final com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>>) bVar, (com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.b(str, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void M(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) eVar);
                }
            });
        }
    }

    public boolean tp(String str) {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aHs()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e rb = com.baidu.swan.apps.network.c.b.a.rb(str);
        return (rb == null || rb.forbidden || !rb.aLR()) ? false : true;
    }

    public void b(Context context, String str, boolean z, com.baidu.swan.apps.ap.e.b<h<b.d>> bVar) {
        a(context, str, z, true, false, bVar);
    }

    public void a(Context context, String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.ap.e.b<h<b.d>> bVar) {
        b(context, str, z, z2, z3, bVar);
    }

    private void b(Context context, final String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.ap.e.b<h<b.d>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.dCt.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aLM()) {
            bVar2.A(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a2 = d.aJQ().aJS().aiF().akw().a(context, z, z2, new String[]{str}, null, z3);
        this.dCt.put(str, a2);
        a2.A(bVar).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<b.d> hVar) {
                a.this.dCt.remove(str);
            }
        });
        this.dCu.b(new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a2.A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        finish();
                    }
                });
                a2.aLL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.ap.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0490a<a>) new AbstractC0490a<com.baidu.swan.apps.ap.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0490a
            /* renamed from: x */
            public void Y(com.baidu.swan.apps.ap.e.b<ResulT> bVar2) {
                bVar2.M(result);
            }
        });
    }

    public boolean aLC() {
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.res.widget.b.d.t(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        aim.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("authority", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.cXV.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.cXV.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.cXV.clear();
    }

    public synchronized void aLD() {
        this.dCt.clear();
        this.dCu.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0490a<CallBackT> abstractC0490a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0490a<a>) abstractC0490a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0490a<CallBackT> abstractC0490a) {
        h(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0490a.Y(callbackt);
            }
        });
    }

    public void aLE() {
        a((Collection) this.cXV, (AbstractC0490a) new AbstractC0490a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0490a
            /* renamed from: c */
            public void Y(b bVar) {
                bVar.aLF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public abstract class AbstractC0490a<CallBackT> {
        abstract void Y(CallBackT callbackt);

        private AbstractC0490a() {
        }
    }

    private static void h(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.ap.e.b<h<f.c>> bVar) {
        this.dCu.b(new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.aJQ().aJS().aiF().akw().a(activity, aVar, bundle).A(bVar).A(new com.baidu.swan.apps.ap.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<f.c> hVar) {
                        finish();
                    }
                }).aLL();
            }
        });
    }
}

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
/* loaded from: classes7.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<b> cRc;
    private g dvs;
    public final String dvt;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> dvu;
    public final c dvv;
    public final String name;

    /* loaded from: classes7.dex */
    public interface b {
        void aIx();
    }

    public a(e eVar) {
        super(eVar);
        this.cRc = new HashSet();
        this.dvu = new HashMap();
        this.dvv = new c();
        this.name = com.baidu.swan.apps.storage.b.f(eVar);
        this.dvt = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.dvu.clear();
    }

    public void K(Activity activity) {
    }

    private g aIs() {
        if (this.dvs == null) {
            this.dvs = new g(this.dvt, false);
        }
        return this.dvs;
    }

    public void clear() {
        aIs().edit().clear().apply();
    }

    public void aIt() {
        aIs().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aIs().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aIs().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aIs().putLong(str, j);
    }

    public void remove(String str) {
        this.dvs.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aIs().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aIs().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aIs().getLong(str, j);
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
                if (a.DEBUG && com.baidu.swan.apps.ad.a.a.aEk()) {
                    hVar.aIU();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar);
                    return;
                }
                boolean z3 = eVar == null;
                com.baidu.swan.apps.console.c.bm("SwanAppSetting", "isResultNull = " + z3);
                if (z3 || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.ap.e.b>) bVar, (com.baidu.swan.apps.ap.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                    return;
                }
                if (z) {
                    if (eVar.dwl <= 0) {
                        z2 = true;
                    }
                } else if (eVar.dwl == 0) {
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
                if (eVar.dwl > 0) {
                    hVar.aIU();
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

    public boolean sI(String str) {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aEk()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e qu = com.baidu.swan.apps.network.c.b.a.qu(str);
        return (qu == null || qu.forbidden || !qu.aIJ()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.dvu.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aIE()) {
            bVar2.A(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a2 = d.aGI().aGK().afx().aho().a(context, z, z2, new String[]{str}, null, z3);
        this.dvu.put(str, a2);
        a2.A(bVar).A(new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(h<b.d> hVar) {
                a.this.dvu.remove(str);
            }
        });
        this.dvv.b(new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.a.4
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
                a2.aID();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.ap.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0478a<a>) new AbstractC0478a<com.baidu.swan.apps.ap.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0478a
            /* renamed from: x */
            public void Y(com.baidu.swan.apps.ap.e.b<ResulT> bVar2) {
                bVar2.M(result);
            }
        });
    }

    public boolean aIu() {
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        afe.mV("navigateTo").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("authority", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.cRc.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.cRc.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.cRc.clear();
    }

    public synchronized void aIv() {
        this.dvu.clear();
        this.dvv.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0478a<CallBackT> abstractC0478a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0478a<a>) abstractC0478a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0478a<CallBackT> abstractC0478a) {
        h(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0478a.Y(callbackt);
            }
        });
    }

    public void aIw() {
        a((Collection) this.cRc, (AbstractC0478a) new AbstractC0478a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0478a
            /* renamed from: c */
            public void Y(b bVar) {
                bVar.aIx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public abstract class AbstractC0478a<CallBackT> {
        abstract void Y(CallBackT callbackt);

        private AbstractC0478a() {
        }
    }

    private static void h(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.ap.e.b<h<f.c>> bVar) {
        this.dvv.b(new com.baidu.swan.apps.ap.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.aGI().aGK().afx().aho().a(activity, aVar, bundle).A(bVar).A(new com.baidu.swan.apps.ap.e.b<h<f.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<f.c> hVar) {
                        finish();
                    }
                }).aID();
            }
        });
    }
}

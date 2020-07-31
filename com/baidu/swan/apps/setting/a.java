package com.baidu.swan.apps.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.aq.d.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.runtime.f;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.a.e;
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
    private final Set<b> cBE;
    private g cLu;
    public final String cLv;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> cLw;
    public final c cLx;
    public final String name;

    /* loaded from: classes7.dex */
    public interface b {
        void atk();
    }

    public a(e eVar) {
        super(eVar);
        this.cBE = new HashSet();
        this.cLw = new HashMap();
        this.cLx = new c();
        this.name = com.baidu.swan.apps.storage.b.e(eVar);
        this.cLv = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.cLw.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g atf() {
        if (this.cLu == null) {
            this.cLu = new g(this.cLv, false);
        }
        return this.cLu;
    }

    public void clear() {
        atf().edit().clear().apply();
    }

    public void atg() {
        atf().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        atf().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        atf().putString(str, str2);
    }

    public void putLong(String str, long j) {
        atf().putLong(str, j);
    }

    public void remove(String str) {
        this.cLu.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return atf().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return atf().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return atf().getLong(str, j);
    }

    public void b(Context context, String str, com.baidu.swan.apps.aq.e.b<h<b.d>> bVar) {
        a(context, str, false, bVar);
    }

    public void a(final Context context, final String str, final boolean z, final com.baidu.swan.apps.aq.e.b<h<b.d>> bVar) {
        d(str, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: c */
            public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ae.a.a.aph()) {
                    hVar.atH();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                } else {
                    if (z) {
                        if (eVar.cMo <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.cMo == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        a.this.b(context, str, z, new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.aq.e.b
                            /* renamed from: a */
                            public void H(h<b.d> hVar2) {
                                a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar2);
                            }
                        });
                        return;
                    }
                    if (eVar.cMo > 0) {
                        hVar.atH();
                        hVar.mData = new b.d(true, null);
                    } else {
                        hVar.a(new OAuthException(10003));
                    }
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                }
            }
        });
    }

    public void d(String str, final com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>>) bVar, (com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.a(str, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: c */
                public void H(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) eVar);
                }
            });
        }
    }

    public boolean pc(String str) {
        if (DEBUG && com.baidu.swan.apps.ae.a.a.aph()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e mO = com.baidu.swan.apps.network.c.b.a.mO(str);
        return (mO == null || mO.forbidden || !mO.atw()) ? false : true;
    }

    public void b(Context context, String str, boolean z, com.baidu.swan.apps.aq.e.b<h<b.d>> bVar) {
        a(context, str, z, true, false, bVar);
    }

    public void a(Context context, String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.aq.e.b<h<b.d>> bVar) {
        b(context, str, z, z2, z3, bVar);
    }

    private void b(Context context, final String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.aq.e.b<h<b.d>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.cLw.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.atr()) {
            bVar2.t(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.arr().art().Sv().Uf().a(context, z, z2, new String[]{str}, null, z3);
        this.cLw.put(str, a);
        a.t(bVar).t(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                a.this.cLw.remove(str);
            }
        });
        this.cLx.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.t(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<b.d> hVar) {
                        finish();
                    }
                });
                a.atq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.aq.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0396a<a>) new AbstractC0396a<com.baidu.swan.apps.aq.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0396a
            /* renamed from: q */
            public void R(com.baidu.swan.apps.aq.e.b<ResulT> bVar2) {
                bVar2.H(result);
            }
        });
    }

    public boolean ath() {
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        Sc.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("authority", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.cBE.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.cBE.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.cBE.clear();
    }

    public synchronized void ati() {
        this.cLw.clear();
        this.cLx.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0396a<CallBackT> abstractC0396a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0396a<a>) abstractC0396a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0396a<CallBackT> abstractC0396a) {
        k(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0396a.R(callbackt);
            }
        });
    }

    public void atj() {
        a((Collection) this.cBE, (AbstractC0396a) new AbstractC0396a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0396a
            /* renamed from: c */
            public void R(b bVar) {
                bVar.atk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public abstract class AbstractC0396a<CallBackT> {
        abstract void R(CallBackT callbackt);

        private AbstractC0396a() {
        }
    }

    private static void k(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.aq.e.b<h<e.c>> bVar) {
        this.cLx.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.arr().art().Sv().Uf().a(activity, aVar, bundle).t(bVar).t(new com.baidu.swan.apps.aq.e.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<e.c> hVar) {
                        finish();
                    }
                }).atq();
            }
        });
    }
}

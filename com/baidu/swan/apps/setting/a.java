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
/* loaded from: classes11.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cDB;
    public final String cDC;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> cDD;
    public final c cDE;
    private final Set<b> cus;
    public final String name;

    /* loaded from: classes11.dex */
    public interface b {
        void aqm();
    }

    public a(e eVar) {
        super(eVar);
        this.cus = new HashSet();
        this.cDD = new HashMap();
        this.cDE = new c();
        this.name = com.baidu.swan.apps.storage.b.e(eVar);
        this.cDC = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.cDD.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g aqh() {
        if (this.cDB == null) {
            this.cDB = new g(this.cDC, false);
        }
        return this.cDB;
    }

    public void clear() {
        aqh().edit().clear().apply();
    }

    public void aqi() {
        aqh().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aqh().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aqh().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aqh().putLong(str, j);
    }

    public void remove(String str) {
        this.cDB.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aqh().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aqh().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aqh().getLong(str, j);
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
                if (a.DEBUG && com.baidu.swan.apps.af.a.a.ams()) {
                    hVar.aqG();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                } else {
                    if (z) {
                        if (eVar.cEu <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.cEu == 0) {
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
                    if (eVar.cEu > 0) {
                        hVar.aqG();
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

    public boolean ok(String str) {
        if (DEBUG && com.baidu.swan.apps.af.a.a.ams()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e mi = com.baidu.swan.apps.network.c.b.a.mi(str);
        return (mi == null || mi.forbidden || !mi.aqy()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.cDD.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aqt()) {
            bVar2.q(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.aoB().aoD().QY().Sz().a(context, z, z2, new String[]{str}, null, z3);
        this.cDD.put(str, a);
        a.q(bVar).q(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                a.this.cDD.remove(str);
            }
        });
        this.cDE.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.q(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<b.d> hVar) {
                        finish();
                    }
                });
                a.aqs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.aq.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0386a<a>) new AbstractC0386a<com.baidu.swan.apps.aq.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0386a
            /* renamed from: p */
            public void R(com.baidu.swan.apps.aq.e.b<ResulT> bVar2) {
                bVar2.H(result);
            }
        });
    }

    public boolean aqj() {
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        QH.jp("navigateTo").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.cus.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.cus.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.cus.clear();
    }

    public synchronized void aqk() {
        this.cDD.clear();
        this.cDE.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0386a<CallBackT> abstractC0386a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0386a<a>) abstractC0386a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0386a<CallBackT> abstractC0386a) {
        k(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0386a.R(callbackt);
            }
        });
    }

    public void aql() {
        a((Collection) this.cus, (AbstractC0386a) new AbstractC0386a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0386a
            /* renamed from: c */
            public void R(b bVar) {
                bVar.aqm();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public abstract class AbstractC0386a<CallBackT> {
        abstract void R(CallBackT callbackt);

        private AbstractC0386a() {
        }
    }

    private static void k(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.aq.e.b<h<e.c>> bVar) {
        this.cDE.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.aoB().aoD().QY().Sz().a(activity, aVar, bundle).q(bVar).q(new com.baidu.swan.apps.aq.e.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<e.c> hVar) {
                        finish();
                    }
                }).aqs();
            }
        });
    }
}

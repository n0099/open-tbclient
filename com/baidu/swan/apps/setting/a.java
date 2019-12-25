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
import com.baidu.swan.apps.as.c.c;
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
/* loaded from: classes9.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<b> bEW;
    private g bNF;
    public final String bNG;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> bNH;
    public final c bNI;
    public final String name;

    /* loaded from: classes9.dex */
    public interface b {
        void abp();
    }

    public a(e eVar) {
        super(eVar);
        this.bEW = new HashSet();
        this.bNH = new HashMap();
        this.bNI = new c();
        this.name = com.baidu.swan.apps.storage.b.c(eVar);
        this.bNG = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.bNH.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g abk() {
        if (this.bNF == null) {
            this.bNF = new g(this.bNG);
        }
        return this.bNF;
    }

    public void clear() {
        abk().edit().clear().apply();
    }

    public void abl() {
        abk().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        abk().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        abk().putString(str, str2);
    }

    public void putLong(String str, long j) {
        abk().putLong(str, j);
    }

    public void remove(String str) {
        this.bNF.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return abk().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return abk().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return abk().getLong(str, j);
    }

    public void b(Context context, String str, com.baidu.swan.apps.as.d.b<h<b.d>> bVar) {
        a(context, str, false, bVar);
    }

    public void a(final Context context, final String str, final boolean z, final com.baidu.swan.apps.as.d.b<h<b.d>> bVar) {
        d(str, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r0v11, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            /* JADX WARN: Type inference failed for: r0v8, types: [com.baidu.swan.apps.setting.oauth.a.b$d, ResultDataT] */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: c */
            public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ah.a.a.XR()) {
                    hVar.abJ();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else {
                    if (z) {
                        if (eVar.bOA <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.bOA == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        a.this.b(context, str, z, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.as.d.b
                            /* renamed from: a */
                            public void B(h<b.d> hVar2) {
                                a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar2);
                            }
                        });
                        return;
                    }
                    if (eVar.bOA > 0) {
                        hVar.abJ();
                        hVar.mData = new b.d(true, null);
                    } else {
                        hVar.a(new OAuthException(10003));
                    }
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                }
            }
        });
    }

    public void d(String str, final com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e> bVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>>) bVar, (com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.a(str, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) eVar);
                }
            });
        }
    }

    public boolean lh(String str) {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.XR()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e jq = com.baidu.swan.apps.network.c.b.a.jq(str);
        return (jq == null || jq.forbidden || !jq.abB()) ? false : true;
    }

    public void b(Context context, String str, boolean z, com.baidu.swan.apps.as.d.b<h<b.d>> bVar) {
        a(context, str, z, true, false, bVar);
    }

    public void a(Context context, String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.as.d.b<h<b.d>> bVar) {
        b(context, str, z, z2, z3, bVar);
    }

    private void b(Context context, final String str, boolean z, boolean z2, boolean z3, com.baidu.swan.apps.as.d.b<h<b.d>> bVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.bNH.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.abw()) {
            bVar2.h(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.ZP().ZR().Ei().Ff().a(context, z, z2, new String[]{str}, null, z3);
        this.bNH.put(str, a);
        a.h(bVar).h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(h<b.d> hVar) {
                a.this.bNH.remove(str);
            }
        });
        this.bNI.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(h<b.d> hVar) {
                        finish();
                    }
                });
                a.abv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.as.d.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0280a<a>) new AbstractC0280a<com.baidu.swan.apps.as.d.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0280a
            /* renamed from: g */
            public void K(com.baidu.swan.apps.as.d.b<ResulT> bVar2) {
                bVar2.B(result);
            }
        });
    }

    public boolean abm() {
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP == null) {
            com.baidu.swan.apps.res.widget.b.d.q(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        DP.gJ("navigateTo").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.bEW.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.bEW.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.bEW.clear();
    }

    public synchronized void abn() {
        this.bNH.clear();
        this.bNI.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0280a<CallBackT> abstractC0280a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0280a<a>) abstractC0280a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0280a<CallBackT> abstractC0280a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0280a.K(callbackt);
            }
        });
    }

    public void abo() {
        a((Collection) this.bEW, (AbstractC0280a) new AbstractC0280a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0280a
            /* renamed from: c */
            public void K(b bVar) {
                bVar.abp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public abstract class AbstractC0280a<CallBackT> {
        abstract void K(CallBackT callbackt);

        private AbstractC0280a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.as.d.b<h<e.c>> bVar) {
        this.bNI.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.ZP().ZR().Ei().Ff().a(activity, aVar, bundle).h(bVar).h(new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(h<e.c> hVar) {
                        finish();
                    }
                }).abv();
            }
        });
    }
}

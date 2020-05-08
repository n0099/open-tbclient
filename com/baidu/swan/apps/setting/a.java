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
/* loaded from: classes11.dex */
public class a extends f {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Set<b> ciP;
    private g crC;
    public final String crD;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> crE;
    public final c crF;
    public final String name;

    /* loaded from: classes11.dex */
    public interface b {
        void amj();
    }

    public a(e eVar) {
        super(eVar);
        this.ciP = new HashSet();
        this.crE = new HashMap();
        this.crF = new c();
        this.name = com.baidu.swan.apps.storage.b.c(eVar);
        this.crD = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.crE.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g ame() {
        if (this.crC == null) {
            this.crC = new g(this.crD);
        }
        return this.crC;
    }

    public void clear() {
        ame().edit().clear().apply();
    }

    public void amf() {
        ame().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        ame().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        ame().putString(str, str2);
    }

    public void putLong(String str, long j) {
        ame().putLong(str, j);
    }

    public void remove(String str) {
        this.crC.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return ame().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return ame().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return ame().getLong(str, j);
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
            public void F(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ah.a.a.aiL()) {
                    hVar.amD();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else {
                    if (z) {
                        if (eVar.csx <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.csx == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        a.this.b(context, str, z, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.as.d.b
                            /* renamed from: a */
                            public void F(h<b.d> hVar2) {
                                a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar2);
                            }
                        });
                        return;
                    }
                    if (eVar.csx > 0) {
                        hVar.amD();
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
                public void F(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) eVar);
                }
            });
        }
    }

    public boolean mL(String str) {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aiL()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e kU = com.baidu.swan.apps.network.c.b.a.kU(str);
        return (kU == null || kU.forbidden || !kU.amv()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.crE.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.amq()) {
            bVar2.h(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.akJ().akL().OM().PG().a(context, z, z2, new String[]{str}, null, z3);
        this.crE.put(str, a);
        a.h(bVar).h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(h<b.d> hVar) {
                a.this.crE.remove(str);
            }
        });
        this.crF.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void F(h<b.d> hVar) {
                        finish();
                    }
                });
                a.amp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.as.d.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0343a<a>) new AbstractC0343a<com.baidu.swan.apps.as.d.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0343a
            /* renamed from: g */
            public void O(com.baidu.swan.apps.as.d.b<ResulT> bVar2) {
                bVar2.F(result);
            }
        });
    }

    public boolean amg() {
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        Ot.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.ciP.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.ciP.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.ciP.clear();
    }

    public synchronized void amh() {
        this.crE.clear();
        this.crF.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0343a<CallBackT> abstractC0343a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0343a<a>) abstractC0343a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0343a<CallBackT> abstractC0343a) {
        j(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0343a.O(callbackt);
            }
        });
    }

    public void ami() {
        a((Collection) this.ciP, (AbstractC0343a) new AbstractC0343a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0343a
            /* renamed from: c */
            public void O(b bVar) {
                bVar.amj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public abstract class AbstractC0343a<CallBackT> {
        abstract void O(CallBackT callbackt);

        private AbstractC0343a() {
        }
    }

    private static void j(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.as.d.b<h<e.c>> bVar) {
        this.crF.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.akJ().akL().OM().PG().a(activity, aVar, bundle).h(bVar).h(new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void F(h<e.c> hVar) {
                        finish();
                    }
                }).amp();
            }
        });
    }
}

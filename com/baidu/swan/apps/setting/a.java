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
    private final Set<b> ciJ;
    private g crw;
    public final String crx;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> cry;
    public final c crz;
    public final String name;

    /* loaded from: classes11.dex */
    public interface b {
        void amk();
    }

    public a(e eVar) {
        super(eVar);
        this.ciJ = new HashSet();
        this.cry = new HashMap();
        this.crz = new c();
        this.name = com.baidu.swan.apps.storage.b.c(eVar);
        this.crx = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.cry.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g amf() {
        if (this.crw == null) {
            this.crw = new g(this.crx);
        }
        return this.crw;
    }

    public void clear() {
        amf().edit().clear().apply();
    }

    public void amg() {
        amf().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        amf().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        amf().putString(str, str2);
    }

    public void putLong(String str, long j) {
        amf().putLong(str, j);
    }

    public void remove(String str) {
        this.crw.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return amf().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return amf().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return amf().getLong(str, j);
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
            public void E(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ah.a.a.aiM()) {
                    hVar.amE();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else {
                    if (z) {
                        if (eVar.csr <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.csr == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        a.this.b(context, str, z, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.as.d.b
                            /* renamed from: a */
                            public void E(h<b.d> hVar2) {
                                a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar2);
                            }
                        });
                        return;
                    }
                    if (eVar.csr > 0) {
                        hVar.amE();
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
                public void E(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) eVar);
                }
            });
        }
    }

    public boolean mL(String str) {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aiM()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e kU = com.baidu.swan.apps.network.c.b.a.kU(str);
        return (kU == null || kU.forbidden || !kU.amw()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.cry.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.amr()) {
            bVar2.h(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.akK().akM().ON().PH().a(context, z, z2, new String[]{str}, null, z3);
        this.cry.put(str, a);
        a.h(bVar).h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(h<b.d> hVar) {
                a.this.cry.remove(str);
            }
        });
        this.crz.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void E(h<b.d> hVar) {
                        finish();
                    }
                });
                a.amq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.as.d.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0322a<a>) new AbstractC0322a<com.baidu.swan.apps.as.d.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0322a
            /* renamed from: g */
            public void N(com.baidu.swan.apps.as.d.b<ResulT> bVar2) {
                bVar2.E(result);
            }
        });
    }

    public boolean amh() {
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        Ou.io("navigateTo").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.ciJ.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.ciJ.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.ciJ.clear();
    }

    public synchronized void ami() {
        this.cry.clear();
        this.crz.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0322a<CallBackT> abstractC0322a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0322a<a>) abstractC0322a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0322a<CallBackT> abstractC0322a) {
        j(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0322a.N(callbackt);
            }
        });
    }

    public void amj() {
        a((Collection) this.ciJ, (AbstractC0322a) new AbstractC0322a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0322a
            /* renamed from: c */
            public void N(b bVar) {
                bVar.amk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public abstract class AbstractC0322a<CallBackT> {
        abstract void N(CallBackT callbackt);

        private AbstractC0322a() {
        }
    }

    private static void j(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.as.d.b<h<e.c>> bVar) {
        this.crz.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.akK().akM().ON().PH().a(activity, aVar, bundle).h(bVar).h(new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void E(h<e.c> hVar) {
                        finish();
                    }
                }).amq();
            }
        });
    }
}

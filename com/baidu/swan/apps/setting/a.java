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
    private e bnF;
    public final String bnG;
    private final Set<b> bnH;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> bnI;
    public final com.baidu.swan.apps.an.c.c bnJ;
    public final String name;

    /* loaded from: classes2.dex */
    public interface b {
        void Se();
    }

    public a(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        this.bnH = new HashSet();
        this.bnI = new HashMap();
        this.bnJ = new com.baidu.swan.apps.an.c.c();
        this.name = com.baidu.swan.apps.storage.b.d(bVar);
        this.bnG = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.bnI.clear();
    }

    public void L(Activity activity) {
    }

    private e RZ() {
        if (this.bnF == null) {
            this.bnF = new e(this.bnG);
        }
        return this.bnF;
    }

    public void clear() {
        RZ().edit().clear().apply();
    }

    public void Sa() {
        RZ().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        RZ().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        RZ().putString(str, str2);
    }

    public boolean getBoolean(String str, boolean z) {
        return RZ().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return RZ().getString(str, str2);
    }

    public void a(final Activity activity, final String str, final com.baidu.swan.apps.an.d.a<Boolean> aVar) {
        c(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: c */
            public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                if (a.DEBUG && com.baidu.swan.apps.ac.a.a.Od()) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) true);
                } else if (eVar == null || eVar.forbidden) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) false);
                } else if (eVar.bou != 0) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(eVar.bou > 0));
                } else {
                    a.this.b(activity, str, new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.an.d.a
                        /* renamed from: a */
                        public void B(g<b.d> gVar) {
                            a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) Boolean.valueOf(gVar != null && gVar.isOk() && gVar.mData.boy));
                        }
                    });
                }
            }
        });
    }

    public void c(String str, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e> aVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>>) aVar, (com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>) null);
        } else {
            com.baidu.swan.apps.network.c.b.a.a(str, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.apps.setting.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: c */
                public void B(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.an.d.a>) aVar, (com.baidu.swan.apps.an.d.a) eVar);
                }
            });
        }
    }

    public boolean hR(String str) {
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Od()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e gu = com.baidu.swan.apps.network.c.b.a.gu(str);
        return (gu == null || gu.forbidden || !gu.So()) ? false : true;
    }

    public void b(Activity activity, String str, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        a(activity, str, true, false, aVar);
    }

    public void a(Activity activity, String str, boolean z, boolean z2, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        b(activity, str, z, z2, aVar);
    }

    private void b(Activity activity, final String str, boolean z, boolean z2, com.baidu.swan.apps.an.d.a<g<b.d>> aVar) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        com.baidu.swan.apps.setting.oauth.a.b bVar = this.bnI.get(str);
        if (bVar != null && TaskState.FINISHED != bVar.Sj()) {
            bVar.g(aVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = com.baidu.swan.apps.ae.e.Rr().bks.get().AX().By().a(activity, z, str, z2);
        this.bnI.put(str, a);
        a.g(aVar).g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(g<b.d> gVar) {
                a.this.bnI.remove(str);
            }
        });
        this.bnJ.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.g(new com.baidu.swan.apps.an.d.a<g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(g<b.d> gVar) {
                        finish();
                    }
                });
                a.Si();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.an.d.a<ResulT> aVar, final ResulT result) {
        a((a) aVar, (AbstractC0220a<a>) new AbstractC0220a<com.baidu.swan.apps.an.d.a<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0220a
            /* renamed from: f */
            public void G(com.baidu.swan.apps.an.d.a<ResulT> aVar2) {
                aVar2.B(result);
            }
        });
    }

    public boolean Sb() {
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            d.i(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).QN();
            return false;
        }
        AH.eC("navigateTo").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.bnH.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.bnH.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.bnH.clear();
    }

    public synchronized void Sc() {
        this.bnI.clear();
        this.bnJ.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0220a<CallBackT> abstractC0220a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0220a<a>) abstractC0220a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0220a<CallBackT> abstractC0220a) {
        e(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0220a.G(callbackt);
            }
        });
    }

    public void Sd() {
        a((Collection) this.bnH, (AbstractC0220a) new AbstractC0220a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0220a
            /* renamed from: c */
            public void G(b bVar) {
                bVar.Se();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public abstract class AbstractC0220a<CallBackT> {
        abstract void G(CallBackT callbackt);

        private AbstractC0220a() {
        }
    }

    private static void e(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final g.a aVar, final Bundle bundle, final com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>> aVar2) {
        this.bnJ.b(new com.baidu.swan.apps.an.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.e.Rr().bks.get().AX().By().a(activity, aVar, bundle).g(aVar2).g(new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                        finish();
                    }
                }).Si();
            }
        });
    }
}

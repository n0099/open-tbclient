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
    private final Set<b> bJZ;
    private g bSH;
    public final String bSI;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> bSJ;
    public final c bSK;
    public final String name;

    /* loaded from: classes11.dex */
    public interface b {
        void aef();
    }

    public a(e eVar) {
        super(eVar);
        this.bJZ = new HashSet();
        this.bSJ = new HashMap();
        this.bSK = new c();
        this.name = com.baidu.swan.apps.storage.b.c(eVar);
        this.bSI = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.bSJ.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g aea() {
        if (this.bSH == null) {
            this.bSH = new g(this.bSI);
        }
        return this.bSH;
    }

    public void clear() {
        aea().edit().clear().apply();
    }

    public void aeb() {
        aea().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        aea().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        aea().putString(str, str2);
    }

    public void putLong(String str, long j) {
        aea().putLong(str, j);
    }

    public void remove(String str) {
        this.bSH.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return aea().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return aea().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return aea().getLong(str, j);
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
            public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                boolean z2 = false;
                h hVar = new h();
                if (a.DEBUG && com.baidu.swan.apps.ah.a.a.aaH()) {
                    hVar.aez();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar);
                } else {
                    if (z) {
                        if (eVar.bTC <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.bTC == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        a.this.b(context, str, z, new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.swan.apps.as.d.b
                            /* renamed from: a */
                            public void D(h<b.d> hVar2) {
                                a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) hVar2);
                            }
                        });
                        return;
                    }
                    if (eVar.bTC > 0) {
                        hVar.aez();
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
                public void D(com.baidu.swan.apps.setting.oauth.e eVar) {
                    a.this.a((com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.as.d.b>) bVar, (com.baidu.swan.apps.as.d.b) eVar);
                }
            });
        }
    }

    public boolean ly(String str) {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aaH()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e jH = com.baidu.swan.apps.network.c.b.a.jH(str);
        return (jH == null || jH.forbidden || !jH.aer()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.bSJ.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.aem()) {
            bVar2.h(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.acF().acH().Ha().HV().a(context, z, z2, new String[]{str}, null, z3);
        this.bSJ.put(str, a);
        a.h(bVar).h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(h<b.d> hVar) {
                a.this.bSJ.remove(str);
            }
        });
        this.bSK.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.h(new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.4.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void D(h<b.d> hVar) {
                        finish();
                    }
                });
                a.ael();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.as.d.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0292a<a>) new AbstractC0292a<com.baidu.swan.apps.as.d.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0292a
            /* renamed from: g */
            public void M(com.baidu.swan.apps.as.d.b<ResulT> bVar2) {
                bVar2.D(result);
            }
        });
    }

    public boolean aec() {
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH == null) {
            com.baidu.swan.apps.res.widget.b.d.q(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        GH.ha("navigateTo").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.bJZ.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.bJZ.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.bJZ.clear();
    }

    public synchronized void aed() {
        this.bSJ.clear();
        this.bSK.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0292a<CallBackT> abstractC0292a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0292a<a>) abstractC0292a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0292a<CallBackT> abstractC0292a) {
        g(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0292a.M(callbackt);
            }
        });
    }

    public void aee() {
        a((Collection) this.bJZ, (AbstractC0292a) new AbstractC0292a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0292a
            /* renamed from: c */
            public void M(b bVar) {
                bVar.aef();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public abstract class AbstractC0292a<CallBackT> {
        abstract void M(CallBackT callbackt);

        private AbstractC0292a() {
        }
    }

    private static void g(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.as.d.b<h<e.c>> bVar) {
        this.bSK.b(new com.baidu.swan.apps.as.c.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.acF().acH().Ha().HV().a(activity, aVar, bundle).h(bVar).h(new com.baidu.swan.apps.as.d.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void D(h<e.c> hVar) {
                        finish();
                    }
                }).ael();
            }
        });
    }
}

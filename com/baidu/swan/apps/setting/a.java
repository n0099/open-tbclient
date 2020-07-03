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
    private g cIl;
    public final String cIm;
    private final Map<String, com.baidu.swan.apps.setting.oauth.a.b> cIn;
    public final c cIo;
    private final Set<b> cze;
    public final String name;

    /* loaded from: classes11.dex */
    public interface b {
        void ars();
    }

    public a(e eVar) {
        super(eVar);
        this.cze = new HashSet();
        this.cIn = new HashMap();
        this.cIo = new c();
        this.name = com.baidu.swan.apps.storage.b.e(eVar);
        this.cIm = "aiapp_setting_" + this.name;
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        clearCallbacks();
        this.cIn.clear();
    }

    public void onActivityResume(Activity activity) {
    }

    private g arn() {
        if (this.cIl == null) {
            this.cIl = new g(this.cIm, false);
        }
        return this.cIl;
    }

    public void clear() {
        arn().edit().clear().apply();
    }

    public void aro() {
        arn().edit().clear().commit();
    }

    public void putBoolean(String str, boolean z) {
        arn().putBoolean(str, z);
    }

    public void putString(String str, String str2) {
        arn().putString(str, str2);
    }

    public void putLong(String str, long j) {
        arn().putLong(str, j);
    }

    public void remove(String str) {
        this.cIl.remove(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return arn().getBoolean(str, z);
    }

    public String getString(String str, String str2) {
        return arn().getString(str, str2);
    }

    public long getLong(String str, long j) {
        return arn().getLong(str, j);
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
                if (a.DEBUG && com.baidu.swan.apps.af.a.a.any()) {
                    hVar.arM();
                    hVar.mData = new b.d(true, null);
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                } else if (eVar == null || eVar.forbidden) {
                    hVar.a(new OAuthException(10005));
                    a.this.a((com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.aq.e.b>) bVar, (com.baidu.swan.apps.aq.e.b) hVar);
                    com.baidu.swan.apps.statistic.h.b(10005, eVar);
                } else {
                    if (z) {
                        if (eVar.cJe <= 0) {
                            z2 = true;
                        }
                    } else if (eVar.cJe == 0) {
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
                    if (eVar.cJe > 0) {
                        hVar.arM();
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

    public boolean ot(String str) {
        if (DEBUG && com.baidu.swan.apps.af.a.a.any()) {
            return true;
        }
        com.baidu.swan.apps.setting.oauth.e mq = com.baidu.swan.apps.network.c.b.a.mq(str);
        return (mq == null || mq.forbidden || !mq.arE()) ? false : true;
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
        com.baidu.swan.apps.setting.oauth.a.b bVar2 = this.cIn.get(str);
        if (bVar2 != null && TaskState.FINISHED != bVar2.arz()) {
            bVar2.q(bVar);
            return;
        }
        final com.baidu.swan.apps.setting.oauth.a.b a = d.apI().apK().Se().TF().a(context, z, z2, new String[]{str}, null, z3);
        this.cIn.put(str, a);
        a.q(bVar).q(new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(h<b.d> hVar) {
                a.this.cIn.remove(str);
            }
        });
        this.cIo.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.4
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
                a.ary();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ResulT> void a(com.baidu.swan.apps.aq.e.b<ResulT> bVar, final ResulT result) {
        a((a) bVar, (AbstractC0392a<a>) new AbstractC0392a<com.baidu.swan.apps.aq.e.b<ResulT>>() { // from class: com.baidu.swan.apps.setting.a.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0392a
            /* renamed from: p */
            public void R(com.baidu.swan.apps.aq.e.b<ResulT> bVar2) {
                bVar2.H(result);
            }
        });
    }

    public boolean arp() {
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_open_fragment_failed_toast).showToast();
            return false;
        }
        RN.jx("navigateTo").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).a("setting", null).commit();
        return true;
    }

    public synchronized void a(b bVar) {
        this.cze.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.cze.remove(bVar);
    }

    public synchronized void clearCallbacks() {
        this.cze.clear();
    }

    public synchronized void arq() {
        this.cIn.clear();
        this.cIo.clear();
        clearCallbacks();
    }

    public synchronized <CallBackT> void a(Collection<CallBackT> collection, AbstractC0392a<CallBackT> abstractC0392a) {
        for (CallBackT callbackt : collection) {
            a((a) callbackt, (AbstractC0392a<a>) abstractC0392a);
        }
    }

    public synchronized <CallBackT> void a(final CallBackT callbackt, final AbstractC0392a<CallBackT> abstractC0392a) {
        k(new Runnable() { // from class: com.baidu.swan.apps.setting.a.6
            @Override // java.lang.Runnable
            public void run() {
                abstractC0392a.R(callbackt);
            }
        });
    }

    public void arr() {
        a((Collection) this.cze, (AbstractC0392a) new AbstractC0392a<b>() { // from class: com.baidu.swan.apps.setting.a.7
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.baidu.swan.apps.setting.a.AbstractC0392a
            /* renamed from: c */
            public void R(b bVar) {
                bVar.ars();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.setting.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public abstract class AbstractC0392a<CallBackT> {
        abstract void R(CallBackT callbackt);

        private AbstractC0392a() {
        }
    }

    private static void k(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public void a(final Activity activity, final b.a aVar, final Bundle bundle, final com.baidu.swan.apps.aq.e.b<h<e.c>> bVar) {
        this.cIo.b(new com.baidu.swan.apps.aq.d.a() { // from class: com.baidu.swan.apps.setting.a.8
            @Override // java.lang.Runnable
            public void run() {
                d.apI().apK().Se().TF().a(activity, aVar, bundle).q(bVar).q(new com.baidu.swan.apps.aq.e.b<h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.8.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: a */
                    public void H(h<e.c> hVar) {
                        finish();
                    }
                }).ary();
            }
        });
    }
}

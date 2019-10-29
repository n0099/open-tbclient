package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.ae.c {
    private final com.baidu.swan.apps.an.c.c aEs;
    private String aEt;

    public b(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        com.baidu.swan.apps.v.b.b AJ;
        this.aEs = new com.baidu.swan.apps.an.c.c();
        String str = "";
        if (bVar != null && (AJ = bVar.AJ()) != null) {
            str = AJ.Ks().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.aEs.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.u.a.Jn().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.u.a.Jn().bd(context);
    }

    public String getUid(@NonNull Context context) {
        String be = com.baidu.swan.apps.u.a.Jn().be(context);
        setUid(be);
        return be;
    }

    @NonNull
    public String AW() {
        return TextUtils.isEmpty(this.aEt) ? "" : this.aEt;
    }

    public void setUid(String str) {
        this.aEt = str;
    }

    public synchronized void clear() {
        this.aEs.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a extends com.baidu.swan.apps.an.c.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a aEw;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.aEw = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.aEw != null) {
                this.aEw.onResult(i);
            }
            finish();
        }
    }
}

package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.ae.c {
    private final com.baidu.swan.apps.an.c.c aEa;
    private String aEb;

    public b(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        com.baidu.swan.apps.v.b.b AK;
        this.aEa = new com.baidu.swan.apps.an.c.c();
        String str = "";
        if (bVar != null && (AK = bVar.AK()) != null) {
            str = AK.Kt().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.aEa.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.u.a.Jo().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return com.baidu.swan.apps.u.a.Jo().bd(context);
    }

    public String getUid(@NonNull Context context) {
        String be = com.baidu.swan.apps.u.a.Jo().be(context);
        setUid(be);
        return be;
    }

    @NonNull
    public String AX() {
        return TextUtils.isEmpty(this.aEb) ? "" : this.aEb;
    }

    public void setUid(String str) {
        this.aEb = str;
    }

    public synchronized void clear() {
        this.aEa.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a extends com.baidu.swan.apps.an.c.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a aEe;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.aEe = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.aEe != null) {
                this.aEe.onResult(i);
            }
            finish();
        }
    }
}

package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.ae.c {
    private final com.baidu.swan.apps.an.b.c ajC;
    private String ajD;

    public b(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        com.baidu.swan.apps.v.b.b uB;
        this.ajC = new com.baidu.swan.apps.an.b.c();
        String str = "";
        if (bVar != null && (uB = bVar.uB()) != null) {
            str = uB.DC().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.ajC.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.u.a.CD().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean bk(Context context) {
        return com.baidu.swan.apps.u.a.CD().bH(context);
    }

    public String bl(@NonNull Context context) {
        String bI = com.baidu.swan.apps.u.a.CD().bI(context);
        setUid(bI);
        return bI;
    }

    @NonNull
    public String uO() {
        return TextUtils.isEmpty(this.ajD) ? "" : this.ajD;
    }

    public void setUid(String str) {
        this.ajD = str;
    }

    public synchronized void clear() {
        this.ajC.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a extends com.baidu.swan.apps.an.b.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a ajG;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.ajG = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.ajG != null) {
                this.ajG.onResult(i);
            }
            finish();
        }
    }
}

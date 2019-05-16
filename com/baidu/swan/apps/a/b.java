package com.baidu.swan.apps.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.apps.ae.c {
    private final com.baidu.swan.apps.an.c.c ajW;
    private String ajX;

    public b(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
        com.baidu.swan.apps.v.b.b vk;
        this.ajW = new com.baidu.swan.apps.an.c.c();
        String str = "";
        if (bVar != null && (vk = bVar.vk()) != null) {
            str = vk.EK().getString("extra_data_uid_key", "");
        }
        setUid(str);
    }

    private void a(a aVar) {
        this.ajW.b(aVar);
    }

    public void a(final Activity activity, final Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a(new a(aVar) { // from class: com.baidu.swan.apps.a.b.1
            @Override // com.baidu.swan.apps.a.b.a
            protected void a(com.baidu.swan.apps.a.a aVar2) {
                com.baidu.swan.apps.u.a.DG().a(activity, bundle, aVar2);
            }
        });
    }

    public boolean aD(Context context) {
        return com.baidu.swan.apps.u.a.DG().bb(context);
    }

    public String aE(@NonNull Context context) {
        String bc = com.baidu.swan.apps.u.a.DG().bc(context);
        setUid(bc);
        return bc;
    }

    @NonNull
    public String vx() {
        return TextUtils.isEmpty(this.ajX) ? "" : this.ajX;
    }

    public void setUid(String str) {
        this.ajX = str;
    }

    public synchronized void clear() {
        this.ajW.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class a extends com.baidu.swan.apps.an.c.a implements com.baidu.swan.apps.a.a {
        private final com.baidu.swan.apps.a.a aka;

        protected abstract void a(com.baidu.swan.apps.a.a aVar);

        private a(com.baidu.swan.apps.a.a aVar) {
            this.aka = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this);
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            if (this.aka != null) {
                this.aka.onResult(i);
            }
            finish();
        }
    }
}

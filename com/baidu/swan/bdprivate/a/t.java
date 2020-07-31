package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.api.module.a.b;
/* loaded from: classes11.dex */
public class t implements com.baidu.swan.apps.adaptation.a.h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.adaptation.a.h
    public com.baidu.swan.apps.adaptation.a.c Uf() {
        return new a();
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.swan.apps.adaptation.a.c {
        private a() {
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.a a(Activity activity, boolean z, String str, String str2) {
            return new n(activity, z, str, str2);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.b a(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            return new o(context, z, z2, strArr, str, z3);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.e a(Activity activity, b.a aVar, Bundle bundle) {
            return new r(activity, aVar, bundle);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.c c(Activity activity, String str) {
            return new p(activity, str);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.d bc(Context context) {
            return new q(context);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.f a(Activity activity, String str, String str2, boolean z, boolean z2) {
            return new s(activity, str, str2, z, z2);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.h
    public com.baidu.swan.apps.adaptation.a.b Ug() {
        return new m();
    }
}

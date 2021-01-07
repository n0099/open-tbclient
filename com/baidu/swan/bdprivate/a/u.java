package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.module.a.b;
/* loaded from: classes9.dex */
public class u implements com.baidu.swan.apps.adaptation.a.i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.adaptation.a.i
    public com.baidu.swan.apps.adaptation.a.c alH() {
        return new a();
    }

    /* loaded from: classes9.dex */
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
        public com.baidu.swan.apps.setting.oauth.a.f a(Activity activity, b.a aVar, Bundle bundle) {
            return new s(activity, aVar, bundle);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.c ac(Context context, String str) {
            return new p(context, str);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.e bZ(Context context) {
            return new r(context);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.d ca(Context context) {
            return new q(context);
        }

        @Override // com.baidu.swan.apps.adaptation.a.c
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.g a(Activity activity, String str, String str2, boolean z, boolean z2) {
            return new t(activity, str, str2, z, z2);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.i
    public com.baidu.swan.apps.adaptation.a.b alI() {
        return new m();
    }
}

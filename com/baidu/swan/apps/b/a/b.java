package com.baidu.swan.apps.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.b.b.p;
import com.baidu.swan.apps.setting.a.g;
import okhttp3.OkHttpClient;
/* loaded from: classes2.dex */
public class b implements com.baidu.swan.apps.b.b.d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static c ajI;

    /* loaded from: classes2.dex */
    public interface c {
        com.baidu.swan.apps.b.b.b uW();
    }

    public static void a(c cVar) {
        ajI = cVar;
    }

    @Override // com.baidu.swan.apps.b.b.d
    public p a(@NonNull com.baidu.swan.apps.core.i.c cVar) {
        return new C0086b();
    }

    @Override // com.baidu.swan.apps.b.b.d
    public com.baidu.swan.apps.b.b.b uT() {
        return ajI != null ? ajI.uW() : new a();
    }

    @Override // com.baidu.swan.apps.b.b.d
    public com.baidu.swan.apps.b.b.a uU() {
        return new com.baidu.swan.apps.b.a.a();
    }

    @Override // com.baidu.swan.apps.b.b.d
    public OkHttpClient uV() {
        return new OkHttpClient.Builder().build();
    }

    /* renamed from: com.baidu.swan.apps.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0086b implements p {
        private C0086b() {
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.core.f.a i(Context context, int i) {
            return new com.baidu.swan.apps.core.f.b().j(context, i);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.c bn(Context context) {
            return new com.baidu.swan.apps.core.h.c(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.a bo(Context context) {
            return new com.baidu.swan.apps.core.b.d(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.a bp(Context context) {
            return new com.baidu.swan.games.c.f(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.f bq(Context context) {
            return new com.baidu.swan.apps.view.c(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.f br(Context context) {
            return new com.baidu.swan.apps.d.c(context);
        }
    }

    /* loaded from: classes2.dex */
    private static class a implements com.baidu.swan.apps.b.b.b {
        private a() {
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.a a(Activity activity, boolean z, String str) {
            return new com.baidu.swan.apps.setting.oauth.a.a(activity, z, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.b a(Activity activity, boolean z, String str, boolean z2) {
            return new com.baidu.swan.apps.setting.oauth.a.b(activity, z, str, z2);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.e a(Activity activity, g.a aVar, Bundle bundle) {
            return new com.baidu.swan.apps.setting.oauth.a.e(activity, aVar, bundle);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.c c(Activity activity, String str) {
            return new com.baidu.swan.apps.setting.oauth.a.c(activity, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.d u(Activity activity) {
            return new com.baidu.swan.apps.setting.oauth.a.d(activity);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.f b(Activity activity, String str, String str2) {
            return new com.baidu.swan.apps.setting.oauth.a.f(activity, str, str2);
        }
    }
}

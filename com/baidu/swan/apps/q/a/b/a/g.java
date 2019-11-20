package com.baidu.swan.apps.q.a.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.b.b.p;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.tieba.aiapps.apps.a.m;
import okhttp3.OkHttpClient;
/* loaded from: classes4.dex */
public class g implements com.baidu.swan.apps.b.b.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.b.b.d
    public p a(@NonNull com.baidu.swan.apps.core.j.c cVar) {
        return new b();
    }

    @Override // com.baidu.swan.apps.b.b.d
    public com.baidu.swan.apps.b.b.b Bz() {
        return new a();
    }

    @Override // com.baidu.swan.apps.b.b.d
    public OkHttpClient BB() {
        return new OkHttpClient.Builder().build();
    }

    /* loaded from: classes4.dex */
    private class b implements p {
        private b() {
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.core.g.a f(Context context, int i) {
            return new com.baidu.swan.apps.core.g.b().g(context, i);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.c aI(Context context) {
            return new com.baidu.swan.apps.core.i.c(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.a aJ(Context context) {
            return new com.baidu.swan.apps.core.c.d(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.a aK(Context context) {
            return new com.baidu.swan.games.c.g(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.f aL(Context context) {
            return new com.baidu.swan.apps.view.c(context);
        }

        @Override // com.baidu.swan.apps.b.b.p
        public com.baidu.swan.apps.b.c.f aM(Context context) {
            return new com.baidu.swan.apps.d.d(context);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements com.baidu.swan.apps.b.b.b {
        private a() {
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.a a(Activity activity, boolean z, String str) {
            return new com.baidu.swan.apps.q.a.b.a.a(activity, z, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.b a(Activity activity, boolean z, String str, boolean z2) {
            return new com.baidu.swan.apps.q.a.b.a.b(activity, z, str, z2);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.e a(Activity activity, g.a aVar, Bundle bundle) {
            return new e(activity, aVar, bundle);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.c c(Activity activity, String str) {
            return new c(activity, str);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.d w(Activity activity) {
            return new d(activity);
        }

        @Override // com.baidu.swan.apps.b.b.b
        @NonNull
        public com.baidu.swan.apps.setting.oauth.a.f b(Activity activity, String str, String str2) {
            return new f(activity, str, str2);
        }
    }

    @Override // com.baidu.swan.apps.b.b.d
    public com.baidu.swan.apps.b.b.a BA() {
        return new m();
    }
}

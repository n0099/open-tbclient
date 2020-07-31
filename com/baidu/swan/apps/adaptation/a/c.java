package com.baidu.swan.apps.adaptation.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.api.module.a.b;
/* loaded from: classes7.dex */
public interface c {
    @NonNull
    com.baidu.swan.apps.setting.oauth.a.a a(Activity activity, boolean z, String str, String str2);

    @NonNull
    com.baidu.swan.apps.setting.oauth.a.b a(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3);

    @NonNull
    com.baidu.swan.apps.setting.oauth.a.e a(Activity activity, b.a aVar, Bundle bundle);

    @NonNull
    com.baidu.swan.apps.setting.oauth.a.f a(Activity activity, String str, String str2, boolean z, boolean z2);

    @NonNull
    com.baidu.swan.apps.setting.oauth.a.d bc(Context context);

    @NonNull
    com.baidu.swan.apps.setting.oauth.a.c c(Activity activity, String str);
}

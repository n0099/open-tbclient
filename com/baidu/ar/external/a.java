package com.baidu.ar.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import com.baidu.ar.external.ARCallback;
/* loaded from: classes3.dex */
public interface a {
    void a(Context context, String str);

    void a(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, ShareResultListener shareResultListener);

    void a(Context context, String str, Object... objArr);

    void a(Bitmap bitmap);

    void a(Fragment fragment);

    void a(Fragment fragment, ARCallback.ARAction aRAction);

    boolean a();

    Bitmap b();
}

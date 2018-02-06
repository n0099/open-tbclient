package com.baidu.ar.external.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import com.baidu.ar.external.a.a.b;
import com.baidu.ar.external.a.a.c;
import com.baidu.ar.external.a.a.d;
import com.baidu.ar.external.a.a.e;
/* loaded from: classes3.dex */
public interface IARCallback {

    /* loaded from: classes3.dex */
    public enum ARAction {
        BACK,
        SWITCHTOBARCODE
    }

    void executeCommand(Context context, String str);

    void executeCommandWithO2O(Context context, String str);

    Bitmap getPreviewBitmap();

    c getUserInfo();

    void getUserInfo(d dVar);

    void isLogin(d dVar);

    boolean isLogin();

    void login(b bVar);

    void openNuomiScheme(String str);

    void quitAR(Fragment fragment, ARAction aRAction);

    void rescan(Fragment fragment);

    void setPreviewBitmap(Bitmap bitmap);

    void share(String str, String str2, String str3, String str4, int i);

    void shareSyncForPlugin(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, e eVar);

    void transparentLink(String str);
}

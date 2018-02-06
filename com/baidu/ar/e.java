package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.util.o;
/* loaded from: classes3.dex */
public class e implements IARCallback {
    private static final boolean EXTERNAL_DEBUG = false;
    private IARCallback mExternalClient;

    private void setWillQuitAR(Fragment fragment) {
        if (fragment == null || !(fragment instanceof ARFragment)) {
            return;
        }
        ((ARFragment) fragment).setWillQuitAR();
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void executeCommand(Context context, String str) {
        if (this.mExternalClient != null) {
            this.mExternalClient.executeCommand(context, str);
        } else {
            o.a(context, str);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void executeCommandWithO2O(Context context, String str) {
        if (this.mExternalClient != null) {
            this.mExternalClient.executeCommandWithO2O(context, str);
        } else {
            o.a(context, str);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public Bitmap getPreviewBitmap() {
        if (this.mExternalClient != null) {
            com.baidu.ar.util.b.a("bdar: mExternalClient getPreviewBitmap");
            return this.mExternalClient.getPreviewBitmap();
        }
        return null;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public com.baidu.ar.external.a.a.c getUserInfo() {
        if (this.mExternalClient != null) {
            return this.mExternalClient.getUserInfo();
        }
        return null;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void getUserInfo(com.baidu.ar.external.a.a.d dVar) {
        if (this.mExternalClient != null) {
            this.mExternalClient.getUserInfo(dVar);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void isLogin(com.baidu.ar.external.a.a.d dVar) {
        if (this.mExternalClient != null) {
            this.mExternalClient.isLogin(dVar);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public boolean isLogin() {
        if (this.mExternalClient != null) {
            return this.mExternalClient.isLogin();
        }
        return false;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void login(com.baidu.ar.external.a.a.b bVar) {
        if (this.mExternalClient != null) {
            this.mExternalClient.login(bVar);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void openNuomiScheme(String str) {
        if (this.mExternalClient != null) {
            this.mExternalClient.openNuomiScheme(str);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void quitAR(Fragment fragment, IARCallback.ARAction aRAction) {
        if (this.mExternalClient != null) {
            setWillQuitAR(fragment);
            this.mExternalClient.quitAR(fragment, aRAction);
        } else if (fragment != null) {
            fragment.getActivity().finish();
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void rescan(Fragment fragment) {
        if (this.mExternalClient != null) {
            setWillQuitAR(fragment);
            this.mExternalClient.rescan(fragment);
        } else if (fragment != null) {
            fragment.getActivity().finish();
        }
    }

    public void setARCallbackClient(IARCallback iARCallback) {
        this.mExternalClient = iARCallback;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void setPreviewBitmap(Bitmap bitmap) {
        if (this.mExternalClient != null) {
            this.mExternalClient.setPreviewBitmap(bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
        } else {
            bitmap.recycle();
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void share(String str, String str2, String str3, String str4, int i) {
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void shareSyncForPlugin(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, com.baidu.ar.external.a.a.e eVar) {
        if (this.mExternalClient != null) {
            this.mExternalClient.shareSyncForPlugin(context, str, str2, str3, bitmap, str4, str5, z, z2, eVar);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void transparentLink(String str) {
    }
}

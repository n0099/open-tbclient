package com.baidu.sapi2.share;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.AES;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
/* loaded from: classes6.dex */
class s implements Runnable {
    final /* synthetic */ ShareStorage.StorageModel a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar, ShareStorage.StorageModel storageModel) {
        this.b = tVar;
        this.a = storageModel;
    }

    @Override // java.lang.Runnable
    @TargetApi(8)
    public void run() {
        Context context;
        String str;
        LoginShareStrategy loginShareStrategy = SapiAccountManager.getInstance().getConfignation().loginShareStrategy();
        String loginShareDirection = SapiAccountManager.getInstance().getConfignation().loginShareDirection();
        if (loginShareStrategy == LoginShareStrategy.DISABLED || com.baidu.sapi2.utils.enums.a.a.equals(loginShareDirection)) {
            this.a.b = 1;
        }
        context = this.b.a.h;
        String md5 = MD5Util.toMd5(context.getPackageName().getBytes(), false);
        try {
            str = new String(Base64.encode(new AES().encrypt(this.a.a().toString(), "2314906973403010", "w0d4o27mh3k1e461"), 0));
        } catch (Exception e) {
            Log.e(e);
            str = "";
        }
        this.b.a.setSp(md5, str);
        this.b.a.setSd(md5, str);
    }
}

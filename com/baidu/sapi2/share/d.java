package com.baidu.sapi2.share;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ShareModel shareModel) {
        if (shareModel == null) {
            throw new IllegalArgumentException("ShareModel can't be null");
        }
        if (shareModel.c() == null) {
            throw new IllegalArgumentException("Event can't be null");
        }
        Intent intent = new Intent("baidu.intent.action.SHARE_V6");
        if (TextUtils.isEmpty(shareModel.e())) {
            shareModel.a(this.a.getPackageName());
        }
        try {
            shareModel.a(this.a);
            intent.putExtra("LOGIN_SHARE_MODEL", shareModel);
            if (com.baidu.sapi2.d.a(this.a).i() != null) {
                intent.putExtra("RELOGIN_CREDENTIALS", a.a(this.a, com.baidu.sapi2.d.a(this.a).i().toString()));
            }
            this.a.sendBroadcast(intent, "com.baidu.permission.SHARE");
        } catch (Throwable th) {
            L.e(th);
        }
    }
}

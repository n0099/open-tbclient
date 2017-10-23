package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {
    protected com.baidu.sofire.rp.d.a Qc;
    protected Context b;
    private Handler c = null;

    public a(Context context) {
        this.Qc = new com.baidu.sofire.rp.d.a(context);
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String g(String str, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Qc.g(str, bArr);
    }

    public final String a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Qc.a(str);
    }
}

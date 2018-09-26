package com.baidu.ar;

import android.content.Context;
import com.baidu.aip.auth.Auth;
import com.baidu.ar.bean.IToken;
/* loaded from: classes3.dex */
public class a implements IToken {
    private static Auth b;
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    private static Auth b() {
        if (b == null) {
            b = new Auth();
        }
        return b;
    }

    public void a() {
        this.a = null;
    }

    @Override // com.baidu.ar.bean.IToken
    public String getToken() {
        try {
            if (this.a != null) {
                return b().getToken(this.a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}

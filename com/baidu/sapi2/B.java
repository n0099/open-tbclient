package com.baidu.sapi2;

import android.os.Looper;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class B extends HttpHandlerWrap {
    final /* synthetic */ String a;
    final /* synthetic */ OneKeyLoginCallback b;
    final /* synthetic */ String c;
    final /* synthetic */ OneKeyLoginResult d;
    final /* synthetic */ L e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(L l, Looper looper, String str, OneKeyLoginCallback oneKeyLoginCallback, String str2, OneKeyLoginResult oneKeyLoginResult) {
        super(looper);
        this.e = l;
        this.a = str;
        this.b = oneKeyLoginCallback;
        this.c = str2;
        this.d = oneKeyLoginResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onFailure(Throwable th, int i, String str) {
        new com.baidu.sapi2.outsdk.c().b(this.b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
    public void onSuccess(int i, String str) {
        String str2;
        String md5 = SecurityUtil.md5(str.getBytes(), false);
        String str3 = this.a;
        if (str3 != null && !str3.equals(md5)) {
            str2 = L.a;
            Log.d(str2, "oneKeyLogin check javsScript MD5 failed");
            new com.baidu.sapi2.outsdk.c().b(this.b, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, null);
            return;
        }
        SapiContext.getInstance().setOneKeyLoginJSCode(str);
        SapiContext.getInstance().setOnekeyLoginJsMd5(this.a);
        OneKeyLoginResult.secondJsCode = this.c;
        this.b.available(this.d);
    }
}

package com.baidu.sapi2;

import android.os.AsyncTask;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.utils.Log;
import java.net.URL;
import java.net.URLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w extends AsyncTask<String, Void, Long> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ SsoHashCallback c;
    final /* synthetic */ L d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(L l, String str, String str2, SsoHashCallback ssoHashCallback) {
        this.d = l;
        this.a = str;
        this.b = str2;
        this.c = ssoHashCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Long doInBackground(String... strArr) {
        try {
            URLConnection openConnection = new URL(strArr[0]).openConnection();
            openConnection.setConnectTimeout(3000);
            openConnection.connect();
            return Long.valueOf(openConnection.getDate() / 1000);
        } catch (Exception e) {
            Log.e(e);
            return 0L;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Long l) {
        SsoHashResult ssoHashResult = new SsoHashResult();
        ssoHashResult.ssoHash = new com.baidu.sapi2.utils.n().a(l, this.a, this.b);
        ssoHashResult.setResultCode(0);
        this.c.onSuccess(ssoHashResult);
    }
}

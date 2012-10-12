package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.w;
import com.baidu.android.pushservice.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b implements Runnable {
    protected Context a;
    protected h b;
    protected boolean d = true;
    protected String c = w.f;

    public b(h hVar, Context context) {
        this.b = hVar;
        this.a = context.getApplicationContext();
    }

    private boolean b() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.c)) {
            this.c += y.a().b();
            ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.a);
            try {
                HttpPost httpPost = new HttpPost(this.c);
                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                ArrayList arrayList = new ArrayList();
                a(arrayList);
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                HttpResponse execute = proxyHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    a(0, b(EntityUtils.toString(execute.getEntity())).getBytes());
                    z = true;
                } else {
                    Log.i("BaseApiProcessor", "networkRegister request failed  " + execute.getStatusLine());
                    a(EntityUtils.toString(execute.getEntity()));
                }
            } catch (Exception e) {
                a(PushConstants.ERROR_UNKNOWN);
            } catch (IOException e2) {
                a(PushConstants.ERROR_SERVICE_NOT_AVAILABLE);
            } finally {
                proxyHttpClient.close();
            }
        }
        return z;
    }

    protected void a() {
        if (this.b == null || TextUtils.isEmpty(this.b.c) || TextUtils.isEmpty(this.b.a)) {
            return;
        }
        if (!ConnectManager.isNetworkConnected(this.a)) {
            a(PushConstants.ERROR_NETWORK_ERROR);
            a.a(this.a);
            return;
        }
        y a = y.a();
        synchronized (a) {
            if (this.d && !y.a().d()) {
                a.a(this.a, false);
                this.d = false;
                try {
                    a.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        if (y.a().d()) {
            b();
        } else {
            a(PushConstants.ERROR_SERVICE_NOT_AVAILABLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        a(i, PushConstants.getErrorMsg(i).getBytes());
    }

    protected void a(int i, byte[] bArr) {
        Intent intent = new Intent(PushConstants.ACTION_RECEIVE);
        intent.putExtra(PushConstants.EXTRA_METHOD, this.b.a);
        intent.putExtra(PushConstants.EXTRA_ERROR_CODE, i);
        intent.putExtra(PushConstants.EXTRA_CONTENT, bArr);
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(this.b.c)) {
            return;
        }
        intent.setPackage(this.b.c);
        this.a.sendBroadcast(intent);
    }

    protected void a(Intent intent) {
    }

    protected void a(String str) {
        if (str == null) {
            return;
        }
        if (!str.startsWith("{\"")) {
            str = str.substring(str.indexOf("{\""));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject.getInt("error_code"), jSONObject.getString(PushConstants.EXTRA_ERROR_CODE).getBytes());
        } catch (JSONException e) {
            Log.e("BaseApiProcessor", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List list) {
        a.a(list);
        if (!TextUtils.isEmpty(this.b.b)) {
            list.add(new BasicNameValuePair("rsa_access_token", this.b.b));
            return;
        }
        list.add(new BasicNameValuePair("rsa_bduss", this.b.f));
        list.add(new BasicNameValuePair("appid", this.b.d));
    }

    protected String b(String str) {
        return str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}

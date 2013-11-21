package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f689a;
    protected l b;
    protected boolean d = true;
    protected String c = com.baidu.android.pushservice.w.f;

    public a(l lVar, Context context) {
        this.b = lVar;
        this.f689a = context.getApplicationContext();
    }

    private void b(int i, byte[] bArr) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.internal.RECEIVE");
        intent.putExtra(PushConstants.EXTRA_METHOD, this.b.f691a);
        intent.putExtra("error_msg", i);
        intent.putExtra("content", bArr);
        intent.putExtra("appid", this.b.f);
        intent.setFlags(32);
        a(intent);
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("BaseBaseApiProcessor", "> sendInternalMethodResult  ,method:" + this.b.f691a + " ,errorCode : " + i + " ,content : " + new String(bArr));
        }
        this.f689a.sendBroadcast(intent);
    }

    protected void a() {
        if (this.b == null || TextUtils.isEmpty(this.b.f691a)) {
            return;
        }
        if (this.b.f691a.equals("com.baidu.android.pushservice.action.UNBIND") || !TextUtils.isEmpty(this.b.e)) {
            if (!ConnectManager.isNetworkConnected(this.f689a)) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("BaseBaseApiProcessor", "Network is not useful!");
                }
                a(PushConstants.ERROR_NETWORK_ERROR);
                b.a(this.f689a);
                if (com.baidu.android.pushservice.b.a()) {
                    Log.i("BaseBaseApiProcessor", "startPushService BaseApiProcess");
                    return;
                }
                return;
            }
            com.baidu.android.pushservice.y a2 = com.baidu.android.pushservice.y.a();
            synchronized (a2) {
                if (this.d && !a2.e()) {
                    a2.a(this.f689a, false);
                    this.d = false;
                    while (!a2.b()) {
                        try {
                            a2.wait();
                        } catch (InterruptedException e) {
                            if (com.baidu.android.pushservice.b.a()) {
                                Log.e("BaseBaseApiProcessor", e.getMessage());
                            }
                        }
                    }
                }
            }
            if (!com.baidu.android.pushservice.y.a().e()) {
                a(PushConstants.ERROR_SERVICE_NOT_AVAILABLE);
                return;
            }
            boolean b = b();
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("BaseBaseApiProcessor", "netWorkConnect connectResult: " + b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        a(i, PushConstants.getErrorMsg(i).getBytes());
    }

    protected void a(int i, byte[] bArr) {
        if (!TextUtils.isEmpty(this.b.b) && this.b.b.equals("internal")) {
            b(i, bArr);
            return;
        }
        Intent intent = new Intent(PushConstants.ACTION_RECEIVE);
        intent.putExtra(PushConstants.EXTRA_METHOD, this.b.f691a);
        intent.putExtra("error_msg", i);
        intent.putExtra("content", bArr);
        intent.setFlags(32);
        a(intent);
        if (this.b.f691a.equals(PushConstants.METHOD_BIND)) {
            com.baidu.android.pushservice.b.a aVar = new com.baidu.android.pushservice.b.a();
            aVar.c("020101");
            aVar.a(System.currentTimeMillis());
            aVar.d(com.baidu.android.pushservice.b.m.d(this.f689a));
            com.baidu.android.pushservice.b.b bVar = new com.baidu.android.pushservice.b.b();
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                aVar.b(jSONObject.getString("request_id"));
                if (i != 0) {
                    aVar.a(jSONObject.getString("error_msg"));
                }
                String string = jSONObject.getJSONObject("response_params").getString("appid");
                com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.f689a).b(string);
                aVar.e(string);
                String string2 = jSONObject.getJSONObject("response_params").getString(PushConstants.EXTRA_USER_ID);
                aVar.e(string);
                bVar.a(string);
                bVar.c(com.baidu.android.pushservice.util.m.b(string2));
                bVar.b(string2);
                if (b != null) {
                    bVar.d(b.f708a);
                    bVar = com.baidu.android.pushservice.util.m.a(bVar, this.f689a, b.f708a);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aVar.a(i);
            com.baidu.android.pushservice.b.s.a(this.f689a, aVar);
            com.baidu.android.pushservice.b.s.a(this.f689a, bVar);
        }
        if (TextUtils.isEmpty(this.b.e)) {
            return;
        }
        intent.setPackage(this.b.e);
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("BaseBaseApiProcessor", "> sendResult to " + this.b.e + " ,method:" + this.b.f691a + " ,errorCode : " + i + " ,content : " + new String(bArr));
        }
        this.f689a.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Intent intent) {
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
            int i = jSONObject.getInt(SocialConstants.PARAM_ERROR_CODE);
            String string = jSONObject.getString("error_msg");
            String string2 = jSONObject.getString("request_id");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_msg", string);
            jSONObject2.put("requestId", string2);
            a(i, jSONObject2.toString().getBytes());
        } catch (JSONException e) {
            Log.e("BaseBaseApiProcessor", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List list) {
        b.a(list);
        if (!TextUtils.isEmpty(this.b.h)) {
            list.add(new BasicNameValuePair("rsa_bduss", this.b.h));
            list.add(new BasicNameValuePair("appid", this.b.f));
        } else if (TextUtils.isEmpty(this.b.d)) {
            list.add(new BasicNameValuePair("apikey", this.b.i));
        } else {
            list.add(new BasicNameValuePair("rsa_access_token", this.b.d));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(String str) {
        return str;
    }

    public boolean b() {
        boolean z;
        boolean z2 = true;
        Log.i("BaseBaseApiProcessor", "networkConnect");
        if (TextUtils.isEmpty(this.c)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("BaseBaseApiProcessor", "mUrl is null");
                return false;
            }
            return false;
        }
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("BaseBaseApiProcessor", "Request Url = " + this.c);
        }
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f689a);
        try {
            try {
                HttpPost httpPost = new HttpPost(this.c);
                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                ArrayList arrayList = new ArrayList();
                a(arrayList);
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                HttpResponse execute = proxyHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    String entityUtils = EntityUtils.toString(execute.getEntity());
                    if (com.baidu.android.pushservice.b.a()) {
                        Log.i("BaseBaseApiProcessor", "<<< networkRegister return string :  " + entityUtils);
                    }
                    a(0, b(entityUtils).getBytes());
                } else {
                    Log.i("BaseBaseApiProcessor", "networkRegister request failed  " + execute.getStatusLine());
                    z = execute.getStatusLine().getStatusCode() == 503;
                    try {
                        String entityUtils2 = EntityUtils.toString(execute.getEntity());
                        if (com.baidu.android.pushservice.b.a()) {
                            Log.i("BaseBaseApiProcessor", "<<< networkRegister return string :  " + entityUtils2);
                        }
                        a(entityUtils2);
                        z2 = false;
                    } catch (Exception e) {
                        e = e;
                        if (com.baidu.android.pushservice.b.a()) {
                            Log.e("BaseBaseApiProcessor", e.getMessage());
                        }
                        if (z) {
                            a(PushConstants.ERROR_SERVICE_NOT_AVAILABLE_TEMP);
                        } else {
                            a(PushConstants.ERROR_UNKNOWN);
                        }
                        return false;
                    }
                }
                proxyHttpClient.close();
                return z2;
            } catch (IOException e2) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("BaseBaseApiProcessor", e2.getMessage());
                    Log.i("BaseBaseApiProcessor", "io exception do something ? ");
                }
                a(PushConstants.ERROR_SERVICE_NOT_AVAILABLE);
                return false;
            } finally {
                proxyHttpClient.close();
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }
}

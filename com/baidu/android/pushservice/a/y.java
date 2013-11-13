package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSDK;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f691a;
    private int b = 5;
    private int c = 0;
    private boolean d = false;

    public y(Context context) {
        this.f691a = context.getApplicationContext();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:3)|4|5|6|(4:8|(1:10)|11|(8:13|(1:15)|16|17|18|19|20|21)(2:36|(1:38)))(2:40|(1:42))|39|17|18|19|20|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0162, code lost:
        if (com.baidu.android.pushservice.b.a() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0164, code lost:
        com.baidu.android.common.logging.Log.e("TokenRequester", r1);
        com.baidu.android.common.logging.Log.i("TokenRequester", "io exception, schedule retry");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0170, code lost:
        r10.d = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x017f, code lost:
        if (com.baidu.android.pushservice.b.a() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0181, code lost:
        com.baidu.android.common.logging.Log.e("TokenRequester", "Connect Exception:" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0199, code lost:
        r10.d = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a6, code lost:
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01a8, code lost:
        r1 = e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        HttpResponse execute;
        boolean z = true;
        String str = com.baidu.android.pushservice.w.e;
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("TokenRequester", ">>> token request:" + str);
        }
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f691a);
        try {
            try {
                HttpPost httpPost = new HttpPost(str);
                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                httpPost.setEntity(new UrlEncodedFormEntity(c(), "UTF-8"));
                execute = proxyHttpClient.execute(httpPost);
            } finally {
                proxyHttpClient.close();
            }
        } catch (IOException e) {
            z = false;
            IOException e2 = e;
        } catch (Exception e3) {
            z = false;
            Exception e4 = e3;
        }
        if (execute.getStatusLine().getStatusCode() == 200) {
            String entityUtils = EntityUtils.toString(execute.getEntity());
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("TokenRequester", "<<< RequestToken return string :  " + entityUtils);
            }
            JSONObject jSONObject = new JSONObject(entityUtils).getJSONObject("response_params");
            if (jSONObject != null) {
                String string = jSONObject.getString("channel_id");
                String string2 = jSONObject.getString("rsa_channel_token");
                String string3 = jSONObject.getString("expires_time");
                if (com.baidu.android.pushservice.b.a()) {
                    Log.i("TokenRequester", "RequestToken channelId :  " + string);
                    Log.i("TokenRequester", "RequestToken rsaChannelToken :  " + string2);
                    Log.i("TokenRequester", "RequestToken expiresTime :  " + string3);
                }
                com.baidu.android.pushservice.y.a().a(string, string2);
                this.c = 0;
                this.d = false;
                return z;
            } else if (com.baidu.android.pushservice.b.a()) {
                Log.i("TokenRequester", "RequestToken failed :  " + entityUtils);
            }
        } else if (com.baidu.android.pushservice.b.a()) {
            Log.i("TokenRequester", "RequestToken request failed  " + execute.getStatusLine());
            Log.i("TokenRequester", "<<< RequestToken return string :  " + EntityUtils.toString(execute.getEntity()));
        }
        z = false;
        this.c = 0;
        this.d = false;
        return z;
    }

    private List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, SocialConstants.TOKEN_RESPONSE_TYPE));
        b.a(arrayList);
        arrayList.add(new BasicNameValuePair("device_type", "3"));
        arrayList.add(new BasicNameValuePair("rsa_device_id", Base64.encode(RSAUtil.encryptByPublicKey(DeviceId.getDeviceID(this.f691a).getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n"), BdUtil.UTF8)));
        arrayList.add(new BasicNameValuePair("device_name", Build.MODEL));
        SharedPreferences sharedPreferences = this.f691a.getSharedPreferences(this.f691a.getPackageName(), 1);
        int i = sharedPreferences.getInt("com.baidu.android.pushservice.PushManager.LOGIN_TYPE", -1);
        String string = sharedPreferences.getString("com.baidu.android.pushservice.PushManager.LONGIN_VALUE", "");
        if (i == 2) {
            arrayList.add(new BasicNameValuePair("rsa_bduss", PushConstants.rsaEncrypt(sharedPreferences.getString("com.baidu.android.pushservice.PushManager.BDUSS", ""))));
            arrayList.add(new BasicNameValuePair("appid", string));
        } else if (i == 0) {
            arrayList.add(new BasicNameValuePair("rsa_access_token", PushConstants.rsaEncrypt(string)));
        } else {
            arrayList.add(new BasicNameValuePair("apikey", string));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] b = com.baidu.android.pushservice.util.m.b(this.f691a);
        jSONObject.put("screen_height", b[0]);
        jSONObject.put("screen_width", b[1]);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("isroot", com.baidu.android.pushservice.util.m.a(this.f691a) ? 1 : 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.util.m.e(this.f691a, this.f691a.getPackageName()) ? 1 : 0);
        jSONObject.put(PushConstants.EXTRA_PUSH_SDK_VERSION, 13);
        arrayList.add(new BasicNameValuePair("info", jSONObject.toString()));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Log.d("TokenRequester", "TOKEN param -- " + ((NameValuePair) it.next()).toString());
            }
        }
        return arrayList;
    }

    private void d() {
        this.c++;
        if (this.c >= this.b) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("TokenRequester", "hava reconnect " + this.b + " times, all failed.");
            }
            this.d = false;
            return;
        }
        int i = (1 << (this.c - 1)) * 5 * LocationClientOption.MIN_SCAN_SPAN;
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("TokenRequester", "schedule retry-- retry times: " + this.c + "time delay: " + i);
        }
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("TokenRequester", e);
            }
        }
    }

    protected void a() {
        boolean b;
        do {
            b = b();
            if (this.d) {
                d();
            }
            if (this.b <= 0) {
                break;
            }
        } while (this.d);
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("TokenRequester", "RequestTokenThread connectResult: " + b);
        }
        if (!b) {
            com.baidu.android.pushservice.util.m.i(this.f691a);
            return;
        }
        b.b(this.f691a);
        if (PushSDK.mPushConnection != null) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("TokenRequester", "TokenRequester start PushService after Request finish.");
            }
            b.a(this.f691a);
        }
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        synchronized (com.baidu.android.pushservice.y.a()) {
            com.baidu.android.pushservice.y.a().a(true);
            com.baidu.android.pushservice.y.a().notifyAll();
        }
    }
}

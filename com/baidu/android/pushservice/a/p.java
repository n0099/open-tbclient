package com.baidu.android.pushservice.a;

import android.content.Context;
import android.os.Build;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.v;
import com.baidu.android.pushservice.x;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.NetWorkCore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p implements Runnable {
    private Context a;
    private int b = 5;
    private int c = 0;
    private boolean d = false;

    public p(Context context) {
        this.a = context.getApplicationContext();
    }

    private boolean b() {
        JSONObject jSONObject;
        boolean z = true;
        String str = v.d;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.a);
        try {
            HttpPost httpPost = new HttpPost(str);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(new UrlEncodedFormEntity(c(), "UTF-8"));
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() != 200 || (jSONObject = new JSONObject(EntityUtils.toString(execute.getEntity())).getJSONObject("response_params")) == null) {
                z = false;
            } else {
                String string = jSONObject.getString("channel_id");
                String str2 = new String(RSAUtil.decryptByPublicKey(Base64.decode(jSONObject.getString("rsa_channel_token").getBytes()), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n"));
                jSONObject.getString("expires_time");
                x.a().a(string, str2);
            }
            this.c = 0;
            this.d = false;
            return z;
        } catch (Exception e) {
            this.d = false;
            return false;
        } catch (IOException e2) {
            this.d = true;
            return false;
        } finally {
            proxyHttpClient.close();
        }
    }

    private List c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "token"));
        a.a(arrayList);
        arrayList.add(new BasicNameValuePair("device_type", NetWorkCore.NET_TYPE_WIFI));
        arrayList.add(new BasicNameValuePair("rsa_device_id", Base64.encode(RSAUtil.encryptByPublicKey(DeviceId.getDeviceID(this.a).getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n"), "utf-8")));
        arrayList.add(new BasicNameValuePair("device_name", Build.MODEL));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_level", Build.VERSION.SDK_INT);
        int[] b = com.baidu.android.pushservice.b.d.b(this.a);
        jSONObject.put("screen_height", b[0]);
        jSONObject.put("screen_width", b[1]);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("isroot", com.baidu.android.pushservice.b.d.a(this.a) ? 1 : 0);
        jSONObject.put("is_baidu_app", com.baidu.android.pushservice.b.d.c(this.a, this.a.getPackageName()) ? 1 : 0);
        arrayList.add(new BasicNameValuePair(LoginActivity.INFO, jSONObject.toString()));
        return arrayList;
    }

    private void d() {
        this.c++;
        if (this.c < this.b) {
            try {
                Thread.sleep((1 << (this.c - 1)) * 5 * 1000);
                return;
            } catch (InterruptedException e) {
                return;
            }
        }
        com.baidu.android.pushservice.b.d.c(this.a);
        this.d = false;
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
        if (b) {
            a.b(this.a);
            if (PushService.a != null) {
                a.a(this.a);
            }
        }
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        synchronized (x.a()) {
            x.a().notifyAll();
        }
    }
}

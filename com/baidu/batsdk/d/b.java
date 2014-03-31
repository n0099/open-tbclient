package com.baidu.batsdk.d;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static Map<String, Object> a(Map<String, Object> map) {
        JSONObject jSONObject;
        try {
            byte[] bytes = new JSONObject(map).toString().getBytes("UTF-8");
            HttpPost httpPost = new HttpPost("http://batsdk.baidu.com/batsdk/api/sync");
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bytes);
            com.baidu.batsdk.f.a.b("sendSignAndRecvSync post bytes: " + com.baidu.batsdk.b.b.b(bytes.length));
            httpPost.setEntity(byteArrayEntity);
            com.baidu.batsdk.f.a.c("post: " + httpPost.getURI());
            String entityUtils = EntityUtils.toString(a().execute(httpPost).getEntity());
            com.baidu.batsdk.f.a.a("sendSignAndRecvSync return " + entityUtils);
            jSONObject = new JSONObject(entityUtils);
        } catch (JSONException e) {
            com.baidu.batsdk.f.a.b("sendSignAndRecvSync fail.", e);
        } catch (ClientProtocolException e2) {
            com.baidu.batsdk.f.a.b("sendSignAndRecvSync fail.", e2);
        } catch (UnsupportedEncodingException e3) {
            com.baidu.batsdk.f.a.b("sendSignAndRecvSync fail.", e3);
        } catch (IOException e4) {
            com.baidu.batsdk.f.a.b("sendSignAndRecvSync fail.", e4);
        }
        if (((Integer) jSONObject.get("errNo")).intValue() == 0) {
            return com.baidu.batsdk.b.b.a(jSONObject.getJSONObject("syncMsg"));
        }
        com.baidu.batsdk.f.a.d("sendSignAndRecvSync fail. jsonRet:" + jSONObject);
        return null;
    }

    public static boolean a(String str, byte[] bArr) {
        String entityUtils;
        HttpPost httpPost = new HttpPost(str);
        try {
            if (com.baidu.batsdk.a.B) {
                httpPost.addHeader("Content-Type", "application/octet-stream");
                httpPost.addHeader("Content-Encoding", "gzip");
            }
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
            com.baidu.batsdk.f.a.b("sendRecord post bytes: " + com.baidu.batsdk.b.b.b(bArr.length));
            httpPost.setEntity(byteArrayEntity);
            entityUtils = EntityUtils.toString(a().execute(httpPost).getEntity());
            com.baidu.batsdk.f.a.a("sendRecord return " + entityUtils);
        } catch (UnsupportedEncodingException e) {
            com.baidu.batsdk.f.a.b("sendRecord fail.", e);
        } catch (IOException e2) {
            com.baidu.batsdk.f.a.b("sendRecord fail.", e2);
        } catch (RuntimeException e3) {
            com.baidu.batsdk.f.a.b("sendRecord fail.", e3);
        } catch (JSONException e4) {
            com.baidu.batsdk.f.a.b("sendRecord fail.", e4);
        } catch (ClientProtocolException e5) {
            com.baidu.batsdk.f.a.b("sendRecord fail.", e5);
        }
        if (((Integer) new JSONObject(entityUtils).get("errNo")).intValue() == 0) {
            return true;
        }
        return false;
    }
}

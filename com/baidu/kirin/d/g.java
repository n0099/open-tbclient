package com.baidu.kirin.d;

import com.baidu.kirin.KirinConfig;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static long a = 256;
    public static String b = " HTTP.UTF_8";

    public static e a(String str, String str2) {
        d.a("Post_URL : " + str);
        e eVar = new e();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, KirinConfig.CONNECT_TIME_OUT);
        HttpConnectionParams.setSoTimeout(basicHttpParams, KirinConfig.READ_TIME_OUT);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        HttpPost httpPost = new HttpPost(str);
        try {
            StringEntity stringEntity = new StringEntity("content=" + str2, "UTF-8");
            d.a("postdata content : " + str2);
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            d.a("Response_Length : " + ((int) execute.getEntity().getContentLength()));
            int statusCode = execute.getStatusLine().getStatusCode();
            d.a("Status : " + statusCode);
            String entityUtils = EntityUtils.toString(execute.getEntity());
            d.a("Return_Content : " + entityUtils);
            switch (statusCode) {
                case Constants.MEDIA_INFO /* 200 */:
                    try {
                        eVar.a(Integer.parseInt(new JSONObject(entityUtils).getString("errNum")));
                        eVar.a(true);
                    } catch (Exception e) {
                        d.c("Parse Response error!");
                        String exc = e.toString();
                        eVar.a(false);
                        e.printStackTrace();
                        entityUtils = exc;
                    }
                    eVar.a(entityUtils);
                    break;
                default:
                    d.c("Stauts : " + statusCode + "; RetrunConetent : " + entityUtils);
                    eVar.a(false);
                    eVar.a(entityUtils);
                    break;
            }
        } catch (Exception e2) {
            JSONObject jSONObject = new JSONObject();
            e2.printStackTrace();
            try {
                jSONObject.put("err", e2.toString());
                String jSONObject2 = jSONObject.toString();
                eVar.a(false);
                eVar.a(jSONObject2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        d.a("ServerResponse : " + eVar.c());
        return eVar;
    }
}

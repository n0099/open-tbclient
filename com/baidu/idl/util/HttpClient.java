package com.baidu.idl.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/* loaded from: classes15.dex */
public class HttpClient {
    public static String post(String str, String str2) {
        HttpPost httpPost = new HttpPost(str);
        try {
            httpPost.setEntity(new StringEntity(str2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        new ArrayList().add(new BasicNameValuePair("data", str2));
        try {
            HttpResponse execute = new DefaultHttpClient().execute(httpPost);
            StuLogEx.v("HttpClient", " httpResponse.getStatusLine().getStatusCode()  : " + execute.getStatusLine().getStatusCode());
            if (execute.getStatusLine().getStatusCode() != 200) {
                return null;
            }
            return EntityUtils.toString(execute.getEntity());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (ClientProtocolException e3) {
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}

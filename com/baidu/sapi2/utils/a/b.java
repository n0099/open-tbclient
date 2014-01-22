package com.baidu.sapi2.utils.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class b {
    public ArrayList<BasicNameValuePair> a = new ArrayList<>();

    public void a(Object obj, Object obj2) {
        this.a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(next.getName());
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(next.getValue(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    sb.append(next.getValue());
                }
            }
        }
        return sb.toString();
    }
}

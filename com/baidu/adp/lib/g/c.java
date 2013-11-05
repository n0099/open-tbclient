package com.baidu.adp.lib.g;

import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BasicNameValuePair> f486a;

    public void a(Object obj, Object obj2) {
        if (this.f486a == null) {
            this.f486a = new ArrayList<>();
        }
        this.f486a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f486a != null) {
            Iterator<BasicNameValuePair> it = this.f486a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(next.getName());
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(next.getValue(), BdUtil.UTF8));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    sb.append(next.getValue());
                }
            }
        }
        return sb.toString();
    }
}

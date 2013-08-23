package com.baidu.adp.lib.d;

import com.baidu.browser.core.util.BdUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f390a;

    public void a(Object obj, Object obj2) {
        if (this.f390a == null) {
            this.f390a = new ArrayList();
        }
        this.f390a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f390a != null) {
            Iterator it = this.f390a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) it.next();
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(basicNameValuePair.getName());
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(basicNameValuePair.getValue(), BdUtil.UTF8));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    sb.append(basicNameValuePair.getValue());
                }
            }
        }
        return sb.toString();
    }
}

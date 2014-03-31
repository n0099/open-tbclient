package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class p {
    private ArrayList<BasicNameValuePair> a;
    private String b;

    public p(String str) {
        this.b = null;
        this.b = str;
    }

    public p() {
        this.b = null;
    }

    public final void a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.clear();
            String[] split2 = str.split("&");
            if (split2 != null && split2.length != 0) {
                for (String str2 : split2) {
                    if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                        try {
                            this.a.add(new BasicNameValuePair(split[0], URLDecoder.decode(split[1], "utf-8")));
                        } catch (UnsupportedEncodingException e) {
                            com.baidu.adp.lib.util.f.a(getClass(), "parse", e);
                        }
                    }
                }
            }
        }
    }

    public final void a(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.a == null) {
                this.a = new ArrayList<>();
            }
            this.a.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                    if (sb.length() > 0) {
                        sb.append('&');
                    }
                    sb.append(next.getName());
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(next.getValue(), "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        com.baidu.adp.lib.util.f.a(getClass(), "toString", e);
                        sb.append(next.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public final void a(Object... objArr) {
        if (objArr != null) {
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    a(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
        }
    }

    public final String b(String str) {
        if (this.a == null || this.a.size() == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<BasicNameValuePair> it = this.a.iterator();
        while (it.hasNext()) {
            BasicNameValuePair next = it.next();
            if (next != null && next.getName() != null && next.getName().equals(str)) {
                return next.getValue();
            }
        }
        return null;
    }

    public final void a(String str, int i) {
        if (this.a != null && this.a.size() != 0 && !TextUtils.isEmpty(str)) {
            Iterator<BasicNameValuePair> it = this.a.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                if (next != null && next.getName() != null && next.getName().equals(str)) {
                    this.a.remove(next);
                    this.a.add(new BasicNameValuePair(str, String.valueOf(i)));
                    return;
                }
            }
        }
    }
}

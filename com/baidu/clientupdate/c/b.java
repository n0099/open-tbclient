package com.baidu.clientupdate.c;

import android.text.TextUtils;
import com.baidu.util.Base64Encoder;
import com.baidu.util.LogUtil;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public StringBuilder f4733a;

    public b(String str) {
        this.f4733a = new StringBuilder(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f4733a;
        sb.append("&" + str + "=");
        byte[] b64Encode = Base64Encoder.b64Encode(URLEncoder.encode(str2).getBytes());
        this.f4733a.append(new String(b64Encode));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + new String(b64Encode));
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f4733a;
        sb.append("&" + str + "=");
        this.f4733a.append(URLEncoder.encode(str2));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + str2);
    }

    public String toString() {
        return this.f4733a.toString();
    }
}

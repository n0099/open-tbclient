package com.baidu.sapi2.biometrics.liveness;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class e {
    public static final int a = 1;
    public static final int b = 2;
    private AsyncHttpClient c;
    private Context d;

    public e(Context context) {
        this.d = context;
    }

    public void a() {
    }

    public void a(a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, int i, String str6, String str7, String str8) {
    }

    String a(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb.append(str3);
            sb.append("=");
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(URLEncoder.encode(str4, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                com.baidu.fsg.biometrics.base.d.c.a(e);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    private String a(String str) {
        return str + com.baidu.fsg.biometrics.base.d.e.o;
    }

    /* loaded from: classes2.dex */
    public abstract class a implements com.baidu.fsg.biometrics.base.a.a<b> {
        public a() {
        }

        public void a(int i) {
        }

        public void a(b bVar) {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends com.baidu.fsg.biometrics.base.c.a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 5;
        public static final int d = -306;
        public static final int e = -302;
        public static final String f = "获取用户信息失败";
        public static final String g = "系统繁忙，请稍候重试";
        public static final String h = "获取人脸图像失败";
        public static final String i = "人脸对比失败，请确保本人操作";
        public static final String j = "操作超时";
        public String k;
        public String l;
        public boolean m;
        public boolean n = true;
        public boolean o = false;

        b() {
            this.msgMap.put(1, f);
            this.msgMap.put(2, g);
            this.msgMap.put(-306, h);
            this.msgMap.put(-302, i);
        }
    }
}

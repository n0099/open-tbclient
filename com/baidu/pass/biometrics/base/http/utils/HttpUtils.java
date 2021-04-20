package com.baidu.pass.biometrics.base.http.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.utils.Crypto;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class HttpUtils {
    public static String getNonce(Context context, List<RestNameValuePair> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.pass.biometrics.base.http.utils.HttpUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
            }
        });
        RestNameValuePair restNameValuePair = new RestNameValuePair();
        restNameValuePair.setName("key");
        MessageDigest messageDigest = null;
        try {
            str = Crypto.sha1(context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        restNameValuePair.setValue(str);
        arrayList.add(restNameValuePair);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        }
        if (messageDigest == null) {
            return "";
        }
        for (int i = 0; i < arrayList.size(); i++) {
            RestNameValuePair restNameValuePair2 = (RestNameValuePair) arrayList.get(i);
            String name = restNameValuePair2.getName();
            String value = restNameValuePair2.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(a.f1922h);
                sb.append(value);
                if (i != arrayList.size() - 1) {
                    sb.append(Typography.amp);
                }
                if (!TextUtils.isEmpty(sb)) {
                    messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                }
            }
        }
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b2 : digest) {
            sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
        }
        return sb2.toString();
    }
}

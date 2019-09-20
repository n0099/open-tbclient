package com.baidu.pass.biometrics.base.http.utils;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.restnet.RestNameValuePair;
import com.baidu.pass.biometrics.base.utils.Crypto;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class HttpUtils {
    public static String getNonce(Context context, List<RestNameValuePair> list) {
        String str;
        MessageDigest messageDigest;
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
        try {
            str = Crypto.sha1(context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        restNameValuePair.setValue(str);
        arrayList.add(restNameValuePair);
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            messageDigest = null;
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
                sb.append(name).append('=').append(value);
                if (i != arrayList.size() - 1) {
                    sb.append('&');
                }
                if (!TextUtils.isEmpty(sb)) {
                    messageDigest.update(sb.toString().getBytes(Charset.forName(HTTP.UTF_8)));
                }
            }
        }
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b : digest) {
            sb2.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
        }
        return sb2.toString();
    }
}

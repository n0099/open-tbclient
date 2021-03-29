package com.baidu.fsg.base.restnet.beans.business.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.Crypto;
import com.baidu.fsg.base.utils.Md5Utils;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public final class PayUtils {
    public static final String API_SECRET = "";
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";
    public static final String PACKAGE_NAME = "rim-package-name";
    public static final String PACKAGE_NAME_INFO = "rim-package-info";
    public static String TAG = "PayUtils";
    public static ArrayList<String> keys;

    /* loaded from: classes.dex */
    public static class ParamComparator implements Comparator<String> {
        public ParamComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add("card_no");
        keys.add("valid_date");
        keys.add("cvv2");
        keys.add("identity_code");
        keys.add("phone_number");
    }

    public static String encrypt(String str, String str2) {
        return keys.contains(str) ? !TextUtils.isEmpty(str2) ? RimArmor.getInstance().encryptProxy(str2) : "" : str2;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList();
        for (RestNameValuePair restNameValuePair : list) {
            arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
        }
        return getSign(arrayList);
    }

    public static String getAppSignatureSha1(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return (packageInfo == null || packageInfo.signatures == null) ? "" : Crypto.sha1(packageInfo.signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String getCookie(Context context) {
        return null;
    }

    public static String getNonce(Context context, List<RestNameValuePair> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.fsg.base.restnet.beans.business.core.PayUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
            }
        });
        RestNameValuePair restNameValuePair = new RestNameValuePair();
        restNameValuePair.setName("key");
        String fpk = RimArmor.getInstance().getFpk(context);
        if (TextUtils.isEmpty(fpk)) {
            fpk = context.getPackageName();
        }
        MessageDigest messageDigest = null;
        try {
            str = Crypto.sha1(fpk + ChannelUtils.getHostAppId());
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
        if (messageDigest != null) {
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
                    sb.append(a.f1897h);
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
            return RimArmor.getInstance().encrypt(sb2.toString());
        }
        return "";
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        return (map == null || map.size() == 0) ? "" : getSign(mapToList(map), str);
    }

    public static String getSign(List<String> list) {
        Collections.sort(list, new ParamComparator());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
            stringBuffer.append("&");
        }
        stringBuffer.append("key=");
        stringBuffer.append("");
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }

    public static String list2String(List<RestNameValuePair> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair restNameValuePair : list) {
            String name = restNameValuePair.getName();
            String value = restNameValuePair.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                sb.append(name);
                sb.append(a.f1897h);
                sb.append(value);
                sb.append(Typography.amp);
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public static List<String> mapToList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey().toString());
            sb.append("=");
            sb.append(TextUtils.isEmpty(entry.getValue()) ? "" : entry.getValue().toString());
            arrayList.add(sb.toString());
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static String getSign(List<String> list, String str) {
        Collections.sort(list, new ParamComparator());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : list) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        stringBuffer.append("key=");
        stringBuffer.append(str);
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }
}

package com.baidu.fsg.base.restnet.beans.business.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.Crypto;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes16.dex */
public final class PayUtils {
    private static final String API_SECRET = "";
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";
    public static final String PACKAGE_NAME = "rim-package-name";
    public static final String PACKAGE_NAME_INFO = "rim-package-info";
    private static String TAG = "PayUtils";
    private static ArrayList<String> keys = new ArrayList<>();

    static {
        keys.add(KEY_CARD_NO);
        keys.add(KEY_VALID_DATE);
        keys.add(KEY_CVV2);
        keys.add(KEY_IDENTITY_CODE);
        keys.add(KEY_PHONE_NUMBER);
    }

    public static String encrypt(String str, String str2) {
        if (keys.contains(str)) {
            if (!TextUtils.isEmpty(str2)) {
                return RimArmor.getInstance().encryptProxy(str2);
            }
            return "";
        }
        return str2;
    }

    public static String getCookie(Context context) {
        return null;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList();
        for (RestNameValuePair restNameValuePair : list) {
            arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
        }
        return getSign(arrayList);
    }

    private static String getSign(List<String> list) {
        Collections.sort(list, new ParamComparator());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
            stringBuffer.append(ETAG.ITEM_SEPARATOR);
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
                sb.append(name).append('=').append(value).append('&');
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public static String getNonce(Context context, List<RestNameValuePair> list) {
        String str;
        MessageDigest messageDigest;
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
        try {
            str = Crypto.sha1(fpk + ChannelUtils.getHostAppId());
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
        if (messageDigest == null || arrayList == null) {
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
                    messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                }
            }
        }
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        for (byte b : digest) {
            sb2.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
        }
        return RimArmor.getInstance().encrypt(sb2.toString());
    }

    private static String getAppSignatureSha1(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null) {
                return Crypto.sha1(packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        if (map == null || map.size() == 0) {
            return "";
        }
        return getSign(mapToList(map), str);
    }

    public static List<String> mapToList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey().toString() + "=" + (TextUtils.isEmpty(entry.getValue()) ? "" : entry.getValue().toString()));
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    private static String getSign(List<String> list, String str) {
        Collections.sort(list, new ParamComparator());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : list) {
            stringBuffer.append(str2);
            stringBuffer.append(ETAG.ITEM_SEPARATOR);
        }
        stringBuffer.append("key=");
        stringBuffer.append(str);
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class ParamComparator implements Comparator<String> {
        private ParamComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }
}

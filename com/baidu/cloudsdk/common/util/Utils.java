package com.baidu.cloudsdk.common.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import com.baidu.android.common.security.Base64;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class Utils {
    public static String base64Encode(String str) {
        Validator.notNull(str, "str");
        return base64Encode(str.getBytes());
    }

    public static String base64Encode(byte[] bArr) {
        Validator.notNull(bArr, "data");
        try {
            return Base64.encode(bArr, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static JSONObject decodeAsJSONObject(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split != null && split.length == 2) {
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject getFragmentParams(String str) {
        try {
            return decodeAsJSONObject(new URI(str).getFragment());
        } catch (URISyntaxException e) {
            return new JSONObject();
        }
    }

    public static JSONObject getQueryParams(String str) {
        try {
            return decodeAsJSONObject(new URI(str).getQuery());
        } catch (URISyntaxException e) {
            return new JSONObject();
        }
    }

    public static String getQueryString(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string)) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(str)).append("=").append(URLEncoder.encode(string));
            }
        }
        return sb.toString();
    }

    public static String getRealPathFromUri(Activity activity, Uri uri) {
        Validator.notNull(activity, "activity");
        Validator.notNull(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase(PushConstants.EXTRA_CONTENT)) {
            return uri.getPath();
        }
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        return managedQuery.getString(columnIndexOrThrow);
    }

    public static boolean isActivityExist(Context context, Intent intent) {
        Validator.notNull(context, "context");
        Validator.notNull(intent, "intent");
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static boolean isEmpty(Bundle bundle) {
        return bundle == null || bundle.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isNetWorkAvaliable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        int type = activeNetworkInfo.getType();
        if (type != 1 && type != 0) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static boolean isUrl(Uri uri) {
        String scheme;
        return (uri == null || (scheme = uri.getScheme()) == null || (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https"))) ? false : true;
    }

    public static String md5(String str) {
        Validator.notNull(str, "str");
        return md5(str.getBytes());
    }

    public static String md5(byte[] bArr) {
        Validator.notNull(bArr, "data");
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append(SocialConstants.FALSE);
                }
                sb.append(hexString);
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }

    public static void setBrightness(Dialog dialog, int i) {
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i).floatValue() * 0.003921569f;
        dialog.getWindow().setAttributes(attributes);
    }
}

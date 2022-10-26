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
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static JSONObject decodeAsJSONObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (str != null) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (split != null && split.length == 2) {
                        try {
                            jSONObject.put(split[0], split[1]);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean isNetWorkAvaliable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return activeNetworkInfo.isConnected();
            }
            if (type != 0) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static JSONObject getFragmentParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return decodeAsJSONObject(new URI(str).getFragment());
            } catch (URISyntaxException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject getQueryParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return decodeAsJSONObject(new URI(str).getQuery());
            } catch (URISyntaxException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean isEmpty(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) {
            if (bundle != null && !bundle.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUrl(Uri uri) {
        InterceptResult invokeL;
        String scheme;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) {
            if (uri != null && (scheme = uri.getScheme()) != null) {
                if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            Validator.notNull(str, "str");
            return md5(str.getBytes());
        }
        return (String) invokeL.objValue;
    }

    public static String getQueryString(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) {
            if (bundle == null) {
                return "";
            }
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
                    try {
                        sb.append(URLEncoder.encode(str, null));
                        sb.append("=");
                        sb.append(URLEncoder.encode(string, null));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getRealPathFromUri(Activity activity, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, activity, uri)) == null) {
            Validator.notNull(activity, "activity");
            Validator.notNull(uri, "uri");
            String scheme = uri.getScheme();
            if (scheme != null && scheme.equalsIgnoreCase("content")) {
                Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
                int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
                managedQuery.moveToFirst();
                String string = managedQuery.getString(columnIndexOrThrow);
                managedQuery.close();
                return string;
            }
            return uri.getPath();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isActivityExist(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, intent)) == null) {
            Validator.notNull(context, "context");
            Validator.notNull(intent, IntentData.KEY);
            if (context.getPackageManager().resolveActivity(intent, 0) == null) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void setBrightness(Dialog dialog, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, dialog, i) == null) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.screenBrightness = Float.valueOf(i).floatValue() * 0.003921569f;
            dialog.getWindow().setAttributes(attributes);
        }
    }

    public static boolean isEmpty(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            if (collection != null && collection.size() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isEmpty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, objArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String md5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) {
            Validator.notNull(bArr, "data");
            StringBuilder sb = new StringBuilder();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                for (byte b : digest) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}

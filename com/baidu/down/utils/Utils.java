package com.baidu.down.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.nps.utils.Constant;
import com.baidu.sapi2.SapiWebView;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.webkit.internal.ConectivityUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes10.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_DL_FILENAME = "downloadfile";
    public static final int NET = 2;
    public static final int NONE = 3;
    public static final String TAG = "Utils";
    public static final int WAP = 1;
    public static final int WIFI = 0;
    public static final Map<String, String> extMimeMap;
    public static int mApnType = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1114658841, "Lcom/baidu/down/utils/Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1114658841, "Lcom/baidu/down/utils/Utils;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        extMimeMap = hashMap;
        hashMap.put(".au", "audio/basic");
        extMimeMap.put(".avi", "video/x-msvideo");
        extMimeMap.put(".bmp", "image/bmp");
        extMimeMap.put(".dif", "video/x-dv");
        extMimeMap.put(".dv", "video/x-dv");
        extMimeMap.put(".gif", "image/gif");
        extMimeMap.put(".jp2", "image/jp2");
        extMimeMap.put(".jpe", "image/jpeg");
        extMimeMap.put(".jpeg", "image/jpeg");
        extMimeMap.put(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX, "image/jpeg");
        extMimeMap.put(".kar", "audio/midi");
        extMimeMap.put(".m3u", "audio/x-mpegurl");
        extMimeMap.put(".m4a", "audio/mp4a-latm");
        extMimeMap.put(".m4b", "audio/mp4a-latm");
        extMimeMap.put(".m4p", "audio/mp4a-latm");
        extMimeMap.put(".m4u", "video/vnd.mpegurl");
        extMimeMap.put(".m4v", "video/x-m4v");
        extMimeMap.put(".mac", "image/x-macpaint");
        extMimeMap.put(".mid", "audio/midi");
        extMimeMap.put(".midi", "audio/midi");
        extMimeMap.put(".mov", "video/quicktime");
        extMimeMap.put(".movie", "video/x-sgi-movie");
        extMimeMap.put(".mp2", "audio/mpeg");
        extMimeMap.put(EmotionResourceProvider.EMOTION_SOUND_SUFFIX, "audio/mpeg");
        extMimeMap.put(".mp4", "video/mp4");
        extMimeMap.put(".mpe", "video/mpeg");
        extMimeMap.put(".mpeg", "video/mpeg");
        extMimeMap.put(".mpg", "video/mpeg");
        extMimeMap.put(".mpga", "audio/mpeg");
        extMimeMap.put(".mxu", "video/vnd.mpegurl");
        extMimeMap.put(".pct", "image/pict");
        extMimeMap.put(".pic", "image/pict");
        extMimeMap.put(".pict", "image/pict");
        extMimeMap.put(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, "image/png");
        extMimeMap.put(".pnm", "image/x-portable-anymap");
        extMimeMap.put(".pnt", "image/x-macpaint");
        extMimeMap.put(".pntg", "image/x-macpaint");
        extMimeMap.put(".ppm", "image/x-portable-pixmap");
        extMimeMap.put(".qt", "video/quicktime");
        extMimeMap.put(".qti", "image/x-quicktime");
        extMimeMap.put(".qtif", "image/x-quicktime");
        extMimeMap.put(".ra", "audio/x-pn-realaudio");
        extMimeMap.put(".ram", "audio/x-pn-realaudio");
        extMimeMap.put(".ras", "image/x-cmu-raster");
        extMimeMap.put(".rgb", "image/x-rgb");
        extMimeMap.put(".snd", "audio/basic");
        extMimeMap.put(".svg", "image/svg+xml");
        extMimeMap.put(".tif", "image/tiff");
        extMimeMap.put(".tiff", "image/tiff");
        extMimeMap.put(".wav", "audio/x-wav");
        extMimeMap.put(Constant.FILE.SUFFIX.BUNDLE_SUFFIX, "application/apk");
        extMimeMap.put(".rtf", "text/rtf");
        extMimeMap.put(".rtx", "text/richtext");
        extMimeMap.put(DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION, "text/plain");
        extMimeMap.put(".pdf", DocumentOpenUtil.PDF_TYPE);
        extMimeMap.put(".doc", DocumentOpenUtil.WORD_TYPE);
        extMimeMap.put(".ppt", DocumentOpenUtil.PPT_TYPE);
        extMimeMap.put(".xls", DocumentOpenUtil.EXCEL_TYPE);
        extMimeMap.put(".xlsx", DocumentOpenUtil.SHEET_TYPE);
        extMimeMap.put(".pptx", DocumentOpenUtil.PRESENT_TYPE);
        extMimeMap.put(".docx", DocumentOpenUtil.DOCUMENT_TYPE);
    }

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String chooseExtension(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        int lastIndexOf;
        int lastIndexOf2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) != null) {
            return (String) invokeLLL.objValue;
        }
        int lastIndexOf3 = (str2 == null || str2.endsWith("/")) ? -1 : str2.lastIndexOf(46);
        String str5 = null;
        if (lastIndexOf3 >= 0 && lastIndexOf3 < str2.length() - 1) {
            String substring = str2.substring(lastIndexOf3 + 1);
            if (!TextUtils.isEmpty(MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring))) {
                str4 = "." + substring;
                if (TextUtils.isEmpty(str3)) {
                    str4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    if (str4 != null) {
                        str4 = "." + str4;
                    } else if (str3.toLowerCase().startsWith("text/")) {
                        if (str3.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE)) {
                            str4 = DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                        } else {
                            str4 = str3.equalsIgnoreCase("text/bin") ? DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION : DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
                        }
                    } else if (str3.toLowerCase().startsWith("audio/")) {
                        str4 = "." + str3.substring(6);
                    }
                } else {
                    String decode = Uri.decode(str);
                    if (decode != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf2 = decode.lastIndexOf(47) + 1) > 0) {
                        str5 = decode.substring(lastIndexOf2);
                    }
                    if (str5 != null && (lastIndexOf = str5.lastIndexOf(46)) > 0) {
                        str4 = str5.substring(lastIndexOf);
                    }
                }
                return str4 != null ? DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION : str4;
            }
        }
        str4 = null;
        if (TextUtils.isEmpty(str3)) {
        }
        if (str4 != null) {
        }
    }

    public static String chooseFilename(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String decode;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (str2 == null || str2.endsWith("/")) {
                str2 = null;
            } else {
                int lastIndexOf2 = str2.lastIndexOf(47) + 1;
                if (lastIndexOf2 > 0) {
                    str2 = str2.substring(lastIndexOf2);
                }
            }
            if (str2 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                str2 = decode.substring(lastIndexOf);
            }
            if (str2 == null) {
                str2 = DEFAULT_DL_FILENAME;
            } else {
                int lastIndexOf3 = str2.lastIndexOf(46);
                if (lastIndexOf3 > 0) {
                    str2 = str2.substring(0, lastIndexOf3);
                }
            }
            String replaceAll = str2.replaceAll("[()（）.,：:\\-|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", "_");
            try {
                return URLEncoder.encode(replaceAll, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return replaceAll;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String chooseUniqueFilename(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            int length = str.length();
            int length2 = str2.length();
            if (length + length2 > 243) {
                if (length2 < 243) {
                    str = str.substring(0, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK - length2);
                } else {
                    str = "" + System.currentTimeMillis();
                    str2 = DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                }
            }
            String str3 = str + str2;
            if (str.endsWith(str2)) {
                str3 = str;
            }
            if (new File(str3).exists()) {
                String str4 = str + "_";
                int i2 = 1;
                for (int i3 = 1; i3 < 1000000000; i3 *= 10) {
                    for (int i4 = 0; i4 < 9; i4++) {
                        String str5 = str4 + i2 + str2;
                        if (!new File(str5).exists()) {
                            return str5;
                        }
                        i2 += new Random(SystemClock.uptimeMillis()).nextInt(i3) + 1;
                    }
                }
                return "";
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean detectIfProxyExist(Context context) {
        InterceptResult invokeL;
        int port;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                port = Integer.parseInt(property);
            } else {
                String host = Proxy.getHost(context);
                port = Proxy.getPort(context);
                str = host;
            }
            return (str == null || port == -1) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static int extractPositiveInteger(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt >= '0' && charAt <= '9') {
                    int i4 = i3 + 1;
                    while (i4 < length) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 < '0' || charAt2 > '9') {
                            break;
                        }
                        i4++;
                    }
                    return Integer.parseInt(str.substring(i3, i4));
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static byte[] gZip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            byte[] bArr2 = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return bArr2;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static NetworkInfo getActiveNetworkInfoSafely(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static int getApnType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (mApnType == -1) {
                initApnType(context);
            }
            return mApnType;
        }
        return invokeL.intValue;
    }

    public static String getCurrentNetWorkApn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null) ? "" : activeNetworkInfo.getExtraInfo().toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static String getEncodedValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                return TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str != null) {
                return extMimeMap.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getURLEncoderString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            System.currentTimeMillis();
            try {
                HttpUrlHelper parse = HttpUrlHelper.parse(str);
                return parse == null ? str : parse.toString();
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getWifiLevel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getRssi();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String getWifiOr2gOr3G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context != null) {
                try {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                        if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                            return "WF";
                        }
                        int subtype = activeNetworkInfo.getSubtype();
                        if (subtype != 3) {
                            if (subtype != 20) {
                                switch (subtype) {
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                        return "3G";
                                    default:
                                        switch (subtype) {
                                            case 12:
                                            case 14:
                                            case 15:
                                                return "3G";
                                            case 13:
                                                return "4G";
                                            default:
                                                return "2G";
                                        }
                                }
                            }
                            return "5G";
                        }
                        return "3G";
                    }
                } catch (Exception unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void initApnType(Context context) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, context) == null) {
            NetworkInfo activeNetworkInfoSafely = getActiveNetworkInfoSafely(context);
            if (activeNetworkInfoSafely == null) {
                mApnType = 3;
            } else if (activeNetworkInfoSafely.getType() == 1) {
                mApnType = 0;
            } else {
                if (activeNetworkInfoSafely.getExtraInfo() != null && (lowerCase = activeNetworkInfoSafely.getExtraInfo().toLowerCase()) != null) {
                    if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP) && !lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            mApnType = 2;
                        }
                    } else {
                        mApnType = 1;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    return;
                }
                if (!"10.0.0.172".equals(defaultHost.trim()) && !"10.0.0.200".equals(defaultHost.trim())) {
                    mApnType = 2;
                } else {
                    mApnType = 1;
                }
            }
        }
    }

    public static boolean isEmpty(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, collection)) == null) ? collection == null || collection.size() == 0 : invokeL.booleanValue;
    }

    public static boolean isIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf(46);
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                if (indexOf == -1) {
                    indexOf = str.length();
                }
                try {
                    int parseInt = Integer.parseInt(str.substring(i2, indexOf));
                    if (parseInt <= 255 && parseInt >= 0) {
                        i3++;
                        i2 = indexOf + 1;
                        indexOf = str.indexOf(46, i2);
                    }
                } catch (NumberFormatException unused) {
                }
                return false;
            }
            return i3 == 4;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUrlContainsQ(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? str.indexOf("?") > 0 : invokeL.booleanValue;
    }

    public static void removeMapKeyIgnoreCase(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, map, str) == null) || map == null || str == null) {
            return;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equalsIgnoreCase(str)) {
                it.remove();
            }
        }
    }
}

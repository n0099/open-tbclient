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
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.android.util.media.MimeType;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
/* loaded from: classes5.dex */
public class Utils {
    public static final String DEFAULT_DL_FILENAME = "downloadfile";
    public static final int NET = 2;
    public static final int NONE = 3;
    private static final String TAG = "Utils";
    public static final int WAP = 1;
    public static final int WIFI = 0;
    public static int mApnType = -1;
    private static final Map<String, String> extMimeMap = new HashMap();

    static {
        extMimeMap.put(".au", "audio/basic");
        extMimeMap.put(".avi", "video/x-msvideo");
        extMimeMap.put(".bmp", "image/bmp");
        extMimeMap.put(".dif", "video/x-dv");
        extMimeMap.put(".dv", "video/x-dv");
        extMimeMap.put(".gif", "image/gif");
        extMimeMap.put(".jp2", "image/jp2");
        extMimeMap.put(".jpe", MimeType.Image.JPEG);
        extMimeMap.put(".jpeg", MimeType.Image.JPEG);
        extMimeMap.put(".jpg", MimeType.Image.JPEG);
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
        extMimeMap.put(".mp3", "audio/mpeg");
        extMimeMap.put(".mp4", MimeType.Video.MP4);
        extMimeMap.put(".mpe", MimeType.Video.MPEG);
        extMimeMap.put(".mpeg", MimeType.Video.MPEG);
        extMimeMap.put(".mpg", MimeType.Video.MPEG);
        extMimeMap.put(".mpga", "audio/mpeg");
        extMimeMap.put(".mxu", "video/vnd.mpegurl");
        extMimeMap.put(".pct", "image/pict");
        extMimeMap.put(".pic", "image/pict");
        extMimeMap.put(".pict", "image/pict");
        extMimeMap.put(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX, MimeType.Image.PNG);
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
        extMimeMap.put(".wav", MimeType.Audio.WAV);
        extMimeMap.put(".apk", "application/apk");
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

    public static String getMimeType(String str) {
        if (str == null) {
            return null;
        }
        return extMimeMap.get(str);
    }

    public static int getApnType(Context context) {
        if (mApnType == -1) {
            initApnType(context);
        }
        return mApnType;
    }

    public static void initApnType(Context context) {
        String lowerCase;
        NetworkInfo activeNetworkInfoSafely = getActiveNetworkInfoSafely(context);
        if (activeNetworkInfoSafely == null) {
            mApnType = 3;
        } else if (activeNetworkInfoSafely.getType() == 1) {
            mApnType = 0;
        } else {
            if (activeNetworkInfoSafely.getExtraInfo() != null && (lowerCase = activeNetworkInfoSafely.getExtraInfo().toLowerCase()) != null) {
                if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap") || lowerCase.startsWith("ctwap")) {
                    mApnType = 1;
                } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                    mApnType = 2;
                }
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.length() > 0) {
                if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(defaultHost.trim())) {
                    mApnType = 1;
                } else {
                    mApnType = 2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String chooseExtension(String str, String str2, String str3) {
        String str4;
        int lastIndexOf;
        int lastIndexOf2;
        String str5 = null;
        int i = -1;
        if (str2 != null && !str2.endsWith("/")) {
            i = str2.lastIndexOf(46);
        }
        if (i >= 0 && i < str2.length() - 1) {
            String substring = str2.substring(i + 1);
            if (!TextUtils.isEmpty(MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring))) {
                str4 = "." + substring;
                if (TextUtils.isEmpty(str3)) {
                    str4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    if (str4 != null) {
                        str4 = "." + str4;
                    } else if (str3.toLowerCase().startsWith("text/")) {
                        if (str3.equalsIgnoreCase("text/html")) {
                            str4 = DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                        } else if (str3.equalsIgnoreCase("text/bin")) {
                            str4 = DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                        } else {
                            str4 = DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
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
                if (str4 != null) {
                    return DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                }
                return str4;
            }
        }
        str4 = null;
        if (TextUtils.isEmpty(str3)) {
        }
        if (str4 != null) {
        }
    }

    public static String chooseUniqueFilename(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length + length2 > 243) {
            if (length2 < 243) {
                str = str.substring(0, 243 - length2);
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
            String str4 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
            int i = 1;
            int i2 = 1;
            while (i < 1000000000) {
                int i3 = i2;
                for (int i4 = 0; i4 < 9; i4++) {
                    String str5 = str4 + i3 + str2;
                    if (new File(str5).exists()) {
                        i3 += new Random(SystemClock.uptimeMillis()).nextInt(i) + 1;
                    } else {
                        return str5;
                    }
                }
                i *= 10;
                i2 = i3;
            }
            return "";
        }
        return str3;
    }

    public static String chooseFilename(String str, String str2, String str3) {
        String decode;
        int lastIndexOf;
        String str4 = null;
        if (0 == 0 && str2 != null && !str2.endsWith("/")) {
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            str4 = lastIndexOf2 > 0 ? str2.substring(lastIndexOf2) : str2;
        }
        if (str4 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            str4 = decode.substring(lastIndexOf);
        }
        if (str4 == null) {
            str4 = DEFAULT_DL_FILENAME;
        } else {
            int lastIndexOf3 = str4.lastIndexOf(46);
            if (lastIndexOf3 > 0) {
                str4 = str4.substring(0, lastIndexOf3);
            }
        }
        String replaceAll = str4.replaceAll("[()（）.,：:\\-|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        try {
            return URLEncoder.encode(replaceAll, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return replaceAll;
        }
    }

    public static byte[] gZip(byte[] bArr) {
        byte[] bArr2;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            bArr2 = null;
            e = e2;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bArr2;
        }
        return bArr2;
    }

    public static String getWifiOr2gOr3G(Context context) {
        String str;
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                        str = "WF";
                    } else {
                        str = "2G";
                        switch (activeNetworkInfo.getSubtype()) {
                            case 3:
                                str = "3G";
                                break;
                            case 5:
                                str = "3G";
                                break;
                            case 6:
                                str = "3G";
                                break;
                            case 7:
                                str = "3G";
                                break;
                            case 8:
                                str = "3G";
                                break;
                            case 9:
                                str = "3G";
                                break;
                            case 10:
                                str = "3G";
                                break;
                            case 12:
                                str = "3G";
                                break;
                            case 13:
                                str = "4G";
                                break;
                            case 14:
                                str = "3G";
                                break;
                            case 15:
                                str = "3G";
                                break;
                        }
                    }
                    return str;
                }
            } catch (Exception e) {
                return "";
            }
        }
        str = "";
        return str;
    }

    public static boolean isIpAddress(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(46);
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                int parseInt = Integer.parseInt(str.substring(i, indexOf));
                if (parseInt > 255 || parseInt < 0) {
                    return false;
                }
                i2++;
                i = indexOf + 1;
                indexOf = str.indexOf(46, i);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return i2 == 4;
    }

    public static int extractPositiveInteger(String str, int i) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                int i3 = i2 + 1;
                while (i3 < length) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i3++;
                }
                return Integer.parseInt(str.substring(i2, i3));
            }
        }
        return i;
    }

    public static String getCurrentNetWorkApn(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null) ? "" : activeNetworkInfo.getExtraInfo().toLowerCase();
    }

    public static String getEncodedValue(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static NetworkInfo getActiveNetworkInfoSafely(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isUrlContainsQ(String str) {
        return str.indexOf("?") > 0;
    }

    public static int getWifiLevel(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getRssi();
        }
        return 0;
    }

    public static String getURLEncoderString(String str) {
        System.currentTimeMillis();
        try {
            HttpUrlHelper parse = HttpUrlHelper.parse(str);
            if (parse == null) {
                Log.i(TAG, "HttpUrlHelper parse error");
            } else {
                str = parse.toString();
            }
        } catch (Exception e) {
        }
        return str;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static void removeMapKeyIgnoreCase(Map<String, String> map, String str) {
        if (map != null && str != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().equalsIgnoreCase(str)) {
                    it.remove();
                }
            }
        }
    }

    public static boolean detectIfProxyExist(Context context) {
        String host;
        int port;
        if (Build.VERSION.SDK_INT >= 14) {
            host = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            port = Integer.parseInt(property);
        } else {
            host = Proxy.getHost(context);
            port = Proxy.getPort(context);
        }
        return (host == null || port == -1) ? false : true;
    }
}

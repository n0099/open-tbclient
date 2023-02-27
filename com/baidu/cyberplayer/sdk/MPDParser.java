package com.baidu.cyberplayer.sdk;

import android.net.Uri;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class MPDParser {

    @Keep
    /* loaded from: classes2.dex */
    public static class MPDInfo {
        public int mpdAuto;
        public int mpdClarity;
        public String urlStr;
    }

    @Keep
    public static Uri getDefaultUrlFromMPD(Uri uri) {
        return !isMPD(uri) ? uri : getDefaultUrlFromMPDURL(uri);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:
        r1 = android.net.Uri.parse(r6.getString("url"));
        r3 = java.lang.Boolean.TRUE;
        com.baidu.cyberplayer.sdk.CyberLog.d("sdk_MPDParser", "mpd parsed uri is => " + r1);
        r9 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri getDefaultUrlFromMPDURL(Uri uri) {
        Uri uri2;
        int parseInt;
        JSONArray jSONArray;
        String queryParameter = uri.getQueryParameter("content");
        String queryParameter2 = uri.getQueryParameter("clarity");
        Boolean bool = Boolean.FALSE;
        try {
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            parseInt = Integer.parseInt(queryParameter2);
            jSONArray = new JSONObject(decode).getJSONObject("video").getJSONArray("adaptation_set");
        } catch (Exception e) {
            e = e;
            uri2 = uri;
        }
        if (jSONArray.length() >= 1) {
            int i = 0;
            if (jSONArray.get(0) instanceof JSONObject) {
                JSONArray jSONArray2 = ((JSONObject) jSONArray.get(0)).getJSONArray("representation_list");
                new ArrayList();
                uri2 = uri;
                while (true) {
                    try {
                        if (i >= jSONArray2.length()) {
                            break;
                        }
                        Object obj = jSONArray2.get(i);
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject.getInt(MultiRatePlayUrlHelper.RANK) == parseInt) {
                                break;
                            }
                            uri2 = Uri.parse(jSONObject.getString("url"));
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        CyberLog.d("sdk_MPDParser", "mpd urlWithMPDURL parse exception " + e.getMessage());
                        if (!bool.booleanValue()) {
                        }
                    }
                }
                return !bool.booleanValue() ? uri : uri2;
            }
        }
        return uri;
    }

    @Keep
    public static String getDefaultUrlStringFromMPD(String str) {
        return !isMPD(str) ? str : getDefaultUrlStringFromMPDStr(str);
    }

    @Keep
    public static String getDefaultUrlStringFromMPDStr(String str) {
        try {
            return getDefaultUrlFromMPDURL(Uri.parse(str)).toString();
        } catch (Exception e) {
            CyberLog.d("sdk_MPDParser", "mpd parse exception " + e.getMessage());
            return str;
        }
    }

    @Keep
    public static MPDInfo getMPDInfoFromMPDStr(String str) {
        MPDInfo mPDInfo = new MPDInfo();
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("content");
            String queryParameter2 = parse.getQueryParameter("clarity");
            String queryParameter3 = parse.getQueryParameter("auto");
            CyberLog.d("sdk_MPDParser", "mpd autoMode: " + queryParameter3 + " selectedClarity:" + queryParameter2);
            try {
                mPDInfo.mpdClarity = Integer.parseInt(queryParameter2);
            } catch (Exception e) {
                CyberLog.d("sdk_MPDParser", "mpd parse exception " + e.getMessage());
            }
            try {
                mPDInfo.mpdAuto = Integer.parseInt(queryParameter3);
            } catch (Exception e2) {
                CyberLog.d("sdk_MPDParser", "mpd parse exception " + e2.getMessage());
            }
            String decode = URLDecoder.decode(queryParameter, "UTF-8");
            CyberLog.d("sdk_MPDParser", "mpd uri decodedStr is => " + decode);
            mPDInfo.urlStr = decode;
        } catch (Exception e3) {
            CyberLog.d("sdk_MPDParser", "mpd parse exception " + e3.getMessage());
        }
        return mPDInfo;
    }

    @Keep
    public static boolean isMPD(Uri uri) {
        if (uri == null) {
            return false;
        }
        return "mpd".equalsIgnoreCase(uri.getScheme());
    }

    @Keep
    public static boolean isMPD(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("mpd://");
    }
}

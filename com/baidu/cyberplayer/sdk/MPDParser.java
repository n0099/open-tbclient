package com.baidu.cyberplayer.sdk;

import android.net.Uri;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class MPDParser {
    public static final String MPD_PREFIX = "mpd://";
    public static final String MPD_SCHEME = "mpd";
    public static final String TAG = "sdk_MPDParser";

    @Keep
    /* loaded from: classes3.dex */
    public static class MPDInfo {
        public int mpdAuto;
        public int mpdClarity;
        public String urlStr;
    }

    @Keep
    public static Uri getDefaultUrlFromMPD(Uri uri) {
        if (!isMPD(uri)) {
            return uri;
        }
        return getDefaultUrlFromMPDURL(uri);
    }

    @Keep
    public static String getDefaultUrlStringFromMPD(String str) {
        if (!isMPD(str)) {
            return str;
        }
        return getDefaultUrlStringFromMPDStr(str);
    }

    @Keep
    public static String getDefaultUrlStringFromMPDStr(String str) {
        try {
            return getDefaultUrlFromMPDURL(Uri.parse(str)).toString();
        } catch (Exception e) {
            CyberLog.d(TAG, "mpd parse exception " + e.getMessage());
            return str;
        }
    }

    @Keep
    public static boolean isMPD(Uri uri) {
        if (uri == null) {
            return false;
        }
        return MPD_SCHEME.equalsIgnoreCase(uri.getScheme());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
        r1 = android.net.Uri.parse(r6.getString("url"));
        r3 = java.lang.Boolean.TRUE;
        com.baidu.cyberplayer.sdk.CyberLog.d(com.baidu.cyberplayer.sdk.MPDParser.TAG, "mpd parsed uri is => " + r1);
        r9 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri getDefaultUrlFromMPDURL(Uri uri) {
        Uri uri2;
        int i;
        JSONArray jSONArray;
        MPDInfo mPDInfoFromMPDStr = getMPDInfoFromMPDStr(uri.toString());
        String str = mPDInfoFromMPDStr.urlStr;
        Boolean bool = Boolean.FALSE;
        try {
            i = mPDInfoFromMPDStr.mpdClarity;
            jSONArray = new JSONObject(str).getJSONObject("video").getJSONArray("adaptation_set");
        } catch (Exception e) {
            e = e;
            uri2 = uri;
        }
        if (jSONArray.length() >= 1) {
            int i2 = 0;
            if (jSONArray.get(0) instanceof JSONObject) {
                JSONArray jSONArray2 = ((JSONObject) jSONArray.get(0)).getJSONArray("representation_list");
                new ArrayList();
                uri2 = uri;
                while (true) {
                    try {
                        if (i2 >= jSONArray2.length()) {
                            break;
                        }
                        Object obj = jSONArray2.get(i2);
                        if (obj instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject.getInt(MultiRatePlayUrlHelper.RANK) == i) {
                                break;
                            }
                            uri2 = Uri.parse(jSONObject.getString("url"));
                        }
                        i2++;
                    } catch (Exception e2) {
                        e = e2;
                        CyberLog.d(TAG, "mpd urlWithMPDURL parse exception " + e.getMessage());
                        if (bool.booleanValue()) {
                        }
                    }
                }
                if (bool.booleanValue()) {
                    return uri2;
                }
                return uri;
            }
        }
        return uri;
    }

    @Keep
    public static MPDInfo getMPDInfoFromMPDStr(String str) {
        MPDInfo mPDInfo = new MPDInfo();
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("content");
            String queryParameter2 = parse.getQueryParameter("clarity");
            String queryParameter3 = parse.getQueryParameter("auto");
            CyberLog.d(TAG, "mpd autoMode: " + queryParameter3 + " selectedClarity:" + queryParameter2);
            StringBuilder sb = new StringBuilder();
            sb.append("mpd uri content is => ");
            sb.append(queryParameter);
            CyberLog.d(TAG, sb.toString());
            try {
                mPDInfo.mpdClarity = Integer.parseInt(queryParameter2);
            } catch (Exception e) {
                CyberLog.d(TAG, "mpd parse exception " + e.getMessage());
            }
            try {
                mPDInfo.mpdAuto = Integer.parseInt(queryParameter3);
            } catch (Exception e2) {
                CyberLog.d(TAG, "mpd parse exception " + e2.getMessage());
            }
            mPDInfo.urlStr = queryParameter;
        } catch (Exception e3) {
            CyberLog.d(TAG, "mpd parse exception " + e3.getMessage());
        }
        return mPDInfo;
    }

    @Keep
    public static boolean isMPD(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(MPD_PREFIX);
    }
}

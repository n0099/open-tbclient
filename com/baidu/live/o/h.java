package com.baidu.live.o;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static String c(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData == null || alaLiveInfoData.session_info == null) {
            return null;
        }
        String flvUrl = alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
        return TextUtils.isEmpty(flvUrl) ? alaLiveInfoData.session_info.getRtmpUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : flvUrl;
    }

    public static String fz(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 1) {
            String str2 = pathSegments.get(pathSegments.size() - 1);
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("\\.");
                if (split.length > 0) {
                    return split[0];
                }
            }
        }
        return null;
    }

    public static boolean ay(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        String fz = fz(str);
        String fz2 = fz(str2);
        if (fz == null || fz2 == null) {
            return str.equals(str2);
        }
        return fz.equals(fz2);
    }

    public static boolean az(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}

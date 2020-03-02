package com.baidu.live.o;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public static String b(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData == null || alaLiveInfoData.session_info == null) {
            return null;
        }
        String flvUrl = alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
        return TextUtils.isEmpty(flvUrl) ? alaLiveInfoData.session_info.getRtmpUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : flvUrl;
    }

    public static String dV(String str) {
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

    public static boolean ah(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        String dV = dV(str);
        String dV2 = dV(str2);
        if (dV == null || dV2 == null) {
            return str.equals(str2);
        }
        return dV.equals(dV2);
    }

    public static boolean ai(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}

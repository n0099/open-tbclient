package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
/* loaded from: classes3.dex */
public class YYLiveUtil {
    public static int calculateLiveType(AlaInfoData alaInfoData) {
        YyExtData yyExtData = alaInfoData.mYyExtData;
        return yyExtData != null ? yyExtData.isYyGame ? 3 : 2 : alaInfoData.live_type == 1 ? 1 : 5;
    }

    public static void jumpYYLiveRoom(TbPageContext tbPageContext, AlaInfoData alaInfoData) {
        if (alaInfoData == null || !alaInfoData.isLegalYYLiveData()) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX + "sid=" + alaInfoData.mYyExtData.mSid + "&ssid=" + alaInfoData.mYyExtData.mSsid + "&templateId=" + alaInfoData.mYyExtData.mTemplateId + "&roomId=" + alaInfoData.roomId});
    }
}

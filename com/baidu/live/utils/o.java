package com.baidu.live.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.ax;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {
    public static long bfr;

    public static void a(String str, long j, boolean z, boolean z2) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isVideoGoodslistUnabled()) {
            com.baidu.live.message.h hVar = new com.baidu.live.message.h();
            hVar.aEX = str;
            hVar.liveId = j;
            hVar.aWR = z2;
            hVar.isHost = z;
            hVar.setParams();
            MessageManager.getInstance().sendMessage(hVar);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1533", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST, z ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", null));
        }
    }

    public static void m(Context context, String str, String str2) {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar != null && axVar.aAM != null) {
            String str3 = axVar.aAM.aCD;
            if (!TextUtils.isEmpty(str3)) {
                BrowserHelper.startInternalWebActivity(context, str3 + (str3.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "feed_id=" + str + "&live_id=" + str2 + "&subapp_type=" + TbConfig.getSubappType());
            }
        }
    }

    public static String a(String str, String str2, long j, boolean z, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar == null || axVar.aAM == null) {
            return "";
        }
        String str12 = axVar.aAM.aCC;
        if (TextUtils.isEmpty(str12)) {
            return "";
        }
        String str13 = axVar.aAM.appKey;
        String str14 = axVar.aAM.aCE;
        String str15 = str14 == null ? "" : str14;
        StringBuffer stringBuffer = new StringBuffer(str12);
        stringBuffer.append(str12.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
        stringBuffer.append("from=");
        if (z) {
            stringBuffer.append("self");
        } else {
            stringBuffer.append("guest");
        }
        stringBuffer.append("&feed_id=").append(str).append("&live_id=").append(str2).append("&user_id=").append(str8).append("&user_name=").append(str9).append("&anchor_id=").append(str11).append("&group_id=").append(str10).append("&_client_type=2").append("&subapp_type=").append(TbConfig.getSubappType()).append("&app_key=").append(str13);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            stringBuffer.append("&backURL=").append("baiduhaokan://");
            if (!z) {
                try {
                    String format = String.format("baiduhaokan://video/live/?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str5, str6, str7);
                    HashMap hashMap = new HashMap();
                    hashMap.put("debug_goods_back_scheme", "");
                    Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                    if (process.containsKey("debug_goods_back_scheme")) {
                        format = (String) process.get("debug_goods_back_scheme");
                    }
                    stringBuffer.append("&back_scheme=" + URLEncoder.encode(format, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            stringBuffer.append("&backURL=").append("bdminivideo://");
            if (!z) {
                try {
                    String format2 = String.format("bdminivideo://video/live?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str5, str6, str7);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("debug_goods_back_scheme", "");
                    Map<String, Object> process2 = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap2);
                    if (process2.containsKey("debug_goods_back_scheme")) {
                        format2 = (String) process2.get("debug_goods_back_scheme");
                    }
                    stringBuffer.append("&back_scheme=" + URLEncoder.encode(format2, "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            stringBuffer.append("&backURL=").append("bdtiebalive://");
            if (!z) {
                try {
                    stringBuffer.append("&back_scheme=" + URLEncoder.encode(String.format("bdtiebalive://video/live?live_id=%s&tab=%s&tag=%s&source=%s", str2, str5, str6, str7), "utf-8"));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            stringBuffer.append("&backURL=").append("baiduboxapp://");
            if (!z) {
                try {
                    stringBuffer.append("&back_scheme=" + URLEncoder.encode(String.format("baiduboxapp://v33/live/enterTiebaRoom?params={\"roomId\":\"%s\"}", Long.valueOf(j)), "utf-8"));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
            }
        }
        stringBuffer.append("&keplerID=").append(str15);
        return stringBuffer.toString();
    }
}

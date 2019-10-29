package com.baidu.live.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.af;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class m {
    public static long arv;

    public static void i(String str, long j) {
        a(str, j, false);
    }

    public static void a(String str, long j, boolean z) {
        com.baidu.live.message.f fVar = new com.baidu.live.message.f();
        fVar.WX = str;
        fVar.liveId = j;
        fVar.akj = z;
        fVar.setParams();
        MessageManager.getInstance().sendMessage(fVar);
    }

    public static void k(Context context, String str, String str2) {
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar != null && afVar.Ui != null) {
            String str3 = afVar.Ui.Vr;
            if (!TextUtils.isEmpty(str3)) {
                BrowserHelper.startInternalWebActivity(context, str3 + (str3.contains("?") ? "&" : "?") + "feed_id=" + str + "&live_id=" + str2 + "&subapp_type=" + TbConfig.getSubappType());
            }
        }
    }

    public static String a(String str, String str2, long j, boolean z, int i, String str3, String str4, String str5, String str6, String str7) {
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar == null || afVar.Ui == null) {
            return "";
        }
        String str8 = afVar.Ui.Vq;
        if (TextUtils.isEmpty(str8)) {
            return "";
        }
        String str9 = afVar.Ui.appKey;
        StringBuffer stringBuffer = new StringBuffer(str8);
        stringBuffer.append(str8.contains("?") ? "&" : "?");
        stringBuffer.append("from=");
        if (z) {
            stringBuffer.append("self");
        } else {
            stringBuffer.append("guest");
        }
        stringBuffer.append("&feed_id=").append(str).append("&live_id=").append(str2).append("&_client_type=2").append("&subapp_type=").append(TbConfig.getSubappType()).append("&app_key=").append(str9);
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
        }
        return stringBuffer.toString();
    }
}

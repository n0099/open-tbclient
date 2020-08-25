package com.baidu.live.sdk.goods.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static void m(Context context, String str, String str2) {
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJC != null) {
            String str3 = beVar.aJC.aLz;
            if (!TextUtils.isEmpty(str3)) {
                BrowserHelper.startInternalWebActivity(context, str3 + (str3.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "feed_id=" + str + "&live_id=" + str2 + "&subapp_type=" + TbConfig.getSubappType());
            }
        }
    }

    public static String a(String str, long j, boolean z, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            sb.append("&backURL=").append("baiduhaokan://");
            if (!z) {
                try {
                    String format = String.format("baiduhaokan://video/live/?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str2, str3, str4);
                    HashMap hashMap = new HashMap();
                    hashMap.put("debug_goods_back_scheme", "");
                    Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                    if (process.containsKey("debug_goods_back_scheme")) {
                        format = (String) process.get("debug_goods_back_scheme");
                    }
                    sb.append("&back_scheme=" + URLEncoder.encode(format, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            sb.append("&backURL=").append("bdminivideo://");
            if (!z) {
                try {
                    String format2 = String.format("bdminivideo://video/live?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str2, str3, str4);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("debug_goods_back_scheme", "");
                    Map<String, Object> process2 = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap2);
                    if (process2.containsKey("debug_goods_back_scheme")) {
                        format2 = (String) process2.get("debug_goods_back_scheme");
                    }
                    sb.append("&back_scheme=" + URLEncoder.encode(format2, "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            sb.append("&backURL=").append("bdtiebalive://");
            if (!z) {
                try {
                    sb.append("&back_scheme=" + URLEncoder.encode(String.format("bdtiebalive://video/live?live_id=%s&tab=%s&tag=%s&source=%s", str, str2, str3, str4), "utf-8"));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            sb.append("&backURL=").append("baiduboxapp://");
            if (!z) {
                try {
                    sb.append("&back_scheme=" + URLEncoder.encode(String.format("baiduboxapp://v33/live/enterTiebaRoom?params={\"roomId\":\"%s\"}", Long.valueOf(j)), "utf-8"));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}

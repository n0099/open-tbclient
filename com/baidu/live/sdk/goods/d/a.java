package com.baidu.live.sdk.goods.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.data.bn;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class a {
    public static void o(Context context, String str, String str2) {
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar != null && bnVar.aPB != null) {
            String str3 = bnVar.aPB.aSb;
            if (!TextUtils.isEmpty(str3)) {
                BrowserHelper.startInternalWebActivity(context, str3 + (str3.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "feed_id=" + str + "&live_id=" + str2 + "&subapp_type=" + TbConfig.getSubappType());
            }
        }
    }

    public static String a(String str, long j, boolean z, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            if (!z) {
                try {
                    sb.append(String.format("baiduhaokan://video/live/?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str2, str3, str4));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!z) {
                try {
                    sb.append(String.format("bdminivideo://video/live?room_id=%s&tab=%s&tag=%s&source=%s", Long.valueOf(j), str2, str3, str4));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            if (!z) {
                try {
                    sb.append(String.format("bdtiebalive://video/live?live_id=%s&tab=%s&tag=%s&source=%s", str, str2, str3, str4));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else if (TbadkCoreApplication.getInst().isMobileBaidu() && !z) {
            try {
                sb.append(String.format("baiduboxapp://v33/live/enterTiebaRoom?params={\"roomId\":\"%s\"}", Long.valueOf(j)));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return sb.toString();
    }
}

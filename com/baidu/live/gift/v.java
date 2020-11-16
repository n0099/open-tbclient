package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.media.duplayer.LibsInfoDef;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class v {
    public static boolean aUK = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aZw;
        hVar.giftId = cVar.giftId;
        if (cVar.aZq.Fr()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aZq.Fl();
        }
        hVar.bij = cVar.aZq.Fu();
        hVar.aTP = cVar.aTP;
        hVar.bik = cVar.aZw;
        hVar.bim.add(Long.valueOf(hVar.aTP));
        if (aUK && !cVar.aZu) {
            String Gq = Gq();
            if (Gq != null) {
                try {
                    JSONObject jSONObject = new JSONObject(Gq);
                    hVar.bin = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bin = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
                hVar.text = "荣耀值";
                hVar.fontColor = "#FFFFFF";
                hVar.startColor = "#F53DC7";
                hVar.endColor = "#AF40FF";
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aZr = cVar.aZr;
        iVar.bip = cVar.msgId;
        iVar.biq = cVar.aZw;
        iVar.bir = cVar.aTP;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.HT(), cVar2.HT())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aZr = cVar.aZr;
            iVar.bip = cVar.msgId;
            iVar.biq = cVar.aZw;
            iVar.bir = cVar.aTP;
            iVar.bis = cVar2.msgId;
            iVar.bit = cVar2.aZw;
            iVar.biu = cVar2.aTP;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aZr = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bip = j;
        iVar.biv = j2;
        iVar.biw = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String Gq() {
        return com.baidu.live.aa.a.Ph().bms.aJh;
    }
}

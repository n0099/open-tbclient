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
public class w {
    public static boolean aXR = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.bcU;
        hVar.giftId = cVar.giftId;
        if (cVar.bcN.Hf()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.bcN.GY();
        }
        hVar.bmx = cVar.bcN.Hi();
        hVar.bmC = cVar.bcN.Hy();
        hVar.aWT = cVar.aWT;
        hVar.bmy = cVar.bcU;
        hVar.bmA.add(Long.valueOf(hVar.aWT));
        if (aXR && !cVar.bcS) {
            String If = If();
            if (If != null) {
                try {
                    JSONObject jSONObject = new JSONObject(If);
                    hVar.bmB = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bmB = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.bcO = cVar.bcO;
        iVar.bmD = cVar.msgId;
        iVar.bmE = cVar.bcU;
        iVar.bmF = cVar.aWT;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.JK(), cVar2.JK())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.bcO = cVar.bcO;
            iVar.bmD = cVar.msgId;
            iVar.bmE = cVar.bcU;
            iVar.bmF = cVar.aWT;
            iVar.bmG = cVar2.msgId;
            iVar.bmH = cVar2.bcU;
            iVar.bmI = cVar2.aWT;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.bcO = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bmD = j;
        iVar.bmJ = j2;
        iVar.bmK = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String If() {
        return com.baidu.live.ae.a.RB().brA.aMa;
    }
}

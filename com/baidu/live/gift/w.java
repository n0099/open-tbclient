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
/* loaded from: classes10.dex */
public class w {
    public static boolean aUJ = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aZM;
        hVar.giftId = cVar.giftId;
        if (cVar.aZH.CL()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aZH.CD();
        }
        hVar.bjp = cVar.aZH.CO();
        hVar.bju = cVar.aZH.De();
        hVar.aTM = cVar.aTM;
        hVar.bjq = cVar.aZM;
        hVar.bjs.add(Long.valueOf(hVar.aTM));
        if (aUJ && !cVar.aZK) {
            String DL = DL();
            if (DL != null) {
                try {
                    JSONObject jSONObject = new JSONObject(DL);
                    hVar.bjt = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bjt = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.aZI = cVar.aZI;
        iVar.bjv = cVar.msgId;
        iVar.bjw = cVar.aZM;
        iVar.bjx = cVar.aTM;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Fr(), cVar2.Fr())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aZI = cVar.aZI;
            iVar.bjv = cVar.msgId;
            iVar.bjw = cVar.aZM;
            iVar.bjx = cVar.aTM;
            iVar.bjy = cVar2.msgId;
            iVar.bjz = cVar2.aZM;
            iVar.bjA = cVar2.aTM;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aZI = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bjv = j;
        iVar.bjB = j2;
        iVar.bjC = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String DL() {
        return com.baidu.live.af.a.OJ().bru.aHR;
    }
}

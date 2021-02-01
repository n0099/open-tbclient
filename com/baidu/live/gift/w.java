package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class w {
    public static boolean aXQ = false;
    public static String aXR = "1";

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.bcT;
        hVar.giftId = cVar.giftId;
        if (cVar.bcO.Eb()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.bcO.DS();
        }
        hVar.bmH = cVar.bcO.Ee();
        hVar.bmM = cVar.bcO.Eu();
        hVar.aWR = cVar.aWR;
        hVar.bmI = cVar.bcT;
        hVar.bmK.add(Long.valueOf(hVar.aWR));
        if (aXQ && !cVar.bcR) {
            String Fb = Fb();
            if (Fb != null) {
                try {
                    JSONObject jSONObject = new JSONObject(Fb);
                    hVar.bmL = aXR;
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bmL = aXR;
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
        iVar.bcP = cVar.bcP;
        iVar.bmN = cVar.msgId;
        iVar.bmO = cVar.bcT;
        iVar.bmP = cVar.aWR;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.GH(), cVar2.GH())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.bcP = cVar.bcP;
            iVar.bmN = cVar.msgId;
            iVar.bmO = cVar.bcT;
            iVar.bmP = cVar.aWR;
            iVar.bmQ = cVar2.msgId;
            iVar.bmR = cVar2.bcT;
            iVar.bmS = cVar2.aWR;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.bcP = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bmN = j;
        iVar.bmT = j2;
        iVar.bmU = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String Fb() {
        return com.baidu.live.ae.a.Qj().buX.aKv;
    }
}

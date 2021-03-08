package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class w {
    public static boolean aZq = false;
    public static String aZr = "1";

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.bev;
        hVar.giftId = cVar.giftId;
        if (cVar.bep.Ee()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.bep.DV();
        }
        hVar.boh = cVar.bep.Eh();
        hVar.bom = cVar.bep.Ex();
        hVar.aYr = cVar.aYr;
        hVar.boi = cVar.bev;
        hVar.bok.add(Long.valueOf(hVar.aYr));
        if (aZq && !cVar.bes) {
            String Fe = Fe();
            if (Fe != null) {
                try {
                    JSONObject jSONObject = new JSONObject(Fe);
                    hVar.bol = aZr;
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bol = aZr;
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
        iVar.beq = cVar.beq;
        iVar.bon = cVar.msgId;
        iVar.boo = cVar.bev;
        iVar.bop = cVar.aYr;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.GK(), cVar2.GK())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.beq = cVar.beq;
            iVar.bon = cVar.msgId;
            iVar.boo = cVar.bev;
            iVar.bop = cVar.aYr;
            iVar.boq = cVar2.msgId;
            iVar.bor = cVar2.bev;
            iVar.bos = cVar2.aYr;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.beq = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bon = j;
        iVar.bot = j2;
        iVar.bou = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String Fe() {
        return com.baidu.live.ae.a.Qm().bwx.aLV;
    }
}

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
/* loaded from: classes11.dex */
public class w {
    public static boolean aZw = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.beC;
        hVar.giftId = cVar.giftId;
        if (cVar.bex.GG()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.bex.Gy();
        }
        hVar.boc = cVar.bex.GJ();
        hVar.boh = cVar.bex.GZ();
        hVar.aYz = cVar.aYz;
        hVar.bod = cVar.beC;
        hVar.bof.add(Long.valueOf(hVar.aYz));
        if (aZw && !cVar.beA) {
            String HG = HG();
            if (HG != null) {
                try {
                    JSONObject jSONObject = new JSONObject(HG);
                    hVar.bog = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bog = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.bey = cVar.bey;
        iVar.boi = cVar.msgId;
        iVar.boj = cVar.beC;
        iVar.bok = cVar.aYz;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Jm(), cVar2.Jm())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.bey = cVar.bey;
            iVar.boi = cVar.msgId;
            iVar.boj = cVar.beC;
            iVar.bok = cVar.aYz;
            iVar.bol = cVar2.msgId;
            iVar.bom = cVar2.beC;
            iVar.bon = cVar2.aYz;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.bey = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.boi = j;
        iVar.boo = j2;
        iVar.bop = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String HG() {
        return com.baidu.live.af.a.SE().bwi.aME;
    }
}

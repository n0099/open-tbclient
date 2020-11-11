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
    public static boolean aWv = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.bbi;
        hVar.giftId = cVar.giftId;
        if (cVar.bbc.Ga()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.bbc.FU();
        }
        hVar.bjV = cVar.bbc.Gd();
        hVar.aVA = cVar.aVA;
        hVar.bjW = cVar.bbi;
        hVar.bjY.add(Long.valueOf(hVar.aVA));
        if (aWv && !cVar.bbg) {
            String GZ = GZ();
            if (GZ != null) {
                try {
                    JSONObject jSONObject = new JSONObject(GZ);
                    hVar.bjZ = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bjZ = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.bbd = cVar.bbd;
        iVar.bka = cVar.msgId;
        iVar.bkb = cVar.bbi;
        iVar.bkc = cVar.aVA;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.IC(), cVar2.IC())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.bbd = cVar.bbd;
            iVar.bka = cVar.msgId;
            iVar.bkb = cVar.bbi;
            iVar.bkc = cVar.aVA;
            iVar.bkd = cVar2.msgId;
            iVar.bke = cVar2.bbi;
            iVar.bkf = cVar2.aVA;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.bbd = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bka = j;
        iVar.bkg = j2;
        iVar.bkh = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String GZ() {
        return com.baidu.live.aa.a.PQ().bod.aKS;
    }
}

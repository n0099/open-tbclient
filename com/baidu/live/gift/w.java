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
    public static boolean aVd = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aZP;
        hVar.giftId = cVar.giftId;
        if (cVar.aZJ.Fz()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aZJ.Ft();
        }
        hVar.biC = cVar.aZJ.FC();
        hVar.aUi = cVar.aUi;
        hVar.biD = cVar.aZP;
        hVar.biF.add(Long.valueOf(hVar.aUi));
        if (aVd && !cVar.aZN) {
            String Gy = Gy();
            if (Gy != null) {
                try {
                    JSONObject jSONObject = new JSONObject(Gy);
                    hVar.biG = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.biG = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.aZK = cVar.aZK;
        iVar.biH = cVar.msgId;
        iVar.biI = cVar.aZP;
        iVar.biJ = cVar.aUi;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Ib(), cVar2.Ib())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aZK = cVar.aZK;
            iVar.biH = cVar.msgId;
            iVar.biI = cVar.aZP;
            iVar.biJ = cVar.aUi;
            iVar.biK = cVar2.msgId;
            iVar.biL = cVar2.aZP;
            iVar.biM = cVar2.aUi;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aZK = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.biH = j;
        iVar.biN = j2;
        iVar.biO = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String Gy() {
        return com.baidu.live.z.a.Pq().bmJ.aJS;
    }
}

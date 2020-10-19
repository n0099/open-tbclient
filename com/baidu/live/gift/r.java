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
public class r {
    public static boolean aTT = false;

    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aYt;
        hVar.giftId = cVar.giftId;
        if (cVar.aYo.Fk()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aYo.Fe();
        }
        hVar.bhl = cVar.aYo.Fn();
        hVar.aTm = cVar.aTm;
        hVar.bhm = cVar.aYt;
        hVar.bho.add(Long.valueOf(hVar.aTm));
        if (aTT && !cVar.aYs) {
            String Gd = Gd();
            if (Gd != null) {
                try {
                    JSONObject jSONObject = new JSONObject(Gd);
                    hVar.bhp = jSONObject.optString("pk_honer_buff_multiple");
                    hVar.text = jSONObject.optString("pk_honer_buff_text");
                    hVar.fontColor = jSONObject.optString("pk_honer_buff_text_font_color");
                    hVar.startColor = jSONObject.optString("pk_honer_buff_text_color_start");
                    hVar.endColor = jSONObject.optString("pk_honer_buff_text_color_end");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hVar.bhp = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
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
        iVar.aYp = cVar.aYp;
        iVar.bhq = cVar.msgId;
        iVar.bhr = cVar.aYt;
        iVar.bhs = cVar.aTm;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.HG(), cVar2.HG())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aYp = cVar.aYp;
            iVar.bhq = cVar.msgId;
            iVar.bhr = cVar.aYt;
            iVar.bhs = cVar.aTm;
            iVar.bht = cVar2.msgId;
            iVar.bhu = cVar2.aYt;
            iVar.bhv = cVar2.aTm;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aYp = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bhq = j;
        iVar.bhw = j2;
        iVar.bhx = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }

    private static String Gd() {
        return com.baidu.live.x.a.OS().blo.aJq;
    }
}

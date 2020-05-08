package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class q {
    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aEh;
        hVar.giftId = cVar.giftId;
        if (cVar.aEd.wc()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aEd.vV();
        }
        hVar.aLL = cVar.aEd.wf();
        hVar.azH = cVar.azH;
        hVar.aLM = cVar.aEh;
        hVar.aLO.add(Long.valueOf(hVar.azH));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aEe = cVar.aEe;
        iVar.aLP = cVar.msgId;
        iVar.aLQ = cVar.aEh;
        iVar.aLR = cVar.azH;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.yp(), cVar2.yp())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aEe = cVar.aEe;
            iVar.aLP = cVar.msgId;
            iVar.aLQ = cVar.aEh;
            iVar.aLR = cVar.azH;
            iVar.aLS = cVar2.msgId;
            iVar.aLT = cVar2.aEh;
            iVar.aLU = cVar2.azH;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aEe = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.aLP = j;
        iVar.aLV = j2;
        iVar.aLW = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

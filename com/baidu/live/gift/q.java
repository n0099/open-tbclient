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
        hVar.count = cVar.aEb;
        hVar.giftId = cVar.giftId;
        if (cVar.aDX.wd()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aDX.vW();
        }
        hVar.aLF = cVar.aDX.wg();
        hVar.azB = cVar.azB;
        hVar.aLG = cVar.aEb;
        hVar.aLI.add(Long.valueOf(hVar.azB));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aDY = cVar.aDY;
        iVar.aLJ = cVar.msgId;
        iVar.aLK = cVar.aEb;
        iVar.aLL = cVar.azB;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.yq(), cVar2.yq())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aDY = cVar.aDY;
            iVar.aLJ = cVar.msgId;
            iVar.aLK = cVar.aEb;
            iVar.aLL = cVar.azB;
            iVar.aLM = cVar2.msgId;
            iVar.aLN = cVar2.aEb;
            iVar.aLO = cVar2.azB;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aDY = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.aLJ = j;
        iVar.aLP = j2;
        iVar.aLQ = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

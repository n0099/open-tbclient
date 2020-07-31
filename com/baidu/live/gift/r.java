package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes4.dex */
public class r {
    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aNH;
        hVar.giftId = cVar.giftId;
        if (cVar.aND.yv()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aND.yp();
        }
        hVar.aVK = cVar.aND.yy();
        hVar.aIQ = cVar.aIQ;
        hVar.aVL = cVar.aNH;
        hVar.aVN.add(Long.valueOf(hVar.aIQ));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aNE = cVar.aNE;
        iVar.aVO = cVar.msgId;
        iVar.aVP = cVar.aNH;
        iVar.aVQ = cVar.aIQ;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.AH(), cVar2.AH())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aNE = cVar.aNE;
            iVar.aVO = cVar.msgId;
            iVar.aVP = cVar.aNH;
            iVar.aVQ = cVar.aIQ;
            iVar.aVR = cVar2.msgId;
            iVar.aVS = cVar2.aNH;
            iVar.aVT = cVar2.aIQ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aNE = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.aVO = j;
        iVar.aVU = j2;
        iVar.aVV = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

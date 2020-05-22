package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class r {
    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aJG;
        hVar.giftId = cVar.giftId;
        if (cVar.aJC.xt()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aJC.xm();
        }
        hVar.aRL = cVar.aJC.xw();
        hVar.aEZ = cVar.aEZ;
        hVar.aRM = cVar.aJG;
        hVar.aRO.add(Long.valueOf(hVar.aEZ));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aJD = cVar.aJD;
        iVar.aRP = cVar.msgId;
        iVar.aRQ = cVar.aJG;
        iVar.aRR = cVar.aEZ;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.zF(), cVar2.zF())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aJD = cVar.aJD;
            iVar.aRP = cVar.msgId;
            iVar.aRQ = cVar.aJG;
            iVar.aRR = cVar.aEZ;
            iVar.aRS = cVar2.msgId;
            iVar.aRT = cVar2.aJG;
            iVar.aRU = cVar2.aEZ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aJD = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.aRP = j;
        iVar.aRV = j2;
        iVar.aRW = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

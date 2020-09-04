package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes7.dex */
public class r {
    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aSW;
        hVar.giftId = cVar.giftId;
        if (cVar.aSS.DY()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aSS.DS();
        }
        hVar.bbb = cVar.aSS.Eb();
        hVar.aOd = cVar.aOd;
        hVar.bbc = cVar.aSW;
        hVar.bbe.add(Long.valueOf(hVar.aOd));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aST = cVar.aST;
        iVar.bbf = cVar.msgId;
        iVar.bbg = cVar.aSW;
        iVar.bbh = cVar.aOd;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Gk(), cVar2.Gk())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aST = cVar.aST;
            iVar.bbf = cVar.msgId;
            iVar.bbg = cVar.aSW;
            iVar.bbh = cVar.aOd;
            iVar.bbi = cVar2.msgId;
            iVar.bbj = cVar2.aSW;
            iVar.bbk = cVar2.aOd;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aST = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bbf = j;
        iVar.bbl = j2;
        iVar.bbm = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

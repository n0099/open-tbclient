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
        hVar.count = cVar.aSU;
        hVar.giftId = cVar.giftId;
        if (cVar.aSQ.DY()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aSQ.DS();
        }
        hVar.baZ = cVar.aSQ.Eb();
        hVar.aOb = cVar.aOb;
        hVar.bba = cVar.aSU;
        hVar.bbc.add(Long.valueOf(hVar.aOb));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aSR = cVar.aSR;
        iVar.bbd = cVar.msgId;
        iVar.bbe = cVar.aSU;
        iVar.bbf = cVar.aOb;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Gk(), cVar2.Gk())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aSR = cVar.aSR;
            iVar.bbd = cVar.msgId;
            iVar.bbe = cVar.aSU;
            iVar.bbf = cVar.aOb;
            iVar.bbg = cVar2.msgId;
            iVar.bbh = cVar2.aSU;
            iVar.bbi = cVar2.aOb;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aSR = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.bbd = j;
        iVar.bbj = j2;
        iVar.bbk = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

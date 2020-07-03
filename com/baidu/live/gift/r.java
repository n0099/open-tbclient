package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes3.dex */
public class r {
    public static void f(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.h hVar = new com.baidu.live.im.h();
        hVar.count = cVar.aMm;
        hVar.giftId = cVar.giftId;
        if (cVar.aMi.xT()) {
            hVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
        } else {
            hVar.giftName = cVar.aMi.xN();
        }
        hVar.aUr = cVar.aMi.xW();
        hVar.aHv = cVar.aHv;
        hVar.aUs = cVar.aMm;
        hVar.aUu.add(Long.valueOf(hVar.aHv));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, hVar));
    }

    public static void g(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aMj = cVar.aMj;
        iVar.aUv = cVar.msgId;
        iVar.aUw = cVar.aMm;
        iVar.aUx = cVar.aHv;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, iVar));
    }

    public static void a(com.baidu.live.gift.a.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Af(), cVar2.Af())) {
            com.baidu.live.im.i iVar = new com.baidu.live.im.i();
            iVar.aMj = cVar.aMj;
            iVar.aUv = cVar.msgId;
            iVar.aUw = cVar.aMm;
            iVar.aUx = cVar.aHv;
            iVar.aUy = cVar2.msgId;
            iVar.aUz = cVar2.aMm;
            iVar.aUA = cVar2.aHv;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, iVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3) {
        com.baidu.live.im.i iVar = new com.baidu.live.im.i();
        iVar.aMj = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        iVar.aUv = j;
        iVar.aUB = j2;
        iVar.aUC = j3;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, iVar));
    }
}

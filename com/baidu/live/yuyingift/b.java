package com.baidu.live.yuyingift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.im.r;
import com.baidu.live.im.s;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static void f(c cVar) {
        if (cVar != null) {
            r rVar = new r();
            rVar.userId = cVar.userId;
            rVar.giftId = cVar.giftId;
            rVar.aZL = cVar.aZL;
            rVar.boO = cVar.boO;
            List<s.a> il = s.il(cVar.boO);
            rVar.boP = new ArrayList();
            if (il != null && il.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= il.size()) {
                        break;
                    }
                    r.a aVar = new r.a();
                    aVar.count = cVar.bev;
                    aVar.giftId = cVar.giftId;
                    if (cVar.bep != null) {
                        aVar.aYq = cVar.bep.getThumbnail_url();
                    }
                    aVar.boQ = il.get(i2).name;
                    if (cVar.bep.Ee()) {
                        aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                    } else {
                        aVar.giftName = cVar.bep.DV();
                    }
                    aVar.boh = cVar.bep.Eh();
                    rVar.boP.add(aVar);
                    i = i2 + 1;
                }
            }
            rVar.aYr = cVar.aYr;
            rVar.bok.add(Long.valueOf(rVar.aYr));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
        }
    }

    public static void g(c cVar) {
        if (cVar != null) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> il = s.il(cVar.boO);
            sVar.boR = new ArrayList();
            sVar.beq = cVar.beq;
            sVar.bon = cVar.msgId;
            sVar.bop = cVar.aYr;
            if (il != null && il.size() > 0) {
                for (int i = 0; i < il.size(); i++) {
                    s.a aVar = new s.a();
                    aVar.boo = cVar.bev;
                    sVar.boR.add(aVar);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
        }
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.GK(), cVar2.GK())) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> il = com.baidu.live.utils.s.il(cVar.boO);
            sVar.boR = new ArrayList();
            sVar.beq = cVar.beq;
            sVar.bon = cVar.msgId;
            sVar.bop = cVar.aYr;
            sVar.boq = cVar2.msgId;
            sVar.bos = cVar2.aYr;
            if (il != null && il.size() > 0) {
                s.a aVar = new s.a();
                aVar.boo = cVar.bev;
                aVar.bor = cVar2.bev;
                sVar.boR.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        com.baidu.live.im.s sVar = new com.baidu.live.im.s();
        List<s.a> il = com.baidu.live.utils.s.il(str4);
        sVar.boR = new ArrayList();
        sVar.beq = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bon = j;
        if (il != null && il.size() > 0) {
            s.a aVar = new s.a();
            aVar.bot = j2;
            aVar.bou = j3;
            sVar.boR.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

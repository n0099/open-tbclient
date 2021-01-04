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
/* loaded from: classes11.dex */
public class b {
    public static void f(c cVar) {
        if (cVar != null) {
            r rVar = new r();
            rVar.userId = cVar.userId;
            rVar.giftId = cVar.giftId;
            rVar.aZQ = cVar.aZQ;
            rVar.boI = cVar.boI;
            List<s.a> iV = s.iV(cVar.boI);
            rVar.boJ = new ArrayList();
            if (iV != null && iV.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= iV.size()) {
                        break;
                    }
                    r.a aVar = new r.a();
                    aVar.count = cVar.beC;
                    aVar.giftId = cVar.giftId;
                    if (cVar.bex != null) {
                        aVar.aYy = cVar.bex.getThumbnail_url();
                    }
                    aVar.boK = iV.get(i2).name;
                    if (cVar.bex.GG()) {
                        aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                    } else {
                        aVar.giftName = cVar.bex.Gy();
                    }
                    aVar.boc = cVar.bex.GJ();
                    rVar.boJ.add(aVar);
                    i = i2 + 1;
                }
            }
            rVar.aYz = cVar.aYz;
            rVar.bof.add(Long.valueOf(rVar.aYz));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
        }
    }

    public static void g(c cVar) {
        if (cVar != null) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> iV = s.iV(cVar.boI);
            sVar.boL = new ArrayList();
            sVar.bey = cVar.bey;
            sVar.boi = cVar.msgId;
            sVar.bok = cVar.aYz;
            if (iV != null && iV.size() > 0) {
                for (int i = 0; i < iV.size(); i++) {
                    s.a aVar = new s.a();
                    aVar.boj = cVar.beC;
                    sVar.boL.add(aVar);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
        }
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Jm(), cVar2.Jm())) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> iV = com.baidu.live.utils.s.iV(cVar.boI);
            sVar.boL = new ArrayList();
            sVar.bey = cVar.bey;
            sVar.boi = cVar.msgId;
            sVar.bok = cVar.aYz;
            sVar.bol = cVar2.msgId;
            sVar.bon = cVar2.aYz;
            if (iV != null && iV.size() > 0) {
                s.a aVar = new s.a();
                aVar.boj = cVar.beC;
                aVar.bom = cVar2.beC;
                sVar.boL.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        com.baidu.live.im.s sVar = new com.baidu.live.im.s();
        List<s.a> iV = com.baidu.live.utils.s.iV(str4);
        sVar.boL = new ArrayList();
        sVar.bey = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.boi = j;
        if (iV != null && iV.size() > 0) {
            s.a aVar = new s.a();
            aVar.boo = j2;
            aVar.bop = j3;
            sVar.boL.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

package com.baidu.live.yuyingift;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.im.r;
import com.baidu.live.im.s;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.a.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static void f(c cVar) {
        r rVar = new r();
        rVar.userId = cVar.userId;
        rVar.giftId = cVar.giftId;
        rVar.bnb = cVar.bnb;
        List<r.a> jf = com.baidu.live.utils.r.jf(cVar.bnb);
        rVar.bnc = new ArrayList();
        if (jf != null && jf.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jf.size()) {
                    break;
                }
                r.a aVar = new r.a();
                aVar.count = cVar.bcU;
                aVar.giftId = cVar.giftId;
                if (cVar.bcN != null) {
                    aVar.aWS = cVar.bcN.getThumbnail_url();
                }
                aVar.bnd = jf.get(i2).name;
                if (cVar.bcN.Hf()) {
                    aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                } else {
                    aVar.giftName = cVar.bcN.GY();
                }
                aVar.bmx = cVar.bcN.Hi();
                rVar.bnc.add(aVar);
                i = i2 + 1;
            }
        }
        rVar.aWT = cVar.aWT;
        rVar.bmA.add(Long.valueOf(rVar.aWT));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
    }

    public static void g(c cVar) {
        s sVar = new s();
        List<r.a> jf = com.baidu.live.utils.r.jf(cVar.bnb);
        sVar.bne = new ArrayList();
        sVar.bcO = cVar.bcO;
        sVar.bmD = cVar.msgId;
        sVar.bmF = cVar.aWT;
        if (jf != null && jf.size() > 0) {
            for (int i = 0; i < jf.size(); i++) {
                s.a aVar = new s.a();
                aVar.bmE = cVar.bcU;
                sVar.bne.add(aVar);
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.JK(), cVar2.JK())) {
            s sVar = new s();
            List<r.a> jf = com.baidu.live.utils.r.jf(cVar.bnb);
            sVar.bne = new ArrayList();
            sVar.bcO = cVar.bcO;
            sVar.bmD = cVar.msgId;
            sVar.bmF = cVar.aWT;
            sVar.bmG = cVar2.msgId;
            sVar.bmI = cVar2.aWT;
            if (jf != null && jf.size() > 0) {
                s.a aVar = new s.a();
                aVar.bmE = cVar.bcU;
                aVar.bmH = cVar2.bcU;
                sVar.bne.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        s sVar = new s();
        List<r.a> jf = com.baidu.live.utils.r.jf(str4);
        sVar.bne = new ArrayList();
        sVar.bcO = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bmD = j;
        if (jf != null && jf.size() > 0) {
            s.a aVar = new s.a();
            aVar.bmJ = j2;
            aVar.bmK = j3;
            sVar.bne.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

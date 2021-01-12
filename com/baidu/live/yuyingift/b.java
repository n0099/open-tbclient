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
            rVar.aVd = cVar.aVd;
            rVar.bjV = cVar.bjV;
            List<s.a> hK = s.hK(cVar.bjV);
            rVar.bjW = new ArrayList();
            if (hK != null && hK.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= hK.size()) {
                        break;
                    }
                    r.a aVar = new r.a();
                    aVar.count = cVar.aZM;
                    aVar.giftId = cVar.giftId;
                    if (cVar.aZH != null) {
                        aVar.aTL = cVar.aZH.getThumbnail_url();
                    }
                    aVar.bjX = hK.get(i2).name;
                    if (cVar.aZH.CL()) {
                        aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                    } else {
                        aVar.giftName = cVar.aZH.CD();
                    }
                    aVar.bjp = cVar.aZH.CO();
                    rVar.bjW.add(aVar);
                    i = i2 + 1;
                }
            }
            rVar.aTM = cVar.aTM;
            rVar.bjs.add(Long.valueOf(rVar.aTM));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
        }
    }

    public static void g(c cVar) {
        if (cVar != null) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> hK = s.hK(cVar.bjV);
            sVar.bjY = new ArrayList();
            sVar.aZI = cVar.aZI;
            sVar.bjv = cVar.msgId;
            sVar.bjx = cVar.aTM;
            if (hK != null && hK.size() > 0) {
                for (int i = 0; i < hK.size(); i++) {
                    s.a aVar = new s.a();
                    aVar.bjw = cVar.aZM;
                    sVar.bjY.add(aVar);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
        }
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Fr(), cVar2.Fr())) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> hK = com.baidu.live.utils.s.hK(cVar.bjV);
            sVar.bjY = new ArrayList();
            sVar.aZI = cVar.aZI;
            sVar.bjv = cVar.msgId;
            sVar.bjx = cVar.aTM;
            sVar.bjy = cVar2.msgId;
            sVar.bjA = cVar2.aTM;
            if (hK != null && hK.size() > 0) {
                s.a aVar = new s.a();
                aVar.bjw = cVar.aZM;
                aVar.bjz = cVar2.aZM;
                sVar.bjY.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        com.baidu.live.im.s sVar = new com.baidu.live.im.s();
        List<s.a> hK = com.baidu.live.utils.s.hK(str4);
        sVar.bjY = new ArrayList();
        sVar.aZI = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bjv = j;
        if (hK != null && hK.size() > 0) {
            s.a aVar = new s.a();
            aVar.bjB = j2;
            aVar.bjC = j3;
            sVar.bjY.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

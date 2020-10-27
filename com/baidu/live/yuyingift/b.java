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
        rVar.bja = cVar.bja;
        List<r.a> io2 = com.baidu.live.utils.r.io(cVar.bja);
        rVar.bjb = new ArrayList();
        if (io2 != null && io2.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= io2.size()) {
                    break;
                }
                r.a aVar = new r.a();
                aVar.count = cVar.aZP;
                aVar.giftId = cVar.giftId;
                if (cVar.aZJ != null) {
                    aVar.aUh = cVar.aZJ.getThumbnail_url();
                }
                aVar.bjc = io2.get(i2).name;
                if (cVar.aZJ.Fz()) {
                    aVar.giftName = TbadkCoreApplication.getInst().getString(a.i.text_gift_graffiti);
                } else {
                    aVar.giftName = cVar.aZJ.Ft();
                }
                aVar.biC = cVar.aZJ.FC();
                rVar.bjb.add(aVar);
                i = i2 + 1;
            }
        }
        rVar.aUi = cVar.aUi;
        rVar.biF.add(Long.valueOf(rVar.aUi));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
    }

    public static void g(c cVar) {
        s sVar = new s();
        List<r.a> io2 = com.baidu.live.utils.r.io(cVar.bja);
        sVar.bjd = new ArrayList();
        sVar.aZK = cVar.aZK;
        sVar.biH = cVar.msgId;
        sVar.biJ = cVar.aUi;
        if (io2 != null && io2.size() > 0) {
            for (int i = 0; i < io2.size(); i++) {
                s.a aVar = new s.a();
                aVar.biI = cVar.aZP;
                sVar.bjd.add(aVar);
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.Ib(), cVar2.Ib())) {
            s sVar = new s();
            List<r.a> io2 = com.baidu.live.utils.r.io(cVar.bja);
            sVar.bjd = new ArrayList();
            sVar.aZK = cVar.aZK;
            sVar.biH = cVar.msgId;
            sVar.biJ = cVar.aUi;
            sVar.biK = cVar2.msgId;
            sVar.biM = cVar2.aUi;
            if (io2 != null && io2.size() > 0) {
                s.a aVar = new s.a();
                aVar.biI = cVar.aZP;
                aVar.biL = cVar2.aZP;
                sVar.bjd.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        s sVar = new s();
        List<r.a> io2 = com.baidu.live.utils.r.io(str4);
        sVar.bjd = new ArrayList();
        sVar.aZK = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.biH = j;
        if (io2 != null && io2.size() > 0) {
            s.a aVar = new s.a();
            aVar.biN = j2;
            aVar.biO = j3;
            sVar.bjd.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

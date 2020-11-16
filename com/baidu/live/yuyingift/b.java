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
        rVar.biJ = cVar.biJ;
        List<r.a> iB = com.baidu.live.utils.r.iB(cVar.biJ);
        rVar.biK = new ArrayList();
        if (iB != null && iB.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iB.size()) {
                    break;
                }
                r.a aVar = new r.a();
                aVar.count = cVar.aZw;
                aVar.giftId = cVar.giftId;
                if (cVar.aZq != null) {
                    aVar.aTO = cVar.aZq.getThumbnail_url();
                }
                aVar.biL = iB.get(i2).name;
                if (cVar.aZq.Fr()) {
                    aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                } else {
                    aVar.giftName = cVar.aZq.Fl();
                }
                aVar.bij = cVar.aZq.Fu();
                rVar.biK.add(aVar);
                i = i2 + 1;
            }
        }
        rVar.aTP = cVar.aTP;
        rVar.bim.add(Long.valueOf(rVar.aTP));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
    }

    public static void g(c cVar) {
        s sVar = new s();
        List<r.a> iB = com.baidu.live.utils.r.iB(cVar.biJ);
        sVar.biM = new ArrayList();
        sVar.aZr = cVar.aZr;
        sVar.bip = cVar.msgId;
        sVar.bir = cVar.aTP;
        if (iB != null && iB.size() > 0) {
            for (int i = 0; i < iB.size(); i++) {
                s.a aVar = new s.a();
                aVar.biq = cVar.aZw;
                sVar.biM.add(aVar);
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.HT(), cVar2.HT())) {
            s sVar = new s();
            List<r.a> iB = com.baidu.live.utils.r.iB(cVar.biJ);
            sVar.biM = new ArrayList();
            sVar.aZr = cVar.aZr;
            sVar.bip = cVar.msgId;
            sVar.bir = cVar.aTP;
            sVar.bis = cVar2.msgId;
            sVar.biu = cVar2.aTP;
            if (iB != null && iB.size() > 0) {
                s.a aVar = new s.a();
                aVar.biq = cVar.aZw;
                aVar.bit = cVar2.aZw;
                sVar.biM.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        s sVar = new s();
        List<r.a> iB = com.baidu.live.utils.r.iB(str4);
        sVar.biM = new ArrayList();
        sVar.aZr = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bip = j;
        if (iB != null && iB.size() > 0) {
            s.a aVar = new s.a();
            aVar.biv = j2;
            aVar.biw = j3;
            sVar.biM.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

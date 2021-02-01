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
            rVar.aYl = cVar.aYl;
            rVar.bno = cVar.bno;
            List<s.a> m22if = s.m22if(cVar.bno);
            rVar.bnp = new ArrayList();
            if (m22if != null && m22if.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= m22if.size()) {
                        break;
                    }
                    r.a aVar = new r.a();
                    aVar.count = cVar.bcT;
                    aVar.giftId = cVar.giftId;
                    if (cVar.bcO != null) {
                        aVar.aWQ = cVar.bcO.getThumbnail_url();
                    }
                    aVar.bnq = m22if.get(i2).name;
                    if (cVar.bcO.Eb()) {
                        aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                    } else {
                        aVar.giftName = cVar.bcO.DS();
                    }
                    aVar.bmH = cVar.bcO.Ee();
                    rVar.bnp.add(aVar);
                    i = i2 + 1;
                }
            }
            rVar.aWR = cVar.aWR;
            rVar.bmK.add(Long.valueOf(rVar.aWR));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
        }
    }

    public static void g(c cVar) {
        if (cVar != null) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> m22if = s.m22if(cVar.bno);
            sVar.bnr = new ArrayList();
            sVar.bcP = cVar.bcP;
            sVar.bmN = cVar.msgId;
            sVar.bmP = cVar.aWR;
            if (m22if != null && m22if.size() > 0) {
                for (int i = 0; i < m22if.size(); i++) {
                    s.a aVar = new s.a();
                    aVar.bmO = cVar.bcT;
                    sVar.bnr.add(aVar);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
        }
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.GH(), cVar2.GH())) {
            com.baidu.live.im.s sVar = new com.baidu.live.im.s();
            List<s.a> m22if = com.baidu.live.utils.s.m22if(cVar.bno);
            sVar.bnr = new ArrayList();
            sVar.bcP = cVar.bcP;
            sVar.bmN = cVar.msgId;
            sVar.bmP = cVar.aWR;
            sVar.bmQ = cVar2.msgId;
            sVar.bmS = cVar2.aWR;
            if (m22if != null && m22if.size() > 0) {
                s.a aVar = new s.a();
                aVar.bmO = cVar.bcT;
                aVar.bmR = cVar2.bcT;
                sVar.bnr.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        com.baidu.live.im.s sVar = new com.baidu.live.im.s();
        List<s.a> m22if = com.baidu.live.utils.s.m22if(str4);
        sVar.bnr = new ArrayList();
        sVar.bcP = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bmN = j;
        if (m22if != null && m22if.size() > 0) {
            s.a aVar = new s.a();
            aVar.bmT = j2;
            aVar.bmU = j3;
            sVar.bnr.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

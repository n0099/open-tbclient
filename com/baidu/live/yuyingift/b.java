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
        rVar.bku = cVar.bku;
        List<r.a> iH = com.baidu.live.utils.r.iH(cVar.bku);
        rVar.bkv = new ArrayList();
        if (iH != null && iH.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iH.size()) {
                    break;
                }
                r.a aVar = new r.a();
                aVar.count = cVar.bbi;
                aVar.giftId = cVar.giftId;
                if (cVar.bbc != null) {
                    aVar.aVz = cVar.bbc.getThumbnail_url();
                }
                aVar.bkw = iH.get(i2).name;
                if (cVar.bbc.Ga()) {
                    aVar.giftName = TbadkCoreApplication.getInst().getString(a.h.text_gift_graffiti);
                } else {
                    aVar.giftName = cVar.bbc.FU();
                }
                aVar.bjV = cVar.bbc.Gd();
                rVar.bkv.add(aVar);
                i = i2 + 1;
            }
        }
        rVar.aVA = cVar.aVA;
        rVar.bjY.add(Long.valueOf(rVar.aVA));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913185, rVar));
    }

    public static void g(c cVar) {
        s sVar = new s();
        List<r.a> iH = com.baidu.live.utils.r.iH(cVar.bku);
        sVar.bkx = new ArrayList();
        sVar.bbd = cVar.bbd;
        sVar.bka = cVar.msgId;
        sVar.bkc = cVar.aVA;
        if (iH != null && iH.size() > 0) {
            for (int i = 0; i < iH.size(); i++) {
                s.a aVar = new s.a();
                aVar.bkb = cVar.bbi;
                sVar.bkx.add(aVar);
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913184, sVar));
    }

    public static void a(c cVar, c cVar2) {
        if (cVar != null && cVar2 != null && TextUtils.equals(cVar.IC(), cVar2.IC())) {
            s sVar = new s();
            List<r.a> iH = com.baidu.live.utils.r.iH(cVar.bku);
            sVar.bkx = new ArrayList();
            sVar.bbd = cVar.bbd;
            sVar.bka = cVar.msgId;
            sVar.bkc = cVar.aVA;
            sVar.bkd = cVar2.msgId;
            sVar.bkf = cVar2.aVA;
            if (iH != null && iH.size() > 0) {
                s.a aVar = new s.a();
                aVar.bkb = cVar.bbi;
                aVar.bke = cVar2.bbi;
                sVar.bkx.add(aVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913183, sVar));
        }
    }

    public static void a(long j, String str, String str2, String str3, long j2, long j3, String str4) {
        s sVar = new s();
        List<r.a> iH = com.baidu.live.utils.r.iH(str4);
        sVar.bkx = new ArrayList();
        sVar.bbd = str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3;
        sVar.bka = j;
        if (iH != null && iH.size() > 0) {
            s.a aVar = new s.a();
            aVar.bkg = j2;
            aVar.bkh = j3;
            sVar.bkx.add(aVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913195, sVar));
    }
}

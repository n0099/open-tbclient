package com.baidu.live.aa;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class d {
    private static volatile d bsq;

    public static d Pu() {
        if (bsq == null) {
            synchronized (d.class) {
                if (bsq == null) {
                    bsq = new d();
                }
            }
        }
        return bsq;
    }

    private d() {
    }

    public void a(long j, long j2, long j3, long j4, String str) {
        HttpMessage httpMessage = new HttpMessage(1021122);
        int i = 0;
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = 1;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = 2;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = 3;
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            i = 4;
        } else if (TbadkCoreApplication.getInst().isYinbo()) {
            i = 6;
        }
        httpMessage.addParam("from", i);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("charm_user_id", j2);
        httpMessage.addParam("room_id", j3);
        httpMessage.addParam("live_id", j4);
        httpMessage.addParam("pub_show_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

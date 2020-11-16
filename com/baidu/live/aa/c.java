package com.baidu.live.aa;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c {
    private static volatile c bsp;

    public static c Pt() {
        if (bsp == null) {
            synchronized (c.class) {
                if (bsp == null) {
                    bsp = new c();
                }
            }
        }
        return bsp;
    }

    private c() {
    }

    public void a(String str, String str2, long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1031002);
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
        httpMessage.addParam("user_uk", str);
        httpMessage.addParam("charm_user_uk", str2);
        httpMessage.addParam("room_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

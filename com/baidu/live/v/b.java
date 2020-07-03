package com.baidu.live.v;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private static volatile b beb;

    public static b Hq() {
        if (beb == null) {
            synchronized (b.class) {
                if (beb == null) {
                    beb = new b();
                }
            }
        }
        return beb;
    }

    private b() {
    }

    public void d(long j, long j2, long j3, long j4) {
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
        }
        httpMessage.addParam("from", i);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("charm_user_id", j2);
        httpMessage.addParam("room_id", j3);
        httpMessage.addParam("live_id", j4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

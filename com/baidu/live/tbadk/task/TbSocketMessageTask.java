package com.baidu.live.tbadk.task;

import com.baidu.live.adp.framework.task.SocketMessageTask;
/* loaded from: classes6.dex */
public class TbSocketMessageTask extends SocketMessageTask {
    public TbSocketMessageTask(int i) {
        super(i);
        init();
    }

    private void init() {
        setNeedAck(true);
    }
}

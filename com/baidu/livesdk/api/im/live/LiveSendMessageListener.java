package com.baidu.livesdk.api.im.live;

import java.util.List;
/* loaded from: classes7.dex */
public interface LiveSendMessageListener {

    /* loaded from: classes7.dex */
    public interface State {
        public static final int DATAERROR = -2;
        public static final int UNKNOW = -1;
    }

    void onSendSuccess(String str, int i2, List<LiveMessageBean> list);
}

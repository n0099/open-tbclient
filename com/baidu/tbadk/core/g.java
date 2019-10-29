package com.baidu.tbadk.core;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.sapi2.share.ShareResult;
/* loaded from: classes.dex */
public class g {
    private static int BASE_ERROR_NO = -100000000;
    public static final int ONLINE_SUCC = BASE_ERROR_NO - 1000;
    public static final int ONLINE_FAILED = BASE_ERROR_NO + MessageConfig.ERROR_TASK_OUTTIME;
    public static final int BEGIN_ONLINE = BASE_ERROR_NO - 1002;
    public static final int SEND_PING = BASE_ERROR_NO - 2000;
    public static final int PING_ERR = BASE_ERROR_NO - 2001;
    public static final int PING_SUCC = BASE_ERROR_NO - 2002;
    public static final int RETRY_IPLIST = BASE_ERROR_NO - 3000;
    public static final int RETRY_IPLIST_SUCC = BASE_ERROR_NO + ShareResult.ERROR_CODE_REASON_CANCLE;
}

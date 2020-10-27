package com.baidu.live.tbadk.core;

import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.sapi2.share.d;
/* loaded from: classes4.dex */
public class OpCode {
    private static int BASE_ERROR_NO = -100000000;
    public static final int ONLINE_SUCC = BASE_ERROR_NO - 1000;
    public static final int ONLINE_FAILED = BASE_ERROR_NO - 1001;
    public static final int BEGIN_ONLINE = BASE_ERROR_NO - 1002;
    public static final int SEND_PING = BASE_ERROR_NO + DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE;
    public static final int PING_ERR = BASE_ERROR_NO + DlnaManager.DLNA_SUB_ERROR_NETWORK_NOT_WIFI;
    public static final int PING_SUCC = BASE_ERROR_NO - 2002;
    public static final int RETRY_IPLIST = BASE_ERROR_NO - 3000;
    public static final int RETRY_IPLIST_SUCC = BASE_ERROR_NO + d.g;
}

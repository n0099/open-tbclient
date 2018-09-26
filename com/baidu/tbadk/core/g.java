package com.baidu.tbadk.core;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.tbadk.core.util.TbErrInfo;
/* loaded from: classes.dex */
public class g {
    private static int BASE_ERROR_NO = -100000000;
    public static final int aeL = BASE_ERROR_NO + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    public static final int aeM = BASE_ERROR_NO - 1001;
    public static final int aeN = BASE_ERROR_NO + TbErrInfo.ERR_IMG_SEND;
    public static final int aeO = BASE_ERROR_NO - 2000;
    public static final int aeP = BASE_ERROR_NO - 2001;
    public static final int aeQ = BASE_ERROR_NO - 2002;
    public static final int aeR = BASE_ERROR_NO - 3000;
    public static final int aeS = BASE_ERROR_NO + ShareResult.ERROR_CODE_REASON_CANCLE;
}

package com.baidu.tbadk.core;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.tbadk.core.util.TbErrInfo;
/* loaded from: classes.dex */
public class g {
    private static int BASE_ERROR_NO = -100000000;
    public static final int akv = BASE_ERROR_NO + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    public static final int akw = BASE_ERROR_NO - 1001;
    public static final int akx = BASE_ERROR_NO + TbErrInfo.ERR_IMG_SEND;
    public static final int aky = BASE_ERROR_NO - 2000;
    public static final int akz = BASE_ERROR_NO - 2001;
    public static final int akA = BASE_ERROR_NO - 2002;
    public static final int akB = BASE_ERROR_NO - 3000;
    public static final int akC = BASE_ERROR_NO + ShareResult.ERROR_CODE_REASON_CANCLE;
}

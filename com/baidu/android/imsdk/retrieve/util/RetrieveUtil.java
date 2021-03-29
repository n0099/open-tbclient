package com.baidu.android.imsdk.retrieve.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes.dex */
public class RetrieveUtil {
    public static final long RETRIEVE_PAUID_ONLINE = 17592197488700L;
    public static final long RETRIEVE_PAUID_TEST = 17592186068166L;

    public static boolean isRetrievePaUid(Context context, long j) {
        int readIntData = Utility.readIntData(context, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if ((readIntData != 1 && readIntData != 2 && readIntData != 3) || j != RETRIEVE_PAUID_TEST) {
                return false;
            }
        } else if (j != RETRIEVE_PAUID_ONLINE) {
            return false;
        }
        return true;
    }
}

package com.baidu.android.imsdk.retrieve.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes3.dex */
public class RetrieveUtil {
    private static final long RETRIEVE_PAUID_ONLINE = 17592197488700L;
    private static final long RETRIEVE_PAUID_TEST = 17592186068166L;

    public static boolean isRetrievePaUid(Context context, long j) {
        switch (Utility.readIntData(context, Constants.KEY_ENV, 0)) {
            case 0:
                return j == RETRIEVE_PAUID_ONLINE;
            case 1:
            case 2:
            case 3:
                return j == RETRIEVE_PAUID_TEST;
            default:
                return false;
        }
    }
}

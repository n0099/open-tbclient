package com.baidu.sapi2.passhost.pluginsdk;

import android.util.Pair;
/* loaded from: classes.dex */
public abstract class AbsPassPiSafe extends AbsPassPi {
    public static final int SOFIRE_MODULE_ID = 1;

    /* loaded from: classes.dex */
    public interface ISafeCallback {
        void onFinished(Pair<Integer, Object> pair, Pair<Integer, Object> pair2);
    }

    public void checkSafeAsync(String str, String str2, int i, ISafeCallback iSafeCallback) {
    }
}

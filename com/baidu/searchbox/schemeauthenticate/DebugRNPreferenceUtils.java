package com.baidu.searchbox.schemeauthenticate;

import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes4.dex */
public class DebugRNPreferenceUtils extends SharedPrefsWrapper {
    public static final String SP_FILE_NAME = "debug_rn_sp";

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final DebugRNPreferenceUtils INSTANCE = new DebugRNPreferenceUtils();
    }

    public DebugRNPreferenceUtils() {
        super("debug_rn_sp");
    }

    public static DebugRNPreferenceUtils getInstance() {
        return Holder.INSTANCE;
    }
}

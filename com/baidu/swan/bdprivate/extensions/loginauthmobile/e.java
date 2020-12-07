package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
/* loaded from: classes25.dex */
public class e {
    public static SwanAppLoginAndGetMobileDialog a(String str, boolean z, QuickLoginInfo quickLoginInfo, String str2, String str3) {
        SwanAppLoginAndGetMobileDialog swanAppPhoneLoginDialog;
        Bundle bundle = new Bundle();
        if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
            swanAppPhoneLoginDialog = new SwanAppQuickLoginDialog();
        } else {
            swanAppPhoneLoginDialog = new SwanAppPhoneLoginDialog();
        }
        bundle.putString("auth_tip", str);
        bundle.putBoolean("is_night", z);
        bundle.putParcelable("quick_login_info", quickLoginInfo);
        bundle.putString("app_id", str3);
        bundle.putString("launch_from", str2);
        swanAppPhoneLoginDialog.setArguments(bundle);
        return swanAppPhoneLoginDialog;
    }
}

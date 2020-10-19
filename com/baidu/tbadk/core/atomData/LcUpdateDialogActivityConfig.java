package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LcUpdateDialogActivityConfig extends IntentConfig {
    public static final String KEY_LC_UPDATE_APKMD5RSA = "key_lc_update_apkmd5rsa";
    public static final String KEY_LC_UPDATE_DATA = "key_lc_update_data";

    public LcUpdateDialogActivityConfig(Context context, ClientUpdateInfo clientUpdateInfo, String str) {
        super(context);
        Intent intent = getIntent();
        intent.setFlags(268435456);
        intent.putExtra(KEY_LC_UPDATE_DATA, clientUpdateInfo);
        intent.putExtra(KEY_LC_UPDATE_APKMD5RSA, str);
        TbadkCoreApplication.getInst().setHasNewVersion(true);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(R.string.live_error_system_not_support));
        return false;
    }
}

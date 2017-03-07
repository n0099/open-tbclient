package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class UpdateDialogConfig extends IntentConfig {
    public static final String KEY_AS_APK_URL = "as_apk_url";
    public static final String KEY_OTHER_APK_DATA = "other_apk_data";
    public static final String KEY_OTHER_APK_URL = "other_apk_url";
    public static final String KEY_TIEBA_APK_DATA = "tieba_apk_data";
    public static final String KEY_TIEBA_APK_URL = "key_tieba_apk_url";

    public UpdateDialogConfig(Context context, VersionData versionData, CombineDownload combineDownload) {
        super(context);
        Intent intent = getIntent();
        intent.setFlags(268435456);
        intent.putExtra(KEY_TIEBA_APK_DATA, versionData);
        intent.putExtra(KEY_OTHER_APK_DATA, combineDownload);
        TbadkCoreApplication.m9getInst().setHasNewVersion(true);
        TbadkCoreApplication.m9getInst().setCombineDownload(combineDownload);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(w.l.live_error_system_not_support));
        return false;
    }
}

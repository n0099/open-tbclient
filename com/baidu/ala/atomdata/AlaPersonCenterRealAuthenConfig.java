package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes9.dex */
public class AlaPersonCenterRealAuthenConfig extends IntentConfig {
    public static final String REAL_AUTHEN_CERTIFY_STATUS = "real_authen_certify_status";
    public static final String REAL_AUTHEN_USER_ID = "real_authen_user_id";

    public AlaPersonCenterRealAuthenConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra(REAL_AUTHEN_USER_ID, str);
        getIntent().putExtra(REAL_AUTHEN_CERTIFY_STATUS, str2);
    }
}

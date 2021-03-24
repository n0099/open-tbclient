package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class GroupAddressLocateActivityConfig extends IntentConfig {
    public static final String INTENT_DATA_IS_HIDDEN_ADDRESS = "IntentDataIsHiddenAddress";
    public static final String INTENT_DATA_OLD_ADDRESS = "IntentDataOldAddress";
    public static final String INTENT_DATA_OLD_BUSINESS = "IntentDataOldBusiness";

    public GroupAddressLocateActivityConfig(Context context, int i, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra(INTENT_DATA_OLD_ADDRESS, str);
        getIntent().putExtra(INTENT_DATA_OLD_BUSINESS, str2);
        getIntent().putExtra(INTENT_DATA_IS_HIDDEN_ADDRESS, z);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

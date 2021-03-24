package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PersonChangeActivityConfig extends IntentConfig {
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final String TAG_DATA = "data";

    public PersonChangeActivityConfig(Context context, int i, PersonChangeData personChangeData, Boolean bool) {
        super(context);
        getIntent().putExtra("data", personChangeData);
        getIntent().putExtra("isFromPersonInfo", bool);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
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

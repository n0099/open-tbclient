package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Build;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PersonChangeActivityConfig extends a {
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final String TAG_DATA = "data";

    public PersonChangeActivityConfig(Context context, int i, PersonChangeData personChangeData, Boolean bool) {
        super(context);
        getIntent().putExtra("data", personChangeData);
        getIntent().putExtra(IS_FROM_PERSONINFO, bool);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 9) {
            return true;
        }
        UtilHelper.showToast(getContext(), getContext().getString(z.live_error_system_not_support));
        return false;
    }
}

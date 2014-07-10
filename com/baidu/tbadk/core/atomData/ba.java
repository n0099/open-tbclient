package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
public class ba extends com.baidu.tbadk.core.frameworkData.a {
    public ba(Context context, String str, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
    }

    public ba(Context context, String str, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i);
        intent.putExtra("key_current_tab", i2);
    }

    public ba(Context context, int i, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", TbadkApplication.getCurrentAccount());
        intent.putExtra("key_sex", 0);
        intent.putExtra("key_from_where", i2);
        intent.putExtra("tb_request_code", i);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }

    public ba(Context context, int i) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", TbadkApplication.getCurrentAccount());
        intent.putExtra("key_sex", 0);
        intent.putExtra("tb_request_code", i);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }
}

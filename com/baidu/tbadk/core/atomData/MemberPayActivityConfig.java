package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class MemberPayActivityConfig extends a {
    public static final String MEMBER_TYPE = "member_type";
    public static final String ST_TYPE = "st_type";

    public MemberPayActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
    }

    public MemberPayActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
    }

    public MemberPayActivityConfig(Context context, boolean z, int i, String str) {
        super(context);
        if (str != null) {
            getIntent().putExtra("st_type", str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i);
        }
    }
}

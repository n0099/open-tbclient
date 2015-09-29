package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MemberPayActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final int FROM_BACKGROUND_DETAIL_DIALOG = 14;
    public static final int FROM_BACKGROUND_ITEM_DIALOG = 13;
    public static final int FROM_BACKGROUND_LIST_PAGE = 12;
    public static final int FROM_BUBBLE = 7;
    public static final int FROM_DRESSUP_CENTER = 8;
    public static final int FROM_EXP_SPEED = 2;
    public static final int FROM_MEMBER_CENTER = 3;
    public static final int FROM_PB_MUTE = 4;
    public static final int FROM_PERSON_INFO_MUTE = 5;
    public static final int FROM_SIGNALL = 1;
    public static final int FROM_SKIN_DETAIL_DIALOG = 11;
    public static final int FROM_SKIN_ITEM_DIALOG = 10;
    public static final int FROM_TAIL = 6;
    public static final int FROM_THEME_LIST_PAGE = 9;
    public static final String MEMBER_TYPE = "member_type";
    public static final String ST_TYPE = "st_type";

    public MemberPayActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
    }

    public MemberPayActivityConfig(Context context, int i, boolean z, int i2) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra(IntentConfig.CLOSE, z);
        getIntent().putExtra("from", i2);
    }

    public MemberPayActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
    }

    public MemberPayActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra(MEMBER_TYPE, i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
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

    public MemberPayActivityConfig(Context context, boolean z, int i, String str, int i2) {
        super(context);
        if (str != null) {
            getIntent().putExtra("st_type", str);
        }
        if (z) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(i);
        }
        if (i2 > 0) {
            getIntent().putExtra("from", i2);
        }
    }
}

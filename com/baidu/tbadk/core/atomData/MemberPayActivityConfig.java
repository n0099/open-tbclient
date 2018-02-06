package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MemberPayActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final int FROM_AVATAR_PENDANT_LIST = 22;
    public static final int FROM_BACKGROUND_DETAIL_DIALOG = 14;
    public static final int FROM_BACKGROUND_ITEM_DIALOG = 13;
    public static final int FROM_BACKGROUND_LIST_PAGE = 12;
    public static final int FROM_BUBBLE = 7;
    public static final int FROM_BUBBLE_ITEM_CLICK = 18;
    public static final int FROM_BUBBLE_RECOMMEND_CLCK = 19;
    public static final int FROM_CLOSE_AD = 20;
    public static final int FROM_DRESSUP_CENTER = 8;
    public static final int FROM_EXP_SPEED = 2;
    public static final int FROM_MARGA_VIP = 23;
    public static final int FROM_MEMBERCENTER_BOTTOM = 16;
    public static final int FROM_MEMBERCENTER_JOIN = 21;
    public static final int FROM_MEMBERCENTER_SPREAD = 15;
    public static final int FROM_MEMBER_CENTER = 3;
    public static final int FROM_MY_INFORMATION = 24;
    public static final int FROM_PB_MUTE = 4;
    public static final int FROM_PERSON_INFO_MUTE = 5;
    public static final String FROM_SCENE = "from_scene";
    public static final int FROM_SEND_VIP_GIFT = 17;
    public static final int FROM_SIGNALL = 1;
    public static final int FROM_SKIN_DETAIL_DIALOG = 11;
    public static final int FROM_SKIN_ITEM_DIALOG = 10;
    public static final int FROM_TAIL = 6;
    public static final int FROM_THEME_LIST_PAGE = 9;
    public static final String MEMBER_TYPE = "member_type";
    public static final String PAY_TYPE = "pay_type";
    public static final int SCENE_FROM_MEMBER_DEFAULT_COMMON = 0;
    public static final int SCENE_FROM_MEMBER_YEAR_COMMON = 9;
    public static final String SCENE_ID = "scene_id";
    public static final String ST_TYPE = "st_type";

    public MemberPayActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("member_type", i);
    }

    public MemberPayActivityConfig(Context context, int i, boolean z, int i2) {
        super(context);
        getIntent().putExtra("member_type", i);
        getIntent().putExtra("close", z);
        getIntent().putExtra("from", i2);
    }

    public MemberPayActivityConfig(Context context, int i, boolean z, int i2, int i3) {
        super(context);
        getIntent().putExtra("member_type", i);
        getIntent().putExtra("close", z);
        getIntent().putExtra("from", i2);
        getIntent().putExtra(FROM_SCENE, i3);
    }

    public MemberPayActivityConfig(Context context, int i, String str, int i2) {
        super(context);
        getIntent().putExtra("member_type", i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
    }

    public MemberPayActivityConfig(Context context, int i, String str, int i2, int i3, String str2) {
        super(context);
        getIntent().putExtra("member_type", i);
        getIntent().putExtra("st_type", str);
        getIntent().putExtra("from", i2);
        getIntent().putExtra("scene_id", str2);
        getIntent().putExtra("pay_type", i3);
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

    public void setReferPageClickZone(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            getIntent().putExtra("refer_page", str);
        }
        if (!StringUtils.isNull(str2)) {
            getIntent().putExtra("click_zone", str2);
        }
    }

    public void setSceneId(String str) {
        getIntent().putExtra("scene_id", str);
    }

    public void setFromScence(int i) {
        getIntent().putExtra(FROM_SCENE, i);
    }

    public void setStType(String str) {
        getIntent().putExtra("st_type", str);
    }

    public void setFrom(int i) {
        if (i > 0) {
            getIntent().putExtra("from", i);
        }
    }
}

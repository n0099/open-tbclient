package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class CommonVcodeActivityConfig extends IntentConfig {
    public static final String CHECK_STR = "check_str";
    public static final String FROM_GRAFFITI_TAB = "from_graffiti_tab";
    public static final String FROM_PAGE = "from_page";
    public static final String HEIGHT = "height";
    public static final String NEED_FEED_BACK_BUTTON = "need_feed_back_button";
    public static final String PIC_ID = "pic_id";
    public static final String VCODE_MD5 = "vcode_md5";
    public static final String VCODE_PIC_URL = "vcode_pic_url";
    public static final String WIDTH = "width";

    public CommonVcodeActivityConfig(Context context, int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        setHideFeedBackButton();
        getIntent().putExtra(VCODE_PIC_URL, str);
        getIntent().putExtra(VCODE_MD5, str2);
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("thread_id", str4);
        getIntent().putExtra(PIC_ID, str5);
        getIntent().putExtra(WIDTH, i2);
        getIntent().putExtra(HEIGHT, i3);
        getIntent().putExtra(CHECK_STR, str6);
        if (FROM_GRAFFITI_TAB.equals(str7)) {
            getIntent().putExtra("from_page", FROM_GRAFFITI_TAB);
        }
    }

    public void setHideFeedBackButton() {
        if (getIntent() != null) {
            getIntent().putExtra("need_feed_back_button", false);
        }
    }
}

package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class WriteShareActivityConfig extends IntentConfig {
    public static final String FORUM_NAME = "forum_name";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String SHARE_API_KEY = "share_api_key";
    public static final String SHARE_APP_NAME = "share_app_name";
    public static final String SHARE_REFER_URL = "share_refer_url";
    public static final String SHARE_SIGN_KEY = "share_sign_key";
    public static final String SHARE_SUMMARY_CONTENT = "share_summary_content";
    public static final String SHARE_SUMMARY_IMG = "share_summary_img";
    public static final String SHARE_SUMMARY_IMG_HEIGHT = "summary_img_height";
    public static final String SHARE_SUMMARY_IMG_TYPE = "summary_img_type";
    public static final String SHARE_SUMMARY_IMG_WIDTH = "summary_img_width";
    public static final String SHARE_SUMMARY_TITLE = "share_summary_title";

    public WriteShareActivityConfig(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(activity);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra(SHARE_SUMMARY_TITLE, str2);
        getIntent().putExtra(SHARE_SUMMARY_CONTENT, str3);
        getIntent().putExtra(SHARE_SUMMARY_IMG, str4);
        getIntent().putExtra(SHARE_REFER_URL, str5);
        getIntent().putExtra(SHARE_API_KEY, str6);
        getIntent().putExtra(SHARE_APP_NAME, str7);
        getIntent().putExtra(SHARE_SIGN_KEY, str8);
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class TbWebViewActivityConfig extends WebViewActivityConfig {
    public static String GOD_INVITE_JUMP_URL = "http://c.tieba.baidu.com/mo/q/god/inviteGod";
    public static final String INTENT_KEY_IS_FROM_PUSH_NOTIFY = "is_from_push";
    public static final String JUMP_PARAMS_PAGE_TYPE = "?page_type=open_full_screen_opacity_web_page";
    public static final String KEY_IS_FROM_SCHEMA = "key_is_from_schema";
    public static final String PAGE_TYPE_BLACK_TRANSLUCENT = "open_full_screen_opacity_web_page";
    public static final String PAGE_TYPE_NORMAL = "normal";
    public static final String PARAMS_KEY_PAGE_FROM = "page_from";
    public static final String PARAMS_KEY_PAGE_TYPE = "page_type";
    public static final String V_PAGE_FROM_LIVE = "live";

    public TbWebViewActivityConfig(Context context) {
        super(context);
    }

    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context, str, str2, z);
    }

    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context, str, str2, z, z2, z3);
    }

    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, str, str2, z, z2, z3, z4);
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setIsFromSchema(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_FROM_SCHEMA, z);
        }
    }
}

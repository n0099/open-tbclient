package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class TbWebViewActivityConfig extends a {
    public static final String TAG_BACK = "tag_back";
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_REFRESH = "tag_refresh";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";

    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, str2);
        getIntent().putExtra(TAG_NAV_BAR, true);
        getIntent().putExtra(TAG_BACK, true);
        getIntent().putExtra(TAG_REFRESH, true);
        getIntent().putExtra(TAG_COOKIE, z);
        getIntent().putExtra(TAG_ENABLE_JS, false);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            m.showToast(getContext(), getContext().getString(y.web_view_corrupted));
            return false;
        }
        return true;
    }
}

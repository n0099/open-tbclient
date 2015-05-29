package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class WebViewActivityConfig extends c {
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";

    public WebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
        getIntent().putExtra(TAG_COOKIE, z);
        getIntent().putExtra(TAG_ENABLE_JS, false);
        getIntent().putExtra(TAG_NAV_BAR, true);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    public WebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context);
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
        getIntent().putExtra(TAG_NAV_BAR, z);
        getIntent().putExtra(TAG_COOKIE, z2);
        getIntent().putExtra(TAG_ENABLE_JS, z3);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.c
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            n.showToast(getContext(), getContext().getString(t.web_view_corrupted));
            return false;
        }
        return true;
    }

    public static String addTiebaParams(String str) {
        if (!bb.isEmpty(str)) {
            if (str.indexOf("_client_version=") < 0) {
                if (bb.isEmpty(Uri.parse(str).getQuery())) {
                    str = String.valueOf(str) + "?_client_version=" + TbConfig.getVersion();
                } else {
                    str = String.valueOf(str) + "&_client_version=" + TbConfig.getVersion();
                }
            }
            if (str.indexOf("nohead=1") < 0) {
                return String.valueOf(str) + "&nohead=1";
            }
            return str;
        }
        return str;
    }
}

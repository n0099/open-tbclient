package com.baidu.live.tbadk.core.atomdata;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes7.dex */
public class WebViewActivityConfig extends IntentConfig {
    public static final String IS_SHOW_RIGHT_ICON = "is_show_right_icon";
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_FIX_TITLE = "tag_fix_title";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_NEED_STYLE_IMMERSIVE_STICKY = "tag_style_immersive_sticky";
    public static final String TAG_TITLE = "tag_title";
    public static final String TAG_URL = "tag_url";

    public WebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("tag_title", str);
        getIntent().putExtra("tag_url", addTiebaParams(str2));
        getIntent().putExtra("tag_cookie", z);
        getIntent().putExtra("tag_enable_js", true);
        getIntent().putExtra("tag_navigation_bar", true);
        getIntent().putExtra("tag_style_immersive_sticky", true);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    public WebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context);
        getIntent().putExtra("tag_title", str);
        getIntent().putExtra("tag_url", addTiebaParams(str2));
        getIntent().putExtra("tag_navigation_bar", z);
        getIntent().putExtra("tag_cookie", z2);
        getIntent().putExtra("tag_enable_js", z3);
        getIntent().putExtra("tag_style_immersive_sticky", true);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    public WebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        getIntent().putExtra("tag_title", str);
        getIntent().putExtra("tag_url", addTiebaParams(str2));
        getIntent().putExtra("tag_navigation_bar", z);
        getIntent().putExtra("tag_cookie", z2);
        getIntent().putExtra("tag_enable_js", z3);
        getIntent().putExtra("tag_style_immersive_sticky", z4);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.live.tbadk.core.frameworkdata.IntentConfig
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            BdUtilHelper.showToast(getContext(), getContext().getString(a.i.sdk_web_view_corrupted));
            return false;
        }
        return true;
    }

    public void setFixTitle(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra("tag_fix_title", z);
        }
    }

    public static String addTiebaParams(String str) {
        if (!StringHelper.isEmpty(str)) {
            if (str.indexOf("_client_version=") < 0) {
                if (StringHelper.isEmpty(Uri.parse(str).getQuery())) {
                    str = str + "?_client_version=" + TbConfig.getVersion();
                } else {
                    str = str + "&_client_version=" + TbConfig.getVersion();
                }
            }
            if (str.indexOf("nohead=1") < 0) {
                return str + "&nohead=1";
            }
            return str;
        }
        return str;
    }
}

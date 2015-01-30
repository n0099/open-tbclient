package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.z;
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
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
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

    public TbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context);
        getIntent().putExtra(TAG_TITLE, str);
        getIntent().putExtra(TAG_URL, addTiebaParams(str2));
        getIntent().putExtra(TAG_NAV_BAR, z);
        getIntent().putExtra(TAG_BACK, z2);
        getIntent().putExtra(TAG_REFRESH, z3);
        getIntent().putExtra(TAG_COOKIE, z4);
        getIntent().putExtra(TAG_ENABLE_JS, z5);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            l.showToast(getContext(), getContext().getString(z.web_view_corrupted));
            return false;
        }
        return true;
    }

    public static String addTiebaParams(String str) {
        if (!bf.isEmpty(str)) {
            if (str.indexOf("_client_version=") < 0) {
                if (bf.isEmpty(Uri.parse(str).getQuery())) {
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

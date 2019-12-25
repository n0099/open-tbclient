package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WebViewActivityConfig extends IntentConfig {
    public static final String TAG_COOKIE = "tag_cookie";
    public static final String TAG_DOWNLOAD_AD_ID = "tag_download_ad_id";
    public static final String TAG_ENABLE_JS = "tag_enable_js";
    public static final String TAG_FIX_TITLE = "tag_fix_title";
    public static final String TAG_NAV_BAR = "tag_navigation_bar";
    public static final String TAG_NEED_STYLE_IMMERSIVE_STICKY = "tag_style_immersive_sticky";
    public static final String TAG_NO_MENU = "tag_nomenu";
    public static final String TAG_NO_SHARE = "tag_noshare";
    public static final String TAG_PAGE_TRANSLUCENT = "tag_page_translucent";
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
        addPageIdParams(context);
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
        addPageIdParams(context);
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
        addPageIdParams(context);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            l.showToast(getContext(), getContext().getString(R.string.web_view_corrupted));
            return false;
        }
        return true;
    }

    public void setFixTitle(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra("tag_fix_title", z);
        }
    }

    public void setNoShare(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(TAG_NO_SHARE, z);
        }
    }

    public void setNoMenu(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(TAG_NO_MENU, z);
        }
    }

    public void setPageTranslucent(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(TAG_PAGE_TRANSLUCENT, str);
        }
    }

    public void addPageIdParams(Context context) {
        BdUniqueId uniqueId;
        if (getIntent() != null && (context instanceof TbPageContextSupport) && (uniqueId = ((TbPageContextSupport) context).getPageContext().getUniqueId()) != null) {
            getIntent().putExtra(IntentConfig.PRE_PAGE_ID, uniqueId.getId());
        }
    }

    public static String addTiebaParams(String str) {
        if (!aq.isEmpty(str)) {
            if (str.indexOf("_client_version=") < 0) {
                if (aq.isEmpty(Uri.parse(str).getQuery())) {
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

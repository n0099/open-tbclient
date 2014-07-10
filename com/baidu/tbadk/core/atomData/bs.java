package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class bs extends com.baidu.tbadk.core.frameworkData.a {
    public bs(Context context, String str, String str2, boolean z) {
        super(context);
        getIntent().putExtra("tag_title", str);
        getIntent().putExtra("tag_url", str2);
        getIntent().putExtra("tag_navigation_bar", true);
        getIntent().putExtra("tag_back", true);
        getIntent().putExtra("tag_refresh", true);
        getIntent().putExtra("tag_cookie", z);
        getIntent().putExtra("tag_enable_js", false);
        if (!(getContext() instanceof Activity)) {
            getIntent().addFlags(268435456);
        }
        setIntentAction(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public boolean isValid() {
        if (UtilHelper.webViewIsProbablyCorrupt(getContext())) {
            com.baidu.adp.lib.util.j.a(getContext(), getContext().getString(com.baidu.tieba.y.web_view_corrupted));
            return false;
        }
        return true;
    }
}

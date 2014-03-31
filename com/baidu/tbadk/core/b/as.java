package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class as extends com.baidu.tbadk.core.frameworkData.a {
    public as(Context context, String str, String str2, boolean z) {
        super(context);
        d().putExtra("tag_title", str);
        d().putExtra("tag_url", str2);
        d().putExtra("tag_navigation_bar", true);
        d().putExtra("tag_back", true);
        d().putExtra("tag_refresh", true);
        d().putExtra("tag_cookie", false);
        d().putExtra("tag_enable_js", false);
        if (!(c() instanceof Activity)) {
            d().addFlags(268435456);
        }
        a(IntentAction.Activity);
    }

    @Override // com.baidu.tbadk.core.frameworkData.a
    public final boolean a() {
        if (UtilHelper.h(c())) {
            com.baidu.adp.lib.util.i.a(c(), c().getString(com.baidu.tbadk.l.web_view_corrupted));
            return false;
        }
        return true;
    }
}

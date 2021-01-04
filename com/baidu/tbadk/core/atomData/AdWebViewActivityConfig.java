package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes.dex */
public class AdWebViewActivityConfig extends WebViewActivityConfig {
    public AdWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        super(context, str, str2, z, z2, z3);
        if (bundle != null) {
            getIntent().putExtras(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.atomData.WebViewActivityConfig
    public String addTiebaParams(String str) {
        return str;
    }
}

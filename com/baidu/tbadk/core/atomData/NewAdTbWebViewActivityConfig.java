package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class NewAdTbWebViewActivityConfig extends WebViewActivityConfig {
    public NewAdTbWebViewActivityConfig(Context context, String str, String str2, boolean z, String str3) {
        super(context, str, str2, z);
        getIntent().putExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str3);
    }

    public NewAdTbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3) {
        super(context, str, str2, z, z2, z3);
        getIntent().putExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str3);
    }

    public NewAdTbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        super(context, str, str2, z, z2, z3, z4);
        getIntent().putExtra(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str3);
    }
}

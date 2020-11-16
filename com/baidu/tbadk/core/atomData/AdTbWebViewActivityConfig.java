package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class AdTbWebViewActivityConfig extends WebViewActivityConfig {
    public AdTbWebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context, str, str2, z);
    }

    public AdTbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        super(context, str, str2, z, z2, z3);
    }

    public AdTbWebViewActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context, str, str2, z, z2, z3, z4);
    }

    @Override // com.baidu.tbadk.core.atomData.WebViewActivityConfig
    public String addTiebaParams(String str) {
        return str;
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommSellerErrorActivityConfig extends IntentConfig {
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MSG = "errorMsg";

    public EcommSellerErrorActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(ERROR_CODE, i);
        getIntent().putExtra(ERROR_MSG, str);
    }
}

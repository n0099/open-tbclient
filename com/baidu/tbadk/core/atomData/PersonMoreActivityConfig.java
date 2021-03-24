package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class PersonMoreActivityConfig extends IntentConfig {
    public static final String URL_BUNDLE = "url_bundle";

    public PersonMoreActivityConfig(Context context, Bundle bundle) {
        super(context);
        getIntent().putExtra(URL_BUNDLE, bundle);
    }
}

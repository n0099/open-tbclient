package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HomePageTabFeedCollegeSecondActivityConfig extends IntentConfig {
    public static final String KEY_DATA = "data";

    public HomePageTabFeedCollegeSecondActivityConfig(Context context, Parcelable parcelable) {
        super(context);
        getIntent().putExtra("data", parcelable);
    }
}

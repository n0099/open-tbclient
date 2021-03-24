package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AlbumFloatActivityConfig extends AlbumActivityConfig {
    public AlbumFloatActivityConfig(Context context, String str, boolean z, boolean z2) {
        super(context, str, z, z2);
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            getIntent().putExtra("prefix_data", postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }
}

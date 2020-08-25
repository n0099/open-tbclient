package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
/* loaded from: classes2.dex */
public class AlbumFloatActivityConfig extends AlbumActivityConfig {
    public AlbumFloatActivityConfig(Context context, String str, boolean z, boolean z2) {
        super(context, str, z, z2);
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        if (getIntent() != null) {
            getIntent().putExtra("forum_first_dir", str);
            getIntent().putExtra("forum_second_dir", str2);
            getIntent().putExtra("prefix_data", postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MangaVipMaskActivityConfig extends IntentConfig {
    public static final String MEMBER_TYPE = "member_type";

    public MangaVipMaskActivityConfig(Context context, int i) {
        super(context);
        getIntent().putExtra("member_type", i);
    }
}

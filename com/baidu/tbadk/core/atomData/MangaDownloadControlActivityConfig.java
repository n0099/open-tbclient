package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class MangaDownloadControlActivityConfig extends IntentConfig {
    public static final String CARTOON_ID = "cartoon_id";
    public static final String CARTOON_NAME = "cartoon_name";

    public MangaDownloadControlActivityConfig(Context context, long j, String str) {
        super(context);
        getIntent().putExtra("cartoon_id", j);
        getIntent().putExtra(CARTOON_NAME, str);
    }
}

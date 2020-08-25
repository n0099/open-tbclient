package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class MangaDownloadListActivityConfig extends IntentConfig {
    public static final String CARTOON_ID = "cartoon_id";

    public MangaDownloadListActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("cartoon_id", j);
    }
}

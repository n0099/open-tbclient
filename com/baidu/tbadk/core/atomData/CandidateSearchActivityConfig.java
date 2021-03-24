package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class CandidateSearchActivityConfig extends IntentConfig {
    public CandidateSearchActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("forum_id", str);
    }
}

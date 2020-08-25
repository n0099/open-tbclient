package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class PraiseListActivityConfig extends IntentConfig {
    public static final String IS_AUTHOR = "is_author";
    public static final int TYPE_GRAFFITI_PRAISE_LIST = 1;
    public static final int TYPE_NORMAL_PRAISE_LIST = 0;

    public PraiseListActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra("post_id", str2);
        getIntent().putExtra("post_desc", str3);
        getIntent().putExtra("is_from_pb", z);
    }

    public void setIsGraffitiPraiseList() {
        if (getIntent() != null) {
            getIntent().putExtra("list_type", 1);
        }
    }

    public void setIsAuthor(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(IS_AUTHOR, z);
        }
    }
}

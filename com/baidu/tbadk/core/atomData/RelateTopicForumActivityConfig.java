package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RelateTopicForumActivityConfig extends IntentConfig {
    public RelateTopicForumActivityConfig(Context context, List list) {
        super(context);
        getIntent().putExtra("data_list", (ArrayList) list);
    }
}

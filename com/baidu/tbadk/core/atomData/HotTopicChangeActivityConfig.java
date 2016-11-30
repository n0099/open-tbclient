package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class HotTopicChangeActivityConfig extends IntentConfig {
    public static final String ST_TYPE = "hot_topic_change";

    public HotTopicChangeActivityConfig(Context context, int i, List<HotTopicBussinessData> list) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM, (Serializable) list);
    }
}

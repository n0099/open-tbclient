package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicChangeActivityConfig extends IntentConfig {
    public static final String KEY_USE_ORIGIN_LIST = "KEY_USE_ORIGIN_LIST";
    public static final String ST_TYPE = "hot_topic_change";

    public HotTopicChangeActivityConfig(Context context, int i, List<HotTopicBussinessData> list) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("hot_topic_forum_list", (Serializable) list);
    }

    public void setUseOriginList(boolean z) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_USE_ORIGIN_LIST, z);
        }
    }
}

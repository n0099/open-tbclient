package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HotTopicActivityConfig extends IntentConfig {
    public static final String HOT_TOPIC_SELECT_STRING = "hot_string";
    public static final String ST_TYPE = "hot_topic";

    public HotTopicActivityConfig(Context context) {
        super(context);
    }

    public HotTopicActivityConfig createNormalConfig(String str, String str2, String str3) {
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.TOPIC_ID, str);
        intent.putExtra(IntentConfig.TOPIC_NAME, str2);
        intent.putExtra("from", str3);
        return this;
    }

    public static boolean isHotTopicAvailable() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }
}

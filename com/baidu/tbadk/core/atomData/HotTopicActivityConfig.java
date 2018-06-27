package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HotTopicActivityConfig extends IntentConfig {
    public static final String FROM_BANG = "5";
    public static final String FROM_OTHER_CARD = "1";
    public static final String FROM_PB = "2";
    public static final String FROM_SEARCH = "4";
    public static final String FROM_TOPIC_CARD = "3";
    public static final String HOT_TOPIC_SELECT_STRING = "hot_string";
    public static final String ST_TYPE = "hot_topic";

    public HotTopicActivityConfig(Context context) {
        super(context);
    }

    public HotTopicActivityConfig createNormalConfig(String str, String str2, String str3) {
        Intent intent = getIntent();
        intent.putExtra(IntentConfig.TOPIC_ID, str);
        intent.putExtra(IntentConfig.TOPIC_NAME, str2);
        if (StringUtils.isNull(str3)) {
            str3 = "1";
        }
        intent.putExtra("from", str3);
        return this;
    }

    public void setExtra(long j, String str, String str2, long j2) {
        getIntent().putExtra(IntentConfig.TOPIC_FID, j);
        getIntent().putExtra(IntentConfig.TOPIC_FIRST_DIR, str);
        getIntent().putExtra(IntentConfig.TOPIC_SECOND_DIR, str2);
        getIntent().putExtra(IntentConfig.TOPIC_TID, j2);
    }
}

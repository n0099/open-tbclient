package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class WriteVoteActivityConfig extends IntentConfig {
    public static final String ANTI = "anti";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String MEMBER_TYPE = "mem_type";
    public static final String PREFIX_DATA = "prefix_data";

    public WriteVoteActivityConfig(Activity activity, String str, String str2, AntiData antiData, int i, PostPrefixData postPrefixData, int i2) {
        super(activity);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("anti", antiData);
        getIntent().putExtra("mem_type", i2);
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
    }
}

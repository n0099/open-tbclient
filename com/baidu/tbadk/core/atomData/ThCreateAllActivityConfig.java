package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ThCreateAllActivityConfig extends IntentConfig {
    public static final String ANTI_DATA = "anti_data";
    public static final String CATEGORY_ID = "category_id";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String MEM_TYPE = "mem_type";
    public static final String POST_PREFIX_DATA = "post_prefix_data";

    public ThCreateAllActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public ThCreateAllActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }

    public ThCreateAllActivityConfig(Context context, String str, String str2, int i, int i2, AntiData antiData, PostPrefixData postPrefixData) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("mem_type", i);
        getIntent().putExtra("category_id", i2);
        getIntent().putExtra("anti_data", antiData);
        getIntent().putExtra(POST_PREFIX_DATA, postPrefixData);
    }
}

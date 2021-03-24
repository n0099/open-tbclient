package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class AddLinkActivityConfig extends IntentConfig {
    public static final String BUBBLE_NEW_LINK_CONTENT = "bubble_new_link_content";
    public static final String IS_SHOW_FIND_NEW_LINK_BUBBLE = "is_show_find_new_link_bubble";
    public static final String NEW_LINK_CONTENT = "new_link_content";
    public static final String ORIGINAL_LINK_CONTENT = "original_link_content";
    public static final String SPAN_ID = "span_id";

    public AddLinkActivityConfig(Context context, int i, String str, boolean z, String str2) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra(ORIGINAL_LINK_CONTENT, str);
        getIntent().putExtra(IS_SHOW_FIND_NEW_LINK_BUBBLE, z);
        getIntent().putExtra(BUBBLE_NEW_LINK_CONTENT, str2);
    }

    public AddLinkActivityConfig(Context context, int i, int i2, String str) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra(SPAN_ID, i2);
        getIntent().putExtra(ORIGINAL_LINK_CONTENT, str);
    }
}

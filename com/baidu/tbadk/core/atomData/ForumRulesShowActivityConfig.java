package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ForumRulesShowActivityConfig extends IntentConfig {
    public static final String FORUM_RULE_EDIT_FROM_SHOW = "forum_rule_edit_pre";
    public static final String FORUM_RULE_H5_FROM_SHOW = "forum_rule_h5_pre";
    public static final String FORUM_RULE_PUSH_FROM_SHOW = "forum_rule_push_pre";
    public static final String FORUM_RULE_SHOW_FROM_MESSAGE = "forum_rule_show_from_message";

    public ForumRulesShowActivityConfig(Context context, String str, String str2) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("from", str2);
    }

    public ForumRulesShowActivityConfig(Context context, String str, String str2, ForumRuleBaseData forumRuleBaseData, String str3, String str4, int i) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(IntentConfig.DATAS, forumRuleBaseData);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("url", str4);
        getIntent().putExtra(IntentConfig.USER_LEVEL, i);
    }
}

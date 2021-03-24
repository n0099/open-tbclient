package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ForumRuleEditActivityConfig extends IntentConfig {
    public static final String FORUM_RULE_EDIT_FROM_DELETED_REASON_DIALOG = "forum_rule_edit_from_deleted_reason_dialog";
    public static final String FORUM_RULE_EDIT_FROM_FRS = "forum_rule_edit_from_frs";
    public static final String FORUM_RULE_EDIT_FROM_SHOW = "forum_rule_edit_from_show";

    public ForumRuleEditActivityConfig(Context context, String str, String str2, String str3, int i, String str4) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str4);
        getIntent().putExtra("url", str3);
        getIntent().putExtra(IntentConfig.USER_LEVEL, i);
    }

    public ForumRuleEditActivityConfig(Context context, String str, String str2, String str3, ForumRuleBaseData forumRuleBaseData, String str4, int i, int i2) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("url", str4);
        getIntent().putExtra(IntentConfig.USER_LEVEL, i);
        getIntent().putExtra(IntentConfig.DATAS, forumRuleBaseData);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public ForumRuleEditActivityConfig(Context context, String str, String str2, String str3, String str4, int i, int i2) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("url", str4);
        getIntent().putExtra(IntentConfig.USER_LEVEL, i);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

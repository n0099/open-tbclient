package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumRulesShowActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_RULE_EDIT_FROM_SHOW = "forum_rule_edit_pre";
    public static final String FORUM_RULE_H5_FROM_SHOW = "forum_rule_h5_pre";
    public static final String FORUM_RULE_PUSH_FROM_SHOW = "forum_rule_push_pre";
    public static final String FORUM_RULE_SHOW_FROM_MESSAGE = "forum_rule_show_from_message";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRulesShowActivityConfig(Context context, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("from", str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRulesShowActivityConfig(Context context, String str, String str2, ForumRuleBaseData forumRuleBaseData, String str3, String str4, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, forumRuleBaseData, str3, str4, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(IntentConfig.DATAS, forumRuleBaseData);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("url", str4);
        getIntent().putExtra(IntentConfig.USER_LEVEL, i2);
    }
}

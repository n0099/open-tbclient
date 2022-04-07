package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CreateGroupMainActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CANCREATECOMMONGROUP = "canCreateCommonGroup";
    public static final String CANCRRATEOFFICIALGROUP = "canCreateOfficialGroup";
    public static final String CREATECOMMONGROUPTIP = "createCommonGroupTip";
    public static final String CREATEGROUPOFFICIALTIP = "createGroupOfficialTip";
    public static final String FORUMID = "forumid";
    public static final String NUM_CREATE_GROUP_NORMAL = "num_create_group_normal";
    public static final String NUM_CREATE_GROUP_OFFICAL = "num_create_group_offical";
    public static final String NUM_CREATE_GROUP_PERSONAL = "num_create_group_private";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGroupMainActivityConfig(Context context, boolean z, boolean z2, String str, String str2, int i, int i2, int i3, int i4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CANCRRATEOFFICIALGROUP, z);
        getIntent().putExtra(CANCREATECOMMONGROUP, z2);
        getIntent().putExtra(CREATEGROUPOFFICIALTIP, str);
        getIntent().putExtra(CREATECOMMONGROUPTIP, str2);
        getIntent().putExtra("num_create_group_normal", i2);
        getIntent().putExtra("num_create_group_offical", i3);
        getIntent().putExtra("num_create_group_private", i4);
        getIntent().putExtra("forumid", i);
    }
}

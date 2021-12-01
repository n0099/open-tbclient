package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AddLinkActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUBBLE_NEW_LINK_CONTENT = "bubble_new_link_content";
    public static final String IS_SHOW_FIND_NEW_LINK_BUBBLE = "is_show_find_new_link_bubble";
    public static final String NEW_LINK_CONTENT = "new_link_content";
    public static final String ORIGINAL_LINK_CONTENT = "original_link_content";
    public static final String SPAN_ID = "span_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddLinkActivityConfig(Context context, int i2, String str, boolean z, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, Boolean.valueOf(z), str2};
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
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra(ORIGINAL_LINK_CONTENT, str);
        getIntent().putExtra(IS_SHOW_FIND_NEW_LINK_BUBBLE, z);
        getIntent().putExtra(BUBBLE_NEW_LINK_CONTENT, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddLinkActivityConfig(Context context, int i2, int i3, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra(SPAN_ID, i3);
        getIntent().putExtra(ORIGINAL_LINK_CONTENT, str);
    }
}

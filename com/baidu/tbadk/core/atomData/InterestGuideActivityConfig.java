package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class InterestGuideActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUSTOM_TITLE_DATA_LENGTH = 3;
    public static final int INTEREST_GUID_SHOW_SCENE_FIRST = 8;
    public static final int INTEREST_GUID_SHOW_SCENE_FIRST_START = 4;
    public static final int INTEREST_GUID_SHOW_SCENE_NOT_FIRST = 9;
    public static final int INTEREST_GUID_SHOW_SCENE_OTHER = 2;
    public static final int INTEREST_GUID_SHOW_SCENE_Y_DAY = 10;
    public static final String KEY_CUSTOM_TITLE = "key_custom_title";
    public static final String KEY_INTEREST_BACK_TO_MAINTAB = "interest_back_to_maintab";
    public static final String KEY_INTEREST_GUID_SHOW_SCENE = "interest_guid_show_scene";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestGuideActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestGuideActivityConfig(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(KEY_INTEREST_GUID_SHOW_SCENE, i);
    }

    public void setCustomTitle(String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) && strArr != null && strArr.length >= 3) {
            getIntent().putExtra(KEY_CUSTOM_TITLE, strArr);
        }
    }

    public void setIsBackToMainTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            getIntent().putExtra(KEY_INTEREST_BACK_TO_MAINTAB, z);
        }
    }

    public void setScene(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            getIntent().putExtra(KEY_INTEREST_GUID_SHOW_SCENE, i);
        }
    }
}

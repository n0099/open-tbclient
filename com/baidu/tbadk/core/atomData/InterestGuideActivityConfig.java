package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class InterestGuideActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUSTOM_TITLE_DATA_LENGTH = 3;
    public static final int INTEREST_GUID_SHOW_SCENE_FIRST = 8;
    public static final int INTEREST_GUID_SHOW_SCENE_FIRST_START = 4;
    public static final int INTEREST_GUID_SHOW_SCENE_NOT_FIRST = 9;
    public static final int INTEREST_GUID_SHOW_SCENE_OTHER = 2;
    public static final int INTEREST_GUID_SHOW_SCENE_Y_DAY = 10;
    public static final String KEY_CLASS_ID_WHEN_ONLY_SHOW_INTERESTED_FORUM = "KEY_CLASS_ID_WHEN_ONLY_SHOW_INTERESTED_FORUM";
    public static final String KEY_CUSTOM_TITLE = "key_custom_title";
    public static final String KEY_INTEREST_GUID_SHOW_SCENE = "interest_guid_show_scene";
    public static final String KEY_ONLY_SHOW_INTERESTED_FORUM = "key_only_show_interested_forum";
    public static final int SCENE_HOME_RECOMMEND_INTEREST_CARD = 5;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setCustomTitle(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) || strArr == null || strArr.length < 3) {
            return;
        }
        getIntent().putExtra("key_custom_title", strArr);
    }

    public void setOnlyShowInterestedForum(boolean z, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, arrayList) == null) {
            getIntent().putExtra("key_only_show_interested_forum", z);
            getIntent().putExtra(KEY_CLASS_ID_WHEN_ONLY_SHOW_INTERESTED_FORUM, arrayList);
        }
    }

    public void setScene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            getIntent().putExtra(KEY_INTEREST_GUID_SHOW_SCENE, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterestGuideActivityConfig(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
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
        getIntent().putExtra(KEY_INTEREST_GUID_SHOW_SCENE, i2);
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SelectForumConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_SELECT_INTEREST_FORUM = "is_select_interest_forum";
    public static final String KEY_SELECTED_INTEREST_FORUMS = "key_selected_interest_forums";
    public static final String KEY_SELECTED_INTEREST_FORUMS_RESPONSE = "key_selected_interest_forums_response";
    public static final int SELECT_INTEREST_FORUMS_REQ;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1896039451, "Lcom/baidu/tbadk/core/atomData/SelectForumConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1896039451, "Lcom/baidu/tbadk/core/atomData/SelectForumConfig;");
                return;
            }
        }
        SELECT_INTEREST_FORUMS_REQ = BdUniqueId.gen().getId();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectForumConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setIsSelectInterestForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra(IS_SELECT_INTEREST_FORUM, z);
        }
    }

    public void setSelectedInterestedForums(ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            getIntent().putParcelableArrayListExtra(KEY_SELECTED_INTEREST_FORUMS, arrayList);
        }
    }
}

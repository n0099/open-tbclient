package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class QuestionTagChooseActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CATEGORY = "key_category";
    public static final String KEY_QUESTION_TAG_DEFAULT_CATEGORY = "key_question_default_category";
    public static final String KEY_QUESTION_TAG_REFER = "key_question_tag_refer";
    public static final String KEY_RESPONSE_CREATE_TAG = "key_response_create_tag";
    public static final String KEY_RESPONSE_TAG = "key_response_tag";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTagChooseActivityConfig(Context context) {
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
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(25072);
    }

    public QuestionTagChooseActivityConfig setCategory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            getIntent().putExtra("key_category", str);
            return this;
        }
        return (QuestionTagChooseActivityConfig) invokeL.objValue;
    }

    public QuestionTagChooseActivityConfig setKeyQuestionTagDefaultCategory(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            getIntent().putExtra(KEY_QUESTION_TAG_DEFAULT_CATEGORY, str);
            return this;
        }
        return (QuestionTagChooseActivityConfig) invokeL.objValue;
    }

    public QuestionTagChooseActivityConfig setKeyQuestionTagRefer(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            getIntent().putExtra(KEY_QUESTION_TAG_REFER, str);
            return this;
        }
        return (QuestionTagChooseActivityConfig) invokeL.objValue;
    }
}

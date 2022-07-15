package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaseWriteConfig<T> extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADDITION_DATA = "addition_data";
    public static final String CATEGORY_ID = "category_id";
    public static final String CONTENT = "write_content";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String HOT_TOPIC = "hot_topic";
    public static final String HOT_TOPIC_POST_FORUM = "hot_topic_forum_list";
    public static final String IS_SAVE_DRAFTE = "need_save_draft";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_WRITE_IMAGES_INFO_STRING = "KEY_WRITE_IMAGES_INFO_STRING";
    public static final String KEY_WRITE_LEVEL = "key_write_level";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String PRIVATE_THREAD = "private_thread";
    public static final String THREAD_ID = "thread_id";
    public static final String TITLE = "write_title";
    public static final String TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWriteConfig(Context context) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tbadk.core.atomData.BaseWriteConfig<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public T setCategoryId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            getIntent().putExtra("category_id", i);
            return this;
        }
        return (T) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tbadk.core.atomData.BaseWriteConfig<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public T setForumDir(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Intent intent = getIntent();
            if (str == null) {
                str = "";
            }
            intent.putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            Intent intent2 = getIntent();
            if (str2 == null) {
                str2 = "";
            }
            intent2.putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            return this;
        }
        return (T) invokeLL.objValue;
    }
}

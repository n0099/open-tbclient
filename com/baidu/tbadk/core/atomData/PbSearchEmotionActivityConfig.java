package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PbSearchEmotionActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTHOR_SHOW_NAME = "author_show_name";
    public static final String CURRENT_QUERY_WORD = "current_query_word";
    public static final String KEEP_IMG_CACHE_LIST = "keep_img_cache_list";
    public static final String TOP_WORDS = "top_words";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbSearchEmotionActivityConfig(Context context, int i2, String str, List<String> list, String str2, List<String> list2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, list, str2, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        if (!TextUtils.isEmpty(str)) {
            getIntent().putExtra(CURRENT_QUERY_WORD, str);
        }
        if (list != null && (list instanceof ArrayList)) {
            getIntent().putStringArrayListExtra(TOP_WORDS, (ArrayList) list);
        }
        if (str2 != null) {
            getIntent().putExtra(AUTHOR_SHOW_NAME, str2);
        }
        if (list2 == null || !(list2 instanceof ArrayList)) {
            return;
        }
        getIntent().putStringArrayListExtra(KEEP_IMG_CACHE_LIST, (ArrayList) list2);
    }
}

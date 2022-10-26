package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MangaBrowserActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BROWSER_FROM_BOOK_COVER = 1;
    public static final int BROWSER_FROM_COLLECTION = 3;
    public static final int BROWSER_FROM_DOWN_LIST = 7;
    public static final int BROWSER_FROM_FRS_LIST = 2;
    public static final int BROWSER_FROM_MY_LIKE = 6;
    public static final int BROWSER_FROM_PERSON_INFO = 5;
    public static final String CARTOON_ID = "cartoon_id";
    public static final String CHAPTER_ID = "chapter_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MangaBrowserActivityConfig(Context context, long j, int i, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)};
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
        getIntent().putExtra(CARTOON_ID, j);
        getIntent().putExtra(CHAPTER_ID, i);
        getIntent().putExtra("from", i2);
    }
}

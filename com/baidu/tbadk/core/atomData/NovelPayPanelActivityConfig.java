package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class NovelPayPanelActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TYPE = "book_type";
    public static final String FROM_READER_SDK = "reader_sdk";
    public static final String PAGE_ID = "page_id";
    public static final String PAY_TYPE = "pay_type";
    public static final int PAY_TYPE_BUY = 1;
    public static final int PAY_TYPE_EXCHANGE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelPayPanelActivityConfig(Context context, int i2, String str, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, Integer.valueOf(i3)};
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
        getIntent().putExtra("book_type", i2);
        getIntent().putExtra("book_id", str);
        getIntent().putExtra("page_id", i3);
    }

    public void setForm(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("from", str);
    }

    public void setPayType(int i2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("pay_type", i2);
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import c.a.d.f.m.b;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NewVcodeActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_AD = "is_ad";
    public static final String NEED_FEED_BACK_BUTTON = "need_feed_back_button";
    public static final String PAGE_TYPE = "page_type";
    public static final String SAVE_KEY = "model";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewVcodeActivityConfig(Context context, int i2, WriteData writeData, boolean z, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), writeData, Boolean.valueOf(z), str};
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
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
        if (writeData == null) {
            return;
        }
        getIntent().putExtra("model", writeData);
        getIntent().putExtra("is_ad", z);
        getIntent().putExtra("page_type", b.e(str, 0));
    }

    public void setHideFeedBackButton() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(NEED_FEED_BACK_BUTTON, false);
    }
}

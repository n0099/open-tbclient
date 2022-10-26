package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VrPlayerActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_LOGO = "is_logo";
    public static final String PIC_HEIGHT = "pic_height";
    public static final String PIC_WIDTH = "pic_width";
    public static final String RES_PATH = "video_path";
    public static final String TITLE = "title";
    public static final String TYPE = "type";
    public static final int TYPE_PIC = 2;
    public static final int TYPE_VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VrPlayerActivityConfig(Context context, int i, boolean z, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z), str};
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
        if (getIntent() != null) {
            getIntent().putExtra("type", i);
            getIntent().putExtra(IS_LOGO, z);
            getIntent().putExtra(RES_PATH, str);
        }
    }

    public void addPicParam(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && getIntent() != null) {
            getIntent().putExtra(PIC_WIDTH, i);
            getIntent().putExtra(PIC_HEIGHT, i2);
        }
    }

    public void addTitle(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && getIntent() != null) {
            getIntent().putExtra("title", str);
        }
    }
}

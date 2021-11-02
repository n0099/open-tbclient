package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class EmotionDetailActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_FROM_PACKAGE = "from_package";
    public static final String EMOTION_IS_GIF_KEY = "is_gif";
    public static final String EMOTION_PCK_ID_KEY = "pck_id";
    public static final String EMOTION_PIC_ID_KEY = "pic_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailActivityConfig(Context context, int i2, long j, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z)};
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
        Intent intent = getIntent();
        intent.putExtra("pck_id", i2);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
        intent.putExtra(EMOTION_IS_GIF_KEY, z);
    }

    public EmotionDetailActivityConfig setFromEmotionPackage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            getIntent().putExtra(EMOTION_FROM_PACKAGE, z);
            return this;
        }
        return (EmotionDetailActivityConfig) invokeZ.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionDetailActivityConfig(Context context, int i2, long j, int i3, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Boolean.valueOf(z)};
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
        Intent intent = getIntent();
        setRequestCode(i3);
        intent.putExtra("pck_id", i2);
        intent.putExtra(EMOTION_PIC_ID_KEY, j);
        intent.putExtra(EMOTION_IS_GIF_KEY, z);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EmotionImageActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionImageActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, str2, str3, str4, str5, str6, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
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
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        intent.putExtra("pid", str);
        intent.putExtra("panme", str2);
        intent.putExtra("iconUrl", str3);
        intent.putExtra("gifUrl", str5);
        intent.putExtra("staticUrl", str4);
        intent.putExtra("sharpText", str6);
        intent.putExtra("from", i);
        intent.putExtra("width", i2);
        intent.putExtra("height", i3);
    }
}

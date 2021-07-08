package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VideoEasterEggActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_FRS = "from_frs";
    public static final String FROM_HOTTOPIC = "from_hottopic";
    public static final String FROM_MAINTAB = "from_maintab";
    public static final String FROM_PERSON = "from_person";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEasterEggActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public VideoEasterEggActivityConfig createNormalConfig(String str, VideoEasterEggData videoEasterEggData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, videoEasterEggData)) == null) {
            Intent intent = getIntent();
            intent.putExtra("from", str);
            intent.putExtra(IntentConfig.VIDEO_EASTER_EGG_DATA, videoEasterEggData);
            return this;
        }
        return (VideoEasterEggActivityConfig) invokeLL.objValue;
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CloudMusicActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MUSIC_DATA = "music_data";
    public static final String MUSIC_ID = "music_id";
    public static final String MUSIC_RESOURCE = "music_resource";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudMusicActivityConfig(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
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
    }

    public void setCurrentMusicData(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbMusicData) == null) {
            getIntent().putExtra(MUSIC_DATA, tbMusicData);
        }
    }
}

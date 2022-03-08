package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EmotionEditActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_DATA = "EmotionImageData";
    public static final String EMOTION_IS_GIF = "EmotionIsGif";
    public static final String FROM_PB_BOTTOM = "from_pb_bottom";
    public static final String FROM_PB_SEARCH = "from_pb_search";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionEditActivityConfig(Context context, int i2, EmotionImageData emotionImageData, boolean z, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), emotionImageData, Boolean.valueOf(z), str};
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
        getIntent().putExtra(EMOTION_DATA, emotionImageData);
        getIntent().putExtra(EMOTION_IS_GIF, z);
        getIntent().putExtra("from", str);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

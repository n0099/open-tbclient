package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class XiaoyingPlayerConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_THUMBNAIL_URL = "extra_thumbnail_url";
    public static final String EXTRA_URL = "extra_url";
    public static final String EXTRA_VIDEO_HEIGHT = "extra_video_height";
    public static final String EXTRA_VIDEO_WIDTH = "extra_video_width";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XiaoyingPlayerConfig(Context context, String str, int i2, int i3, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
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
        getIntent().putExtra(EXTRA_URL, str);
        getIntent().putExtra(EXTRA_VIDEO_WIDTH, i2);
        getIntent().putExtra(EXTRA_VIDEO_HEIGHT, i3);
        getIntent().putExtra(EXTRA_THUMBNAIL_URL, str2);
    }
}

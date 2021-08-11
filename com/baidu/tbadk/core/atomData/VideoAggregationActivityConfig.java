package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoAggregationActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_FROM = "PARAM_FROM";
    public static final String PARAM_ID = "PARAM_FID";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public static final String TYPE_FROM_FRS = "type_from_frs";
    public static final String TYPE_FROM_VIDEO_CARD = "type_from_video_card";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAggregationActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
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
        getIntent().putExtra("PARAM_FID", str);
        getIntent().putExtra("PARAM_FROM", str2);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("yuelaou_locate", str4);
    }
}

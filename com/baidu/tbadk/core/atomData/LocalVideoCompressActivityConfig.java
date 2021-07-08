package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LocalVideoCompressActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_LOCAL_VIDEO_DURATION = "local_video_duration";
    public static final String KEY_LOCAL_VIDEO_PATH = "local_video_path";
    public static final String KEY_LOCAL_VIDEO_THUMB_PATH = "local_video_thumb_path";
    public static final String KEY_LOCAL_VIEW_BG = "local_view_bg";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoCompressActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, long j, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, Long.valueOf(j), str6};
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
        getIntent().putExtra(KEY_LOCAL_VIDEO_PATH, str);
        getIntent().putExtra(KEY_LOCAL_VIDEO_THUMB_PATH, str2);
        getIntent().putExtra("forum_name", str4);
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("video_title", str5);
        getIntent().putExtra(KEY_LOCAL_VIDEO_DURATION, j);
        getIntent().putExtra(KEY_LOCAL_VIEW_BG, str6);
    }
}

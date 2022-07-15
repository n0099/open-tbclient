package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MotuVideoConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_FINISH_VIDEO_ALL_ACTIVITY = "cn.jingling.motu.mv.finish_all";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String IS_SINGLE_GOD_USER = "is_single_god_user";
    public static final String LOCAL_VIDEO_OPEN = "is_local_video_open";
    public static final String VIDEO_TITLE = "video_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MotuVideoConfig(Context context) {
        this(context, false, null, null, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotuVideoConfig(Context context, boolean z, String str, String str2, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str3);
        getIntent().putExtra(LOCAL_VIDEO_OPEN, z);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

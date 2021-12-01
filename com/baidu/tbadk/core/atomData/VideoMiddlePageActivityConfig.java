package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoMiddlePageActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_CONCERN_TAB = "concern_tab";
    public static final String FROM_DAILY_TAB = "daily_tab";
    public static final String FROM_FRS = "frs";
    public static final String FROM_HOTTOPIC = "hottopic";
    public static final String FROM_INDEX = "index";
    public static final String FROM_SCHEME_QA = "scheme_qa";
    public static final String FROM_VIDEO_TAB = "video_tab";
    public static final String KEY_NID = "key_nid";
    public static final String PARAM_FROM = "PARAM_FROM";
    public static final String PARAM_ID = "PARAM_FID";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_VIDEO_THREAD_INFO = "param_video_thread_info";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageActivityConfig(Context context, String str, String str2, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, videoSerializeVideoThreadInfo};
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
        getIntent().putExtra("PARAM_FID", str2);
        getIntent().putExtra("PARAM_FROM", str);
        getIntent().putExtra("param_video_thread_info", videoSerializeVideoThreadInfo);
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("key_nid", str);
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("PARAM_FID", str2);
        getIntent().putExtra("st_type", str3);
        getIntent().putExtra("yuelaou_locate", str4);
        getIntent().putExtra("PARAM_FROM", str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageActivityConfig(Context context, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this(context, str, str2, str3, str4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, str2, str3, str4, videoSerializeVideoThreadInfo};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("param_video_thread_info", videoSerializeVideoThreadInfo);
    }
}

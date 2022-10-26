package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class TbFileVideoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTER_ANIM_VALUES = "enter_anim_values";
    public static final String FILE_FROM = "file_from";
    public static final String FILTER_NAME = "filter_name";
    public static final int FROM_ALBUM = 1;
    public static final int FROM_EDIT = 2;
    public static final String MULTI_MEDIA_DATA = "multi_media_data";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbFileVideoActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setEnterAnimValues(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            getIntent().putExtra("enter_anim_values", bundle);
        }
    }

    public void setFilter(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmFilterItem) == null) {
            getIntent().putExtra(FILTER_NAME, (Serializable) qmFilterItem);
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            getIntent().putExtra(FILE_FROM, i);
        }
    }

    public void setTbMultiMediaData(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMultiMediaData) == null) {
            getIntent().putExtra(MULTI_MEDIA_DATA, (Parcelable) tbMultiMediaData);
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoInfo) == null) {
            getIntent().putExtra(WriteActivityConfig.VIDEO_INFO, videoInfo);
        }
    }

    public void setForResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setIntentAction(IntentAction.ActivityForResult);
            setRequestCode(25062);
        }
    }
}

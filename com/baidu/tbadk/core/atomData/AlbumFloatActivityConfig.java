package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlbumFloatActivityConfig extends AlbumActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAR_ID = "bar_id";
    public static final String BAR_NAME = "bar_name";
    public static final String CAN_CHANGE_BAR_NAME = "can_change_bar_name";
    public static final String TOPIC = "topic";
    public static final String TOPIC_ID = "topicId";
    public static final String VIDEO_ABSTRACT = "video_abstract";
    public static final String VIDEO_TITLE = "video_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumFloatActivityConfig(Context context, String str, boolean z, boolean z2) {
        super(context, str, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setBarID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            getIntent().putExtra("bar_id", str);
        }
    }

    public void setBarName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            getIntent().putExtra("bar_name", str);
        }
    }

    public void setCanChangeBarName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            getIntent().putExtra(CAN_CHANGE_BAR_NAME, z);
        }
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, antiData, postPrefixData, str, str2) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
        getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
        getIntent().putExtra("prefix_data", postPrefixData);
        getIntent().putExtra("anti_data", antiData);
    }

    public void setIsVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            getIntent().putExtra("is_video_topic", str);
        }
    }

    public void setTopic(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getIntent().putExtra("topic", str);
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            getIntent().putExtra("topicId", str);
        }
    }

    public void setVideoAbstract(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            getIntent().putExtra(VIDEO_ABSTRACT, str);
        }
    }

    public void setVideoTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            getIntent().putExtra("video_title", str);
        }
    }
}

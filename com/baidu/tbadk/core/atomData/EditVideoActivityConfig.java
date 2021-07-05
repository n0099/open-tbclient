package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EditVideoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_TYPE = "from_type";
    public static final String FROM_TYPE_RECORD_VIDEO_ACTIVITY = "from_record_activity";
    public static final String FROM_TYPE_WRITE_ACTIVITY_EDIT = "from_write_activity_edit";
    public static final String KEY_ANTI_DATA = "anti_data";
    public static final String KEY_PRO_ZONE = "pro_zone";
    public static String LOCAL_PATH_KEY = "local_path";
    public static String MUSIC_ID_KEY = "music_id";
    public static String POSITION_KEY = "position";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-613612224, "Lcom/baidu/tbadk/core/atomData/EditVideoActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-613612224, "Lcom/baidu/tbadk/core/atomData/EditVideoActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditVideoActivityConfig(Context context, String str, String str2, String str3, String str4, VideoInfo videoInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, videoInfo};
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
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str4);
        getIntent().putExtra(WriteActivityConfig.VIDEO_INFO, videoInfo);
        getIntent().putExtra("KEY_CALL_FROM", str);
    }

    public void addFromType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            getIntent().putExtra("from_type", str);
        }
    }

    public void addMusicInfo(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2) == null) {
            getIntent().putExtra(LOCAL_PATH_KEY, str);
            getIntent().putExtra(MUSIC_ID_KEY, str2);
            getIntent().putExtra(POSITION_KEY, i2);
        }
    }

    public void addRequestForResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            setRequestCode(i2);
            setIntentAction(IntentAction.ActivityForResult);
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

    public void setForumLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            getIntent().putExtra("key_write_level", i2);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            getIntent().putExtra("from", str);
        }
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, frsTabInfoData) == null) {
            getIntent().putExtra("tab_list", frsTabInfoData);
        }
    }

    public void setProZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            getIntent().putExtra(KEY_PRO_ZONE, i2);
        }
    }

    public void setStatisticFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            getIntent().putExtra(WriteActivityConfig.KEY_STATISTIS_FROM, i2);
        }
    }
}

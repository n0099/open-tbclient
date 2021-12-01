package com.baidu.tbadk.core.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class VideoNotifyPersonalPageData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    @SerializedName("pn")
    public String currentPn;
    @NonNull
    @SerializedName("tid")
    public String currentThreadId;
    @SerializedName("status")
    public int deleteStatus;
    @Nullable
    @SerializedName("message")
    public String deleteStatusMessage;
    @NonNull
    @SerializedName("pageId")
    public String flutterPageId;
    @SerializedName("is_delete")
    public int isDeleteOperate;
    @NonNull
    @SerializedName("uid")
    public String personalPageUid;
    @NonNull
    @SerializedName("post_reply_list")
    public List<Map<String, Object>> userPostDataResMapList;
    @NonNull
    @SerializedName("hot_thread_list")
    public List<Map<String, Object>> videoHotTopicDataResMapList;

    public VideoNotifyPersonalPageData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void setCurrentPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.currentPn = String.valueOf(i2);
        }
    }

    public void setCurrentThreadId(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.currentThreadId = str;
        }
    }

    public void setDeleteStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.deleteStatus = z ? 1 : 2;
        }
    }

    public void setDeleteStatusMessage(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.deleteStatusMessage = str;
        }
    }

    public void setFlutterPageId(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.flutterPageId = str;
        }
    }

    public void setIsDeleteOperate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isDeleteOperate = z ? 1 : 0;
        }
    }

    public void setPersonalPageUid(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.personalPageUid = str;
        }
    }

    public void setUserPostDataResMapList(@NonNull List<Map<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.userPostDataResMapList = list;
        }
    }

    public void setVideoHotTopicDataResMapList(@NonNull List<Map<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.videoHotTopicDataResMapList = list;
        }
    }
}

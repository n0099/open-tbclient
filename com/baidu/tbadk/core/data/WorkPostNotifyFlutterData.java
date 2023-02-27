package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.y79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
/* loaded from: classes3.dex */
public class WorkPostNotifyFlutterData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FAIL_POST = "102";
    public static final String SUCC_POST = "2";
    public static final String SUCC_UPLOAD_VIDEO = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public String errorMessage;
    @NonNull
    public String flutterPageId;
    @Nullable
    public String forumId;
    @Nullable
    public String forumName;
    public String status;
    @NonNull
    public NewWriteThreadData4Flutter threadData;
    public String videoId;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Keep
    /* loaded from: classes3.dex */
    public static class NewWriteThreadData4Flutter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Author author;
        public String barName;
        public Location location;
        @SerializedName("thread_type")
        public int threadType;
        public String title;
        @SerializedName(WriteActivityConfig.VIDEO_INFO)
        public VideoInfo videoInfo;

        @Keep
        /* loaded from: classes3.dex */
        public static class Author {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String id;
            public String name;
            @SerializedName("name_show")
            public String nameShow;
            public String portrait;

            public Author() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        @Keep
        /* loaded from: classes3.dex */
        public static class Location {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String name;

            public Location() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        @Keep
        /* loaded from: classes3.dex */
        public static class VideoInfo {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName(TiebaStatic.Params.IS_VERTICAL)
            public int isVertical;
            @SerializedName(TiebaStatic.Params.POST_TYPE)
            public int postType;
            @SerializedName("thumbnail_height")
            public int thumbnailHeight;
            @SerializedName("thumbnail_url")
            public String thumbnailUrl;
            @SerializedName("thumbnail_width")
            public int thumbnailWidth;
            @SerializedName("video_height")
            public int videoHeight;
            @SerializedName("video_url")
            public String videoUrl;
            @SerializedName("video_width")
            public int videoWidth;

            public VideoInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public NewWriteThreadData4Flutter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ NewWriteThreadData4Flutter(a aVar) {
            this();
        }
    }

    public WorkPostNotifyFlutterData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.status = str;
        this.videoId = str2;
        this.errorMessage = str3;
    }

    public static WorkPostNotifyFlutterData notifyFlutterPostFail(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return new WorkPostNotifyFlutterData(FAIL_POST, "", str);
        }
        return (WorkPostNotifyFlutterData) invokeL.objValue;
    }

    public static WorkPostNotifyFlutterData notifyFlutterPostSucc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return new WorkPostNotifyFlutterData("2", str, "");
        }
        return (WorkPostNotifyFlutterData) invokeL.objValue;
    }

    public void setFlutterPageId(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.flutterPageId = str;
        }
    }

    public void setForumId(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setForumName(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setThreadDataByWriteData(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
            this.threadData = parseFromWriteData4Flutter(writeData);
        }
    }

    public static WorkPostNotifyFlutterData notifyFlutterVideoUploadSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new WorkPostNotifyFlutterData("1", "", "");
        }
        return (WorkPostNotifyFlutterData) invokeV.objValue;
    }

    @NonNull
    public String getFlutterPageId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.flutterPageId;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.forumId;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Map<String, Object> getThreadDataMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NewWriteThreadData4Flutter newWriteThreadData4Flutter = this.threadData;
            if (newWriteThreadData4Flutter == null) {
                return null;
            }
            return DataExt.toMap(newWriteThreadData4Flutter);
        }
        return (Map) invokeV.objValue;
    }

    public static NewWriteThreadData4Flutter parseFromWriteData4Flutter(@NonNull WriteData writeData) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData)) == null) {
            NewWriteThreadData4Flutter.VideoInfo videoInfo = new NewWriteThreadData4Flutter.VideoInfo();
            VideoInfo videoInfo2 = writeData.getVideoInfo();
            String e = y79.e();
            if (TextUtils.isEmpty(e)) {
                e = videoInfo2.getThumbPath();
            }
            videoInfo.thumbnailUrl = e;
            videoInfo.thumbnailWidth = videoInfo2.getVideoWidth();
            videoInfo.thumbnailHeight = videoInfo2.getVideoHeight();
            videoInfo.videoWidth = videoInfo2.getVideoWidth();
            videoInfo.videoHeight = videoInfo2.getVideoHeight();
            if (videoInfo2.getVideoHeight() > videoInfo2.getVideoWidth()) {
                i = 1;
            } else {
                i = 0;
            }
            videoInfo.isVertical = i;
            videoInfo.postType = writeData.getType();
            videoInfo.videoUrl = videoInfo2.getVideoUrl();
            NewWriteThreadData4Flutter.Location location = new NewWriteThreadData4Flutter.Location();
            location.name = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
            NewWriteThreadData4Flutter.Author author = new NewWriteThreadData4Flutter.Author();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                author.id = currentAccountInfo.getID();
                author.nameShow = currentAccountInfo.getAccountNameShow();
                author.name = currentAccountInfo.getAccount();
                author.portrait = currentAccountInfo.getPortrait();
            }
            NewWriteThreadData4Flutter newWriteThreadData4Flutter = new NewWriteThreadData4Flutter(null);
            newWriteThreadData4Flutter.videoInfo = videoInfo;
            newWriteThreadData4Flutter.location = location;
            newWriteThreadData4Flutter.author = author;
            newWriteThreadData4Flutter.threadType = 40;
            newWriteThreadData4Flutter.title = writeData.getTitle();
            newWriteThreadData4Flutter.barName = writeData.getForumName();
            return newWriteThreadData4Flutter;
        }
        return (NewWriteThreadData4Flutter) invokeL.objValue;
    }
}

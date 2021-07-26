package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbEditVideoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENTER_ANIM_VALUES = "enter_anim_values";
    public static final int FROM_CAPTURE = 2;
    public static final int FROM_FILE_VIDEO = 1;
    public static final int FROM_WRITE = 3;
    public static final String KEY_EDIT_PAGE_MODE_TYPE = "key_edit_page_mode_type";
    public static final String KEY_EDIT_VIDEO_DATA = "key_edit_video_file_path";
    public static final String KEY_EDIT_VIDEO_FROM = "key_edit_video_from";
    public static final String KEY_EDIT_VIDEO_MUSIC_DATA = "key_edit_video_music_data";
    public static final String KEY_EDIT_VIDEO_RATIO = "key_edit_video_ratio";
    public static final int MODE_TYPE_COVER_STATUS = 2;
    public static final int MODE_TYPE_EDIT_STATUS = 1;
    public static final int MODE_TYPE_PURE_COVER = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbEditVideoActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    public static TbMultiMediaData convert2MultiMedia(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoInfo)) == null) {
            TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
            tbMultiMediaData.path = videoInfo.getVideoPath();
            tbMultiMediaData.coverPath = videoInfo.getThumbPath();
            tbMultiMediaData.height = videoInfo.getVideoHeight();
            tbMultiMediaData.width = videoInfo.getVideoWidth();
            tbMultiMediaData.type = 1;
            tbMultiMediaData.start = 0L;
            tbMultiMediaData.end = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.originalDuration = videoInfo.getVideoDuration() * 1000;
            tbMultiMediaData.scaleType = "center_inside";
            tbMultiMediaData.coverSource = videoInfo.getMultiMediaData().coverSource;
            tbMultiMediaData.orignalCoverPath = videoInfo.getMultiMediaData().orignalCoverPath;
            tbMultiMediaData.lastCoverPercent = videoInfo.getMultiMediaData().lastCoverPercent;
            tbMultiMediaData.videoInfoType = videoInfo.getVideoType();
            return tbMultiMediaData;
        }
        return (TbMultiMediaData) invokeL.objValue;
    }

    public void setMultiMediaData(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbMultiMediaData) == null) {
            getIntent().putExtra(KEY_EDIT_VIDEO_DATA, (Parcelable) tbMultiMediaData);
        }
    }

    public void setMusicData(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMusicData) == null) {
            getIntent().putExtra(KEY_EDIT_VIDEO_MUSIC_DATA, tbMusicData);
        }
    }

    public void setPageModeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            getIntent().putExtra(KEY_EDIT_PAGE_MODE_TYPE, i2);
        }
    }

    public void setVideoFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            getIntent().putExtra(KEY_EDIT_VIDEO_FROM, i2);
        }
    }

    public void setVideoRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            getIntent().putExtra(KEY_EDIT_VIDEO_RATIO, f2);
        }
    }
}

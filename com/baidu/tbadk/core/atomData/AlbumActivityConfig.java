package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AlbumActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_SELECT_IMAGE_RESULT = "com.baidu.tieba.AlbumActivity.SelectImageResult";
    public static final String ALBUM_RESULT = "album_result";
    public static final String AUTO_PHOTO_NAME = "auto_photo_name";
    public static final int AVATAR_TYPE = 2;
    public static final String CAMERA_PHOTO_NAME = "camera_photo_name";
    public static final String CAMERA_REQUEST_FROM = "camera_request_from";
    public static final String CAMERA_RESULT = "camera_result";
    public static final int COMMON_TYPE = 0;
    public static final String FINISH_SELF = "finish_self";
    public static final String FROM_AIAPPS = "aiapps";
    public static final int FROM_DEFAULT = 0;
    public static final String FROM_FLUTTER = "flutterpicker";
    public static final String FROM_FLUTTER_GAME_VIDEO = "flutter_game_video_picker";
    public static final String FROM_FLUTTER_MULTI = "flutter_multi_picker";
    public static final String FROM_FRS = "frs";
    public static final int FROM_HOME_OR_FRS_PUBLISH = 4;
    public static final String FROM_MAIN_TAB = "main_tab";
    public static final int FROM_OTHER = 5;
    public static final String FROM_PB = "pb";
    public static final int FROM_PB_SHOW_PICTURE = 2;
    public static final String FROM_PERSON = "person";
    public static final int FROM_PHOTO_LIVE_UPGRADE_DIALOG = 3;
    public static final String FROM_TOPIC = "topic";
    public static final int FROM_TOPIC_DETAIL_REPLAY = 4;
    public static final int FROM_VOTE = 3;
    public static final String FROM_WEB_VIEW = "webview";
    public static final int FROM_WEB_VIEW_ALBUM = 6;
    public static final int FROM_WEB_VIEW_HYBRID = 5;
    public static final String FROM_WRITE = "write";
    public static final int FROM_WRITE_ACTIVITY = 3;
    public static final int IM_TYPE = 1;
    public static final String IS_SELECT_DIRECTLY = "select_directly";
    public static final String KEY_ALBUM_DIRECT_DONE_ONLY_ONE = "key_album_direct_done_only_one";
    public static final String KEY_ALBUM_SHOW_CAPTURE = "key_album_show_capture";
    public static final String KEY_DIRECT_TO_WORK_PUBLISH_PAGE = "key_direct_to_work_publish_page";
    public static final String KEY_FORUM_WRITE_DATA = "KEY_FORUM_WRITE_DATA";
    public static final String LAST_ALBUM_ID = "last_album_id";
    public static final String USE_ORIGINAL_IMG = "use_original_img";
    public static final String WRITE_IMAGES_INFO = "write_images_info";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        getIntent().putExtra(CAMERA_REQUEST_FROM, 0);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, int i) {
        this(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CAMERA_REQUEST_FROM, i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, String str2) {
        this(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CAMERA_PHOTO_NAME, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, String str2, int i) {
        this(context, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CAMERA_REQUEST_FROM, i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, String str2, boolean z) {
        this(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CAMERA_PHOTO_NAME, str2);
        getIntent().putExtra(USE_ORIGINAL_IMG, z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, boolean z) {
        this(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        getIntent().putExtra(AUTO_PHOTO_NAME, z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, String str, boolean z, boolean z2) {
        this(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        getIntent().putExtra(AUTO_PHOTO_NAME, z);
        getIntent().putExtra(USE_ORIGINAL_IMG, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumActivityConfig(Context context, boolean z, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        getIntent().putExtra(CAMERA_REQUEST_FROM, 0);
        getIntent().putExtra(WRITE_IMAGES_INFO, str);
        getIntent().putExtra(USE_ORIGINAL_IMG, z);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setAlbumDirectDoneOnlyOne(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra(KEY_ALBUM_DIRECT_DONE_ONLY_ONE, z);
        }
    }

    public void setAlbumShowCapture(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            getIntent().putExtra(KEY_ALBUM_SHOW_CAPTURE, z);
        }
    }

    public void setAlbumThread(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, i);
        }
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            getIntent().putExtra(BaseWriteConfig.KEY_CALL_FROM, str);
        }
    }

    public void setCanEditImage(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, z);
        }
    }

    public void setCanSelectGif(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_CAN_SELECT_GIF, z);
        }
    }

    public void setCanSelectOnlyVideo(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, z);
        }
    }

    public void setCanSelectVideo(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, z);
        }
    }

    public void setFromWrite(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_FROM_WRITE_TYPE, i);
        }
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, frsTabInfoData) == null) {
            getIntent().putExtra("tab_list", frsTabInfoData);
        }
    }

    public void setImageClipType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_IMAGE_CLIP_TYPE, i);
        }
    }

    public void setNeedClipImage(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_NEED_CLIP_IMAGE, z);
        }
    }

    public void setOnlySelectPngAndJpeg(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && getIntent() != null) {
            getIntent().putExtra(IntentConfig.KEY_ONLY_SELECT_PNG_AND_JPEG, z);
        }
    }

    public void setRedirectToWorkPublishPage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            getIntent().putExtra(KEY_DIRECT_TO_WORK_PUBLISH_PAGE, true);
            getIntent().putExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, i);
        }
    }

    public void setRequestFrom(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && getIntent() != null) {
            getIntent().putExtra(CAMERA_REQUEST_FROM, i);
        }
    }

    public void setResourceType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && getIntent() != null) {
            getIntent().putExtra("from_type", i);
        }
    }

    public void setStatisticFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            getIntent().putExtra(WriteActivityConfig.KEY_STATISTIS_FROM, i);
        }
    }
}

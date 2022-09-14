package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoPlayActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_PAGE_UNIQUEID = "activity_page_uniqueid";
    public static final String CURRENT_TYPE = "current_type";
    public static final String FROM = "from";
    public static final String FROM_DEFAULT = "from_default";
    public static final String FROM_FRS = "frs";
    public static final String FROM_H5_SEARCH = "h5_search";
    public static final String FROM_MAINTAB_CONCERN = "concern_tab";
    public static final String FROM_MAINTAB_DAILY = "daily_tab";
    public static final String FROM_MAINTAB_RECOMMEND = "index";
    public static final String FROM_MAINTAB_VIDEO = "video_tab";
    public static final String FROM_NANI_VIDEO = "from_nani_video";
    public static final String FROM_VIDEO_ACCOUNT_ATTENTION_TAB = "video_attention_tab";
    public static final String FROM_VIDEO_ACCOUNT_TAB = "video_channel_tab";
    public static final String FROM_VIDEO_MIDDLE_VIDEO = "from_video_middle_video";
    public static final String IS_FROM_BJH_PB = "is_from_bjh_pb";
    public static final String IS_NEED_SHOW_SECOND_FLOOR = "is_need_show_second_floor";
    public static final String IS_SCROLLED = "is_scrolled";
    public static final String IS_SHARE_THREAD = "is_share_thread";
    public static final String IS_SHOW_PB_COMMENT_FLOAT = "is_show_pb_comment_float";
    public static final String KEY_FPS_VIDEO_FROM_FRS = "FrsToVideo";
    public static final String KEY_FPS_VIDEO_FROM_HOME = "HomeToVideo";
    public static final String KEY_FPS_VIDEO_FROM_TAB = "HomeToTab";
    public static final String KEY_FPS_VIDEO_FRS_PAGE = "FrsToVideo_video_tran";
    public static final String KEY_FPS_VIDEO_HOME_PAGE = "HomeToVideo_video_tran";
    public static final String KEY_FPS_VIDEO_HOME_TAB = "HomeToTab_video_tran";
    public static final String KEY_FPS_VIDEO_PAGE = "video";
    public static final String KEY_FPS_VIDEO_TYPE = "tran";
    public static final String KEY_NID = "key_nid";
    public static final String OBJ_ID = "obj_id";
    public static final String PAGE_FIRST_IN = "page_first_in";
    public static final String PAGE_FROM = "page_from";
    public static final String PARAM_IS_VERTAIL = "is_vertail";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public static final String SOURCE_FROM = "source_from";
    public static final String VIDEO_ATTENTION_LIST = "video_attention_list";
    public static final String VIDEO_ATTENTION_SHOWWORD = "video_attention_showword";
    public static final String VIDEO_COVER_RECT = "video_cover_rect";
    public static final String VIDEO_DATA = "video_data";
    public static final String VIDEO_INDEX = "video_index";
    public static final String VIDEO_LIST = "video_list";
    public static final String VIDEO_SHOW_INDEX = "video_show_index";
    public static final String VIDEO_VIEW_RECT = "video_view_rect";
    public static List<VideoItemData> bigDataList;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i)};
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
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i);
    }

    public void setFid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("forum_id", str);
    }

    public void setForceUseBigDataList(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            bigDataList = list;
            getIntent().removeExtra("video_list");
        }
    }

    public void setIsFromBjhPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            getIntent().putExtra("is_from_bjh_pb", z);
        }
    }

    public void setIsShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("is_show_pb_comment_float", z);
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("key_nid", str);
    }

    public void setParamIsVertail(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("is_vertail", z);
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
    }

    public void setVideoShowIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            getIntent().putExtra("video_show_index", i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str};
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
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i);
        getIntent().putExtra("from", str);
        getIntent().putExtra(VIDEO_VIEW_RECT, rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, str2};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("from", str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str, str2, str3, str4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra(VIDEO_VIEW_RECT, rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra("source_from", str5);
        getIntent().putExtra(VIDEO_VIEW_RECT, rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4, String str5, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str, str2, str3, str4, str5, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("video_index", i);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().putExtra("source_from", str5);
        getIntent().putExtra(VIDEO_VIEW_RECT, rect);
        getIntent().putExtra("is_show_pb_comment_float", z);
    }
}

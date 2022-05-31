package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.module.hottopic.VideoHotTopicParams;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class VideoRecommentPlayActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM = "from";
    public static final String FROM_AGREE_PAGE = "from_agree_page";
    public static final String FROM_AT_PAGE = "from_at_page";
    public static final String FROM_COLLECTION = "from_collection";
    public static final String FROM_CREATE_CENTER = "from_create_center";
    public static final String FROM_DEFAULT = "from_default";
    public static final String FROM_FRS = "frs";
    public static final String FROM_FRS_TOP = "from_frs_top";
    public static final String FROM_HISTORY = "from_history";
    public static final String FROM_LINK_PAGE = "from_link_page";
    public static final String FROM_MAINTAB_CONCERN = "concern_tab";
    public static final String FROM_MAINTAB_DAILY = "daily_tab";
    public static final String FROM_MAINTAB_RECOMMEND = "index";
    public static final String FROM_MAINTAB_VIDEO = "video_tab";
    public static final String FROM_MY_THREADS = "from_my_threads";
    public static final String FROM_NANI_VIDEO = "from_nani_video";
    public static final String FROM_OFFICAL_VIDEO = "from_offical_video";
    public static final String FROM_PB_VIDEO_SCHEME = "from_pb_video_scheme";
    public static final String FROM_PERSONAL_PAGE = "from_personal_page";
    public static final String FROM_REPLY_PAGE = "from_reply_page";
    public static final String FROM_VIDEO_ACCOUNT_ATTENTION_TAB = "video_attention_tab";
    public static final String FROM_VIDEO_ACCOUNT_TAB = "video_channel_tab";
    public static final String FROM_VIDEO_HOT_TOPIC = "from_video_hot_topic";
    public static final String FROM_VIDEO_MIDDLE_VIDEO = "from_video_middle_video";
    public static final String FROM_WORK_MANAGEMENT = "from_work_management";
    public static final String IS_FROM_BJH_PB = "is_from_bjh_pb";
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
    @Nullable
    public static PersonalPageParams bigPersonalPageParams;
    @Nullable
    public static VideoHotTopicParams bigVideoHotTopicParams;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class PersonalPageParams implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String IDENTIFER_FROM_THREAD_TAB = "15";
        public static final String IDENTIFER_FROM_VIDEO_TAB = "14";
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(Config.PACKAGE_NAME)
        public int currentPn;
        @SerializedName("data")
        public List<Map<String, Object>> dataList;
        @SerializedName("enter_type")
        public String enterType;
        @NonNull
        @SerializedName("pageId")
        public String flutterPageId;
        public boolean hasMore;
        @SerializedName("is_share")
        public boolean isShareThread;
        @SerializedName("is_works")
        public boolean isVideoTab;
        @SerializedName("uid")
        public String personalPageUid;
        @SerializedName("tid")
        public String threadId;
        @SerializedName("work_tab_id")
        public int workTabId;

        public PersonalPageParams() {
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

        public int getCurrentPn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.currentPn : invokeV.intValue;
        }

        public List<Map<String, Object>> getDataList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dataList : (List) invokeV.objValue;
        }

        @NonNull
        public String getFlutterPageId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.flutterPageId : (String) invokeV.objValue;
        }

        public String getPersonalPageUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.personalPageUid : (String) invokeV.objValue;
        }

        @NonNull
        public String getStatPageFromIdentifier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isVideoTab ? "14" : "15" : (String) invokeV.objValue;
        }

        @NonNull
        public String getThreadId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.threadId : (String) invokeV.objValue;
        }

        @NonNull
        public int getWorkTabId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.workTabId : invokeV.intValue;
        }

        public boolean isHasMore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.hasMore : invokeV.booleanValue;
        }

        public boolean isShareThread() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isShareThread : invokeV.booleanValue;
        }

        public boolean isVideoTab() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isVideoTab : invokeV.booleanValue;
        }

        public void setCurrentPn(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                this.currentPn = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i)};
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
    }

    public void setIsFromBjhPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra("is_from_bjh_pb", z);
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("key_nid", str);
    }

    public void setParamIsVertail(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || getIntent() == null) {
            return;
        }
        getIntent().putExtra("is_vertail", z);
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, uri) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(IntentConfig.KEY_URI, uri);
    }

    public void setVideoShowIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            getIntent().putExtra("video_show_index", i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str};
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
        getIntent().putExtra("from", str);
        getIntent().setSourceBounds(rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, String str, String str2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        getIntent().putExtra("video_list", (Serializable) list);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("from", str2);
        TbSingleton.getInstance().setIsNeedShowPbCommentFloat(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, String str, String str2) {
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
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str, str2, str3, str4};
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
        getIntent().setSourceBounds(rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i), rect, str, str2, str3, str4, str5};
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
        getIntent().setSourceBounds(rect);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRecommentPlayActivityConfig(@NonNull Context context, int i, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str};
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
        getIntent().putExtra("video_show_index", i);
        getIntent().putExtra("page_from", str);
        getIntent().putExtra("from", str);
    }
}

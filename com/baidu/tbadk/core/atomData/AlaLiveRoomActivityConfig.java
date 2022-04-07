package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaLiveRoomActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FREM_TYPE_LIVE_FRS_STAGE_LIVE = "frs_live_stage_live";
    public static final String FROM_TYPE_ALTER_PLAY = "alter_play";
    public static final String FROM_TYPE_ARTICLE_PB_RECOMMEND = "live_from_article_pb_recommend";
    public static final String FROM_TYPE_BROADCAST_GIFT_TOAST = "broadcast_gift_toast";
    public static final String FROM_TYPE_END_VIEW = "end_view";
    public static final String FROM_TYPE_FRS_AUTO_PLAY = "frs_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_AUTO_PLAY = "frs_live_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_PLAY = "frs_live_play";
    public static final String FROM_TYPE_FRS_PLAY = "frs_play";
    public static final String FROM_TYPE_FRS_SHARE_LIVE = "frs_share_live";
    public static final String FROM_TYPE_HOME_CONCERN_TAB = "home_concern_tab";
    public static final String FROM_TYPE_HOME_LIVE_AUTO_PLAY = "home_live_auto_play";
    public static final String FROM_TYPE_HOME_LIVE_PLAY = "home_live_play";
    public static final String FROM_TYPE_HOME_LIVE_TAB_FRIEND = "home_live_tab_jiaoyou";
    public static final String FROM_TYPE_HOME_LIVE_TAB_MAIN = "home_live_tab_main";
    public static final String FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN = "home_live_tab_my_concern";
    public static final String FROM_TYPE_HOME_REC_AUTO_PLAY = "home_rec_auto_play";
    public static final String FROM_TYPE_HOME_REC_PLAY = "home_rec_play";
    public static final String FROM_TYPE_LIVE_ACTIVE_VIEW = "active_view_jump_live_room";
    public static final String FROM_TYPE_LIVE_BOTTOM_PANEL_FANS = "live_bottom_panel_fans";
    public static final String FROM_TYPE_LIVE_BOTTOM_PANEL_FOLLOWED = "live_bottom_panel_followed";
    public static final String FROM_TYPE_LIVE_CONCERN_TAB_TOP_LIVE = "ala_concern_tab_top_live";
    public static final String FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP = "frs_followed_live_tip";
    public static final String FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP = "frs_hot_live_tip";
    public static final String FROM_TYPE_LIVE_FRS_INSERT_LIVE = "frs_five_floor_recommend";
    public static final String FROM_TYPE_LIVE_LIVE_ROOM_LIVE_TAB = "live_room_live_tab";
    public static final String FROM_TYPE_LIVE_PB_POST_RECOMMEND = "pb_recommend_live";
    public static final String FROM_TYPE_LIVE_PK_SWITCH = "live_pk_switch";
    public static final String FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB = "recent_history_living_tab";
    public static final String FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB = "recent_history_whole_tab";
    public static final String FROM_TYPE_LIVE_ROOM_CLOSE_DIALOG = "live_room_close_dialog";
    public static final String FROM_TYPE_LIVE_ROOM_RANK_LIST = "live_room_rank_list";
    public static final String FROM_TYPE_LIVE_SQUARE_ATTENTION_LIVE = "ala_square_attention_live";
    public static final String FROM_TYPE_MIS_GLOBAL_BROADCAST = "live_mis_global_broadcast";
    public static final String FROM_TYPE_MIS_SINGLE_BROADCAST = "live_mis_single_broadcast";
    public static final String FROM_TYPE_OUTSIDE = "safari_play";
    public static final String FROM_TYPE_PB_AUTO_PLAY = "pb_auto_play";
    public static final String FROM_TYPE_PB_PLAY = "pb_play";
    public static final String FROM_TYPE_PB_USER_ICON_LIVE = "pb_user_icon_live";
    public static final String FROM_TYPE_PERSON_ATTENTION = "person_attention";
    public static final String FROM_TYPE_PERSON_AUTO_PLAY = "person_auto_play";
    public static final String FROM_TYPE_PERSON_PLAY = "person_play";
    public static final String FROM_TYPE_PHOTO_BROWSE_TOP = "live_from_photo_browse_top";
    public static final String FROM_TYPE_REPLY_PORTRAIT = "live_from_reply_portrait";
    public static final String FROM_TYPE_SCAN_HISTORY = "scan_history";
    public static final String FROM_TYPE_SEARCH = "search";
    public static final String FROM_TYPE_SHARE_PLAY = "share_play";
    public static final String FROM_TYPE_SPECIAL_CONCERN_TAB = "frs_live_tab_concern_tab";
    public static final String FROM_TYPE_SPECIAL_GAME_TAB = "frs_live_tab_game_tab";
    public static final String FROM_TYPE_SPECIAL_RECOMMEND_TAB = "frs_live_tab_recommend_tab";
    public static final String FROM_TYPE_SPECIAL_SUB_TAB = "frs_live_tab_sub_tab";
    public static final String FROM_TYPE_SPECIAL_TAB_TOP_LIVE = "frs_live_tab_headview";
    public static final String FROM_TYPE_SQUARE_CATOGORY = "square_category";
    public static final String FROM_TYPE_SQUARE_DYNAMIC = "square_dynamic";
    public static final String FROM_TYPE_SQUARE_LIVE = "square_live";
    public static final String FROM_TYPE_SQUARE_LIVE_BANNER = "square_live_banner";
    public static final String FROM_TYPE_SQUARE_RECOMMEND = "square_recommend";
    public static final String FROM_TYPE_SQUARE_RECOMMEND_TOP_CARD = "square_recommend_top_card";
    @Deprecated
    public static final String FROM_TYPE_SQUARE_SHOW_LIVE = "square_show_field";
    public static final String FROM_TYPE_SQUARE_SUB_LIVE = "square_sub_live";
    public static final String FROM_TYPE_TAIL_LIGHT = "tail_light_play";
    public static final String FROM_TYPE_VIDEO_AUTO_PLAY = "video_auto_play";
    public static final String FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND = "live_from_video_pb_cross_recommend";
    public static final String FROM_TYPE_VIDEO_PB_RECOMMEND = "live_from_video_pb_recommend";
    public static final String FROM_TYPE_VIDEO_PLAY = "video_play";
    public static final String FRS_LIVE_FROM_PREFIX_FRIENDLIVE = "frs_play-friendlive-";
    public static final String FRS_LIVE_FROM_PREFIX_HOT = "frs_play-hot-";
    public static final String FRS_LIVE_FROM_PREFIX_NEW = "frs_play-new-";
    public static final String JUMP_ALA_LIVE_ROOM_DATA = "jump_ala_live_room_data";
    public static final String JUMP_ALA_LIVE_ROOM_DATA_CORE = "jump_ala_live_room_data_core";
    public static final String JUMP_ALA_LIVE_ROOM_DATA_FROM = "jump_ala_live_room_data_from";
    public static final String JUMP_ALA_LIVE_ROOM_DATA_HOST = "jump_ala_live_room_data_host";
    public static final String LIVE_COMMON_BROADCAST_QUEUE = "live_common_broadcast_queue";
    public static final String LIVE_ENTRY_LIVE_URL = "live_entry_live_url";
    public static final String LIVE_ENTRY_NAME = "live_entry_name";
    public static final String LIVE_FORBID_VERTICAL_CHANGE_LIVEROOM = "live_forbid_vertical_change_liveroom";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_FROM_FORUM_ID = "live_from_forum_id";
    public static final String LIVE_FROM_TYPE = "live_from_type";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_IS_HOST = "live_is_host";
    public static final String SDK_LIVE_COVER_KEY = "cover";
    public static final String SDK_LIVE_ENTER_LIVE_ID_KEY = "enterLiveId";
    public static final String SDK_LIVE_ENTER_ROOM_ID_KEY = "enterRoomId";
    public static final String SDK_LIVE_FROM_KEY = "from";
    public static final String SDK_LIVE_URL_KEY = "live_url";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static boolean isAlreadyEnterLiveRoom;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1536598772, "Lcom/baidu/tbadk/core/atomData/AlaLiveRoomActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1536598772, "Lcom/baidu/tbadk/core/atomData/AlaLiveRoomActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, String str, String str2, boolean z, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaLiveInfoCoreData, str, str2, Boolean.valueOf(z), str3};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra("live_forum_name", str3);
        isAlreadyEnterLiveRoom = true;
    }

    public AlaLiveRoomActivityConfig setCommonBroadcastQueue(ArrayList<Parcelable> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            getIntent().putParcelableArrayListExtra(LIVE_COMMON_BROADCAST_QUEUE, arrayList);
            return this;
        }
        return (AlaLiveRoomActivityConfig) invokeL.objValue;
    }

    public AlaLiveRoomActivityConfig setIsForbidVerticalChangeLiveRoom(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            getIntent().putExtra(LIVE_FORBID_VERTICAL_CHANGE_LIVEROOM, z);
            return this;
        }
        return (AlaLiveRoomActivityConfig) invokeZ.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, AlaLiveInfoListCoreData alaLiveInfoListCoreData, String str, String str2, boolean z, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaLiveInfoCoreData, alaLiveInfoListCoreData, str, str2, Boolean.valueOf(z), str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_ENTRY_NAME, str3);
        getIntent().putExtra(LIVE_FROM_FORUM_ID, str4);
        isAlreadyEnterLiveRoom = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, AlaLiveInfoListCoreData alaLiveInfoListCoreData, String str, String str2, boolean z, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaLiveInfoCoreData, alaLiveInfoListCoreData, str, str2, Boolean.valueOf(z), str3, str4, str5};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra(LIVE_IS_HOST, z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_ENTRY_NAME, str3);
        getIntent().putExtra(LIVE_FROM_FORUM_ID, str4);
        getIntent().putExtra("live_forum_name", str5);
        isAlreadyEnterLiveRoom = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveRoomActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
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
        getIntent().putExtra(LIVE_ENTRY_LIVE_URL, str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(LIVE_FROM_TYPE, str3);
        isAlreadyEnterLiveRoom = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaLiveRoomActivityConfig(Context context, AlaLiveInfoCoreData alaLiveInfoCoreData, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, alaLiveInfoCoreData, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra(LIVE_FROM_TYPE, str);
        getIntent().putExtra(LIVE_FROM_FORUM_ID, str2);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        isAlreadyEnterLiveRoom = true;
    }
}

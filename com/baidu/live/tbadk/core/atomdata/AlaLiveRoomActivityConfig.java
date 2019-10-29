package com.baidu.live.tbadk.core.atomdata;

import android.content.Context;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class AlaLiveRoomActivityConfig extends IntentConfig {
    public static final String EXTRA_LIVE_ID = "live_id";
    public static final String EXTRA_ROOM_ID = "room_id";
    public static final String FREM_TYPE_LIVE_FRS_STAGE_LIVE = "frs_live_stage_live";
    public static final String FROM_TYPE_ALTER_PLAY = "alter_play";
    public static final String FROM_TYPE_BROADCAST_GIFT_TOAST = "broadcast_gift_toast";
    public static final String FROM_TYPE_END_LIVE_RECOMMEND = "end_live_recommend";
    public static final String FROM_TYPE_END_VIEW = "end_view";
    public static final String FROM_TYPE_FRS_AUTO_PLAY = "frs_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_AUTO_PLAY = "frs_live_auto_play";
    public static final String FROM_TYPE_FRS_LIVE_PLAY = "frs_live_play";
    public static final String FROM_TYPE_FRS_PLAY = "frs_play";
    public static final String FROM_TYPE_FRS_SHARE_LIVE = "frs_share_live";
    public static final String FROM_TYPE_HOME_CONCERN_TAB = "home_concern_tab";
    public static final String FROM_TYPE_HOME_LIVE_AUTO_PLAY = "home_live_auto_play";
    public static final String FROM_TYPE_HOME_LIVE_PLAY = "home_live_play";
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
    public static final String FROM_TYPE_LIVE_SDK = "live_sdk";
    public static final String FROM_TYPE_LIVE_SQUARE_ATTENTION_LIVE = "ala_square_attention_live";
    public static final String FROM_TYPE_OUTSIDE = "safari_play";
    public static final String FROM_TYPE_PB_AUTO_PLAY = "pb_auto_play";
    public static final String FROM_TYPE_PB_PLAY = "pb_play";
    public static final String FROM_TYPE_PERSON_ATTENTION = "person_attention";
    public static final String FROM_TYPE_PERSON_AUTO_PLAY = "person_auto_play";
    public static final String FROM_TYPE_PERSON_PLAY = "person_play";
    public static final String FROM_TYPE_SCAN_HISTORY = "scan_history";
    public static final String FROM_TYPE_SEARCH = "search";
    public static final String FROM_TYPE_SHARE_PLAY = "share_play";
    public static final String FROM_TYPE_SPECIAL_CONCERN_TAB = "frs_live_tab_concern_tab";
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
    public static final String FROM_TYPE_VIDEO_PLAY = "video_play";
    public static final String LIVE_BROADCAST_GIFT_TOAST_QUEUE = "live_broadcast_gift_toast_queue";
    public static final String LIVE_ENTRY_LIVE_URL = "live_entry_live_url";
    public static final String LIVE_ENTRY_NAME = "live_entry_name";
    public static final String LIVE_FORBID_VERTICAL_CHANGE_LIVEROOM = "live_forbid_vertical_change_liveroom";
    public static final String LIVE_FORUM_NAME = "live_forum_name";
    public static final String LIVE_FROM_FORUM_ID = "live_from_forum_id";
    public static final String LIVE_FROM_TYPE = "live_from_type";
    public static final String LIVE_INFO = "live_info_core";
    public static final String LIVE_IS_HOST = "live_is_host";
    public static final String LIVE_SHOW_GITE_PANEL = "open_giftlist";
    public static final String SDK_EXTRA_COVER_URL = "cover";
    public static final String SDK_EXTRA_ENTER_FROM_TYPE = "live_enter_type";
    public static final String SDK_EXTRA_EXTRA = "extra";
    public static final String SDK_EXTRA_FROM = "from";
    public static final String SDK_EXTRA_LIVE_ENTER_LIVEID = "enterLiveId";
    public static final String SDK_EXTRA_LIVE_ENTER_ROOMID = "enterRoomId";
    public static final String SDK_EXTRA_LIVE_URL = "live_url";
    public static final String SDK_EXTRA_PARAMS = "params";
    public static final String SDK_EXTRA_RECOMMEND_TYPE = "recommend_type";
    public static final String SDK_EXTRA_SOURCE = "source";
    public static final String SDK_EXTRA_TAB = "tab";
    public static final String SDK_EXTRA_TAG = "tag";
    public static final String STOP_IM_WHEN_CLOSE = "stop_im_when_close";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";

    public AlaLiveRoomActivityConfig(Context context) {
        super(context);
    }

    public void addExtraByScheme(AlaLiveInfoCoreData alaLiveInfoCoreData, String str, String str2, boolean z, String str3) {
        getIntent().putExtra("user_id", str2);
        getIntent().putExtra("live_is_host", z);
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra("live_from_type", str);
        getIntent().putExtra("live_forum_name", str3);
    }

    public void addExtraByUrl(String str, String str2, String str3) {
        getIntent().putExtra("live_entry_live_url", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("live_from_type", str3);
    }

    public AlaLiveRoomActivityConfig setNeedStopImWhenClose(boolean z) {
        getIntent().putExtra("stop_im_when_close", z);
        return this;
    }

    public void addExtraByRoomId(String str, String str2) {
        getIntent().putExtra("room_id", str);
        getIntent().putExtra("live_from_type", FROM_TYPE_LIVE_SDK);
        getIntent().putExtra("params", str2);
    }

    public void addExtraByLiveId(long j, String str) {
        getIntent().putExtra("live_id", j);
        getIntent().putExtra("live_from_type", FROM_TYPE_LIVE_SDK);
        getIntent().putExtra("params", str);
    }

    public void addExtraByParams(String str) {
        getIntent().putExtra("params", str);
    }

    public void addExtraByLiveId(long j, String str, String str2) {
        getIntent().putExtra("live_id", j);
        getIntent().putExtra("room_id", str);
        getIntent().putExtra("live_from_type", str2);
    }

    public void addExtraByLiveCoreData(AlaLiveInfoCoreData alaLiveInfoCoreData, long j, String str, String str2) {
        getIntent().putExtra("live_info_core", alaLiveInfoCoreData);
        getIntent().putExtra("live_id", j);
        getIntent().putExtra("room_id", str);
        getIntent().putExtra("live_from_type", str2);
    }

    public AlaLiveRoomActivityConfig(Context context, long j, String str, ArrayList<AlaBroadcastGiftToastData> arrayList) {
        super(context);
        getIntent().putExtra("live_id", j);
        getIntent().putExtra("room_id", str);
        getIntent().putExtra("live_from_type", FROM_TYPE_LIVE_SDK);
        getIntent().putExtra(LIVE_BROADCAST_GIFT_TOAST_QUEUE, getBroadcastGiftStr(arrayList));
    }

    private String getBroadcastGiftStr(ArrayList<AlaBroadcastGiftToastData> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<AlaBroadcastGiftToastData> it = arrayList.iterator();
            while (it.hasNext()) {
                AlaBroadcastGiftToastData next = it.next();
                if (next != null && next.toJsonObject() != null) {
                    jSONArray.put(next.toJsonObject());
                }
            }
        }
        return jSONArray.toString();
    }
}

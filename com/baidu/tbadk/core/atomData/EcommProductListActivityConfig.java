package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommProductListActivityConfig extends IntentConfig {
    public static final String ADDITION_DATA = "addition_data";
    public static final String BAOBAO_IMAGES = "baobao_images";
    public static final String CATEGORY_ID = "category_id";
    public static final String DEAL_INFO = "deal_info";
    public static final String DISABLE_AUDIO_MESSAGE = "disable_audio_message";
    public static final String ECOMM_ADDRESS = "ecomm_address";
    public static final String ENABLE_AUDIO = "enable_audio";
    public static final String FEED_BACK = "feed_back";
    public static final String FILE_NAME = "file_name";
    public static final String FLOOR_ID = "floor_id";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM_ADD_PHOTO_LIVE_IN_MISSON = "from_add_photo_live_in_misson";
    public static final String IS_AD = "is_ad";
    public static final String IS_ADDITION = "is_addition";
    public static final String IS_LIVE_POST = "is_live_post";
    public static final String LIVE_DATE = "live_date";
    public static final String LIVE_GROUP_HEAD = "live_group_head";
    public static final String LIVE_GROUP_ID = "live_group_id";
    public static final String LIVE_GROUP_INTRO = "live_group_intro";
    public static final String LIVE_GROUP_MEMBER_COUNT = "live_group_member_count";
    public static final String LIVE_GROUP_NAME = "live_group_name";
    public static final String LIVE_GROUP_PUBLISH_HEAD = "live_group_author_head";
    public static final String LIVE_GROUP_PUBLISH_NAME = "live_group_author";
    public static final String LIVE_GROUP_ZAN_COUNT = "live_group_zan_count";
    public static final String LIVE_TIME_IS_MODIFY = "live_time_is_modify";
    public static final String MEMBER_TYPE = "mem_type";
    public static final String PHOTO_LIVE_COVER_IMAGE = "photolivecoverimage";
    public static final String PHOTO_NAME = "photo_name";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String REFRESH_PIC = "refresh_pic";
    public static final String REPLY_SUB_PB = "reply_sub_pb";
    public static final String SUB_USER_NAME = "sub_user_name";
    public static final String THREAD_ID = "thread_id";
    public static final String TYPE = "type";
    public static final String VCODE_FEED_BACK = "vcode_feed_back";
    public static final String WRITE_IMAGES = "write_images";

    public void addEcommAddress(String str) {
        getIntent().putExtra(ECOMM_ADDRESS, str);
    }

    public void setCategroyId(int i) {
        getIntent().putExtra("category_id", i);
    }

    public EcommProductListActivityConfig(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData, int i4, String str7) {
        super(activity);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        getIntent().putExtra("type", i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("reply_sub_pb", z2);
        getIntent().putExtra("is_ad", z3);
        getIntent().putExtra("mem_type", i4);
        if (antiData != null) {
            getIntent().putExtra("enable_audio", antiData.isIfvoice());
            getIntent().putExtra("disable_audio_message", antiData.getVoice_message());
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().putExtra("refresh_pic", z4);
        if (z) {
            getIntent().putExtra("feed_back", true);
        }
        if (str3 != null) {
            getIntent().putExtra("thread_id", str3);
        }
        if (str4 != null) {
            getIntent().putExtra("floor_id", str4);
        }
        if (i2 > 0) {
            getIntent().putExtra("floor_num", i2);
        }
        if (str5 != null) {
            getIntent().putExtra("sub_user_name", str5);
        }
        if (additionData != null) {
            getIntent().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
        getIntent().putExtra("from", str7);
    }
}

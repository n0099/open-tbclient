package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class WriteActivityConfig extends IntentConfig {
    public static final String ADDITION_DATA = "addition_data";
    public static final String BAOBAO_IMAGES = "baobao_images";
    public static final String DISABLE_AUDIO_MESSAGE = "disable_audio_message";
    public static final String ENABLE_AUDIO = "enable_audio";
    public static final String FEED_BACK = "feed_back";
    public static final String FILE_NAME = "file_name";
    public static final String FLOOR_ID = "floor_id";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
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
    public static final String WRITE_IMAGES = "write_images";

    public WriteActivityConfig(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData, int i4) {
        super(activity);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        if (antiData != null && antiData.getIfpost() == 0 && !StringUtils.isNull(antiData.getForbid_info())) {
            k.showToast(activity, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(REPLY_SUB_PB, z2);
        getIntent().putExtra("is_ad", z3);
        getIntent().putExtra(MEMBER_TYPE, i4);
        if (antiData != null) {
            getIntent().putExtra(ENABLE_AUDIO, antiData.isIfvoice());
            getIntent().putExtra(DISABLE_AUDIO_MESSAGE, antiData.getVoice_message());
        }
        if (str6 != null) {
            getIntent().putExtra("file_name", str6);
        }
        getIntent().putExtra(REFRESH_PIC, z4);
        if (z) {
            getIntent().putExtra(FEED_BACK, true);
        }
        if (str3 != null) {
            getIntent().putExtra("thread_id", str3);
        }
        if (str4 != null) {
            getIntent().putExtra(FLOOR_ID, str4);
        }
        if (i2 > 0) {
            getIntent().putExtra("floor_num", i2);
        }
        if (str5 != null) {
            getIntent().putExtra(SUB_USER_NAME, str5);
        }
        if (additionData != null) {
            getIntent().putExtra(ADDITION_DATA, additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
    }

    public void toLivePost(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5) {
        getIntent().putExtra(IS_LIVE_POST, true);
        getIntent().putExtra(LIVE_GROUP_ID, i);
        if (str != null) {
            getIntent().putExtra(LIVE_GROUP_HEAD, str);
        }
        if (str2 != null) {
            getIntent().putExtra(LIVE_GROUP_NAME, str2);
        }
        if (str4 != null) {
            getIntent().putExtra(LIVE_GROUP_PUBLISH_HEAD, str4);
        }
        getIntent().putExtra(LIVE_GROUP_MEMBER_COUNT, i2);
        getIntent().putExtra(LIVE_GROUP_ZAN_COUNT, i3);
        if (str3 != null) {
            getIntent().putExtra(LIVE_GROUP_PUBLISH_NAME, str3);
        }
        if (str5 != null) {
            getIntent().putExtra(LIVE_GROUP_INTRO, str5);
        }
    }
}

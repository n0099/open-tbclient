package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes.dex */
public class WriteActivityConfig extends IntentConfig {
    public static final String ADDITION_DATA = "addition_data";
    public static final String CATEGORY_ID = "category_id";
    public static final String CONTENT = "write_content";
    public static final String DISABLE_AUDIO_MESSAGE = "disable_audio_message";
    public static final String ENABLE_AUDIO = "enable_audio";
    public static final String FEED_BACK = "feed_back";
    public static final String FILE_NAME = "file_name";
    public static final String FLOOR_ID = "floor_id";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM_ADD_PHOTO_LIVE_IN_MISSON = "from_add_photo_live_in_misson";
    public static final String FROM_FORUM_SHARE = "from_forum_share";
    public static final String HOT_TOPIC = "hot_topic";
    public static final String HOT_TOPIC_ID = "hot_topic_id";
    public static final String HOT_TOPIC_POST_FORUM = "hot_topic_forum_list";
    public static final String IS_AD = "is_ad";
    public static final String IS_ADDITION = "is_addition";
    public static final String IS_LIVE_POST = "is_live_post";
    public static final String IS_SAVE_DRAFTE = "need_save_draft";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_FORUM_AVATAR = "forum_avatar";
    public static final String KEY_PROFESSION_ZONE = "profession_zone";
    public static final String KEY_SHOW_HOMEPAGE_TEST_BTN = "key_show_homepage_test_btn";
    public static final String KEY_TOPIC_ID = "topic_id";
    public static final String KEY_WRITE_IMAGES_INFO_STRING = "KEY_WRITE_IMAGES_INFO_STRING";
    public static final String KEY_WRITE_LEVEL = "key_write_level";
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
    public static final String MORE_FORUM_IMG = "more_forum_img";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String PHOTO_LIVE_COVER_IMAGE = "photolivecoverimage";
    public static final String PHOTO_NAME = "photo_name";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String PRIVATE_THREAD = "private_thread";
    public static final int PROFESSION_ZONE_TYPE_DEFAULT = -1;
    public static final String REFRESH_PIC = "refresh_pic";
    public static final String REPLY_SUB_PB = "reply_sub_pb";
    public static final String SUB_USER_NAME = "sub_user_name";
    public static final String THREAD_ID = "thread_id";
    public static final String TITLE = "write_title";
    public static final String TYPE = "type";
    public static final String VCODE_FEED_BACK = "vcode_feed_back";
    public static final String WRITE_IMAGES = "write_images";

    public WriteActivityConfig(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData, int i4) {
        this(activity, i, str, str2, str3, str4, i2, antiData, i3, z, z2, str5, z3, z4, str6, additionData, postPrefixData, i4, "");
    }

    public WriteActivityConfig(Activity activity, int i, String str, String str2, String str3, String str4, int i2, AntiData antiData, int i3, boolean z, boolean z2, String str5, boolean z3, boolean z4, String str6, AdditionData additionData, PostPrefixData postPrefixData, int i4, String str7) {
        super(activity);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
        if (antiData != null && antiData.getIfpost() == 0 && !StringUtils.isNull(antiData.getForbid_info())) {
            l.showToast(activity, antiData.getForbid_info());
            return;
        }
        getIntent().putExtra("type", i);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(REPLY_SUB_PB, z2);
        getIntent().putExtra("is_ad", z3);
        getIntent().putExtra(MEMBER_TYPE, i4);
        if (antiData == null) {
            getIntent().putExtra(ENABLE_AUDIO, true);
            getIntent().putExtra(DISABLE_AUDIO_MESSAGE, "");
        } else {
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
            getIntent().putExtra("addition_data", additionData);
        }
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
        getIntent().putExtra("from", str7);
    }

    public void setForumDir(String str, String str2) {
        Intent intent = getIntent();
        intent.putExtra("forum_first_dir", str);
        intent.putExtra("forum_second_dir", str2);
    }

    public void addHotTopicInfo(PostTopicData postTopicData) {
        getIntent().putExtra("hot_topic", postTopicData);
    }

    public void setCategroyId(int i) {
        getIntent().putExtra("category_id", i);
    }

    public void setTitle(String str, boolean z) {
        getIntent().putExtra("write_title", str);
        getIntent().putExtra("need_save_draft", z);
    }

    public void setIsVcodeFeedBack() {
        if (getIntent() != null) {
            getIntent().putExtra(VCODE_FEED_BACK, true);
        }
    }

    public void setCallFrom(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("KEY_CALL_FROM", str);
        }
    }

    public void setForumLevel(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("key_write_level", i);
        }
    }

    public void setForumAvatar(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("forum_avatar", str);
        }
    }

    public void setPrivateThread(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("private_thread", i);
        }
    }

    public void setAlbumThread(int i) {
        if (getIntent() != null) {
            getIntent().putExtra("album_thread", i);
        }
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        if (getIntent() != null && writeImagesInfo != null) {
            getIntent().putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
        }
    }

    public void setMoreForumImg(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_img", str);
        }
    }

    public void setMoreForumTitle(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_title", str);
        }
    }

    public void setMoreForumUrl(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_url", str);
        }
    }

    public void setProfessionZone(int i) {
        getIntent().putExtra(KEY_PROFESSION_ZONE, i);
    }

    public void setTopicId(String str) {
        getIntent().putExtra(HOT_TOPIC_ID, str);
    }

    public void setContent(String str) {
        getIntent().putExtra("write_content", str);
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        getIntent().putExtra("tab_list", frsTabInfoData);
    }

    public void setShowHomepageTestBtn(boolean z) {
        getIntent().putExtra(KEY_SHOW_HOMEPAGE_TEST_BTN, z);
    }
}

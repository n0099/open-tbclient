package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import d.b.c.e.p.l;
import d.b.j0.d3.q0.a;
import d.b.j0.d3.q0.b;
import d.b.j0.d3.q0.c;
/* loaded from: classes3.dex */
public class WriteActivityConfig extends IntentConfig {
    public static final String ADDITION_DATA = "addition_data";
    public static final String CAN_GOODS = "can_goods";
    public static final String CATEGORY_ID = "category_id";
    public static final String CONTENT = "write_content";
    public static final String DISABLE_AUDIO_MESSAGE = "disable_audio_message";
    public static final String ENABLE_AUDIO = "enable_audio";
    public static final String FEED_BACK = "feed_back";
    public static final String FLOOR_ID = "floor_id";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM_ADD_PHOTO_LIVE_IN_MISSON = "from_add_photo_live_in_misson";
    public static final String FROM_FORUM_SHARE = "from_forum_share";
    public static final String GOODS_LIST = "goods_list";
    public static final String HOT_TOPIC = "hot_topic";
    public static final String HOT_TOPIC_ID = "hot_topic_id";
    public static final String HOT_TOPIC_POST_FORUM = "hot_topic_forum_list";
    public static final String IS_FROM_ERROR_DIALOG = "is_from_error_dialog";
    public static final String IS_SAVE_DRAFTE = "need_save_draft";
    public static final String ITEM_INFO = "item_info";
    public static final String ITEM_IS_SCHOOL = "item_is_school";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_PROFESSION_ZONE = "profession_zone";
    public static final String KEY_SHOW_HOMEPAGE_TEST_BTN = "key_show_homepage_test_btn";
    public static final String KEY_STATISTIS_FROM = "key_statistic_from";
    public static final String KEY_WRITE_IMAGES_INFO_STRING = "KEY_WRITE_IMAGES_INFO_STRING";
    public static final String KEY_WRITE_LEVEL = "key_write_level";
    public static final String MORE_FORUM_IMG = "more_forum_img";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String PHOTO_NAME = "photo_name";
    public static final String POST_WRITE_CALLBACK_DATA = "post_write_callback_data";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String PRIVATE_THREAD = "private_thread";
    public static final int PROFESSION_ZONE_TYPE_DEFAULT = -1;
    public static final String REPLY_SUB_PB = "reply_sub_pb";
    public static final String STAR_COUNT = "star_count";
    public static final String SUB_USER_NAME = "sub_user_name";
    public static final String THREAD_ID = "thread_id";
    public static final String TITLE = "write_title";
    public static final String TYPE = "type";
    public static final String VCODE_FEED_BACK = "vcode_feed_back";
    public static final String VIDEO_INFO = "video_info";
    public static final String VIDEO_TITLE = "video_title";

    public WriteActivityConfig(Context context) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(13003);
    }

    public static boolean isAsyncWriting() {
        return isAsyncWriting(true);
    }

    public static WriteActivityConfig newInstance(@NonNull Context context) {
        return new WriteActivityConfig(context);
    }

    public void send() {
        c.f55453g = new Intent(getIntent());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
    }

    public WriteActivityConfig setAdditionData(AdditionData additionData) {
        if (additionData != null) {
            getIntent().putExtra("addition_data", additionData);
        }
        return this;
    }

    public WriteActivityConfig setAlbumThread(int i) {
        getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, i);
        return this;
    }

    public WriteActivityConfig setAntiData(AntiData antiData) {
        if (antiData != null) {
            getIntent().putExtra(ENABLE_AUDIO, antiData.isIfvoice());
            getIntent().putExtra(DISABLE_AUDIO_MESSAGE, antiData.getVoice_message());
            getIntent().putExtra(CAN_GOODS, antiData.getCanGoods());
        }
        return this;
    }

    public WriteActivityConfig setCallFrom(String str) {
        getIntent().putExtra("KEY_CALL_FROM", str);
        return this;
    }

    public WriteActivityConfig setCanGoods(boolean z) {
        getIntent().putExtra(CAN_GOODS, z);
        return this;
    }

    public WriteActivityConfig setCategoryId(int i) {
        getIntent().putExtra("category_id", i);
        return this;
    }

    public WriteActivityConfig setContent(String str) {
        getIntent().putExtra("write_content", str);
        return this;
    }

    public WriteActivityConfig setFeedBack(boolean z) {
        getIntent().putExtra(FEED_BACK, z);
        return this;
    }

    public WriteActivityConfig setFloorId(String str) {
        getIntent().putExtra(FLOOR_ID, str);
        return this;
    }

    public WriteActivityConfig setFloorNum(int i) {
        getIntent().putExtra("floor_num", i);
        return this;
    }

    public WriteActivityConfig setForumData(ForumData forumData) {
        if (forumData != null) {
            setForumId(forumData.getId() != null ? forumData.getId() : "0");
            setForumName(forumData.getName());
            setPrefixData(forumData.getPrefixData());
            setPrivateThread(forumData.getIsPrivateForum());
            setForumDir(forumData.getFirst_class(), forumData.getSecond_class());
        } else {
            setForumId("0");
            setForumDir("", "");
        }
        return this;
    }

    public WriteActivityConfig setForumDir(@Nullable String str, @Nullable String str2) {
        Intent intent = getIntent();
        if (str == null) {
            str = "";
        }
        intent.putExtra(IntentConfig.FORUM_FIRST_DIR, str);
        Intent intent2 = getIntent();
        if (str2 == null) {
            str2 = "";
        }
        intent2.putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
        return this;
    }

    public WriteActivityConfig setForumId(String str) {
        Intent intent = getIntent();
        if (str == null) {
            str = "0";
        }
        intent.putExtra("forum_id", str);
        return this;
    }

    public WriteActivityConfig setForumName(String str) {
        getIntent().putExtra("forum_name", str);
        return this;
    }

    public WriteActivityConfig setForumWriteData(ForumWriteData forumWriteData) {
        if (forumWriteData != null) {
            String str = forumWriteData.forumId;
            setForumId(str != null ? str : "0");
            setForumName(forumWriteData.forumName);
            setAntiData(forumWriteData.antiData);
            setPrefixData(forumWriteData.prefixData);
            setPrivateThread(forumWriteData.privateThread);
            setForumDir(forumWriteData.firstDir, forumWriteData.secondDir);
            setProfessionZone(forumWriteData.defaultZone);
            setFrsTabInfo(forumWriteData.frsTabInfo);
            setFrom(forumWriteData.mFrom);
            setCallFrom(forumWriteData.writeCallFrom);
            setStatisticFrom(forumWriteData.statisticFrom);
        } else {
            setForumId("0");
            setProfessionZone(-1);
            setForumDir("", "");
        }
        return this;
    }

    public WriteActivityConfig setFrom(String str) {
        getIntent().putExtra("from", str);
        return this;
    }

    public WriteActivityConfig setFromErrorDialog(boolean z) {
        getIntent().putExtra(IS_FROM_ERROR_DIALOG, z);
        return this;
    }

    public WriteActivityConfig setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        getIntent().putExtra("tab_list", frsTabInfoData);
        return this;
    }

    public WriteActivityConfig setGoodsList(String str) {
        if (!StringUtils.isNull(str)) {
            getIntent().putExtra(GOODS_LIST, str);
        }
        return this;
    }

    public WriteActivityConfig setHotTopicInfo(PostTopicData postTopicData) {
        getIntent().putExtra("hot_topic", postTopicData);
        return this;
    }

    public WriteActivityConfig setIsEvaluate(boolean z) {
        getIntent().putExtra(IntentConfig.IS_EVALUATE, z);
        return this;
    }

    public WriteActivityConfig setIsItemDetail(boolean z) {
        getIntent().putExtra(IntentConfig.IS_ITEM_DETAIL, z);
        return this;
    }

    public WriteActivityConfig setIsReplySubPb(boolean z) {
        getIntent().putExtra(REPLY_SUB_PB, z);
        return this;
    }

    public WriteActivityConfig setIsSaveDraft(boolean z) {
        getIntent().putExtra("need_save_draft", z);
        return this;
    }

    public WriteActivityConfig setIsVcodeFeedBack() {
        getIntent().putExtra(VCODE_FEED_BACK, true);
        return this;
    }

    public WriteActivityConfig setItemIsSchool(boolean z) {
        getIntent().putExtra("item_is_school", z);
        return this;
    }

    public WriteActivityConfig setPrefixData(PostPrefixData postPrefixData) {
        if (postPrefixData != null) {
            getIntent().putExtra("prefix_data", postPrefixData);
        }
        return this;
    }

    public WriteActivityConfig setPrivateThread(int i) {
        getIntent().putExtra("private_thread", i);
        return this;
    }

    public WriteActivityConfig setProfessionZone(int i) {
        getIntent().putExtra(KEY_PROFESSION_ZONE, i);
        return this;
    }

    public WriteActivityConfig setScoreItemInfo(SerializableItemInfo serializableItemInfo) {
        getIntent().putExtra("item_info", serializableItemInfo);
        return this;
    }

    public WriteActivityConfig setShowHomepageTestBtn(boolean z) {
        getIntent().putExtra(KEY_SHOW_HOMEPAGE_TEST_BTN, z);
        return this;
    }

    public WriteActivityConfig setShowVoteData(WriteVoteData writeVoteData) {
        getIntent().putExtra(IntentConfig.WRITE_VOTE_DATA, writeVoteData);
        return this;
    }

    public WriteActivityConfig setStarCount(int i) {
        getIntent().putExtra(STAR_COUNT, i);
        return this;
    }

    public WriteActivityConfig setStatisticFrom(int i) {
        getIntent().putExtra(KEY_STATISTIS_FROM, i);
        return this;
    }

    public WriteActivityConfig setSubUserName(String str) {
        getIntent().putExtra(SUB_USER_NAME, str);
        return this;
    }

    public WriteActivityConfig setThreadId(String str) {
        getIntent().putExtra("thread_id", str);
        return this;
    }

    public WriteActivityConfig setTitle(String str) {
        getIntent().putExtra("write_title", str);
        return this;
    }

    public WriteActivityConfig setTopicId(String str) {
        getIntent().putExtra(HOT_TOPIC_ID, str);
        return this;
    }

    public WriteActivityConfig setType(int i) {
        getIntent().putExtra("type", i);
        return this;
    }

    public WriteActivityConfig setVideoInfo(VideoInfo videoInfo) {
        getIntent().putExtra(VIDEO_INFO, videoInfo);
        return this;
    }

    public WriteActivityConfig setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo != null) {
            getIntent().putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
        }
        return this;
    }

    public static boolean isAsyncWriting(boolean z) {
        Activity currentActivity;
        boolean l = a.f().l();
        b.a("发帖阻拦状态 = " + l);
        if (l && z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
            l.L(currentActivity, "正在发布，请稍后");
        }
        return l;
    }
}

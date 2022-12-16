package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.gu8;
import com.baidu.tieba.h79;
import com.baidu.tieba.hu8;
import com.baidu.tieba.iu8;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class WriteActivityConfig extends BaseWriteConfig<WriteActivityConfig> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CAN_GOODS = "can_goods";
    public static final String DISABLE_AUDIO_MESSAGE = "disable_audio_message";
    public static final String DYNAMIC_PARAMS = "dynamic_params";
    public static final String ENABLE_AUDIO = "enable_audio";
    public static final String FLOOR_ID = "floor_id";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FORUM_FIRST_CATEGORY = "forum_first_category";
    public static final String FORUM_TAG_INFO = "forum_tag_info";
    public static final String FROM_ADD_PHOTO_LIVE_IN_MISSON = "from_add_photo_live_in_misson";
    public static final String FROM_FORUM_SHARE = "from_forum_share";
    public static final String GOODS_LIST = "goods_list";
    public static final String H5_FROM_TOPIC_DETAIL = "topic_detail";
    public static final String HOT_TOPIC_ID = "hot_topic_id";
    public static final String IS_ARTICLE = "is_article";
    public static final String IS_FROM_ERROR_DIALOG = "is_from_error_dialog";
    public static final String IS_QUESTION_THREAD = "is_question_thread";
    public static final String ITEM_INFO = "item_info";
    public static final String KEY_GAME_ID = "key_game_id";
    public static final String KEY_GAME_NAME = "key_game_name";
    public static final String KEY_GAME_RANK_IMG_URL = "key_game_rank_img_url";
    public static final String KEY_IS_FROM_GAME_RANK = "key_is_from_game_rank";
    public static final String KEY_LOCAL_CHANNEL_TOPIC = "key_local_channel_topic";
    public static final String KEY_NOTIFICATION_H5 = "key_notification_h5";
    public static final String KEY_NOT_FAKE_POST = "key_not_fake_post";
    public static final String KEY_NOT_SHOW_VIDEO_WORK_LIST_PAGE = "key_not_show_video_work_list_page";
    public static final String KEY_POST_LOCAL_CHANNEL_DYNAMIC = "key_post_local_channel_dynamic";
    public static final String KEY_PROFESSION_ZONE = "profession_zone";
    public static final String KEY_REWARDS_TYPE = "key_rewards_type";
    public static final String KEY_STATISTIS_FROM = "key_statistic_from";
    public static final String KEY_XIUXIU_ORIGINAL_CONTENT = "key_xiuxiu_original_content";
    public static final String KEY_XIUXIU_ORIGINAL_FNAME = "key_xiuxiu_original_fname";
    public static final String MORE_FORUM_IMG = "more_forum_img";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String NEED_CLOSE_PRE_PAGE = "need_close_pre_page";
    public static final String PHOTO_NAME = "photo_name";
    public static final int PROFESSION_ZONE_TYPE_DEFAULT = -1;
    public static final String REPLY_SUB_PB = "reply_sub_pb";
    public static final String RICH_MODE_ENABLE = "rich_mode_enable";
    public static final String RICH_TEXT_MODE = "rich_text_mode";
    public static final String STAR_COUNT = "star_count";
    public static final String VIDEO_INFO = "video_info";
    public static final String VIDEO_TITLE = "video_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(13003);
    }

    public static boolean isAsyncWriting(boolean z) {
        InterceptResult invokeZ;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            boolean q = gu8.k().q();
            hu8.a("发帖阻拦状态 = " + q);
            if (q && z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                yi.Q(currentActivity, "正在发布，请稍后");
            }
            return q;
        }
        return invokeZ.booleanValue;
    }

    public static boolean isAsyncWriting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return isAsyncWriting(true);
        }
        return invokeV.booleanValue;
    }

    public void send() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            iu8.h = new Intent(getIntent());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
        }
    }

    public static WriteActivityConfig newInstance(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return new WriteActivityConfig(context);
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setAlbumThread(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setAntiData(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, antiData)) == null) {
            if (antiData != null) {
                setEnableAudio(antiData.isIfvoice());
                setAudioMsg(antiData.getVoice_message());
                setCanGoods(antiData.getCanGoods());
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setAudioMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            getIntent().putExtra(DISABLE_AUDIO_MESSAGE, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setCallFrom(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            getIntent().putExtra(BaseWriteConfig.KEY_CALL_FROM, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setCanGoods(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            getIntent().putExtra(CAN_GOODS, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            getIntent().putExtra(BaseWriteConfig.CONTENT, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setDynamicParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            getIntent().putExtra(DYNAMIC_PARAMS, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setEnableAudio(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            getIntent().putExtra(ENABLE_AUDIO, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setFloorNum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            getIntent().putExtra("floor_num", i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setForumCategory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            getIntent().putExtra(FORUM_FIRST_CATEGORY, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Intent intent = getIntent();
            if (str == null) {
                str = "0";
            }
            intent.putExtra("forum_id", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            getIntent().putExtra("forum_name", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumTagInfo(ForumTagInfo forumTagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, forumTagInfo)) == null) {
            getIntent().putExtra(FORUM_TAG_INFO, forumTagInfo);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setFrom(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            getIntent().putExtra("from", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setFromArticle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            getIntent().putExtra(IS_ARTICLE, str);
            if (h79.l.equals(str)) {
                setType(11);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setFromErrorDialog(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            getIntent().putExtra(IS_FROM_ERROR_DIALOG, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setFromGameRank(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            getIntent().putExtra(KEY_IS_FROM_GAME_RANK, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, frsTabInfoData)) == null) {
            getIntent().putExtra("tab_list", frsTabInfoData);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setGameId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            getIntent().putExtra(KEY_GAME_ID, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setGameName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            getIntent().putExtra(KEY_GAME_NAME, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setGameRankImgUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            getIntent().putExtra(KEY_GAME_RANK_IMG_URL, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setGoodsList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra(GOODS_LIST, str);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setIsEvaluate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            getIntent().putExtra(IntentConfig.IS_EVALUATE, z);
            setType(12);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsItemDetail(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            getIntent().putExtra(IntentConfig.IS_ITEM_DETAIL, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsPostLocalChannelDynamic(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            getIntent().putExtra(KEY_POST_LOCAL_CHANNEL_DYNAMIC, z);
            setType(13);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsQuestionThread(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            getIntent().putExtra(IS_QUESTION_THREAD, z);
            if (z) {
                setType(14);
            }
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsSaveDraft(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            getIntent().putExtra(BaseWriteConfig.IS_SAVE_DRAFTE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setLocalChannelTopic(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            getIntent().putExtra(KEY_LOCAL_CHANNEL_TOPIC, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setMoreForumImg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            getIntent().putExtra("more_forum_img", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setMoreForumTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            getIntent().putExtra("more_forum_title", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setMoreForumUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            getIntent().putExtra("more_forum_url", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setNeedClosePrePage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            getIntent().putExtra(NEED_CLOSE_PRE_PAGE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setNotFakePost(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            getIntent().putExtra(KEY_NOT_FAKE_POST, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setNotShowVideoWorkListPage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            getIntent().putExtra(KEY_NOT_SHOW_VIDEO_WORK_LIST_PAGE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setNotificationH5(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            getIntent().putExtra(KEY_NOTIFICATION_H5, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setPrefixData(PostPrefixData postPrefixData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, postPrefixData)) == null) {
            if (postPrefixData != null) {
                getIntent().putExtra(BaseWriteConfig.PREFIX_DATA, postPrefixData);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setPrivateThread(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            getIntent().putExtra(BaseWriteConfig.PRIVATE_THREAD, i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setProfessionZone(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
            getIntent().putExtra(KEY_PROFESSION_ZONE, i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setRewardsType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            getIntent().putExtra(KEY_REWARDS_TYPE, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setRichModeEnable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            getIntent().putExtra(RICH_MODE_ENABLE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setRichTextMode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            getIntent().putExtra(RICH_TEXT_MODE, z);
            if (z) {
                setType(11);
            }
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setScoreItemInfo(SerializableItemInfo serializableItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, serializableItemInfo)) == null) {
            getIntent().putExtra(ITEM_INFO, serializableItemInfo);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setShowVoteData(WriteVoteData writeVoteData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, writeVoteData)) == null) {
            getIntent().putExtra(IntentConfig.WRITE_VOTE_DATA, writeVoteData);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setStarCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            getIntent().putExtra(STAR_COUNT, i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setStatisticFrom(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            getIntent().putExtra(KEY_STATISTIS_FROM, i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setThreadId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            getIntent().putExtra("thread_id", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            getIntent().putExtra(BaseWriteConfig.TITLE, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setTopicId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            getIntent().putExtra(HOT_TOPIC_ID, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
            getIntent().putExtra("type", i);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setVideoInfo(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, videoInfo)) == null) {
            getIntent().putExtra(VIDEO_INFO, videoInfo);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, writeImagesInfo)) == null) {
            if (writeImagesInfo != null) {
                getIntent().putExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, writeImagesInfo.toJsonString());
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setXiuxiuOriginalContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            getIntent().putExtra(KEY_XIUXIU_ORIGINAL_CONTENT, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setXiuxiuOriginalFname(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            getIntent().putExtra(KEY_XIUXIU_ORIGINAL_FNAME, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumData(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, forumData)) == null) {
            String str = "0";
            if (forumData != null) {
                if (forumData.getId() != null) {
                    str = forumData.getId();
                }
                setForumId(str);
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
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumWriteData(ForumWriteData forumWriteData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, forumWriteData)) == null) {
            String str = "0";
            if (forumWriteData != null) {
                String str2 = forumWriteData.forumId;
                if (str2 != null) {
                    str = str2;
                }
                setForumId(str);
                setForumName(forumWriteData.forumName);
                setAntiData(forumWriteData.antiData);
                setPrefixData(forumWriteData.prefixData);
                setPrivateThread(forumWriteData.privateThread);
                setForumDir(forumWriteData.firstDir, forumWriteData.secondDir);
                setProfessionZone(forumWriteData.defaultZone);
                setFrsTabInfo(forumWriteData.frsTabInfo);
                setForumTagInfo(forumWriteData.forumTagInfo);
                setForumCategory(forumWriteData.firstCategory);
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
        return (WriteActivityConfig) invokeL.objValue;
    }
}

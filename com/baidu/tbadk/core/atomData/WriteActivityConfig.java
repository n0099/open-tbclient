package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.k3.r0.g;
import c.a.r0.k3.r0.h;
import c.a.r0.k3.r0.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class WriteActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String NEED_CLOSE_PRE_PAGE = "need_close_pre_page";
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(13003);
    }

    public static boolean isAsyncWriting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? isAsyncWriting(true) : invokeV.booleanValue;
    }

    public static WriteActivityConfig newInstance(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new WriteActivityConfig(context) : (WriteActivityConfig) invokeL.objValue;
    }

    public void send() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i.f21302g = new Intent(getIntent());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
        }
    }

    public WriteActivityConfig setAdditionData(AdditionData additionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, additionData)) == null) {
            if (additionData != null) {
                getIntent().putExtra("addition_data", additionData);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setAlbumThread(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setAntiData(AntiData antiData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, antiData)) == null) {
            if (antiData != null) {
                getIntent().putExtra(ENABLE_AUDIO, antiData.isIfvoice());
                getIntent().putExtra(DISABLE_AUDIO_MESSAGE, antiData.getVoice_message());
                getIntent().putExtra(CAN_GOODS, antiData.getCanGoods());
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setCallFrom(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            getIntent().putExtra("KEY_CALL_FROM", str);
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

    public WriteActivityConfig setCategoryId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            getIntent().putExtra("category_id", i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setContent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            getIntent().putExtra("write_content", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setFeedBack(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            getIntent().putExtra(FEED_BACK, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setFloorId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            getIntent().putExtra(FLOOR_ID, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setFloorNum(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            getIntent().putExtra("floor_num", i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setForumData(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, forumData)) == null) {
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
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumDir(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
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
        return (WriteActivityConfig) invokeLL.objValue;
    }

    public WriteActivityConfig setForumId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            getIntent().putExtra("forum_name", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setForumWriteData(ForumWriteData forumWriteData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, forumWriteData)) == null) {
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

    public WriteActivityConfig setFromErrorDialog(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            getIntent().putExtra(IS_FROM_ERROR_DIALOG, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, frsTabInfoData)) == null) {
            getIntent().putExtra("tab_list", frsTabInfoData);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setGoodsList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!StringUtils.isNull(str)) {
                getIntent().putExtra(GOODS_LIST, str);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setHotTopicInfo(PostTopicData postTopicData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, postTopicData)) == null) {
            getIntent().putExtra("hot_topic", postTopicData);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setIsEvaluate(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            getIntent().putExtra(IntentConfig.IS_EVALUATE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsItemDetail(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            getIntent().putExtra(IntentConfig.IS_ITEM_DETAIL, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsReplySubPb(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            getIntent().putExtra(REPLY_SUB_PB, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsSaveDraft(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            getIntent().putExtra("need_save_draft", z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setIsVcodeFeedBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            getIntent().putExtra(VCODE_FEED_BACK, true);
            return this;
        }
        return (WriteActivityConfig) invokeV.objValue;
    }

    public WriteActivityConfig setItemIsSchool(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            getIntent().putExtra("item_is_school", z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setNeedClosePrePage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            getIntent().putExtra(NEED_CLOSE_PRE_PAGE, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setPrefixData(PostPrefixData postPrefixData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, postPrefixData)) == null) {
            if (postPrefixData != null) {
                getIntent().putExtra("prefix_data", postPrefixData);
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setPrivateThread(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            getIntent().putExtra("private_thread", i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setProfessionZone(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            getIntent().putExtra(KEY_PROFESSION_ZONE, i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setScoreItemInfo(SerializableItemInfo serializableItemInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, serializableItemInfo)) == null) {
            getIntent().putExtra("item_info", serializableItemInfo);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setShowHomepageTestBtn(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            getIntent().putExtra(KEY_SHOW_HOMEPAGE_TEST_BTN, z);
            return this;
        }
        return (WriteActivityConfig) invokeZ.objValue;
    }

    public WriteActivityConfig setShowVoteData(WriteVoteData writeVoteData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, writeVoteData)) == null) {
            getIntent().putExtra(IntentConfig.WRITE_VOTE_DATA, writeVoteData);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setStarCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            getIntent().putExtra(STAR_COUNT, i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setStatisticFrom(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            getIntent().putExtra(KEY_STATISTIS_FROM, i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setSubUserName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            getIntent().putExtra(SUB_USER_NAME, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setThreadId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            getIntent().putExtra("thread_id", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            getIntent().putExtra("write_title", str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setTopicId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            getIntent().putExtra(HOT_TOPIC_ID, str);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            getIntent().putExtra("type", i2);
            return this;
        }
        return (WriteActivityConfig) invokeI.objValue;
    }

    public WriteActivityConfig setVideoInfo(VideoInfo videoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, videoInfo)) == null) {
            getIntent().putExtra(VIDEO_INFO, videoInfo);
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public WriteActivityConfig setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, writeImagesInfo)) == null) {
            if (writeImagesInfo != null) {
                getIntent().putExtra("KEY_WRITE_IMAGES_INFO_STRING", writeImagesInfo.toJsonString());
            }
            return this;
        }
        return (WriteActivityConfig) invokeL.objValue;
    }

    public static boolean isAsyncWriting(boolean z) {
        InterceptResult invokeZ;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            boolean p = g.j().p();
            h.a("发帖阻拦状态 = " + p);
            if (p && z && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                l.M(currentActivity, "正在发布，请稍后");
            }
            return p;
        }
        return invokeZ.booleanValue;
    }
}

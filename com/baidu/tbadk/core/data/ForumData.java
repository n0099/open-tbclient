package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.a55;
import com.baidu.tieba.e25;
import com.baidu.tieba.l25;
import com.baidu.tieba.n25;
import com.baidu.tieba.p45;
import com.baidu.tieba.q25;
import com.baidu.tieba.r25;
import com.baidu.tieba.s45;
import com.baidu.tieba.u15;
import com.baidu.tieba.wn;
import com.baidu.tieba.x25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DeletedReasonInfo;
import tbclient.FrsPage.AcrossForumIcon;
import tbclient.FrsPage.Badges;
import tbclient.FrsPage.Classify;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.Manager;
import tbclient.FrsPage.MemberShowIcon;
import tbclient.FrsPage.RankInfo;
import tbclient.FrsPage.RecommendForum;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
import tbclient.FrsPage.TagInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsPage.Yule;
import tbclient.SimpleForum;
import tbclient.SpritePBGuide;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class ForumData implements Serializable, PreLoadImageProvider, wn {
    public static /* synthetic */ Interceptable $ic = null;
    public static BdUniqueId FORUM_FLOOR_TYPE = null;
    public static final String FROM_PAGE_FRS = "frs";
    public static final long serialVersionUID = -5446966999595522426L;
    public transient /* synthetic */ FieldHolder $fh;
    public String accelerate_cotent;
    public int cur_score;
    public String fShareImage;
    public int favo_type;
    public String first_class;
    public String forumGameLabel;
    public q25 forumShowInfoData;
    public String forum_share_link;
    public ArrayList<x25> good_classify;
    public String id;
    public String image_url;
    public boolean isBlockBawuDelete;
    public boolean isBrandForum;
    public boolean isFrsMask;
    public int isShowAllTopThread;
    public boolean isShowBawuTask;
    public boolean isShowForumRule;
    public int is_like;
    public int is_private_forum;
    public boolean is_sign;
    public l25 l;
    public String level_name;
    public int levelup_score;
    public int locate;
    public AcrossForumIcon mAcrossForumIcon;
    public final ArrayList<u15> mBadgeData;
    public final BannerListData mBannerListData;
    public DeletedReasonInfo mDeletedReasonInfo;
    public String mFromPage;
    public final r25 mFrsBannerData;
    public int mIsLiveGameForum;
    public n25 mMemberShowIconData;
    public PostTopicData mPostTopicData;
    public final PostPrefixData mPrefixData;
    public ArrayList<RecommendForumData> mRecommendForumData;
    public SignData mSignData;
    public ThemeColorInfo mThemeColorInfo;
    public List<TipInfo> mTipInfos;
    public List<Manager> managers;
    public int member_num;
    public String name;
    public s45 news_info;
    public List<String> pendants;
    public int post_num;
    public String riskTipNotice;
    public String riskTipPop;
    public String riskTipPopTitle;
    public String second_class;
    public String slogan;
    public String special_forum_type;
    public SpritePBGuide spritePBGuide;
    public String tag_color;
    public String tag_name;
    public int thread_num;
    public String topIcon;
    public p45 top_code;
    public TopNoticeData top_notice_data;
    public String topic_special_icon;
    public String topic_special_icon_right;
    public int user_level;
    public String warning_msg;
    public a55 yuleData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-801540248, "Lcom/baidu/tbadk/core/data/ForumData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-801540248, "Lcom/baidu/tbadk/core/data/ForumData;");
                return;
            }
        }
        FORUM_FLOOR_TYPE = BdUniqueId.gen();
    }

    public String getAccelerateContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.accelerate_cotent;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<u15> getBadgeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBadgeData;
        }
        return (ArrayList) invokeV.objValue;
    }

    public BannerListData getBannerListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBannerListData;
        }
        return (BannerListData) invokeV.objValue;
    }

    public int getCurScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.cur_score;
        }
        return invokeV.intValue;
    }

    public DeletedReasonInfo getDeletedReasonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDeletedReasonInfo;
        }
        return (DeletedReasonInfo) invokeV.objValue;
    }

    public int getFavo_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.favo_type;
        }
        return invokeV.intValue;
    }

    public String getFirst_class() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.first_class;
        }
        return (String) invokeV.objValue;
    }

    public String getForumGameLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.forumGameLabel;
        }
        return (String) invokeV.objValue;
    }

    public q25 getForumShowInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.forumShowInfoData;
        }
        return (q25) invokeV.objValue;
    }

    public String getFromPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mFromPage;
        }
        return (String) invokeV.objValue;
    }

    public r25 getFrsBannerData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mFrsBannerData;
        }
        return (r25) invokeV.objValue;
    }

    public ArrayList<x25> getGood_classify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.good_classify;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public String getImage_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.image_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.image_url;
            preLoadImageInfo.procType = 10;
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getIsPrivateForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.is_private_forum;
        }
        return invokeV.intValue;
    }

    public boolean getIsShowBawuTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isShowBawuTask;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsShowRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.isShowForumRule;
        }
        return invokeV.booleanValue;
    }

    public String getLevelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.level_name;
        }
        return (String) invokeV.objValue;
    }

    public int getLevelupScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.levelup_score;
        }
        return invokeV.intValue;
    }

    public List<Manager> getManagers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.managers;
        }
        return (List) invokeV.objValue;
    }

    public int getMember_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.member_num;
        }
        return invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public s45 getNewsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.news_info;
        }
        return (s45) invokeV.objValue;
    }

    public List<String> getPendants() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.pendants;
        }
        return (List) invokeV.objValue;
    }

    public int getPost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.post_num;
        }
        return invokeV.intValue;
    }

    public PostPrefixData getPrefixData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mPrefixData;
        }
        return (PostPrefixData) invokeV.objValue;
    }

    public ArrayList<RecommendForumData> getRecommendForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mRecommendForumData;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getRiskTipNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.riskTipNotice;
        }
        return (String) invokeV.objValue;
    }

    public String getRiskTipPop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.riskTipPop;
        }
        return (String) invokeV.objValue;
    }

    public String getRiskTipPopTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.riskTipPopTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getSecond_class() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.second_class;
        }
        return (String) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mSignData;
        }
        return (SignData) invokeV.objValue;
    }

    public boolean getSigned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.is_sign || this.mSignData.is_signed == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.slogan;
        }
        return (String) invokeV.objValue;
    }

    public String getSpecialForumType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.special_forum_type;
        }
        return (String) invokeV.objValue;
    }

    public SpritePBGuide getSpritePBGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.spritePBGuide;
        }
        return (SpritePBGuide) invokeV.objValue;
    }

    public String getTag_color() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.tag_color;
        }
        return (String) invokeV.objValue;
    }

    public String getTag_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.tag_name;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getThemeColorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mThemeColorInfo;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public int getThread_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.thread_num;
        }
        return invokeV.intValue;
    }

    public List<TipInfo> getTipInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mTipInfos;
        }
        return (List) invokeV.objValue;
    }

    public p45 getTopCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.top_code;
        }
        return (p45) invokeV.objValue;
    }

    public String getTopIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.topIcon;
        }
        return (String) invokeV.objValue;
    }

    public TopNoticeData getTop_notice_data() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.top_notice_data;
        }
        return (TopNoticeData) invokeV.objValue;
    }

    public String getTopic_special_icon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.topic_special_icon;
        }
        return (String) invokeV.objValue;
    }

    public String getTopic_special_icon_right() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.topic_special_icon_right;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return FORUM_FLOOR_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public int getUser_level() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.user_level;
        }
        return invokeV.intValue;
    }

    public String getWarningMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.warning_msg;
        }
        return (String) invokeV.objValue;
    }

    public a55 getYuleData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.yuleData;
        }
        return (a55) invokeV.objValue;
    }

    public String getfShareImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.fShareImage;
        }
        return (String) invokeV.objValue;
    }

    public boolean isFrsMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.isFrsMask;
        }
        return invokeV.booleanValue;
    }

    public boolean isGameForumType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.mIsLiveGameForum == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int isLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.is_like;
        }
        return invokeV.intValue;
    }

    public ForumData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isBlockBawuDelete = false;
        this.id = null;
        this.name = null;
        this.first_class = null;
        this.second_class = null;
        this.thread_num = 0;
        this.post_num = 0;
        this.member_num = 0;
        this.is_like = 0;
        this.user_level = 0;
        this.mSignData = new SignData();
        this.managers = new ArrayList();
        this.good_classify = new ArrayList<>();
        this.tag_name = null;
        setTag_color(null);
        this.cur_score = 0;
        this.levelup_score = 0;
        this.top_notice_data = new TopNoticeData();
        this.mBadgeData = new ArrayList<>();
        this.mFrsBannerData = new r25();
        this.mBannerListData = new BannerListData();
        this.mRecommendForumData = new ArrayList<>();
        this.mPrefixData = new PostPrefixData();
        this.mPostTopicData = new PostTopicData();
        this.top_code = new p45();
        this.news_info = new s45();
        this.mMemberShowIconData = new n25();
        this.yuleData = new a55();
        this.mIsLiveGameForum = 0;
        this.warning_msg = null;
        this.special_forum_type = null;
        this.topic_special_icon = null;
        this.topic_special_icon_right = null;
        this.mThemeColorInfo = null;
        this.topIcon = null;
        this.is_private_forum = 0;
        this.isShowBawuTask = false;
        this.isShowForumRule = false;
        this.isFrsMask = false;
        this.fShareImage = null;
        this.mTipInfos = new ArrayList();
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setCurScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.cur_score = i;
        }
    }

    public void setFavo_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.favo_type = i;
        }
    }

    public void setFromPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.mFromPage = str;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.id = str;
        }
    }

    public void setImage_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.image_url = str;
        }
    }

    public void setLevelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.level_name = str;
        }
    }

    public void setLevelupScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.levelup_score = i;
        }
    }

    public void setLike(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.is_like = i;
        }
    }

    public void setMember_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.member_num = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.name = str;
        }
    }

    public void setPost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.post_num = i;
        }
    }

    public void setSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, signData) == null) {
            this.mSignData = signData;
        }
    }

    public void setSlogan(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.slogan = str;
        }
    }

    public void setTag_color(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.tag_color = str;
        }
    }

    public void setTag_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.tag_name = str;
        }
    }

    public void setThread_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            this.thread_num = i;
        }
    }

    public void setUser_level(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.user_level = i;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.slogan = jSONObject.optString("slogan");
            JSONObject optJSONObject = jSONObject.optJSONObject("top_notice");
            if (optJSONObject != null) {
                this.top_notice_data.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tag_info");
            if (optJSONObject2 != null) {
                this.tag_name = optJSONObject2.optString(PushConstants.SUB_TAGS_STATUS_NAME, null);
                this.tag_color = optJSONObject2.optString("color", null);
            }
            this.image_url = jSONObject.optString("avatar", null);
            boolean z3 = false;
            this.cur_score = jSONObject.optInt("cur_score", 0);
            this.levelup_score = jSONObject.optInt("levelup_score", 0);
            this.first_class = jSONObject.optString("first_class");
            this.second_class = jSONObject.optString("second_class");
            this.thread_num = jSONObject.optInt("thread_num", 0);
            this.post_num = jSONObject.optInt("post_num", 0);
            this.member_num = jSONObject.optInt("member_num", 0);
            this.is_like = jSONObject.optInt("is_like", 0);
            this.user_level = jSONObject.optInt("level_id", 0);
            this.level_name = jSONObject.optString("level_name", null);
            this.mIsLiveGameForum = jSONObject.optInt("is_live_game_forum", 0);
            this.warning_msg = jSONObject.optString("warning_msg", null);
            setFavo_type(jSONObject.optInt("favo_type", 0));
            JSONArray optJSONArray = jSONObject.optJSONArray("managers");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Manager.Builder builder = new Manager.Builder();
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    builder.id = Long.valueOf(jSONObject2.getLong("id"));
                    builder.name = jSONObject2.getString("name");
                    builder.show_name = jSONObject2.getString("show_name");
                    builder.portrait = jSONObject2.getString("portrait");
                    this.managers.add(builder.build(false));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    x25 x25Var = new x25();
                    x25Var.c(optJSONArray2.optJSONObject(i2));
                    this.good_classify.add(x25Var);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("sign_in_info");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject(SourceConstant.SOURCE_USER_INFO);
                if (optJSONObject4 != null) {
                    this.mSignData.is_signed = optJSONObject4.optInt("is_sign_in");
                    this.mSignData.user_sign_rank = optJSONObject4.optInt("user_sign_rank");
                    this.mSignData.count_sign_num = optJSONObject4.optInt("cont_sign_num");
                    this.mSignData.miss_sign_num = optJSONObject4.optInt("miss_sign_num", 0);
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("forum_info");
                if (optJSONObject5 != null) {
                    if (optJSONObject5.optInt("is_on") == 0) {
                        this.mSignData.forum_rank = -2;
                    } else {
                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("current_rank_info");
                        if (optJSONObject6 != null) {
                            this.mSignData.forum_rank = optJSONObject6.optInt("sign_rank");
                            this.mSignData.sign_count = optJSONObject6.optInt("sign_count");
                        }
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("badges");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    u15 u15Var = new u15();
                    u15Var.a(optJSONArray3.optJSONObject(i3));
                    this.mBadgeData.add(u15Var);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("recommend_forum");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    RecommendForumData recommendForumData = new RecommendForumData();
                    recommendForumData.parserJson(optJSONArray4.optJSONObject(i4));
                    this.mRecommendForumData.add(recommendForumData);
                }
            }
            try {
                this.mFrsBannerData.g(jSONObject.getJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            try {
                this.mBannerListData.parserJson(jSONObject.optJSONObject("banner_list"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.mPrefixData.parserJson(jSONObject.optJSONObject("post_prefix"));
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            try {
                this.mMemberShowIconData.a(jSONObject.optJSONObject("forumvip_show_icon"));
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
            try {
                this.yuleData.c(jSONObject.optJSONObject("yule"));
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
            try {
                this.top_code.i(jSONObject.optJSONObject("top_code"));
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            try {
                this.news_info.B1(jSONObject.optJSONObject("news_info"));
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            this.forumGameLabel = jSONObject.optString("forum_game_label");
            this.special_forum_type = jSONObject.optString(AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE);
            this.topic_special_icon = jSONObject.optString("topic_special_icon");
            this.topic_special_icon_right = jSONObject.optString("topic_special_icon_right");
            this.topIcon = jSONObject.optString("is_top_img");
            this.is_private_forum = jSONObject.optInt("is_private_forum");
            if (jSONObject.optInt("is_show_bawutask") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isShowBawuTask = z;
            if (jSONObject.optInt("is_show_forumrule") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.isShowForumRule = z2;
            this.fShareImage = jSONObject.optString("f_share_img");
            if (jSONObject.optInt("is_frs_mask") == 1) {
                z3 = true;
            }
            this.isFrsMask = z3;
        } catch (Exception e8) {
            BdLog.e(e8.getMessage());
        }
    }

    public void parserProtobuf(ForumInfo forumInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, forumInfo) != null) || forumInfo == null) {
            return;
        }
        try {
            this.id = forumInfo.id + "";
            this.name = forumInfo.name;
            this.slogan = forumInfo.slogan;
            if (!TextUtils.isEmpty(forumInfo.accelerate_cotent)) {
                this.accelerate_cotent = forumInfo.accelerate_cotent;
            }
            this.top_notice_data.parserProtobuf(forumInfo.top_notice);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                this.tag_name = tagInfo.tag_name;
                this.tag_color = tagInfo.color + "";
            }
            this.riskTipPop = forumInfo.risk_tip_pop;
            this.riskTipNotice = forumInfo.risk_tip_notice;
            this.riskTipPopTitle = forumInfo.risk_tip_pop_title;
            this.image_url = forumInfo.avatar;
            this.cur_score = forumInfo.cur_score.intValue();
            this.levelup_score = forumInfo.levelup_score.intValue();
            this.forum_share_link = forumInfo.forum_share_link;
            this.first_class = forumInfo.first_class;
            this.second_class = forumInfo.second_class;
            this.thread_num = forumInfo.thread_num.intValue();
            this.post_num = forumInfo.post_num.intValue();
            this.member_num = forumInfo.member_num.intValue();
            this.is_like = forumInfo.is_like.intValue();
            this.user_level = forumInfo.user_level.intValue();
            this.level_name = forumInfo.level_name;
            setFavo_type(forumInfo.favo_type.intValue());
            this.managers = forumInfo.managers;
            List<Classify> list = forumInfo.good_classify;
            boolean z5 = false;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    x25 x25Var = new x25();
                    x25Var.d(list.get(i));
                    this.good_classify.add(x25Var);
                }
            }
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                SignUser signUser = signInfo.user_info;
                if (signUser != null) {
                    this.mSignData.is_signed = signUser.is_sign_in.intValue();
                    this.mSignData.user_sign_rank = signUser.user_sign_rank.intValue();
                    this.mSignData.count_sign_num = signUser.cont_sign_num.intValue();
                    this.mSignData.miss_sign_num = signUser.miss_sign_num.intValue();
                }
                SignForum signForum = signInfo.forum_info;
                if (signForum != null) {
                    if (signForum.is_on.intValue() == 0) {
                        this.mSignData.forum_rank = -2;
                    } else {
                        RankInfo rankInfo = signForum.current_rank_info;
                        if (rankInfo != null) {
                            this.mSignData.forum_rank = rankInfo.sign_rank.intValue();
                            this.mSignData.sign_count = rankInfo.sign_count.intValue();
                        }
                    }
                }
                SignData signData = this.mSignData;
                if (signInfo.has_chatroom_sign.intValue() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                signData.showGuideToChatRoom = z4;
                if (signInfo.chatroom_sign_info != null) {
                    this.mSignData.chatRoomGuideData = e25.d.a(signInfo.chatroom_sign_info);
                }
            }
            List<Badges> list2 = forumInfo.badges;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    u15 u15Var = new u15();
                    u15Var.b(list2.get(i2));
                    this.mBadgeData.add(u15Var);
                }
            }
            List<RecommendForum> list3 = forumInfo.recommend_forum;
            if (list3 != null && list3.size() > 0) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    RecommendForumData recommendForumData = new RecommendForumData();
                    recommendForumData.parserProtobuf(list3.get(i3));
                    this.mRecommendForumData.add(recommendForumData);
                }
            }
            List<TipInfo> list4 = forumInfo.tip_list;
            if (!ListUtils.isEmpty(list4)) {
                this.mTipInfos.addAll(list4);
            }
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                this.mMemberShowIconData.b(memberShowIcon);
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                this.yuleData.d(yule);
            }
            this.mFrsBannerData.h(forumInfo.banner);
            this.mBannerListData.parserProtobuf(forumInfo.banner_list);
            this.mPrefixData.parserProtobuf(forumInfo.post_prefix);
            this.mPostTopicData.parserProtobuf(forumInfo.post_topic);
            this.top_code.j(forumInfo.top_code);
            this.news_info.C1(forumInfo.news_info);
            this.mAcrossForumIcon = forumInfo.across_forum_show;
            this.mIsLiveGameForum = forumInfo.is_live_game_forum.intValue();
            this.forumGameLabel = forumInfo.forum_game_label;
            this.warning_msg = forumInfo.warning_msg;
            this.special_forum_type = forumInfo.special_forum_type;
            this.topic_special_icon = forumInfo.topic_special_icon;
            this.topic_special_icon_right = forumInfo.topic_special_icon_right;
            if (forumInfo.is_brand_forum.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.isBrandForum = z;
            this.isShowAllTopThread = forumInfo.is_show_all_top_thread.intValue();
            this.mThemeColorInfo = forumInfo.theme_color;
            this.topIcon = forumInfo.is_top_img;
            this.is_private_forum = forumInfo.is_private_forum.intValue();
            if (forumInfo.is_show_bawutask.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.isShowBawuTask = z2;
            this.fShareImage = forumInfo.f_share_img;
            if (forumInfo.is_show_forumrule.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.isShowForumRule = z3;
            this.mDeletedReasonInfo = forumInfo.deleted_reason_info;
            if (forumInfo.is_frs_mask.intValue() == 1) {
                z5 = true;
            }
            this.isFrsMask = z5;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, simpleForum) != null) || simpleForum == null) {
            return;
        }
        try {
            this.id = String.valueOf(simpleForum.id);
            this.name = simpleForum.name;
            this.image_url = simpleForum.avatar;
            this.is_like = simpleForum.is_liked.intValue();
            boolean z4 = false;
            if (simpleForum.is_signed.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.is_sign = z;
            this.first_class = simpleForum.first_class;
            this.second_class = simpleForum.second_class;
            this.member_num = simpleForum.member_num.intValue();
            this.post_num = simpleForum.post_num.intValue();
            if (simpleForum.is_brand_forum.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.isBrandForum = z2;
            if (simpleForum.multi_forum_perm != null && simpleForum.multi_forum_perm.is_block_bawu_delete.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.isBlockBawuDelete = z3;
            this.mDeletedReasonInfo = simpleForum.deleted_reason_info;
            if (simpleForum.is_frs_mask.intValue() == 1) {
                z4 = true;
            }
            this.isFrsMask = z4;
            this.pendants = simpleForum.pendants;
            if (simpleForum.show_info != null) {
                q25 q25Var = new q25();
                this.forumShowInfoData = q25Var;
                q25Var.f(simpleForum.show_info);
            }
            this.spritePBGuide = simpleForum.sprite_pb_guide;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}

package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.nr4;
import com.baidu.tieba.pr4;
import com.baidu.tieba.pt4;
import com.baidu.tieba.rt4;
import com.baidu.tieba.sr4;
import com.baidu.tieba.xq4;
import com.baidu.tieba.xt4;
import com.baidu.tieba.yr4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class ForumData implements Serializable, PreLoadImageProvider, Cdo {
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
    public String forum_share_link;
    public ArrayList<yr4> good_classify;
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
    public nr4 l;
    public String level_name;
    public int levelup_score;
    public int locate;
    public AcrossForumIcon mAcrossForumIcon;
    public final ArrayList<xq4> mBadgeData;
    public final BannerListData mBannerListData;
    public DeletedReasonInfo mDeletedReasonInfo;
    public String mFromPage;
    public final sr4 mFrsBannerData;
    public int mIsLiveGameForum;
    public pr4 mMemberShowIconData;
    public PostTopicData mPostTopicData;
    public final PostPrefixData mPrefixData;
    public ArrayList<RecommendForumData> mRecommendForumData;
    public SignData mSignData;
    public ThemeColorInfo mThemeColorInfo;
    public List<TipInfo> mTipInfos;
    public List<Manager> managers;
    public int member_num;
    public String name;
    public rt4 news_info;
    public int post_num;
    public String riskTipNotice;
    public String riskTipPop;
    public String riskTipPopTitle;
    public String second_class;
    public String slogan;
    public String special_forum_type;
    public String tag_color;
    public String tag_name;
    public int thread_num;
    public String topIcon;
    public pt4 top_code;
    public TopNoticeData top_notice_data;
    public String topic_special_icon;
    public String topic_special_icon_right;
    public int user_level;
    public String warning_msg;
    public xt4 yuleData;

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
        this.mFrsBannerData = new sr4();
        this.mBannerListData = new BannerListData();
        this.mRecommendForumData = new ArrayList<>();
        this.mPrefixData = new PostPrefixData();
        this.mPostTopicData = new PostTopicData();
        this.top_code = new pt4();
        this.news_info = new rt4();
        this.mMemberShowIconData = new pr4();
        this.yuleData = new xt4();
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

    public String getAccelerateContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.accelerate_cotent : (String) invokeV.objValue;
    }

    public ArrayList<xq4> getBadgeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBadgeData : (ArrayList) invokeV.objValue;
    }

    public BannerListData getBannerListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBannerListData : (BannerListData) invokeV.objValue;
    }

    public int getCurScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cur_score : invokeV.intValue;
    }

    public DeletedReasonInfo getDeletedReasonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDeletedReasonInfo : (DeletedReasonInfo) invokeV.objValue;
    }

    public int getFavo_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.favo_type : invokeV.intValue;
    }

    public String getFirst_class() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.first_class : (String) invokeV.objValue;
    }

    public String getForumGameLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.forumGameLabel : (String) invokeV.objValue;
    }

    public String getFromPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mFromPage : (String) invokeV.objValue;
    }

    public sr4 getFrsBannerData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFrsBannerData : (sr4) invokeV.objValue;
    }

    public ArrayList<yr4> getGood_classify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.good_classify : (ArrayList) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public String getImage_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.image_url : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.is_private_forum : invokeV.intValue;
    }

    public boolean getIsShowBawuTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.isShowBawuTask : invokeV.booleanValue;
    }

    public boolean getIsShowRule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isShowForumRule : invokeV.booleanValue;
    }

    public String getLevelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.level_name : (String) invokeV.objValue;
    }

    public int getLevelupScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.levelup_score : invokeV.intValue;
    }

    public List<Manager> getManagers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.managers : (List) invokeV.objValue;
    }

    public int getMember_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.member_num : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public rt4 getNewsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.news_info : (rt4) invokeV.objValue;
    }

    public int getPost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.post_num : invokeV.intValue;
    }

    public PostPrefixData getPrefixData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mPrefixData : (PostPrefixData) invokeV.objValue;
    }

    public ArrayList<RecommendForumData> getRecommendForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mRecommendForumData : (ArrayList) invokeV.objValue;
    }

    public String getRiskTipNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.riskTipNotice : (String) invokeV.objValue;
    }

    public String getRiskTipPop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.riskTipPop : (String) invokeV.objValue;
    }

    public String getRiskTipPopTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.riskTipPopTitle : (String) invokeV.objValue;
    }

    public String getSecond_class() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.second_class : (String) invokeV.objValue;
    }

    public SignData getSignData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mSignData : (SignData) invokeV.objValue;
    }

    public boolean getSigned() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.is_sign || this.mSignData.is_signed == 1 : invokeV.booleanValue;
    }

    public String getSlogan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.slogan : (String) invokeV.objValue;
    }

    public String getSpecialForumType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.special_forum_type : (String) invokeV.objValue;
    }

    public String getTag_color() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.tag_color : (String) invokeV.objValue;
    }

    public String getTag_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.tag_name : (String) invokeV.objValue;
    }

    public ThemeColorInfo getThemeColorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mThemeColorInfo : (ThemeColorInfo) invokeV.objValue;
    }

    public int getThread_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.thread_num : invokeV.intValue;
    }

    public List<TipInfo> getTipInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mTipInfos : (List) invokeV.objValue;
    }

    public pt4 getTopCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.top_code : (pt4) invokeV.objValue;
    }

    public String getTopIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.topIcon : (String) invokeV.objValue;
    }

    public TopNoticeData getTop_notice_data() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.top_notice_data : (TopNoticeData) invokeV.objValue;
    }

    public String getTopic_special_icon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.topic_special_icon : (String) invokeV.objValue;
    }

    public String getTopic_special_icon_right() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.topic_special_icon_right : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? FORUM_FLOOR_TYPE : (BdUniqueId) invokeV.objValue;
    }

    public int getUser_level() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.user_level : invokeV.intValue;
    }

    public String getWarningMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.warning_msg : (String) invokeV.objValue;
    }

    public xt4 getYuleData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.yuleData : (xt4) invokeV.objValue;
    }

    public String getfShareImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.fShareImage : (String) invokeV.objValue;
    }

    public boolean isFrsMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.isFrsMask : invokeV.booleanValue;
    }

    public boolean isGameForumType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mIsLiveGameForum == 1 : invokeV.booleanValue;
    }

    public int isLike() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.is_like : invokeV.intValue;
    }

    public void parserJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(ForumInfo forumInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, forumInfo) == null) || forumInfo == null) {
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
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    yr4 yr4Var = new yr4();
                    yr4Var.d(list.get(i));
                    this.good_classify.add(yr4Var);
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
            }
            List<Badges> list2 = forumInfo.badges;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    xq4 xq4Var = new xq4();
                    xq4Var.b(list2.get(i2));
                    this.mBadgeData.add(xq4Var);
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
            this.news_info.m1(forumInfo.news_info);
            this.mAcrossForumIcon = forumInfo.across_forum_show;
            this.mIsLiveGameForum = forumInfo.is_live_game_forum.intValue();
            this.forumGameLabel = forumInfo.forum_game_label;
            this.warning_msg = forumInfo.warning_msg;
            this.special_forum_type = forumInfo.special_forum_type;
            this.topic_special_icon = forumInfo.topic_special_icon;
            this.topic_special_icon_right = forumInfo.topic_special_icon_right;
            this.isBrandForum = forumInfo.is_brand_forum.intValue() == 1;
            this.isShowAllTopThread = forumInfo.is_show_all_top_thread.intValue();
            this.mThemeColorInfo = forumInfo.theme_color;
            this.topIcon = forumInfo.is_top_img;
            this.is_private_forum = forumInfo.is_private_forum.intValue();
            this.isShowBawuTask = forumInfo.is_show_bawutask.intValue() == 1;
            this.fShareImage = forumInfo.f_share_img;
            this.isShowForumRule = forumInfo.is_show_forumrule.intValue() == 1;
            this.mDeletedReasonInfo = forumInfo.deleted_reason_info;
            this.isFrsMask = forumInfo.is_frs_mask.intValue() == 1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setCurScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.cur_score = i;
        }
    }

    public void setFavo_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.favo_type = i;
        }
    }

    public void setFromPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.mFromPage = str;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.id = str;
        }
    }

    public void setImage_url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.image_url = str;
        }
    }

    public void setLevelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.level_name = str;
        }
    }

    public void setLevelupScore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.levelup_score = i;
        }
    }

    public void setLike(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.is_like = i;
        }
    }

    public void setMember_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.member_num = i;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.name = str;
        }
    }

    public void setPost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.post_num = i;
        }
    }

    public void setSignData(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, signData) == null) {
            this.mSignData = signData;
        }
    }

    public void setSlogan(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.slogan = str;
        }
    }

    public void setTag_color(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.tag_color = str;
        }
    }

    public void setTag_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.tag_name = str;
        }
    }

    public void setThread_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.thread_num = i;
        }
    }

    public void setUser_level(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.user_level = i;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, jSONObject) == null) || jSONObject == null) {
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
                this.tag_name = optJSONObject2.optString("tag_name", null);
                this.tag_color = optJSONObject2.optString("color", null);
            }
            this.image_url = jSONObject.optString("avatar", null);
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
                    yr4 yr4Var = new yr4();
                    yr4Var.c(optJSONArray2.optJSONObject(i2));
                    this.good_classify.add(yr4Var);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("sign_in_info");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("user_info");
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
                    xq4 xq4Var = new xq4();
                    xq4Var.a(optJSONArray3.optJSONObject(i3));
                    this.mBadgeData.add(xq4Var);
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
                this.news_info.l1(jSONObject.optJSONObject("news_info"));
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            this.forumGameLabel = jSONObject.optString("forum_game_label");
            this.special_forum_type = jSONObject.optString(AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE);
            this.topic_special_icon = jSONObject.optString("topic_special_icon");
            this.topic_special_icon_right = jSONObject.optString("topic_special_icon_right");
            this.topIcon = jSONObject.optString("is_top_img");
            this.is_private_forum = jSONObject.optInt("is_private_forum");
            this.isShowBawuTask = jSONObject.optInt("is_show_bawutask") == 1;
            this.isShowForumRule = jSONObject.optInt("is_show_forumrule") == 1;
            this.fShareImage = jSONObject.optString("f_share_img");
            this.isFrsMask = jSONObject.optInt("is_frs_mask") == 1;
        } catch (Exception e8) {
            BdLog.e(e8.getMessage());
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, simpleForum) == null) || simpleForum == null) {
            return;
        }
        try {
            this.id = String.valueOf(simpleForum.id);
            this.name = simpleForum.name;
            this.image_url = simpleForum.avatar;
            this.is_like = simpleForum.is_liked.intValue();
            this.is_sign = simpleForum.is_signed.intValue() == 1;
            this.first_class = simpleForum.first_class;
            this.second_class = simpleForum.second_class;
            this.member_num = simpleForum.member_num.intValue();
            this.post_num = simpleForum.post_num.intValue();
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            this.isBlockBawuDelete = simpleForum.multi_forum_perm != null && simpleForum.multi_forum_perm.is_block_bawu_delete.intValue() == 1;
            this.mDeletedReasonInfo = simpleForum.deleted_reason_info;
            this.isFrsMask = simpleForum.is_frs_mask.intValue() == 1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}

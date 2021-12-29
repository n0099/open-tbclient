package c.a.t0.w3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.f0;
import c.a.s0.s.q.i0;
import c.a.s0.s.q.k1;
import c.a.s0.s.q.o0;
import c.a.s0.s.q.t1;
import c.a.s0.s.q.y0;
import c.a.s0.t.c.p0;
import c.a.s0.t.c.q0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.ForumRuleStatus;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes8.dex */
public class m implements c.a.s0.l0.b.b, c.a.s0.l0.b.h {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public int accessFlag;
    public ActivityConfig activityConfig;
    public AgreeBanner agreeBanner;
    public int alaLiveCount;
    public AntiData anti;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public WindowToast bazhuExam;
    public c.a.s0.s.q.z bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public c.a.t0.d1.d brandAdData;
    public i businessPromot;
    public d2 cardVideoInfo;
    public c.a.s0.s.q.t carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public b chatGroup;
    public ArrayList<c.a.s0.s.q.v> color_eggs;
    public int defaultShowTab;
    public PopInfo enterFrsDialogInfo;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public int forumState;
    public int frsDefaultTabId;
    public PopInfo frsMaskPopInfo;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public s gconAccount;
    public boolean hasGame;
    public c.a.s0.s.q.h0 headSdkData;
    public c.a.s0.s.q.c0 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public AlaLiveNotify liveNotify;
    public c.a.s0.s.q.y mActivityHeadData;
    public List<c.a.d.n.e.n> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public o mEntelechyTabInfo;
    public int mErrorNo;
    public g mFrsInsertLiveData;
    public h mFrsStageLiveData;
    public r mFrsVideoActivityData;
    public c.a.t0.g1.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public Integer mangaReadRecordChapterId;
    public NebulaHotThreads nebulaHotThreads;
    public int needLog;
    public List<OriForumInfo> oriForumInfoList;
    public b1 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public f0 presentInfoData;
    public k1 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public i0 recommendBookData;
    public t1 schoolRecommendInfo;
    public int schoolRecommendPos;
    public c0 serviceAreaData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public n star;
    public List<k> starEnter;
    public StarRank starRank;
    public ArrayList<c.a.d.n.e.n> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<c.a.d.n.e.n> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public c.a.t0.d1.w userRecommend;
    @Nullable
    public p0 voiceRoomConfig;
    @Nullable
    public q0 voiceRoomData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(990249364, "Lc/a/t0/w3/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(990249364, "Lc/a/t0/w3/m;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needLog = 0;
        this.starEnter = new ArrayList();
        this.isNewUrl = 0;
        this.color_eggs = new ArrayList<>();
        this.mActivityHeadData = null;
        this.mEntelechyTabInfo = new o();
        this.frsDefaultTabId = 1;
        this.isShowRedTip = false;
        this.bawuCenterUrl = null;
        this.headSdkData = null;
        this.recommendBookData = null;
        this.postTopic = null;
        this.bookInfoData = null;
        this.mangaReadRecordChapterId = -1;
        this.presentInfoData = null;
        this.headlineImgInfoData = null;
        this.schoolRecommendPos = -1;
        this.topThreadList = null;
        this.forumState = 0;
        this.accessFlag = 0;
        this.alaLiveCount = 0;
        this.gameDefaultTabId = 0;
        this.mErrorNo = 0;
        this.defaultShowTab = 1;
        this.mDataParseTime = 0L;
        initData();
    }

    private void handleDefaultTab(int i2) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.frsDefaultTabId = 1;
            o oVar = this.mEntelechyTabInfo;
            if (oVar == null || (list = oVar.a) == null || list.size() <= 0) {
                return;
            }
            for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.a) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i2) {
                    this.frsDefaultTabId = i2;
                    return;
                }
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.forum = new ForumData();
            this.threadList = new ArrayList<>();
            this.topThreadList = new ArrayList();
            this.userMap = new HashMap<>();
            this.page = new b1();
            this.star = new n();
            this.userData = new UserData();
            this.gconAccount = new s();
            setAnti(new AntiData());
            setChatGroup(new b());
            this.privateForumTotalData = new k1();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    public void convertThreadInfoToThreadData(DataRes dataRes, List<ThreadInfo> list, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, list, Long.valueOf(j2)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                d2 d2Var = new d2();
                d2Var.F3(dataRes.forum.id.longValue());
                SpecHotTopicHelper.setSpecTopicIcon(j2, d2Var);
                d2Var.I4(this.userMap);
                d2Var.O3(true);
                d2Var.c3(threadInfo);
                d2Var.g3();
                d2Var.J1();
                if (d2Var.U() == 0 && j2 != 0) {
                    d2Var.I3(j2);
                }
                if (StringUtils.isNull(d2Var.a0())) {
                    d2Var.M3(this.forum.getName());
                }
                d2Var.V2(this.color_eggs);
                d2Var.L1 = this.forum.isBrandForum;
                if (!TextUtils.isEmpty(d2Var.z0())) {
                    c.a.s0.s.q.p0 p0Var = new c.a.s0.s.q.p0();
                    p0Var.k(d2Var.z0());
                    this.threadList.add(p0Var);
                } else {
                    this.threadList.add(d2Var);
                    JSONObject c2 = c.a.t0.j3.l0.b.c(threadInfo, d2Var.a0());
                    if (c2 != null) {
                        arrayList.add(c2);
                    }
                }
            }
        }
        c.a.t0.j3.l0.b.f().h("FRS", arrayList);
    }

    public void deleteLikeFeedForum(String str) {
        List<FeedForumData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.likeFeedForumDataList) == null || str == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                this.likeFeedForumDataList.remove(feedForumData);
                return;
            }
        }
    }

    public int getAccessFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.accessFlag : invokeV.intValue;
    }

    public c.a.s0.s.q.y getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityHeadData : (c.a.s0.s.q.y) invokeV.objValue;
    }

    public AgreeBanner getAgreeBanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.agreeBanner : (AgreeBanner) invokeV.objValue;
    }

    public int getAlaLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.alaLiveCount : invokeV.intValue;
    }

    public AntiData getAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.anti : (AntiData) invokeV.objValue;
    }

    public String getBawuCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bawuCenterUrl : (String) invokeV.objValue;
    }

    public c.a.s0.s.q.z getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bookInfoData : (c.a.s0.s.q.z) invokeV.objValue;
    }

    public i getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.businessPromot : (i) invokeV.objValue;
    }

    @Override // c.a.s0.l0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<c.a.d.n.e.n> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCardShipinNew : (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCardShipinPos : (List) invokeV.objValue;
    }

    public d2 getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.cardVideoInfo : (d2) invokeV.objValue;
    }

    public c.a.s0.s.q.t getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.carrierEnterData : (c.a.s0.s.q.t) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.categoryInfos : (List) invokeV.objValue;
    }

    public b getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.chatGroup : (b) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mDataParseTime : invokeV.longValue;
    }

    public o getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mEntelechyTabInfo : (o) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.fortuneDesc : (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.forum : (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.forumHeadIcon : (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.forumState : invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsDefaultTabId : invokeV.intValue;
    }

    public g getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mFrsInsertLiveData : (g) invokeV.objValue;
    }

    public h getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mFrsStageLiveData : (h) invokeV.objValue;
    }

    public r getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFrsVideoActivityData : (r) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.gameDefaultTabId : invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.gameName : (String) invokeV.objValue;
    }

    public c.a.t0.g1.b getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mGameRankListData : (c.a.t0.g1.b) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.gameTabInfo : (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.gameUrl : (String) invokeV.objValue;
    }

    public s getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.gconAccount : (s) invokeV.objValue;
    }

    public c.a.s0.s.q.h0 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.headSdkData : (c.a.s0.s.q.h0) invokeV.objValue;
    }

    public c.a.s0.s.q.c0 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.headlineImgInfoData : (c.a.s0.s.q.c0) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mHotUserRankData : (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.isNewUrl : invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.likeFeedForumDataList : (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.liveNotify : (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mangaReadRecordChapterId : (Integer) invokeV.objValue;
    }

    public b1 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.page : (b1) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.photoLivePos : invokeV.intValue;
    }

    public k1 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.privateForumTotalData : (k1) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.schoolRecommendPos : invokeV.intValue;
    }

    public t1 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.schoolRecommendInfo : (t1) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mSortType : invokeV.intValue;
    }

    public n getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.star : (n) invokeV.objValue;
    }

    public List<k> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.starEnter : (List) invokeV.objValue;
    }

    public ArrayList<c.a.d.n.e.n> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.threadListIds : (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.toLoadHorseData : (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.userData : (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public c.a.t0.d1.w getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.userRecommend : (c.a.t0.d1.w) invokeV.objValue;
    }

    @NonNull
    public p0 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            p0 p0Var = this.voiceRoomConfig;
            return p0Var != null ? p0Var : p0.f14205b;
        }
        return (p0) invokeV.objValue;
    }

    public q0 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.voiceRoomData : (q0) invokeV.objValue;
    }

    @Override // c.a.s0.l0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, jSONObject) == null) {
        }
    }

    @Override // c.a.s0.l0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, message) == null) {
        }
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.fortuneBag : invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.hasGame : invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.isShowRedTip : invokeV.booleanValue;
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048639, this, bArr, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bArr == null) {
                return null;
            }
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null) {
                    parserProtobuf(frsPageResIdl.data);
                }
                if (z) {
                    if (this.mDataParseTime == 0) {
                        this.mDataParseTime = System.currentTimeMillis() - currentTimeMillis;
                    }
                } else {
                    this.mDataParseTime = 0L;
                }
                return frsPageResIdl;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (FrsPageResIdl) invokeLZ.objValue;
    }

    public void setAccessFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.accessFlag = i2;
        }
    }

    public void setActivityHeadData(c.a.s0.s.q.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, yVar) == null) {
            this.mActivityHeadData = yVar;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.alaLiveCount = i2;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(c.a.s0.s.q.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, zVar) == null) {
            this.bookInfoData = zVar;
        }
    }

    public void setBusinessPromot(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, iVar) == null) {
            this.businessPromot = iVar;
        }
    }

    public void setCardShipinNew(List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, d2Var) == null) {
            this.cardVideoInfo = d2Var;
        }
    }

    public void setCarrierEnterData(c.a.s0.s.q.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, tVar) == null) {
            this.carrierEnterData = tVar;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bVar) == null) {
            this.chatGroup = bVar;
        }
    }

    public void setEntelechyTabInfo(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, oVar) == null) {
            this.mEntelechyTabInfo = oVar;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            this.forumState = i2;
        }
    }

    public void setFrsDefaultTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.frsDefaultTabId = i2;
        }
    }

    public void setFrsInsertLiveData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, gVar) == null) {
            this.mFrsInsertLiveData = gVar;
        }
    }

    public void setFrsStageLiveData(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, hVar) == null) {
            this.mFrsStageLiveData = hVar;
        }
    }

    public void setFrsVideoActivityData(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, rVar) == null) {
            this.mFrsVideoActivityData = rVar;
        }
    }

    public void setGameDefaultTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.gameDefaultTabId = i2;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(c.a.t0.g1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, bVar) == null) {
            this.mGameRankListData = bVar;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, sVar) == null) {
            this.gconAccount = sVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(c.a.s0.s.q.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, h0Var) == null) {
            this.headSdkData = h0Var;
        }
    }

    public void setHeadlineImgInfoData(c.a.s0.s.q.c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, c0Var) == null) {
            this.headlineImgInfoData = c0Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            this.isNewUrl = i2;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, b1Var) == null) {
            this.page = b1Var;
        }
    }

    public void setPhotoLivePos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i2) == null) {
            this.photoLivePos = i2;
        }
    }

    public void setPrivateForumTotalInfo(k1 k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, k1Var) == null) {
            this.privateForumTotalData = k1Var;
        }
    }

    public void setSchoolRecommendInfo(t1 t1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, t1Var) == null) {
            this.schoolRecommendInfo = t1Var;
        }
    }

    public void setSchoolRecommendPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            this.schoolRecommendPos = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i2) == null) {
            this.mSortType = i2;
        }
    }

    public void setStar(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, nVar) == null) {
            this.star = nVar;
        }
    }

    public void setStarEnter(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<c.a.d.n.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(c.a.t0.d1.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, wVar) == null) {
            this.userRecommend = wVar;
        }
    }

    public void setVoiceRoomConfig(@Nullable p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, p0Var) == null) {
            this.voiceRoomConfig = p0Var;
        }
    }

    public q0 setVoiceRoomData(q0 q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, q0Var)) == null) {
            this.voiceRoomData = q0Var;
            return q0Var;
        }
        return (q0) invokeL.objValue;
    }

    public ArrayList<c.a.d.n.e.n> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            ArrayList<c.a.d.n.e.n> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.s0.l0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ArrayList<c.a.d.n.e.n> switchThreadDataToThreadCardInfo(ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                c.a.d.n.e.n next = it.next();
                if (next instanceof o0) {
                    ((o0) next).setPosition(i2 - i3);
                    arrayList2.add(next);
                } else if (next instanceof c.a.s0.s.q.p0) {
                    ((c.a.s0.s.q.p0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof d2) {
                    d2 d2Var = (d2) next;
                    if (d2Var.D2()) {
                        i3++;
                    }
                    c.a.s0.b.f.a.e(d2Var);
                    int[] h0 = d2Var.h0();
                    if (d2Var.getType() == d2.i3 && !d2Var.D2()) {
                        c2 c2Var = new c2();
                        c2Var.w = d2Var;
                        c2Var.position = i2;
                        c2Var.f13640e = true;
                        c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var);
                        c2 c2Var2 = new c2();
                        c2Var2.w = d2Var;
                        c2Var2.position = i2;
                        if (d2Var.Q1()) {
                            c2Var2.f13645j = true;
                        } else if (d2Var.h3() == 1) {
                            c2Var2.f13643h = true;
                            c2Var2.x = h0[0];
                            c2Var2.y = h0[1];
                        } else if (d2Var.h3() >= 2) {
                            c2Var2.f13644i = true;
                        } else {
                            c2Var2.f13641f = true;
                        }
                        c2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var2);
                        if (d2Var.J0() != null) {
                            c2 c2Var3 = new c2();
                            c2Var3.s = true;
                            c2Var3.w = d2Var;
                            c2Var3.position = i2;
                            c2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var3);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var4 = new c2();
                            c2Var4.p = true;
                            c2Var4.w = d2Var;
                            c2Var4.position = i2;
                            c2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var4);
                        }
                        if (!ListUtils.isEmpty(d2Var.B0()) || !ListUtils.isEmpty(d2Var.d0())) {
                            c2 c2Var5 = new c2();
                            if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) == 1) {
                                c2Var5.t = true;
                            } else if (ListUtils.getCount(d2Var.B0()) + ListUtils.getCount(d2Var.d0()) > 1) {
                                c2Var5.u = true;
                            }
                            c2Var5.w = d2Var;
                            c2Var5.position = i2;
                            c2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var5);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var6 = new c2();
                            c2Var6.l = true;
                            c2Var6.w = d2Var;
                            c2Var6.position = i2;
                            c2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var6);
                        }
                        if (d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var7 = new c2();
                            c2Var7.r = true;
                            c2Var7.w = d2Var;
                            c2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var7);
                        }
                        c2 c2Var8 = new c2();
                        c2Var8.f13646k = true;
                        c2Var8.w = d2Var;
                        c2Var8.position = i2;
                        c2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var8);
                    } else if ((d2Var.getType() == d2.G3 || d2Var.getType() == d2.Y3) && !d2Var.D2()) {
                        c2 c2Var9 = new c2();
                        c2Var9.w = d2Var;
                        c2Var9.position = i2;
                        c2Var9.f13640e = true;
                        c2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var9);
                        c2 c2Var10 = new c2();
                        c2Var10.w = d2Var;
                        c2Var10.position = i2;
                        if (d2Var instanceof y0) {
                            c2Var10.n = true;
                        } else {
                            c2Var10.m = true;
                        }
                        c2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var10);
                        if (d2Var.J0() != null) {
                            c2 c2Var11 = new c2();
                            c2Var11.s = true;
                            c2Var11.w = d2Var;
                            c2Var11.position = i2;
                            c2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var11);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var12 = new c2();
                            c2Var12.p = true;
                            c2Var12.w = d2Var;
                            c2Var12.position = i2;
                            c2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var12);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var13 = new c2();
                            c2Var13.l = true;
                            c2Var13.w = d2Var;
                            c2Var13.position = i2;
                            c2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var13);
                        }
                        if (d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var14 = new c2();
                            c2Var14.r = true;
                            c2Var14.w = d2Var;
                            c2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var14);
                        }
                        c2 c2Var15 = new c2();
                        c2Var15.f13646k = true;
                        c2Var15.w = d2Var;
                        c2Var15.position = i2;
                        c2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var15);
                    } else if (d2Var.t1() != null && !d2Var.i2() && d2Var.c2()) {
                        c2 c2Var16 = new c2();
                        c2Var16.w = d2Var;
                        c2Var16.position = i2;
                        c2Var16.f13640e = true;
                        c2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(c2Var16);
                        c2 c2Var17 = new c2();
                        c2Var17.w = d2Var;
                        c2Var17.position = i2;
                        c2Var17.o = true;
                        c2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(c2Var17);
                        if (d2Var.J0() != null) {
                            c2 c2Var18 = new c2();
                            c2Var18.s = true;
                            c2Var18.w = d2Var;
                            c2Var18.position = i2;
                            c2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var18);
                        }
                        if (d2Var.g1() != null) {
                            c2 c2Var19 = new c2();
                            c2Var19.p = true;
                            c2Var19.w = d2Var;
                            c2Var19.position = i2;
                            c2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var19);
                        }
                        if (d2Var.y1() != null) {
                            c2 c2Var20 = new c2();
                            c2Var20.l = true;
                            c2Var20.w = d2Var;
                            c2Var20.position = i2;
                            c2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var20);
                        }
                        if (d2Var.t0() != null && !d2Var.L2()) {
                            c2 c2Var21 = new c2();
                            c2Var21.r = true;
                            c2Var21.w = d2Var;
                            c2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(c2Var21);
                        }
                        c2 c2Var22 = new c2();
                        c2Var22.f13646k = true;
                        c2Var22.w = d2Var;
                        c2Var22.position = i2;
                        c2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(c2Var22);
                    } else if (d2Var.getType() == d2.y3 && d2Var.P1()) {
                        d2Var.position = i2;
                        arrayList2.add(d2Var);
                    } else {
                        c2 c2Var23 = new c2();
                        c2Var23.w = d2Var;
                        c2Var23.position = i2;
                        arrayList2.add(c2Var23);
                    }
                    i2++;
                    d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    if (next != null && next.getType() != d2.h3) {
                        this.mHasThreadExceptTop = true;
                    }
                } else {
                    arrayList2.add(next);
                }
                i2++;
                if (next != null) {
                    this.mHasThreadExceptTop = true;
                }
            }
            c.a.s0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        c.a.s0.s.q.v vVar = new c.a.s0.s.q.v();
                        if (vVar.c(colorEgg)) {
                            this.color_eggs.add(vVar);
                        }
                    }
                }
            }
            int i2 = 0;
            boolean z = true;
            if (dataRes.forum != null) {
                this.hasGame = dataRes.forum.has_game.intValue() == 1;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
            }
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                c.a.s0.s.q.y yVar = new c.a.s0.s.q.y();
                this.mActivityHeadData = yVar;
                yVar.e(dataRes.brand_forum_info.head_imgs);
                c.a.t0.d1.d dVar = new c.a.t0.d1.d();
                this.brandAdData = dVar;
                dVar.a(dataRes.brand_forum_info);
                if (!ListUtils.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                    this.oriForumInfoList = new ArrayList();
                    for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                        if (oriForumInfo != null) {
                            this.oriForumInfoList.add(oriForumInfo);
                        }
                    }
                }
            } else if (dataRes.activityhead != null) {
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                c.a.s0.s.q.y yVar2 = new c.a.s0.s.q.y();
                this.mActivityHeadData = yVar2;
                yVar2.d(dataRes.activityhead, longValue);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !c.a.d.f.p.m.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                c.a.s0.s.q.y yVar3 = new c.a.s0.s.q.y();
                this.mActivityHeadData = yVar3;
                yVar3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MetaData metaData2 = new MetaData();
                    metaData2.parserProtobuf(list.get(i3));
                    String userId = metaData2.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData2.getUserId(), metaData2);
                    }
                }
            }
            this.userList = dataRes.user_list;
            setIsNewUrl(dataRes.is_new_url.intValue());
            this.fortuneBag = dataRes.fortune_bag.intValue() == 1;
            this.fortuneDesc = dataRes.fortune_desc;
            List<StarEnter> list2 = dataRes.star_enter;
            this.starEnter.clear();
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    k kVar = new k();
                    kVar.l(list2.get(i4));
                    this.starEnter.add(kVar);
                }
            }
            this.gconAccount.c(dataRes.gcon_account);
            this.forum.parserProtobuf(dataRes.forum);
            if (dataRes.forum != null) {
                j2 = dataRes.forum.id.longValue();
                SpecHotTopicHelper.putSpecialTopicIcon(Long.valueOf(j2), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
            } else {
                j2 = 0;
            }
            this.threadListIds = dataRes.thread_id_list;
            this.anti.parserProtobuf(dataRes.anti);
            if (dataRes.anti != null) {
                c.a.t0.e4.d.f(dataRes.anti.block_pop_info);
            }
            this.chatGroup.a(dataRes.group);
            this.page.j(dataRes.page);
            this.star.c(dataRes.frs_star);
            this.userData.parserProtobuf(dataRes.user);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
            }
            if (dataRes.nav_tab_info == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                this.mEntelechyTabInfo.a(builder.build(true));
            } else {
                this.mEntelechyTabInfo.a(dataRes.nav_tab_info);
            }
            this.defaultShowTab = 1;
            if (c.a.s0.b.d.t() && !c.a.s0.b.g.a.f12555e.equals(((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.a, 0)).tab_name)) {
                this.defaultShowTab = c.a.s0.b.g.a.c();
            }
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.f25663c)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.f25663c.get(0);
            }
            this.alaLiveCount = dataRes.ala_live_count.intValue();
            handleDefaultTab(dataRes.frs_tab_default.intValue());
            this.photoLivePos = dataRes.twzhibo_pos.intValue();
            this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
            convertThreadInfoToThreadData(dataRes, dataRes.thread_list, j2);
            this.categoryInfos = dataRes.category_list;
            if (!c.a.d.f.p.m.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                c.a.s0.s.q.h0 h0Var = new c.a.s0.s.q.h0();
                this.headSdkData = h0Var;
                h0Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                i0 i0Var = new i0();
                this.recommendBookData = i0Var;
                i0Var.T4(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                c.a.s0.s.q.z zVar = new c.a.s0.s.q.z();
                this.bookInfoData = zVar;
                zVar.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                f0 f0Var = new f0();
                this.presentInfoData = f0Var;
                f0Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                c.a.s0.s.q.c0 c0Var = new c.a.s0.s.q.c0();
                this.headlineImgInfoData = c0Var;
                c0Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                i iVar = new i();
                this.businessPromot = iVar;
                iVar.p(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                d2 d2Var = new d2();
                this.cardVideoInfo = d2Var;
                d2Var.V3(true);
                this.cardVideoInfo.T3(this.photoLivePos);
                this.cardVideoInfo.I4(this.userMap);
                this.cardVideoInfo.c3(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.g3();
                this.cardVideoInfo.L1 = this.isBrandForum;
                if (this.cardVideoInfo.U() == 0 && j2 != 0) {
                    this.cardVideoInfo.I3(j2);
                }
                this.cardVideoInfo.V2(this.color_eggs);
                this.cardVideoInfo.L3(!this.cardVideoInfo.B2());
                if (this.cardVideoInfo.J() != null && this.cardVideoInfo.J().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.J().getUserId())) != null && metaData.getPendantData() != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    userPendantData.setPropsId(metaData.getPendantData().getPropsId());
                    userPendantData.setImgUrl(metaData.getPendantData().getImgUrl());
                    this.cardVideoInfo.J().setPendantData(userPendantData);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                g gVar = new g();
                this.mFrsInsertLiveData = gVar;
                gVar.f25516f = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                        d2 d2Var2 = new d2();
                        d2Var2.c3(dataRes.ala_live_insert.ala_live_list.get(i5));
                        d2Var2.L1 = this.isBrandForum;
                        arrayList.add(d2Var2);
                    }
                }
                this.mFrsInsertLiveData.f25515e = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new h();
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                    if (dataRes.ala_stage_list.get(i6) != null) {
                        d2 d2Var3 = new d2();
                        d2Var3.c3(dataRes.ala_stage_list.get(i6));
                        d2Var3.L1 = this.isBrandForum;
                        arrayList2.add(d2Var3);
                    }
                }
                this.mFrsStageLiveData.f25518e = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                t1 t1Var = new t1();
                this.schoolRecommendInfo = t1Var;
                t1Var.U4(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                c.a.s0.s.q.t tVar = new c.a.s0.s.q.t();
                this.carrierEnterData = tVar;
                tVar.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            c.a.t0.j3.j0.a.e().h(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                    d2 d2Var4 = new d2();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        d2Var4.T3(this.mCardShipinPos.get(i7).intValue());
                    }
                    d2Var4.V3(true);
                    d2Var4.c3(dataRes.card_shipin_new.get(i7));
                    d2Var4.L1 = this.isBrandForum;
                    this.mCardShipinNew.add(d2Var4);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                c.a.t0.g1.b bVar = new c.a.t0.g1.b();
                this.mGameRankListData = bVar;
                bVar.e(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                c.a.t0.d1.w wVar = new c.a.t0.d1.w();
                this.userRecommend = wVar;
                wVar.i(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                r rVar = new r();
                this.mFrsVideoActivityData = rVar;
                rVar.a(dataRes.video.video_act);
            }
            if (dataRes.info != null) {
                this.recm_forum_list = dataRes.info.recm_forum_list;
            }
            this.forumArIno = dataRes.forum_ar_info;
            if (dataRes.star_rank_info != null) {
                this.starRank = dataRes.star_rank_info;
            }
            if (dataRes.recom_post_topic != null) {
                this.postTopic = dataRes.recom_post_topic;
            }
            this.mWindowToast = dataRes.window_toast;
            this.activityConfig = dataRes.activity_config;
            if (dataRes.video_auto_play.intValue() != 1) {
                z = false;
            }
            this.isFrsVideoAutoPlay = z;
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            this.mHotUserRankData = dataRes.hot_user_entry;
            this.bazhuExam = dataRes.bazhu_exam_fail;
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new c0();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        d0 d0Var = new d0();
                        d0Var.f25496b = serviceArea.picurl;
                        d0Var.f25497c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        d0Var.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            d0Var.f25496b = serviceArea.area_smart_app.avatar;
                            d0Var.f25497c = serviceArea.area_smart_app.name;
                        }
                        d0Var.f25498d = serviceArea.serviceurl;
                        d0Var.f25499e = serviceArea.schema;
                        d0Var.f25503i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String p = c.a.s0.s.g0.b.j().p("frs_service_version_" + this.forum.getName() + d0Var.f25497c, "");
                        if (!TextUtils.isEmpty(p)) {
                            p.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            e0 e0Var = new e0();
                            e0Var.a(serviceArea.area_smart_app);
                            d0Var.f25500f = e0Var;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            d0Var.f25501g = this.forum.getId();
                        }
                        d0Var.f25502h = i2;
                        i2++;
                        arrayList3.add(d0Var);
                    }
                }
                this.serviceAreaData.a = arrayList3.size();
                this.serviceAreaData.f25492b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
            this.frsMaskPopInfo = dataRes.frsmask_pop_info;
            this.voiceRoomConfig = p0.c(dataRes);
            q0 q0Var = new q0();
            this.voiceRoomData = q0Var;
            q0Var.d(dataRes);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

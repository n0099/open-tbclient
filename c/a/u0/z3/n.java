package c.a.u0.z3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.b1;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.k1;
import c.a.t0.s.r.o0;
import c.a.t0.s.r.p0;
import c.a.t0.s.r.t1;
import c.a.t0.s.r.y0;
import c.a.t0.t.c.q0;
import c.a.t0.t.c.r0;
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
import com.baidu.tbadk.util.DataExt;
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
import java.util.Map;
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
/* loaded from: classes9.dex */
public class n implements c.a.t0.l0.b.b, c.a.t0.l0.b.h {
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
    public c.a.t0.s.r.z bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public c.a.u0.e1.d brandAdData;
    public i businessPromot;
    public e2 cardVideoInfo;
    public c.a.t0.s.r.t carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public b chatGroup;
    public ArrayList<c.a.t0.s.r.v> color_eggs;
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
    public t gconAccount;
    public boolean hasGame;
    public c.a.t0.s.r.h0 headSdkData;
    public c.a.t0.s.r.c0 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public AlaLiveNotify liveNotify;
    public c.a.t0.s.r.y mActivityHeadData;
    public List<c.a.d.o.e.n> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public p mEntelechyTabInfo;
    public int mErrorNo;
    public g mFrsInsertLiveData;
    public h mFrsStageLiveData;
    public s mFrsVideoActivityData;
    public c.a.u0.h1.b mGameRankListData;
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
    public c.a.t0.s.r.f0 presentInfoData;
    public k1 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public c.a.t0.s.r.i0 recommendBookData;
    public t1 schoolRecommendInfo;
    public int schoolRecommendPos;
    public d0 serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public o star;
    public List<k> starEnter;
    public StarRank starRank;
    public ArrayList<c.a.d.o.e.n> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<c.a.d.o.e.n> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public c.a.u0.e1.w userRecommend;
    @Nullable
    public q0 voiceRoomConfig;
    @Nullable
    public r0 voiceRoomData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559137003, "Lc/a/u0/z3/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559137003, "Lc/a/u0/z3/n;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public n() {
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
        this.mEntelechyTabInfo = new p();
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
        this.serviceAreaFlutterData = new ArrayList();
        initData();
    }

    private void handleDefaultTab(int i2) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.frsDefaultTabId = 1;
            p pVar = this.mEntelechyTabInfo;
            if (pVar == null || (list = pVar.a) == null || list.size() <= 0) {
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
            this.star = new o();
            this.userData = new UserData();
            this.gconAccount = new t();
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
                e2 e2Var = new e2();
                e2Var.G3(dataRes.forum.id.longValue());
                SpecHotTopicHelper.setSpecTopicIcon(j2, e2Var);
                e2Var.J4(this.userMap);
                e2Var.P3(true);
                e2Var.d3(threadInfo);
                e2Var.h3();
                e2Var.K1();
                if (e2Var.U() == 0 && j2 != 0) {
                    e2Var.J3(j2);
                }
                if (StringUtils.isNull(e2Var.b0())) {
                    e2Var.N3(this.forum.getName());
                }
                e2Var.W2(this.color_eggs);
                e2Var.K1 = this.forum.isBrandForum;
                if (!TextUtils.isEmpty(e2Var.A0())) {
                    p0 p0Var = new p0();
                    p0Var.k(e2Var.A0());
                    this.threadList.add(p0Var);
                } else {
                    this.threadList.add(e2Var);
                    JSONObject c2 = c.a.u0.l3.l0.b.c(threadInfo, e2Var.b0());
                    if (c2 != null) {
                        arrayList.add(c2);
                    }
                }
            }
        }
        c.a.u0.l3.l0.b.f().h("FRS", arrayList);
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

    public c.a.t0.s.r.y getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityHeadData : (c.a.t0.s.r.y) invokeV.objValue;
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

    public c.a.t0.s.r.z getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bookInfoData : (c.a.t0.s.r.z) invokeV.objValue;
    }

    public i getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.businessPromot : (i) invokeV.objValue;
    }

    @Override // c.a.t0.l0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<c.a.d.o.e.n> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCardShipinNew : (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCardShipinPos : (List) invokeV.objValue;
    }

    public e2 getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.cardVideoInfo : (e2) invokeV.objValue;
    }

    public c.a.t0.s.r.t getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.carrierEnterData : (c.a.t0.s.r.t) invokeV.objValue;
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

    public p getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mEntelechyTabInfo : (p) invokeV.objValue;
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

    public s getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFrsVideoActivityData : (s) invokeV.objValue;
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

    public c.a.u0.h1.b getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mGameRankListData : (c.a.u0.h1.b) invokeV.objValue;
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

    public t getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.gconAccount : (t) invokeV.objValue;
    }

    public c.a.t0.s.r.h0 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.headSdkData : (c.a.t0.s.r.h0) invokeV.objValue;
    }

    public c.a.t0.s.r.c0 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.headlineImgInfoData : (c.a.t0.s.r.c0) invokeV.objValue;
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

    public o getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.star : (o) invokeV.objValue;
    }

    public List<k> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.starEnter : (List) invokeV.objValue;
    }

    public ArrayList<c.a.d.o.e.n> getThreadList() {
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

    public c.a.u0.e1.w getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.userRecommend : (c.a.u0.e1.w) invokeV.objValue;
    }

    @NonNull
    public q0 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            q0 q0Var = this.voiceRoomConfig;
            return q0Var != null ? q0Var : q0.f14297b;
        }
        return (q0) invokeV.objValue;
    }

    public r0 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.voiceRoomData : (r0) invokeV.objValue;
    }

    @Override // c.a.t0.l0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, jSONObject) == null) {
        }
    }

    @Override // c.a.t0.l0.b.h
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

    public void setActivityHeadData(c.a.t0.s.r.y yVar) {
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

    public void setBookInfo(c.a.t0.s.r.z zVar) {
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

    public void setCardShipinNew(List<c.a.d.o.e.n> list) {
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

    public void setCardVideoInfo(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, e2Var) == null) {
            this.cardVideoInfo = e2Var;
        }
    }

    public void setCarrierEnterData(c.a.t0.s.r.t tVar) {
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

    public void setEntelechyTabInfo(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, pVar) == null) {
            this.mEntelechyTabInfo = pVar;
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

    public void setFrsVideoActivityData(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, sVar) == null) {
            this.mFrsVideoActivityData = sVar;
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

    public void setGameRankListData(c.a.u0.h1.b bVar) {
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

    public void setGconAccount(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, tVar) == null) {
            this.gconAccount = tVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(c.a.t0.s.r.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, h0Var) == null) {
            this.headSdkData = h0Var;
        }
    }

    public void setHeadlineImgInfoData(c.a.t0.s.r.c0 c0Var) {
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

    public void setStar(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, oVar) == null) {
            this.star = oVar;
        }
    }

    public void setStarEnter(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<c.a.d.o.e.n> arrayList) {
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

    public void setUserRecommend(c.a.u0.e1.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, wVar) == null) {
            this.userRecommend = wVar;
        }
    }

    public void setVoiceRoomConfig(@Nullable q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, q0Var) == null) {
            this.voiceRoomConfig = q0Var;
        }
    }

    public r0 setVoiceRoomData(r0 r0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, r0Var)) == null) {
            this.voiceRoomData = r0Var;
            return r0Var;
        }
        return (r0) invokeL.objValue;
    }

    public ArrayList<c.a.d.o.e.n> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            ArrayList<c.a.d.o.e.n> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // c.a.t0.l0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ArrayList<c.a.d.o.e.n> switchThreadDataToThreadCardInfo(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if (next instanceof o0) {
                    ((o0) next).setPosition(i2 - i3);
                    arrayList2.add(next);
                } else if (next instanceof p0) {
                    ((p0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof e2) {
                    e2 e2Var = (e2) next;
                    if (e2Var.E2()) {
                        i3++;
                    }
                    c.a.t0.b.f.a.e(e2Var);
                    int[] i0 = e2Var.i0();
                    if (e2Var.getType() == e2.j3 && !e2Var.E2()) {
                        d2 d2Var = new d2();
                        d2Var.w = e2Var;
                        d2Var.position = i2;
                        d2Var.f13813e = true;
                        d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var);
                        d2 d2Var2 = new d2();
                        d2Var2.w = e2Var;
                        d2Var2.position = i2;
                        if (e2Var.R1()) {
                            d2Var2.f13818j = true;
                        } else if (e2Var.i3() == 1) {
                            d2Var2.f13816h = true;
                            d2Var2.x = i0[0];
                            d2Var2.y = i0[1];
                        } else if (e2Var.i3() >= 2) {
                            d2Var2.f13817i = true;
                        } else {
                            d2Var2.f13814f = true;
                        }
                        d2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var2);
                        if (e2Var.K0() != null) {
                            d2 d2Var3 = new d2();
                            d2Var3.s = true;
                            d2Var3.w = e2Var;
                            d2Var3.position = i2;
                            d2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var3);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var4 = new d2();
                            d2Var4.p = true;
                            d2Var4.w = e2Var;
                            d2Var4.position = i2;
                            d2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var4);
                        }
                        if (!ListUtils.isEmpty(e2Var.C0()) || !ListUtils.isEmpty(e2Var.e0())) {
                            d2 d2Var5 = new d2();
                            if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) == 1) {
                                d2Var5.t = true;
                            } else if (ListUtils.getCount(e2Var.C0()) + ListUtils.getCount(e2Var.e0()) > 1) {
                                d2Var5.u = true;
                            }
                            d2Var5.w = e2Var;
                            d2Var5.position = i2;
                            d2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var5);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var6 = new d2();
                            d2Var6.l = true;
                            d2Var6.w = e2Var;
                            d2Var6.position = i2;
                            d2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var6);
                        }
                        if (e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var7 = new d2();
                            d2Var7.r = true;
                            d2Var7.w = e2Var;
                            d2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var7);
                        }
                        d2 d2Var8 = new d2();
                        d2Var8.k = true;
                        d2Var8.w = e2Var;
                        d2Var8.position = i2;
                        d2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var8);
                    } else if ((e2Var.getType() == e2.H3 || e2Var.getType() == e2.Z3) && !e2Var.E2()) {
                        d2 d2Var9 = new d2();
                        d2Var9.w = e2Var;
                        d2Var9.position = i2;
                        d2Var9.f13813e = true;
                        d2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var9);
                        d2 d2Var10 = new d2();
                        d2Var10.w = e2Var;
                        d2Var10.position = i2;
                        if (e2Var instanceof y0) {
                            d2Var10.n = true;
                        } else {
                            d2Var10.m = true;
                        }
                        d2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var10);
                        if (e2Var.K0() != null) {
                            d2 d2Var11 = new d2();
                            d2Var11.s = true;
                            d2Var11.w = e2Var;
                            d2Var11.position = i2;
                            d2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var11);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var12 = new d2();
                            d2Var12.p = true;
                            d2Var12.w = e2Var;
                            d2Var12.position = i2;
                            d2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var12);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var13 = new d2();
                            d2Var13.l = true;
                            d2Var13.w = e2Var;
                            d2Var13.position = i2;
                            d2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var13);
                        }
                        if (e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var14 = new d2();
                            d2Var14.r = true;
                            d2Var14.w = e2Var;
                            d2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var14);
                        }
                        d2 d2Var15 = new d2();
                        d2Var15.k = true;
                        d2Var15.w = e2Var;
                        d2Var15.position = i2;
                        d2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var15);
                    } else if (e2Var.u1() != null && !e2Var.j2() && e2Var.d2()) {
                        d2 d2Var16 = new d2();
                        d2Var16.w = e2Var;
                        d2Var16.position = i2;
                        d2Var16.f13813e = true;
                        d2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(d2Var16);
                        d2 d2Var17 = new d2();
                        d2Var17.w = e2Var;
                        d2Var17.position = i2;
                        d2Var17.o = true;
                        d2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(d2Var17);
                        if (e2Var.K0() != null) {
                            d2 d2Var18 = new d2();
                            d2Var18.s = true;
                            d2Var18.w = e2Var;
                            d2Var18.position = i2;
                            d2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var18);
                        }
                        if (e2Var.h1() != null) {
                            d2 d2Var19 = new d2();
                            d2Var19.p = true;
                            d2Var19.w = e2Var;
                            d2Var19.position = i2;
                            d2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var19);
                        }
                        if (e2Var.z1() != null) {
                            d2 d2Var20 = new d2();
                            d2Var20.l = true;
                            d2Var20.w = e2Var;
                            d2Var20.position = i2;
                            d2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var20);
                        }
                        if (e2Var.u0() != null && !e2Var.M2()) {
                            d2 d2Var21 = new d2();
                            d2Var21.r = true;
                            d2Var21.w = e2Var;
                            d2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(d2Var21);
                        }
                        d2 d2Var22 = new d2();
                        d2Var22.k = true;
                        d2Var22.w = e2Var;
                        d2Var22.position = i2;
                        d2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(d2Var22);
                    } else if (e2Var.getType() == e2.z3 && e2Var.Q1()) {
                        e2Var.position = i2;
                        arrayList2.add(e2Var);
                    } else {
                        d2 d2Var23 = new d2();
                        d2Var23.w = e2Var;
                        d2Var23.position = i2;
                        arrayList2.add(d2Var23);
                    }
                    i2++;
                    e2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    if (next != null && next.getType() != e2.i3) {
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
            c.a.t0.b.f.a.d(arrayList2);
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
                        c.a.t0.s.r.v vVar = new c.a.t0.s.r.v();
                        if (vVar.c(colorEgg)) {
                            this.color_eggs.add(vVar);
                        }
                    }
                }
            }
            int i2 = 0;
            if (dataRes.forum != null) {
                this.hasGame = dataRes.forum.has_game.intValue() == 1;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
            }
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                c.a.t0.s.r.y yVar = new c.a.t0.s.r.y();
                this.mActivityHeadData = yVar;
                yVar.e(dataRes.brand_forum_info.head_imgs);
                c.a.u0.e1.d dVar = new c.a.u0.e1.d();
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
                c.a.t0.s.r.y yVar2 = new c.a.t0.s.r.y();
                this.mActivityHeadData = yVar2;
                yVar2.d(dataRes.activityhead, longValue);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !c.a.d.f.p.m.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                c.a.t0.s.r.y yVar3 = new c.a.t0.s.r.y();
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
                c.a.u0.h4.d.f(dataRes.anti.block_pop_info);
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
            if (c.a.t0.b.d.x() && !c.a.t0.b.g.a.f12513e.equals(((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.a, 0)).tab_name)) {
                this.defaultShowTab = c.a.t0.b.g.a.c();
            }
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.f26318c)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.f26318c.get(0);
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
                c.a.t0.s.r.h0 h0Var = new c.a.t0.s.r.h0();
                this.headSdkData = h0Var;
                h0Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                c.a.t0.s.r.i0 i0Var = new c.a.t0.s.r.i0();
                this.recommendBookData = i0Var;
                i0Var.U4(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                c.a.t0.s.r.z zVar = new c.a.t0.s.r.z();
                this.bookInfoData = zVar;
                zVar.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                c.a.t0.s.r.f0 f0Var = new c.a.t0.s.r.f0();
                this.presentInfoData = f0Var;
                f0Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                c.a.t0.s.r.c0 c0Var = new c.a.t0.s.r.c0();
                this.headlineImgInfoData = c0Var;
                c0Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                i iVar = new i();
                this.businessPromot = iVar;
                iVar.p(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                e2 e2Var = new e2();
                this.cardVideoInfo = e2Var;
                e2Var.W3(true);
                this.cardVideoInfo.U3(this.photoLivePos);
                this.cardVideoInfo.J4(this.userMap);
                this.cardVideoInfo.d3(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.h3();
                this.cardVideoInfo.K1 = this.isBrandForum;
                if (this.cardVideoInfo.U() == 0 && j2 != 0) {
                    this.cardVideoInfo.J3(j2);
                }
                this.cardVideoInfo.W2(this.color_eggs);
                this.cardVideoInfo.M3(!this.cardVideoInfo.C2());
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
                gVar.f26169f = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                        e2 e2Var2 = new e2();
                        e2Var2.d3(dataRes.ala_live_insert.ala_live_list.get(i5));
                        e2Var2.K1 = this.isBrandForum;
                        arrayList.add(e2Var2);
                    }
                }
                this.mFrsInsertLiveData.f26168e = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new h();
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                    if (dataRes.ala_stage_list.get(i6) != null) {
                        e2 e2Var3 = new e2();
                        e2Var3.d3(dataRes.ala_stage_list.get(i6));
                        e2Var3.K1 = this.isBrandForum;
                        arrayList2.add(e2Var3);
                    }
                }
                this.mFrsStageLiveData.f26171e = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                t1 t1Var = new t1();
                this.schoolRecommendInfo = t1Var;
                t1Var.V4(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                c.a.t0.s.r.t tVar = new c.a.t0.s.r.t();
                this.carrierEnterData = tVar;
                tVar.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            c.a.u0.l3.j0.a.e().h(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                    e2 e2Var4 = new e2();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        e2Var4.U3(this.mCardShipinPos.get(i7).intValue());
                    }
                    e2Var4.W3(true);
                    e2Var4.d3(dataRes.card_shipin_new.get(i7));
                    e2Var4.K1 = this.isBrandForum;
                    this.mCardShipinNew.add(e2Var4);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                c.a.u0.h1.b bVar = new c.a.u0.h1.b();
                this.mGameRankListData = bVar;
                bVar.e(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                c.a.u0.e1.w wVar = new c.a.u0.e1.w();
                this.userRecommend = wVar;
                wVar.i(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                s sVar = new s();
                this.mFrsVideoActivityData = sVar;
                sVar.a(dataRes.video.video_act);
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
            this.isFrsVideoAutoPlay = dataRes.video_auto_play.intValue() == 1;
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            this.mHotUserRankData = hotUserRankEntry;
            if (hotUserRankEntry != null) {
                ServiceArea.Builder builder2 = new ServiceArea.Builder();
                builder2.picurl = "icon_mask_service_celebrity24";
                builder2.servicename = "本吧红人榜";
                builder2.service_type = "本吧红人榜";
                this.serviceAreaFlutterData.add(DataExt.h(builder2.build(true)));
            }
            this.bazhuExam = dataRes.bazhu_exam_fail;
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new d0();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.h(serviceArea));
                        e0 e0Var = new e0();
                        e0Var.f26152b = serviceArea.picurl;
                        e0Var.f26153c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        e0Var.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            e0Var.f26152b = serviceArea.area_smart_app.avatar;
                            e0Var.f26153c = serviceArea.area_smart_app.name;
                        }
                        e0Var.f26154d = serviceArea.serviceurl;
                        e0Var.f26155e = serviceArea.schema;
                        e0Var.f26159i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String q = c.a.t0.s.j0.b.k().q("frs_service_version_" + this.forum.getName() + e0Var.f26153c, "");
                        if (!TextUtils.isEmpty(q)) {
                            q.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            f0 f0Var2 = new f0();
                            f0Var2.a(serviceArea.area_smart_app);
                            e0Var.f26156f = f0Var2;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            e0Var.f26157g = this.forum.getId();
                        }
                        e0Var.f26158h = i2;
                        i2++;
                        arrayList3.add(e0Var);
                    }
                }
                this.serviceAreaData.a = arrayList3.size();
                this.serviceAreaData.f26148b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
            this.frsMaskPopInfo = dataRes.frsmask_pop_info;
            this.voiceRoomConfig = q0.c(dataRes);
            r0 r0Var = new r0();
            this.voiceRoomData = r0Var;
            r0Var.d(dataRes);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}

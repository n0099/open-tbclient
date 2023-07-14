package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.FriendBotPostConfigData;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ae5;
import com.baidu.tieba.b45;
import com.baidu.tieba.be5;
import com.baidu.tieba.bi5;
import com.baidu.tieba.bv9;
import com.baidu.tieba.ce5;
import com.baidu.tieba.da5;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.dr6;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.gd5;
import com.baidu.tieba.ge5;
import com.baidu.tieba.h29;
import com.baidu.tieba.hd5;
import com.baidu.tieba.id5;
import com.baidu.tieba.ke5;
import com.baidu.tieba.lf5;
import com.baidu.tieba.nba;
import com.baidu.tieba.oe5;
import com.baidu.tieba.pd5;
import com.baidu.tieba.qe5;
import com.baidu.tieba.re5;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.te5;
import com.baidu.tieba.tf5;
import com.baidu.tieba.uh5;
import com.baidu.tieba.ux9;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.we5;
import com.baidu.tieba.x0b;
import com.baidu.tieba.xe5;
import com.baidu.tieba.xi;
import com.baidu.tieba.xw4;
import com.baidu.tieba.yf5;
import com.baidu.tieba.ze5;
import com.baidu.tieba.zg;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.ItemInfo;
import tbclient.VideoRedIcon.RedIcon;
@ModifyClass
/* loaded from: classes4.dex */
public final class TbSingleton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ACCELERATOR_ITEM_ID = -1;
    public static final int DEFAULT_THREAD_HOLD = 200;
    public static final int FRS_PULL_REFRESH_COMPLETE_STATE = 2;
    public static final int FRS_PULL_REFRESH_DOING_STATE = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final String KEY_CHATROOM_MASK_SWITCH = "chatroom_mask_switch";
    public static final int LOGIN_FROM_DEFAULT = -1;
    public static final int LOGIN_FROM_VIDEO_ATTENTION = 1;
    public static final int PB_SUB_COMMENT_NUMBER = 4;
    public static final String TEMP_STRING_KEY_INTEREST_FORUM = "interest_forum";
    public static final int VIDEO_TAB_PB_SUB_COMMENT_NUMBER = 2;
    public static boolean isAppInBackground = false;
    public static boolean isExceptInsertAdDiaShow = false;
    public static int loginFrom = -1;
    public static TbSingleton mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final long THREE_DAY_MILLISECOND;
    public PkgNameAndNodeInfoData acceleratorData;
    public long acceleratorItemId;
    public long activeTimeStamp;
    public gd5 adFloatViewData;
    public long appFirstInstallTime;
    public long appLastUpdateTime;
    public int autoInLiveRoomTimes;
    public String baiduIdForAnti;
    public Calendar calendar;
    public boolean canShowPermDlg;
    public String continuousAccessTips;
    public long currentClickTime;
    public String dayCount;
    public long duXiaoManActivityTimestamp;
    public boolean enableVideoVerticalPreload;
    public Uri firstOpenScheme;
    @Nullable
    public FriendBotPostConfigData friendBotPostConfigData;
    public String fromWhichSearchSource;
    public Map<String, ItemInfo> frsItemInfoCache;
    public String funnySpriteAvatar;
    @Nullable
    public ae5 funnySpriteConfig;
    public String funnySpriteName;
    @Nullable
    public GroupChatDisturbText groupChatDisturbText;
    public String guideTips;
    public boolean hasDownloadEmotion;
    public boolean hasPerformInterestPanelShow;
    public boolean hasPerformedFirstLoginTest;
    public boolean hasShowPermDlg;
    public ce5 hotNotifyConfigData;
    public IconPopData iconPopData;
    public String invokeSource;
    public boolean isAddBanner;
    public boolean isBaiduidCookieSwitch;
    public boolean isBusinessAccount;
    public boolean isCanShowHotSplash;
    public boolean isChatTabPage;
    public boolean isDanmuSwitchOpen;
    public boolean isFirstEnterBigPicPage;
    public boolean isInFrs;
    public boolean isItemTabVisible;
    public boolean isMercatorRequestFromHomePageTabFeedFragment;
    public boolean isMyTabClicked;
    public boolean isNeedJoinChatRoom;
    public boolean isNewUser;
    public boolean isNewUserRedPackageShowed;
    public boolean isPushOrSchemeLog;
    public boolean isRecommendPage;
    public boolean isShowBackLabel;
    public boolean isShowConcernLiveSecondFloor;
    public boolean isShowRecommendLiveSecondFloor;
    public boolean isShowSpriteDialog;
    public boolean isStartStatUploadImmediately;
    public String isSwitchActivity;
    public boolean isUserBan;
    public boolean isVideoChannelRelogin;
    public Boolean isYYLive;
    public HashMap<String, uh5> lastColourHeaderConfigs;
    public long lastResumeTime;
    public LevePopData levePopData;
    public ArrayList<LightEmotionData> lightEmotionInfo;
    public List<AlaLiveInfo> liveFollowSecondFloor;
    public HashMap<Long, String> liveForumMap;
    public List<AlaLiveInfo> liveIndexSecondFloor;
    public final HashMap<String, String> mAcceleratorMap;
    public String mActivityId;
    public int mAdFloatTipsAppLimitCount;
    public int mAdFloatTipsDayLimitCount;
    public id5 mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public pd5 mBearSidConfigData;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public tf5 mChannelConfigModel;
    public int mChatGroupThreadHold;
    public boolean mClipboardDelayTime;
    public HashMap<String, uh5> mColourHeaderConfigs;
    public int mCpuFlopsDur;
    public int mCpuThreshold;
    public boolean mEnableBenchmark;
    public final String mFlutterPageActivity;
    public boolean mForceRefreshHomeRecommend;
    public boolean mFrsContentViewLoadingShow;
    public int mFrsCurTabType;
    public nba mFrsResponseData;
    public boolean mFrsRootViewLoadingShow;
    public boolean mHasAgreeToPlay;
    public Map<Long, Integer> mHasClickRedPot;
    public Map<String, Date> mHasShowFid;
    public Map<Long, Date> mHasShowRedPot;
    public final BroadcastReceiver mHeadSetStateReceiver;
    public be5 mHomeInsertAdData;
    public zh5 mHomeOperateData;
    public int mHomePageStyleAbTest;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public int mIsCutoutScreen;
    public boolean mIsFlutterPluginLoadSuccess;
    public boolean mIsForceLayoutMaintab;
    public boolean mIsInNeedReuseVideoPlayer;
    public boolean mIsJumpFromVideoMiddleView;
    public boolean mIsNeedRemindLiveRoom;
    public String mIsNeedShowCommentThreadId;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
    public boolean mIsOutNeedReuseVideoPlayer;
    public boolean mIsShowVoiceFloat;
    public boolean mIsSplashClick;
    public boolean mIsVideoCardMute;
    public boolean mIsVisitPreviewServer;
    public String mLFUser;
    public String mLFUserTaskId;
    public bi5 mLiveActivityGuide;
    public int mLoopChatroomFrequency;
    public String mLoopRoomMsgId;
    public ke5 mMainTabPopConfig;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public b45 mPbToHomeUpdateData;
    public bv9 mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public HashMap mRoomDraft;
    public String mSampleId;
    public int mSendMsgCountToRemindSubscribe;
    public qe5 mShakeData;
    public re5 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public SmallTailThemeData mSmallTailThemeData;
    public boolean mStartGameClicked;
    public TiebaPlusConfigData mTiebaPlusConfigData;
    public Map<String, Date> mTimeMap;
    public boolean mTipsAutoPlayInVideoChannel;
    public boolean mTipsAutoPlayInVideoMiddle;
    public JSONArray mUbsABTestJsonArray;
    public ux9 mUploadAndClearModule;
    public dr6 mVideoCover;
    public LinkedList<xw4> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public ze5 mWlConfigData;
    public String mWorldCupSponsorFlag;
    public YYLiveConfig mYYLiveConfig;
    public x0b mYYLiveTabConfig;
    public String msgCount;
    public boolean needRefreshForumSquare;
    public JSONObject newGodDataJson;
    public int pageCount;
    public boolean personalizedRecSwitchChanged;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public oe5 pushStrategyConfig;
    public String pushTid;
    public Bundle reloginVideoMiddleBundle;
    public String schemaForStartOtherAppAfterSwanApp;
    public int second;
    public boolean shouldShowHomeLocalCompleteInfoCard;
    public boolean shouldShowLocalChannelPostAnim;
    public boolean showStampMissionDialog;
    public boolean showedInterestGuide;
    public String singleSendMessageTips;
    public int spriteDelayFirst;
    public volatile JSONObject syncJson;
    public yf5 syncModel;
    public HashMap<String, String> tempStrings;
    public boolean triggerInterestPanelYDaysConfig;
    public te5 upgradePopWindowConfig;
    public UserGrowthTaskListData userGrowthTaskListData;
    public UserPendantData userPendantData;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public we5 videoEventsConfig;
    public int videoRedIconInterval;
    public String videoTestType;
    @Nullable
    public xe5 voiceRoomConfig;
    public int worksAddTopicMaxNum;
    public String yyCloudSwitch;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2074071359, "Lcom/baidu/tbadk/TbSingleton;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2074071359, "Lcom/baidu/tbadk/TbSingleton;");
        }
    }

    public boolean isDebugToolMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static class GroupChatDisturbText implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(DebugKt.DEBUG_PROPERTY_VALUE_ON)
        public TitleText canDisturb;
        @SerializedName(DebugKt.DEBUG_PROPERTY_VALUE_OFF)
        public TitleText canNotDisturb;

        /* loaded from: classes4.dex */
        public static class TitleText implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("main_title")
            public String mainTitle;
            @SerializedName("sub_title")
            public String subTitle;

            public TitleText() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String getMainTitle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.mainTitle;
                }
                return (String) invokeV.objValue;
            }

            public String getSubTitle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.subTitle;
                }
                return (String) invokeV.objValue;
            }
        }

        public GroupChatDisturbText() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public TitleText getCanDisturb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.canDisturb;
            }
            return (TitleText) invokeV.objValue;
        }

        public TitleText getCanNotDisturb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.canNotDisturb;
            }
            return (TitleText) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class MsgUpgradeTips {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KEY_SHOW_MESSAGE_NOTIFY_UPGRADE = "key_show_message_notify_upgrade";
        public static boolean sIsMsgTabUpgradeTipsShowing;
        public transient /* synthetic */ FieldHolder $fh;

        public MsgUpgradeTips() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static boolean isMsgTabUpgradeTipsShowing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return sIsMsgTabUpgradeTipsShowing;
            }
            return invokeV.booleanValue;
        }

        public static void markHasShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, null) == null) {
                da5.p().A(KEY_SHOW_MESSAGE_NOTIFY_UPGRADE, false);
                ((lf5) ServiceManager.getService(lf5.a)).a(false);
            }
        }

        public static void onMsgTabClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, null) == null) && sIsMsgTabUpgradeTipsShowing) {
                markHasShown();
                sIsMsgTabUpgradeTipsShowing = false;
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GUIDE_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }

        public static boolean shouldShow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return da5.p().l(KEY_SHOW_MESSAGE_NOTIFY_UPGRADE, true);
            }
            return invokeV.booleanValue;
        }

        public static void setIsMsgTabUpgradeTipsShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
                sIsMsgTabUpgradeTipsShowing = z;
            }
        }
    }

    public TbSingleton() {
        boolean z;
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
        this.THREE_DAY_MILLISECOND = 259200000L;
        this.pushDialogLoopTime = 3600000L;
        this.pushDialogShowTime = 300000L;
        this.lastResumeTime = 0L;
        this.canShowPermDlg = false;
        this.hasShowPermDlg = false;
        this.isNewUser = false;
        this.mHasAgreeToPlay = false;
        this.mTipsAutoPlayInVideoChannel = false;
        this.mTipsAutoPlayInVideoMiddle = false;
        this.mShakeData = null;
        this.invokeSource = "";
        this.isBusinessAccount = false;
        this.mFrsRootViewLoadingShow = false;
        this.mFrsContentViewLoadingShow = false;
        this.mIsVideoCardMute = true;
        this.mEnableBenchmark = false;
        this.mCpuFlopsDur = -1;
        this.mCpuThreshold = Integer.MAX_VALUE;
        this.mAnimFpsSyncThreshold = 0;
        this.mIsNotchScreen = -1;
        this.mIsCutoutScreen = -1;
        this.mStartGameClicked = false;
        this.mIsVisitPreviewServer = false;
        this.hasDownloadEmotion = false;
        this.mHomePageStyleAbTest = 0;
        this.liveForumMap = new HashMap<>();
        this.mShowVivoBadge = false;
        this.mCanWebViewActivityShowProgress = true;
        this.isInFrs = false;
        this.appFirstInstallTime = 0L;
        this.appLastUpdateTime = 0L;
        this.activeTimeStamp = 0L;
        this.isAddBanner = false;
        this.mIsInNeedReuseVideoPlayer = false;
        this.mIsOutNeedReuseVideoPlayer = false;
        this.mVideoCover = null;
        this.mIsJumpFromVideoMiddleView = false;
        this.mBaseActivity = "BaseActivity";
        this.mBaseFragmentActivity = BaseFragmentActivity.TAG;
        this.mFlutterPageActivity = "FlutterPageActivity";
        this.isNewUserRedPackageShowed = false;
        this.hasPerformedFirstLoginTest = false;
        this.needRefreshForumSquare = false;
        this.worksAddTopicMaxNum = 3;
        this.showedInterestGuide = false;
        this.mUbsABTestJsonArray = null;
        this.enableVideoVerticalPreload = false;
        this.fromWhichSearchSource = "";
        this.isItemTabVisible = false;
        this.isDanmuSwitchOpen = true;
        this.isMercatorRequestFromHomePageTabFeedFragment = false;
        this.shouldShowHomeLocalCompleteInfoCard = true;
        this.mAcceleratorMap = new HashMap<>();
        this.isStartStatUploadImmediately = false;
        this.shouldShowLocalChannelPostAnim = true;
        this.acceleratorItemId = -1L;
        this.acceleratorData = null;
        this.mHomeInsertAdData = null;
        this.showStampMissionDialog = false;
        this.isCanShowHotSplash = false;
        this.triggerInterestPanelYDaysConfig = false;
        this.hasPerformInterestPanelShow = false;
        this.tempStrings = new HashMap<>();
        this.isBaiduidCookieSwitch = false;
        this.mIsFlutterPluginLoadSuccess = false;
        this.mIsNeedRemindLiveRoom = false;
        this.isUserBan = false;
        this.mIsForceLayoutMaintab = false;
        this.duXiaoManActivityTimestamp = 0L;
        this.autoInLiveRoomTimes = 0;
        this.levePopData = null;
        this.iconPopData = null;
        this.mHasShowFid = new HashMap();
        this.isPushOrSchemeLog = false;
        this.mHasShowRedPot = new HashMap();
        this.mHasClickRedPot = new HashMap();
        this.isChatTabPage = false;
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
        this.isShowRecommendLiveSecondFloor = true;
        this.isShowConcernLiveSecondFloor = true;
        this.lightEmotionInfo = new ArrayList<>();
        this.mFrsResponseData = null;
        this.isFirstEnterBigPicPage = true;
        this.frsItemInfoCache = new HashMap();
        this.mRoomDraft = new HashMap();
        this.isNeedJoinChatRoom = false;
        this.mTimeMap = new HashMap();
        this.pageCount = 0;
        this.mHeadSetStateReceiver = new BroadcastReceiver(this) { // from class: com.baidu.tbadk.TbSingleton.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbSingleton this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                    boolean z2 = false;
                    if (intent.getIntExtra("state", 0) != 0 && intent.getIntExtra("state", 0) == 1) {
                        z2 = true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z2)));
                }
            }
        };
        this.personalizedRecSwitchChanged = false;
        setIsOpenTrack(da5.p().l("key_is_open_track", false));
        setProfileGameCenterKey(da5.p().w("profile_swan_app_key", ""));
        setHomePageStyleAbTest(da5.p().q("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(da5.p().w("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(da5.p().w("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(da5.p().w("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(da5.p().l("audit_package_switch", false));
        setBaiduidCookieSwitch(da5.p().l("key_baidu_id_cookie_switch", false));
        setUbsSampleId(da5.p().w("key_ubs_sample_id", ""));
        if (da5.p().q("key_is_show_shoubai_dynamic_guide", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        setShowShoubaiDynamicGuide(z);
        setClipboardDelayTime(da5.p().l("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        setDanmuSwitchOpen(da5.p().l("key_video_danmu_switch", true));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        zg.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbSingleton this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.registerScreenSizeChangeTask();
                }
            }
        });
        this.mShowVivoBadge = da5.p().l("key_show_vivo_badge", false);
        this.mChannelConfigModel = new tf5();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = da5.p().l("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = da5.p().l("has_performed_first_login_test", false);
        this.yyCloudSwitch = da5.p().w("key_yy_cloud_switch", null);
        this.isStartStatUploadImmediately = da5.p().q("key_switch_immediately_upload", 0) == 1;
        SpeedStats.getInstance().setSid(this.mSampleId);
        setWorldCupSponsorFlag(da5.p().w("world_cup_sponsor_flag", ""));
        String w = da5.p().w("key_home_color_header_config", "");
        if (!TextUtils.isEmpty(w)) {
            try {
                setColourHeaderConfig(uh5.p(new JSONObject(w)));
            } catch (JSONException unused) {
            }
        }
    }

    private String getAdStrWithLimit() {
        InterceptResult invokeV;
        id5 id5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (StringHelper.isTaday(da5.p().r("key_pb_falling_ad_feedback_click_time", 0L)) || (id5Var = this.mAdVertiSementConfigData) == null) {
                return "";
            }
            return id5Var.c();
        }
        return (String) invokeV.objValue;
    }

    private void getAppInstallUpdateTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0);
                this.appFirstInstallTime = packageInfo.firstInstallTime;
                this.appLastUpdateTime = packageInfo.lastUpdateTime;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean getExceptInsertAdDiaShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return isExceptInsertAdDiaShow;
        }
        return invokeV.booleanValue;
    }

    public static TbSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (mInstance == null) {
                synchronized (TbSingleton.class) {
                    if (mInstance == null) {
                        mInstance = new TbSingleton();
                    }
                }
            }
            return mInstance;
        }
        return (TbSingleton) invokeV.objValue;
    }

    private void getYYSwitchStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.yyCloudSwitch == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            this.yyCloudSwitch = "";
        }
    }

    public void clearVideoRecord() {
        LinkedList<xw4> linkedList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (linkedList = this.mVideoWatchTimeRecord) != null) {
            linkedList.clear();
        }
    }

    public long getActiveTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.activeTimeStamp == 0) {
                this.activeTimeStamp = da5.p().r("key_active_timestamp", 0L);
            }
            return this.activeTimeStamp;
        }
        return invokeV.longValue;
    }

    public String getActivityId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mActivityId;
        }
        return (String) invokeV.objValue;
    }

    public String getAdVertiComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getAdStrWithLimit();
        }
        return (String) invokeV.objValue;
    }

    public id5 getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAdVertiSementConfigData;
        }
        return (id5) invokeV.objValue;
    }

    public int getAnimFpsSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mAnimFpsSyncThreshold;
        }
        return invokeV.intValue;
    }

    public long getAppFirstInstallTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.appFirstInstallTime == 0) {
                getAppInstallUpdateTime();
            }
            return this.appFirstInstallTime;
        }
        return invokeV.longValue;
    }

    public long getAppLastUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.appLastUpdateTime == 0) {
                getAppInstallUpdateTime();
            }
            return this.appLastUpdateTime;
        }
        return invokeV.longValue;
    }

    public String getBaiduIdForAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.baiduIdForAnti == null) {
                this.baiduIdForAnti = da5.p().w("key_baiduid_for_anti", null);
            }
            return this.baiduIdForAnti;
        }
        return (String) invokeV.objValue;
    }

    public boolean getBaiduidCookieSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isBaiduidCookieSwitch;
        }
        return invokeV.booleanValue;
    }

    public String getBannerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mBannerText;
        }
        return (String) invokeV.objValue;
    }

    public tf5 getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mChannelConfigModel;
        }
        return (tf5) invokeV.objValue;
    }

    public int getChatGroupThreadHold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = this.mChatGroupThreadHold;
            if (i <= 0) {
                return 200;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mClipboardDelayTime;
        }
        return invokeV.booleanValue;
    }

    public HashMap<String, uh5> getColourHeaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mColourHeaderConfigs;
        }
        return (HashMap) invokeV.objValue;
    }

    public String getContinuousAccessTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.continuousAccessTips;
        }
        return (String) invokeV.objValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = da5.p().q("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mCpuThreshold;
        }
        return invokeV.intValue;
    }

    public long getCurrentClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.currentClickTime;
        }
        return invokeV.longValue;
    }

    public String getDayCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.dayCount;
        }
        return (String) invokeV.objValue;
    }

    public long getDuXiaoManActivityTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.duXiaoManActivityTimestamp == 0) {
                this.duXiaoManActivityTimestamp = da5.p().r("key_doxiaoman_activity_timestamp", 0L);
            }
            return this.duXiaoManActivityTimestamp;
        }
        return invokeV.longValue;
    }

    public Uri getFirstOpenScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.firstOpenScheme;
        }
        return (Uri) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mForceRefreshHomeRecommend;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public FriendBotPostConfigData getFriendBotPostConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.friendBotPostConfigData;
        }
        return (FriendBotPostConfigData) invokeV.objValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.fromWhichSearchSource;
        }
        return (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mFrsCurTabType;
        }
        return invokeV.intValue;
    }

    public Map<String, ItemInfo> getFrsItemInfoCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.frsItemInfoCache;
        }
        return (Map) invokeV.objValue;
    }

    public nba getFrsResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mFrsResponseData;
        }
        return (nba) invokeV.objValue;
    }

    public String getFunnySpriteAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.funnySpriteAvatar;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public ae5 getFunnySpriteConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.funnySpriteConfig;
        }
        return (ae5) invokeV.objValue;
    }

    public String getFunnySpriteName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.funnySpriteName;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public GroupChatDisturbText getGroupChatDisturbText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.groupChatDisturbText;
        }
        return (GroupChatDisturbText) invokeV.objValue;
    }

    public String getGuideTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.guideTips;
        }
        return (String) invokeV.objValue;
    }

    public Map<Long, Integer> getHasClickRedPot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mHasClickRedPot;
        }
        return (Map) invokeV.objValue;
    }

    public Map<Long, Date> getHasShowRedPot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mHasShowRedPot;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, Date> getHasShowTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mHasShowFid;
        }
        return (Map) invokeV.objValue;
    }

    public hd5 getHomeAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            gd5 gd5Var = this.adFloatViewData;
            if (gd5Var != null) {
                return gd5Var.a();
            }
            return null;
        }
        return (hd5) invokeV.objValue;
    }

    public be5 getHomeInsertAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mHomeInsertAdData;
        }
        return (be5) invokeV.objValue;
    }

    public zh5 getHomeOperateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mHomeOperateData;
        }
        return (zh5) invokeV.objValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mHomePageStyleAbTest;
        }
        return invokeV.intValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mHostWhiteList;
        }
        return (List) invokeV.objValue;
    }

    public ce5 getHotNotifyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.hotNotifyConfigData;
        }
        return (ce5) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mHotSearch;
        }
        return (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.invokeSource;
        }
        return (String) invokeV.objValue;
    }

    public Boolean getIsJumpFromVideoMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return Boolean.valueOf(this.mIsJumpFromVideoMiddleView);
        }
        return (Boolean) invokeV.objValue;
    }

    public boolean getIsNeedRemindLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.mIsNeedRemindLiveRoom;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.mIsInNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public String getIsNeedShowPbCommentThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mIsNeedShowCommentThreadId;
        }
        return (String) invokeV.objValue;
    }

    public boolean getIsOutNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mIsOutNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsPushOrSchemeLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.isPushOrSchemeLog;
        }
        return invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mLFUser;
        }
        return (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mLFUserTaskId;
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, uh5> getLastColourHeaderConfigs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.lastColourHeaderConfigs;
        }
        return (HashMap) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = da5.p().r("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public ArrayList<LightEmotionData> getLightEmotionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.lightEmotionInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveFollowSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.liveFollowSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveIndexSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.liveIndexSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public int getLoopChatroomFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mLoopChatroomFrequency;
        }
        return invokeV.intValue;
    }

    public String getLoopMsgRoomMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.mLoopRoomMsgId;
        }
        return (String) invokeV.objValue;
    }

    public ke5 getMainTabPopConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.mMainTabPopConfig;
        }
        return (ke5) invokeV.objValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mMercatorData;
        }
        return (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mMissionEntranceIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mMissionEntranceObjSource;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mMissionEntranceUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            ux9 ux9Var = this.mUploadAndClearModule;
            if (ux9Var == null) {
                return null;
            }
            return ux9Var.a();
        }
        return (String) invokeV.objValue;
    }

    public String getMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.msgCount;
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.mNewGodData;
        }
        return (NewGodData) invokeV.objValue;
    }

    public JSONObject getNewGodDataJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.newGodDataJson;
        }
        return (JSONObject) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.mNewUserRedPackageData;
        }
        return (NewUserRedPackageData) invokeV.objValue;
    }

    public int getPageCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.pageCount;
        }
        return invokeV.intValue;
    }

    public hd5 getPbAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            gd5 gd5Var = this.adFloatViewData;
            if (gd5Var != null) {
                return gd5Var.b();
            }
            return null;
        }
        return (hd5) invokeV.objValue;
    }

    public b45 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.mPbToHomeUpdateData;
        }
        return (b45) invokeV.objValue;
    }

    public bv9 getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mPcdnConfigData;
        }
        return (bv9) invokeV.objValue;
    }

    public int getPersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return da5.p().q("key_personalized_rec_switch", 1);
        }
        return invokeV.intValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mProfileGameCenterKey;
        }
        return (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1=沙盒环境，2=小流量环境", type = Constants.SHORT_PING_CMD_TYPE)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.mPubEnvValue;
        }
        return (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.pushDialogLoopTime;
        }
        return invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.pushDialogShowTime;
        }
        return invokeV.longValue;
    }

    @NonNull
    public oe5 getPushStrategyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            oe5 oe5Var = this.pushStrategyConfig;
            if (oe5Var != null) {
                return oe5Var;
            }
            return oe5.d;
        }
        return (oe5) invokeV.objValue;
    }

    public String getPushTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.pushTid;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getReloginVideoMiddleBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.reloginVideoMiddleBundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.mSampleId;
        }
        return (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.schemaForStartOtherAppAfterSwanApp;
        }
        return (String) invokeV.objValue;
    }

    public int getSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.second;
        }
        return invokeV.intValue;
    }

    public int getSendMsgNumToRemindSubscribe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mSendMsgCountToRemindSubscribe;
        }
        return invokeV.intValue;
    }

    public qe5 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.mShakeData;
        }
        return (qe5) invokeV.objValue;
    }

    public re5 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.mSharePanelConfData;
        }
        return (re5) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.mSharePanelText;
        }
        return (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.showedInterestGuide;
        }
        return invokeV.booleanValue;
    }

    public String getSingleSendMessageTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.singleSendMessageTips;
        }
        return (String) invokeV.objValue;
    }

    @Modify(description = "精灵-首次请求延迟配置(毫秒)")
    public int getSkipDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.spriteDelayFirst == 0) {
                this.spriteDelayFirst = da5.p().q("key_sprite_skip_anim_req_delay", 1000);
            }
            return this.spriteDelayFirst;
        }
        return invokeV.intValue;
    }

    public JSONObject getSyncJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.syncJson;
        }
        return (JSONObject) invokeV.objValue;
    }

    public yf5 getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.syncModel;
        }
        return (yf5) invokeV.objValue;
    }

    public TiebaPlusConfigData getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.mTiebaPlusConfigData;
        }
        return (TiebaPlusConfigData) invokeV.objValue;
    }

    public Map<String, Date> getTimeMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.mTimeMap == null) {
                this.mTimeMap = new HashMap();
            }
            return this.mTimeMap;
        }
        return (Map) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.mUbsABTestJsonArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public te5 getUpgradePopWindowConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            te5 te5Var = this.upgradePopWindowConfig;
            if (te5Var != null) {
                return te5Var;
            }
            return te5.i;
        }
        return (te5) invokeV.objValue;
    }

    public UserGrowthTaskListData getUserGrowthTaskListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.userGrowthTaskListData == null) {
                int q = da5.p().q("key_person_growth_switch", 0);
                UserGrowthTaskListData userGrowthTaskListData = new UserGrowthTaskListData();
                this.userGrowthTaskListData = userGrowthTaskListData;
                userGrowthTaskListData.setGrowthSwitch(q);
            }
            return this.userGrowthTaskListData;
        }
        return (UserGrowthTaskListData) invokeV.objValue;
    }

    @Nullable
    public UserPendantData getUserPendantData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.userPendantData;
        }
        return (UserPendantData) invokeV.objValue;
    }

    public SmallTailThemeData getUserSmallTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.mSmallTailThemeData;
        }
        return (SmallTailThemeData) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.videoChannelAttentionRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.videoChannelRecommendRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public dr6 getVideoCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.mVideoCover;
        }
        return (dr6) invokeV.objValue;
    }

    public we5 getVideoEventsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.videoEventsConfig;
        }
        return (we5) invokeV.objValue;
    }

    public LinkedList<xw4> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.mVideoWatchTimeRecord;
        }
        return (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.videoRedIconInterval;
        }
        return invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.videoTestType;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public xe5 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            xe5 xe5Var = this.voiceRoomConfig;
            if (xe5Var != null) {
                return xe5Var;
            }
            return xe5.a;
        }
        return (xe5) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.mWalletSignLink;
        }
        return (String) invokeV.objValue;
    }

    public ze5 getWlConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.mWlConfigData;
        }
        return (ze5) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.worksAddTopicMaxNum;
        }
        return invokeV.intValue;
    }

    public String getWorldCupSponsorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.mWorldCupSponsorFlag;
        }
        return (String) invokeV.objValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.mYYLiveConfig;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public x0b getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.mYYLiveTabConfig;
        }
        return (x0b) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.mHasAgreeToPlay;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.hasDownloadEmotion;
        }
        return invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.hasPerformedFirstLoginTest;
        }
        return invokeV.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.mIsAuditPackageSwitchOn;
        }
        return invokeV.booleanValue;
    }

    public boolean isBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.isBusinessAccount;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.mCanWebViewActivityShowProgress;
        }
        return invokeV.booleanValue;
    }

    public boolean isChatTabPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.isChatTabPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            ux9 ux9Var = this.mUploadAndClearModule;
            if (ux9Var == null) {
                return false;
            }
            return ux9Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isDanmuSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.isDanmuSwitchOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.mEnableBenchmark;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.enableVideoVerticalPreload;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstEnterBigPicPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.isFirstEnterBigPicPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlutterPluginLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            return this.mIsFlutterPluginLoadSuccess;
        }
        return invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            if (!this.mFrsRootViewLoadingShow && !this.mFrsContentViewLoadingShow) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIsOpenTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.mIsOpenTrack;
        }
        return invokeV.booleanValue;
    }

    public boolean isMercatorRequestFromHomePageTabFeedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.isMercatorRequestFromHomePageTabFeedFragment;
        }
        return invokeV.booleanValue;
    }

    public boolean isMyTabClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.isMyTabClicked;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedJoinChatRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.isNeedJoinChatRoom;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.isNewUser;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.isNewUserRedPackageShowed;
        }
        return invokeV.booleanValue;
    }

    public boolean isPbPreloadSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            if (SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRecommendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.isRecommendPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isShouldShowHomeLocalCompleteInfoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.shouldShowHomeLocalCompleteInfoCard;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowConcernLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            return this.isShowConcernLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRecommendLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return this.isShowRecommendLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return this.mShowShoubaiDynamicGuide;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            getYYSwitchStatus();
            if (!StringHelper.equals(this.yyCloudSwitch, "yy") && getSyncYYSwitch()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVivoBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.mShowVivoBadge;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVoiceFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return this.mIsShowVoiceFloat;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return da5.p().l("local_slide_animation__switch", false);
        }
        return invokeV.booleanValue;
    }

    public boolean isSplashShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !LogoActivityConfig.IS_HOT_SPLASH_SHOW) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.mTipsAutoPlayInVideoChannel;
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            return this.mTipsAutoPlayInVideoMiddle;
        }
        return invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            ux9 ux9Var = this.mUploadAndClearModule;
            if (ux9Var == null) {
                return false;
            }
            return ux9Var.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isUserBan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return this.isUserBan;
        }
        return invokeV.booleanValue;
    }

    public boolean isUserGrowthOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (getUserGrowthTaskListData() == null || getUserGrowthTaskListData().getGrowthSwitch() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.mIsVideoCardMute;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoChannelRelogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.isVideoChannelRelogin;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = Constants.SHORT_PING_CMD_TYPE)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.mIsVisitPreviewServer;
        }
        return invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy");
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            zg.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TbSingleton this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CustomMessageTask customMessageTask = new CustomMessageTask(2921414, new CustomMessageTask.CustomRunnable<Object>(this) { // from class: com.baidu.tbadk.TbSingleton.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, customMessage)) == null) {
                                    return new CustomResponsedMessage<>(2921414);
                                }
                                return (CustomResponsedMessage) invokeL.objValue;
                            }
                        });
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                        MessageManager.getInstance().registerTask(customMessageTask);
                    }
                }
            });
        }
    }

    public void saveHomeRecommendItemClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            da5.p().H("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048761, this) == null) && getActiveTimeStamp() == 0) {
            da5.p().H("key_active_timestamp", System.currentTimeMillis());
        }
    }

    private UserGrowthTaskListData.UserGrowthTaskData getUserGrowthTaskData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (getUserGrowthTaskListData() == null) {
                return null;
            }
            if (getUserGrowthTaskListData().getNoviceTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData : getUserGrowthTaskListData().getNoviceTask()) {
                    if (str.equals(userGrowthTaskData.getActType())) {
                        return userGrowthTaskData;
                    }
                }
            }
            if (getUserGrowthTaskListData().getDailyTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData2 : getUserGrowthTaskListData().getDailyTask()) {
                    if (str.equals(userGrowthTaskData2.getActType())) {
                        return userGrowthTaskData2;
                    }
                }
            }
            if (getUserGrowthTaskListData().getIconTask() != null) {
                for (UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData3 : getUserGrowthTaskListData().getIconTask()) {
                    if (str.equals(userGrowthTaskData3.getActType())) {
                        return userGrowthTaskData3;
                    }
                }
            }
            return null;
        }
        return (UserGrowthTaskListData.UserGrowthTaskData) invokeL.objValue;
    }

    private void initBenchmarkData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                setCpuThreshold(Integer.MAX_VALUE);
                setAnimAverageFpsThreshold(0);
                setEnableBenchmark(true);
                setAnimComputedFps("anim_switch_trans_frs", -1);
                setAnimAvgFps("anim_switch_trans_frs", 0);
                setAnimAvgFpsCount("anim_switch_trans_frs", 0);
                setAnimComputedFps("anim_switch_sendthread_maintab", -1);
                setAnimAvgFps("anim_switch_sendthread_maintab", 0);
                setAnimAvgFpsCount("anim_switch_sendthread_maintab", 0);
                setAnimComputedFps("anim_switch_slide", -1);
                setAnimAvgFps("anim_switch_slide", 0);
                setAnimAvgFpsCount("anim_switch_slide", 0);
                return;
            }
            this.mEnableBenchmark = da5.p().l("enable_benchmark", true);
            this.mCpuThreshold = da5.p().q("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = da5.p().q("anim_avg_fps_threshold", 0);
        }
    }

    public IconPopData getIconPopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            da5 p = da5.p();
            String w = p.w("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(w)) {
                try {
                    this.iconPopData = (IconPopData) DataExt.toEntity(w, IconPopData.class);
                } catch (Exception e) {
                    h29 defaultLog = DefaultLog.getInstance();
                    defaultLog.b(DataExt.GSON_FORMAT_LOG, "format icon pop data error : " + e.getMessage() + "  json: " + w);
                    e.printStackTrace();
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw e;
                    }
                }
            }
            if (this.iconPopData == null) {
                this.iconPopData = new IconPopData();
            }
            return this.iconPopData;
        }
        return (IconPopData) invokeV.objValue;
    }

    public LevePopData getLevePopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            da5 p = da5.p();
            String w = p.w("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(w)) {
                try {
                    this.levePopData = (LevePopData) DataExt.toEntity(w, LevePopData.class);
                } catch (Exception e) {
                    h29 defaultLog = DefaultLog.getInstance();
                    defaultLog.b(DataExt.GSON_FORMAT_LOG, "format level pop data error : " + e.getMessage() + "  json: " + w);
                    e.printStackTrace();
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        throw e;
                    }
                }
            }
            if (this.levePopData == null) {
                this.levePopData = new LevePopData();
            }
            return this.levePopData;
        }
        return (LevePopData) invokeV.objValue;
    }

    public static void setExceptInsertAdDiaShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            isExceptInsertAdDiaShow = z;
        }
    }

    private void setUbsSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public boolean checkLiveForumByFid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j)));
        }
        return invokeJ.booleanValue;
    }

    public String getAcceleratorServer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.mAcceleratorMap.containsKey(str)) {
                return this.mAcceleratorMap.get(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public int getAnimComputedFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (xi.isEmpty(str)) {
                return -1;
            }
            return da5.p().q(str, -1);
        }
        return invokeL.intValue;
    }

    @Nullable
    public String getRoomDraft(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, l)) == null) {
            HashMap hashMap = this.mRoomDraft;
            if (hashMap != null && (hashMap.get(l) instanceof String)) {
                return (String) this.mRoomDraft.get(l);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String getTempString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, str)) == null) {
            return this.tempStrings.get(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean isAnimFpsComputed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, str)) == null) {
            if (xi.isEmpty(str) || getAnimComputedFps(str) < 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, activity)) == null) {
            if (this.mIsCutoutScreen < 0) {
                this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
            }
            if (this.mIsCutoutScreen == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048729, this, activity)) == null) {
            if (this.mIsNotchScreen < 0) {
                this.mIsNotchScreen = UtilHelper.isNotchScreen(activity) ? 1 : 0;
            }
            if (this.mIsNotchScreen == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isUserGrowthTaskCompleted(String str) {
        InterceptResult invokeL;
        UserGrowthTaskListData.UserGrowthTaskData userGrowthTaskData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, str)) == null) {
            if (StringUtils.isNull(str) || !isUserGrowthOpen() || (userGrowthTaskData = getUserGrowthTaskData(str)) == null || userGrowthTaskData.getDotaskStatus() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void parseGroupChatDisturbText(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, jSONObject) == null) {
            try {
                String optString = jSONObject.optString(KEY_CHATROOM_MASK_SWITCH);
                if (!TextUtils.isEmpty(optString)) {
                    this.groupChatDisturbText = (GroupChatDisturbText) DataExt.toEntity(optString, GroupChatDisturbText.class);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void removeAcceleratorServer(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, str) == null) && this.mAcceleratorMap.containsKey(str)) {
            this.mAcceleratorMap.remove(str);
        }
    }

    public void removeTempString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, str) == null) {
            this.tempStrings.remove(str);
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, gd5Var) == null) {
            this.adFloatViewData = gd5Var;
        }
    }

    public void setAdVertiSementData(id5 id5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, id5Var) == null) {
            this.mAdVertiSementConfigData = id5Var;
        }
    }

    public void setAnimAverageFpsThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048765, this, i) == null) {
            this.mAnimFpsSyncThreshold = i;
            da5.p().F("anim_avg_fps_threshold", i);
        }
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048770, this, str) == null) && da5.p().w("key_baiduid_for_anti", null) == null) {
            da5.p().J("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBaiduidCookieSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048771, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z) == null) {
            this.isBusinessAccount = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048776, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(tf5 tf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, tf5Var) == null) {
            this.mChannelConfigModel = tf5Var;
        }
    }

    public void setChatGroupThreadHold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048778, this, i) == null) {
            this.mChatGroupThreadHold = i;
        }
    }

    public void setChatTabPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z) == null) {
            this.isChatTabPage = z;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setColourHeaderConfig(HashMap<String, uh5> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, hashMap) == null) {
            this.mColourHeaderConfigs = hashMap;
        }
    }

    public void setContinuousAccessTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, str) == null) {
            this.continuousAccessTips = str;
        }
    }

    public void setCpuFlopsDuration(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048783, this, i) != null) || i < 0) {
            return;
        }
        this.mCpuFlopsDur = i;
        da5.p().F("cpu_flops_dura", i);
    }

    public void setCpuThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048784, this, i) == null) {
            this.mCpuThreshold = i;
            da5.p().F("cpu_flops_dura_threshold", i);
        }
    }

    public void setCurrentClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048785, this, j) == null) {
            this.currentClickTime = j;
        }
    }

    public void setDanmuSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048786, this, z) == null) {
            this.isDanmuSwitchOpen = z;
            da5.p().A("key_video_danmu_switch", z);
        }
    }

    public void setDayCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, str) == null) {
            this.dayCount = str;
        }
    }

    public void setDuXiaoManActivityTimestamp(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048788, this, j) == null) && j != this.duXiaoManActivityTimestamp) {
            this.duXiaoManActivityTimestamp = j;
            da5.p().H("key_doxiaoman_activity_timestamp", j);
        }
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z) == null) {
            this.mEnableBenchmark = z;
            da5.p().A("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048790, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setFirstEnterBigPicPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048791, this, z) == null) {
            this.isFirstEnterBigPicPage = z;
        }
    }

    public void setFirstOpenScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048792, this, uri) == null) {
            this.firstOpenScheme = uri;
        }
    }

    public void setFlutterPluginLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
            this.mIsFlutterPluginLoadSuccess = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048794, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFriendBotPostConfigData(@Nullable FriendBotPostConfigData friendBotPostConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, friendBotPostConfigData) == null) {
            this.friendBotPostConfigData = friendBotPostConfigData;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048797, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048798, this, i) == null) {
            this.mFrsCurTabType = i;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setFunnySpriteAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, str) == null) {
            this.funnySpriteAvatar = str;
        }
    }

    public void setFunnySpriteConfig(@NonNull ae5 ae5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, ae5Var) == null) {
            this.funnySpriteConfig = ae5Var;
        }
    }

    public void setFunnySpriteName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, str) == null) {
            this.funnySpriteName = str;
        }
    }

    public void setGuideTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, str) == null) {
            this.guideTips = str;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048805, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasClickRedPot(Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, map) == null) {
            this.mHasClickRedPot = map;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048807, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048808, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            da5.p().A("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048809, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHasShowRedPot(Map<Long, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, map) == null) {
            this.mHasShowRedPot = map;
        }
    }

    public void setHasShowTip(Map<String, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, map) == null) {
            this.mHasShowFid = map;
        }
    }

    public void setHomeInsertAdData(be5 be5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, be5Var) == null) {
            this.mHomeInsertAdData = be5Var;
        }
    }

    public void setHomeOperateData(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, zh5Var) == null) {
            this.mHomeOperateData = zh5Var;
        }
    }

    public void setHomePageStyleAbTest(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048814, this, i) == null) {
            this.mHomePageStyleAbTest = i;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotNotifyConfig(ce5 ce5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048816, this, ce5Var) == null) {
            this.hotNotifyConfigData = ce5Var;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setIconPopData(IconPopData iconPopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, iconPopData) == null) {
            this.iconPopData = iconPopData;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048819, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsJumpFromVideoMiddleView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048820, this, z) == null) {
            this.mIsJumpFromVideoMiddleView = z;
        }
    }

    public void setIsNeedRemindLiveRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048821, this, z) == null) {
            this.mIsNeedRemindLiveRoom = z;
        }
    }

    public void setIsNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048822, this, z) == null) {
            this.mIsInNeedReuseVideoPlayer = z;
        }
    }

    public void setIsNeedShowPbCommentThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.mIsNeedShowCommentThreadId = str;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048824, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsOutNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048825, this, z) == null) {
            this.mIsOutNeedReuseVideoPlayer = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048826, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048828, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastColourHeaderConfigs(HashMap<String, uh5> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048829, this, hashMap) == null) {
            this.lastColourHeaderConfigs = hashMap;
        }
    }

    public void setLastResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048830, this, j) == null) {
            this.lastResumeTime = j;
        }
    }

    public void setLevePopData(LevePopData levePopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048831, this, levePopData) == null) {
            this.levePopData = levePopData;
        }
    }

    public void setLightEmotionInfo(ArrayList<LightEmotionData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048832, this, arrayList) == null) {
            this.lightEmotionInfo.clear();
            this.lightEmotionInfo.addAll(arrayList);
        }
    }

    public void setLiveFollowSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048833, this, list) == null) {
            this.liveFollowSecondFloor.clear();
            this.liveFollowSecondFloor.addAll(list);
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048834, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setLiveIndexSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048835, this, list) == null) {
            this.liveIndexSecondFloor.clear();
            this.liveIndexSecondFloor.addAll(list);
        }
    }

    public void setLoopChatroomFrequency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048836, this, i) == null) {
            this.mLoopChatroomFrequency = i;
        }
    }

    public void setLoopMsgRoomMsgId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048837, this, str) == null) {
            this.mLoopRoomMsgId = str;
        }
    }

    public void setMainTabPopConfig(ke5 ke5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, ke5Var) == null) {
            this.mMainTabPopConfig = ke5Var;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMercatorRequestFromHomePageTabFeedFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048840, this, z) == null) {
            this.isMercatorRequestFromHomePageTabFeedFragment = z;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048841, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048843, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setMsgCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, str) == null) {
            this.msgCount = str;
        }
    }

    public void setMyTabClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048845, this, z) == null) {
            this.isMyTabClicked = z;
        }
    }

    public void setNeedJoinChatRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048846, this, z) == null) {
            this.isNeedJoinChatRoom = z;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048847, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewGodDataJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048848, this, jSONObject) == null) {
            this.newGodDataJson = jSONObject;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048849, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048851, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            da5.p().A("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPageCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048852, this, i) == null) {
            this.pageCount = i;
        }
    }

    public void setPbToHomeUpdateData(b45 b45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048853, this, b45Var) == null) {
            this.mPbToHomeUpdateData = b45Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new bv9();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048855, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048857, this, j) == null) {
            this.pushDialogLoopTime = j;
        }
    }

    public void setPushDialogShowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048858, this, j) == null) {
            this.pushDialogShowTime = j;
        }
    }

    public void setPushOrSchemeLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048859, this, z) == null) {
            this.isPushOrSchemeLog = z;
        }
    }

    public void setPushStrategyConfig(oe5 oe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048860, this, oe5Var) == null) {
            this.pushStrategyConfig = oe5Var;
        }
    }

    public void setPushTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, str) == null) {
            this.pushTid = str;
        }
    }

    public void setReloginVideoMiddleBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, bundle) == null) {
            this.reloginVideoMiddleBundle = bundle;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048864, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048865, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setSecond(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048866, this, i) == null) {
            this.second = i;
        }
    }

    public void setSendMsgCountToRemindSubscribe(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048867, this, i) == null) {
            this.mSendMsgCountToRemindSubscribe = i;
        }
    }

    public void setShakeData(qe5 qe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048868, this, qe5Var) == null) {
            this.mShakeData = qe5Var;
        }
    }

    public void setSharePanelConfData(re5 re5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048869, this, re5Var) == null) {
            this.mSharePanelConfData = re5Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048870, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShouldShowHomeLocalCompleteInfoCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048871, this, z) == null) {
            this.shouldShowHomeLocalCompleteInfoCard = z;
        }
    }

    public void setShowConcernLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048872, this, z) == null) {
            this.isShowConcernLiveSecondFloor = z;
        }
    }

    public void setShowRecommendLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048873, this, z) == null) {
            this.isShowRecommendLiveSecondFloor = z;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048874, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowVoiceFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048875, this, z) == null) {
            this.mIsShowVoiceFloat = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048876, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSingleSendMessageTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048877, this, str) == null) {
            this.singleSendMessageTips = str;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048878, this, z) == null) {
            da5.p().A("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048879, this, jSONObject) == null) {
            this.syncJson = jSONObject;
        }
    }

    public void setSyncModel(yf5 yf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048880, this, yf5Var) == null) {
            this.syncModel = yf5Var;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048881, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            da5 p = da5.p();
            p.A("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTiebaPlusConfigData(TiebaPlusConfigData tiebaPlusConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048883, this, tiebaPlusConfigData) == null) {
            this.mTiebaPlusConfigData = tiebaPlusConfigData;
        }
    }

    public void setTimeMap(Map<String, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048884, this, map) == null) {
            this.mTimeMap = map;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048885, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048886, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048887, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUpgradePopWindowConfig(te5 te5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048888, this, te5Var) == null) {
            this.upgradePopWindowConfig = te5Var;
        }
    }

    public void setUploadAndClearModule(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048889, this, ux9Var) == null) {
            this.mUploadAndClearModule = ux9Var;
        }
    }

    public void setUserBan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048890, this, z) == null) {
            this.isUserBan = z;
        }
    }

    public void setUserGrowthTaskListData(UserGrowthTaskListData userGrowthTaskListData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048891, this, userGrowthTaskListData) == null) {
            this.userGrowthTaskListData = userGrowthTaskListData;
            if (userGrowthTaskListData != null) {
                da5.p().F("key_person_growth_switch", userGrowthTaskListData.getGrowthSwitch());
            } else {
                da5.p().Q("key_person_growth_switch");
            }
        }
    }

    public void setUserPendantData(@NonNull UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048892, this, userPendantData) == null) {
            this.userPendantData = userPendantData;
        }
    }

    public void setUserSmallTheme(SmallTailThemeData smallTailThemeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048893, this, smallTailThemeData) == null) {
            this.mSmallTailThemeData = smallTailThemeData;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048894, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelRelogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048897, this, z) == null) {
            this.isVideoChannelRelogin = z;
        }
    }

    public void setVideoCover(dr6 dr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048898, this, dr6Var) == null) {
            this.mVideoCover = dr6Var;
        }
    }

    public void setVideoEventsConfig(we5 we5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048899, this, we5Var) == null) {
            we5 we5Var2 = this.videoEventsConfig;
            if (we5Var2 == null) {
                this.videoEventsConfig = we5Var;
            } else if (!we5Var2.a(we5Var)) {
                this.videoEventsConfig = we5Var;
            }
        }
    }

    public void setVideoRedIconInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048900, this, i) == null) {
            this.videoRedIconInterval = i;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048901, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048902, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setVoiceRoomConfig(@Nullable xe5 xe5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048903, this, xe5Var) == null) {
            this.voiceRoomConfig = xe5Var;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048904, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWlConfigData(ze5 ze5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048905, this, ze5Var) == null) {
            this.mWlConfigData = ze5Var;
        }
    }

    public void setWorksAddTopicMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048906, this, i) == null) {
            this.worksAddTopicMaxNum = i;
        }
    }

    public void setWorldCupSponsorFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048907, this, str) == null) {
            this.mWorldCupSponsorFlag = str;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048908, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(x0b x0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048909, this, x0bVar) == null) {
            this.mYYLiveTabConfig = x0bVar;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048910, this, str) == null) {
            this.yyCloudSwitch = str;
            da5.p().J("key_yy_cloud_switch", str);
        }
    }

    public boolean canShowPermDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long r = da5.p().r("key_first_enter_app_timestamp", 0L);
            if (this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - r > 259200000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int i = this.calendar.get(1);
            int i2 = this.calendar.get(5);
            sb.append(i);
            sb.append(this.calendar.get(2) + 1);
            sb.append(i2);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean getSyncYYSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if (this.isYYLive == null) {
                da5 p = da5.p();
                this.isYYLive = Boolean.valueOf(p.l("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            boolean z2 = false;
            if (da5.p().q("slide_local_switch_is_clicked", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (da5.p().q("sync_slide_animation__switch", 0) == 1) {
                z2 = true;
            }
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                da5.p().A("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            da5 p = da5.p();
            this.isYYLive = Boolean.valueOf(p.l("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    @NonNull
    public String getAdVertiComment(boolean z, boolean z2, @NonNull String str) {
        InterceptResult invokeCommon;
        String adStrWithLimit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z) {
                if (z2) {
                    adStrWithLimit = getAdStrWithLimit();
                    if (StringUtils.isNull(adStrWithLimit)) {
                        return str;
                    }
                } else {
                    return str;
                }
            } else {
                adStrWithLimit = getAdStrWithLimit();
                if (StringUtils.isNull(adStrWithLimit)) {
                    return str;
                }
            }
            return adStrWithLimit;
        }
        return (String) invokeCommon.objValue;
    }

    public Integer getAnimAvgFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (xi.isEmpty(str)) {
                return 0;
            }
            da5 p = da5.p();
            return Integer.valueOf(p.q(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (xi.isEmpty(str)) {
                return 0;
            }
            da5 p = da5.p();
            return Integer.valueOf(p.q(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public boolean isAnimEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, str)) == null) {
            if (!isEnableBenchmark()) {
                return true;
            }
            if (getCpuFlopsDuration() > getCpuFlopsDurationSyncThreshold()) {
                return false;
            }
            if (!isAnimFpsComputed(str) || getAnimComputedFps(str) >= getAnimFpsSyncThreshold()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setVideoChannelRecommendRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048896, this, redIcon) == null) {
            this.videoChannelRecommendRedIcon = redIcon;
            if (redIcon != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, redIcon.text));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
            }
        }
    }

    public boolean interestGuideShowCountInLimit(String str, ge5 ge5Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048706, this, str, ge5Var)) == null) {
            if (StringUtils.isNull(str)) {
                return true;
            }
            String[] split = str.split(",");
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = 0;
            for (int length = split.length - 1; length >= 0; length--) {
                try {
                    i = (int) (((((currentTimeMillis - Long.parseLong(split[length])) / 1000) / 60) / 60) / 24);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i <= ge5Var.c) {
                    if (i2 >= ge5Var.d - 1) {
                        return false;
                    }
                    i2++;
                } else if (i2 < ge5Var.d) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isNeedShowInterestGuide() {
        InterceptResult invokeV;
        long j;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            ge5 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
            if (interestBoardConfigData == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long r = da5.p().r("key_new_user_logon_time", 0L);
            long r2 = da5.p().r("key_home_recommend_item_click_time", 0L);
            long r3 = da5.p().r("key_select_interest_flag", 0L);
            long r4 = da5.p().r("key_app_launch_time", 0L);
            String w = da5.p().w("key_interest_guide_show", "");
            boolean isSameDay = TimeHelper.isSameDay(System.currentTimeMillis() - (interestBoardConfigData.a * 86400000), r);
            boolean isTargetTimeInTimeBlock = TimeHelper.isTargetTimeInTimeBlock(r2, r, System.currentTimeMillis());
            int i = (int) (((((currentTimeMillis - r4) / 1000) / 60) / 60) / 24);
            if (isSameDay && !isTargetTimeInTimeBlock) {
                j = 0;
                if (r3 == 0) {
                    z = true;
                    if (r4 == j && i >= interestBoardConfigData.b) {
                        this.triggerInterestPanelYDaysConfig = true;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((!z || z2) && interestGuideShowCountInLimit(w, interestBoardConfigData) && !getShowedInterestGuide()) {
                        return true;
                    }
                    return false;
                }
            } else {
                j = 0;
            }
            z = false;
            if (r4 == j) {
            }
            z2 = false;
            if (!z) {
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void putVideoRecord(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048755, this, str, i) != null) || xi.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        boolean z = false;
        xw4 xw4Var = null;
        int i2 = size - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                break;
            }
            xw4 xw4Var2 = this.mVideoWatchTimeRecord.get(i3);
            if (str.equals(xw4Var2.a())) {
                if (xw4Var2.b() == i) {
                    return;
                }
                if (i3 == i2) {
                    z = true;
                }
                xw4Var = xw4Var2;
            } else {
                i3--;
            }
        }
        if (xw4Var != null) {
            xw4Var.c(i);
            if (!z) {
                this.mVideoWatchTimeRecord.remove(xw4Var);
                this.mVideoWatchTimeRecord.addLast(xw4Var);
                return;
            }
            return;
        }
        xw4 xw4Var3 = new xw4(str, i);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(xw4Var3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(xw4Var3);
    }

    public void recordAcceleratorServer(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048756, this, str, str2) == null) {
            this.mAcceleratorMap.put(str, str2);
        }
    }

    public void setAnimAvgFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048766, this, str, i) == null) && !xi.isEmpty(str) && i >= 0) {
            da5 p = da5.p();
            p.F(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public void setAnimAvgFpsCount(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048767, this, str, i) == null) && !xi.isEmpty(str) && i >= 0) {
            da5 p = da5.p();
            p.F(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setAnimComputedFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048768, this, str, i) != null) || xi.isEmpty(str)) {
            return;
        }
        da5.p().F(str, i);
        if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
            setSlideAnimLocalSwitch(false);
        }
    }

    public void setRoomDraft(Long l, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048863, this, l, str) == null) {
            if (this.mRoomDraft == null) {
                this.mRoomDraft = new HashMap();
            }
            this.mRoomDraft.put(l, str);
        }
    }

    public void setTempString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048882, this, str, str2) == null) {
            this.tempStrings.put(str, str2);
        }
    }

    public void setBaiduidCookieSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048772, this, z) == null) {
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setFrsResponseData(nba nbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, nbaVar) == null) {
            this.mFrsResponseData = nbaVar;
            if (nbaVar != null && nbaVar.getForum() != null && !TextUtils.isEmpty(nbaVar.getForum().getName())) {
                if (nbaVar.itemInfo != null) {
                    this.frsItemInfoCache.put(nbaVar.getForum().getName(), nbaVar.itemInfo);
                } else {
                    this.frsItemInfoCache.remove(nbaVar.getForum().getName());
                }
            }
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048895, this, redIcon) == null) {
            if (redIcon == null && this.videoChannelAttentionRedIcon == null) {
                z = false;
            } else {
                z = true;
            }
            this.videoChannelAttentionRedIcon = redIcon;
            if (z) {
                if (redIcon != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, redIcon.text));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921578, redIcon.text));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921578, ""));
            }
        }
    }

    public void startOneGame() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048911, this) != null) || !this.mStartGameClicked) {
            return;
        }
        this.mStartGameClicked = false;
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
    }
}

package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.services.vod.VodClient;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.ah5;
import com.repackage.ar4;
import com.repackage.f05;
import com.repackage.fo4;
import com.repackage.fp4;
import com.repackage.id5;
import com.repackage.io4;
import com.repackage.jo4;
import com.repackage.ju4;
import com.repackage.kk8;
import com.repackage.kp4;
import com.repackage.ku4;
import com.repackage.lp4;
import com.repackage.mi8;
import com.repackage.mq4;
import com.repackage.ng;
import com.repackage.nn;
import com.repackage.nn4;
import com.repackage.oe5;
import com.repackage.og5;
import com.repackage.oi;
import com.repackage.on4;
import com.repackage.oq4;
import com.repackage.pi;
import com.repackage.pp4;
import com.repackage.rg5;
import com.repackage.sq4;
import com.repackage.tz4;
import com.repackage.um;
import com.repackage.ux5;
import com.repackage.vn4;
import com.repackage.vq4;
import com.repackage.wn4;
import com.repackage.xt4;
import com.repackage.y05;
import com.repackage.zm4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.ApkDetail;
import tbclient.DislikeInfo;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.TiebaPlusAd;
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.UserPostPerm;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.VoiceRoom;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes3.dex */
public class ThreadData extends nn4 implements PreLoadImageProvider, nn, IVideoData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACT_STATE_CLOSE = 3;
    public static final int ACT_STATE_INVALID = -1;
    public static final int ACT_STATE_NORMAL = 1;
    public static final int ACT_STATE_NOT_START = 4;
    public static final int ACT_STATE_TIME_OUT = 2;
    public static final int FRS = 2;
    public static final int HOME = 1;
    public static final int HOT_TOPIC = 5;
    public static final int MAX_CATEGORY_LENGTH = 4;
    public static final int MAX_CONCERN_FORUM_NAME_LENGTH = 36;
    public static final int MAX_HOME_FORUM_NAME_LENGTH = 24;
    public static final int MAX_IMAGE = 3;
    public static final int MAX_USERNAME_LENGTH = 12;
    public static final int MAX_VIDEO_USER_NAME_LENGTH = 16;
    public static final int NEED_CHECK_REPEAT = 1;
    public static final int OBJ_TYPE_BJH_ARTICAL = 5;
    public static final int OBJ_TYPE_BJH_VIDEO = 6;
    public static final int OBJ_TYPE_GOD = 4;
    public static final int OBJ_TYPE_LIVE = 3;
    public static final int OBJ_TYPE_NORMAL = 1;
    public static final int OBJ_TYPE_TRANSMIT = 9;
    public static final int OBJ_TYPE_UGC_PIC = 7;
    public static final int OBJ_TYPE_UGC_VIDEO = 8;
    public static final int OBJ_TYPE_VIDEO = 2;
    public static final int OPERATE_THREAD = 1;
    public static final int OTHER = 0;
    public static final int PB = 3;
    public static final int PB_BOTTOM = 4;
    public static final int SHOW_STATUS_NOT_SHOWN = 0;
    public static final int SHOW_STATUS_RECORD = 2;
    public static final int SHOW_STATUS_SHOWN = 1;
    public static final int TAB_SHOW_MODE_FORUM = 2;
    public static final int TAB_SHOW_MODE_USER = 1;
    public static final String TITLE_END_SPACE = " ";
    public static final BdUniqueId TYPE_ALA_FRIEND_ROOM;
    public static final BdUniqueId TYPE_ALA_LIVE_EMPTY;
    public static final BdUniqueId TYPE_ALA_SHARE_THREAD;
    public static final BdUniqueId TYPE_ARTICLE;
    public static final BdUniqueId TYPE_ARTICLE_SHARE_THREAD;
    public static final BdUniqueId TYPE_BOTTOM_NORMAL;
    public static final BdUniqueId TYPE_CONTENT_FEED_PIC_NORMMAL;
    public static final BdUniqueId TYPE_CONTENT_MULTI_PIC_NORMMAL;
    public static final BdUniqueId TYPE_CONTENT_SINGLE_H_NORMAL;
    public static final BdUniqueId TYPE_CONTENT_SINGLE_V_NORMAL;
    public static final BdUniqueId TYPE_CONTENT_TEXT_NORMAL;
    public static final BdUniqueId TYPE_CONTENT_VOICE_ROOM;
    public static final BdUniqueId TYPE_Double_NORMAL;
    public static final BdUniqueId TYPE_ENTER_FORUM;
    public static final BdUniqueId TYPE_FAKE_VIDEO;
    public static final BdUniqueId TYPE_FORUM_HEADER;
    public static final BdUniqueId TYPE_FRS_HOTTOPIC;
    public static final BdUniqueId TYPE_FRS_HOTTOPIC_VIDEO;
    public static final BdUniqueId TYPE_GODREPLY_NORMAL;
    public static final BdUniqueId TYPE_GOD_NORMAL;
    public static final BdUniqueId TYPE_INSERT_VIDEO;
    public static final BdUniqueId TYPE_ITEM;
    public static final BdUniqueId TYPE_LINK;
    public static final BdUniqueId TYPE_LOTTERY;
    public static final BdUniqueId TYPE_MULTI_LINK;
    public static final BdUniqueId TYPE_More_NORMAL;
    public static final BdUniqueId TYPE_NEW_NORMAL_SHARE_THREAD;
    public static final BdUniqueId TYPE_NEW_VIDEO_SHARE_THREAD;
    public static final BdUniqueId TYPE_NORMAL;
    public static final BdUniqueId TYPE_SHARE_THREAD;
    public static final BdUniqueId TYPE_SINGLE_LINK;
    public static final BdUniqueId TYPE_SMART_APP;
    public static final BdUniqueId TYPE_SMART_APP_IMAGE;
    public static final BdUniqueId TYPE_SMART_APP_VIDEO;
    public static final BdUniqueId TYPE_STAR_INTERVIEW;
    public static final BdUniqueId TYPE_Single_NORMAL;
    public static final BdUniqueId TYPE_TOP;
    public static final BdUniqueId TYPE_TOPIC;
    public static final BdUniqueId TYPE_USER_NORMAL;
    public static final BdUniqueId TYPE_VIDEO;
    public static final BdUniqueId TYPE_VIDEO_ALA_ONLIVE;
    public static final BdUniqueId TYPE_VIDEO_GOD;
    public static final BdUniqueId TYPE_VIDEO_WITH_FORUM_HEADER;
    public static final BdUniqueId TYPE_VOTE;
    public static HashMap<Point, Integer> activityResMap;
    public static HashMap<Point, Integer> activityResStringMap;
    public static AtomicBoolean isFRSExtraLoaded;
    public static AtomicBoolean isLegoLoaded;
    public static AtomicBoolean isRecAppLoaded;
    public static HashMap<Integer, Integer> mInterviewResMap;
    public static SparseArray<ux5.a> mInterviewResMapForPb;
    public transient /* synthetic */ FieldHolder $fh;
    public SpannableString abstractText;
    public String abstract_text;
    public String ad_url;
    public String address;
    public AgreeData agreeData;
    public AnchorInfoData anchorInfoData;
    public int anchorLevel;
    public String articeCover;
    public MetaData author;
    public String authorId;
    public int bjhContentTag;
    public fo4 bookChapterData;
    public String buttonText;
    public boolean canCopyThread;
    public String category_name;
    public int collectNum;
    public int copyThreadRemindType;
    public long dispatchedForumId;
    public String distance;
    public int expandStatus;
    public String extraTag;
    public String extraText;
    public SparseArray<String> feedBackExtraMap;
    public SparseArray<String> feedBackReasonMap;
    public long fid;
    public String first_post_id;
    public int floorNum;
    public boolean forbidComment;
    public boolean forceReadUserMap;
    public String forumAvatar;
    public mq4 forumData;
    public ForumRecTip forumRecTip;
    public String forum_name;
    public String from;
    public mi8 funAdData;
    public String funAdId;
    public boolean hasPlayVirtualImage;
    public boolean hasRecommend;
    public int has_commented;
    public int hotIndex;
    public int hotNum;
    public String iconLink;
    public String iconPicUrl;
    public String id;
    public int isAuthorView;
    public int isBjh;
    public boolean isBlocked;
    public int isBookChapter;
    public boolean isBottomType;
    public boolean isContentFeedPicType;
    public boolean isContentMutliPicType;
    public boolean isContentSingleHType;
    public boolean isContentSingleVType;
    public boolean isContentTextType;
    public boolean isCopyTWzhibo;
    public boolean isDailyThread;
    public boolean isFirstRecommend;
    public boolean isFloor5Video;
    public boolean isFromBrandForum;
    public boolean isFromConcern;
    public boolean isFromEnterFroumTabFeed;
    public boolean isFromFeedTab;
    public boolean isFromFrs;
    public boolean isFromHomPage;
    public boolean isFromHotRankTab;
    public boolean isFromLocal;
    public boolean isFromLowFlowsPage;
    public boolean isFromPersonPolymeric;
    public boolean isFromVideoTab;
    public boolean isFrsKadunOpt;
    public boolean isFunAd;
    public boolean isGodReplyType;
    public int isGodthreadRecommend;
    public boolean isGoods;
    public boolean isHeadLinePost;
    public boolean isHeadLive;
    public boolean isImShareFromPb;
    public boolean isInsertThread;
    public boolean isItem;
    public boolean isJumpToFrsVideoTabPlay;
    public boolean isLinkThread;
    public boolean isLocal;
    public int isManager;
    public boolean isMarkToDel;
    public int isMarked;
    public boolean isMutiForumThread;
    public int isNoTitle;
    public boolean isOperateThread;
    public int isOriginManager;
    public boolean isPrivacy;
    public boolean isQualityReplyThread;
    public boolean isSCard;
    public boolean isShareThread;
    public boolean isShowFullThread;
    public boolean isSmartFrsThread;
    public boolean isSubPb;
    public boolean isTargetTWZhibo;
    public int isTbReadDispatch;
    public boolean isTiebaPlusAdThread;
    public int isTopic;
    public boolean isUserType;
    public int isVoiceThread;
    public int is_activity;
    public int is_called;
    public int is_god;
    public int is_good;
    public int is_live;
    public int is_membertop;
    public int is_top;
    public ItemData itemData;
    public ItemStarData itemStarData;
    public String labelUrl;
    public String last_time;
    public long last_time_int;
    public String latitude;
    public String legoCard;
    public String lengthLimitName;
    public fp4 linkThreadData;
    public String linkUrl;
    public String location;
    public String longtitude;
    public ArrayList<on4> mActDatas;
    public wn4 mAppCodeData;
    public long mAuditTime;
    public BaijiahaoData mBaijiahao;
    public io4 mCartoonThreadData;
    public boolean mCheckRepeat;
    public long mCreateTime;
    public VirtualImageCustomFigure mCustomFigure;
    public y05 mCustomState;
    public String mDailyPaperTime;
    public ArrayList<f05> mExtTails;
    public String mFirstClassName;
    public List<PbContent> mFirstFloorList;
    public String mFirstPostId;
    public long mFreqNum;
    public String mFromType;
    public List<PbGoodsData> mGoodsDataList;
    public String mHomePageTopTabTabCode;
    public VideoInfo mHotTopicInfo;
    public int mInsertFloor;
    public boolean mIsMarkToMove;
    public Item mItem;
    public List<HeadItem> mItemStar;
    public int mLastPostNum;
    public long mLastReadPid;
    public List<PbLinkData> mLinkDataList;
    public LiveCoverStatus mLiveCoverStatus;
    public ArrayList<MediaData> mMedias;
    public String mNid;
    public String mNotice;
    public OriginalForumInfo mOriginalForumInfo;
    public String mPbTitle;
    public String mPhotoLiveCover;
    public MediaData mPicMediaData;
    public PollData mPollData;
    public PushStatusData mPushStatusData;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomExtraImg;
    public int mRecomExtraImgHeight;
    public int mRecomExtraImgWidth;
    public String mRecomExtraNightImg;
    public String mRecomReason;
    public String mRecomReasonIcon;
    public String mRecomSource;
    public String mRecomWeight;
    public List<ReportInfo> mReportInfoList;
    public int mResourceType;
    public List<PbContent> mRichAbstractList;
    public List<PbContent> mRichTitleList;
    public String mRightUrl;
    public String mSecondClassName;
    public String mShareImageUrl;
    public long mShareNum;
    public SkinInfo mSkinInfoData;
    public SmartApp mSmartApp;
    public int mStoreCount;
    public String mTabCode;
    public int mTabId;
    public String mTabName;
    public int mTabShowMode;
    public PostData mTopAgreePost;
    public TopicModule mTopicModule;
    public String mUrl;
    public VoiceRoom mVoiceRoomData;
    public ArrayList<VoiceData.VoiceModel> mVoices;
    public String mWonderfulPostInfo;
    public ar4 mYulePostActivityData;
    public String markID;
    public int middle_page_num;
    public int middle_page_pass_flag;
    public String modeUrl;
    public String noCommetStr;
    public int operator_flag;
    public OriginalThreadInfo originalThreadData;
    public int originalThreadType;
    public boolean partialVisible;
    public PostData pbFirstShareData;
    public String person_center_post_id;
    public int positionInFrsItemTab;
    public int post_num;
    public PraiseData praise;
    public String presentationStyle;
    public List<TwAnchorProfitItem> profitList;
    public ThreadInfo rawThreadInfo;
    public String replyTime;
    public String replyTimeForMyThread;
    public int reply_num;
    public int repost_num;
    public String scardPacketId;
    public String shareIntro;
    public int showStatus;
    public int show_commented;
    public int smartFrsPosition;
    public int sortType;
    public SpannableStringBuilder span_str;
    public vn4 specialData;
    public int statFloor;
    public int style_flag;
    public oq4 taskInfoData;
    public AlaInfoData threadAlaInfo;
    public ArrayList<tz4> threadExpressionArrayList;
    public String threadExtendInfo;
    public List<ThreadRecommendInfoData> threadRecommendInfoDataList;
    public ThreadRecommendTagData threadRecommendTagData;
    public int threadTitleSpanOffset;
    public int threadType;
    public vq4 threadVideoChannelInfo;
    public VideoInfo threadVideoInfo;
    public VideoDesc threadVideoSegment;
    public String thread_share_link;
    public String tid;
    public String tiePlusAdSource;
    public String tiePlusCostUrl;
    public int tiePlusFrsStaticLocate;
    @Nullable
    public List<ah5> tiePlusLinkOriginData;
    public String tiePlusMonitorClickUrl;
    public String tiePlusMonitorShowUrl;
    public String tiePlusShowUrl;
    public String tiebaPlusExtraParam;
    public String tiebaPlusOrderId;
    public String tiebaPlusToken;
    public String tieba_game_information_source;
    public boolean tiebaplusCantDelete;
    public long time;
    public String title;
    public SpannableStringBuilder titleText;
    public sq4 topicData;
    public String topicUrl;
    public String topicUserName;
    public TwZhiBoUser twZhiBoUser;
    public HashMap<String, MetaData> userMap;
    public UserPostPerm userPostPerm;
    public int view_num;
    public WorksInfoData worksInfoData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-376331601, "Lcom/baidu/tbadk/core/data/ThreadData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-376331601, "Lcom/baidu/tbadk/core/data/ThreadData;");
                return;
            }
        }
        TYPE_TOP = BdUniqueId.gen();
        TYPE_NORMAL = BdUniqueId.gen();
        TYPE_VIDEO_WITH_FORUM_HEADER = BdUniqueId.gen();
        TYPE_Single_NORMAL = BdUniqueId.gen();
        TYPE_Double_NORMAL = BdUniqueId.gen();
        TYPE_More_NORMAL = BdUniqueId.gen();
        TYPE_FORUM_HEADER = BdUniqueId.gen();
        TYPE_USER_NORMAL = BdUniqueId.gen();
        TYPE_CONTENT_TEXT_NORMAL = BdUniqueId.gen();
        TYPE_CONTENT_SINGLE_H_NORMAL = BdUniqueId.gen();
        TYPE_CONTENT_SINGLE_V_NORMAL = BdUniqueId.gen();
        TYPE_CONTENT_MULTI_PIC_NORMMAL = BdUniqueId.gen();
        TYPE_CONTENT_FEED_PIC_NORMMAL = BdUniqueId.gen();
        TYPE_CONTENT_VOICE_ROOM = BdUniqueId.gen();
        TYPE_BOTTOM_NORMAL = BdUniqueId.gen();
        TYPE_GODREPLY_NORMAL = BdUniqueId.gen();
        TYPE_TOPIC = BdUniqueId.gen();
        TYPE_ARTICLE = BdUniqueId.gen();
        TYPE_ENTER_FORUM = BdUniqueId.gen();
        TYPE_ITEM = BdUniqueId.gen();
        TYPE_VOTE = BdUniqueId.gen();
        TYPE_SINGLE_LINK = BdUniqueId.gen();
        TYPE_MULTI_LINK = BdUniqueId.gen();
        TYPE_LINK = BdUniqueId.gen();
        TYPE_GOD_NORMAL = BdUniqueId.gen();
        TYPE_VIDEO = BdUniqueId.gen();
        TYPE_VIDEO_ALA_ONLIVE = BdUniqueId.gen();
        TYPE_ALA_LIVE_EMPTY = BdUniqueId.gen();
        TYPE_ALA_SHARE_THREAD = BdUniqueId.gen();
        TYPE_ALA_FRIEND_ROOM = BdUniqueId.gen();
        TYPE_SHARE_THREAD = BdUniqueId.gen();
        TYPE_NEW_NORMAL_SHARE_THREAD = BdUniqueId.gen();
        TYPE_ARTICLE_SHARE_THREAD = BdUniqueId.gen();
        TYPE_NEW_VIDEO_SHARE_THREAD = BdUniqueId.gen();
        TYPE_VIDEO_GOD = BdUniqueId.gen();
        TYPE_FRS_HOTTOPIC = BdUniqueId.gen();
        TYPE_FRS_HOTTOPIC_VIDEO = BdUniqueId.gen();
        TYPE_SMART_APP_IMAGE = BdUniqueId.gen();
        TYPE_SMART_APP_VIDEO = BdUniqueId.gen();
        TYPE_SMART_APP = BdUniqueId.gen();
        isFRSExtraLoaded = new AtomicBoolean(false);
        isRecAppLoaded = new AtomicBoolean(true);
        isLegoLoaded = new AtomicBoolean(true);
        TYPE_INSERT_VIDEO = BdUniqueId.gen();
        TYPE_FAKE_VIDEO = BdUniqueId.gen();
        activityResMap = new HashMap<>();
        mInterviewResMap = new HashMap<>();
        TYPE_STAR_INTERVIEW = BdUniqueId.gen();
        TYPE_LOTTERY = BdUniqueId.gen();
        activityResStringMap = new HashMap<>();
        mInterviewResMapForPb = new SparseArray<>(3);
        activityResMap.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        activityResMap.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        activityResMap.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        activityResMap.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        activityResMap.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        activityResMap.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        activityResMap.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        activityResMap.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        activityResStringMap.put(new Point(1, 1), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0a64));
        activityResStringMap.put(new Point(1, 2), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0a67));
        activityResStringMap.put(new Point(1, 3), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0a66));
        activityResStringMap.put(new Point(1, 4), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0a65));
        activityResStringMap.put(new Point(2, 1), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f1155));
        activityResStringMap.put(new Point(2, 2), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f1158));
        activityResStringMap.put(new Point(2, 3), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f1157));
        activityResStringMap.put(new Point(2, 4), Integer.valueOf((int) R.string.obfuscated_res_0x7f0f1156));
        mInterviewResMap.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        mInterviewResMap.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        mInterviewResMap.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        mInterviewResMapForPb.put(1, new ux5.a(R.string.obfuscated_res_0x7f0f0946, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        mInterviewResMapForPb.put(2, new ux5.a(R.string.obfuscated_res_0x7f0f0945, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        mInterviewResMapForPb.put(3, new ux5.a(R.string.obfuscated_res_0x7f0f0947, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public ThreadData() {
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
        this.isUserType = false;
        this.isContentTextType = false;
        this.isContentSingleHType = false;
        this.isContentSingleVType = false;
        this.isContentMutliPicType = false;
        this.isContentFeedPicType = false;
        this.isBottomType = false;
        this.isGodReplyType = false;
        this.isItem = false;
        this.isJumpToFrsVideoTabPlay = false;
        this.mResourceType = 0;
        this.mPbTitle = "1";
        this.threadTitleSpanOffset = 1;
        this.isTbReadDispatch = 0;
        this.markID = null;
        this.style_flag = 0;
        this.operator_flag = 0;
        this.showStatus = 0;
        this.mFirstPostId = "";
        this.isFrsKadunOpt = false;
        this.mPhotoLiveCover = "";
        this.mFreqNum = 0L;
        this.mCheckRepeat = true;
        this.isFirstRecommend = false;
        this.hasRecommend = false;
        this.smartFrsPosition = -1;
        this.feedBackReasonMap = null;
        this.feedBackExtraMap = null;
        this.partialVisible = false;
        this.middle_page_num = 0;
        this.isTopic = 0;
        this.isMarkToDel = false;
        this.isShowFullThread = false;
        this.isHeadLinePost = false;
        this.isQualityReplyThread = false;
        this.forbidComment = false;
        this.isSCard = false;
        this.isSubPb = false;
        this.forceReadUserMap = false;
        this.labelUrl = "";
        this.modeUrl = "";
        this.location = "";
        this.id = null;
        this.tid = null;
        this.fid = 0L;
        this.title = null;
        this.is_god = 0;
        this.reply_num = 0;
        this.repost_num = 0;
        this.view_num = 0;
        this.last_time = null;
        this.last_time_int = 0L;
        this.is_top = 0;
        this.is_membertop = 0;
        this.is_good = 0;
        this.is_live = 0;
        this.topicData = new sq4();
        this.author = new MetaData();
        this.forum_name = null;
        this.mMedias = new ArrayList<>();
        this.mVoices = new ArrayList<>();
        this.has_commented = 0;
        this.show_commented = 0;
        this.ad_url = null;
        this.abstract_text = null;
        this.from = null;
        this.isMarked = 0;
        this.praise = new PraiseData();
        this.anchorInfoData = new AnchorInfoData();
        this.time = 0L;
        this.is_activity = 0;
        this.mActDatas = new ArrayList<>();
        this.mYulePostActivityData = null;
        this.mAppCodeData = null;
        this.mStoreCount = 0;
        this.threadExpressionArrayList = new ArrayList<>();
        this.isHeadLive = false;
        this.post_num = 0;
        this.mNotice = null;
        this.post_num = 0;
        this.mLastPostNum = 0;
        this.mFreqNum = 0L;
        this.isCopyTWzhibo = false;
        this.isTargetTWZhibo = false;
        this.copyThreadRemindType = 0;
        this.canCopyThread = false;
        this.operator_flag = 0;
        this.anchorLevel = 0;
        this.isBookChapter = 0;
        this.bookChapterData = new fo4();
        this.mFirstFloorList = new ArrayList();
        this.mRichTitleList = new ArrayList();
        this.mRichAbstractList = new ArrayList();
        this.category_name = null;
        this.taskInfoData = new oq4();
        this.mExtTails = new ArrayList<>();
        this.mPushStatusData = new PushStatusData();
        this.isTbReadDispatch = 0;
        this.isInsertThread = false;
        this.mInsertFloor = -1;
        this.mTopAgreePost = new PostData();
        this.agreeData = new AgreeData();
        this.is_called = 0;
        this.middle_page_num = 0;
        this.middle_page_pass_flag = 0;
        this.tieba_game_information_source = "";
        this.iconLink = "";
        this.iconPicUrl = "";
        this.mUrl = "";
        this.mRightUrl = "";
        this.mLinkDataList = new ArrayList();
        this.mGoodsDataList = new ArrayList();
        this.threadRecommendInfoDataList = new ArrayList();
        this.hotNum = -1;
    }

    private SpannableStringBuilder addGodTittle(String str, ArrayList<ux5.a> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            if (isVideoThreadType() || !needShowGodTitle() || oi.isEmpty(str)) {
                return null;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                arrayList = new ArrayList<>();
                arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f07dc));
            }
            return ux5.h(TbadkCoreApplication.getInst(), str, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    private SpannableStringBuilder addPrefix(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            ArrayList<ux5.a> prefixList = getPrefixList(z, z2, z3, z4);
            if (prefixList == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h = ux5.h(TbadkCoreApplication.getInst(), str, prefixList, false);
            if (prefixList.size() > 0) {
                if (h == null) {
                    h = new SpannableStringBuilder();
                }
                if (this.isNoTitle == 1) {
                    this.span_str = h;
                    return h;
                }
            } else if (this.isNoTitle == 1) {
                this.span_str = new SpannableStringBuilder();
                return h;
            }
            if (spannableStringBuilder != null) {
                h.append((CharSequence) spannableStringBuilder);
            } else if (prefixList.size() > 0 || h.length() == 0) {
                h.append((CharSequence) str);
            }
            return h;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    private SpannableStringBuilder addPrefixNew(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, spannableString, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            ArrayList<ux5.a> prefixList = getPrefixList(z, z2, z3, false);
            if (prefixList == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h = ux5.h(TbadkCoreApplication.getInst(), str, prefixList, false);
            if (prefixList.size() > 0 && h == null) {
                h = new SpannableStringBuilder();
            }
            if (spannableString != null) {
                h.append((CharSequence) spannableString);
            } else if (prefixList.size() > 0 || h.length() == 0) {
                h.append((CharSequence) str);
            }
            return h;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    private ArrayList<ux5.a> getPrefixList(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? getPrefixList(z, z2, true, false) : (ArrayList) invokeCommon.objValue;
    }

    private boolean isConveneThreadOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    private void parseFromVideoRichTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            Matcher matcher = Pattern.compile("#([ ]*[^#(\\n ]+[ ]*)++#(?!\\\\(\\\\w+\\\\))").matcher(str);
            String[] split = str.split("#([ ]*[^#(\\n ]+[ ]*)++#(?!\\\\(\\\\w+\\\\))");
            PbContent.Builder builder = new PbContent.Builder();
            PbContent.Builder builder2 = new PbContent.Builder();
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if ((!matcher.find() || i2 > matcher.groupCount()) && i2 > split.length) {
                    return;
                }
                if (i2 < split.length && !TextUtils.isEmpty(split[i2])) {
                    builder2.text = split[i2];
                    this.mRichTitleList.add(builder2.build(true));
                    i += split[i2].length();
                }
                if (matcher.find(i)) {
                    builder.type = 1282;
                    builder.text = matcher.group(0);
                    builder.link = " =" + matcher.group(0);
                    this.mRichTitleList.add(builder.build(true));
                    i += matcher.group(0).length();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parse_title(boolean z, boolean z2) {
        um umVar;
        SpannableStringBuilder parseRichTitle;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (getThreadType() == 42 && isConveneThreadOpen()) {
                    arrayList.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f0806c2));
                }
                if (getIs_top() == 1) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
                } else if (getIs_top() == 2) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
                }
                if (getIsLive() == 1 || this.topicData.a() != 0) {
                    if (getTaskInfoData() != null && getThreadType() == 41) {
                        if (getTaskInfoStatus() == 2) {
                            arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                        }
                    } else {
                        arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                    }
                }
                if (z && isInterviewLive() && (num = mInterviewResMap.get(Integer.valueOf(getTaskInfoStatus()))) != null) {
                    arrayList.add(num);
                }
                if (getIs_good() == 1 && !isTop() && TYPE_VIDEO != getType() && TYPE_VIDEO_GOD != getType()) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
                }
                AnchorInfoData anchorInfoData = this.anchorInfoData;
                if (anchorInfoData != null && anchorInfoData.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
                }
                if (getShow_commented() == 1) {
                    arrayList.add(Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080582));
                }
                Integer num2 = activityResMap.get(new Point(getActInfoType(), getActInfoStatus()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
                if (getYulePostActivityData() != null) {
                    arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
                }
                if (getAppCodeData() != null) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
                }
                if (!oi.isEmpty(this.category_name)) {
                    umVar = transStrToSpanStr(this.category_name);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < arrayList.size(); i++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (umVar != null) {
                            spannableString = new SpannableString(sb2 + this.category_name + " ");
                        } else {
                            spannableString = new SpannableString(sb2);
                        }
                        int i2 = 0;
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            Bitmap bitmap = SkinManager.getBitmap(((Integer) arrayList.get(i3)).intValue());
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                            if (bitmap != null) {
                                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            }
                            ju4 ju4Var = new ju4(bitmapDrawable);
                            ju4Var.b(pi.d(TbadkCoreApplication.getInst().getApplicationContext(), this.threadTitleSpanOffset));
                            spannableString.setSpan(ju4Var, i2, i2 + 1, 33);
                            i2 += 2;
                        }
                        if (umVar != null) {
                            spannableString.setSpan(umVar, i2, this.category_name.length() + i2, 33);
                        }
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    parseRichTitle = parseRichTitle();
                    if (parseRichTitle != null) {
                        spannableStringBuilder.append((CharSequence) parseRichTitle);
                    }
                    this.span_str = spannableStringBuilder;
                }
            }
            umVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            parseRichTitle = parseRichTitle();
            if (parseRichTitle != null) {
            }
            this.span_str = spannableStringBuilder2;
        }
    }

    private void processAbstructText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.abstractText = parseAbstract();
        }
    }

    private void processAlaExtensionInfo() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (alaInfoData = this.threadAlaInfo) == null) {
            return;
        }
        if (alaInfoData.openRecomDuration == 1) {
            long j = this.mCreateTime;
            if (j > 0) {
                String formatTimeForAlaCardCreate = StringHelper.getFormatTimeForAlaCardCreate(j);
                if (!StringUtils.isNull(formatTimeForAlaCardCreate)) {
                    this.threadExtendInfo = formatTimeForAlaCardCreate;
                }
            }
        }
        AlaInfoData alaInfoData2 = this.threadAlaInfo;
        if (alaInfoData2.openRecomFans == 1) {
            int i = 0;
            if (alaInfoData2 != null && (alaUserInfoData = alaInfoData2.user_info) != null) {
                i = alaUserInfoData.anchor_fans;
            }
            if (TextUtils.isEmpty(this.threadExtendInfo) || i <= 0) {
                if (i > 0) {
                    this.threadExtendInfo = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f01ff) + StringHelper.numberUniformFormatExtraWithRoundInt(i);
                    return;
                }
                return;
            }
            this.threadExtendInfo += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f01ff) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i);
        }
    }

    private void processExtensionInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if ((this instanceof lp4) && "0".equals(getId())) {
                this.threadExtendInfo = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f151d);
                return;
            }
            int i = 36;
            if (!isUgcThreadType() && ((!isFromConcern() || getType() == TYPE_VIDEO_ALA_ONLIVE) && !this.isFromFeedTab && !this.isFromLocal)) {
                if (getType() != TYPE_VIDEO_ALA_ONLIVE && getType() != TYPE_ALA_FRIEND_ROOM) {
                    if (isVocieRoom() && !TextUtils.isEmpty(this.forum_name)) {
                        this.threadExtendInfo = StringHelper.cutChineseAndEnglishWithSuffix(this.forum_name, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0650);
                        return;
                    }
                    long last_time_int = getLast_time_int() * 1000;
                    if (last_time_int != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(last_time_int);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(last_time_int);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0fbc);
                        if (showWeakenName()) {
                            formatTimeForJustNow = StringHelper.getFormatTimeForHomeC(last_time_int);
                        }
                        this.threadExtendInfo = string + formatTimeForJustNow;
                    } else {
                        long j = this.mCreateTime;
                        String formatTimeForJustNow2 = StringHelper.getFormatTimeForJustNow(j);
                        if (StringHelper.isThisYear(formatTimeForJustNow2)) {
                            formatTimeForJustNow2 = StringHelper.getFormatTimeShort(j);
                        }
                        this.threadExtendInfo = formatTimeForJustNow2;
                    }
                    if (this.isFromFrs) {
                        i = 24;
                    } else if (!this.isFromConcern) {
                        i = 16;
                    }
                    String authInfo = UtilHelper.getAuthInfo(this.author, this.isFromHomPage, i);
                    if (isShowForumAndReply()) {
                        String str = StringHelper.cutChineseAndEnglishWithSuffix(this.forum_name, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0650);
                        if (!TextUtils.isEmpty(authInfo)) {
                            this.threadExtendInfo = authInfo + GlideException.IndentedAppendable.INDENT + str;
                        } else {
                            this.threadExtendInfo = str;
                        }
                    } else if (!TextUtils.isEmpty(this.threadExtendInfo) && !TextUtils.isEmpty(authInfo)) {
                        this.threadExtendInfo += GlideException.IndentedAppendable.INDENT + authInfo;
                    } else if (!TextUtils.isEmpty(authInfo)) {
                        this.threadExtendInfo = authInfo;
                    }
                    if (TextUtils.isEmpty(this.threadExtendInfo) || TextUtils.isEmpty(getAddress())) {
                        return;
                    }
                    this.threadExtendInfo += " • " + getAddress();
                    return;
                }
                processAlaExtensionInfo();
                return;
            }
            long j2 = this.mCreateTime;
            if (j2 != 0) {
                String formatTimeForJustNow3 = StringHelper.getFormatTimeForJustNow(j2);
                if (StringHelper.isThisYear(formatTimeForJustNow3)) {
                    formatTimeForJustNow3 = StringHelper.getFormatTimeShort(j2);
                }
                this.threadExtendInfo = formatTimeForJustNow3;
            }
            if (!this.isFromLocal || (TextUtils.isEmpty(this.distance) && TextUtils.isEmpty(this.location))) {
                if (this.isFromFrs) {
                    i = 24;
                } else if (!this.isFromConcern) {
                    i = 16;
                }
                String authInfo2 = UtilHelper.getAuthInfo(this.author, this.isFromHomPage, i);
                if (!TextUtils.isEmpty(this.threadExtendInfo) && !TextUtils.isEmpty(authInfo2)) {
                    this.threadExtendInfo += "   " + authInfo2;
                } else if (TextUtils.isEmpty(authInfo2)) {
                } else {
                    this.threadExtendInfo = authInfo2;
                }
            }
        }
    }

    private void processExtensionInfoForNewGod() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && isNewGodAuthor() && !TextUtils.isEmpty(this.author.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.threadExtendInfo)) {
                this.threadExtendInfo += "   " + this.author.getNewGodData().getFieldName() + oe5.c(this.author.getNewGodData().isVideoGod());
                return;
            }
            this.threadExtendInfo = this.author.getNewGodData().getFieldName() + oe5.c(this.author.getNewGodData().isVideoGod());
        }
    }

    private void processReplyTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.replyTime = StringHelper.getFormatTimeShort(getLast_time_int() * 1000);
        }
    }

    private void processReplyTimeForMyThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.replyTimeForMyThread = StringHelper.getFormatTimeShort(getLast_time_int());
        }
    }

    private void processShareIntro() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (getThreadAlaInfo() != null && getThreadAlaInfo().share_info != null && getThreadAlaInfo().share_info.share_user_count > 0 && isSharedLiveThread() && (this.middle_page_num <= 0 || this.middle_page_pass_flag != 0)) {
                int i = getThreadAlaInfo().share_info.share_user_count;
                if (i == 1) {
                    this.shareIntro = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f022e);
                    return;
                } else {
                    this.shareIntro = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f022d, new Object[]{StringHelper.numberUniform(i)});
                    return;
                }
            }
            this.shareIntro = null;
        }
    }

    private void processTitleText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            SpannableStringBuilder parseTitle = parseTitle();
            this.titleText = parseTitle;
            ux5.b(this, parseTitle, true);
        }
    }

    private void processUserName() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || StringUtils.isNull(this.author.getName_show())) {
            return;
        }
        this.lengthLimitName = StringHelper.cutChineseAndEnglishWithSuffix(this.author.getName_show(), 12, StringHelper.STRING_MORE);
    }

    private um transStrToSpanStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(R.layout.obfuscated_res_0x7f0d0830, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202e);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0106_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                return new um(bitmapDrawable, 1);
            }
            return null;
        }
        return (um) invokeL.objValue;
    }

    public boolean canShowNaniTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public SpannableString generateNaniTail(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070304);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f08069b);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            ku4 ku4Var = new ku4(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String q = xt4.k().q("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0c1a));
            if (StringUtils.isNull(q)) {
                q = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f0c1a);
            }
            StringBuilder sb = new StringBuilder(q);
            if (getAuthor() != null) {
                if (getAuthor().getGender() == 1) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f082f));
                } else if (getAuthor().getGender() == 2) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f1187));
                } else {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f1357));
                }
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f1357));
            }
            sb.insert(0, "[icon]");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(ku4Var, 0, 6, 17);
            spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public String getAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.abstract_text : (String) invokeV.objValue;
    }

    public SpannableString getAbstractText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.abstractText : (SpannableString) invokeV.objValue;
    }

    public ArrayList<on4> getActDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActDatas : (ArrayList) invokeV.objValue;
    }

    public int getActInfoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!isActInfo() || this.mActDatas.size() < 1) {
                return -1;
            }
            on4 on4Var = this.mActDatas.get(0);
            int e = on4Var.e();
            if (e == 3) {
                return e;
            }
            int b = on4Var.b();
            int c = on4Var.c();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < b) {
                return 4;
            }
            return currentTimeMillis > c ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public int getActInfoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!isActInfo() || this.mActDatas.size() < 1 || this.mActDatas.get(0) == null) {
                return -1;
            }
            return this.mActDatas.get(0).a();
        }
        return invokeV.intValue;
    }

    public String getActUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (!isActInfo() || this.mActDatas.size() < 1 || this.mActDatas.get(0) == null) ? "" : this.mActDatas.get(0).g() : (String) invokeV.objValue;
    }

    public ActivityItemData getActivityData() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<PbContent> list = this.mRichTitleList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int size = this.mRichTitleList.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.mRichTitleList.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && isVideoThreadType() && (str = pbContent.text) != null && str.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = id5.d(pbContent.text);
                    String str2 = pbContent.text;
                    activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                    return activityItemData;
                }
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    public String getAd_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.ad_url : (String) invokeV.objValue;
    }

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.address : (String) invokeV.objValue;
    }

    public AgreeData getAgreeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.agreeData : (AgreeData) invokeV.objValue;
    }

    public long getAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.agreeData.agreeNum : invokeV.longValue;
    }

    public int getAgreeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.agreeData.agreeType : invokeV.intValue;
    }

    public AnchorInfoData getAnchorInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.anchorInfoData : (AnchorInfoData) invokeV.objValue;
    }

    public int getAnchorLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.anchorLevel : invokeV.intValue;
    }

    public wn4 getAppCodeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAppCodeData : (wn4) invokeV.objValue;
    }

    public String getArticeCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.articeCover : (String) invokeV.objValue;
    }

    public long getAuditTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mAuditTime : invokeV.longValue;
    }

    public MetaData getAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.author : (MetaData) invokeV.objValue;
    }

    public int getBJHContentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.bjhContentTag : invokeV.intValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mBaijiahao : (BaijiahaoData) invokeV.objValue;
    }

    public boolean getCanCopyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.canCopyThread : invokeV.booleanValue;
    }

    public io4 getCartoonThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mCartoonThreadData : (io4) invokeV.objValue;
    }

    public String getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.category_name : (String) invokeV.objValue;
    }

    public int getCopyThreadRemindType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.copyThreadRemindType : invokeV.intValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mCreateTime : invokeV.longValue;
    }

    public VirtualImageCustomFigure getCustomFigure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mCustomFigure : (VirtualImageCustomFigure) invokeV.objValue;
    }

    public y05 getCustomState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mCustomState : (y05) invokeV.objValue;
    }

    public String getDailyPaperTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mDailyPaperTime : (String) invokeV.objValue;
    }

    public long getDisAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.agreeData.disAgreeNum : invokeV.longValue;
    }

    public long getDispatchedForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.dispatchedForumId : invokeV.longValue;
    }

    public String getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.distance : (String) invokeV.objValue;
    }

    public ArrayList<tz4> getExpressDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.threadExpressionArrayList : (ArrayList) invokeV.objValue;
    }

    public ArrayList<f05> getExtTails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mExtTails : (ArrayList) invokeV.objValue;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.feedBackReasonMap : (SparseArray) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.fid : invokeV.longValue;
    }

    public String getFirstClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mFirstClassName : (String) invokeV.objValue;
    }

    public List<PbContent> getFirstFloorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mFirstFloorList : (List) invokeV.objValue;
    }

    public String getFirstPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mFirstPostId : (String) invokeV.objValue;
    }

    public String getFirst_post_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.first_post_id : (String) invokeV.objValue;
    }

    public String getForumAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.forumAvatar : (String) invokeV.objValue;
    }

    public mq4 getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.forumData : (mq4) invokeV.objValue;
    }

    public ForumRecTip getForumRecTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.forumRecTip : (ForumRecTip) invokeV.objValue;
    }

    public String getForum_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.forum_name : (String) invokeV.objValue;
    }

    public long getFreqNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mFreqNum : invokeV.longValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.from : (String) invokeV.objValue;
    }

    public String getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mFromType : (String) invokeV.objValue;
    }

    public String getGameInformationSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.tieba_game_information_source : (String) invokeV.objValue;
    }

    public GodUserData getGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null) {
                return null;
            }
            return metaData.getGodUserData();
        }
        return (GodUserData) invokeV.objValue;
    }

    public List<PbGoodsData> getGoodsDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mGoodsDataList : (List) invokeV.objValue;
    }

    public int getHasAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.agreeData.hasAgree ? 1 : 0 : invokeV.intValue;
    }

    public int getHas_commented() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.has_commented : invokeV.intValue;
    }

    public VideoInfo getHotTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mHotTopicInfo : (VideoInfo) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.id : (String) invokeV.objValue;
    }

    public int[] getImageWidthAndHeight() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            int[] iArr = new int[2];
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int size = (int) (((View.MeasureSpec.getSize(pi.q(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> medias = getMedias();
            if (zm4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i10 = 0; i10 < medias.size(); i10++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i10);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(medias, 0);
            if (mediaData2 == null || (i2 = mediaData2.picWidth) <= 0 || (i = mediaData2.picHeight) <= 0) {
                size = (size * 2) + dimensionPixelSize;
                i = size;
            } else {
                if (i2 * 2 <= i) {
                    i8 = ((int) (size * 1.5f)) + dimensionPixelSize;
                    i9 = size * 2;
                } else if (i * 2 <= i2) {
                    i8 = (size * 2) + dimensionPixelSize;
                    i9 = (int) (size * 1.5f);
                } else if (i2 >= size) {
                    if (i2 < size || i2 >= (i7 = size * 2)) {
                        int i11 = mediaData2.picHeight;
                        if (i11 >= size) {
                            if (i11 >= size && i11 < (i6 = size * 2)) {
                                size = i6 + dimensionPixelSize;
                                i3 = (i11 * size) / mediaData2.picWidth;
                            } else {
                                int i12 = mediaData2.picWidth;
                                int i13 = mediaData2.picHeight;
                                if (i12 < i13) {
                                    i4 = (size * 2) + dimensionPixelSize;
                                    i5 = (i12 * i4) / i13;
                                } else {
                                    size = (size * 2) + dimensionPixelSize;
                                    i3 = (i13 * size) / i12;
                                }
                            }
                            i = i3;
                        }
                        size = 0;
                        i = 0;
                    } else if (i < size) {
                        i2 = (i2 * size) / i;
                        i = size;
                        size = i2;
                    } else {
                        if (i < size || i >= i7) {
                            i4 = i7 + dimensionPixelSize;
                            i5 = (mediaData2.picWidth * i4) / mediaData2.picHeight;
                        }
                        size = i2;
                    }
                    i = i4;
                    size = i5;
                } else if (i >= size) {
                    if (i >= size && i < size * 2) {
                        i = (i * size) / i2;
                    }
                    size = 0;
                    i = 0;
                } else if (i2 < i) {
                    i = (i * size) / i2;
                } else {
                    i2 = (i2 * size) / i;
                    i = size;
                    size = i2;
                }
                i = i9 + dimensionPixelSize;
                size = i8;
            }
            iArr[0] = size;
            iArr[1] = i;
            HomeGroupUbsUIHelper.handleSinglePicSize(this, iArr);
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            ArrayList<MediaData> medias = getMedias();
            if (medias == null || isTop()) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            for (int i = 0; i < medias.size() && i < 3; i++) {
                if (medias.get(i) != null && medias.get(i).getType() == 3) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    if (!StringUtils.isNull(medias.get(i).getThumbnails_url())) {
                        preLoadImageInfo.imgUrl = medias.get(i).getThumbnails_url();
                    } else {
                        preLoadImageInfo.imgUrl = medias.get(i).getPicUrl();
                    }
                    preLoadImageInfo.procType = 13;
                    arrayList.add(preLoadImageInfo);
                }
            }
            int size = arrayList.size();
            Iterator<PreLoadImageInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                PreLoadImageInfo next = it.next();
                if (size == 1) {
                    next.preloadType = 1;
                } else {
                    next.preloadType = 2;
                }
            }
            VideoInfo videoInfo = this.threadVideoInfo;
            if (videoInfo != null && !StringUtils.isNull(videoInfo.thumbnail_url)) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.imgUrl = this.threadVideoInfo.thumbnail_url;
                preLoadImageInfo2.procType = 10;
                preLoadImageInfo2.preloadType = 1;
                arrayList.add(preLoadImageInfo2);
            }
            if (this.author != null) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.author.getPortrait();
                preLoadImageInfo3.procType = 28;
                preLoadImageInfo3.preloadType = 3;
                arrayList.add(preLoadImageInfo3);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getInsertFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mInsertFloor : invokeV.intValue;
    }

    public boolean getIsDailyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.isDailyThread : invokeV.booleanValue;
    }

    public int getIsLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.is_live : invokeV.intValue;
    }

    public int getIsManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.isManager : invokeV.intValue;
    }

    public int getIsMarked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.isMarked : invokeV.intValue;
    }

    public int getIsMemberTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.is_membertop : invokeV.intValue;
    }

    public int getIsNoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.isNoTitle : invokeV.intValue;
    }

    public boolean getIsOperateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.isOperateThread : invokeV.booleanValue;
    }

    public int getIsOriginManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.isOriginManager : invokeV.intValue;
    }

    public int getIs_called() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.is_called : invokeV.intValue;
    }

    public int getIs_good() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.is_good : invokeV.intValue;
    }

    public int getIs_top() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.is_top : invokeV.intValue;
    }

    public Item getItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mItem : (Item) invokeV.objValue;
    }

    public List<HeadItem> getItemStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.mItemStar : (List) invokeV.objValue;
    }

    public int getLastPostNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.mLastPostNum : invokeV.intValue;
    }

    public long getLastReadPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mLastReadPid : invokeV.longValue;
    }

    public String getLast_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.last_time : (String) invokeV.objValue;
    }

    public long getLast_time_int() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.last_time_int : invokeV.longValue;
    }

    public String getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.latitude : (String) invokeV.objValue;
    }

    public String getLeftHotIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public String getLegoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.legoCard : (String) invokeV.objValue;
    }

    public String getLengthLimitName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.lengthLimitName : (String) invokeV.objValue;
    }

    public List<PbLinkData> getLinkDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mLinkDataList : (List) invokeV.objValue;
    }

    public fp4 getLinkThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.linkThreadData : (fp4) invokeV.objValue;
    }

    public LiveCoverStatus getLiveCoverStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.mLiveCoverStatus : (LiveCoverStatus) invokeV.objValue;
    }

    public String getLongtitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.longtitude : (String) invokeV.objValue;
    }

    public String getMarkID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.markID : (String) invokeV.objValue;
    }

    public ArrayList<MediaData> getMedias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.mMedias : (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.nn4
    public kp4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            SparseArray<String> sparseArray = this.feedBackReasonMap;
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            kp4 kp4Var = new kp4();
            kp4Var.o(getThreadData().getTid());
            kp4Var.k(getThreadData().getFid());
            kp4Var.n(getThreadData().getNid());
            kp4Var.j(this.feedBackReasonMap);
            kp4Var.g = this.feedBackExtraMap;
            kp4Var.p = this.mRecomAbTag;
            kp4Var.k = this.mRecomWeight;
            kp4Var.m = this.mRecomExtra;
            kp4Var.l = this.mRecomSource;
            kp4Var.q = this.statFloor;
            kp4Var.o = getRecomCardType();
            return kp4Var;
        }
        return (kp4) invokeV.objValue;
    }

    public String getNid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mNid : (String) invokeV.objValue;
    }

    public String getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.mNotice : (String) invokeV.objValue;
    }

    public int getOperatorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.operator_flag : invokeV.intValue;
    }

    public int getOriginalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.originalThreadType : invokeV.intValue;
    }

    public PostData getPbFirstShareData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.pbFirstShareData : (PostData) invokeV.objValue;
    }

    public String getPbTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.mPbTitle : (String) invokeV.objValue;
    }

    public String getPhotoLiveCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mPhotoLiveCover : (String) invokeV.objValue;
    }

    public MediaData getPicMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.mPicMediaData : (MediaData) invokeV.objValue;
    }

    public PollData getPollData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.mPollData : (PollData) invokeV.objValue;
    }

    public int getPositionInFrsItemTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.positionInFrsItemTab : invokeV.intValue;
    }

    public int getPost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.post_num : invokeV.intValue;
    }

    public PraiseData getPraise() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.praise : (PraiseData) invokeV.objValue;
    }

    public ArrayList<og5> getPrefixIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            ArrayList<og5> arrayList = new ArrayList<>();
            if (this.isSCard) {
                arrayList.add(new og5(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ff9)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<TwAnchorProfitItem> getProfitList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.profitList : (List) invokeV.objValue;
    }

    public PushStatusData getPushStatusData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.mPushStatusData : (PushStatusData) invokeV.objValue;
    }

    public ThreadInfo getRawThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.rawThreadInfo : (ThreadInfo) invokeV.objValue;
    }

    public int getRecomCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (isRealGod()) {
                return 4;
            }
            if (isLiveThread() || isLiveRecordThread()) {
                return 3;
            }
            if (isBJHArticleThreadType()) {
                return 5;
            }
            if (isBJHVideoThreadType()) {
                return 6;
            }
            if (isBJHNormalThreadType()) {
                return 7;
            }
            if (isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (!this.isShareThread || this.originalThreadData == null) {
                return isRealVideoThread() ? 2 : 1;
            }
            return 9;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.nn4
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.mRecomReason : (String) invokeV.objValue;
    }

    public String getRecomSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mRecomSource : (String) invokeV.objValue;
    }

    public String getReplyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.replyTime : (String) invokeV.objValue;
    }

    public String getReplyTimeForMyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.replyTimeForMyThread : (String) invokeV.objValue;
    }

    public int getReply_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.reply_num : invokeV.intValue;
    }

    public List<ReportInfo> getReportInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.mReportInfoList : (List) invokeV.objValue;
    }

    public int getRepost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.repost_num : invokeV.intValue;
    }

    public int getResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.mResourceType : invokeV.intValue;
    }

    public List<PbContent> getRichAbstractList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.mRichAbstractList : (List) invokeV.objValue;
    }

    public List<PbContent> getRichTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.mRichTitleList : (List) invokeV.objValue;
    }

    public String getRightHotIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.mRightUrl : (String) invokeV.objValue;
    }

    public String getSecondClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mSecondClassName : (String) invokeV.objValue;
    }

    public String getShareImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.mShareImageUrl : (String) invokeV.objValue;
    }

    public String getShareIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.shareIntro : (String) invokeV.objValue;
    }

    public long getShareNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.mShareNum : invokeV.longValue;
    }

    public int getShow_commented() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.show_commented : invokeV.intValue;
    }

    public SkinInfo getSkinInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.mSkinInfoData : (SkinInfo) invokeV.objValue;
    }

    public SmartApp getSmartApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.mSmartApp : (SmartApp) invokeV.objValue;
    }

    public int getSmartFrsPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.smartFrsPosition : invokeV.intValue;
    }

    public SpannableStringBuilder getSpan_str() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.span_str : (SpannableStringBuilder) invokeV.objValue;
    }

    public int getStoreCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.mStoreCount : invokeV.intValue;
    }

    public int getStyle_flag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.style_flag : invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.mTabId : invokeV.intValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.mTabName : (String) invokeV.objValue;
    }

    public int getTabShowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.mTabShowMode : invokeV.intValue;
    }

    public oq4 getTaskInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.taskInfoData : (oq4) invokeV.objValue;
    }

    public int getTaskInfoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            oq4 oq4Var = this.taskInfoData;
            if (oq4Var != null) {
                long e = oq4Var.e();
                long a = this.taskInfoData.a();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < e) {
                    return 1;
                }
                return currentTimeMillis > a ? 3 : 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public AlaInfoData getThreadAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.threadAlaInfo : (AlaInfoData) invokeV.objValue;
    }

    @Override // com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this : (ThreadData) invokeV.objValue;
    }

    public String getThreadExtendInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.threadExtendInfo : (String) invokeV.objValue;
    }

    public List<ThreadRecommendInfoData> getThreadRecommendInfoDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.threadRecommendInfoDataList : (List) invokeV.objValue;
    }

    public ThreadRecommendTagData getThreadRecommendTagData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.threadRecommendTagData : (ThreadRecommendTagData) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.threadType : invokeV.intValue;
    }

    public vq4 getThreadVideoChannelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.threadVideoChannelInfo : (vq4) invokeV.objValue;
    }

    public VideoInfo getThreadVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.threadVideoInfo : (VideoInfo) invokeV.objValue;
    }

    public VideoDesc getThreadVideoSegment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.threadVideoSegment : (VideoDesc) invokeV.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            if (!StringUtils.isNull(this.tid) && !"0".equals(this.tid)) {
                return this.tid;
            }
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<ah5> getTiePlusLinkOriginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.tiePlusLinkOriginData : (List) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.time : invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public SpannableStringBuilder getTitleText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.titleText : (SpannableStringBuilder) invokeV.objValue;
    }

    public PostData getTopAgreePost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.mTopAgreePost : (PostData) invokeV.objValue;
    }

    public sq4 getTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? this.topicData : (sq4) invokeV.objValue;
    }

    public TopicModule getTopicModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.mTopicModule : (TopicModule) invokeV.objValue;
    }

    public String getTopicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.topicUrl : (String) invokeV.objValue;
    }

    public String getTopicUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.topicUserName : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            mi8 mi8Var = this.funAdData;
            if (mi8Var != null) {
                return mi8Var.f() ? this.funAdData.g() ? AdvertAppInfo.D : AdvertAppInfo.E : this.funAdData.g() ? AdvertAppInfo.D : AdvertAppInfo.C;
            } else if (getIsDailyThread()) {
                if (getThreadVideoInfo() != null) {
                    return TYPE_VIDEO;
                }
                return TYPE_NORMAL;
            } else {
                int is_top = getIs_top();
                if (this.isTopic == 1) {
                    if (this.mTopicModule != null) {
                        return TYPE_TOPIC;
                    }
                    return this.mHotTopicInfo != null ? TYPE_FRS_HOTTOPIC_VIDEO : TYPE_FRS_HOTTOPIC;
                } else if (this.threadAlaInfo != null && this.threadType == 60) {
                    return TYPE_ALA_SHARE_THREAD;
                } else {
                    if (this.threadAlaInfo != null && ((i = this.threadType) == 49 || i == 69)) {
                        return TYPE_VIDEO_ALA_ONLIVE;
                    }
                    if (this.threadAlaInfo != null && this.threadType == 67) {
                        return TYPE_ALA_FRIEND_ROOM;
                    }
                    int i2 = this.threadType;
                    if (i2 == 51) {
                        return TYPE_ALA_LIVE_EMPTY;
                    }
                    if (i2 == 63) {
                        return TYPE_SMART_APP_IMAGE;
                    }
                    if (i2 == 64) {
                        return TYPE_SMART_APP_VIDEO;
                    }
                    if (is_top != 2 && is_top != 1) {
                        if (this.threadVideoInfo != null && isInsertThread() && !isLiveInterviewLiveType()) {
                            return TYPE_INSERT_VIDEO;
                        }
                        if (this.threadVideoInfo != null && !isLiveInterviewLiveType()) {
                            if (isGodThread()) {
                                return TYPE_VIDEO_GOD;
                            }
                            if (this instanceof lp4) {
                                return TYPE_FAKE_VIDEO;
                            }
                            return TYPE_VIDEO;
                        } else if (this.isShareThread && (originalThreadInfo = this.originalThreadData) != null) {
                            if (originalThreadInfo.x) {
                                if (originalThreadInfo.r != null) {
                                    return TYPE_NEW_VIDEO_SHARE_THREAD;
                                }
                                if (originalThreadInfo.h()) {
                                    return TYPE_ARTICLE_SHARE_THREAD;
                                }
                                return TYPE_NEW_NORMAL_SHARE_THREAD;
                            }
                            return TYPE_SHARE_THREAD;
                        } else if (isBJHArticleThreadType()) {
                            return TYPE_ARTICLE;
                        } else {
                            if (isInterviewLiveStyle()) {
                                return isFRSExtraLoaded.get() ? TYPE_STAR_INTERVIEW : TYPE_NORMAL;
                            } else if (isActInfo() && getActInfoType() == 1) {
                                return isFRSExtraLoaded.get() ? TYPE_LOTTERY : TYPE_NORMAL;
                            } else if (isLinkThread()) {
                                return TYPE_LINK;
                            } else {
                                if (isGodThread()) {
                                    return TYPE_GOD_NORMAL;
                                }
                                if (this.isUserType) {
                                    return TYPE_USER_NORMAL;
                                }
                                if (this.isContentTextType) {
                                    return TYPE_CONTENT_TEXT_NORMAL;
                                }
                                if (this.isContentSingleHType) {
                                    return TYPE_CONTENT_SINGLE_H_NORMAL;
                                }
                                if (this.isContentSingleVType) {
                                    return TYPE_CONTENT_SINGLE_V_NORMAL;
                                }
                                if (this.isContentMutliPicType) {
                                    return TYPE_CONTENT_MULTI_PIC_NORMMAL;
                                }
                                if (this.isBottomType) {
                                    return TYPE_BOTTOM_NORMAL;
                                }
                                if (this.isGodReplyType) {
                                    return TYPE_GODREPLY_NORMAL;
                                }
                                if (this.isContentFeedPicType) {
                                    return TYPE_CONTENT_FEED_PIC_NORMMAL;
                                }
                                if (this.isItem) {
                                    return TYPE_ITEM;
                                }
                                if (this.isFrsKadunOpt) {
                                    int picCount = picCount();
                                    if (picCount == 1) {
                                        return TYPE_Single_NORMAL;
                                    }
                                    if (picCount == 2) {
                                        return TYPE_Double_NORMAL;
                                    }
                                    if (picCount > 2) {
                                        return TYPE_More_NORMAL;
                                    }
                                    return TYPE_NORMAL;
                                }
                                return TYPE_NORMAL;
                            }
                        }
                    }
                    return TYPE_TOP;
                }
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public int getVideoRecStaticticType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            if (isBJHVideoDynamicThreadType() || isBJHNormalThreadType()) {
                return 2;
            }
            return (isBJHArticleThreadType() || isBJHVideoThreadType()) ? 3 : 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            VideoInfo videoInfo = this.threadVideoInfo;
            if (videoInfo != null) {
                return videoInfo.video_url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getView_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.view_num : invokeV.intValue;
    }

    public ArrayList<VoiceData.VoiceModel> getVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.mVoices : (ArrayList) invokeV.objValue;
    }

    public VoiceRoom getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.mVoiceRoomData : (VoiceRoom) invokeV.objValue;
    }

    public String getWonderfulPostInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.mWonderfulPostInfo : (String) invokeV.objValue;
    }

    public int getYYStaticticType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if (getRecomCardType() == 1) {
                return 2;
            }
            if (getRecomCardType() == 2) {
                return 3;
            }
            return getRecomCardType() == 3 ? 1 : 4;
        }
        return invokeV.intValue;
    }

    public ar4 getYulePostActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.mYulePostActivityData : (ar4) invokeV.objValue;
    }

    public UserTbVipInfoData getbigVData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null) {
                return null;
            }
            return metaData.getUserTbVipInfoData();
        }
        return (UserTbVipInfoData) invokeV.objValue;
    }

    public void insertItemToTitleOrAbstractText() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || ListUtils.getCount(this.mItemStar) <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.titleText;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) rg5.e(this.mItemStar));
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.abstractText);
        spannableStringBuilder2.insert(0, (CharSequence) rg5.e(this.mItemStar));
        this.abstractText = new SpannableString(spannableStringBuilder2);
    }

    public void insertUsernameIntoTitleOrAbstract(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048737, this, spannableString) == null) || getAuthor() == null || showNoName() || showWeakenName()) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.titleText;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.abstractText);
        spannableStringBuilder2.insert(0, (CharSequence) spannableString);
        this.abstractText = new SpannableString(spannableStringBuilder2);
    }

    public boolean isActInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.is_activity == 1 : invokeV.booleanValue;
    }

    public boolean isAddedGood() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? getIs_good() == 1 : invokeV.booleanValue;
    }

    public boolean isAlaLiveUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? (getAuthor() == null || getAuthor().getAlaUserData() == null || getAuthor().getAlaUserData().live_status != 1) ? false : true : invokeV.booleanValue;
    }

    public boolean isAnonymityUser() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            MetaData metaData = this.author;
            return metaData == null || (userId = metaData.getUserId()) == null || userId.equals("0");
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHArticleThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 1;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHNormalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 3;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHVideoDynamicThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 4;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            return baijiahaoData != null && baijiahaoData.oriUgcType == 2;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? isUgcThreadType() : invokeV.booleanValue;
    }

    public boolean isBjhDynamicThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) ? isBJHNormalThreadType() || isBJHVideoDynamicThreadType() : invokeV.booleanValue;
    }

    public boolean isBlocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) ? this.isBlocked : invokeV.booleanValue;
    }

    public boolean isCommonUserThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null || metaData.getGodUserData() == null) {
                return true;
            }
            return (this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isConcernDynamicType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? isUgcThreadType() || this.isShareThread : invokeV.booleanValue;
    }

    public boolean isCopyTWzhibo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.isCopyTWzhibo : invokeV.booleanValue;
    }

    public boolean isDisplayHighQualityPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? isWorksInfo() : invokeV.booleanValue;
    }

    public boolean isDisplayOffcialPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            MetaData metaData = this.author;
            return metaData != null && metaData.isForumBusinessAccount();
        }
        return invokeV.booleanValue;
    }

    public boolean isFloor5Video() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.isFloor5Video : invokeV.booleanValue;
    }

    public boolean isFromConcern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) ? this.isFromConcern : invokeV.booleanValue;
    }

    @Override // com.repackage.nn4
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.isFromFrs : invokeV.booleanValue;
    }

    public boolean isFunAdPlaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            mi8 mi8Var = this.funAdData;
            if (mi8Var != null) {
                return mi8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGodThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            MetaData metaData = this.author;
            return (metaData == null || metaData.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isGoods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? this.isGoods : invokeV.booleanValue;
    }

    public boolean isHasPlayVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) ? this.hasPlayVirtualImage : invokeV.booleanValue;
    }

    public boolean isHeadLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) ? this.isHeadLive : invokeV.booleanValue;
    }

    public boolean isImShareFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) ? this.isImShareFromPb : invokeV.booleanValue;
    }

    public boolean isInsertThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) ? this.isInsertThread : invokeV.booleanValue;
    }

    public boolean isInterviewLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) ? this.threadType == 41 : invokeV.booleanValue;
    }

    public boolean isInterviewLiveStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) ? getTaskInfoData() != null && getThreadType() == 41 && getIsLive() == 1 && getTaskInfoStatus() == 2 : invokeV.booleanValue;
    }

    public boolean isLinkThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) ? this.isLinkThread : invokeV.booleanValue;
    }

    public boolean isLiveInterviewLiveType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) ? this.threadType == 41 : invokeV.booleanValue;
    }

    public boolean isLiveRecordThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) ? getThreadType() == 50 : invokeV.booleanValue;
    }

    public boolean isLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) ? getThreadType() == 49 || getThreadType() == 69 : invokeV.booleanValue;
    }

    public boolean isMadeTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) ? getIs_top() == 1 : invokeV.booleanValue;
    }

    public boolean isMarkToDel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) ? this.isMarkToDel : invokeV.booleanValue;
    }

    public boolean isMarkToMove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.mIsMarkToMove : invokeV.booleanValue;
    }

    public boolean isMutiForumThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) ? this.isMutiForumThread : invokeV.booleanValue;
    }

    public boolean isNeedCheckRepeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) ? this.mCheckRepeat : invokeV.booleanValue;
    }

    public boolean isNewGodAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            MetaData metaData = this.author;
            return metaData != null && metaData.isNewGod();
        }
        return invokeV.booleanValue;
    }

    public boolean isNormalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) ? this.threadType == 0 : invokeV.booleanValue;
    }

    public boolean isNovelThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) ? this.threadType == 31 : invokeV.booleanValue;
    }

    public boolean isPGCUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            MetaData metaData = this.author;
            return (metaData == null || metaData.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPhotoLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) ? this.threadType == 33 : invokeV.booleanValue;
    }

    public boolean isRealGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) ? this.is_god == 1 : invokeV.booleanValue;
    }

    public boolean isRealVideoThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) ? getThreadType() == 40 : invokeV.booleanValue;
    }

    public boolean isScoreThread() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) ? (this.itemData == null && getItem() == null && ((originalThreadInfo = this.originalThreadData) == null || originalThreadInfo.C == null)) ? false : true : invokeV.booleanValue;
    }

    public boolean isSharedLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) ? getThreadType() == 60 : invokeV.booleanValue;
    }

    public boolean isShowDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) ? getIsLive() == 1 || getIs_good() == 1 || getIs_top() == 1 || isActInfo() || this.isBookChapter == 1 || isGodThread() || getAppCodeData() != null || getYulePostActivityData() != null || !oi.isEmpty(getCategory()) || isRealGod() : invokeV.booleanValue;
    }

    public boolean isShowForumAndReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) ? (isWorksInfo() || isVideoThreadType()) && !StringUtils.isNull(this.forum_name) && this.isFromHomPage : invokeV.booleanValue;
    }

    public boolean isShowFullThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) ? this.isShowFullThread : invokeV.booleanValue;
    }

    public boolean isSmartAppThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            int i = this.threadType;
            return i == 63 || i == 64;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartFrsThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) ? this.isSmartFrsThread : invokeV.booleanValue;
    }

    public boolean isTargetTWzhi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) ? this.isTargetTWZhibo : invokeV.booleanValue;
    }

    public boolean isTbReadDispatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) ? this.isTbReadDispatch == 1 : invokeV.booleanValue;
    }

    public boolean isTiePlusCantDeleteUnion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) ? this.isTiebaPlusAdThread || this.tiebaplusCantDelete : invokeV.booleanValue;
    }

    public boolean isTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) ? getIs_top() != 0 : invokeV.booleanValue;
    }

    public boolean isTopicThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) ? this.isTopic == 1 : invokeV.booleanValue;
    }

    public boolean isTransportThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) ? this.mOriginalForumInfo != null : invokeV.booleanValue;
    }

    public boolean isUgcThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            if (baijiahaoData == null) {
                return false;
            }
            return UtilHelper.isUgcThreadType(baijiahaoData.oriUgcType);
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            int i = this.threadType;
            return i == 40 || i == 50;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoWorksInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) ? isVideoThreadType() && isWorksInfo() : invokeV.booleanValue;
    }

    public boolean isVocieRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) {
            VoiceRoom voiceRoom = this.mVoiceRoomData;
            return voiceRoom != null && voiceRoom.room_id.longValue() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVoiceThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) ? this.threadType == 11 || this.isVoiceThread == 1 : invokeV.booleanValue;
    }

    public boolean isVoteThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048800, this)) == null) ? this.threadType == 36 : invokeV.booleanValue;
    }

    public boolean isWorksInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            WorksInfoData worksInfoData = this.worksInfoData;
            return worksInfoData != null && worksInfoData.isWorks;
        }
        return invokeV.booleanValue;
    }

    public boolean needShowGodTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) ? this.is_god != 0 : invokeV.booleanValue;
    }

    public boolean notShowHideThreadBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) {
            UserPostPerm userPostPerm = this.userPostPerm;
            return userPostPerm != null && userPostPerm.not_show_hide_thread.intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public SpannableString parseAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            SpannableStringBuilder parseRichAbastract = parseRichAbastract();
            ux5.b(this, parseRichAbastract, false);
            return new SpannableString(parseRichAbastract);
        }
        return (SpannableString) invokeV.objValue;
    }

    public SpannableString parseFirstFloorContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048805, this)) == null) {
            if (ListUtils.isEmpty(this.mFirstFloorList)) {
                return null;
            }
            return new SpannableString(rg5.C(this, this.mFirstFloorList, this.abstract_text));
        }
        return (SpannableString) invokeV.objValue;
    }

    public void parseFromWriteData(WriteData writeData) {
        String n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048806, this, writeData) == null) || writeData == null) {
            return;
        }
        try {
            this.id = "0";
            this.tid = "";
            this.fid = ng.g(writeData.getForumId(), 0L);
            this.title = writeData.getTitle();
            this.mCreateTime = System.currentTimeMillis() / 1000;
            this.last_time = (System.currentTimeMillis() / 1000) + "";
            this.last_time_int = System.currentTimeMillis() / 1000;
            MetaData metaData = new MetaData();
            this.author = metaData;
            metaData.parseFromCurrentUser();
            this.authorId = TbadkCoreApplication.getCurrentAccount();
            this.forum_name = writeData.getForumName();
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
            if (oi.isEmpty(kk8.k().n())) {
                n = writeData.getVideoInfo().getThumbPath();
            } else {
                n = kk8.k().n();
            }
            builder.thumbnail_url = n;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.threadVideoInfo = builder.build(true);
            this.threadType = 40;
            this.time = System.currentTimeMillis();
            this.isNoTitle = writeData.isNoTitle() ? 1 : 0;
            this.abstract_text = writeData.getContent();
            mq4 mq4Var = new mq4();
            this.forumData = mq4Var;
            mq4Var.a = writeData.getForumId();
            this.forumData.b = writeData.getForumName();
            this.mTabId = writeData.getTabId();
            this.mTabName = writeData.getTabName();
            parseFromVideoRichTitle(writeData.getTitle());
            praserTimeConsumingInfo();
            if (StringUtils.isNull(writeData.getItem_id()) || writeData.getItemInfo() == null) {
                return;
            }
            Item.Builder builder2 = new Item.Builder();
            builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
            builder2.icon_url = writeData.getItemInfo().getIconUrl();
            builder2.item_name = writeData.getItemInfo().getTitle();
            builder2.tags = writeData.getItemInfo().getTags();
            builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
            builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
            this.mItem = builder2.build(true);
            ItemData itemData = new ItemData();
            this.itemData = itemData;
            itemData.parseItemInfo(writeData.getItemInfo());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public SpannableStringBuilder parseRichAbastract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) {
            if (this.tiePlusLinkOriginData == null) {
                this.tiePlusLinkOriginData = new ArrayList();
            }
            return rg5.D(this, this.mRichAbstractList, this.abstract_text, this.tiePlusLinkOriginData);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public SpannableStringBuilder parseRichTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) ? rg5.C(this, this.mRichTitleList, this.title) : (SpannableStringBuilder) invokeV.objValue;
    }

    public void parseStyle_flag(ArrayList<jo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, arrayList) == null) {
            if (this.isNoTitle == 1) {
                this.style_flag = 0;
            } else if (arrayList != null && arrayList.size() > 0) {
                this.style_flag = 0;
                Iterator<jo4> it = arrayList.iterator();
                while (it.hasNext()) {
                    jo4 next = it.next();
                    if (next != null && next.a() != null && !StringUtils.isNull(this.title)) {
                        Iterator<String> it2 = next.a().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String next2 = it2.next();
                                if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                    this.style_flag = next.b();
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                this.style_flag = 0;
            }
        }
    }

    public SpannableStringBuilder parseTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) {
            if (StringUtils.isNull(this.title) || this.isNoTitle == 1) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parseRichTitle());
            this.span_str = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public SpannableStringBuilder parseTitleOrAbstractForFrs(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        SpannableStringBuilder parseRichTitle;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048812, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (this.isNoTitle == 1) {
                parseRichTitle = parseRichAbastract();
                spannableStringBuilder = parseRichTitle.toString();
            } else {
                parseRichTitle = parseRichTitle();
                spannableStringBuilder = parseRichTitle.toString();
            }
            SpannableStringBuilder spannableStringBuilder3 = parseRichTitle;
            String str = spannableStringBuilder;
            if (z) {
                spannableStringBuilder2 = addPrefix(str, spannableStringBuilder3, z, true, z2, z3);
            } else {
                spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder3);
            }
            this.span_str = spannableStringBuilder2;
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public SpannableStringBuilder parseTitleOrAbstractForFrsNew(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder parseRichAbastract;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048813, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!StringUtils.isNull(this.title) && this.isNoTitle != 1) {
                parseRichAbastract = parseRichTitle();
            } else {
                parseRichAbastract = parseRichAbastract();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parseRichAbastract);
            this.span_str = spannableStringBuilder;
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    @Deprecated
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048814, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.id = jSONObject.optString("id");
            this.fid = jSONObject.optLong("fid", 0L);
            this.tid = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.is_god = jSONObject.optInt("is_god");
            this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
            this.mAuditTime = jSONObject.optLong("audit_time", 0L) * 1000;
            this.reply_num = jSONObject.optInt("reply_num", 0);
            this.repost_num = jSONObject.optInt("repost_num", 0);
            this.view_num = jSONObject.optInt("view_num", 0);
            this.last_time = jSONObject.optString("last_time");
            this.last_time_int = jSONObject.optLong("last_time_int", 0L);
            this.is_top = jSONObject.optInt("is_top", 0);
            this.is_membertop = jSONObject.optInt("is_membertop", 0);
            this.is_good = jSONObject.optInt("is_good", 0);
            this.is_live = jSONObject.optInt("is_livepost", 0);
            this.topicData.c(jSONObject.optJSONObject("topic"));
            this.authorId = jSONObject.optString("author_id");
            this.author.parserJson(jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR));
            this.forum_name = jSONObject.optString("fname");
            this.has_commented = jSONObject.optInt("has_commented", 0);
            this.show_commented = jSONObject.optInt("show_commented", 0);
            this.ad_url = jSONObject.optString("click_url");
            this.from = jSONObject.optString("from");
            this.isMarked = jSONObject.optInt("collect_status");
            this.markID = jSONObject.optString("collect_mark_pid");
            this.isVoiceThread = jSONObject.optInt("is_voice_thread");
            this.threadType = jSONObject.optInt("thread_type");
            this.originalThreadType = jSONObject.optInt("thread_type");
            this.mShareNum = jSONObject.optLong("share_num");
            this.first_post_id = jSONObject.optString("first_post_id", "0");
            this.mFirstPostId = jSONObject.optString("post_id", "0");
            this.time = jSONObject.optLong("time", 0L) * 1000;
            this.isNoTitle = jSONObject.optInt("is_ntitle");
            this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
            this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
            this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
            this.agreeData.threadId = this.tid;
            JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
            ArrayList<DislikeInfo> arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (optJSONArray.getJSONObject(i) != null) {
                        DislikeInfo.Builder builder = new DislikeInfo.Builder();
                        builder.dislike_reason = optJSONArray.getJSONObject(i).optString("dislike_reason");
                        builder.dislike_id = Integer.valueOf(optJSONArray.getJSONObject(i).optInt("dislike_id"));
                        arrayList.add(builder.build(true));
                    }
                }
            }
            if (ListUtils.getCount(arrayList) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : arrayList) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.feedBackReasonMap = sparseArray;
                this.feedBackExtraMap = sparseArray2;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
            if (optJSONObject2 != null) {
                this.taskInfoData.k(optJSONObject2);
            }
            if ((this.author == null || this.author.getUserId() == null) && this.userMap != null) {
                this.author = this.userMap.get(this.authorId);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
            if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                this.address = optJSONObject.optString("location");
            }
            this.labelUrl = jSONObject.optString("label_url");
            this.modeUrl = jSONObject.optString("mode_url");
            this.location = jSONObject.optString("location");
            AlaInfoData alaInfoData = new AlaInfoData();
            this.threadAlaInfo = alaInfoData;
            alaInfoData.parserJson(jSONObject.optJSONObject("ala_info"));
            StringBuilder sb = new StringBuilder();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                        sb.append(optJSONArray2.getJSONObject(i2).optString("text"));
                    }
                }
            }
            this.abstract_text = sb.toString();
            JSONArray optJSONArray3 = jSONObject.optJSONArray(VodClient.PATH_MEDIA);
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                    this.mMedias.add(mediaData);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("voice_info");
            if (optJSONArray4 != null) {
                int length = optJSONArray4.length();
                for (int i4 = 0; i4 < length; i4++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    JSONObject jSONObject3 = optJSONArray4.getJSONObject(i4);
                    voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceModel.voiceId = jSONObject3.optString("voice_md5");
                    voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                    this.mVoices.add(voiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
            if (optJSONArray5 != null) {
                for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                    on4 on4Var = new on4();
                    on4Var.h(optJSONArray5.getJSONObject(i5));
                    this.mActDatas.add(on4Var);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                ar4 ar4Var = new ar4();
                this.mYulePostActivityData = ar4Var;
                ar4Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                wn4 wn4Var = new wn4();
                this.mAppCodeData = wn4Var;
                wn4Var.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                io4 io4Var = new io4();
                this.mCartoonThreadData = io4Var;
                io4Var.c(optJSONObject6);
            }
            this.praise.setUserMap(this.userMap);
            this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!oi.isEmpty(this.title)) {
                this.praise.setTitle(this.title);
            } else {
                this.praise.setTitle(this.abstract_text);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.taskInfoData.k(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                    f05 f05Var = new f05();
                    f05Var.a(optJSONArray6.getJSONObject(i6));
                    this.mExtTails.add(f05Var);
                }
            }
            this.isBookChapter = jSONObject.optInt("is_book_chapter", 0);
            this.bookChapterData.a(jSONObject.optJSONObject("book_chapter"));
            this.mRecomSource = jSONObject.optString("recom_source");
            this.mRecomReason = jSONObject.optString("recom_reason");
            this.mRecomReasonIcon = jSONObject.optString("recom_tag_icon");
            this.mRecomWeight = jSONObject.optString(TiebaStatic.Params.RECOM_WEIGHT);
            this.mRecomExtra = jSONObject.optString(TiebaStatic.Params.RECOM_EXTRA);
            this.mRecomExtraImg = jSONObject.optString("recom_extra_img");
            this.mRecomExtraNightImg = jSONObject.optString("recom_extra_img_night");
            this.mRecomExtraImgWidth = jSONObject.optInt("recom_extra_img_width", 0);
            this.mRecomExtraImgHeight = jSONObject.optInt("recom_extra_img_height", 0);
            this.mLastReadPid = jSONObject.optLong("last_read_pid");
            this.mCheckRepeat = jSONObject.optInt("cheak_repeat") == 1;
            JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
            if (optJSONObject8 != null) {
                vq4 vq4Var = new vq4();
                this.threadVideoChannelInfo = vq4Var;
                vq4Var.a(optJSONObject8);
            }
            this.isMutiForumThread = jSONObject.optInt("is_multiforum_thread") == 1;
            this.isLinkThread = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.isLinkThread && optJSONObject9 != null) {
                fp4 fp4Var = new fp4();
                this.linkThreadData = fp4Var;
                fp4Var.g(optJSONObject9);
            }
            this.partialVisible = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                vn4 vn4Var = new vn4();
                this.specialData = vn4Var;
                vn4Var.a(optJSONObject10);
            }
            JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
            if (optJSONObject11 != null) {
                MediaData mediaData2 = new MediaData();
                this.mPicMediaData = mediaData2;
                mediaData2.parserJson(optJSONObject11);
            }
            this.is_called = jSONObject.optInt("is_called", 0);
            this.middle_page_num = jSONObject.optInt("middle_page_num", 0);
            this.middle_page_pass_flag = jSONObject.optInt("middle_page_pass_flag", 0);
            JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
            if (optJSONObject12 != null) {
                VideoInfo.Builder builder2 = new VideoInfo.Builder();
                builder2.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                builder2.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                builder2.video_md5 = optJSONObject12.optString(VideoFinishResult.KEY_VIDEO_MD5);
                builder2.video_url = optJSONObject12.optString("video_url");
                builder2.video_duration = new Integer(optJSONObject12.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                builder2.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                builder2.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                builder2.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                builder2.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                builder2.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                builder2.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                builder2.is_vertical = new Integer(optJSONObject12.optInt(TiebaStatic.Params.IS_VERTICAL, 0));
                builder2.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                this.threadVideoInfo = builder2.build(true);
            }
            boolean z = jSONObject.optInt(VideoPlayActivityConfig.IS_SHARE_THREAD, 0) == 1;
            this.isShareThread = z;
            if (z) {
                JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                if (optJSONObject13 != null) {
                    OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                    this.originalThreadData = originalThreadInfo;
                    originalThreadInfo.q(optJSONObject13);
                } else {
                    this.originalThreadData = null;
                }
            } else {
                this.originalThreadData = null;
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
            if (optJSONObject14 != null) {
                SmartApp.Builder builder3 = new SmartApp.Builder();
                builder3.avatar = optJSONObject14.optString("avatar");
                builder3.name = optJSONObject14.optString("name");
                builder3._abstract = optJSONObject14.optString("abstract");
                builder3.pic = optJSONObject14.optString("pic");
                builder3.h5_url = optJSONObject14.optString("h5_url");
                builder3.id = optJSONObject14.optString("id");
                builder3.link = optJSONObject14.optString("link");
                this.mSmartApp = builder3.build(false);
            }
            this.mShareImageUrl = jSONObject.optString("t_share_img");
            this.mNid = jSONObject.optString("nid");
            this.isHeadLinePost = jSONObject.optInt("is_headlinepost", 0) == 1;
            this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
            this.bjhContentTag = jSONObject.optInt("bjh_content_tag");
            this.articeCover = jSONObject.optString("article_cover");
            JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
            if (optJSONObject15 != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.mBaijiahao = baijiahaoData;
                baijiahaoData.parseJson(optJSONObject15);
                this.agreeData.baijiahaoData = this.mBaijiahao;
            }
            this.isSCard = jSONObject.optInt("is_s_card", 0) == 1;
            this.scardPacketId = jSONObject.optString("scard_packet_id");
            this.mTabId = jSONObject.optInt("tab_id");
            this.mTabName = jSONObject.optString("tab_name");
            this.mWonderfulPostInfo = jSONObject.optString("wonderful_post_info");
            this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
            this.noCommetStr = jSONObject.optString("if_comment_info");
            JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
            if (optJSONObject16 != null) {
                if (this.mPollData == null) {
                    this.mPollData = new PollData();
                }
                this.mPollData.parserJson(optJSONObject16);
            }
            JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
            if (optJSONArray7 != null) {
                for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                    if (pbLinkData.urlType == 2 && !this.isGoods) {
                        this.isGoods = true;
                    }
                    this.mLinkDataList.add(pbLinkData);
                }
            }
            JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
            if (optJSONArray8 != null) {
                for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                    this.mGoodsDataList.add(pbGoodsData);
                }
                if (this.mGoodsDataList.size() > 0 && !this.isGoods) {
                    this.isGoods = true;
                }
            }
            this.hotNum = jSONObject.optInt("hot_num", -1);
            this.isLocal = jSONObject.optInt("is_local") == 1;
            JSONObject optJSONObject17 = jSONObject.optJSONObject("works_info");
            if (optJSONObject17 != null) {
                if (this.worksInfoData == null) {
                    this.worksInfoData = new WorksInfoData();
                }
                this.worksInfoData.parseJson(optJSONObject17);
            }
            this.collectNum = jSONObject.optInt("collect_num");
            JSONArray optJSONArray9 = jSONObject.optJSONArray("thread_recommend_infos");
            if (optJSONArray9 != null) {
                for (int i9 = 0; i9 < optJSONArray9.length(); i9++) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseJson(optJSONArray9.getJSONObject(i9));
                    this.threadRecommendInfoDataList.add(threadRecommendInfoData);
                }
            }
            mq4 mq4Var = new mq4();
            this.forumData = mq4Var;
            mq4Var.i(jSONObject.optJSONObject("forum_info"));
            this.isAuthorView = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.mPhotoLiveCover = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.mRichAbstractList = pp4.a(optJSONArray10);
            }
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.mRichTitleList = pp4.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.mFirstFloorList = pp4.a(optJSONArray12);
            }
            JSONObject optJSONObject18 = jSONObject.optJSONObject("star_rank_icon");
            if (optJSONObject18 != null) {
                this.iconPicUrl = optJSONObject18.optString("icon_pic_url");
                this.iconLink = optJSONObject18.optString("icon_link");
            }
            JSONObject optJSONObject19 = jSONObject.optJSONObject("location");
            if (optJSONObject19 != null) {
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LAT))) {
                    this.latitude = optJSONObject19.optString(SuggestAddrField.KEY_LAT);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString(SuggestAddrField.KEY_LNG))) {
                    this.longtitude = optJSONObject19.optString(SuggestAddrField.KEY_LNG);
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("name"))) {
                    this.address = optJSONObject19.optString("name");
                }
                if (!TextUtils.isEmpty(optJSONObject19.optString("distance"))) {
                    this.distance = optJSONObject19.optString("distance");
                }
            }
            JSONObject optJSONObject20 = jSONObject.optJSONObject("ori_forum_info");
            if (optJSONObject20 != null) {
                OriginalForumInfo originalForumInfo = new OriginalForumInfo();
                originalForumInfo.id = optJSONObject20.optLong("ori_fid") + "";
                originalForumInfo.ori_fname = optJSONObject20.optString("ori_fname");
                originalForumInfo.ori_avatar = optJSONObject20.optString("ori_avatar");
                originalForumInfo.ori_member_num = optJSONObject20.optLong("ori_member_num");
                this.mOriginalForumInfo = originalForumInfo;
            }
            JSONArray optJSONArray13 = jSONObject.optJSONArray("item_star");
            if (optJSONArray13 != null) {
                for (int i10 = 0; i10 < optJSONArray13.length(); i10++) {
                    JSONObject optJSONObject21 = optJSONArray13.optJSONObject(i10);
                    if (optJSONObject21 != null) {
                        HeadItem.Builder builder4 = new HeadItem.Builder();
                        builder4.content = optJSONObject21.optString("content");
                        builder4.name = optJSONObject21.optString("name");
                        builder4.type = Integer.valueOf(optJSONObject21.optInt("type"));
                        if (this.mItemStar == null) {
                            this.mItemStar = new ArrayList();
                        }
                        this.mItemStar.add(builder4.build(true));
                    }
                }
            }
            JSONObject optJSONObject22 = jSONObject.optJSONObject("item");
            if (optJSONObject22 != null && 0 != optJSONObject22.optLong("item_id")) {
                Item.Builder builder5 = new Item.Builder();
                builder5.item_id = Long.valueOf(optJSONObject22.optLong("item_id"));
                builder5.item_name = optJSONObject22.optString("item_name");
                builder5.icon_size = Double.valueOf(optJSONObject22.optDouble("icon_size"));
                builder5.score = Double.valueOf(optJSONObject22.optDouble("score"));
                builder5.icon_url = optJSONObject22.optString("icon_url");
                builder5.star = Integer.valueOf(optJSONObject22.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
                builder5.forum_name = optJSONObject22.optString("forum_name");
                builder5.apk_name = optJSONObject22.optString("apk_name");
                builder5.button_link = optJSONObject22.optString("button_link");
                builder5.button_link_type = Integer.valueOf(optJSONObject22.optInt("button_link_type"));
                builder5.button_name = optJSONObject22.optString("button_name");
                JSONObject optJSONObject23 = optJSONObject22.optJSONObject("apk_detail");
                if (optJSONObject23 != null) {
                    ApkDetail.Builder builder6 = new ApkDetail.Builder();
                    builder6.authority_url = optJSONObject23.optString("authority_url");
                    builder6.developer = optJSONObject23.optString("developer");
                    builder6.publisher = optJSONObject23.optString("publisher");
                    builder6.privacy_url = optJSONObject23.optString("privacy_url");
                    builder6.size = optJSONObject23.optString("size");
                    builder6.update_time = optJSONObject23.optString("update_time");
                    builder6.version = optJSONObject23.optString("version");
                    builder6.version_code = Integer.valueOf(optJSONObject23.optInt("version_code"));
                    builder6.need_inner_buy = Integer.valueOf(optJSONObject23.optInt("need_inner_buy"));
                    builder6.need_network = Integer.valueOf(optJSONObject23.optInt("need_network"));
                    builder6.pkg_source = Integer.valueOf(optJSONObject23.optInt("pkg_source"));
                    builder5.apk_detail = builder6.build(true);
                }
                JSONArray optJSONArray14 = optJSONObject22.optJSONArray("tags");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray14 != null) {
                    for (int i11 = 0; i11 < optJSONArray14.length(); i11++) {
                        arrayList2.add(optJSONArray14.optString(i11));
                    }
                    builder5.tags = arrayList2;
                }
                Item build = builder5.build(true);
                if (build != null) {
                    this.mItem = build;
                    ItemData itemData = new ItemData();
                    this.itemData = itemData;
                    itemData.parseProto(build);
                }
            }
            this.isTiebaPlusAdThread = StringHelper.equals(jSONObject.optString("is_tiebaplus_ad"), "1");
            this.tiebaPlusOrderId = jSONObject.optString("tiebaplus_order_id");
            this.tiebaPlusToken = jSONObject.optString("tiebaplus_token");
            this.tiebaPlusExtraParam = jSONObject.optString("tiebaplus_extra_param");
            this.tiebaplusCantDelete = jSONObject.optInt("tiebaplus_cant_delete") == 1;
            this.mTabShowMode = jSONObject.optInt("tab_show_mode");
            JSONObject optJSONObject24 = jSONObject.optJSONObject("tiebaplus_ad");
            if (optJSONObject24 != null) {
                this.tiePlusAdSource = optJSONObject24.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
                this.tiePlusShowUrl = optJSONObject24.optString("show_url");
                this.tiePlusCostUrl = optJSONObject24.optString("cost_url");
            }
            this.tiePlusMonitorShowUrl = jSONObject.optString("exposure_monitor_url");
            this.tiePlusMonitorClickUrl = jSONObject.optString("click_monitor_url");
            JSONObject optJSONObject25 = jSONObject.optJSONObject("recommend_tip");
            if (optJSONObject25 != null) {
                ForumRecTip forumRecTip = new ForumRecTip();
                this.forumRecTip = forumRecTip;
                forumRecTip.parseJson(optJSONObject25);
            }
            praserTimeConsumingInfo();
            JSONObject optJSONObject26 = jSONObject.optJSONObject("voice_room");
            if (optJSONObject26 != null) {
                VoiceRoom.Builder builder7 = new VoiceRoom.Builder();
                builder7.room_id = Long.valueOf(optJSONObject26.optLong("room_id"));
                builder7.room_name = optJSONObject26.getString(DpStatConstants.KEY_ROOM_NAME);
                this.mVoiceRoomData = builder7.build(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048815, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        try {
            if (threadInfo.location != null) {
                this.latitude = threadInfo.location.lat;
                this.longtitude = threadInfo.location.lng;
                this.address = threadInfo.location.name;
                this.distance = threadInfo.location.distance;
            }
            this.isTbReadDispatch = threadInfo.is_tbread_dispatch.intValue();
            this.id = threadInfo.id + "";
            this.tid = threadInfo.tid + "";
            this.fid = threadInfo.fid.longValue();
            this.title = threadInfo.title;
            this.is_god = threadInfo.is_god.intValue();
            this.mCreateTime = threadInfo.create_time.intValue() * 1000;
            this.mAuditTime = threadInfo.audit_time.longValue() * 1000;
            this.reply_num = threadInfo.reply_num.intValue();
            this.repost_num = threadInfo.repost_num.intValue();
            this.view_num = threadInfo.view_num.intValue();
            this.last_time = threadInfo.last_time;
            this.last_time_int = threadInfo.last_time_int.intValue();
            this.is_top = threadInfo.is_top.intValue();
            this.is_membertop = threadInfo.is_membertop.intValue();
            this.is_good = threadInfo.is_good.intValue();
            this.is_live = threadInfo.is_livepost.intValue();
            this.topicData.d(threadInfo.topic);
            this.author.parserProtobuf(threadInfo.author);
            this.authorId = threadInfo.author_id.toString();
            this.forum_name = threadInfo.fname;
            this.has_commented = threadInfo.has_commented.intValue();
            this.show_commented = threadInfo.show_commented.intValue();
            this.ad_url = threadInfo.click_url;
            this.threadVideoInfo = threadInfo.video_info;
            this.threadVideoSegment = threadInfo.video_segment;
            AlaInfoData alaInfoData = new AlaInfoData();
            this.threadAlaInfo = alaInfoData;
            alaInfoData.parserProtobuf(threadInfo.ala_info);
            this.from = threadInfo.from;
            this.isMarked = threadInfo.collect_status.intValue();
            this.markID = threadInfo.collect_mark_pid;
            this.isVoiceThread = threadInfo.is_voice_thread.intValue();
            this.threadType = threadInfo.thread_type.intValue();
            this.originalThreadType = threadInfo.thread_type.intValue();
            this.first_post_id = threadInfo.first_post_id + "";
            this.mFirstPostId = threadInfo.post_id + "";
            this.time = ((long) threadInfo.time.intValue()) * 1000;
            this.isNoTitle = threadInfo.is_ntitle.intValue();
            this.is_activity = threadInfo.is_activity.intValue();
            if (threadInfo.agree != null) {
                this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                this.agreeData.parseProtobuf(threadInfo.agree);
            }
            if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                this.tieba_game_information_source = threadInfo.tieba_game_information_source;
            } else {
                this.tieba_game_information_source = "";
            }
            this.mShareNum = threadInfo.share_num.longValue();
            this.category_name = threadInfo.category_name;
            this.operator_flag = threadInfo.operator_flag.intValue();
            if (threadInfo.is_operate_thread != null) {
                this.isOperateThread = threadInfo.is_operate_thread.intValue() == 1;
            }
            this.mRichTitleList = threadInfo.rich_title;
            this.mFirstFloorList = threadInfo.first_post_content;
            this.mRichAbstractList = threadInfo.rich_abstract;
            this.isGodthreadRecommend = threadInfo.is_godthread_recommend.intValue();
            if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0") || this.forceReadUserMap) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                this.author = metaData;
            }
            StringBuilder sb = new StringBuilder();
            List<Abstract> list = threadInfo._abstract;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null && list.get(i).type.intValue() == 0) {
                        sb.append(list.get(i).text);
                    }
                }
            }
            this.abstract_text = sb.toString();
            List<Media> list2 = threadInfo.media;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    MediaData mediaData = new MediaData();
                    mediaData.parserProtobuf(list2.get(i2));
                    this.mMedias.add(mediaData);
                }
            }
            if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                this.threadVideoInfo = threadInfo.video_info;
            }
            if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                vq4 vq4Var = new vq4();
                this.threadVideoChannelInfo = vq4Var;
                vq4Var.b(threadInfo.video_channel_info);
            }
            List<Voice> list3 = threadInfo.voice_info;
            if (list3 != null) {
                int size = list3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    Voice voice = list3.get(i3);
                    voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceModel.voiceId = voice.voice_md5;
                    voiceModel.duration = voice.during_time.intValue() / 1000;
                    this.mVoices.add(voiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    on4 on4Var = new on4();
                    on4Var.i(list4.get(i4));
                    this.mActDatas.add(on4Var);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                ar4 ar4Var = new ar4();
                this.mYulePostActivityData = ar4Var;
                ar4Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                wn4 wn4Var = new wn4();
                this.mAppCodeData = wn4Var;
                wn4Var.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                io4 io4Var = new io4();
                this.mCartoonThreadData = io4Var;
                io4Var.d(threadInfo.cartoon_info);
            }
            this.praise.setUserMap(this.userMap);
            this.praise.parserProtobuf(threadInfo.zan);
            this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
            if (!oi.isEmpty(this.title)) {
                this.praise.setTitle(this.title);
            } else {
                this.praise.setTitle(this.abstract_text);
            }
            this.mPhotoLiveCover = threadInfo.livecover_src;
            this.mStoreCount = threadInfo.storecount.intValue();
            this.post_num = threadInfo.post_num.intValue();
            this.mLastPostNum = threadInfo.post_num.intValue();
            this.mFreqNum = threadInfo.freq_num.longValue();
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                if (zhiBoInfoTW.labelInfo != null) {
                    int size3 = zhiBoInfoTW.labelInfo.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                            tz4 tz4Var = new tz4();
                            tz4Var.a(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                            tz4Var.b(zhiBoInfoTW.labelInfo.get(i5).labelId);
                            tz4Var.c(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                            this.threadExpressionArrayList.add(tz4Var);
                        }
                    }
                }
                NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                if (noticeInfo != null) {
                    this.mNotice = noticeInfo.notice;
                }
                this.copyThreadRemindType = zhiBoInfoTW.copythread_remind.intValue();
                this.isCopyTWzhibo = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                this.isTargetTWZhibo = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                if (StringUtils.isNull(this.mPhotoLiveCover)) {
                    this.mPhotoLiveCover = zhiBoInfoTW.livecover_src;
                }
                if (zhiBoInfoTW.user != null) {
                    this.twZhiBoUser = zhiBoInfoTW.user.tw_anchor_info;
                    this.profitList = zhiBoInfoTW.user.profit_list;
                }
            }
            if (threadInfo.twzhibo_info != null) {
                this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                this.mLiveCoverStatus = threadInfo.twzhibo_info.livecover_status;
                this.mFreqNum = threadInfo.twzhibo_info.freq_num.intValue();
                if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                    this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                }
            }
            this.canCopyThread = threadInfo.is_copythread.intValue() == 1;
            if (threadInfo.task_info != null) {
                this.taskInfoData.l(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                    f05 f05Var = new f05();
                    f05Var.b(threadInfo.ext_tails.get(i6));
                    this.mExtTails.add(f05Var);
                }
            }
            this.mPushStatusData.parserProtobuf(threadInfo.push_status);
            this.legoCard = threadInfo.lego_card;
            this.mSkinInfoData = threadInfo.skin_info;
            this.isBookChapter = threadInfo.is_book_chapter.intValue();
            this.bookChapterData.b(threadInfo.book_chapter);
            this.mRecomSource = threadInfo.recom_source;
            this.mRecomReason = threadInfo.recom_reason;
            this.mRecomReasonIcon = threadInfo.recom_tag_icon;
            this.mRecomWeight = threadInfo.recom_weight;
            this.mRecomAbTag = threadInfo.ab_tag;
            this.mRecomExtra = threadInfo.recom_extra;
            this.mLastReadPid = threadInfo.last_read_pid.longValue();
            this.mCheckRepeat = threadInfo.cheak_repeat.intValue() == 1;
            this.mReportInfoList = threadInfo.report_info;
            if (threadInfo.top_agree_post != null) {
                this.mTopAgreePost.m0(threadInfo.top_agree_post);
            }
            List<DislikeInfo> list5 = threadInfo.dislike_info;
            if (ListUtils.getCount(list5) > 0) {
                SparseArray<String> sparseArray = new SparseArray<>();
                SparseArray<String> sparseArray2 = new SparseArray<>();
                for (DislikeInfo dislikeInfo : list5) {
                    if (dislikeInfo != null) {
                        sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                    }
                }
                this.feedBackReasonMap = sparseArray;
                this.feedBackExtraMap = sparseArray2;
            }
            this.isMutiForumThread = threadInfo.is_multiforum_thread.intValue() == 1;
            boolean z = threadInfo.is_link_thread.intValue() == 1;
            this.isLinkThread = z;
            if (z && threadInfo.link_info != null) {
                fp4 fp4Var = new fp4();
                this.linkThreadData = fp4Var;
                fp4Var.h(threadInfo.link_info);
            }
            this.partialVisible = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                vn4 vn4Var = new vn4();
                this.specialData = vn4Var;
                vn4Var.b(threadInfo.activity_info);
            }
            if (threadInfo.pic_info != null) {
                MediaData mediaData2 = new MediaData();
                this.mPicMediaData = mediaData2;
                mediaData2.parserProtobuf(threadInfo.pic_info);
            }
            this.is_called = threadInfo.is_called.intValue();
            this.middle_page_num = threadInfo.middle_page_num.intValue();
            this.middle_page_pass_flag = threadInfo.middle_page_pass_flag.intValue();
            this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
            if (threadInfo.star_rank_icon != null) {
                this.iconPicUrl = threadInfo.star_rank_icon.icon_pic_url;
                this.iconLink = threadInfo.star_rank_icon.icon_link;
            }
            if (threadInfo.origin_thread_info != null) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.originalThreadData = originalThreadInfo;
                originalThreadInfo.o(threadInfo.origin_thread_info, this);
            } else {
                this.originalThreadData = null;
                this.isShareThread = false;
            }
            this.isTopic = threadInfo.is_topic.intValue();
            this.topicUserName = threadInfo.topic_user_name;
            this.topicUrl = threadInfo.topic_h5_url;
            this.mTopicModule = threadInfo.topic_module;
            this.presentationStyle = threadInfo.presentation_style;
            this.mOriginalForumInfo = OriginalForumInfo.parser(threadInfo.ori_forum_info);
            this.mDailyPaperTime = threadInfo.daily_paper_time;
            if (threadInfo.forum_info != null) {
                mq4 mq4Var = new mq4();
                this.forumData = mq4Var;
                mq4Var.j(threadInfo.forum_info);
            }
            if (threadInfo.swan_info != null) {
                this.mSmartApp = threadInfo.swan_info;
            }
            this.mShareImageUrl = threadInfo.t_share_img;
            this.mNid = threadInfo.nid;
            this.isHeadLinePost = threadInfo.is_headlinepost.intValue() == 1;
            this.thread_share_link = threadInfo.thread_share_link;
            this.articeCover = threadInfo.article_cover;
            this.bjhContentTag = threadInfo.bjh_content_tag.intValue();
            this.isBjh = threadInfo.is_bjh.intValue();
            if (threadInfo.baijiahao != null) {
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                this.mBaijiahao = baijiahaoData;
                baijiahaoData.parseProto(threadInfo.baijiahao);
                this.agreeData.baijiahaoData = this.mBaijiahao;
            }
            this.isSCard = threadInfo.is_s_card.intValue() == 1;
            this.scardPacketId = threadInfo.scard_packet_id;
            this.mTabId = threadInfo.tab_id.intValue();
            this.mTabName = threadInfo.tab_name;
            this.mWonderfulPostInfo = threadInfo.wonderful_post_info;
            this.forbidComment = threadInfo.if_comment.intValue() == 1;
            this.noCommetStr = threadInfo.if_comment_info;
            this.rawThreadInfo = threadInfo;
            if (!ListUtils.isEmpty(threadInfo.pb_link_info)) {
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    PbLinkData pbLinkData = new PbLinkData();
                    pbLinkData.parseProto(pbLinkInfo);
                    if (pbLinkData.urlType == 2 && !this.isGoods) {
                        this.isGoods = true;
                    }
                    this.mLinkDataList.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(threadInfo.pb_goods_info)) {
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    PbGoodsData pbGoodsData = new PbGoodsData();
                    pbGoodsData.parseProto(pbGoodsInfo);
                    this.mGoodsDataList.add(pbGoodsData);
                }
                if (this.mGoodsDataList.size() > 0 && !this.isGoods) {
                    this.isGoods = true;
                }
            }
            if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                this.mItem = threadInfo.item;
            }
            if (this.mItem != null) {
                ItemData itemData = new ItemData();
                this.itemData = itemData;
                itemData.parseProto(this.mItem);
            }
            List<HeadItem> list6 = threadInfo.item_star;
            this.mItemStar = list6;
            if (!ListUtils.isEmpty(list6)) {
                ItemStarData itemStarData = new ItemStarData();
                this.itemStarData = itemStarData;
                itemStarData.parseProto(this.mItemStar);
            }
            if (threadInfo.poll_info != null) {
                if (this.mPollData == null) {
                    this.mPollData = new PollData();
                }
                this.mPollData.parserProtobuf(threadInfo.poll_info);
            }
            this.hotNum = threadInfo.hot_num.intValue();
            this.isLocal = threadInfo.is_local.intValue() == 1;
            this.isAuthorView = threadInfo.is_author_view.intValue();
            if (threadInfo.works_info != null) {
                if (this.worksInfoData == null) {
                    this.worksInfoData = new WorksInfoData();
                }
                this.worksInfoData.parseProto(threadInfo.works_info);
            }
            this.collectNum = threadInfo.collect_num.intValue();
            if (!ListUtils.isEmpty(threadInfo.thread_recommend_infos)) {
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
                    threadRecommendInfoData.parseProto(threadRecommendInfo);
                    this.threadRecommendInfoDataList.add(threadRecommendInfoData);
                }
            }
            this.isBlocked = threadInfo.is_frs_mask.intValue() == 1;
            this.isTiebaPlusAdThread = StringHelper.equals(threadInfo.is_tiebaplus_ad, "1");
            this.tiebaPlusOrderId = threadInfo.tiebaplus_order_id;
            this.tiebaPlusToken = threadInfo.tiebaplus_token;
            this.tiebaPlusExtraParam = threadInfo.tiebaplus_extra_param;
            this.tiebaplusCantDelete = threadInfo.tiebaplus_cant_delete.intValue() == 1;
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                this.tiePlusAdSource = tiebaPlusAd.ad_source;
                this.tiePlusShowUrl = tiebaPlusAd.show_url;
                this.tiePlusCostUrl = tiebaPlusAd.cost_url;
            }
            this.tiePlusMonitorShowUrl = threadInfo.exposure_monitor_url;
            this.tiePlusMonitorClickUrl = threadInfo.click_monitor_url;
            this.mVoiceRoomData = threadInfo.voice_room;
            this.mTabShowMode = threadInfo.tab_show_mode.intValue();
            if (threadInfo.recommend_tip != null) {
                ForumRecTip forumRecTip = new ForumRecTip();
                this.forumRecTip = forumRecTip;
                forumRecTip.parseProto(threadInfo.recommend_tip);
            }
            if (threadInfo.thread_recommend_tag != null) {
                ThreadRecommendTagData threadRecommendTagData = new ThreadRecommendTagData();
                this.threadRecommendTagData = threadRecommendTagData;
                threadRecommendTagData.parseProtobuf(threadInfo.thread_recommend_tag);
            }
            praserTimeConsumingInfo();
            if (threadInfo.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.mCustomFigure = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(threadInfo.custom_figure);
            }
            if (threadInfo.custom_state != null) {
                y05 y05Var = new y05();
                this.mCustomState = y05Var;
                y05Var.c(threadInfo.custom_state);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserSpecTitleForFrsAndPb(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048816, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            parserSpecTitleForFrsAndPb(z, z2, true);
        }
    }

    public void parserTitleFrsForTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048818, this) == null) {
            parse_title(false, true);
        }
    }

    public void parser_title() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048819, this) == null) {
            parse_title(false, false);
        }
    }

    public int picCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) {
            if (!zm4.c().g() || ListUtils.getCount(getMedias()) == 0) {
                return 0;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < getMedias().size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(getMedias(), i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void praserTimeConsumingInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048821, this) == null) {
            processUserName();
            processExtensionInfo();
            processShareIntro();
            processTitleText();
            processAbstructText();
            processReplyTime();
            processReplyTimeForMyThread();
        }
    }

    public void processExtensionInfoForPersonCenter() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048822, this) == null) || isUgcThreadType() || isFromConcern()) {
            return;
        }
        long last_time_int = getLast_time_int() * 1000;
        if (last_time_int != 0) {
            String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(last_time_int);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(last_time_int);
            }
            this.threadExtendInfo = formatTimeForJustNow;
        }
        if (isNewGodAuthor()) {
            processExtensionInfoForNewGod();
        } else if (!this.isFromHomPage && (metaData = this.author) != null && metaData.showBazhuGrade()) {
            String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(this.author.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
            if (!TextUtils.isEmpty(this.threadExtendInfo)) {
                this.threadExtendInfo += "   " + cutChineseAndEnglishWithSuffix;
            } else {
                this.threadExtendInfo = cutChineseAndEnglishWithSuffix;
            }
        }
        if (TextUtils.isEmpty(this.threadExtendInfo) || TextUtils.isEmpty(getAddress())) {
            return;
        }
        this.threadExtendInfo += " • " + getAddress();
    }

    public void setAbstract(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.abstract_text = str;
        }
    }

    public void setActDatas(ArrayList<on4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048824, this, arrayList) == null) {
            this.mActDatas = arrayList;
        }
    }

    public void setAddedGood(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048825, this, z) == null) {
            setIs_good(z ? 1 : 0);
        }
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048826, this, str) == null) {
            this.address = str;
        }
    }

    public void setAgreeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048827, this, i) == null) {
            this.agreeData.agreeNum = i;
        }
    }

    public void setAgreeType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048829, this, i) == null) {
            this.agreeData.agreeType = i;
        }
    }

    public void setAnchorLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048830, this, i) == null) {
            this.anchorLevel = i;
        }
    }

    public void setAppCodeData(wn4 wn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048831, this, wn4Var) == null) {
            this.mAppCodeData = wn4Var;
        }
    }

    public void setArticeCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048832, this, str) == null) {
            this.articeCover = str;
        }
    }

    public void setAuthor(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048833, this, metaData) == null) {
            this.author = metaData;
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048834, this, baijiahaoData) == null) {
            this.mBaijiahao = baijiahaoData;
        }
    }

    public void setCartoonThreadData(io4 io4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048835, this, io4Var) == null) {
            this.mCartoonThreadData = io4Var;
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048836, this, str) == null) {
            this.category_name = str;
        }
    }

    public void setCopyThreadRemindType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048837, this, i) == null) {
            this.copyThreadRemindType = i;
        }
    }

    public void setCurrentPage(int i) {
        vq4 vq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048838, this, i) == null) || (vq4Var = this.threadVideoChannelInfo) == null) {
            return;
        }
        vq4Var.b = i;
    }

    public void setDailyPaperTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, str) == null) {
            this.mDailyPaperTime = str;
        }
    }

    public void setDisAgreeNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048840, this, j) == null) {
            this.agreeData.diffAgreeNum = j;
        }
    }

    public void setDispatchedForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048841, this, j) == null) {
            this.dispatchedForumId = j;
        }
    }

    public void setDispatchedForumIdWithString(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, str) == null) {
            setDispatchedForumId(ng.g(str, 0L));
        }
    }

    public void setDistance(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048843, this, str) == null) {
            this.distance = str;
        }
    }

    public void setExpressionDatas(ArrayList<tz4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048844, this, arrayList) == null) {
            this.threadExpressionArrayList.clear();
            this.threadExpressionArrayList.addAll(arrayList);
        }
    }

    public void setFeedBackReasonMap(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, sparseArray) == null) {
            this.feedBackReasonMap = sparseArray;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048846, this, j) == null) {
            this.fid = j;
        }
    }

    public void setFirstClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048847, this, str) == null) {
            this.mFirstClassName = str;
        }
    }

    public void setFirstFloorList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048848, this, list) == null) {
            this.mFirstFloorList = list;
        }
    }

    public void setFloor5Video(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048849, this, z) == null) {
            this.isFloor5Video = z;
        }
    }

    public void setForumAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, str) == null) {
            this.forumAvatar = str;
        }
    }

    public void setForumData(mq4 mq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048851, this, mq4Var) == null) {
            this.forumData = mq4Var;
        }
    }

    public void setForum_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048852, this, str) == null) {
            this.forum_name = str;
        }
    }

    public void setFreqNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048853, this, j) == null) {
            this.mFreqNum = j;
        }
    }

    public void setFromConcern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048854, this, z) == null) {
            this.isFromConcern = z;
        }
    }

    public void setFromFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048855, this, z) == null) {
            this.isFromFrs = z;
        }
    }

    public void setFromType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, str) == null) {
            this.mFromType = str;
        }
    }

    public void setGameInformationSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, str) == null) {
            this.tieba_game_information_source = str;
        }
    }

    public void setGoods(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048858, this, z) == null) {
            this.isGoods = z;
        }
    }

    public void setHasAgree(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048859, this, i) == null) {
            this.agreeData.hasAgree = i == 1;
        }
    }

    public void setHasPlayVirtualImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048860, this, z) == null) {
            this.hasPlayVirtualImage = z;
        }
    }

    public void setHas_commented(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048861, this, i) == null) {
            this.has_commented = i;
        }
    }

    public void setHotTopicInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, videoInfo) == null) {
            this.mHotTopicInfo = videoInfo;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, str) == null) {
            this.id = str;
        }
    }

    public void setImShareFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048864, this, z) == null) {
            this.isImShareFromPb = z;
        }
    }

    public void setInsertFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048865, this, i) == null) {
            this.mInsertFloor = i + 1;
        }
    }

    public void setIsBjh(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048866, this, i) == null) {
            this.isBjh = i;
        }
    }

    public void setIsDailyThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048867, this, z) == null) {
            this.isDailyThread = z;
        }
    }

    public void setIsInsertThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048868, this, z) == null) {
            this.isInsertThread = z;
        }
    }

    public void setIsManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048869, this, i) == null) {
            this.isManager = i;
        }
    }

    public void setIsMarked(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048870, this, i) == null) {
            this.isMarked = i;
        }
    }

    public void setIsOriginManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048871, this, i) == null) {
            this.isOriginManager = i;
        }
    }

    public void setIsSmartFrsThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048872, this, z) == null) {
            this.isSmartFrsThread = z;
        }
    }

    public void setIsTbReadDispatch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048873, this, i) == null) {
            this.isTbReadDispatch = i;
        }
    }

    public void setIsTopicThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048874, this) == null) {
            this.isTopic = 1;
        }
    }

    public void setIs_called(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048875, this, i) == null) {
            this.is_called = i;
        }
    }

    public void setIs_good(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048876, this, i) == null) {
            this.is_good = i;
        }
    }

    public void setIs_top(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048877, this, i) == null) {
            this.is_top = i;
        }
    }

    public void setItem(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, item) == null) {
            this.mItem = item;
        }
    }

    public void setItemData(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048879, this, itemData) == null) {
            this.itemData = itemData;
        }
    }

    public void setItemStar(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048880, this, list) == null) {
            this.mItemStar = list;
        }
    }

    public void setLastPostNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048881, this, i) == null) {
            this.mLastPostNum = i;
        }
    }

    public void setLast_time(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048882, this, str) == null) {
            this.last_time = str;
        }
    }

    public void setLast_time_int(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048883, this, j) == null) {
            this.last_time_int = j;
        }
    }

    public void setLegoCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048884, this, str) == null) {
            this.legoCard = str;
        }
    }

    public void setLinkDataList(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048885, this, list) == null) {
            this.mLinkDataList = list;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (PbLinkData pbLinkData : this.mLinkDataList) {
                if (pbLinkData.urlType == 2 && !this.isGoods) {
                    this.isGoods = true;
                }
            }
        }
    }

    public void setMadeTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048886, this, z) == null) {
            setIs_top(z ? 1 : 0);
        }
    }

    public void setMarkID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048887, this, str) == null) {
            this.markID = str;
        }
    }

    public void setMarkToDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048888, this, z) == null) {
            this.isMarkToDel = z;
        }
    }

    public void setMarkToMove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048889, this, z) == null) {
            this.mIsMarkToMove = z;
        }
    }

    public void setMedias(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048890, this, arrayList) == null) {
            this.mMedias = arrayList;
        }
    }

    public void setPbFirstShareData(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048891, this, postData) == null) {
            this.pbFirstShareData = postData;
        }
    }

    public void setPbTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048892, this, str) == null) {
            this.mPbTitle = str;
        }
    }

    public void setPhotoLiveCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048893, this, str) == null) {
            this.mPhotoLiveCover = str;
        }
    }

    public void setPollData(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048894, this, pollData) == null) {
            this.mPollData = pollData;
        }
    }

    public void setPositionInFrsItemTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048895, this, i) == null) {
            this.positionInFrsItemTab = i;
        }
    }

    public void setPost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048896, this, i) == null) {
            this.post_num = i;
        }
    }

    public void setPraise(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048897, this, praiseData) == null) {
            this.praise = praiseData;
        }
    }

    public void setProfitList(List<TwAnchorProfitItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048898, this, list) == null) {
            this.profitList = list;
        }
    }

    public void setReply_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048899, this, i) == null) {
            this.reply_num = i;
        }
    }

    public void setRepost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048900, this, i) == null) {
            this.repost_num = i;
        }
    }

    public void setResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048901, this, i) == null) {
            this.mResourceType = i;
        }
    }

    public void setRichAbstractList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048902, this, list) == null) {
            this.mRichAbstractList = list;
        }
    }

    public void setRichTitleList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048903, this, list) == null) {
            this.mRichTitleList = list;
        }
    }

    public void setSecondClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048904, this, str) == null) {
            this.mSecondClassName = str;
        }
    }

    public void setShareNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048905, this, j) == null) {
            this.mShareNum = j;
        }
    }

    public void setShowFullThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048906, this, z) == null) {
            this.isShowFullThread = z;
        }
    }

    public void setShow_commented(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048907, this, i) == null) {
            this.show_commented = i;
        }
    }

    public void setSmartFrsPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048908, this, i) == null) {
            this.smartFrsPosition = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048909, this, i) == null) {
            this.sortType = i;
        }
    }

    public void setSpan_str(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048910, this, spannableStringBuilder) == null) {
            this.span_str = spannableStringBuilder;
        }
    }

    public void setSpecUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048911, this, str, str2) == null) {
            this.mUrl = str;
            this.mRightUrl = str2;
        }
    }

    public void setStyle_flag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048912, this, i) == null) {
            this.style_flag = i;
        }
    }

    public void setThreadAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048913, this, alaInfoData) == null) {
            this.threadAlaInfo = alaInfoData;
        }
    }

    public void setThreadExtendInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048914, this, str) == null) {
            this.threadExtendInfo = str;
        }
    }

    public void setThreadRecommendInfoDataList(List<ThreadRecommendInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048915, this, list) == null) {
            this.threadRecommendInfoDataList = list;
        }
    }

    public void setThreadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048916, this, i) == null) {
            this.threadType = i;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048917, this, str) == null) {
            this.tid = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048918, this, str) == null) {
            this.title = str;
        }
    }

    public void setTopicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048919, this, str) == null) {
            this.topicUrl = str;
        }
    }

    public void setTopicUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048920, this, str) == null) {
            this.topicUserName = str;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048921, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserPostPerm(UserPostPerm userPostPerm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048922, this, userPostPerm) == null) {
            this.userPostPerm = userPostPerm;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048923, this, videoInfo) == null) {
            this.threadVideoInfo = videoInfo;
        }
    }

    public void setView_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048924, this, i) == null) {
            this.view_num = i;
        }
    }

    public void setVoices(ArrayList<VoiceData.VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048925, this, arrayList) == null) {
            this.mVoices = arrayList;
        }
    }

    public void setWonderfulPostInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048926, this, str) == null) {
            this.mWonderfulPostInfo = str;
        }
    }

    public void setYulePostActivityData(ar4 ar4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048927, this, ar4Var) == null) {
            this.mYulePostActivityData = ar4Var;
        }
    }

    public void setmCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048928, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setmGoodsDataList(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048929, this, list) == null) {
            this.mGoodsDataList = list;
            if (ListUtils.isEmpty(list) || this.isGoods) {
                return;
            }
            this.isGoods = true;
        }
    }

    public boolean shouldShowBlockedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048930, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.originalThreadData;
            return originalThreadInfo != null && originalThreadInfo.H && this.fid == originalThreadInfo.e;
        }
        return invokeV.booleanValue;
    }

    public void updateIsNotitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048931, this, i) == null) {
            this.isNoTitle = i;
        }
    }

    public void updateShowStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048932, this) == null) && this.showStatus == 0) {
            this.showStatus = 1;
        }
    }

    private ArrayList<ux5.a> getPrefixList(boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            ArrayList<ux5.a> arrayList = new ArrayList<>();
            boolean needShowGodTitle = needShowGodTitle();
            if (z2) {
                if (z) {
                    if (needShowGodTitle && !isVideoThreadType()) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f07dc));
                    }
                    if (getIsLive() == 1 || getThreadType() == 33 || (getTopicData() != null && getTopicData().a() != 0)) {
                        if (getTaskInfoData() == null || !isInterviewLive()) {
                            if (!needShowGodTitle) {
                                arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f0e5f));
                            }
                        } else if (getTaskInfoStatus() == 2) {
                            arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f093f));
                        }
                    }
                    if (isInterviewLive()) {
                        arrayList.add(mInterviewResMapForPb.get(getTaskInfoStatus()));
                    }
                    if (isActInfo()) {
                        Integer num = activityResStringMap.get(new Point(getActInfoType(), getActInfoStatus()));
                        if (num != null) {
                            arrayList.add(new ux5.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f037f));
                        }
                    }
                    if (getYulePostActivityData() != null) {
                        arrayList.add(new ux5.a(R.string.obfuscated_res_0x7f0f037f, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!oi.isEmpty(getCategory())) {
                        arrayList.add(new ux5.a(getCategory()));
                    }
                } else {
                    if (needShowGodTitle && getIs_top() != 1 && !isVideoThreadType()) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f07dc));
                    }
                    if ((getIsLive() == 1 || getThreadType() == 33) && !isInterviewLive() && !needShowGodTitle) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f0e5f));
                    }
                    if (getIs_good() == 1) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f07dd));
                    }
                    if (getIs_top() == 1) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f1445));
                    }
                    if (isInterviewLive() && getTaskInfoData() != null && getTaskInfoStatus() == 2) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f093f));
                    }
                    if (isActInfo()) {
                        Integer num2 = activityResStringMap.get(new Point(getActInfoType(), getActInfoStatus()));
                        if (num2 != null) {
                            arrayList.add(new ux5.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f037f));
                        }
                    }
                    if (this.isBookChapter == 1) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f0380));
                    }
                    if (getAppCodeData() != null) {
                        arrayList.add(new ux5.a(R.string.obfuscated_res_0x7f0f110c, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (getYulePostActivityData() != null) {
                        arrayList.add(new ux5.a(R.string.obfuscated_res_0x7f0f037f, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!oi.isEmpty(getCategory())) {
                        arrayList.add(new ux5.a(getCategory()));
                    }
                    if (z3 && isLiveThread()) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f0221));
                    }
                    if (z3 && isLiveRecordThread()) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f0a06));
                    } else if (isRealVideoThread()) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f1542));
                    }
                    if (z4) {
                        arrayList.add(new ux5.a((int) R.string.obfuscated_res_0x7f0f1538));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public void parserSpecTitleForFrsAndPb(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048817, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (ListUtils.getCount(getPrefixList(z, z2, z3, false)) > 0) {
                parseTitleOrAbstractForFrs(z, z3);
                return;
            }
            SpannableStringBuilder parseRichTitle = parseRichTitle();
            if (z) {
                spannableStringBuilder = addPrefix(parseRichTitle.toString(), parseRichTitle, z, z2, z3, false);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(parseRichTitle);
            }
            this.span_str = spannableStringBuilder;
        }
    }

    public void setAgreeNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048828, this, j) == null) {
            this.agreeData.agreeNum = j;
        }
    }

    public SpannableStringBuilder parseTitleOrAbstractForFrs(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048811, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? parseTitleOrAbstractForFrs(z, z2, false) : (SpannableStringBuilder) invokeCommon.objValue;
    }
}

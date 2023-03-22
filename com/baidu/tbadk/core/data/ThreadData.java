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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
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
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.a45;
import com.baidu.tieba.ay4;
import com.baidu.tieba.bc9;
import com.baidu.tieba.cu5;
import com.baidu.tieba.cx4;
import com.baidu.tieba.ee9;
import com.baidu.tieba.ex4;
import com.baidu.tieba.fa5;
import com.baidu.tieba.fy4;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.gn;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hi;
import com.baidu.tieba.hw4;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jq5;
import com.baidu.tieba.ky4;
import com.baidu.tieba.kz4;
import com.baidu.tieba.m35;
import com.baidu.tieba.nm;
import com.baidu.tieba.oz4;
import com.baidu.tieba.pv4;
import com.baidu.tieba.pw4;
import com.baidu.tieba.qw4;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.rt5;
import com.baidu.tieba.rz4;
import com.baidu.tieba.s95;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.ut5;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.xe6;
import com.baidu.tieba.xz4;
import com.baidu.tieba.yo5;
import com.baidu.tieba.z35;
import com.baidu.tieba.zb9;
import com.baidu.tieba.zw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
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
public class ThreadData extends hw4 implements PreLoadImageProvider, gn, IVideoData {
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
    public static final int MAX_FORUM_NAME_LENGTH = 14;
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
    public static final int OBJ_TYPE_QUESTION = 10;
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
    public static final BdUniqueId TYPE_RECOMMEND_INFO;
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
    public static SparseArray<xe6.a> mInterviewResMapForPb;
    public transient /* synthetic */ FieldHolder $fh;
    public SpannableString abstractText;
    public String abstract_text;
    public String ad_url;
    public String address;
    public AgreeData agreeData;
    public int albumTabId;
    public AnchorInfoData anchorInfoData;
    public int anchorLevel;
    public String articeCover;
    public MetaData author;
    public String authorId;
    public int bjhContentTag;
    public zw4 bookChapterData;
    public String buttonText;
    public boolean canCopyThread;
    public String category_name;
    public int collectNum;
    public String convertBtnType;
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
    public iz4 forumData;
    public String forum_name;
    public String from;
    public zb9 funAdData;
    public String funAdId;
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
    public boolean isFromFrsTab;
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
    public boolean isHighLight;
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
    public boolean isXiuxiuThread;
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
    public ay4 linkThreadData;
    public String linkUrl;
    public String location;
    public String longtitude;
    public ArrayList<iw4> mActDatas;
    public qw4 mAppCodeData;
    public long mAuditTime;
    public BaijiahaoData mBaijiahao;
    public cx4 mCartoonThreadData;
    public boolean mCheckRepeat;
    public long mCreateTime;
    public VirtualImageCustomFigure mCustomFigure;
    public VirtualImageCustomState mCustomState;
    public String mDailyPaperTime;
    public ArrayList<fa5> mExtTails;
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
    public boolean mIsNeedCheckNTitle;
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
    public bc9 mTopAgreePost;
    public TopicModule mTopicModule;
    public String mUrl;
    public VoiceRoom mVoiceRoomData;
    public ArrayList<VoiceData.VoiceModel> mVoices;
    public String mWonderfulPostInfo;
    public xz4 mYulePostActivityData;
    public String markID;
    public int middle_page_num;
    public int middle_page_pass_flag;
    public String modeUrl;
    public String noCommetStr;
    public int operator_flag;
    public OriginalThreadInfo originalThreadData;
    public int originalThreadType;
    public boolean partialVisible;
    public bc9 pbFirstShareData;
    public String person_center_post_id;
    public int positionInFrsItemTab;
    public int post_num;
    public PraiseData praise;
    public String presentationStyle;
    public List<TwAnchorProfitItem> profitList;
    public ThreadInfo rawThreadInfo;
    public int recomCardType;
    public String replyTime;
    public String replyTimeForMyThread;
    public int reply_num;
    public int repost_num;
    public String scardPacketId;
    public String shareIntro;
    public boolean showAdSubscript;
    public int showStatus;
    public int show_commented;
    public int smartFrsPosition;
    public int sortType;
    public SpannableStringBuilder span_str;
    public pw4 specialData;
    public int statFloor;
    public int style_flag;
    public String targetScheme;
    public kz4 taskInfoData;
    public AlaInfoData threadAlaInfo;
    public ArrayList<s95> threadExpressionArrayList;
    public String threadExtendInfo;
    public List<ThreadRecommendInfoData> threadRecommendInfoDataList;
    public ThreadRecommendTagData threadRecommendTagData;
    public int threadTitleSpanOffset;
    public int threadType;
    public rz4 threadVideoChannelInfo;
    public VideoInfo threadVideoInfo;
    public VideoDesc threadVideoSegment;
    public String thread_share_link;
    public String tid;
    public String tiePlusAdSource;
    public String tiePlusCostUrl;
    public int tiePlusFrsStaticLocate;
    @Nullable
    public List<cu5> tiePlusLinkOriginData;
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
    public oz4 topicData;
    public String topicUrl;
    public String topicUserName;
    public TwZhiBoUser twZhiBoUser;
    public HashMap<String, MetaData> userMap;
    public UserPostPerm userPostPerm;
    public int view_num;
    public WorksInfoData worksInfoData;

    public boolean canShowNaniTail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this : (ThreadData) invokeV.objValue;
    }

    @Deprecated
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048828, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.id = jSONObject.optString("id");
            this.fid = jSONObject.optLong("fid", 0L);
            this.tid = jSONObject.optString("tid");
            this.title = jSONObject.optString("title");
            this.is_god = jSONObject.optInt(IMUserExtraData.KEY_IS_GOD);
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
            this.isMarked = jSONObject.optInt(TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS);
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
                this.taskInfoData.n(optJSONObject2);
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
            JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
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
                    voiceModel.setVoiceId(jSONObject3.optString("voice_md5"));
                    voiceModel.setDuration(jSONObject3.optInt("during_time") / 1000);
                    this.mVoices.add(voiceModel);
                }
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
            if (optJSONArray5 != null) {
                for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                    iw4 iw4Var = new iw4();
                    iw4Var.h(optJSONArray5.getJSONObject(i5));
                    this.mActDatas.add(iw4Var);
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
            if (optJSONObject4 != null) {
                xz4 xz4Var = new xz4();
                this.mYulePostActivityData = xz4Var;
                xz4Var.c(optJSONObject4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
            if (optJSONObject5 != null) {
                qw4 qw4Var = new qw4();
                this.mAppCodeData = qw4Var;
                qw4Var.b(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
            if (optJSONObject6 != null) {
                cx4 cx4Var = new cx4();
                this.mCartoonThreadData = cx4Var;
                cx4Var.c(optJSONObject6);
            }
            this.praise.setUserMap(this.userMap);
            this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
            this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
            if (!gi.isEmpty(this.title)) {
                this.praise.setTitle(this.title);
            } else {
                this.praise.setTitle(this.abstract_text);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
            if (optJSONObject7 != null) {
                this.taskInfoData.n(optJSONObject7);
            }
            JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
            if (optJSONArray6 != null) {
                for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                    fa5 fa5Var = new fa5();
                    fa5Var.a(optJSONArray6.getJSONObject(i6));
                    this.mExtTails.add(fa5Var);
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
                rz4 rz4Var = new rz4();
                this.threadVideoChannelInfo = rz4Var;
                rz4Var.a(optJSONObject8);
            }
            this.isMutiForumThread = jSONObject.optInt("is_multiforum_thread") == 1;
            this.isLinkThread = jSONObject.optBoolean("is_link_thread");
            JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
            if (this.isLinkThread && optJSONObject9 != null) {
                ay4 ay4Var = new ay4();
                this.linkThreadData = ay4Var;
                ay4Var.g(optJSONObject9);
            }
            this.partialVisible = jSONObject.optInt("is_partial_visible") == 1;
            JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
            if (optJSONObject10 != null) {
                pw4 pw4Var = new pw4();
                this.specialData = pw4Var;
                pw4Var.a(optJSONObject10);
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
                    originalThreadInfo.r(optJSONObject13);
                } else {
                    this.originalThreadData = null;
                }
            } else {
                this.originalThreadData = null;
            }
            JSONObject optJSONObject14 = jSONObject.optJSONObject("naws_info");
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
            this.mTabId = jSONObject.optInt(TiebaStatic.Params.TAB_ID);
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
            iz4 iz4Var = new iz4();
            this.forumData = iz4Var;
            iz4Var.h(jSONObject.optJSONObject("forum_info"));
            this.isAuthorView = jSONObject.optInt("is_author_view");
            jSONObject.optString("scard_packet_id");
            this.mPhotoLiveCover = jSONObject.optString("livecover_src");
            JSONArray optJSONArray10 = jSONObject.optJSONArray("rich_abstract");
            if (optJSONArray10 != null) {
                this.mRichAbstractList = ky4.a(optJSONArray10);
            }
            this.showAdSubscript = jSONObject.optInt("show_ad_subscript") == 1;
            this.convertBtnType = jSONObject.optString("convert_btn_type");
            JSONArray optJSONArray11 = jSONObject.optJSONArray("rich_title");
            if (optJSONArray11 != null) {
                this.mRichTitleList = ky4.a(optJSONArray11);
            }
            JSONArray optJSONArray12 = jSONObject.optJSONArray("first_post_content");
            if (optJSONArray12 != null) {
                this.mFirstFloorList = ky4.a(optJSONArray12);
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
                JSONArray optJSONArray14 = optJSONObject22.optJSONArray(TaskProcess.keyTags);
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
            praserTimeConsumingInfo();
            JSONObject optJSONObject25 = jSONObject.optJSONObject("voice_room");
            if (optJSONObject25 != null) {
                VoiceRoom.Builder builder7 = new VoiceRoom.Builder();
                builder7.room_id = Long.valueOf(optJSONObject25.optLong("room_id"));
                builder7.room_name = optJSONObject25.getString(DpStatConstants.KEY_ROOM_NAME);
                this.mVoiceRoomData = builder7.build(true);
            }
            this.isHighLight = jSONObject.optInt("is_highlight") == 1;
            this.isXiuxiuThread = jSONObject.optInt("is_xiuxiu_thread") == 1;
            this.targetScheme = jSONObject.optString("target_scheme");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserProtobuf(ThreadInfo threadInfo) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048829, this, threadInfo) == null) || threadInfo == null) {
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
                rz4 rz4Var = new rz4();
                this.threadVideoChannelInfo = rz4Var;
                rz4Var.b(threadInfo.video_channel_info);
            }
            List<Voice> list3 = threadInfo.voice_info;
            if (list3 != null) {
                int size = list3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                    Voice voice = list3.get(i3);
                    voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                    voiceModel.setVoiceId(voice.voice_md5);
                    voiceModel.setDuration(voice.during_time.intValue() / 1000);
                    this.mVoices.add(voiceModel);
                }
            }
            List<ActInfo> list4 = threadInfo.act_info;
            if (list4 != null) {
                int size2 = list4.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    iw4 iw4Var = new iw4();
                    iw4Var.i(list4.get(i4));
                    this.mActDatas.add(iw4Var);
                }
            }
            if (threadInfo.yule_post_activity != null) {
                xz4 xz4Var = new xz4();
                this.mYulePostActivityData = xz4Var;
                xz4Var.d(threadInfo.yule_post_activity);
            }
            if (threadInfo.app_code != null) {
                qw4 qw4Var = new qw4();
                this.mAppCodeData = qw4Var;
                qw4Var.c(threadInfo.app_code);
            }
            if (threadInfo.cartoon_info != null) {
                cx4 cx4Var = new cx4();
                this.mCartoonThreadData = cx4Var;
                cx4Var.d(threadInfo.cartoon_info);
            }
            this.praise.setUserMap(this.userMap);
            this.praise.parserProtobuf(threadInfo.zan);
            this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
            if (!gi.isEmpty(this.title)) {
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
                            s95 s95Var = new s95();
                            s95Var.a(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                            s95Var.b(zhiBoInfoTW.labelInfo.get(i5).labelId);
                            s95Var.c(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                            this.threadExpressionArrayList.add(s95Var);
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
                this.taskInfoData.o(threadInfo.task_info);
            }
            if (threadInfo.ext_tails != null) {
                for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                    fa5 fa5Var = new fa5();
                    fa5Var.b(threadInfo.ext_tails.get(i6));
                    this.mExtTails.add(fa5Var);
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
                this.mTopAgreePost.A0(threadInfo.top_agree_post);
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
                ay4 ay4Var = new ay4();
                this.linkThreadData = ay4Var;
                ay4Var.h(threadInfo.link_info);
            }
            this.partialVisible = threadInfo.is_partial_visible.intValue() == 1;
            if (threadInfo.activity_info != null) {
                pw4 pw4Var = new pw4();
                this.specialData = pw4Var;
                pw4Var.b(threadInfo.activity_info);
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
                originalThreadInfo.p(threadInfo.origin_thread_info, this);
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
                iz4 iz4Var = new iz4();
                this.forumData = iz4Var;
                iz4Var.i(threadInfo.forum_info);
            }
            if (threadInfo.naws_info != null) {
                this.mSmartApp = threadInfo.naws_info;
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
            if (threadInfo.thread_recommend_tag != null) {
                ThreadRecommendTagData threadRecommendTagData = new ThreadRecommendTagData();
                this.threadRecommendTagData = threadRecommendTagData;
                threadRecommendTagData.parseProtobuf(threadInfo.thread_recommend_tag);
            }
            this.showAdSubscript = threadInfo.show_ad_subscript.intValue() == 1;
            this.convertBtnType = threadInfo.convert_btn_type;
            praserTimeConsumingInfo();
            if (threadInfo.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.mCustomFigure = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(threadInfo.custom_figure);
            }
            if (threadInfo.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.mCustomState = virtualImageCustomState;
                virtualImageCustomState.parseProto(threadInfo.custom_state);
            }
            this.isHighLight = threadInfo.is_highlight.intValue() == 1;
            this.isXiuxiuThread = threadInfo.is_xiuxiu_thread.intValue() == 1;
            if (threadInfo.ablum_info != null && threadInfo.ablum_info.tab_id != null) {
                this.albumTabId = threadInfo.ablum_info.tab_id.intValue();
            }
            this.targetScheme = threadInfo.target_scheme;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

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
        TYPE_RECOMMEND_INFO = BdUniqueId.gen();
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
        activityResStringMap.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        activityResStringMap.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        activityResStringMap.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        activityResStringMap.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        activityResStringMap.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        activityResStringMap.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        activityResStringMap.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        activityResStringMap.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        mInterviewResMap.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        mInterviewResMap.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        mInterviewResMap.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        mInterviewResMapForPb.put(1, new xe6.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        mInterviewResMapForPb.put(2, new xe6.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        mInterviewResMapForPb.put(3, new xe6.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
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
        this.recomCardType = -1;
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
        this.topicData = new oz4();
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
        this.bookChapterData = new zw4();
        this.mFirstFloorList = new ArrayList();
        this.mRichTitleList = new ArrayList();
        this.mRichAbstractList = new ArrayList();
        this.category_name = null;
        this.taskInfoData = new kz4();
        this.mExtTails = new ArrayList<>();
        this.mPushStatusData = new PushStatusData();
        this.isTbReadDispatch = 0;
        this.isInsertThread = false;
        this.mInsertFloor = -1;
        this.mTopAgreePost = new bc9();
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
        this.mIsNeedCheckNTitle = true;
    }

    private SpannableStringBuilder addGodTittle(String str, ArrayList<xe6.a> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            if (isVideoThreadType() || !needShowGodTitle() || gi.isEmpty(str)) {
                return null;
            }
            if (arrayList == null || arrayList.size() <= 0) {
                arrayList = new ArrayList<>();
                arrayList.add(new xe6.a((int) R.string.god_title));
            }
            return xe6.h(TbadkCoreApplication.getInst(), str, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    private SpannableStringBuilder addPrefix(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, spannableStringBuilder, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            ArrayList<xe6.a> prefixList = getPrefixList(z, z2, z3, z4);
            if (prefixList == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h = xe6.h(TbadkCoreApplication.getInst(), str, prefixList, false);
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
            ArrayList<xe6.a> prefixList = getPrefixList(z, z2, z3, false);
            if (prefixList == null) {
                return new SpannableStringBuilder();
            }
            SpannableStringBuilder h = xe6.h(TbadkCoreApplication.getInst(), str, prefixList, false);
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

    private ArrayList<xe6.a> getPrefixList(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return getPrefixList(z, z2, true, false);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public SpannableStringBuilder parseTitleOrAbstractForFrs(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048824, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return parseTitleOrAbstractForFrs(z, z2, false);
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public void parserSpecTitleForFrsAndPb(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048830, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            parserSpecTitleForFrsAndPb(z, z2, true);
        }
    }

    public void setSpecUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048928, this, str, str2) == null) {
            this.mUrl = str;
            this.mRightUrl = str2;
        }
    }

    private ArrayList<xe6.a> getPrefixList(boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            ArrayList<xe6.a> arrayList = new ArrayList<>();
            boolean needShowGodTitle = needShowGodTitle();
            if (z2) {
                if (z) {
                    if (needShowGodTitle && !isVideoThreadType()) {
                        arrayList.add(new xe6.a((int) R.string.god_title));
                    }
                    if (getIsLive() == 1 || getThreadType() == 33 || (getTopicData() != null && getTopicData().a() != 0)) {
                        if (getTaskInfoData() != null && isInterviewLive()) {
                            if (getTaskInfoStatus() == 2) {
                                arrayList.add(new xe6.a((int) R.string.interview_live));
                            }
                        } else if (!needShowGodTitle) {
                            arrayList.add(new xe6.a((int) R.string.photo_live_tips));
                        }
                    }
                    if (isInterviewLive()) {
                        arrayList.add(mInterviewResMapForPb.get(getTaskInfoStatus()));
                    }
                    if (isActInfo()) {
                        Integer num = activityResStringMap.get(new Point(getActInfoType(), getActInfoStatus()));
                        if (num != null) {
                            arrayList.add(new xe6.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new xe6.a((int) R.string.card_promotion_text));
                        }
                    }
                    if (getYulePostActivityData() != null) {
                        arrayList.add(new xe6.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!gi.isEmpty(getCategory())) {
                        arrayList.add(new xe6.a(getCategory()));
                    }
                } else {
                    if (needShowGodTitle && getIs_top() != 1 && !isVideoThreadType()) {
                        arrayList.add(new xe6.a((int) R.string.god_title));
                    }
                    if ((getIsLive() == 1 || getThreadType() == 33) && !isInterviewLive() && !needShowGodTitle) {
                        arrayList.add(new xe6.a((int) R.string.photo_live_tips));
                    }
                    if (getIs_good() == 1) {
                        arrayList.add(new xe6.a((int) R.string.obfuscated_res_0x7f0f0853));
                    }
                    if (getIs_top() == 1) {
                        arrayList.add(new xe6.a((int) R.string.obfuscated_res_0x7f0f1538));
                    }
                    if (isInterviewLive() && getTaskInfoData() != null && getTaskInfoStatus() == 2) {
                        arrayList.add(new xe6.a((int) R.string.interview_live));
                    }
                    if (isActInfo()) {
                        Integer num2 = activityResStringMap.get(new Point(getActInfoType(), getActInfoStatus()));
                        if (num2 != null) {
                            arrayList.add(new xe6.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                        } else {
                            arrayList.add(new xe6.a((int) R.string.card_promotion_text));
                        }
                    }
                    if (this.isBookChapter == 1) {
                        arrayList.add(new xe6.a((int) R.string.card_tbread_text));
                    }
                    if (getAppCodeData() != null) {
                        arrayList.add(new xe6.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (getYulePostActivityData() != null) {
                        arrayList.add(new xe6.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    }
                    if (!gi.isEmpty(getCategory())) {
                        arrayList.add(new xe6.a(getCategory()));
                    }
                    if (z3 && isLiveThread()) {
                        arrayList.add(new xe6.a((int) R.string.ala_live));
                    }
                    if (z3 && isLiveRecordThread()) {
                        arrayList.add(new xe6.a((int) R.string.live_record));
                    } else if (isRealVideoThread()) {
                        arrayList.add(new xe6.a((int) R.string.video_title_str));
                    }
                    if (z4) {
                        arrayList.add(new xe6.a((int) R.string.video_review_state));
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    private boolean isConveneThreadOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void processAbstructText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.abstractText = parseAbstract();
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

    private void processTitleText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            SpannableStringBuilder parseTitle = parseTitle();
            this.titleText = parseTitle;
            xe6.b(this, parseTitle, true);
        }
    }

    private void processUserName() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && !StringUtils.isNull(this.author.getName_show())) {
            this.lengthLimitName = StringHelper.cutChineseAndEnglishWithSuffix(this.author.getName_show(), 12, StringHelper.STRING_MORE);
        }
    }

    public void cancelHighLight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.isHighLight = false;
        }
    }

    public String getAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.abstract_text;
        }
        return (String) invokeV.objValue;
    }

    public SpannableString getAbstractText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.abstractText;
        }
        return (SpannableString) invokeV.objValue;
    }

    public ArrayList<iw4> getActDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mActDatas;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getAd_url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.ad_url;
        }
        return (String) invokeV.objValue;
    }

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.address;
        }
        return (String) invokeV.objValue;
    }

    public AgreeData getAgreeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.agreeData;
        }
        return (AgreeData) invokeV.objValue;
    }

    public long getAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.agreeData.agreeNum;
        }
        return invokeV.longValue;
    }

    public int getAgreeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.agreeData.agreeType;
        }
        return invokeV.intValue;
    }

    public int getAlbumTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.albumTabId;
        }
        return invokeV.intValue;
    }

    public AnchorInfoData getAnchorInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.anchorInfoData;
        }
        return (AnchorInfoData) invokeV.objValue;
    }

    public int getAnchorLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.anchorLevel;
        }
        return invokeV.intValue;
    }

    public qw4 getAppCodeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mAppCodeData;
        }
        return (qw4) invokeV.objValue;
    }

    public String getArticeCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.articeCover;
        }
        return (String) invokeV.objValue;
    }

    public long getAuditTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mAuditTime;
        }
        return invokeV.longValue;
    }

    public MetaData getAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.author;
        }
        return (MetaData) invokeV.objValue;
    }

    public String getAuthorId() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if ((TextUtils.isEmpty(this.authorId) || this.authorId.equals("0")) && (metaData = this.author) != null) {
                return metaData.getUserId();
            }
            return this.authorId;
        }
        return (String) invokeV.objValue;
    }

    public int getBJHContentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.bjhContentTag;
        }
        return invokeV.intValue;
    }

    public BaijiahaoData getBaijiahaoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.mBaijiahao;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public boolean getCanCopyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.canCopyThread;
        }
        return invokeV.booleanValue;
    }

    public cx4 getCartoonThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mCartoonThreadData;
        }
        return (cx4) invokeV.objValue;
    }

    public String getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.category_name;
        }
        return (String) invokeV.objValue;
    }

    public String getConvertBtnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.convertBtnType;
        }
        return (String) invokeV.objValue;
    }

    public int getCopyThreadRemindType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.copyThreadRemindType;
        }
        return invokeV.intValue;
    }

    public long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mCreateTime;
        }
        return invokeV.longValue;
    }

    public VirtualImageCustomFigure getCustomFigure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mCustomFigure;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public VirtualImageCustomState getCustomState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mCustomState;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public String getDailyPaperTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mDailyPaperTime;
        }
        return (String) invokeV.objValue;
    }

    public long getDisAgreeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.agreeData.disAgreeNum;
        }
        return invokeV.longValue;
    }

    public long getDispatchedForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.dispatchedForumId;
        }
        return invokeV.longValue;
    }

    public String getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.distance;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<s95> getExpressDatas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.threadExpressionArrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<fa5> getExtTails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mExtTails;
        }
        return (ArrayList) invokeV.objValue;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.feedBackReasonMap;
        }
        return (SparseArray) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.fid;
        }
        return invokeV.longValue;
    }

    public String getFirstClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mFirstClassName;
        }
        return (String) invokeV.objValue;
    }

    public List<PbContent> getFirstFloorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mFirstFloorList;
        }
        return (List) invokeV.objValue;
    }

    public String getFirstPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.mFirstPostId;
        }
        return (String) invokeV.objValue;
    }

    public String getFirst_post_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.first_post_id;
        }
        return (String) invokeV.objValue;
    }

    public String getForumAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.forumAvatar;
        }
        return (String) invokeV.objValue;
    }

    public iz4 getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.forumData;
        }
        return (iz4) invokeV.objValue;
    }

    public String getForum_name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.forum_name;
        }
        return (String) invokeV.objValue;
    }

    public long getFreqNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mFreqNum;
        }
        return invokeV.longValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.from;
        }
        return (String) invokeV.objValue;
    }

    public String getFromType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mFromType;
        }
        return (String) invokeV.objValue;
    }

    public String getGameInformationSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.tieba_game_information_source;
        }
        return (String) invokeV.objValue;
    }

    public GodUserData getGodInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.mGoodsDataList;
        }
        return (List) invokeV.objValue;
    }

    public int getHasAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.agreeData.hasAgree ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public int getHas_commented() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.has_commented;
        }
        return invokeV.intValue;
    }

    public VideoInfo getHotTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.mHotTopicInfo;
        }
        return (VideoInfo) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public int getInsertFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mInsertFloor;
        }
        return invokeV.intValue;
    }

    public boolean getIsDailyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.isDailyThread;
        }
        return invokeV.booleanValue;
    }

    public int getIsLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.is_live;
        }
        return invokeV.intValue;
    }

    public int getIsManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.isManager;
        }
        return invokeV.intValue;
    }

    public int getIsMarked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.isMarked;
        }
        return invokeV.intValue;
    }

    public int getIsMemberTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.is_membertop;
        }
        return invokeV.intValue;
    }

    public int getIsNoTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.isNoTitle;
        }
        return invokeV.intValue;
    }

    public boolean getIsOperateThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.isOperateThread;
        }
        return invokeV.booleanValue;
    }

    public int getIsOriginManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.isOriginManager;
        }
        return invokeV.intValue;
    }

    public int getIs_called() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.is_called;
        }
        return invokeV.intValue;
    }

    public int getIs_good() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.is_good;
        }
        return invokeV.intValue;
    }

    public int getIs_top() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.is_top;
        }
        return invokeV.intValue;
    }

    public Item getItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.mItem;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> getItemStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.mItemStar;
        }
        return (List) invokeV.objValue;
    }

    public int getLastPostNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.mLastPostNum;
        }
        return invokeV.intValue;
    }

    public long getLastReadPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.mLastReadPid;
        }
        return invokeV.longValue;
    }

    public String getLast_time() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.last_time;
        }
        return (String) invokeV.objValue;
    }

    public long getLast_time_int() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.last_time_int;
        }
        return invokeV.longValue;
    }

    public String getLatitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.latitude;
        }
        return (String) invokeV.objValue;
    }

    public String getLeftHotIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.mUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getLegoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.legoCard;
        }
        return (String) invokeV.objValue;
    }

    public String getLengthLimitName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.lengthLimitName;
        }
        return (String) invokeV.objValue;
    }

    public List<PbLinkData> getLinkDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.mLinkDataList;
        }
        return (List) invokeV.objValue;
    }

    public ay4 getLinkThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.linkThreadData;
        }
        return (ay4) invokeV.objValue;
    }

    public LiveCoverStatus getLiveCoverStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.mLiveCoverStatus;
        }
        return (LiveCoverStatus) invokeV.objValue;
    }

    public String getLongtitude() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.longtitude;
        }
        return (String) invokeV.objValue;
    }

    public String getMarkID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.markID;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<MediaData> getMedias() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.mMedias;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String getNid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.mNid;
        }
        return (String) invokeV.objValue;
    }

    public String getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.mNotice;
        }
        return (String) invokeV.objValue;
    }

    public int getOperatorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.operator_flag;
        }
        return invokeV.intValue;
    }

    public int getOriginalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.originalThreadType;
        }
        return invokeV.intValue;
    }

    public bc9 getPbFirstShareData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.pbFirstShareData;
        }
        return (bc9) invokeV.objValue;
    }

    public String getPbTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.mPbTitle;
        }
        return (String) invokeV.objValue;
    }

    public String getPhotoLiveCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mPhotoLiveCover;
        }
        return (String) invokeV.objValue;
    }

    public MediaData getPicMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.mPicMediaData;
        }
        return (MediaData) invokeV.objValue;
    }

    public PollData getPollData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.mPollData;
        }
        return (PollData) invokeV.objValue;
    }

    public int getPositionInFrsItemTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.positionInFrsItemTab;
        }
        return invokeV.intValue;
    }

    public int getPost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.post_num;
        }
        return invokeV.intValue;
    }

    public PraiseData getPraise() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.praise;
        }
        return (PraiseData) invokeV.objValue;
    }

    public List<TwAnchorProfitItem> getProfitList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.profitList;
        }
        return (List) invokeV.objValue;
    }

    public PushStatusData getPushStatusData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.mPushStatusData;
        }
        return (PushStatusData) invokeV.objValue;
    }

    public ThreadInfo getRawThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.rawThreadInfo;
        }
        return (ThreadInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hw4
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.mRecomReason;
        }
        return (String) invokeV.objValue;
    }

    public String getRecomSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.mRecomSource;
        }
        return (String) invokeV.objValue;
    }

    public String getReplyTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.replyTime;
        }
        return (String) invokeV.objValue;
    }

    public String getReplyTimeForMyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.replyTimeForMyThread;
        }
        return (String) invokeV.objValue;
    }

    public int getReply_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.reply_num;
        }
        return invokeV.intValue;
    }

    public List<ReportInfo> getReportInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.mReportInfoList;
        }
        return (List) invokeV.objValue;
    }

    public int getRepost_num() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.repost_num;
        }
        return invokeV.intValue;
    }

    public int getResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.mResourceType;
        }
        return invokeV.intValue;
    }

    public List<PbContent> getRichAbstractList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.mRichAbstractList;
        }
        return (List) invokeV.objValue;
    }

    public List<PbContent> getRichTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.mRichTitleList;
        }
        return (List) invokeV.objValue;
    }

    public String getRightHotIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.mRightUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getSecondClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.mSecondClassName;
        }
        return (String) invokeV.objValue;
    }

    public String getShareImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.mShareImageUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getShareIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.shareIntro;
        }
        return (String) invokeV.objValue;
    }

    public long getShareNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.mShareNum;
        }
        return invokeV.longValue;
    }

    public boolean getShowAdSubscript() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.showAdSubscript;
        }
        return invokeV.booleanValue;
    }

    public int getShow_commented() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.show_commented;
        }
        return invokeV.intValue;
    }

    public SkinInfo getSkinInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.mSkinInfoData;
        }
        return (SkinInfo) invokeV.objValue;
    }

    public SmartApp getSmartApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.mSmartApp;
        }
        return (SmartApp) invokeV.objValue;
    }

    public int getSmartFrsPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.smartFrsPosition;
        }
        return invokeV.intValue;
    }

    public SpannableStringBuilder getSpan_str() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.span_str;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int getStoreCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.mStoreCount;
        }
        return invokeV.intValue;
    }

    public int getStyle_flag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.style_flag;
        }
        return invokeV.intValue;
    }

    public int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.mTabId;
        }
        return invokeV.intValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.mTabName;
        }
        return (String) invokeV.objValue;
    }

    public int getTabShowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.mTabShowMode;
        }
        return invokeV.intValue;
    }

    public String getTargetScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return this.targetScheme;
        }
        return (String) invokeV.objValue;
    }

    public kz4 getTaskInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.taskInfoData;
        }
        return (kz4) invokeV.objValue;
    }

    public AlaInfoData getThreadAlaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.threadAlaInfo;
        }
        return (AlaInfoData) invokeV.objValue;
    }

    public String getThreadExtendInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return this.threadExtendInfo;
        }
        return (String) invokeV.objValue;
    }

    public List<ThreadRecommendInfoData> getThreadRecommendInfoDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            return this.threadRecommendInfoDataList;
        }
        return (List) invokeV.objValue;
    }

    public ThreadRecommendTagData getThreadRecommendTagData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.threadRecommendTagData;
        }
        return (ThreadRecommendTagData) invokeV.objValue;
    }

    public int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return this.threadType;
        }
        return invokeV.intValue;
    }

    public rz4 getThreadVideoChannelInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.threadVideoChannelInfo;
        }
        return (rz4) invokeV.objValue;
    }

    public VideoInfo getThreadVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.threadVideoInfo;
        }
        return (VideoInfo) invokeV.objValue;
    }

    public VideoDesc getThreadVideoSegment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.threadVideoSegment;
        }
        return (VideoDesc) invokeV.objValue;
    }

    public String getTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            if (!StringUtils.isNull(this.tid) && !"0".equals(this.tid)) {
                return this.tid;
            }
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<cu5> getTiePlusLinkOriginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.tiePlusLinkOriginData;
        }
        return (List) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public SpannableStringBuilder getTitleText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.titleText;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public bc9 getTopAgreePost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.mTopAgreePost;
        }
        return (bc9) invokeV.objValue;
    }

    public oz4 getTopicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            return this.topicData;
        }
        return (oz4) invokeV.objValue;
    }

    public TopicModule getTopicModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.mTopicModule;
        }
        return (TopicModule) invokeV.objValue;
    }

    public String getTopicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.topicUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.topicUserName;
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.userMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public int getVideoRecStaticticType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if (!isBJHVideoDynamicThreadType() && !isBJHNormalThreadType()) {
                if (!isBJHArticleThreadType() && !isBJHVideoThreadType()) {
                    return 1;
                }
                return 3;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return this.view_num;
        }
        return invokeV.intValue;
    }

    public ArrayList<VoiceData.VoiceModel> getVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return this.mVoices;
        }
        return (ArrayList) invokeV.objValue;
    }

    public VoiceRoom getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.mVoiceRoomData;
        }
        return (VoiceRoom) invokeV.objValue;
    }

    public String getWonderfulPostInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.mWonderfulPostInfo;
        }
        return (String) invokeV.objValue;
    }

    public int getYYStaticticType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            if (getRecomCardType() == 1) {
                return 2;
            }
            if (getRecomCardType() == 2) {
                return 3;
            }
            if (getRecomCardType() == 3) {
                return 1;
            }
            return 4;
        }
        return invokeV.intValue;
    }

    public xz4 getYulePostActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return this.mYulePostActivityData;
        }
        return (xz4) invokeV.objValue;
    }

    public UserTbVipInfoData getbigVData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null) {
                return null;
            }
            return metaData.getUserTbVipInfoData();
        }
        return (UserTbVipInfoData) invokeV.objValue;
    }

    public boolean isActInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            if (this.is_activity == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAddedGood() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            if (getIs_good() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAlaLiveUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            if (getAuthor() != null && getAuthor().getAlaUserData() != null && getAuthor().getAlaUserData().live_status == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAnonymityUser() {
        InterceptResult invokeV;
        String userId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            MetaData metaData = this.author;
            if (metaData != null && (userId = metaData.getUserId()) != null && !userId.equals("0")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHArticleThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            if (baijiahaoData != null && baijiahaoData.oriUgcType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHNormalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            if (baijiahaoData != null && baijiahaoData.oriUgcType == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHVideoDynamicThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            if (baijiahaoData != null && baijiahaoData.oriUgcType == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBJHVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            BaijiahaoData baijiahaoData = this.mBaijiahao;
            if (baijiahaoData != null && baijiahaoData.oriUgcType == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return isUgcThreadType();
        }
        return invokeV.booleanValue;
    }

    public boolean isBjhDynamicThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            if (!isBJHNormalThreadType() && !isBJHVideoDynamicThreadType()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isBlocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            return this.isBlocked;
        }
        return invokeV.booleanValue;
    }

    public boolean isConcernDynamicType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (!isUgcThreadType() && !this.isShareThread) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isCopyTWzhibo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            return this.isCopyTWzhibo;
        }
        return invokeV.booleanValue;
    }

    public boolean isDisplayHighQualityPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return isWorksInfo();
        }
        return invokeV.booleanValue;
    }

    public boolean isDisplayOffcialPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            MetaData metaData = this.author;
            if (metaData != null && metaData.isForumBusinessAccount()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isFloor5Video() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            return this.isFloor5Video;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromConcern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return this.isFromConcern;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hw4
    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            return this.isFromFrs;
        }
        return invokeV.booleanValue;
    }

    public boolean isFromFrsTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            return this.isFromFrsTab;
        }
        return invokeV.booleanValue;
    }

    public boolean isFunAdPlaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            zb9 zb9Var = this.funAdData;
            if (zb9Var != null) {
                return zb9Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isGodThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null || metaData.getGodUserData() == null || this.author.getGodUserData().getType() != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isGoods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            return this.isGoods;
        }
        return invokeV.booleanValue;
    }

    public boolean isHeadLinesThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048766, this)) == null) {
            if (getType() == TYPE_STAR_INTERVIEW) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHeadLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            return this.isHeadLive;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hw4, com.baidu.tieba.card.data.BaseCardInfo
    public boolean isHighLight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return this.isHighLight;
        }
        return invokeV.booleanValue;
    }

    public boolean isImShareFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            return this.isImShareFromPb;
        }
        return invokeV.booleanValue;
    }

    public boolean isInsertThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            return this.isInsertThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isInterviewLive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            if (this.threadType == 41) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isInterviewLiveStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            if (getTaskInfoData() != null && getThreadType() == 41 && getIsLive() == 1 && getTaskInfoStatus() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLinkThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            return this.isLinkThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isLiveInterviewLiveType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048774, this)) == null) {
            if (this.threadType == 41) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLiveRecordThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) {
            if (getThreadType() == 50) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            if (getThreadType() != 49 && getThreadType() != 69) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isLongNovelThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            if (this.threadType == 72) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMadeTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048778, this)) == null) {
            if (getIs_top() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isMarkToDel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048779, this)) == null) {
            return this.isMarkToDel;
        }
        return invokeV.booleanValue;
    }

    public boolean isMarkToMove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            return this.mIsMarkToMove;
        }
        return invokeV.booleanValue;
    }

    public boolean isMutiForumThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            return this.isMutiForumThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedCheckNTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            return this.mIsNeedCheckNTitle;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedCheckRepeat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048783, this)) == null) {
            return this.mCheckRepeat;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewGodAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048784, this)) == null) {
            MetaData metaData = this.author;
            if (metaData != null && metaData.isNewGod()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNormalThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) {
            if (this.threadType == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNovelThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) {
            if (this.threadType == 31) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPGCUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null || metaData.getGodUserData() == null || this.author.getGodUserData().getType() != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPbHeadLinesThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048788, this)) == null) {
            if (getTaskInfoData() != null && !"0".equals(getTaskInfoData().i())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPhotoLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048789, this)) == null) {
            if (this.threadType == 33) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isQuestionThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            if (this.threadType == 71) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isQuestionsAndAnswersThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            if (this.threadType == 71) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRealGod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            if (this.is_god == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRealVideoThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048793, this)) == null) {
            if (getThreadType() == 40) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isScoreThread() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048794, this)) == null) {
            if (this.itemData == null && getItem() == null && ((originalThreadInfo = this.originalThreadData) == null || originalThreadInfo.C == null)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isSharedLiveThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            if (getThreadType() == 60) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowForumAndReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
            if ((isWorksInfo() || isVideoThreadType()) && !StringUtils.isNull(this.forum_name) && this.isFromHomPage) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowFullThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048798, this)) == null) {
            return this.isShowFullThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartAppThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048799, this)) == null) {
            int i = this.threadType;
            if (i != 63 && i != 64) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmartFrsThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048800, this)) == null) {
            return this.isSmartFrsThread;
        }
        return invokeV.booleanValue;
    }

    public boolean isTargetTWzhi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            return this.isTargetTWZhibo;
        }
        return invokeV.booleanValue;
    }

    public boolean isTbReadDispatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) {
            if (this.isTbReadDispatch == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isTiePlusCantDeleteUnion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048803, this)) == null) {
            if (!this.isTiebaPlusAdThread && !this.tiebaplusCantDelete) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048804, this)) == null) {
            if (getIs_top() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isTopicThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048805, this)) == null) {
            if (this.isTopic == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isTransportThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048806, this)) == null) {
            if (this.mOriginalForumInfo != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isUgcThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048807, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048808, this)) == null) {
            int i = this.threadType;
            if (i != 40 && i != 50) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoWorksInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048809, this)) == null) {
            if (isVideoThreadType() && isWorksInfo()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVocieRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048810, this)) == null) {
            VoiceRoom voiceRoom = this.mVoiceRoomData;
            if (voiceRoom != null && voiceRoom.room_id.longValue() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVoiceThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) {
            if (this.threadType == 11 || this.isVoiceThread == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVoteThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048812, this)) == null) {
            if (this.threadType == 36) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isWorksInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048813, this)) == null) {
            WorksInfoData worksInfoData = this.worksInfoData;
            if (worksInfoData != null && worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isXiuXiuThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048814, this)) == null) {
            return this.isXiuxiuThread;
        }
        return invokeV.booleanValue;
    }

    public boolean needShowGodTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048815, this)) == null) {
            if (this.is_god == 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean notShowHideThreadBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) {
            UserPostPerm userPostPerm = this.userPostPerm;
            if (userPostPerm == null || userPostPerm.not_show_hide_thread.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public SpannableString parseAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048817, this)) == null) {
            SpannableStringBuilder parseRichAbastract = parseRichAbastract();
            xe6.b(this, parseRichAbastract, false);
            return new SpannableString(parseRichAbastract);
        }
        return (SpannableString) invokeV.objValue;
    }

    public SpannableStringBuilder parseRichAbastract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048820, this)) == null) {
            if (this.tiePlusLinkOriginData == null) {
                this.tiePlusLinkOriginData = new ArrayList();
            }
            return ut5.G(this, this.mRichAbstractList, this.abstract_text, this.tiePlusLinkOriginData);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public SpannableStringBuilder parseRichTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048821, this)) == null) {
            if (this.tiePlusLinkOriginData == null) {
                this.tiePlusLinkOriginData = new ArrayList();
            }
            return ut5.G(this, this.mRichTitleList, this.title, this.tiePlusLinkOriginData);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public SpannableStringBuilder parseVideoTiePlusRichTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048827, this)) == null) {
            if (this.tiePlusLinkOriginData == null) {
                this.tiePlusLinkOriginData = new ArrayList();
            }
            return ut5.K(this, this.mRichAbstractList, this.title, this.tiePlusLinkOriginData);
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public void parserTitleFrsForTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048832, this) == null) {
            parse_title(false, true);
        }
    }

    public void parser_title() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048833, this) == null) {
            parse_title(false, false);
        }
    }

    public void praserTimeConsumingInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048835, this) == null) {
            processUserName();
            processExtensionInfo();
            processShareIntro();
            processTitleText();
            processAbstructText();
            processReplyTime();
            processReplyTimeForMyThread();
        }
    }

    public void setIsTopicThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048890, this) == null) {
            this.isTopic = 1;
        }
    }

    public boolean shouldShowBlockedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048948, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.originalThreadData;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.fid != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void updateShowStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048950, this) == null) && this.showStatus == 0) {
            this.showStatus = 1;
        }
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
                if ((matcher.find() && i2 <= matcher.groupCount()) || i2 <= split.length) {
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
                } else {
                    return;
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
        nm nmVar;
        SpannableStringBuilder parseRichTitle;
        SpannableString spannableString;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList arrayList = new ArrayList();
            if (!z2) {
                if (getThreadType() == 42 && isConveneThreadOpen()) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
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
                    arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
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
                if (!gi.isEmpty(this.category_name)) {
                    nmVar = transStrToSpanStr(this.category_name);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < arrayList.size(); i++) {
                            sb.append("1 ");
                        }
                        String sb2 = sb.toString();
                        if (nmVar != null) {
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
                            z35 z35Var = new z35(bitmapDrawable);
                            z35Var.b(hi.d(TbadkCoreApplication.getInst().getApplicationContext(), this.threadTitleSpanOffset));
                            spannableString.setSpan(z35Var, i2, i2 + 1, 33);
                            i2 += 2;
                        }
                        if (nmVar != null) {
                            spannableString.setSpan(nmVar, i2, this.category_name.length() + i2, 33);
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
            nmVar = null;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (arrayList.size() > 0) {
            }
            parseRichTitle = parseRichTitle();
            if (parseRichTitle != null) {
            }
            this.span_str = spannableStringBuilder2;
        }
    }

    private void processAlaExtensionInfo() {
        AlaInfoData alaInfoData;
        AlaUserInfoData alaUserInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65547, this) != null) || (alaInfoData = this.threadAlaInfo) == null) {
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
            if (!TextUtils.isEmpty(this.threadExtendInfo) && i > 0) {
                this.threadExtendInfo += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + StringHelper.numberUniformFormatExtraWithRoundInt(i);
            } else if (i > 0) {
                this.threadExtendInfo = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + StringHelper.numberUniformFormatExtraWithRoundInt(i);
            }
        }
    }

    public void processExtensionInfoForPersonCenter() {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048836, this) == null) && !isUgcThreadType() && !isFromConcern()) {
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
            if (!TextUtils.isEmpty(this.threadExtendInfo) && !TextUtils.isEmpty(getAddress())) {
                this.threadExtendInfo += " • " + getAddress();
            }
        }
    }

    private void processExtensionInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if ((this instanceof gy4) && "0".equals(getId())) {
                this.threadExtendInfo = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
                return;
            }
            int i = 36;
            if (!isUgcThreadType() && ((!isFromConcern() || getType() == TYPE_VIDEO_ALA_ONLIVE) && !this.isFromFeedTab && !this.isFromLocal)) {
                if (getType() != TYPE_VIDEO_ALA_ONLIVE && getType() != TYPE_ALA_FRIEND_ROOM) {
                    if (isVocieRoom() && !TextUtils.isEmpty(this.forum_name)) {
                        this.threadExtendInfo = StringHelper.cutChineseAndEnglishWithSuffix(this.forum_name, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f06bd);
                        return;
                    }
                    long last_time_int = getLast_time_int() * 1000;
                    if (last_time_int != 0) {
                        String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(last_time_int);
                        if (StringHelper.isThisYear(formatTimeForJustNow)) {
                            formatTimeForJustNow = StringHelper.getFormatTimeShort(last_time_int);
                        }
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
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
                        String str = StringHelper.cutChineseAndEnglishWithSuffix(this.forum_name, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f06bd);
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
                    if (!TextUtils.isEmpty(this.threadExtendInfo) && !TextUtils.isEmpty(getAddress())) {
                        this.threadExtendInfo += " • " + getAddress();
                        return;
                    }
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
            if (this.isFromLocal && (!TextUtils.isEmpty(this.distance) || !TextUtils.isEmpty(this.location))) {
                return;
            }
            if (this.isFromFrs) {
                i = 24;
            } else if (!this.isFromConcern) {
                i = 16;
            }
            String authInfo2 = UtilHelper.getAuthInfo(this.author, this.isFromHomPage, i);
            if (!TextUtils.isEmpty(this.threadExtendInfo) && !TextUtils.isEmpty(authInfo2)) {
                this.threadExtendInfo += "   " + authInfo2;
            } else if (!TextUtils.isEmpty(authInfo2)) {
                this.threadExtendInfo = authInfo2;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.gn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            zb9 zb9Var = this.funAdData;
            if (zb9Var != null) {
                if (zb9Var.h()) {
                    if (this.funAdData.i()) {
                        return AdvertAppInfo.G;
                    }
                    return AdvertAppInfo.H;
                } else if (this.funAdData.i()) {
                    return AdvertAppInfo.G;
                } else {
                    return AdvertAppInfo.F;
                }
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
                    if (this.mHotTopicInfo != null) {
                        return TYPE_FRS_HOTTOPIC_VIDEO;
                    }
                    return TYPE_FRS_HOTTOPIC;
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
                            if (this instanceof gy4) {
                                return TYPE_FAKE_VIDEO;
                            }
                            return TYPE_VIDEO;
                        } else if (this.isShareThread && (originalThreadInfo = this.originalThreadData) != null) {
                            if (originalThreadInfo.x) {
                                if (originalThreadInfo.r != null) {
                                    return TYPE_NEW_VIDEO_SHARE_THREAD;
                                }
                                if (originalThreadInfo.i()) {
                                    return TYPE_ARTICLE_SHARE_THREAD;
                                }
                                return TYPE_NEW_NORMAL_SHARE_THREAD;
                            }
                            return TYPE_SHARE_THREAD;
                        } else if (isBJHArticleThreadType()) {
                            return TYPE_ARTICLE;
                        } else {
                            if (isInterviewLiveStyle()) {
                                if (isFRSExtraLoaded.get()) {
                                    return TYPE_STAR_INTERVIEW;
                                }
                                return TYPE_NORMAL;
                            } else if (isActInfo() && getActInfoType() == 1) {
                                if (isFRSExtraLoaded.get()) {
                                    return TYPE_LOTTERY;
                                }
                                return TYPE_NORMAL;
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

    private void processExtensionInfoForNewGod() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && isNewGodAuthor() && !TextUtils.isEmpty(this.author.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.threadExtendInfo)) {
                this.threadExtendInfo += "   " + this.author.getNewGodData().getFieldName() + jq5.c(this.author.getNewGodData().isVideoGod());
                return;
            }
            this.threadExtendInfo = this.author.getNewGodData().getFieldName() + jq5.c(this.author.getNewGodData().isVideoGod());
        }
    }

    private void processShareIntro() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (getThreadAlaInfo() != null && getThreadAlaInfo().share_info != null && getThreadAlaInfo().share_info.share_user_count > 0 && isSharedLiveThread() && (this.middle_page_num <= 0 || this.middle_page_pass_flag != 0)) {
                int i = getThreadAlaInfo().share_info.share_user_count;
                if (i == 1) {
                    this.shareIntro = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
                    return;
                } else {
                    this.shareIntro = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i)});
                    return;
                }
            }
            this.shareIntro = null;
        }
    }

    public ActivityItemData getActivityData() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<PbContent> list = this.mRichTitleList;
            if (list != null && list.size() > 0) {
                int size = this.mRichTitleList.size();
                for (int i = 0; i < size; i++) {
                    PbContent pbContent = this.mRichTitleList.get(i);
                    if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && isVideoThreadType() && (str = pbContent.text) != null && str.length() >= 3) {
                        ActivityItemData activityItemData = new ActivityItemData();
                        activityItemData.link_url = yo5.d(pbContent.text);
                        String str2 = pbContent.text;
                        activityItemData.activity_name = str2.substring(1, str2.length() - 2);
                        return activityItemData;
                    }
                }
                return null;
            }
            return null;
        }
        return (ActivityItemData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hw4
    public fy4 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            SparseArray<String> sparseArray = this.feedBackReasonMap;
            if (sparseArray != null && sparseArray.size() > 0) {
                fy4 fy4Var = new fy4();
                fy4Var.o(getThreadData().getTid());
                fy4Var.k(getThreadData().getFid());
                fy4Var.n(getThreadData().getNid());
                fy4Var.j(this.feedBackReasonMap);
                fy4Var.g = this.feedBackExtraMap;
                fy4Var.p = this.mRecomAbTag;
                fy4Var.k = this.mRecomWeight;
                fy4Var.m = this.mRecomExtra;
                fy4Var.l = this.mRecomSource;
                fy4Var.q = this.statFloor;
                fy4Var.o = getRecomCardType();
                return fy4Var;
            }
            return null;
        }
        return (fy4) invokeV.objValue;
    }

    public int getRecomCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            int i = this.recomCardType;
            if (i > 0) {
                return i;
            }
            if (isRealGod()) {
                return 4;
            }
            if (!isLiveThread() && !isLiveRecordThread()) {
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
                if (this.isShareThread && this.originalThreadData != null) {
                    return 9;
                }
                if (isRealVideoThread()) {
                    return 2;
                }
                if (isQuestionThread()) {
                    return 10;
                }
                return 1;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    private nm transStrToSpanStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (str.length() > 4) {
                str = str.substring(0, 4);
            }
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(R.layout.thread_category, (ViewGroup) null);
            if (inflate == null) {
                return null;
            }
            TextView textView = (TextView) inflate.findViewById(R.id.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0106_2));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
            bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
            return new nm(bitmapDrawable, 1);
        }
        return (nm) invokeL.objValue;
    }

    public void parseStyle_flag(ArrayList<ex4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, arrayList) == null) {
            if (this.isNoTitle == 1) {
                this.style_flag = 0;
            } else if (arrayList != null && arrayList.size() > 0) {
                this.style_flag = 0;
                Iterator<ex4> it = arrayList.iterator();
                while (it.hasNext()) {
                    ex4 next = it.next();
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

    public SpannableString generateNaniTail(ClickableSpan clickableSpan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clickableSpan)) == null) {
            if (clickableSpan == null) {
                return null;
            }
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070303);
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.icon_card_video_jump);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            a45 a45Var = new a45(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
            String s = m35.m().s("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
            if (StringUtils.isNull(s)) {
                s = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
            }
            StringBuilder sb = new StringBuilder(s);
            if (getAuthor() != null) {
                if (getAuthor().getGender() == 1) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f08e6));
                } else if (getAuthor().getGender() == 2) {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f125e));
                } else {
                    sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f143e));
                }
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.obfuscated_res_0x7f0f143e));
            }
            sb.insert(0, "[icon]");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(a45Var, 0, 6, 17);
            spannableString.setSpan(clickableSpan, 6, spannableString.length(), 17);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public int getActInfoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isActInfo() && this.mActDatas.size() >= 1) {
                iw4 iw4Var = this.mActDatas.get(0);
                int e = iw4Var.e();
                if (e == 3) {
                    return e;
                }
                int b = iw4Var.b();
                int c = iw4Var.c();
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (currentTimeMillis < b) {
                    return 4;
                }
                if (currentTimeMillis <= c) {
                    return 1;
                }
                return 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean isShowDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            if (getIsLive() == 1 || getIs_good() == 1 || getIs_top() == 1 || isActInfo() || this.isBookChapter == 1 || isGodThread() || getAppCodeData() != null || getYulePostActivityData() != null || !gi.isEmpty(getCategory()) || isRealGod()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public SpannableStringBuilder parseTitle() {
        InterceptResult invokeV;
        SpannableStringBuilder parseRichTitle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048823, this)) == null) {
            if (!StringUtils.isNull(this.title)) {
                if (!this.mIsNeedCheckNTitle || this.isNoTitle != 1) {
                    if (isRealVideoThread() && getRecomSource() != null && getRecomSource().startsWith("manual") && ListUtils.isEmpty(this.mRichTitleList)) {
                        parseRichTitle = parseVideoTiePlusRichTitle();
                    } else {
                        parseRichTitle = parseRichTitle();
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parseRichTitle);
                    this.span_str = spannableStringBuilder;
                    return spannableStringBuilder;
                }
                return null;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeV.objValue;
    }

    public int picCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048834, this)) == null) {
            if (!pv4.c().g() || ListUtils.getCount(getMedias()) == 0) {
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

    public int getActInfoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (isActInfo() && this.mActDatas.size() >= 1 && this.mActDatas.get(0) != null) {
                return this.mActDatas.get(0).a();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String getActUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (isActInfo() && this.mActDatas.size() >= 1 && this.mActDatas.get(0) != null) {
                return this.mActDatas.get(0).g();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<rt5> getPrefixIcons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            ArrayList<rt5> arrayList = new ArrayList<>();
            if (this.isSCard) {
                arrayList.add(new rt5(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getTaskInfoStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            kz4 kz4Var = this.taskInfoData;
            if (kz4Var != null) {
                long f = kz4Var.f();
                long a = this.taskInfoData.a();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < f) {
                    return 1;
                }
                if (currentTimeMillis > a) {
                    return 3;
                }
                return 2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void insertItemToTitleOrAbstractText() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && ListUtils.getCount(this.mItemStar) > 0) {
            SpannableStringBuilder spannableStringBuilder = this.titleText;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.insert(0, (CharSequence) ut5.e(this.mItemStar));
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.abstractText);
            spannableStringBuilder2.insert(0, (CharSequence) ut5.e(this.mItemStar));
            this.abstractText = new SpannableString(spannableStringBuilder2);
        }
    }

    public boolean isCommonUserThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            MetaData metaData = this.author;
            if (metaData == null || metaData.getGodUserData() == null) {
                return true;
            }
            if (this.author.getGodUserData().getType() != 2 && this.author.getGodUserData().getType() != 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public SpannableString parseFirstFloorContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048818, this)) == null) {
            if (this.tiePlusLinkOriginData == null) {
                this.tiePlusLinkOriginData = new ArrayList();
            }
            if (!ListUtils.isEmpty(this.mFirstFloorList)) {
                return new SpannableString(ut5.G(this, this.mFirstFloorList, this.abstract_text, this.tiePlusLinkOriginData));
            }
            return null;
        }
        return (SpannableString) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            int[] iArr = new int[2];
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int size = (int) (((View.MeasureSpec.getSize(hi.s(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) - (dimensionPixelSize * 2)) / 3.0f);
            ArrayList<MediaData> medias = getMedias();
            if (pv4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i10 = 0; i10 < medias.size(); i10++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i10);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
            }
            MediaData mediaData2 = (MediaData) ListUtils.getItem(medias, 0);
            if (mediaData2 != null && (i2 = mediaData2.picWidth) > 0 && (i = mediaData2.picHeight) > 0) {
                if (i2 * 2 <= i) {
                    i8 = ((int) (size * 1.5f)) + dimensionPixelSize;
                    i9 = size * 2;
                } else if (i * 2 <= i2) {
                    i8 = (size * 2) + dimensionPixelSize;
                    i9 = (int) (size * 1.5f);
                } else if (i2 < size) {
                    if (i < size) {
                        if (i2 < i) {
                            i = (i * size) / i2;
                        } else {
                            i2 = (i2 * size) / i;
                            i = size;
                            size = i2;
                        }
                    } else {
                        if (i >= size && i < size * 2) {
                            i = (i * size) / i2;
                        }
                        size = 0;
                        i = 0;
                    }
                } else {
                    if (i2 >= size && i2 < (i7 = size * 2)) {
                        if (i < size) {
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
                    } else {
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
                    }
                    i = i4;
                    size = i5;
                }
                i = i9 + dimensionPixelSize;
                size = i8;
            } else {
                size = (size * 2) + dimensionPixelSize;
                i = size;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
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

    public void insertUsernameIntoTitleOrAbstract(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048742, this, spannableString) == null) && getAuthor() != null && !showNoName() && !showWeakenName()) {
            SpannableStringBuilder spannableStringBuilder = this.titleText;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.abstractText);
            spannableStringBuilder2.insert(0, (CharSequence) spannableString);
            this.abstractText = new SpannableString(spannableStringBuilder2);
        }
    }

    public void setLinkDataList(List<PbLinkData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048901, this, list) == null) {
            this.mLinkDataList = list;
            if (!ListUtils.isEmpty(list)) {
                for (PbLinkData pbLinkData : this.mLinkDataList) {
                    if (pbLinkData.urlType == 2 && !this.isGoods) {
                        this.isGoods = true;
                    }
                }
            }
        }
    }

    public void parseFromWriteData(WriteData writeData) {
        int i;
        String e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048819, this, writeData) != null) || writeData == null) {
            return;
        }
        try {
            this.id = "0";
            this.tid = "";
            this.fid = gg.g(writeData.getForumId(), 0L);
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
            int i2 = 0;
            if (writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth()) {
                i = 1;
            } else {
                i = 0;
            }
            builder.is_vertical = Integer.valueOf(i);
            if (gi.isEmpty(ee9.e())) {
                e = writeData.getVideoInfo().getThumbPath();
            } else {
                e = ee9.e();
            }
            builder.thumbnail_url = e;
            builder.video_url = writeData.getVideoInfo().getVideoUrl();
            this.threadVideoInfo = builder.build(true);
            this.threadType = 40;
            this.time = System.currentTimeMillis();
            if (writeData.isNoTitle()) {
                i2 = 1;
            }
            this.isNoTitle = i2;
            this.abstract_text = writeData.getContent();
            iz4 iz4Var = new iz4();
            this.forumData = iz4Var;
            iz4Var.a = writeData.getForumId();
            this.forumData.b = writeData.getForumName();
            this.mTabId = writeData.getTabId();
            this.mTabName = writeData.getTabName();
            parseFromVideoRichTitle(writeData.getTitle());
            praserTimeConsumingInfo();
            if (!StringUtils.isNull(writeData.getItem_id()) && writeData.getItemInfo() != null) {
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
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public SpannableStringBuilder parseTitleOrAbstractForFrs(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        SpannableStringBuilder parseRichTitle;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048825, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
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

    public void parserSpecTitleForFrsAndPb(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048831, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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

    public SpannableStringBuilder parseTitleOrAbstractForFrsNew(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        SpannableStringBuilder parseRichAbastract;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048826, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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

    public void setAbstract(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048837, this, str) == null) {
            this.abstract_text = str;
        }
    }

    public void setActDatas(ArrayList<iw4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048838, this, arrayList) == null) {
            this.mActDatas = arrayList;
        }
    }

    public void setAddedGood(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048839, this, z) == null) {
            setIs_good(z ? 1 : 0);
        }
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048840, this, str) == null) {
            this.address = str;
        }
    }

    public void setAgreeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048841, this, i) == null) {
            this.agreeData.agreeNum = i;
        }
    }

    public void setAgreeType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048843, this, i) == null) {
            this.agreeData.agreeType = i;
        }
    }

    public void setAnchorLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048844, this, i) == null) {
            this.anchorLevel = i;
        }
    }

    public void setAppCodeData(qw4 qw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, qw4Var) == null) {
            this.mAppCodeData = qw4Var;
        }
    }

    public void setArticeCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048846, this, str) == null) {
            this.articeCover = str;
        }
    }

    public void setAuthor(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048847, this, metaData) == null) {
            this.author = metaData;
        }
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048848, this, baijiahaoData) == null) {
            this.mBaijiahao = baijiahaoData;
        }
    }

    public void setCartoonThreadData(cx4 cx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048849, this, cx4Var) == null) {
            this.mCartoonThreadData = cx4Var;
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, str) == null) {
            this.category_name = str;
        }
    }

    public void setCopyThreadRemindType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048851, this, i) == null) {
            this.copyThreadRemindType = i;
        }
    }

    public void setCurrentPage(int i) {
        rz4 rz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048852, this, i) == null) && (rz4Var = this.threadVideoChannelInfo) != null) {
            rz4Var.b = i;
        }
    }

    public void setCustomFigure(VirtualImageCustomFigure virtualImageCustomFigure) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048853, this, virtualImageCustomFigure) == null) {
            this.mCustomFigure = virtualImageCustomFigure;
        }
    }

    public void setCustomState(VirtualImageCustomState virtualImageCustomState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, virtualImageCustomState) == null) {
            this.mCustomState = virtualImageCustomState;
        }
    }

    public void setDailyPaperTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048855, this, str) == null) {
            this.mDailyPaperTime = str;
        }
    }

    public void setDisAgreeNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048856, this, j) == null) {
            this.agreeData.diffAgreeNum = j;
        }
    }

    public void setDispatchedForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048857, this, j) == null) {
            this.dispatchedForumId = j;
        }
    }

    public void setDispatchedForumIdWithString(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048858, this, str) == null) {
            setDispatchedForumId(gg.g(str, 0L));
        }
    }

    public void setDistance(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048859, this, str) == null) {
            this.distance = str;
        }
    }

    public void setExpressionDatas(ArrayList<s95> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048860, this, arrayList) == null) {
            this.threadExpressionArrayList.clear();
            this.threadExpressionArrayList.addAll(arrayList);
        }
    }

    public void setFeedBackReasonMap(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, sparseArray) == null) {
            this.feedBackReasonMap = sparseArray;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048862, this, j) == null) {
            this.fid = j;
        }
    }

    public void setFirstClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, str) == null) {
            this.mFirstClassName = str;
        }
    }

    public void setFirstFloorList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048864, this, list) == null) {
            this.mFirstFloorList = list;
        }
    }

    public void setFloor5Video(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048865, this, z) == null) {
            this.isFloor5Video = z;
        }
    }

    public void setForumAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048866, this, str) == null) {
            this.forumAvatar = str;
        }
    }

    public void setForumData(iz4 iz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048867, this, iz4Var) == null) {
            this.forumData = iz4Var;
        }
    }

    public void setForum_name(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048868, this, str) == null) {
            this.forum_name = str;
        }
    }

    public void setFreqNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048869, this, j) == null) {
            this.mFreqNum = j;
        }
    }

    public void setFromConcern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048870, this, z) == null) {
            this.isFromConcern = z;
        }
    }

    public void setFromFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048871, this, z) == null) {
            this.isFromFrs = z;
        }
    }

    public void setFromFrsTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048872, this, z) == null) {
            this.isFromFrsTab = z;
        }
    }

    public void setFromType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048873, this, str) == null) {
            this.mFromType = str;
        }
    }

    public void setGameInformationSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048874, this, str) == null) {
            this.tieba_game_information_source = str;
        }
    }

    public void setGoods(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048875, this, z) == null) {
            this.isGoods = z;
        }
    }

    public void setHasAgree(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048876, this, i) == null) {
            AgreeData agreeData = this.agreeData;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            agreeData.hasAgree = z;
        }
    }

    public void setHas_commented(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048877, this, i) == null) {
            this.has_commented = i;
        }
    }

    public void setHotTopicInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048878, this, videoInfo) == null) {
            this.mHotTopicInfo = videoInfo;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048879, this, str) == null) {
            this.id = str;
        }
    }

    public void setImShareFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048880, this, z) == null) {
            this.isImShareFromPb = z;
        }
    }

    public void setInsertFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048881, this, i) == null) {
            this.mInsertFloor = i + 1;
        }
    }

    public void setIsBjh(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048882, this, i) == null) {
            this.isBjh = i;
        }
    }

    public void setIsDailyThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048883, this, z) == null) {
            this.isDailyThread = z;
        }
    }

    public void setIsInsertThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048884, this, z) == null) {
            this.isInsertThread = z;
        }
    }

    public void setIsManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048885, this, i) == null) {
            this.isManager = i;
        }
    }

    public void setIsMarked(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048886, this, i) == null) {
            this.isMarked = i;
        }
    }

    public void setIsOriginManager(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048887, this, i) == null) {
            this.isOriginManager = i;
        }
    }

    public void setIsSmartFrsThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048888, this, z) == null) {
            this.isSmartFrsThread = z;
        }
    }

    public void setIsTbReadDispatch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048889, this, i) == null) {
            this.isTbReadDispatch = i;
        }
    }

    public void setIs_called(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048891, this, i) == null) {
            this.is_called = i;
        }
    }

    public void setIs_good(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048892, this, i) == null) {
            this.is_good = i;
        }
    }

    public void setIs_top(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048893, this, i) == null) {
            this.is_top = i;
        }
    }

    public void setItem(Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048894, this, item) == null) {
            this.mItem = item;
        }
    }

    public void setItemData(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048895, this, itemData) == null) {
            this.itemData = itemData;
        }
    }

    public void setItemStar(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048896, this, list) == null) {
            this.mItemStar = list;
        }
    }

    public void setLastPostNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048897, this, i) == null) {
            this.mLastPostNum = i;
        }
    }

    public void setLast_time(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048898, this, str) == null) {
            this.last_time = str;
        }
    }

    public void setLast_time_int(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048899, this, j) == null) {
            this.last_time_int = j;
        }
    }

    public void setLegoCard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048900, this, str) == null) {
            this.legoCard = str;
        }
    }

    public void setMadeTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048902, this, z) == null) {
            setIs_top(z ? 1 : 0);
        }
    }

    public void setMarkID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048903, this, str) == null) {
            this.markID = str;
        }
    }

    public void setMarkToDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048904, this, z) == null) {
            this.isMarkToDel = z;
        }
    }

    public void setMarkToMove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048905, this, z) == null) {
            this.mIsMarkToMove = z;
        }
    }

    public void setMedias(ArrayList<MediaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048906, this, arrayList) == null) {
            this.mMedias = arrayList;
        }
    }

    public void setNeedCheckNTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048907, this, z) == null) {
            this.mIsNeedCheckNTitle = z;
        }
    }

    public void setPbFirstShareData(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048908, this, bc9Var) == null) {
            this.pbFirstShareData = bc9Var;
        }
    }

    public void setPbTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048909, this, str) == null) {
            this.mPbTitle = str;
        }
    }

    public void setPhotoLiveCover(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048910, this, str) == null) {
            this.mPhotoLiveCover = str;
        }
    }

    public void setPollData(PollData pollData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048911, this, pollData) == null) {
            this.mPollData = pollData;
        }
    }

    public void setPositionInFrsItemTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048912, this, i) == null) {
            this.positionInFrsItemTab = i;
        }
    }

    public void setPost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048913, this, i) == null) {
            this.post_num = i;
        }
    }

    public void setPraise(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048914, this, praiseData) == null) {
            this.praise = praiseData;
        }
    }

    public void setProfitList(List<TwAnchorProfitItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048915, this, list) == null) {
            this.profitList = list;
        }
    }

    public void setReply_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048916, this, i) == null) {
            this.reply_num = i;
        }
    }

    public void setRepost_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048917, this, i) == null) {
            this.repost_num = i;
        }
    }

    public void setResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048918, this, i) == null) {
            this.mResourceType = i;
        }
    }

    public void setRichAbstractList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048919, this, list) == null) {
            this.mRichAbstractList = list;
        }
    }

    public void setRichTitleList(List<PbContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048920, this, list) == null) {
            this.mRichTitleList = list;
        }
    }

    public void setSecondClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048921, this, str) == null) {
            this.mSecondClassName = str;
        }
    }

    public void setShareNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048922, this, j) == null) {
            this.mShareNum = j;
        }
    }

    public void setShowFullThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048923, this, z) == null) {
            this.isShowFullThread = z;
        }
    }

    public void setShow_commented(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048924, this, i) == null) {
            this.show_commented = i;
        }
    }

    public void setSmartFrsPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048925, this, i) == null) {
            this.smartFrsPosition = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048926, this, i) == null) {
            this.sortType = i;
        }
    }

    public void setSpan_str(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048927, this, spannableStringBuilder) == null) {
            this.span_str = spannableStringBuilder;
        }
    }

    public void setStyle_flag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048929, this, i) == null) {
            this.style_flag = i;
        }
    }

    public void setTargetScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048930, this, str) == null) {
            this.targetScheme = str;
        }
    }

    public void setThreadAlaInfo(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048931, this, alaInfoData) == null) {
            this.threadAlaInfo = alaInfoData;
        }
    }

    public void setThreadExtendInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048932, this, str) == null) {
            this.threadExtendInfo = str;
        }
    }

    public void setThreadRecommendInfoDataList(List<ThreadRecommendInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048933, this, list) == null) {
            this.threadRecommendInfoDataList = list;
        }
    }

    public void setThreadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048934, this, i) == null) {
            this.threadType = i;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048935, this, str) == null) {
            this.tid = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048936, this, str) == null) {
            this.title = str;
        }
    }

    public void setTopicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048937, this, str) == null) {
            this.topicUrl = str;
        }
    }

    public void setTopicUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048938, this, str) == null) {
            this.topicUserName = str;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048939, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserPostPerm(UserPostPerm userPostPerm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048940, this, userPostPerm) == null) {
            this.userPostPerm = userPostPerm;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048941, this, videoInfo) == null) {
            this.threadVideoInfo = videoInfo;
        }
    }

    public void setView_num(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048942, this, i) == null) {
            this.view_num = i;
        }
    }

    public void setVoices(ArrayList<VoiceData.VoiceModel> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048943, this, arrayList) == null) {
            this.mVoices = arrayList;
        }
    }

    public void setWonderfulPostInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048944, this, str) == null) {
            this.mWonderfulPostInfo = str;
        }
    }

    public void setYulePostActivityData(xz4 xz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048945, this, xz4Var) == null) {
            this.mYulePostActivityData = xz4Var;
        }
    }

    public void setmCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048946, this, j) == null) {
            this.mCreateTime = j;
        }
    }

    public void setmGoodsDataList(List<PbGoodsData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048947, this, list) == null) {
            this.mGoodsDataList = list;
            if (!ListUtils.isEmpty(list) && !this.isGoods) {
                this.isGoods = true;
            }
        }
    }

    public void updateIsNotitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048949, this, i) == null) {
            this.isNoTitle = i;
        }
    }

    public void setAgreeNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048842, this, j) == null) {
            this.agreeData.agreeNum = j;
        }
    }
}

package com.baidu.tbadk.core.data;

import android.content.Context;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.ActivityItemData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.DislikeInfo;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PbLinkInfo;
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.TopicModule;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bu extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.af, com.baidu.tbadk.core.util.f.a {
    private String aZd;
    private String address;
    private String authorId;
    private SpannableString dJC;
    public int dJw;
    private int dMA;
    private int dMD;
    public int dME;
    private String dMH;
    private String dMI;
    private int dMK;
    private VideoInfo dMM;
    private VideoDesc dMN;
    private cb dMO;
    private AlaInfoData dMP;
    private long dMQ;
    private r dMY;
    private int dMc;
    private SpannableStringBuilder dMh;
    private SpannableStringBuilder dMi;
    private bq dMj;
    private String dMk;
    private String dMl;
    public int dMz;
    public int dNA;
    public int dNB;
    public String dNC;
    public String dND;
    public long dNE;
    private List<ReportInfo> dNI;
    private boolean dNO;
    private long dNQ;
    private ak dNR;
    public e dNT;
    private MediaData dNU;
    public int dNV;
    public OriginalThreadInfo dNX;
    private LiveCoverStatus dNe;
    private long dNf;
    public TwZhiBoUser dNm;
    public List<TwAnchorProfitItem> dNn;
    private SkinInfo dNr;
    private boolean dNt;
    private String dNu;
    private boolean dNx;
    public String dNz;
    public boolean dOA;
    public boolean dOB;
    public String dOC;
    private int dOD;
    private String dOE;
    private int dOF;
    public String dOH;
    private String dOI;
    private ThreadInfo dOJ;
    private Item dOL;
    private List<HeadItem> dOM;
    private TopicModule dOb;
    private String dOc;
    private String dOd;
    private VideoInfo dOe;
    private String dOf;
    private boolean dOh;
    public OriginalForumInfo dOi;
    public boolean dOj;
    private String dOk;
    private boolean dOl;
    private SmartApp dOm;
    private String dOo;
    private String dOp;
    private String dOq;
    private String dOr;
    private String dOs;
    public String dOt;
    private boolean dOw;
    private boolean dOx;
    public boolean dOy;
    public boolean dOz;
    private boolean isLinkThread;
    public boolean isPrivacy;
    public boolean isShareThread;
    public ItemData itemData;
    public ItemStarData itemStarData;
    private String latitude;
    private BaijiahaoData mBaijiahao;
    private long mCreateTime;
    private String mNid;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private int mTabId;
    private String mTabName;
    public String noCommetStr;
    private int post_num;
    public int sortType;
    public int threadType;
    public String thread_share_link;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId dLl = BdUniqueId.gen();
    public static final BdUniqueId dLm = BdUniqueId.gen();
    public static final BdUniqueId dLn = BdUniqueId.gen();
    public static final BdUniqueId dLo = BdUniqueId.gen();
    public static final BdUniqueId dLp = BdUniqueId.gen();
    public static final BdUniqueId dLq = BdUniqueId.gen();
    public static final BdUniqueId dLr = BdUniqueId.gen();
    public static final BdUniqueId dLs = BdUniqueId.gen();
    public static final BdUniqueId dLt = BdUniqueId.gen();
    public static final BdUniqueId dLu = BdUniqueId.gen();
    public static final BdUniqueId dLv = BdUniqueId.gen();
    public static final BdUniqueId dLw = BdUniqueId.gen();
    public static final BdUniqueId dLx = BdUniqueId.gen();
    public static final BdUniqueId dLy = BdUniqueId.gen();
    public static final BdUniqueId dLz = BdUniqueId.gen();
    public static final BdUniqueId dLA = BdUniqueId.gen();
    public static final BdUniqueId dLB = BdUniqueId.gen();
    public static final BdUniqueId dLC = BdUniqueId.gen();
    public static final BdUniqueId dLD = BdUniqueId.gen();
    public static final BdUniqueId dLE = BdUniqueId.gen();
    public static final BdUniqueId dLF = BdUniqueId.gen();
    public static final BdUniqueId dLG = BdUniqueId.gen();
    public static final BdUniqueId dLH = BdUniqueId.gen();
    public static final BdUniqueId dLI = BdUniqueId.gen();
    public static final BdUniqueId dLJ = BdUniqueId.gen();
    public static final BdUniqueId dLK = BdUniqueId.gen();
    public static final BdUniqueId dLL = BdUniqueId.gen();
    public static final BdUniqueId dLM = BdUniqueId.gen();
    public static final BdUniqueId dLN = BdUniqueId.gen();
    public static final BdUniqueId dLO = BdUniqueId.gen();
    public static final BdUniqueId dLP = BdUniqueId.gen();
    public static final BdUniqueId dLQ = BdUniqueId.gen();
    public static final BdUniqueId dLR = BdUniqueId.gen();
    public static final BdUniqueId dLS = BdUniqueId.gen();
    public static final BdUniqueId dLT = BdUniqueId.gen();
    public static final BdUniqueId dLU = BdUniqueId.gen();
    public static AtomicBoolean dLV = new AtomicBoolean(false);
    public static AtomicBoolean dLW = new AtomicBoolean(false);
    public static AtomicBoolean dLX = new AtomicBoolean(false);
    public static final BdUniqueId dLY = BdUniqueId.gen();
    private static HashMap<Point, Integer> dMZ = new HashMap<>();
    private static HashMap<Integer, Integer> dNa = new HashMap<>();
    public static final BdUniqueId dNk = BdUniqueId.gen();
    public static final BdUniqueId dNs = BdUniqueId.gen();
    private static HashMap<Point, Integer> dNJ = new HashMap<>();
    private static SparseArray<m.a> dNK = new SparseArray<>(3);
    public boolean dKS = false;
    public boolean dKT = false;
    public boolean dKU = false;
    public boolean dKV = false;
    public boolean dKW = false;
    public boolean dKX = false;
    public boolean dKY = false;
    public boolean dKZ = false;
    private int dLZ = 0;
    private String dMa = "1";
    public int dMb = 1;
    private String dMC = null;
    private int dIa = 0;
    public int dMR = 0;
    private String dMS = "";
    public boolean dMT = false;
    private String dNb = "";
    public boolean dNF = true;
    public boolean dNL = false;
    public boolean dNM = false;
    private int dNN = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean dNS = false;
    private int dOa = 0;
    private boolean dOg = false;
    private boolean dOn = false;
    public boolean dOu = false;
    public boolean dOv = false;
    public boolean forbidComment = false;
    public boolean dOG = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int dMm = 0;
    private int dMn = 0;
    private String last_time = null;
    private long dMo = 0;
    private int dMp = 0;
    private int dMq = 0;
    private int dMr = 0;
    private int dMs = 0;
    private by dMt = new by();
    private MetaData dMu = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> dMx = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> dMy = new ArrayList<>();
    private int dMv = 0;
    private int dMw = 0;
    private String ad_url = null;
    private String dMd = null;
    private String from = null;
    private int dMB = 0;
    private PraiseData dMF = new PraiseData();
    private AnchorInfoData dMG = new AnchorInfoData();
    private long time = 0;
    private int dMJ = 0;
    private ArrayList<a> dMV = new ArrayList<>();
    private cg dMW = null;
    private f dMX = null;
    private int dNc = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> dML = new ArrayList<>();
    private boolean isHeadLive = false;
    private String dNd = null;
    private int dMU = 0;
    private boolean dNg = false;
    private boolean dNh = false;
    private int dNi = 0;
    private boolean dNj = false;
    private int anchorLevel = 0;
    public int dNv = 0;
    public o dNw = new o();
    private List<PbContent> dMg = new ArrayList();
    private List<PbContent> dMe = new ArrayList();
    private List<PbContent> dMf = new ArrayList();
    private String category_name = null;
    private bs dNl = new bs();
    private ArrayList<com.baidu.tbadk.data.c> dNo = new ArrayList<>();
    private PushStatusData dNp = new PushStatusData();
    public boolean dNG = false;
    public int dNH = -1;
    private PostData dNP = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int dNy = 0;
    public int dNW = 0;
    private String tieba_game_information_source = "";
    public String dNZ = "";
    public String dNY = "";
    public String mUrl = "";
    public String dNq = "";
    PollData dON = new PollData();
    private List<PbLinkData> dOK = new ArrayList();

    static {
        dMZ.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        dMZ.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        dMZ.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        dMZ.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        dMZ.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        dMZ.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        dMZ.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        dMZ.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        dNJ.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        dNJ.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        dNJ.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        dNJ.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        dNJ.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        dNJ.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        dNJ.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        dNJ.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        dNa.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        dNa.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        dNa.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        dNK.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        dNK.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        dNK.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bu() {
        this.dMA = 0;
        this.dMK = 0;
        this.dNf = 0L;
        this.dNV = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.dNf = 0L;
        this.dMK = 0;
        this.dMA = 0;
        this.dNV = 0;
    }

    public String aRM() {
        return this.dOo;
    }

    public String aRN() {
        return this.dOp;
    }

    public void vP(String str) {
        this.dOp = str;
    }

    public String aRO() {
        return this.dOq;
    }

    public SpannableStringBuilder aRP() {
        return this.dMi;
    }

    public SpannableString aRQ() {
        return this.dJC;
    }

    public void a(SpannableString spannableString) {
        if (aSp() != null) {
            if (this.dMi != null) {
                this.dMi.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dJC);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dJC = new SpannableString(spannableStringBuilder);
        }
    }

    public void aRR() {
        if (com.baidu.tbadk.core.util.w.getCount(this.dOM) > 0) {
            if (this.dMi != null) {
                this.dMi.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bd(this.dOM));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dJC);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bd(this.dOM));
            this.dJC = new SpannableString(spannableStringBuilder);
        }
    }

    public String aRS() {
        return this.dOr;
    }

    public String aRT() {
        return this.dOs;
    }

    public boolean aRU() {
        return this.dMA == 1;
    }

    public bs aRV() {
        return this.dNl;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void kD(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.dMK;
    }

    public void kE(int i) {
        this.dNi = i;
    }

    public int aRW() {
        return this.dNi;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aRX() {
        return this.dOe;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void ca(long j) {
        this.mCreateTime = j;
    }

    public long aRY() {
        return this.dMQ;
    }

    public String aRZ() {
        return this.dMH;
    }

    public PraiseData aSa() {
        return this.dMF;
    }

    public void a(PraiseData praiseData) {
        this.dMF = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aSb() {
        return this.aZd;
    }

    public void vQ(String str) {
        this.aZd = str;
    }

    public String aSc() {
        return this.dMa;
    }

    public void vR(String str) {
        this.dMa = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void kF(int i) {
        this.dLZ = i;
    }

    public int aSd() {
        return this.dLZ;
    }

    public String aSe() {
        return this.tieba_game_information_source;
    }

    public String getTid() {
        return (StringUtils.isNull(this.tid) || "0".equals(this.tid)) ? this.id : this.tid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String getCategory() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<PbContent> aSf() {
        return this.dMg;
    }

    public void aG(List<PbContent> list) {
        this.dMg = list;
    }

    public void aH(List<PbContent> list) {
        this.dMe = list;
    }

    public void aI(List<PbContent> list) {
        this.dMf = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void kG(int i) {
        this.reply_num = i;
    }

    public int aSg() {
        return this.reply_num;
    }

    public int aSh() {
        return this.dMn;
    }

    public void kH(int i) {
        this.dMn = i;
    }

    public long aSi() {
        return this.dMo;
    }

    public void cb(long j) {
        this.dMo = j;
    }

    public int aSj() {
        return this.dMq;
    }

    public int aSk() {
        return this.dMp;
    }

    public void kI(int i) {
        this.dMp = i;
    }

    public int aSl() {
        return this.dMr;
    }

    public void kJ(int i) {
        this.dMr = i;
    }

    public int aSm() {
        return this.dMs;
    }

    public List<PbContent> aSn() {
        return this.dMe;
    }

    public by aSo() {
        return this.dMt;
    }

    public MetaData aSp() {
        return this.dMu;
    }

    public boolean aSq() {
        return this.is_god != 0;
    }

    public boolean aSr() {
        return this.is_god == 1;
    }

    public boolean aSs() {
        return (this.dMu == null || this.dMu.getGodUserData() == null || this.dMu.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.dMu = metaData;
    }

    public String aSt() {
        return this.forum_name;
    }

    public void vS(String str) {
        this.forum_name = str;
    }

    public int aSu() {
        return this.dMw;
    }

    public String aSv() {
        return this.ad_url;
    }

    public int aSw() {
        return this.dMB;
    }

    public void kK(int i) {
        this.dMB = i;
    }

    public String aSx() {
        return this.dMC;
    }

    public void vT(String str) {
        this.dMC = str;
    }

    public ArrayList<MediaData> aSy() {
        return this.dMx;
    }

    public ArrayList<a> aSz() {
        return this.dMV;
    }

    public void x(ArrayList<a> arrayList) {
        this.dMV = arrayList;
    }

    public cg aSA() {
        return this.dMW;
    }

    public f aSB() {
        return this.dMX;
    }

    public ArrayList<VoiceData.VoiceModel> aSC() {
        return this.dMy;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aSD() {
        return this.dMc;
    }

    public void kL(int i) {
        this.dMc = i;
    }

    public String aSE() {
        return this.latitude;
    }

    public String aSF() {
        return this.dMI;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aSG() {
        return this.dMS;
    }

    public VideoInfo aSH() {
        return this.dMM;
    }

    public void a(VideoInfo videoInfo) {
        this.dMM = videoInfo;
    }

    public VideoDesc aSI() {
        return this.dMN;
    }

    public void a(AlaInfoData alaInfoData) {
        this.dMP = alaInfoData;
    }

    public AlaInfoData aSJ() {
        return this.dMP;
    }

    public PushStatusData aSK() {
        return this.dNp;
    }

    public SkinInfo aSL() {
        return this.dNr;
    }

    public long aSM() {
        return this.dNE;
    }

    public boolean aSN() {
        return this.dNF;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aPT() {
        return this.dND;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ap apVar = new ap();
        apVar.setTid(aPS().getTid());
        apVar.setFid(aPS().getFid());
        apVar.setNid(aPS().getNid());
        apVar.setFeedBackReasonMap(this.feedBackReasonMap);
        apVar.abTag = this.mRecomAbTag;
        apVar.weight = this.mRecomWeight;
        apVar.extra = this.mRecomExtra;
        apVar.source = this.mRecomSource;
        apVar.dJw = this.dJw;
        apVar.cardType = aUp();
        return apVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.dMI = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.dMA = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.dMQ = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.dMm = threadInfo.repost_num.intValue();
                this.dMn = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.dMo = threadInfo.last_time_int.intValue();
                this.dMp = threadInfo.is_top.intValue();
                this.dMq = threadInfo.is_membertop.intValue();
                this.dMr = threadInfo.is_good.intValue();
                this.dMs = threadInfo.is_livepost.intValue();
                this.dMt.a(threadInfo.topic);
                this.dMu.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.dMv = threadInfo.has_commented.intValue();
                this.dMw = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.dMM = threadInfo.video_info;
                this.dMN = threadInfo.video_segment;
                this.dMP = new AlaInfoData();
                this.dMP.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.dMB = threadInfo.collect_status.intValue();
                this.dMC = threadInfo.collect_mark_pid;
                this.dMD = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.dME = threadInfo.thread_type.intValue();
                this.dMH = threadInfo.first_post_id + "";
                this.dMS = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.dMc = threadInfo.is_ntitle.intValue();
                this.dMJ = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.dNQ = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.dMK = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.dNx = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.dMe = threadInfo.rich_title;
                this.dMg = threadInfo.first_post_content;
                this.dMf = threadInfo.rich_abstract;
                this.dMz = threadInfo.is_godthread_recommend.intValue();
                if ((this.dMu == null || this.dMu.getUserId() == null || this.dMu.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dMu = metaData;
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
                this.dMd = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.dMx.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.dMM = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.dMO = new cb();
                    this.dMO.a(threadInfo.video_channel_info);
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
                        this.dMy.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.dMV.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.dMW = new cg();
                    this.dMW.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.dMX = new f();
                    this.dMX.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.dMY = new r();
                    this.dMY.a(threadInfo.cartoon_info);
                }
                this.dMF.setUserMap(this.userMap);
                this.dMF.parserProtobuf(threadInfo.zan);
                this.dMG.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dMF.setTitle(this.title);
                } else {
                    this.dMF.setTitle(this.dMd);
                }
                this.dNb = threadInfo.livecover_src;
                this.dNc = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.dMU = threadInfo.post_num.intValue();
                this.dNf = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.nl(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.xV(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.dML.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.dNd = noticeInfo.notice;
                    }
                    this.dNi = zhiBoInfoTW.copythread_remind.intValue();
                    this.dNg = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.dNh = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.dNb)) {
                        this.dNb = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.dNm = zhiBoInfoTW.user.tw_anchor_info;
                        this.dNn = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.dNe = threadInfo.twzhibo_info.livecover_status;
                    this.dNf = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.dNj = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.dNl.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.dNo.add(cVar2);
                    }
                }
                this.dNp.parserProtobuf(threadInfo.push_status);
                this.dNu = threadInfo.lego_card;
                this.dNr = threadInfo.skin_info;
                this.dNv = threadInfo.is_book_chapter.intValue();
                this.dNw.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.dND = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.dNE = threadInfo.last_read_pid.longValue();
                this.dNF = threadInfo.cheak_repeat.intValue() == 1;
                this.dNI = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.dNP.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.w.getCount(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                }
                this.dNO = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.dNR = new ak();
                    this.dNR.a(threadInfo.link_info);
                }
                this.dNS = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.dNT = new e();
                    this.dNT.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.dNU = new MediaData();
                    this.dNU.parserProtobuf(threadInfo.pic_info);
                }
                this.dNy = threadInfo.is_called.intValue();
                this.dNV = threadInfo.middle_page_num.intValue();
                this.dNW = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.dNY = threadInfo.star_rank_icon.icon_pic_url;
                    this.dNZ = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.dNX = new OriginalThreadInfo();
                    this.dNX.a(threadInfo.origin_thread_info);
                } else {
                    this.dNX = null;
                    this.isShareThread = false;
                }
                this.dOa = threadInfo.is_topic.intValue();
                this.dOc = threadInfo.topic_user_name;
                this.dOd = threadInfo.topic_h5_url;
                this.dOb = threadInfo.topic_module;
                this.dOf = threadInfo.presentation_style;
                this.dOi = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.dOk = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.dMj = new bq();
                    this.dMj.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.dOm = threadInfo.swan_info;
                }
                this.dOt = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.dOu = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.dOE = threadInfo.article_cover;
                this.dOF = threadInfo.bjh_content_tag.intValue();
                this.dOD = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dOG = threadInfo.is_s_card.intValue() == 1;
                this.dOH = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.dOI = threadInfo.wonderful_post_info;
                aSO();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.dOJ = threadInfo;
                if (!com.baidu.tbadk.core.util.w.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        this.dOK.add(pbLinkData);
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.dOL = threadInfo.item;
                }
                if (this.dOL != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.dOL);
                }
                this.dOM = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.w.isEmpty(this.dOM)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.dOM);
                }
                if (threadInfo.poll_info != null) {
                    this.dON.parserProtobuf(threadInfo.poll_info);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Deprecated
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.fid = jSONObject.optLong("fid", 0L);
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.dMQ = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.dMm = jSONObject.optInt("repost_num", 0);
                this.dMn = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.dMo = jSONObject.optLong("last_time_int", 0L);
                this.dMp = jSONObject.optInt("is_top", 0);
                this.dMq = jSONObject.optInt("is_membertop", 0);
                this.dMr = jSONObject.optInt("is_good", 0);
                this.dMs = jSONObject.optInt("is_livepost", 0);
                this.dMt.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.dMu.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.dMv = jSONObject.optInt("has_commented", 0);
                this.dMw = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.dMB = jSONObject.optInt("collect_status");
                this.dMC = jSONObject.optString("collect_mark_pid");
                this.dMD = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.dME = jSONObject.optInt("thread_type");
                this.dNQ = jSONObject.optLong("share_num");
                this.dMH = jSONObject.optString("first_post_id", "0");
                this.dMS = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.dMc = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.dNl.parserJson(optJSONObject2);
                }
                if ((this.dMu == null || this.dMu.getUserId() == null) && this.userMap != null) {
                    this.dMu = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.dMP = new AlaInfoData();
                this.dMP.parserJson(jSONObject.optJSONObject("ala_info"));
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                            sb.append(optJSONArray.getJSONObject(i).optString("text"));
                        }
                    }
                }
                this.dMd = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.dMx.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.dMy.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.dMV.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.dMW = new cg();
                    this.dMW.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.dMX = new f();
                    this.dMX.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.dMY = new r();
                    this.dMY.parserJson(optJSONObject6);
                }
                this.dMF.setUserMap(this.userMap);
                this.dMF.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.dMG.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dMF.setTitle(this.title);
                } else {
                    this.dMF.setTitle(this.dMd);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.dNl.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.dNo.add(cVar);
                    }
                }
                this.dNv = jSONObject.optInt("is_book_chapter", 0);
                this.dNw.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.dND = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.dNz = jSONObject.optString("recom_extra_img");
                this.dNC = jSONObject.optString("recom_extra_img_night");
                this.dNA = jSONObject.optInt("recom_extra_img_width", 0);
                this.dNB = jSONObject.optInt("recom_extra_img_height", 0);
                this.dNE = jSONObject.optLong("last_read_pid");
                this.dNF = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.dMO = new cb();
                    this.dMO.cG(optJSONObject8);
                }
                this.dNO = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.dNR = new ak();
                    this.dNR.parserJson(optJSONObject9);
                }
                this.dNS = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.dNT = new e();
                    this.dNT.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.dNU = new MediaData();
                    this.dNU.parserJson(optJSONObject11);
                }
                this.dNy = jSONObject.optInt("is_called", 0);
                this.dNV = jSONObject.optInt("middle_page_num", 0);
                this.dNW = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject12.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject12.optInt(LogConfig.LOG_VIDEO_TYPE, 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject12.optInt("is_vertical", 0));
                    builder.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                    this.dMM = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.dNX = new OriginalThreadInfo();
                        this.dNX.parserJson(optJSONObject13);
                    } else {
                        this.dNX = null;
                    }
                } else {
                    this.dNX = null;
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject14 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject14.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder2.name = optJSONObject14.optString("name");
                    builder2._abstract = optJSONObject14.optString("abstract");
                    builder2.pic = optJSONObject14.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                    builder2.h5_url = optJSONObject14.optString("h5_url");
                    builder2.id = optJSONObject14.optString("id");
                    builder2.link = optJSONObject14.optString("link");
                    this.dOm = builder2.build(false);
                }
                this.dOt = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.dOu = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.dOD = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.dOF = jSONObject.optInt("bjh_content_tag");
                this.dOE = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dOG = jSONObject.optInt("is_s_card", 0) == 1;
                this.dOH = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.dOI = jSONObject.optString("wonderful_post_info");
                aSO();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    this.dON.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray6.getJSONObject(i6));
                        this.dOK.add(pbLinkData);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aSO() {
        aSP();
        aSR();
        aSU();
        aSV();
        aSW();
        aSX();
        aSY();
    }

    private void aSP() {
        if (!StringUtils.isNull(this.dMu.getName_show())) {
            this.dOo = com.baidu.tbadk.core.util.ar.cutChineseAndEnglishWithSuffix(this.dMu.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aSQ() {
        if (this.dMP != null) {
            if (this.dMP.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cl = com.baidu.tbadk.core.util.ar.cl(this.mCreateTime);
                if (!StringUtils.isNull(cl)) {
                    this.dOp = cl;
                }
            }
            if (this.dMP.openRecomFans == 1) {
                int i = 0;
                if (this.dMP != null && this.dMP.user_info != null) {
                    i = this.dMP.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.dOp) && i > 0) {
                    this.dOp += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.ar.cn(i);
                } else if (i > 0) {
                    this.dOp = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.ar.cn(i);
                }
            }
        }
    }

    private void aSR() {
        if (aQZ() || (aUh() && getType() != dLI)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String ck = com.baidu.tbadk.core.util.ar.ck(j);
                if (com.baidu.tbadk.core.util.ar.wK(ck)) {
                    ck = com.baidu.tbadk.core.util.ar.getFormatTimeShort(j);
                }
                this.dOp = ck;
            }
            String str = "";
            if (this.dMu != null && this.dMu.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.dMu.getBaijiahaoInfo().auth_desc)) {
                str = this.dMu.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.dOp) && !TextUtils.isEmpty(str)) {
                this.dOp += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.dOp = str;
            } else if (!this.dOy && this.dMu != null && this.dMu.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.ar.cutChineseAndEnglishWithSuffix(this.dMu.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dOp)) {
                    this.dOp += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.dOp = cutChineseAndEnglishWithSuffix;
                }
            } else if (aUs()) {
                aSS();
            }
        } else if (getType() == dLI) {
            aSQ();
        } else {
            long aSi = aSi() * 1000;
            if (aSi != 0) {
                String ck2 = com.baidu.tbadk.core.util.ar.ck(aSi);
                if (com.baidu.tbadk.core.util.ar.wK(ck2)) {
                    ck2 = com.baidu.tbadk.core.util.ar.getFormatTimeShort(aSi);
                }
                this.dOp = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + ck2;
            } else {
                long j2 = this.mCreateTime;
                String ck3 = com.baidu.tbadk.core.util.ar.ck(j2);
                if (com.baidu.tbadk.core.util.ar.wK(ck3)) {
                    ck3 = com.baidu.tbadk.core.util.ar.getFormatTimeShort(j2);
                }
                this.dOp = ck3;
            }
            if (!this.dOy && this.dMu != null && this.dMu.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.ar.cutChineseAndEnglishWithSuffix(this.dMu.getBazhuGradeData().getDesc(), this.dOx ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dOp)) {
                    this.dOp += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.dOp = cutChineseAndEnglishWithSuffix2;
                }
            } else if (aUs()) {
                aSS();
            }
            if (!TextUtils.isEmpty(this.dOp) && !TextUtils.isEmpty(getAddress())) {
                this.dOp += " • " + getAddress();
            }
        }
    }

    private void aSS() {
        if (aUs() && !TextUtils.isEmpty(this.dMu.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.dOp)) {
                this.dOp += "   " + this.dMu.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.dOp = this.dMu.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void aST() {
        if (!aQZ() && !aUh()) {
            long aSi = 1000 * aSi();
            if (aSi != 0) {
                String ck = com.baidu.tbadk.core.util.ar.ck(aSi);
                if (com.baidu.tbadk.core.util.ar.wK(ck)) {
                    ck = com.baidu.tbadk.core.util.ar.getFormatTimeShort(aSi);
                }
                this.dOp = ck;
            }
            if (!this.dOy && this.dMu != null && this.dMu.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.ar.cutChineseAndEnglishWithSuffix(this.dMu.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dOp)) {
                    this.dOp += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.dOp = cutChineseAndEnglishWithSuffix;
                }
            } else if (aUs()) {
                aSS();
            }
            if (!TextUtils.isEmpty(this.dOp) && !TextUtils.isEmpty(getAddress())) {
                this.dOp += " • " + getAddress();
            }
        }
    }

    private void aSU() {
        if (aSJ() == null || aSJ().share_info == null || aSJ().share_info.share_user_count <= 0 || !aTJ() || (this.dNV > 0 && this.dNW == 0)) {
            this.dOq = null;
            return;
        }
        int i = aSJ().share_info.share_user_count;
        if (i == 1) {
            this.dOq = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.dOq = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.ar.numberUniform(i)});
        }
    }

    private void aSV() {
        this.dMi = aTm();
        com.baidu.tieba.card.m.a(this, this.dMi, true);
    }

    private void aSW() {
        this.dJC = aTk();
    }

    private void aSX() {
        this.dOr = com.baidu.tbadk.core.util.ar.getFormatTimeShort(aSi() * 1000);
    }

    private void aSY() {
        this.dOs = com.baidu.tbadk.core.util.ar.getFormatTimeShort(aSi());
    }

    public SpannableStringBuilder aSZ() {
        return this.dMh;
    }

    public boolean isTop() {
        return aSk() != 0;
    }

    public int aTa() {
        if (this.dNl != null) {
            long aRH = this.dNl.aRH();
            long aRI = this.dNl.aRI();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aRH) {
                return 1;
            }
            if (currentTimeMillis > aRI) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aTb() {
        if (aTd() && this.dMV.size() >= 1) {
            a aVar = this.dMV.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aQe = aVar.aQe();
            int aQf = aVar.aQf();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aQe) {
                return 4;
            }
            return currentTimeMillis > aQf ? 2 : 1;
        }
        return -1;
    }

    public int aTc() {
        if (!aTd() || this.dMV.size() < 1 || this.dMV.get(0) == null) {
            return -1;
        }
        return this.dMV.get(0).aQd();
    }

    public boolean aTd() {
        return this.dMJ == 1;
    }

    public String getActUrl() {
        return (!aTd() || this.dMV.size() < 1 || this.dMV.get(0) == null) ? "" : this.dMV.get(0).getUrl();
    }

    private com.baidu.adp.widget.b vU(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(R.layout.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.cp_cont_f_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                bVar = new com.baidu.adp.widget.b(bitmapDrawable, 1);
            } else {
                bVar = null;
            }
            return bVar;
        }
        return null;
    }

    public SmartApp aTe() {
        return this.dOm;
    }

    private void u(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aTg()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aSk() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aSk() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aSm() == 1 || this.dMt.aUE() != 0) {
                if (aRV() != null && getThreadType() == 41) {
                    if (aTa() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aTx()) {
                Integer num = dNa.get(Integer.valueOf(aTa()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aSl() == 1 && !isTop() && dLH != getType() && dLP != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.dMG != null && this.dMG.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aSu() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = dMZ.get(new Point(aTc(), aTb()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aSA() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aSB() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = vU(this.category_name);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("1 ");
            }
            String sb2 = sb.toString();
            if (bVar != null) {
                spannableString = new SpannableString(sb2 + this.category_name + " ");
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bitmap bitmap = com.baidu.tbadk.core.util.an.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.dMb));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aTh = aTh();
        if (aTh != null) {
            spannableStringBuilder.append((CharSequence) aTh);
        }
        this.dMh = spannableStringBuilder;
    }

    public boolean aTf() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = com.baidu.tbadk.core.util.an.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aSp() != null) {
            if (aSp().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aSp().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(jVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean aTg() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void v(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.w.getCount(b(z, z2, z3, false)) > 0) {
            w(z, z3);
            return;
        }
        SpannableStringBuilder aTh = aTh();
        if (z) {
            spannableStringBuilder = a(aTh.toString(), aTh, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aTh);
        }
        this.dMh = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.dMc == 1) {
                this.dMh = a;
                return a;
            }
        } else if (this.dMc == 1) {
            this.dMh = new SpannableStringBuilder();
            return a;
        }
        if (spannableStringBuilder != null) {
            a.append((CharSequence) spannableStringBuilder);
            return a;
        } else if (b.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public void db(String str, String str2) {
        this.mUrl = str;
        this.dNq = str2;
    }

    public SpannableStringBuilder aTh() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dMe, this.title);
    }

    public SpannableStringBuilder aTi() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dMf, this.dMd);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aTj() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.dOG) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aTk() {
        SpannableStringBuilder aTi = aTi();
        com.baidu.tieba.card.m.a(this, aTi, false);
        return new SpannableString(aTi);
    }

    public SpannableString aTl() {
        if (com.baidu.tbadk.core.util.w.isEmpty(this.dMg)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.dMg, this.dMd));
    }

    public String getAbstract() {
        return this.dMd;
    }

    public void vV(String str) {
        this.dMd = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aTh;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.dMc == 1) {
            aTh = aTi();
            spannableStringBuilder = aTh.toString();
        } else {
            aTh = aTh();
            spannableStringBuilder = aTh.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aTh, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aTh);
        }
        this.dMh = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder w(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder x(boolean z, boolean z2) {
        SpannableStringBuilder aTi;
        if (!StringUtils.isNull(this.title) && this.dMc != 1) {
            aTi = aTh();
        } else {
            aTi = aTi();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aTi);
        this.dMh = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aTm() {
        if (StringUtils.isNull(this.title) || this.dMc == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aTh());
        this.dMh = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aQU() {
        if (this.dMe != null && this.dMe.size() > 0) {
            int size = this.dMe.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.dMe.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aQV() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.ze(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aTn() {
        u(false, false);
    }

    public void aTo() {
        u(false, true);
    }

    public AnchorInfoData aTp() {
        return this.dMG;
    }

    public boolean aTq() {
        return this.threadType == 36;
    }

    public boolean aQV() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aTr() {
        return this.threadType == 11 || this.dMD == 1;
    }

    public boolean aTs() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aSy = aSy();
        if (aSy == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aSy.size() || i2 >= 3) {
                break;
            }
            if (aSy.get(i2) != null && aSy.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aSy.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aSy.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aSy.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
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
        if (this.dMM != null && !StringUtils.isNull(this.dMM.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.dMM.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.dMu != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.dMu.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aTt() {
        String userId;
        return this.dMu == null || (userId = this.dMu.getUserId()) == null || userId.equals("0");
    }

    public boolean aTu() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (aUe()) {
            if (aSH() != null) {
                return dLH;
            }
            return dLm;
        }
        int aSk = aSk();
        if (this.dOa == 1) {
            if (this.dOb != null) {
                return dLy;
            }
            return this.dOe != null ? dLR : dLQ;
        } else if (this.dMP != null && this.threadType == 60) {
            return dLK;
        } else {
            if (this.dMP != null && this.threadType == 49) {
                return dLI;
            }
            if (this.threadType == 51) {
                return dLJ;
            }
            if (this.threadType == 63) {
                return dLS;
            }
            if (this.threadType == 64) {
                return dLT;
            }
            if (aSk == 2 || aSk == 1) {
                return dLl;
            }
            if (this.dMM != null && aTC() && !aTu()) {
                return dLY;
            }
            if (this.dMM != null && !aTu()) {
                if (aSs()) {
                    return dLP;
                }
                return dLH;
            } else if (this.isShareThread && this.dNX != null) {
                if (this.dNX.dJD) {
                    if (this.dNX.videoInfo != null) {
                        return dLO;
                    }
                    if (this.dNX.aQX()) {
                        return dLN;
                    }
                    return dLM;
                }
                return dLL;
            } else if (aQX()) {
                return dLz;
            } else {
                if (aTw()) {
                    return dLV.get() ? dNk : dLm;
                } else if (aTd() && aTc() == 1) {
                    return dLV.get() ? dNs : dLm;
                } else if (isLinkThread()) {
                    return dLF;
                } else {
                    if (aSs()) {
                        return dLG;
                    }
                    if (this.dKS) {
                        return dLq;
                    }
                    if (this.dKT) {
                        return dLr;
                    }
                    if (this.dKU) {
                        return dLs;
                    }
                    if (this.dKV) {
                        return dLt;
                    }
                    if (this.dKW) {
                        return dLu;
                    }
                    if (this.dKY) {
                        return dLw;
                    }
                    if (this.dKZ) {
                        return dLx;
                    }
                    if (this.dKX) {
                        return dLv;
                    }
                    if (this.dMT) {
                        int aTv = aTv();
                        if (aTv == 1) {
                            return dLn;
                        }
                        if (aTv == 2) {
                            return dLo;
                        }
                        if (aTv > 2) {
                            return dLp;
                        }
                        return dLm;
                    }
                    return dLm;
                }
            }
        }
    }

    public int aTv() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.aPA().isShowImages() || com.baidu.tbadk.core.util.w.getCount(aSy()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aSy().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aTw() {
        return aRV() != null && getThreadType() == 41 && aSm() == 1 && aTa() == 2;
    }

    public void y(ArrayList<s> arrayList) {
        if (this.dMc == 1) {
            this.dIa = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dIa = 0;
        } else {
            this.dIa = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.aQr() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aQr().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dIa = next.aQs();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aTx() {
        return this.threadType == 41;
    }

    public boolean aTy() {
        return this.dNt;
    }

    public void gX(boolean z) {
        this.dNt = z;
    }

    public String aTz() {
        return this.dNu;
    }

    public r aTA() {
        return this.dMY;
    }

    public void aTB() {
        if (this.dMR == 0) {
            this.dMR = 1;
        }
    }

    public void gY(boolean z) {
        this.dNG = z;
    }

    public boolean aTC() {
        return this.dNG;
    }

    public void kM(int i) {
        this.dNH = i + 1;
    }

    public int aTD() {
        return this.dNH;
    }

    public boolean aTE() {
        return this.dOw;
    }

    public void gZ(boolean z) {
        this.dOw = z;
    }

    public cb aTF() {
        return this.dMO;
    }

    public boolean aTG() {
        return getThreadType() == 49;
    }

    public boolean aTH() {
        return getThreadType() == 40;
    }

    public boolean aTI() {
        return getThreadType() == 50;
    }

    public boolean aTJ() {
        return getThreadType() == 60;
    }

    public int aTK() {
        return this.dNN;
    }

    public void setSmartFrsPosition(int i) {
        this.dNN = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aTL() {
        return this.mRecomSource;
    }

    public boolean aTM() {
        return this.dNO;
    }

    public long aTN() {
        return this.agreeData.agreeNum;
    }

    public long aTO() {
        return this.agreeData.disAgreeNum;
    }

    public int aTP() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aTQ() {
        return this.agreeData.agreeType;
    }

    public void kN(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void kO(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cc(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cd(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void kP(int i) {
        this.agreeData.agreeType = i;
    }

    public long aTR() {
        return this.dNQ;
    }

    public void ce(long j) {
        this.dNQ = j;
    }

    public PostData aTS() {
        return this.dNP;
    }

    public ak aTT() {
        return this.dNR;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean aSq = aSq();
        if (z2) {
            if (z) {
                if (aSq && !aQV()) {
                    arrayList.add(new m.a((int) R.string.god_title));
                }
                if (aSm() == 1 || getThreadType() == 33 || (aSo() != null && aSo().aUE() != 0)) {
                    if (aRV() != null && aTx()) {
                        if (aTa() == 2) {
                            arrayList.add(new m.a((int) R.string.interview_live));
                        }
                    } else if (!aSq) {
                        arrayList.add(new m.a((int) R.string.photo_live_tips));
                    }
                }
                if (aTx()) {
                    arrayList.add(dNK.get(aTa()));
                }
                if (aTd()) {
                    Integer num = dNJ.get(new Point(aTc(), aTb()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a((int) R.string.card_promotion_text));
                    }
                }
                if (aSA() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ar.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (aSq && aSk() != 1 && !aQV()) {
                    arrayList.add(new m.a((int) R.string.god_title));
                }
                if ((aSm() == 1 || getThreadType() == 33) && !aTx() && !aSq) {
                    arrayList.add(new m.a((int) R.string.photo_live_tips));
                }
                if (aSl() == 1) {
                    arrayList.add(new m.a((int) R.string.good));
                }
                if (aSk() == 1) {
                    arrayList.add(new m.a((int) R.string.f1303top));
                }
                if (aTx() && aRV() != null && aTa() == 2) {
                    arrayList.add(new m.a((int) R.string.interview_live));
                }
                if (aTd()) {
                    Integer num2 = dNJ.get(new Point(aTc(), aTb()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.dNv == 1) {
                    arrayList.add(new m.a((int) R.string.card_tbread_text));
                }
                if (aSB() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aSA() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ar.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && aTG()) {
                    arrayList.add(new m.a((int) R.string.ala_live));
                }
                if (z3 && aTI()) {
                    arrayList.add(new m.a((int) R.string.live_record));
                } else if (aTH()) {
                    arrayList.add(new m.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void z(ArrayList<MediaData> arrayList) {
        this.dMx = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.dMy = arrayList;
    }

    public String aTU() {
        return this.dOc;
    }

    public void vW(String str) {
        this.dOc = str;
    }

    public void aTV() {
        this.dOa = 1;
    }

    public boolean aTW() {
        return this.dOa == 1;
    }

    public String aTX() {
        return this.dMk;
    }

    public void vX(String str) {
        this.dMk = str;
    }

    public String aTY() {
        return this.dMl;
    }

    public void vY(String str) {
        this.dMl = str;
    }

    public String aTZ() {
        return this.dOd;
    }

    public void vZ(String str) {
        this.dOd = str;
    }

    public boolean aUa() {
        return this.dOg;
    }

    public void ha(boolean z) {
        this.dOg = z;
    }

    public boolean aUb() {
        return this.dOh;
    }

    public void hb(boolean z) {
        this.dOh = z;
    }

    public void b(VideoInfo videoInfo) {
        this.dOe = videoInfo;
    }

    public boolean aUc() {
        return this.dOi != null;
    }

    public bq aUd() {
        return this.dMj;
    }

    public void a(bq bqVar) {
        this.dMj = bqVar;
    }

    public boolean aUe() {
        return this.dOl;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dMM != null) {
            return this.dMM.video_url;
        }
        return null;
    }

    public boolean aUf() {
        return this.dOn;
    }

    public void hc(boolean z) {
        this.dOn = z;
    }

    public AgreeData aUg() {
        return this.agreeData;
    }

    public boolean aUh() {
        return this.dOz;
    }

    public void hd(boolean z) {
        this.dOz = z;
    }

    public boolean aUi() {
        return this.dOx;
    }

    public void he(boolean z) {
        this.dOx = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aUj() {
        return this.dOb;
    }

    public String getShareImageUrl() {
        return this.dOt;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aSy = aSy();
        if (com.baidu.tbadk.core.k.aPA().isShowImages() && com.baidu.tbadk.core.util.w.getCount(aSy) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aSy.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.w.getItem(aSy, 0);
        if (mediaData2 != null && mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
            if (mediaData2.picWidth * 2 <= mediaData2.picHeight) {
                i = ((int) (i2 * 1.5f)) + dimensionPixelSize;
                i2 = (i2 * 2) + dimensionPixelSize;
            } else if (mediaData2.picHeight * 2 <= mediaData2.picWidth) {
                i = (i2 * 2) + dimensionPixelSize;
                i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
            } else if (mediaData2.picWidth < i2) {
                if (mediaData2.picHeight < i2) {
                    if (mediaData2.picWidth < mediaData2.picHeight) {
                        int i4 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                        i = i2;
                        i2 = i4;
                    } else {
                        i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                    }
                } else if (mediaData2.picHeight < i2 || mediaData2.picHeight >= i2 * 2) {
                    i2 = 0;
                    i = 0;
                } else {
                    int i5 = (mediaData2.picHeight * i2) / mediaData2.picWidth;
                    i = i2;
                    i2 = i5;
                }
            } else if (mediaData2.picWidth >= i2 && mediaData2.picWidth < i2 * 2) {
                if (mediaData2.picHeight < i2) {
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                    int i6 = mediaData2.picWidth;
                    i2 = mediaData2.picHeight;
                    i = i6;
                } else {
                    i2 = (i2 * 2) + dimensionPixelSize;
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                }
            } else if (mediaData2.picHeight < i2) {
                i2 = 0;
                i = 0;
            } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 2) {
                int i7 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i7) / mediaData2.picWidth;
                i = i7;
            } else if (mediaData2.picWidth < mediaData2.picHeight) {
                i2 = (i2 * 2) + dimensionPixelSize;
                i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
            } else {
                int i8 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i8) / mediaData2.picWidth;
                i = i8;
            }
        } else {
            i2 = (i2 * 2) + dimensionPixelSize;
            i = i2;
        }
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public boolean aUk() {
        return aUl() || aUm();
    }

    public boolean aQX() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aQY() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aUl() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aUm() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aQZ() {
        if (this.mBaijiahao == null) {
            return false;
        }
        switch (this.mBaijiahao.oriUgcType) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public boolean isBjh() {
        return aQZ();
    }

    public void kQ(int i) {
        this.dOD = i;
    }

    public int aUn() {
        return this.dOF;
    }

    public String aUo() {
        return this.dOE;
    }

    public void wa(String str) {
        this.dOE = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aUp() {
        if (aSr()) {
            return 4;
        }
        if (aTG() || aTI()) {
            return 3;
        }
        if (aQX()) {
            return 5;
        }
        if (aQY()) {
            return 6;
        }
        if (aUl()) {
            return 7;
        }
        if (aUm()) {
            return 8;
        }
        if (this.isShareThread && this.dNX != null) {
            return 9;
        }
        if (aTH()) {
            return 2;
        }
        return 1;
    }

    public int aUq() {
        if (aUm() || aUl()) {
            return 2;
        }
        if (aQX() || aQY()) {
            return 3;
        }
        return 1;
    }

    public int getTabId() {
        return this.mTabId;
    }

    public String getTabName() {
        return this.mTabName;
    }

    public String aUr() {
        return this.dOI;
    }

    public String getNid() {
        return this.mNid;
    }

    public boolean aUs() {
        return this.dMu != null && this.dMu.isNewGod();
    }

    public boolean aUt() {
        return (aSp() == null || aSp().getAlaUserData() == null || aSp().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item aUu() {
        return this.dOL;
    }

    public List<HeadItem> aUv() {
        return this.dOM;
    }

    public void a(Item item) {
        this.dOL = item;
    }

    public void aJ(List<HeadItem> list) {
        this.dOM = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData aUw() {
        return this.dON;
    }

    public void b(PollData pollData) {
        this.dON = pollData;
    }

    public List<PbLinkData> aUx() {
        return this.dOK;
    }

    public void aK(List<PbLinkData> list) {
        this.dOK = list;
    }
}

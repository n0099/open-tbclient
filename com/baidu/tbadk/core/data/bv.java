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
import com.baidu.tbadk.core.util.UtilHelper;
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
public class bv extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ag, com.baidu.tbadk.core.util.f.a {
    private String aZb;
    private String address;
    private String authorId;
    public int dPI;
    private SpannableString dPO;
    public int dSK;
    private int dSL;
    private int dSO;
    public int dSP;
    private String dSS;
    private String dST;
    private int dSV;
    private VideoInfo dSX;
    private VideoDesc dSY;
    private cc dSZ;
    private int dSn;
    private SpannableStringBuilder dSs;
    private SpannableStringBuilder dSt;
    private br dSu;
    private String dSv;
    private String dSw;
    private SkinInfo dTC;
    private boolean dTE;
    private String dTF;
    private boolean dTI;
    public String dTK;
    public int dTL;
    public int dTM;
    public String dTN;
    public String dTO;
    public long dTP;
    private List<ReportInfo> dTT;
    private boolean dTZ;
    private AlaInfoData dTa;
    private long dTb;
    private r dTj;
    private LiveCoverStatus dTp;
    private long dTq;
    public TwZhiBoUser dTx;
    public List<TwAnchorProfitItem> dTy;
    private String dUA;
    private String dUB;
    private String dUC;
    private String dUD;
    public String dUE;
    private boolean dUH;
    private boolean dUI;
    public boolean dUJ;
    public boolean dUK;
    public boolean dUL;
    public boolean dUM;
    public boolean dUN;
    public String dUO;
    private int dUP;
    private String dUQ;
    private int dUR;
    public String dUT;
    private String dUU;
    private ThreadInfo dUV;
    private Item dUX;
    private List<HeadItem> dUY;
    private long dUb;
    private al dUc;
    public e dUe;
    private MediaData dUf;
    public int dUg;
    public OriginalThreadInfo dUi;
    private TopicModule dUm;
    private String dUn;
    private String dUo;
    private VideoInfo dUp;
    private String dUq;
    private boolean dUs;
    public OriginalForumInfo dUt;
    public boolean dUu;
    private String dUv;
    private boolean dUw;
    private SmartApp dUx;
    private String dUz;
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
    public static final BdUniqueId dRw = BdUniqueId.gen();
    public static final BdUniqueId dRx = BdUniqueId.gen();
    public static final BdUniqueId dRy = BdUniqueId.gen();
    public static final BdUniqueId dRz = BdUniqueId.gen();
    public static final BdUniqueId dRA = BdUniqueId.gen();
    public static final BdUniqueId dRB = BdUniqueId.gen();
    public static final BdUniqueId dRC = BdUniqueId.gen();
    public static final BdUniqueId dRD = BdUniqueId.gen();
    public static final BdUniqueId dRE = BdUniqueId.gen();
    public static final BdUniqueId dRF = BdUniqueId.gen();
    public static final BdUniqueId dRG = BdUniqueId.gen();
    public static final BdUniqueId dRH = BdUniqueId.gen();
    public static final BdUniqueId dRI = BdUniqueId.gen();
    public static final BdUniqueId dRJ = BdUniqueId.gen();
    public static final BdUniqueId dRK = BdUniqueId.gen();
    public static final BdUniqueId dRL = BdUniqueId.gen();
    public static final BdUniqueId dRM = BdUniqueId.gen();
    public static final BdUniqueId dRN = BdUniqueId.gen();
    public static final BdUniqueId dRO = BdUniqueId.gen();
    public static final BdUniqueId dRP = BdUniqueId.gen();
    public static final BdUniqueId dRQ = BdUniqueId.gen();
    public static final BdUniqueId dRR = BdUniqueId.gen();
    public static final BdUniqueId dRS = BdUniqueId.gen();
    public static final BdUniqueId dRT = BdUniqueId.gen();
    public static final BdUniqueId dRU = BdUniqueId.gen();
    public static final BdUniqueId dRV = BdUniqueId.gen();
    public static final BdUniqueId dRW = BdUniqueId.gen();
    public static final BdUniqueId dRX = BdUniqueId.gen();
    public static final BdUniqueId dRY = BdUniqueId.gen();
    public static final BdUniqueId dRZ = BdUniqueId.gen();
    public static final BdUniqueId dSa = BdUniqueId.gen();
    public static final BdUniqueId dSb = BdUniqueId.gen();
    public static final BdUniqueId dSc = BdUniqueId.gen();
    public static final BdUniqueId dSd = BdUniqueId.gen();
    public static final BdUniqueId dSe = BdUniqueId.gen();
    public static final BdUniqueId dSf = BdUniqueId.gen();
    public static AtomicBoolean dSg = new AtomicBoolean(false);
    public static AtomicBoolean dSh = new AtomicBoolean(false);
    public static AtomicBoolean dSi = new AtomicBoolean(false);
    public static final BdUniqueId dSj = BdUniqueId.gen();
    private static HashMap<Point, Integer> dTk = new HashMap<>();
    private static HashMap<Integer, Integer> dTl = new HashMap<>();
    public static final BdUniqueId dTv = BdUniqueId.gen();
    public static final BdUniqueId dTD = BdUniqueId.gen();
    private static HashMap<Point, Integer> dTU = new HashMap<>();
    private static SparseArray<m.a> dTV = new SparseArray<>(3);
    public boolean dRe = false;
    public boolean dRf = false;
    public boolean dRg = false;
    public boolean dRh = false;
    public boolean dRi = false;
    public boolean dRj = false;
    public boolean dRk = false;
    public boolean dRl = false;
    private int dSk = 0;
    private String dSl = "1";
    public int dSm = 1;
    private String dSN = null;
    private int dOl = 0;
    public int dTc = 0;
    private String dTd = "";
    public boolean dTe = false;
    private String dTm = "";
    public boolean dTQ = true;
    public boolean dTW = false;
    public boolean dTX = false;
    private int dTY = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dPE = null;
    public boolean dUd = false;
    private int dUl = 0;
    private boolean dUr = false;
    private boolean dUy = false;
    public boolean dUF = false;
    public boolean dUG = false;
    public boolean forbidComment = false;
    public boolean dUS = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int dSx = 0;
    private int dSy = 0;
    private String last_time = null;
    private long dSz = 0;
    private int dSA = 0;
    private int dSB = 0;
    private int dSC = 0;
    private int dSD = 0;
    private bz dSE = new bz();
    private MetaData dSF = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> dSI = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> dSJ = new ArrayList<>();
    private int dSG = 0;
    private int dSH = 0;
    private String ad_url = null;
    private String dSo = null;
    private String from = null;
    private int dSM = 0;
    private PraiseData dSQ = new PraiseData();
    private AnchorInfoData dSR = new AnchorInfoData();
    private long time = 0;
    private int dSU = 0;
    private ArrayList<a> dTg = new ArrayList<>();
    private ch dTh = null;
    private f dTi = null;
    private int dTn = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> dSW = new ArrayList<>();
    private boolean isHeadLive = false;
    private String dTo = null;
    private int dTf = 0;
    private boolean dTr = false;
    private boolean dTs = false;
    private int dTt = 0;
    private boolean dTu = false;
    private int anchorLevel = 0;
    public int dTG = 0;
    public o dTH = new o();
    private List<PbContent> dSr = new ArrayList();
    private List<PbContent> dSp = new ArrayList();
    private List<PbContent> dSq = new ArrayList();
    private String category_name = null;
    private bt dTw = new bt();
    private ArrayList<com.baidu.tbadk.data.c> dTz = new ArrayList<>();
    private PushStatusData dTA = new PushStatusData();
    public boolean dTR = false;
    public int dTS = -1;
    private PostData dUa = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int dTJ = 0;
    public int dUh = 0;
    private String tieba_game_information_source = "";
    public String dUk = "";
    public String dUj = "";
    public String mUrl = "";
    public String dTB = "";
    PollData dUZ = new PollData();
    private List<PbLinkData> dUW = new ArrayList();

    static {
        dTk.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        dTk.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        dTk.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        dTk.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        dTk.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        dTk.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        dTk.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        dTk.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        dTU.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        dTU.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        dTU.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        dTU.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        dTU.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        dTU.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        dTU.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        dTU.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        dTl.put(1, Integer.valueOf(R.drawable.label_interview_no));
        dTl.put(2, Integer.valueOf(R.drawable.label_interview_live));
        dTl.put(3, Integer.valueOf(R.drawable.label_interview_off));
        dTV.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        dTV.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        dTV.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bv() {
        this.dSL = 0;
        this.dSV = 0;
        this.dTq = 0L;
        this.dUg = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.dTq = 0L;
        this.dSV = 0;
        this.dSL = 0;
        this.dUg = 0;
    }

    public String aVI() {
        return this.dUz;
    }

    public String aVJ() {
        return this.dUA;
    }

    public void wW(String str) {
        this.dUA = str;
    }

    public String aVK() {
        return this.dUB;
    }

    public SpannableStringBuilder aVL() {
        return this.dSt;
    }

    public SpannableString aVM() {
        return this.dPO;
    }

    public void a(SpannableString spannableString) {
        if (aWl() != null && !aTX() && !aTW()) {
            if (this.dSt != null) {
                this.dSt.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dPO);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dPO = new SpannableString(spannableStringBuilder);
        }
    }

    public void aVN() {
        if (com.baidu.tbadk.core.util.x.getCount(this.dUY) > 0) {
            if (this.dSt != null) {
                this.dSt.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bh(this.dUY));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dPO);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bh(this.dUY));
            this.dPO = new SpannableString(spannableStringBuilder);
        }
    }

    public String aVO() {
        return this.dUC;
    }

    public String aVP() {
        return this.dUD;
    }

    public boolean aVQ() {
        return this.dSL == 1;
    }

    public bt aVR() {
        return this.dTw;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void kX(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.dSV;
    }

    public void kY(int i) {
        this.dTt = i;
    }

    public int aVS() {
        return this.dTt;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aVT() {
        return this.dUp;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void cp(long j) {
        this.mCreateTime = j;
    }

    public long aVU() {
        return this.dTb;
    }

    public String aVV() {
        return this.dSS;
    }

    public PraiseData aVW() {
        return this.dSQ;
    }

    public void a(PraiseData praiseData) {
        this.dSQ = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aVX() {
        return this.aZb;
    }

    public void wX(String str) {
        this.aZb = str;
    }

    public String aVY() {
        return this.dSl;
    }

    public void wY(String str) {
        this.dSl = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void kZ(int i) {
        this.dSk = i;
    }

    public int aVZ() {
        return this.dSk;
    }

    public String aWa() {
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

    public List<PbContent> aWb() {
        return this.dSr;
    }

    public void aN(List<PbContent> list) {
        this.dSr = list;
    }

    public void aO(List<PbContent> list) {
        this.dSp = list;
    }

    public void aP(List<PbContent> list) {
        this.dSq = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void la(int i) {
        this.reply_num = i;
    }

    public int aWc() {
        return this.reply_num;
    }

    public int aWd() {
        return this.dSy;
    }

    public void lb(int i) {
        this.dSy = i;
    }

    public long aWe() {
        return this.dSz;
    }

    public void cq(long j) {
        this.dSz = j;
    }

    public int aWf() {
        return this.dSB;
    }

    public int aWg() {
        return this.dSA;
    }

    public void lc(int i) {
        this.dSA = i;
    }

    public int aWh() {
        return this.dSC;
    }

    public void ld(int i) {
        this.dSC = i;
    }

    public int aWi() {
        return this.dSD;
    }

    public List<PbContent> aWj() {
        return this.dSp;
    }

    public bz aWk() {
        return this.dSE;
    }

    public MetaData aWl() {
        return this.dSF;
    }

    public boolean aWm() {
        return this.is_god != 0;
    }

    public boolean aWn() {
        return this.is_god == 1;
    }

    public boolean aWo() {
        return (this.dSF == null || this.dSF.getGodUserData() == null || this.dSF.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.dSF = metaData;
    }

    public String aWp() {
        return this.forum_name;
    }

    public void wZ(String str) {
        this.forum_name = str;
    }

    public int aWq() {
        return this.dSH;
    }

    public String aWr() {
        return this.ad_url;
    }

    public int aWs() {
        return this.dSM;
    }

    public void le(int i) {
        this.dSM = i;
    }

    public String aWt() {
        return this.dSN;
    }

    public void xa(String str) {
        this.dSN = str;
    }

    public ArrayList<MediaData> aWu() {
        return this.dSI;
    }

    public ArrayList<a> aWv() {
        return this.dTg;
    }

    public void y(ArrayList<a> arrayList) {
        this.dTg = arrayList;
    }

    public ch aWw() {
        return this.dTh;
    }

    public f aWx() {
        return this.dTi;
    }

    public ArrayList<VoiceData.VoiceModel> aWy() {
        return this.dSJ;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aWz() {
        return this.dSn;
    }

    public void lf(int i) {
        this.dSn = i;
    }

    public String aWA() {
        return this.latitude;
    }

    public String aWB() {
        return this.dST;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aWC() {
        return this.dTd;
    }

    public VideoInfo aWD() {
        return this.dSX;
    }

    public void a(VideoInfo videoInfo) {
        this.dSX = videoInfo;
    }

    public VideoDesc aWE() {
        return this.dSY;
    }

    public void a(AlaInfoData alaInfoData) {
        this.dTa = alaInfoData;
    }

    public AlaInfoData aWF() {
        return this.dTa;
    }

    public PushStatusData aWG() {
        return this.dTA;
    }

    public SkinInfo aWH() {
        return this.dTC;
    }

    public long aWI() {
        return this.dTP;
    }

    public boolean aWJ() {
        return this.dTQ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aTO() {
        return this.dTO;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.setTid(aTN().getTid());
        aqVar.setFid(aTN().getFid());
        aqVar.setNid(aTN().getNid());
        aqVar.setFeedBackReasonMap(this.feedBackReasonMap);
        aqVar.dPE = this.dPE;
        aqVar.abTag = this.mRecomAbTag;
        aqVar.weight = this.mRecomWeight;
        aqVar.extra = this.mRecomExtra;
        aqVar.source = this.mRecomSource;
        aqVar.dPI = this.dPI;
        aqVar.cardType = aYk();
        return aqVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.dST = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.dSL = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.dTb = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.dSx = threadInfo.repost_num.intValue();
                this.dSy = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.dSz = threadInfo.last_time_int.intValue();
                this.dSA = threadInfo.is_top.intValue();
                this.dSB = threadInfo.is_membertop.intValue();
                this.dSC = threadInfo.is_good.intValue();
                this.dSD = threadInfo.is_livepost.intValue();
                this.dSE.a(threadInfo.topic);
                this.dSF.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.dSG = threadInfo.has_commented.intValue();
                this.dSH = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.dSX = threadInfo.video_info;
                this.dSY = threadInfo.video_segment;
                this.dTa = new AlaInfoData();
                this.dTa.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.dSM = threadInfo.collect_status.intValue();
                this.dSN = threadInfo.collect_mark_pid;
                this.dSO = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.dSP = threadInfo.thread_type.intValue();
                this.dSS = threadInfo.first_post_id + "";
                this.dTd = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.dSn = threadInfo.is_ntitle.intValue();
                this.dSU = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.dUb = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.dSV = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.dTI = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.dSp = threadInfo.rich_title;
                this.dSr = threadInfo.first_post_content;
                this.dSq = threadInfo.rich_abstract;
                this.dSK = threadInfo.is_godthread_recommend.intValue();
                if ((this.dSF == null || this.dSF.getUserId() == null || this.dSF.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dSF = metaData;
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
                this.dSo = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.dSI.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.dSX = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.dSZ = new cc();
                    this.dSZ.a(threadInfo.video_channel_info);
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
                        this.dSJ.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.dTg.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.dTh = new ch();
                    this.dTh.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.dTi = new f();
                    this.dTi.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.dTj = new r();
                    this.dTj.a(threadInfo.cartoon_info);
                }
                this.dSQ.setUserMap(this.userMap);
                this.dSQ.parserProtobuf(threadInfo.zan);
                this.dSR.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dSQ.setTitle(this.title);
                } else {
                    this.dSQ.setTitle(this.dSo);
                }
                this.dTm = threadInfo.livecover_src;
                this.dTn = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.dTf = threadInfo.post_num.intValue();
                this.dTq = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.nD(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.zb(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.dSW.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.dTo = noticeInfo.notice;
                    }
                    this.dTt = zhiBoInfoTW.copythread_remind.intValue();
                    this.dTr = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.dTs = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.dTm)) {
                        this.dTm = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.dTx = zhiBoInfoTW.user.tw_anchor_info;
                        this.dTy = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.dTp = threadInfo.twzhibo_info.livecover_status;
                    this.dTq = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.dTu = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.dTw.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.dTz.add(cVar2);
                    }
                }
                this.dTA.parserProtobuf(threadInfo.push_status);
                this.dTF = threadInfo.lego_card;
                this.dTC = threadInfo.skin_info;
                this.dTG = threadInfo.is_book_chapter.intValue();
                this.dTH.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.dTO = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.dTP = threadInfo.last_read_pid.longValue();
                this.dTQ = threadInfo.cheak_repeat.intValue() == 1;
                this.dTT = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.dUa.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.x.getCount(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    SparseArray<String> sparseArray2 = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                            sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                    this.dPE = sparseArray2;
                }
                this.dTZ = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.dUc = new al();
                    this.dUc.a(threadInfo.link_info);
                }
                this.dUd = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.dUe = new e();
                    this.dUe.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.dUf = new MediaData();
                    this.dUf.parserProtobuf(threadInfo.pic_info);
                }
                this.dTJ = threadInfo.is_called.intValue();
                this.dUg = threadInfo.middle_page_num.intValue();
                this.dUh = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.dUj = threadInfo.star_rank_icon.icon_pic_url;
                    this.dUk = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.dUi = new OriginalThreadInfo();
                    this.dUi.a(threadInfo.origin_thread_info);
                } else {
                    this.dUi = null;
                    this.isShareThread = false;
                }
                this.dUl = threadInfo.is_topic.intValue();
                this.dUn = threadInfo.topic_user_name;
                this.dUo = threadInfo.topic_h5_url;
                this.dUm = threadInfo.topic_module;
                this.dUq = threadInfo.presentation_style;
                this.dUt = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.dUv = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.dSu = new br();
                    this.dSu.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.dUx = threadInfo.swan_info;
                }
                this.dUE = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.dUF = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.dUQ = threadInfo.article_cover;
                this.dUR = threadInfo.bjh_content_tag.intValue();
                this.dUP = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dUS = threadInfo.is_s_card.intValue() == 1;
                this.dUT = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.dUU = threadInfo.wonderful_post_info;
                aWK();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.dUV = threadInfo;
                if (!com.baidu.tbadk.core.util.x.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        this.dUW.add(pbLinkData);
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.dUX = threadInfo.item;
                }
                if (this.dUX != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.dUX);
                }
                this.dUY = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.x.isEmpty(this.dUY)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.dUY);
                }
                if (threadInfo.poll_info != null) {
                    this.dUZ.parserProtobuf(threadInfo.poll_info);
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
                this.dTb = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.dSx = jSONObject.optInt("repost_num", 0);
                this.dSy = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.dSz = jSONObject.optLong("last_time_int", 0L);
                this.dSA = jSONObject.optInt("is_top", 0);
                this.dSB = jSONObject.optInt("is_membertop", 0);
                this.dSC = jSONObject.optInt("is_good", 0);
                this.dSD = jSONObject.optInt("is_livepost", 0);
                this.dSE.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.dSF.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.dSG = jSONObject.optInt("has_commented", 0);
                this.dSH = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.dSM = jSONObject.optInt("collect_status");
                this.dSN = jSONObject.optString("collect_mark_pid");
                this.dSO = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.dSP = jSONObject.optInt("thread_type");
                this.dUb = jSONObject.optLong("share_num");
                this.dSS = jSONObject.optString("first_post_id", "0");
                this.dTd = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.dSn = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.dTw.parserJson(optJSONObject2);
                }
                if ((this.dSF == null || this.dSF.getUserId() == null) && this.userMap != null) {
                    this.dSF = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.dTa = new AlaInfoData();
                this.dTa.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.dSo = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.dSI.add(mediaData);
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
                        this.dSJ.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.dTg.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.dTh = new ch();
                    this.dTh.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.dTi = new f();
                    this.dTi.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.dTj = new r();
                    this.dTj.parserJson(optJSONObject6);
                }
                this.dSQ.setUserMap(this.userMap);
                this.dSQ.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.dSR.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dSQ.setTitle(this.title);
                } else {
                    this.dSQ.setTitle(this.dSo);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.dTw.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.dTz.add(cVar);
                    }
                }
                this.dTG = jSONObject.optInt("is_book_chapter", 0);
                this.dTH.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.dTO = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.dTK = jSONObject.optString("recom_extra_img");
                this.dTN = jSONObject.optString("recom_extra_img_night");
                this.dTL = jSONObject.optInt("recom_extra_img_width", 0);
                this.dTM = jSONObject.optInt("recom_extra_img_height", 0);
                this.dTP = jSONObject.optLong("last_read_pid");
                this.dTQ = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.dSZ = new cc();
                    this.dSZ.cM(optJSONObject8);
                }
                this.dTZ = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.dUc = new al();
                    this.dUc.parserJson(optJSONObject9);
                }
                this.dUd = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.dUe = new e();
                    this.dUe.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.dUf = new MediaData();
                    this.dUf.parserJson(optJSONObject11);
                }
                this.dTJ = jSONObject.optInt("is_called", 0);
                this.dUg = jSONObject.optInt("middle_page_num", 0);
                this.dUh = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.dSX = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.dUi = new OriginalThreadInfo();
                        this.dUi.parserJson(optJSONObject13);
                    } else {
                        this.dUi = null;
                    }
                } else {
                    this.dUi = null;
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
                    this.dUx = builder2.build(false);
                }
                this.dUE = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.dUF = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.dUP = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.dUR = jSONObject.optInt("bjh_content_tag");
                this.dUQ = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dUS = jSONObject.optInt("is_s_card", 0) == 1;
                this.dUT = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.dUU = jSONObject.optString("wonderful_post_info");
                aWK();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    this.dUZ.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray6.getJSONObject(i6));
                        this.dUW.add(pbLinkData);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aWK() {
        aWL();
        aWN();
        aWQ();
        aWR();
        aWS();
        aWT();
        aWU();
    }

    private void aWL() {
        if (!StringUtils.isNull(this.dSF.getName_show())) {
            this.dUz = com.baidu.tbadk.core.util.as.cutChineseAndEnglishWithSuffix(this.dSF.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aWM() {
        if (this.dTa != null) {
            if (this.dTa.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cD = com.baidu.tbadk.core.util.as.cD(this.mCreateTime);
                if (!StringUtils.isNull(cD)) {
                    this.dUA = cD;
                }
            }
            if (this.dTa.openRecomFans == 1) {
                int i = 0;
                if (this.dTa != null && this.dTa.user_info != null) {
                    i = this.dTa.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.dUA) && i > 0) {
                    this.dUA += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.as.cG(i);
                } else if (i > 0) {
                    this.dUA = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.as.cG(i);
                }
            }
        }
    }

    private void aWN() {
        if (aUV() || (aYd() && getType() != dRT)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cB = com.baidu.tbadk.core.util.as.cB(j);
                if (com.baidu.tbadk.core.util.as.xS(cB)) {
                    cB = com.baidu.tbadk.core.util.as.getFormatTimeShort(j);
                }
                this.dUA = cB;
            }
            String str = "";
            if (this.dSF != null && this.dSF.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.dSF.getBaijiahaoInfo().auth_desc)) {
                str = this.dSF.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.dUA) && !TextUtils.isEmpty(str)) {
                this.dUA += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.dUA = str;
            } else if (!this.dUJ && this.dSF != null && this.dSF.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.as.cutChineseAndEnglishWithSuffix(this.dSF.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dUA)) {
                    this.dUA += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.dUA = cutChineseAndEnglishWithSuffix;
                }
            } else if (aYm()) {
                aWO();
            }
        } else if (getType() == dRT) {
            aWM();
        } else {
            long aWe = aWe() * 1000;
            if (aWe != 0) {
                String cB2 = com.baidu.tbadk.core.util.as.cB(aWe);
                if (com.baidu.tbadk.core.util.as.xS(cB2)) {
                    cB2 = com.baidu.tbadk.core.util.as.getFormatTimeShort(aWe);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (aTW()) {
                    cB2 = com.baidu.tbadk.core.util.as.cC(aWe);
                }
                this.dUA = string + cB2;
            } else {
                long j2 = this.mCreateTime;
                String cB3 = com.baidu.tbadk.core.util.as.cB(j2);
                if (com.baidu.tbadk.core.util.as.xS(cB3)) {
                    cB3 = com.baidu.tbadk.core.util.as.getFormatTimeShort(j2);
                }
                this.dUA = cB3;
            }
            if (!this.dUJ && this.dSF != null && this.dSF.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.as.cutChineseAndEnglishWithSuffix(this.dSF.getBazhuGradeData().getDesc(), this.dUI ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dUA)) {
                    this.dUA += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.dUA = cutChineseAndEnglishWithSuffix2;
                }
            } else if (aYm()) {
                aWO();
            }
            if (!TextUtils.isEmpty(this.dUA) && !TextUtils.isEmpty(getAddress())) {
                this.dUA += " • " + getAddress();
            }
        }
    }

    private void aWO() {
        if (aYm() && !TextUtils.isEmpty(this.dSF.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.dUA)) {
                this.dUA += "   " + this.dSF.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.dUA = this.dSF.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void aWP() {
        if (!aUV() && !aYd()) {
            long aWe = 1000 * aWe();
            if (aWe != 0) {
                String cB = com.baidu.tbadk.core.util.as.cB(aWe);
                if (com.baidu.tbadk.core.util.as.xS(cB)) {
                    cB = com.baidu.tbadk.core.util.as.getFormatTimeShort(aWe);
                }
                this.dUA = cB;
            }
            if (!this.dUJ && this.dSF != null && this.dSF.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.as.cutChineseAndEnglishWithSuffix(this.dSF.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.dUA)) {
                    this.dUA += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.dUA = cutChineseAndEnglishWithSuffix;
                }
            } else if (aYm()) {
                aWO();
            }
            if (!TextUtils.isEmpty(this.dUA) && !TextUtils.isEmpty(getAddress())) {
                this.dUA += " • " + getAddress();
            }
        }
    }

    private void aWQ() {
        if (aWF() == null || aWF().share_info == null || aWF().share_info.share_user_count <= 0 || !aXF() || (this.dUg > 0 && this.dUh == 0)) {
            this.dUB = null;
            return;
        }
        int i = aWF().share_info.share_user_count;
        if (i == 1) {
            this.dUB = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.dUB = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.as.numberUniform(i)});
        }
    }

    private void aWR() {
        this.dSt = aXi();
        com.baidu.tieba.card.m.a(this, this.dSt, true);
    }

    private void aWS() {
        this.dPO = aXg();
    }

    private void aWT() {
        this.dUC = com.baidu.tbadk.core.util.as.getFormatTimeShort(aWe() * 1000);
    }

    private void aWU() {
        this.dUD = com.baidu.tbadk.core.util.as.getFormatTimeShort(aWe());
    }

    public SpannableStringBuilder aWV() {
        return this.dSs;
    }

    public boolean isTop() {
        return aWg() != 0;
    }

    public int aWW() {
        if (this.dTw != null) {
            long aVD = this.dTw.aVD();
            long aVE = this.dTw.aVE();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aVD) {
                return 1;
            }
            if (currentTimeMillis > aVE) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aWX() {
        if (aWZ() && this.dTg.size() >= 1) {
            a aVar = this.dTg.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aUa = aVar.aUa();
            int aUb = aVar.aUb();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aUa) {
                return 4;
            }
            return currentTimeMillis > aUb ? 2 : 1;
        }
        return -1;
    }

    public int aWY() {
        if (!aWZ() || this.dTg.size() < 1 || this.dTg.get(0) == null) {
            return -1;
        }
        return this.dTg.get(0).aTZ();
    }

    public boolean aWZ() {
        return this.dSU == 1;
    }

    public String getActUrl() {
        return (!aWZ() || this.dTg.size() < 1 || this.dTg.get(0) == null) ? "" : this.dTg.get(0).getUrl();
    }

    private com.baidu.adp.widget.b xb(String str) {
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

    public SmartApp aXa() {
        return this.dUx;
    }

    private void v(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aXc()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (aWg() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (aWg() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (aWi() == 1 || this.dSE.aYy() != 0) {
                if (aVR() != null && getThreadType() == 41) {
                    if (aWW() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && aXt()) {
                Integer num = dTl.get(Integer.valueOf(aWW()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aWh() == 1 && !isTop() && dRS != getType() && dSa != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.dSR != null && this.dSR.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (aWq() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = dTk.get(new Point(aWY(), aWX()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aWw() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (aWx() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = xb(this.category_name);
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
                Bitmap bitmap = com.baidu.tbadk.core.util.ao.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.dSm));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aXd = aXd();
        if (aXd != null) {
            spannableStringBuilder.append((CharSequence) aXd);
        }
        this.dSs = spannableStringBuilder;
    }

    public boolean aXb() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = com.baidu.tbadk.core.util.ao.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aWl() != null) {
            if (aWl().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aWl().getGender() == 2) {
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

    private boolean aXc() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void w(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.x.getCount(b(z, z2, z3, false)) > 0) {
            x(z, z3);
            return;
        }
        SpannableStringBuilder aXd = aXd();
        if (z) {
            spannableStringBuilder = a(aXd.toString(), aXd, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aXd);
        }
        this.dSs = spannableStringBuilder;
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
            if (this.dSn == 1) {
                this.dSs = a;
                return a;
            }
        } else if (this.dSn == 1) {
            this.dSs = new SpannableStringBuilder();
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

    public void de(String str, String str2) {
        this.mUrl = str;
        this.dTB = str2;
    }

    public SpannableStringBuilder aXd() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dSp, this.title);
    }

    public SpannableStringBuilder aXe() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dSq, this.dSo);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aXf() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.dUS) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aXg() {
        SpannableStringBuilder aXe = aXe();
        com.baidu.tieba.card.m.a(this, aXe, false);
        return new SpannableString(aXe);
    }

    public SpannableString aXh() {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.dSr)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.dSr, this.dSo));
    }

    public String getAbstract() {
        return this.dSo;
    }

    public void xc(String str) {
        this.dSo = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aXd;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.dSn == 1) {
            aXd = aXe();
            spannableStringBuilder = aXd.toString();
        } else {
            aXd = aXd();
            spannableStringBuilder = aXd.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aXd, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aXd);
        }
        this.dSs = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder x(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder y(boolean z, boolean z2) {
        SpannableStringBuilder aXe;
        if (!StringUtils.isNull(this.title) && this.dSn != 1) {
            aXe = aXd();
        } else {
            aXe = aXe();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aXe);
        this.dSs = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aXi() {
        if (StringUtils.isNull(this.title) || this.dSn == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aXd());
        this.dSs = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aUQ() {
        if (this.dSp != null && this.dSp.size() > 0) {
            int size = this.dSp.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.dSp.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aUR() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Al(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aXj() {
        v(false, false);
    }

    public void aXk() {
        v(false, true);
    }

    public AnchorInfoData aXl() {
        return this.dSR;
    }

    public boolean aXm() {
        return this.threadType == 36;
    }

    public boolean aUR() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aXn() {
        return this.threadType == 11 || this.dSO == 1;
    }

    public boolean aXo() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aWu = aWu();
        if (aWu == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aWu.size() || i2 >= 3) {
                break;
            }
            if (aWu.get(i2) != null && aWu.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aWu.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aWu.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aWu.get(i2).getPicUrl();
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
        if (this.dSX != null && !StringUtils.isNull(this.dSX.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.dSX.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.dSF != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.dSF.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aXp() {
        String userId;
        return this.dSF == null || (userId = this.dSF.getUserId()) == null || userId.equals("0");
    }

    public boolean aXq() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (aYa()) {
            if (aWD() != null) {
                return dRS;
            }
            return dRx;
        }
        int aWg = aWg();
        if (this.dUl == 1) {
            if (this.dUm != null) {
                return dRJ;
            }
            return this.dUp != null ? dSc : dSb;
        } else if (this.dTa != null && this.threadType == 60) {
            return dRV;
        } else {
            if (this.dTa != null && this.threadType == 49) {
                return dRT;
            }
            if (this.threadType == 51) {
                return dRU;
            }
            if (this.threadType == 63) {
                return dSd;
            }
            if (this.threadType == 64) {
                return dSe;
            }
            if (aWg == 2 || aWg == 1) {
                return dRw;
            }
            if (this.dSX != null && aXy() && !aXq()) {
                return dSj;
            }
            if (this.dSX != null && !aXq()) {
                if (aWo()) {
                    return dSa;
                }
                return dRS;
            } else if (this.isShareThread && this.dUi != null) {
                if (this.dUi.dPP) {
                    if (this.dUi.videoInfo != null) {
                        return dRZ;
                    }
                    if (this.dUi.aUT()) {
                        return dRY;
                    }
                    return dRX;
                }
                return dRW;
            } else if (aUT()) {
                return dRK;
            } else {
                if (aXs()) {
                    return dSg.get() ? dTv : dRx;
                } else if (aWZ() && aWY() == 1) {
                    return dSg.get() ? dTD : dRx;
                } else if (isLinkThread()) {
                    return dRQ;
                } else {
                    if (aWo()) {
                        return dRR;
                    }
                    if (this.dRe) {
                        return dRB;
                    }
                    if (this.dRf) {
                        return dRC;
                    }
                    if (this.dRg) {
                        return dRD;
                    }
                    if (this.dRh) {
                        return dRE;
                    }
                    if (this.dRi) {
                        return dRF;
                    }
                    if (this.dRk) {
                        return dRH;
                    }
                    if (this.dRl) {
                        return dRI;
                    }
                    if (this.dRj) {
                        return dRG;
                    }
                    if (this.dTe) {
                        int aXr = aXr();
                        if (aXr == 1) {
                            return dRy;
                        }
                        if (aXr == 2) {
                            return dRz;
                        }
                        if (aXr > 2) {
                            return dRA;
                        }
                        return dRx;
                    }
                    return dRx;
                }
            }
        }
    }

    public int aXr() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.aTv().isShowImages() || com.baidu.tbadk.core.util.x.getCount(aWu()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aWu().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(aWu(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aXs() {
        return aVR() != null && getThreadType() == 41 && aWi() == 1 && aWW() == 2;
    }

    public void z(ArrayList<s> arrayList) {
        if (this.dSn == 1) {
            this.dOl = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dOl = 0;
        } else {
            this.dOl = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.aUn() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aUn().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dOl = next.aUo();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aXt() {
        return this.threadType == 41;
    }

    public boolean aXu() {
        return this.dTE;
    }

    public void hB(boolean z) {
        this.dTE = z;
    }

    public String aXv() {
        return this.dTF;
    }

    public r aXw() {
        return this.dTj;
    }

    public void aXx() {
        if (this.dTc == 0) {
            this.dTc = 1;
        }
    }

    public void hC(boolean z) {
        this.dTR = z;
    }

    public boolean aXy() {
        return this.dTR;
    }

    public void lg(int i) {
        this.dTS = i + 1;
    }

    public int aXz() {
        return this.dTS;
    }

    public boolean aXA() {
        return this.dUH;
    }

    public void hD(boolean z) {
        this.dUH = z;
    }

    public cc aXB() {
        return this.dSZ;
    }

    public boolean aXC() {
        return getThreadType() == 49;
    }

    public boolean aXD() {
        return getThreadType() == 40;
    }

    public boolean aXE() {
        return getThreadType() == 50;
    }

    public boolean aXF() {
        return getThreadType() == 60;
    }

    public int aXG() {
        return this.dTY;
    }

    public void setSmartFrsPosition(int i) {
        this.dTY = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aXH() {
        return this.mRecomSource;
    }

    public boolean aXI() {
        return this.dTZ;
    }

    public long aXJ() {
        return this.agreeData.agreeNum;
    }

    public long aXK() {
        return this.agreeData.disAgreeNum;
    }

    public int aXL() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aXM() {
        return this.agreeData.agreeType;
    }

    public void lh(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void li(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cr(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cs(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void lj(int i) {
        this.agreeData.agreeType = i;
    }

    public long aXN() {
        return this.dUb;
    }

    public void ct(long j) {
        this.dUb = j;
    }

    public PostData aXO() {
        return this.dUa;
    }

    public al aXP() {
        return this.dUc;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean aWm = aWm();
        if (z2) {
            if (z) {
                if (aWm && !aUR()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (aWi() == 1 || getThreadType() == 33 || (aWk() != null && aWk().aYy() != 0)) {
                    if (aVR() != null && aXt()) {
                        if (aWW() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!aWm) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (aXt()) {
                    arrayList.add(dTV.get(aWW()));
                }
                if (aWZ()) {
                    Integer num = dTU.get(new Point(aWY(), aWX()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (aWw() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.as.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (aWm && aWg() != 1 && !aUR()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((aWi() == 1 || getThreadType() == 33) && !aXt() && !aWm) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (aWh() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (aWg() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (aXt() && aVR() != null && aWW() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (aWZ()) {
                    Integer num2 = dTU.get(new Point(aWY(), aWX()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.dTG == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (aWx() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aWw() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.as.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && aXC()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && aXE()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (aXD()) {
                    arrayList.add(new m.a(R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void A(ArrayList<MediaData> arrayList) {
        this.dSI = arrayList;
    }

    public void B(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.dSJ = arrayList;
    }

    public String aXQ() {
        return this.dUn;
    }

    public void xd(String str) {
        this.dUn = str;
    }

    public void aXR() {
        this.dUl = 1;
    }

    public boolean aXS() {
        return this.dUl == 1;
    }

    public String aXT() {
        return this.dSv;
    }

    public void xe(String str) {
        this.dSv = str;
    }

    public String aXU() {
        return this.dSw;
    }

    public void xf(String str) {
        this.dSw = str;
    }

    public String aXV() {
        return this.dUo;
    }

    public void xg(String str) {
        this.dUo = str;
    }

    public boolean aXW() {
        return this.dUr;
    }

    public void hE(boolean z) {
        this.dUr = z;
    }

    public boolean aXX() {
        return this.dUs;
    }

    public void hF(boolean z) {
        this.dUs = z;
    }

    public void b(VideoInfo videoInfo) {
        this.dUp = videoInfo;
    }

    public boolean aXY() {
        return this.dUt != null;
    }

    public br aXZ() {
        return this.dSu;
    }

    public boolean aYa() {
        return this.dUw;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dSX != null) {
            return this.dSX.video_url;
        }
        return null;
    }

    public boolean aYb() {
        return this.dUy;
    }

    public void hG(boolean z) {
        this.dUy = z;
    }

    public AgreeData aYc() {
        return this.agreeData;
    }

    public boolean aYd() {
        return this.dUK;
    }

    public void hH(boolean z) {
        this.dUK = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean aTV() {
        return this.dUI;
    }

    public void hI(boolean z) {
        this.dUI = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aYe() {
        return this.dUm;
    }

    public String getShareImageUrl() {
        return this.dUE;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aWu = aWu();
        if (com.baidu.tbadk.core.k.aTv().isShowImages() && com.baidu.tbadk.core.util.x.getCount(aWu) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aWu.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(aWu, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.x.getItem(aWu, 0);
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
        com.baidu.tbadk.a.b.a.a(this, iArr);
        return iArr;
    }

    public boolean aYf() {
        return aYg() || aYh();
    }

    public boolean aUT() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aUU() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aYg() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aYh() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aUV() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return aUV();
    }

    public void lk(int i) {
        this.dUP = i;
    }

    public int aYi() {
        return this.dUR;
    }

    public String aYj() {
        return this.dUQ;
    }

    public void xh(String str) {
        this.dUQ = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aYk() {
        if (aWn()) {
            return 4;
        }
        if (aXC() || aXE()) {
            return 3;
        }
        if (aUT()) {
            return 5;
        }
        if (aUU()) {
            return 6;
        }
        if (aYg()) {
            return 7;
        }
        if (aYh()) {
            return 8;
        }
        if (this.isShareThread && this.dUi != null) {
            return 9;
        }
        if (aXD()) {
            return 2;
        }
        return 1;
    }

    public int aYl() {
        if (aYh() || aYg()) {
            return 2;
        }
        if (aUT() || aUU()) {
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

    public String getNid() {
        return this.mNid;
    }

    public boolean aYm() {
        return this.dSF != null && this.dSF.isNewGod();
    }

    public boolean aYn() {
        return (aWl() == null || aWl().getAlaUserData() == null || aWl().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item aYo() {
        return this.dUX;
    }

    public List<HeadItem> aYp() {
        return this.dUY;
    }

    public void a(Item item) {
        this.dUX = item;
    }

    public void aQ(List<HeadItem> list) {
        this.dUY = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData aYq() {
        return this.dUZ;
    }

    public void b(PollData pollData) {
        this.dUZ = pollData;
    }

    public List<PbLinkData> aYr() {
        return this.dUW;
    }

    public void aR(List<PbLinkData> list) {
        this.dUW = list;
    }
}

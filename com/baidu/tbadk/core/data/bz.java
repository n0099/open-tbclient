package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.Headers;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
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
import tbclient.PbGoodsInfo;
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
public class bz extends a implements com.baidu.adp.widget.ListView.n, com.baidu.tbadk.core.util.ag, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String authorId;
    private String brl;
    public String buttonText;
    public int eKn;
    public int eMg;
    private SpannableString eMm;
    private int eOV;
    private String ePA;
    private String ePB;
    private int ePD;
    private VideoInfo ePF;
    private VideoDesc ePG;
    private cg ePH;
    private AlaInfoData ePI;
    private long ePJ;
    private s ePR;
    private LiveCoverStatus ePX;
    private long ePY;
    private SpannableStringBuilder ePa;
    private SpannableStringBuilder ePb;
    private bv ePc;
    private String ePd;
    private String ePe;
    public int ePs;
    private int ePt;
    private int ePw;
    public int ePx;
    private List<ReportInfo> eQB;
    private boolean eQH;
    private long eQJ;
    private ao eQK;
    public f eQM;
    private MediaData eQN;
    public int eQO;
    public OriginalThreadInfo eQQ;
    private TopicModule eQU;
    private String eQV;
    private String eQW;
    private VideoInfo eQX;
    private String eQY;
    public TwZhiBoUser eQf;
    public List<TwAnchorProfitItem> eQg;
    private SkinInfo eQk;
    private boolean eQm;
    private String eQn;
    private boolean eQq;
    public String eQs;
    public int eQt;
    public int eQu;
    public String eQv;
    public String eQw;
    public long eQx;
    private int eRA;
    public String eRC;
    private String eRD;
    private ThreadInfo eRE;
    private boolean eRH;
    private Item eRI;
    private List<HeadItem> eRJ;
    PollData eRK;
    public int eRM;
    public String eRN;
    public boolean eRO;
    public String eRP;
    public String eRQ;
    public String eRR;
    public com.baidu.tieba.tbadkCore.data.n eRU;
    private boolean eRa;
    public OriginalForumInfo eRb;
    public boolean eRc;
    private String eRd;
    private boolean eRe;
    private SmartApp eRf;
    private String eRh;
    private String eRi;
    private String eRj;
    private String eRk;
    private String eRl;
    public String eRm;
    private String eRn;
    private boolean eRq;
    private boolean eRr;
    public boolean eRs;
    public boolean eRt;
    public boolean eRu;
    public boolean eRv;
    public boolean eRw;
    public boolean eRx;
    public String eRy;
    private String eRz;
    private int isBjh;
    private boolean isLinkThread;
    public boolean isLocal;
    public boolean isPrivacy;
    public boolean isShareThread;
    public ItemData itemData;
    public ItemStarData itemStarData;
    private String latitude;
    private BaijiahaoData mBaijiahao;
    private long mCreateTime;
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
    public static final BdUniqueId eNZ = BdUniqueId.gen();
    public static final BdUniqueId eOa = BdUniqueId.gen();
    public static final BdUniqueId eOb = BdUniqueId.gen();
    public static final BdUniqueId eOc = BdUniqueId.gen();
    public static final BdUniqueId eOd = BdUniqueId.gen();
    public static final BdUniqueId eOe = BdUniqueId.gen();
    public static final BdUniqueId eOf = BdUniqueId.gen();
    public static final BdUniqueId eOg = BdUniqueId.gen();
    public static final BdUniqueId eOh = BdUniqueId.gen();
    public static final BdUniqueId eOi = BdUniqueId.gen();
    public static final BdUniqueId eOj = BdUniqueId.gen();
    public static final BdUniqueId eOk = BdUniqueId.gen();
    public static final BdUniqueId eOl = BdUniqueId.gen();
    public static final BdUniqueId eOm = BdUniqueId.gen();
    public static final BdUniqueId eOn = BdUniqueId.gen();
    public static final BdUniqueId eOo = BdUniqueId.gen();
    public static final BdUniqueId eOp = BdUniqueId.gen();
    public static final BdUniqueId eOq = BdUniqueId.gen();
    public static final BdUniqueId eOr = BdUniqueId.gen();
    public static final BdUniqueId eOs = BdUniqueId.gen();
    public static final BdUniqueId eOt = BdUniqueId.gen();
    public static final BdUniqueId eOu = BdUniqueId.gen();
    public static final BdUniqueId eOw = BdUniqueId.gen();
    public static final BdUniqueId eOx = BdUniqueId.gen();
    public static final BdUniqueId eOy = BdUniqueId.gen();
    public static final BdUniqueId eOz = BdUniqueId.gen();
    public static final BdUniqueId eOA = BdUniqueId.gen();
    public static final BdUniqueId eOB = BdUniqueId.gen();
    public static final BdUniqueId eOC = BdUniqueId.gen();
    public static final BdUniqueId eOD = BdUniqueId.gen();
    public static final BdUniqueId eOE = BdUniqueId.gen();
    public static final BdUniqueId eOF = BdUniqueId.gen();
    public static final BdUniqueId eOG = BdUniqueId.gen();
    public static final BdUniqueId eOH = BdUniqueId.gen();
    public static final BdUniqueId eOI = BdUniqueId.gen();
    public static final BdUniqueId eOJ = BdUniqueId.gen();
    public static final BdUniqueId eOK = BdUniqueId.gen();
    public static final BdUniqueId eOL = BdUniqueId.gen();
    public static final BdUniqueId eOM = BdUniqueId.gen();
    public static AtomicBoolean eON = new AtomicBoolean(false);
    public static AtomicBoolean eOO = new AtomicBoolean(false);
    public static AtomicBoolean eOP = new AtomicBoolean(false);
    public static final BdUniqueId eOQ = BdUniqueId.gen();
    public static final BdUniqueId eOR = BdUniqueId.gen();
    private static HashMap<Point, Integer> ePS = new HashMap<>();
    private static HashMap<Integer, Integer> ePT = new HashMap<>();
    public static final BdUniqueId eQd = BdUniqueId.gen();
    public static final BdUniqueId eQl = BdUniqueId.gen();
    private static HashMap<Point, Integer> eQC = new HashMap<>();
    private static SparseArray<m.a> eQD = new SparseArray<>(3);
    public boolean eNF = false;
    public boolean eNG = false;
    public boolean eNH = false;
    public boolean eNI = false;
    public boolean eNJ = false;
    public boolean eNK = false;
    public boolean eNL = false;
    public boolean eNM = false;
    public boolean eOv = false;
    private int eOS = 0;
    private String eOT = "1";
    public int eOU = 1;
    private String ePv = null;
    private int eKy = 0;
    public int ePK = 0;
    private String ePL = "";
    public boolean ePM = false;
    private String ePU = "";
    public boolean eQy = true;
    public boolean eQE = false;
    public boolean eQF = false;
    private int eQG = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eMc = null;
    public boolean eQL = false;
    private int eQT = 0;
    private boolean eQZ = false;
    private boolean eRg = false;
    public boolean eRo = false;
    public boolean eRp = false;
    public boolean forbidComment = false;
    public boolean eRB = false;
    public boolean eRS = false;
    public boolean eRT = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int ePf = 0;
    private int ePg = 0;
    private String last_time = null;
    private long ePh = 0;
    private int ePi = 0;
    private int ePj = 0;
    private int ePk = 0;
    private int ePl = 0;
    private cd ePm = new cd();
    private MetaData ePn = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> ePq = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> ePr = new ArrayList<>();
    private int ePo = 0;
    private int ePp = 0;
    private String ad_url = null;
    private String eOW = null;
    private String from = null;
    private int ePu = 0;
    private PraiseData ePy = new PraiseData();
    private AnchorInfoData ePz = new AnchorInfoData();
    private long time = 0;
    private int ePC = 0;
    private ArrayList<b> ePO = new ArrayList<>();
    private cl ePP = null;
    private g ePQ = null;
    private int ePV = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> ePE = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ePW = null;
    private int ePN = 0;
    private boolean ePZ = false;
    private boolean eQa = false;
    private int eQb = 0;
    private boolean eQc = false;
    private int anchorLevel = 0;
    public int eQo = 0;
    public p eQp = new p();
    private List<PbContent> eOZ = new ArrayList();
    private List<PbContent> eOX = new ArrayList();
    private List<PbContent> eOY = new ArrayList();
    private String category_name = null;
    private bx eQe = new bx();
    private ArrayList<com.baidu.tbadk.data.c> eQh = new ArrayList<>();
    private PushStatusData eQi = new PushStatusData();
    public boolean eQz = false;
    public int eQA = -1;
    private PostData eQI = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eQr = 0;
    public int eQP = 0;
    private String tieba_game_information_source = "";
    public String eQS = "";
    public String eQR = "";
    private String mUrl = "";
    private String eQj = "";
    private List<PbLinkData> eRF = new ArrayList();
    private List<PbGoodsData> eRG = new ArrayList();
    public int eRL = -1;

    static {
        ePS.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        ePS.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        ePS.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        ePS.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        ePS.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        ePS.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        ePS.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        ePS.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eQC.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eQC.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eQC.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eQC.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eQC.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eQC.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eQC.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eQC.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        ePT.put(1, Integer.valueOf(R.drawable.label_interview_no));
        ePT.put(2, Integer.valueOf(R.drawable.label_interview_live));
        ePT.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eQD.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eQD.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eQD.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public bz() {
        this.ePt = 0;
        this.ePD = 0;
        this.ePY = 0L;
        this.eQO = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ePY = 0L;
        this.ePD = 0;
        this.ePt = 0;
        this.eQO = 0;
    }

    public String bmU() {
        return this.eRh;
    }

    public String bmV() {
        return this.eRi;
    }

    public void zO(String str) {
        this.eRi = str;
    }

    public String bmW() {
        return this.eRj;
    }

    public SpannableStringBuilder bmX() {
        return this.ePb;
    }

    public SpannableString bmY() {
        return this.eMm;
    }

    public void a(SpannableString spannableString) {
        if (bnx() != null && !ble() && !bld()) {
            if (this.ePb != null) {
                this.ePb.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eMm);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eMm = new SpannableString(spannableStringBuilder);
        }
    }

    public void bmZ() {
        if (com.baidu.tbadk.core.util.x.getCount(this.eRJ) > 0) {
            if (this.ePb != null) {
                this.ePb.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bQ(this.eRJ));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eMm);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bQ(this.eRJ));
            this.eMm = new SpannableString(spannableStringBuilder);
        }
    }

    public String bna() {
        return this.eRk;
    }

    public String bnb() {
        return this.eRl;
    }

    public boolean bnc() {
        return this.ePt == 1;
    }

    public bx bnd() {
        return this.eQe;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void ne(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.ePD;
    }

    public void nf(int i) {
        this.eQb = i;
    }

    public int bne() {
        return this.eQb;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bnf() {
        return this.eQX;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dF(long j) {
        this.mCreateTime = j;
    }

    public long bng() {
        return this.ePJ;
    }

    public String bnh() {
        return this.ePA;
    }

    public PraiseData bni() {
        return this.ePy;
    }

    public void a(PraiseData praiseData) {
        this.ePy = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bnj() {
        return this.brl;
    }

    public void zP(String str) {
        this.brl = str;
    }

    public String bnk() {
        return this.eOT;
    }

    public void zQ(String str) {
        this.eOT = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void ng(int i) {
        this.eOS = i;
    }

    public int bnl() {
        return this.eOS;
    }

    public String bnm() {
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

    public List<PbContent> bnn() {
        return this.eOZ;
    }

    public void bv(List<PbContent> list) {
        this.eOZ = list;
    }

    public void bw(List<PbContent> list) {
        this.eOX = list;
    }

    public void bx(List<PbContent> list) {
        this.eOY = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nh(int i) {
        this.reply_num = i;
    }

    public int bno() {
        return this.reply_num;
    }

    public int bnp() {
        return this.ePg;
    }

    public void ni(int i) {
        this.ePg = i;
    }

    public long bnq() {
        return this.ePh;
    }

    public void dG(long j) {
        this.ePh = j;
    }

    public int bnr() {
        return this.ePj;
    }

    public int bns() {
        return this.ePi;
    }

    public void nj(int i) {
        this.ePi = i;
    }

    public int bnt() {
        return this.ePk;
    }

    public void nk(int i) {
        this.ePk = i;
    }

    public int bnu() {
        return this.ePl;
    }

    public List<PbContent> bnv() {
        return this.eOX;
    }

    public cd bnw() {
        return this.ePm;
    }

    public MetaData bnx() {
        return this.ePn;
    }

    public boolean bny() {
        return this.is_god != 0;
    }

    public boolean bnz() {
        return this.is_god == 1;
    }

    public boolean bnA() {
        return (this.ePn == null || this.ePn.getGodUserData() == null || this.ePn.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.ePn = metaData;
    }

    public String bnB() {
        return this.forum_name;
    }

    public void zR(String str) {
        this.forum_name = str;
    }

    public int bnC() {
        return this.ePp;
    }

    public String bnD() {
        return this.ad_url;
    }

    public int bnE() {
        return this.ePu;
    }

    public void nl(int i) {
        this.ePu = i;
    }

    public String bnF() {
        return this.ePv;
    }

    public void zS(String str) {
        this.ePv = str;
    }

    public ArrayList<MediaData> bnG() {
        return this.ePq;
    }

    public ArrayList<b> bnH() {
        return this.ePO;
    }

    public void z(ArrayList<b> arrayList) {
        this.ePO = arrayList;
    }

    public cl bnI() {
        return this.ePP;
    }

    public g bnJ() {
        return this.ePQ;
    }

    public ArrayList<VoiceData.VoiceModel> bnK() {
        return this.ePr;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bnL() {
        return this.eOV;
    }

    public void nm(int i) {
        this.eOV = i;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String bnM() {
        return this.ePB;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bnN() {
        return this.ePL;
    }

    public VideoInfo bnO() {
        return this.ePF;
    }

    public void a(VideoInfo videoInfo) {
        this.ePF = videoInfo;
    }

    public VideoDesc bnP() {
        return this.ePG;
    }

    public void a(AlaInfoData alaInfoData) {
        this.ePI = alaInfoData;
    }

    public AlaInfoData bnQ() {
        return this.ePI;
    }

    public PushStatusData bnR() {
        return this.eQi;
    }

    public SkinInfo bnS() {
        return this.eQk;
    }

    public long bnT() {
        return this.eQx;
    }

    public boolean bnU() {
        return this.eQy;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bkW() {
        return this.eQw;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bkV().getTid());
        atVar.setFid(bkV().getFid());
        atVar.setNid(bkV().blV());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.eMc = this.eMc;
        atVar.abTag = this.mRecomAbTag;
        atVar.weight = this.mRecomWeight;
        atVar.extra = this.mRecomExtra;
        atVar.source = this.mRecomSource;
        atVar.eMg = this.eMg;
        atVar.cardType = bpz();
        return atVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ePB = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ePt = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ePJ = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.ePf = threadInfo.repost_num.intValue();
                this.ePg = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.ePh = threadInfo.last_time_int.intValue();
                this.ePi = threadInfo.is_top.intValue();
                this.ePj = threadInfo.is_membertop.intValue();
                this.ePk = threadInfo.is_good.intValue();
                this.ePl = threadInfo.is_livepost.intValue();
                this.ePm.a(threadInfo.topic);
                this.ePn.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.ePo = threadInfo.has_commented.intValue();
                this.ePp = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ePF = threadInfo.video_info;
                this.ePG = threadInfo.video_segment;
                this.ePI = new AlaInfoData();
                this.ePI.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.ePu = threadInfo.collect_status.intValue();
                this.ePv = threadInfo.collect_mark_pid;
                this.ePw = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ePx = threadInfo.thread_type.intValue();
                this.ePA = threadInfo.first_post_id + "";
                this.ePL = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eOV = threadInfo.is_ntitle.intValue();
                this.ePC = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eQJ = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.ePD = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eQq = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eOX = threadInfo.rich_title;
                this.eOZ = threadInfo.first_post_content;
                this.eOY = threadInfo.rich_abstract;
                this.ePs = threadInfo.is_godthread_recommend.intValue();
                if ((this.ePn == null || this.ePn.getUserId() == null || this.ePn.getUserId().equals("0") || this.eRT) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ePn = metaData;
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
                this.eOW = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.ePq.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ePF = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ePH = new cg();
                    this.ePH.a(threadInfo.video_channel_info);
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
                        this.ePr.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.ePO.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ePP = new cl();
                    this.ePP.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ePQ = new g();
                    this.ePQ.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ePR = new s();
                    this.ePR.a(threadInfo.cartoon_info);
                }
                this.ePy.setUserMap(this.userMap);
                this.ePy.parserProtobuf(threadInfo.zan);
                this.ePz.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ePy.setTitle(this.title);
                } else {
                    this.ePy.setTitle(this.eOW);
                }
                this.ePU = threadInfo.livecover_src;
                this.ePV = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ePN = threadInfo.post_num.intValue();
                this.ePY = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qz(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Ca(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ePE.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ePW = noticeInfo.notice;
                    }
                    this.eQb = zhiBoInfoTW.copythread_remind.intValue();
                    this.ePZ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eQa = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ePU)) {
                        this.ePU = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eQf = zhiBoInfoTW.user.tw_anchor_info;
                        this.eQg = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ePX = threadInfo.twzhibo_info.livecover_status;
                    this.ePY = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eQc = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eQe.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eQh.add(cVar2);
                    }
                }
                this.eQi.parserProtobuf(threadInfo.push_status);
                this.eQn = threadInfo.lego_card;
                this.eQk = threadInfo.skin_info;
                this.eQo = threadInfo.is_book_chapter.intValue();
                this.eQp.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eQw = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eQx = threadInfo.last_read_pid.longValue();
                this.eQy = threadInfo.cheak_repeat.intValue() == 1;
                this.eQB = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eQI.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.eMc = sparseArray2;
                }
                this.eQH = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eQK = new ao();
                    this.eQK.a(threadInfo.link_info);
                }
                this.eQL = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eQM = new f();
                    this.eQM.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eQN = new MediaData();
                    this.eQN.parserProtobuf(threadInfo.pic_info);
                }
                this.eQr = threadInfo.is_called.intValue();
                this.eQO = threadInfo.middle_page_num.intValue();
                this.eQP = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eQR = threadInfo.star_rank_icon.icon_pic_url;
                    this.eQS = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eQQ = new OriginalThreadInfo();
                    this.eQQ.a(threadInfo.origin_thread_info);
                } else {
                    this.eQQ = null;
                    this.isShareThread = false;
                }
                this.eQT = threadInfo.is_topic.intValue();
                this.eQV = threadInfo.topic_user_name;
                this.eQW = threadInfo.topic_h5_url;
                this.eQU = threadInfo.topic_module;
                this.eQY = threadInfo.presentation_style;
                this.eRb = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eRd = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.ePc = new bv();
                    this.ePc.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eRf = threadInfo.swan_info;
                }
                this.eRm = threadInfo.t_share_img;
                this.eRn = threadInfo.nid;
                this.eRo = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eRz = threadInfo.article_cover;
                this.eRA = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eRB = threadInfo.is_s_card.intValue() == 1;
                this.eRC = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eRD = threadInfo.wonderful_post_info;
                bnV();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eRE = threadInfo;
                if (!com.baidu.tbadk.core.util.x.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eRH) {
                            this.eRH = true;
                        }
                        this.eRF.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eRG.add(pbGoodsData);
                    }
                    if (this.eRG.size() > 0 && !this.eRH) {
                        this.eRH = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eRI = threadInfo.item;
                }
                if (this.eRI != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eRI);
                }
                this.eRJ = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.x.isEmpty(this.eRJ)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eRJ);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eRK == null) {
                        this.eRK = new PollData();
                    }
                    this.eRK.parserProtobuf(threadInfo.poll_info);
                }
                this.eRL = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eRM = threadInfo.distance.intValue();
                this.eRN = threadInfo.distance_text;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(WriteData writeData) {
        String dMP;
        if (writeData != null) {
            try {
                this.id = "0";
                this.tid = "";
                this.fid = com.baidu.adp.lib.f.b.toLong(writeData.getForumId(), 0L);
                this.title = writeData.getTitle();
                this.mCreateTime = System.currentTimeMillis() / 1000;
                this.last_time = (System.currentTimeMillis() / 1000) + "";
                this.ePh = System.currentTimeMillis() / 1000;
                this.ePn = new MetaData();
                this.ePn.parseFromCurrentUser();
                this.authorId = TbadkCoreApplication.getCurrentAccount();
                this.forum_name = writeData.getForumName();
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
                if (com.baidu.tbadk.core.util.at.isEmpty(com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMP())) {
                    dMP = writeData.getVideoInfo().getThumbPath();
                } else {
                    dMP = com.baidu.tieba.tbadkCore.writeModel.a.dMJ().dMP();
                }
                builder.thumbnail_url = dMP;
                builder.video_url = writeData.getVideoInfo().getVideoUrl();
                this.ePF = builder.build(true);
                this.threadType = 40;
                this.time = System.currentTimeMillis();
                this.eOV = writeData.isNoTitle() ? 1 : 0;
                this.eOW = writeData.getContent();
                this.ePc = new bv();
                this.ePc.forumId = writeData.getForumId();
                this.ePc.forumName = writeData.getForumName();
                this.mTabId = writeData.getTabId();
                this.mTabName = writeData.getTabName();
                bnV();
                if (!StringUtils.isNull(writeData.getItem_id()) && writeData.getItemInfo() != null) {
                    Item.Builder builder2 = new Item.Builder();
                    builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
                    builder2.icon_url = writeData.getItemInfo().getIconUrl();
                    builder2.item_name = writeData.getItemInfo().getTitle();
                    builder2.tags = writeData.getItemInfo().getTags();
                    builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
                    builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
                    this.eRI = builder2.build(true);
                    this.itemData = new ItemData();
                    this.itemData.parseItemInfo(writeData.getItemInfo());
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
                this.ePJ = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.ePf = jSONObject.optInt("repost_num", 0);
                this.ePg = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.ePh = jSONObject.optLong("last_time_int", 0L);
                this.ePi = jSONObject.optInt("is_top", 0);
                this.ePj = jSONObject.optInt("is_membertop", 0);
                this.ePk = jSONObject.optInt("is_good", 0);
                this.ePl = jSONObject.optInt("is_livepost", 0);
                this.ePm.parserJson(jSONObject.optJSONObject(AlbumActivityConfig.FROM_TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.ePn.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.ePo = jSONObject.optInt("has_commented", 0);
                this.ePp = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.ePu = jSONObject.optInt("collect_status");
                this.ePv = jSONObject.optString("collect_mark_pid");
                this.ePw = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ePx = jSONObject.optInt("thread_type");
                this.eQJ = jSONObject.optLong("share_num");
                this.ePA = jSONObject.optString("first_post_id", "0");
                this.ePL = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eOV = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONArray optJSONArray = jSONObject.optJSONArray("dislike_info");
                ArrayList<DislikeInfo> arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        DislikeInfo build = new DislikeInfo.Builder().build(true);
                        build.parseJson(optJSONArray.getJSONObject(i));
                        arrayList.add(build);
                    }
                }
                if (com.baidu.tbadk.core.util.x.getCount(arrayList) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    SparseArray<String> sparseArray2 = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : arrayList) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                            sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                    this.eMc = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eQe.parserJson(optJSONObject2);
                }
                if ((this.ePn == null || this.ePn.getUserId() == null) && this.userMap != null) {
                    this.ePn = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.ePI = new AlaInfoData();
                this.ePI.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eOW = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.ePq.add(mediaData);
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
                        this.ePr.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ePO.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ePP = new cl();
                    this.ePP.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ePQ = new g();
                    this.ePQ.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ePR = new s();
                    this.ePR.parserJson(optJSONObject6);
                }
                this.ePy.setUserMap(this.userMap);
                this.ePy.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ePz.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ePy.setTitle(this.title);
                } else {
                    this.ePy.setTitle(this.eOW);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eQe.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eQh.add(cVar);
                    }
                }
                this.eQo = jSONObject.optInt("is_book_chapter", 0);
                this.eQp.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eQw = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eQs = jSONObject.optString("recom_extra_img");
                this.eQv = jSONObject.optString("recom_extra_img_night");
                this.eQt = jSONObject.optInt("recom_extra_img_width", 0);
                this.eQu = jSONObject.optInt("recom_extra_img_height", 0);
                this.eQx = jSONObject.optLong("last_read_pid");
                this.eQy = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.ePH = new cg();
                    this.ePH.dp(optJSONObject8);
                }
                this.eQH = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eQK = new ao();
                    this.eQK.parserJson(optJSONObject9);
                }
                this.eQL = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eQM = new f();
                    this.eQM.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eQN = new MediaData();
                    this.eQN.parserJson(optJSONObject11);
                }
                this.eQr = jSONObject.optInt("is_called", 0);
                this.eQO = jSONObject.optInt("middle_page_num", 0);
                this.eQP = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject12.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject12.optInt(LogConfig.LOG_VIDEO_TYPE, 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject12.optInt("is_vertical", 0));
                    builder.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                    this.ePF = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eQQ = new OriginalThreadInfo();
                        this.eQQ.parserJson(optJSONObject13);
                    } else {
                        this.eQQ = null;
                    }
                } else {
                    this.eQQ = null;
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject14 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject14.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder2.name = optJSONObject14.optString("name");
                    builder2._abstract = optJSONObject14.optString("abstract");
                    builder2.pic = optJSONObject14.optString("pic");
                    builder2.h5_url = optJSONObject14.optString("h5_url");
                    builder2.id = optJSONObject14.optString("id");
                    builder2.link = optJSONObject14.optString("link");
                    this.eRf = builder2.build(false);
                }
                this.eRm = jSONObject.optString("t_share_img");
                this.eRn = jSONObject.optString(IntentConfig.NID);
                this.eRo = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eRA = jSONObject.optInt("bjh_content_tag");
                this.eRz = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eRB = jSONObject.optInt("is_s_card", 0) == 1;
                this.eRC = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eRD = jSONObject.optString("wonderful_post_info");
                bnV();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eRK == null) {
                        this.eRK = new PollData();
                    }
                    this.eRK.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eRH) {
                            this.eRH = true;
                        }
                        this.eRF.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eRG.add(pbGoodsData);
                    }
                    if (this.eRG.size() > 0 && !this.eRH) {
                        this.eRH = true;
                    }
                }
                this.eRL = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eRM = jSONObject.optInt("distance");
                this.eRN = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bnV() {
        bnW();
        bnY();
        bob();
        boc();
        bod();
        boe();
        bof();
    }

    private void bnW() {
        if (!StringUtils.isNull(this.ePn.getName_show())) {
            this.eRh = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ePn.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bnX() {
        if (this.ePI != null) {
            if (this.ePI.openRecomDuration == 1 && this.mCreateTime > 0) {
                String dU = com.baidu.tbadk.core.util.at.dU(this.mCreateTime);
                if (!StringUtils.isNull(dU)) {
                    this.eRi = dU;
                }
            }
            if (this.ePI.openRecomFans == 1) {
                int i = 0;
                if (this.ePI != null && this.ePI.user_info != null) {
                    i = this.ePI.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eRi) && i > 0) {
                    this.eRi += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.dX(i);
                } else if (i > 0) {
                    this.eRi = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.dX(i);
                }
            }
        }
    }

    private void bnY() {
        if ((this instanceof au) && "0".equals(getId())) {
            this.eRi = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
        } else if (bmg() || (bps() && getType() != eOz)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dS = com.baidu.tbadk.core.util.at.dS(j);
                if (com.baidu.tbadk.core.util.at.AO(dS)) {
                    dS = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.eRi = dS;
            }
            String str = "";
            if (this.ePn != null && this.ePn.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.ePn.getBaijiahaoInfo().auth_desc)) {
                str = this.ePn.getBaijiahaoInfo().auth_desc;
            }
            if (bpC()) {
                bnZ();
            } else if (!this.eRs && this.ePn != null && this.ePn.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ePn.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eRi)) {
                    this.eRi += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eRi = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eRi) && !TextUtils.isEmpty(str)) {
                this.eRi += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eRi = str;
            }
        } else if (getType() == eOz || getType() == eOC) {
            bnX();
        } else {
            long bnq = bnq() * 1000;
            if (bnq != 0) {
                String dS2 = com.baidu.tbadk.core.util.at.dS(bnq);
                if (com.baidu.tbadk.core.util.at.AO(dS2)) {
                    dS2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bnq);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bld()) {
                    dS2 = com.baidu.tbadk.core.util.at.dT(bnq);
                }
                this.eRi = string + dS2;
            } else {
                long j2 = this.mCreateTime;
                String dS3 = com.baidu.tbadk.core.util.at.dS(j2);
                if (com.baidu.tbadk.core.util.at.AO(dS3)) {
                    dS3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.eRi = dS3;
            }
            if (bpC()) {
                bnZ();
            } else if (!this.eRs && this.ePn != null && this.ePn.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ePn.getBazhuGradeData().getDesc(), this.eRr ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eRi)) {
                    this.eRi += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eRi = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eRi) && !TextUtils.isEmpty(getAddress())) {
                this.eRi += " • " + getAddress();
            }
        }
    }

    private void bnZ() {
        if (bpC() && !TextUtils.isEmpty(this.ePn.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eRi)) {
                this.eRi += "   " + this.ePn.getNewGodData().getFieldName() + com.baidu.tbadk.util.ag.lx(this.ePn.getNewGodData().isVideoGod());
            } else {
                this.eRi = this.ePn.getNewGodData().getFieldName() + com.baidu.tbadk.util.ag.lx(this.ePn.getNewGodData().isVideoGod());
            }
        }
    }

    public void boa() {
        if (!bmg() && !bps()) {
            long bnq = 1000 * bnq();
            if (bnq != 0) {
                String dS = com.baidu.tbadk.core.util.at.dS(bnq);
                if (com.baidu.tbadk.core.util.at.AO(dS)) {
                    dS = com.baidu.tbadk.core.util.at.getFormatTimeShort(bnq);
                }
                this.eRi = dS;
            }
            if (bpC()) {
                bnZ();
            } else if (!this.eRs && this.ePn != null && this.ePn.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ePn.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eRi)) {
                    this.eRi += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eRi = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eRi) && !TextUtils.isEmpty(getAddress())) {
                this.eRi += " • " + getAddress();
            }
        }
    }

    private void bob() {
        if (bnQ() == null || bnQ().share_info == null || bnQ().share_info.share_user_count <= 0 || !boU() || (this.eQO > 0 && this.eQP == 0)) {
            this.eRj = null;
            return;
        }
        int i = bnQ().share_info.share_user_count;
        if (i == 1) {
            this.eRj = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eRj = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void boc() {
        this.ePb = bow();
        com.baidu.tieba.card.m.a(this, this.ePb, true);
    }

    private void bod() {
        this.eMm = bou();
    }

    private void boe() {
        this.eRk = com.baidu.tbadk.core.util.at.getFormatTimeShort(bnq() * 1000);
    }

    private void bof() {
        this.eRl = com.baidu.tbadk.core.util.at.getFormatTimeShort(bnq());
    }

    public SpannableStringBuilder bog() {
        return this.ePa;
    }

    public boolean boh() {
        return bns() != 0;
    }

    public int boi() {
        if (this.eQe != null) {
            long bmP = this.eQe.bmP();
            long bmQ = this.eQe.bmQ();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bmP) {
                return 1;
            }
            if (currentTimeMillis > bmQ) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int boj() {
        if (bol() && this.ePO.size() >= 1) {
            b bVar = this.ePO.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int blh = bVar.blh();
            int bli = bVar.bli();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < blh) {
                return 4;
            }
            return currentTimeMillis > bli ? 2 : 1;
        }
        return -1;
    }

    public int bok() {
        if (!bol() || this.ePO.size() < 1 || this.ePO.get(0) == null) {
            return -1;
        }
        return this.ePO.get(0).blg();
    }

    public boolean bol() {
        return this.ePC == 1;
    }

    public String getActUrl() {
        return (!bol() || this.ePO.size() < 1 || this.ePO.get(0) == null) ? "" : this.ePO.get(0).getUrl();
    }

    private com.baidu.adp.widget.b zT(String str) {
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0106_1));
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

    public SmartApp bom() {
        return this.eRf;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && boo()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bns() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bns() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bnu() == 1 || this.ePm.bpR() != 0) {
                if (bnd() != null && getThreadType() == 41) {
                    if (boi() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && boH()) {
                Integer num = ePT.get(Integer.valueOf(boi()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bnt() == 1 && !boh() && eOy != getType() && eOH != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.ePz != null && this.ePz.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bnC() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = ePS.get(new Point(bok(), boj()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bnI() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bnJ() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = zT(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eOU));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bor = bor();
        if (bor != null) {
            spannableStringBuilder.append((CharSequence) bor);
        }
        this.ePa = spannableStringBuilder;
    }

    public boolean bon() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bnx() != null) {
            if (bnx().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bnx().getGender() == 2) {
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

    private boolean boo() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void z(boolean z, boolean z2) {
        e(z, z2, true);
    }

    public void e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.x.getCount(b(z, z2, z3, false)) > 0) {
            A(z, z3);
            return;
        }
        SpannableStringBuilder bor = bor();
        if (z) {
            spannableStringBuilder = a(bor.toString(), bor, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bor);
        }
        this.ePa = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> b2 = b(z, z2, z3, z4);
        if (b2 == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, b2, false);
        if (b2.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.eOV == 1) {
                this.ePa = a2;
                return a2;
            }
        } else if (this.eOV == 1) {
            this.ePa = new SpannableStringBuilder();
            return a2;
        }
        if (spannableStringBuilder != null) {
            a2.append((CharSequence) spannableStringBuilder);
            return a2;
        } else if (b2.size() > 0 || a2.length() == 0) {
            a2.append((CharSequence) str);
            return a2;
        } else {
            return a2;
        }
    }

    public void dJ(String str, String str2) {
        this.mUrl = str;
        this.eQj = str2;
    }

    public String bop() {
        return this.mUrl;
    }

    public String boq() {
        return this.eQj;
    }

    public SpannableStringBuilder bor() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eOX, this.title);
    }

    public SpannableStringBuilder bos() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eOY, this.eOW);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bot() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eRB) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bou() {
        SpannableStringBuilder bos = bos();
        com.baidu.tieba.card.m.a(this, bos, false);
        return new SpannableString(bos);
    }

    public SpannableString bov() {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.eOZ)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eOZ, this.eOW));
    }

    public String getAbstract() {
        return this.eOW;
    }

    public void zU(String str) {
        this.eOW = str;
    }

    public SpannableStringBuilder f(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bor;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eOV == 1) {
            bor = bos();
            spannableStringBuilder = bor.toString();
        } else {
            bor = bor();
            spannableStringBuilder = bor.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bor, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bor);
        }
        this.ePa = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return f(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bos;
        if (!StringUtils.isNull(this.title) && this.eOV != 1) {
            bos = bor();
        } else {
            bos = bos();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bos);
        this.ePa = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bow() {
        if (StringUtils.isNull(this.title) || this.eOV == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bor());
        this.ePa = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bmb() {
        if (this.eOX != null && this.eOX.size() > 0) {
            int size = this.eOX.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eOX.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bmc() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Dm(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void box() {
        y(false, false);
    }

    public void boy() {
        y(false, true);
    }

    public AnchorInfoData boz() {
        return this.ePz;
    }

    public boolean boA() {
        return this.threadType == 36;
    }

    public boolean bmc() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean boB() {
        return this.threadType == 11 || this.ePw == 1;
    }

    public boolean boC() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bnG = bnG();
        if (bnG == null || boh()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bnG.size() || i2 >= 3) {
                break;
            }
            if (bnG.get(i2) != null && bnG.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bnG.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bnG.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bnG.get(i2).getPicUrl();
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
        if (this.ePF != null && !StringUtils.isNull(this.ePF.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ePF.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.ePn != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.ePn.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean boD() {
        String userId;
        return this.ePn == null || (userId = this.ePn.getUserId()) == null || userId.equals("0");
    }

    public boolean boE() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eRU != null) {
            return this.eRU.dKX() ? (this.eRU.dKW() == null && this.eRU.dKY()) ? AdvertAppInfo.eIZ : AdvertAppInfo.eJa : this.eRU.dKW() != null ? AdvertAppInfo.eIY : AdvertAppInfo.eIZ;
        } else if (bpp()) {
            if (bnO() != null) {
                return eOy;
            }
            return eOa;
        } else {
            int bns = bns();
            if (this.eQT == 1) {
                if (this.eQU != null) {
                    return eOo;
                }
                return this.eQX != null ? eOJ : eOI;
            } else if (this.ePI != null && this.threadType == 60) {
                return eOB;
            } else {
                if (this.ePI != null && this.threadType == 49) {
                    return eOz;
                }
                if (this.ePI != null && this.threadType == 67) {
                    return eOC;
                }
                if (this.threadType == 51) {
                    return eOA;
                }
                if (this.threadType == 63) {
                    return eOK;
                }
                if (this.threadType == 64) {
                    return eOL;
                }
                if (bns == 2 || bns == 1) {
                    return eNZ;
                }
                if (this.ePF != null && boN() && !boE()) {
                    return eOQ;
                }
                if (this.ePF != null && !boE()) {
                    if (bnA()) {
                        return eOH;
                    }
                    if (this instanceof au) {
                        return eOR;
                    }
                    return eOy;
                } else if (this.isShareThread && this.eQQ != null) {
                    if (this.eQQ.eMn) {
                        if (this.eQQ.videoInfo != null) {
                            return eOG;
                        }
                        if (this.eQQ.bme()) {
                            return eOF;
                        }
                        return eOE;
                    }
                    return eOD;
                } else if (bme()) {
                    return eOp;
                } else {
                    if (boG()) {
                        return eON.get() ? eQd : eOa;
                    } else if (bol() && bok() == 1) {
                        return eON.get() ? eQl : eOa;
                    } else if (isLinkThread()) {
                        return eOw;
                    } else {
                        if (bnA()) {
                            return eOx;
                        }
                        if (this.eNF) {
                            return eOg;
                        }
                        if (this.eNG) {
                            return eOh;
                        }
                        if (this.eNH) {
                            return eOi;
                        }
                        if (this.eNI) {
                            return eOj;
                        }
                        if (this.eNJ) {
                            return eOk;
                        }
                        if (this.eNL) {
                            return eOm;
                        }
                        if (this.eNM) {
                            return eOn;
                        }
                        if (this.eNK) {
                            return eOl;
                        }
                        if (this.eOv) {
                            return eOr;
                        }
                        if (this.ePM) {
                            int boF = boF();
                            if (boF == 1) {
                                return eOc;
                            }
                            if (boF == 2) {
                                return eOd;
                            }
                            if (boF > 2) {
                                return eOe;
                            }
                            return eOa;
                        }
                        return eOa;
                    }
                }
            }
        }
    }

    public int boF() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bkB().isShowImages() || com.baidu.tbadk.core.util.x.getCount(bnG()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bnG().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(bnG(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean boG() {
        return bnd() != null && getThreadType() == 41 && bnu() == 1 && boi() == 2;
    }

    public void A(ArrayList<t> arrayList) {
        if (this.eOV == 1) {
            this.eKy = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eKy = 0;
        } else {
            this.eKy = 0;
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.blx() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.blx().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eKy = next.bly();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean boH() {
        return this.threadType == 41;
    }

    public boolean boI() {
        return this.eQm;
    }

    public void jv(boolean z) {
        this.eQm = z;
    }

    public String boJ() {
        return this.eQn;
    }

    public s boK() {
        return this.ePR;
    }

    public void boL() {
        if (this.ePK == 0) {
            this.ePK = 1;
        }
    }

    public boolean boM() {
        return this.eQq;
    }

    public void jw(boolean z) {
        this.eQz = z;
    }

    public boolean boN() {
        return this.eQz;
    }

    public void nn(int i) {
        this.eQA = i + 1;
    }

    public int boO() {
        return this.eQA;
    }

    public boolean boP() {
        return this.eRq;
    }

    public void jx(boolean z) {
        this.eRq = z;
    }

    public cg boQ() {
        return this.ePH;
    }

    public boolean boR() {
        return getThreadType() == 49;
    }

    public boolean boS() {
        return getThreadType() == 40;
    }

    public boolean boT() {
        return getThreadType() == 50;
    }

    public boolean boU() {
        return getThreadType() == 60;
    }

    public int boV() {
        return this.eQG;
    }

    public void setSmartFrsPosition(int i) {
        this.eQG = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String boW() {
        return this.mRecomSource;
    }

    public boolean boX() {
        return this.eQH;
    }

    public long boY() {
        return this.agreeData.agreeNum;
    }

    public long boZ() {
        return this.agreeData.disAgreeNum;
    }

    public int bpa() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bpb() {
        return this.agreeData.agreeType;
    }

    public void no(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void np(int i) {
        this.agreeData.agreeNum = i;
    }

    public void dH(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dI(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void nq(int i) {
        this.agreeData.agreeType = i;
    }

    public long bpc() {
        return this.eQJ;
    }

    public void dJ(long j) {
        this.eQJ = j;
    }

    public PostData bpd() {
        return this.eQI;
    }

    public ao bpe() {
        return this.eQK;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean bny = bny();
        if (z2) {
            if (z) {
                if (bny && !bmc()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (bnu() == 1 || getThreadType() == 33 || (bnw() != null && bnw().bpR() != 0)) {
                    if (bnd() != null && boH()) {
                        if (boi() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!bny) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (boH()) {
                    arrayList.add(eQD.get(boi()));
                }
                if (bol()) {
                    Integer num = eQC.get(new Point(bok(), boj()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (bnI() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (bny && bns() != 1 && !bmc()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((bnu() == 1 || getThreadType() == 33) && !boH() && !bny) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (bnt() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bns() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (boH() && bnd() != null && boi() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (bol()) {
                    Integer num2 = eQC.get(new Point(bok(), boj()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.eQo == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (bnJ() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (bnI() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && boR()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && boT()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (boS()) {
                    arrayList.add(new m.a(R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void B(ArrayList<MediaData> arrayList) {
        this.ePq = arrayList;
    }

    public void C(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.ePr = arrayList;
    }

    public String bpf() {
        return this.eQV;
    }

    public void zV(String str) {
        this.eQV = str;
    }

    public void bpg() {
        this.eQT = 1;
    }

    public boolean bph() {
        return this.eQT == 1;
    }

    public String bpi() {
        return this.ePd;
    }

    public void zW(String str) {
        this.ePd = str;
    }

    public String bpj() {
        return this.ePe;
    }

    public void zX(String str) {
        this.ePe = str;
    }

    public String bpk() {
        return this.eQW;
    }

    public void zY(String str) {
        this.eQW = str;
    }

    public boolean bpl() {
        return this.eQZ;
    }

    public void jy(boolean z) {
        this.eQZ = z;
    }

    public boolean bpm() {
        return this.eRa;
    }

    public void jz(boolean z) {
        this.eRa = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eQX = videoInfo;
    }

    public boolean bpn() {
        return this.eRb != null;
    }

    public bv bpo() {
        return this.ePc;
    }

    public boolean bpp() {
        return this.eRe;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.ePF != null) {
            return this.ePF.video_url;
        }
        return null;
    }

    public boolean bpq() {
        return this.eRg;
    }

    public void jA(boolean z) {
        this.eRg = z;
    }

    public AgreeData bpr() {
        return this.agreeData;
    }

    public boolean bps() {
        return this.eRt;
    }

    public void jB(boolean z) {
        this.eRt = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean blc() {
        return this.eRr;
    }

    public void jC(boolean z) {
        this.eRr = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bpt() {
        return this.eQU;
    }

    public String getShareImageUrl() {
        return this.eRm;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int i2;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bnG = bnG();
        if (com.baidu.tbadk.core.k.bkB().isShowImages() && com.baidu.tbadk.core.util.x.getCount(bnG) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < bnG.size(); i4++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(bnG, i4);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.x.getItem(bnG, 0);
        if (mediaData2 != null && mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
            if (mediaData2.picWidth * 2 <= mediaData2.picHeight) {
                i2 = ((int) (i3 * 1.5f)) + dimensionPixelSize;
                i = (i3 * 2) + dimensionPixelSize;
            } else if (mediaData2.picHeight * 2 <= mediaData2.picWidth) {
                i2 = (i3 * 2) + dimensionPixelSize;
                i = ((int) (i3 * 1.5f)) + dimensionPixelSize;
            } else if (mediaData2.picWidth < i3) {
                if (mediaData2.picHeight < i3) {
                    if (mediaData2.picWidth < mediaData2.picHeight) {
                        i = (mediaData2.picHeight * i3) / mediaData2.picWidth;
                        i2 = i3;
                    } else {
                        i2 = (mediaData2.picWidth * i3) / mediaData2.picHeight;
                        i = i3;
                    }
                } else if (mediaData2.picHeight < i3 || mediaData2.picHeight >= i3 * 2) {
                    i = 0;
                    i2 = 0;
                } else {
                    i = (mediaData2.picHeight * i3) / mediaData2.picWidth;
                    i2 = i3;
                }
            } else if (mediaData2.picWidth >= i3 && mediaData2.picWidth < i3 * 2) {
                if (mediaData2.picHeight < i3) {
                    i2 = (mediaData2.picWidth * i3) / mediaData2.picHeight;
                    i = i3;
                } else if (mediaData2.picHeight >= i3 && mediaData2.picHeight < i3 * 2) {
                    i2 = mediaData2.picWidth;
                    i = mediaData2.picHeight;
                } else {
                    int i5 = (i3 * 2) + dimensionPixelSize;
                    i2 = (mediaData2.picWidth * i5) / mediaData2.picHeight;
                    i = i5;
                }
            } else if (mediaData2.picHeight < i3) {
                i = 0;
                i2 = 0;
            } else if (mediaData2.picHeight >= i3 && mediaData2.picHeight < i3 * 2) {
                i2 = (i3 * 2) + dimensionPixelSize;
                i = (mediaData2.picHeight * i2) / mediaData2.picWidth;
            } else if (mediaData2.picWidth < mediaData2.picHeight) {
                int i6 = (i3 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picWidth * i6) / mediaData2.picHeight;
                i = i6;
            } else {
                i2 = (i3 * 2) + dimensionPixelSize;
                i = (mediaData2.picHeight * i2) / mediaData2.picWidth;
            }
        } else {
            int i7 = (i3 * 2) + dimensionPixelSize;
            i = i7;
            i2 = i7;
        }
        iArr[0] = i2;
        iArr[1] = i;
        com.baidu.tbadk.a.b.b.a(this, iArr);
        return iArr;
    }

    public boolean bpu() {
        return bpv() || bpw();
    }

    public boolean bme() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bmf() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bpv() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bpw() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bmg() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bmg();
    }

    public void nr(int i) {
        this.isBjh = i;
    }

    public int bpx() {
        return this.eRA;
    }

    public String bpy() {
        return this.eRz;
    }

    public void zZ(String str) {
        this.eRz = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bpz() {
        if (bnz()) {
            return 4;
        }
        if (boR() || boT()) {
            return 3;
        }
        if (bme()) {
            return 5;
        }
        if (bmf()) {
            return 6;
        }
        if (bpv()) {
            return 7;
        }
        if (bpw()) {
            return 8;
        }
        if (this.isShareThread && this.eQQ != null) {
            return 9;
        }
        if (boS()) {
            return 2;
        }
        return 1;
    }

    public int bpA() {
        if (bpw() || bpv()) {
            return 2;
        }
        if (bme() || bmf()) {
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

    public ThreadInfo bpB() {
        return this.eRE;
    }

    public String blV() {
        return this.eRn;
    }

    public boolean bpC() {
        return this.ePn != null && this.ePn.isNewGod();
    }

    public boolean bpD() {
        return (bnx() == null || bnx().getAlaUserData() == null || bnx().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bpE() {
        return this.eRI;
    }

    public List<HeadItem> bpF() {
        return this.eRJ;
    }

    public void a(Item item) {
        this.eRI = item;
    }

    public void by(List<HeadItem> list) {
        this.eRJ = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bpG() {
        return this.eRK;
    }

    public void b(PollData pollData) {
        this.eRK = pollData;
    }

    public List<PbLinkData> bpH() {
        return this.eRF;
    }

    public void bz(List<PbLinkData> list) {
        this.eRF = list;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.eRF)) {
            for (PbLinkData pbLinkData : this.eRF) {
                if (pbLinkData.urlType == 2 && !this.eRH) {
                    this.eRH = true;
                }
            }
        }
    }

    public List<PbGoodsData> bpI() {
        return this.eRG;
    }

    public void bA(List<PbGoodsData> list) {
        this.eRG = list;
        if (!com.baidu.tbadk.core.util.x.isEmpty(list) && !this.eRH) {
            this.eRH = true;
        }
    }

    public boolean bpJ() {
        return this.eRH;
    }

    public boolean bpK() {
        return this.ePn != null && this.ePn.isForumBusinessAccount();
    }
}

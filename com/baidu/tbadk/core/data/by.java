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
import com.baidu.tieba.card.n;
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
public class by extends a implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String brs;
    public String buttonText;
    public int eFi;
    public int eHa;
    private SpannableString eHg;
    private int eJM;
    private SpannableStringBuilder eJR;
    private SpannableStringBuilder eJS;
    private bu eJT;
    private String eJU;
    private String eJV;
    private long eKA;
    private s eKI;
    private LiveCoverStatus eKO;
    private long eKP;
    public TwZhiBoUser eKW;
    public List<TwAnchorProfitItem> eKX;
    public int eKj;
    private int eKk;
    private int eKn;
    public int eKo;
    private String eKr;
    private String eKs;
    private int eKu;
    private VideoInfo eKw;
    private VideoDesc eKx;
    private cf eKy;
    private AlaInfoData eKz;
    private long eLA;
    private ao eLB;
    public f eLD;
    private MediaData eLE;
    public int eLF;
    public OriginalThreadInfo eLH;
    private TopicModule eLL;
    private String eLM;
    private String eLN;
    private VideoInfo eLO;
    private String eLP;
    private boolean eLR;
    public OriginalForumInfo eLS;
    public boolean eLT;
    private String eLU;
    private boolean eLV;
    private SmartApp eLW;
    private String eLY;
    private String eLZ;
    private SkinInfo eLb;
    private boolean eLd;
    private String eLe;
    private boolean eLh;
    public String eLj;
    public int eLk;
    public int eLl;
    public String eLm;
    public String eLn;
    public long eLo;
    private List<ReportInfo> eLs;
    private boolean eLy;
    PollData eMA;
    public int eMC;
    public String eMD;
    public String eME;
    public String eMF;
    private String eMa;
    private String eMb;
    private String eMc;
    public String eMd;
    private boolean eMg;
    private boolean eMh;
    public boolean eMi;
    public boolean eMj;
    public boolean eMk;
    public boolean eMl;
    public boolean eMm;
    public boolean eMn;
    public String eMo;
    private String eMp;
    private int eMq;
    public String eMs;
    private String eMt;
    private ThreadInfo eMu;
    private boolean eMx;
    private Item eMy;
    private List<HeadItem> eMz;
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
    public static final BdUniqueId eIR = BdUniqueId.gen();
    public static final BdUniqueId eIS = BdUniqueId.gen();
    public static final BdUniqueId eIT = BdUniqueId.gen();
    public static final BdUniqueId eIU = BdUniqueId.gen();
    public static final BdUniqueId eIV = BdUniqueId.gen();
    public static final BdUniqueId eIW = BdUniqueId.gen();
    public static final BdUniqueId eIX = BdUniqueId.gen();
    public static final BdUniqueId eIY = BdUniqueId.gen();
    public static final BdUniqueId eIZ = BdUniqueId.gen();
    public static final BdUniqueId eJa = BdUniqueId.gen();
    public static final BdUniqueId eJb = BdUniqueId.gen();
    public static final BdUniqueId eJc = BdUniqueId.gen();
    public static final BdUniqueId eJd = BdUniqueId.gen();
    public static final BdUniqueId eJe = BdUniqueId.gen();
    public static final BdUniqueId eJf = BdUniqueId.gen();
    public static final BdUniqueId eJg = BdUniqueId.gen();
    public static final BdUniqueId eJh = BdUniqueId.gen();
    public static final BdUniqueId eJi = BdUniqueId.gen();
    public static final BdUniqueId eJj = BdUniqueId.gen();
    public static final BdUniqueId eJk = BdUniqueId.gen();
    public static final BdUniqueId eJl = BdUniqueId.gen();
    public static final BdUniqueId eJm = BdUniqueId.gen();
    public static final BdUniqueId eJo = BdUniqueId.gen();
    public static final BdUniqueId eJp = BdUniqueId.gen();
    public static final BdUniqueId eJq = BdUniqueId.gen();
    public static final BdUniqueId eJr = BdUniqueId.gen();
    public static final BdUniqueId eJs = BdUniqueId.gen();
    public static final BdUniqueId eJt = BdUniqueId.gen();
    public static final BdUniqueId eJu = BdUniqueId.gen();
    public static final BdUniqueId eJv = BdUniqueId.gen();
    public static final BdUniqueId eJw = BdUniqueId.gen();
    public static final BdUniqueId eJx = BdUniqueId.gen();
    public static final BdUniqueId eJy = BdUniqueId.gen();
    public static final BdUniqueId eJz = BdUniqueId.gen();
    public static final BdUniqueId eJA = BdUniqueId.gen();
    public static final BdUniqueId eJB = BdUniqueId.gen();
    public static final BdUniqueId eJC = BdUniqueId.gen();
    public static final BdUniqueId eJD = BdUniqueId.gen();
    public static final BdUniqueId eJE = BdUniqueId.gen();
    public static AtomicBoolean eJF = new AtomicBoolean(false);
    public static AtomicBoolean eJG = new AtomicBoolean(false);
    public static AtomicBoolean eJH = new AtomicBoolean(false);
    public static final BdUniqueId eJI = BdUniqueId.gen();
    private static HashMap<Point, Integer> eKJ = new HashMap<>();
    private static HashMap<Integer, Integer> eKK = new HashMap<>();
    public static final BdUniqueId eKU = BdUniqueId.gen();
    public static final BdUniqueId eLc = BdUniqueId.gen();
    private static HashMap<Point, Integer> eLt = new HashMap<>();
    private static SparseArray<n.a> eLu = new SparseArray<>(3);
    public boolean eIy = false;
    public boolean eIz = false;
    public boolean eIA = false;
    public boolean eIB = false;
    public boolean eIC = false;
    public boolean eID = false;
    public boolean eIE = false;
    public boolean eIF = false;
    public boolean eJn = false;
    private int eJJ = 0;
    private String eJK = "1";
    public int eJL = 1;
    private String eKm = null;
    private int eFt = 0;
    public int eKB = 0;
    private String eKC = "";
    public boolean eKD = false;
    private String eKL = "";
    public boolean eLp = true;
    public boolean eLv = false;
    public boolean eLw = false;
    private int eLx = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eGW = null;
    public boolean eLC = false;
    private int eLK = 0;
    private boolean eLQ = false;
    private boolean eLX = false;
    public boolean eMe = false;
    public boolean eMf = false;
    public boolean forbidComment = false;
    public boolean eMr = false;
    public boolean eMG = false;
    public boolean eMH = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eJW = 0;
    private int eJX = 0;
    private String last_time = null;
    private long eJY = 0;
    private int eJZ = 0;
    private int eKa = 0;
    private int eKb = 0;
    private int eKc = 0;
    private cc eKd = new cc();
    private MetaData eKe = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eKh = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eKi = new ArrayList<>();
    private int eKf = 0;
    private int eKg = 0;
    private String ad_url = null;
    private String eJN = null;
    private String from = null;
    private int eKl = 0;
    private PraiseData eKp = new PraiseData();
    private AnchorInfoData eKq = new AnchorInfoData();
    private long time = 0;
    private int eKt = 0;
    private ArrayList<b> eKF = new ArrayList<>();
    private ck eKG = null;
    private g eKH = null;
    private int eKM = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eKv = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eKN = null;
    private int eKE = 0;
    private boolean eKQ = false;
    private boolean eKR = false;
    private int eKS = 0;
    private boolean eKT = false;
    private int anchorLevel = 0;
    public int eLf = 0;
    public p eLg = new p();
    private List<PbContent> eJQ = new ArrayList();
    private List<PbContent> eJO = new ArrayList();
    private List<PbContent> eJP = new ArrayList();
    private String category_name = null;
    private bw eKV = new bw();
    private ArrayList<com.baidu.tbadk.data.c> eKY = new ArrayList<>();
    private PushStatusData eKZ = new PushStatusData();
    public boolean eLq = false;
    public int eLr = -1;
    private PostData eLz = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eLi = 0;
    public int eLG = 0;
    private String tieba_game_information_source = "";
    public String eLJ = "";
    public String eLI = "";
    private String mUrl = "";
    private String eLa = "";
    private List<PbLinkData> eMv = new ArrayList();
    private List<PbGoodsData> eMw = new ArrayList();
    public int eMB = -1;

    static {
        eKJ.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eKJ.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eKJ.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eKJ.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eKJ.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eKJ.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eKJ.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eKJ.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eLt.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eLt.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eLt.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eLt.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eLt.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eLt.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eLt.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eLt.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eKK.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eKK.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eKK.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eLu.put(1, new n.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eLu.put(2, new n.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eLu.put(3, new n.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public by() {
        this.eKk = 0;
        this.eKu = 0;
        this.eKP = 0L;
        this.eLF = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eKP = 0L;
        this.eKu = 0;
        this.eKk = 0;
        this.eLF = 0;
    }

    public String bom() {
        return this.eLY;
    }

    public String bon() {
        return this.eLZ;
    }

    public void Bb(String str) {
        this.eLZ = str;
    }

    public String boo() {
        return this.eMa;
    }

    public SpannableStringBuilder bop() {
        return this.eJS;
    }

    public SpannableString boq() {
        return this.eHg;
    }

    public void a(SpannableString spannableString) {
        if (boP() != null && !bmw() && !bmv()) {
            if (this.eJS != null) {
                this.eJS.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eHg);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eHg = new SpannableString(spannableStringBuilder);
        }
    }

    public void bor() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eMz) > 0) {
            if (this.eJS != null) {
                this.eJS.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bJ(this.eMz));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eHg);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bJ(this.eMz));
            this.eHg = new SpannableString(spannableStringBuilder);
        }
    }

    public String bos() {
        return this.eMb;
    }

    public String bot() {
        return this.eMc;
    }

    public boolean bou() {
        return this.eKk == 1;
    }

    public bw bov() {
        return this.eKV;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void oA(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eKu;
    }

    public void oB(int i) {
        this.eKS = i;
    }

    public int bow() {
        return this.eKS;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo box() {
        return this.eLO;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dF(long j) {
        this.mCreateTime = j;
    }

    public long boy() {
        return this.eKA;
    }

    public String boz() {
        return this.eKr;
    }

    public PraiseData boA() {
        return this.eKp;
    }

    public void a(PraiseData praiseData) {
        this.eKp = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String boB() {
        return this.brs;
    }

    public void Bc(String str) {
        this.brs = str;
    }

    public String boC() {
        return this.eJK;
    }

    public void Bd(String str) {
        this.eJK = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void oC(int i) {
        this.eJJ = i;
    }

    public int boD() {
        return this.eJJ;
    }

    public String boE() {
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

    public List<PbContent> boF() {
        return this.eJQ;
    }

    public void bo(List<PbContent> list) {
        this.eJQ = list;
    }

    public void bp(List<PbContent> list) {
        this.eJO = list;
    }

    public void bq(List<PbContent> list) {
        this.eJP = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void oD(int i) {
        this.reply_num = i;
    }

    public int boG() {
        return this.reply_num;
    }

    public int boH() {
        return this.eJX;
    }

    public void oE(int i) {
        this.eJX = i;
    }

    public long boI() {
        return this.eJY;
    }

    public void dG(long j) {
        this.eJY = j;
    }

    public int boJ() {
        return this.eKa;
    }

    public int boK() {
        return this.eJZ;
    }

    public void oF(int i) {
        this.eJZ = i;
    }

    public int boL() {
        return this.eKb;
    }

    public void oG(int i) {
        this.eKb = i;
    }

    public int boM() {
        return this.eKc;
    }

    public List<PbContent> boN() {
        return this.eJO;
    }

    public cc boO() {
        return this.eKd;
    }

    public MetaData boP() {
        return this.eKe;
    }

    public boolean boQ() {
        return this.is_god != 0;
    }

    public boolean boR() {
        return this.is_god == 1;
    }

    public boolean boS() {
        return (this.eKe == null || this.eKe.getGodUserData() == null || this.eKe.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eKe = metaData;
    }

    public String boT() {
        return this.forum_name;
    }

    public void Be(String str) {
        this.forum_name = str;
    }

    public int boU() {
        return this.eKg;
    }

    public String boV() {
        return this.ad_url;
    }

    public int boW() {
        return this.eKl;
    }

    public void oH(int i) {
        this.eKl = i;
    }

    public String boX() {
        return this.eKm;
    }

    public void Bf(String str) {
        this.eKm = str;
    }

    public ArrayList<MediaData> boY() {
        return this.eKh;
    }

    public ArrayList<b> boZ() {
        return this.eKF;
    }

    public void E(ArrayList<b> arrayList) {
        this.eKF = arrayList;
    }

    public ck bpa() {
        return this.eKG;
    }

    public g bpb() {
        return this.eKH;
    }

    public ArrayList<VoiceData.VoiceModel> bpc() {
        return this.eKi;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bpd() {
        return this.eJM;
    }

    public void oI(int i) {
        this.eJM = i;
    }

    public String bpe() {
        return this.latitude;
    }

    public String bpf() {
        return this.eKs;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bpg() {
        return this.eKC;
    }

    public VideoInfo bph() {
        return this.eKw;
    }

    public void a(VideoInfo videoInfo) {
        this.eKw = videoInfo;
    }

    public VideoDesc bpi() {
        return this.eKx;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eKz = alaInfoData;
    }

    public AlaInfoData bpj() {
        return this.eKz;
    }

    public PushStatusData bpk() {
        return this.eKZ;
    }

    public SkinInfo bpl() {
        return this.eLb;
    }

    public long bpm() {
        return this.eLo;
    }

    public boolean bpn() {
        return this.eLp;
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmo() {
        return this.eLn;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bmn().getTid());
        atVar.setFid(bmn().getFid());
        atVar.setNid(bmn().getNid());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.eGW = this.eGW;
        atVar.abTag = this.mRecomAbTag;
        atVar.weight = this.mRecomWeight;
        atVar.extra = this.mRecomExtra;
        atVar.source = this.mRecomSource;
        atVar.eHa = this.eHa;
        atVar.cardType = bqQ();
        return atVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eKs = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eKk = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eKA = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eJW = threadInfo.repost_num.intValue();
                this.eJX = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eJY = threadInfo.last_time_int.intValue();
                this.eJZ = threadInfo.is_top.intValue();
                this.eKa = threadInfo.is_membertop.intValue();
                this.eKb = threadInfo.is_good.intValue();
                this.eKc = threadInfo.is_livepost.intValue();
                this.eKd.a(threadInfo.topic);
                this.eKe.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eKf = threadInfo.has_commented.intValue();
                this.eKg = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eKw = threadInfo.video_info;
                this.eKx = threadInfo.video_segment;
                this.eKz = new AlaInfoData();
                this.eKz.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eKl = threadInfo.collect_status.intValue();
                this.eKm = threadInfo.collect_mark_pid;
                this.eKn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eKo = threadInfo.thread_type.intValue();
                this.eKr = threadInfo.first_post_id + "";
                this.eKC = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eJM = threadInfo.is_ntitle.intValue();
                this.eKt = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eLA = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eKu = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eLh = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eJO = threadInfo.rich_title;
                this.eJQ = threadInfo.first_post_content;
                this.eJP = threadInfo.rich_abstract;
                this.eKj = threadInfo.is_godthread_recommend.intValue();
                if ((this.eKe == null || this.eKe.getUserId() == null || this.eKe.getUserId().equals("0") || this.eMH) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eKe = metaData;
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
                this.eJN = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eKh.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eKw = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eKy = new cf();
                    this.eKy.a(threadInfo.video_channel_info);
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
                        this.eKi.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.eKF.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eKG = new ck();
                    this.eKG.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eKH = new g();
                    this.eKH.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eKI = new s();
                    this.eKI.a(threadInfo.cartoon_info);
                }
                this.eKp.setUserMap(this.userMap);
                this.eKp.parserProtobuf(threadInfo.zan);
                this.eKq.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eKp.setTitle(this.title);
                } else {
                    this.eKp.setTitle(this.eJN);
                }
                this.eKL = threadInfo.livecover_src;
                this.eKM = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eKE = threadInfo.post_num.intValue();
                this.eKP = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.rT(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Do(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eKv.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eKN = noticeInfo.notice;
                    }
                    this.eKS = zhiBoInfoTW.copythread_remind.intValue();
                    this.eKQ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eKR = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eKL)) {
                        this.eKL = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eKW = zhiBoInfoTW.user.tw_anchor_info;
                        this.eKX = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eKO = threadInfo.twzhibo_info.livecover_status;
                    this.eKP = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eKT = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eKV.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eKY.add(cVar2);
                    }
                }
                this.eKZ.parserProtobuf(threadInfo.push_status);
                this.eLe = threadInfo.lego_card;
                this.eLb = threadInfo.skin_info;
                this.eLf = threadInfo.is_book_chapter.intValue();
                this.eLg.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eLn = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eLo = threadInfo.last_read_pid.longValue();
                this.eLp = threadInfo.cheak_repeat.intValue() == 1;
                this.eLs = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eLz.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.y.getCount(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    SparseArray<String> sparseArray2 = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                            sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                    this.eGW = sparseArray2;
                }
                this.eLy = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eLB = new ao();
                    this.eLB.a(threadInfo.link_info);
                }
                this.eLC = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eLD = new f();
                    this.eLD.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eLE = new MediaData();
                    this.eLE.parserProtobuf(threadInfo.pic_info);
                }
                this.eLi = threadInfo.is_called.intValue();
                this.eLF = threadInfo.middle_page_num.intValue();
                this.eLG = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eLI = threadInfo.star_rank_icon.icon_pic_url;
                    this.eLJ = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eLH = new OriginalThreadInfo();
                    this.eLH.a(threadInfo.origin_thread_info);
                } else {
                    this.eLH = null;
                    this.isShareThread = false;
                }
                this.eLK = threadInfo.is_topic.intValue();
                this.eLM = threadInfo.topic_user_name;
                this.eLN = threadInfo.topic_h5_url;
                this.eLL = threadInfo.topic_module;
                this.eLP = threadInfo.presentation_style;
                this.eLS = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eLU = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eJT = new bu();
                    this.eJT.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eLW = threadInfo.swan_info;
                }
                this.eMd = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.eMe = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eMp = threadInfo.article_cover;
                this.eMq = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eMr = threadInfo.is_s_card.intValue() == 1;
                this.eMs = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eMt = threadInfo.wonderful_post_info;
                bpo();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eMu = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eMx) {
                            this.eMx = true;
                        }
                        this.eMv.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eMw.add(pbGoodsData);
                    }
                    if (this.eMw.size() > 0 && !this.eMx) {
                        this.eMx = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eMy = threadInfo.item;
                }
                if (this.eMy != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eMy);
                }
                this.eMz = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eMz)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eMz);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eMA == null) {
                        this.eMA = new PollData();
                    }
                    this.eMA.parserProtobuf(threadInfo.poll_info);
                }
                this.eMB = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eMC = threadInfo.distance.intValue();
                this.eMD = threadInfo.distance_text;
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
                this.eKA = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eJW = jSONObject.optInt("repost_num", 0);
                this.eJX = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eJY = jSONObject.optLong("last_time_int", 0L);
                this.eJZ = jSONObject.optInt("is_top", 0);
                this.eKa = jSONObject.optInt("is_membertop", 0);
                this.eKb = jSONObject.optInt("is_good", 0);
                this.eKc = jSONObject.optInt("is_livepost", 0);
                this.eKd.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.eKe.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eKf = jSONObject.optInt("has_commented", 0);
                this.eKg = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eKl = jSONObject.optInt("collect_status");
                this.eKm = jSONObject.optString("collect_mark_pid");
                this.eKn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eKo = jSONObject.optInt("thread_type");
                this.eLA = jSONObject.optLong("share_num");
                this.eKr = jSONObject.optString("first_post_id", "0");
                this.eKC = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eJM = jSONObject.optInt("is_ntitle");
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
                if (com.baidu.tbadk.core.util.y.getCount(arrayList) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    SparseArray<String> sparseArray2 = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : arrayList) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                            sparseArray2.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.extra);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                    this.eGW = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eKV.parserJson(optJSONObject2);
                }
                if ((this.eKe == null || this.eKe.getUserId() == null) && this.userMap != null) {
                    this.eKe = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eKz = new AlaInfoData();
                this.eKz.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eJN = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eKh.add(mediaData);
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
                        this.eKi.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eKF.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eKG = new ck();
                    this.eKG.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eKH = new g();
                    this.eKH.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eKI = new s();
                    this.eKI.parserJson(optJSONObject6);
                }
                this.eKp.setUserMap(this.userMap);
                this.eKp.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eKq.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eKp.setTitle(this.title);
                } else {
                    this.eKp.setTitle(this.eJN);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eKV.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eKY.add(cVar);
                    }
                }
                this.eLf = jSONObject.optInt("is_book_chapter", 0);
                this.eLg.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eLn = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eLj = jSONObject.optString("recom_extra_img");
                this.eLm = jSONObject.optString("recom_extra_img_night");
                this.eLk = jSONObject.optInt("recom_extra_img_width", 0);
                this.eLl = jSONObject.optInt("recom_extra_img_height", 0);
                this.eLo = jSONObject.optLong("last_read_pid");
                this.eLp = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eKy = new cf();
                    this.eKy.dh(optJSONObject8);
                }
                this.eLy = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eLB = new ao();
                    this.eLB.parserJson(optJSONObject9);
                }
                this.eLC = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eLD = new f();
                    this.eLD.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eLE = new MediaData();
                    this.eLE.parserJson(optJSONObject11);
                }
                this.eLi = jSONObject.optInt("is_called", 0);
                this.eLF = jSONObject.optInt("middle_page_num", 0);
                this.eLG = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eKw = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eLH = new OriginalThreadInfo();
                        this.eLH.parserJson(optJSONObject13);
                    } else {
                        this.eLH = null;
                    }
                } else {
                    this.eLH = null;
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
                    this.eLW = builder2.build(false);
                }
                this.eMd = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.eMe = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eMq = jSONObject.optInt("bjh_content_tag");
                this.eMp = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eMr = jSONObject.optInt("is_s_card", 0) == 1;
                this.eMs = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eMt = jSONObject.optString("wonderful_post_info");
                bpo();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eMA == null) {
                        this.eMA = new PollData();
                    }
                    this.eMA.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eMx) {
                            this.eMx = true;
                        }
                        this.eMv.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eMw.add(pbGoodsData);
                    }
                    if (this.eMw.size() > 0 && !this.eMx) {
                        this.eMx = true;
                    }
                }
                this.eMB = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eMC = jSONObject.optInt("distance");
                this.eMD = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bpo() {
        bpp();
        bpr();
        bpu();
        bpv();
        bpw();
        bpx();
        bpy();
    }

    private void bpp() {
        if (!StringUtils.isNull(this.eKe.getName_show())) {
            this.eLY = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eKe.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bpq() {
        if (this.eKz != null) {
            if (this.eKz.openRecomDuration == 1 && this.mCreateTime > 0) {
                String dU = com.baidu.tbadk.core.util.au.dU(this.mCreateTime);
                if (!StringUtils.isNull(dU)) {
                    this.eLZ = dU;
                }
            }
            if (this.eKz.openRecomFans == 1) {
                int i = 0;
                if (this.eKz != null && this.eKz.user_info != null) {
                    i = this.eKz.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eLZ) && i > 0) {
                    this.eLZ += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.au.dX(i);
                } else if (i > 0) {
                    this.eLZ = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.au.dX(i);
                }
            }
        }
    }

    private void bpr() {
        if (bnz() || (bqJ() && getType() != eJr)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dS = com.baidu.tbadk.core.util.au.dS(j);
                if (com.baidu.tbadk.core.util.au.Cc(dS)) {
                    dS = com.baidu.tbadk.core.util.au.getFormatTimeShort(j);
                }
                this.eLZ = dS;
            }
            String str = "";
            if (this.eKe != null && this.eKe.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eKe.getBaijiahaoInfo().auth_desc)) {
                str = this.eKe.getBaijiahaoInfo().auth_desc;
            }
            if (bqT()) {
                bps();
            } else if (!this.eMi && this.eKe != null && this.eKe.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eKe.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eLZ)) {
                    this.eLZ += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eLZ = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eLZ) && !TextUtils.isEmpty(str)) {
                this.eLZ += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eLZ = str;
            }
        } else if (getType() == eJr || getType() == eJu) {
            bpq();
        } else {
            long boI = boI() * 1000;
            if (boI != 0) {
                String dS2 = com.baidu.tbadk.core.util.au.dS(boI);
                if (com.baidu.tbadk.core.util.au.Cc(dS2)) {
                    dS2 = com.baidu.tbadk.core.util.au.getFormatTimeShort(boI);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bmv()) {
                    dS2 = com.baidu.tbadk.core.util.au.dT(boI);
                }
                this.eLZ = string + dS2;
            } else {
                long j2 = this.mCreateTime;
                String dS3 = com.baidu.tbadk.core.util.au.dS(j2);
                if (com.baidu.tbadk.core.util.au.Cc(dS3)) {
                    dS3 = com.baidu.tbadk.core.util.au.getFormatTimeShort(j2);
                }
                this.eLZ = dS3;
            }
            if (bqT()) {
                bps();
            } else if (!this.eMi && this.eKe != null && this.eKe.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eKe.getBazhuGradeData().getDesc(), this.eMh ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eLZ)) {
                    this.eLZ += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eLZ = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eLZ) && !TextUtils.isEmpty(getAddress())) {
                this.eLZ += " • " + getAddress();
            }
        }
    }

    private void bps() {
        if (bqT() && !TextUtils.isEmpty(this.eKe.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eLZ)) {
                this.eLZ += "   " + this.eKe.getNewGodData().getFieldName() + com.baidu.tbadk.util.ah.lf(this.eKe.getNewGodData().isVideoGod());
            } else {
                this.eLZ = this.eKe.getNewGodData().getFieldName() + com.baidu.tbadk.util.ah.lf(this.eKe.getNewGodData().isVideoGod());
            }
        }
    }

    public void bpt() {
        if (!bnz() && !bqJ()) {
            long boI = 1000 * boI();
            if (boI != 0) {
                String dS = com.baidu.tbadk.core.util.au.dS(boI);
                if (com.baidu.tbadk.core.util.au.Cc(dS)) {
                    dS = com.baidu.tbadk.core.util.au.getFormatTimeShort(boI);
                }
                this.eLZ = dS;
            }
            if (bqT()) {
                bps();
            } else if (!this.eMi && this.eKe != null && this.eKe.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eKe.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eLZ)) {
                    this.eLZ += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eLZ = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eLZ) && !TextUtils.isEmpty(getAddress())) {
                this.eLZ += " • " + getAddress();
            }
        }
    }

    private void bpu() {
        if (bpj() == null || bpj().share_info == null || bpj().share_info.share_user_count <= 0 || !bql() || (this.eLF > 0 && this.eLG == 0)) {
            this.eMa = null;
            return;
        }
        int i = bpj().share_info.share_user_count;
        if (i == 1) {
            this.eMa = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eMa = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.au.numberUniform(i)});
        }
    }

    private void bpv() {
        this.eJS = bpO();
        com.baidu.tieba.card.n.a(this, this.eJS, true);
    }

    private void bpw() {
        this.eHg = bpM();
    }

    private void bpx() {
        this.eMb = com.baidu.tbadk.core.util.au.getFormatTimeShort(boI() * 1000);
    }

    private void bpy() {
        this.eMc = com.baidu.tbadk.core.util.au.getFormatTimeShort(boI());
    }

    public SpannableStringBuilder bpz() {
        return this.eJR;
    }

    public boolean isTop() {
        return boK() != 0;
    }

    public int bpA() {
        if (this.eKV != null) {
            long boh = this.eKV.boh();
            long boi = this.eKV.boi();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < boh) {
                return 1;
            }
            if (currentTimeMillis > boi) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bpB() {
        if (bpD() && this.eKF.size() >= 1) {
            b bVar = this.eKF.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bmz = bVar.bmz();
            int bmA = bVar.bmA();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bmz) {
                return 4;
            }
            return currentTimeMillis > bmA ? 2 : 1;
        }
        return -1;
    }

    public int bpC() {
        if (!bpD() || this.eKF.size() < 1 || this.eKF.get(0) == null) {
            return -1;
        }
        return this.eKF.get(0).bmy();
    }

    public boolean bpD() {
        return this.eKt == 1;
    }

    public String getActUrl() {
        return (!bpD() || this.eKF.size() < 1 || this.eKF.get(0) == null) ? "" : this.eKF.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Bg(String str) {
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

    public SmartApp bpE() {
        return this.eLW;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bpG()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (boK() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (boK() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (boM() == 1 || this.eKd.bri() != 0) {
                if (bov() != null && getThreadType() == 41) {
                    if (bpA() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bpZ()) {
                Integer num = eKK.get(Integer.valueOf(bpA()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (boL() == 1 && !isTop() && eJq != getType() && eJz != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eKq != null && this.eKq.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (boU() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eKJ.get(new Point(bpC(), bpB()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bpa() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bpb() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Bg(this.category_name);
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
                Bitmap bitmap = com.baidu.tbadk.core.util.ap.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eJL));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bpJ = bpJ();
        if (bpJ != null) {
            spannableStringBuilder.append((CharSequence) bpJ);
        }
        this.eJR = spannableStringBuilder;
    }

    public boolean bpF() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = com.baidu.tbadk.core.util.ap.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (boP() != null) {
            if (boP().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (boP().getGender() == 2) {
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

    private boolean bpG() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void z(boolean z, boolean z2) {
        d(z, z2, true);
    }

    public void d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.y.getCount(a(z, z2, z3, false)) > 0) {
            A(z, z3);
            return;
        }
        SpannableStringBuilder bpJ = bpJ();
        if (z) {
            spannableStringBuilder = a(bpJ.toString(), bpJ, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bpJ);
        }
        this.eJR = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> a2 = a(z, z2, z3, z4);
        if (a2 == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a3 = com.baidu.tieba.card.n.a((Context) TbadkCoreApplication.getInst(), str, a2, false);
        if (a2.size() > 0) {
            if (a3 == null) {
                a3 = new SpannableStringBuilder();
            }
            if (this.eJM == 1) {
                this.eJR = a3;
                return a3;
            }
        } else if (this.eJM == 1) {
            this.eJR = new SpannableStringBuilder();
            return a3;
        }
        if (spannableStringBuilder != null) {
            a3.append((CharSequence) spannableStringBuilder);
            return a3;
        } else if (a2.size() > 0 || a3.length() == 0) {
            a3.append((CharSequence) str);
            return a3;
        } else {
            return a3;
        }
    }

    public void dL(String str, String str2) {
        this.mUrl = str;
        this.eLa = str2;
    }

    public String bpH() {
        return this.mUrl;
    }

    public String bpI() {
        return this.eLa;
    }

    public SpannableStringBuilder bpJ() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eJO, this.title);
    }

    public SpannableStringBuilder bpK() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eJP, this.eJN);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bpL() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eMr) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bpM() {
        SpannableStringBuilder bpK = bpK();
        com.baidu.tieba.card.n.a(this, bpK, false);
        return new SpannableString(bpK);
    }

    public SpannableString bpN() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eJQ)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eJQ, this.eJN));
    }

    public String getAbstract() {
        return this.eJN;
    }

    public void Bh(String str) {
        this.eJN = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bpJ;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eJM == 1) {
            bpJ = bpK();
            spannableStringBuilder = bpJ.toString();
        } else {
            bpJ = bpJ();
            spannableStringBuilder = bpJ.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bpJ, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bpJ);
        }
        this.eJR = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bpK;
        if (!StringUtils.isNull(this.title) && this.eJM != 1) {
            bpK = bpJ();
        } else {
            bpK = bpK();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bpK);
        this.eJR = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bpO() {
        if (StringUtils.isNull(this.title) || this.eJM == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bpJ());
        this.eJR = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bnu() {
        if (this.eJO != null && this.eJO.size() > 0) {
            int size = this.eJO.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eJO.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bnv() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.EB(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bpP() {
        y(false, false);
    }

    public void bpQ() {
        y(false, true);
    }

    public AnchorInfoData bpR() {
        return this.eKq;
    }

    public boolean bpS() {
        return this.threadType == 36;
    }

    public boolean bnv() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bpT() {
        return this.threadType == 11 || this.eKn == 1;
    }

    public boolean bpU() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> boY = boY();
        if (boY == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= boY.size() || i2 >= 3) {
                break;
            }
            if (boY.get(i2) != null && boY.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(boY.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = boY.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = boY.get(i2).getPicUrl();
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
        if (this.eKw != null && !StringUtils.isNull(this.eKw.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eKw.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eKe != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eKe.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bpV() {
        String userId;
        return this.eKe == null || (userId = this.eKe.getUserId()) == null || userId.equals("0");
    }

    public boolean bpW() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bqG()) {
            if (bph() != null) {
                return eJq;
            }
            return eIS;
        }
        int boK = boK();
        if (this.eLK == 1) {
            if (this.eLL != null) {
                return eJg;
            }
            return this.eLO != null ? eJB : eJA;
        } else if (this.eKz != null && this.threadType == 60) {
            return eJt;
        } else {
            if (this.eKz != null && this.threadType == 49) {
                return eJr;
            }
            if (this.eKz != null && this.threadType == 67) {
                return eJu;
            }
            if (this.threadType == 51) {
                return eJs;
            }
            if (this.threadType == 63) {
                return eJC;
            }
            if (this.threadType == 64) {
                return eJD;
            }
            if (boK == 2 || boK == 1) {
                return eIR;
            }
            if (this.eKw != null && bqe() && !bpW()) {
                return eJI;
            }
            if (this.eKw != null && !bpW()) {
                if (boS()) {
                    return eJz;
                }
                return eJq;
            } else if (this.isShareThread && this.eLH != null) {
                if (this.eLH.eHh) {
                    if (this.eLH.videoInfo != null) {
                        return eJy;
                    }
                    if (this.eLH.bnx()) {
                        return eJx;
                    }
                    return eJw;
                }
                return eJv;
            } else if (bnx()) {
                return eJh;
            } else {
                if (bpY()) {
                    return eJF.get() ? eKU : eIS;
                } else if (bpD() && bpC() == 1) {
                    return eJF.get() ? eLc : eIS;
                } else if (isLinkThread()) {
                    return eJo;
                } else {
                    if (boS()) {
                        return eJp;
                    }
                    if (this.eIy) {
                        return eIY;
                    }
                    if (this.eIz) {
                        return eIZ;
                    }
                    if (this.eIA) {
                        return eJa;
                    }
                    if (this.eIB) {
                        return eJb;
                    }
                    if (this.eIC) {
                        return eJc;
                    }
                    if (this.eIE) {
                        return eJe;
                    }
                    if (this.eIF) {
                        return eJf;
                    }
                    if (this.eID) {
                        return eJd;
                    }
                    if (this.eJn) {
                        return eJj;
                    }
                    if (this.eKD) {
                        int bpX = bpX();
                        if (bpX == 1) {
                            return eIU;
                        }
                        if (bpX == 2) {
                            return eIV;
                        }
                        if (bpX > 2) {
                            return eIW;
                        }
                        return eIS;
                    }
                    return eIS;
                }
            }
        }
    }

    public int bpX() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.blV().isShowImages() || com.baidu.tbadk.core.util.y.getCount(boY()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < boY().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(boY(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bpY() {
        return bov() != null && getThreadType() == 41 && boM() == 1 && bpA() == 2;
    }

    public void F(ArrayList<t> arrayList) {
        if (this.eJM == 1) {
            this.eFt = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eFt = 0;
        } else {
            this.eFt = 0;
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.bmR() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bmR().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eFt = next.bmS();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bpZ() {
        return this.threadType == 41;
    }

    public boolean bqa() {
        return this.eLd;
    }

    public void jd(boolean z) {
        this.eLd = z;
    }

    public String bqb() {
        return this.eLe;
    }

    public s bqc() {
        return this.eKI;
    }

    public void bqd() {
        if (this.eKB == 0) {
            this.eKB = 1;
        }
    }

    public void je(boolean z) {
        this.eLq = z;
    }

    public boolean bqe() {
        return this.eLq;
    }

    public void oJ(int i) {
        this.eLr = i + 1;
    }

    public int bqf() {
        return this.eLr;
    }

    public boolean bqg() {
        return this.eMg;
    }

    public void jf(boolean z) {
        this.eMg = z;
    }

    public cf bqh() {
        return this.eKy;
    }

    public boolean bqi() {
        return getThreadType() == 49;
    }

    public boolean bqj() {
        return getThreadType() == 40;
    }

    public boolean bqk() {
        return getThreadType() == 50;
    }

    public boolean bql() {
        return getThreadType() == 60;
    }

    public int bqm() {
        return this.eLx;
    }

    public void setSmartFrsPosition(int i) {
        this.eLx = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bqn() {
        return this.mRecomSource;
    }

    public boolean bqo() {
        return this.eLy;
    }

    public long bqp() {
        return this.agreeData.agreeNum;
    }

    public long bqq() {
        return this.agreeData.disAgreeNum;
    }

    public int bqr() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bqs() {
        return this.agreeData.agreeType;
    }

    public void oK(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void oL(int i) {
        this.agreeData.agreeNum = i;
    }

    public void dH(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dI(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void oM(int i) {
        this.agreeData.agreeType = i;
    }

    public long bqt() {
        return this.eLA;
    }

    public void dJ(long j) {
        this.eLA = j;
    }

    public PostData bqu() {
        return this.eLz;
    }

    public ao bqv() {
        return this.eLB;
    }

    private ArrayList<n.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean boQ = boQ();
        if (z2) {
            if (z) {
                if (boQ && !bnv()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if (boM() == 1 || getThreadType() == 33 || (boO() != null && boO().bri() != 0)) {
                    if (bov() != null && bpZ()) {
                        if (bpA() == 2) {
                            arrayList.add(new n.a(R.string.interview_live));
                        }
                    } else if (!boQ) {
                        arrayList.add(new n.a(R.string.photo_live_tips));
                    }
                }
                if (bpZ()) {
                    arrayList.add(eLu.get(bpA()));
                }
                if (bpD()) {
                    Integer num = eLt.get(new Point(bpC(), bpB()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (bpa() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (boQ && boK() != 1 && !bnv()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if ((boM() == 1 || getThreadType() == 33) && !bpZ() && !boQ) {
                    arrayList.add(new n.a(R.string.photo_live_tips));
                }
                if (boL() == 1) {
                    arrayList.add(new n.a(R.string.good));
                }
                if (boK() == 1) {
                    arrayList.add(new n.a(R.string.top));
                }
                if (bpZ() && bov() != null && bpA() == 2) {
                    arrayList.add(new n.a(R.string.interview_live));
                }
                if (bpD()) {
                    Integer num2 = eLt.get(new Point(bpC(), bpB()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (this.eLf == 1) {
                    arrayList.add(new n.a(R.string.card_tbread_text));
                }
                if (bpb() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (bpa() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && bqi()) {
                    arrayList.add(new n.a(R.string.ala_live));
                }
                if (z3 && bqk()) {
                    arrayList.add(new n.a(R.string.live_record));
                } else if (bqj()) {
                    arrayList.add(new n.a(R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new n.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void G(ArrayList<MediaData> arrayList) {
        this.eKh = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eKi = arrayList;
    }

    public String bqw() {
        return this.eLM;
    }

    public void Bi(String str) {
        this.eLM = str;
    }

    public void bqx() {
        this.eLK = 1;
    }

    public boolean bqy() {
        return this.eLK == 1;
    }

    public String bqz() {
        return this.eJU;
    }

    public void Bj(String str) {
        this.eJU = str;
    }

    public String bqA() {
        return this.eJV;
    }

    public void Bk(String str) {
        this.eJV = str;
    }

    public String bqB() {
        return this.eLN;
    }

    public void Bl(String str) {
        this.eLN = str;
    }

    public boolean bqC() {
        return this.eLQ;
    }

    public void jg(boolean z) {
        this.eLQ = z;
    }

    public boolean bqD() {
        return this.eLR;
    }

    public void jh(boolean z) {
        this.eLR = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eLO = videoInfo;
    }

    public boolean bqE() {
        return this.eLS != null;
    }

    public bu bqF() {
        return this.eJT;
    }

    public boolean bqG() {
        return this.eLV;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eKw != null) {
            return this.eKw.video_url;
        }
        return null;
    }

    public boolean bqH() {
        return this.eLX;
    }

    public void ji(boolean z) {
        this.eLX = z;
    }

    public AgreeData bqI() {
        return this.agreeData;
    }

    public boolean bqJ() {
        return this.eMj;
    }

    public void jj(boolean z) {
        this.eMj = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean bmu() {
        return this.eMh;
    }

    public void jk(boolean z) {
        this.eMh = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bqK() {
        return this.eLL;
    }

    public String getShareImageUrl() {
        return this.eMd;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> boY = boY();
        if (com.baidu.tbadk.core.k.blV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(boY) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < boY.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(boY, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(boY, 0);
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

    public boolean bqL() {
        return bqM() || bqN();
    }

    public boolean bnx() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bny() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bqM() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bqN() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bnz() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bnz();
    }

    public void oN(int i) {
        this.isBjh = i;
    }

    public int bqO() {
        return this.eMq;
    }

    public String bqP() {
        return this.eMp;
    }

    public void Bm(String str) {
        this.eMp = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bqQ() {
        if (boR()) {
            return 4;
        }
        if (bqi() || bqk()) {
            return 3;
        }
        if (bnx()) {
            return 5;
        }
        if (bny()) {
            return 6;
        }
        if (bqM()) {
            return 7;
        }
        if (bqN()) {
            return 8;
        }
        if (this.isShareThread && this.eLH != null) {
            return 9;
        }
        if (bqj()) {
            return 2;
        }
        return 1;
    }

    public int bqR() {
        if (bqN() || bqM()) {
            return 2;
        }
        if (bnx() || bny()) {
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

    public ThreadInfo bqS() {
        return this.eMu;
    }

    public String getNid() {
        return this.mNid;
    }

    public boolean bqT() {
        return this.eKe != null && this.eKe.isNewGod();
    }

    public boolean bqU() {
        return (boP() == null || boP().getAlaUserData() == null || boP().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bqV() {
        return this.eMy;
    }

    public List<HeadItem> bqW() {
        return this.eMz;
    }

    public void a(Item item) {
        this.eMy = item;
    }

    public void br(List<HeadItem> list) {
        this.eMz = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bqX() {
        return this.eMA;
    }

    public void b(PollData pollData) {
        this.eMA = pollData;
    }

    public List<PbLinkData> bqY() {
        return this.eMv;
    }

    public void bs(List<PbLinkData> list) {
        this.eMv = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eMv)) {
            for (PbLinkData pbLinkData : this.eMv) {
                if (pbLinkData.urlType == 2 && !this.eMx) {
                    this.eMx = true;
                }
            }
        }
    }

    public List<PbGoodsData> bqZ() {
        return this.eMw;
    }

    public void bt(List<PbGoodsData> list) {
        this.eMw = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eMx) {
            this.eMx = true;
        }
    }

    public boolean bra() {
        return this.eMx;
    }

    public boolean brb() {
        return this.eKe != null && this.eKe.isForumBusinessAccount();
    }
}

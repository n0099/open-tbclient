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
public class cb extends a implements com.baidu.adp.widget.ListView.n, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String authorId;
    private String buO;
    public String buttonText;
    public int eMz;
    public int eOs;
    private SpannableString eOy;
    public int eRE;
    private int eRF;
    private int eRI;
    public int eRJ;
    private String eRM;
    private String eRN;
    private int eRP;
    private VideoInfo eRR;
    private VideoDesc eRS;
    private ci eRT;
    private AlaInfoData eRU;
    private long eRV;
    private int eRh;
    private SpannableStringBuilder eRm;
    private SpannableStringBuilder eRn;
    private bx eRo;
    private String eRp;
    private String eRq;
    private boolean eSC;
    public String eSE;
    public int eSF;
    public int eSG;
    public String eSH;
    public String eSI;
    public long eSJ;
    private List<ReportInfo> eSN;
    private boolean eST;
    private long eSV;
    private ap eSW;
    public g eSY;
    private MediaData eSZ;
    private t eSd;
    private LiveCoverStatus eSj;
    private long eSk;
    public TwZhiBoUser eSr;
    public List<TwAnchorProfitItem> eSs;
    private SkinInfo eSw;
    private boolean eSy;
    private String eSz;
    private boolean eTC;
    private boolean eTD;
    public boolean eTE;
    public boolean eTF;
    public boolean eTG;
    public boolean eTH;
    public boolean eTI;
    public boolean eTJ;
    public boolean eTK;
    public String eTL;
    public String eTM;
    private String eTN;
    private int eTO;
    public String eTQ;
    private String eTR;
    private ThreadInfo eTS;
    private boolean eTV;
    private Item eTW;
    private List<HeadItem> eTX;
    PollData eTY;
    public int eTa;
    public OriginalThreadInfo eTc;
    private TopicModule eTg;
    private String eTh;
    private String eTi;
    private VideoInfo eTj;
    private String eTk;
    private boolean eTm;
    public OriginalForumInfo eTn;
    public boolean eTo;
    private String eTp;
    private boolean eTq;
    private SmartApp eTr;
    private String eTt;
    private String eTu;
    private String eTv;
    private String eTw;
    private String eTx;
    public String eTy;
    private String eTz;
    public int eUa;
    public String eUb;
    public boolean eUc;
    public String eUd;
    public String eUe;
    public String eUf;
    public com.baidu.tieba.tbadkCore.data.n eUi;
    public int isAuthorView;
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
    public static final BdUniqueId eQl = BdUniqueId.gen();
    public static final BdUniqueId eQm = BdUniqueId.gen();
    public static final BdUniqueId eQn = BdUniqueId.gen();
    public static final BdUniqueId eQo = BdUniqueId.gen();
    public static final BdUniqueId eQp = BdUniqueId.gen();
    public static final BdUniqueId eQq = BdUniqueId.gen();
    public static final BdUniqueId eQr = BdUniqueId.gen();
    public static final BdUniqueId eQs = BdUniqueId.gen();
    public static final BdUniqueId eQt = BdUniqueId.gen();
    public static final BdUniqueId eQu = BdUniqueId.gen();
    public static final BdUniqueId eQv = BdUniqueId.gen();
    public static final BdUniqueId eQw = BdUniqueId.gen();
    public static final BdUniqueId eQx = BdUniqueId.gen();
    public static final BdUniqueId eQy = BdUniqueId.gen();
    public static final BdUniqueId eQz = BdUniqueId.gen();
    public static final BdUniqueId eQA = BdUniqueId.gen();
    public static final BdUniqueId eQB = BdUniqueId.gen();
    public static final BdUniqueId eQC = BdUniqueId.gen();
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public static final BdUniqueId eQE = BdUniqueId.gen();
    public static final BdUniqueId eQF = BdUniqueId.gen();
    public static final BdUniqueId eQG = BdUniqueId.gen();
    public static final BdUniqueId eQI = BdUniqueId.gen();
    public static final BdUniqueId eQJ = BdUniqueId.gen();
    public static final BdUniqueId eQK = BdUniqueId.gen();
    public static final BdUniqueId eQL = BdUniqueId.gen();
    public static final BdUniqueId eQM = BdUniqueId.gen();
    public static final BdUniqueId eQN = BdUniqueId.gen();
    public static final BdUniqueId eQO = BdUniqueId.gen();
    public static final BdUniqueId eQP = BdUniqueId.gen();
    public static final BdUniqueId eQQ = BdUniqueId.gen();
    public static final BdUniqueId eQR = BdUniqueId.gen();
    public static final BdUniqueId eQS = BdUniqueId.gen();
    public static final BdUniqueId eQT = BdUniqueId.gen();
    public static final BdUniqueId eQU = BdUniqueId.gen();
    public static final BdUniqueId eQV = BdUniqueId.gen();
    public static final BdUniqueId eQW = BdUniqueId.gen();
    public static final BdUniqueId eQX = BdUniqueId.gen();
    public static final BdUniqueId eQY = BdUniqueId.gen();
    public static AtomicBoolean eQZ = new AtomicBoolean(false);
    public static AtomicBoolean eRa = new AtomicBoolean(false);
    public static AtomicBoolean eRb = new AtomicBoolean(false);
    public static final BdUniqueId eRc = BdUniqueId.gen();
    public static final BdUniqueId eRd = BdUniqueId.gen();
    private static HashMap<Point, Integer> eSe = new HashMap<>();
    private static HashMap<Integer, Integer> eSf = new HashMap<>();
    public static final BdUniqueId eSp = BdUniqueId.gen();
    public static final BdUniqueId eSx = BdUniqueId.gen();
    private static HashMap<Point, Integer> eSO = new HashMap<>();
    private static SparseArray<m.a> eSP = new SparseArray<>(3);
    public boolean ePR = false;
    public boolean ePS = false;
    public boolean ePT = false;
    public boolean ePU = false;
    public boolean ePV = false;
    public boolean ePW = false;
    public boolean ePX = false;
    public boolean ePY = false;
    public boolean eQH = false;
    private int eRe = 0;
    private String eRf = "1";
    public int eRg = 1;
    private String eRH = null;
    private int eMK = 0;
    public int eRW = 0;
    private String eRX = "";
    public boolean eRY = false;
    private String eSg = "";
    public boolean eSK = true;
    public boolean eSQ = false;
    public boolean eSR = false;
    private int eSS = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eOo = null;
    public boolean eSX = false;
    private int eTf = 0;
    private boolean eTl = false;
    private boolean eTs = false;
    public boolean eTA = false;
    public boolean eTB = false;
    public boolean forbidComment = false;
    public boolean eTP = false;
    public boolean eUg = false;
    public boolean eUh = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eRr = 0;
    private int eRs = 0;
    private String last_time = null;
    private long eRt = 0;
    private int eRu = 0;
    private int eRv = 0;
    private int eRw = 0;
    private int eRx = 0;
    private cf eRy = new cf();
    private MetaData eRz = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eRC = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eRD = new ArrayList<>();
    private int eRA = 0;
    private int eRB = 0;
    private String ad_url = null;
    private String eRi = null;
    private String from = null;
    private int eRG = 0;
    private PraiseData eRK = new PraiseData();
    private AnchorInfoData eRL = new AnchorInfoData();
    private long time = 0;
    private int eRO = 0;
    private ArrayList<b> eSa = new ArrayList<>();
    private cn eSb = null;
    private h eSc = null;
    private int eSh = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eRQ = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eSi = null;
    private int eRZ = 0;
    private boolean eSl = false;
    private boolean eSm = false;
    private int eSn = 0;
    private boolean eSo = false;
    private int anchorLevel = 0;
    public int eSA = 0;
    public q eSB = new q();
    private List<PbContent> eRl = new ArrayList();
    private List<PbContent> eRj = new ArrayList();
    private List<PbContent> eRk = new ArrayList();
    private String category_name = null;
    private bz eSq = new bz();
    private ArrayList<com.baidu.tbadk.data.c> eSt = new ArrayList<>();
    private PushStatusData eSu = new PushStatusData();
    public boolean eSL = false;
    public int eSM = -1;
    private PostData eSU = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eSD = 0;
    public int eTb = 0;
    private String tieba_game_information_source = "";
    public String eTe = "";
    public String eTd = "";
    private String mUrl = "";
    private String eSv = "";
    private List<PbLinkData> eTT = new ArrayList();
    private List<PbGoodsData> eTU = new ArrayList();
    public int eTZ = -1;

    static {
        eSe.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eSe.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eSe.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eSe.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eSe.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eSe.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eSe.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eSe.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eSO.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eSO.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eSO.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eSO.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eSO.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eSO.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eSO.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eSO.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eSf.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eSf.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eSf.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eSP.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eSP.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eSP.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public cb() {
        this.eRF = 0;
        this.eRP = 0;
        this.eSk = 0L;
        this.eTa = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eSk = 0L;
        this.eRP = 0;
        this.eRF = 0;
        this.eTa = 0;
    }

    public String bnn() {
        return this.eTt;
    }

    public String bno() {
        return this.eTu;
    }

    public void Af(String str) {
        this.eTu = str;
    }

    public String bnp() {
        return this.eTv;
    }

    public SpannableStringBuilder bnq() {
        return this.eRn;
    }

    public SpannableString bnr() {
        return this.eOy;
    }

    public void a(SpannableString spannableString) {
        if (bnQ() != null && !blw() && !blv()) {
            if (this.eRn != null) {
                this.eRn.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eOy);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eOy = new SpannableString(spannableStringBuilder);
        }
    }

    public void bns() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eTX) > 0) {
            if (this.eRn != null) {
                this.eRn.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bL(this.eTX));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eOy);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bL(this.eTX));
            this.eOy = new SpannableString(spannableStringBuilder);
        }
    }

    public String bnt() {
        return this.eTw;
    }

    public String bnu() {
        return this.eTx;
    }

    public boolean bnv() {
        return this.eRF == 1;
    }

    public bz bnw() {
        return this.eSq;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void nh(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eRP;
    }

    public void ni(int i) {
        this.eSn = i;
    }

    public int bnx() {
        return this.eSn;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bny() {
        return this.eTj;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dL(long j) {
        this.mCreateTime = j;
    }

    public long bnz() {
        return this.eRV;
    }

    public String bnA() {
        return this.eRM;
    }

    public PraiseData bnB() {
        return this.eRK;
    }

    public void a(PraiseData praiseData) {
        this.eRK = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bnC() {
        return this.buO;
    }

    public void Ag(String str) {
        this.buO = str;
    }

    public String bnD() {
        return this.eRf;
    }

    public void Ah(String str) {
        this.eRf = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nj(int i) {
        this.eRe = i;
    }

    public int bnE() {
        return this.eRe;
    }

    public String bnF() {
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

    public List<PbContent> bnG() {
        return this.eRl;
    }

    public void bq(List<PbContent> list) {
        this.eRl = list;
    }

    public void br(List<PbContent> list) {
        this.eRj = list;
    }

    public void bs(List<PbContent> list) {
        this.eRk = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nk(int i) {
        this.reply_num = i;
    }

    public int bnH() {
        return this.reply_num;
    }

    public int bnI() {
        return this.eRs;
    }

    public void nl(int i) {
        this.eRs = i;
    }

    public long bnJ() {
        return this.eRt;
    }

    public void dM(long j) {
        this.eRt = j;
    }

    public int bnK() {
        return this.eRv;
    }

    public int bnL() {
        return this.eRu;
    }

    public void nm(int i) {
        this.eRu = i;
    }

    public int bnM() {
        return this.eRw;
    }

    public void nn(int i) {
        this.eRw = i;
    }

    public int bnN() {
        return this.eRx;
    }

    public List<PbContent> bnO() {
        return this.eRj;
    }

    public cf bnP() {
        return this.eRy;
    }

    public MetaData bnQ() {
        return this.eRz;
    }

    public boolean bnR() {
        return this.is_god != 0;
    }

    public boolean bnS() {
        return this.is_god == 1;
    }

    public boolean bnT() {
        return (this.eRz == null || this.eRz.getGodUserData() == null || this.eRz.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eRz = metaData;
    }

    public String bnU() {
        return this.forum_name;
    }

    public void Ai(String str) {
        this.forum_name = str;
    }

    public int bnV() {
        return this.eRB;
    }

    public String bnW() {
        return this.ad_url;
    }

    public int bnX() {
        return this.eRG;
    }

    public void no(int i) {
        this.eRG = i;
    }

    public String bnY() {
        return this.eRH;
    }

    public void Aj(String str) {
        this.eRH = str;
    }

    public ArrayList<MediaData> bnZ() {
        return this.eRC;
    }

    public ArrayList<b> boa() {
        return this.eSa;
    }

    public void z(ArrayList<b> arrayList) {
        this.eSa = arrayList;
    }

    public cn bob() {
        return this.eSb;
    }

    public h boc() {
        return this.eSc;
    }

    public ArrayList<VoiceData.VoiceModel> bod() {
        return this.eRD;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int boe() {
        return this.eRh;
    }

    public void np(int i) {
        this.eRh = i;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String bof() {
        return this.eRN;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bog() {
        return this.eRX;
    }

    public VideoInfo boh() {
        return this.eRR;
    }

    public void a(VideoInfo videoInfo) {
        this.eRR = videoInfo;
    }

    public VideoDesc boi() {
        return this.eRS;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eRU = alaInfoData;
    }

    public AlaInfoData boj() {
        return this.eRU;
    }

    public PushStatusData bok() {
        return this.eSu;
    }

    public SkinInfo bol() {
        return this.eSw;
    }

    public long bom() {
        return this.eSJ;
    }

    public boolean bon() {
        return this.eSK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blo() {
        return this.eSI;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(bln().getTid());
        avVar.setFid(bln().getFid());
        avVar.setNid(bln().bmo());
        avVar.setFeedBackReasonMap(this.feedBackReasonMap);
        avVar.eOo = this.eOo;
        avVar.abTag = this.mRecomAbTag;
        avVar.weight = this.mRecomWeight;
        avVar.extra = this.mRecomExtra;
        avVar.source = this.mRecomSource;
        avVar.eOs = this.eOs;
        avVar.cardType = bpR();
        return avVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eRN = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eRF = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eRV = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eRr = threadInfo.repost_num.intValue();
                this.eRs = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eRt = threadInfo.last_time_int.intValue();
                this.eRu = threadInfo.is_top.intValue();
                this.eRv = threadInfo.is_membertop.intValue();
                this.eRw = threadInfo.is_good.intValue();
                this.eRx = threadInfo.is_livepost.intValue();
                this.eRy.a(threadInfo.topic);
                this.eRz.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eRA = threadInfo.has_commented.intValue();
                this.eRB = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eRR = threadInfo.video_info;
                this.eRS = threadInfo.video_segment;
                this.eRU = new AlaInfoData();
                this.eRU.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eRG = threadInfo.collect_status.intValue();
                this.eRH = threadInfo.collect_mark_pid;
                this.eRI = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eRJ = threadInfo.thread_type.intValue();
                this.eRM = threadInfo.first_post_id + "";
                this.eRX = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eRh = threadInfo.is_ntitle.intValue();
                this.eRO = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eSV = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eRP = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eSC = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eRj = threadInfo.rich_title;
                this.eRl = threadInfo.first_post_content;
                this.eRk = threadInfo.rich_abstract;
                this.eRE = threadInfo.is_godthread_recommend.intValue();
                if ((this.eRz == null || this.eRz.getUserId() == null || this.eRz.getUserId().equals("0") || this.eUh) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eRz = metaData;
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
                this.eRi = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eRC.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eRR = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eRT = new ci();
                    this.eRT.a(threadInfo.video_channel_info);
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
                        this.eRD.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.eSa.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eSb = new cn();
                    this.eSb.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eSc = new h();
                    this.eSc.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eSd = new t();
                    this.eSd.a(threadInfo.cartoon_info);
                }
                this.eRK.setUserMap(this.userMap);
                this.eRK.parserProtobuf(threadInfo.zan);
                this.eRL.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eRK.setTitle(this.title);
                } else {
                    this.eRK.setTitle(this.eRi);
                }
                this.eSg = threadInfo.livecover_src;
                this.eSh = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eRZ = threadInfo.post_num.intValue();
                this.eSk = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qE(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Cr(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eRQ.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eSi = noticeInfo.notice;
                    }
                    this.eSn = zhiBoInfoTW.copythread_remind.intValue();
                    this.eSl = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eSm = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eSg)) {
                        this.eSg = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eSr = zhiBoInfoTW.user.tw_anchor_info;
                        this.eSs = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eSj = threadInfo.twzhibo_info.livecover_status;
                    this.eSk = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eSo = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eSq.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eSt.add(cVar2);
                    }
                }
                this.eSu.parserProtobuf(threadInfo.push_status);
                this.eSz = threadInfo.lego_card;
                this.eSw = threadInfo.skin_info;
                this.eSA = threadInfo.is_book_chapter.intValue();
                this.eSB.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eSI = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eSJ = threadInfo.last_read_pid.longValue();
                this.eSK = threadInfo.cheak_repeat.intValue() == 1;
                this.eSN = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eSU.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.eOo = sparseArray2;
                }
                this.eST = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eSW = new ap();
                    this.eSW.a(threadInfo.link_info);
                }
                this.eSX = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eSY = new g();
                    this.eSY.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eSZ = new MediaData();
                    this.eSZ.parserProtobuf(threadInfo.pic_info);
                }
                this.eSD = threadInfo.is_called.intValue();
                this.eTa = threadInfo.middle_page_num.intValue();
                this.eTb = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eTd = threadInfo.star_rank_icon.icon_pic_url;
                    this.eTe = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eTc = new OriginalThreadInfo();
                    this.eTc.a(threadInfo.origin_thread_info);
                } else {
                    this.eTc = null;
                    this.isShareThread = false;
                }
                this.eTf = threadInfo.is_topic.intValue();
                this.eTh = threadInfo.topic_user_name;
                this.eTi = threadInfo.topic_h5_url;
                this.eTg = threadInfo.topic_module;
                this.eTk = threadInfo.presentation_style;
                this.eTn = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eTp = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eRo = new bx();
                    this.eRo.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eTr = threadInfo.swan_info;
                }
                this.eTy = threadInfo.t_share_img;
                this.eTz = threadInfo.nid;
                this.eTA = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eTN = threadInfo.article_cover;
                this.eTO = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eTP = threadInfo.is_s_card.intValue() == 1;
                this.eTQ = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eTR = threadInfo.wonderful_post_info;
                boo();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eTS = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eTV) {
                            this.eTV = true;
                        }
                        this.eTT.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eTU.add(pbGoodsData);
                    }
                    if (this.eTU.size() > 0 && !this.eTV) {
                        this.eTV = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eTW = threadInfo.item;
                }
                if (this.eTW != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eTW);
                }
                this.eTX = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eTX)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eTX);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eTY == null) {
                        this.eTY = new PollData();
                    }
                    this.eTY.parserProtobuf(threadInfo.poll_info);
                }
                this.eTZ = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eUa = threadInfo.distance.intValue();
                this.eUb = threadInfo.distance_text;
                this.isAuthorView = threadInfo.is_author_view.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(WriteData writeData) {
        String dPi;
        if (writeData != null) {
            try {
                this.id = "0";
                this.tid = "";
                this.fid = com.baidu.adp.lib.f.b.toLong(writeData.getForumId(), 0L);
                this.title = writeData.getTitle();
                this.mCreateTime = System.currentTimeMillis() / 1000;
                this.last_time = (System.currentTimeMillis() / 1000) + "";
                this.eRt = System.currentTimeMillis() / 1000;
                this.eRz = new MetaData();
                this.eRz.parseFromCurrentUser();
                this.authorId = TbadkCoreApplication.getCurrentAccount();
                this.forum_name = writeData.getForumName();
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
                if (com.baidu.tbadk.core.util.au.isEmpty(com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPi())) {
                    dPi = writeData.getVideoInfo().getThumbPath();
                } else {
                    dPi = com.baidu.tieba.tbadkCore.writeModel.a.dPc().dPi();
                }
                builder.thumbnail_url = dPi;
                builder.video_url = writeData.getVideoInfo().getVideoUrl();
                this.eRR = builder.build(true);
                this.threadType = 40;
                this.time = System.currentTimeMillis();
                this.eRh = writeData.isNoTitle() ? 1 : 0;
                this.eRi = writeData.getContent();
                this.eRo = new bx();
                this.eRo.forumId = writeData.getForumId();
                this.eRo.forumName = writeData.getForumName();
                this.mTabId = writeData.getTabId();
                this.mTabName = writeData.getTabName();
                boo();
                if (!StringUtils.isNull(writeData.getItem_id()) && writeData.getItemInfo() != null) {
                    Item.Builder builder2 = new Item.Builder();
                    builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
                    builder2.icon_url = writeData.getItemInfo().getIconUrl();
                    builder2.item_name = writeData.getItemInfo().getTitle();
                    builder2.tags = writeData.getItemInfo().getTags();
                    builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
                    builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
                    this.eTW = builder2.build(true);
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
                this.eRV = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eRr = jSONObject.optInt("repost_num", 0);
                this.eRs = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eRt = jSONObject.optLong("last_time_int", 0L);
                this.eRu = jSONObject.optInt("is_top", 0);
                this.eRv = jSONObject.optInt("is_membertop", 0);
                this.eRw = jSONObject.optInt("is_good", 0);
                this.eRx = jSONObject.optInt("is_livepost", 0);
                this.eRy.parserJson(jSONObject.optJSONObject(AlbumActivityConfig.FROM_TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.eRz.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eRA = jSONObject.optInt("has_commented", 0);
                this.eRB = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eRG = jSONObject.optInt("collect_status");
                this.eRH = jSONObject.optString("collect_mark_pid");
                this.eRI = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eRJ = jSONObject.optInt("thread_type");
                this.eSV = jSONObject.optLong("share_num");
                this.eRM = jSONObject.optString("first_post_id", "0");
                this.eRX = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eRh = jSONObject.optInt("is_ntitle");
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
                    this.eOo = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eSq.parserJson(optJSONObject2);
                }
                if ((this.eRz == null || this.eRz.getUserId() == null) && this.userMap != null) {
                    this.eRz = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.eRU = new AlaInfoData();
                this.eRU.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eRi = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eRC.add(mediaData);
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
                        this.eRD.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eSa.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eSb = new cn();
                    this.eSb.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eSc = new h();
                    this.eSc.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eSd = new t();
                    this.eSd.parserJson(optJSONObject6);
                }
                this.eRK.setUserMap(this.userMap);
                this.eRK.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eRL.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eRK.setTitle(this.title);
                } else {
                    this.eRK.setTitle(this.eRi);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eSq.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eSt.add(cVar);
                    }
                }
                this.eSA = jSONObject.optInt("is_book_chapter", 0);
                this.eSB.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eSI = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eSE = jSONObject.optString("recom_extra_img");
                this.eSH = jSONObject.optString("recom_extra_img_night");
                this.eSF = jSONObject.optInt("recom_extra_img_width", 0);
                this.eSG = jSONObject.optInt("recom_extra_img_height", 0);
                this.eSJ = jSONObject.optLong("last_read_pid");
                this.eSK = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eRT = new ci();
                    this.eRT.dp(optJSONObject8);
                }
                this.eST = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eSW = new ap();
                    this.eSW.parserJson(optJSONObject9);
                }
                this.eSX = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eSY = new g();
                    this.eSY.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eSZ = new MediaData();
                    this.eSZ.parserJson(optJSONObject11);
                }
                this.eSD = jSONObject.optInt("is_called", 0);
                this.eTa = jSONObject.optInt("middle_page_num", 0);
                this.eTb = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eRR = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eTc = new OriginalThreadInfo();
                        this.eTc.parserJson(optJSONObject13);
                    } else {
                        this.eTc = null;
                    }
                } else {
                    this.eTc = null;
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
                    this.eTr = builder2.build(false);
                }
                this.eTy = jSONObject.optString("t_share_img");
                this.eTz = jSONObject.optString(IntentConfig.NID);
                this.eTA = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eTO = jSONObject.optInt("bjh_content_tag");
                this.eTN = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eTP = jSONObject.optInt("is_s_card", 0) == 1;
                this.eTQ = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eTR = jSONObject.optString("wonderful_post_info");
                boo();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eTY == null) {
                        this.eTY = new PollData();
                    }
                    this.eTY.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eTV) {
                            this.eTV = true;
                        }
                        this.eTT.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eTU.add(pbGoodsData);
                    }
                    if (this.eTU.size() > 0 && !this.eTV) {
                        this.eTV = true;
                    }
                }
                this.eTZ = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eUa = jSONObject.optInt("distance");
                this.eUb = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void boo() {
        bop();
        bor();
        bou();
        bov();
        bow();
        box();
        boy();
    }

    private void bop() {
        if (!StringUtils.isNull(this.eRz.getName_show())) {
            this.eTt = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eRz.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void boq() {
        if (this.eRU != null) {
            if (this.eRU.openRecomDuration == 1 && this.mCreateTime > 0) {
                String ea = com.baidu.tbadk.core.util.au.ea(this.mCreateTime);
                if (!StringUtils.isNull(ea)) {
                    this.eTu = ea;
                }
            }
            if (this.eRU.openRecomFans == 1) {
                int i = 0;
                if (this.eRU != null && this.eRU.user_info != null) {
                    i = this.eRU.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eTu) && i > 0) {
                    this.eTu += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.au.ed(i);
                } else if (i > 0) {
                    this.eTu = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.au.ed(i);
                }
            }
        }
    }

    private void bor() {
        if ((this instanceof aw) && "0".equals(getId())) {
            this.eTu = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
        } else if (bmz() || (bpK() && getType() != eQL)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dY = com.baidu.tbadk.core.util.au.dY(j);
                if (com.baidu.tbadk.core.util.au.Bf(dY)) {
                    dY = com.baidu.tbadk.core.util.au.getFormatTimeShort(j);
                }
                this.eTu = dY;
            }
            String str = "";
            if (this.eRz != null && this.eRz.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eRz.getBaijiahaoInfo().auth_desc)) {
                str = this.eRz.getBaijiahaoInfo().auth_desc;
            }
            if (bpU()) {
                bos();
            } else if (!this.eTE && this.eRz != null && this.eRz.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eRz.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eTu)) {
                    this.eTu += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eTu = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eTu) && !TextUtils.isEmpty(str)) {
                this.eTu += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eTu = str;
            }
        } else if (getType() == eQL || getType() == eQO) {
            boq();
        } else {
            long bnJ = bnJ() * 1000;
            if (bnJ != 0) {
                String dY2 = com.baidu.tbadk.core.util.au.dY(bnJ);
                if (com.baidu.tbadk.core.util.au.Bf(dY2)) {
                    dY2 = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnJ);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (blv()) {
                    dY2 = com.baidu.tbadk.core.util.au.dZ(bnJ);
                }
                this.eTu = string + dY2;
            } else {
                long j2 = this.mCreateTime;
                String dY3 = com.baidu.tbadk.core.util.au.dY(j2);
                if (com.baidu.tbadk.core.util.au.Bf(dY3)) {
                    dY3 = com.baidu.tbadk.core.util.au.getFormatTimeShort(j2);
                }
                this.eTu = dY3;
            }
            if (bpU()) {
                bos();
            } else if (!this.eTE && this.eRz != null && this.eRz.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eRz.getBazhuGradeData().getDesc(), this.eTD ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eTu)) {
                    this.eTu += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eTu = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eTu) && !TextUtils.isEmpty(getAddress())) {
                this.eTu += " • " + getAddress();
            }
        }
    }

    private void bos() {
        if (bpU() && !TextUtils.isEmpty(this.eRz.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eTu)) {
                this.eTu += "   " + this.eRz.getNewGodData().getFieldName() + com.baidu.tbadk.util.aj.lA(this.eRz.getNewGodData().isVideoGod());
            } else {
                this.eTu = this.eRz.getNewGodData().getFieldName() + com.baidu.tbadk.util.aj.lA(this.eRz.getNewGodData().isVideoGod());
            }
        }
    }

    public void bot() {
        if (!bmz() && !bpK()) {
            long bnJ = 1000 * bnJ();
            if (bnJ != 0) {
                String dY = com.baidu.tbadk.core.util.au.dY(bnJ);
                if (com.baidu.tbadk.core.util.au.Bf(dY)) {
                    dY = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnJ);
                }
                this.eTu = dY;
            }
            if (bpU()) {
                bos();
            } else if (!this.eTE && this.eRz != null && this.eRz.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eRz.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eTu)) {
                    this.eTu += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eTu = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eTu) && !TextUtils.isEmpty(getAddress())) {
                this.eTu += " • " + getAddress();
            }
        }
    }

    private void bou() {
        if (boj() == null || boj().share_info == null || boj().share_info.share_user_count <= 0 || !bpm() || (this.eTa > 0 && this.eTb == 0)) {
            this.eTv = null;
            return;
        }
        int i = boj().share_info.share_user_count;
        if (i == 1) {
            this.eTv = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eTv = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.au.numberUniform(i)});
        }
    }

    private void bov() {
        this.eRn = boO();
        com.baidu.tieba.card.m.a(this, this.eRn, true);
    }

    private void bow() {
        this.eOy = boM();
    }

    private void box() {
        this.eTw = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnJ() * 1000);
    }

    private void boy() {
        this.eTx = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnJ());
    }

    public SpannableStringBuilder boz() {
        return this.eRm;
    }

    public boolean isTop() {
        return bnL() != 0;
    }

    public int boA() {
        if (this.eSq != null) {
            long bni = this.eSq.bni();
            long bnj = this.eSq.bnj();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bni) {
                return 1;
            }
            if (currentTimeMillis > bnj) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int boB() {
        if (boD() && this.eSa.size() >= 1) {
            b bVar = this.eSa.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int blz = bVar.blz();
            int blA = bVar.blA();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < blz) {
                return 4;
            }
            return currentTimeMillis > blA ? 2 : 1;
        }
        return -1;
    }

    public int boC() {
        if (!boD() || this.eSa.size() < 1 || this.eSa.get(0) == null) {
            return -1;
        }
        return this.eSa.get(0).bly();
    }

    public boolean boD() {
        return this.eRO == 1;
    }

    public String getActUrl() {
        return (!boD() || this.eSa.size() < 1 || this.eSa.get(0) == null) ? "" : this.eSa.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Ak(String str) {
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

    public SmartApp boE() {
        return this.eTr;
    }

    private void x(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && boG()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bnL() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bnL() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bnN() == 1 || this.eRy.bqj() != 0) {
                if (bnw() != null && getThreadType() == 41) {
                    if (boA() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && boZ()) {
                Integer num = eSf.get(Integer.valueOf(boA()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bnM() == 1 && !isTop() && eQK != getType() && eQT != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eRL != null && this.eRL.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bnV() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eSe.get(new Point(boC(), boB()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bob() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (boc() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Ak(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eRg));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder boJ = boJ();
        if (boJ != null) {
            spannableStringBuilder.append((CharSequence) boJ);
        }
        this.eRm = spannableStringBuilder;
    }

    public boolean boF() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bnQ() != null) {
            if (bnQ().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bnQ().getGender() == 2) {
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

    private boolean boG() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void y(boolean z, boolean z2) {
        e(z, z2, true);
    }

    public void e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.y.getCount(b(z, z2, z3, false)) > 0) {
            z(z, z3);
            return;
        }
        SpannableStringBuilder boJ = boJ();
        if (z) {
            spannableStringBuilder = a(boJ.toString(), boJ, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(boJ);
        }
        this.eRm = spannableStringBuilder;
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
            if (this.eRh == 1) {
                this.eRm = a2;
                return a2;
            }
        } else if (this.eRh == 1) {
            this.eRm = new SpannableStringBuilder();
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

    public void dD(String str, String str2) {
        this.mUrl = str;
        this.eSv = str2;
    }

    public String boH() {
        return this.mUrl;
    }

    public String boI() {
        return this.eSv;
    }

    public SpannableStringBuilder boJ() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eRj, this.title);
    }

    public SpannableStringBuilder boK() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eRk, this.eRi);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> boL() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eTP) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString boM() {
        SpannableStringBuilder boK = boK();
        com.baidu.tieba.card.m.a(this, boK, false);
        return new SpannableString(boK);
    }

    public SpannableString boN() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eRl)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eRl, this.eRi));
    }

    public String getAbstract() {
        return this.eRi;
    }

    public void Al(String str) {
        this.eRi = str;
    }

    public SpannableStringBuilder f(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder boJ;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eRh == 1) {
            boJ = boK();
            spannableStringBuilder = boJ.toString();
        } else {
            boJ = boJ();
            spannableStringBuilder = boJ.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, boJ, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(boJ);
        }
        this.eRm = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder z(boolean z, boolean z2) {
        return f(z, z2, false);
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        SpannableStringBuilder boK;
        if (!StringUtils.isNull(this.title) && this.eRh != 1) {
            boK = boJ();
        } else {
            boK = boK();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(boK);
        this.eRm = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder boO() {
        if (StringUtils.isNull(this.title) || this.eRh == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(boJ());
        this.eRm = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bmu() {
        if (this.eRj != null && this.eRj.size() > 0) {
            int size = this.eRj.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eRj.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bmv() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.DB(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void boP() {
        x(false, false);
    }

    public void boQ() {
        x(false, true);
    }

    public AnchorInfoData boR() {
        return this.eRL;
    }

    public boolean boS() {
        return this.threadType == 36;
    }

    public boolean bmv() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean boT() {
        return this.threadType == 11 || this.eRI == 1;
    }

    public boolean boU() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bnZ = bnZ();
        if (bnZ == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bnZ.size() || i2 >= 3) {
                break;
            }
            if (bnZ.get(i2) != null && bnZ.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bnZ.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bnZ.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bnZ.get(i2).getPicUrl();
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
        if (this.eRR != null && !StringUtils.isNull(this.eRR.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eRR.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eRz != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eRz.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean boV() {
        String userId;
        return this.eRz == null || (userId = this.eRz.getUserId()) == null || userId.equals("0");
    }

    public boolean boW() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eUi != null) {
            return this.eUi.dNq() ? (this.eUi.dNp() == null && this.eUi.dNr()) ? AdvertAppInfo.eLl : AdvertAppInfo.eLm : this.eUi.dNp() != null ? AdvertAppInfo.eLk : AdvertAppInfo.eLl;
        } else if (bpH()) {
            if (boh() != null) {
                return eQK;
            }
            return eQm;
        } else {
            int bnL = bnL();
            if (this.eTf == 1) {
                if (this.eTg != null) {
                    return eQA;
                }
                return this.eTj != null ? eQV : eQU;
            } else if (this.eRU != null && this.threadType == 60) {
                return eQN;
            } else {
                if (this.eRU != null && this.threadType == 49) {
                    return eQL;
                }
                if (this.eRU != null && this.threadType == 67) {
                    return eQO;
                }
                if (this.threadType == 51) {
                    return eQM;
                }
                if (this.threadType == 63) {
                    return eQW;
                }
                if (this.threadType == 64) {
                    return eQX;
                }
                if (bnL == 2 || bnL == 1) {
                    return eQl;
                }
                if (this.eRR != null && bpf() && !boW()) {
                    return eRc;
                }
                if (this.eRR != null && !boW()) {
                    if (bnT()) {
                        return eQT;
                    }
                    if (this instanceof aw) {
                        return eRd;
                    }
                    return eQK;
                } else if (this.isShareThread && this.eTc != null) {
                    if (this.eTc.eOz) {
                        if (this.eTc.videoInfo != null) {
                            return eQS;
                        }
                        if (this.eTc.bmx()) {
                            return eQR;
                        }
                        return eQQ;
                    }
                    return eQP;
                } else if (bmx()) {
                    return eQB;
                } else {
                    if (boY()) {
                        return eQZ.get() ? eSp : eQm;
                    } else if (boD() && boC() == 1) {
                        return eQZ.get() ? eSx : eQm;
                    } else if (isLinkThread()) {
                        return eQI;
                    } else {
                        if (bnT()) {
                            return eQJ;
                        }
                        if (this.ePR) {
                            return eQs;
                        }
                        if (this.ePS) {
                            return eQt;
                        }
                        if (this.ePT) {
                            return eQu;
                        }
                        if (this.ePU) {
                            return eQv;
                        }
                        if (this.ePV) {
                            return eQw;
                        }
                        if (this.ePX) {
                            return eQy;
                        }
                        if (this.ePY) {
                            return eQz;
                        }
                        if (this.ePW) {
                            return eQx;
                        }
                        if (this.eQH) {
                            return eQD;
                        }
                        if (this.eRY) {
                            int boX = boX();
                            if (boX == 1) {
                                return eQo;
                            }
                            if (boX == 2) {
                                return eQp;
                            }
                            if (boX > 2) {
                                return eQq;
                            }
                            return eQm;
                        }
                        return eQm;
                    }
                }
            }
        }
    }

    public int boX() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bkT().isShowImages() || com.baidu.tbadk.core.util.y.getCount(bnZ()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bnZ().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bnZ(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean boY() {
        return bnw() != null && getThreadType() == 41 && bnN() == 1 && boA() == 2;
    }

    public void A(ArrayList<u> arrayList) {
        if (this.eRh == 1) {
            this.eMK = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eMK = 0;
        } else {
            this.eMK = 0;
            Iterator<u> it = arrayList.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next != null && next.blP() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.blP().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eMK = next.blQ();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean boZ() {
        return this.threadType == 41;
    }

    public boolean bpa() {
        return this.eSy;
    }

    public void jx(boolean z) {
        this.eSy = z;
    }

    public String bpb() {
        return this.eSz;
    }

    public t bpc() {
        return this.eSd;
    }

    public void bpd() {
        if (this.eRW == 0) {
            this.eRW = 1;
        }
    }

    public boolean bpe() {
        return this.eSC;
    }

    public void jy(boolean z) {
        this.eSL = z;
    }

    public boolean bpf() {
        return this.eSL;
    }

    public void nq(int i) {
        this.eSM = i + 1;
    }

    public int bpg() {
        return this.eSM;
    }

    public boolean bph() {
        return this.eTC;
    }

    public void jz(boolean z) {
        this.eTC = z;
    }

    public ci bpi() {
        return this.eRT;
    }

    public boolean bpj() {
        return getThreadType() == 49;
    }

    public boolean bpk() {
        return getThreadType() == 40;
    }

    public boolean bpl() {
        return getThreadType() == 50;
    }

    public boolean bpm() {
        return getThreadType() == 60;
    }

    public int bpn() {
        return this.eSS;
    }

    public void setSmartFrsPosition(int i) {
        this.eSS = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bpo() {
        return this.mRecomSource;
    }

    public boolean bpp() {
        return this.eST;
    }

    public long bpq() {
        return this.agreeData.agreeNum;
    }

    public long bpr() {
        return this.agreeData.disAgreeNum;
    }

    public int bps() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bpt() {
        return this.agreeData.agreeType;
    }

    public void nr(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void ns(int i) {
        this.agreeData.agreeNum = i;
    }

    public void dN(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dO(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void nt(int i) {
        this.agreeData.agreeType = i;
    }

    public long bpu() {
        return this.eSV;
    }

    public void dP(long j) {
        this.eSV = j;
    }

    public PostData bpv() {
        return this.eSU;
    }

    public ap bpw() {
        return this.eSW;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean bnR = bnR();
        if (z2) {
            if (z) {
                if (bnR && !bmv()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (bnN() == 1 || getThreadType() == 33 || (bnP() != null && bnP().bqj() != 0)) {
                    if (bnw() != null && boZ()) {
                        if (boA() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!bnR) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (boZ()) {
                    arrayList.add(eSP.get(boA()));
                }
                if (boD()) {
                    Integer num = eSO.get(new Point(boC(), boB()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (bob() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (bnR && bnL() != 1 && !bmv()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((bnN() == 1 || getThreadType() == 33) && !boZ() && !bnR) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (bnM() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bnL() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (boZ() && bnw() != null && boA() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (boD()) {
                    Integer num2 = eSO.get(new Point(boC(), boB()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.eSA == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (boc() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (bob() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bpj()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bpl()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bpk()) {
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
        this.eRC = arrayList;
    }

    public void C(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eRD = arrayList;
    }

    public String bpx() {
        return this.eTh;
    }

    public void Am(String str) {
        this.eTh = str;
    }

    public void bpy() {
        this.eTf = 1;
    }

    public boolean bpz() {
        return this.eTf == 1;
    }

    public String bpA() {
        return this.eRp;
    }

    public void An(String str) {
        this.eRp = str;
    }

    public String bpB() {
        return this.eRq;
    }

    public void Ao(String str) {
        this.eRq = str;
    }

    public String bpC() {
        return this.eTi;
    }

    public void Ap(String str) {
        this.eTi = str;
    }

    public boolean bpD() {
        return this.eTl;
    }

    public void jA(boolean z) {
        this.eTl = z;
    }

    public boolean bpE() {
        return this.eTm;
    }

    public void jB(boolean z) {
        this.eTm = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eTj = videoInfo;
    }

    public boolean bpF() {
        return this.eTn != null;
    }

    public bx bpG() {
        return this.eRo;
    }

    public boolean bpH() {
        return this.eTq;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eRR != null) {
            return this.eRR.video_url;
        }
        return null;
    }

    public boolean bpI() {
        return this.eTs;
    }

    public void jC(boolean z) {
        this.eTs = z;
    }

    public AgreeData bpJ() {
        return this.agreeData;
    }

    public boolean bpK() {
        return this.eTF;
    }

    public void jD(boolean z) {
        this.eTF = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean blu() {
        return this.eTD;
    }

    public void jE(boolean z) {
        this.eTD = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bpL() {
        return this.eTg;
    }

    public String getShareImageUrl() {
        return this.eTy;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int i2;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bnZ = bnZ();
        if (com.baidu.tbadk.core.k.bkT().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bnZ) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < bnZ.size(); i4++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bnZ, i4);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(bnZ, 0);
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

    public boolean bpM() {
        return bpN() || bpO();
    }

    public boolean bmx() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bmy() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bpN() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bpO() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bmz() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bmz();
    }

    public void nu(int i) {
        this.isBjh = i;
    }

    public int bpP() {
        return this.eTO;
    }

    public String bpQ() {
        return this.eTN;
    }

    public void Aq(String str) {
        this.eTN = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bpR() {
        if (bnS()) {
            return 4;
        }
        if (bpj() || bpl()) {
            return 3;
        }
        if (bmx()) {
            return 5;
        }
        if (bmy()) {
            return 6;
        }
        if (bpN()) {
            return 7;
        }
        if (bpO()) {
            return 8;
        }
        if (this.isShareThread && this.eTc != null) {
            return 9;
        }
        if (bpk()) {
            return 2;
        }
        return 1;
    }

    public int bpS() {
        if (bpO() || bpN()) {
            return 2;
        }
        if (bmx() || bmy()) {
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

    public ThreadInfo bpT() {
        return this.eTS;
    }

    public String bmo() {
        return this.eTz;
    }

    public boolean bpU() {
        return this.eRz != null && this.eRz.isNewGod();
    }

    public boolean bpV() {
        return (bnQ() == null || bnQ().getAlaUserData() == null || bnQ().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bpW() {
        return this.eTW;
    }

    public List<HeadItem> bpX() {
        return this.eTX;
    }

    public void a(Item item) {
        this.eTW = item;
    }

    public void bt(List<HeadItem> list) {
        this.eTX = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bpY() {
        return this.eTY;
    }

    public void b(PollData pollData) {
        this.eTY = pollData;
    }

    public List<PbLinkData> bpZ() {
        return this.eTT;
    }

    public void bu(List<PbLinkData> list) {
        this.eTT = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eTT)) {
            for (PbLinkData pbLinkData : this.eTT) {
                if (pbLinkData.urlType == 2 && !this.eTV) {
                    this.eTV = true;
                }
            }
        }
    }

    public List<PbGoodsData> bqa() {
        return this.eTU;
    }

    public void bv(List<PbGoodsData> list) {
        this.eTU = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eTV) {
            this.eTV = true;
        }
    }

    public boolean bqb() {
        return this.eTV;
    }

    public boolean bqc() {
        return this.eRz != null && this.eRz.isForumBusinessAccount();
    }
}

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
    public String buttonText;
    private String bwo;
    public int eOa;
    public int ePT;
    private SpannableString ePZ;
    private int eSI;
    private SpannableStringBuilder eSN;
    private SpannableStringBuilder eSO;
    private bx eSP;
    private String eSQ;
    private String eSR;
    private t eTE;
    private LiveCoverStatus eTK;
    private long eTL;
    public TwZhiBoUser eTS;
    public List<TwAnchorProfitItem> eTT;
    private SkinInfo eTX;
    private boolean eTZ;
    public int eTf;
    private int eTg;
    private int eTj;
    public int eTk;
    private String eTn;
    private String eTo;
    private int eTq;
    private VideoInfo eTs;
    private VideoDesc eTt;
    private ci eTu;
    private AlaInfoData eTv;
    private long eTw;
    private MediaData eUA;
    public int eUB;
    public OriginalThreadInfo eUD;
    private TopicModule eUH;
    private String eUI;
    private String eUJ;
    private VideoInfo eUK;
    private String eUL;
    private boolean eUN;
    public OriginalForumInfo eUO;
    public boolean eUP;
    private String eUQ;
    private boolean eUR;
    private SmartApp eUS;
    private String eUU;
    private String eUV;
    private String eUW;
    private String eUX;
    private String eUY;
    public String eUZ;
    private String eUa;
    private boolean eUd;
    public String eUf;
    public int eUg;
    public int eUh;
    public String eUi;
    public String eUj;
    public long eUk;
    private List<ReportInfo> eUo;
    private boolean eUu;
    private long eUw;
    private ap eUx;
    public g eUz;
    public int eVB;
    public String eVC;
    public String eVD;
    public String eVE;
    public com.baidu.tieba.tbadkCore.data.n eVH;
    private String eVa;
    private boolean eVd;
    private boolean eVe;
    public boolean eVf;
    public boolean eVg;
    public boolean eVh;
    public boolean eVi;
    public boolean eVj;
    public boolean eVk;
    public boolean eVl;
    public String eVm;
    public String eVn;
    private String eVo;
    private int eVp;
    public String eVr;
    private String eVs;
    private ThreadInfo eVt;
    private boolean eVw;
    private Item eVx;
    private List<HeadItem> eVy;
    PollData eVz;
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
    public static final BdUniqueId eRM = BdUniqueId.gen();
    public static final BdUniqueId eRN = BdUniqueId.gen();
    public static final BdUniqueId eRO = BdUniqueId.gen();
    public static final BdUniqueId eRP = BdUniqueId.gen();
    public static final BdUniqueId eRQ = BdUniqueId.gen();
    public static final BdUniqueId eRR = BdUniqueId.gen();
    public static final BdUniqueId eRS = BdUniqueId.gen();
    public static final BdUniqueId eRT = BdUniqueId.gen();
    public static final BdUniqueId eRU = BdUniqueId.gen();
    public static final BdUniqueId eRV = BdUniqueId.gen();
    public static final BdUniqueId eRW = BdUniqueId.gen();
    public static final BdUniqueId eRX = BdUniqueId.gen();
    public static final BdUniqueId eRY = BdUniqueId.gen();
    public static final BdUniqueId eRZ = BdUniqueId.gen();
    public static final BdUniqueId eSa = BdUniqueId.gen();
    public static final BdUniqueId eSb = BdUniqueId.gen();
    public static final BdUniqueId eSc = BdUniqueId.gen();
    public static final BdUniqueId eSd = BdUniqueId.gen();
    public static final BdUniqueId eSe = BdUniqueId.gen();
    public static final BdUniqueId eSf = BdUniqueId.gen();
    public static final BdUniqueId eSg = BdUniqueId.gen();
    public static final BdUniqueId eSh = BdUniqueId.gen();
    public static final BdUniqueId eSj = BdUniqueId.gen();
    public static final BdUniqueId eSk = BdUniqueId.gen();
    public static final BdUniqueId eSl = BdUniqueId.gen();
    public static final BdUniqueId eSm = BdUniqueId.gen();
    public static final BdUniqueId eSn = BdUniqueId.gen();
    public static final BdUniqueId eSo = BdUniqueId.gen();
    public static final BdUniqueId eSp = BdUniqueId.gen();
    public static final BdUniqueId eSq = BdUniqueId.gen();
    public static final BdUniqueId eSr = BdUniqueId.gen();
    public static final BdUniqueId eSs = BdUniqueId.gen();
    public static final BdUniqueId eSt = BdUniqueId.gen();
    public static final BdUniqueId eSu = BdUniqueId.gen();
    public static final BdUniqueId eSv = BdUniqueId.gen();
    public static final BdUniqueId eSw = BdUniqueId.gen();
    public static final BdUniqueId eSx = BdUniqueId.gen();
    public static final BdUniqueId eSy = BdUniqueId.gen();
    public static final BdUniqueId eSz = BdUniqueId.gen();
    public static AtomicBoolean eSA = new AtomicBoolean(false);
    public static AtomicBoolean eSB = new AtomicBoolean(false);
    public static AtomicBoolean eSC = new AtomicBoolean(false);
    public static final BdUniqueId eSD = BdUniqueId.gen();
    public static final BdUniqueId eSE = BdUniqueId.gen();
    private static HashMap<Point, Integer> eTF = new HashMap<>();
    private static HashMap<Integer, Integer> eTG = new HashMap<>();
    public static final BdUniqueId eTQ = BdUniqueId.gen();
    public static final BdUniqueId eTY = BdUniqueId.gen();
    private static HashMap<Point, Integer> eUp = new HashMap<>();
    private static SparseArray<m.a> eUq = new SparseArray<>(3);
    public boolean eRs = false;
    public boolean eRt = false;
    public boolean eRu = false;
    public boolean eRv = false;
    public boolean eRw = false;
    public boolean eRx = false;
    public boolean eRy = false;
    public boolean eRz = false;
    public boolean eSi = false;
    private int eSF = 0;
    private String eSG = "1";
    public int eSH = 1;
    private String eTi = null;
    private int eOl = 0;
    public int eTx = 0;
    private String eTy = "";
    public boolean eTz = false;
    private String eTH = "";
    public boolean eUl = true;
    public boolean eUr = false;
    public boolean eUs = false;
    private int eUt = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ePP = null;
    public boolean eUy = false;
    private int eUG = 0;
    private boolean eUM = false;
    private boolean eUT = false;
    public boolean eVb = false;
    public boolean eVc = false;
    public boolean forbidComment = false;
    public boolean eVq = false;
    public boolean eVF = false;
    public boolean eVG = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eSS = 0;
    private int eST = 0;
    private String last_time = null;
    private long eSU = 0;
    private int eSV = 0;
    private int eSW = 0;
    private int eSX = 0;
    private int eSY = 0;
    private cf eSZ = new cf();
    private MetaData eTa = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eTd = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eTe = new ArrayList<>();
    private int eTb = 0;
    private int eTc = 0;
    private String ad_url = null;
    private String eSJ = null;
    private String from = null;
    private int eTh = 0;
    private PraiseData eTl = new PraiseData();
    private AnchorInfoData eTm = new AnchorInfoData();
    private long time = 0;
    private int eTp = 0;
    private ArrayList<b> eTB = new ArrayList<>();
    private cn eTC = null;
    private h eTD = null;
    private int eTI = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eTr = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eTJ = null;
    private int eTA = 0;
    private boolean eTM = false;
    private boolean eTN = false;
    private int eTO = 0;
    private boolean eTP = false;
    private int anchorLevel = 0;
    public int eUb = 0;
    public q eUc = new q();
    private List<PbContent> eSM = new ArrayList();
    private List<PbContent> eSK = new ArrayList();
    private List<PbContent> eSL = new ArrayList();
    private String category_name = null;
    private bz eTR = new bz();
    private ArrayList<com.baidu.tbadk.data.c> eTU = new ArrayList<>();
    private PushStatusData eTV = new PushStatusData();
    public boolean eUm = false;
    public int eUn = -1;
    private PostData eUv = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eUe = 0;
    public int eUC = 0;
    private String tieba_game_information_source = "";
    public String eUF = "";
    public String eUE = "";
    private String mUrl = "";
    private String eTW = "";
    private List<PbLinkData> eVu = new ArrayList();
    private List<PbGoodsData> eVv = new ArrayList();
    public int eVA = -1;

    static {
        eTF.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eTF.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eTF.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eTF.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eTF.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eTF.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eTF.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eTF.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eUp.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eUp.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eUp.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eUp.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eUp.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eUp.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eUp.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eUp.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eTG.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eTG.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eTG.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eUq.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eUq.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eUq.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public cb() {
        this.eTg = 0;
        this.eTq = 0;
        this.eTL = 0L;
        this.eUB = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eTL = 0L;
        this.eTq = 0;
        this.eTg = 0;
        this.eUB = 0;
    }

    public String bnp() {
        return this.eUU;
    }

    public String bnq() {
        return this.eUV;
    }

    public void Am(String str) {
        this.eUV = str;
    }

    public String bnr() {
        return this.eUW;
    }

    public SpannableStringBuilder bns() {
        return this.eSO;
    }

    public SpannableString bnt() {
        return this.ePZ;
    }

    public void a(SpannableString spannableString) {
        if (bnS() != null && !bly() && !blx()) {
            if (this.eSO != null) {
                this.eSO.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ePZ);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.ePZ = new SpannableString(spannableStringBuilder);
        }
    }

    public void bnu() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eVy) > 0) {
            if (this.eSO != null) {
                this.eSO.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bL(this.eVy));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ePZ);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bL(this.eVy));
            this.ePZ = new SpannableString(spannableStringBuilder);
        }
    }

    public String bnv() {
        return this.eUX;
    }

    public String bnw() {
        return this.eUY;
    }

    public boolean bnx() {
        return this.eTg == 1;
    }

    public bz bny() {
        return this.eTR;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void ni(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eTq;
    }

    public void nj(int i) {
        this.eTO = i;
    }

    public int bnz() {
        return this.eTO;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bnA() {
        return this.eUK;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dL(long j) {
        this.mCreateTime = j;
    }

    public long bnB() {
        return this.eTw;
    }

    public String bnC() {
        return this.eTn;
    }

    public PraiseData bnD() {
        return this.eTl;
    }

    public void a(PraiseData praiseData) {
        this.eTl = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bnE() {
        return this.bwo;
    }

    public void An(String str) {
        this.bwo = str;
    }

    public String bnF() {
        return this.eSG;
    }

    public void Ao(String str) {
        this.eSG = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nk(int i) {
        this.eSF = i;
    }

    public int bnG() {
        return this.eSF;
    }

    public String bnH() {
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

    public List<PbContent> bnI() {
        return this.eSM;
    }

    public void bq(List<PbContent> list) {
        this.eSM = list;
    }

    public void br(List<PbContent> list) {
        this.eSK = list;
    }

    public void bs(List<PbContent> list) {
        this.eSL = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nl(int i) {
        this.reply_num = i;
    }

    public int bnJ() {
        return this.reply_num;
    }

    public int bnK() {
        return this.eST;
    }

    public void nm(int i) {
        this.eST = i;
    }

    public long bnL() {
        return this.eSU;
    }

    public void dM(long j) {
        this.eSU = j;
    }

    public int bnM() {
        return this.eSW;
    }

    public int bnN() {
        return this.eSV;
    }

    public void nn(int i) {
        this.eSV = i;
    }

    public int bnO() {
        return this.eSX;
    }

    public void no(int i) {
        this.eSX = i;
    }

    public int bnP() {
        return this.eSY;
    }

    public List<PbContent> bnQ() {
        return this.eSK;
    }

    public cf bnR() {
        return this.eSZ;
    }

    public MetaData bnS() {
        return this.eTa;
    }

    public boolean bnT() {
        return this.is_god != 0;
    }

    public boolean bnU() {
        return this.is_god == 1;
    }

    public boolean bnV() {
        return (this.eTa == null || this.eTa.getGodUserData() == null || this.eTa.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eTa = metaData;
    }

    public String bnW() {
        return this.forum_name;
    }

    public void Ap(String str) {
        this.forum_name = str;
    }

    public int bnX() {
        return this.eTc;
    }

    public String bnY() {
        return this.ad_url;
    }

    public int bnZ() {
        return this.eTh;
    }

    public void np(int i) {
        this.eTh = i;
    }

    public String boa() {
        return this.eTi;
    }

    public void Aq(String str) {
        this.eTi = str;
    }

    public ArrayList<MediaData> bob() {
        return this.eTd;
    }

    public ArrayList<b> boc() {
        return this.eTB;
    }

    public void z(ArrayList<b> arrayList) {
        this.eTB = arrayList;
    }

    public cn bod() {
        return this.eTC;
    }

    public h boe() {
        return this.eTD;
    }

    public ArrayList<VoiceData.VoiceModel> bof() {
        return this.eTe;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bog() {
        return this.eSI;
    }

    public void nq(int i) {
        this.eSI = i;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String boh() {
        return this.eTo;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String boi() {
        return this.eTy;
    }

    public VideoInfo boj() {
        return this.eTs;
    }

    public void a(VideoInfo videoInfo) {
        this.eTs = videoInfo;
    }

    public VideoDesc bok() {
        return this.eTt;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eTv = alaInfoData;
    }

    public AlaInfoData bol() {
        return this.eTv;
    }

    public PushStatusData bom() {
        return this.eTV;
    }

    public SkinInfo bon() {
        return this.eTX;
    }

    public long boo() {
        return this.eUk;
    }

    public boolean bop() {
        return this.eUl;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        return this.eUj;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(blp().getTid());
        avVar.setFid(blp().getFid());
        avVar.setNid(blp().bmq());
        avVar.setFeedBackReasonMap(this.feedBackReasonMap);
        avVar.ePP = this.ePP;
        avVar.abTag = this.mRecomAbTag;
        avVar.weight = this.mRecomWeight;
        avVar.extra = this.mRecomExtra;
        avVar.source = this.mRecomSource;
        avVar.ePT = this.ePT;
        avVar.cardType = bpT();
        return avVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eTo = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eTg = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eTw = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eSS = threadInfo.repost_num.intValue();
                this.eST = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eSU = threadInfo.last_time_int.intValue();
                this.eSV = threadInfo.is_top.intValue();
                this.eSW = threadInfo.is_membertop.intValue();
                this.eSX = threadInfo.is_good.intValue();
                this.eSY = threadInfo.is_livepost.intValue();
                this.eSZ.a(threadInfo.topic);
                this.eTa.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eTb = threadInfo.has_commented.intValue();
                this.eTc = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eTs = threadInfo.video_info;
                this.eTt = threadInfo.video_segment;
                this.eTv = new AlaInfoData();
                this.eTv.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eTh = threadInfo.collect_status.intValue();
                this.eTi = threadInfo.collect_mark_pid;
                this.eTj = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eTk = threadInfo.thread_type.intValue();
                this.eTn = threadInfo.first_post_id + "";
                this.eTy = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eSI = threadInfo.is_ntitle.intValue();
                this.eTp = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eUw = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eTq = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eUd = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eSK = threadInfo.rich_title;
                this.eSM = threadInfo.first_post_content;
                this.eSL = threadInfo.rich_abstract;
                this.eTf = threadInfo.is_godthread_recommend.intValue();
                if ((this.eTa == null || this.eTa.getUserId() == null || this.eTa.getUserId().equals("0") || this.eVG) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTa = metaData;
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
                this.eSJ = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eTd.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eTs = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eTu = new ci();
                    this.eTu.a(threadInfo.video_channel_info);
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
                        this.eTe.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.eTB.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eTC = new cn();
                    this.eTC.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eTD = new h();
                    this.eTD.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eTE = new t();
                    this.eTE.a(threadInfo.cartoon_info);
                }
                this.eTl.setUserMap(this.userMap);
                this.eTl.parserProtobuf(threadInfo.zan);
                this.eTm.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eTl.setTitle(this.title);
                } else {
                    this.eTl.setTitle(this.eSJ);
                }
                this.eTH = threadInfo.livecover_src;
                this.eTI = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eTA = threadInfo.post_num.intValue();
                this.eTL = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qF(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Cy(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eTr.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eTJ = noticeInfo.notice;
                    }
                    this.eTO = zhiBoInfoTW.copythread_remind.intValue();
                    this.eTM = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eTN = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eTH)) {
                        this.eTH = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eTS = zhiBoInfoTW.user.tw_anchor_info;
                        this.eTT = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eTK = threadInfo.twzhibo_info.livecover_status;
                    this.eTL = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eTP = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eTR.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eTU.add(cVar2);
                    }
                }
                this.eTV.parserProtobuf(threadInfo.push_status);
                this.eUa = threadInfo.lego_card;
                this.eTX = threadInfo.skin_info;
                this.eUb = threadInfo.is_book_chapter.intValue();
                this.eUc.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eUj = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eUk = threadInfo.last_read_pid.longValue();
                this.eUl = threadInfo.cheak_repeat.intValue() == 1;
                this.eUo = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eUv.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.ePP = sparseArray2;
                }
                this.eUu = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eUx = new ap();
                    this.eUx.a(threadInfo.link_info);
                }
                this.eUy = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eUz = new g();
                    this.eUz.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eUA = new MediaData();
                    this.eUA.parserProtobuf(threadInfo.pic_info);
                }
                this.eUe = threadInfo.is_called.intValue();
                this.eUB = threadInfo.middle_page_num.intValue();
                this.eUC = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eUE = threadInfo.star_rank_icon.icon_pic_url;
                    this.eUF = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eUD = new OriginalThreadInfo();
                    this.eUD.a(threadInfo.origin_thread_info);
                } else {
                    this.eUD = null;
                    this.isShareThread = false;
                }
                this.eUG = threadInfo.is_topic.intValue();
                this.eUI = threadInfo.topic_user_name;
                this.eUJ = threadInfo.topic_h5_url;
                this.eUH = threadInfo.topic_module;
                this.eUL = threadInfo.presentation_style;
                this.eUO = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eUQ = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eSP = new bx();
                    this.eSP.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eUS = threadInfo.swan_info;
                }
                this.eUZ = threadInfo.t_share_img;
                this.eVa = threadInfo.nid;
                this.eVb = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eVo = threadInfo.article_cover;
                this.eVp = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eVq = threadInfo.is_s_card.intValue() == 1;
                this.eVr = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eVs = threadInfo.wonderful_post_info;
                boq();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eVt = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eVw) {
                            this.eVw = true;
                        }
                        this.eVu.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eVv.add(pbGoodsData);
                    }
                    if (this.eVv.size() > 0 && !this.eVw) {
                        this.eVw = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eVx = threadInfo.item;
                }
                if (this.eVx != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eVx);
                }
                this.eVy = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eVy)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eVy);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eVz == null) {
                        this.eVz = new PollData();
                    }
                    this.eVz.parserProtobuf(threadInfo.poll_info);
                }
                this.eVA = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eVB = threadInfo.distance.intValue();
                this.eVC = threadInfo.distance_text;
                this.isAuthorView = threadInfo.is_author_view.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(WriteData writeData) {
        String dPr;
        if (writeData != null) {
            try {
                this.id = "0";
                this.tid = "";
                this.fid = com.baidu.adp.lib.f.b.toLong(writeData.getForumId(), 0L);
                this.title = writeData.getTitle();
                this.mCreateTime = System.currentTimeMillis() / 1000;
                this.last_time = (System.currentTimeMillis() / 1000) + "";
                this.eSU = System.currentTimeMillis() / 1000;
                this.eTa = new MetaData();
                this.eTa.parseFromCurrentUser();
                this.authorId = TbadkCoreApplication.getCurrentAccount();
                this.forum_name = writeData.getForumName();
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
                if (com.baidu.tbadk.core.util.au.isEmpty(com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPr())) {
                    dPr = writeData.getVideoInfo().getThumbPath();
                } else {
                    dPr = com.baidu.tieba.tbadkCore.writeModel.a.dPl().dPr();
                }
                builder.thumbnail_url = dPr;
                builder.video_url = writeData.getVideoInfo().getVideoUrl();
                this.eTs = builder.build(true);
                this.threadType = 40;
                this.time = System.currentTimeMillis();
                this.eSI = writeData.isNoTitle() ? 1 : 0;
                this.eSJ = writeData.getContent();
                this.eSP = new bx();
                this.eSP.forumId = writeData.getForumId();
                this.eSP.forumName = writeData.getForumName();
                this.mTabId = writeData.getTabId();
                this.mTabName = writeData.getTabName();
                boq();
                if (!StringUtils.isNull(writeData.getItem_id()) && writeData.getItemInfo() != null) {
                    Item.Builder builder2 = new Item.Builder();
                    builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
                    builder2.icon_url = writeData.getItemInfo().getIconUrl();
                    builder2.item_name = writeData.getItemInfo().getTitle();
                    builder2.tags = writeData.getItemInfo().getTags();
                    builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
                    builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
                    this.eVx = builder2.build(true);
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
                this.eTw = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eSS = jSONObject.optInt("repost_num", 0);
                this.eST = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eSU = jSONObject.optLong("last_time_int", 0L);
                this.eSV = jSONObject.optInt("is_top", 0);
                this.eSW = jSONObject.optInt("is_membertop", 0);
                this.eSX = jSONObject.optInt("is_good", 0);
                this.eSY = jSONObject.optInt("is_livepost", 0);
                this.eSZ.parserJson(jSONObject.optJSONObject(AlbumActivityConfig.FROM_TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.eTa.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eTb = jSONObject.optInt("has_commented", 0);
                this.eTc = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eTh = jSONObject.optInt("collect_status");
                this.eTi = jSONObject.optString("collect_mark_pid");
                this.eTj = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eTk = jSONObject.optInt("thread_type");
                this.eUw = jSONObject.optLong("share_num");
                this.eTn = jSONObject.optString("first_post_id", "0");
                this.eTy = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eSI = jSONObject.optInt("is_ntitle");
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
                    this.ePP = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eTR.parserJson(optJSONObject2);
                }
                if ((this.eTa == null || this.eTa.getUserId() == null) && this.userMap != null) {
                    this.eTa = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.eTv = new AlaInfoData();
                this.eTv.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eSJ = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eTd.add(mediaData);
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
                        this.eTe.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eTB.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eTC = new cn();
                    this.eTC.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eTD = new h();
                    this.eTD.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eTE = new t();
                    this.eTE.parserJson(optJSONObject6);
                }
                this.eTl.setUserMap(this.userMap);
                this.eTl.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eTm.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eTl.setTitle(this.title);
                } else {
                    this.eTl.setTitle(this.eSJ);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eTR.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eTU.add(cVar);
                    }
                }
                this.eUb = jSONObject.optInt("is_book_chapter", 0);
                this.eUc.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eUj = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eUf = jSONObject.optString("recom_extra_img");
                this.eUi = jSONObject.optString("recom_extra_img_night");
                this.eUg = jSONObject.optInt("recom_extra_img_width", 0);
                this.eUh = jSONObject.optInt("recom_extra_img_height", 0);
                this.eUk = jSONObject.optLong("last_read_pid");
                this.eUl = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eTu = new ci();
                    this.eTu.dr(optJSONObject8);
                }
                this.eUu = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eUx = new ap();
                    this.eUx.parserJson(optJSONObject9);
                }
                this.eUy = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eUz = new g();
                    this.eUz.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eUA = new MediaData();
                    this.eUA.parserJson(optJSONObject11);
                }
                this.eUe = jSONObject.optInt("is_called", 0);
                this.eUB = jSONObject.optInt("middle_page_num", 0);
                this.eUC = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eTs = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eUD = new OriginalThreadInfo();
                        this.eUD.parserJson(optJSONObject13);
                    } else {
                        this.eUD = null;
                    }
                } else {
                    this.eUD = null;
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
                    this.eUS = builder2.build(false);
                }
                this.eUZ = jSONObject.optString("t_share_img");
                this.eVa = jSONObject.optString(IntentConfig.NID);
                this.eVb = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eVp = jSONObject.optInt("bjh_content_tag");
                this.eVo = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eVq = jSONObject.optInt("is_s_card", 0) == 1;
                this.eVr = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eVs = jSONObject.optString("wonderful_post_info");
                boq();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eVz == null) {
                        this.eVz = new PollData();
                    }
                    this.eVz.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eVw) {
                            this.eVw = true;
                        }
                        this.eVu.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eVv.add(pbGoodsData);
                    }
                    if (this.eVv.size() > 0 && !this.eVw) {
                        this.eVw = true;
                    }
                }
                this.eVA = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eVB = jSONObject.optInt("distance");
                this.eVC = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void boq() {
        bor();
        bot();
        bow();
        box();
        boy();
        boz();
        boA();
    }

    private void bor() {
        if (!StringUtils.isNull(this.eTa.getName_show())) {
            this.eUU = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eTa.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bos() {
        if (this.eTv != null) {
            if (this.eTv.openRecomDuration == 1 && this.mCreateTime > 0) {
                String ea = com.baidu.tbadk.core.util.au.ea(this.mCreateTime);
                if (!StringUtils.isNull(ea)) {
                    this.eUV = ea;
                }
            }
            if (this.eTv.openRecomFans == 1) {
                int i = 0;
                if (this.eTv != null && this.eTv.user_info != null) {
                    i = this.eTv.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eUV) && i > 0) {
                    this.eUV += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.au.ed(i);
                } else if (i > 0) {
                    this.eUV = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.au.ed(i);
                }
            }
        }
    }

    private void bot() {
        if ((this instanceof aw) && "0".equals(getId())) {
            this.eUV = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
        } else if (bmB() || (bpM() && getType() != eSm)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dY = com.baidu.tbadk.core.util.au.dY(j);
                if (com.baidu.tbadk.core.util.au.Bm(dY)) {
                    dY = com.baidu.tbadk.core.util.au.getFormatTimeShort(j);
                }
                this.eUV = dY;
            }
            String str = "";
            if (this.eTa != null && this.eTa.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eTa.getBaijiahaoInfo().auth_desc)) {
                str = this.eTa.getBaijiahaoInfo().auth_desc;
            }
            if (bpW()) {
                bou();
            } else if (!this.eVf && this.eTa != null && this.eTa.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eTa.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eUV)) {
                    this.eUV += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eUV = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eUV) && !TextUtils.isEmpty(str)) {
                this.eUV += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eUV = str;
            }
        } else if (getType() == eSm || getType() == eSp) {
            bos();
        } else {
            long bnL = bnL() * 1000;
            if (bnL != 0) {
                String dY2 = com.baidu.tbadk.core.util.au.dY(bnL);
                if (com.baidu.tbadk.core.util.au.Bm(dY2)) {
                    dY2 = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnL);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (blx()) {
                    dY2 = com.baidu.tbadk.core.util.au.dZ(bnL);
                }
                this.eUV = string + dY2;
            } else {
                long j2 = this.mCreateTime;
                String dY3 = com.baidu.tbadk.core.util.au.dY(j2);
                if (com.baidu.tbadk.core.util.au.Bm(dY3)) {
                    dY3 = com.baidu.tbadk.core.util.au.getFormatTimeShort(j2);
                }
                this.eUV = dY3;
            }
            if (bpW()) {
                bou();
            } else if (!this.eVf && this.eTa != null && this.eTa.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eTa.getBazhuGradeData().getDesc(), this.eVe ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eUV)) {
                    this.eUV += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eUV = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eUV) && !TextUtils.isEmpty(getAddress())) {
                this.eUV += " • " + getAddress();
            }
        }
    }

    private void bou() {
        if (bpW() && !TextUtils.isEmpty(this.eTa.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eUV)) {
                this.eUV += "   " + this.eTa.getNewGodData().getFieldName() + com.baidu.tbadk.util.aj.lA(this.eTa.getNewGodData().isVideoGod());
            } else {
                this.eUV = this.eTa.getNewGodData().getFieldName() + com.baidu.tbadk.util.aj.lA(this.eTa.getNewGodData().isVideoGod());
            }
        }
    }

    public void bov() {
        if (!bmB() && !bpM()) {
            long bnL = 1000 * bnL();
            if (bnL != 0) {
                String dY = com.baidu.tbadk.core.util.au.dY(bnL);
                if (com.baidu.tbadk.core.util.au.Bm(dY)) {
                    dY = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnL);
                }
                this.eUV = dY;
            }
            if (bpW()) {
                bou();
            } else if (!this.eVf && this.eTa != null && this.eTa.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eTa.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eUV)) {
                    this.eUV += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eUV = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eUV) && !TextUtils.isEmpty(getAddress())) {
                this.eUV += " • " + getAddress();
            }
        }
    }

    private void bow() {
        if (bol() == null || bol().share_info == null || bol().share_info.share_user_count <= 0 || !bpo() || (this.eUB > 0 && this.eUC == 0)) {
            this.eUW = null;
            return;
        }
        int i = bol().share_info.share_user_count;
        if (i == 1) {
            this.eUW = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eUW = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.au.numberUniform(i)});
        }
    }

    private void box() {
        this.eSO = boQ();
        com.baidu.tieba.card.m.a(this, this.eSO, true);
    }

    private void boy() {
        this.ePZ = boO();
    }

    private void boz() {
        this.eUX = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnL() * 1000);
    }

    private void boA() {
        this.eUY = com.baidu.tbadk.core.util.au.getFormatTimeShort(bnL());
    }

    public SpannableStringBuilder boB() {
        return this.eSN;
    }

    public boolean isTop() {
        return bnN() != 0;
    }

    public int boC() {
        if (this.eTR != null) {
            long bnk = this.eTR.bnk();
            long bnl = this.eTR.bnl();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bnk) {
                return 1;
            }
            if (currentTimeMillis > bnl) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int boD() {
        if (boF() && this.eTB.size() >= 1) {
            b bVar = this.eTB.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int blB = bVar.blB();
            int blC = bVar.blC();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < blB) {
                return 4;
            }
            return currentTimeMillis > blC ? 2 : 1;
        }
        return -1;
    }

    public int boE() {
        if (!boF() || this.eTB.size() < 1 || this.eTB.get(0) == null) {
            return -1;
        }
        return this.eTB.get(0).blA();
    }

    public boolean boF() {
        return this.eTp == 1;
    }

    public String getActUrl() {
        return (!boF() || this.eTB.size() < 1 || this.eTB.get(0) == null) ? "" : this.eTB.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Ar(String str) {
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

    public SmartApp boG() {
        return this.eUS;
    }

    private void x(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && boI()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bnN() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bnN() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bnP() == 1 || this.eSZ.bql() != 0) {
                if (bny() != null && getThreadType() == 41) {
                    if (boC() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bpb()) {
                Integer num = eTG.get(Integer.valueOf(boC()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bnO() == 1 && !isTop() && eSl != getType() && eSu != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eTm != null && this.eTm.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bnX() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eTF.get(new Point(boE(), boD()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bod() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (boe() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Ar(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eSH));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder boL = boL();
        if (boL != null) {
            spannableStringBuilder.append((CharSequence) boL);
        }
        this.eSN = spannableStringBuilder;
    }

    public boolean boH() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bnS() != null) {
            if (bnS().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bnS().getGender() == 2) {
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

    private boolean boI() {
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
        SpannableStringBuilder boL = boL();
        if (z) {
            spannableStringBuilder = a(boL.toString(), boL, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(boL);
        }
        this.eSN = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.eSI == 1) {
                this.eSN = a2;
                return a2;
            }
        } else if (this.eSI == 1) {
            this.eSN = new SpannableStringBuilder();
            return a2;
        }
        if (spannableStringBuilder != null) {
            a2.append((CharSequence) spannableStringBuilder);
            return a2;
        } else if (b.size() > 0 || a2.length() == 0) {
            a2.append((CharSequence) str);
            return a2;
        } else {
            return a2;
        }
    }

    public void dD(String str, String str2) {
        this.mUrl = str;
        this.eTW = str2;
    }

    public String boJ() {
        return this.mUrl;
    }

    public String boK() {
        return this.eTW;
    }

    public SpannableStringBuilder boL() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eSK, this.title);
    }

    public SpannableStringBuilder boM() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eSL, this.eSJ);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> boN() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eVq) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString boO() {
        SpannableStringBuilder boM = boM();
        com.baidu.tieba.card.m.a(this, boM, false);
        return new SpannableString(boM);
    }

    public SpannableString boP() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eSM)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eSM, this.eSJ));
    }

    public String getAbstract() {
        return this.eSJ;
    }

    public void As(String str) {
        this.eSJ = str;
    }

    public SpannableStringBuilder f(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder boL;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eSI == 1) {
            boL = boM();
            spannableStringBuilder = boL.toString();
        } else {
            boL = boL();
            spannableStringBuilder = boL.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, boL, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(boL);
        }
        this.eSN = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder z(boolean z, boolean z2) {
        return f(z, z2, false);
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        SpannableStringBuilder boM;
        if (!StringUtils.isNull(this.title) && this.eSI != 1) {
            boM = boL();
        } else {
            boM = boM();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(boM);
        this.eSN = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder boQ() {
        if (StringUtils.isNull(this.title) || this.eSI == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(boL());
        this.eSN = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bmw() {
        if (this.eSK != null && this.eSK.size() > 0) {
            int size = this.eSK.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eSK.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bmx() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.DI(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void boR() {
        x(false, false);
    }

    public void boS() {
        x(false, true);
    }

    public AnchorInfoData boT() {
        return this.eTm;
    }

    public boolean boU() {
        return this.threadType == 36;
    }

    public boolean bmx() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean boV() {
        return this.threadType == 11 || this.eTj == 1;
    }

    public boolean boW() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bob = bob();
        if (bob == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bob.size() || i2 >= 3) {
                break;
            }
            if (bob.get(i2) != null && bob.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bob.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bob.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bob.get(i2).getPicUrl();
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
        if (this.eTs != null && !StringUtils.isNull(this.eTs.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eTs.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eTa != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eTa.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean boX() {
        String userId;
        return this.eTa == null || (userId = this.eTa.getUserId()) == null || userId.equals("0");
    }

    public boolean boY() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eVH != null) {
            return this.eVH.dNx() ? this.eVH.dNy() ? AdvertAppInfo.eMM : AdvertAppInfo.eMN : this.eVH.dNy() ? AdvertAppInfo.eMM : AdvertAppInfo.eML;
        } else if (bpJ()) {
            if (boj() != null) {
                return eSl;
            }
            return eRN;
        } else {
            int bnN = bnN();
            if (this.eUG == 1) {
                if (this.eUH != null) {
                    return eSb;
                }
                return this.eUK != null ? eSw : eSv;
            } else if (this.eTv != null && this.threadType == 60) {
                return eSo;
            } else {
                if (this.eTv != null && this.threadType == 49) {
                    return eSm;
                }
                if (this.eTv != null && this.threadType == 67) {
                    return eSp;
                }
                if (this.threadType == 51) {
                    return eSn;
                }
                if (this.threadType == 63) {
                    return eSx;
                }
                if (this.threadType == 64) {
                    return eSy;
                }
                if (bnN == 2 || bnN == 1) {
                    return eRM;
                }
                if (this.eTs != null && bph() && !boY()) {
                    return eSD;
                }
                if (this.eTs != null && !boY()) {
                    if (bnV()) {
                        return eSu;
                    }
                    if (this instanceof aw) {
                        return eSE;
                    }
                    return eSl;
                } else if (this.isShareThread && this.eUD != null) {
                    if (this.eUD.eQa) {
                        if (this.eUD.videoInfo != null) {
                            return eSt;
                        }
                        if (this.eUD.bmz()) {
                            return eSs;
                        }
                        return eSr;
                    }
                    return eSq;
                } else if (bmz()) {
                    return eSc;
                } else {
                    if (bpa()) {
                        return eSA.get() ? eTQ : eRN;
                    } else if (boF() && boE() == 1) {
                        return eSA.get() ? eTY : eRN;
                    } else if (isLinkThread()) {
                        return eSj;
                    } else {
                        if (bnV()) {
                            return eSk;
                        }
                        if (this.eRs) {
                            return eRT;
                        }
                        if (this.eRt) {
                            return eRU;
                        }
                        if (this.eRu) {
                            return eRV;
                        }
                        if (this.eRv) {
                            return eRW;
                        }
                        if (this.eRw) {
                            return eRX;
                        }
                        if (this.eRy) {
                            return eRZ;
                        }
                        if (this.eRz) {
                            return eSa;
                        }
                        if (this.eRx) {
                            return eRY;
                        }
                        if (this.eSi) {
                            return eSe;
                        }
                        if (this.eTz) {
                            int boZ = boZ();
                            if (boZ == 1) {
                                return eRP;
                            }
                            if (boZ == 2) {
                                return eRQ;
                            }
                            if (boZ > 2) {
                                return eRR;
                            }
                            return eRN;
                        }
                        return eRN;
                    }
                }
            }
        }
    }

    public int boZ() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bkV().isShowImages() || com.baidu.tbadk.core.util.y.getCount(bob()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bob().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bob(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bpa() {
        return bny() != null && getThreadType() == 41 && bnP() == 1 && boC() == 2;
    }

    public void A(ArrayList<u> arrayList) {
        if (this.eSI == 1) {
            this.eOl = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eOl = 0;
        } else {
            this.eOl = 0;
            Iterator<u> it = arrayList.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next != null && next.blR() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.blR().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eOl = next.blS();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bpb() {
        return this.threadType == 41;
    }

    public boolean bpc() {
        return this.eTZ;
    }

    public void jx(boolean z) {
        this.eTZ = z;
    }

    public String bpd() {
        return this.eUa;
    }

    public t bpe() {
        return this.eTE;
    }

    public void bpf() {
        if (this.eTx == 0) {
            this.eTx = 1;
        }
    }

    public boolean bpg() {
        return this.eUd;
    }

    public void jy(boolean z) {
        this.eUm = z;
    }

    public boolean bph() {
        return this.eUm;
    }

    public void nr(int i) {
        this.eUn = i + 1;
    }

    public int bpi() {
        return this.eUn;
    }

    public boolean bpj() {
        return this.eVd;
    }

    public void jz(boolean z) {
        this.eVd = z;
    }

    public ci bpk() {
        return this.eTu;
    }

    public boolean bpl() {
        return getThreadType() == 49;
    }

    public boolean bpm() {
        return getThreadType() == 40;
    }

    public boolean bpn() {
        return getThreadType() == 50;
    }

    public boolean bpo() {
        return getThreadType() == 60;
    }

    public int bpp() {
        return this.eUt;
    }

    public void setSmartFrsPosition(int i) {
        this.eUt = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bpq() {
        return this.mRecomSource;
    }

    public boolean bpr() {
        return this.eUu;
    }

    public long bps() {
        return this.agreeData.agreeNum;
    }

    public long bpt() {
        return this.agreeData.disAgreeNum;
    }

    public int bpu() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bpv() {
        return this.agreeData.agreeType;
    }

    public void ns(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void nt(int i) {
        this.agreeData.agreeNum = i;
    }

    public void dN(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dO(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void nu(int i) {
        this.agreeData.agreeType = i;
    }

    public long bpw() {
        return this.eUw;
    }

    public void dP(long j) {
        this.eUw = j;
    }

    public PostData bpx() {
        return this.eUv;
    }

    public ap bpy() {
        return this.eUx;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean bnT = bnT();
        if (z2) {
            if (z) {
                if (bnT && !bmx()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (bnP() == 1 || getThreadType() == 33 || (bnR() != null && bnR().bql() != 0)) {
                    if (bny() != null && bpb()) {
                        if (boC() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!bnT) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (bpb()) {
                    arrayList.add(eUq.get(boC()));
                }
                if (boF()) {
                    Integer num = eUp.get(new Point(boE(), boD()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (bod() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (bnT && bnN() != 1 && !bmx()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((bnP() == 1 || getThreadType() == 33) && !bpb() && !bnT) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (bnO() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bnN() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (bpb() && bny() != null && boC() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (boF()) {
                    Integer num2 = eUp.get(new Point(boE(), boD()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.eUb == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (boe() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (bod() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bpl()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bpn()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bpm()) {
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
        this.eTd = arrayList;
    }

    public void C(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eTe = arrayList;
    }

    public String bpz() {
        return this.eUI;
    }

    public void At(String str) {
        this.eUI = str;
    }

    public void bpA() {
        this.eUG = 1;
    }

    public boolean bpB() {
        return this.eUG == 1;
    }

    public String bpC() {
        return this.eSQ;
    }

    public void Au(String str) {
        this.eSQ = str;
    }

    public String bpD() {
        return this.eSR;
    }

    public void Av(String str) {
        this.eSR = str;
    }

    public String bpE() {
        return this.eUJ;
    }

    public void Aw(String str) {
        this.eUJ = str;
    }

    public boolean bpF() {
        return this.eUM;
    }

    public void jA(boolean z) {
        this.eUM = z;
    }

    public boolean bpG() {
        return this.eUN;
    }

    public void jB(boolean z) {
        this.eUN = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eUK = videoInfo;
    }

    public boolean bpH() {
        return this.eUO != null;
    }

    public bx bpI() {
        return this.eSP;
    }

    public boolean bpJ() {
        return this.eUR;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eTs != null) {
            return this.eTs.video_url;
        }
        return null;
    }

    public boolean bpK() {
        return this.eUT;
    }

    public void jC(boolean z) {
        this.eUT = z;
    }

    public AgreeData bpL() {
        return this.agreeData;
    }

    public boolean bpM() {
        return this.eVg;
    }

    public void jD(boolean z) {
        this.eVg = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean blw() {
        return this.eVe;
    }

    public void jE(boolean z) {
        this.eVe = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bpN() {
        return this.eUH;
    }

    public String getShareImageUrl() {
        return this.eUZ;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int i2;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bob = bob();
        if (com.baidu.tbadk.core.k.bkV().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bob) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < bob.size(); i4++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bob, i4);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(bob, 0);
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

    public boolean bpO() {
        return bpP() || bpQ();
    }

    public boolean bmz() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bmA() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bpP() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bpQ() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bmB() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bmB();
    }

    public void nv(int i) {
        this.isBjh = i;
    }

    public int bpR() {
        return this.eVp;
    }

    public String bpS() {
        return this.eVo;
    }

    public void Ax(String str) {
        this.eVo = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bpT() {
        if (bnU()) {
            return 4;
        }
        if (bpl() || bpn()) {
            return 3;
        }
        if (bmz()) {
            return 5;
        }
        if (bmA()) {
            return 6;
        }
        if (bpP()) {
            return 7;
        }
        if (bpQ()) {
            return 8;
        }
        if (this.isShareThread && this.eUD != null) {
            return 9;
        }
        if (bpm()) {
            return 2;
        }
        return 1;
    }

    public int bpU() {
        if (bpQ() || bpP()) {
            return 2;
        }
        if (bmz() || bmA()) {
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

    public ThreadInfo bpV() {
        return this.eVt;
    }

    public String bmq() {
        return this.eVa;
    }

    public boolean bpW() {
        return this.eTa != null && this.eTa.isNewGod();
    }

    public boolean bpX() {
        return (bnS() == null || bnS().getAlaUserData() == null || bnS().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bpY() {
        return this.eVx;
    }

    public List<HeadItem> bpZ() {
        return this.eVy;
    }

    public void a(Item item) {
        this.eVx = item;
    }

    public void bt(List<HeadItem> list) {
        this.eVy = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bqa() {
        return this.eVz;
    }

    public void b(PollData pollData) {
        this.eVz = pollData;
    }

    public List<PbLinkData> bqb() {
        return this.eVu;
    }

    public void bu(List<PbLinkData> list) {
        this.eVu = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eVu)) {
            for (PbLinkData pbLinkData : this.eVu) {
                if (pbLinkData.urlType == 2 && !this.eVw) {
                    this.eVw = true;
                }
            }
        }
    }

    public List<PbGoodsData> bqc() {
        return this.eVv;
    }

    public void bv(List<PbGoodsData> list) {
        this.eVv = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eVw) {
            this.eVw = true;
        }
    }

    public boolean bqd() {
        return this.eVw;
    }

    public boolean bqe() {
        return this.eTa != null && this.eTa.isForumBusinessAccount();
    }
}

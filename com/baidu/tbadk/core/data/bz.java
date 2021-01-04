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
    public String buttonText;
    private String bvZ;
    public int eOY;
    public int eQR;
    private SpannableString eQX;
    private int eTG;
    private SpannableStringBuilder eTL;
    private SpannableStringBuilder eTM;
    private bv eTN;
    private String eTO;
    private String eTP;
    private s eUC;
    private LiveCoverStatus eUI;
    private long eUJ;
    public TwZhiBoUser eUQ;
    public List<TwAnchorProfitItem> eUR;
    private SkinInfo eUV;
    private boolean eUX;
    private String eUY;
    public int eUd;
    private int eUe;
    private int eUh;
    public int eUi;
    private String eUl;
    private String eUm;
    private int eUo;
    private VideoInfo eUq;
    private VideoDesc eUr;
    private cg eUs;
    private AlaInfoData eUt;
    private long eUu;
    public OriginalThreadInfo eVB;
    private TopicModule eVF;
    private String eVG;
    private String eVH;
    private VideoInfo eVI;
    private String eVJ;
    private boolean eVL;
    public OriginalForumInfo eVM;
    public boolean eVN;
    private String eVO;
    private boolean eVP;
    private SmartApp eVQ;
    private String eVS;
    private String eVT;
    private String eVU;
    private String eVV;
    private String eVW;
    public String eVX;
    private String eVY;
    private boolean eVb;
    public String eVd;
    public int eVe;
    public int eVf;
    public String eVg;
    public String eVh;
    public long eVi;
    private List<ReportInfo> eVm;
    private boolean eVs;
    private long eVu;
    private ao eVv;
    public f eVx;
    private MediaData eVy;
    public int eVz;
    public String eWA;
    public String eWB;
    public String eWC;
    public com.baidu.tieba.tbadkCore.data.n eWF;
    private boolean eWb;
    private boolean eWc;
    public boolean eWd;
    public boolean eWe;
    public boolean eWf;
    public boolean eWg;
    public boolean eWh;
    public boolean eWi;
    public String eWj;
    private String eWk;
    private int eWl;
    public String eWn;
    private String eWo;
    private ThreadInfo eWp;
    private boolean eWs;
    private Item eWt;
    private List<HeadItem> eWu;
    PollData eWv;
    public int eWx;
    public String eWy;
    public boolean eWz;
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
    public static final BdUniqueId eSK = BdUniqueId.gen();
    public static final BdUniqueId eSL = BdUniqueId.gen();
    public static final BdUniqueId eSM = BdUniqueId.gen();
    public static final BdUniqueId eSN = BdUniqueId.gen();
    public static final BdUniqueId eSO = BdUniqueId.gen();
    public static final BdUniqueId eSP = BdUniqueId.gen();
    public static final BdUniqueId eSQ = BdUniqueId.gen();
    public static final BdUniqueId eSR = BdUniqueId.gen();
    public static final BdUniqueId eSS = BdUniqueId.gen();
    public static final BdUniqueId eST = BdUniqueId.gen();
    public static final BdUniqueId eSU = BdUniqueId.gen();
    public static final BdUniqueId eSV = BdUniqueId.gen();
    public static final BdUniqueId eSW = BdUniqueId.gen();
    public static final BdUniqueId eSX = BdUniqueId.gen();
    public static final BdUniqueId eSY = BdUniqueId.gen();
    public static final BdUniqueId eSZ = BdUniqueId.gen();
    public static final BdUniqueId eTa = BdUniqueId.gen();
    public static final BdUniqueId eTb = BdUniqueId.gen();
    public static final BdUniqueId eTc = BdUniqueId.gen();
    public static final BdUniqueId eTd = BdUniqueId.gen();
    public static final BdUniqueId eTe = BdUniqueId.gen();
    public static final BdUniqueId eTf = BdUniqueId.gen();
    public static final BdUniqueId eTh = BdUniqueId.gen();
    public static final BdUniqueId eTi = BdUniqueId.gen();
    public static final BdUniqueId eTj = BdUniqueId.gen();
    public static final BdUniqueId eTk = BdUniqueId.gen();
    public static final BdUniqueId eTl = BdUniqueId.gen();
    public static final BdUniqueId eTm = BdUniqueId.gen();
    public static final BdUniqueId eTn = BdUniqueId.gen();
    public static final BdUniqueId eTo = BdUniqueId.gen();
    public static final BdUniqueId eTp = BdUniqueId.gen();
    public static final BdUniqueId eTq = BdUniqueId.gen();
    public static final BdUniqueId eTr = BdUniqueId.gen();
    public static final BdUniqueId eTs = BdUniqueId.gen();
    public static final BdUniqueId eTt = BdUniqueId.gen();
    public static final BdUniqueId eTu = BdUniqueId.gen();
    public static final BdUniqueId eTv = BdUniqueId.gen();
    public static final BdUniqueId eTw = BdUniqueId.gen();
    public static final BdUniqueId eTx = BdUniqueId.gen();
    public static AtomicBoolean eTy = new AtomicBoolean(false);
    public static AtomicBoolean eTz = new AtomicBoolean(false);
    public static AtomicBoolean eTA = new AtomicBoolean(false);
    public static final BdUniqueId eTB = BdUniqueId.gen();
    public static final BdUniqueId eTC = BdUniqueId.gen();
    private static HashMap<Point, Integer> eUD = new HashMap<>();
    private static HashMap<Integer, Integer> eUE = new HashMap<>();
    public static final BdUniqueId eUO = BdUniqueId.gen();
    public static final BdUniqueId eUW = BdUniqueId.gen();
    private static HashMap<Point, Integer> eVn = new HashMap<>();
    private static SparseArray<m.a> eVo = new SparseArray<>(3);
    public boolean eSq = false;
    public boolean eSr = false;
    public boolean eSs = false;
    public boolean eSt = false;
    public boolean eSu = false;
    public boolean eSv = false;
    public boolean eSw = false;
    public boolean eSx = false;
    public boolean eTg = false;
    private int eTD = 0;
    private String eTE = "1";
    public int eTF = 1;
    private String eUg = null;
    private int ePj = 0;
    public int eUv = 0;
    private String eUw = "";
    public boolean eUx = false;
    private String eUF = "";
    public boolean eVj = true;
    public boolean eVp = false;
    public boolean eVq = false;
    private int eVr = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eQN = null;
    public boolean eVw = false;
    private int eVE = 0;
    private boolean eVK = false;
    private boolean eVR = false;
    public boolean eVZ = false;
    public boolean eWa = false;
    public boolean forbidComment = false;
    public boolean eWm = false;
    public boolean eWD = false;
    public boolean eWE = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eTQ = 0;
    private int eTR = 0;
    private String last_time = null;
    private long eTS = 0;
    private int eTT = 0;
    private int eTU = 0;
    private int eTV = 0;
    private int eTW = 0;
    private cd eTX = new cd();
    private MetaData eTY = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eUb = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eUc = new ArrayList<>();
    private int eTZ = 0;
    private int eUa = 0;
    private String ad_url = null;
    private String eTH = null;
    private String from = null;
    private int eUf = 0;
    private PraiseData eUj = new PraiseData();
    private AnchorInfoData eUk = new AnchorInfoData();
    private long time = 0;
    private int eUn = 0;
    private ArrayList<b> eUz = new ArrayList<>();
    private cl eUA = null;
    private g eUB = null;
    private int eUG = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eUp = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eUH = null;
    private int eUy = 0;
    private boolean eUK = false;
    private boolean eUL = false;
    private int eUM = 0;
    private boolean eUN = false;
    private int anchorLevel = 0;
    public int eUZ = 0;
    public p eVa = new p();
    private List<PbContent> eTK = new ArrayList();
    private List<PbContent> eTI = new ArrayList();
    private List<PbContent> eTJ = new ArrayList();
    private String category_name = null;
    private bx eUP = new bx();
    private ArrayList<com.baidu.tbadk.data.c> eUS = new ArrayList<>();
    private PushStatusData eUT = new PushStatusData();
    public boolean eVk = false;
    public int eVl = -1;
    private PostData eVt = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eVc = 0;
    public int eVA = 0;
    private String tieba_game_information_source = "";
    public String eVD = "";
    public String eVC = "";
    private String mUrl = "";
    private String eUU = "";
    private List<PbLinkData> eWq = new ArrayList();
    private List<PbGoodsData> eWr = new ArrayList();
    public int eWw = -1;

    static {
        eUD.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eUD.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eUD.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eUD.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eUD.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eUD.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eUD.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eUD.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eVn.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eVn.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eVn.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eVn.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eVn.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eVn.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eVn.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eVn.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eUE.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eUE.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eUE.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eVo.put(1, new m.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eVo.put(2, new m.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eVo.put(3, new m.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public bz() {
        this.eUe = 0;
        this.eUo = 0;
        this.eUJ = 0L;
        this.eVz = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eUJ = 0L;
        this.eUo = 0;
        this.eUe = 0;
        this.eVz = 0;
    }

    public String bqN() {
        return this.eVS;
    }

    public String bqO() {
        return this.eVT;
    }

    public void Ba(String str) {
        this.eVT = str;
    }

    public String bqP() {
        return this.eVU;
    }

    public SpannableStringBuilder bqQ() {
        return this.eTM;
    }

    public SpannableString bqR() {
        return this.eQX;
    }

    public void a(SpannableString spannableString) {
        if (brq() != null && !boX() && !boW()) {
            if (this.eTM != null) {
                this.eTM.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eQX);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eQX = new SpannableString(spannableStringBuilder);
        }
    }

    public void bqS() {
        if (com.baidu.tbadk.core.util.x.getCount(this.eWu) > 0) {
            if (this.eTM != null) {
                this.eTM.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bQ(this.eWu));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eQX);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bQ(this.eWu));
            this.eQX = new SpannableString(spannableStringBuilder);
        }
    }

    public String bqT() {
        return this.eVV;
    }

    public String bqU() {
        return this.eVW;
    }

    public boolean bqV() {
        return this.eUe == 1;
    }

    public bx bqW() {
        return this.eUP;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void oK(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eUo;
    }

    public void oL(int i) {
        this.eUM = i;
    }

    public int bqX() {
        return this.eUM;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bqY() {
        return this.eVI;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dF(long j) {
        this.mCreateTime = j;
    }

    public long bqZ() {
        return this.eUu;
    }

    public String bra() {
        return this.eUl;
    }

    public PraiseData brb() {
        return this.eUj;
    }

    public void a(PraiseData praiseData) {
        this.eUj = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String brc() {
        return this.bvZ;
    }

    public void Bb(String str) {
        this.bvZ = str;
    }

    public String brd() {
        return this.eTE;
    }

    public void Bc(String str) {
        this.eTE = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void oM(int i) {
        this.eTD = i;
    }

    public int bre() {
        return this.eTD;
    }

    public String brf() {
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

    public List<PbContent> brg() {
        return this.eTK;
    }

    public void bv(List<PbContent> list) {
        this.eTK = list;
    }

    public void bw(List<PbContent> list) {
        this.eTI = list;
    }

    public void bx(List<PbContent> list) {
        this.eTJ = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void oN(int i) {
        this.reply_num = i;
    }

    public int brh() {
        return this.reply_num;
    }

    public int bri() {
        return this.eTR;
    }

    public void oO(int i) {
        this.eTR = i;
    }

    public long brj() {
        return this.eTS;
    }

    public void dG(long j) {
        this.eTS = j;
    }

    public int brk() {
        return this.eTU;
    }

    public int brl() {
        return this.eTT;
    }

    public void oP(int i) {
        this.eTT = i;
    }

    public int brm() {
        return this.eTV;
    }

    public void oQ(int i) {
        this.eTV = i;
    }

    public int brn() {
        return this.eTW;
    }

    public List<PbContent> bro() {
        return this.eTI;
    }

    public cd brp() {
        return this.eTX;
    }

    public MetaData brq() {
        return this.eTY;
    }

    public boolean brr() {
        return this.is_god != 0;
    }

    public boolean brs() {
        return this.is_god == 1;
    }

    public boolean brt() {
        return (this.eTY == null || this.eTY.getGodUserData() == null || this.eTY.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eTY = metaData;
    }

    public String bru() {
        return this.forum_name;
    }

    public void Bd(String str) {
        this.forum_name = str;
    }

    public int brv() {
        return this.eUa;
    }

    public String brw() {
        return this.ad_url;
    }

    public int brx() {
        return this.eUf;
    }

    public void oR(int i) {
        this.eUf = i;
    }

    public String bry() {
        return this.eUg;
    }

    public void Be(String str) {
        this.eUg = str;
    }

    public ArrayList<MediaData> brz() {
        return this.eUb;
    }

    public ArrayList<b> brA() {
        return this.eUz;
    }

    public void E(ArrayList<b> arrayList) {
        this.eUz = arrayList;
    }

    public cl brB() {
        return this.eUA;
    }

    public g brC() {
        return this.eUB;
    }

    public ArrayList<VoiceData.VoiceModel> brD() {
        return this.eUc;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int brE() {
        return this.eTG;
    }

    public void oS(int i) {
        this.eTG = i;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String brF() {
        return this.eUm;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String brG() {
        return this.eUw;
    }

    public VideoInfo brH() {
        return this.eUq;
    }

    public void a(VideoInfo videoInfo) {
        this.eUq = videoInfo;
    }

    public VideoDesc brI() {
        return this.eUr;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eUt = alaInfoData;
    }

    public AlaInfoData brJ() {
        return this.eUt;
    }

    public PushStatusData brK() {
        return this.eUT;
    }

    public SkinInfo brL() {
        return this.eUV;
    }

    public long brM() {
        return this.eVi;
    }

    public boolean brN() {
        return this.eVj;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boO() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String boP() {
        return this.eVh;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boQ() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(boO().getTid());
        atVar.setFid(boO().getFid());
        atVar.setNid(boO().bpO());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.eQN = this.eQN;
        atVar.abTag = this.mRecomAbTag;
        atVar.weight = this.mRecomWeight;
        atVar.extra = this.mRecomExtra;
        atVar.source = this.mRecomSource;
        atVar.eQR = this.eQR;
        atVar.cardType = bts();
        return atVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eUm = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eUe = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eUu = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eTQ = threadInfo.repost_num.intValue();
                this.eTR = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eTS = threadInfo.last_time_int.intValue();
                this.eTT = threadInfo.is_top.intValue();
                this.eTU = threadInfo.is_membertop.intValue();
                this.eTV = threadInfo.is_good.intValue();
                this.eTW = threadInfo.is_livepost.intValue();
                this.eTX.a(threadInfo.topic);
                this.eTY.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eTZ = threadInfo.has_commented.intValue();
                this.eUa = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eUq = threadInfo.video_info;
                this.eUr = threadInfo.video_segment;
                this.eUt = new AlaInfoData();
                this.eUt.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eUf = threadInfo.collect_status.intValue();
                this.eUg = threadInfo.collect_mark_pid;
                this.eUh = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eUi = threadInfo.thread_type.intValue();
                this.eUl = threadInfo.first_post_id + "";
                this.eUw = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eTG = threadInfo.is_ntitle.intValue();
                this.eUn = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eVu = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eUo = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eVb = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eTI = threadInfo.rich_title;
                this.eTK = threadInfo.first_post_content;
                this.eTJ = threadInfo.rich_abstract;
                this.eUd = threadInfo.is_godthread_recommend.intValue();
                if ((this.eTY == null || this.eTY.getUserId() == null || this.eTY.getUserId().equals("0") || this.eWE) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eTY = metaData;
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
                this.eTH = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eUb.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eUq = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eUs = new cg();
                    this.eUs.a(threadInfo.video_channel_info);
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
                        this.eUc.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.eUz.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eUA = new cl();
                    this.eUA.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eUB = new g();
                    this.eUB.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eUC = new s();
                    this.eUC.a(threadInfo.cartoon_info);
                }
                this.eUj.setUserMap(this.userMap);
                this.eUj.parserProtobuf(threadInfo.zan);
                this.eUk.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eUj.setTitle(this.title);
                } else {
                    this.eUj.setTitle(this.eTH);
                }
                this.eUF = threadInfo.livecover_src;
                this.eUG = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eUy = threadInfo.post_num.intValue();
                this.eUJ = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.sf(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Dm(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eUp.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eUH = noticeInfo.notice;
                    }
                    this.eUM = zhiBoInfoTW.copythread_remind.intValue();
                    this.eUK = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eUL = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eUF)) {
                        this.eUF = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eUQ = zhiBoInfoTW.user.tw_anchor_info;
                        this.eUR = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eUI = threadInfo.twzhibo_info.livecover_status;
                    this.eUJ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eUN = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eUP.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eUS.add(cVar2);
                    }
                }
                this.eUT.parserProtobuf(threadInfo.push_status);
                this.eUY = threadInfo.lego_card;
                this.eUV = threadInfo.skin_info;
                this.eUZ = threadInfo.is_book_chapter.intValue();
                this.eVa.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eVh = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eVi = threadInfo.last_read_pid.longValue();
                this.eVj = threadInfo.cheak_repeat.intValue() == 1;
                this.eVm = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eVt.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.eQN = sparseArray2;
                }
                this.eVs = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eVv = new ao();
                    this.eVv.a(threadInfo.link_info);
                }
                this.eVw = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eVx = new f();
                    this.eVx.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eVy = new MediaData();
                    this.eVy.parserProtobuf(threadInfo.pic_info);
                }
                this.eVc = threadInfo.is_called.intValue();
                this.eVz = threadInfo.middle_page_num.intValue();
                this.eVA = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eVC = threadInfo.star_rank_icon.icon_pic_url;
                    this.eVD = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eVB = new OriginalThreadInfo();
                    this.eVB.a(threadInfo.origin_thread_info);
                } else {
                    this.eVB = null;
                    this.isShareThread = false;
                }
                this.eVE = threadInfo.is_topic.intValue();
                this.eVG = threadInfo.topic_user_name;
                this.eVH = threadInfo.topic_h5_url;
                this.eVF = threadInfo.topic_module;
                this.eVJ = threadInfo.presentation_style;
                this.eVM = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eVO = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eTN = new bv();
                    this.eTN.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eVQ = threadInfo.swan_info;
                }
                this.eVX = threadInfo.t_share_img;
                this.eVY = threadInfo.nid;
                this.eVZ = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eWk = threadInfo.article_cover;
                this.eWl = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eWm = threadInfo.is_s_card.intValue() == 1;
                this.eWn = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eWo = threadInfo.wonderful_post_info;
                brO();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eWp = threadInfo;
                if (!com.baidu.tbadk.core.util.x.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eWs) {
                            this.eWs = true;
                        }
                        this.eWq.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.x.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eWr.add(pbGoodsData);
                    }
                    if (this.eWr.size() > 0 && !this.eWs) {
                        this.eWs = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eWt = threadInfo.item;
                }
                if (this.eWt != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eWt);
                }
                this.eWu = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.x.isEmpty(this.eWu)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eWu);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eWv == null) {
                        this.eWv = new PollData();
                    }
                    this.eWv.parserProtobuf(threadInfo.poll_info);
                }
                this.eWw = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eWx = threadInfo.distance.intValue();
                this.eWy = threadInfo.distance_text;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(WriteData writeData) {
        String dQG;
        if (writeData != null) {
            try {
                this.id = "0";
                this.tid = "";
                this.fid = com.baidu.adp.lib.f.b.toLong(writeData.getForumId(), 0L);
                this.title = writeData.getTitle();
                this.mCreateTime = System.currentTimeMillis() / 1000;
                this.last_time = (System.currentTimeMillis() / 1000) + "";
                this.eTS = System.currentTimeMillis() / 1000;
                this.eTY = new MetaData();
                this.eTY.parseFromCurrentUser();
                this.authorId = TbadkCoreApplication.getCurrentAccount();
                this.forum_name = writeData.getForumName();
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.is_vertical = Integer.valueOf(writeData.getVideoInfo().getVideoHeight() > writeData.getVideoInfo().getVideoWidth() ? 1 : 0);
                if (com.baidu.tbadk.core.util.at.isEmpty(com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQG())) {
                    dQG = writeData.getVideoInfo().getThumbPath();
                } else {
                    dQG = com.baidu.tieba.tbadkCore.writeModel.a.dQA().dQG();
                }
                builder.thumbnail_url = dQG;
                builder.video_url = writeData.getVideoInfo().getVideoUrl();
                this.eUq = builder.build(true);
                this.threadType = 40;
                this.time = System.currentTimeMillis();
                this.eTG = writeData.isNoTitle() ? 1 : 0;
                this.eTH = writeData.getContent();
                this.eTN = new bv();
                this.eTN.forumId = writeData.getForumId();
                this.eTN.forumName = writeData.getForumName();
                this.mTabId = writeData.getTabId();
                this.mTabName = writeData.getTabName();
                brO();
                if (!StringUtils.isNull(writeData.getItem_id()) && writeData.getItemInfo() != null) {
                    Item.Builder builder2 = new Item.Builder();
                    builder2.icon_size = Double.valueOf(writeData.getItemInfo().getIconSize());
                    builder2.icon_url = writeData.getItemInfo().getIconUrl();
                    builder2.item_name = writeData.getItemInfo().getTitle();
                    builder2.tags = writeData.getItemInfo().getTags();
                    builder2.score = Double.valueOf(writeData.getItemInfo().getScore());
                    builder2.star = Integer.valueOf(writeData.getItemInfo().getStar());
                    this.eWt = builder2.build(true);
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
                this.eUu = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eTQ = jSONObject.optInt("repost_num", 0);
                this.eTR = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eTS = jSONObject.optLong("last_time_int", 0L);
                this.eTT = jSONObject.optInt("is_top", 0);
                this.eTU = jSONObject.optInt("is_membertop", 0);
                this.eTV = jSONObject.optInt("is_good", 0);
                this.eTW = jSONObject.optInt("is_livepost", 0);
                this.eTX.parserJson(jSONObject.optJSONObject(AlbumActivityConfig.FROM_TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.eTY.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eTZ = jSONObject.optInt("has_commented", 0);
                this.eUa = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eUf = jSONObject.optInt("collect_status");
                this.eUg = jSONObject.optString("collect_mark_pid");
                this.eUh = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eUi = jSONObject.optInt("thread_type");
                this.eVu = jSONObject.optLong("share_num");
                this.eUl = jSONObject.optString("first_post_id", "0");
                this.eUw = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eTG = jSONObject.optInt("is_ntitle");
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
                    this.eQN = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eUP.parserJson(optJSONObject2);
                }
                if ((this.eTY == null || this.eTY.getUserId() == null) && this.userMap != null) {
                    this.eTY = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eUt = new AlaInfoData();
                this.eUt.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eTH = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eUb.add(mediaData);
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
                        this.eUc.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eUz.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eUA = new cl();
                    this.eUA.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eUB = new g();
                    this.eUB.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eUC = new s();
                    this.eUC.parserJson(optJSONObject6);
                }
                this.eUj.setUserMap(this.userMap);
                this.eUj.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eUk.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eUj.setTitle(this.title);
                } else {
                    this.eUj.setTitle(this.eTH);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eUP.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eUS.add(cVar);
                    }
                }
                this.eUZ = jSONObject.optInt("is_book_chapter", 0);
                this.eVa.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eVh = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eVd = jSONObject.optString("recom_extra_img");
                this.eVg = jSONObject.optString("recom_extra_img_night");
                this.eVe = jSONObject.optInt("recom_extra_img_width", 0);
                this.eVf = jSONObject.optInt("recom_extra_img_height", 0);
                this.eVi = jSONObject.optLong("last_read_pid");
                this.eVj = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eUs = new cg();
                    this.eUs.dp(optJSONObject8);
                }
                this.eVs = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eVv = new ao();
                    this.eVv.parserJson(optJSONObject9);
                }
                this.eVw = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eVx = new f();
                    this.eVx.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eVy = new MediaData();
                    this.eVy.parserJson(optJSONObject11);
                }
                this.eVc = jSONObject.optInt("is_called", 0);
                this.eVz = jSONObject.optInt("middle_page_num", 0);
                this.eVA = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eUq = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eVB = new OriginalThreadInfo();
                        this.eVB.parserJson(optJSONObject13);
                    } else {
                        this.eVB = null;
                    }
                } else {
                    this.eVB = null;
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
                    this.eVQ = builder2.build(false);
                }
                this.eVX = jSONObject.optString("t_share_img");
                this.eVY = jSONObject.optString(IntentConfig.NID);
                this.eVZ = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eWl = jSONObject.optInt("bjh_content_tag");
                this.eWk = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eWm = jSONObject.optInt("is_s_card", 0) == 1;
                this.eWn = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eWo = jSONObject.optString("wonderful_post_info");
                brO();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eWv == null) {
                        this.eWv = new PollData();
                    }
                    this.eWv.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eWs) {
                            this.eWs = true;
                        }
                        this.eWq.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eWr.add(pbGoodsData);
                    }
                    if (this.eWr.size() > 0 && !this.eWs) {
                        this.eWs = true;
                    }
                }
                this.eWw = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eWx = jSONObject.optInt("distance");
                this.eWy = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void brO() {
        brP();
        brR();
        brU();
        brV();
        brW();
        brX();
        brY();
    }

    private void brP() {
        if (!StringUtils.isNull(this.eTY.getName_show())) {
            this.eVS = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eTY.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void brQ() {
        if (this.eUt != null) {
            if (this.eUt.openRecomDuration == 1 && this.mCreateTime > 0) {
                String dU = com.baidu.tbadk.core.util.at.dU(this.mCreateTime);
                if (!StringUtils.isNull(dU)) {
                    this.eVT = dU;
                }
            }
            if (this.eUt.openRecomFans == 1) {
                int i = 0;
                if (this.eUt != null && this.eUt.user_info != null) {
                    i = this.eUt.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eVT) && i > 0) {
                    this.eVT += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.dX(i);
                } else if (i > 0) {
                    this.eVT = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.dX(i);
                }
            }
        }
    }

    private void brR() {
        if ((this instanceof au) && "0".equals(getId())) {
            this.eVT = TbadkCoreApplication.getInst().getString(R.string.video_is_checking_novisible);
        } else if (bpZ() || (btl() && getType() != eTk)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dS = com.baidu.tbadk.core.util.at.dS(j);
                if (com.baidu.tbadk.core.util.at.Ca(dS)) {
                    dS = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.eVT = dS;
            }
            String str = "";
            if (this.eTY != null && this.eTY.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eTY.getBaijiahaoInfo().auth_desc)) {
                str = this.eTY.getBaijiahaoInfo().auth_desc;
            }
            if (btv()) {
                brS();
            } else if (!this.eWd && this.eTY != null && this.eTY.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eTY.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eVT)) {
                    this.eVT += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eVT = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eVT) && !TextUtils.isEmpty(str)) {
                this.eVT += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eVT = str;
            }
        } else if (getType() == eTk || getType() == eTn) {
            brQ();
        } else {
            long brj = brj() * 1000;
            if (brj != 0) {
                String dS2 = com.baidu.tbadk.core.util.at.dS(brj);
                if (com.baidu.tbadk.core.util.at.Ca(dS2)) {
                    dS2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(brj);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (boW()) {
                    dS2 = com.baidu.tbadk.core.util.at.dT(brj);
                }
                this.eVT = string + dS2;
            } else {
                long j2 = this.mCreateTime;
                String dS3 = com.baidu.tbadk.core.util.at.dS(j2);
                if (com.baidu.tbadk.core.util.at.Ca(dS3)) {
                    dS3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.eVT = dS3;
            }
            if (btv()) {
                brS();
            } else if (!this.eWd && this.eTY != null && this.eTY.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eTY.getBazhuGradeData().getDesc(), this.eWc ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eVT)) {
                    this.eVT += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eVT = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eVT) && !TextUtils.isEmpty(getAddress())) {
                this.eVT += " • " + getAddress();
            }
        }
    }

    private void brS() {
        if (btv() && !TextUtils.isEmpty(this.eTY.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eVT)) {
                this.eVT += "   " + this.eTY.getNewGodData().getFieldName() + com.baidu.tbadk.util.ag.lB(this.eTY.getNewGodData().isVideoGod());
            } else {
                this.eVT = this.eTY.getNewGodData().getFieldName() + com.baidu.tbadk.util.ag.lB(this.eTY.getNewGodData().isVideoGod());
            }
        }
    }

    public void brT() {
        if (!bpZ() && !btl()) {
            long brj = 1000 * brj();
            if (brj != 0) {
                String dS = com.baidu.tbadk.core.util.at.dS(brj);
                if (com.baidu.tbadk.core.util.at.Ca(dS)) {
                    dS = com.baidu.tbadk.core.util.at.getFormatTimeShort(brj);
                }
                this.eVT = dS;
            }
            if (btv()) {
                brS();
            } else if (!this.eWd && this.eTY != null && this.eTY.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eTY.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eVT)) {
                    this.eVT += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eVT = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eVT) && !TextUtils.isEmpty(getAddress())) {
                this.eVT += " • " + getAddress();
            }
        }
    }

    private void brU() {
        if (brJ() == null || brJ().share_info == null || brJ().share_info.share_user_count <= 0 || !bsN() || (this.eVz > 0 && this.eVA == 0)) {
            this.eVU = null;
            return;
        }
        int i = brJ().share_info.share_user_count;
        if (i == 1) {
            this.eVU = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eVU = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void brV() {
        this.eTM = bsp();
        com.baidu.tieba.card.m.a(this, this.eTM, true);
    }

    private void brW() {
        this.eQX = bsn();
    }

    private void brX() {
        this.eVV = com.baidu.tbadk.core.util.at.getFormatTimeShort(brj() * 1000);
    }

    private void brY() {
        this.eVW = com.baidu.tbadk.core.util.at.getFormatTimeShort(brj());
    }

    public SpannableStringBuilder brZ() {
        return this.eTL;
    }

    public boolean bsa() {
        return brl() != 0;
    }

    public int bsb() {
        if (this.eUP != null) {
            long bqI = this.eUP.bqI();
            long bqJ = this.eUP.bqJ();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bqI) {
                return 1;
            }
            if (currentTimeMillis > bqJ) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bsc() {
        if (bse() && this.eUz.size() >= 1) {
            b bVar = this.eUz.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bpa = bVar.bpa();
            int bpb = bVar.bpb();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bpa) {
                return 4;
            }
            return currentTimeMillis > bpb ? 2 : 1;
        }
        return -1;
    }

    public int bsd() {
        if (!bse() || this.eUz.size() < 1 || this.eUz.get(0) == null) {
            return -1;
        }
        return this.eUz.get(0).boZ();
    }

    public boolean bse() {
        return this.eUn == 1;
    }

    public String getActUrl() {
        return (!bse() || this.eUz.size() < 1 || this.eUz.get(0) == null) ? "" : this.eUz.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Bf(String str) {
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

    public SmartApp bsf() {
        return this.eVQ;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bsh()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (brl() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (brl() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (brn() == 1 || this.eTX.btK() != 0) {
                if (bqW() != null && getThreadType() == 41) {
                    if (bsb() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bsA()) {
                Integer num = eUE.get(Integer.valueOf(bsb()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (brm() == 1 && !bsa() && eTj != getType() && eTs != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eUk != null && this.eUk.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (brv() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eUD.get(new Point(bsd(), bsc()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (brB() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (brC() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Bf(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eTF));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bsk = bsk();
        if (bsk != null) {
            spannableStringBuilder.append((CharSequence) bsk);
        }
        this.eTL = spannableStringBuilder;
    }

    public boolean bsg() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (brq() != null) {
            if (brq().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (brq().getGender() == 2) {
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

    private boolean bsh() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void z(boolean z, boolean z2) {
        e(z, z2, true);
    }

    public void e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.x.getCount(a(z, z2, z3, false)) > 0) {
            A(z, z3);
            return;
        }
        SpannableStringBuilder bsk = bsk();
        if (z) {
            spannableStringBuilder = a(bsk.toString(), bsk, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bsk);
        }
        this.eTL = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> a2 = a(z, z2, z3, z4);
        if (a2 == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a3 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, a2, false);
        if (a2.size() > 0) {
            if (a3 == null) {
                a3 = new SpannableStringBuilder();
            }
            if (this.eTG == 1) {
                this.eTL = a3;
                return a3;
            }
        } else if (this.eTG == 1) {
            this.eTL = new SpannableStringBuilder();
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

    public void dK(String str, String str2) {
        this.mUrl = str;
        this.eUU = str2;
    }

    public String bsi() {
        return this.mUrl;
    }

    public String bsj() {
        return this.eUU;
    }

    public SpannableStringBuilder bsk() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eTI, this.title);
    }

    public SpannableStringBuilder bsl() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eTJ, this.eTH);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bsm() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eWm) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bsn() {
        SpannableStringBuilder bsl = bsl();
        com.baidu.tieba.card.m.a(this, bsl, false);
        return new SpannableString(bsl);
    }

    public SpannableString bso() {
        if (com.baidu.tbadk.core.util.x.isEmpty(this.eTK)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eTK, this.eTH));
    }

    public String getAbstract() {
        return this.eTH;
    }

    public void Bg(String str) {
        this.eTH = str;
    }

    public SpannableStringBuilder f(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bsk;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eTG == 1) {
            bsk = bsl();
            spannableStringBuilder = bsk.toString();
        } else {
            bsk = bsk();
            spannableStringBuilder = bsk.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bsk, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bsk);
        }
        this.eTL = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return f(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bsl;
        if (!StringUtils.isNull(this.title) && this.eTG != 1) {
            bsl = bsk();
        } else {
            bsl = bsl();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bsl);
        this.eTL = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bsp() {
        if (StringUtils.isNull(this.title) || this.eTG == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bsk());
        this.eTL = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bpU() {
        if (this.eTI != null && this.eTI.size() > 0) {
            int size = this.eTI.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eTI.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bpV() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Ey(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bsq() {
        y(false, false);
    }

    public void bsr() {
        y(false, true);
    }

    public AnchorInfoData bss() {
        return this.eUk;
    }

    public boolean bst() {
        return this.threadType == 36;
    }

    public boolean bpV() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bsu() {
        return this.threadType == 11 || this.eUh == 1;
    }

    public boolean bsv() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> brz = brz();
        if (brz == null || bsa()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= brz.size() || i2 >= 3) {
                break;
            }
            if (brz.get(i2) != null && brz.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(brz.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = brz.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = brz.get(i2).getPicUrl();
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
        if (this.eUq != null && !StringUtils.isNull(this.eUq.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eUq.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eTY != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eTY.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bsw() {
        String userId;
        return this.eTY == null || (userId = this.eTY.getUserId()) == null || userId.equals("0");
    }

    public boolean bsx() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (this.eWF != null) {
            return this.eWF.dOO() ? (this.eWF.dON() == null && this.eWF.dOP()) ? AdvertAppInfo.eNK : AdvertAppInfo.eNL : this.eWF.dON() != null ? AdvertAppInfo.eNJ : AdvertAppInfo.eNK;
        } else if (bti()) {
            if (brH() != null) {
                return eTj;
            }
            return eSL;
        } else {
            int brl = brl();
            if (this.eVE == 1) {
                if (this.eVF != null) {
                    return eSZ;
                }
                return this.eVI != null ? eTu : eTt;
            } else if (this.eUt != null && this.threadType == 60) {
                return eTm;
            } else {
                if (this.eUt != null && this.threadType == 49) {
                    return eTk;
                }
                if (this.eUt != null && this.threadType == 67) {
                    return eTn;
                }
                if (this.threadType == 51) {
                    return eTl;
                }
                if (this.threadType == 63) {
                    return eTv;
                }
                if (this.threadType == 64) {
                    return eTw;
                }
                if (brl == 2 || brl == 1) {
                    return eSK;
                }
                if (this.eUq != null && bsG() && !bsx()) {
                    return eTB;
                }
                if (this.eUq != null && !bsx()) {
                    if (brt()) {
                        return eTs;
                    }
                    if (this instanceof au) {
                        return eTC;
                    }
                    return eTj;
                } else if (this.isShareThread && this.eVB != null) {
                    if (this.eVB.eQY) {
                        if (this.eVB.videoInfo != null) {
                            return eTr;
                        }
                        if (this.eVB.bpX()) {
                            return eTq;
                        }
                        return eTp;
                    }
                    return eTo;
                } else if (bpX()) {
                    return eTa;
                } else {
                    if (bsz()) {
                        return eTy.get() ? eUO : eSL;
                    } else if (bse() && bsd() == 1) {
                        return eTy.get() ? eUW : eSL;
                    } else if (isLinkThread()) {
                        return eTh;
                    } else {
                        if (brt()) {
                            return eTi;
                        }
                        if (this.eSq) {
                            return eSR;
                        }
                        if (this.eSr) {
                            return eSS;
                        }
                        if (this.eSs) {
                            return eST;
                        }
                        if (this.eSt) {
                            return eSU;
                        }
                        if (this.eSu) {
                            return eSV;
                        }
                        if (this.eSw) {
                            return eSX;
                        }
                        if (this.eSx) {
                            return eSY;
                        }
                        if (this.eSv) {
                            return eSW;
                        }
                        if (this.eTg) {
                            return eTc;
                        }
                        if (this.eUx) {
                            int bsy = bsy();
                            if (bsy == 1) {
                                return eSN;
                            }
                            if (bsy == 2) {
                                return eSO;
                            }
                            if (bsy > 2) {
                                return eSP;
                            }
                            return eSL;
                        }
                        return eSL;
                    }
                }
            }
        }
    }

    public int bsy() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bou().isShowImages() || com.baidu.tbadk.core.util.x.getCount(brz()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < brz().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(brz(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bsz() {
        return bqW() != null && getThreadType() == 41 && brn() == 1 && bsb() == 2;
    }

    public void F(ArrayList<t> arrayList) {
        if (this.eTG == 1) {
            this.ePj = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.ePj = 0;
        } else {
            this.ePj = 0;
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.bpq() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bpq().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.ePj = next.bpr();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bsA() {
        return this.threadType == 41;
    }

    public boolean bsB() {
        return this.eUX;
    }

    public void jz(boolean z) {
        this.eUX = z;
    }

    public String bsC() {
        return this.eUY;
    }

    public s bsD() {
        return this.eUC;
    }

    public void bsE() {
        if (this.eUv == 0) {
            this.eUv = 1;
        }
    }

    public boolean bsF() {
        return this.eVb;
    }

    public void jA(boolean z) {
        this.eVk = z;
    }

    public boolean bsG() {
        return this.eVk;
    }

    public void oT(int i) {
        this.eVl = i + 1;
    }

    public int bsH() {
        return this.eVl;
    }

    public boolean bsI() {
        return this.eWb;
    }

    public void jB(boolean z) {
        this.eWb = z;
    }

    public cg bsJ() {
        return this.eUs;
    }

    public boolean bsK() {
        return getThreadType() == 49;
    }

    public boolean bsL() {
        return getThreadType() == 40;
    }

    public boolean bsM() {
        return getThreadType() == 50;
    }

    public boolean bsN() {
        return getThreadType() == 60;
    }

    public int bsO() {
        return this.eVr;
    }

    public void setSmartFrsPosition(int i) {
        this.eVr = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bsP() {
        return this.mRecomSource;
    }

    public boolean bsQ() {
        return this.eVs;
    }

    public long bsR() {
        return this.agreeData.agreeNum;
    }

    public long bsS() {
        return this.agreeData.disAgreeNum;
    }

    public int bsT() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bsU() {
        return this.agreeData.agreeType;
    }

    public void oU(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void oV(int i) {
        this.agreeData.agreeNum = i;
    }

    public void dH(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dI(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void oW(int i) {
        this.agreeData.agreeType = i;
    }

    public long bsV() {
        return this.eVu;
    }

    public void dJ(long j) {
        this.eVu = j;
    }

    public PostData bsW() {
        return this.eVt;
    }

    public ao bsX() {
        return this.eVv;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean brr = brr();
        if (z2) {
            if (z) {
                if (brr && !bpV()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (brn() == 1 || getThreadType() == 33 || (brp() != null && brp().btK() != 0)) {
                    if (bqW() != null && bsA()) {
                        if (bsb() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!brr) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (bsA()) {
                    arrayList.add(eVo.get(bsb()));
                }
                if (bse()) {
                    Integer num = eVn.get(new Point(bsd(), bsc()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (brB() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (brr && brl() != 1 && !bpV()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((brn() == 1 || getThreadType() == 33) && !bsA() && !brr) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (brm() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (brl() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (bsA() && bqW() != null && bsb() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (bse()) {
                    Integer num2 = eVn.get(new Point(bsd(), bsc()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.eUZ == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (brC() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (brB() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bsK()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bsM()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bsL()) {
                    arrayList.add(new m.a(R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a(R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void G(ArrayList<MediaData> arrayList) {
        this.eUb = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eUc = arrayList;
    }

    public String bsY() {
        return this.eVG;
    }

    public void Bh(String str) {
        this.eVG = str;
    }

    public void bsZ() {
        this.eVE = 1;
    }

    public boolean bta() {
        return this.eVE == 1;
    }

    public String btb() {
        return this.eTO;
    }

    public void Bi(String str) {
        this.eTO = str;
    }

    public String btc() {
        return this.eTP;
    }

    public void Bj(String str) {
        this.eTP = str;
    }

    public String btd() {
        return this.eVH;
    }

    public void Bk(String str) {
        this.eVH = str;
    }

    public boolean bte() {
        return this.eVK;
    }

    public void jC(boolean z) {
        this.eVK = z;
    }

    public boolean btf() {
        return this.eVL;
    }

    public void jD(boolean z) {
        this.eVL = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eVI = videoInfo;
    }

    public boolean btg() {
        return this.eVM != null;
    }

    public bv bth() {
        return this.eTN;
    }

    public boolean bti() {
        return this.eVP;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.eUq != null) {
            return this.eUq.video_url;
        }
        return null;
    }

    public boolean btj() {
        return this.eVR;
    }

    public void jE(boolean z) {
        this.eVR = z;
    }

    public AgreeData btk() {
        return this.agreeData;
    }

    public boolean btl() {
        return this.eWe;
    }

    public void jF(boolean z) {
        this.eWe = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean boV() {
        return this.eWc;
    }

    public void jG(boolean z) {
        this.eWc = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule btm() {
        return this.eVF;
    }

    public String getShareImageUrl() {
        return this.eVX;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int i2;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> brz = brz();
        if (com.baidu.tbadk.core.k.bou().isShowImages() && com.baidu.tbadk.core.util.x.getCount(brz) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i4 = 0; i4 < brz.size(); i4++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.x.getItem(brz, i4);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.x.getItem(brz, 0);
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

    public boolean btn() {
        return bto() || btp();
    }

    public boolean bpX() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bpY() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bto() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean btp() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bpZ() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bpZ();
    }

    public void oX(int i) {
        this.isBjh = i;
    }

    public int btq() {
        return this.eWl;
    }

    public String btr() {
        return this.eWk;
    }

    public void Bl(String str) {
        this.eWk = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bts() {
        if (brs()) {
            return 4;
        }
        if (bsK() || bsM()) {
            return 3;
        }
        if (bpX()) {
            return 5;
        }
        if (bpY()) {
            return 6;
        }
        if (bto()) {
            return 7;
        }
        if (btp()) {
            return 8;
        }
        if (this.isShareThread && this.eVB != null) {
            return 9;
        }
        if (bsL()) {
            return 2;
        }
        return 1;
    }

    public int btt() {
        if (btp() || bto()) {
            return 2;
        }
        if (bpX() || bpY()) {
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

    public ThreadInfo btu() {
        return this.eWp;
    }

    public String bpO() {
        return this.eVY;
    }

    public boolean btv() {
        return this.eTY != null && this.eTY.isNewGod();
    }

    public boolean btw() {
        return (brq() == null || brq().getAlaUserData() == null || brq().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item btx() {
        return this.eWt;
    }

    public List<HeadItem> bty() {
        return this.eWu;
    }

    public void a(Item item) {
        this.eWt = item;
    }

    public void by(List<HeadItem> list) {
        this.eWu = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData btz() {
        return this.eWv;
    }

    public void b(PollData pollData) {
        this.eWv = pollData;
    }

    public List<PbLinkData> btA() {
        return this.eWq;
    }

    public void bz(List<PbLinkData> list) {
        this.eWq = list;
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.eWq)) {
            for (PbLinkData pbLinkData : this.eWq) {
                if (pbLinkData.urlType == 2 && !this.eWs) {
                    this.eWs = true;
                }
            }
        }
    }

    public List<PbGoodsData> btB() {
        return this.eWr;
    }

    public void bA(List<PbGoodsData> list) {
        this.eWr = list;
        if (!com.baidu.tbadk.core.util.x.isEmpty(list) && !this.eWs) {
            this.eWs = true;
        }
    }

    public boolean btC() {
        return this.eWs;
    }

    public boolean btD() {
        return this.eTY != null && this.eTY.isForumBusinessAccount();
    }
}

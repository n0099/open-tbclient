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
public class bw extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String bnW;
    public String buttonText;
    public int eBK;
    private SpannableString eBQ;
    private String eEA;
    private String eEB;
    public int eEP;
    private int eEQ;
    private int eET;
    public int eEU;
    private String eEX;
    private String eEY;
    private int eEs;
    private SpannableStringBuilder eEx;
    private SpannableStringBuilder eEy;
    private bs eEz;
    public TwZhiBoUser eFC;
    public List<TwAnchorProfitItem> eFD;
    private SkinInfo eFH;
    private boolean eFJ;
    private String eFK;
    private boolean eFN;
    public String eFP;
    public int eFQ;
    public int eFR;
    public String eFS;
    public String eFT;
    public long eFU;
    private List<ReportInfo> eFY;
    private int eFa;
    private VideoInfo eFc;
    private VideoDesc eFd;
    private cd eFe;
    private AlaInfoData eFf;
    private long eFg;
    private r eFo;
    private LiveCoverStatus eFu;
    private long eFv;
    private String eGA;
    private boolean eGB;
    private SmartApp eGC;
    private String eGE;
    private String eGF;
    private String eGG;
    private String eGH;
    private String eGI;
    public String eGJ;
    private boolean eGM;
    private boolean eGN;
    public boolean eGO;
    public boolean eGP;
    public boolean eGQ;
    public boolean eGR;
    public boolean eGS;
    public boolean eGT;
    public String eGU;
    private String eGV;
    private int eGW;
    public String eGY;
    private String eGZ;
    private boolean eGe;
    private long eGg;
    private am eGh;
    public e eGj;
    private MediaData eGk;
    public int eGl;
    public OriginalThreadInfo eGn;
    private TopicModule eGr;
    private String eGs;
    private String eGt;
    private VideoInfo eGu;
    private String eGv;
    private boolean eGx;
    public OriginalForumInfo eGy;
    public boolean eGz;
    private ThreadInfo eHa;
    private boolean eHd;
    private Item eHe;
    private List<HeadItem> eHf;
    PollData eHg;
    public int eHi;
    public String eHj;
    public String eHk;
    public String eHl;
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
    public static final BdUniqueId eDz = BdUniqueId.gen();
    public static final BdUniqueId eDA = BdUniqueId.gen();
    public static final BdUniqueId eDB = BdUniqueId.gen();
    public static final BdUniqueId eDC = BdUniqueId.gen();
    public static final BdUniqueId eDD = BdUniqueId.gen();
    public static final BdUniqueId eDE = BdUniqueId.gen();
    public static final BdUniqueId eDF = BdUniqueId.gen();
    public static final BdUniqueId eDG = BdUniqueId.gen();
    public static final BdUniqueId eDH = BdUniqueId.gen();
    public static final BdUniqueId eDI = BdUniqueId.gen();
    public static final BdUniqueId eDJ = BdUniqueId.gen();
    public static final BdUniqueId eDK = BdUniqueId.gen();
    public static final BdUniqueId eDL = BdUniqueId.gen();
    public static final BdUniqueId eDM = BdUniqueId.gen();
    public static final BdUniqueId eDN = BdUniqueId.gen();
    public static final BdUniqueId eDO = BdUniqueId.gen();
    public static final BdUniqueId eDP = BdUniqueId.gen();
    public static final BdUniqueId eDQ = BdUniqueId.gen();
    public static final BdUniqueId eDR = BdUniqueId.gen();
    public static final BdUniqueId eDS = BdUniqueId.gen();
    public static final BdUniqueId eDT = BdUniqueId.gen();
    public static final BdUniqueId eDU = BdUniqueId.gen();
    public static final BdUniqueId eDV = BdUniqueId.gen();
    public static final BdUniqueId eDW = BdUniqueId.gen();
    public static final BdUniqueId eDX = BdUniqueId.gen();
    public static final BdUniqueId eDY = BdUniqueId.gen();
    public static final BdUniqueId eDZ = BdUniqueId.gen();
    public static final BdUniqueId eEa = BdUniqueId.gen();
    public static final BdUniqueId eEb = BdUniqueId.gen();
    public static final BdUniqueId eEc = BdUniqueId.gen();
    public static final BdUniqueId eEd = BdUniqueId.gen();
    public static final BdUniqueId eEe = BdUniqueId.gen();
    public static final BdUniqueId eEf = BdUniqueId.gen();
    public static final BdUniqueId eEg = BdUniqueId.gen();
    public static final BdUniqueId eEh = BdUniqueId.gen();
    public static final BdUniqueId eEi = BdUniqueId.gen();
    public static final BdUniqueId eEj = BdUniqueId.gen();
    public static final BdUniqueId eEk = BdUniqueId.gen();
    public static AtomicBoolean eEl = new AtomicBoolean(false);
    public static AtomicBoolean eEm = new AtomicBoolean(false);
    public static AtomicBoolean eEn = new AtomicBoolean(false);
    public static final BdUniqueId eEo = BdUniqueId.gen();
    private static HashMap<Point, Integer> eFp = new HashMap<>();
    private static HashMap<Integer, Integer> eFq = new HashMap<>();
    public static final BdUniqueId eFA = BdUniqueId.gen();
    public static final BdUniqueId eFI = BdUniqueId.gen();
    private static HashMap<Point, Integer> eFZ = new HashMap<>();
    private static SparseArray<n.a> eGa = new SparseArray<>(3);
    public boolean eDg = false;
    public boolean eDh = false;
    public boolean eDi = false;
    public boolean eDj = false;
    public boolean eDk = false;
    public boolean eDl = false;
    public boolean eDm = false;
    public boolean eDn = false;
    private int eEp = 0;
    private String eEq = "1";
    public int eEr = 1;
    private String eES = null;
    private int eAd = 0;
    public int eFh = 0;
    private String eFi = "";
    public boolean eFj = false;
    private String eFr = "";
    public boolean eFV = true;
    public boolean eGb = false;
    public boolean eGc = false;
    private int eGd = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eBG = null;
    public boolean eGi = false;
    private int eGq = 0;
    private boolean eGw = false;
    private boolean eGD = false;
    public boolean eGK = false;
    public boolean eGL = false;
    public boolean forbidComment = false;
    public boolean eGX = false;
    public boolean eHm = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eEC = 0;
    private int eED = 0;
    private String last_time = null;
    private long eEE = 0;
    private int eEF = 0;
    private int eEG = 0;
    private int eEH = 0;
    private int eEI = 0;
    private ca eEJ = new ca();
    private MetaData eEK = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eEN = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eEO = new ArrayList<>();
    private int eEL = 0;
    private int eEM = 0;
    private String ad_url = null;
    private String eEt = null;
    private String from = null;
    private int eER = 0;
    private PraiseData eEV = new PraiseData();
    private AnchorInfoData eEW = new AnchorInfoData();
    private long time = 0;
    private int eEZ = 0;
    private ArrayList<a> eFl = new ArrayList<>();
    private ci eFm = null;
    private f eFn = null;
    private int eFs = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eFb = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eFt = null;
    private int eFk = 0;
    private boolean eFw = false;
    private boolean eFx = false;
    private int eFy = 0;
    private boolean eFz = false;
    private int anchorLevel = 0;
    public int eFL = 0;
    public o eFM = new o();
    private List<PbContent> eEw = new ArrayList();
    private List<PbContent> eEu = new ArrayList();
    private List<PbContent> eEv = new ArrayList();
    private String category_name = null;
    private bu eFB = new bu();
    private ArrayList<com.baidu.tbadk.data.c> eFE = new ArrayList<>();
    private PushStatusData eFF = new PushStatusData();
    public boolean eFW = false;
    public int eFX = -1;
    private PostData eGf = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eFO = 0;
    public int eGm = 0;
    private String tieba_game_information_source = "";
    public String eGp = "";
    public String eGo = "";
    public String mUrl = "";
    public String eFG = "";
    private List<PbLinkData> eHb = new ArrayList();
    private List<PbGoodsData> eHc = new ArrayList();
    public int eHh = -1;

    static {
        eFp.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eFp.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eFp.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eFp.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eFp.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eFp.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eFp.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eFp.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eFZ.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eFZ.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eFZ.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eFZ.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eFZ.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eFZ.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eFZ.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eFZ.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eFq.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eFq.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eFq.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eGa.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        eGa.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        eGa.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bw() {
        this.eEQ = 0;
        this.eFa = 0;
        this.eFv = 0L;
        this.eGl = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eFv = 0L;
        this.eFa = 0;
        this.eEQ = 0;
        this.eGl = 0;
    }

    public String blX() {
        return this.eGE;
    }

    public String blY() {
        return this.eGF;
    }

    public void AZ(String str) {
        this.eGF = str;
    }

    public String blZ() {
        return this.eGG;
    }

    public SpannableStringBuilder bma() {
        return this.eEy;
    }

    public SpannableString bmb() {
        return this.eBQ;
    }

    public void a(SpannableString spannableString) {
        if (bmA() != null && !bkk() && !bkj()) {
            if (this.eEy != null) {
                this.eEy.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eBQ);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eBQ = new SpannableString(spannableStringBuilder);
        }
    }

    public void bmc() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eHf) > 0) {
            if (this.eEy != null) {
                this.eEy.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bF(this.eHf));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eBQ);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bF(this.eHf));
            this.eBQ = new SpannableString(spannableStringBuilder);
        }
    }

    public String bmd() {
        return this.eGH;
    }

    public String bme() {
        return this.eGI;
    }

    public boolean bmf() {
        return this.eEQ == 1;
    }

    public bu bmg() {
        return this.eFB;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void og(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eFa;
    }

    public void oh(int i) {
        this.eFy = i;
    }

    public int bmh() {
        return this.eFy;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bmi() {
        return this.eGu;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dg(long j) {
        this.mCreateTime = j;
    }

    public long bmj() {
        return this.eFg;
    }

    public String bmk() {
        return this.eEX;
    }

    public PraiseData bml() {
        return this.eEV;
    }

    public void a(PraiseData praiseData) {
        this.eEV = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bmm() {
        return this.bnW;
    }

    public void Ba(String str) {
        this.bnW = str;
    }

    public String bmn() {
        return this.eEq;
    }

    public void Bb(String str) {
        this.eEq = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void oi(int i) {
        this.eEp = i;
    }

    public int bmo() {
        return this.eEp;
    }

    public String bmp() {
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

    public List<PbContent> bmq() {
        return this.eEw;
    }

    public void bl(List<PbContent> list) {
        this.eEw = list;
    }

    public void bm(List<PbContent> list) {
        this.eEu = list;
    }

    public void bn(List<PbContent> list) {
        this.eEv = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void oj(int i) {
        this.reply_num = i;
    }

    public int bmr() {
        return this.reply_num;
    }

    public int bms() {
        return this.eED;
    }

    public void ok(int i) {
        this.eED = i;
    }

    public long bmt() {
        return this.eEE;
    }

    public void dh(long j) {
        this.eEE = j;
    }

    public int bmu() {
        return this.eEG;
    }

    public int bmv() {
        return this.eEF;
    }

    public void ol(int i) {
        this.eEF = i;
    }

    public int bmw() {
        return this.eEH;
    }

    public void om(int i) {
        this.eEH = i;
    }

    public int bmx() {
        return this.eEI;
    }

    public List<PbContent> bmy() {
        return this.eEu;
    }

    public ca bmz() {
        return this.eEJ;
    }

    public MetaData bmA() {
        return this.eEK;
    }

    public boolean bmB() {
        return this.is_god != 0;
    }

    public boolean bmC() {
        return this.is_god == 1;
    }

    public boolean bmD() {
        return (this.eEK == null || this.eEK.getGodUserData() == null || this.eEK.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eEK = metaData;
    }

    public String bmE() {
        return this.forum_name;
    }

    public void Bc(String str) {
        this.forum_name = str;
    }

    public int bmF() {
        return this.eEM;
    }

    public String bmG() {
        return this.ad_url;
    }

    public int bmH() {
        return this.eER;
    }

    public void on(int i) {
        this.eER = i;
    }

    public String bmI() {
        return this.eES;
    }

    public void Bd(String str) {
        this.eES = str;
    }

    public ArrayList<MediaData> bmJ() {
        return this.eEN;
    }

    public ArrayList<a> bmK() {
        return this.eFl;
    }

    public void E(ArrayList<a> arrayList) {
        this.eFl = arrayList;
    }

    public ci bmL() {
        return this.eFm;
    }

    public f bmM() {
        return this.eFn;
    }

    public ArrayList<VoiceData.VoiceModel> bmN() {
        return this.eEO;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bmO() {
        return this.eEs;
    }

    public void oo(int i) {
        this.eEs = i;
    }

    public String bmP() {
        return this.latitude;
    }

    public String bmQ() {
        return this.eEY;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bmR() {
        return this.eFi;
    }

    public VideoInfo bmS() {
        return this.eFc;
    }

    public void a(VideoInfo videoInfo) {
        this.eFc = videoInfo;
    }

    public VideoDesc bmT() {
        return this.eFd;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eFf = alaInfoData;
    }

    public AlaInfoData bmU() {
        return this.eFf;
    }

    public PushStatusData bmV() {
        return this.eFF;
    }

    public SkinInfo bmW() {
        return this.eFH;
    }

    public long bmX() {
        return this.eFU;
    }

    public boolean bmY() {
        return this.eFV;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bka() {
        return this.eFT;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bjZ().getTid());
        arVar.setFid(bjZ().getFid());
        arVar.setNid(bjZ().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.eBG = this.eBG;
        arVar.abTag = this.mRecomAbTag;
        arVar.weight = this.mRecomWeight;
        arVar.extra = this.mRecomExtra;
        arVar.source = this.mRecomSource;
        arVar.eBK = this.eBK;
        arVar.cardType = boz();
        return arVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eEY = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eEQ = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eFg = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eEC = threadInfo.repost_num.intValue();
                this.eED = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eEE = threadInfo.last_time_int.intValue();
                this.eEF = threadInfo.is_top.intValue();
                this.eEG = threadInfo.is_membertop.intValue();
                this.eEH = threadInfo.is_good.intValue();
                this.eEI = threadInfo.is_livepost.intValue();
                this.eEJ.a(threadInfo.topic);
                this.eEK.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eEL = threadInfo.has_commented.intValue();
                this.eEM = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eFc = threadInfo.video_info;
                this.eFd = threadInfo.video_segment;
                this.eFf = new AlaInfoData();
                this.eFf.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eER = threadInfo.collect_status.intValue();
                this.eES = threadInfo.collect_mark_pid;
                this.eET = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eEU = threadInfo.thread_type.intValue();
                this.eEX = threadInfo.first_post_id + "";
                this.eFi = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eEs = threadInfo.is_ntitle.intValue();
                this.eEZ = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eGg = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eFa = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eFN = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eEu = threadInfo.rich_title;
                this.eEw = threadInfo.first_post_content;
                this.eEv = threadInfo.rich_abstract;
                this.eEP = threadInfo.is_godthread_recommend.intValue();
                if ((this.eEK == null || this.eEK.getUserId() == null || this.eEK.getUserId().equals("0") || this.eHm) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eEK = metaData;
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
                this.eEt = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eEN.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eFc = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eFe = new cd();
                    this.eFe.a(threadInfo.video_channel_info);
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
                        this.eEO.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.eFl.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eFm = new ci();
                    this.eFm.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eFn = new f();
                    this.eFn.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eFo = new r();
                    this.eFo.a(threadInfo.cartoon_info);
                }
                this.eEV.setUserMap(this.userMap);
                this.eEV.parserProtobuf(threadInfo.zan);
                this.eEW.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eEV.setTitle(this.title);
                } else {
                    this.eEV.setTitle(this.eEt);
                }
                this.eFr = threadInfo.livecover_src;
                this.eFs = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eFk = threadInfo.post_num.intValue();
                this.eFv = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qU(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Dh(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eFb.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eFt = noticeInfo.notice;
                    }
                    this.eFy = zhiBoInfoTW.copythread_remind.intValue();
                    this.eFw = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eFx = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eFr)) {
                        this.eFr = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eFC = zhiBoInfoTW.user.tw_anchor_info;
                        this.eFD = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eFu = threadInfo.twzhibo_info.livecover_status;
                    this.eFv = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eFz = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eFB.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eFE.add(cVar2);
                    }
                }
                this.eFF.parserProtobuf(threadInfo.push_status);
                this.eFK = threadInfo.lego_card;
                this.eFH = threadInfo.skin_info;
                this.eFL = threadInfo.is_book_chapter.intValue();
                this.eFM.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eFT = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eFU = threadInfo.last_read_pid.longValue();
                this.eFV = threadInfo.cheak_repeat.intValue() == 1;
                this.eFY = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eGf.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.eBG = sparseArray2;
                }
                this.eGe = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eGh = new am();
                    this.eGh.a(threadInfo.link_info);
                }
                this.eGi = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eGj = new e();
                    this.eGj.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eGk = new MediaData();
                    this.eGk.parserProtobuf(threadInfo.pic_info);
                }
                this.eFO = threadInfo.is_called.intValue();
                this.eGl = threadInfo.middle_page_num.intValue();
                this.eGm = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eGo = threadInfo.star_rank_icon.icon_pic_url;
                    this.eGp = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eGn = new OriginalThreadInfo();
                    this.eGn.a(threadInfo.origin_thread_info);
                } else {
                    this.eGn = null;
                    this.isShareThread = false;
                }
                this.eGq = threadInfo.is_topic.intValue();
                this.eGs = threadInfo.topic_user_name;
                this.eGt = threadInfo.topic_h5_url;
                this.eGr = threadInfo.topic_module;
                this.eGv = threadInfo.presentation_style;
                this.eGy = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eGA = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eEz = new bs();
                    this.eEz.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eGC = threadInfo.swan_info;
                }
                this.eGJ = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.eGK = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eGV = threadInfo.article_cover;
                this.eGW = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eGX = threadInfo.is_s_card.intValue() == 1;
                this.eGY = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eGZ = threadInfo.wonderful_post_info;
                bmZ();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eHa = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eHd) {
                            this.eHd = true;
                        }
                        this.eHb.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eHc.add(pbGoodsData);
                    }
                    if (this.eHc.size() > 0 && !this.eHd) {
                        this.eHd = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eHe = threadInfo.item;
                }
                if (this.eHe != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eHe);
                }
                this.eHf = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eHf)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eHf);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eHg == null) {
                        this.eHg = new PollData();
                    }
                    this.eHg.parserProtobuf(threadInfo.poll_info);
                }
                this.eHh = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eHi = threadInfo.distance.intValue();
                this.eHj = threadInfo.distance_text;
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
                this.eFg = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eEC = jSONObject.optInt("repost_num", 0);
                this.eED = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eEE = jSONObject.optLong("last_time_int", 0L);
                this.eEF = jSONObject.optInt("is_top", 0);
                this.eEG = jSONObject.optInt("is_membertop", 0);
                this.eEH = jSONObject.optInt("is_good", 0);
                this.eEI = jSONObject.optInt("is_livepost", 0);
                this.eEJ.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.eEK.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eEL = jSONObject.optInt("has_commented", 0);
                this.eEM = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eER = jSONObject.optInt("collect_status");
                this.eES = jSONObject.optString("collect_mark_pid");
                this.eET = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eEU = jSONObject.optInt("thread_type");
                this.eGg = jSONObject.optLong("share_num");
                this.eEX = jSONObject.optString("first_post_id", "0");
                this.eFi = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eEs = jSONObject.optInt("is_ntitle");
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
                    this.eBG = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eFB.parserJson(optJSONObject2);
                }
                if ((this.eEK == null || this.eEK.getUserId() == null) && this.userMap != null) {
                    this.eEK = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eFf = new AlaInfoData();
                this.eFf.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eEt = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eEN.add(mediaData);
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
                        this.eEO.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eFl.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eFm = new ci();
                    this.eFm.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eFn = new f();
                    this.eFn.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eFo = new r();
                    this.eFo.parserJson(optJSONObject6);
                }
                this.eEV.setUserMap(this.userMap);
                this.eEV.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eEW.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eEV.setTitle(this.title);
                } else {
                    this.eEV.setTitle(this.eEt);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eFB.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eFE.add(cVar);
                    }
                }
                this.eFL = jSONObject.optInt("is_book_chapter", 0);
                this.eFM.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eFT = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eFP = jSONObject.optString("recom_extra_img");
                this.eFS = jSONObject.optString("recom_extra_img_night");
                this.eFQ = jSONObject.optInt("recom_extra_img_width", 0);
                this.eFR = jSONObject.optInt("recom_extra_img_height", 0);
                this.eFU = jSONObject.optLong("last_read_pid");
                this.eFV = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eFe = new cd();
                    this.eFe.dl(optJSONObject8);
                }
                this.eGe = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eGh = new am();
                    this.eGh.parserJson(optJSONObject9);
                }
                this.eGi = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eGj = new e();
                    this.eGj.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eGk = new MediaData();
                    this.eGk.parserJson(optJSONObject11);
                }
                this.eFO = jSONObject.optInt("is_called", 0);
                this.eGl = jSONObject.optInt("middle_page_num", 0);
                this.eGm = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eFc = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eGn = new OriginalThreadInfo();
                        this.eGn.parserJson(optJSONObject13);
                    } else {
                        this.eGn = null;
                    }
                } else {
                    this.eGn = null;
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
                    this.eGC = builder2.build(false);
                }
                this.eGJ = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.eGK = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eGW = jSONObject.optInt("bjh_content_tag");
                this.eGV = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eGX = jSONObject.optInt("is_s_card", 0) == 1;
                this.eGY = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eGZ = jSONObject.optString("wonderful_post_info");
                bmZ();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eHg == null) {
                        this.eHg = new PollData();
                    }
                    this.eHg.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eHd) {
                            this.eHd = true;
                        }
                        this.eHb.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eHc.add(pbGoodsData);
                    }
                    if (this.eHc.size() > 0 && !this.eHd) {
                        this.eHd = true;
                    }
                }
                this.eHh = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eHi = jSONObject.optInt("distance");
                this.eHj = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bmZ() {
        bna();
        bnc();
        bnf();
        bng();
        bnh();
        bni();
        bnj();
    }

    private void bna() {
        if (!StringUtils.isNull(this.eEK.getName_show())) {
            this.eGE = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eEK.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bnb() {
        if (this.eFf != null) {
            if (this.eFf.openRecomDuration == 1 && this.mCreateTime > 0) {
                String dv = com.baidu.tbadk.core.util.at.dv(this.mCreateTime);
                if (!StringUtils.isNull(dv)) {
                    this.eGF = dv;
                }
            }
            if (this.eFf.openRecomFans == 1) {
                int i = 0;
                if (this.eFf != null && this.eFf.user_info != null) {
                    i = this.eFf.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eGF) && i > 0) {
                    this.eGF += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.dy(i);
                } else if (i > 0) {
                    this.eGF = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.dy(i);
                }
            }
        }
    }

    private void bnc() {
        if (blk() || (bos() && getType() != eDX)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dt = com.baidu.tbadk.core.util.at.dt(j);
                if (com.baidu.tbadk.core.util.at.BW(dt)) {
                    dt = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.eGF = dt;
            }
            String str = "";
            if (this.eEK != null && this.eEK.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eEK.getBaijiahaoInfo().auth_desc)) {
                str = this.eEK.getBaijiahaoInfo().auth_desc;
            }
            if (boB()) {
                bnd();
            } else if (!this.eGO && this.eEK != null && this.eEK.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eEK.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eGF)) {
                    this.eGF += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eGF = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eGF) && !TextUtils.isEmpty(str)) {
                this.eGF += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eGF = str;
            }
        } else if (getType() == eDX || getType() == eEa) {
            bnb();
        } else {
            long bmt = bmt() * 1000;
            if (bmt != 0) {
                String dt2 = com.baidu.tbadk.core.util.at.dt(bmt);
                if (com.baidu.tbadk.core.util.at.BW(dt2)) {
                    dt2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bmt);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bkj()) {
                    dt2 = com.baidu.tbadk.core.util.at.du(bmt);
                }
                this.eGF = string + dt2;
            } else {
                long j2 = this.mCreateTime;
                String dt3 = com.baidu.tbadk.core.util.at.dt(j2);
                if (com.baidu.tbadk.core.util.at.BW(dt3)) {
                    dt3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.eGF = dt3;
            }
            if (boB()) {
                bnd();
            } else if (!this.eGO && this.eEK != null && this.eEK.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eEK.getBazhuGradeData().getDesc(), this.eGN ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eGF)) {
                    this.eGF += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eGF = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eGF) && !TextUtils.isEmpty(getAddress())) {
                this.eGF += " • " + getAddress();
            }
        }
    }

    private void bnd() {
        if (boB() && !TextUtils.isEmpty(this.eEK.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eGF)) {
                this.eGF += "   " + this.eEK.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.eGF = this.eEK.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void bne() {
        if (!blk() && !bos()) {
            long bmt = 1000 * bmt();
            if (bmt != 0) {
                String dt = com.baidu.tbadk.core.util.at.dt(bmt);
                if (com.baidu.tbadk.core.util.at.BW(dt)) {
                    dt = com.baidu.tbadk.core.util.at.getFormatTimeShort(bmt);
                }
                this.eGF = dt;
            }
            if (boB()) {
                bnd();
            } else if (!this.eGO && this.eEK != null && this.eEK.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eEK.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eGF)) {
                    this.eGF += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eGF = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eGF) && !TextUtils.isEmpty(getAddress())) {
                this.eGF += " • " + getAddress();
            }
        }
    }

    private void bnf() {
        if (bmU() == null || bmU().share_info == null || bmU().share_info.share_user_count <= 0 || !bnU() || (this.eGl > 0 && this.eGm == 0)) {
            this.eGG = null;
            return;
        }
        int i = bmU().share_info.share_user_count;
        if (i == 1) {
            this.eGG = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eGG = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void bng() {
        this.eEy = bnx();
        com.baidu.tieba.card.n.a(this, this.eEy, true);
    }

    private void bnh() {
        this.eBQ = bnv();
    }

    private void bni() {
        this.eGH = com.baidu.tbadk.core.util.at.getFormatTimeShort(bmt() * 1000);
    }

    private void bnj() {
        this.eGI = com.baidu.tbadk.core.util.at.getFormatTimeShort(bmt());
    }

    public SpannableStringBuilder bnk() {
        return this.eEx;
    }

    public boolean isTop() {
        return bmv() != 0;
    }

    public int bnl() {
        if (this.eFB != null) {
            long blS = this.eFB.blS();
            long blT = this.eFB.blT();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < blS) {
                return 1;
            }
            if (currentTimeMillis > blT) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bnm() {
        if (bno() && this.eFl.size() >= 1) {
            a aVar = this.eFl.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bkn = aVar.bkn();
            int bko = aVar.bko();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bkn) {
                return 4;
            }
            return currentTimeMillis > bko ? 2 : 1;
        }
        return -1;
    }

    public int bnn() {
        if (!bno() || this.eFl.size() < 1 || this.eFl.get(0) == null) {
            return -1;
        }
        return this.eFl.get(0).bkm();
    }

    public boolean bno() {
        return this.eEZ == 1;
    }

    public String getActUrl() {
        return (!bno() || this.eFl.size() < 1 || this.eFl.get(0) == null) ? "" : this.eFl.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Be(String str) {
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

    public SmartApp bnp() {
        return this.eGC;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bnr()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bmv() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bmv() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bmx() == 1 || this.eEJ.boP() != 0) {
                if (bmg() != null && getThreadType() == 41) {
                    if (bnl() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bnI()) {
                Integer num = eFq.get(Integer.valueOf(bnl()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bmw() == 1 && !isTop() && eDW != getType() && eEf != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eEW != null && this.eEW.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bmF() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eFp.get(new Point(bnn(), bnm()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bmL() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bmM() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Be(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eEr));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bns = bns();
        if (bns != null) {
            spannableStringBuilder.append((CharSequence) bns);
        }
        this.eEx = spannableStringBuilder;
    }

    public boolean bnq() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bmA() != null) {
            if (bmA().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bmA().getGender() == 2) {
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

    private boolean bnr() {
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
        SpannableStringBuilder bns = bns();
        if (z) {
            spannableStringBuilder = a(bns.toString(), bns, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bns);
        }
        this.eEx = spannableStringBuilder;
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
            if (this.eEs == 1) {
                this.eEx = a3;
                return a3;
            }
        } else if (this.eEs == 1) {
            this.eEx = new SpannableStringBuilder();
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

    public void dG(String str, String str2) {
        this.mUrl = str;
        this.eFG = str2;
    }

    public SpannableStringBuilder bns() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eEu, this.title);
    }

    public SpannableStringBuilder bnt() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eEv, this.eEt);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bnu() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eGX) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bnv() {
        SpannableStringBuilder bnt = bnt();
        com.baidu.tieba.card.n.a(this, bnt, false);
        return new SpannableString(bnt);
    }

    public SpannableString bnw() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eEw)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eEw, this.eEt));
    }

    public String getAbstract() {
        return this.eEt;
    }

    public void Bf(String str) {
        this.eEt = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bns;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eEs == 1) {
            bns = bnt();
            spannableStringBuilder = bns.toString();
        } else {
            bns = bns();
            spannableStringBuilder = bns.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bns, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bns);
        }
        this.eEx = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bnt;
        if (!StringUtils.isNull(this.title) && this.eEs != 1) {
            bnt = bns();
        } else {
            bnt = bnt();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bnt);
        this.eEx = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bnx() {
        if (StringUtils.isNull(this.title) || this.eEs == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bns());
        this.eEx = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData blf() {
        if (this.eEu != null && this.eEu.size() > 0) {
            int size = this.eEu.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eEu.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && blg() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Er(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bny() {
        y(false, false);
    }

    public void bnz() {
        y(false, true);
    }

    public AnchorInfoData bnA() {
        return this.eEW;
    }

    public boolean bnB() {
        return this.threadType == 36;
    }

    public boolean blg() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bnC() {
        return this.threadType == 11 || this.eET == 1;
    }

    public boolean bnD() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bmJ = bmJ();
        if (bmJ == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bmJ.size() || i2 >= 3) {
                break;
            }
            if (bmJ.get(i2) != null && bmJ.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bmJ.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bmJ.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bmJ.get(i2).getPicUrl();
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
        if (this.eFc != null && !StringUtils.isNull(this.eFc.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eFc.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eEK != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eEK.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bnE() {
        String userId;
        return this.eEK == null || (userId = this.eEK.getUserId()) == null || userId.equals("0");
    }

    public boolean bnF() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bop()) {
            if (bmS() != null) {
                return eDW;
            }
            return eDA;
        }
        int bmv = bmv();
        if (this.eGq == 1) {
            if (this.eGr != null) {
                return eDN;
            }
            return this.eGu != null ? eEh : eEg;
        } else if (this.eFf != null && this.threadType == 60) {
            return eDZ;
        } else {
            if (this.eFf != null && this.threadType == 49) {
                return eDX;
            }
            if (this.eFf != null && this.threadType == 67) {
                return eEa;
            }
            if (this.threadType == 51) {
                return eDY;
            }
            if (this.threadType == 63) {
                return eEi;
            }
            if (this.threadType == 64) {
                return eEj;
            }
            if (bmv == 2 || bmv == 1) {
                return eDz;
            }
            if (this.eFc != null && bnN() && !bnF()) {
                return eEo;
            }
            if (this.eFc != null && !bnF()) {
                if (bmD()) {
                    return eEf;
                }
                return eDW;
            } else if (this.isShareThread && this.eGn != null) {
                if (this.eGn.eBR) {
                    if (this.eGn.videoInfo != null) {
                        return eEe;
                    }
                    if (this.eGn.bli()) {
                        return eEd;
                    }
                    return eEc;
                }
                return eEb;
            } else if (bli()) {
                return eDO;
            } else {
                if (bnH()) {
                    return eEl.get() ? eFA : eDA;
                } else if (bno() && bnn() == 1) {
                    return eEl.get() ? eFI : eDA;
                } else if (isLinkThread()) {
                    return eDU;
                } else {
                    if (bmD()) {
                        return eDV;
                    }
                    if (this.eDg) {
                        return eDF;
                    }
                    if (this.eDh) {
                        return eDG;
                    }
                    if (this.eDi) {
                        return eDH;
                    }
                    if (this.eDj) {
                        return eDI;
                    }
                    if (this.eDk) {
                        return eDJ;
                    }
                    if (this.eDm) {
                        return eDL;
                    }
                    if (this.eDn) {
                        return eDM;
                    }
                    if (this.eDl) {
                        return eDK;
                    }
                    if (this.eFj) {
                        int bnG = bnG();
                        if (bnG == 1) {
                            return eDB;
                        }
                        if (bnG == 2) {
                            return eDC;
                        }
                        if (bnG > 2) {
                            return eDD;
                        }
                        return eDA;
                    }
                    return eDA;
                }
            }
        }
    }

    public int bnG() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bjH().isShowImages() || com.baidu.tbadk.core.util.y.getCount(bmJ()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bmJ().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bmJ(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bnH() {
        return bmg() != null && getThreadType() == 41 && bmx() == 1 && bnl() == 2;
    }

    public void F(ArrayList<s> arrayList) {
        if (this.eEs == 1) {
            this.eAd = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eAd = 0;
        } else {
            this.eAd = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.bkC() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bkC().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eAd = next.bkD();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bnI() {
        return this.threadType == 41;
    }

    public boolean bnJ() {
        return this.eFJ;
    }

    public void iN(boolean z) {
        this.eFJ = z;
    }

    public String bnK() {
        return this.eFK;
    }

    public r bnL() {
        return this.eFo;
    }

    public void bnM() {
        if (this.eFh == 0) {
            this.eFh = 1;
        }
    }

    public void iO(boolean z) {
        this.eFW = z;
    }

    public boolean bnN() {
        return this.eFW;
    }

    public void op(int i) {
        this.eFX = i + 1;
    }

    public int bnO() {
        return this.eFX;
    }

    public boolean bnP() {
        return this.eGM;
    }

    public void iP(boolean z) {
        this.eGM = z;
    }

    public cd bnQ() {
        return this.eFe;
    }

    public boolean bnR() {
        return getThreadType() == 49;
    }

    public boolean bnS() {
        return getThreadType() == 40;
    }

    public boolean bnT() {
        return getThreadType() == 50;
    }

    public boolean bnU() {
        return getThreadType() == 60;
    }

    public int bnV() {
        return this.eGd;
    }

    public void setSmartFrsPosition(int i) {
        this.eGd = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bnW() {
        return this.mRecomSource;
    }

    public boolean bnX() {
        return this.eGe;
    }

    public long bnY() {
        return this.agreeData.agreeNum;
    }

    public long bnZ() {
        return this.agreeData.disAgreeNum;
    }

    public int boa() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bob() {
        return this.agreeData.agreeType;
    }

    public void oq(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void or(int i) {
        this.agreeData.agreeNum = i;
    }

    public void di(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dj(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void os(int i) {
        this.agreeData.agreeType = i;
    }

    public long boc() {
        return this.eGg;
    }

    public void dk(long j) {
        this.eGg = j;
    }

    public PostData bod() {
        return this.eGf;
    }

    public am boe() {
        return this.eGh;
    }

    private ArrayList<n.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean bmB = bmB();
        if (z2) {
            if (z) {
                if (bmB && !blg()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if (bmx() == 1 || getThreadType() == 33 || (bmz() != null && bmz().boP() != 0)) {
                    if (bmg() != null && bnI()) {
                        if (bnl() == 2) {
                            arrayList.add(new n.a(R.string.interview_live));
                        }
                    } else if (!bmB) {
                        arrayList.add(new n.a(R.string.photo_live_tips));
                    }
                }
                if (bnI()) {
                    arrayList.add(eGa.get(bnl()));
                }
                if (bno()) {
                    Integer num = eFZ.get(new Point(bnn(), bnm()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (bmL() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (bmB && bmv() != 1 && !blg()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if ((bmx() == 1 || getThreadType() == 33) && !bnI() && !bmB) {
                    arrayList.add(new n.a(R.string.photo_live_tips));
                }
                if (bmw() == 1) {
                    arrayList.add(new n.a(R.string.good));
                }
                if (bmv() == 1) {
                    arrayList.add(new n.a(R.string.top));
                }
                if (bnI() && bmg() != null && bnl() == 2) {
                    arrayList.add(new n.a(R.string.interview_live));
                }
                if (bno()) {
                    Integer num2 = eFZ.get(new Point(bnn(), bnm()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (this.eFL == 1) {
                    arrayList.add(new n.a(R.string.card_tbread_text));
                }
                if (bmM() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (bmL() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && bnR()) {
                    arrayList.add(new n.a(R.string.ala_live));
                }
                if (z3 && bnT()) {
                    arrayList.add(new n.a(R.string.live_record));
                } else if (bnS()) {
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
        this.eEN = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eEO = arrayList;
    }

    public String bof() {
        return this.eGs;
    }

    public void Bg(String str) {
        this.eGs = str;
    }

    public void bog() {
        this.eGq = 1;
    }

    public boolean boh() {
        return this.eGq == 1;
    }

    public String boi() {
        return this.eEA;
    }

    public void Bh(String str) {
        this.eEA = str;
    }

    public String boj() {
        return this.eEB;
    }

    public void Bi(String str) {
        this.eEB = str;
    }

    public String bok() {
        return this.eGt;
    }

    public void Bj(String str) {
        this.eGt = str;
    }

    public boolean bol() {
        return this.eGw;
    }

    public void iQ(boolean z) {
        this.eGw = z;
    }

    public boolean bom() {
        return this.eGx;
    }

    public void iR(boolean z) {
        this.eGx = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eGu = videoInfo;
    }

    public boolean bon() {
        return this.eGy != null;
    }

    public bs boo() {
        return this.eEz;
    }

    public boolean bop() {
        return this.eGB;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eFc != null) {
            return this.eFc.video_url;
        }
        return null;
    }

    public boolean boq() {
        return this.eGD;
    }

    public void iS(boolean z) {
        this.eGD = z;
    }

    public AgreeData bor() {
        return this.agreeData;
    }

    public boolean bos() {
        return this.eGP;
    }

    public void iT(boolean z) {
        this.eGP = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean bki() {
        return this.eGN;
    }

    public void iU(boolean z) {
        this.eGN = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bot() {
        return this.eGr;
    }

    public String getShareImageUrl() {
        return this.eGJ;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bmJ = bmJ();
        if (com.baidu.tbadk.core.k.bjH().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bmJ) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < bmJ.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bmJ, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(bmJ, 0);
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

    public boolean bou() {
        return bov() || bow();
    }

    public boolean bli() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean blj() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bov() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bow() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean blk() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return blk();
    }

    public void ot(int i) {
        this.isBjh = i;
    }

    public int box() {
        return this.eGW;
    }

    public String boy() {
        return this.eGV;
    }

    public void Bk(String str) {
        this.eGV = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int boz() {
        if (bmC()) {
            return 4;
        }
        if (bnR() || bnT()) {
            return 3;
        }
        if (bli()) {
            return 5;
        }
        if (blj()) {
            return 6;
        }
        if (bov()) {
            return 7;
        }
        if (bow()) {
            return 8;
        }
        if (this.isShareThread && this.eGn != null) {
            return 9;
        }
        if (bnS()) {
            return 2;
        }
        return 1;
    }

    public int boA() {
        if (bow() || bov()) {
            return 2;
        }
        if (bli() || blj()) {
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

    public boolean boB() {
        return this.eEK != null && this.eEK.isNewGod();
    }

    public boolean boC() {
        return (bmA() == null || bmA().getAlaUserData() == null || bmA().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item boD() {
        return this.eHe;
    }

    public List<HeadItem> boE() {
        return this.eHf;
    }

    public void a(Item item) {
        this.eHe = item;
    }

    public void bo(List<HeadItem> list) {
        this.eHf = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData boF() {
        return this.eHg;
    }

    public void b(PollData pollData) {
        this.eHg = pollData;
    }

    public List<PbLinkData> boG() {
        return this.eHb;
    }

    public void bp(List<PbLinkData> list) {
        this.eHb = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eHb)) {
            for (PbLinkData pbLinkData : this.eHb) {
                if (pbLinkData.urlType == 2 && !this.eHd) {
                    this.eHd = true;
                }
            }
        }
    }

    public List<PbGoodsData> boH() {
        return this.eHc;
    }

    public void bq(List<PbGoodsData> list) {
        this.eHc = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eHd) {
            this.eHd = true;
        }
    }

    public boolean boI() {
        return this.eHd;
    }
}

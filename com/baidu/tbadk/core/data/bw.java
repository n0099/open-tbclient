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
    private String bmC;
    public String buttonText;
    private TopicModule eAC;
    private String eAD;
    private String eAE;
    private VideoInfo eAF;
    private String eAG;
    private boolean eAI;
    public OriginalForumInfo eAJ;
    public boolean eAK;
    private String eAL;
    private boolean eAM;
    private SmartApp eAN;
    private String eAP;
    private String eAQ;
    private String eAR;
    private String eAS;
    private String eAT;
    public String eAU;
    private boolean eAX;
    private boolean eAY;
    public boolean eAZ;
    public String eAa;
    public int eAb;
    public int eAc;
    public String eAd;
    public String eAe;
    public long eAf;
    private List<ReportInfo> eAj;
    private boolean eAp;
    private long eAr;
    private am eAs;
    public e eAu;
    private MediaData eAv;
    public int eAw;
    public OriginalThreadInfo eAy;
    public boolean eBa;
    public boolean eBb;
    public boolean eBc;
    public boolean eBd;
    public boolean eBe;
    public String eBf;
    private String eBg;
    private int eBh;
    public String eBj;
    private String eBk;
    private ThreadInfo eBl;
    private boolean eBo;
    private Item eBp;
    private List<HeadItem> eBq;
    PollData eBr;
    public int eBt;
    public String eBu;
    public String eBv;
    public String eBw;
    public int evR;
    private SpannableString evX;
    private int eyD;
    private SpannableStringBuilder eyI;
    private SpannableStringBuilder eyJ;
    private bs eyK;
    private String eyL;
    private String eyM;
    private LiveCoverStatus ezF;
    private long ezG;
    public TwZhiBoUser ezN;
    public List<TwAnchorProfitItem> ezO;
    private SkinInfo ezS;
    private boolean ezU;
    private String ezV;
    private boolean ezY;
    public int eza;
    private int ezb;
    private int eze;
    public int ezf;
    private String ezi;
    private String ezj;
    private int ezl;
    private VideoInfo ezn;
    private VideoDesc ezo;
    private cd ezp;
    private AlaInfoData ezq;
    private long ezr;
    private r ezz;
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
    public static final BdUniqueId exI = BdUniqueId.gen();
    public static final BdUniqueId exJ = BdUniqueId.gen();
    public static final BdUniqueId exK = BdUniqueId.gen();
    public static final BdUniqueId exL = BdUniqueId.gen();
    public static final BdUniqueId exM = BdUniqueId.gen();
    public static final BdUniqueId exN = BdUniqueId.gen();
    public static final BdUniqueId exO = BdUniqueId.gen();
    public static final BdUniqueId exP = BdUniqueId.gen();
    public static final BdUniqueId exQ = BdUniqueId.gen();
    public static final BdUniqueId exR = BdUniqueId.gen();
    public static final BdUniqueId exS = BdUniqueId.gen();
    public static final BdUniqueId exT = BdUniqueId.gen();
    public static final BdUniqueId exU = BdUniqueId.gen();
    public static final BdUniqueId exV = BdUniqueId.gen();
    public static final BdUniqueId exW = BdUniqueId.gen();
    public static final BdUniqueId exX = BdUniqueId.gen();
    public static final BdUniqueId exY = BdUniqueId.gen();
    public static final BdUniqueId exZ = BdUniqueId.gen();
    public static final BdUniqueId eya = BdUniqueId.gen();
    public static final BdUniqueId eyb = BdUniqueId.gen();
    public static final BdUniqueId eyc = BdUniqueId.gen();
    public static final BdUniqueId eyd = BdUniqueId.gen();
    public static final BdUniqueId eyf = BdUniqueId.gen();
    public static final BdUniqueId eyg = BdUniqueId.gen();
    public static final BdUniqueId eyh = BdUniqueId.gen();
    public static final BdUniqueId eyi = BdUniqueId.gen();
    public static final BdUniqueId eyj = BdUniqueId.gen();
    public static final BdUniqueId eyk = BdUniqueId.gen();
    public static final BdUniqueId eyl = BdUniqueId.gen();
    public static final BdUniqueId eyn = BdUniqueId.gen();
    public static final BdUniqueId eyo = BdUniqueId.gen();
    public static final BdUniqueId eyp = BdUniqueId.gen();
    public static final BdUniqueId eyq = BdUniqueId.gen();
    public static final BdUniqueId eyr = BdUniqueId.gen();
    public static final BdUniqueId eys = BdUniqueId.gen();
    public static final BdUniqueId eyt = BdUniqueId.gen();
    public static final BdUniqueId eyu = BdUniqueId.gen();
    public static final BdUniqueId eyv = BdUniqueId.gen();
    public static AtomicBoolean eyw = new AtomicBoolean(false);
    public static AtomicBoolean eyx = new AtomicBoolean(false);
    public static AtomicBoolean eyy = new AtomicBoolean(false);
    public static final BdUniqueId eyz = BdUniqueId.gen();
    private static HashMap<Point, Integer> ezA = new HashMap<>();
    private static HashMap<Integer, Integer> ezB = new HashMap<>();
    public static final BdUniqueId ezL = BdUniqueId.gen();
    public static final BdUniqueId ezT = BdUniqueId.gen();
    private static HashMap<Point, Integer> eAk = new HashMap<>();
    private static SparseArray<n.a> eAl = new SparseArray<>(3);
    public boolean exo = false;
    public boolean exp = false;
    public boolean exq = false;
    public boolean exr = false;
    public boolean exs = false;
    public boolean exu = false;
    public boolean exv = false;
    public boolean exw = false;
    private int eyA = 0;
    private String eyB = "1";
    public int eyC = 1;
    private String ezd = null;
    private int euk = 0;
    public int ezs = 0;
    private String ezt = "";
    public boolean ezu = false;
    private String ezC = "";
    public boolean eAg = true;
    public boolean eAm = false;
    public boolean eAn = false;
    private int eAo = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> evN = null;
    public boolean eAt = false;
    private int eAB = 0;
    private boolean eAH = false;
    private boolean eAO = false;
    public boolean eAV = false;
    public boolean eAW = false;
    public boolean forbidComment = false;
    public boolean eBi = false;
    public boolean eBx = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eyN = 0;
    private int eyO = 0;
    private String last_time = null;
    private long eyP = 0;
    private int eyQ = 0;
    private int eyR = 0;
    private int eyS = 0;
    private int eyT = 0;
    private ca eyU = new ca();
    private MetaData eyV = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eyY = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eyZ = new ArrayList<>();
    private int eyW = 0;
    private int eyX = 0;
    private String ad_url = null;
    private String eyE = null;
    private String from = null;
    private int ezc = 0;
    private PraiseData ezg = new PraiseData();
    private AnchorInfoData ezh = new AnchorInfoData();
    private long time = 0;
    private int ezk = 0;
    private ArrayList<a> ezw = new ArrayList<>();
    private ci ezx = null;
    private f ezy = null;
    private int ezD = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> ezm = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ezE = null;
    private int ezv = 0;
    private boolean ezH = false;
    private boolean ezI = false;
    private int ezJ = 0;
    private boolean ezK = false;
    private int anchorLevel = 0;
    public int ezW = 0;
    public o ezX = new o();
    private List<PbContent> eyH = new ArrayList();
    private List<PbContent> eyF = new ArrayList();
    private List<PbContent> eyG = new ArrayList();
    private String category_name = null;
    private bu ezM = new bu();
    private ArrayList<com.baidu.tbadk.data.c> ezP = new ArrayList<>();
    private PushStatusData ezQ = new PushStatusData();
    public boolean eAh = false;
    public int eAi = -1;
    private PostData eAq = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int ezZ = 0;
    public int eAx = 0;
    private String tieba_game_information_source = "";
    public String eAA = "";
    public String eAz = "";
    public String mUrl = "";
    public String ezR = "";
    private List<PbLinkData> eBm = new ArrayList();
    private List<PbGoodsData> eBn = new ArrayList();
    public int eBs = -1;

    static {
        ezA.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        ezA.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        ezA.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        ezA.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        ezA.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        ezA.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        ezA.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        ezA.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eAk.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eAk.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eAk.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eAk.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eAk.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eAk.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eAk.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eAk.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        ezB.put(1, Integer.valueOf(R.drawable.label_interview_no));
        ezB.put(2, Integer.valueOf(R.drawable.label_interview_live));
        ezB.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eAl.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        eAl.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        eAl.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bw() {
        this.ezb = 0;
        this.ezl = 0;
        this.ezG = 0L;
        this.eAw = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ezG = 0L;
        this.ezl = 0;
        this.ezb = 0;
        this.eAw = 0;
    }

    public String bjx() {
        return this.eAP;
    }

    public String bjy() {
        return this.eAQ;
    }

    public void AL(String str) {
        this.eAQ = str;
    }

    public String bjz() {
        return this.eAR;
    }

    public SpannableStringBuilder bjA() {
        return this.eyJ;
    }

    public SpannableString bjB() {
        return this.evX;
    }

    public void a(SpannableString spannableString) {
        if (bka() != null && !bhK() && !bhJ()) {
            if (this.eyJ != null) {
                this.eyJ.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.evX);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.evX = new SpannableString(spannableStringBuilder);
        }
    }

    public void bjC() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eBq) > 0) {
            if (this.eyJ != null) {
                this.eyJ.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.by(this.eBq));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.evX);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.by(this.eBq));
            this.evX = new SpannableString(spannableStringBuilder);
        }
    }

    public String bjD() {
        return this.eAS;
    }

    public String bjE() {
        return this.eAT;
    }

    public boolean bjF() {
        return this.ezb == 1;
    }

    public bu bjG() {
        return this.ezM;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void nW(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.ezl;
    }

    public void nX(int i) {
        this.ezJ = i;
    }

    public int bjH() {
        return this.ezJ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bjI() {
        return this.eAF;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void cK(long j) {
        this.mCreateTime = j;
    }

    public long bjJ() {
        return this.ezr;
    }

    public String bjK() {
        return this.ezi;
    }

    public PraiseData bjL() {
        return this.ezg;
    }

    public void a(PraiseData praiseData) {
        this.ezg = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bjM() {
        return this.bmC;
    }

    public void AM(String str) {
        this.bmC = str;
    }

    public String bjN() {
        return this.eyB;
    }

    public void AN(String str) {
        this.eyB = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nY(int i) {
        this.eyA = i;
    }

    public int bjO() {
        return this.eyA;
    }

    public String bjP() {
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

    public List<PbContent> bjQ() {
        return this.eyH;
    }

    public void be(List<PbContent> list) {
        this.eyH = list;
    }

    public void bf(List<PbContent> list) {
        this.eyF = list;
    }

    public void bg(List<PbContent> list) {
        this.eyG = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nZ(int i) {
        this.reply_num = i;
    }

    public int bjR() {
        return this.reply_num;
    }

    public int bjS() {
        return this.eyO;
    }

    public void oa(int i) {
        this.eyO = i;
    }

    public long bjT() {
        return this.eyP;
    }

    public void cL(long j) {
        this.eyP = j;
    }

    public int bjU() {
        return this.eyR;
    }

    public int bjV() {
        return this.eyQ;
    }

    public void ob(int i) {
        this.eyQ = i;
    }

    public int bjW() {
        return this.eyS;
    }

    public void oc(int i) {
        this.eyS = i;
    }

    public int bjX() {
        return this.eyT;
    }

    public List<PbContent> bjY() {
        return this.eyF;
    }

    public ca bjZ() {
        return this.eyU;
    }

    public MetaData bka() {
        return this.eyV;
    }

    public boolean bkb() {
        return this.is_god != 0;
    }

    public boolean bkc() {
        return this.is_god == 1;
    }

    public boolean bkd() {
        return (this.eyV == null || this.eyV.getGodUserData() == null || this.eyV.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eyV = metaData;
    }

    public String bke() {
        return this.forum_name;
    }

    public void AO(String str) {
        this.forum_name = str;
    }

    public int bkf() {
        return this.eyX;
    }

    public String bkg() {
        return this.ad_url;
    }

    public int bkh() {
        return this.ezc;
    }

    public void od(int i) {
        this.ezc = i;
    }

    public String bki() {
        return this.ezd;
    }

    public void AP(String str) {
        this.ezd = str;
    }

    public ArrayList<MediaData> bkj() {
        return this.eyY;
    }

    public ArrayList<a> bkk() {
        return this.ezw;
    }

    public void E(ArrayList<a> arrayList) {
        this.ezw = arrayList;
    }

    public ci bkl() {
        return this.ezx;
    }

    public f bkm() {
        return this.ezy;
    }

    public ArrayList<VoiceData.VoiceModel> bkn() {
        return this.eyZ;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bko() {
        return this.eyD;
    }

    public void oe(int i) {
        this.eyD = i;
    }

    public String bkp() {
        return this.latitude;
    }

    public String bkq() {
        return this.ezj;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bkr() {
        return this.ezt;
    }

    public VideoInfo bks() {
        return this.ezn;
    }

    public void a(VideoInfo videoInfo) {
        this.ezn = videoInfo;
    }

    public VideoDesc bkt() {
        return this.ezo;
    }

    public void a(AlaInfoData alaInfoData) {
        this.ezq = alaInfoData;
    }

    public AlaInfoData bku() {
        return this.ezq;
    }

    public PushStatusData bkv() {
        return this.ezQ;
    }

    public SkinInfo bkw() {
        return this.ezS;
    }

    public long bkx() {
        return this.eAf;
    }

    public boolean bky() {
        return this.eAg;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bhA() {
        return this.eAe;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bhz().getTid());
        arVar.setFid(bhz().getFid());
        arVar.setNid(bhz().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.evN = this.evN;
        arVar.abTag = this.mRecomAbTag;
        arVar.weight = this.mRecomWeight;
        arVar.extra = this.mRecomExtra;
        arVar.source = this.mRecomSource;
        arVar.evR = this.evR;
        arVar.cardType = blZ();
        return arVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ezj = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ezb = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ezr = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eyN = threadInfo.repost_num.intValue();
                this.eyO = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eyP = threadInfo.last_time_int.intValue();
                this.eyQ = threadInfo.is_top.intValue();
                this.eyR = threadInfo.is_membertop.intValue();
                this.eyS = threadInfo.is_good.intValue();
                this.eyT = threadInfo.is_livepost.intValue();
                this.eyU.a(threadInfo.topic);
                this.eyV.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eyW = threadInfo.has_commented.intValue();
                this.eyX = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ezn = threadInfo.video_info;
                this.ezo = threadInfo.video_segment;
                this.ezq = new AlaInfoData();
                this.ezq.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.ezc = threadInfo.collect_status.intValue();
                this.ezd = threadInfo.collect_mark_pid;
                this.eze = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ezf = threadInfo.thread_type.intValue();
                this.ezi = threadInfo.first_post_id + "";
                this.ezt = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eyD = threadInfo.is_ntitle.intValue();
                this.ezk = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eAr = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.ezl = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ezY = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eyF = threadInfo.rich_title;
                this.eyH = threadInfo.first_post_content;
                this.eyG = threadInfo.rich_abstract;
                this.eza = threadInfo.is_godthread_recommend.intValue();
                if ((this.eyV == null || this.eyV.getUserId() == null || this.eyV.getUserId().equals("0") || this.eBx) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eyV = metaData;
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
                this.eyE = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eyY.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ezn = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ezp = new cd();
                    this.ezp.a(threadInfo.video_channel_info);
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
                        this.eyZ.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ezw.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ezx = new ci();
                    this.ezx.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ezy = new f();
                    this.ezy.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ezz = new r();
                    this.ezz.a(threadInfo.cartoon_info);
                }
                this.ezg.setUserMap(this.userMap);
                this.ezg.parserProtobuf(threadInfo.zan);
                this.ezh.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ezg.setTitle(this.title);
                } else {
                    this.ezg.setTitle(this.eyE);
                }
                this.ezC = threadInfo.livecover_src;
                this.ezD = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ezv = threadInfo.post_num.intValue();
                this.ezG = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qK(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.CT(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ezm.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ezE = noticeInfo.notice;
                    }
                    this.ezJ = zhiBoInfoTW.copythread_remind.intValue();
                    this.ezH = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ezI = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ezC)) {
                        this.ezC = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.ezN = zhiBoInfoTW.user.tw_anchor_info;
                        this.ezO = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ezF = threadInfo.twzhibo_info.livecover_status;
                    this.ezG = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.ezK = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ezM.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.ezP.add(cVar2);
                    }
                }
                this.ezQ.parserProtobuf(threadInfo.push_status);
                this.ezV = threadInfo.lego_card;
                this.ezS = threadInfo.skin_info;
                this.ezW = threadInfo.is_book_chapter.intValue();
                this.ezX.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eAe = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eAf = threadInfo.last_read_pid.longValue();
                this.eAg = threadInfo.cheak_repeat.intValue() == 1;
                this.eAj = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eAq.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.evN = sparseArray2;
                }
                this.eAp = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eAs = new am();
                    this.eAs.a(threadInfo.link_info);
                }
                this.eAt = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eAu = new e();
                    this.eAu.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eAv = new MediaData();
                    this.eAv.parserProtobuf(threadInfo.pic_info);
                }
                this.ezZ = threadInfo.is_called.intValue();
                this.eAw = threadInfo.middle_page_num.intValue();
                this.eAx = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eAz = threadInfo.star_rank_icon.icon_pic_url;
                    this.eAA = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eAy = new OriginalThreadInfo();
                    this.eAy.a(threadInfo.origin_thread_info);
                } else {
                    this.eAy = null;
                    this.isShareThread = false;
                }
                this.eAB = threadInfo.is_topic.intValue();
                this.eAD = threadInfo.topic_user_name;
                this.eAE = threadInfo.topic_h5_url;
                this.eAC = threadInfo.topic_module;
                this.eAG = threadInfo.presentation_style;
                this.eAJ = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eAL = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eyK = new bs();
                    this.eyK.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eAN = threadInfo.swan_info;
                }
                this.eAU = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.eAV = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eBg = threadInfo.article_cover;
                this.eBh = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eBi = threadInfo.is_s_card.intValue() == 1;
                this.eBj = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eBk = threadInfo.wonderful_post_info;
                bkz();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eBl = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eBo) {
                            this.eBo = true;
                        }
                        this.eBm.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eBn.add(pbGoodsData);
                    }
                    if (this.eBn.size() > 0 && !this.eBo) {
                        this.eBo = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eBp = threadInfo.item;
                }
                if (this.eBp != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eBp);
                }
                this.eBq = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eBq)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eBq);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eBr == null) {
                        this.eBr = new PollData();
                    }
                    this.eBr.parserProtobuf(threadInfo.poll_info);
                }
                this.eBs = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eBt = threadInfo.distance.intValue();
                this.eBu = threadInfo.distance_text;
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
                this.ezr = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eyN = jSONObject.optInt("repost_num", 0);
                this.eyO = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eyP = jSONObject.optLong("last_time_int", 0L);
                this.eyQ = jSONObject.optInt("is_top", 0);
                this.eyR = jSONObject.optInt("is_membertop", 0);
                this.eyS = jSONObject.optInt("is_good", 0);
                this.eyT = jSONObject.optInt("is_livepost", 0);
                this.eyU.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.eyV.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eyW = jSONObject.optInt("has_commented", 0);
                this.eyX = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.ezc = jSONObject.optInt("collect_status");
                this.ezd = jSONObject.optString("collect_mark_pid");
                this.eze = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ezf = jSONObject.optInt("thread_type");
                this.eAr = jSONObject.optLong("share_num");
                this.ezi = jSONObject.optString("first_post_id", "0");
                this.ezt = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eyD = jSONObject.optInt("is_ntitle");
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
                    this.evN = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ezM.parserJson(optJSONObject2);
                }
                if ((this.eyV == null || this.eyV.getUserId() == null) && this.userMap != null) {
                    this.eyV = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.ezq = new AlaInfoData();
                this.ezq.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eyE = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eyY.add(mediaData);
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
                        this.eyZ.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ezw.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ezx = new ci();
                    this.ezx.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ezy = new f();
                    this.ezy.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ezz = new r();
                    this.ezz.parserJson(optJSONObject6);
                }
                this.ezg.setUserMap(this.userMap);
                this.ezg.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ezh.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ezg.setTitle(this.title);
                } else {
                    this.ezg.setTitle(this.eyE);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ezM.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.ezP.add(cVar);
                    }
                }
                this.ezW = jSONObject.optInt("is_book_chapter", 0);
                this.ezX.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eAe = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eAa = jSONObject.optString("recom_extra_img");
                this.eAd = jSONObject.optString("recom_extra_img_night");
                this.eAb = jSONObject.optInt("recom_extra_img_width", 0);
                this.eAc = jSONObject.optInt("recom_extra_img_height", 0);
                this.eAf = jSONObject.optLong("last_read_pid");
                this.eAg = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.ezp = new cd();
                    this.ezp.df(optJSONObject8);
                }
                this.eAp = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eAs = new am();
                    this.eAs.parserJson(optJSONObject9);
                }
                this.eAt = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eAu = new e();
                    this.eAu.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eAv = new MediaData();
                    this.eAv.parserJson(optJSONObject11);
                }
                this.ezZ = jSONObject.optInt("is_called", 0);
                this.eAw = jSONObject.optInt("middle_page_num", 0);
                this.eAx = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.ezn = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eAy = new OriginalThreadInfo();
                        this.eAy.parserJson(optJSONObject13);
                    } else {
                        this.eAy = null;
                    }
                } else {
                    this.eAy = null;
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
                    this.eAN = builder2.build(false);
                }
                this.eAU = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.eAV = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eBh = jSONObject.optInt("bjh_content_tag");
                this.eBg = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eBi = jSONObject.optInt("is_s_card", 0) == 1;
                this.eBj = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eBk = jSONObject.optString("wonderful_post_info");
                bkz();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eBr == null) {
                        this.eBr = new PollData();
                    }
                    this.eBr.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eBo) {
                            this.eBo = true;
                        }
                        this.eBm.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eBn.add(pbGoodsData);
                    }
                    if (this.eBn.size() > 0 && !this.eBo) {
                        this.eBo = true;
                    }
                }
                this.eBs = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eBt = jSONObject.optInt("distance");
                this.eBu = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bkz() {
        bkA();
        bkC();
        bkF();
        bkG();
        bkH();
        bkI();
        bkJ();
    }

    private void bkA() {
        if (!StringUtils.isNull(this.eyV.getName_show())) {
            this.eAP = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eyV.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bkB() {
        if (this.ezq != null) {
            if (this.ezq.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cZ = com.baidu.tbadk.core.util.at.cZ(this.mCreateTime);
                if (!StringUtils.isNull(cZ)) {
                    this.eAQ = cZ;
                }
            }
            if (this.ezq.openRecomFans == 1) {
                int i = 0;
                if (this.ezq != null && this.ezq.user_info != null) {
                    i = this.ezq.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eAQ) && i > 0) {
                    this.eAQ += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.dc(i);
                } else if (i > 0) {
                    this.eAQ = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.dc(i);
                }
            }
        }
    }

    private void bkC() {
        if (biK() || (blS() && getType() != eyh)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cX = com.baidu.tbadk.core.util.at.cX(j);
                if (com.baidu.tbadk.core.util.at.BI(cX)) {
                    cX = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.eAQ = cX;
            }
            String str = "";
            if (this.eyV != null && this.eyV.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eyV.getBaijiahaoInfo().auth_desc)) {
                str = this.eyV.getBaijiahaoInfo().auth_desc;
            }
            if (bmb()) {
                bkD();
            } else if (!this.eAZ && this.eyV != null && this.eyV.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eyV.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eAQ)) {
                    this.eAQ += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eAQ = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eAQ) && !TextUtils.isEmpty(str)) {
                this.eAQ += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eAQ = str;
            }
        } else if (getType() == eyh || getType() == eyk) {
            bkB();
        } else {
            long bjT = bjT() * 1000;
            if (bjT != 0) {
                String cX2 = com.baidu.tbadk.core.util.at.cX(bjT);
                if (com.baidu.tbadk.core.util.at.BI(cX2)) {
                    cX2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bjT);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bhJ()) {
                    cX2 = com.baidu.tbadk.core.util.at.cY(bjT);
                }
                this.eAQ = string + cX2;
            } else {
                long j2 = this.mCreateTime;
                String cX3 = com.baidu.tbadk.core.util.at.cX(j2);
                if (com.baidu.tbadk.core.util.at.BI(cX3)) {
                    cX3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.eAQ = cX3;
            }
            if (bmb()) {
                bkD();
            } else if (!this.eAZ && this.eyV != null && this.eyV.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eyV.getBazhuGradeData().getDesc(), this.eAY ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eAQ)) {
                    this.eAQ += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eAQ = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eAQ) && !TextUtils.isEmpty(getAddress())) {
                this.eAQ += " • " + getAddress();
            }
        }
    }

    private void bkD() {
        if (bmb() && !TextUtils.isEmpty(this.eyV.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eAQ)) {
                this.eAQ += "   " + this.eyV.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.eAQ = this.eyV.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void bkE() {
        if (!biK() && !blS()) {
            long bjT = 1000 * bjT();
            if (bjT != 0) {
                String cX = com.baidu.tbadk.core.util.at.cX(bjT);
                if (com.baidu.tbadk.core.util.at.BI(cX)) {
                    cX = com.baidu.tbadk.core.util.at.getFormatTimeShort(bjT);
                }
                this.eAQ = cX;
            }
            if (bmb()) {
                bkD();
            } else if (!this.eAZ && this.eyV != null && this.eyV.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eyV.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eAQ)) {
                    this.eAQ += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eAQ = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eAQ) && !TextUtils.isEmpty(getAddress())) {
                this.eAQ += " • " + getAddress();
            }
        }
    }

    private void bkF() {
        if (bku() == null || bku().share_info == null || bku().share_info.share_user_count <= 0 || !blu() || (this.eAw > 0 && this.eAx == 0)) {
            this.eAR = null;
            return;
        }
        int i = bku().share_info.share_user_count;
        if (i == 1) {
            this.eAR = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eAR = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void bkG() {
        this.eyJ = bkX();
        com.baidu.tieba.card.n.a(this, this.eyJ, true);
    }

    private void bkH() {
        this.evX = bkV();
    }

    private void bkI() {
        this.eAS = com.baidu.tbadk.core.util.at.getFormatTimeShort(bjT() * 1000);
    }

    private void bkJ() {
        this.eAT = com.baidu.tbadk.core.util.at.getFormatTimeShort(bjT());
    }

    public SpannableStringBuilder bkK() {
        return this.eyI;
    }

    public boolean isTop() {
        return bjV() != 0;
    }

    public int bkL() {
        if (this.ezM != null) {
            long bjs = this.ezM.bjs();
            long bjt = this.ezM.bjt();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bjs) {
                return 1;
            }
            if (currentTimeMillis > bjt) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bkM() {
        if (bkO() && this.ezw.size() >= 1) {
            a aVar = this.ezw.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bhN = aVar.bhN();
            int bhO = aVar.bhO();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bhN) {
                return 4;
            }
            return currentTimeMillis > bhO ? 2 : 1;
        }
        return -1;
    }

    public int bkN() {
        if (!bkO() || this.ezw.size() < 1 || this.ezw.get(0) == null) {
            return -1;
        }
        return this.ezw.get(0).bhM();
    }

    public boolean bkO() {
        return this.ezk == 1;
    }

    public String getActUrl() {
        return (!bkO() || this.ezw.size() < 1 || this.ezw.get(0) == null) ? "" : this.ezw.get(0).getUrl();
    }

    private com.baidu.adp.widget.b AQ(String str) {
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

    public SmartApp bkP() {
        return this.eAN;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bkR()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bjV() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bjV() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bjX() == 1 || this.eyU.bmp() != 0) {
                if (bjG() != null && getThreadType() == 41) {
                    if (bkL() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bli()) {
                Integer num = ezB.get(Integer.valueOf(bkL()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bjW() == 1 && !isTop() && eyg != getType() && eyq != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.ezh != null && this.ezh.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bkf() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = ezA.get(new Point(bkN(), bkM()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bkl() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bkm() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = AQ(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eyC));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bkS = bkS();
        if (bkS != null) {
            spannableStringBuilder.append((CharSequence) bkS);
        }
        this.eyI = spannableStringBuilder;
    }

    public boolean bkQ() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bka() != null) {
            if (bka().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bka().getGender() == 2) {
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

    private boolean bkR() {
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
        SpannableStringBuilder bkS = bkS();
        if (z) {
            spannableStringBuilder = a(bkS.toString(), bkS, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bkS);
        }
        this.eyI = spannableStringBuilder;
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
            if (this.eyD == 1) {
                this.eyI = a3;
                return a3;
            }
        } else if (this.eyD == 1) {
            this.eyI = new SpannableStringBuilder();
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
        this.ezR = str2;
    }

    public SpannableStringBuilder bkS() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eyF, this.title);
    }

    public SpannableStringBuilder bkT() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eyG, this.eyE);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bkU() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eBi) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bkV() {
        SpannableStringBuilder bkT = bkT();
        com.baidu.tieba.card.n.a(this, bkT, false);
        return new SpannableString(bkT);
    }

    public SpannableString bkW() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eyH)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eyH, this.eyE));
    }

    public String getAbstract() {
        return this.eyE;
    }

    public void AR(String str) {
        this.eyE = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bkS;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eyD == 1) {
            bkS = bkT();
            spannableStringBuilder = bkS.toString();
        } else {
            bkS = bkS();
            spannableStringBuilder = bkS.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bkS, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bkS);
        }
        this.eyI = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bkT;
        if (!StringUtils.isNull(this.title) && this.eyD != 1) {
            bkT = bkS();
        } else {
            bkT = bkT();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bkT);
        this.eyI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bkX() {
        if (StringUtils.isNull(this.title) || this.eyD == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bkS());
        this.eyI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData biF() {
        if (this.eyF != null && this.eyF.size() > 0) {
            int size = this.eyF.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eyF.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && biG() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.Ed(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bkY() {
        y(false, false);
    }

    public void bkZ() {
        y(false, true);
    }

    public AnchorInfoData bla() {
        return this.ezh;
    }

    public boolean blb() {
        return this.threadType == 36;
    }

    public boolean biG() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean blc() {
        return this.threadType == 11 || this.eze == 1;
    }

    public boolean bld() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bkj = bkj();
        if (bkj == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bkj.size() || i2 >= 3) {
                break;
            }
            if (bkj.get(i2) != null && bkj.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bkj.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bkj.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bkj.get(i2).getPicUrl();
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
        if (this.ezn != null && !StringUtils.isNull(this.ezn.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ezn.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eyV != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eyV.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ble() {
        String userId;
        return this.eyV == null || (userId = this.eyV.getUserId()) == null || userId.equals("0");
    }

    public boolean blf() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (blP()) {
            if (bks() != null) {
                return eyg;
            }
            return exJ;
        }
        int bjV = bjV();
        if (this.eAB == 1) {
            if (this.eAC != null) {
                return exW;
            }
            return this.eAF != null ? eys : eyr;
        } else if (this.ezq != null && this.threadType == 60) {
            return eyj;
        } else {
            if (this.ezq != null && this.threadType == 49) {
                return eyh;
            }
            if (this.ezq != null && this.threadType == 67) {
                return eyk;
            }
            if (this.threadType == 51) {
                return eyi;
            }
            if (this.threadType == 63) {
                return eyt;
            }
            if (this.threadType == 64) {
                return eyu;
            }
            if (bjV == 2 || bjV == 1) {
                return exI;
            }
            if (this.ezn != null && bln() && !blf()) {
                return eyz;
            }
            if (this.ezn != null && !blf()) {
                if (bkd()) {
                    return eyq;
                }
                return eyg;
            } else if (this.isShareThread && this.eAy != null) {
                if (this.eAy.evY) {
                    if (this.eAy.videoInfo != null) {
                        return eyp;
                    }
                    if (this.eAy.biI()) {
                        return eyo;
                    }
                    return eyn;
                }
                return eyl;
            } else if (biI()) {
                return exX;
            } else {
                if (blh()) {
                    return eyw.get() ? ezL : exJ;
                } else if (bkO() && bkN() == 1) {
                    return eyw.get() ? ezT : exJ;
                } else if (isLinkThread()) {
                    return eyd;
                } else {
                    if (bkd()) {
                        return eyf;
                    }
                    if (this.exo) {
                        return exO;
                    }
                    if (this.exp) {
                        return exP;
                    }
                    if (this.exq) {
                        return exQ;
                    }
                    if (this.exr) {
                        return exR;
                    }
                    if (this.exs) {
                        return exS;
                    }
                    if (this.exv) {
                        return exU;
                    }
                    if (this.exw) {
                        return exV;
                    }
                    if (this.exu) {
                        return exT;
                    }
                    if (this.ezu) {
                        int blg = blg();
                        if (blg == 1) {
                            return exK;
                        }
                        if (blg == 2) {
                            return exL;
                        }
                        if (blg > 2) {
                            return exM;
                        }
                        return exJ;
                    }
                    return exJ;
                }
            }
        }
    }

    public int blg() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bhh().isShowImages() || com.baidu.tbadk.core.util.y.getCount(bkj()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bkj().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bkj(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean blh() {
        return bjG() != null && getThreadType() == 41 && bjX() == 1 && bkL() == 2;
    }

    public void F(ArrayList<s> arrayList) {
        if (this.eyD == 1) {
            this.euk = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.euk = 0;
        } else {
            this.euk = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.bic() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bic().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.euk = next.bid();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bli() {
        return this.threadType == 41;
    }

    public boolean blj() {
        return this.ezU;
    }

    public void iE(boolean z) {
        this.ezU = z;
    }

    public String blk() {
        return this.ezV;
    }

    public r bll() {
        return this.ezz;
    }

    public void blm() {
        if (this.ezs == 0) {
            this.ezs = 1;
        }
    }

    public void iF(boolean z) {
        this.eAh = z;
    }

    public boolean bln() {
        return this.eAh;
    }

    public void of(int i) {
        this.eAi = i + 1;
    }

    public int blo() {
        return this.eAi;
    }

    public boolean blp() {
        return this.eAX;
    }

    public void iG(boolean z) {
        this.eAX = z;
    }

    public cd blq() {
        return this.ezp;
    }

    public boolean blr() {
        return getThreadType() == 49;
    }

    public boolean bls() {
        return getThreadType() == 40;
    }

    public boolean blt() {
        return getThreadType() == 50;
    }

    public boolean blu() {
        return getThreadType() == 60;
    }

    public int blv() {
        return this.eAo;
    }

    public void setSmartFrsPosition(int i) {
        this.eAo = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String blw() {
        return this.mRecomSource;
    }

    public boolean blx() {
        return this.eAp;
    }

    public long bly() {
        return this.agreeData.agreeNum;
    }

    public long blz() {
        return this.agreeData.disAgreeNum;
    }

    public int blA() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int blB() {
        return this.agreeData.agreeType;
    }

    public void og(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void oh(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cM(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cN(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void oi(int i) {
        this.agreeData.agreeType = i;
    }

    public long blC() {
        return this.eAr;
    }

    public void cO(long j) {
        this.eAr = j;
    }

    public PostData blD() {
        return this.eAq;
    }

    public am blE() {
        return this.eAs;
    }

    private ArrayList<n.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean bkb = bkb();
        if (z2) {
            if (z) {
                if (bkb && !biG()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if (bjX() == 1 || getThreadType() == 33 || (bjZ() != null && bjZ().bmp() != 0)) {
                    if (bjG() != null && bli()) {
                        if (bkL() == 2) {
                            arrayList.add(new n.a(R.string.interview_live));
                        }
                    } else if (!bkb) {
                        arrayList.add(new n.a(R.string.photo_live_tips));
                    }
                }
                if (bli()) {
                    arrayList.add(eAl.get(bkL()));
                }
                if (bkO()) {
                    Integer num = eAk.get(new Point(bkN(), bkM()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (bkl() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (bkb && bjV() != 1 && !biG()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if ((bjX() == 1 || getThreadType() == 33) && !bli() && !bkb) {
                    arrayList.add(new n.a(R.string.photo_live_tips));
                }
                if (bjW() == 1) {
                    arrayList.add(new n.a(R.string.good));
                }
                if (bjV() == 1) {
                    arrayList.add(new n.a(R.string.top));
                }
                if (bli() && bjG() != null && bkL() == 2) {
                    arrayList.add(new n.a(R.string.interview_live));
                }
                if (bkO()) {
                    Integer num2 = eAk.get(new Point(bkN(), bkM()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (this.ezW == 1) {
                    arrayList.add(new n.a(R.string.card_tbread_text));
                }
                if (bkm() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (bkl() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && blr()) {
                    arrayList.add(new n.a(R.string.ala_live));
                }
                if (z3 && blt()) {
                    arrayList.add(new n.a(R.string.live_record));
                } else if (bls()) {
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
        this.eyY = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eyZ = arrayList;
    }

    public String blF() {
        return this.eAD;
    }

    public void AS(String str) {
        this.eAD = str;
    }

    public void blG() {
        this.eAB = 1;
    }

    public boolean blH() {
        return this.eAB == 1;
    }

    public String blI() {
        return this.eyL;
    }

    public void AT(String str) {
        this.eyL = str;
    }

    public String blJ() {
        return this.eyM;
    }

    public void AU(String str) {
        this.eyM = str;
    }

    public String blK() {
        return this.eAE;
    }

    public void AV(String str) {
        this.eAE = str;
    }

    public boolean blL() {
        return this.eAH;
    }

    public void iH(boolean z) {
        this.eAH = z;
    }

    public boolean blM() {
        return this.eAI;
    }

    public void iI(boolean z) {
        this.eAI = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eAF = videoInfo;
    }

    public boolean blN() {
        return this.eAJ != null;
    }

    public bs blO() {
        return this.eyK;
    }

    public boolean blP() {
        return this.eAM;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.ezn != null) {
            return this.ezn.video_url;
        }
        return null;
    }

    public boolean blQ() {
        return this.eAO;
    }

    public void iJ(boolean z) {
        this.eAO = z;
    }

    public AgreeData blR() {
        return this.agreeData;
    }

    public boolean blS() {
        return this.eBa;
    }

    public void iK(boolean z) {
        this.eBa = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean bhI() {
        return this.eAY;
    }

    public void iL(boolean z) {
        this.eAY = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule blT() {
        return this.eAC;
    }

    public String getShareImageUrl() {
        return this.eAU;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bkj = bkj();
        if (com.baidu.tbadk.core.k.bhh().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bkj) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < bkj.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bkj, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(bkj, 0);
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

    public boolean blU() {
        return blV() || blW();
    }

    public boolean biI() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean biJ() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean blV() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean blW() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean biK() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return biK();
    }

    public void oj(int i) {
        this.isBjh = i;
    }

    public int blX() {
        return this.eBh;
    }

    public String blY() {
        return this.eBg;
    }

    public void AW(String str) {
        this.eBg = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int blZ() {
        if (bkc()) {
            return 4;
        }
        if (blr() || blt()) {
            return 3;
        }
        if (biI()) {
            return 5;
        }
        if (biJ()) {
            return 6;
        }
        if (blV()) {
            return 7;
        }
        if (blW()) {
            return 8;
        }
        if (this.isShareThread && this.eAy != null) {
            return 9;
        }
        if (bls()) {
            return 2;
        }
        return 1;
    }

    public int bma() {
        if (blW() || blV()) {
            return 2;
        }
        if (biI() || biJ()) {
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

    public boolean bmb() {
        return this.eyV != null && this.eyV.isNewGod();
    }

    public boolean bmc() {
        return (bka() == null || bka().getAlaUserData() == null || bka().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bmd() {
        return this.eBp;
    }

    public List<HeadItem> bme() {
        return this.eBq;
    }

    public void a(Item item) {
        this.eBp = item;
    }

    public void bh(List<HeadItem> list) {
        this.eBq = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bmf() {
        return this.eBr;
    }

    public void b(PollData pollData) {
        this.eBr = pollData;
    }

    public List<PbLinkData> bmg() {
        return this.eBm;
    }

    public void bi(List<PbLinkData> list) {
        this.eBm = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eBm)) {
            for (PbLinkData pbLinkData : this.eBm) {
                if (pbLinkData.urlType == 2 && !this.eBo) {
                    this.eBo = true;
                }
            }
        }
    }

    public List<PbGoodsData> bmh() {
        return this.eBn;
    }

    public void bj(List<PbGoodsData> list) {
        this.eBn = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eBo) {
            this.eBo = true;
        }
    }

    public boolean bmi() {
        return this.eBo;
    }
}

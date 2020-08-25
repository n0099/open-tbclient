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
/* loaded from: classes2.dex */
public class bw extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String bev;
    public int dZb;
    private SpannableString dZh;
    private int ebJ;
    private SpannableStringBuilder ebO;
    private SpannableStringBuilder ebP;
    private bs ebQ;
    private String ebR;
    private String ebS;
    private r ecF;
    private LiveCoverStatus ecL;
    private long ecM;
    public TwZhiBoUser ecT;
    public List<TwAnchorProfitItem> ecU;
    private SkinInfo ecY;
    public int ecg;
    private int ech;
    private int eck;
    public int ecl;
    private String eco;
    private String ecp;
    private int ecr;
    private VideoInfo ect;
    private VideoDesc ecu;
    private cd ecv;
    private AlaInfoData ecw;
    private long ecx;
    public e edA;
    private MediaData edB;
    public int edC;
    public OriginalThreadInfo edE;
    private TopicModule edI;
    private String edJ;
    private String edK;
    private VideoInfo edL;
    private String edM;
    private boolean edO;
    public OriginalForumInfo edP;
    public boolean edQ;
    private String edR;
    private boolean edS;
    private SmartApp edT;
    private String edV;
    private String edW;
    private String edX;
    private String edY;
    private String edZ;
    private boolean eda;
    private String edb;
    private boolean ede;
    public String edg;
    public int edh;
    public int edi;
    public String edj;
    public String edk;
    public long edl;
    private List<ReportInfo> edp;
    private boolean edv;
    private long edx;
    private am edy;
    public String eea;
    private boolean eed;
    private boolean eee;
    public boolean eef;
    public boolean eeg;
    public boolean eeh;
    public boolean eei;
    public boolean eej;
    public boolean eek;
    public String eel;
    private int eem;
    private String een;
    private int eeo;
    public String eeq;
    private String eer;
    private ThreadInfo ees;
    private boolean eev;
    private Item eew;
    private List<HeadItem> eex;
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
    public static final BdUniqueId eaR = BdUniqueId.gen();
    public static final BdUniqueId eaS = BdUniqueId.gen();
    public static final BdUniqueId eaT = BdUniqueId.gen();
    public static final BdUniqueId eaU = BdUniqueId.gen();
    public static final BdUniqueId eaV = BdUniqueId.gen();
    public static final BdUniqueId eaW = BdUniqueId.gen();
    public static final BdUniqueId eaX = BdUniqueId.gen();
    public static final BdUniqueId eaY = BdUniqueId.gen();
    public static final BdUniqueId eaZ = BdUniqueId.gen();
    public static final BdUniqueId eba = BdUniqueId.gen();
    public static final BdUniqueId ebb = BdUniqueId.gen();
    public static final BdUniqueId ebc = BdUniqueId.gen();
    public static final BdUniqueId ebd = BdUniqueId.gen();
    public static final BdUniqueId ebe = BdUniqueId.gen();
    public static final BdUniqueId ebf = BdUniqueId.gen();
    public static final BdUniqueId ebg = BdUniqueId.gen();
    public static final BdUniqueId ebh = BdUniqueId.gen();
    public static final BdUniqueId ebi = BdUniqueId.gen();
    public static final BdUniqueId ebj = BdUniqueId.gen();
    public static final BdUniqueId ebk = BdUniqueId.gen();
    public static final BdUniqueId ebl = BdUniqueId.gen();
    public static final BdUniqueId ebm = BdUniqueId.gen();
    public static final BdUniqueId ebn = BdUniqueId.gen();
    public static final BdUniqueId ebo = BdUniqueId.gen();
    public static final BdUniqueId ebp = BdUniqueId.gen();
    public static final BdUniqueId ebq = BdUniqueId.gen();
    public static final BdUniqueId ebr = BdUniqueId.gen();
    public static final BdUniqueId ebs = BdUniqueId.gen();
    public static final BdUniqueId ebt = BdUniqueId.gen();
    public static final BdUniqueId ebu = BdUniqueId.gen();
    public static final BdUniqueId ebv = BdUniqueId.gen();
    public static final BdUniqueId ebw = BdUniqueId.gen();
    public static final BdUniqueId ebx = BdUniqueId.gen();
    public static final BdUniqueId eby = BdUniqueId.gen();
    public static final BdUniqueId ebz = BdUniqueId.gen();
    public static final BdUniqueId ebA = BdUniqueId.gen();
    public static final BdUniqueId ebB = BdUniqueId.gen();
    public static AtomicBoolean ebC = new AtomicBoolean(false);
    public static AtomicBoolean ebD = new AtomicBoolean(false);
    public static AtomicBoolean ebE = new AtomicBoolean(false);
    public static final BdUniqueId ebF = BdUniqueId.gen();
    private static HashMap<Point, Integer> ecG = new HashMap<>();
    private static HashMap<Integer, Integer> ecH = new HashMap<>();
    public static final BdUniqueId ecR = BdUniqueId.gen();
    public static final BdUniqueId ecZ = BdUniqueId.gen();
    private static HashMap<Point, Integer> edq = new HashMap<>();
    private static SparseArray<m.a> edr = new SparseArray<>(3);
    public boolean eay = false;
    public boolean eaz = false;
    public boolean eaA = false;
    public boolean eaB = false;
    public boolean eaC = false;
    public boolean eaD = false;
    public boolean eaE = false;
    public boolean eaF = false;
    private int ebG = 0;
    private String ebH = "1";
    public int ebI = 1;
    private String ecj = null;
    private int dXu = 0;
    public int ecy = 0;
    private String ecz = "";
    public boolean ecA = false;
    private String ecI = "";
    public boolean edm = true;
    public boolean eds = false;
    public boolean edt = false;
    private int edu = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> dYX = null;
    public boolean edz = false;
    private int edH = 0;
    private boolean edN = false;
    private boolean edU = false;
    public boolean eeb = false;
    public boolean eec = false;
    public boolean forbidComment = false;
    public boolean eep = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int ebT = 0;
    private int ebU = 0;
    private String last_time = null;
    private long ebV = 0;
    private int ebW = 0;
    private int ebX = 0;
    private int ebY = 0;
    private int ebZ = 0;
    private ca eca = new ca();
    private MetaData ecb = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> ece = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> ecf = new ArrayList<>();
    private int ecc = 0;
    private int ecd = 0;
    private String ad_url = null;
    private String ebK = null;
    private String from = null;
    private int eci = 0;
    private PraiseData ecm = new PraiseData();
    private AnchorInfoData ecn = new AnchorInfoData();
    private long time = 0;
    private int ecq = 0;
    private ArrayList<a> ecC = new ArrayList<>();
    private ci ecD = null;
    private f ecE = null;
    private int ecJ = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> ecs = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ecK = null;
    private int ecB = 0;
    private boolean ecN = false;
    private boolean ecO = false;
    private int ecP = 0;
    private boolean ecQ = false;
    private int anchorLevel = 0;
    public int edc = 0;
    public o edd = new o();
    private List<PbContent> ebN = new ArrayList();
    private List<PbContent> ebL = new ArrayList();
    private List<PbContent> ebM = new ArrayList();
    private String category_name = null;
    private bu ecS = new bu();
    private ArrayList<com.baidu.tbadk.data.c> ecV = new ArrayList<>();
    private PushStatusData ecW = new PushStatusData();
    public boolean edn = false;
    public int edo = -1;
    private PostData edw = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int edf = 0;
    public int edD = 0;
    private String tieba_game_information_source = "";
    public String edG = "";
    public String edF = "";
    public String mUrl = "";
    public String ecX = "";
    PollData eey = new PollData();
    private List<PbLinkData> eet = new ArrayList();
    private List<PbGoodsData> eeu = new ArrayList();
    public int eez = -1;

    static {
        ecG.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        ecG.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        ecG.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        ecG.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        ecG.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        ecG.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        ecG.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        ecG.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        edq.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        edq.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        edq.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        edq.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        edq.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        edq.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        edq.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        edq.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        ecH.put(1, Integer.valueOf(R.drawable.label_interview_no));
        ecH.put(2, Integer.valueOf(R.drawable.label_interview_live));
        ecH.put(3, Integer.valueOf(R.drawable.label_interview_off));
        edr.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        edr.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        edr.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bw() {
        this.ech = 0;
        this.ecr = 0;
        this.ecM = 0L;
        this.edC = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ecM = 0L;
        this.ecr = 0;
        this.ech = 0;
        this.edC = 0;
    }

    public String beb() {
        return this.edV;
    }

    public String bec() {
        return this.edW;
    }

    public void zk(String str) {
        this.edW = str;
    }

    public String bed() {
        return this.edX;
    }

    public SpannableStringBuilder bee() {
        return this.ebP;
    }

    public SpannableString bef() {
        return this.dZh;
    }

    public void a(SpannableString spannableString) {
        if (beE() != null && !bco() && !bcn()) {
            if (this.ebP != null) {
                this.ebP.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dZh);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dZh = new SpannableString(spannableStringBuilder);
        }
    }

    public void beg() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eex) > 0) {
            if (this.ebP != null) {
                this.ebP.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bh(this.eex));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dZh);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bh(this.eex));
            this.dZh = new SpannableString(spannableStringBuilder);
        }
    }

    public String beh() {
        return this.edY;
    }

    public String bei() {
        return this.edZ;
    }

    public boolean bej() {
        return this.ech == 1;
    }

    public bu bek() {
        return this.ecS;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void nd(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.ecr;
    }

    public void ne(int i) {
        this.ecP = i;
    }

    public int bel() {
        return this.ecP;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bem() {
        return this.edL;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void cz(long j) {
        this.mCreateTime = j;
    }

    public long ben() {
        return this.ecx;
    }

    public String beo() {
        return this.eco;
    }

    public PraiseData bep() {
        return this.ecm;
    }

    public void a(PraiseData praiseData) {
        this.ecm = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String beq() {
        return this.bev;
    }

    public void zl(String str) {
        this.bev = str;
    }

    public String ber() {
        return this.ebH;
    }

    public void zm(String str) {
        this.ebH = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nf(int i) {
        this.ebG = i;
    }

    public int bes() {
        return this.ebG;
    }

    public String bet() {
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

    public List<PbContent> beu() {
        return this.ebN;
    }

    public void aN(List<PbContent> list) {
        this.ebN = list;
    }

    public void aO(List<PbContent> list) {
        this.ebL = list;
    }

    public void aP(List<PbContent> list) {
        this.ebM = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void ng(int i) {
        this.reply_num = i;
    }

    public int bev() {
        return this.reply_num;
    }

    public int bew() {
        return this.ebU;
    }

    public void nh(int i) {
        this.ebU = i;
    }

    public long bex() {
        return this.ebV;
    }

    public void cA(long j) {
        this.ebV = j;
    }

    public int bey() {
        return this.ebX;
    }

    public int bez() {
        return this.ebW;
    }

    public void ni(int i) {
        this.ebW = i;
    }

    public int beA() {
        return this.ebY;
    }

    public void nj(int i) {
        this.ebY = i;
    }

    public int beB() {
        return this.ebZ;
    }

    public List<PbContent> beC() {
        return this.ebL;
    }

    public ca beD() {
        return this.eca;
    }

    public MetaData beE() {
        return this.ecb;
    }

    public boolean beF() {
        return this.is_god != 0;
    }

    public boolean beG() {
        return this.is_god == 1;
    }

    public boolean beH() {
        return (this.ecb == null || this.ecb.getGodUserData() == null || this.ecb.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.ecb = metaData;
    }

    public String beI() {
        return this.forum_name;
    }

    public void zn(String str) {
        this.forum_name = str;
    }

    public int beJ() {
        return this.ecd;
    }

    public String beK() {
        return this.ad_url;
    }

    public int beL() {
        return this.eci;
    }

    public void nk(int i) {
        this.eci = i;
    }

    public String beM() {
        return this.ecj;
    }

    public void zo(String str) {
        this.ecj = str;
    }

    public ArrayList<MediaData> beN() {
        return this.ece;
    }

    public ArrayList<a> beO() {
        return this.ecC;
    }

    public void E(ArrayList<a> arrayList) {
        this.ecC = arrayList;
    }

    public ci beP() {
        return this.ecD;
    }

    public f beQ() {
        return this.ecE;
    }

    public ArrayList<VoiceData.VoiceModel> beR() {
        return this.ecf;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int beS() {
        return this.ebJ;
    }

    public void nl(int i) {
        this.ebJ = i;
    }

    public String beT() {
        return this.latitude;
    }

    public String beU() {
        return this.ecp;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String beV() {
        return this.ecz;
    }

    public VideoInfo beW() {
        return this.ect;
    }

    public void a(VideoInfo videoInfo) {
        this.ect = videoInfo;
    }

    public VideoDesc beX() {
        return this.ecu;
    }

    public void a(AlaInfoData alaInfoData) {
        this.ecw = alaInfoData;
    }

    public AlaInfoData beY() {
        return this.ecw;
    }

    public PushStatusData beZ() {
        return this.ecW;
    }

    public SkinInfo bfa() {
        return this.ecY;
    }

    public long bfb() {
        return this.edl;
    }

    public boolean bfc() {
        return this.edm;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcf() {
        return this.edk;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bce().getTid());
        arVar.setFid(bce().getFid());
        arVar.setNid(bce().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.dYX = this.dYX;
        arVar.abTag = this.mRecomAbTag;
        arVar.weight = this.mRecomWeight;
        arVar.extra = this.mRecomExtra;
        arVar.source = this.mRecomSource;
        arVar.dZb = this.dZb;
        arVar.cardType = bgD();
        return arVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ecp = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ech = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ecx = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.ebT = threadInfo.repost_num.intValue();
                this.ebU = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.ebV = threadInfo.last_time_int.intValue();
                this.ebW = threadInfo.is_top.intValue();
                this.ebX = threadInfo.is_membertop.intValue();
                this.ebY = threadInfo.is_good.intValue();
                this.ebZ = threadInfo.is_livepost.intValue();
                this.eca.a(threadInfo.topic);
                this.ecb.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.ecc = threadInfo.has_commented.intValue();
                this.ecd = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ect = threadInfo.video_info;
                this.ecu = threadInfo.video_segment;
                this.ecw = new AlaInfoData();
                this.ecw.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eci = threadInfo.collect_status.intValue();
                this.ecj = threadInfo.collect_mark_pid;
                this.eck = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ecl = threadInfo.thread_type.intValue();
                this.eco = threadInfo.first_post_id + "";
                this.ecz = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.ebJ = threadInfo.is_ntitle.intValue();
                this.ecq = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.edx = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.ecr = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ede = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ebL = threadInfo.rich_title;
                this.ebN = threadInfo.first_post_content;
                this.ebM = threadInfo.rich_abstract;
                this.ecg = threadInfo.is_godthread_recommend.intValue();
                if ((this.ecb == null || this.ecb.getUserId() == null || this.ecb.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ecb = metaData;
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
                this.ebK = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.ece.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ect = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ecv = new cd();
                    this.ecv.a(threadInfo.video_channel_info);
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
                        this.ecf.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ecC.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ecD = new ci();
                    this.ecD.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ecE = new f();
                    this.ecE.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ecF = new r();
                    this.ecF.a(threadInfo.cartoon_info);
                }
                this.ecm.setUserMap(this.userMap);
                this.ecm.parserProtobuf(threadInfo.zan);
                this.ecn.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ecm.setTitle(this.title);
                } else {
                    this.ecm.setTitle(this.ebK);
                }
                this.ecI = threadInfo.livecover_src;
                this.ecJ = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ecB = threadInfo.post_num.intValue();
                this.ecM = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.pO(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.Br(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ecs.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ecK = noticeInfo.notice;
                    }
                    this.ecP = zhiBoInfoTW.copythread_remind.intValue();
                    this.ecN = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ecO = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ecI)) {
                        this.ecI = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.ecT = zhiBoInfoTW.user.tw_anchor_info;
                        this.ecU = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ecL = threadInfo.twzhibo_info.livecover_status;
                    this.ecM = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.ecQ = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ecS.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.ecV.add(cVar2);
                    }
                }
                this.ecW.parserProtobuf(threadInfo.push_status);
                this.edb = threadInfo.lego_card;
                this.ecY = threadInfo.skin_info;
                this.edc = threadInfo.is_book_chapter.intValue();
                this.edd.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.edk = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.edl = threadInfo.last_read_pid.longValue();
                this.edm = threadInfo.cheak_repeat.intValue() == 1;
                this.edp = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.edw.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.dYX = sparseArray2;
                }
                this.edv = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.edy = new am();
                    this.edy.a(threadInfo.link_info);
                }
                this.edz = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.edA = new e();
                    this.edA.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.edB = new MediaData();
                    this.edB.parserProtobuf(threadInfo.pic_info);
                }
                this.edf = threadInfo.is_called.intValue();
                this.edC = threadInfo.middle_page_num.intValue();
                this.edD = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.edF = threadInfo.star_rank_icon.icon_pic_url;
                    this.edG = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.edE = new OriginalThreadInfo();
                    this.edE.a(threadInfo.origin_thread_info);
                } else {
                    this.edE = null;
                    this.isShareThread = false;
                }
                this.edH = threadInfo.is_topic.intValue();
                this.edJ = threadInfo.topic_user_name;
                this.edK = threadInfo.topic_h5_url;
                this.edI = threadInfo.topic_module;
                this.edM = threadInfo.presentation_style;
                this.edP = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.edR = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.ebQ = new bs();
                    this.ebQ.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.edT = threadInfo.swan_info;
                }
                this.eea = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.eeb = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.een = threadInfo.article_cover;
                this.eeo = threadInfo.bjh_content_tag.intValue();
                this.eem = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eep = threadInfo.is_s_card.intValue() == 1;
                this.eeq = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eer = threadInfo.wonderful_post_info;
                bfd();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.ees = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eev) {
                            this.eev = true;
                        }
                        this.eet.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eeu.add(pbGoodsData);
                    }
                    if (this.eeu.size() > 0 && !this.eev) {
                        this.eev = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eew = threadInfo.item;
                }
                if (this.eew != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eew);
                }
                this.eex = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eex)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eex);
                }
                if (threadInfo.poll_info != null) {
                    this.eey.parserProtobuf(threadInfo.poll_info);
                }
                this.eez = threadInfo.hot_num.intValue();
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
                this.ecx = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.ebT = jSONObject.optInt("repost_num", 0);
                this.ebU = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.ebV = jSONObject.optLong("last_time_int", 0L);
                this.ebW = jSONObject.optInt("is_top", 0);
                this.ebX = jSONObject.optInt("is_membertop", 0);
                this.ebY = jSONObject.optInt("is_good", 0);
                this.ebZ = jSONObject.optInt("is_livepost", 0);
                this.eca.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.ecb.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.ecc = jSONObject.optInt("has_commented", 0);
                this.ecd = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eci = jSONObject.optInt("collect_status");
                this.ecj = jSONObject.optString("collect_mark_pid");
                this.eck = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ecl = jSONObject.optInt("thread_type");
                this.edx = jSONObject.optLong("share_num");
                this.eco = jSONObject.optString("first_post_id", "0");
                this.ecz = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.ebJ = jSONObject.optInt("is_ntitle");
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
                    this.dYX = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ecS.parserJson(optJSONObject2);
                }
                if ((this.ecb == null || this.ecb.getUserId() == null) && this.userMap != null) {
                    this.ecb = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.ecw = new AlaInfoData();
                this.ecw.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.ebK = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.ece.add(mediaData);
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
                        this.ecf.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ecC.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ecD = new ci();
                    this.ecD.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.ecE = new f();
                    this.ecE.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ecF = new r();
                    this.ecF.parserJson(optJSONObject6);
                }
                this.ecm.setUserMap(this.userMap);
                this.ecm.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ecn.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ecm.setTitle(this.title);
                } else {
                    this.ecm.setTitle(this.ebK);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ecS.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.ecV.add(cVar);
                    }
                }
                this.edc = jSONObject.optInt("is_book_chapter", 0);
                this.edd.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.edk = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.edg = jSONObject.optString("recom_extra_img");
                this.edj = jSONObject.optString("recom_extra_img_night");
                this.edh = jSONObject.optInt("recom_extra_img_width", 0);
                this.edi = jSONObject.optInt("recom_extra_img_height", 0);
                this.edl = jSONObject.optLong("last_read_pid");
                this.edm = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.ecv = new cd();
                    this.ecv.cS(optJSONObject8);
                }
                this.edv = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.edy = new am();
                    this.edy.parserJson(optJSONObject9);
                }
                this.edz = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.edA = new e();
                    this.edA.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.edB = new MediaData();
                    this.edB.parserJson(optJSONObject11);
                }
                this.edf = jSONObject.optInt("is_called", 0);
                this.edC = jSONObject.optInt("middle_page_num", 0);
                this.edD = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.ect = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.edE = new OriginalThreadInfo();
                        this.edE.parserJson(optJSONObject13);
                    } else {
                        this.edE = null;
                    }
                } else {
                    this.edE = null;
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
                    this.edT = builder2.build(false);
                }
                this.eea = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.eeb = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.eem = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eeo = jSONObject.optInt("bjh_content_tag");
                this.een = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eep = jSONObject.optInt("is_s_card", 0) == 1;
                this.eeq = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eer = jSONObject.optString("wonderful_post_info");
                bfd();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    this.eey.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eev) {
                            this.eev = true;
                        }
                        this.eet.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eeu.add(pbGoodsData);
                    }
                    if (this.eeu.size() > 0 && !this.eev) {
                        this.eev = true;
                    }
                }
                this.eez = jSONObject.optInt("hot_num", -1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bfd() {
        bfe();
        bfg();
        bfj();
        bfk();
        bfl();
        bfm();
        bfn();
    }

    private void bfe() {
        if (!StringUtils.isNull(this.ecb.getName_show())) {
            this.edV = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ecb.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bff() {
        if (this.ecw != null) {
            if (this.ecw.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cO = com.baidu.tbadk.core.util.at.cO(this.mCreateTime);
                if (!StringUtils.isNull(cO)) {
                    this.edW = cO;
                }
            }
            if (this.ecw.openRecomFans == 1) {
                int i = 0;
                if (this.ecw != null && this.ecw.user_info != null) {
                    i = this.ecw.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.edW) && i > 0) {
                    this.edW += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.cR(i);
                } else if (i > 0) {
                    this.edW = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.cR(i);
                }
            }
        }
    }

    private void bfg() {
        if (bdo() || (bgw() && getType() != ebp)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cM = com.baidu.tbadk.core.util.at.cM(j);
                if (com.baidu.tbadk.core.util.at.Ag(cM)) {
                    cM = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.edW = cM;
            }
            String str = "";
            if (this.ecb != null && this.ecb.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.ecb.getBaijiahaoInfo().auth_desc)) {
                str = this.ecb.getBaijiahaoInfo().auth_desc;
            }
            if (bgF()) {
                bfh();
            } else if (!this.eef && this.ecb != null && this.ecb.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ecb.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.edW)) {
                    this.edW += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.edW = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.edW) && !TextUtils.isEmpty(str)) {
                this.edW += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.edW = str;
            }
        } else if (getType() == ebp) {
            bff();
        } else {
            long bex = bex() * 1000;
            if (bex != 0) {
                String cM2 = com.baidu.tbadk.core.util.at.cM(bex);
                if (com.baidu.tbadk.core.util.at.Ag(cM2)) {
                    cM2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bex);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bcn()) {
                    cM2 = com.baidu.tbadk.core.util.at.cN(bex);
                }
                this.edW = string + cM2;
            } else {
                long j2 = this.mCreateTime;
                String cM3 = com.baidu.tbadk.core.util.at.cM(j2);
                if (com.baidu.tbadk.core.util.at.Ag(cM3)) {
                    cM3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.edW = cM3;
            }
            if (bgF()) {
                bfh();
            } else if (!this.eef && this.ecb != null && this.ecb.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ecb.getBazhuGradeData().getDesc(), this.eee ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.edW)) {
                    this.edW += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.edW = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.edW) && !TextUtils.isEmpty(getAddress())) {
                this.edW += " • " + getAddress();
            }
        }
    }

    private void bfh() {
        if (bgF() && !TextUtils.isEmpty(this.ecb.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.edW)) {
                this.edW += "   " + this.ecb.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.edW = this.ecb.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void bfi() {
        if (!bdo() && !bgw()) {
            long bex = 1000 * bex();
            if (bex != 0) {
                String cM = com.baidu.tbadk.core.util.at.cM(bex);
                if (com.baidu.tbadk.core.util.at.Ag(cM)) {
                    cM = com.baidu.tbadk.core.util.at.getFormatTimeShort(bex);
                }
                this.edW = cM;
            }
            if (bgF()) {
                bfh();
            } else if (!this.eef && this.ecb != null && this.ecb.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.ecb.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.edW)) {
                    this.edW += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.edW = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.edW) && !TextUtils.isEmpty(getAddress())) {
                this.edW += " • " + getAddress();
            }
        }
    }

    private void bfj() {
        if (beY() == null || beY().share_info == null || beY().share_info.share_user_count <= 0 || !bfY() || (this.edC > 0 && this.edD == 0)) {
            this.edX = null;
            return;
        }
        int i = beY().share_info.share_user_count;
        if (i == 1) {
            this.edX = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.edX = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void bfk() {
        this.ebP = bfB();
        com.baidu.tieba.card.m.a(this, this.ebP, true);
    }

    private void bfl() {
        this.dZh = bfz();
    }

    private void bfm() {
        this.edY = com.baidu.tbadk.core.util.at.getFormatTimeShort(bex() * 1000);
    }

    private void bfn() {
        this.edZ = com.baidu.tbadk.core.util.at.getFormatTimeShort(bex());
    }

    public SpannableStringBuilder bfo() {
        return this.ebO;
    }

    public boolean isTop() {
        return bez() != 0;
    }

    public int bfp() {
        if (this.ecS != null) {
            long bdW = this.ecS.bdW();
            long bdX = this.ecS.bdX();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bdW) {
                return 1;
            }
            if (currentTimeMillis > bdX) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bfq() {
        if (bfs() && this.ecC.size() >= 1) {
            a aVar = this.ecC.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bcr = aVar.bcr();
            int bcs = aVar.bcs();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bcr) {
                return 4;
            }
            return currentTimeMillis > bcs ? 2 : 1;
        }
        return -1;
    }

    public int bfr() {
        if (!bfs() || this.ecC.size() < 1 || this.ecC.get(0) == null) {
            return -1;
        }
        return this.ecC.get(0).bcq();
    }

    public boolean bfs() {
        return this.ecq == 1;
    }

    public String getActUrl() {
        return (!bfs() || this.ecC.size() < 1 || this.ecC.get(0) == null) ? "" : this.ecC.get(0).getUrl();
    }

    private com.baidu.adp.widget.b zp(String str) {
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

    public SmartApp bft() {
        return this.edT;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bfv()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bez() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bez() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (beB() == 1 || this.eca.bgT() != 0) {
                if (bek() != null && getThreadType() == 41) {
                    if (bfp() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bfM()) {
                Integer num = ecH.get(Integer.valueOf(bfp()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (beA() == 1 && !isTop() && ebo != getType() && ebw != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.ecn != null && this.ecn.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (beJ() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = ecG.get(new Point(bfr(), bfq()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (beP() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (beQ() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = zp(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ebI));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bfw = bfw();
        if (bfw != null) {
            spannableStringBuilder.append((CharSequence) bfw);
        }
        this.ebO = spannableStringBuilder;
    }

    public boolean bfu() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (beE() != null) {
            if (beE().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (beE().getGender() == 2) {
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

    private boolean bfv() {
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
        SpannableStringBuilder bfw = bfw();
        if (z) {
            spannableStringBuilder = a(bfw.toString(), bfw, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bfw);
        }
        this.ebO = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.ebJ == 1) {
                this.ebO = a2;
                return a2;
            }
        } else if (this.ebJ == 1) {
            this.ebO = new SpannableStringBuilder();
            return a2;
        }
        if (spannableStringBuilder != null) {
            a2.append((CharSequence) spannableStringBuilder);
            return a2;
        } else if (a.size() > 0 || a2.length() == 0) {
            a2.append((CharSequence) str);
            return a2;
        } else {
            return a2;
        }
    }

    public void du(String str, String str2) {
        this.mUrl = str;
        this.ecX = str2;
    }

    public SpannableStringBuilder bfw() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.ebL, this.title);
    }

    public SpannableStringBuilder bfx() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.ebM, this.ebK);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bfy() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eep) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bfz() {
        SpannableStringBuilder bfx = bfx();
        com.baidu.tieba.card.m.a(this, bfx, false);
        return new SpannableString(bfx);
    }

    public SpannableString bfA() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.ebN)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.ebN, this.ebK));
    }

    public String getAbstract() {
        return this.ebK;
    }

    public void zq(String str) {
        this.ebK = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bfw;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.ebJ == 1) {
            bfw = bfx();
            spannableStringBuilder = bfw.toString();
        } else {
            bfw = bfw();
            spannableStringBuilder = bfw.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bfw, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bfw);
        }
        this.ebO = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bfx;
        if (!StringUtils.isNull(this.title) && this.ebJ != 1) {
            bfx = bfw();
        } else {
            bfx = bfx();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bfx);
        this.ebO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bfB() {
        if (StringUtils.isNull(this.title) || this.ebJ == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bfw());
        this.ebO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bdj() {
        if (this.ebL != null && this.ebL.size() > 0) {
            int size = this.ebL.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.ebL.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bdk() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.CB(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bfC() {
        y(false, false);
    }

    public void bfD() {
        y(false, true);
    }

    public AnchorInfoData bfE() {
        return this.ecn;
    }

    public boolean bfF() {
        return this.threadType == 36;
    }

    public boolean bdk() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bfG() {
        return this.threadType == 11 || this.eck == 1;
    }

    public boolean bfH() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> beN = beN();
        if (beN == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= beN.size() || i2 >= 3) {
                break;
            }
            if (beN.get(i2) != null && beN.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(beN.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = beN.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = beN.get(i2).getPicUrl();
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
        if (this.ect != null && !StringUtils.isNull(this.ect.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ect.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.ecb != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.ecb.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bfI() {
        String userId;
        return this.ecb == null || (userId = this.ecb.getUserId()) == null || userId.equals("0");
    }

    public boolean bfJ() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bgt()) {
            if (beW() != null) {
                return ebo;
            }
            return eaS;
        }
        int bez = bez();
        if (this.edH == 1) {
            if (this.edI != null) {
                return ebf;
            }
            return this.edL != null ? eby : ebx;
        } else if (this.ecw != null && this.threadType == 60) {
            return ebr;
        } else {
            if (this.ecw != null && this.threadType == 49) {
                return ebp;
            }
            if (this.threadType == 51) {
                return ebq;
            }
            if (this.threadType == 63) {
                return ebz;
            }
            if (this.threadType == 64) {
                return ebA;
            }
            if (bez == 2 || bez == 1) {
                return eaR;
            }
            if (this.ect != null && bfR() && !bfJ()) {
                return ebF;
            }
            if (this.ect != null && !bfJ()) {
                if (beH()) {
                    return ebw;
                }
                return ebo;
            } else if (this.isShareThread && this.edE != null) {
                if (this.edE.dZi) {
                    if (this.edE.videoInfo != null) {
                        return ebv;
                    }
                    if (this.edE.bdm()) {
                        return ebu;
                    }
                    return ebt;
                }
                return ebs;
            } else if (bdm()) {
                return ebg;
            } else {
                if (bfL()) {
                    return ebC.get() ? ecR : eaS;
                } else if (bfs() && bfr() == 1) {
                    return ebC.get() ? ecZ : eaS;
                } else if (isLinkThread()) {
                    return ebm;
                } else {
                    if (beH()) {
                        return ebn;
                    }
                    if (this.eay) {
                        return eaX;
                    }
                    if (this.eaz) {
                        return eaY;
                    }
                    if (this.eaA) {
                        return eaZ;
                    }
                    if (this.eaB) {
                        return eba;
                    }
                    if (this.eaC) {
                        return ebb;
                    }
                    if (this.eaE) {
                        return ebd;
                    }
                    if (this.eaF) {
                        return ebe;
                    }
                    if (this.eaD) {
                        return ebc;
                    }
                    if (this.ecA) {
                        int bfK = bfK();
                        if (bfK == 1) {
                            return eaT;
                        }
                        if (bfK == 2) {
                            return eaU;
                        }
                        if (bfK > 2) {
                            return eaV;
                        }
                        return eaS;
                    }
                    return eaS;
                }
            }
        }
    }

    public int bfK() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bbM().isShowImages() || com.baidu.tbadk.core.util.y.getCount(beN()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < beN().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bfL() {
        return bek() != null && getThreadType() == 41 && beB() == 1 && bfp() == 2;
    }

    public void F(ArrayList<s> arrayList) {
        if (this.ebJ == 1) {
            this.dXu = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dXu = 0;
        } else {
            this.dXu = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.bcG() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bcG().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dXu = next.bcH();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bfM() {
        return this.threadType == 41;
    }

    public boolean bfN() {
        return this.eda;
    }

    public void hX(boolean z) {
        this.eda = z;
    }

    public String bfO() {
        return this.edb;
    }

    public r bfP() {
        return this.ecF;
    }

    public void bfQ() {
        if (this.ecy == 0) {
            this.ecy = 1;
        }
    }

    public void hY(boolean z) {
        this.edn = z;
    }

    public boolean bfR() {
        return this.edn;
    }

    public void nm(int i) {
        this.edo = i + 1;
    }

    public int bfS() {
        return this.edo;
    }

    public boolean bfT() {
        return this.eed;
    }

    public void hZ(boolean z) {
        this.eed = z;
    }

    public cd bfU() {
        return this.ecv;
    }

    public boolean bfV() {
        return getThreadType() == 49;
    }

    public boolean bfW() {
        return getThreadType() == 40;
    }

    public boolean bfX() {
        return getThreadType() == 50;
    }

    public boolean bfY() {
        return getThreadType() == 60;
    }

    public int bfZ() {
        return this.edu;
    }

    public void setSmartFrsPosition(int i) {
        this.edu = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bga() {
        return this.mRecomSource;
    }

    public boolean bgb() {
        return this.edv;
    }

    public long bgc() {
        return this.agreeData.agreeNum;
    }

    public long bgd() {
        return this.agreeData.disAgreeNum;
    }

    public int bge() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bgf() {
        return this.agreeData.agreeType;
    }

    public void nn(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void no(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cB(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cC(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void np(int i) {
        this.agreeData.agreeType = i;
    }

    public long bgg() {
        return this.edx;
    }

    public void cD(long j) {
        this.edx = j;
    }

    public PostData bgh() {
        return this.edw;
    }

    public am bgi() {
        return this.edy;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean beF = beF();
        if (z2) {
            if (z) {
                if (beF && !bdk()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (beB() == 1 || getThreadType() == 33 || (beD() != null && beD().bgT() != 0)) {
                    if (bek() != null && bfM()) {
                        if (bfp() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!beF) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (bfM()) {
                    arrayList.add(edr.get(bfp()));
                }
                if (bfs()) {
                    Integer num = edq.get(new Point(bfr(), bfq()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (beP() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (beF && bez() != 1 && !bdk()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((beB() == 1 || getThreadType() == 33) && !bfM() && !beF) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (beA() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bez() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (bfM() && bek() != null && bfp() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (bfs()) {
                    Integer num2 = edq.get(new Point(bfr(), bfq()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.edc == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (beQ() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (beP() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bfV()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bfX()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bfW()) {
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
        this.ece = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.ecf = arrayList;
    }

    public String bgj() {
        return this.edJ;
    }

    public void zr(String str) {
        this.edJ = str;
    }

    public void bgk() {
        this.edH = 1;
    }

    public boolean bgl() {
        return this.edH == 1;
    }

    public String bgm() {
        return this.ebR;
    }

    public void zs(String str) {
        this.ebR = str;
    }

    public String bgn() {
        return this.ebS;
    }

    public void zt(String str) {
        this.ebS = str;
    }

    public String bgo() {
        return this.edK;
    }

    public void zu(String str) {
        this.edK = str;
    }

    public boolean bgp() {
        return this.edN;
    }

    public void ia(boolean z) {
        this.edN = z;
    }

    public boolean bgq() {
        return this.edO;
    }

    public void ib(boolean z) {
        this.edO = z;
    }

    public void b(VideoInfo videoInfo) {
        this.edL = videoInfo;
    }

    public boolean bgr() {
        return this.edP != null;
    }

    public bs bgs() {
        return this.ebQ;
    }

    public boolean bgt() {
        return this.edS;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.ect != null) {
            return this.ect.video_url;
        }
        return null;
    }

    public boolean bgu() {
        return this.edU;
    }

    public void ic(boolean z) {
        this.edU = z;
    }

    public AgreeData bgv() {
        return this.agreeData;
    }

    public boolean bgw() {
        return this.eeg;
    }

    public void id(boolean z) {
        this.eeg = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean bcm() {
        return this.eee;
    }

    public void ie(boolean z) {
        this.eee = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bgx() {
        return this.edI;
    }

    public String getShareImageUrl() {
        return this.eea;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> beN = beN();
        if (com.baidu.tbadk.core.k.bbM().isShowImages() && com.baidu.tbadk.core.util.y.getCount(beN) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < beN.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(beN, 0);
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

    public boolean bgy() {
        return bgz() || bgA();
    }

    public boolean bdm() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bdn() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bgz() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bgA() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bdo() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bdo();
    }

    public void nq(int i) {
        this.eem = i;
    }

    public int bgB() {
        return this.eeo;
    }

    public String bgC() {
        return this.een;
    }

    public void zv(String str) {
        this.een = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bgD() {
        if (beG()) {
            return 4;
        }
        if (bfV() || bfX()) {
            return 3;
        }
        if (bdm()) {
            return 5;
        }
        if (bdn()) {
            return 6;
        }
        if (bgz()) {
            return 7;
        }
        if (bgA()) {
            return 8;
        }
        if (this.isShareThread && this.edE != null) {
            return 9;
        }
        if (bfW()) {
            return 2;
        }
        return 1;
    }

    public int bgE() {
        if (bgA() || bgz()) {
            return 2;
        }
        if (bdm() || bdn()) {
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

    public boolean bgF() {
        return this.ecb != null && this.ecb.isNewGod();
    }

    public boolean bgG() {
        return (beE() == null || beE().getAlaUserData() == null || beE().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bgH() {
        return this.eew;
    }

    public List<HeadItem> bgI() {
        return this.eex;
    }

    public void a(Item item) {
        this.eew = item;
    }

    public void aQ(List<HeadItem> list) {
        this.eex = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bgJ() {
        return this.eey;
    }

    public void b(PollData pollData) {
        this.eey = pollData;
    }

    public List<PbLinkData> bgK() {
        return this.eet;
    }

    public void aR(List<PbLinkData> list) {
        this.eet = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eet)) {
            for (PbLinkData pbLinkData : this.eet) {
                if (pbLinkData.urlType == 2 && !this.eev) {
                    this.eev = true;
                }
            }
        }
    }

    public List<PbGoodsData> bgL() {
        return this.eeu;
    }

    public void aS(List<PbGoodsData> list) {
        this.eeu = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eet) && !this.eev) {
            this.eev = true;
        }
    }

    public boolean bgM() {
        return this.eev;
    }
}

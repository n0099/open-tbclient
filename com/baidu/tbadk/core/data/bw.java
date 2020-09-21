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
/* loaded from: classes.dex */
public class bw extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String bhq;
    public String buttonText;
    public int ebp;
    private SpannableString ebv;
    private int edX;
    private String eeC;
    private String eeD;
    private int eeF;
    private VideoInfo eeH;
    private VideoDesc eeI;
    private cd eeJ;
    private AlaInfoData eeK;
    private long eeL;
    private r eeT;
    private LiveCoverStatus eeZ;
    private SpannableStringBuilder eec;
    private SpannableStringBuilder eed;
    private bs eee;
    private String eef;
    private String eeg;
    public int eeu;
    private int eev;
    private int eey;
    public int eez;
    private List<ReportInfo> efD;
    private boolean efJ;
    private long efL;
    private am efM;
    public e efO;
    private MediaData efP;
    public int efQ;
    public OriginalThreadInfo efS;
    private TopicModule efW;
    private String efX;
    private String efY;
    private VideoInfo efZ;
    private long efa;
    public TwZhiBoUser efh;
    public List<TwAnchorProfitItem> efi;
    private SkinInfo efm;
    private boolean efo;
    private String efp;
    private boolean efs;
    public String efu;
    public int efv;
    public int efw;
    public String efx;
    public String efy;
    public long efz;
    private String egA;
    private int egB;
    public String egD;
    private String egE;
    private ThreadInfo egF;
    private boolean egI;
    private Item egJ;
    private List<HeadItem> egK;
    PollData egL;
    public int egN;
    public String egO;
    public String egP;
    public String egQ;
    private String ega;
    private boolean egc;
    public OriginalForumInfo egd;
    public boolean ege;
    private String egf;
    private boolean egg;
    private SmartApp egh;
    private String egj;
    private String egk;
    private String egl;
    private String egm;
    private String egn;
    public String ego;
    private boolean egr;
    private boolean egs;
    public boolean egt;
    public boolean egu;
    public boolean egv;
    public boolean egw;
    public boolean egx;
    public boolean egy;
    public String egz;
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
    public static final BdUniqueId edf = BdUniqueId.gen();
    public static final BdUniqueId edg = BdUniqueId.gen();
    public static final BdUniqueId edh = BdUniqueId.gen();
    public static final BdUniqueId edi = BdUniqueId.gen();
    public static final BdUniqueId edj = BdUniqueId.gen();
    public static final BdUniqueId edk = BdUniqueId.gen();
    public static final BdUniqueId edl = BdUniqueId.gen();
    public static final BdUniqueId edm = BdUniqueId.gen();
    public static final BdUniqueId edn = BdUniqueId.gen();
    public static final BdUniqueId edo = BdUniqueId.gen();
    public static final BdUniqueId edp = BdUniqueId.gen();
    public static final BdUniqueId edq = BdUniqueId.gen();
    public static final BdUniqueId edr = BdUniqueId.gen();
    public static final BdUniqueId eds = BdUniqueId.gen();
    public static final BdUniqueId edt = BdUniqueId.gen();
    public static final BdUniqueId edu = BdUniqueId.gen();
    public static final BdUniqueId edv = BdUniqueId.gen();
    public static final BdUniqueId edw = BdUniqueId.gen();
    public static final BdUniqueId edx = BdUniqueId.gen();
    public static final BdUniqueId edy = BdUniqueId.gen();
    public static final BdUniqueId edz = BdUniqueId.gen();
    public static final BdUniqueId edA = BdUniqueId.gen();
    public static final BdUniqueId edB = BdUniqueId.gen();
    public static final BdUniqueId edC = BdUniqueId.gen();
    public static final BdUniqueId edD = BdUniqueId.gen();
    public static final BdUniqueId edE = BdUniqueId.gen();
    public static final BdUniqueId edF = BdUniqueId.gen();
    public static final BdUniqueId edG = BdUniqueId.gen();
    public static final BdUniqueId edH = BdUniqueId.gen();
    public static final BdUniqueId edI = BdUniqueId.gen();
    public static final BdUniqueId edJ = BdUniqueId.gen();
    public static final BdUniqueId edK = BdUniqueId.gen();
    public static final BdUniqueId edL = BdUniqueId.gen();
    public static final BdUniqueId edM = BdUniqueId.gen();
    public static final BdUniqueId edN = BdUniqueId.gen();
    public static final BdUniqueId edO = BdUniqueId.gen();
    public static final BdUniqueId edP = BdUniqueId.gen();
    public static AtomicBoolean edQ = new AtomicBoolean(false);
    public static AtomicBoolean edR = new AtomicBoolean(false);
    public static AtomicBoolean edS = new AtomicBoolean(false);
    public static final BdUniqueId edT = BdUniqueId.gen();
    private static HashMap<Point, Integer> eeU = new HashMap<>();
    private static HashMap<Integer, Integer> eeV = new HashMap<>();
    public static final BdUniqueId eff = BdUniqueId.gen();
    public static final BdUniqueId efn = BdUniqueId.gen();
    private static HashMap<Point, Integer> efE = new HashMap<>();
    private static SparseArray<m.a> efF = new SparseArray<>(3);
    public boolean ecM = false;
    public boolean ecN = false;
    public boolean ecO = false;
    public boolean ecP = false;
    public boolean ecQ = false;
    public boolean ecR = false;
    public boolean ecS = false;
    public boolean ecT = false;
    private int edU = 0;
    private String edV = "1";
    public int edW = 1;
    private String eex = null;
    private int dZI = 0;
    public int eeM = 0;
    private String eeN = "";
    public boolean eeO = false;
    private String eeW = "";
    public boolean efA = true;
    public boolean efG = false;
    public boolean efH = false;
    private int efI = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ebl = null;
    public boolean efN = false;
    private int efV = 0;
    private boolean egb = false;
    private boolean egi = false;
    public boolean egp = false;
    public boolean egq = false;
    public boolean forbidComment = false;
    public boolean egC = false;
    public boolean egR = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eeh = 0;
    private int eei = 0;
    private String last_time = null;
    private long eej = 0;
    private int eek = 0;
    private int eel = 0;
    private int eem = 0;
    private int een = 0;
    private ca eeo = new ca();
    private MetaData eep = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> ees = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eet = new ArrayList<>();
    private int eeq = 0;
    private int eer = 0;
    private String ad_url = null;
    private String edY = null;
    private String from = null;
    private int eew = 0;
    private PraiseData eeA = new PraiseData();
    private AnchorInfoData eeB = new AnchorInfoData();
    private long time = 0;
    private int eeE = 0;
    private ArrayList<a> eeQ = new ArrayList<>();
    private ci eeR = null;
    private f eeS = null;
    private int eeX = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eeG = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eeY = null;
    private int eeP = 0;
    private boolean efb = false;
    private boolean efc = false;
    private int efd = 0;
    private boolean efe = false;
    private int anchorLevel = 0;
    public int efq = 0;
    public o efr = new o();
    private List<PbContent> eeb = new ArrayList();
    private List<PbContent> edZ = new ArrayList();
    private List<PbContent> eea = new ArrayList();
    private String category_name = null;
    private bu efg = new bu();
    private ArrayList<com.baidu.tbadk.data.c> efj = new ArrayList<>();
    private PushStatusData efk = new PushStatusData();
    public boolean efB = false;
    public int efC = -1;
    private PostData efK = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eft = 0;
    public int efR = 0;
    private String tieba_game_information_source = "";
    public String efU = "";
    public String efT = "";
    public String mUrl = "";
    public String efl = "";
    private List<PbLinkData> egG = new ArrayList();
    private List<PbGoodsData> egH = new ArrayList();
    public int egM = -1;

    static {
        eeU.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eeU.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eeU.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eeU.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eeU.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eeU.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eeU.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eeU.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        efE.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        efE.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        efE.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        efE.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        efE.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        efE.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        efE.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        efE.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eeV.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eeV.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eeV.put(3, Integer.valueOf(R.drawable.label_interview_off));
        efF.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        efF.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        efF.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bw() {
        this.eev = 0;
        this.eeF = 0;
        this.efa = 0L;
        this.efQ = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.efa = 0L;
        this.eeF = 0;
        this.eev = 0;
        this.efQ = 0;
    }

    public String beV() {
        return this.egj;
    }

    public String beW() {
        return this.egk;
    }

    public void zG(String str) {
        this.egk = str;
    }

    public String beX() {
        return this.egl;
    }

    public SpannableStringBuilder beY() {
        return this.eed;
    }

    public SpannableString beZ() {
        return this.ebv;
    }

    public void a(SpannableString spannableString) {
        if (bfy() != null && !bdi() && !bdh()) {
            if (this.eed != null) {
                this.eed.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ebv);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.ebv = new SpannableString(spannableStringBuilder);
        }
    }

    public void bfa() {
        if (com.baidu.tbadk.core.util.y.getCount(this.egK) > 0) {
            if (this.eed != null) {
                this.eed.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bm(this.egK));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.ebv);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bm(this.egK));
            this.ebv = new SpannableString(spannableStringBuilder);
        }
    }

    public String bfb() {
        return this.egm;
    }

    public String bfc() {
        return this.egn;
    }

    public boolean bfd() {
        return this.eev == 1;
    }

    public bu bfe() {
        return this.efg;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void no(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eeF;
    }

    public void np(int i) {
        this.efd = i;
    }

    public int bff() {
        return this.efd;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bfg() {
        return this.efZ;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void cA(long j) {
        this.mCreateTime = j;
    }

    public long bfh() {
        return this.eeL;
    }

    public String bfi() {
        return this.eeC;
    }

    public PraiseData bfj() {
        return this.eeA;
    }

    public void a(PraiseData praiseData) {
        this.eeA = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bfk() {
        return this.bhq;
    }

    public void zH(String str) {
        this.bhq = str;
    }

    public String bfl() {
        return this.edV;
    }

    public void zI(String str) {
        this.edV = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nq(int i) {
        this.edU = i;
    }

    public int bfm() {
        return this.edU;
    }

    public String bfn() {
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

    public List<PbContent> bfo() {
        return this.eeb;
    }

    public void aR(List<PbContent> list) {
        this.eeb = list;
    }

    public void aS(List<PbContent> list) {
        this.edZ = list;
    }

    public void aT(List<PbContent> list) {
        this.eea = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nr(int i) {
        this.reply_num = i;
    }

    public int bfp() {
        return this.reply_num;
    }

    public int bfq() {
        return this.eei;
    }

    public void ns(int i) {
        this.eei = i;
    }

    public long bfr() {
        return this.eej;
    }

    public void cB(long j) {
        this.eej = j;
    }

    public int bfs() {
        return this.eel;
    }

    public int bft() {
        return this.eek;
    }

    public void nt(int i) {
        this.eek = i;
    }

    public int bfu() {
        return this.eem;
    }

    public void nu(int i) {
        this.eem = i;
    }

    public int bfv() {
        return this.een;
    }

    public List<PbContent> bfw() {
        return this.edZ;
    }

    public ca bfx() {
        return this.eeo;
    }

    public MetaData bfy() {
        return this.eep;
    }

    public boolean bfz() {
        return this.is_god != 0;
    }

    public boolean bfA() {
        return this.is_god == 1;
    }

    public boolean bfB() {
        return (this.eep == null || this.eep.getGodUserData() == null || this.eep.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eep = metaData;
    }

    public String bfC() {
        return this.forum_name;
    }

    public void zJ(String str) {
        this.forum_name = str;
    }

    public int bfD() {
        return this.eer;
    }

    public String bfE() {
        return this.ad_url;
    }

    public int bfF() {
        return this.eew;
    }

    public void nv(int i) {
        this.eew = i;
    }

    public String bfG() {
        return this.eex;
    }

    public void zK(String str) {
        this.eex = str;
    }

    public ArrayList<MediaData> bfH() {
        return this.ees;
    }

    public ArrayList<a> bfI() {
        return this.eeQ;
    }

    public void E(ArrayList<a> arrayList) {
        this.eeQ = arrayList;
    }

    public ci bfJ() {
        return this.eeR;
    }

    public f bfK() {
        return this.eeS;
    }

    public ArrayList<VoiceData.VoiceModel> bfL() {
        return this.eet;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int bfM() {
        return this.edX;
    }

    public void nw(int i) {
        this.edX = i;
    }

    public String bfN() {
        return this.latitude;
    }

    public String bfO() {
        return this.eeD;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String bfP() {
        return this.eeN;
    }

    public VideoInfo bfQ() {
        return this.eeH;
    }

    public void a(VideoInfo videoInfo) {
        this.eeH = videoInfo;
    }

    public VideoDesc bfR() {
        return this.eeI;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eeK = alaInfoData;
    }

    public AlaInfoData bfS() {
        return this.eeK;
    }

    public PushStatusData bfT() {
        return this.efk;
    }

    public SkinInfo bfU() {
        return this.efm;
    }

    public long bfV() {
        return this.efz;
    }

    public boolean bfW() {
        return this.efA;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bcZ() {
        return this.efy;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bcY().getTid());
        arVar.setFid(bcY().getFid());
        arVar.setNid(bcY().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.ebl = this.ebl;
        arVar.abTag = this.mRecomAbTag;
        arVar.weight = this.mRecomWeight;
        arVar.extra = this.mRecomExtra;
        arVar.source = this.mRecomSource;
        arVar.ebp = this.ebp;
        arVar.cardType = bhx();
        return arVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eeD = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eev = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eeL = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eeh = threadInfo.repost_num.intValue();
                this.eei = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eej = threadInfo.last_time_int.intValue();
                this.eek = threadInfo.is_top.intValue();
                this.eel = threadInfo.is_membertop.intValue();
                this.eem = threadInfo.is_good.intValue();
                this.een = threadInfo.is_livepost.intValue();
                this.eeo.a(threadInfo.topic);
                this.eep.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eeq = threadInfo.has_commented.intValue();
                this.eer = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eeH = threadInfo.video_info;
                this.eeI = threadInfo.video_segment;
                this.eeK = new AlaInfoData();
                this.eeK.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eew = threadInfo.collect_status.intValue();
                this.eex = threadInfo.collect_mark_pid;
                this.eey = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eez = threadInfo.thread_type.intValue();
                this.eeC = threadInfo.first_post_id + "";
                this.eeN = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.edX = threadInfo.is_ntitle.intValue();
                this.eeE = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.efL = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eeF = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.efs = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.edZ = threadInfo.rich_title;
                this.eeb = threadInfo.first_post_content;
                this.eea = threadInfo.rich_abstract;
                this.eeu = threadInfo.is_godthread_recommend.intValue();
                if ((this.eep == null || this.eep.getUserId() == null || this.eep.getUserId().equals("0") || this.egR) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eep = metaData;
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
                this.edY = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.ees.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eeH = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eeJ = new cd();
                    this.eeJ.a(threadInfo.video_channel_info);
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
                        this.eet.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.eeQ.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eeR = new ci();
                    this.eeR.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eeS = new f();
                    this.eeS.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eeT = new r();
                    this.eeT.a(threadInfo.cartoon_info);
                }
                this.eeA.setUserMap(this.userMap);
                this.eeA.parserProtobuf(threadInfo.zan);
                this.eeB.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eeA.setTitle(this.title);
                } else {
                    this.eeA.setTitle(this.edY);
                }
                this.eeW = threadInfo.livecover_src;
                this.eeX = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eeP = threadInfo.post_num.intValue();
                this.efa = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qb(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.BO(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eeG.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eeY = noticeInfo.notice;
                    }
                    this.efd = zhiBoInfoTW.copythread_remind.intValue();
                    this.efb = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.efc = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eeW)) {
                        this.eeW = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.efh = zhiBoInfoTW.user.tw_anchor_info;
                        this.efi = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eeZ = threadInfo.twzhibo_info.livecover_status;
                    this.efa = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.efe = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.efg.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.efj.add(cVar2);
                    }
                }
                this.efk.parserProtobuf(threadInfo.push_status);
                this.efp = threadInfo.lego_card;
                this.efm = threadInfo.skin_info;
                this.efq = threadInfo.is_book_chapter.intValue();
                this.efr.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.efy = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.efz = threadInfo.last_read_pid.longValue();
                this.efA = threadInfo.cheak_repeat.intValue() == 1;
                this.efD = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.efK.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.ebl = sparseArray2;
                }
                this.efJ = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.efM = new am();
                    this.efM.a(threadInfo.link_info);
                }
                this.efN = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.efO = new e();
                    this.efO.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.efP = new MediaData();
                    this.efP.parserProtobuf(threadInfo.pic_info);
                }
                this.eft = threadInfo.is_called.intValue();
                this.efQ = threadInfo.middle_page_num.intValue();
                this.efR = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.efT = threadInfo.star_rank_icon.icon_pic_url;
                    this.efU = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.efS = new OriginalThreadInfo();
                    this.efS.a(threadInfo.origin_thread_info);
                } else {
                    this.efS = null;
                    this.isShareThread = false;
                }
                this.efV = threadInfo.is_topic.intValue();
                this.efX = threadInfo.topic_user_name;
                this.efY = threadInfo.topic_h5_url;
                this.efW = threadInfo.topic_module;
                this.ega = threadInfo.presentation_style;
                this.egd = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.egf = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eee = new bs();
                    this.eee.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.egh = threadInfo.swan_info;
                }
                this.ego = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.egp = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.egA = threadInfo.article_cover;
                this.egB = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.egC = threadInfo.is_s_card.intValue() == 1;
                this.egD = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.egE = threadInfo.wonderful_post_info;
                bfX();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.egF = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.egI) {
                            this.egI = true;
                        }
                        this.egG.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.egH.add(pbGoodsData);
                    }
                    if (this.egH.size() > 0 && !this.egI) {
                        this.egI = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.egJ = threadInfo.item;
                }
                if (this.egJ != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.egJ);
                }
                this.egK = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.egK)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.egK);
                }
                if (threadInfo.poll_info != null) {
                    if (this.egL == null) {
                        this.egL = new PollData();
                    }
                    this.egL.parserProtobuf(threadInfo.poll_info);
                }
                this.egM = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.egN = threadInfo.distance.intValue();
                this.egO = threadInfo.distance_text;
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
                this.eeL = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eeh = jSONObject.optInt("repost_num", 0);
                this.eei = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eej = jSONObject.optLong("last_time_int", 0L);
                this.eek = jSONObject.optInt("is_top", 0);
                this.eel = jSONObject.optInt("is_membertop", 0);
                this.eem = jSONObject.optInt("is_good", 0);
                this.een = jSONObject.optInt("is_livepost", 0);
                this.eeo.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.eep.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eeq = jSONObject.optInt("has_commented", 0);
                this.eer = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eew = jSONObject.optInt("collect_status");
                this.eex = jSONObject.optString("collect_mark_pid");
                this.eey = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eez = jSONObject.optInt("thread_type");
                this.efL = jSONObject.optLong("share_num");
                this.eeC = jSONObject.optString("first_post_id", "0");
                this.eeN = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.edX = jSONObject.optInt("is_ntitle");
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
                    this.ebl = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.efg.parserJson(optJSONObject2);
                }
                if ((this.eep == null || this.eep.getUserId() == null) && this.userMap != null) {
                    this.eep = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eeK = new AlaInfoData();
                this.eeK.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.edY = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.ees.add(mediaData);
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
                        this.eet.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eeQ.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eeR = new ci();
                    this.eeR.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eeS = new f();
                    this.eeS.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eeT = new r();
                    this.eeT.parserJson(optJSONObject6);
                }
                this.eeA.setUserMap(this.userMap);
                this.eeA.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eeB.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eeA.setTitle(this.title);
                } else {
                    this.eeA.setTitle(this.edY);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.efg.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.efj.add(cVar);
                    }
                }
                this.efq = jSONObject.optInt("is_book_chapter", 0);
                this.efr.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.efy = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.efu = jSONObject.optString("recom_extra_img");
                this.efx = jSONObject.optString("recom_extra_img_night");
                this.efv = jSONObject.optInt("recom_extra_img_width", 0);
                this.efw = jSONObject.optInt("recom_extra_img_height", 0);
                this.efz = jSONObject.optLong("last_read_pid");
                this.efA = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eeJ = new cd();
                    this.eeJ.cV(optJSONObject8);
                }
                this.efJ = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.efM = new am();
                    this.efM.parserJson(optJSONObject9);
                }
                this.efN = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.efO = new e();
                    this.efO.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.efP = new MediaData();
                    this.efP.parserJson(optJSONObject11);
                }
                this.eft = jSONObject.optInt("is_called", 0);
                this.efQ = jSONObject.optInt("middle_page_num", 0);
                this.efR = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eeH = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.efS = new OriginalThreadInfo();
                        this.efS.parserJson(optJSONObject13);
                    } else {
                        this.efS = null;
                    }
                } else {
                    this.efS = null;
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
                    this.egh = builder2.build(false);
                }
                this.ego = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.egp = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.egB = jSONObject.optInt("bjh_content_tag");
                this.egA = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.egC = jSONObject.optInt("is_s_card", 0) == 1;
                this.egD = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.egE = jSONObject.optString("wonderful_post_info");
                bfX();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.egL == null) {
                        this.egL = new PollData();
                    }
                    this.egL.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.egI) {
                            this.egI = true;
                        }
                        this.egG.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.egH.add(pbGoodsData);
                    }
                    if (this.egH.size() > 0 && !this.egI) {
                        this.egI = true;
                    }
                }
                this.egM = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.egN = jSONObject.optInt("distance");
                this.egO = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bfX() {
        bfY();
        bga();
        bgd();
        bge();
        bgf();
        bgg();
        bgh();
    }

    private void bfY() {
        if (!StringUtils.isNull(this.eep.getName_show())) {
            this.egj = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eep.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bfZ() {
        if (this.eeK != null) {
            if (this.eeK.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cP = com.baidu.tbadk.core.util.at.cP(this.mCreateTime);
                if (!StringUtils.isNull(cP)) {
                    this.egk = cP;
                }
            }
            if (this.eeK.openRecomFans == 1) {
                int i = 0;
                if (this.eeK != null && this.eeK.user_info != null) {
                    i = this.eeK.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.egk) && i > 0) {
                    this.egk += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.cS(i);
                } else if (i > 0) {
                    this.egk = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.cS(i);
                }
            }
        }
    }

    private void bga() {
        if (bei() || (bhq() && getType() != edD)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cN = com.baidu.tbadk.core.util.at.cN(j);
                if (com.baidu.tbadk.core.util.at.AD(cN)) {
                    cN = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.egk = cN;
            }
            String str = "";
            if (this.eep != null && this.eep.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eep.getBaijiahaoInfo().auth_desc)) {
                str = this.eep.getBaijiahaoInfo().auth_desc;
            }
            if (bhz()) {
                bgb();
            } else if (!this.egt && this.eep != null && this.eep.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eep.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.egk)) {
                    this.egk += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.egk = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.egk) && !TextUtils.isEmpty(str)) {
                this.egk += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.egk = str;
            }
        } else if (getType() == edD) {
            bfZ();
        } else {
            long bfr = bfr() * 1000;
            if (bfr != 0) {
                String cN2 = com.baidu.tbadk.core.util.at.cN(bfr);
                if (com.baidu.tbadk.core.util.at.AD(cN2)) {
                    cN2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bfr);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bdh()) {
                    cN2 = com.baidu.tbadk.core.util.at.cO(bfr);
                }
                this.egk = string + cN2;
            } else {
                long j2 = this.mCreateTime;
                String cN3 = com.baidu.tbadk.core.util.at.cN(j2);
                if (com.baidu.tbadk.core.util.at.AD(cN3)) {
                    cN3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.egk = cN3;
            }
            if (bhz()) {
                bgb();
            } else if (!this.egt && this.eep != null && this.eep.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eep.getBazhuGradeData().getDesc(), this.egs ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.egk)) {
                    this.egk += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.egk = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.egk) && !TextUtils.isEmpty(getAddress())) {
                this.egk += " • " + getAddress();
            }
        }
    }

    private void bgb() {
        if (bhz() && !TextUtils.isEmpty(this.eep.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.egk)) {
                this.egk += "   " + this.eep.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.egk = this.eep.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void bgc() {
        if (!bei() && !bhq()) {
            long bfr = 1000 * bfr();
            if (bfr != 0) {
                String cN = com.baidu.tbadk.core.util.at.cN(bfr);
                if (com.baidu.tbadk.core.util.at.AD(cN)) {
                    cN = com.baidu.tbadk.core.util.at.getFormatTimeShort(bfr);
                }
                this.egk = cN;
            }
            if (bhz()) {
                bgb();
            } else if (!this.egt && this.eep != null && this.eep.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.eep.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.egk)) {
                    this.egk += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.egk = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.egk) && !TextUtils.isEmpty(getAddress())) {
                this.egk += " • " + getAddress();
            }
        }
    }

    private void bgd() {
        if (bfS() == null || bfS().share_info == null || bfS().share_info.share_user_count <= 0 || !bgS() || (this.efQ > 0 && this.efR == 0)) {
            this.egl = null;
            return;
        }
        int i = bfS().share_info.share_user_count;
        if (i == 1) {
            this.egl = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.egl = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void bge() {
        this.eed = bgv();
        com.baidu.tieba.card.m.a(this, this.eed, true);
    }

    private void bgf() {
        this.ebv = bgt();
    }

    private void bgg() {
        this.egm = com.baidu.tbadk.core.util.at.getFormatTimeShort(bfr() * 1000);
    }

    private void bgh() {
        this.egn = com.baidu.tbadk.core.util.at.getFormatTimeShort(bfr());
    }

    public SpannableStringBuilder bgi() {
        return this.eec;
    }

    public boolean isTop() {
        return bft() != 0;
    }

    public int bgj() {
        if (this.efg != null) {
            long beQ = this.efg.beQ();
            long beR = this.efg.beR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < beQ) {
                return 1;
            }
            if (currentTimeMillis > beR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bgk() {
        if (bgm() && this.eeQ.size() >= 1) {
            a aVar = this.eeQ.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bdl = aVar.bdl();
            int bdm = aVar.bdm();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bdl) {
                return 4;
            }
            return currentTimeMillis > bdm ? 2 : 1;
        }
        return -1;
    }

    public int bgl() {
        if (!bgm() || this.eeQ.size() < 1 || this.eeQ.get(0) == null) {
            return -1;
        }
        return this.eeQ.get(0).bdk();
    }

    public boolean bgm() {
        return this.eeE == 1;
    }

    public String getActUrl() {
        return (!bgm() || this.eeQ.size() < 1 || this.eeQ.get(0) == null) ? "" : this.eeQ.get(0).getUrl();
    }

    private com.baidu.adp.widget.b zL(String str) {
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

    public SmartApp bgn() {
        return this.egh;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bgp()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bft() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bft() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bfv() == 1 || this.eeo.bhN() != 0) {
                if (bfe() != null && getThreadType() == 41) {
                    if (bgj() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bgG()) {
                Integer num = eeV.get(Integer.valueOf(bgj()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bfu() == 1 && !isTop() && edC != getType() && edK != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eeB != null && this.eeB.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bfD() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eeU.get(new Point(bgl(), bgk()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bfJ() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bfK() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = zL(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.edW));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bgq = bgq();
        if (bgq != null) {
            spannableStringBuilder.append((CharSequence) bgq);
        }
        this.eec = spannableStringBuilder;
    }

    public boolean bgo() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bfy() != null) {
            if (bfy().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bfy().getGender() == 2) {
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

    private boolean bgp() {
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
        SpannableStringBuilder bgq = bgq();
        if (z) {
            spannableStringBuilder = a(bgq.toString(), bgq, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bgq);
        }
        this.eec = spannableStringBuilder;
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
            if (this.edX == 1) {
                this.eec = a2;
                return a2;
            }
        } else if (this.edX == 1) {
            this.eec = new SpannableStringBuilder();
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
        this.efl = str2;
    }

    public SpannableStringBuilder bgq() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.edZ, this.title);
    }

    public SpannableStringBuilder bgr() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eea, this.edY);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bgs() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.egC) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bgt() {
        SpannableStringBuilder bgr = bgr();
        com.baidu.tieba.card.m.a(this, bgr, false);
        return new SpannableString(bgr);
    }

    public SpannableString bgu() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eeb)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eeb, this.edY));
    }

    public String getAbstract() {
        return this.edY;
    }

    public void zM(String str) {
        this.edY = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bgq;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.edX == 1) {
            bgq = bgr();
            spannableStringBuilder = bgq.toString();
        } else {
            bgq = bgq();
            spannableStringBuilder = bgq.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bgq, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bgq);
        }
        this.eec = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bgr;
        if (!StringUtils.isNull(this.title) && this.edX != 1) {
            bgr = bgq();
        } else {
            bgr = bgr();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bgr);
        this.eec = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bgv() {
        if (StringUtils.isNull(this.title) || this.edX == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bgq());
        this.eec = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bed() {
        if (this.edZ != null && this.edZ.size() > 0) {
            int size = this.edZ.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.edZ.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bee() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.CY(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bgw() {
        y(false, false);
    }

    public void bgx() {
        y(false, true);
    }

    public AnchorInfoData bgy() {
        return this.eeB;
    }

    public boolean bgz() {
        return this.threadType == 36;
    }

    public boolean bee() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bgA() {
        return this.threadType == 11 || this.eey == 1;
    }

    public boolean bgB() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> bfH = bfH();
        if (bfH == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bfH.size() || i2 >= 3) {
                break;
            }
            if (bfH.get(i2) != null && bfH.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(bfH.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = bfH.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = bfH.get(i2).getPicUrl();
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
        if (this.eeH != null && !StringUtils.isNull(this.eeH.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eeH.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eep != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eep.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bgC() {
        String userId;
        return this.eep == null || (userId = this.eep.getUserId()) == null || userId.equals("0");
    }

    public boolean bgD() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bhn()) {
            if (bfQ() != null) {
                return edC;
            }
            return edg;
        }
        int bft = bft();
        if (this.efV == 1) {
            if (this.efW != null) {
                return edt;
            }
            return this.efZ != null ? edM : edL;
        } else if (this.eeK != null && this.threadType == 60) {
            return edF;
        } else {
            if (this.eeK != null && this.threadType == 49) {
                return edD;
            }
            if (this.threadType == 51) {
                return edE;
            }
            if (this.threadType == 63) {
                return edN;
            }
            if (this.threadType == 64) {
                return edO;
            }
            if (bft == 2 || bft == 1) {
                return edf;
            }
            if (this.eeH != null && bgL() && !bgD()) {
                return edT;
            }
            if (this.eeH != null && !bgD()) {
                if (bfB()) {
                    return edK;
                }
                return edC;
            } else if (this.isShareThread && this.efS != null) {
                if (this.efS.ebw) {
                    if (this.efS.videoInfo != null) {
                        return edJ;
                    }
                    if (this.efS.beg()) {
                        return edI;
                    }
                    return edH;
                }
                return edG;
            } else if (beg()) {
                return edu;
            } else {
                if (bgF()) {
                    return edQ.get() ? eff : edg;
                } else if (bgm() && bgl() == 1) {
                    return edQ.get() ? efn : edg;
                } else if (isLinkThread()) {
                    return edA;
                } else {
                    if (bfB()) {
                        return edB;
                    }
                    if (this.ecM) {
                        return edl;
                    }
                    if (this.ecN) {
                        return edm;
                    }
                    if (this.ecO) {
                        return edn;
                    }
                    if (this.ecP) {
                        return edo;
                    }
                    if (this.ecQ) {
                        return edp;
                    }
                    if (this.ecS) {
                        return edr;
                    }
                    if (this.ecT) {
                        return eds;
                    }
                    if (this.ecR) {
                        return edq;
                    }
                    if (this.eeO) {
                        int bgE = bgE();
                        if (bgE == 1) {
                            return edh;
                        }
                        if (bgE == 2) {
                            return edi;
                        }
                        if (bgE > 2) {
                            return edj;
                        }
                        return edg;
                    }
                    return edg;
                }
            }
        }
    }

    public int bgE() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bcG().isShowImages() || com.baidu.tbadk.core.util.y.getCount(bfH()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < bfH().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bgF() {
        return bfe() != null && getThreadType() == 41 && bfv() == 1 && bgj() == 2;
    }

    public void F(ArrayList<s> arrayList) {
        if (this.edX == 1) {
            this.dZI = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dZI = 0;
        } else {
            this.dZI = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.bdA() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bdA().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dZI = next.bdB();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bgG() {
        return this.threadType == 41;
    }

    public boolean bgH() {
        return this.efo;
    }

    public void hV(boolean z) {
        this.efo = z;
    }

    public String bgI() {
        return this.efp;
    }

    public r bgJ() {
        return this.eeT;
    }

    public void bgK() {
        if (this.eeM == 0) {
            this.eeM = 1;
        }
    }

    public void hW(boolean z) {
        this.efB = z;
    }

    public boolean bgL() {
        return this.efB;
    }

    public void nx(int i) {
        this.efC = i + 1;
    }

    public int bgM() {
        return this.efC;
    }

    public boolean bgN() {
        return this.egr;
    }

    public void hX(boolean z) {
        this.egr = z;
    }

    public cd bgO() {
        return this.eeJ;
    }

    public boolean bgP() {
        return getThreadType() == 49;
    }

    public boolean bgQ() {
        return getThreadType() == 40;
    }

    public boolean bgR() {
        return getThreadType() == 50;
    }

    public boolean bgS() {
        return getThreadType() == 60;
    }

    public int bgT() {
        return this.efI;
    }

    public void setSmartFrsPosition(int i) {
        this.efI = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bgU() {
        return this.mRecomSource;
    }

    public boolean bgV() {
        return this.efJ;
    }

    public long bgW() {
        return this.agreeData.agreeNum;
    }

    public long bgX() {
        return this.agreeData.disAgreeNum;
    }

    public int bgY() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bgZ() {
        return this.agreeData.agreeType;
    }

    public void ny(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void nz(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cC(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cD(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void nA(int i) {
        this.agreeData.agreeType = i;
    }

    public long bha() {
        return this.efL;
    }

    public void cE(long j) {
        this.efL = j;
    }

    public PostData bhb() {
        return this.efK;
    }

    public am bhc() {
        return this.efM;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean bfz = bfz();
        if (z2) {
            if (z) {
                if (bfz && !bee()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (bfv() == 1 || getThreadType() == 33 || (bfx() != null && bfx().bhN() != 0)) {
                    if (bfe() != null && bgG()) {
                        if (bgj() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!bfz) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (bgG()) {
                    arrayList.add(efF.get(bgj()));
                }
                if (bgm()) {
                    Integer num = efE.get(new Point(bgl(), bgk()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (bfJ() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (bfz && bft() != 1 && !bee()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((bfv() == 1 || getThreadType() == 33) && !bgG() && !bfz) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (bfu() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bft() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (bgG() && bfe() != null && bgj() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (bgm()) {
                    Integer num2 = efE.get(new Point(bgl(), bgk()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.efq == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (bfK() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (bfJ() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bgP()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bgR()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bgQ()) {
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
        this.ees = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eet = arrayList;
    }

    public String bhd() {
        return this.efX;
    }

    public void zN(String str) {
        this.efX = str;
    }

    public void bhe() {
        this.efV = 1;
    }

    public boolean bhf() {
        return this.efV == 1;
    }

    public String bhg() {
        return this.eef;
    }

    public void zO(String str) {
        this.eef = str;
    }

    public String bhh() {
        return this.eeg;
    }

    public void zP(String str) {
        this.eeg = str;
    }

    public String bhi() {
        return this.efY;
    }

    public void zQ(String str) {
        this.efY = str;
    }

    public boolean bhj() {
        return this.egb;
    }

    public void hY(boolean z) {
        this.egb = z;
    }

    public boolean bhk() {
        return this.egc;
    }

    public void hZ(boolean z) {
        this.egc = z;
    }

    public void b(VideoInfo videoInfo) {
        this.efZ = videoInfo;
    }

    public boolean bhl() {
        return this.egd != null;
    }

    public bs bhm() {
        return this.eee;
    }

    public boolean bhn() {
        return this.egg;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eeH != null) {
            return this.eeH.video_url;
        }
        return null;
    }

    public boolean bho() {
        return this.egi;
    }

    public void ia(boolean z) {
        this.egi = z;
    }

    public AgreeData bhp() {
        return this.agreeData;
    }

    public boolean bhq() {
        return this.egu;
    }

    public void ib(boolean z) {
        this.egu = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean bdg() {
        return this.egs;
    }

    public void ic(boolean z) {
        this.egs = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bhr() {
        return this.efW;
    }

    public String getShareImageUrl() {
        return this.ego;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> bfH = bfH();
        if (com.baidu.tbadk.core.k.bcG().isShowImages() && com.baidu.tbadk.core.util.y.getCount(bfH) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < bfH.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(bfH, 0);
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

    public boolean bhs() {
        return bht() || bhu();
    }

    public boolean beg() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean beh() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bht() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bhu() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bei() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bei();
    }

    public void nB(int i) {
        this.isBjh = i;
    }

    public int bhv() {
        return this.egB;
    }

    public String bhw() {
        return this.egA;
    }

    public void zR(String str) {
        this.egA = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bhx() {
        if (bfA()) {
            return 4;
        }
        if (bgP() || bgR()) {
            return 3;
        }
        if (beg()) {
            return 5;
        }
        if (beh()) {
            return 6;
        }
        if (bht()) {
            return 7;
        }
        if (bhu()) {
            return 8;
        }
        if (this.isShareThread && this.efS != null) {
            return 9;
        }
        if (bgQ()) {
            return 2;
        }
        return 1;
    }

    public int bhy() {
        if (bhu() || bht()) {
            return 2;
        }
        if (beg() || beh()) {
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

    public boolean bhz() {
        return this.eep != null && this.eep.isNewGod();
    }

    public boolean bhA() {
        return (bfy() == null || bfy().getAlaUserData() == null || bfy().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bhB() {
        return this.egJ;
    }

    public List<HeadItem> bhC() {
        return this.egK;
    }

    public void a(Item item) {
        this.egJ = item;
    }

    public void aU(List<HeadItem> list) {
        this.egK = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bhD() {
        return this.egL;
    }

    public void b(PollData pollData) {
        this.egL = pollData;
    }

    public List<PbLinkData> bhE() {
        return this.egG;
    }

    public void aV(List<PbLinkData> list) {
        this.egG = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.egG)) {
            for (PbLinkData pbLinkData : this.egG) {
                if (pbLinkData.urlType == 2 && !this.egI) {
                    this.egI = true;
                }
            }
        }
    }

    public List<PbGoodsData> bhF() {
        return this.egH;
    }

    public void aW(List<PbGoodsData> list) {
        this.egH = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.egI) {
            this.egI = true;
        }
    }

    public boolean bhG() {
        return this.egI;
    }
}

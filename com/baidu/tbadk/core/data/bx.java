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
public class bx extends a implements com.baidu.adp.widget.ListView.q, com.baidu.tbadk.core.util.ah, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String bml;
    public String buttonText;
    public int eAb;
    private SpannableString eAh;
    private int eCK;
    private SpannableStringBuilder eCP;
    private SpannableStringBuilder eCQ;
    private bt eCR;
    private String eCS;
    private String eCT;
    private s eDG;
    private LiveCoverStatus eDM;
    private long eDN;
    public TwZhiBoUser eDU;
    public List<TwAnchorProfitItem> eDV;
    private SkinInfo eDZ;
    public int eDh;
    private int eDi;
    private int eDl;
    public int eDm;
    private String eDp;
    private String eDq;
    private int eDs;
    private VideoInfo eDu;
    private VideoDesc eDv;
    private ce eDw;
    private AlaInfoData eDx;
    private long eDy;
    public f eEB;
    private MediaData eEC;
    public int eED;
    public OriginalThreadInfo eEF;
    private TopicModule eEJ;
    private String eEK;
    private String eEL;
    private VideoInfo eEM;
    private String eEN;
    private boolean eEP;
    public OriginalForumInfo eEQ;
    public boolean eER;
    private String eES;
    private boolean eET;
    private SmartApp eEU;
    private String eEW;
    private String eEX;
    private String eEY;
    private String eEZ;
    private boolean eEb;
    private String eEc;
    private boolean eEf;
    public String eEh;
    public int eEi;
    public int eEj;
    public String eEk;
    public String eEl;
    public long eEm;
    private List<ReportInfo> eEq;
    private boolean eEw;
    private long eEy;
    private an eEz;
    public int eFA;
    public String eFB;
    public String eFC;
    public String eFD;
    private String eFa;
    public String eFb;
    private boolean eFe;
    private boolean eFf;
    public boolean eFg;
    public boolean eFh;
    public boolean eFi;
    public boolean eFj;
    public boolean eFk;
    public boolean eFl;
    public String eFm;
    private String eFn;
    private int eFo;
    public String eFq;
    private String eFr;
    private ThreadInfo eFs;
    private boolean eFv;
    private Item eFw;
    private List<HeadItem> eFx;
    PollData eFy;
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
    public static final BdUniqueId eBQ = BdUniqueId.gen();
    public static final BdUniqueId eBR = BdUniqueId.gen();
    public static final BdUniqueId eBS = BdUniqueId.gen();
    public static final BdUniqueId eBT = BdUniqueId.gen();
    public static final BdUniqueId eBU = BdUniqueId.gen();
    public static final BdUniqueId eBV = BdUniqueId.gen();
    public static final BdUniqueId eBW = BdUniqueId.gen();
    public static final BdUniqueId eBX = BdUniqueId.gen();
    public static final BdUniqueId eBY = BdUniqueId.gen();
    public static final BdUniqueId eBZ = BdUniqueId.gen();
    public static final BdUniqueId eCa = BdUniqueId.gen();
    public static final BdUniqueId eCb = BdUniqueId.gen();
    public static final BdUniqueId eCc = BdUniqueId.gen();
    public static final BdUniqueId eCd = BdUniqueId.gen();
    public static final BdUniqueId eCe = BdUniqueId.gen();
    public static final BdUniqueId eCf = BdUniqueId.gen();
    public static final BdUniqueId eCg = BdUniqueId.gen();
    public static final BdUniqueId eCh = BdUniqueId.gen();
    public static final BdUniqueId eCi = BdUniqueId.gen();
    public static final BdUniqueId eCj = BdUniqueId.gen();
    public static final BdUniqueId eCk = BdUniqueId.gen();
    public static final BdUniqueId eCl = BdUniqueId.gen();
    public static final BdUniqueId eCm = BdUniqueId.gen();
    public static final BdUniqueId eCn = BdUniqueId.gen();
    public static final BdUniqueId eCo = BdUniqueId.gen();
    public static final BdUniqueId eCp = BdUniqueId.gen();
    public static final BdUniqueId eCq = BdUniqueId.gen();
    public static final BdUniqueId eCr = BdUniqueId.gen();
    public static final BdUniqueId eCs = BdUniqueId.gen();
    public static final BdUniqueId eCt = BdUniqueId.gen();
    public static final BdUniqueId eCu = BdUniqueId.gen();
    public static final BdUniqueId eCv = BdUniqueId.gen();
    public static final BdUniqueId eCw = BdUniqueId.gen();
    public static final BdUniqueId eCx = BdUniqueId.gen();
    public static final BdUniqueId eCy = BdUniqueId.gen();
    public static final BdUniqueId eCz = BdUniqueId.gen();
    public static final BdUniqueId eCA = BdUniqueId.gen();
    public static final BdUniqueId eCB = BdUniqueId.gen();
    public static final BdUniqueId eCC = BdUniqueId.gen();
    public static AtomicBoolean eCD = new AtomicBoolean(false);
    public static AtomicBoolean eCE = new AtomicBoolean(false);
    public static AtomicBoolean eCF = new AtomicBoolean(false);
    public static final BdUniqueId eCG = BdUniqueId.gen();
    private static HashMap<Point, Integer> eDH = new HashMap<>();
    private static HashMap<Integer, Integer> eDI = new HashMap<>();
    public static final BdUniqueId eDS = BdUniqueId.gen();
    public static final BdUniqueId eEa = BdUniqueId.gen();
    private static HashMap<Point, Integer> eEr = new HashMap<>();
    private static SparseArray<n.a> eEs = new SparseArray<>(3);
    public boolean eBx = false;
    public boolean eBy = false;
    public boolean eBz = false;
    public boolean eBA = false;
    public boolean eBB = false;
    public boolean eBC = false;
    public boolean eBD = false;
    public boolean eBE = false;
    private int eCH = 0;
    private String eCI = "1";
    public int eCJ = 1;
    private String eDk = null;
    private int eyu = 0;
    public int eDz = 0;
    private String eDA = "";
    public boolean eDB = false;
    private String eDJ = "";
    public boolean eEn = true;
    public boolean eEt = false;
    public boolean eEu = false;
    private int eEv = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> ezX = null;
    public boolean eEA = false;
    private int eEI = 0;
    private boolean eEO = false;
    private boolean eEV = false;
    public boolean eFc = false;
    public boolean eFd = false;
    public boolean forbidComment = false;
    public boolean eFp = false;
    public boolean eFE = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eCU = 0;
    private int eCV = 0;
    private String last_time = null;
    private long eCW = 0;
    private int eCX = 0;
    private int eCY = 0;
    private int eCZ = 0;
    private int eDa = 0;
    private cb eDb = new cb();
    private MetaData eDc = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eDf = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eDg = new ArrayList<>();
    private int eDd = 0;
    private int eDe = 0;
    private String ad_url = null;
    private String eCL = null;
    private String from = null;
    private int eDj = 0;
    private PraiseData eDn = new PraiseData();
    private AnchorInfoData eDo = new AnchorInfoData();
    private long time = 0;
    private int eDr = 0;
    private ArrayList<b> eDD = new ArrayList<>();
    private cj eDE = null;
    private g eDF = null;
    private int eDK = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eDt = new ArrayList<>();
    private boolean isHeadLive = false;
    private String eDL = null;
    private int eDC = 0;
    private boolean eDO = false;
    private boolean eDP = false;
    private int eDQ = 0;
    private boolean eDR = false;
    private int anchorLevel = 0;
    public int eEd = 0;
    public p eEe = new p();
    private List<PbContent> eCO = new ArrayList();
    private List<PbContent> eCM = new ArrayList();
    private List<PbContent> eCN = new ArrayList();
    private String category_name = null;
    private bv eDT = new bv();
    private ArrayList<com.baidu.tbadk.data.c> eDW = new ArrayList<>();
    private PushStatusData eDX = new PushStatusData();
    public boolean eEo = false;
    public int eEp = -1;
    private PostData eEx = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int eEg = 0;
    public int eEE = 0;
    private String tieba_game_information_source = "";
    public String eEH = "";
    public String eEG = "";
    private String mUrl = "";
    private String eDY = "";
    private List<PbLinkData> eFt = new ArrayList();
    private List<PbGoodsData> eFu = new ArrayList();
    public int eFz = -1;

    static {
        eDH.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eDH.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eDH.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eDH.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eDH.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eDH.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eDH.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eDH.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        eEr.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        eEr.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        eEr.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        eEr.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        eEr.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        eEr.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        eEr.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        eEr.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        eDI.put(1, Integer.valueOf(R.drawable.label_interview_no));
        eDI.put(2, Integer.valueOf(R.drawable.label_interview_live));
        eDI.put(3, Integer.valueOf(R.drawable.label_interview_off));
        eEs.put(1, new n.a(R.string.interview_live_status_not_start, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
        eEs.put(2, new n.a(R.string.interview_live_status_ing, R.color.CAM_X0309, R.drawable.pic_dot_title_green));
        eEs.put(3, new n.a(R.string.interview_live_status_over, R.color.CAM_X0303, R.drawable.pic_dot_title_blue));
    }

    public bx() {
        this.eDi = 0;
        this.eDs = 0;
        this.eDN = 0L;
        this.eED = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.eDN = 0L;
        this.eDs = 0;
        this.eDi = 0;
        this.eED = 0;
    }

    public String bkZ() {
        return this.eEW;
    }

    public String bla() {
        return this.eEX;
    }

    public void Au(String str) {
        this.eEX = str;
    }

    public String blb() {
        return this.eEY;
    }

    public SpannableStringBuilder blc() {
        return this.eCQ;
    }

    public SpannableString bld() {
        return this.eAh;
    }

    public void a(SpannableString spannableString) {
        if (blC() != null && !bjm() && !bjl()) {
            if (this.eCQ != null) {
                this.eCQ.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eAh);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.eAh = new SpannableString(spannableStringBuilder);
        }
    }

    public void ble() {
        if (com.baidu.tbadk.core.util.y.getCount(this.eFx) > 0) {
            if (this.eCQ != null) {
                this.eCQ.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bF(this.eFx));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eAh);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bF(this.eFx));
            this.eAh = new SpannableString(spannableStringBuilder);
        }
    }

    public String blf() {
        return this.eEZ;
    }

    public String blg() {
        return this.eFa;
    }

    public boolean blh() {
        return this.eDi == 1;
    }

    public bv bli() {
        return this.eDT;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void oc(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eDs;
    }

    public void od(int i) {
        this.eDQ = i;
    }

    public int blj() {
        return this.eDQ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo blk() {
        return this.eEM;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void dg(long j) {
        this.mCreateTime = j;
    }

    public long bll() {
        return this.eDy;
    }

    public String blm() {
        return this.eDp;
    }

    public PraiseData bln() {
        return this.eDn;
    }

    public void a(PraiseData praiseData) {
        this.eDn = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String blo() {
        return this.bml;
    }

    public void Av(String str) {
        this.bml = str;
    }

    public String blp() {
        return this.eCI;
    }

    public void Aw(String str) {
        this.eCI = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void oe(int i) {
        this.eCH = i;
    }

    public int blq() {
        return this.eCH;
    }

    public String blr() {
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

    public List<PbContent> bls() {
        return this.eCO;
    }

    public void bl(List<PbContent> list) {
        this.eCO = list;
    }

    public void bm(List<PbContent> list) {
        this.eCM = list;
    }

    public void bn(List<PbContent> list) {
        this.eCN = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void of(int i) {
        this.reply_num = i;
    }

    public int blt() {
        return this.reply_num;
    }

    public int blu() {
        return this.eCV;
    }

    public void og(int i) {
        this.eCV = i;
    }

    public long blv() {
        return this.eCW;
    }

    public void dh(long j) {
        this.eCW = j;
    }

    public int blw() {
        return this.eCY;
    }

    public int blx() {
        return this.eCX;
    }

    public void oh(int i) {
        this.eCX = i;
    }

    public int bly() {
        return this.eCZ;
    }

    public void oi(int i) {
        this.eCZ = i;
    }

    public int blz() {
        return this.eDa;
    }

    public List<PbContent> blA() {
        return this.eCM;
    }

    public cb blB() {
        return this.eDb;
    }

    public MetaData blC() {
        return this.eDc;
    }

    public boolean blD() {
        return this.is_god != 0;
    }

    public boolean blE() {
        return this.is_god == 1;
    }

    public boolean blF() {
        return (this.eDc == null || this.eDc.getGodUserData() == null || this.eDc.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.eDc = metaData;
    }

    public String blG() {
        return this.forum_name;
    }

    public void Ax(String str) {
        this.forum_name = str;
    }

    public int blH() {
        return this.eDe;
    }

    public String blI() {
        return this.ad_url;
    }

    public int blJ() {
        return this.eDj;
    }

    public void oj(int i) {
        this.eDj = i;
    }

    public String blK() {
        return this.eDk;
    }

    public void Ay(String str) {
        this.eDk = str;
    }

    public ArrayList<MediaData> blL() {
        return this.eDf;
    }

    public ArrayList<b> blM() {
        return this.eDD;
    }

    public void E(ArrayList<b> arrayList) {
        this.eDD = arrayList;
    }

    public cj blN() {
        return this.eDE;
    }

    public g blO() {
        return this.eDF;
    }

    public ArrayList<VoiceData.VoiceModel> blP() {
        return this.eDg;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int blQ() {
        return this.eCK;
    }

    public void ok(int i) {
        this.eCK = i;
    }

    public String blR() {
        return this.latitude;
    }

    public String blS() {
        return this.eDq;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String blT() {
        return this.eDA;
    }

    public VideoInfo blU() {
        return this.eDu;
    }

    public void a(VideoInfo videoInfo) {
        this.eDu = videoInfo;
    }

    public VideoDesc blV() {
        return this.eDv;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eDx = alaInfoData;
    }

    public AlaInfoData blW() {
        return this.eDx;
    }

    public PushStatusData blX() {
        return this.eDX;
    }

    public SkinInfo blY() {
        return this.eDZ;
    }

    public long blZ() {
        return this.eEm;
    }

    public boolean bma() {
        return this.eEn;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bje() {
        return this.eEl;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        as asVar = new as();
        asVar.setTid(bjd().getTid());
        asVar.setFid(bjd().getFid());
        asVar.setNid(bjd().getNid());
        asVar.setFeedBackReasonMap(this.feedBackReasonMap);
        asVar.ezX = this.ezX;
        asVar.abTag = this.mRecomAbTag;
        asVar.weight = this.mRecomWeight;
        asVar.extra = this.mRecomExtra;
        asVar.source = this.mRecomSource;
        asVar.eAb = this.eAb;
        asVar.cardType = bnD();
        return asVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eDq = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eDi = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eDy = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eCU = threadInfo.repost_num.intValue();
                this.eCV = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eCW = threadInfo.last_time_int.intValue();
                this.eCX = threadInfo.is_top.intValue();
                this.eCY = threadInfo.is_membertop.intValue();
                this.eCZ = threadInfo.is_good.intValue();
                this.eDa = threadInfo.is_livepost.intValue();
                this.eDb.a(threadInfo.topic);
                this.eDc.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eDd = threadInfo.has_commented.intValue();
                this.eDe = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eDu = threadInfo.video_info;
                this.eDv = threadInfo.video_segment;
                this.eDx = new AlaInfoData();
                this.eDx.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eDj = threadInfo.collect_status.intValue();
                this.eDk = threadInfo.collect_mark_pid;
                this.eDl = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eDm = threadInfo.thread_type.intValue();
                this.eDp = threadInfo.first_post_id + "";
                this.eDA = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eCK = threadInfo.is_ntitle.intValue();
                this.eDr = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.eEy = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eDs = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.eEf = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eCM = threadInfo.rich_title;
                this.eCO = threadInfo.first_post_content;
                this.eCN = threadInfo.rich_abstract;
                this.eDh = threadInfo.is_godthread_recommend.intValue();
                if ((this.eDc == null || this.eDc.getUserId() == null || this.eDc.getUserId().equals("0") || this.eFE) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.eDc = metaData;
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
                this.eCL = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eDf.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eDu = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eDw = new ce();
                    this.eDw.a(threadInfo.video_channel_info);
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
                        this.eDg.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.eDD.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eDE = new cj();
                    this.eDE.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eDF = new g();
                    this.eDF.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eDG = new s();
                    this.eDG.a(threadInfo.cartoon_info);
                }
                this.eDn.setUserMap(this.userMap);
                this.eDn.parserProtobuf(threadInfo.zan);
                this.eDo.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eDn.setTitle(this.title);
                } else {
                    this.eDn.setTitle(this.eCL);
                }
                this.eDJ = threadInfo.livecover_src;
                this.eDK = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eDC = threadInfo.post_num.intValue();
                this.eDN = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.rs(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.CG(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eDt.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.eDL = noticeInfo.notice;
                    }
                    this.eDQ = zhiBoInfoTW.copythread_remind.intValue();
                    this.eDO = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.eDP = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.eDJ)) {
                        this.eDJ = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.eDU = zhiBoInfoTW.user.tw_anchor_info;
                        this.eDV = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.eDM = threadInfo.twzhibo_info.livecover_status;
                    this.eDN = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.eDR = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.eDT.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.eDW.add(cVar2);
                    }
                }
                this.eDX.parserProtobuf(threadInfo.push_status);
                this.eEc = threadInfo.lego_card;
                this.eDZ = threadInfo.skin_info;
                this.eEd = threadInfo.is_book_chapter.intValue();
                this.eEe.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.eEl = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.eEm = threadInfo.last_read_pid.longValue();
                this.eEn = threadInfo.cheak_repeat.intValue() == 1;
                this.eEq = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.eEx.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.ezX = sparseArray2;
                }
                this.eEw = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.eEz = new an();
                    this.eEz.a(threadInfo.link_info);
                }
                this.eEA = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.eEB = new f();
                    this.eEB.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.eEC = new MediaData();
                    this.eEC.parserProtobuf(threadInfo.pic_info);
                }
                this.eEg = threadInfo.is_called.intValue();
                this.eED = threadInfo.middle_page_num.intValue();
                this.eEE = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.eEG = threadInfo.star_rank_icon.icon_pic_url;
                    this.eEH = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.eEF = new OriginalThreadInfo();
                    this.eEF.a(threadInfo.origin_thread_info);
                } else {
                    this.eEF = null;
                    this.isShareThread = false;
                }
                this.eEI = threadInfo.is_topic.intValue();
                this.eEK = threadInfo.topic_user_name;
                this.eEL = threadInfo.topic_h5_url;
                this.eEJ = threadInfo.topic_module;
                this.eEN = threadInfo.presentation_style;
                this.eEQ = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.eES = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eCR = new bt();
                    this.eCR.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.eEU = threadInfo.swan_info;
                }
                this.eFb = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.eFc = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.eFn = threadInfo.article_cover;
                this.eFo = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eFp = threadInfo.is_s_card.intValue() == 1;
                this.eFq = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.eFr = threadInfo.wonderful_post_info;
                bmb();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.eFs = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.eFv) {
                            this.eFv = true;
                        }
                        this.eFt.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.eFu.add(pbGoodsData);
                    }
                    if (this.eFu.size() > 0 && !this.eFv) {
                        this.eFv = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.eFw = threadInfo.item;
                }
                if (this.eFw != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.eFw);
                }
                this.eFx = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.eFx)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.eFx);
                }
                if (threadInfo.poll_info != null) {
                    if (this.eFy == null) {
                        this.eFy = new PollData();
                    }
                    this.eFy.parserProtobuf(threadInfo.poll_info);
                }
                this.eFz = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.eFA = threadInfo.distance.intValue();
                this.eFB = threadInfo.distance_text;
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
                this.eDy = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eCU = jSONObject.optInt("repost_num", 0);
                this.eCV = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eCW = jSONObject.optLong("last_time_int", 0L);
                this.eCX = jSONObject.optInt("is_top", 0);
                this.eCY = jSONObject.optInt("is_membertop", 0);
                this.eCZ = jSONObject.optInt("is_good", 0);
                this.eDa = jSONObject.optInt("is_livepost", 0);
                this.eDb.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.eDc.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eDd = jSONObject.optInt("has_commented", 0);
                this.eDe = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eDj = jSONObject.optInt("collect_status");
                this.eDk = jSONObject.optString("collect_mark_pid");
                this.eDl = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eDm = jSONObject.optInt("thread_type");
                this.eEy = jSONObject.optLong("share_num");
                this.eDp = jSONObject.optString("first_post_id", "0");
                this.eDA = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eCK = jSONObject.optInt("is_ntitle");
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
                    this.ezX = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.eDT.parserJson(optJSONObject2);
                }
                if ((this.eDc == null || this.eDc.getUserId() == null) && this.userMap != null) {
                    this.eDc = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eDx = new AlaInfoData();
                this.eDx.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eCL = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eDf.add(mediaData);
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
                        this.eDg.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eDD.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eDE = new cj();
                    this.eDE.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eDF = new g();
                    this.eDF.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eDG = new s();
                    this.eDG.parserJson(optJSONObject6);
                }
                this.eDn.setUserMap(this.userMap);
                this.eDn.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eDo.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eDn.setTitle(this.title);
                } else {
                    this.eDn.setTitle(this.eCL);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.eDT.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.eDW.add(cVar);
                    }
                }
                this.eEd = jSONObject.optInt("is_book_chapter", 0);
                this.eEe.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.eEl = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.eEh = jSONObject.optString("recom_extra_img");
                this.eEk = jSONObject.optString("recom_extra_img_night");
                this.eEi = jSONObject.optInt("recom_extra_img_width", 0);
                this.eEj = jSONObject.optInt("recom_extra_img_height", 0);
                this.eEm = jSONObject.optLong("last_read_pid");
                this.eEn = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eDw = new ce();
                    this.eDw.df(optJSONObject8);
                }
                this.eEw = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.eEz = new an();
                    this.eEz.parserJson(optJSONObject9);
                }
                this.eEA = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.eEB = new f();
                    this.eEB.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.eEC = new MediaData();
                    this.eEC.parserJson(optJSONObject11);
                }
                this.eEg = jSONObject.optInt("is_called", 0);
                this.eED = jSONObject.optInt("middle_page_num", 0);
                this.eEE = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eDu = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.eEF = new OriginalThreadInfo();
                        this.eEF.parserJson(optJSONObject13);
                    } else {
                        this.eEF = null;
                    }
                } else {
                    this.eEF = null;
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
                    this.eEU = builder2.build(false);
                }
                this.eFb = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.eFc = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.eFo = jSONObject.optInt("bjh_content_tag");
                this.eFn = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.eFp = jSONObject.optInt("is_s_card", 0) == 1;
                this.eFq = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.eFr = jSONObject.optString("wonderful_post_info");
                bmb();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.eFy == null) {
                        this.eFy = new PollData();
                    }
                    this.eFy.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.eFv) {
                            this.eFv = true;
                        }
                        this.eFt.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.eFu.add(pbGoodsData);
                    }
                    if (this.eFu.size() > 0 && !this.eFv) {
                        this.eFv = true;
                    }
                }
                this.eFz = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.eFA = jSONObject.optInt("distance");
                this.eFB = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bmb() {
        bmc();
        bme();
        bmh();
        bmi();
        bmj();
        bmk();
        bml();
    }

    private void bmc() {
        if (!StringUtils.isNull(this.eDc.getName_show())) {
            this.eEW = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eDc.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void bmd() {
        if (this.eDx != null) {
            if (this.eDx.openRecomDuration == 1 && this.mCreateTime > 0) {
                String dv = com.baidu.tbadk.core.util.au.dv(this.mCreateTime);
                if (!StringUtils.isNull(dv)) {
                    this.eEX = dv;
                }
            }
            if (this.eDx.openRecomFans == 1) {
                int i = 0;
                if (this.eDx != null && this.eDx.user_info != null) {
                    i = this.eDx.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.eEX) && i > 0) {
                    this.eEX += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.au.dy(i);
                } else if (i > 0) {
                    this.eEX = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.au.dy(i);
                }
            }
        }
    }

    private void bme() {
        if (bkm() || (bnw() && getType() != eCp)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String dt = com.baidu.tbadk.core.util.au.dt(j);
                if (com.baidu.tbadk.core.util.au.Bv(dt)) {
                    dt = com.baidu.tbadk.core.util.au.getFormatTimeShort(j);
                }
                this.eEX = dt;
            }
            String str = "";
            if (this.eDc != null && this.eDc.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.eDc.getBaijiahaoInfo().auth_desc)) {
                str = this.eDc.getBaijiahaoInfo().auth_desc;
            }
            if (bnF()) {
                bmf();
            } else if (!this.eFg && this.eDc != null && this.eDc.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eDc.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eEX)) {
                    this.eEX += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eEX = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.eEX) && !TextUtils.isEmpty(str)) {
                this.eEX += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.eEX = str;
            }
        } else if (getType() == eCp || getType() == eCs) {
            bmd();
        } else {
            long blv = blv() * 1000;
            if (blv != 0) {
                String dt2 = com.baidu.tbadk.core.util.au.dt(blv);
                if (com.baidu.tbadk.core.util.au.Bv(dt2)) {
                    dt2 = com.baidu.tbadk.core.util.au.getFormatTimeShort(blv);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bjl()) {
                    dt2 = com.baidu.tbadk.core.util.au.du(blv);
                }
                this.eEX = string + dt2;
            } else {
                long j2 = this.mCreateTime;
                String dt3 = com.baidu.tbadk.core.util.au.dt(j2);
                if (com.baidu.tbadk.core.util.au.Bv(dt3)) {
                    dt3 = com.baidu.tbadk.core.util.au.getFormatTimeShort(j2);
                }
                this.eEX = dt3;
            }
            if (bnF()) {
                bmf();
            } else if (!this.eFg && this.eDc != null && this.eDc.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eDc.getBazhuGradeData().getDesc(), this.eFf ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eEX)) {
                    this.eEX += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.eEX = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.eEX) && !TextUtils.isEmpty(getAddress())) {
                this.eEX += " • " + getAddress();
            }
        }
    }

    private void bmf() {
        if (bnF() && !TextUtils.isEmpty(this.eDc.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.eEX)) {
                this.eEX += "   " + this.eDc.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.eEX = this.eDc.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void bmg() {
        if (!bkm() && !bnw()) {
            long blv = 1000 * blv();
            if (blv != 0) {
                String dt = com.baidu.tbadk.core.util.au.dt(blv);
                if (com.baidu.tbadk.core.util.au.Bv(dt)) {
                    dt = com.baidu.tbadk.core.util.au.getFormatTimeShort(blv);
                }
                this.eEX = dt;
            }
            if (bnF()) {
                bmf();
            } else if (!this.eFg && this.eDc != null && this.eDc.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.au.cutChineseAndEnglishWithSuffix(this.eDc.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.eEX)) {
                    this.eEX += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.eEX = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.eEX) && !TextUtils.isEmpty(getAddress())) {
                this.eEX += " • " + getAddress();
            }
        }
    }

    private void bmh() {
        if (blW() == null || blW().share_info == null || blW().share_info.share_user_count <= 0 || !bmY() || (this.eED > 0 && this.eEE == 0)) {
            this.eEY = null;
            return;
        }
        int i = blW().share_info.share_user_count;
        if (i == 1) {
            this.eEY = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.eEY = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.au.numberUniform(i)});
        }
    }

    private void bmi() {
        this.eCQ = bmB();
        com.baidu.tieba.card.n.a(this, this.eCQ, true);
    }

    private void bmj() {
        this.eAh = bmz();
    }

    private void bmk() {
        this.eEZ = com.baidu.tbadk.core.util.au.getFormatTimeShort(blv() * 1000);
    }

    private void bml() {
        this.eFa = com.baidu.tbadk.core.util.au.getFormatTimeShort(blv());
    }

    public SpannableStringBuilder bmm() {
        return this.eCP;
    }

    public boolean isTop() {
        return blx() != 0;
    }

    public int bmn() {
        if (this.eDT != null) {
            long bkU = this.eDT.bkU();
            long bkV = this.eDT.bkV();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bkU) {
                return 1;
            }
            if (currentTimeMillis > bkV) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int bmo() {
        if (bmq() && this.eDD.size() >= 1) {
            b bVar = this.eDD.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bjp = bVar.bjp();
            int bjq = bVar.bjq();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bjp) {
                return 4;
            }
            return currentTimeMillis > bjq ? 2 : 1;
        }
        return -1;
    }

    public int bmp() {
        if (!bmq() || this.eDD.size() < 1 || this.eDD.get(0) == null) {
            return -1;
        }
        return this.eDD.get(0).bjo();
    }

    public boolean bmq() {
        return this.eDr == 1;
    }

    public String getActUrl() {
        return (!bmq() || this.eDD.size() < 1 || this.eDD.get(0) == null) ? "" : this.eDD.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Az(String str) {
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

    public SmartApp bmr() {
        return this.eEU;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && bmt()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (blx() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (blx() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (blz() == 1 || this.eDb.bnT() != 0) {
                if (bli() != null && getThreadType() == 41) {
                    if (bmn() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bmM()) {
                Integer num = eDI.get(Integer.valueOf(bmn()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bly() == 1 && !isTop() && eCo != getType() && eCx != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eDo != null && this.eDo.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (blH() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eDH.get(new Point(bmp(), bmo()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (blN() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (blO() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Az(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eCJ));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder bmw = bmw();
        if (bmw != null) {
            spannableStringBuilder.append((CharSequence) bmw);
        }
        this.eCP = spannableStringBuilder;
    }

    public boolean bms() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (blC() != null) {
            if (blC().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (blC().getGender() == 2) {
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

    private boolean bmt() {
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
        SpannableStringBuilder bmw = bmw();
        if (z) {
            spannableStringBuilder = a(bmw.toString(), bmw, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(bmw);
        }
        this.eCP = spannableStringBuilder;
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
            if (this.eCK == 1) {
                this.eCP = a3;
                return a3;
            }
        } else if (this.eCK == 1) {
            this.eCP = new SpannableStringBuilder();
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

    public void dE(String str, String str2) {
        this.mUrl = str;
        this.eDY = str2;
    }

    public String bmu() {
        return this.mUrl;
    }

    public String bmv() {
        return this.eDY;
    }

    public SpannableStringBuilder bmw() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eCM, this.title);
    }

    public SpannableStringBuilder bmx() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eCN, this.eCL);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bmy() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.eFp) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bmz() {
        SpannableStringBuilder bmx = bmx();
        com.baidu.tieba.card.n.a(this, bmx, false);
        return new SpannableString(bmx);
    }

    public SpannableString bmA() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eCO)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eCO, this.eCL));
    }

    public String getAbstract() {
        return this.eCL;
    }

    public void AA(String str) {
        this.eCL = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder bmw;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eCK == 1) {
            bmw = bmx();
            spannableStringBuilder = bmw.toString();
        } else {
            bmw = bmw();
            spannableStringBuilder = bmw.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, bmw, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(bmw);
        }
        this.eCP = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bmx;
        if (!StringUtils.isNull(this.title) && this.eCK != 1) {
            bmx = bmw();
        } else {
            bmx = bmx();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bmx);
        this.eCP = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bmB() {
        if (StringUtils.isNull(this.title) || this.eCK == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bmw());
        this.eCP = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bkh() {
        if (this.eCM != null && this.eCM.size() > 0) {
            int size = this.eCM.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eCM.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bki() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.DQ(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bmC() {
        y(false, false);
    }

    public void bmD() {
        y(false, true);
    }

    public AnchorInfoData bmE() {
        return this.eDo;
    }

    public boolean bmF() {
        return this.threadType == 36;
    }

    public boolean bki() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bmG() {
        return this.threadType == 11 || this.eDl == 1;
    }

    public boolean bmH() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> blL = blL();
        if (blL == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= blL.size() || i2 >= 3) {
                break;
            }
            if (blL.get(i2) != null && blL.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(blL.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = blL.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = blL.get(i2).getPicUrl();
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
        if (this.eDu != null && !StringUtils.isNull(this.eDu.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eDu.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.eDc != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.eDc.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bmI() {
        String userId;
        return this.eDc == null || (userId = this.eDc.getUserId()) == null || userId.equals("0");
    }

    public boolean bmJ() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bnt()) {
            if (blU() != null) {
                return eCo;
            }
            return eBR;
        }
        int blx = blx();
        if (this.eEI == 1) {
            if (this.eEJ != null) {
                return eCf;
            }
            return this.eEM != null ? eCz : eCy;
        } else if (this.eDx != null && this.threadType == 60) {
            return eCr;
        } else {
            if (this.eDx != null && this.threadType == 49) {
                return eCp;
            }
            if (this.eDx != null && this.threadType == 67) {
                return eCs;
            }
            if (this.threadType == 51) {
                return eCq;
            }
            if (this.threadType == 63) {
                return eCA;
            }
            if (this.threadType == 64) {
                return eCB;
            }
            if (blx == 2 || blx == 1) {
                return eBQ;
            }
            if (this.eDu != null && bmR() && !bmJ()) {
                return eCG;
            }
            if (this.eDu != null && !bmJ()) {
                if (blF()) {
                    return eCx;
                }
                return eCo;
            } else if (this.isShareThread && this.eEF != null) {
                if (this.eEF.eAi) {
                    if (this.eEF.videoInfo != null) {
                        return eCw;
                    }
                    if (this.eEF.bkk()) {
                        return eCv;
                    }
                    return eCu;
                }
                return eCt;
            } else if (bkk()) {
                return eCg;
            } else {
                if (bmL()) {
                    return eCD.get() ? eDS : eBR;
                } else if (bmq() && bmp() == 1) {
                    return eCD.get() ? eEa : eBR;
                } else if (isLinkThread()) {
                    return eCm;
                } else {
                    if (blF()) {
                        return eCn;
                    }
                    if (this.eBx) {
                        return eBX;
                    }
                    if (this.eBy) {
                        return eBY;
                    }
                    if (this.eBz) {
                        return eBZ;
                    }
                    if (this.eBA) {
                        return eCa;
                    }
                    if (this.eBB) {
                        return eCb;
                    }
                    if (this.eBD) {
                        return eCd;
                    }
                    if (this.eBE) {
                        return eCe;
                    }
                    if (this.eBC) {
                        return eCc;
                    }
                    if (this.eDB) {
                        int bmK = bmK();
                        if (bmK == 1) {
                            return eBT;
                        }
                        if (bmK == 2) {
                            return eBU;
                        }
                        if (bmK > 2) {
                            return eBV;
                        }
                        return eBR;
                    }
                    return eBR;
                }
            }
        }
    }

    public int bmK() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.biL().isShowImages() || com.baidu.tbadk.core.util.y.getCount(blL()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < blL().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(blL(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bmL() {
        return bli() != null && getThreadType() == 41 && blz() == 1 && bmn() == 2;
    }

    public void F(ArrayList<t> arrayList) {
        if (this.eCK == 1) {
            this.eyu = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.eyu = 0;
        } else {
            this.eyu = 0;
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null && next.bjE() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bjE().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.eyu = next.bjF();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bmM() {
        return this.threadType == 41;
    }

    public boolean bmN() {
        return this.eEb;
    }

    public void iO(boolean z) {
        this.eEb = z;
    }

    public String bmO() {
        return this.eEc;
    }

    public s bmP() {
        return this.eDG;
    }

    public void bmQ() {
        if (this.eDz == 0) {
            this.eDz = 1;
        }
    }

    public void iP(boolean z) {
        this.eEo = z;
    }

    public boolean bmR() {
        return this.eEo;
    }

    public void ol(int i) {
        this.eEp = i + 1;
    }

    public int bmS() {
        return this.eEp;
    }

    public boolean bmT() {
        return this.eFe;
    }

    public void iQ(boolean z) {
        this.eFe = z;
    }

    public ce bmU() {
        return this.eDw;
    }

    public boolean bmV() {
        return getThreadType() == 49;
    }

    public boolean bmW() {
        return getThreadType() == 40;
    }

    public boolean bmX() {
        return getThreadType() == 50;
    }

    public boolean bmY() {
        return getThreadType() == 60;
    }

    public int bmZ() {
        return this.eEv;
    }

    public void setSmartFrsPosition(int i) {
        this.eEv = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bna() {
        return this.mRecomSource;
    }

    public boolean bnb() {
        return this.eEw;
    }

    public long bnc() {
        return this.agreeData.agreeNum;
    }

    public long bnd() {
        return this.agreeData.disAgreeNum;
    }

    public int bne() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bnf() {
        return this.agreeData.agreeType;
    }

    public void om(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void on(int i) {
        this.agreeData.agreeNum = i;
    }

    public void di(long j) {
        this.agreeData.agreeNum = j;
    }

    public void dj(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void oo(int i) {
        this.agreeData.agreeType = i;
    }

    public long bng() {
        return this.eEy;
    }

    public void dk(long j) {
        this.eEy = j;
    }

    public PostData bnh() {
        return this.eEx;
    }

    public an bni() {
        return this.eEz;
    }

    private ArrayList<n.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean blD = blD();
        if (z2) {
            if (z) {
                if (blD && !bki()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if (blz() == 1 || getThreadType() == 33 || (blB() != null && blB().bnT() != 0)) {
                    if (bli() != null && bmM()) {
                        if (bmn() == 2) {
                            arrayList.add(new n.a(R.string.interview_live));
                        }
                    } else if (!blD) {
                        arrayList.add(new n.a(R.string.photo_live_tips));
                    }
                }
                if (bmM()) {
                    arrayList.add(eEs.get(bmn()));
                }
                if (bmq()) {
                    Integer num = eEr.get(new Point(bmp(), bmo()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (blN() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (blD && blx() != 1 && !bki()) {
                    arrayList.add(new n.a(R.string.god_title));
                }
                if ((blz() == 1 || getThreadType() == 33) && !bmM() && !blD) {
                    arrayList.add(new n.a(R.string.photo_live_tips));
                }
                if (bly() == 1) {
                    arrayList.add(new n.a(R.string.good));
                }
                if (blx() == 1) {
                    arrayList.add(new n.a(R.string.top));
                }
                if (bmM() && bli() != null && bmn() == 2) {
                    arrayList.add(new n.a(R.string.interview_live));
                }
                if (bmq()) {
                    Integer num2 = eEr.get(new Point(bmp(), bmo()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(R.string.card_promotion_text));
                    }
                }
                if (this.eEd == 1) {
                    arrayList.add(new n.a(R.string.card_tbread_text));
                }
                if (blO() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (blN() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.CAM_X0308, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && bmV()) {
                    arrayList.add(new n.a(R.string.ala_live));
                }
                if (z3 && bmX()) {
                    arrayList.add(new n.a(R.string.live_record));
                } else if (bmW()) {
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
        this.eDf = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eDg = arrayList;
    }

    public String bnj() {
        return this.eEK;
    }

    public void AB(String str) {
        this.eEK = str;
    }

    public void bnk() {
        this.eEI = 1;
    }

    public boolean bnl() {
        return this.eEI == 1;
    }

    public String bnm() {
        return this.eCS;
    }

    public void AC(String str) {
        this.eCS = str;
    }

    public String bnn() {
        return this.eCT;
    }

    public void AD(String str) {
        this.eCT = str;
    }

    public String bno() {
        return this.eEL;
    }

    public void AE(String str) {
        this.eEL = str;
    }

    public boolean bnp() {
        return this.eEO;
    }

    public void iR(boolean z) {
        this.eEO = z;
    }

    public boolean bnq() {
        return this.eEP;
    }

    public void iS(boolean z) {
        this.eEP = z;
    }

    public void b(VideoInfo videoInfo) {
        this.eEM = videoInfo;
    }

    public boolean bnr() {
        return this.eEQ != null;
    }

    public bt bns() {
        return this.eCR;
    }

    public boolean bnt() {
        return this.eET;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eDu != null) {
            return this.eDu.video_url;
        }
        return null;
    }

    public boolean bnu() {
        return this.eEV;
    }

    public void iT(boolean z) {
        this.eEV = z;
    }

    public AgreeData bnv() {
        return this.agreeData;
    }

    public boolean bnw() {
        return this.eFh;
    }

    public void iU(boolean z) {
        this.eFh = z;
    }

    @Override // com.baidu.tbadk.core.data.a
    public boolean bjk() {
        return this.eFf;
    }

    public void iV(boolean z) {
        this.eFf = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bnx() {
        return this.eEJ;
    }

    public String getShareImageUrl() {
        return this.eFb;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> blL = blL();
        if (com.baidu.tbadk.core.k.biL().isShowImages() && com.baidu.tbadk.core.util.y.getCount(blL) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < blL.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(blL, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(blL, 0);
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

    public boolean bny() {
        return bnz() || bnA();
    }

    public boolean bkk() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bkl() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bnz() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bnA() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bkm() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bkm();
    }

    public void op(int i) {
        this.isBjh = i;
    }

    public int bnB() {
        return this.eFo;
    }

    public String bnC() {
        return this.eFn;
    }

    public void AF(String str) {
        this.eFn = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bnD() {
        if (blE()) {
            return 4;
        }
        if (bmV() || bmX()) {
            return 3;
        }
        if (bkk()) {
            return 5;
        }
        if (bkl()) {
            return 6;
        }
        if (bnz()) {
            return 7;
        }
        if (bnA()) {
            return 8;
        }
        if (this.isShareThread && this.eEF != null) {
            return 9;
        }
        if (bmW()) {
            return 2;
        }
        return 1;
    }

    public int bnE() {
        if (bnA() || bnz()) {
            return 2;
        }
        if (bkk() || bkl()) {
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

    public boolean bnF() {
        return this.eDc != null && this.eDc.isNewGod();
    }

    public boolean bnG() {
        return (blC() == null || blC().getAlaUserData() == null || blC().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bnH() {
        return this.eFw;
    }

    public List<HeadItem> bnI() {
        return this.eFx;
    }

    public void a(Item item) {
        this.eFw = item;
    }

    public void bo(List<HeadItem> list) {
        this.eFx = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bnJ() {
        return this.eFy;
    }

    public void b(PollData pollData) {
        this.eFy = pollData;
    }

    public List<PbLinkData> bnK() {
        return this.eFt;
    }

    public void bp(List<PbLinkData> list) {
        this.eFt = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.eFt)) {
            for (PbLinkData pbLinkData : this.eFt) {
                if (pbLinkData.urlType == 2 && !this.eFv) {
                    this.eFv = true;
                }
            }
        }
    }

    public List<PbGoodsData> bnL() {
        return this.eFu;
    }

    public void bq(List<PbGoodsData> list) {
        this.eFu = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.eFv) {
            this.eFv = true;
        }
    }

    public boolean bnM() {
        return this.eFv;
    }
}

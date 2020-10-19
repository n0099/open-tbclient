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
    private String blg;
    public String buttonText;
    public int ens;
    private SpannableString enz;
    private int eqA;
    private int eqD;
    public int eqE;
    private String eqH;
    private String eqI;
    private int eqK;
    private VideoInfo eqM;
    private VideoDesc eqN;
    private cd eqO;
    private AlaInfoData eqP;
    private long eqQ;
    private r eqY;
    private int eqc;
    private SpannableStringBuilder eqh;
    private SpannableStringBuilder eqi;
    private bs eqj;
    private String eqk;
    private String eql;
    public int eqz;
    public String erA;
    public int erB;
    public int erC;
    public String erD;
    public String erE;
    public long erF;
    private List<ReportInfo> erJ;
    private boolean erP;
    private long erR;
    private am erS;
    public e erU;
    private MediaData erV;
    public int erW;
    public OriginalThreadInfo erY;
    private LiveCoverStatus ere;
    private long erf;
    public TwZhiBoUser erm;
    public List<TwAnchorProfitItem> ern;
    private SkinInfo ers;
    private boolean eru;
    private String erv;
    private boolean ery;
    public boolean esA;
    public boolean esB;
    public boolean esC;
    public boolean esD;
    public boolean esE;
    public String esF;
    private String esG;
    private int esH;
    public String esJ;
    private String esK;
    private ThreadInfo esL;
    private boolean esO;
    private Item esP;
    private List<HeadItem> esQ;
    PollData esR;
    public int esT;
    public String esU;
    public String esV;
    public String esW;
    private TopicModule esc;
    private String esd;
    private String ese;
    private VideoInfo esf;
    private String esg;
    private boolean esi;
    public OriginalForumInfo esj;
    public boolean esk;
    private String esl;
    private boolean esm;
    private SmartApp esn;
    private String esp;
    private String esq;
    private String esr;
    private String ess;
    private String est;
    public String esu;
    private boolean esx;
    private boolean esy;
    public boolean esz;
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
    public static final BdUniqueId epk = BdUniqueId.gen();
    public static final BdUniqueId epl = BdUniqueId.gen();
    public static final BdUniqueId epm = BdUniqueId.gen();
    public static final BdUniqueId epn = BdUniqueId.gen();
    public static final BdUniqueId epo = BdUniqueId.gen();
    public static final BdUniqueId epp = BdUniqueId.gen();
    public static final BdUniqueId epq = BdUniqueId.gen();
    public static final BdUniqueId epr = BdUniqueId.gen();
    public static final BdUniqueId eps = BdUniqueId.gen();
    public static final BdUniqueId ept = BdUniqueId.gen();
    public static final BdUniqueId epu = BdUniqueId.gen();
    public static final BdUniqueId epv = BdUniqueId.gen();
    public static final BdUniqueId epw = BdUniqueId.gen();
    public static final BdUniqueId epx = BdUniqueId.gen();
    public static final BdUniqueId epy = BdUniqueId.gen();
    public static final BdUniqueId epz = BdUniqueId.gen();
    public static final BdUniqueId epA = BdUniqueId.gen();
    public static final BdUniqueId epB = BdUniqueId.gen();
    public static final BdUniqueId epC = BdUniqueId.gen();
    public static final BdUniqueId epD = BdUniqueId.gen();
    public static final BdUniqueId epE = BdUniqueId.gen();
    public static final BdUniqueId epF = BdUniqueId.gen();
    public static final BdUniqueId epG = BdUniqueId.gen();
    public static final BdUniqueId epH = BdUniqueId.gen();
    public static final BdUniqueId epI = BdUniqueId.gen();
    public static final BdUniqueId epJ = BdUniqueId.gen();
    public static final BdUniqueId epK = BdUniqueId.gen();
    public static final BdUniqueId epL = BdUniqueId.gen();
    public static final BdUniqueId epM = BdUniqueId.gen();
    public static final BdUniqueId epN = BdUniqueId.gen();
    public static final BdUniqueId epO = BdUniqueId.gen();
    public static final BdUniqueId epP = BdUniqueId.gen();
    public static final BdUniqueId epQ = BdUniqueId.gen();
    public static final BdUniqueId epR = BdUniqueId.gen();
    public static final BdUniqueId epS = BdUniqueId.gen();
    public static final BdUniqueId epT = BdUniqueId.gen();
    public static final BdUniqueId epU = BdUniqueId.gen();
    public static AtomicBoolean epV = new AtomicBoolean(false);
    public static AtomicBoolean epW = new AtomicBoolean(false);
    public static AtomicBoolean epX = new AtomicBoolean(false);
    public static final BdUniqueId epY = BdUniqueId.gen();
    private static HashMap<Point, Integer> eqZ = new HashMap<>();
    private static HashMap<Integer, Integer> era = new HashMap<>();
    public static final BdUniqueId erk = BdUniqueId.gen();
    public static final BdUniqueId ert = BdUniqueId.gen();
    private static HashMap<Point, Integer> erK = new HashMap<>();
    private static SparseArray<m.a> erL = new SparseArray<>(3);
    public boolean eoR = false;
    public boolean eoS = false;
    public boolean eoT = false;
    public boolean eoU = false;
    public boolean eoV = false;
    public boolean eoW = false;
    public boolean eoX = false;
    public boolean eoY = false;
    private int epZ = 0;
    private String eqa = "1";
    public int eqb = 1;
    private String eqC = null;
    private int elK = 0;
    public int eqR = 0;
    private String eqS = "";
    public boolean eqT = false;
    private String erb = "";
    public boolean erG = true;
    public boolean erM = false;
    public boolean erN = false;
    private int erO = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public SparseArray<String> eno = null;
    public boolean erT = false;
    private int esb = 0;
    private boolean esh = false;
    private boolean eso = false;
    public boolean esv = false;
    public boolean esw = false;
    public boolean forbidComment = false;
    public boolean esI = false;
    public boolean esX = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int eqm = 0;
    private int eqn = 0;
    private String last_time = null;
    private long eqo = 0;
    private int eqp = 0;
    private int eqq = 0;
    private int eqr = 0;
    private int eqs = 0;
    private ca eqt = new ca();
    private MetaData equ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> eqx = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> eqy = new ArrayList<>();
    private int eqv = 0;
    private int eqw = 0;
    private String ad_url = null;
    private String eqd = null;
    private String from = null;
    private int eqB = 0;
    private PraiseData eqF = new PraiseData();
    private AnchorInfoData eqG = new AnchorInfoData();
    private long time = 0;
    private int eqJ = 0;
    private ArrayList<a> eqV = new ArrayList<>();
    private ci eqW = null;
    private f eqX = null;
    private int erc = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> eqL = new ArrayList<>();
    private boolean isHeadLive = false;
    private String erd = null;
    private int eqU = 0;
    private boolean erg = false;
    private boolean erh = false;
    private int eri = 0;
    private boolean erj = false;
    private int anchorLevel = 0;
    public int erw = 0;
    public o erx = new o();
    private List<PbContent> eqg = new ArrayList();
    private List<PbContent> eqe = new ArrayList();
    private List<PbContent> eqf = new ArrayList();
    private String category_name = null;
    private bu erl = new bu();
    private ArrayList<com.baidu.tbadk.data.c> ero = new ArrayList<>();
    private PushStatusData erp = new PushStatusData();
    public boolean erH = false;
    public int erI = -1;
    private PostData erQ = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int erz = 0;
    public int erX = 0;
    private String tieba_game_information_source = "";
    public String esa = "";
    public String erZ = "";
    public String mUrl = "";
    public String erq = "";
    private List<PbLinkData> esM = new ArrayList();
    private List<PbGoodsData> esN = new ArrayList();
    public int esS = -1;

    static {
        eqZ.put(new Point(1, 1), Integer.valueOf(R.drawable.label_frs_lottery_ing));
        eqZ.put(new Point(1, 2), Integer.valueOf(R.drawable.label_frs_lottery_over));
        eqZ.put(new Point(1, 3), Integer.valueOf(R.drawable.label_frs_lottery_off));
        eqZ.put(new Point(1, 4), Integer.valueOf(R.drawable.label_frs_lottery_d));
        eqZ.put(new Point(2, 1), Integer.valueOf(R.drawable.label_frs_activity_shaiing));
        eqZ.put(new Point(2, 2), Integer.valueOf(R.drawable.label_frs_activity_shai_over));
        eqZ.put(new Point(2, 3), Integer.valueOf(R.drawable.label_frs_activity_shai_off));
        eqZ.put(new Point(2, 4), Integer.valueOf(R.drawable.label_frs_activity_shai_d));
        erK.put(new Point(1, 1), Integer.valueOf(R.string.lottery_status_ing));
        erK.put(new Point(1, 2), Integer.valueOf(R.string.lottery_status_over));
        erK.put(new Point(1, 3), Integer.valueOf(R.string.lottery_status_off));
        erK.put(new Point(1, 4), Integer.valueOf(R.string.lottery_status_not_start));
        erK.put(new Point(2, 1), Integer.valueOf(R.string.share_picture_status_ing));
        erK.put(new Point(2, 2), Integer.valueOf(R.string.share_picture_status_over));
        erK.put(new Point(2, 3), Integer.valueOf(R.string.share_picture_status_off));
        erK.put(new Point(2, 4), Integer.valueOf(R.string.share_picture_status_not_start));
        era.put(1, Integer.valueOf(R.drawable.label_interview_no));
        era.put(2, Integer.valueOf(R.drawable.label_interview_live));
        era.put(3, Integer.valueOf(R.drawable.label_interview_off));
        erL.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        erL.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        erL.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bw() {
        this.eqA = 0;
        this.eqK = 0;
        this.erf = 0L;
        this.erW = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.erf = 0L;
        this.eqK = 0;
        this.eqA = 0;
        this.erW = 0;
    }

    public String bhE() {
        return this.esp;
    }

    public String bhF() {
        return this.esq;
    }

    public void As(String str) {
        this.esq = str;
    }

    public String bhG() {
        return this.esr;
    }

    public SpannableStringBuilder bhH() {
        return this.eqi;
    }

    public SpannableString bhI() {
        return this.enz;
    }

    public void a(SpannableString spannableString) {
        if (bih() != null && !bfR() && !bfQ()) {
            if (this.eqi != null) {
                this.eqi.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.enz);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.enz = new SpannableString(spannableStringBuilder);
        }
    }

    public void bhJ() {
        if (com.baidu.tbadk.core.util.y.getCount(this.esQ) > 0) {
            if (this.eqi != null) {
                this.eqi.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bp(this.esQ));
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.enz);
            spannableStringBuilder.insert(0, (CharSequence) com.baidu.tbadk.widget.richText.e.bp(this.esQ));
            this.enz = new SpannableString(spannableStringBuilder);
        }
    }

    public String bhK() {
        return this.ess;
    }

    public String bhL() {
        return this.est;
    }

    public boolean bhM() {
        return this.eqA == 1;
    }

    public bu bhN() {
        return this.erl;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void nL(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.eqK;
    }

    public void nM(int i) {
        this.eri = i;
    }

    public int bhO() {
        return this.eri;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo bhP() {
        return this.esf;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void cI(long j) {
        this.mCreateTime = j;
    }

    public long bhQ() {
        return this.eqQ;
    }

    public String bhR() {
        return this.eqH;
    }

    public PraiseData bhS() {
        return this.eqF;
    }

    public void a(PraiseData praiseData) {
        this.eqF = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String bhT() {
        return this.blg;
    }

    public void At(String str) {
        this.blg = str;
    }

    public String bhU() {
        return this.eqa;
    }

    public void Au(String str) {
        this.eqa = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void nN(int i) {
        this.epZ = i;
    }

    public int bhV() {
        return this.epZ;
    }

    public String bhW() {
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

    public List<PbContent> bhX() {
        return this.eqg;
    }

    public void aU(List<PbContent> list) {
        this.eqg = list;
    }

    public void aV(List<PbContent> list) {
        this.eqe = list;
    }

    public void aW(List<PbContent> list) {
        this.eqf = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void nO(int i) {
        this.reply_num = i;
    }

    public int bhY() {
        return this.reply_num;
    }

    public int bhZ() {
        return this.eqn;
    }

    public void nP(int i) {
        this.eqn = i;
    }

    public long bia() {
        return this.eqo;
    }

    public void cJ(long j) {
        this.eqo = j;
    }

    public int bib() {
        return this.eqq;
    }

    public int bic() {
        return this.eqp;
    }

    public void nQ(int i) {
        this.eqp = i;
    }

    public int bid() {
        return this.eqr;
    }

    public void nR(int i) {
        this.eqr = i;
    }

    public int bie() {
        return this.eqs;
    }

    public List<PbContent> bif() {
        return this.eqe;
    }

    public ca big() {
        return this.eqt;
    }

    public MetaData bih() {
        return this.equ;
    }

    public boolean bii() {
        return this.is_god != 0;
    }

    public boolean bij() {
        return this.is_god == 1;
    }

    public boolean bik() {
        return (this.equ == null || this.equ.getGodUserData() == null || this.equ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public void a(MetaData metaData) {
        this.equ = metaData;
    }

    public String bil() {
        return this.forum_name;
    }

    public void Av(String str) {
        this.forum_name = str;
    }

    public int bim() {
        return this.eqw;
    }

    public String bin() {
        return this.ad_url;
    }

    public int bio() {
        return this.eqB;
    }

    public void nS(int i) {
        this.eqB = i;
    }

    public String bip() {
        return this.eqC;
    }

    public void Aw(String str) {
        this.eqC = str;
    }

    public ArrayList<MediaData> biq() {
        return this.eqx;
    }

    public ArrayList<a> bir() {
        return this.eqV;
    }

    public void E(ArrayList<a> arrayList) {
        this.eqV = arrayList;
    }

    public ci bis() {
        return this.eqW;
    }

    public f bit() {
        return this.eqX;
    }

    public ArrayList<VoiceData.VoiceModel> biu() {
        return this.eqy;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int biv() {
        return this.eqc;
    }

    public void nT(int i) {
        this.eqc = i;
    }

    public String biw() {
        return this.latitude;
    }

    public String bix() {
        return this.eqI;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String biy() {
        return this.eqS;
    }

    public VideoInfo biz() {
        return this.eqM;
    }

    public void a(VideoInfo videoInfo) {
        this.eqM = videoInfo;
    }

    public VideoDesc biA() {
        return this.eqN;
    }

    public void a(AlaInfoData alaInfoData) {
        this.eqP = alaInfoData;
    }

    public AlaInfoData biB() {
        return this.eqP;
    }

    public PushStatusData biC() {
        return this.erp;
    }

    public SkinInfo biD() {
        return this.ers;
    }

    public long biE() {
        return this.erF;
    }

    public boolean biF() {
        return this.erG;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bfH() {
        return this.erE;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bfG().getTid());
        arVar.setFid(bfG().getFid());
        arVar.setNid(bfG().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.eno = this.eno;
        arVar.abTag = this.mRecomAbTag;
        arVar.weight = this.mRecomWeight;
        arVar.extra = this.mRecomExtra;
        arVar.source = this.mRecomSource;
        arVar.ens = this.ens;
        arVar.cardType = bkg();
        return arVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.eqI = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.eqA = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.eqQ = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.eqm = threadInfo.repost_num.intValue();
                this.eqn = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.eqo = threadInfo.last_time_int.intValue();
                this.eqp = threadInfo.is_top.intValue();
                this.eqq = threadInfo.is_membertop.intValue();
                this.eqr = threadInfo.is_good.intValue();
                this.eqs = threadInfo.is_livepost.intValue();
                this.eqt.a(threadInfo.topic);
                this.equ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.eqv = threadInfo.has_commented.intValue();
                this.eqw = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.eqM = threadInfo.video_info;
                this.eqN = threadInfo.video_segment;
                this.eqP = new AlaInfoData();
                this.eqP.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.eqB = threadInfo.collect_status.intValue();
                this.eqC = threadInfo.collect_mark_pid;
                this.eqD = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.eqE = threadInfo.thread_type.intValue();
                this.eqH = threadInfo.first_post_id + "";
                this.eqS = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.eqc = threadInfo.is_ntitle.intValue();
                this.eqJ = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.erR = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.eqK = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ery = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.eqe = threadInfo.rich_title;
                this.eqg = threadInfo.first_post_content;
                this.eqf = threadInfo.rich_abstract;
                this.eqz = threadInfo.is_godthread_recommend.intValue();
                if ((this.equ == null || this.equ.getUserId() == null || this.equ.getUserId().equals("0") || this.esX) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.equ = metaData;
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
                this.eqd = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.eqx.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.eqM = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.eqO = new cd();
                    this.eqO.a(threadInfo.video_channel_info);
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
                        this.eqy.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.eqV.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.eqW = new ci();
                    this.eqW.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.eqX = new f();
                    this.eqX.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.eqY = new r();
                    this.eqY.a(threadInfo.cartoon_info);
                }
                this.eqF.setUserMap(this.userMap);
                this.eqF.parserProtobuf(threadInfo.zan);
                this.eqG.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eqF.setTitle(this.title);
                } else {
                    this.eqF.setTitle(this.eqd);
                }
                this.erb = threadInfo.livecover_src;
                this.erc = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.eqU = threadInfo.post_num.intValue();
                this.erf = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.qz(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.CA(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.eqL.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.erd = noticeInfo.notice;
                    }
                    this.eri = zhiBoInfoTW.copythread_remind.intValue();
                    this.erg = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.erh = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.erb)) {
                        this.erb = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.erm = zhiBoInfoTW.user.tw_anchor_info;
                        this.ern = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ere = threadInfo.twzhibo_info.livecover_status;
                    this.erf = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.erj = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.erl.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.ero.add(cVar2);
                    }
                }
                this.erp.parserProtobuf(threadInfo.push_status);
                this.erv = threadInfo.lego_card;
                this.ers = threadInfo.skin_info;
                this.erw = threadInfo.is_book_chapter.intValue();
                this.erx.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.erE = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.erF = threadInfo.last_read_pid.longValue();
                this.erG = threadInfo.cheak_repeat.intValue() == 1;
                this.erJ = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.erQ.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                    this.eno = sparseArray2;
                }
                this.erP = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.erS = new am();
                    this.erS.a(threadInfo.link_info);
                }
                this.erT = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.erU = new e();
                    this.erU.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.erV = new MediaData();
                    this.erV.parserProtobuf(threadInfo.pic_info);
                }
                this.erz = threadInfo.is_called.intValue();
                this.erW = threadInfo.middle_page_num.intValue();
                this.erX = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.erZ = threadInfo.star_rank_icon.icon_pic_url;
                    this.esa = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.erY = new OriginalThreadInfo();
                    this.erY.a(threadInfo.origin_thread_info);
                } else {
                    this.erY = null;
                    this.isShareThread = false;
                }
                this.esb = threadInfo.is_topic.intValue();
                this.esd = threadInfo.topic_user_name;
                this.ese = threadInfo.topic_h5_url;
                this.esc = threadInfo.topic_module;
                this.esg = threadInfo.presentation_style;
                this.esj = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.esl = threadInfo.daily_paper_time;
                if (threadInfo.forum_info != null) {
                    this.eqj = new bs();
                    this.eqj.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.esn = threadInfo.swan_info;
                }
                this.esu = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.esv = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.esG = threadInfo.article_cover;
                this.esH = threadInfo.bjh_content_tag.intValue();
                this.isBjh = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.esI = threadInfo.is_s_card.intValue() == 1;
                this.esJ = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.esK = threadInfo.wonderful_post_info;
                biG();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.esL = threadInfo;
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_link_info)) {
                    for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseProto(pbLinkInfo);
                        if (pbLinkData.urlType == 2 && !this.esO) {
                            this.esO = true;
                        }
                        this.esM.add(pbLinkData);
                    }
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(threadInfo.pb_goods_info)) {
                    for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseProto(pbGoodsInfo);
                        this.esN.add(pbGoodsData);
                    }
                    if (this.esN.size() > 0 && !this.esO) {
                        this.esO = true;
                    }
                }
                if (threadInfo.item != null && threadInfo.item.item_id.longValue() != 0) {
                    this.esP = threadInfo.item;
                }
                if (this.esP != null) {
                    this.itemData = new ItemData();
                    this.itemData.parseProto(this.esP);
                }
                this.esQ = threadInfo.item_star;
                if (!com.baidu.tbadk.core.util.y.isEmpty(this.esQ)) {
                    this.itemStarData = new ItemStarData();
                    this.itemStarData.parseProto(this.esQ);
                }
                if (threadInfo.poll_info != null) {
                    if (this.esR == null) {
                        this.esR = new PollData();
                    }
                    this.esR.parserProtobuf(threadInfo.poll_info);
                }
                this.esS = threadInfo.hot_num.intValue();
                this.isLocal = threadInfo.is_local.intValue() == 1;
                this.esT = threadInfo.distance.intValue();
                this.esU = threadInfo.distance_text;
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
                this.eqQ = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.eqm = jSONObject.optInt("repost_num", 0);
                this.eqn = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.eqo = jSONObject.optLong("last_time_int", 0L);
                this.eqp = jSONObject.optInt("is_top", 0);
                this.eqq = jSONObject.optInt("is_membertop", 0);
                this.eqr = jSONObject.optInt("is_good", 0);
                this.eqs = jSONObject.optInt("is_livepost", 0);
                this.eqt.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.equ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.eqv = jSONObject.optInt("has_commented", 0);
                this.eqw = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.eqB = jSONObject.optInt("collect_status");
                this.eqC = jSONObject.optString("collect_mark_pid");
                this.eqD = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.eqE = jSONObject.optInt("thread_type");
                this.erR = jSONObject.optLong("share_num");
                this.eqH = jSONObject.optString("first_post_id", "0");
                this.eqS = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.eqc = jSONObject.optInt("is_ntitle");
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
                    this.eno = sparseArray2;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.erl.parserJson(optJSONObject2);
                }
                if ((this.equ == null || this.equ.getUserId() == null) && this.userMap != null) {
                    this.equ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.eqP = new AlaInfoData();
                this.eqP.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.eqd = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray3.getJSONObject(i3));
                        this.eqx.add(mediaData);
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
                        this.eqy.add(voiceModel);
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("act_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.eqV.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.eqW = new ci();
                    this.eqW.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.eqX = new f();
                    this.eqX.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.eqY = new r();
                    this.eqY.parserJson(optJSONObject6);
                }
                this.eqF.setUserMap(this.userMap);
                this.eqF.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.eqG.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.eqF.setTitle(this.title);
                } else {
                    this.eqF.setTitle(this.eqd);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.erl.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray6 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray6 != null) {
                    for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray6.getJSONObject(i6));
                        this.ero.add(cVar);
                    }
                }
                this.erw = jSONObject.optInt("is_book_chapter", 0);
                this.erx.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.erE = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.erA = jSONObject.optString("recom_extra_img");
                this.erD = jSONObject.optString("recom_extra_img_night");
                this.erB = jSONObject.optInt("recom_extra_img_width", 0);
                this.erC = jSONObject.optInt("recom_extra_img_height", 0);
                this.erF = jSONObject.optLong("last_read_pid");
                this.erG = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.eqO = new cd();
                    this.eqO.dc(optJSONObject8);
                }
                this.erP = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.erS = new am();
                    this.erS.parserJson(optJSONObject9);
                }
                this.erT = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.erU = new e();
                    this.erU.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.erV = new MediaData();
                    this.erV.parserJson(optJSONObject11);
                }
                this.erz = jSONObject.optInt("is_called", 0);
                this.erW = jSONObject.optInt("middle_page_num", 0);
                this.erX = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.eqM = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.erY = new OriginalThreadInfo();
                        this.erY.parserJson(optJSONObject13);
                    } else {
                        this.erY = null;
                    }
                } else {
                    this.erY = null;
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
                    this.esn = builder2.build(false);
                }
                this.esu = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.esv = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.isBjh = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.esH = jSONObject.optInt("bjh_content_tag");
                this.esG = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.esI = jSONObject.optInt("is_s_card", 0) == 1;
                this.esJ = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.esK = jSONObject.optString("wonderful_post_info");
                biG();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
                JSONObject optJSONObject16 = jSONObject.optJSONObject("poll_info");
                if (optJSONObject16 != null) {
                    if (this.esR == null) {
                        this.esR = new PollData();
                    }
                    this.esR.parserJson(optJSONObject16);
                }
                JSONArray optJSONArray7 = jSONObject.optJSONArray("pb_link_info");
                if (optJSONArray7 != null) {
                    for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                        PbLinkData pbLinkData = new PbLinkData();
                        pbLinkData.parseJson(optJSONArray7.getJSONObject(i7));
                        if (pbLinkData.urlType == 2 && !this.esO) {
                            this.esO = true;
                        }
                        this.esM.add(pbLinkData);
                    }
                }
                JSONArray optJSONArray8 = jSONObject.optJSONArray("pb_goods_info");
                if (optJSONArray8 != null) {
                    for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                        PbGoodsData pbGoodsData = new PbGoodsData();
                        pbGoodsData.parseJson(optJSONArray8.getJSONObject(i8));
                        this.esN.add(pbGoodsData);
                    }
                    if (this.esN.size() > 0 && !this.esO) {
                        this.esO = true;
                    }
                }
                this.esS = jSONObject.optInt("hot_num", -1);
                this.isLocal = jSONObject.optInt("is_local") == 1;
                this.esT = jSONObject.optInt("distance");
                this.esU = jSONObject.optString("distance_text");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void biG() {
        biH();
        biJ();
        biM();
        biN();
        biO();
        biP();
        biQ();
    }

    private void biH() {
        if (!StringUtils.isNull(this.equ.getName_show())) {
            this.esp = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.equ.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void biI() {
        if (this.eqP != null) {
            if (this.eqP.openRecomDuration == 1 && this.mCreateTime > 0) {
                String cX = com.baidu.tbadk.core.util.at.cX(this.mCreateTime);
                if (!StringUtils.isNull(cX)) {
                    this.esq = cX;
                }
            }
            if (this.eqP.openRecomFans == 1) {
                int i = 0;
                if (this.eqP != null && this.eqP.user_info != null) {
                    i = this.eqP.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.esq) && i > 0) {
                    this.esq += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.at.da(i);
                } else if (i > 0) {
                    this.esq = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.at.da(i);
                }
            }
        }
    }

    private void biJ() {
        if (bgR() || (bjZ() && getType() != epI)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cV = com.baidu.tbadk.core.util.at.cV(j);
                if (com.baidu.tbadk.core.util.at.Bp(cV)) {
                    cV = com.baidu.tbadk.core.util.at.getFormatTimeShort(j);
                }
                this.esq = cV;
            }
            String str = "";
            if (this.equ != null && this.equ.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.equ.getBaijiahaoInfo().auth_desc)) {
                str = this.equ.getBaijiahaoInfo().auth_desc;
            }
            if (bki()) {
                biK();
            } else if (!this.esz && this.equ != null && this.equ.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.equ.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.esq)) {
                    this.esq += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.esq = cutChineseAndEnglishWithSuffix;
                }
            } else if (!TextUtils.isEmpty(this.esq) && !TextUtils.isEmpty(str)) {
                this.esq += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.esq = str;
            }
        } else if (getType() == epI) {
            biI();
        } else {
            long bia = bia() * 1000;
            if (bia != 0) {
                String cV2 = com.baidu.tbadk.core.util.at.cV(bia);
                if (com.baidu.tbadk.core.util.at.Bp(cV2)) {
                    cV2 = com.baidu.tbadk.core.util.at.getFormatTimeShort(bia);
                }
                String string = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when);
                if (bfQ()) {
                    cV2 = com.baidu.tbadk.core.util.at.cW(bia);
                }
                this.esq = string + cV2;
            } else {
                long j2 = this.mCreateTime;
                String cV3 = com.baidu.tbadk.core.util.at.cV(j2);
                if (com.baidu.tbadk.core.util.at.Bp(cV3)) {
                    cV3 = com.baidu.tbadk.core.util.at.getFormatTimeShort(j2);
                }
                this.esq = cV3;
            }
            if (bki()) {
                biK();
            } else if (!this.esz && this.equ != null && this.equ.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix2 = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.equ.getBazhuGradeData().getDesc(), this.esy ? 24 : 16, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.esq)) {
                    this.esq += "   " + cutChineseAndEnglishWithSuffix2;
                } else {
                    this.esq = cutChineseAndEnglishWithSuffix2;
                }
            }
            if (!TextUtils.isEmpty(this.esq) && !TextUtils.isEmpty(getAddress())) {
                this.esq += " • " + getAddress();
            }
        }
    }

    private void biK() {
        if (bki() && !TextUtils.isEmpty(this.equ.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.esq)) {
                this.esq += "   " + this.equ.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.esq = this.equ.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void biL() {
        if (!bgR() && !bjZ()) {
            long bia = 1000 * bia();
            if (bia != 0) {
                String cV = com.baidu.tbadk.core.util.at.cV(bia);
                if (com.baidu.tbadk.core.util.at.Bp(cV)) {
                    cV = com.baidu.tbadk.core.util.at.getFormatTimeShort(bia);
                }
                this.esq = cV;
            }
            if (bki()) {
                biK();
            } else if (!this.esz && this.equ != null && this.equ.showBazhuGrade()) {
                String cutChineseAndEnglishWithSuffix = com.baidu.tbadk.core.util.at.cutChineseAndEnglishWithSuffix(this.equ.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE);
                if (!TextUtils.isEmpty(this.esq)) {
                    this.esq += "   " + cutChineseAndEnglishWithSuffix;
                } else {
                    this.esq = cutChineseAndEnglishWithSuffix;
                }
            }
            if (!TextUtils.isEmpty(this.esq) && !TextUtils.isEmpty(getAddress())) {
                this.esq += " • " + getAddress();
            }
        }
    }

    private void biM() {
        if (biB() == null || biB().share_info == null || biB().share_info.share_user_count <= 0 || !bjB() || (this.erW > 0 && this.erX == 0)) {
            this.esr = null;
            return;
        }
        int i = biB().share_info.share_user_count;
        if (i == 1) {
            this.esr = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.esr = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.at.numberUniform(i)});
        }
    }

    private void biN() {
        this.eqi = bje();
        com.baidu.tieba.card.m.a(this, this.eqi, true);
    }

    private void biO() {
        this.enz = bjc();
    }

    private void biP() {
        this.ess = com.baidu.tbadk.core.util.at.getFormatTimeShort(bia() * 1000);
    }

    private void biQ() {
        this.est = com.baidu.tbadk.core.util.at.getFormatTimeShort(bia());
    }

    public SpannableStringBuilder biR() {
        return this.eqh;
    }

    public boolean isTop() {
        return bic() != 0;
    }

    public int biS() {
        if (this.erl != null) {
            long bhz = this.erl.bhz();
            long bhA = this.erl.bhA();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < bhz) {
                return 1;
            }
            if (currentTimeMillis > bhA) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int biT() {
        if (biV() && this.eqV.size() >= 1) {
            a aVar = this.eqV.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int bfU = aVar.bfU();
            int bfV = aVar.bfV();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < bfU) {
                return 4;
            }
            return currentTimeMillis > bfV ? 2 : 1;
        }
        return -1;
    }

    public int biU() {
        if (!biV() || this.eqV.size() < 1 || this.eqV.get(0) == null) {
            return -1;
        }
        return this.eqV.get(0).bfT();
    }

    public boolean biV() {
        return this.eqJ == 1;
    }

    public String getActUrl() {
        return (!biV() || this.eqV.size() < 1 || this.eqV.get(0) == null) ? "" : this.eqV.get(0).getUrl();
    }

    private com.baidu.adp.widget.b Ax(String str) {
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

    public SmartApp biW() {
        return this.esn;
    }

    private void y(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && biY()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_convene));
            }
            if (bic() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.icon_top));
            } else if (bic() == 2) {
                arrayList.add(Integer.valueOf(R.drawable.icon_notice));
            }
            if (bie() == 1 || this.eqt.bkw() != 0) {
                if (bhN() != null && getThreadType() == 41) {
                    if (biS() == 2) {
                        arrayList.add(Integer.valueOf(R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(R.drawable.icon_zhibo));
                }
            }
            if (z && bjp()) {
                Integer num = era.get(Integer.valueOf(biS()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (bid() == 1 && !isTop() && epH != getType() && epP != getType()) {
                arrayList.add(Integer.valueOf(R.drawable.icon_elite));
            }
            if (this.eqG != null && this.eqG.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(R.drawable.icon_live_on));
            }
            if (bim() == 1) {
                arrayList.add(Integer.valueOf(R.drawable.frs_post_ding));
            }
            Integer num2 = eqZ.get(new Point(biU(), biT()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (bis() != null) {
                arrayList.add(Integer.valueOf(R.drawable.tag_act));
            }
            if (bit() != null) {
                arrayList.add(Integer.valueOf(R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = Ax(this.category_name);
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
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.eqb));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder biZ = biZ();
        if (biZ != null) {
            spannableStringBuilder.append((CharSequence) biZ);
        }
        this.eqh = spannableStringBuilder;
    }

    public boolean biX() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (bih() != null) {
            if (bih().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (bih().getGender() == 2) {
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

    private boolean biY() {
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
        SpannableStringBuilder biZ = biZ();
        if (z) {
            spannableStringBuilder = a(biZ.toString(), biZ, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(biZ);
        }
        this.eqh = spannableStringBuilder;
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
            if (this.eqc == 1) {
                this.eqh = a3;
                return a3;
            }
        } else if (this.eqc == 1) {
            this.eqh = new SpannableStringBuilder();
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

    public void dz(String str, String str2) {
        this.mUrl = str;
        this.erq = str2;
    }

    public SpannableStringBuilder biZ() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eqe, this.title);
    }

    public SpannableStringBuilder bja() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.eqf, this.eqd);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> bjb() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.esI) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString bjc() {
        SpannableStringBuilder bja = bja();
        com.baidu.tieba.card.m.a(this, bja, false);
        return new SpannableString(bja);
    }

    public SpannableString bjd() {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.eqg)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.eqg, this.eqd));
    }

    public String getAbstract() {
        return this.eqd;
    }

    public void Ay(String str) {
        this.eqd = str;
    }

    public SpannableStringBuilder e(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder biZ;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.eqc == 1) {
            biZ = bja();
            spannableStringBuilder = biZ.toString();
        } else {
            biZ = biZ();
            spannableStringBuilder = biZ.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, biZ, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(biZ);
        }
        this.eqh = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder A(boolean z, boolean z2) {
        return e(z, z2, false);
    }

    public SpannableStringBuilder B(boolean z, boolean z2) {
        SpannableStringBuilder bja;
        if (!StringUtils.isNull(this.title) && this.eqc != 1) {
            bja = biZ();
        } else {
            bja = bja();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bja);
        this.eqh = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder bje() {
        if (StringUtils.isNull(this.title) || this.eqc == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(biZ());
        this.eqh = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData bgM() {
        if (this.eqe != null && this.eqe.size() > 0) {
            int size = this.eqe.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.eqe.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && bgN() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.DK(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void bjf() {
        y(false, false);
    }

    public void bjg() {
        y(false, true);
    }

    public AnchorInfoData bjh() {
        return this.eqG;
    }

    public boolean bji() {
        return this.threadType == 36;
    }

    public boolean bgN() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean bjj() {
        return this.threadType == 11 || this.eqD == 1;
    }

    public boolean bjk() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> biq = biq();
        if (biq == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= biq.size() || i2 >= 3) {
                break;
            }
            if (biq.get(i2) != null && biq.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(biq.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = biq.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = biq.get(i2).getPicUrl();
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
        if (this.eqM != null && !StringUtils.isNull(this.eqM.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.eqM.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.equ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.equ.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean bjl() {
        String userId;
        return this.equ == null || (userId = this.equ.getUserId()) == null || userId.equals("0");
    }

    public boolean bjm() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (bjW()) {
            if (biz() != null) {
                return epH;
            }
            return epl;
        }
        int bic = bic();
        if (this.esb == 1) {
            if (this.esc != null) {
                return epy;
            }
            return this.esf != null ? epR : epQ;
        } else if (this.eqP != null && this.threadType == 60) {
            return epK;
        } else {
            if (this.eqP != null && this.threadType == 49) {
                return epI;
            }
            if (this.threadType == 51) {
                return epJ;
            }
            if (this.threadType == 63) {
                return epS;
            }
            if (this.threadType == 64) {
                return epT;
            }
            if (bic == 2 || bic == 1) {
                return epk;
            }
            if (this.eqM != null && bju() && !bjm()) {
                return epY;
            }
            if (this.eqM != null && !bjm()) {
                if (bik()) {
                    return epP;
                }
                return epH;
            } else if (this.isShareThread && this.erY != null) {
                if (this.erY.enA) {
                    if (this.erY.videoInfo != null) {
                        return epO;
                    }
                    if (this.erY.bgP()) {
                        return epN;
                    }
                    return epM;
                }
                return epL;
            } else if (bgP()) {
                return epz;
            } else {
                if (bjo()) {
                    return epV.get() ? erk : epl;
                } else if (biV() && biU() == 1) {
                    return epV.get() ? ert : epl;
                } else if (isLinkThread()) {
                    return epF;
                } else {
                    if (bik()) {
                        return epG;
                    }
                    if (this.eoR) {
                        return epq;
                    }
                    if (this.eoS) {
                        return epr;
                    }
                    if (this.eoT) {
                        return eps;
                    }
                    if (this.eoU) {
                        return ept;
                    }
                    if (this.eoV) {
                        return epu;
                    }
                    if (this.eoX) {
                        return epw;
                    }
                    if (this.eoY) {
                        return epx;
                    }
                    if (this.eoW) {
                        return epv;
                    }
                    if (this.eqT) {
                        int bjn = bjn();
                        if (bjn == 1) {
                            return epm;
                        }
                        if (bjn == 2) {
                            return epn;
                        }
                        if (bjn > 2) {
                            return epo;
                        }
                        return epl;
                    }
                    return epl;
                }
            }
        }
    }

    public int bjn() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.bfo().isShowImages() || com.baidu.tbadk.core.util.y.getCount(biq()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < biq().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean bjo() {
        return bhN() != null && getThreadType() == 41 && bie() == 1 && biS() == 2;
    }

    public void F(ArrayList<s> arrayList) {
        if (this.eqc == 1) {
            this.elK = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.elK = 0;
        } else {
            this.elK = 0;
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && next.bgj() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.bgj().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.elK = next.bgk();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean bjp() {
        return this.threadType == 41;
    }

    public boolean bjq() {
        return this.eru;
    }

    public void ir(boolean z) {
        this.eru = z;
    }

    public String bjr() {
        return this.erv;
    }

    public r bjs() {
        return this.eqY;
    }

    public void bjt() {
        if (this.eqR == 0) {
            this.eqR = 1;
        }
    }

    public void is(boolean z) {
        this.erH = z;
    }

    public boolean bju() {
        return this.erH;
    }

    public void nU(int i) {
        this.erI = i + 1;
    }

    public int bjv() {
        return this.erI;
    }

    public boolean bjw() {
        return this.esx;
    }

    public void it(boolean z) {
        this.esx = z;
    }

    public cd bjx() {
        return this.eqO;
    }

    public boolean bjy() {
        return getThreadType() == 49;
    }

    public boolean bjz() {
        return getThreadType() == 40;
    }

    public boolean bjA() {
        return getThreadType() == 50;
    }

    public boolean bjB() {
        return getThreadType() == 60;
    }

    public int bjC() {
        return this.erO;
    }

    public void setSmartFrsPosition(int i) {
        this.erO = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String bjD() {
        return this.mRecomSource;
    }

    public boolean bjE() {
        return this.erP;
    }

    public long bjF() {
        return this.agreeData.agreeNum;
    }

    public long bjG() {
        return this.agreeData.disAgreeNum;
    }

    public int bjH() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int bjI() {
        return this.agreeData.agreeType;
    }

    public void nV(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void nW(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cK(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cL(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void nX(int i) {
        this.agreeData.agreeType = i;
    }

    public long bjJ() {
        return this.erR;
    }

    public void cM(long j) {
        this.erR = j;
    }

    public PostData bjK() {
        return this.erQ;
    }

    public am bjL() {
        return this.erS;
    }

    private ArrayList<m.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean bii = bii();
        if (z2) {
            if (z) {
                if (bii && !bgN()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if (bie() == 1 || getThreadType() == 33 || (big() != null && big().bkw() != 0)) {
                    if (bhN() != null && bjp()) {
                        if (biS() == 2) {
                            arrayList.add(new m.a(R.string.interview_live));
                        }
                    } else if (!bii) {
                        arrayList.add(new m.a(R.string.photo_live_tips));
                    }
                }
                if (bjp()) {
                    arrayList.add(erL.get(biS()));
                }
                if (biV()) {
                    Integer num = erK.get(new Point(biU(), biT()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (bis() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (bii && bic() != 1 && !bgN()) {
                    arrayList.add(new m.a(R.string.god_title));
                }
                if ((bie() == 1 || getThreadType() == 33) && !bjp() && !bii) {
                    arrayList.add(new m.a(R.string.photo_live_tips));
                }
                if (bid() == 1) {
                    arrayList.add(new m.a(R.string.good));
                }
                if (bic() == 1) {
                    arrayList.add(new m.a(R.string.top));
                }
                if (bjp() && bhN() != null && biS() == 2) {
                    arrayList.add(new m.a(R.string.interview_live));
                }
                if (biV()) {
                    Integer num2 = erK.get(new Point(biU(), biT()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a(R.string.card_promotion_text));
                    }
                }
                if (this.erw == 1) {
                    arrayList.add(new m.a(R.string.card_tbread_text));
                }
                if (bit() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (bis() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && bjy()) {
                    arrayList.add(new m.a(R.string.ala_live));
                }
                if (z3 && bjA()) {
                    arrayList.add(new m.a(R.string.live_record));
                } else if (bjz()) {
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
        this.eqx = arrayList;
    }

    public void H(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.eqy = arrayList;
    }

    public String bjM() {
        return this.esd;
    }

    public void Az(String str) {
        this.esd = str;
    }

    public void bjN() {
        this.esb = 1;
    }

    public boolean bjO() {
        return this.esb == 1;
    }

    public String bjP() {
        return this.eqk;
    }

    public void AA(String str) {
        this.eqk = str;
    }

    public String bjQ() {
        return this.eql;
    }

    public void AB(String str) {
        this.eql = str;
    }

    public String bjR() {
        return this.ese;
    }

    public void AC(String str) {
        this.ese = str;
    }

    public boolean bjS() {
        return this.esh;
    }

    public void iu(boolean z) {
        this.esh = z;
    }

    public boolean bjT() {
        return this.esi;
    }

    public void iv(boolean z) {
        this.esi = z;
    }

    public void b(VideoInfo videoInfo) {
        this.esf = videoInfo;
    }

    public boolean bjU() {
        return this.esj != null;
    }

    public bs bjV() {
        return this.eqj;
    }

    public boolean bjW() {
        return this.esm;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eqM != null) {
            return this.eqM.video_url;
        }
        return null;
    }

    public boolean bjX() {
        return this.eso;
    }

    public void iw(boolean z) {
        this.eso = z;
    }

    public AgreeData bjY() {
        return this.agreeData;
    }

    public boolean bjZ() {
        return this.esA;
    }

    public void ix(boolean z) {
        this.esA = z;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public boolean bfP() {
        return this.esy;
    }

    public void iy(boolean z) {
        this.esy = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule bka() {
        return this.esc;
    }

    public String getShareImageUrl() {
        return this.esu;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> biq = biq();
        if (com.baidu.tbadk.core.k.bfo().isShowImages() && com.baidu.tbadk.core.util.y.getCount(biq) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < biq.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.y.getItem(biq, 0);
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

    public boolean bkb() {
        return bkc() || bkd();
    }

    public boolean bgP() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean bgQ() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean bkc() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean bkd() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean bgR() {
        if (this.mBaijiahao == null) {
            return false;
        }
        return UtilHelper.isUgcThreadType(this.mBaijiahao.oriUgcType);
    }

    @Deprecated
    public boolean isBjh() {
        return bgR();
    }

    public void nY(int i) {
        this.isBjh = i;
    }

    public int bke() {
        return this.esH;
    }

    public String bkf() {
        return this.esG;
    }

    public void AD(String str) {
        this.esG = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int bkg() {
        if (bij()) {
            return 4;
        }
        if (bjy() || bjA()) {
            return 3;
        }
        if (bgP()) {
            return 5;
        }
        if (bgQ()) {
            return 6;
        }
        if (bkc()) {
            return 7;
        }
        if (bkd()) {
            return 8;
        }
        if (this.isShareThread && this.erY != null) {
            return 9;
        }
        if (bjz()) {
            return 2;
        }
        return 1;
    }

    public int bkh() {
        if (bkd() || bkc()) {
            return 2;
        }
        if (bgP() || bgQ()) {
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

    public boolean bki() {
        return this.equ != null && this.equ.isNewGod();
    }

    public boolean bkj() {
        return (bih() == null || bih().getAlaUserData() == null || bih().getAlaUserData().live_status != 1) ? false : true;
    }

    public Item bkk() {
        return this.esP;
    }

    public List<HeadItem> bkl() {
        return this.esQ;
    }

    public void a(Item item) {
        this.esP = item;
    }

    public void aX(List<HeadItem> list) {
        this.esQ = list;
    }

    public void a(ItemData itemData) {
        this.itemData = itemData;
    }

    public PollData bkm() {
        return this.esR;
    }

    public void b(PollData pollData) {
        this.esR = pollData;
    }

    public List<PbLinkData> bkn() {
        return this.esM;
    }

    public void aY(List<PbLinkData> list) {
        this.esM = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.esM)) {
            for (PbLinkData pbLinkData : this.esM) {
                if (pbLinkData.urlType == 2 && !this.esO) {
                    this.esO = true;
                }
            }
        }
    }

    public List<PbGoodsData> bko() {
        return this.esN;
    }

    public void aZ(List<PbGoodsData> list) {
        this.esN = list;
        if (!com.baidu.tbadk.core.util.y.isEmpty(list) && !this.esO) {
            this.esO = true;
        }
    }

    public boolean bkp() {
        return this.esO;
    }
}

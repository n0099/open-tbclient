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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
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
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
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
public class bj extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String asg;
    private String authorId;
    public int cLB;
    private SpannableString cLH;
    private int cNR;
    private SpannableStringBuilder cNW;
    private SpannableStringBuilder cNX;
    private bf cNY;
    private String cNZ;
    private int cOA;
    private VideoInfo cOC;
    private VideoDesc cOD;
    private bq cOE;
    private AlaInfoData cOF;
    private long cOG;
    private p cOO;
    private LiveCoverStatus cOU;
    private long cOV;
    private String cOa;
    private String cOk;
    public int cOp;
    private int cOq;
    private int cOt;
    public int cOu;
    private String cOx;
    private String cOy;
    private boolean cPE;
    private long cPG;
    private ag cPH;
    public f cPJ;
    private MediaData cPK;
    public int cPL;
    public OriginalThreadInfo cPN;
    private TopicModule cPR;
    private String cPS;
    private String cPT;
    private VideoInfo cPU;
    private String cPV;
    public OriginalForumInfo cPX;
    public boolean cPY;
    private String cPZ;
    public TwZhiBoUser cPc;
    public List<TwAnchorProfitItem> cPd;
    private SkinInfo cPh;
    private boolean cPj;
    private String cPk;
    private boolean cPn;
    public String cPp;
    public int cPq;
    public int cPr;
    public String cPs;
    public String cPt;
    public long cPu;
    private List<ReportInfo> cPy;
    private boolean cQa;
    private SmartApp cQb;
    private String cQd;
    private String cQe;
    private String cQf;
    private String cQg;
    private String cQh;
    public String cQi;
    private boolean cQl;
    private boolean cQm;
    private boolean cQn;
    public boolean cQo;
    public boolean cQp;
    public boolean cQq;
    public String cQr;
    private int cQs;
    private String cQt;
    private int cQu;
    public String cQw;
    public boolean isBigGie;
    private boolean isLinkThread;
    public boolean isPrivacy;
    public boolean isShareThread;
    private String latitude;
    private BaijiahaoData mBaijiahao;
    private long mCreateTime;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private int post_num;
    public int sortType;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId cNe = BdUniqueId.gen();
    public static final BdUniqueId cNf = BdUniqueId.gen();
    public static final BdUniqueId cNg = BdUniqueId.gen();
    public static final BdUniqueId cNh = BdUniqueId.gen();
    public static final BdUniqueId cNi = BdUniqueId.gen();
    public static final BdUniqueId cNj = BdUniqueId.gen();
    public static final BdUniqueId cNk = BdUniqueId.gen();
    public static final BdUniqueId cNl = BdUniqueId.gen();
    public static final BdUniqueId cNm = BdUniqueId.gen();
    public static final BdUniqueId cNn = BdUniqueId.gen();
    public static final BdUniqueId cNo = BdUniqueId.gen();
    public static final BdUniqueId cNp = BdUniqueId.gen();
    public static final BdUniqueId cNq = BdUniqueId.gen();
    public static final BdUniqueId cNr = BdUniqueId.gen();
    public static final BdUniqueId cNs = BdUniqueId.gen();
    public static final BdUniqueId cNt = BdUniqueId.gen();
    public static final BdUniqueId cNu = BdUniqueId.gen();
    public static final BdUniqueId cNv = BdUniqueId.gen();
    public static final BdUniqueId cNw = BdUniqueId.gen();
    public static final BdUniqueId cNx = BdUniqueId.gen();
    public static final BdUniqueId cNy = BdUniqueId.gen();
    public static final BdUniqueId cNz = BdUniqueId.gen();
    public static final BdUniqueId cNA = BdUniqueId.gen();
    public static final BdUniqueId cNB = BdUniqueId.gen();
    public static final BdUniqueId cNC = BdUniqueId.gen();
    public static final BdUniqueId cND = BdUniqueId.gen();
    public static final BdUniqueId cNE = BdUniqueId.gen();
    public static final BdUniqueId cNF = BdUniqueId.gen();
    public static final BdUniqueId cNG = BdUniqueId.gen();
    public static final BdUniqueId cNH = BdUniqueId.gen();
    public static final BdUniqueId cNI = BdUniqueId.gen();
    public static AtomicBoolean cNJ = new AtomicBoolean(false);
    public static AtomicBoolean cNK = new AtomicBoolean(false);
    public static AtomicBoolean cNL = new AtomicBoolean(false);
    public static final BdUniqueId cNM = BdUniqueId.gen();
    public static final BdUniqueId cNN = BdUniqueId.gen();
    private static HashMap<Point, Integer> cOP = new HashMap<>();
    private static HashMap<Integer, Integer> cOQ = new HashMap<>();
    public static final BdUniqueId cPa = BdUniqueId.gen();
    public static final BdUniqueId cPi = BdUniqueId.gen();
    private static HashMap<Point, Integer> cPz = new HashMap<>();
    private static SparseArray<l.a> cPA = new SparseArray<>(3);
    public boolean cMQ = false;
    public boolean cMR = false;
    public boolean cMS = false;
    public boolean cMT = false;
    public boolean cMU = false;
    public boolean cMV = false;
    public boolean cMW = false;
    public boolean cMX = false;
    private int cNO = 0;
    private String cNP = "1";
    public int cNQ = 1;
    private String cOs = null;
    private int cKf = 0;
    public int cOH = 0;
    private String cOI = "";
    public boolean cOJ = false;
    private String cOR = "";
    public boolean cPv = true;
    public boolean cPB = false;
    public boolean cPC = false;
    private int cPD = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cPI = false;
    private int cPQ = 0;
    private boolean cPW = false;
    private boolean cQc = false;
    public boolean cQj = false;
    public boolean cQk = false;
    public boolean cQv = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cOb = 0;
    private int cOc = 0;
    private String last_time = null;
    private long cOd = 0;
    private int cOe = 0;
    private int cOf = 0;
    private int cOg = 0;
    private int cOh = 0;
    private bn cOi = new bn();
    private MetaData cOj = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cOn = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cOo = new ArrayList<>();
    private int cOl = 0;
    private int cOm = 0;
    private String ad_url = null;
    private String cNS = null;
    private String from = null;
    private int cOr = 0;
    private PraiseData cOv = new PraiseData();
    private AnchorInfoData cOw = new AnchorInfoData();
    private long time = 0;
    private int cOz = 0;
    private ArrayList<b> cOL = new ArrayList<>();
    private bv cOM = null;
    private g cON = null;
    private int cOS = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cOB = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cOT = null;
    private int cOK = 0;
    private boolean cOW = false;
    private boolean cOX = false;
    private int cOY = 0;
    private boolean cOZ = false;
    private int anchorLevel = 0;
    public int cPl = 0;
    public m cPm = new m();
    private List<PbContent> cNV = new ArrayList();
    private List<PbContent> cNT = new ArrayList();
    private List<PbContent> cNU = new ArrayList();
    private String category_name = null;
    private bh cPb = new bh();
    private ArrayList<com.baidu.tbadk.data.c> cPe = new ArrayList<>();
    private PushStatusData cPf = new PushStatusData();
    public boolean cPw = false;
    public int cPx = -1;
    private PostData cPF = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cPo = 0;
    public int cPM = 0;
    private String tieba_game_information_source = "";
    public String cPP = "";
    public String cPO = "";
    public String mUrl = "";
    public String cPg = "";

    static {
        cOP.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        cOP.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        cOP.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        cOP.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        cOP.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        cOP.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        cOP.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        cOP.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cPz.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cPz.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cPz.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cPz.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cPz.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cPz.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cPz.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cPz.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cOQ.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cOQ.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cOQ.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cPA.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cPA.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cPA.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.cOq = 0;
        this.cOA = 0;
        this.cOV = 0L;
        this.cPL = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cOV = 0L;
        this.cOA = 0;
        this.cOq = 0;
        this.cPL = 0;
        this.isBigGie = false;
    }

    public String azu() {
        return this.cQd;
    }

    public String azv() {
        return this.cQe;
    }

    public void sm(String str) {
        this.cQe = str;
    }

    public String azw() {
        return this.cQf;
    }

    public SpannableStringBuilder azx() {
        return this.cNX;
    }

    public SpannableString azy() {
        return this.cLH;
    }

    public void a(SpannableString spannableString) {
        if (azX() != null) {
            if (this.cNX != null) {
                this.cNX.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cLH);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.cLH = new SpannableString(spannableStringBuilder);
        }
    }

    public String azz() {
        return this.cQg;
    }

    public String azA() {
        return this.cQh;
    }

    public boolean azB() {
        return this.cOq == 1;
    }

    public bh azC() {
        return this.cPb;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jo(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.cOA;
    }

    public int azD() {
        return this.cPo;
    }

    public void jp(int i) {
        this.cPo = i;
    }

    public void jq(int i) {
        this.cOY = i;
    }

    public int azE() {
        return this.cOY;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo azF() {
        return this.cPU;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bq(long j) {
        this.mCreateTime = j;
    }

    public long azG() {
        return this.cOG;
    }

    public String azH() {
        return this.cOx;
    }

    public PraiseData azI() {
        return this.cOv;
    }

    public void a(PraiseData praiseData) {
        this.cOv = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String azJ() {
        return this.asg;
    }

    public void sn(String str) {
        this.asg = str;
    }

    public String azK() {
        return this.cNP;
    }

    public void so(String str) {
        this.cNP = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jr(int i) {
        this.cNO = i;
    }

    public int azL() {
        return this.cNO;
    }

    public String azM() {
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

    public List<PbContent> azN() {
        return this.cNV;
    }

    public void aw(List<PbContent> list) {
        this.cNV = list;
    }

    public void ax(List<PbContent> list) {
        this.cNT = list;
    }

    public void ay(List<PbContent> list) {
        this.cNU = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void js(int i) {
        this.reply_num = i;
    }

    public int azO() {
        return this.reply_num;
    }

    public int azP() {
        return this.cOc;
    }

    public void jt(int i) {
        this.cOc = i;
    }

    public long azQ() {
        return this.cOd;
    }

    public void br(long j) {
        this.cOd = j;
    }

    public int azR() {
        return this.cOf;
    }

    public int azS() {
        return this.cOe;
    }

    public void ju(int i) {
        this.cOe = i;
    }

    public int azT() {
        return this.cOg;
    }

    public void jv(int i) {
        this.cOg = i;
    }

    public int azU() {
        return this.cOh;
    }

    public List<PbContent> azV() {
        return this.cNT;
    }

    public bn azW() {
        return this.cOi;
    }

    public MetaData azX() {
        return this.cOj;
    }

    public boolean azY() {
        return this.is_god != 0;
    }

    public boolean azZ() {
        return this.is_god == 1;
    }

    public boolean aAa() {
        return (this.cOj == null || this.cOj.getGodUserData() == null || this.cOj.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aAb() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cOj = metaData;
    }

    public String aAc() {
        return this.forum_name;
    }

    public void sp(String str) {
        this.forum_name = str;
    }

    public int aAd() {
        return this.cOm;
    }

    public String aAe() {
        return this.ad_url;
    }

    public int aAf() {
        return this.cOr;
    }

    public void jw(int i) {
        this.cOr = i;
    }

    public String aAg() {
        return this.cOs;
    }

    public void sq(String str) {
        this.cOs = str;
    }

    public ArrayList<MediaData> aAh() {
        return this.cOn;
    }

    public ArrayList<b> aAi() {
        return this.cOL;
    }

    public void v(ArrayList<b> arrayList) {
        this.cOL = arrayList;
    }

    public bv aAj() {
        return this.cOM;
    }

    public g aAk() {
        return this.cON;
    }

    public ArrayList<VoiceData.VoiceModel> aAl() {
        return this.cOo;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aAm() {
        return this.cNR;
    }

    public void jx(int i) {
        this.cNR = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aAn() {
        return this.cOI;
    }

    public VideoInfo aAo() {
        return this.cOC;
    }

    public void a(VideoInfo videoInfo) {
        this.cOC = videoInfo;
    }

    public VideoDesc aAp() {
        return this.cOD;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cOF = alaInfoData;
    }

    public AlaInfoData aAq() {
        return this.cOF;
    }

    public PushStatusData aAr() {
        return this.cPf;
    }

    public SkinInfo aAs() {
        return this.cPh;
    }

    public long aAt() {
        return this.cPu;
    }

    public boolean aAu() {
        return this.cPv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axQ() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axR() {
        return this.cPt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axS() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axQ().getTid());
        alVar.setFid(axQ().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.cLA = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.cLB = this.cLB;
        alVar.cardType = aBY();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cOy = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cOq = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cOG = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cOb = threadInfo.repost_num.intValue();
                this.cOc = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cOd = threadInfo.last_time_int.intValue();
                this.cOe = threadInfo.is_top.intValue();
                this.cOf = threadInfo.is_membertop.intValue();
                this.cOg = threadInfo.is_good.intValue();
                this.cOh = threadInfo.is_livepost.intValue();
                this.cOi.a(threadInfo.topic);
                this.cOj.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cOk = threadInfo.fname;
                this.cOl = threadInfo.has_commented.intValue();
                this.cOm = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cOC = threadInfo.video_info;
                this.cOD = threadInfo.video_segment;
                this.cOF = new AlaInfoData();
                this.cOF.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cOr = threadInfo.collect_status.intValue();
                this.cOs = threadInfo.collect_mark_pid;
                this.cOt = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cOu = threadInfo.thread_type.intValue();
                this.cOx = threadInfo.first_post_id + "";
                this.cOI = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cNR = threadInfo.is_ntitle.intValue();
                this.cOz = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cPG = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cOA = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cPn = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cNT = threadInfo.rich_title;
                this.cNV = threadInfo.first_post_content;
                this.cNU = threadInfo.rich_abstract;
                this.cOp = threadInfo.is_godthread_recommend.intValue();
                if ((this.cOj == null || this.cOj.getUserId() == null || this.cOj.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cOj = metaData;
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
                this.cNS = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cOn.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cOC = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cOE = new bq();
                    this.cOE.a(threadInfo.video_channel_info);
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
                        this.cOo.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cOL.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cOM = new bv();
                    this.cOM.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.cON = new g();
                    this.cON.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.cOO = new p();
                    this.cOO.a(threadInfo.cartoon_info);
                }
                this.cOv.setUserMap(this.userMap);
                this.cOv.parserProtobuf(threadInfo.zan);
                this.cOw.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cOv.setTitle(this.title);
                } else {
                    this.cOv.setTitle(this.cNS);
                }
                this.cOR = threadInfo.livecover_src;
                this.cOS = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cOK = threadInfo.post_num.intValue();
                this.cOV = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.lH(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.un(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cOB.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cOT = noticeInfo.notice;
                    }
                    this.cOY = zhiBoInfoTW.copythread_remind.intValue();
                    this.cOW = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cOX = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.cOR)) {
                        this.cOR = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cPc = zhiBoInfoTW.user.tw_anchor_info;
                        this.cPd = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cOU = threadInfo.twzhibo_info.livecover_status;
                    this.cOV = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cOZ = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cPb.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cPe.add(cVar);
                    }
                }
                this.cPf.parserProtobuf(threadInfo.push_status);
                this.cPk = threadInfo.lego_card;
                this.cPh = threadInfo.skin_info;
                this.cPl = threadInfo.is_book_chapter.intValue();
                this.cPm.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cPt = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cPu = threadInfo.last_read_pid.longValue();
                this.cPv = threadInfo.cheak_repeat.intValue() == 1;
                this.cPy = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cPF.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.getCount(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                }
                this.cPE = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cPH = new ag();
                    this.cPH.a(threadInfo.link_info);
                }
                this.cPI = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cPJ = new f();
                    this.cPJ.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cPK = new MediaData();
                    this.cPK.parserProtobuf(threadInfo.pic_info);
                }
                this.cPo = threadInfo.is_called.intValue();
                this.cPL = threadInfo.middle_page_num.intValue();
                this.cPM = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cPO = threadInfo.star_rank_icon.icon_pic_url;
                    this.cPP = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cPN = new OriginalThreadInfo();
                    this.cPN.a(threadInfo.origin_thread_info);
                } else {
                    this.cPN = null;
                    this.isShareThread = false;
                }
                this.cPQ = threadInfo.is_topic.intValue();
                this.cPS = threadInfo.topic_user_name;
                this.cPT = threadInfo.topic_h5_url;
                this.cPR = threadInfo.topic_module;
                this.cPV = threadInfo.presentation_style;
                this.cPX = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cPZ = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cNY = new bf();
                    this.cNY.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cQb = threadInfo.swan_info;
                }
                this.cQi = threadInfo.t_share_img;
                this.cQj = threadInfo.is_headlinepost.intValue() == 1;
                this.cQt = threadInfo.article_cover;
                this.cQu = threadInfo.bjh_content_tag.intValue();
                this.cQs = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cQv = threadInfo.is_s_card.intValue() == 1;
                this.cQw = threadInfo.scard_packet_id;
                aAv();
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
                this.cOG = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cOb = jSONObject.optInt("repost_num", 0);
                this.cOc = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cOd = jSONObject.optLong("last_time_int", 0L);
                this.cOe = jSONObject.optInt("is_top", 0);
                this.cOf = jSONObject.optInt("is_membertop", 0);
                this.cOg = jSONObject.optInt("is_good", 0);
                this.cOh = jSONObject.optInt("is_livepost", 0);
                this.cOi.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cOj.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cOk = this.forum_name;
                this.cOl = jSONObject.optInt("has_commented", 0);
                this.cOm = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cOr = jSONObject.optInt("collect_status");
                this.cOs = jSONObject.optString("collect_mark_pid");
                this.cOt = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cOu = jSONObject.optInt("thread_type");
                this.cPG = jSONObject.optLong("share_num");
                this.cOx = jSONObject.optString("first_post_id", "0");
                this.cOI = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cNR = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.cPb.parserJson(optJSONObject2);
                }
                if ((this.cOj == null || this.cOj.getUserId() == null) && this.userMap != null) {
                    this.cOj = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.cOF = new AlaInfoData();
                this.cOF.parserJson(jSONObject.optJSONObject("ala_info"));
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                            sb.append(optJSONArray.getJSONObject(i).optString("text"));
                        }
                    }
                }
                this.cNS = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cOn.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.cOo.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cOL.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.cOM = new bv();
                    this.cOM.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.cON = new g();
                    this.cON.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.cOO = new p();
                    this.cOO.parserJson(optJSONObject6);
                }
                this.cOv.setUserMap(this.userMap);
                this.cOv.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cOw.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cOv.setTitle(this.title);
                } else {
                    this.cOv.setTitle(this.cNS);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.cPb.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cPe.add(cVar);
                    }
                }
                this.cPl = jSONObject.optInt("is_book_chapter", 0);
                this.cPm.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cPt = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cPp = jSONObject.optString("recom_extra_img");
                this.cPs = jSONObject.optString("recom_extra_img_night");
                this.cPq = jSONObject.optInt("recom_extra_img_width", 0);
                this.cPr = jSONObject.optInt("recom_extra_img_height", 0);
                this.cPu = jSONObject.optLong("last_read_pid");
                this.cPv = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.cOE = new bq();
                    this.cOE.ci(optJSONObject8);
                }
                this.cPE = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.cPH = new ag();
                    this.cPH.parserJson(optJSONObject9);
                }
                this.cPI = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.cPJ = new f();
                    this.cPJ.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.cPK = new MediaData();
                    this.cPK.parserJson(optJSONObject11);
                }
                this.cPo = jSONObject.optInt("is_called", 0);
                this.cPL = jSONObject.optInt("middle_page_num", 0);
                this.cPM = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.cOC = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.cPN = new OriginalThreadInfo();
                        this.cPN.parserJson(optJSONObject13);
                    } else {
                        this.cPN = null;
                    }
                } else {
                    this.cPN = null;
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
                    this.cQb = builder2.build(false);
                }
                this.cQi = jSONObject.optString("t_share_img");
                this.cQj = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.cQs = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.cQu = jSONObject.optInt("bjh_content_tag");
                this.cQt = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject("baijiahao");
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cQv = jSONObject.optInt("is_s_card", 0) == 1;
                this.cQw = jSONObject.optString("scard_packet_id");
                aAv();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aAv() {
        aAw();
        aAx();
        aAz();
        aAA();
        aAB();
        aAC();
        aAD();
    }

    private void aAw() {
        if (!StringUtils.isNull(this.cOj.getName_show())) {
            this.cQd = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cOj.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aAx() {
        if (aBV() || aBN()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String bz = com.baidu.tbadk.core.util.aq.bz(j);
                if (com.baidu.tbadk.core.util.aq.ti(bz)) {
                    bz = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.cQe = bz;
            }
            String str = "";
            if (this.cOj != null && this.cOj.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.cOj.getBaijiahaoInfo().auth_desc)) {
                str = this.cOj.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.cQe) && !TextUtils.isEmpty(str)) {
                this.cQe += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.cQe = str;
                return;
            } else {
                return;
            }
        }
        if (aAb()) {
            long azQ = azQ() * 1000;
            if (azQ != 0) {
                this.cQe = com.baidu.tbadk.core.util.aq.bz(azQ);
            }
        } else {
            long azQ2 = 1000 * azQ();
            if (azQ2 != 0) {
                String bz2 = com.baidu.tbadk.core.util.aq.bz(azQ2);
                if (com.baidu.tbadk.core.util.aq.ti(bz2)) {
                    bz2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azQ2);
                }
                this.cQe = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + bz2;
            }
        }
        if (!TextUtils.isEmpty(this.cQe) && !TextUtils.isEmpty(getAddress())) {
            this.cQe += " • " + getAddress();
        }
    }

    public void aAy() {
        if (!aBV() && !aBN()) {
            if (!aAb()) {
                long azQ = 1000 * azQ();
                if (azQ != 0) {
                    String bz = com.baidu.tbadk.core.util.aq.bz(azQ);
                    if (com.baidu.tbadk.core.util.aq.ti(bz)) {
                        bz = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azQ);
                    }
                    this.cQe = bz;
                }
            }
            if (!TextUtils.isEmpty(this.cQe) && !TextUtils.isEmpty(getAddress())) {
                this.cQe += " • " + getAddress();
            }
        }
    }

    private void aAz() {
        if (aAq() == null || aAq().share_info == null || aAq().share_info.share_user_count <= 0 || !aBo() || (this.cPL > 0 && this.cPM == 0)) {
            this.cQf = null;
            return;
        }
        int i = aAq().share_info.share_user_count;
        if (i == 1) {
            this.cQf = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cQf = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aAA() {
        this.cNX = aAR();
        com.baidu.tieba.card.l.a(this, this.cNX, true);
    }

    private void aAB() {
        this.cLH = aAP();
    }

    private void aAC() {
        this.cQg = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azQ() * 1000);
    }

    private void aAD() {
        this.cQh = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azQ());
    }

    public SpannableStringBuilder aAE() {
        return this.cNW;
    }

    public boolean isTop() {
        return azS() != 0;
    }

    public int aAF() {
        if (this.cPb != null) {
            long azp = this.cPb.azp();
            long azq = this.cPb.azq();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < azp) {
                return 1;
            }
            if (currentTimeMillis > azq) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aAG() {
        if (aAI() && this.cOL.size() >= 1) {
            b bVar = this.cOL.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int axV = bVar.axV();
            int axW = bVar.axW();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < axV) {
                return 4;
            }
            return currentTimeMillis > axW ? 2 : 1;
        }
        return -1;
    }

    public int aAH() {
        if (!aAI() || this.cOL.size() < 1 || this.cOL.get(0) == null) {
            return -1;
        }
        return this.cOL.get(0).axU();
    }

    public boolean aAI() {
        return this.cOz == 1;
    }

    public String getActUrl() {
        return (!aAI() || this.cOL.size() < 1 || this.cOL.get(0) == null) ? "" : this.cOL.get(0).getUrl();
    }

    private com.baidu.adp.widget.b ss(String str) {
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

    public SmartApp aAJ() {
        return this.cQb;
    }

    private void o(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aAL()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (azS() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (azS() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (azU() == 1 || this.cOi.aCg() != 0) {
                if (azC() != null && getThreadType() == 41) {
                    if (aAF() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aBd()) {
                Integer num = cOQ.get(Integer.valueOf(aAF()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (azT() == 1 && !isTop() && cNv != getType() && cND != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cOw != null && this.cOw.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aAd() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = cOP.get(new Point(aAH(), aAG()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aAj() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aAk() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = ss(this.category_name);
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
                spannableString = new SpannableString(sb2 + this.category_name + HanziToPinyin.Token.SEPARATOR);
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cNQ));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aAM = aAM();
        if (aAM != null) {
            spannableStringBuilder.append((CharSequence) aAM);
        }
        this.cNW = spannableStringBuilder;
    }

    public boolean aAK() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (azX() != null) {
            if (azX().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (azX().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(kVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean aAL() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void p(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            q(z, z3);
            return;
        }
        SpannableStringBuilder aAM = aAM();
        if (z) {
            spannableStringBuilder = a(aAM.toString(), aAM, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aAM);
        }
        this.cNW = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.l.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.cNR == 1) {
                this.cNW = a;
                return a;
            }
        } else if (this.cNR == 1) {
            this.cNW = new SpannableStringBuilder();
            return a;
        }
        if (spannableStringBuilder != null) {
            a.append((CharSequence) spannableStringBuilder);
            return a;
        } else if (b.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public void cg(String str, String str2) {
        this.mUrl = str;
        this.cPg = str2;
    }

    public SpannableStringBuilder aAM() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cNT, this.title);
    }

    public SpannableStringBuilder aAN() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cNU, this.cNS);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aAO() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.cQv) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aAP() {
        SpannableStringBuilder aAN = aAN();
        com.baidu.tieba.card.l.a(this, aAN, false);
        return new SpannableString(aAN);
    }

    public SpannableString aAQ() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cNV)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.cNV, this.cNS));
    }

    public String getAbstract() {
        return this.cNS;
    }

    public void st(String str) {
        this.cNS = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aAM;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.cNR == 1) {
            aAM = aAN();
            spannableStringBuilder = aAM.toString();
        } else {
            aAM = aAM();
            spannableStringBuilder = aAM.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aAM, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aAM);
        }
        this.cNW = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder q(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder r(boolean z, boolean z2) {
        SpannableStringBuilder aAN;
        if (!StringUtils.isNull(this.title) && this.cNR != 1) {
            aAN = aAM();
        } else {
            aAN = aAN();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAN);
        this.cNW = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aAR() {
        if (StringUtils.isNull(this.title) || this.cNR == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAM());
        this.cNW = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aAS() {
        if (this.cNT != null && this.cNT.size() > 0) {
            int size = this.cNT.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cNT.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aAX() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vr(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aAT() {
        o(false, false);
    }

    public void aAU() {
        o(false, true);
    }

    public AnchorInfoData aAV() {
        return this.cOw;
    }

    public boolean aAW() {
        return this.threadType == 36;
    }

    public boolean aAX() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aAY() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aAh = aAh();
        if (aAh == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aAh.size() || i2 >= 3) {
                break;
            }
            if (aAh.get(i2) != null && aAh.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aAh.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aAh.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aAh.get(i2).getPicUrl();
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
        if (this.cOC != null && !StringUtils.isNull(this.cOC.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cOC.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cOj != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cOj.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aAZ() {
        String userId;
        return this.cOj == null || (userId = this.cOj.getUserId()) == null || userId.equals("0");
    }

    public boolean aBa() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aBK()) {
            if (aAo() != null) {
                return cNv;
            }
            return cNf;
        }
        int azS = azS();
        if (this.cPQ == 1) {
            if (this.cPR != null) {
                return cNr;
            }
            return this.cPU != null ? cNF : cNE;
        } else if (this.cOF != null && this.threadType == 60) {
            return cNy;
        } else {
            if (this.cOF != null && this.threadType == 49) {
                return cNw;
            }
            if (this.threadType == 51) {
                return cNx;
            }
            if (this.threadType == 63) {
                return cNG;
            }
            if (this.threadType == 64) {
                return cNH;
            }
            if (azS == 2 || azS == 1) {
                return cNe;
            }
            if (this.cOC != null && aBi() && !aBa()) {
                return cNM;
            }
            if (this.cOC != null && !aBa()) {
                if (aAa()) {
                    return cND;
                }
                return cNv;
            } else if (this.isShareThread && this.cPN != null) {
                if (this.cPN.cLI) {
                    if (this.cPN.videoInfo != null) {
                        return cNC;
                    }
                    if (this.cPN.ayL()) {
                        return cNB;
                    }
                    return cNA;
                }
                return cNz;
            } else if (ayL()) {
                return cNs;
            } else {
                if (aBc()) {
                    return cNJ.get() ? cPa : cNf;
                } else if (aAI() && aAH() == 1) {
                    return cNJ.get() ? cPi : cNf;
                } else if (isLinkThread()) {
                    return cNt;
                } else {
                    if (aAa()) {
                        return cNu;
                    }
                    if (this.cMQ) {
                        return cNj;
                    }
                    if (this.cMR) {
                        return cNk;
                    }
                    if (this.cMS) {
                        return cNl;
                    }
                    if (this.cMT) {
                        return cNm;
                    }
                    if (this.cMU) {
                        return cNn;
                    }
                    if (this.cMW) {
                        return cNp;
                    }
                    if (this.cMX) {
                        return cNq;
                    }
                    if (this.cMV) {
                        return cNo;
                    }
                    if (this.cOJ) {
                        int aBb = aBb();
                        if (aBb == 1) {
                            return cNg;
                        }
                        if (aBb == 2) {
                            return cNh;
                        }
                        if (aBb > 2) {
                            return cNi;
                        }
                        return cNf;
                    }
                    return cNf;
                }
            }
        }
    }

    public int aBb() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.axy().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aAh()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aAh().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aBc() {
        return azC() != null && getThreadType() == 41 && azU() == 1 && aAF() == 2;
    }

    public void w(ArrayList<q> arrayList) {
        if (this.cNR == 1) {
            this.cKf = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.cKf = 0;
        } else {
            this.cKf = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.ayf() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.ayf().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.cKf = next.ayg();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aBd() {
        return this.threadType == 41;
    }

    public boolean aBe() {
        return this.cPj;
    }

    public void fs(boolean z) {
        this.cPj = z;
    }

    public String aBf() {
        return this.cPk;
    }

    public p aBg() {
        return this.cOO;
    }

    public void aBh() {
        if (this.cOH == 0) {
            this.cOH = 1;
        }
    }

    public void ft(boolean z) {
        this.cPw = z;
    }

    public boolean aBi() {
        return this.cPw;
    }

    public void jy(int i) {
        this.cPx = i + 1;
    }

    public int aBj() {
        return this.cPx;
    }

    public boolean aBk() {
        return this.cQl;
    }

    public void fu(boolean z) {
        this.cQl = z;
    }

    public boolean aBl() {
        return getThreadType() == 49;
    }

    public boolean aBm() {
        return getThreadType() == 40;
    }

    public boolean aBn() {
        return getThreadType() == 50;
    }

    public boolean aBo() {
        return getThreadType() == 60;
    }

    public int aBp() {
        return this.cPD;
    }

    public void setSmartFrsPosition(int i) {
        this.cPD = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aBq() {
        return this.mRecomSource;
    }

    public boolean aBr() {
        return this.cPE;
    }

    public long aBs() {
        return this.agreeData.agreeNum;
    }

    public long aBt() {
        return this.agreeData.disAgreeNum;
    }

    public int aBu() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aBv() {
        return this.agreeData.agreeType;
    }

    public void jz(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void jA(int i) {
        this.agreeData.agreeNum = i;
    }

    public void bs(long j) {
        this.agreeData.agreeNum = j;
    }

    public void bt(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void jB(int i) {
        this.agreeData.agreeType = i;
    }

    public long aBw() {
        return this.cPG;
    }

    public void bu(long j) {
        this.cPG = j;
    }

    public PostData aBx() {
        return this.cPF;
    }

    public ag aBy() {
        return this.cPH;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean azY = azY();
        if (z2) {
            if (z) {
                if (azY && !aAX()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (azU() == 1 || getThreadType() == 33 || (azW() != null && azW().aCg() != 0)) {
                    if (azC() != null && aBd()) {
                        if (aAF() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!azY) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aBd()) {
                    arrayList.add(cPA.get(aAF()));
                }
                if (aAI()) {
                    Integer num = cPz.get(new Point(aAH(), aAG()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aAj() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (azY && azS() != 1 && !aAX()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((azU() == 1 || getThreadType() == 33) && !aBd() && !azY) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (azT() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (azS() == 1) {
                    arrayList.add(new l.a((int) R.string.top));
                }
                if (aBd() && azC() != null && aAF() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aAI()) {
                    Integer num2 = cPz.get(new Point(aAH(), aAG()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cPl == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aAk() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aAj() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aBl()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aBn()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aBm()) {
                    arrayList.add(new l.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new l.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void x(ArrayList<MediaData> arrayList) {
        this.cOn = arrayList;
    }

    public void y(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.cOo = arrayList;
    }

    public String aBz() {
        return this.cPS;
    }

    public void su(String str) {
        this.cPS = str;
    }

    public void aBA() {
        this.cPQ = 1;
    }

    public boolean aBB() {
        return this.cPQ == 1;
    }

    public boolean aBC() {
        return "worldcupvideo".equals(this.cPV);
    }

    public String aBD() {
        return this.cNZ;
    }

    public void sv(String str) {
        this.cNZ = str;
    }

    public String aBE() {
        return this.cOa;
    }

    public void sw(String str) {
        this.cOa = str;
    }

    public String aBF() {
        return this.cPT;
    }

    public void sx(String str) {
        this.cPT = str;
    }

    public boolean aBG() {
        return this.cPW;
    }

    public void fv(boolean z) {
        this.cPW = z;
    }

    public void b(VideoInfo videoInfo) {
        this.cPU = videoInfo;
    }

    public boolean aBH() {
        return this.cPX != null;
    }

    public String aBI() {
        return this.cOk;
    }

    public bf aBJ() {
        return this.cNY;
    }

    public void a(bf bfVar) {
        this.cNY = bfVar;
    }

    public boolean aBK() {
        return this.cQa;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cOC != null) {
            return this.cOC.video_url;
        }
        return null;
    }

    public boolean aBL() {
        return this.cQc;
    }

    public void fw(boolean z) {
        this.cQc = z;
    }

    public AgreeData aBM() {
        return this.agreeData;
    }

    public boolean aBN() {
        return this.cQm;
    }

    public void fx(boolean z) {
        this.cQm = z;
    }

    public boolean aBO() {
        return this.cQn;
    }

    public void fy(boolean z) {
        this.cQn = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aBP() {
        return this.cPR;
    }

    public String getShareImageUrl() {
        return this.cQi;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aAh = aAh();
        if (com.baidu.tbadk.core.i.axy().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aAh) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aAh.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, 0);
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
        return iArr;
    }

    public int[] aBQ() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aAh = aAh();
        if (com.baidu.tbadk.core.i.axy().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aAh) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aAh.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aAh, 0);
        if (mediaData2 != null && mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
            if (mediaData2.picWidth * 1.5f <= mediaData2.picHeight) {
                i = ((int) (i2 * 1.5f)) + dimensionPixelSize;
                i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
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
                } else if (mediaData2.picHeight < i2 || mediaData2.picHeight >= i2 * 1.5f) {
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
                } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 1.5f) {
                    int i6 = mediaData2.picWidth;
                    i2 = mediaData2.picHeight;
                    i = i6;
                } else {
                    i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
                    i = (mediaData2.picWidth * i2) / mediaData2.picHeight;
                }
            } else if (mediaData2.picHeight < i2) {
                i2 = 0;
                i = 0;
            } else if (mediaData2.picHeight >= i2 && mediaData2.picHeight < i2 * 1.5f) {
                int i7 = (i2 * 2) + dimensionPixelSize;
                i2 = (mediaData2.picHeight * i7) / mediaData2.picWidth;
                i = i7;
            } else if (mediaData2.picWidth < mediaData2.picHeight) {
                i2 = ((int) (i2 * 1.5f)) + dimensionPixelSize;
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
        return iArr;
    }

    public boolean aBR() {
        return aBT() || aBU();
    }

    public boolean ayL() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aBS() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aBT() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aBU() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aBV() {
        if (this.mBaijiahao == null) {
            return false;
        }
        switch (this.mBaijiahao.oriUgcType) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public boolean isBjh() {
        return aBV();
    }

    public void jC(int i) {
        this.cQs = i;
    }

    public int aBW() {
        return this.cQu;
    }

    public String aBX() {
        return this.cQt;
    }

    public void sy(String str) {
        this.cQt = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aBY() {
        if (azZ()) {
            return 4;
        }
        if (aBl() || aBn()) {
            return 3;
        }
        if (ayL()) {
            return 5;
        }
        if (aBS()) {
            return 6;
        }
        if (aBT()) {
            return 7;
        }
        if (aBU()) {
            return 8;
        }
        if (this.isShareThread && this.cPN != null) {
            return 9;
        }
        if (aBm()) {
            return 2;
        }
        return 1;
    }

    public int aBZ() {
        if (aBU() || aBT()) {
            return 2;
        }
        if (ayL() || aBS()) {
            return 3;
        }
        return 1;
    }
}

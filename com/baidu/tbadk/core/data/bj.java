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
    private String aru;
    private String authorId;
    public int cLr;
    private SpannableString cLx;
    private int cNH;
    private SpannableStringBuilder cNM;
    private SpannableStringBuilder cNN;
    private bf cNO;
    private String cNP;
    private String cNQ;
    private p cOE;
    private LiveCoverStatus cOK;
    private long cOL;
    public TwZhiBoUser cOS;
    public List<TwAnchorProfitItem> cOT;
    private SkinInfo cOX;
    private boolean cOZ;
    private String cOa;
    public int cOf;
    private int cOg;
    private int cOj;
    public int cOk;
    private String cOn;
    private String cOo;
    private int cOq;
    private VideoInfo cOs;
    private VideoDesc cOt;
    private bq cOu;
    private AlaInfoData cOv;
    private long cOw;
    private MediaData cPA;
    public int cPB;
    public OriginalThreadInfo cPD;
    private TopicModule cPH;
    private String cPI;
    private String cPJ;
    private VideoInfo cPK;
    private String cPL;
    public OriginalForumInfo cPN;
    public boolean cPO;
    private String cPP;
    private boolean cPQ;
    private SmartApp cPR;
    private String cPT;
    private String cPU;
    private String cPV;
    private String cPW;
    private String cPX;
    public String cPY;
    private String cPa;
    private boolean cPd;
    public String cPf;
    public int cPg;
    public int cPh;
    public String cPi;
    public String cPj;
    public long cPk;
    private List<ReportInfo> cPo;
    private boolean cPu;
    private long cPw;
    private ag cPx;
    public f cPz;
    private boolean cQb;
    private boolean cQc;
    private boolean cQd;
    public boolean cQe;
    public boolean cQf;
    public boolean cQg;
    public String cQh;
    private int cQi;
    private String cQj;
    private int cQk;
    public String cQm;
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
    public static final BdUniqueId cMU = BdUniqueId.gen();
    public static final BdUniqueId cMV = BdUniqueId.gen();
    public static final BdUniqueId cMW = BdUniqueId.gen();
    public static final BdUniqueId cMX = BdUniqueId.gen();
    public static final BdUniqueId cMY = BdUniqueId.gen();
    public static final BdUniqueId cMZ = BdUniqueId.gen();
    public static final BdUniqueId cNa = BdUniqueId.gen();
    public static final BdUniqueId cNb = BdUniqueId.gen();
    public static final BdUniqueId cNc = BdUniqueId.gen();
    public static final BdUniqueId cNd = BdUniqueId.gen();
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
    public static AtomicBoolean cNz = new AtomicBoolean(false);
    public static AtomicBoolean cNA = new AtomicBoolean(false);
    public static AtomicBoolean cNB = new AtomicBoolean(false);
    public static final BdUniqueId cNC = BdUniqueId.gen();
    public static final BdUniqueId cND = BdUniqueId.gen();
    private static HashMap<Point, Integer> cOF = new HashMap<>();
    private static HashMap<Integer, Integer> cOG = new HashMap<>();
    public static final BdUniqueId cOQ = BdUniqueId.gen();
    public static final BdUniqueId cOY = BdUniqueId.gen();
    private static HashMap<Point, Integer> cPp = new HashMap<>();
    private static SparseArray<l.a> cPq = new SparseArray<>(3);
    public boolean cMG = false;
    public boolean cMH = false;
    public boolean cMI = false;
    public boolean cMJ = false;
    public boolean cMK = false;
    public boolean cML = false;
    public boolean cMM = false;
    public boolean cMN = false;
    private int cNE = 0;
    private String cNF = "1";
    public int cNG = 1;
    private String cOi = null;
    private int cJU = 0;
    public int cOx = 0;
    private String cOy = "";
    public boolean cOz = false;
    private String cOH = "";
    public boolean cPl = true;
    public boolean cPr = false;
    public boolean cPs = false;
    private int cPt = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cPy = false;
    private int cPG = 0;
    private boolean cPM = false;
    private boolean cPS = false;
    public boolean cPZ = false;
    public boolean cQa = false;
    public boolean cQl = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cNR = 0;
    private int cNS = 0;
    private String last_time = null;
    private long cNT = 0;
    private int cNU = 0;
    private int cNV = 0;
    private int cNW = 0;
    private int cNX = 0;
    private bn cNY = new bn();
    private MetaData cNZ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cOd = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cOe = new ArrayList<>();
    private int cOb = 0;
    private int cOc = 0;
    private String ad_url = null;
    private String cNI = null;
    private String from = null;
    private int cOh = 0;
    private PraiseData cOl = new PraiseData();
    private AnchorInfoData cOm = new AnchorInfoData();
    private long time = 0;
    private int cOp = 0;
    private ArrayList<b> cOB = new ArrayList<>();
    private bv cOC = null;
    private g cOD = null;
    private int cOI = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cOr = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cOJ = null;
    private int cOA = 0;
    private boolean cOM = false;
    private boolean cON = false;
    private int cOO = 0;
    private boolean cOP = false;
    private int anchorLevel = 0;
    public int cPb = 0;
    public m cPc = new m();
    private List<PbContent> cNL = new ArrayList();
    private List<PbContent> cNJ = new ArrayList();
    private List<PbContent> cNK = new ArrayList();
    private String category_name = null;
    private bh cOR = new bh();
    private ArrayList<com.baidu.tbadk.data.c> cOU = new ArrayList<>();
    private PushStatusData cOV = new PushStatusData();
    public boolean cPm = false;
    public int cPn = -1;
    private PostData cPv = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cPe = 0;
    public int cPC = 0;
    private String tieba_game_information_source = "";
    public String cPF = "";
    public String cPE = "";
    public String mUrl = "";
    public String cOW = "";

    static {
        cOF.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        cOF.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        cOF.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        cOF.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        cOF.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        cOF.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        cOF.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        cOF.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cPp.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cPp.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cPp.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cPp.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cPp.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cPp.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cPp.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cPp.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cOG.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cOG.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cOG.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cPq.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cPq.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cPq.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.cOg = 0;
        this.cOq = 0;
        this.cOL = 0L;
        this.cPB = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cOL = 0L;
        this.cOq = 0;
        this.cOg = 0;
        this.cPB = 0;
        this.isBigGie = false;
    }

    public String azb() {
        return this.cPT;
    }

    public String azc() {
        return this.cPU;
    }

    public void sj(String str) {
        this.cPU = str;
    }

    public String azd() {
        return this.cPV;
    }

    public SpannableStringBuilder aze() {
        return this.cNN;
    }

    public SpannableString azf() {
        return this.cLx;
    }

    public void a(SpannableString spannableString) {
        if (azE() != null) {
            if (this.cNN != null) {
                this.cNN.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cLx);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.cLx = new SpannableString(spannableStringBuilder);
        }
    }

    public String azg() {
        return this.cPW;
    }

    public String azh() {
        return this.cPX;
    }

    public boolean azi() {
        return this.cOg == 1;
    }

    public bh azj() {
        return this.cOR;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jo(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.cOq;
    }

    public int azk() {
        return this.cPe;
    }

    public void jp(int i) {
        this.cPe = i;
    }

    public void jq(int i) {
        this.cOO = i;
    }

    public int azl() {
        return this.cOO;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo azm() {
        return this.cPK;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bn(long j) {
        this.mCreateTime = j;
    }

    public long azn() {
        return this.cOw;
    }

    public String azo() {
        return this.cOn;
    }

    public PraiseData azp() {
        return this.cOl;
    }

    public void a(PraiseData praiseData) {
        this.cOl = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String azq() {
        return this.aru;
    }

    public void sk(String str) {
        this.aru = str;
    }

    public String azr() {
        return this.cNF;
    }

    public void sl(String str) {
        this.cNF = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jr(int i) {
        this.cNE = i;
    }

    public int azs() {
        return this.cNE;
    }

    public String azt() {
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

    public List<PbContent> azu() {
        return this.cNL;
    }

    public void ax(List<PbContent> list) {
        this.cNL = list;
    }

    public void ay(List<PbContent> list) {
        this.cNJ = list;
    }

    public void az(List<PbContent> list) {
        this.cNK = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void js(int i) {
        this.reply_num = i;
    }

    public int azv() {
        return this.reply_num;
    }

    public int azw() {
        return this.cNS;
    }

    public void jt(int i) {
        this.cNS = i;
    }

    public long azx() {
        return this.cNT;
    }

    public void bo(long j) {
        this.cNT = j;
    }

    public int azy() {
        return this.cNV;
    }

    public int azz() {
        return this.cNU;
    }

    public void ju(int i) {
        this.cNU = i;
    }

    public int azA() {
        return this.cNW;
    }

    public void jv(int i) {
        this.cNW = i;
    }

    public int azB() {
        return this.cNX;
    }

    public List<PbContent> azC() {
        return this.cNJ;
    }

    public bn azD() {
        return this.cNY;
    }

    public MetaData azE() {
        return this.cNZ;
    }

    public boolean azF() {
        return this.is_god != 0;
    }

    public boolean azG() {
        return this.is_god == 1;
    }

    public boolean azH() {
        return (this.cNZ == null || this.cNZ.getGodUserData() == null || this.cNZ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean azI() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cNZ = metaData;
    }

    public String azJ() {
        return this.forum_name;
    }

    public void sm(String str) {
        this.forum_name = str;
    }

    public int azK() {
        return this.cOc;
    }

    public String azL() {
        return this.ad_url;
    }

    public int azM() {
        return this.cOh;
    }

    public void jw(int i) {
        this.cOh = i;
    }

    public String azN() {
        return this.cOi;
    }

    public void sn(String str) {
        this.cOi = str;
    }

    public ArrayList<MediaData> azO() {
        return this.cOd;
    }

    public ArrayList<b> azP() {
        return this.cOB;
    }

    public void v(ArrayList<b> arrayList) {
        this.cOB = arrayList;
    }

    public bv azQ() {
        return this.cOC;
    }

    public g azR() {
        return this.cOD;
    }

    public ArrayList<VoiceData.VoiceModel> azS() {
        return this.cOe;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int azT() {
        return this.cNH;
    }

    public void jx(int i) {
        this.cNH = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String azU() {
        return this.cOy;
    }

    public VideoInfo azV() {
        return this.cOs;
    }

    public void a(VideoInfo videoInfo) {
        this.cOs = videoInfo;
    }

    public VideoDesc azW() {
        return this.cOt;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cOv = alaInfoData;
    }

    public AlaInfoData azX() {
        return this.cOv;
    }

    public PushStatusData azY() {
        return this.cOV;
    }

    public SkinInfo azZ() {
        return this.cOX;
    }

    public long aAa() {
        return this.cPk;
    }

    public boolean aAb() {
        return this.cPl;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axx() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axy() {
        return this.cPj;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axz() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axx().getTid());
        alVar.setFid(axx().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.cLq = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.cLr = this.cLr;
        alVar.cardType = aBF();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cOo = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cOg = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cOw = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cNR = threadInfo.repost_num.intValue();
                this.cNS = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cNT = threadInfo.last_time_int.intValue();
                this.cNU = threadInfo.is_top.intValue();
                this.cNV = threadInfo.is_membertop.intValue();
                this.cNW = threadInfo.is_good.intValue();
                this.cNX = threadInfo.is_livepost.intValue();
                this.cNY.a(threadInfo.topic);
                this.cNZ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cOa = threadInfo.fname;
                this.cOb = threadInfo.has_commented.intValue();
                this.cOc = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cOs = threadInfo.video_info;
                this.cOt = threadInfo.video_segment;
                this.cOv = new AlaInfoData();
                this.cOv.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cOh = threadInfo.collect_status.intValue();
                this.cOi = threadInfo.collect_mark_pid;
                this.cOj = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cOk = threadInfo.thread_type.intValue();
                this.cOn = threadInfo.first_post_id + "";
                this.cOy = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cNH = threadInfo.is_ntitle.intValue();
                this.cOp = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cPw = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cOq = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cPd = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cNJ = threadInfo.rich_title;
                this.cNL = threadInfo.first_post_content;
                this.cNK = threadInfo.rich_abstract;
                this.cOf = threadInfo.is_godthread_recommend.intValue();
                if ((this.cNZ == null || this.cNZ.getUserId() == null || this.cNZ.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cNZ = metaData;
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
                this.cNI = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cOd.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cOs = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cOu = new bq();
                    this.cOu.a(threadInfo.video_channel_info);
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
                        this.cOe.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cOB.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cOC = new bv();
                    this.cOC.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.cOD = new g();
                    this.cOD.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.cOE = new p();
                    this.cOE.a(threadInfo.cartoon_info);
                }
                this.cOl.setUserMap(this.userMap);
                this.cOl.parserProtobuf(threadInfo.zan);
                this.cOm.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cOl.setTitle(this.title);
                } else {
                    this.cOl.setTitle(this.cNI);
                }
                this.cOH = threadInfo.livecover_src;
                this.cOI = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cOA = threadInfo.post_num.intValue();
                this.cOL = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.lH(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.ui(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cOr.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cOJ = noticeInfo.notice;
                    }
                    this.cOO = zhiBoInfoTW.copythread_remind.intValue();
                    this.cOM = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cON = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.cOH)) {
                        this.cOH = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cOS = zhiBoInfoTW.user.tw_anchor_info;
                        this.cOT = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cOK = threadInfo.twzhibo_info.livecover_status;
                    this.cOL = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cOP = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cOR.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cOU.add(cVar);
                    }
                }
                this.cOV.parserProtobuf(threadInfo.push_status);
                this.cPa = threadInfo.lego_card;
                this.cOX = threadInfo.skin_info;
                this.cPb = threadInfo.is_book_chapter.intValue();
                this.cPc.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cPj = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cPk = threadInfo.last_read_pid.longValue();
                this.cPl = threadInfo.cheak_repeat.intValue() == 1;
                this.cPo = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cPv.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.cPu = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cPx = new ag();
                    this.cPx.a(threadInfo.link_info);
                }
                this.cPy = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cPz = new f();
                    this.cPz.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cPA = new MediaData();
                    this.cPA.parserProtobuf(threadInfo.pic_info);
                }
                this.cPe = threadInfo.is_called.intValue();
                this.cPB = threadInfo.middle_page_num.intValue();
                this.cPC = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cPE = threadInfo.star_rank_icon.icon_pic_url;
                    this.cPF = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cPD = new OriginalThreadInfo();
                    this.cPD.a(threadInfo.origin_thread_info);
                } else {
                    this.cPD = null;
                    this.isShareThread = false;
                }
                this.cPG = threadInfo.is_topic.intValue();
                this.cPI = threadInfo.topic_user_name;
                this.cPJ = threadInfo.topic_h5_url;
                this.cPH = threadInfo.topic_module;
                this.cPL = threadInfo.presentation_style;
                this.cPN = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cPP = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cNO = new bf();
                    this.cNO.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cPR = threadInfo.swan_info;
                }
                this.cPY = threadInfo.t_share_img;
                this.cPZ = threadInfo.is_headlinepost.intValue() == 1;
                this.cQj = threadInfo.article_cover;
                this.cQk = threadInfo.bjh_content_tag.intValue();
                this.cQi = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cQl = threadInfo.is_s_card.intValue() == 1;
                this.cQm = threadInfo.scard_packet_id;
                aAc();
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
                this.cOw = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cNR = jSONObject.optInt("repost_num", 0);
                this.cNS = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cNT = jSONObject.optLong("last_time_int", 0L);
                this.cNU = jSONObject.optInt("is_top", 0);
                this.cNV = jSONObject.optInt("is_membertop", 0);
                this.cNW = jSONObject.optInt("is_good", 0);
                this.cNX = jSONObject.optInt("is_livepost", 0);
                this.cNY.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cNZ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cOa = this.forum_name;
                this.cOb = jSONObject.optInt("has_commented", 0);
                this.cOc = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cOh = jSONObject.optInt("collect_status");
                this.cOi = jSONObject.optString("collect_mark_pid");
                this.cOj = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cOk = jSONObject.optInt("thread_type");
                this.cPw = jSONObject.optLong("share_num");
                this.cOn = jSONObject.optString("first_post_id", "0");
                this.cOy = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cNH = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.cOR.parserJson(optJSONObject2);
                }
                if ((this.cNZ == null || this.cNZ.getUserId() == null) && this.userMap != null) {
                    this.cNZ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.cOv = new AlaInfoData();
                this.cOv.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.cNI = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cOd.add(mediaData);
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
                        this.cOe.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cOB.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.cOC = new bv();
                    this.cOC.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.cOD = new g();
                    this.cOD.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.cOE = new p();
                    this.cOE.parserJson(optJSONObject6);
                }
                this.cOl.setUserMap(this.userMap);
                this.cOl.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cOm.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cOl.setTitle(this.title);
                } else {
                    this.cOl.setTitle(this.cNI);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.cOR.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cOU.add(cVar);
                    }
                }
                this.cPb = jSONObject.optInt("is_book_chapter", 0);
                this.cPc.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cPj = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cPf = jSONObject.optString("recom_extra_img");
                this.cPi = jSONObject.optString("recom_extra_img_night");
                this.cPg = jSONObject.optInt("recom_extra_img_width", 0);
                this.cPh = jSONObject.optInt("recom_extra_img_height", 0);
                this.cPk = jSONObject.optLong("last_read_pid");
                this.cPl = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.cOu = new bq();
                    this.cOu.ci(optJSONObject8);
                }
                this.cPu = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.cPx = new ag();
                    this.cPx.parserJson(optJSONObject9);
                }
                this.cPy = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.cPz = new f();
                    this.cPz.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.cPA = new MediaData();
                    this.cPA.parserJson(optJSONObject11);
                }
                this.cPe = jSONObject.optInt("is_called", 0);
                this.cPB = jSONObject.optInt("middle_page_num", 0);
                this.cPC = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.cOs = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.cPD = new OriginalThreadInfo();
                        this.cPD.parserJson(optJSONObject13);
                    } else {
                        this.cPD = null;
                    }
                } else {
                    this.cPD = null;
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
                    this.cPR = builder2.build(false);
                }
                this.cPY = jSONObject.optString("t_share_img");
                this.cPZ = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.cQi = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.cQk = jSONObject.optInt("bjh_content_tag");
                this.cQj = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject("baijiahao");
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cQl = jSONObject.optInt("is_s_card", 0) == 1;
                this.cQm = jSONObject.optString("scard_packet_id");
                aAc();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aAc() {
        aAd();
        aAe();
        aAg();
        aAh();
        aAi();
        aAj();
        aAk();
    }

    private void aAd() {
        if (!StringUtils.isNull(this.cNZ.getName_show())) {
            this.cPT = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cNZ.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aAe() {
        if (aBC() || aBu()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String bw = com.baidu.tbadk.core.util.aq.bw(j);
                if (com.baidu.tbadk.core.util.aq.te(bw)) {
                    bw = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.cPU = bw;
            }
            String str = "";
            if (this.cNZ != null && this.cNZ.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.cNZ.getBaijiahaoInfo().auth_desc)) {
                str = this.cNZ.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.cPU) && !TextUtils.isEmpty(str)) {
                this.cPU += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.cPU = str;
                return;
            } else {
                return;
            }
        }
        if (azI()) {
            long azx = azx() * 1000;
            if (azx != 0) {
                this.cPU = com.baidu.tbadk.core.util.aq.bw(azx);
            }
        } else {
            long azx2 = 1000 * azx();
            if (azx2 != 0) {
                String bw2 = com.baidu.tbadk.core.util.aq.bw(azx2);
                if (com.baidu.tbadk.core.util.aq.te(bw2)) {
                    bw2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azx2);
                }
                this.cPU = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + bw2;
            }
        }
        if (!TextUtils.isEmpty(this.cPU) && !TextUtils.isEmpty(getAddress())) {
            this.cPU += " • " + getAddress();
        }
    }

    public void aAf() {
        if (!aBC() && !aBu()) {
            if (!azI()) {
                long azx = 1000 * azx();
                if (azx != 0) {
                    String bw = com.baidu.tbadk.core.util.aq.bw(azx);
                    if (com.baidu.tbadk.core.util.aq.te(bw)) {
                        bw = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azx);
                    }
                    this.cPU = bw;
                }
            }
            if (!TextUtils.isEmpty(this.cPU) && !TextUtils.isEmpty(getAddress())) {
                this.cPU += " • " + getAddress();
            }
        }
    }

    private void aAg() {
        if (azX() == null || azX().share_info == null || azX().share_info.share_user_count <= 0 || !aAV() || (this.cPB > 0 && this.cPC == 0)) {
            this.cPV = null;
            return;
        }
        int i = azX().share_info.share_user_count;
        if (i == 1) {
            this.cPV = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cPV = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aAh() {
        this.cNN = aAy();
        com.baidu.tieba.card.l.a(this, this.cNN, true);
    }

    private void aAi() {
        this.cLx = aAw();
    }

    private void aAj() {
        this.cPW = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azx() * 1000);
    }

    private void aAk() {
        this.cPX = com.baidu.tbadk.core.util.aq.getFormatTimeShort(azx());
    }

    public SpannableStringBuilder aAl() {
        return this.cNM;
    }

    public boolean isTop() {
        return azz() != 0;
    }

    public int aAm() {
        if (this.cOR != null) {
            long ayW = this.cOR.ayW();
            long ayX = this.cOR.ayX();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ayW) {
                return 1;
            }
            if (currentTimeMillis > ayX) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aAn() {
        if (aAp() && this.cOB.size() >= 1) {
            b bVar = this.cOB.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int axC = bVar.axC();
            int axD = bVar.axD();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < axC) {
                return 4;
            }
            return currentTimeMillis > axD ? 2 : 1;
        }
        return -1;
    }

    public int aAo() {
        if (!aAp() || this.cOB.size() < 1 || this.cOB.get(0) == null) {
            return -1;
        }
        return this.cOB.get(0).axB();
    }

    public boolean aAp() {
        return this.cOp == 1;
    }

    public String getActUrl() {
        return (!aAp() || this.cOB.size() < 1 || this.cOB.get(0) == null) ? "" : this.cOB.get(0).getUrl();
    }

    private com.baidu.adp.widget.b so(String str) {
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

    public SmartApp aAq() {
        return this.cPR;
    }

    private void p(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aAs()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (azz() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (azz() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (azB() == 1 || this.cNY.aBN() != 0) {
                if (azj() != null && getThreadType() == 41) {
                    if (aAm() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aAK()) {
                Integer num = cOG.get(Integer.valueOf(aAm()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (azA() == 1 && !isTop() && cNl != getType() && cNt != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cOm != null && this.cOm.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (azK() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = cOF.get(new Point(aAo(), aAn()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (azQ() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (azR() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = so(this.category_name);
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
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cNG));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aAt = aAt();
        if (aAt != null) {
            spannableStringBuilder.append((CharSequence) aAt);
        }
        this.cNM = spannableStringBuilder;
    }

    public boolean aAr() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (azE() != null) {
            if (azE().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (azE().getGender() == 2) {
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

    private boolean aAs() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void q(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            r(z, z3);
            return;
        }
        SpannableStringBuilder aAt = aAt();
        if (z) {
            spannableStringBuilder = a(aAt.toString(), aAt, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aAt);
        }
        this.cNM = spannableStringBuilder;
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
            if (this.cNH == 1) {
                this.cNM = a;
                return a;
            }
        } else if (this.cNH == 1) {
            this.cNM = new SpannableStringBuilder();
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
        this.cOW = str2;
    }

    public SpannableStringBuilder aAt() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cNJ, this.title);
    }

    public SpannableStringBuilder aAu() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cNK, this.cNI);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aAv() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.cQl) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aAw() {
        SpannableStringBuilder aAu = aAu();
        com.baidu.tieba.card.l.a(this, aAu, false);
        return new SpannableString(aAu);
    }

    public SpannableString aAx() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cNL)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.cNL, this.cNI));
    }

    public String getAbstract() {
        return this.cNI;
    }

    public void sp(String str) {
        this.cNI = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aAt;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.cNH == 1) {
            aAt = aAu();
            spannableStringBuilder = aAt.toString();
        } else {
            aAt = aAt();
            spannableStringBuilder = aAt.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aAt, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aAt);
        }
        this.cNM = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder r(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder s(boolean z, boolean z2) {
        SpannableStringBuilder aAu;
        if (!StringUtils.isNull(this.title) && this.cNH != 1) {
            aAu = aAt();
        } else {
            aAu = aAu();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAu);
        this.cNM = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aAy() {
        if (StringUtils.isNull(this.title) || this.cNH == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAt());
        this.cNM = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aAz() {
        if (this.cNJ != null && this.cNJ.size() > 0) {
            int size = this.cNJ.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cNJ.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aAE() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vm(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aAA() {
        p(false, false);
    }

    public void aAB() {
        p(false, true);
    }

    public AnchorInfoData aAC() {
        return this.cOm;
    }

    public boolean aAD() {
        return this.threadType == 36;
    }

    public boolean aAE() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aAF() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> azO = azO();
        if (azO == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= azO.size() || i2 >= 3) {
                break;
            }
            if (azO.get(i2) != null && azO.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(azO.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = azO.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = azO.get(i2).getPicUrl();
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
        if (this.cOs != null && !StringUtils.isNull(this.cOs.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cOs.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cNZ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cNZ.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aAG() {
        String userId;
        return this.cNZ == null || (userId = this.cNZ.getUserId()) == null || userId.equals("0");
    }

    public boolean aAH() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aBr()) {
            if (azV() != null) {
                return cNl;
            }
            return cMV;
        }
        int azz = azz();
        if (this.cPG == 1) {
            if (this.cPH != null) {
                return cNh;
            }
            return this.cPK != null ? cNv : cNu;
        } else if (this.cOv != null && this.threadType == 60) {
            return cNo;
        } else {
            if (this.cOv != null && this.threadType == 49) {
                return cNm;
            }
            if (this.threadType == 51) {
                return cNn;
            }
            if (this.threadType == 63) {
                return cNw;
            }
            if (this.threadType == 64) {
                return cNx;
            }
            if (azz == 2 || azz == 1) {
                return cMU;
            }
            if (this.cOs != null && aAP() && !aAH()) {
                return cNC;
            }
            if (this.cOs != null && !aAH()) {
                if (azH()) {
                    return cNt;
                }
                return cNl;
            } else if (this.isShareThread && this.cPD != null) {
                if (this.cPD.cLy) {
                    if (this.cPD.videoInfo != null) {
                        return cNs;
                    }
                    if (this.cPD.ays()) {
                        return cNr;
                    }
                    return cNq;
                }
                return cNp;
            } else if (ays()) {
                return cNi;
            } else {
                if (aAJ()) {
                    return cNz.get() ? cOQ : cMV;
                } else if (aAp() && aAo() == 1) {
                    return cNz.get() ? cOY : cMV;
                } else if (isLinkThread()) {
                    return cNj;
                } else {
                    if (azH()) {
                        return cNk;
                    }
                    if (this.cMG) {
                        return cMZ;
                    }
                    if (this.cMH) {
                        return cNa;
                    }
                    if (this.cMI) {
                        return cNb;
                    }
                    if (this.cMJ) {
                        return cNc;
                    }
                    if (this.cMK) {
                        return cNd;
                    }
                    if (this.cMM) {
                        return cNf;
                    }
                    if (this.cMN) {
                        return cNg;
                    }
                    if (this.cML) {
                        return cNe;
                    }
                    if (this.cOz) {
                        int aAI = aAI();
                        if (aAI == 1) {
                            return cMW;
                        }
                        if (aAI == 2) {
                            return cMX;
                        }
                        if (aAI > 2) {
                            return cMY;
                        }
                        return cMV;
                    }
                    return cMV;
                }
            }
        }
    }

    public int aAI() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.axf().isShowImages() || com.baidu.tbadk.core.util.v.getCount(azO()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < azO().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aAJ() {
        return azj() != null && getThreadType() == 41 && azB() == 1 && aAm() == 2;
    }

    public void w(ArrayList<q> arrayList) {
        if (this.cNH == 1) {
            this.cJU = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.cJU = 0;
        } else {
            this.cJU = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.axM() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.axM().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.cJU = next.axN();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aAK() {
        return this.threadType == 41;
    }

    public boolean aAL() {
        return this.cOZ;
    }

    public void fn(boolean z) {
        this.cOZ = z;
    }

    public String aAM() {
        return this.cPa;
    }

    public p aAN() {
        return this.cOE;
    }

    public void aAO() {
        if (this.cOx == 0) {
            this.cOx = 1;
        }
    }

    public void fo(boolean z) {
        this.cPm = z;
    }

    public boolean aAP() {
        return this.cPm;
    }

    public void jy(int i) {
        this.cPn = i + 1;
    }

    public int aAQ() {
        return this.cPn;
    }

    public boolean aAR() {
        return this.cQb;
    }

    public void fp(boolean z) {
        this.cQb = z;
    }

    public boolean aAS() {
        return getThreadType() == 49;
    }

    public boolean aAT() {
        return getThreadType() == 40;
    }

    public boolean aAU() {
        return getThreadType() == 50;
    }

    public boolean aAV() {
        return getThreadType() == 60;
    }

    public int aAW() {
        return this.cPt;
    }

    public void setSmartFrsPosition(int i) {
        this.cPt = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aAX() {
        return this.mRecomSource;
    }

    public boolean aAY() {
        return this.cPu;
    }

    public long aAZ() {
        return this.agreeData.agreeNum;
    }

    public long aBa() {
        return this.agreeData.disAgreeNum;
    }

    public int aBb() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aBc() {
        return this.agreeData.agreeType;
    }

    public void jz(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void jA(int i) {
        this.agreeData.agreeNum = i;
    }

    public void bp(long j) {
        this.agreeData.agreeNum = j;
    }

    public void bq(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void jB(int i) {
        this.agreeData.agreeType = i;
    }

    public long aBd() {
        return this.cPw;
    }

    public void br(long j) {
        this.cPw = j;
    }

    public PostData aBe() {
        return this.cPv;
    }

    public ag aBf() {
        return this.cPx;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean azF = azF();
        if (z2) {
            if (z) {
                if (azF && !aAE()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (azB() == 1 || getThreadType() == 33 || (azD() != null && azD().aBN() != 0)) {
                    if (azj() != null && aAK()) {
                        if (aAm() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!azF) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aAK()) {
                    arrayList.add(cPq.get(aAm()));
                }
                if (aAp()) {
                    Integer num = cPp.get(new Point(aAo(), aAn()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (azQ() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (azF && azz() != 1 && !aAE()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((azB() == 1 || getThreadType() == 33) && !aAK() && !azF) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (azA() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (azz() == 1) {
                    arrayList.add(new l.a((int) R.string.top));
                }
                if (aAK() && azj() != null && aAm() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aAp()) {
                    Integer num2 = cPp.get(new Point(aAo(), aAn()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cPb == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (azR() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (azQ() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aAS()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aAU()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aAT()) {
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
        this.cOd = arrayList;
    }

    public void y(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.cOe = arrayList;
    }

    public String aBg() {
        return this.cPI;
    }

    public void sq(String str) {
        this.cPI = str;
    }

    public void aBh() {
        this.cPG = 1;
    }

    public boolean aBi() {
        return this.cPG == 1;
    }

    public boolean aBj() {
        return "worldcupvideo".equals(this.cPL);
    }

    public String aBk() {
        return this.cNP;
    }

    public void ss(String str) {
        this.cNP = str;
    }

    public String aBl() {
        return this.cNQ;
    }

    public void st(String str) {
        this.cNQ = str;
    }

    public String aBm() {
        return this.cPJ;
    }

    public void su(String str) {
        this.cPJ = str;
    }

    public boolean aBn() {
        return this.cPM;
    }

    public void fq(boolean z) {
        this.cPM = z;
    }

    public void b(VideoInfo videoInfo) {
        this.cPK = videoInfo;
    }

    public boolean aBo() {
        return this.cPN != null;
    }

    public String aBp() {
        return this.cOa;
    }

    public bf aBq() {
        return this.cNO;
    }

    public void a(bf bfVar) {
        this.cNO = bfVar;
    }

    public boolean aBr() {
        return this.cPQ;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cOs != null) {
            return this.cOs.video_url;
        }
        return null;
    }

    public boolean aBs() {
        return this.cPS;
    }

    public void fr(boolean z) {
        this.cPS = z;
    }

    public AgreeData aBt() {
        return this.agreeData;
    }

    public boolean aBu() {
        return this.cQc;
    }

    public void fs(boolean z) {
        this.cQc = z;
    }

    public boolean aBv() {
        return this.cQd;
    }

    public void ft(boolean z) {
        this.cQd = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aBw() {
        return this.cPH;
    }

    public String getShareImageUrl() {
        return this.cPY;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> azO = azO();
        if (com.baidu.tbadk.core.i.axf().isShowImages() && com.baidu.tbadk.core.util.v.getCount(azO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < azO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO, 0);
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

    public int[] aBx() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> azO = azO();
        if (com.baidu.tbadk.core.i.axf().isShowImages() && com.baidu.tbadk.core.util.v.getCount(azO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < azO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(azO, 0);
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

    public boolean aBy() {
        return aBA() || aBB();
    }

    public boolean ays() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aBz() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aBA() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aBB() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aBC() {
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
        return aBC();
    }

    public void jC(int i) {
        this.cQi = i;
    }

    public int aBD() {
        return this.cQk;
    }

    public String aBE() {
        return this.cQj;
    }

    public void sv(String str) {
        this.cQj = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aBF() {
        if (azG()) {
            return 4;
        }
        if (azB() == 1) {
            return 3;
        }
        if (ays()) {
            return 5;
        }
        if (aBz()) {
            return 6;
        }
        if (aBA()) {
            return 7;
        }
        if (aBB()) {
            return 8;
        }
        if (!this.isShareThread || this.cPD == null) {
            return aAT() ? 2 : 1;
        }
        return 9;
    }

    public int aBG() {
        if (aBB() || aBA()) {
            return 2;
        }
        if (ays() || aBz()) {
            return 3;
        }
        return 1;
    }
}

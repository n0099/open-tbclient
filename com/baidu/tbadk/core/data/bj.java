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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
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
public class bj extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.f.a {
    private String aQl;
    private String address;
    private String authorId;
    public int dpd;
    private SpannableString dpj;
    private SpannableStringBuilder drB;
    private SpannableStringBuilder drC;
    private bf drD;
    private String drE;
    private String drF;
    public int drT;
    private int drU;
    private int drX;
    public int drY;
    private int drw;
    private long dsA;
    public TwZhiBoUser dsH;
    public List<TwAnchorProfitItem> dsI;
    private SkinInfo dsM;
    private boolean dsO;
    private String dsP;
    private boolean dsS;
    public String dsU;
    public int dsV;
    public int dsW;
    public String dsX;
    public String dsY;
    public long dsZ;
    private String dsb;
    private String dsc;
    private int dse;
    private VideoInfo dsg;
    private VideoDesc dsh;
    private bq dsi;
    private AlaInfoData dsj;
    private long dsk;
    private p dss;
    private LiveCoverStatus dsz;
    private VideoInfo dtA;
    private String dtB;
    public OriginalForumInfo dtD;
    public boolean dtE;
    private String dtF;
    private boolean dtG;
    private SmartApp dtH;
    private String dtJ;
    private String dtK;
    private String dtL;
    private String dtM;
    private String dtN;
    public String dtO;
    private boolean dtR;
    private boolean dtS;
    private boolean dtT;
    public boolean dtU;
    public boolean dtV;
    public boolean dtW;
    public String dtX;
    private int dtY;
    private String dtZ;
    private List<ReportInfo> dtd;
    private boolean dtj;
    private long dtl;
    private ag dtm;
    public f dto;
    private MediaData dtp;
    public int dtq;
    public OriginalThreadInfo dtt;
    private TopicModule dtx;
    private String dty;
    private String dtz;
    private int dua;
    public String duc;
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
    private int mTabId;
    private String mTabName;
    public String noCommetStr;
    private int post_num;
    public int sortType;
    public int threadType;
    public String thread_share_link;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId dqH = BdUniqueId.gen();
    public static final BdUniqueId dqI = BdUniqueId.gen();
    public static final BdUniqueId dqJ = BdUniqueId.gen();
    public static final BdUniqueId dqK = BdUniqueId.gen();
    public static final BdUniqueId dqL = BdUniqueId.gen();
    public static final BdUniqueId dqM = BdUniqueId.gen();
    public static final BdUniqueId dqN = BdUniqueId.gen();
    public static final BdUniqueId dqO = BdUniqueId.gen();
    public static final BdUniqueId dqP = BdUniqueId.gen();
    public static final BdUniqueId dqQ = BdUniqueId.gen();
    public static final BdUniqueId dqR = BdUniqueId.gen();
    public static final BdUniqueId dqS = BdUniqueId.gen();
    public static final BdUniqueId dqT = BdUniqueId.gen();
    public static final BdUniqueId dqU = BdUniqueId.gen();
    public static final BdUniqueId dqV = BdUniqueId.gen();
    public static final BdUniqueId dqW = BdUniqueId.gen();
    public static final BdUniqueId dqX = BdUniqueId.gen();
    public static final BdUniqueId dqY = BdUniqueId.gen();
    public static final BdUniqueId dqZ = BdUniqueId.gen();
    public static final BdUniqueId dra = BdUniqueId.gen();
    public static final BdUniqueId drb = BdUniqueId.gen();
    public static final BdUniqueId drc = BdUniqueId.gen();
    public static final BdUniqueId drd = BdUniqueId.gen();
    public static final BdUniqueId dre = BdUniqueId.gen();
    public static final BdUniqueId drf = BdUniqueId.gen();
    public static final BdUniqueId drg = BdUniqueId.gen();
    public static final BdUniqueId drh = BdUniqueId.gen();
    public static final BdUniqueId dri = BdUniqueId.gen();
    public static final BdUniqueId drj = BdUniqueId.gen();
    public static final BdUniqueId drk = BdUniqueId.gen();
    public static final BdUniqueId drl = BdUniqueId.gen();
    public static final BdUniqueId drm = BdUniqueId.gen();
    public static AtomicBoolean drn = new AtomicBoolean(false);
    public static AtomicBoolean dro = new AtomicBoolean(false);
    public static AtomicBoolean drp = new AtomicBoolean(false);
    public static final BdUniqueId drq = BdUniqueId.gen();
    public static final BdUniqueId drr = BdUniqueId.gen();
    private static HashMap<Point, Integer> dsu = new HashMap<>();
    private static HashMap<Integer, Integer> dsv = new HashMap<>();
    public static final BdUniqueId dsF = BdUniqueId.gen();
    public static final BdUniqueId dsN = BdUniqueId.gen();
    private static HashMap<Point, Integer> dte = new HashMap<>();
    private static SparseArray<l.a> dtf = new SparseArray<>(3);
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean dqw = false;
    public boolean dqx = false;
    public boolean dqy = false;
    public boolean dqz = false;
    private int drt = 0;
    private String dru = "1";
    public int drv = 1;
    private String drW = null;
    private int dnG = 0;
    public int dsl = 0;
    private String dsm = "";
    public boolean dsn = false;
    private String dsw = "";
    public boolean dta = true;
    public boolean dtg = false;
    public boolean dth = false;
    private int dti = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean dtn = false;
    private int dtw = 0;
    private boolean dtC = false;
    private boolean dtI = false;
    public boolean dtP = false;
    public boolean dtQ = false;
    public boolean forbidComment = false;
    public boolean dub = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int drG = 0;
    private int drH = 0;
    private String last_time = null;
    private long drI = 0;
    private int drJ = 0;
    private int drK = 0;
    private int drL = 0;
    private int drM = 0;
    private bn drN = new bn();
    private MetaData drO = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> drR = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> drS = new ArrayList<>();
    private int drP = 0;
    private int drQ = 0;
    private String ad_url = null;
    private String drx = null;
    private String from = null;
    private int drV = 0;
    private PraiseData drZ = new PraiseData();
    private AnchorInfoData dsa = new AnchorInfoData();
    private long time = 0;
    private int dsd = 0;
    private ArrayList<b> dsp = new ArrayList<>();
    private bv dsq = null;
    private g dsr = null;
    private int dsx = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> dsf = new ArrayList<>();
    private boolean isHeadLive = false;
    private String dsy = null;
    private int dso = 0;
    private boolean dsB = false;
    private boolean dsC = false;
    private int dsD = 0;
    private boolean dsE = false;
    private int anchorLevel = 0;
    public int dsQ = 0;
    public m dsR = new m();
    private List<PbContent> drA = new ArrayList();
    private List<PbContent> dry = new ArrayList();
    private List<PbContent> drz = new ArrayList();
    private String category_name = null;
    private bh dsG = new bh();
    private ArrayList<com.baidu.tbadk.data.c> dsJ = new ArrayList<>();
    private PushStatusData dsK = new PushStatusData();
    public boolean dtb = false;
    public int dtc = -1;
    private PostData dtk = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int dsT = 0;
    public int dtr = 0;
    private String tieba_game_information_source = "";
    public String dtv = "";
    public String dtu = "";
    public String mUrl = "";
    public String dsL = "";

    static {
        dsu.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        dsu.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        dsu.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        dsu.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        dsu.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        dsu.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        dsu.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        dsu.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        dte.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        dte.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        dte.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        dte.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        dte.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        dte.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        dte.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        dte.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        dsv.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        dsv.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        dsv.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        dtf.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        dtf.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        dtf.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.drU = 0;
        this.dse = 0;
        this.dsA = 0L;
        this.dtq = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.dsA = 0L;
        this.dse = 0;
        this.drU = 0;
        this.dtq = 0;
        this.isBigGie = false;
    }

    public String aKa() {
        return this.dtJ;
    }

    public String aKb() {
        return this.dtK;
    }

    public void tT(String str) {
        this.dtK = str;
    }

    public String aKc() {
        return this.dtL;
    }

    public SpannableStringBuilder aKd() {
        return this.drC;
    }

    public SpannableString aKe() {
        return this.dpj;
    }

    public void a(SpannableString spannableString) {
        if (aKC() != null) {
            if (this.drC != null) {
                this.drC.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dpj);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dpj = new SpannableString(spannableStringBuilder);
        }
    }

    public String aKf() {
        return this.dtM;
    }

    public String aKg() {
        return this.dtN;
    }

    public boolean aKh() {
        return this.drU == 1;
    }

    public bh aKi() {
        return this.dsG;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jN(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.dse;
    }

    public void jO(int i) {
        this.dsD = i;
    }

    public int aKj() {
        return this.dsD;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aKk() {
        return this.dtA;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bZ(long j) {
        this.mCreateTime = j;
    }

    public long aKl() {
        return this.dsk;
    }

    public String aKm() {
        return this.dsb;
    }

    public PraiseData aKn() {
        return this.drZ;
    }

    public void a(PraiseData praiseData) {
        this.drZ = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aKo() {
        return this.aQl;
    }

    public void tU(String str) {
        this.aQl = str;
    }

    public String aKp() {
        return this.dru;
    }

    public void tV(String str) {
        this.dru = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jP(int i) {
        this.drt = i;
    }

    public int aKq() {
        return this.drt;
    }

    public String aKr() {
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

    public List<PbContent> aKs() {
        return this.drA;
    }

    public void aF(List<PbContent> list) {
        this.drA = list;
    }

    public void aG(List<PbContent> list) {
        this.dry = list;
    }

    public void aH(List<PbContent> list) {
        this.drz = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void jQ(int i) {
        this.reply_num = i;
    }

    public int aKt() {
        return this.reply_num;
    }

    public int aKu() {
        return this.drH;
    }

    public void jR(int i) {
        this.drH = i;
    }

    public long aKv() {
        return this.drI;
    }

    public void ca(long j) {
        this.drI = j;
    }

    public int aKw() {
        return this.drK;
    }

    public int aKx() {
        return this.drJ;
    }

    public void jS(int i) {
        this.drJ = i;
    }

    public int aKy() {
        return this.drL;
    }

    public void jT(int i) {
        this.drL = i;
    }

    public int aKz() {
        return this.drM;
    }

    public List<PbContent> aKA() {
        return this.dry;
    }

    public bn aKB() {
        return this.drN;
    }

    public MetaData aKC() {
        return this.drO;
    }

    public boolean aKD() {
        return this.is_god != 0;
    }

    public boolean aKE() {
        return this.is_god == 1;
    }

    public boolean aKF() {
        return (this.drO == null || this.drO.getGodUserData() == null || this.drO.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aKG() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.drO = metaData;
    }

    public String aKH() {
        return this.forum_name;
    }

    public void tW(String str) {
        this.forum_name = str;
    }

    public int aKI() {
        return this.drQ;
    }

    public String aKJ() {
        return this.ad_url;
    }

    public int aKK() {
        return this.drV;
    }

    public void jU(int i) {
        this.drV = i;
    }

    public String aKL() {
        return this.drW;
    }

    public void tX(String str) {
        this.drW = str;
    }

    public ArrayList<MediaData> aKM() {
        return this.drR;
    }

    public ArrayList<b> aKN() {
        return this.dsp;
    }

    public void x(ArrayList<b> arrayList) {
        this.dsp = arrayList;
    }

    public bv aKO() {
        return this.dsq;
    }

    public g aKP() {
        return this.dsr;
    }

    public ArrayList<VoiceData.VoiceModel> aKQ() {
        return this.drS;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aKR() {
        return this.drw;
    }

    public void jV(int i) {
        this.drw = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aKS() {
        return this.dsm;
    }

    public VideoInfo aKT() {
        return this.dsg;
    }

    public void a(VideoInfo videoInfo) {
        this.dsg = videoInfo;
    }

    public VideoDesc aKU() {
        return this.dsh;
    }

    public void a(AlaInfoData alaInfoData) {
        this.dsj = alaInfoData;
    }

    public AlaInfoData aKV() {
        return this.dsj;
    }

    public PushStatusData aKW() {
        return this.dsK;
    }

    public SkinInfo aKX() {
        return this.dsM;
    }

    public long aKY() {
        return this.dsZ;
    }

    public boolean aKZ() {
        return this.dta;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIu() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIv() {
        return this.dsY;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIw() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIu().getTid());
        alVar.setFid(aIu().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.dpc = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.dpd = this.dpd;
        alVar.cardType = aMB();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.dsc = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.drU = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.dsk = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.drG = threadInfo.repost_num.intValue();
                this.drH = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.drI = threadInfo.last_time_int.intValue();
                this.drJ = threadInfo.is_top.intValue();
                this.drK = threadInfo.is_membertop.intValue();
                this.drL = threadInfo.is_good.intValue();
                this.drM = threadInfo.is_livepost.intValue();
                this.drN.a(threadInfo.topic);
                this.drO.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.drP = threadInfo.has_commented.intValue();
                this.drQ = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.dsg = threadInfo.video_info;
                this.dsh = threadInfo.video_segment;
                this.dsj = new AlaInfoData();
                this.dsj.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.drV = threadInfo.collect_status.intValue();
                this.drW = threadInfo.collect_mark_pid;
                this.drX = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.drY = threadInfo.thread_type.intValue();
                this.dsb = threadInfo.first_post_id + "";
                this.dsm = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.drw = threadInfo.is_ntitle.intValue();
                this.dsd = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.dtl = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.dse = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.dsS = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.dry = threadInfo.rich_title;
                this.drA = threadInfo.first_post_content;
                this.drz = threadInfo.rich_abstract;
                this.drT = threadInfo.is_godthread_recommend.intValue();
                if ((this.drO == null || this.drO.getUserId() == null || this.drO.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drO = metaData;
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
                this.drx = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.drR.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.dsg = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.dsi = new bq();
                    this.dsi.a(threadInfo.video_channel_info);
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
                        this.drS.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.dsp.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.dsq = new bv();
                    this.dsq.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.dsr = new g();
                    this.dsr.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.dss = new p();
                    this.dss.a(threadInfo.cartoon_info);
                }
                this.drZ.setUserMap(this.userMap);
                this.drZ.parserProtobuf(threadInfo.zan);
                this.dsa.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.drZ.setTitle(this.title);
                } else {
                    this.drZ.setTitle(this.drx);
                }
                this.dsw = threadInfo.livecover_src;
                this.dsx = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.dso = threadInfo.post_num.intValue();
                this.dsA = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.mn(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.vW(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.dsf.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.dsy = noticeInfo.notice;
                    }
                    this.dsD = zhiBoInfoTW.copythread_remind.intValue();
                    this.dsB = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.dsC = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.dsw)) {
                        this.dsw = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.dsH = zhiBoInfoTW.user.tw_anchor_info;
                        this.dsI = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.dsz = threadInfo.twzhibo_info.livecover_status;
                    this.dsA = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.dsE = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.dsG.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.dsJ.add(cVar);
                    }
                }
                this.dsK.parserProtobuf(threadInfo.push_status);
                this.dsP = threadInfo.lego_card;
                this.dsM = threadInfo.skin_info;
                this.dsQ = threadInfo.is_book_chapter.intValue();
                this.dsR.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.dsY = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.dsZ = threadInfo.last_read_pid.longValue();
                this.dta = threadInfo.cheak_repeat.intValue() == 1;
                this.dtd = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.dtk.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.dtj = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.dtm = new ag();
                    this.dtm.a(threadInfo.link_info);
                }
                this.dtn = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.dto = new f();
                    this.dto.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.dtp = new MediaData();
                    this.dtp.parserProtobuf(threadInfo.pic_info);
                }
                this.dsT = threadInfo.is_called.intValue();
                this.dtq = threadInfo.middle_page_num.intValue();
                this.dtr = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.dtu = threadInfo.star_rank_icon.icon_pic_url;
                    this.dtv = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.dtt = new OriginalThreadInfo();
                    this.dtt.a(threadInfo.origin_thread_info);
                } else {
                    this.dtt = null;
                    this.isShareThread = false;
                }
                this.dtw = threadInfo.is_topic.intValue();
                this.dty = threadInfo.topic_user_name;
                this.dtz = threadInfo.topic_h5_url;
                this.dtx = threadInfo.topic_module;
                this.dtB = threadInfo.presentation_style;
                this.dtD = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.dtF = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.drD = new bf();
                    this.drD.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.dtH = threadInfo.swan_info;
                }
                this.dtO = threadInfo.t_share_img;
                this.dtP = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.dtZ = threadInfo.article_cover;
                this.dua = threadInfo.bjh_content_tag.intValue();
                this.dtY = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dub = threadInfo.is_s_card.intValue() == 1;
                this.duc = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                aLa();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
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
                this.dsk = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.drG = jSONObject.optInt("repost_num", 0);
                this.drH = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.drI = jSONObject.optLong("last_time_int", 0L);
                this.drJ = jSONObject.optInt("is_top", 0);
                this.drK = jSONObject.optInt("is_membertop", 0);
                this.drL = jSONObject.optInt("is_good", 0);
                this.drM = jSONObject.optInt("is_livepost", 0);
                this.drN.parserJson(jSONObject.optJSONObject(UgcConstant.TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.drO.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.drP = jSONObject.optInt("has_commented", 0);
                this.drQ = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.drV = jSONObject.optInt("collect_status");
                this.drW = jSONObject.optString("collect_mark_pid");
                this.drX = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.drY = jSONObject.optInt("thread_type");
                this.dtl = jSONObject.optLong("share_num");
                this.dsb = jSONObject.optString("first_post_id", "0");
                this.dsm = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.drw = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.dsG.parserJson(optJSONObject2);
                }
                if ((this.drO == null || this.drO.getUserId() == null) && this.userMap != null) {
                    this.drO = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.dsj = new AlaInfoData();
                this.dsj.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.drx = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.drR.add(mediaData);
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
                        this.drS.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.dsp.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.dsq = new bv();
                    this.dsq.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.dsr = new g();
                    this.dsr.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.dss = new p();
                    this.dss.parserJson(optJSONObject6);
                }
                this.drZ.setUserMap(this.userMap);
                this.drZ.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.dsa.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.drZ.setTitle(this.title);
                } else {
                    this.drZ.setTitle(this.drx);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.dsG.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.dsJ.add(cVar);
                    }
                }
                this.dsQ = jSONObject.optInt("is_book_chapter", 0);
                this.dsR.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.dsY = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.dsU = jSONObject.optString("recom_extra_img");
                this.dsX = jSONObject.optString("recom_extra_img_night");
                this.dsV = jSONObject.optInt("recom_extra_img_width", 0);
                this.dsW = jSONObject.optInt("recom_extra_img_height", 0);
                this.dsZ = jSONObject.optLong("last_read_pid");
                this.dta = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.dsi = new bq();
                    this.dsi.ct(optJSONObject8);
                }
                this.dtj = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.dtm = new ag();
                    this.dtm.parserJson(optJSONObject9);
                }
                this.dtn = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.dto = new f();
                    this.dto.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.dtp = new MediaData();
                    this.dtp.parserJson(optJSONObject11);
                }
                this.dsT = jSONObject.optInt("is_called", 0);
                this.dtq = jSONObject.optInt("middle_page_num", 0);
                this.dtr = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.dsg = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.dtt = new OriginalThreadInfo();
                        this.dtt.parserJson(optJSONObject13);
                    } else {
                        this.dtt = null;
                    }
                } else {
                    this.dtt = null;
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
                    this.dtH = builder2.build(false);
                }
                this.dtO = jSONObject.optString("t_share_img");
                this.dtP = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.dtY = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.dua = jSONObject.optInt("bjh_content_tag");
                this.dtZ = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dub = jSONObject.optInt("is_s_card", 0) == 1;
                this.duc = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                aLa();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aLa() {
        aLb();
        aLc();
        aLe();
        aLf();
        aLg();
        aLh();
        aLi();
    }

    private void aLb() {
        if (!StringUtils.isNull(this.drO.getName_show())) {
            this.dtJ = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.drO.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aLc() {
        if (aMy() || aMr()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cj = com.baidu.tbadk.core.util.aq.cj(j);
                if (com.baidu.tbadk.core.util.aq.uO(cj)) {
                    cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.dtK = cj;
            }
            String str = "";
            if (this.drO != null && this.drO.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.drO.getBaijiahaoInfo().auth_desc)) {
                str = this.drO.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.dtK) && !TextUtils.isEmpty(str)) {
                this.dtK += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.dtK = str;
                return;
            } else {
                return;
            }
        }
        if (aKG()) {
            long aKv = aKv() * 1000;
            if (aKv != 0) {
                this.dtK = com.baidu.tbadk.core.util.aq.cj(aKv);
            }
        } else {
            long aKv2 = 1000 * aKv();
            if (aKv2 != 0) {
                String cj2 = com.baidu.tbadk.core.util.aq.cj(aKv2);
                if (com.baidu.tbadk.core.util.aq.uO(cj2)) {
                    cj2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKv2);
                }
                this.dtK = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + cj2;
            }
        }
        if (!TextUtils.isEmpty(this.dtK) && !TextUtils.isEmpty(getAddress())) {
            this.dtK += " • " + getAddress();
        }
    }

    public void aLd() {
        if (!aMy() && !aMr()) {
            if (!aKG()) {
                long aKv = 1000 * aKv();
                if (aKv != 0) {
                    String cj = com.baidu.tbadk.core.util.aq.cj(aKv);
                    if (com.baidu.tbadk.core.util.aq.uO(cj)) {
                        cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKv);
                    }
                    this.dtK = cj;
                }
            }
            if (!TextUtils.isEmpty(this.dtK) && !TextUtils.isEmpty(getAddress())) {
                this.dtK += " • " + getAddress();
            }
        }
    }

    private void aLe() {
        if (aKV() == null || aKV().share_info == null || aKV().share_info.share_user_count <= 0 || !aLT() || (this.dtq > 0 && this.dtr == 0)) {
            this.dtL = null;
            return;
        }
        int i = aKV().share_info.share_user_count;
        if (i == 1) {
            this.dtL = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.dtL = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aLf() {
        this.drC = aLw();
        com.baidu.tieba.card.l.a(this, this.drC, true);
    }

    private void aLg() {
        this.dpj = aLu();
    }

    private void aLh() {
        this.dtM = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKv() * 1000);
    }

    private void aLi() {
        this.dtN = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKv());
    }

    public SpannableStringBuilder aLj() {
        return this.drB;
    }

    public boolean isTop() {
        return aKx() != 0;
    }

    public int aLk() {
        if (this.dsG != null) {
            long aJV = this.dsG.aJV();
            long aJW = this.dsG.aJW();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aJV) {
                return 1;
            }
            if (currentTimeMillis > aJW) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aLl() {
        if (aLn() && this.dsp.size() >= 1) {
            b bVar = this.dsp.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aIz = bVar.aIz();
            int aIA = bVar.aIA();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aIz) {
                return 4;
            }
            return currentTimeMillis > aIA ? 2 : 1;
        }
        return -1;
    }

    public int aLm() {
        if (!aLn() || this.dsp.size() < 1 || this.dsp.get(0) == null) {
            return -1;
        }
        return this.dsp.get(0).aIy();
    }

    public boolean aLn() {
        return this.dsd == 1;
    }

    public String getActUrl() {
        return (!aLn() || this.dsp.size() < 1 || this.dsp.get(0) == null) ? "" : this.dsp.get(0).getUrl();
    }

    private com.baidu.adp.widget.b tY(String str) {
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

    public SmartApp aLo() {
        return this.dtH;
    }

    private void r(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aLq()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aKx() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aKx() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aKz() == 1 || this.drN.aMJ() != 0) {
                if (aKi() != null && getThreadType() == 41) {
                    if (aLk() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aLH()) {
                Integer num = dsv.get(Integer.valueOf(aLk()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aKy() == 1 && !isTop() && dqZ != getType() && drh != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.dsa != null && this.dsa.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aKI() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = dsu.get(new Point(aLm(), aLl()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aKO() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aKP() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = tY(this.category_name);
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
                Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.drv));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aLr = aLr();
        if (aLr != null) {
            spannableStringBuilder.append((CharSequence) aLr);
        }
        this.drB = spannableStringBuilder;
    }

    public boolean aLp() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aKC() != null) {
            if (aKC().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aKC().getGender() == 2) {
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

    private boolean aLq() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void s(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            t(z, z3);
            return;
        }
        SpannableStringBuilder aLr = aLr();
        if (z) {
            spannableStringBuilder = a(aLr.toString(), aLr, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aLr);
        }
        this.drB = spannableStringBuilder;
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
            if (this.drw == 1) {
                this.drB = a;
                return a;
            }
        } else if (this.drw == 1) {
            this.drB = new SpannableStringBuilder();
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

    public void cz(String str, String str2) {
        this.mUrl = str;
        this.dsL = str2;
    }

    public SpannableStringBuilder aLr() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dry, this.title);
    }

    public SpannableStringBuilder aLs() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.drz, this.drx);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aLt() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.dub) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aLu() {
        SpannableStringBuilder aLs = aLs();
        com.baidu.tieba.card.l.a(this, aLs, false);
        return new SpannableString(aLs);
    }

    public SpannableString aLv() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.drA)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.drA, this.drx));
    }

    public String getAbstract() {
        return this.drx;
    }

    public void tZ(String str) {
        this.drx = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aLr;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.drw == 1) {
            aLr = aLs();
            spannableStringBuilder = aLr.toString();
        } else {
            aLr = aLr();
            spannableStringBuilder = aLr.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aLr, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aLr);
        }
        this.drB = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder t(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder u(boolean z, boolean z2) {
        SpannableStringBuilder aLs;
        if (!StringUtils.isNull(this.title) && this.drw != 1) {
            aLs = aLr();
        } else {
            aLs = aLs();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aLs);
        this.drB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aLw() {
        if (StringUtils.isNull(this.title) || this.drw == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aLr());
        this.drB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aJo() {
        if (this.dry != null && this.dry.size() > 0) {
            int size = this.dry.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.dry.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aJp() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.xf(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aLx() {
        r(false, false);
    }

    public void aLy() {
        r(false, true);
    }

    public AnchorInfoData aLz() {
        return this.dsa;
    }

    public boolean aLA() {
        return this.threadType == 36;
    }

    public boolean aJp() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aLB() {
        return this.threadType == 11 || this.drX == 1;
    }

    public boolean aLC() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aKM = aKM();
        if (aKM == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aKM.size() || i2 >= 3) {
                break;
            }
            if (aKM.get(i2) != null && aKM.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aKM.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aKM.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aKM.get(i2).getPicUrl();
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
        if (this.dsg != null && !StringUtils.isNull(this.dsg.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.dsg.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.drO != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.drO.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aLD() {
        String userId;
        return this.drO == null || (userId = this.drO.getUserId()) == null || userId.equals("0");
    }

    public boolean aLE() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aMo()) {
            if (aKT() != null) {
                return dqZ;
            }
            return dqI;
        }
        int aKx = aKx();
        if (this.dtw == 1) {
            if (this.dtx != null) {
                return dqU;
            }
            return this.dtA != null ? drj : dri;
        } else if (this.dsj != null && this.threadType == 60) {
            return drc;
        } else {
            if (this.dsj != null && this.threadType == 49) {
                return dra;
            }
            if (this.threadType == 51) {
                return drb;
            }
            if (this.threadType == 63) {
                return drk;
            }
            if (this.threadType == 64) {
                return drl;
            }
            if (aKx == 2 || aKx == 1) {
                return dqH;
            }
            if (this.dsg != null && aLM() && !aLE()) {
                return drq;
            }
            if (this.dsg != null && !aLE()) {
                if (aKF()) {
                    return drh;
                }
                return dqZ;
            } else if (this.isShareThread && this.dtt != null) {
                if (this.dtt.dpk) {
                    if (this.dtt.videoInfo != null) {
                        return drg;
                    }
                    if (this.dtt.aJr()) {
                        return drf;
                    }
                    return dre;
                }
                return drd;
            } else if (aJr()) {
                return dqV;
            } else {
                if (aLG()) {
                    return drn.get() ? dsF : dqI;
                } else if (aLn() && aLm() == 1) {
                    return drn.get() ? dsN : dqI;
                } else if (isLinkThread()) {
                    return dqX;
                } else {
                    if (aKF()) {
                        return dqY;
                    }
                    if (this.dqs) {
                        return dqM;
                    }
                    if (this.dqt) {
                        return dqN;
                    }
                    if (this.dqu) {
                        return dqO;
                    }
                    if (this.dqv) {
                        return dqP;
                    }
                    if (this.dqw) {
                        return dqQ;
                    }
                    if (this.dqy) {
                        return dqS;
                    }
                    if (this.dqz) {
                        return dqT;
                    }
                    if (this.dqx) {
                        return dqR;
                    }
                    if (this.dsn) {
                        int aLF = aLF();
                        if (aLF == 1) {
                            return dqJ;
                        }
                        if (aLF == 2) {
                            return dqK;
                        }
                        if (aLF > 2) {
                            return dqL;
                        }
                        return dqI;
                    }
                    return dqI;
                }
            }
        }
    }

    public int aLF() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.aIc().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aKM()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aKM().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aLG() {
        return aKi() != null && getThreadType() == 41 && aKz() == 1 && aLk() == 2;
    }

    public void y(ArrayList<q> arrayList) {
        if (this.drw == 1) {
            this.dnG = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dnG = 0;
        } else {
            this.dnG = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.aIJ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aIJ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dnG = next.aIK();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aLH() {
        return this.threadType == 41;
    }

    public boolean aLI() {
        return this.dsO;
    }

    public void gx(boolean z) {
        this.dsO = z;
    }

    public String aLJ() {
        return this.dsP;
    }

    public p aLK() {
        return this.dss;
    }

    public void aLL() {
        if (this.dsl == 0) {
            this.dsl = 1;
        }
    }

    public void gy(boolean z) {
        this.dtb = z;
    }

    public boolean aLM() {
        return this.dtb;
    }

    public void jW(int i) {
        this.dtc = i + 1;
    }

    public int aLN() {
        return this.dtc;
    }

    public boolean aLO() {
        return this.dtR;
    }

    public void gz(boolean z) {
        this.dtR = z;
    }

    public bq aLP() {
        return this.dsi;
    }

    public boolean aLQ() {
        return getThreadType() == 49;
    }

    public boolean aLR() {
        return getThreadType() == 40;
    }

    public boolean aLS() {
        return getThreadType() == 50;
    }

    public boolean aLT() {
        return getThreadType() == 60;
    }

    public int aLU() {
        return this.dti;
    }

    public void setSmartFrsPosition(int i) {
        this.dti = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aLV() {
        return this.mRecomSource;
    }

    public boolean aLW() {
        return this.dtj;
    }

    public long aLX() {
        return this.agreeData.agreeNum;
    }

    public long aLY() {
        return this.agreeData.disAgreeNum;
    }

    public int aLZ() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aMa() {
        return this.agreeData.agreeType;
    }

    public void jX(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void jY(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cb(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cc(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void jZ(int i) {
        this.agreeData.agreeType = i;
    }

    public long aMb() {
        return this.dtl;
    }

    public void cd(long j) {
        this.dtl = j;
    }

    public PostData aMc() {
        return this.dtk;
    }

    public ag aMd() {
        return this.dtm;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean aKD = aKD();
        if (z2) {
            if (z) {
                if (aKD && !aJp()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (aKz() == 1 || getThreadType() == 33 || (aKB() != null && aKB().aMJ() != 0)) {
                    if (aKi() != null && aLH()) {
                        if (aLk() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!aKD) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aLH()) {
                    arrayList.add(dtf.get(aLk()));
                }
                if (aLn()) {
                    Integer num = dte.get(new Point(aLm(), aLl()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aKO() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (aKD && aKx() != 1 && !aJp()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((aKz() == 1 || getThreadType() == 33) && !aLH() && !aKD) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (aKy() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (aKx() == 1) {
                    arrayList.add(new l.a((int) R.string.f1279top));
                }
                if (aLH() && aKi() != null && aLk() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aLn()) {
                    Integer num2 = dte.get(new Point(aLm(), aLl()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.dsQ == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aKP() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aKO() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aLQ()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aLS()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aLR()) {
                    arrayList.add(new l.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new l.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void z(ArrayList<MediaData> arrayList) {
        this.drR = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.drS = arrayList;
    }

    public String aMe() {
        return this.dty;
    }

    public void ua(String str) {
        this.dty = str;
    }

    public void aMf() {
        this.dtw = 1;
    }

    public boolean aMg() {
        return this.dtw == 1;
    }

    public boolean aMh() {
        return "worldcupvideo".equals(this.dtB);
    }

    public String aMi() {
        return this.drE;
    }

    public void ub(String str) {
        this.drE = str;
    }

    public String aMj() {
        return this.drF;
    }

    public void uc(String str) {
        this.drF = str;
    }

    public String aMk() {
        return this.dtz;
    }

    public void ud(String str) {
        this.dtz = str;
    }

    public boolean aMl() {
        return this.dtC;
    }

    public void gA(boolean z) {
        this.dtC = z;
    }

    public void b(VideoInfo videoInfo) {
        this.dtA = videoInfo;
    }

    public boolean aMm() {
        return this.dtD != null;
    }

    public bf aMn() {
        return this.drD;
    }

    public void a(bf bfVar) {
        this.drD = bfVar;
    }

    public boolean aMo() {
        return this.dtG;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dsg != null) {
            return this.dsg.video_url;
        }
        return null;
    }

    public boolean aMp() {
        return this.dtI;
    }

    public void gB(boolean z) {
        this.dtI = z;
    }

    public AgreeData aMq() {
        return this.agreeData;
    }

    public boolean aMr() {
        return this.dtS;
    }

    public void gC(boolean z) {
        this.dtS = z;
    }

    public boolean aMs() {
        return this.dtT;
    }

    public void gD(boolean z) {
        this.dtT = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aMt() {
        return this.dtx;
    }

    public String getShareImageUrl() {
        return this.dtO;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aKM = aKM();
        if (com.baidu.tbadk.core.i.aIc().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKM) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aKM.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM, 0);
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

    public int[] aMu() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aKM = aKM();
        if (com.baidu.tbadk.core.i.aIc().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKM) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aKM.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKM, 0);
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

    public boolean aMv() {
        return aMw() || aMx();
    }

    public boolean aJr() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aJs() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aMw() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aMx() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aMy() {
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
        return aMy();
    }

    public void ka(int i) {
        this.dtY = i;
    }

    public int aMz() {
        return this.dua;
    }

    public String aMA() {
        return this.dtZ;
    }

    public void ue(String str) {
        this.dtZ = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aMB() {
        if (aKE()) {
            return 4;
        }
        if (aLQ() || aLS()) {
            return 3;
        }
        if (aJr()) {
            return 5;
        }
        if (aJs()) {
            return 6;
        }
        if (aMw()) {
            return 7;
        }
        if (aMx()) {
            return 8;
        }
        if (this.isShareThread && this.dtt != null) {
            return 9;
        }
        if (aLR()) {
            return 2;
        }
        return 1;
    }

    public int aMC() {
        if (aMx() || aMw()) {
            return 2;
        }
        if (aJr() || aJs()) {
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
}

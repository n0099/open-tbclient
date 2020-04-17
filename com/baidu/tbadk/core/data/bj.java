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
    private String aQf;
    private String address;
    private String authorId;
    public int doZ;
    private SpannableString dpf;
    private String drA;
    private String drB;
    public int drP;
    private int drQ;
    private int drT;
    public int drU;
    private String drX;
    private String drY;
    private int drr;
    private SpannableStringBuilder drx;
    private SpannableStringBuilder dry;
    private bf drz;
    public TwZhiBoUser dsD;
    public List<TwAnchorProfitItem> dsE;
    private SkinInfo dsI;
    private boolean dsK;
    private String dsL;
    private boolean dsO;
    public String dsQ;
    public int dsR;
    public int dsS;
    public String dsT;
    public String dsU;
    public long dsV;
    private List<ReportInfo> dsZ;
    private int dsa;
    private VideoInfo dsc;
    private VideoDesc dsd;
    private bq dse;
    private AlaInfoData dsf;
    private long dsg;
    private p dso;
    private LiveCoverStatus dsv;
    private long dsw;
    public boolean dtA;
    private String dtB;
    private boolean dtC;
    private SmartApp dtD;
    private String dtF;
    private String dtG;
    private String dtH;
    private String dtI;
    private String dtJ;
    public String dtK;
    private boolean dtN;
    private boolean dtO;
    private boolean dtP;
    public boolean dtQ;
    public boolean dtR;
    public boolean dtS;
    public String dtT;
    private int dtU;
    private String dtV;
    private int dtW;
    public String dtY;
    private boolean dtf;
    private long dth;
    private ag dti;
    public f dtk;
    private MediaData dtl;
    public int dtm;
    public OriginalThreadInfo dto;
    private TopicModule dtt;
    private String dtu;
    private String dtv;
    private VideoInfo dtw;
    private String dtx;
    public OriginalForumInfo dtz;
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
    public static final BdUniqueId dqD = BdUniqueId.gen();
    public static final BdUniqueId dqE = BdUniqueId.gen();
    public static final BdUniqueId dqF = BdUniqueId.gen();
    public static final BdUniqueId dqG = BdUniqueId.gen();
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
    public static AtomicBoolean drj = new AtomicBoolean(false);
    public static AtomicBoolean drk = new AtomicBoolean(false);
    public static AtomicBoolean drl = new AtomicBoolean(false);
    public static final BdUniqueId drm = BdUniqueId.gen();
    public static final BdUniqueId drn = BdUniqueId.gen();
    private static HashMap<Point, Integer> dsp = new HashMap<>();
    private static HashMap<Integer, Integer> dsq = new HashMap<>();
    public static final BdUniqueId dsB = BdUniqueId.gen();
    public static final BdUniqueId dsJ = BdUniqueId.gen();
    private static HashMap<Point, Integer> dta = new HashMap<>();
    private static SparseArray<l.a> dtb = new SparseArray<>(3);
    public boolean dqo = false;
    public boolean dqp = false;
    public boolean dqq = false;
    public boolean dqr = false;
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean dqu = false;
    public boolean dqv = false;
    private int dro = 0;
    private String drp = "1";
    public int drq = 1;
    private String drS = null;
    private int dnC = 0;
    public int dsh = 0;
    private String dsi = "";
    public boolean dsj = false;
    private String dsr = "";
    public boolean dsW = true;
    public boolean dtc = false;
    public boolean dtd = false;
    private int dte = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean dtj = false;
    private int dtr = 0;
    private boolean dty = false;
    private boolean dtE = false;
    public boolean dtL = false;
    public boolean dtM = false;
    public boolean forbidComment = false;
    public boolean dtX = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int drC = 0;
    private int drD = 0;
    private String last_time = null;
    private long drE = 0;
    private int drF = 0;
    private int drG = 0;
    private int drH = 0;
    private int drI = 0;
    private bn drJ = new bn();
    private MetaData drK = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> drN = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> drO = new ArrayList<>();
    private int drL = 0;
    private int drM = 0;
    private String ad_url = null;
    private String drt = null;
    private String from = null;
    private int drR = 0;
    private PraiseData drV = new PraiseData();
    private AnchorInfoData drW = new AnchorInfoData();
    private long time = 0;
    private int drZ = 0;
    private ArrayList<b> dsl = new ArrayList<>();
    private bv dsm = null;
    private g dsn = null;
    private int dss = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> dsb = new ArrayList<>();
    private boolean isHeadLive = false;
    private String dsu = null;
    private int dsk = 0;
    private boolean dsx = false;
    private boolean dsy = false;
    private int dsz = 0;
    private boolean dsA = false;
    private int anchorLevel = 0;
    public int dsM = 0;
    public m dsN = new m();
    private List<PbContent> drw = new ArrayList();
    private List<PbContent> dru = new ArrayList();
    private List<PbContent> drv = new ArrayList();
    private String category_name = null;
    private bh dsC = new bh();
    private ArrayList<com.baidu.tbadk.data.c> dsF = new ArrayList<>();
    private PushStatusData dsG = new PushStatusData();
    public boolean dsX = false;
    public int dsY = -1;
    private PostData dtg = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int dsP = 0;
    public int dtn = 0;
    private String tieba_game_information_source = "";
    public String dtq = "";
    public String dtp = "";
    public String mUrl = "";
    public String dsH = "";

    static {
        dsp.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        dsp.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        dsp.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        dsp.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        dsp.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        dsp.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        dsp.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        dsp.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        dta.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        dta.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        dta.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        dta.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        dta.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        dta.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        dta.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        dta.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        dsq.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        dsq.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        dsq.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        dtb.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        dtb.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        dtb.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.drQ = 0;
        this.dsa = 0;
        this.dsw = 0L;
        this.dtm = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.dsw = 0L;
        this.dsa = 0;
        this.drQ = 0;
        this.dtm = 0;
        this.isBigGie = false;
    }

    public String aKc() {
        return this.dtF;
    }

    public String aKd() {
        return this.dtG;
    }

    public void tQ(String str) {
        this.dtG = str;
    }

    public String aKe() {
        return this.dtH;
    }

    public SpannableStringBuilder aKf() {
        return this.dry;
    }

    public SpannableString aKg() {
        return this.dpf;
    }

    public void a(SpannableString spannableString) {
        if (aKE() != null) {
            if (this.dry != null) {
                this.dry.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dpf);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dpf = new SpannableString(spannableStringBuilder);
        }
    }

    public String aKh() {
        return this.dtI;
    }

    public String aKi() {
        return this.dtJ;
    }

    public boolean aKj() {
        return this.drQ == 1;
    }

    public bh aKk() {
        return this.dsC;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jN(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.dsa;
    }

    public void jO(int i) {
        this.dsz = i;
    }

    public int aKl() {
        return this.dsz;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aKm() {
        return this.dtw;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bZ(long j) {
        this.mCreateTime = j;
    }

    public long aKn() {
        return this.dsg;
    }

    public String aKo() {
        return this.drX;
    }

    public PraiseData aKp() {
        return this.drV;
    }

    public void a(PraiseData praiseData) {
        this.drV = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aKq() {
        return this.aQf;
    }

    public void tR(String str) {
        this.aQf = str;
    }

    public String aKr() {
        return this.drp;
    }

    public void tS(String str) {
        this.drp = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jP(int i) {
        this.dro = i;
    }

    public int aKs() {
        return this.dro;
    }

    public String aKt() {
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

    public List<PbContent> aKu() {
        return this.drw;
    }

    public void aF(List<PbContent> list) {
        this.drw = list;
    }

    public void aG(List<PbContent> list) {
        this.dru = list;
    }

    public void aH(List<PbContent> list) {
        this.drv = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void jQ(int i) {
        this.reply_num = i;
    }

    public int aKv() {
        return this.reply_num;
    }

    public int aKw() {
        return this.drD;
    }

    public void jR(int i) {
        this.drD = i;
    }

    public long aKx() {
        return this.drE;
    }

    public void ca(long j) {
        this.drE = j;
    }

    public int aKy() {
        return this.drG;
    }

    public int aKz() {
        return this.drF;
    }

    public void jS(int i) {
        this.drF = i;
    }

    public int aKA() {
        return this.drH;
    }

    public void jT(int i) {
        this.drH = i;
    }

    public int aKB() {
        return this.drI;
    }

    public List<PbContent> aKC() {
        return this.dru;
    }

    public bn aKD() {
        return this.drJ;
    }

    public MetaData aKE() {
        return this.drK;
    }

    public boolean aKF() {
        return this.is_god != 0;
    }

    public boolean aKG() {
        return this.is_god == 1;
    }

    public boolean aKH() {
        return (this.drK == null || this.drK.getGodUserData() == null || this.drK.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aKI() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.drK = metaData;
    }

    public String aKJ() {
        return this.forum_name;
    }

    public void tT(String str) {
        this.forum_name = str;
    }

    public int aKK() {
        return this.drM;
    }

    public String aKL() {
        return this.ad_url;
    }

    public int aKM() {
        return this.drR;
    }

    public void jU(int i) {
        this.drR = i;
    }

    public String aKN() {
        return this.drS;
    }

    public void tU(String str) {
        this.drS = str;
    }

    public ArrayList<MediaData> aKO() {
        return this.drN;
    }

    public ArrayList<b> aKP() {
        return this.dsl;
    }

    public void x(ArrayList<b> arrayList) {
        this.dsl = arrayList;
    }

    public bv aKQ() {
        return this.dsm;
    }

    public g aKR() {
        return this.dsn;
    }

    public ArrayList<VoiceData.VoiceModel> aKS() {
        return this.drO;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aKT() {
        return this.drr;
    }

    public void jV(int i) {
        this.drr = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aKU() {
        return this.dsi;
    }

    public VideoInfo aKV() {
        return this.dsc;
    }

    public void a(VideoInfo videoInfo) {
        this.dsc = videoInfo;
    }

    public VideoDesc aKW() {
        return this.dsd;
    }

    public void a(AlaInfoData alaInfoData) {
        this.dsf = alaInfoData;
    }

    public AlaInfoData aKX() {
        return this.dsf;
    }

    public PushStatusData aKY() {
        return this.dsG;
    }

    public SkinInfo aKZ() {
        return this.dsI;
    }

    public long aLa() {
        return this.dsV;
    }

    public boolean aLb() {
        return this.dsW;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIw() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIx() {
        return this.dsU;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIy() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIw().getTid());
        alVar.setFid(aIw().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.doY = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.doZ = this.doZ;
        alVar.cardType = aMD();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.drY = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.drQ = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.dsg = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.drC = threadInfo.repost_num.intValue();
                this.drD = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.drE = threadInfo.last_time_int.intValue();
                this.drF = threadInfo.is_top.intValue();
                this.drG = threadInfo.is_membertop.intValue();
                this.drH = threadInfo.is_good.intValue();
                this.drI = threadInfo.is_livepost.intValue();
                this.drJ.a(threadInfo.topic);
                this.drK.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.drL = threadInfo.has_commented.intValue();
                this.drM = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.dsc = threadInfo.video_info;
                this.dsd = threadInfo.video_segment;
                this.dsf = new AlaInfoData();
                this.dsf.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.drR = threadInfo.collect_status.intValue();
                this.drS = threadInfo.collect_mark_pid;
                this.drT = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.drU = threadInfo.thread_type.intValue();
                this.drX = threadInfo.first_post_id + "";
                this.dsi = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.drr = threadInfo.is_ntitle.intValue();
                this.drZ = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.dth = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.dsa = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.dsO = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.dru = threadInfo.rich_title;
                this.drw = threadInfo.first_post_content;
                this.drv = threadInfo.rich_abstract;
                this.drP = threadInfo.is_godthread_recommend.intValue();
                if ((this.drK == null || this.drK.getUserId() == null || this.drK.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.drK = metaData;
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
                this.drt = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.drN.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.dsc = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.dse = new bq();
                    this.dse.a(threadInfo.video_channel_info);
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
                        this.drO.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.dsl.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.dsm = new bv();
                    this.dsm.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.dsn = new g();
                    this.dsn.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.dso = new p();
                    this.dso.a(threadInfo.cartoon_info);
                }
                this.drV.setUserMap(this.userMap);
                this.drV.parserProtobuf(threadInfo.zan);
                this.drW.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.drV.setTitle(this.title);
                } else {
                    this.drV.setTitle(this.drt);
                }
                this.dsr = threadInfo.livecover_src;
                this.dss = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.dsk = threadInfo.post_num.intValue();
                this.dsw = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.mn(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.vT(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.dsb.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.dsu = noticeInfo.notice;
                    }
                    this.dsz = zhiBoInfoTW.copythread_remind.intValue();
                    this.dsx = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.dsy = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.dsr)) {
                        this.dsr = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.dsD = zhiBoInfoTW.user.tw_anchor_info;
                        this.dsE = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.dsv = threadInfo.twzhibo_info.livecover_status;
                    this.dsw = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.dsA = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.dsC.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.dsF.add(cVar);
                    }
                }
                this.dsG.parserProtobuf(threadInfo.push_status);
                this.dsL = threadInfo.lego_card;
                this.dsI = threadInfo.skin_info;
                this.dsM = threadInfo.is_book_chapter.intValue();
                this.dsN.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.dsU = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.dsV = threadInfo.last_read_pid.longValue();
                this.dsW = threadInfo.cheak_repeat.intValue() == 1;
                this.dsZ = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.dtg.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.dtf = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.dti = new ag();
                    this.dti.a(threadInfo.link_info);
                }
                this.dtj = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.dtk = new f();
                    this.dtk.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.dtl = new MediaData();
                    this.dtl.parserProtobuf(threadInfo.pic_info);
                }
                this.dsP = threadInfo.is_called.intValue();
                this.dtm = threadInfo.middle_page_num.intValue();
                this.dtn = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.dtp = threadInfo.star_rank_icon.icon_pic_url;
                    this.dtq = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.dto = new OriginalThreadInfo();
                    this.dto.a(threadInfo.origin_thread_info);
                } else {
                    this.dto = null;
                    this.isShareThread = false;
                }
                this.dtr = threadInfo.is_topic.intValue();
                this.dtu = threadInfo.topic_user_name;
                this.dtv = threadInfo.topic_h5_url;
                this.dtt = threadInfo.topic_module;
                this.dtx = threadInfo.presentation_style;
                this.dtz = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.dtB = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.drz = new bf();
                    this.drz.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.dtD = threadInfo.swan_info;
                }
                this.dtK = threadInfo.t_share_img;
                this.dtL = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.dtV = threadInfo.article_cover;
                this.dtW = threadInfo.bjh_content_tag.intValue();
                this.dtU = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dtX = threadInfo.is_s_card.intValue() == 1;
                this.dtY = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                aLc();
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
                this.dsg = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.drC = jSONObject.optInt("repost_num", 0);
                this.drD = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.drE = jSONObject.optLong("last_time_int", 0L);
                this.drF = jSONObject.optInt("is_top", 0);
                this.drG = jSONObject.optInt("is_membertop", 0);
                this.drH = jSONObject.optInt("is_good", 0);
                this.drI = jSONObject.optInt("is_livepost", 0);
                this.drJ.parserJson(jSONObject.optJSONObject(UgcConstant.TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.drK.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.drL = jSONObject.optInt("has_commented", 0);
                this.drM = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.drR = jSONObject.optInt("collect_status");
                this.drS = jSONObject.optString("collect_mark_pid");
                this.drT = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.drU = jSONObject.optInt("thread_type");
                this.dth = jSONObject.optLong("share_num");
                this.drX = jSONObject.optString("first_post_id", "0");
                this.dsi = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.drr = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.dsC.parserJson(optJSONObject2);
                }
                if ((this.drK == null || this.drK.getUserId() == null) && this.userMap != null) {
                    this.drK = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.dsf = new AlaInfoData();
                this.dsf.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.drt = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.drN.add(mediaData);
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
                        this.drO.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.dsl.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.dsm = new bv();
                    this.dsm.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.dsn = new g();
                    this.dsn.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.dso = new p();
                    this.dso.parserJson(optJSONObject6);
                }
                this.drV.setUserMap(this.userMap);
                this.drV.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.drW.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.drV.setTitle(this.title);
                } else {
                    this.drV.setTitle(this.drt);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.dsC.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.dsF.add(cVar);
                    }
                }
                this.dsM = jSONObject.optInt("is_book_chapter", 0);
                this.dsN.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.dsU = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.dsQ = jSONObject.optString("recom_extra_img");
                this.dsT = jSONObject.optString("recom_extra_img_night");
                this.dsR = jSONObject.optInt("recom_extra_img_width", 0);
                this.dsS = jSONObject.optInt("recom_extra_img_height", 0);
                this.dsV = jSONObject.optLong("last_read_pid");
                this.dsW = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.dse = new bq();
                    this.dse.ct(optJSONObject8);
                }
                this.dtf = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.dti = new ag();
                    this.dti.parserJson(optJSONObject9);
                }
                this.dtj = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.dtk = new f();
                    this.dtk.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.dtl = new MediaData();
                    this.dtl.parserJson(optJSONObject11);
                }
                this.dsP = jSONObject.optInt("is_called", 0);
                this.dtm = jSONObject.optInt("middle_page_num", 0);
                this.dtn = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.dsc = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.dto = new OriginalThreadInfo();
                        this.dto.parserJson(optJSONObject13);
                    } else {
                        this.dto = null;
                    }
                } else {
                    this.dto = null;
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
                    this.dtD = builder2.build(false);
                }
                this.dtK = jSONObject.optString("t_share_img");
                this.dtL = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.dtU = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.dtW = jSONObject.optInt("bjh_content_tag");
                this.dtV = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dtX = jSONObject.optInt("is_s_card", 0) == 1;
                this.dtY = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                aLc();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aLc() {
        aLd();
        aLe();
        aLg();
        aLh();
        aLi();
        aLj();
        aLk();
    }

    private void aLd() {
        if (!StringUtils.isNull(this.drK.getName_show())) {
            this.dtF = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.drK.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aLe() {
        if (aMA() || aMt()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cj = com.baidu.tbadk.core.util.aq.cj(j);
                if (com.baidu.tbadk.core.util.aq.uL(cj)) {
                    cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.dtG = cj;
            }
            String str = "";
            if (this.drK != null && this.drK.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.drK.getBaijiahaoInfo().auth_desc)) {
                str = this.drK.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.dtG) && !TextUtils.isEmpty(str)) {
                this.dtG += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.dtG = str;
                return;
            } else {
                return;
            }
        }
        if (aKI()) {
            long aKx = aKx() * 1000;
            if (aKx != 0) {
                this.dtG = com.baidu.tbadk.core.util.aq.cj(aKx);
            }
        } else {
            long aKx2 = 1000 * aKx();
            if (aKx2 != 0) {
                String cj2 = com.baidu.tbadk.core.util.aq.cj(aKx2);
                if (com.baidu.tbadk.core.util.aq.uL(cj2)) {
                    cj2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKx2);
                }
                this.dtG = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + cj2;
            }
        }
        if (!TextUtils.isEmpty(this.dtG) && !TextUtils.isEmpty(getAddress())) {
            this.dtG += " • " + getAddress();
        }
    }

    public void aLf() {
        if (!aMA() && !aMt()) {
            if (!aKI()) {
                long aKx = 1000 * aKx();
                if (aKx != 0) {
                    String cj = com.baidu.tbadk.core.util.aq.cj(aKx);
                    if (com.baidu.tbadk.core.util.aq.uL(cj)) {
                        cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKx);
                    }
                    this.dtG = cj;
                }
            }
            if (!TextUtils.isEmpty(this.dtG) && !TextUtils.isEmpty(getAddress())) {
                this.dtG += " • " + getAddress();
            }
        }
    }

    private void aLg() {
        if (aKX() == null || aKX().share_info == null || aKX().share_info.share_user_count <= 0 || !aLV() || (this.dtm > 0 && this.dtn == 0)) {
            this.dtH = null;
            return;
        }
        int i = aKX().share_info.share_user_count;
        if (i == 1) {
            this.dtH = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.dtH = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aLh() {
        this.dry = aLy();
        com.baidu.tieba.card.l.a(this, this.dry, true);
    }

    private void aLi() {
        this.dpf = aLw();
    }

    private void aLj() {
        this.dtI = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKx() * 1000);
    }

    private void aLk() {
        this.dtJ = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aKx());
    }

    public SpannableStringBuilder aLl() {
        return this.drx;
    }

    public boolean isTop() {
        return aKz() != 0;
    }

    public int aLm() {
        if (this.dsC != null) {
            long aJX = this.dsC.aJX();
            long aJY = this.dsC.aJY();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aJX) {
                return 1;
            }
            if (currentTimeMillis > aJY) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aLn() {
        if (aLp() && this.dsl.size() >= 1) {
            b bVar = this.dsl.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aIB = bVar.aIB();
            int aIC = bVar.aIC();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aIB) {
                return 4;
            }
            return currentTimeMillis > aIC ? 2 : 1;
        }
        return -1;
    }

    public int aLo() {
        if (!aLp() || this.dsl.size() < 1 || this.dsl.get(0) == null) {
            return -1;
        }
        return this.dsl.get(0).aIA();
    }

    public boolean aLp() {
        return this.drZ == 1;
    }

    public String getActUrl() {
        return (!aLp() || this.dsl.size() < 1 || this.dsl.get(0) == null) ? "" : this.dsl.get(0).getUrl();
    }

    private com.baidu.adp.widget.b tV(String str) {
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

    public SmartApp aLq() {
        return this.dtD;
    }

    private void r(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aLs()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aKz() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aKz() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aKB() == 1 || this.drJ.aML() != 0) {
                if (aKk() != null && getThreadType() == 41) {
                    if (aLm() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aLJ()) {
                Integer num = dsq.get(Integer.valueOf(aLm()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aKA() == 1 && !isTop() && dqV != getType() && drd != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.drW != null && this.drW.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aKK() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = dsp.get(new Point(aLo(), aLn()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aKQ() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aKR() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = tV(this.category_name);
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
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.drq));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aLt = aLt();
        if (aLt != null) {
            spannableStringBuilder.append((CharSequence) aLt);
        }
        this.drx = spannableStringBuilder;
    }

    public boolean aLr() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aKE() != null) {
            if (aKE().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aKE().getGender() == 2) {
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

    private boolean aLs() {
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
        SpannableStringBuilder aLt = aLt();
        if (z) {
            spannableStringBuilder = a(aLt.toString(), aLt, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aLt);
        }
        this.drx = spannableStringBuilder;
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
            if (this.drr == 1) {
                this.drx = a;
                return a;
            }
        } else if (this.drr == 1) {
            this.drx = new SpannableStringBuilder();
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
        this.dsH = str2;
    }

    public SpannableStringBuilder aLt() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dru, this.title);
    }

    public SpannableStringBuilder aLu() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.drv, this.drt);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aLv() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.dtX) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aLw() {
        SpannableStringBuilder aLu = aLu();
        com.baidu.tieba.card.l.a(this, aLu, false);
        return new SpannableString(aLu);
    }

    public SpannableString aLx() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.drw)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.drw, this.drt));
    }

    public String getAbstract() {
        return this.drt;
    }

    public void tW(String str) {
        this.drt = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aLt;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.drr == 1) {
            aLt = aLu();
            spannableStringBuilder = aLt.toString();
        } else {
            aLt = aLt();
            spannableStringBuilder = aLt.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aLt, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aLt);
        }
        this.drx = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder t(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder u(boolean z, boolean z2) {
        SpannableStringBuilder aLu;
        if (!StringUtils.isNull(this.title) && this.drr != 1) {
            aLu = aLt();
        } else {
            aLu = aLu();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aLu);
        this.drx = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aLy() {
        if (StringUtils.isNull(this.title) || this.drr == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aLt());
        this.drx = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aJq() {
        if (this.dru != null && this.dru.size() > 0) {
            int size = this.dru.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.dru.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aJr() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.xc(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aLz() {
        r(false, false);
    }

    public void aLA() {
        r(false, true);
    }

    public AnchorInfoData aLB() {
        return this.drW;
    }

    public boolean aLC() {
        return this.threadType == 36;
    }

    public boolean aJr() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aLD() {
        return this.threadType == 11 || this.drT == 1;
    }

    public boolean aLE() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aKO = aKO();
        if (aKO == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aKO.size() || i2 >= 3) {
                break;
            }
            if (aKO.get(i2) != null && aKO.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aKO.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aKO.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aKO.get(i2).getPicUrl();
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
        if (this.dsc != null && !StringUtils.isNull(this.dsc.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.dsc.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.drK != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.drK.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aLF() {
        String userId;
        return this.drK == null || (userId = this.drK.getUserId()) == null || userId.equals("0");
    }

    public boolean aLG() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aMq()) {
            if (aKV() != null) {
                return dqV;
            }
            return dqE;
        }
        int aKz = aKz();
        if (this.dtr == 1) {
            if (this.dtt != null) {
                return dqQ;
            }
            return this.dtw != null ? drf : dre;
        } else if (this.dsf != null && this.threadType == 60) {
            return dqY;
        } else {
            if (this.dsf != null && this.threadType == 49) {
                return dqW;
            }
            if (this.threadType == 51) {
                return dqX;
            }
            if (this.threadType == 63) {
                return drg;
            }
            if (this.threadType == 64) {
                return drh;
            }
            if (aKz == 2 || aKz == 1) {
                return dqD;
            }
            if (this.dsc != null && aLO() && !aLG()) {
                return drm;
            }
            if (this.dsc != null && !aLG()) {
                if (aKH()) {
                    return drd;
                }
                return dqV;
            } else if (this.isShareThread && this.dto != null) {
                if (this.dto.dpg) {
                    if (this.dto.videoInfo != null) {
                        return drc;
                    }
                    if (this.dto.aJt()) {
                        return drb;
                    }
                    return dra;
                }
                return dqZ;
            } else if (aJt()) {
                return dqR;
            } else {
                if (aLI()) {
                    return drj.get() ? dsB : dqE;
                } else if (aLp() && aLo() == 1) {
                    return drj.get() ? dsJ : dqE;
                } else if (isLinkThread()) {
                    return dqT;
                } else {
                    if (aKH()) {
                        return dqU;
                    }
                    if (this.dqo) {
                        return dqI;
                    }
                    if (this.dqp) {
                        return dqJ;
                    }
                    if (this.dqq) {
                        return dqK;
                    }
                    if (this.dqr) {
                        return dqL;
                    }
                    if (this.dqs) {
                        return dqM;
                    }
                    if (this.dqu) {
                        return dqO;
                    }
                    if (this.dqv) {
                        return dqP;
                    }
                    if (this.dqt) {
                        return dqN;
                    }
                    if (this.dsj) {
                        int aLH = aLH();
                        if (aLH == 1) {
                            return dqF;
                        }
                        if (aLH == 2) {
                            return dqG;
                        }
                        if (aLH > 2) {
                            return dqH;
                        }
                        return dqE;
                    }
                    return dqE;
                }
            }
        }
    }

    public int aLH() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.aIe().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aKO()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aKO().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aLI() {
        return aKk() != null && getThreadType() == 41 && aKB() == 1 && aLm() == 2;
    }

    public void y(ArrayList<q> arrayList) {
        if (this.drr == 1) {
            this.dnC = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dnC = 0;
        } else {
            this.dnC = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.aIL() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aIL().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dnC = next.aIM();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aLJ() {
        return this.threadType == 41;
    }

    public boolean aLK() {
        return this.dsK;
    }

    public void gx(boolean z) {
        this.dsK = z;
    }

    public String aLL() {
        return this.dsL;
    }

    public p aLM() {
        return this.dso;
    }

    public void aLN() {
        if (this.dsh == 0) {
            this.dsh = 1;
        }
    }

    public void gy(boolean z) {
        this.dsX = z;
    }

    public boolean aLO() {
        return this.dsX;
    }

    public void jW(int i) {
        this.dsY = i + 1;
    }

    public int aLP() {
        return this.dsY;
    }

    public boolean aLQ() {
        return this.dtN;
    }

    public void gz(boolean z) {
        this.dtN = z;
    }

    public bq aLR() {
        return this.dse;
    }

    public boolean aLS() {
        return getThreadType() == 49;
    }

    public boolean aLT() {
        return getThreadType() == 40;
    }

    public boolean aLU() {
        return getThreadType() == 50;
    }

    public boolean aLV() {
        return getThreadType() == 60;
    }

    public int aLW() {
        return this.dte;
    }

    public void setSmartFrsPosition(int i) {
        this.dte = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aLX() {
        return this.mRecomSource;
    }

    public boolean aLY() {
        return this.dtf;
    }

    public long aLZ() {
        return this.agreeData.agreeNum;
    }

    public long aMa() {
        return this.agreeData.disAgreeNum;
    }

    public int aMb() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aMc() {
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

    public long aMd() {
        return this.dth;
    }

    public void cd(long j) {
        this.dth = j;
    }

    public PostData aMe() {
        return this.dtg;
    }

    public ag aMf() {
        return this.dti;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean aKF = aKF();
        if (z2) {
            if (z) {
                if (aKF && !aJr()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (aKB() == 1 || getThreadType() == 33 || (aKD() != null && aKD().aML() != 0)) {
                    if (aKk() != null && aLJ()) {
                        if (aLm() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!aKF) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aLJ()) {
                    arrayList.add(dtb.get(aLm()));
                }
                if (aLp()) {
                    Integer num = dta.get(new Point(aLo(), aLn()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aKQ() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (aKF && aKz() != 1 && !aJr()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((aKB() == 1 || getThreadType() == 33) && !aLJ() && !aKF) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (aKA() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (aKz() == 1) {
                    arrayList.add(new l.a((int) R.string.f1287top));
                }
                if (aLJ() && aKk() != null && aLm() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aLp()) {
                    Integer num2 = dta.get(new Point(aLo(), aLn()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.dsM == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aKR() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aKQ() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aLS()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aLU()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aLT()) {
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
        this.drN = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.drO = arrayList;
    }

    public String aMg() {
        return this.dtu;
    }

    public void tX(String str) {
        this.dtu = str;
    }

    public void aMh() {
        this.dtr = 1;
    }

    public boolean aMi() {
        return this.dtr == 1;
    }

    public boolean aMj() {
        return "worldcupvideo".equals(this.dtx);
    }

    public String aMk() {
        return this.drA;
    }

    public void tY(String str) {
        this.drA = str;
    }

    public String aMl() {
        return this.drB;
    }

    public void tZ(String str) {
        this.drB = str;
    }

    public String aMm() {
        return this.dtv;
    }

    public void ua(String str) {
        this.dtv = str;
    }

    public boolean aMn() {
        return this.dty;
    }

    public void gA(boolean z) {
        this.dty = z;
    }

    public void b(VideoInfo videoInfo) {
        this.dtw = videoInfo;
    }

    public boolean aMo() {
        return this.dtz != null;
    }

    public bf aMp() {
        return this.drz;
    }

    public void a(bf bfVar) {
        this.drz = bfVar;
    }

    public boolean aMq() {
        return this.dtC;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dsc != null) {
            return this.dsc.video_url;
        }
        return null;
    }

    public boolean aMr() {
        return this.dtE;
    }

    public void gB(boolean z) {
        this.dtE = z;
    }

    public AgreeData aMs() {
        return this.agreeData;
    }

    public boolean aMt() {
        return this.dtO;
    }

    public void gC(boolean z) {
        this.dtO = z;
    }

    public boolean aMu() {
        return this.dtP;
    }

    public void gD(boolean z) {
        this.dtP = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aMv() {
        return this.dtt;
    }

    public String getShareImageUrl() {
        return this.dtK;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aKO = aKO();
        if (com.baidu.tbadk.core.i.aIe().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aKO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO, 0);
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

    public int[] aMw() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aKO = aKO();
        if (com.baidu.tbadk.core.i.aIe().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aKO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aKO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aKO, 0);
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

    public boolean aMx() {
        return aMy() || aMz();
    }

    public boolean aJt() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aJu() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aMy() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aMz() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aMA() {
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
        return aMA();
    }

    public void ka(int i) {
        this.dtU = i;
    }

    public int aMB() {
        return this.dtW;
    }

    public String aMC() {
        return this.dtV;
    }

    public void ub(String str) {
        this.dtV = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aMD() {
        if (aKG()) {
            return 4;
        }
        if (aLS() || aLU()) {
            return 3;
        }
        if (aJt()) {
            return 5;
        }
        if (aJu()) {
            return 6;
        }
        if (aMy()) {
            return 7;
        }
        if (aMz()) {
            return 8;
        }
        if (this.isShareThread && this.dto != null) {
            return 9;
        }
        if (aLT()) {
            return 2;
        }
        return 1;
    }

    public int aME() {
        if (aMz() || aMy()) {
            return 2;
        }
        if (aJt() || aJu()) {
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

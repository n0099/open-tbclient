package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.Headers;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
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
public class bh extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String ajt;
    private String authorId;
    public int cbD;
    private int cbE;
    private int cbH;
    private String cbK;
    private int cbL;
    private String cbM;
    private int cbO;
    private VideoInfo cbQ;
    private VideoDesc cbR;
    private bn cbS;
    private AlaInfoData cbT;
    private long cbU;
    private bd cbk;
    private String cbl;
    private String cbm;
    private String cbw;
    private SpannableStringBuilder cbz;
    private String ccA;
    private boolean ccG;
    private boolean ccH;
    public String ccJ;
    public int ccK;
    public int ccL;
    public String ccM;
    public long ccN;
    public String ccP;
    private List<ReportInfo> ccS;
    private boolean ccY;
    private o ccc;
    private LiveCoverStatus cci;
    private long ccj;
    public TwZhiBoUser ccr;
    public List<TwAnchorProfitItem> cct;
    private String ccw;
    private SkinInfo ccx;
    private boolean ccz;
    private String cdB;
    private String cdC;
    private String cdD;
    private SpannableStringBuilder cdE;
    private SpannableString cdF;
    private String cdG;
    private String cdH;
    public int cdI;
    public boolean cdJ;
    public String cdK;
    private int cdb;
    private int cdc;
    private long cde;
    private af cdf;
    public f cdh;
    private MediaData cdi;
    public int cdj;
    public OriginalThreadInfo cdl;
    private TopicModule cdp;
    private String cdq;
    private String cdr;
    private VideoInfo cds;
    private String cdt;
    public OriginalForumInfo cdv;
    public boolean cdw;
    private String cdx;
    private boolean cdy;
    private SmartApp cdz;
    public boolean isBigGie;
    private boolean isLinkThread;
    public boolean isShareThread;
    private String latitude;
    private long mCreateTime;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private String mUrl;
    private int post_num;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId caC = BdUniqueId.gen();
    public static final BdUniqueId caD = BdUniqueId.gen();
    public static final BdUniqueId caE = BdUniqueId.gen();
    public static final BdUniqueId caF = BdUniqueId.gen();
    public static final BdUniqueId caG = BdUniqueId.gen();
    public static final BdUniqueId caH = BdUniqueId.gen();
    public static final BdUniqueId caI = BdUniqueId.gen();
    public static final BdUniqueId caJ = BdUniqueId.gen();
    public static final BdUniqueId caK = BdUniqueId.gen();
    public static final BdUniqueId caL = BdUniqueId.gen();
    public static final BdUniqueId caM = BdUniqueId.gen();
    public static final BdUniqueId caN = BdUniqueId.gen();
    public static final BdUniqueId caO = BdUniqueId.gen();
    public static final BdUniqueId caP = BdUniqueId.gen();
    public static final BdUniqueId caQ = BdUniqueId.gen();
    public static final BdUniqueId caR = BdUniqueId.gen();
    public static final BdUniqueId caS = BdUniqueId.gen();
    public static final BdUniqueId caT = BdUniqueId.gen();
    public static final BdUniqueId caU = BdUniqueId.gen();
    public static final BdUniqueId caV = BdUniqueId.gen();
    public static final BdUniqueId caW = BdUniqueId.gen();
    public static final BdUniqueId caX = BdUniqueId.gen();
    public static final BdUniqueId caY = BdUniqueId.gen();
    public static final BdUniqueId caZ = BdUniqueId.gen();
    public static final BdUniqueId cba = BdUniqueId.gen();
    public static final BdUniqueId cbb = BdUniqueId.gen();
    public static AtomicBoolean cbc = new AtomicBoolean(false);
    public static AtomicBoolean cbd = new AtomicBoolean(false);
    public static AtomicBoolean cbe = new AtomicBoolean(false);
    public static final BdUniqueId cbf = BdUniqueId.gen();
    public static final BdUniqueId cbg = BdUniqueId.gen();
    private static HashMap<Point, Integer> ccd = new HashMap<>();
    private static HashMap<Integer, Integer> cce = new HashMap<>();
    public static final BdUniqueId cco = BdUniqueId.gen();
    public static final BdUniqueId ccp = BdUniqueId.gen();
    public static final BdUniqueId ccy = BdUniqueId.gen();
    private static HashMap<Point, Integer> ccT = new HashMap<>();
    private static SparseArray<n.a> ccU = new SparseArray<>(3);
    public boolean cap = false;
    public boolean caq = false;
    public boolean car = false;
    public boolean cas = false;
    public boolean cat = false;
    public boolean cau = false;
    public boolean cav = false;
    private int cbh = 0;
    private String cbi = "1";
    public int cbj = 1;
    private String cbG = null;
    private int bXB = 0;
    public int cbV = 0;
    private String cbW = "";
    public boolean cbX = false;
    private String ccf = "";
    public boolean ccO = true;
    public boolean ccV = false;
    public boolean ccW = false;
    private int ccX = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cdg = false;
    private int cdo = 0;
    private boolean cdu = false;
    private boolean cdA = false;
    public boolean cdL = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cbn = 0;
    private int cbo = 0;
    private String last_time = null;
    private long cbp = 0;
    private int cbq = 0;
    private int cbr = 0;
    private int cbs = 0;
    private int cbt = 0;
    private bl cbu = new bl();
    private MetaData cbv = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cbB = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cbC = new ArrayList<>();
    private int cbx = 0;
    private int cby = 0;
    private String ad_url = null;
    private String cbA = null;
    private String from = null;
    private int cbF = 0;
    private PraiseData cbI = new PraiseData();
    private AnchorInfoData cbJ = new AnchorInfoData();
    private long time = 0;
    private int cbN = 0;
    private ArrayList<b> cbZ = new ArrayList<>();
    private bq cca = null;
    private g ccb = null;
    private int ccg = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cbP = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cch = null;
    private int cbY = 0;
    private boolean cck = false;
    private boolean ccl = false;
    private int ccm = 0;
    private boolean ccn = false;
    private int anchorLevel = 0;
    public int ccB = 0;
    public l ccC = new l();
    private List<PbContent> ccD = new ArrayList();
    private List<PbContent> ccE = new ArrayList();
    private List<PbContent> ccF = new ArrayList();
    private String category_name = null;
    private bf ccq = new bf();
    private ArrayList<com.baidu.tbadk.data.c> ccu = new ArrayList<>();
    private PushStatusData ccv = new PushStatusData();
    public boolean ccQ = false;
    public int ccR = -1;
    private long ccZ = 0;
    private long cda = 0;
    private PostData cdd = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int ccI = 0;
    public int cdk = 0;
    private String tieba_game_information_source = "";
    public String cdn = "";
    public String cdm = "";

    static {
        ccd.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        ccd.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        ccd.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        ccd.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        ccd.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        ccd.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        ccd.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        ccd.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        ccT.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        ccT.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        ccT.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        ccT.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        ccT.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        ccT.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        ccT.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        ccT.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cce.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cce.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cce.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        ccU.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        ccU.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        ccU.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bh() {
        this.cbE = 0;
        this.cbO = 0;
        this.ccj = 0L;
        this.mUrl = "";
        this.ccw = "";
        this.cdj = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.ccj = 0L;
        this.cbO = 0;
        this.cbE = 0;
        this.cdj = 0;
        this.mUrl = "";
        this.ccw = "";
        this.isBigGie = false;
    }

    public String aic() {
        return this.cdB;
    }

    public String aid() {
        return this.cdC;
    }

    public void mW(String str) {
        this.cdC = str;
    }

    public String aie() {
        return this.cdD;
    }

    public SpannableStringBuilder aif() {
        return this.cdE;
    }

    public SpannableString aig() {
        return this.cdF;
    }

    public String aih() {
        return this.cdG;
    }

    public String aii() {
        return this.cdH;
    }

    public boolean aij() {
        return this.cbE == 1;
    }

    public bf aik() {
        return this.ccq;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void hD(int i) {
        this.anchorLevel = i;
    }

    public int ail() {
        return this.ccI;
    }

    public void hE(int i) {
        this.ccI = i;
    }

    public void hF(int i) {
        this.ccm = i;
    }

    public int aim() {
        return this.ccm;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo ain() {
        return this.cds;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void aI(long j) {
        this.mCreateTime = j;
    }

    public long aio() {
        return this.cbU;
    }

    public String aip() {
        return this.cbK;
    }

    public PraiseData aiq() {
        return this.cbI;
    }

    public void a(PraiseData praiseData) {
        this.cbI = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String air() {
        return this.ajt;
    }

    public void mX(String str) {
        this.ajt = str;
    }

    public void mY(String str) {
        this.cbi = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void hG(int i) {
        this.cbh = i;
    }

    public int ais() {
        return this.cbh;
    }

    public String ait() {
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

    public List<PbContent> aiu() {
        return this.ccD;
    }

    public void ar(List<PbContent> list) {
        this.ccE = list;
    }

    public void as(List<PbContent> list) {
        this.ccF = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hH(int i) {
        this.reply_num = i;
    }

    public int aiv() {
        return this.reply_num;
    }

    public int aiw() {
        return this.cbo;
    }

    public void hI(int i) {
        this.cbo = i;
    }

    public long aix() {
        return this.cbp;
    }

    public void aJ(long j) {
        this.cbp = j;
    }

    public int aiy() {
        return this.cbr;
    }

    public int aiz() {
        return this.cbq;
    }

    public void hJ(int i) {
        this.cbq = i;
    }

    public int aiA() {
        return this.cbs;
    }

    public void hK(int i) {
        this.cbs = i;
    }

    public int aiB() {
        return this.cbt;
    }

    public List<PbContent> aiC() {
        return this.ccE;
    }

    public bl aiD() {
        return this.cbu;
    }

    public MetaData aiE() {
        return this.cbv;
    }

    public boolean aiF() {
        return this.is_god != 0;
    }

    public boolean aiG() {
        return this.is_god == 1;
    }

    public boolean aiH() {
        return (this.cbv == null || this.cbv.getGodUserData() == null || this.cbv.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aiI() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cbv = metaData;
    }

    public String aiJ() {
        return this.forum_name;
    }

    public void mZ(String str) {
        this.forum_name = str;
    }

    public int aiK() {
        return this.cby;
    }

    public String aiL() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.cbA;
    }

    public void na(String str) {
        this.cbA = str;
    }

    public String N(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ccF == null || this.ccF.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ccF.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ccF.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ccE == null || (size = this.ccE.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ccE.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString nb(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(N(str, true));
        if (this.ccF != null && (size = this.ccF.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ccF.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.nf(pbContent.link);
                            }
                        }, i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                }
                i2++;
                i3 = i;
            }
        }
        return spannableString;
    }

    public int aiM() {
        return this.cbF;
    }

    public void hL(int i) {
        this.cbF = i;
    }

    public String aiN() {
        return this.cbG;
    }

    public void nc(String str) {
        this.cbG = str;
    }

    public ArrayList<MediaData> aiO() {
        return this.cbB;
    }

    public ArrayList<b> aiP() {
        return this.cbZ;
    }

    public void t(ArrayList<b> arrayList) {
        this.cbZ = arrayList;
    }

    public bq aiQ() {
        return this.cca;
    }

    public g aiR() {
        return this.ccb;
    }

    public ArrayList<VoiceData.VoiceModel> aiS() {
        return this.cbC;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aiT() {
        return this.cbL;
    }

    public void hM(int i) {
        this.cbL = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aiU() {
        return this.cbW;
    }

    public VideoInfo aiV() {
        return this.cbQ;
    }

    public VideoDesc aiW() {
        return this.cbR;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cbT = alaInfoData;
    }

    public AlaInfoData aiX() {
        return this.cbT;
    }

    public PushStatusData aiY() {
        return this.ccv;
    }

    public SkinInfo aiZ() {
        return this.ccx;
    }

    public long aja() {
        return this.ccN;
    }

    public boolean ajb() {
        return this.ccO;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agG() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agH() {
        return this.ccP;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agI() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agG().getTid());
        ajVar.setFid(agG().getFid());
        ajVar.setFeedBackReasonMap(this.feedBackReasonMap);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cbM = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cbE = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cbU = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cbn = threadInfo.repost_num.intValue();
                this.cbo = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cbp = threadInfo.last_time_int.intValue();
                this.cbq = threadInfo.is_top.intValue();
                this.cbr = threadInfo.is_membertop.intValue();
                this.cbs = threadInfo.is_good.intValue();
                this.cbt = threadInfo.is_livepost.intValue();
                this.cbu.a(threadInfo.topic);
                this.cbv.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cbw = threadInfo.fname;
                this.cbx = threadInfo.has_commented.intValue();
                this.cby = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cbQ = threadInfo.video_info;
                this.cbR = threadInfo.video_segment;
                this.cbT = new AlaInfoData();
                this.cbT.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cbF = threadInfo.collect_status.intValue();
                this.cbG = threadInfo.collect_mark_pid;
                this.cbH = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cbK = threadInfo.first_post_id + "";
                this.cbW = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cbL = threadInfo.is_ntitle.intValue();
                this.cbN = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.cdb = threadInfo.agree.has_agree.intValue();
                    this.cdc = threadInfo.agree.agree_type.intValue();
                    this.ccZ = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.cda = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.ccZ;
                    this.agreeData.disAgreeNum = this.cda;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cde = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cbO = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ccG = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ccE = threadInfo.rich_title;
                this.ccD = threadInfo.first_post_content;
                this.ccF = threadInfo.rich_abstract;
                this.cbD = threadInfo.is_godthread_recommend.intValue();
                if ((this.cbv == null || this.cbv.getUserId() == null || this.cbv.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cbv = metaData;
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
                this.cbA = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cbB.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cbQ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cbS = new bn();
                    this.cbS.a(threadInfo.video_channel_info);
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
                        this.cbC.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cbZ.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cca = new bq();
                    this.cca.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ccb = new g();
                    this.ccb.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ccc = new o();
                    this.ccc.a(threadInfo.cartoon_info);
                }
                this.cbI.setUserMap(this.userMap);
                this.cbI.parserProtobuf(threadInfo.zan);
                this.cbJ.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cbI.setTitle(this.title);
                } else {
                    this.cbI.setTitle(this.cbA);
                }
                this.ccf = threadInfo.livecover_src;
                this.ccg = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cbY = threadInfo.post_num.intValue();
                this.ccj = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.ju(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.pe(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cbP.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cch = noticeInfo.notice;
                    }
                    this.ccm = zhiBoInfoTW.copythread_remind.intValue();
                    this.cck = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ccl = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ccf)) {
                        this.ccf = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.ccr = zhiBoInfoTW.user.tw_anchor_info;
                        this.cct = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cci = threadInfo.twzhibo_info.livecover_status;
                    this.ccj = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.ccn = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ccq.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.ccu.add(cVar);
                    }
                }
                this.ccv.parserProtobuf(threadInfo.push_status);
                this.ccA = threadInfo.lego_card;
                this.ccx = threadInfo.skin_info;
                this.ccB = threadInfo.is_book_chapter.intValue();
                this.ccC.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.ccP = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.ccN = threadInfo.last_read_pid.longValue();
                this.ccO = threadInfo.cheak_repeat.intValue() == 1;
                this.ccS = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cdd.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.ccY = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cdf = new af();
                    this.cdf.a(threadInfo.link_info);
                }
                this.cdg = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cdh = new f();
                    this.cdh.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cdi = new MediaData();
                    this.cdi.parserProtobuf(threadInfo.pic_info);
                }
                this.ccI = threadInfo.is_called.intValue();
                this.cdj = threadInfo.middle_page_num.intValue();
                this.cdk = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cdm = threadInfo.star_rank_icon.icon_pic_url;
                    this.cdn = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cdl = new OriginalThreadInfo();
                    this.cdl.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.cdl = new OriginalThreadInfo();
                    this.cdl.parser(threadInfo.origin_thread_info);
                } else {
                    this.cdl = null;
                }
                this.cdo = threadInfo.is_topic.intValue();
                this.cdq = threadInfo.topic_user_name;
                this.cdr = threadInfo.topic_h5_url;
                this.cdp = threadInfo.topic_module;
                this.cdt = threadInfo.presentation_style;
                this.cdv = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cdx = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cbk = new bd();
                    this.cbk.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cdz = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.cdz, this);
                }
                this.cdK = threadInfo.t_share_img;
                ajc();
                this.cdL = threadInfo.is_headlinepost.intValue() == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

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
                this.cbU = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cbn = jSONObject.optInt("repost_num", 0);
                this.cbo = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cbp = jSONObject.optLong("last_time_int", 0L);
                this.cbq = jSONObject.optInt("is_top", 0);
                this.cbr = jSONObject.optInt("is_membertop", 0);
                this.cbs = jSONObject.optInt("is_good", 0);
                this.cbt = jSONObject.optInt("is_livepost", 0);
                this.cbu.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cbv.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cbw = this.forum_name;
                this.cbx = jSONObject.optInt("has_commented", 0);
                this.cby = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cbF = jSONObject.optInt("collect_status");
                this.cbG = jSONObject.optString("collect_mark_pid");
                this.cbH = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ccZ = jSONObject.optInt("agree_num");
                this.cde = jSONObject.optLong("share_num");
                this.cbK = jSONObject.optString("first_post_id", "0");
                this.cbW = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cbL = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.cdb = optJSONObject2.optInt("has_agree");
                    this.ccZ = optJSONObject2.optInt("agree_num");
                    this.cda = optJSONObject2.optLong("disagree_num");
                    this.cdc = optJSONObject2.optInt("agree_type");
                    if (this.ccZ < 0) {
                        this.ccZ = 0L;
                    }
                    if (this.cda < 0) {
                        this.cda = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.ccZ;
                    this.agreeData.disAgreeNum = this.cda;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.ccq.parserJson(optJSONObject3);
                }
                if ((this.cbv == null || this.cbv.getUserId() == null) && this.userMap != null) {
                    this.cbv = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.cbT = new AlaInfoData();
                this.cbT.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.cbA = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cbB.add(mediaData);
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
                        this.cbC.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cbZ.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.cca = new bq();
                    this.cca.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.ccb = new g();
                    this.ccb.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.ccc = new o();
                    this.ccc.parserJson(optJSONObject7);
                }
                this.cbI.setUserMap(this.userMap);
                this.cbI.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cbJ.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cbI.setTitle(this.title);
                } else {
                    this.cbI.setTitle(this.cbA);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.ccq.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ccu.add(cVar);
                    }
                }
                this.ccB = jSONObject.optInt("is_book_chapter", 0);
                this.ccC.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.ccP = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.ccJ = jSONObject.optString("recom_extra_img");
                this.ccM = jSONObject.optString("recom_extra_img_night");
                this.ccK = jSONObject.optInt("recom_extra_img_width", 0);
                this.ccL = jSONObject.optInt("recom_extra_img_height", 0);
                this.ccN = jSONObject.optLong("last_read_pid");
                this.ccO = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.cbS = new bn();
                    this.cbS.bu(optJSONObject9);
                }
                this.ccY = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.cdf = new af();
                    this.cdf.parserJson(optJSONObject10);
                }
                this.cdg = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.cdh = new f();
                    this.cdh.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.cdi = new MediaData();
                    this.cdi.parserJson(optJSONObject12);
                }
                this.ccI = jSONObject.optInt("is_called", 0);
                this.cdj = jSONObject.optInt("middle_page_num", 0);
                this.cdk = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject13 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject13 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject13.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject13.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject13.optString("video_md5");
                    builder.video_url = optJSONObject13.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject13.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject13.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject13.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject13.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject13.optInt(LogConfig.LOG_VIDEO_TYPE, 0));
                    builder.thumbnail_url = optJSONObject13.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject13.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject13.optInt("is_vertical", 0));
                    builder.mcn_lead_page = new String(optJSONObject13.optString("mcn_lead_page"));
                    this.cbQ = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.cdl = new OriginalThreadInfo();
                        this.cdl.parserJson(optJSONObject14);
                    } else {
                        this.cdl = null;
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject15 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject15.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder2.name = optJSONObject15.optString("name");
                    builder2._abstract = optJSONObject15.optString("abstract");
                    builder2.pic = optJSONObject15.optString("pic");
                    builder2.h5_url = optJSONObject15.optString("h5_url");
                    builder2.id = optJSONObject15.optString("id");
                    builder2.link = optJSONObject15.optString("link");
                    this.cdz = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.cdz, this);
                }
                this.cdK = jSONObject.optString("t_share_img");
                ajc();
                this.cdL = jSONObject.optInt("is_headlinepost", 0) == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void ajc() {
        ajd();
        aje();
        ajf();
        ajg();
        ajh();
        aji();
        ajj();
    }

    private void ajd() {
        if (!StringUtils.isNull(this.cbv.getName_show())) {
            this.cdB = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cbv.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aje() {
        if (aiI()) {
            this.cdC = com.baidu.tbadk.core.util.aq.aR(aix() * 1000);
        } else if (aku()) {
            String aR = com.baidu.tbadk.core.util.aq.aR(aix() * 1000);
            if (com.baidu.tbadk.core.util.aq.nS(aR)) {
                aR = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aix() * 1000);
            }
            this.cdC = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aR;
        } else {
            String aR2 = com.baidu.tbadk.core.util.aq.aR(aix() * 1000);
            if (com.baidu.tbadk.core.util.aq.nS(aR2)) {
                aR2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aix() * 1000);
            }
            this.cdC = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aR2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.cdC += " • " + getAddress();
        }
    }

    private void ajf() {
        if (aiX() == null || aiX().share_info == null || aiX().share_info.share_user_count <= 0 || !ajR() || (this.cdj > 0 && this.cdk == 0)) {
            this.cdD = null;
            return;
        }
        int i = aiX().share_info.share_user_count;
        if (i == 1) {
            this.cdD = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cdD = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void ajg() {
        this.cdE = akd();
    }

    private void ajh() {
        this.cdF = ake();
    }

    private void aji() {
        this.cdG = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aix() * 1000);
    }

    private void ajj() {
        this.cdH = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aix());
    }

    public SpannableStringBuilder ajk() {
        return this.cbz;
    }

    public boolean ajl() {
        return aiz() != 0;
    }

    public int ajm() {
        if (this.ccq != null) {
            long ahX = this.ccq.ahX();
            long ahY = this.ccq.ahY();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ahX) {
                return 1;
            }
            if (currentTimeMillis > ahY) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int ajn() {
        if (ajp() && this.cbZ.size() >= 1) {
            b bVar = this.cbZ.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int agL = bVar.agL();
            int agM = bVar.agM();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < agL) {
                return 4;
            }
            return currentTimeMillis > agM ? 2 : 1;
        }
        return -1;
    }

    public int ajo() {
        if (!ajp() || this.cbZ.size() < 1 || this.cbZ.get(0) == null) {
            return -1;
        }
        return this.cbZ.get(0).agK();
    }

    public boolean ajp() {
        return this.cbN == 1;
    }

    public String getActUrl() {
        return (!ajp() || this.cbZ.size() < 1 || this.cbZ.get(0) == null) ? "" : this.cbZ.get(0).getUrl();
    }

    private com.baidu.adp.widget.b nd(String str) {
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

    public SmartApp ajq() {
        return this.cdz;
    }

    private void p(boolean z, boolean z2) {
        SpannableString spannableString;
        String N = N(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && ajs()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aiz() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aiz() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aiB() == 1 || this.cbu.akD() != 0) {
                if (aik() != null && getThreadType() == 41) {
                    if (ajm() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && ajE()) {
                Integer num = cce.get(Integer.valueOf(ajm()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aiA() == 1 && !ajl() && caR != getType() && caW != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cbJ != null && this.cbJ.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aiK() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = ccd.get(new Point(ajo(), ajn()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aiQ() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aiR() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = nd(this.category_name);
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
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cbj));
                spannableString.setSpan(kVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(N + HanziToPinyin.Token.SEPARATOR));
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.cbz = spannableStringBuilder;
    }

    public boolean ajr() {
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
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aiE() != null) {
            if (aiE().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aiE().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(lVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean ajs() {
        return com.baidu.adp.lib.b.d.ft().af("isConveneThreadOpen") == 1;
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
        String N = N(this.title, false);
        SpannableString a = a(new SpannableString(N + HanziToPinyin.Token.SEPARATOR));
        if (z) {
            spannableStringBuilder = a(N, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.cbz = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.n.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.cbL == 1) {
                this.cbz = a;
                return a;
            }
        } else if (this.cbL == 1) {
            this.cbz = new SpannableStringBuilder();
            return a;
        }
        if (spannableString != null) {
            a.append((CharSequence) spannableString);
            return a;
        } else if (b.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public void bI(String str, String str2) {
        this.mUrl = str;
        this.ccw = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a Q;
        com.baidu.adp.widget.ImageView.a Q2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ccw) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.avs().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.e.w.P(this.mUrl, 10)) && (Q = com.baidu.tbadk.core.util.e.w.Q(this.mUrl, 10)) != null) {
                bitmap = Q.getRawBitmap();
                com.baidu.tbadk.imageManager.c.avs().addBitmap(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.avs().getBitmap(this.ccw);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.e.w.P(this.ccw, 10)) && (Q2 = com.baidu.tbadk.core.util.e.w.Q(this.ccw, 10)) != null) {
                bitmap2 = Q2.getRawBitmap();
                com.baidu.tbadk.imageManager.c.avs().addBitmap(this.ccw, bitmap2);
            }
            Bitmap bitmap3 = bitmap2;
            if (bitmap != null && !bitmap.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                int i2 = 0;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    if (str.charAt(i3) == '#') {
                        if (i2 % 2 == 0) {
                            bitmapDrawable = new BitmapDrawable(bitmap);
                            bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        } else {
                            bitmapDrawable = new BitmapDrawable(bitmap3);
                            bitmapDrawable.setBounds(0, 0, bitmap3.getWidth(), bitmap3.getHeight());
                        }
                        com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cbj));
                        spannableString.setSpan(mVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.fT().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.avs().addBitmap(str2, aVar.getRawBitmap());
                    }
                }
            }, caP);
            com.baidu.adp.lib.f.c.fT().a(this.ccw, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.avs().addBitmap(str2, aVar.getRawBitmap());
                    }
                }
            }, caP);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.ccE != null && this.ccE.size() > 0) {
            int size = this.ccE.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ccE.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bh.4
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bh.this.nf(pbContent.link);
                            }
                        }, i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                } else {
                    return spannableString;
                }
                i2++;
                i3 = i;
            }
            return spannableString;
        }
        return spannableString;
    }

    private String ne(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData ajt() {
        if (this.ccE != null && this.ccE.size() > 0) {
            int size = this.ccE.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.ccE.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && ajy() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = ne(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.cbh;
            kVar.cDn = this.cbi;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }

    public void aju() {
        p(false, false);
    }

    public void ajv() {
        p(false, true);
    }

    public AnchorInfoData ajw() {
        return this.cbJ;
    }

    public boolean ajx() {
        return this.threadType == 36;
    }

    public boolean ajy() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean ajz() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aiO = aiO();
        if (aiO == null || ajl()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aiO.size() || i2 >= 3) {
                break;
            }
            if (aiO.get(i2) != null && aiO.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aiO.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aiO.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aiO.get(i2).getPicUrl();
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
        if (this.cbQ != null && !StringUtils.isNull(this.cbQ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cbQ.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cbv != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cbv.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ajA() {
        String userId;
        return this.cbv == null || (userId = this.cbv.getUserId()) == null || userId.equals("0");
    }

    public boolean ajB() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (akr()) {
            if (aiV() != null) {
                return caR;
            }
            return caD;
        }
        int aiz = aiz();
        if (this.cdo == 1) {
            if (this.cdp != null) {
                return caO;
            }
            return this.cds != null ? caY : caX;
        } else if (this.cbQ != null && aki()) {
            return cbg;
        } else {
            if (this.cbT != null && this.threadType == 60) {
                return caU;
            }
            if (this.cbT != null && this.threadType == 49) {
                return caS;
            }
            if (this.threadType == 51) {
                return caT;
            }
            if (this.threadType == 63) {
                return caZ;
            }
            if (this.threadType == 64) {
                return cba;
            }
            if (aiz == 2 || aiz == 1) {
                return caC;
            }
            if (this.cbQ != null && ajJ() && !ajB()) {
                return cbf;
            }
            if (this.cbQ != null && !ajB()) {
                if (aiH()) {
                    return caW;
                }
                return caR;
            } else if (this.isShareThread) {
                return caV;
            } else {
                if (ajD()) {
                    return cbc.get() ? ccp : caD;
                } else if (ajp() && ajo() == 1) {
                    return cbc.get() ? ccy : caD;
                } else if (isLinkThread()) {
                    return caP;
                } else {
                    if (aiH()) {
                        return caQ;
                    }
                    if (this.cap) {
                        return caH;
                    }
                    if (this.caq) {
                        return caI;
                    }
                    if (this.car) {
                        return caJ;
                    }
                    if (this.cas) {
                        return caK;
                    }
                    if (this.cat) {
                        return caL;
                    }
                    if (this.cau) {
                        return caM;
                    }
                    if (this.cav) {
                        return caN;
                    }
                    if (this.cbX) {
                        int ajC = ajC();
                        if (ajC == 1) {
                            return caE;
                        }
                        if (ajC == 2) {
                            return caF;
                        }
                        if (ajC > 2) {
                            return caG;
                        }
                        return caD;
                    }
                    return caD;
                }
            }
        }
    }

    public int ajC() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.ago().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aiO()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aiO().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiO(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean ajD() {
        return aik() != null && getThreadType() == 41 && aiB() == 1 && ajm() == 2;
    }

    public void u(ArrayList<p> arrayList) {
        if (this.cbL == 1) {
            this.bXB = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bXB = 0;
        } else {
            this.bXB = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.agS() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.agS().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bXB = next.agT();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean ajE() {
        return this.threadType == 41;
    }

    public boolean ajF() {
        return this.ccz;
    }

    public void dZ(boolean z) {
        this.ccz = z;
    }

    public String ajG() {
        return this.ccA;
    }

    public o ajH() {
        return this.ccc;
    }

    public void ajI() {
        if (this.cbV == 0) {
            this.cbV = 1;
        }
    }

    public void ea(boolean z) {
        this.ccQ = z;
    }

    public boolean ajJ() {
        return this.ccQ;
    }

    public void hN(int i) {
        this.ccR = i + 1;
    }

    public int ajK() {
        return this.ccR;
    }

    public List<ReportInfo> ajL() {
        return this.ccS;
    }

    public boolean ajM() {
        return this.ccH;
    }

    public void eb(boolean z) {
        this.ccH = z;
    }

    public bn ajN() {
        return this.cbS;
    }

    public void a(bn bnVar) {
        this.cbS = bnVar;
    }

    public void setCurrentPage(int i) {
        if (this.cbS != null) {
            this.cbS.Zv = i;
        }
    }

    public boolean ajO() {
        return getThreadType() == 49;
    }

    public boolean ajP() {
        return getThreadType() == 40;
    }

    public boolean ajQ() {
        return getThreadType() == 50;
    }

    public boolean ajR() {
        return getThreadType() == 60;
    }

    public boolean ajS() {
        return getThreadType() == 40 && ajN() != null && ajN().channelId > 0;
    }

    public int ajT() {
        return this.ccX;
    }

    public void setSmartFrsPosition(int i) {
        this.ccX = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String ajU() {
        return this.mRecomSource;
    }

    public boolean ajV() {
        return this.ccY;
    }

    public long ajW() {
        return this.ccZ;
    }

    public long ajX() {
        return this.cda;
    }

    public int ajY() {
        return this.cdb;
    }

    public int ajZ() {
        return this.cdc;
    }

    public void hO(int i) {
        this.cdb = i;
    }

    public void hP(int i) {
        this.ccZ = i;
    }

    public void aK(long j) {
        this.ccZ = j;
    }

    public void aL(long j) {
        this.cda = j;
    }

    public void hQ(int i) {
        this.cdc = i;
    }

    public long aka() {
        return this.cde;
    }

    public void aM(long j) {
        this.cde = j;
    }

    public PostData akb() {
        return this.cdd;
    }

    public af akc() {
        return this.cdf;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String N;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.cbL == 1) {
            N = N(this.cbA, true);
            a = nb(this.cbA);
        } else {
            N = N(this.title, false);
            a = a(new SpannableString(N + HanziToPinyin.Token.SEPARATOR));
        }
        if (z) {
            spannableStringBuilder = a(N, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.cbz = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder r(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder s(boolean z, boolean z2) {
        SpannableString nb;
        if (!StringUtils.isNull(this.title) && this.cbL != 1) {
            nb = a(new SpannableString(N(this.title, false) + HanziToPinyin.Token.SEPARATOR));
        } else {
            nb = nb(this.cbA);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(nb);
        this.cbz = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder akd() {
        if (StringUtils.isNull(this.title) || this.cbL == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(N(this.title, false) + HanziToPinyin.Token.SEPARATOR)));
        this.cbz = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString ake() {
        return nb(this.cbA);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean aiF = aiF();
        if (z2) {
            if (z) {
                if (aiF && !ajy()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (aiB() == 1 || getThreadType() == 33 || (aiD() != null && aiD().akD() != 0)) {
                    if (aik() != null && ajE()) {
                        if (ajm() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!aiF) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (ajE()) {
                    arrayList.add(ccU.get(ajm()));
                }
                if (ajp()) {
                    Integer num = ccT.get(new Point(ajo(), ajn()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (aiQ() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (aiF && aiz() != 1 && !ajy()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((aiB() == 1 || getThreadType() == 33) && !ajE() && !aiF) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (aiA() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (aiz() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (ajE() && aik() != null && ajm() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (ajp()) {
                    Integer num2 = ccT.get(new Point(ajo(), ajn()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.ccB == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (aiR() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aiQ() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && ajO()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (ajS()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && ajQ()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (ajP()) {
                    arrayList.add(new n.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new n.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void v(ArrayList<MediaData> arrayList) {
        this.cbB = arrayList;
    }

    public String akf() {
        return this.cdq;
    }

    public void ng(String str) {
        this.cdq = str;
    }

    public void akg() {
        this.cdo = 1;
    }

    public boolean akh() {
        return this.cdo == 1;
    }

    public boolean aki() {
        return this.cdt.equals("worldcupvideo");
    }

    public String akj() {
        return this.cbl;
    }

    public void nh(String str) {
        this.cbl = str;
    }

    public String akk() {
        return this.cbm;
    }

    public void ni(String str) {
        this.cbm = str;
    }

    public String akl() {
        return this.cdr;
    }

    public void nj(String str) {
        this.cdr = str;
    }

    public boolean akm() {
        return this.cdu;
    }

    public void ec(boolean z) {
        this.cdu = z;
    }

    public void a(VideoInfo videoInfo) {
        this.cds = videoInfo;
    }

    public boolean akn() {
        return this.cdv != null;
    }

    public String ako() {
        return this.cbw;
    }

    public String akp() {
        return this.cdx;
    }

    public bd akq() {
        return this.cbk;
    }

    public boolean akr() {
        return this.cdy;
    }

    public void ed(boolean z) {
        this.cdy = z;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cbQ != null) {
            return this.cbQ.video_url;
        }
        return null;
    }

    public boolean aks() {
        return this.cdA;
    }

    public void ee(boolean z) {
        this.cdA = z;
    }

    public AgreeData akt() {
        return this.agreeData;
    }

    public boolean aku() {
        return this.cdJ;
    }

    public void ef(boolean z) {
        this.cdJ = z;
    }

    public TopicModule akv() {
        return this.cdp;
    }

    public String getShareImageUrl() {
        return this.cdK;
    }

    void a(SmartApp smartApp, bh bhVar) {
        if (smartApp != null && bhVar != null) {
            MetaData aiE = bhVar.aiE();
            if (com.baidu.tbadk.core.util.aq.isEmpty(smartApp.name)) {
                aiE.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                aiE.setName_show(smartApp.name);
            }
            aiE.setPortrait(smartApp.avatar);
        }
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aiO = aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aiO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aiO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiO, 0);
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

    public int[] akw() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aiO = aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aiO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aiO.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiO, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiO, 0);
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
}

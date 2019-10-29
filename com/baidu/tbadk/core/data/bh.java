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
    private String ajL;
    private String authorId;
    private String ccC;
    private int ccD;
    private String ccE;
    private int ccG;
    private VideoInfo ccI;
    private VideoDesc ccJ;
    private bn ccK;
    private AlaInfoData ccL;
    private long ccM;
    private o ccU;
    private bd ccb;
    private String ccc;
    private String ccd;
    private String ccn;
    private SpannableStringBuilder ccq;
    public int ccv;
    private int ccw;
    private int ccz;
    public String cdA;
    public int cdB;
    public int cdC;
    public String cdD;
    public long cdE;
    public String cdG;
    private List<ReportInfo> cdJ;
    private boolean cdP;
    private int cdS;
    private int cdT;
    private long cdV;
    private af cdW;
    public f cdY;
    private MediaData cdZ;
    private LiveCoverStatus cda;
    private long cdb;
    public TwZhiBoUser cdj;
    public List<TwAnchorProfitItem> cdk;
    private String cdn;
    private SkinInfo cdo;
    private boolean cdq;
    private String cdr;
    private boolean cdx;
    private boolean cdy;
    public boolean ceA;
    public String ceB;
    public int cea;
    public OriginalThreadInfo cec;
    private TopicModule ceg;
    private String ceh;
    private String cei;
    private VideoInfo cej;
    private String cek;
    public OriginalForumInfo cem;
    public boolean cen;
    private String ceo;
    private boolean cep;
    private SmartApp ceq;
    private String ces;
    private String cet;
    private String ceu;
    private SpannableStringBuilder cev;
    private SpannableString cew;
    private String cex;
    private String cey;
    public int cez;
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
    public static final BdUniqueId cbt = BdUniqueId.gen();
    public static final BdUniqueId cbu = BdUniqueId.gen();
    public static final BdUniqueId cbv = BdUniqueId.gen();
    public static final BdUniqueId cbw = BdUniqueId.gen();
    public static final BdUniqueId cbx = BdUniqueId.gen();
    public static final BdUniqueId cby = BdUniqueId.gen();
    public static final BdUniqueId cbz = BdUniqueId.gen();
    public static final BdUniqueId cbA = BdUniqueId.gen();
    public static final BdUniqueId cbB = BdUniqueId.gen();
    public static final BdUniqueId cbC = BdUniqueId.gen();
    public static final BdUniqueId cbD = BdUniqueId.gen();
    public static final BdUniqueId cbE = BdUniqueId.gen();
    public static final BdUniqueId cbF = BdUniqueId.gen();
    public static final BdUniqueId cbG = BdUniqueId.gen();
    public static final BdUniqueId cbH = BdUniqueId.gen();
    public static final BdUniqueId cbI = BdUniqueId.gen();
    public static final BdUniqueId cbJ = BdUniqueId.gen();
    public static final BdUniqueId cbK = BdUniqueId.gen();
    public static final BdUniqueId cbL = BdUniqueId.gen();
    public static final BdUniqueId cbM = BdUniqueId.gen();
    public static final BdUniqueId cbN = BdUniqueId.gen();
    public static final BdUniqueId cbO = BdUniqueId.gen();
    public static final BdUniqueId cbP = BdUniqueId.gen();
    public static final BdUniqueId cbQ = BdUniqueId.gen();
    public static final BdUniqueId cbR = BdUniqueId.gen();
    public static final BdUniqueId cbS = BdUniqueId.gen();
    public static AtomicBoolean cbT = new AtomicBoolean(false);
    public static AtomicBoolean cbU = new AtomicBoolean(false);
    public static AtomicBoolean cbV = new AtomicBoolean(false);
    public static final BdUniqueId cbW = BdUniqueId.gen();
    public static final BdUniqueId cbX = BdUniqueId.gen();
    private static HashMap<Point, Integer> ccV = new HashMap<>();
    private static HashMap<Integer, Integer> ccW = new HashMap<>();
    public static final BdUniqueId cdg = BdUniqueId.gen();
    public static final BdUniqueId cdh = BdUniqueId.gen();
    public static final BdUniqueId cdp = BdUniqueId.gen();
    private static HashMap<Point, Integer> cdK = new HashMap<>();
    private static SparseArray<n.a> cdL = new SparseArray<>(3);
    public boolean cbg = false;
    public boolean cbh = false;
    public boolean cbi = false;
    public boolean cbj = false;
    public boolean cbk = false;
    public boolean cbl = false;
    public boolean cbm = false;
    private int cbY = 0;
    private String cbZ = "1";
    public int cca = 1;
    private String ccy = null;
    private int bYs = 0;
    public int ccN = 0;
    private String ccO = "";
    public boolean ccP = false;
    private String ccX = "";
    public boolean cdF = true;
    public boolean cdM = false;
    public boolean cdN = false;
    private int cdO = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cdX = false;
    private int cef = 0;
    private boolean cel = false;
    private boolean cer = false;
    public boolean ceC = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cce = 0;
    private int ccf = 0;
    private String last_time = null;
    private long ccg = 0;
    private int cch = 0;
    private int cci = 0;
    private int ccj = 0;
    private int cck = 0;
    private bl ccl = new bl();
    private MetaData ccm = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cct = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> ccu = new ArrayList<>();
    private int cco = 0;
    private int ccp = 0;
    private String ad_url = null;
    private String ccr = null;
    private String from = null;
    private int ccx = 0;
    private PraiseData ccA = new PraiseData();
    private AnchorInfoData ccB = new AnchorInfoData();
    private long time = 0;
    private int ccF = 0;
    private ArrayList<b> ccR = new ArrayList<>();
    private bq ccS = null;
    private g ccT = null;
    private int ccY = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> ccH = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ccZ = null;
    private int ccQ = 0;
    private boolean cdc = false;
    private boolean cdd = false;
    private int cde = 0;
    private boolean cdf = false;
    private int anchorLevel = 0;
    public int cds = 0;
    public l cdt = new l();
    private List<PbContent> cdu = new ArrayList();
    private List<PbContent> cdv = new ArrayList();
    private List<PbContent> cdw = new ArrayList();
    private String category_name = null;
    private bf cdi = new bf();
    private ArrayList<com.baidu.tbadk.data.c> cdl = new ArrayList<>();
    private PushStatusData cdm = new PushStatusData();
    public boolean cdH = false;
    public int cdI = -1;
    private long cdQ = 0;
    private long cdR = 0;
    private PostData cdU = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cdz = 0;
    public int ceb = 0;
    private String tieba_game_information_source = "";
    public String cee = "";
    public String ced = "";

    static {
        ccV.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        ccV.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        ccV.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        ccV.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        ccV.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        ccV.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        ccV.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        ccV.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cdK.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cdK.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cdK.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cdK.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cdK.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cdK.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cdK.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cdK.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        ccW.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        ccW.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        ccW.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cdL.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cdL.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cdL.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bh() {
        this.ccw = 0;
        this.ccG = 0;
        this.cdb = 0L;
        this.mUrl = "";
        this.cdn = "";
        this.cea = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cdb = 0L;
        this.ccG = 0;
        this.ccw = 0;
        this.cea = 0;
        this.mUrl = "";
        this.cdn = "";
        this.isBigGie = false;
    }

    public String aie() {
        return this.ces;
    }

    public String aif() {
        return this.cet;
    }

    public void mW(String str) {
        this.cet = str;
    }

    public String aig() {
        return this.ceu;
    }

    public SpannableStringBuilder aih() {
        return this.cev;
    }

    public SpannableString aii() {
        return this.cew;
    }

    public String aij() {
        return this.cex;
    }

    public String aik() {
        return this.cey;
    }

    public boolean ail() {
        return this.ccw == 1;
    }

    public bf aim() {
        return this.cdi;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void hE(int i) {
        this.anchorLevel = i;
    }

    public int ain() {
        return this.cdz;
    }

    public void hF(int i) {
        this.cdz = i;
    }

    public void hG(int i) {
        this.cde = i;
    }

    public int aio() {
        return this.cde;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aip() {
        return this.cej;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void aJ(long j) {
        this.mCreateTime = j;
    }

    public long aiq() {
        return this.ccM;
    }

    public String air() {
        return this.ccC;
    }

    public PraiseData ais() {
        return this.ccA;
    }

    public void a(PraiseData praiseData) {
        this.ccA = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String ait() {
        return this.ajL;
    }

    public void mX(String str) {
        this.ajL = str;
    }

    public void mY(String str) {
        this.cbZ = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void hH(int i) {
        this.cbY = i;
    }

    public int aiu() {
        return this.cbY;
    }

    public String aiv() {
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

    public List<PbContent> aiw() {
        return this.cdu;
    }

    public void ar(List<PbContent> list) {
        this.cdv = list;
    }

    public void as(List<PbContent> list) {
        this.cdw = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hI(int i) {
        this.reply_num = i;
    }

    public int aix() {
        return this.reply_num;
    }

    public int aiy() {
        return this.ccf;
    }

    public void hJ(int i) {
        this.ccf = i;
    }

    public long aiz() {
        return this.ccg;
    }

    public void aK(long j) {
        this.ccg = j;
    }

    public int aiA() {
        return this.cci;
    }

    public int aiB() {
        return this.cch;
    }

    public void hK(int i) {
        this.cch = i;
    }

    public int aiC() {
        return this.ccj;
    }

    public void hL(int i) {
        this.ccj = i;
    }

    public int aiD() {
        return this.cck;
    }

    public List<PbContent> aiE() {
        return this.cdv;
    }

    public bl aiF() {
        return this.ccl;
    }

    public MetaData aiG() {
        return this.ccm;
    }

    public boolean aiH() {
        return this.is_god != 0;
    }

    public boolean aiI() {
        return this.is_god == 1;
    }

    public boolean aiJ() {
        return (this.ccm == null || this.ccm.getGodUserData() == null || this.ccm.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aiK() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.ccm = metaData;
    }

    public String aiL() {
        return this.forum_name;
    }

    public void mZ(String str) {
        this.forum_name = str;
    }

    public int aiM() {
        return this.ccp;
    }

    public String aiN() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.ccr;
    }

    public void na(String str) {
        this.ccr = str;
    }

    public String N(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.cdw == null || this.cdw.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.cdw.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.cdw.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.cdv == null || (size = this.cdv.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.cdv.get(i2);
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
        if (this.cdw != null && (size = this.cdw.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.cdw.get(i2);
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

    public int aiO() {
        return this.ccx;
    }

    public void hM(int i) {
        this.ccx = i;
    }

    public String aiP() {
        return this.ccy;
    }

    public void nc(String str) {
        this.ccy = str;
    }

    public ArrayList<MediaData> aiQ() {
        return this.cct;
    }

    public ArrayList<b> aiR() {
        return this.ccR;
    }

    public void t(ArrayList<b> arrayList) {
        this.ccR = arrayList;
    }

    public bq aiS() {
        return this.ccS;
    }

    public g aiT() {
        return this.ccT;
    }

    public ArrayList<VoiceData.VoiceModel> aiU() {
        return this.ccu;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aiV() {
        return this.ccD;
    }

    public void hN(int i) {
        this.ccD = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aiW() {
        return this.ccO;
    }

    public VideoInfo aiX() {
        return this.ccI;
    }

    public VideoDesc aiY() {
        return this.ccJ;
    }

    public void a(AlaInfoData alaInfoData) {
        this.ccL = alaInfoData;
    }

    public AlaInfoData aiZ() {
        return this.ccL;
    }

    public PushStatusData aja() {
        return this.cdm;
    }

    public SkinInfo ajb() {
        return this.cdo;
    }

    public long ajc() {
        return this.cdE;
    }

    public boolean ajd() {
        return this.cdF;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agI() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agJ() {
        return this.cdG;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agK() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agI().getTid());
        ajVar.setFid(agI().getFid());
        ajVar.setFeedBackReasonMap(this.feedBackReasonMap);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ccE = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ccw = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ccM = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cce = threadInfo.repost_num.intValue();
                this.ccf = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.ccg = threadInfo.last_time_int.intValue();
                this.cch = threadInfo.is_top.intValue();
                this.cci = threadInfo.is_membertop.intValue();
                this.ccj = threadInfo.is_good.intValue();
                this.cck = threadInfo.is_livepost.intValue();
                this.ccl.a(threadInfo.topic);
                this.ccm.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.ccn = threadInfo.fname;
                this.cco = threadInfo.has_commented.intValue();
                this.ccp = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.ccI = threadInfo.video_info;
                this.ccJ = threadInfo.video_segment;
                this.ccL = new AlaInfoData();
                this.ccL.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.ccx = threadInfo.collect_status.intValue();
                this.ccy = threadInfo.collect_mark_pid;
                this.ccz = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.ccC = threadInfo.first_post_id + "";
                this.ccO = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.ccD = threadInfo.is_ntitle.intValue();
                this.ccF = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.cdS = threadInfo.agree.has_agree.intValue();
                    this.cdT = threadInfo.agree.agree_type.intValue();
                    this.cdQ = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.cdR = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.cdQ;
                    this.agreeData.disAgreeNum = this.cdR;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cdV = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.ccG = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cdx = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cdv = threadInfo.rich_title;
                this.cdu = threadInfo.first_post_content;
                this.cdw = threadInfo.rich_abstract;
                this.ccv = threadInfo.is_godthread_recommend.intValue();
                if ((this.ccm == null || this.ccm.getUserId() == null || this.ccm.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.ccm = metaData;
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
                this.ccr = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cct.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.ccI = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.ccK = new bn();
                    this.ccK.a(threadInfo.video_channel_info);
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
                        this.ccu.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.ccR.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ccS = new bq();
                    this.ccS.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.ccT = new g();
                    this.ccT.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ccU = new o();
                    this.ccU.a(threadInfo.cartoon_info);
                }
                this.ccA.setUserMap(this.userMap);
                this.ccA.parserProtobuf(threadInfo.zan);
                this.ccB.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ccA.setTitle(this.title);
                } else {
                    this.ccA.setTitle(this.ccr);
                }
                this.ccX = threadInfo.livecover_src;
                this.ccY = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ccQ = threadInfo.post_num.intValue();
                this.cdb = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jv(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.pe(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.ccH.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ccZ = noticeInfo.notice;
                    }
                    this.cde = zhiBoInfoTW.copythread_remind.intValue();
                    this.cdc = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cdd = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ccX)) {
                        this.ccX = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cdj = zhiBoInfoTW.user.tw_anchor_info;
                        this.cdk = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cda = threadInfo.twzhibo_info.livecover_status;
                    this.cdb = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cdf = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cdi.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cdl.add(cVar);
                    }
                }
                this.cdm.parserProtobuf(threadInfo.push_status);
                this.cdr = threadInfo.lego_card;
                this.cdo = threadInfo.skin_info;
                this.cds = threadInfo.is_book_chapter.intValue();
                this.cdt.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cdG = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cdE = threadInfo.last_read_pid.longValue();
                this.cdF = threadInfo.cheak_repeat.intValue() == 1;
                this.cdJ = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cdU.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.cdP = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cdW = new af();
                    this.cdW.a(threadInfo.link_info);
                }
                this.cdX = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cdY = new f();
                    this.cdY.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cdZ = new MediaData();
                    this.cdZ.parserProtobuf(threadInfo.pic_info);
                }
                this.cdz = threadInfo.is_called.intValue();
                this.cea = threadInfo.middle_page_num.intValue();
                this.ceb = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.ced = threadInfo.star_rank_icon.icon_pic_url;
                    this.cee = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cec = new OriginalThreadInfo();
                    this.cec.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.cec = new OriginalThreadInfo();
                    this.cec.parser(threadInfo.origin_thread_info);
                } else {
                    this.cec = null;
                }
                this.cef = threadInfo.is_topic.intValue();
                this.ceh = threadInfo.topic_user_name;
                this.cei = threadInfo.topic_h5_url;
                this.ceg = threadInfo.topic_module;
                this.cek = threadInfo.presentation_style;
                this.cem = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.ceo = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.ccb = new bd();
                    this.ccb.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.ceq = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.ceq, this);
                }
                this.ceB = threadInfo.t_share_img;
                aje();
                this.ceC = threadInfo.is_headlinepost.intValue() == 1;
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
                this.ccM = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cce = jSONObject.optInt("repost_num", 0);
                this.ccf = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.ccg = jSONObject.optLong("last_time_int", 0L);
                this.cch = jSONObject.optInt("is_top", 0);
                this.cci = jSONObject.optInt("is_membertop", 0);
                this.ccj = jSONObject.optInt("is_good", 0);
                this.cck = jSONObject.optInt("is_livepost", 0);
                this.ccl.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.ccm.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.ccn = this.forum_name;
                this.cco = jSONObject.optInt("has_commented", 0);
                this.ccp = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.ccx = jSONObject.optInt("collect_status");
                this.ccy = jSONObject.optString("collect_mark_pid");
                this.ccz = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cdQ = jSONObject.optInt("agree_num");
                this.cdV = jSONObject.optLong("share_num");
                this.ccC = jSONObject.optString("first_post_id", "0");
                this.ccO = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.ccD = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.cdS = optJSONObject2.optInt("has_agree");
                    this.cdQ = optJSONObject2.optInt("agree_num");
                    this.cdR = optJSONObject2.optLong("disagree_num");
                    this.cdT = optJSONObject2.optInt("agree_type");
                    if (this.cdQ < 0) {
                        this.cdQ = 0L;
                    }
                    if (this.cdR < 0) {
                        this.cdR = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.cdQ;
                    this.agreeData.disAgreeNum = this.cdR;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.cdi.parserJson(optJSONObject3);
                }
                if ((this.ccm == null || this.ccm.getUserId() == null) && this.userMap != null) {
                    this.ccm = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.ccL = new AlaInfoData();
                this.ccL.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.ccr = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cct.add(mediaData);
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
                        this.ccu.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ccR.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.ccS = new bq();
                    this.ccS.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.ccT = new g();
                    this.ccT.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.ccU = new o();
                    this.ccU.parserJson(optJSONObject7);
                }
                this.ccA.setUserMap(this.userMap);
                this.ccA.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.ccB.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.ccA.setTitle(this.title);
                } else {
                    this.ccA.setTitle(this.ccr);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.cdi.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cdl.add(cVar);
                    }
                }
                this.cds = jSONObject.optInt("is_book_chapter", 0);
                this.cdt.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cdG = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cdA = jSONObject.optString("recom_extra_img");
                this.cdD = jSONObject.optString("recom_extra_img_night");
                this.cdB = jSONObject.optInt("recom_extra_img_width", 0);
                this.cdC = jSONObject.optInt("recom_extra_img_height", 0);
                this.cdE = jSONObject.optLong("last_read_pid");
                this.cdF = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.ccK = new bn();
                    this.ccK.bt(optJSONObject9);
                }
                this.cdP = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.cdW = new af();
                    this.cdW.parserJson(optJSONObject10);
                }
                this.cdX = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.cdY = new f();
                    this.cdY.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.cdZ = new MediaData();
                    this.cdZ.parserJson(optJSONObject12);
                }
                this.cdz = jSONObject.optInt("is_called", 0);
                this.cea = jSONObject.optInt("middle_page_num", 0);
                this.ceb = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.ccI = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.cec = new OriginalThreadInfo();
                        this.cec.parserJson(optJSONObject14);
                    } else {
                        this.cec = null;
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
                    this.ceq = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.ceq, this);
                }
                this.ceB = jSONObject.optString("t_share_img");
                aje();
                this.ceC = jSONObject.optInt("is_headlinepost", 0) == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void aje() {
        ajf();
        ajg();
        ajh();
        aji();
        ajj();
        ajk();
        ajl();
    }

    private void ajf() {
        if (!StringUtils.isNull(this.ccm.getName_show())) {
            this.ces = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.ccm.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void ajg() {
        if (aiK()) {
            this.cet = com.baidu.tbadk.core.util.aq.aS(aiz() * 1000);
        } else if (akw()) {
            String aS = com.baidu.tbadk.core.util.aq.aS(aiz() * 1000);
            if (com.baidu.tbadk.core.util.aq.nS(aS)) {
                aS = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aiz() * 1000);
            }
            this.cet = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aS;
        } else {
            String aS2 = com.baidu.tbadk.core.util.aq.aS(aiz() * 1000);
            if (com.baidu.tbadk.core.util.aq.nS(aS2)) {
                aS2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aiz() * 1000);
            }
            this.cet = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aS2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.cet += " • " + getAddress();
        }
    }

    private void ajh() {
        if (aiZ() == null || aiZ().share_info == null || aiZ().share_info.share_user_count <= 0 || !ajT() || (this.cea > 0 && this.ceb == 0)) {
            this.ceu = null;
            return;
        }
        int i = aiZ().share_info.share_user_count;
        if (i == 1) {
            this.ceu = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.ceu = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aji() {
        this.cev = akf();
    }

    private void ajj() {
        this.cew = akg();
    }

    private void ajk() {
        this.cex = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aiz() * 1000);
    }

    private void ajl() {
        this.cey = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aiz());
    }

    public SpannableStringBuilder ajm() {
        return this.ccq;
    }

    public boolean ajn() {
        return aiB() != 0;
    }

    public int ajo() {
        if (this.cdi != null) {
            long ahZ = this.cdi.ahZ();
            long aia = this.cdi.aia();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ahZ) {
                return 1;
            }
            if (currentTimeMillis > aia) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int ajp() {
        if (ajr() && this.ccR.size() >= 1) {
            b bVar = this.ccR.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int agN = bVar.agN();
            int agO = bVar.agO();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < agN) {
                return 4;
            }
            return currentTimeMillis > agO ? 2 : 1;
        }
        return -1;
    }

    public int ajq() {
        if (!ajr() || this.ccR.size() < 1 || this.ccR.get(0) == null) {
            return -1;
        }
        return this.ccR.get(0).agM();
    }

    public boolean ajr() {
        return this.ccF == 1;
    }

    public String getActUrl() {
        return (!ajr() || this.ccR.size() < 1 || this.ccR.get(0) == null) ? "" : this.ccR.get(0).getUrl();
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

    public SmartApp ajs() {
        return this.ceq;
    }

    private void p(boolean z, boolean z2) {
        SpannableString spannableString;
        String N = N(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aju()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aiB() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aiB() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aiD() == 1 || this.ccl.akF() != 0) {
                if (aim() != null && getThreadType() == 41) {
                    if (ajo() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && ajG()) {
                Integer num = ccW.get(Integer.valueOf(ajo()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aiC() == 1 && !ajn() && cbI != getType() && cbN != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.ccB != null && this.ccB.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aiM() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = ccV.get(new Point(ajq(), ajp()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aiS() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aiT() != null) {
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
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cca));
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
        this.ccq = spannableStringBuilder;
    }

    public boolean ajt() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aiG() != null) {
            if (aiG().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aiG().getGender() == 2) {
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

    private boolean aju() {
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
        this.ccq = spannableStringBuilder;
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
            if (this.ccD == 1) {
                this.ccq = a;
                return a;
            }
        } else if (this.ccD == 1) {
            this.ccq = new SpannableStringBuilder();
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
        this.cdn = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a Q;
        com.baidu.adp.widget.ImageView.a Q2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.cdn) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.avu().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.e.w.P(this.mUrl, 10)) && (Q = com.baidu.tbadk.core.util.e.w.Q(this.mUrl, 10)) != null) {
                bitmap = Q.getRawBitmap();
                com.baidu.tbadk.imageManager.c.avu().addBitmap(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.avu().getBitmap(this.cdn);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.e.w.P(this.cdn, 10)) && (Q2 = com.baidu.tbadk.core.util.e.w.Q(this.cdn, 10)) != null) {
                bitmap2 = Q2.getRawBitmap();
                com.baidu.tbadk.imageManager.c.avu().addBitmap(this.cdn, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cca));
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
                        com.baidu.tbadk.imageManager.c.avu().addBitmap(str2, aVar.getRawBitmap());
                    }
                }
            }, cbG);
            com.baidu.adp.lib.f.c.fT().a(this.cdn, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.avu().addBitmap(str2, aVar.getRawBitmap());
                    }
                }
            }, cbG);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.cdv != null && this.cdv.size() > 0) {
            int size = this.cdv.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.cdv.get(i2);
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

    public ActivityItemData ajv() {
        if (this.cdv != null && this.cdv.size() > 0) {
            int size = this.cdv.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cdv.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && ajA() && pbContent.text != null && pbContent.text.length() >= 3) {
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
            kVar.type = this.cbY;
            kVar.cEe = this.cbZ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
        }
    }

    public void ajw() {
        p(false, false);
    }

    public void ajx() {
        p(false, true);
    }

    public AnchorInfoData ajy() {
        return this.ccB;
    }

    public boolean ajz() {
        return this.threadType == 36;
    }

    public boolean ajA() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean ajB() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aiQ = aiQ();
        if (aiQ == null || ajn()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aiQ.size() || i2 >= 3) {
                break;
            }
            if (aiQ.get(i2) != null && aiQ.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aiQ.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aiQ.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aiQ.get(i2).getPicUrl();
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
        if (this.ccI != null && !StringUtils.isNull(this.ccI.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.ccI.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.ccm != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.ccm.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ajC() {
        String userId;
        return this.ccm == null || (userId = this.ccm.getUserId()) == null || userId.equals("0");
    }

    public boolean ajD() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (akt()) {
            if (aiX() != null) {
                return cbI;
            }
            return cbu;
        }
        int aiB = aiB();
        if (this.cef == 1) {
            if (this.ceg != null) {
                return cbF;
            }
            return this.cej != null ? cbP : cbO;
        } else if (this.ccI != null && akk()) {
            return cbX;
        } else {
            if (this.ccL != null && this.threadType == 60) {
                return cbL;
            }
            if (this.ccL != null && this.threadType == 49) {
                return cbJ;
            }
            if (this.threadType == 51) {
                return cbK;
            }
            if (this.threadType == 63) {
                return cbQ;
            }
            if (this.threadType == 64) {
                return cbR;
            }
            if (aiB == 2 || aiB == 1) {
                return cbt;
            }
            if (this.ccI != null && ajL() && !ajD()) {
                return cbW;
            }
            if (this.ccI != null && !ajD()) {
                if (aiJ()) {
                    return cbN;
                }
                return cbI;
            } else if (this.isShareThread) {
                return cbM;
            } else {
                if (ajF()) {
                    return cbT.get() ? cdh : cbu;
                } else if (ajr() && ajq() == 1) {
                    return cbT.get() ? cdp : cbu;
                } else if (isLinkThread()) {
                    return cbG;
                } else {
                    if (aiJ()) {
                        return cbH;
                    }
                    if (this.cbg) {
                        return cby;
                    }
                    if (this.cbh) {
                        return cbz;
                    }
                    if (this.cbi) {
                        return cbA;
                    }
                    if (this.cbj) {
                        return cbB;
                    }
                    if (this.cbk) {
                        return cbC;
                    }
                    if (this.cbl) {
                        return cbD;
                    }
                    if (this.cbm) {
                        return cbE;
                    }
                    if (this.ccP) {
                        int ajE = ajE();
                        if (ajE == 1) {
                            return cbv;
                        }
                        if (ajE == 2) {
                            return cbw;
                        }
                        if (ajE > 2) {
                            return cbx;
                        }
                        return cbu;
                    }
                    return cbu;
                }
            }
        }
    }

    public int ajE() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.agq().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aiQ()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aiQ().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean ajF() {
        return aim() != null && getThreadType() == 41 && aiD() == 1 && ajo() == 2;
    }

    public void u(ArrayList<p> arrayList) {
        if (this.ccD == 1) {
            this.bYs = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bYs = 0;
        } else {
            this.bYs = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.agU() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.agU().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bYs = next.agV();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean ajG() {
        return this.threadType == 41;
    }

    public boolean ajH() {
        return this.cdq;
    }

    public void dZ(boolean z) {
        this.cdq = z;
    }

    public String ajI() {
        return this.cdr;
    }

    public o ajJ() {
        return this.ccU;
    }

    public void ajK() {
        if (this.ccN == 0) {
            this.ccN = 1;
        }
    }

    public void ea(boolean z) {
        this.cdH = z;
    }

    public boolean ajL() {
        return this.cdH;
    }

    public void hO(int i) {
        this.cdI = i + 1;
    }

    public int ajM() {
        return this.cdI;
    }

    public List<ReportInfo> ajN() {
        return this.cdJ;
    }

    public boolean ajO() {
        return this.cdy;
    }

    public void eb(boolean z) {
        this.cdy = z;
    }

    public bn ajP() {
        return this.ccK;
    }

    public void a(bn bnVar) {
        this.ccK = bnVar;
    }

    public void setCurrentPage(int i) {
        if (this.ccK != null) {
            this.ccK.ZN = i;
        }
    }

    public boolean ajQ() {
        return getThreadType() == 49;
    }

    public boolean ajR() {
        return getThreadType() == 40;
    }

    public boolean ajS() {
        return getThreadType() == 50;
    }

    public boolean ajT() {
        return getThreadType() == 60;
    }

    public boolean ajU() {
        return getThreadType() == 40 && ajP() != null && ajP().channelId > 0;
    }

    public int ajV() {
        return this.cdO;
    }

    public void setSmartFrsPosition(int i) {
        this.cdO = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String ajW() {
        return this.mRecomSource;
    }

    public boolean ajX() {
        return this.cdP;
    }

    public long ajY() {
        return this.cdQ;
    }

    public long ajZ() {
        return this.cdR;
    }

    public int aka() {
        return this.cdS;
    }

    public int akb() {
        return this.cdT;
    }

    public void hP(int i) {
        this.cdS = i;
    }

    public void hQ(int i) {
        this.cdQ = i;
    }

    public void aL(long j) {
        this.cdQ = j;
    }

    public void aM(long j) {
        this.cdR = j;
    }

    public void hR(int i) {
        this.cdT = i;
    }

    public long akc() {
        return this.cdV;
    }

    public void aN(long j) {
        this.cdV = j;
    }

    public PostData akd() {
        return this.cdU;
    }

    public af ake() {
        return this.cdW;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        String N;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.ccD == 1) {
            N = N(this.ccr, true);
            a = nb(this.ccr);
        } else {
            N = N(this.title, false);
            a = a(new SpannableString(N + HanziToPinyin.Token.SEPARATOR));
        }
        if (z) {
            spannableStringBuilder = a(N, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.ccq = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder r(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder s(boolean z, boolean z2) {
        SpannableString nb;
        if (!StringUtils.isNull(this.title) && this.ccD != 1) {
            nb = a(new SpannableString(N(this.title, false) + HanziToPinyin.Token.SEPARATOR));
        } else {
            nb = nb(this.ccr);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(nb);
        this.ccq = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder akf() {
        if (StringUtils.isNull(this.title) || this.ccD == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(N(this.title, false) + HanziToPinyin.Token.SEPARATOR)));
        this.ccq = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString akg() {
        return nb(this.ccr);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean aiH = aiH();
        if (z2) {
            if (z) {
                if (aiH && !ajA()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (aiD() == 1 || getThreadType() == 33 || (aiF() != null && aiF().akF() != 0)) {
                    if (aim() != null && ajG()) {
                        if (ajo() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!aiH) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (ajG()) {
                    arrayList.add(cdL.get(ajo()));
                }
                if (ajr()) {
                    Integer num = cdK.get(new Point(ajq(), ajp()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (aiS() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (aiH && aiB() != 1 && !ajA()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((aiD() == 1 || getThreadType() == 33) && !ajG() && !aiH) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (aiC() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (aiB() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (ajG() && aim() != null && ajo() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (ajr()) {
                    Integer num2 = cdK.get(new Point(ajq(), ajp()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cds == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (aiT() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aiS() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && ajQ()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (ajU()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && ajS()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (ajR()) {
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
        this.cct = arrayList;
    }

    public String akh() {
        return this.ceh;
    }

    public void ng(String str) {
        this.ceh = str;
    }

    public void aki() {
        this.cef = 1;
    }

    public boolean akj() {
        return this.cef == 1;
    }

    public boolean akk() {
        return this.cek.equals("worldcupvideo");
    }

    public String akl() {
        return this.ccc;
    }

    public void nh(String str) {
        this.ccc = str;
    }

    public String akm() {
        return this.ccd;
    }

    public void ni(String str) {
        this.ccd = str;
    }

    public String akn() {
        return this.cei;
    }

    public void nj(String str) {
        this.cei = str;
    }

    public boolean ako() {
        return this.cel;
    }

    public void ec(boolean z) {
        this.cel = z;
    }

    public void a(VideoInfo videoInfo) {
        this.cej = videoInfo;
    }

    public boolean akp() {
        return this.cem != null;
    }

    public String akq() {
        return this.ccn;
    }

    public String akr() {
        return this.ceo;
    }

    public bd aks() {
        return this.ccb;
    }

    public boolean akt() {
        return this.cep;
    }

    public void ed(boolean z) {
        this.cep = z;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.ccI != null) {
            return this.ccI.video_url;
        }
        return null;
    }

    public boolean aku() {
        return this.cer;
    }

    public void ee(boolean z) {
        this.cer = z;
    }

    public AgreeData akv() {
        return this.agreeData;
    }

    public boolean akw() {
        return this.ceA;
    }

    public void ef(boolean z) {
        this.ceA = z;
    }

    public TopicModule akx() {
        return this.ceg;
    }

    public String getShareImageUrl() {
        return this.ceB;
    }

    void a(SmartApp smartApp, bh bhVar) {
        if (smartApp != null && bhVar != null) {
            MetaData aiG = bhVar.aiG();
            if (com.baidu.tbadk.core.util.aq.isEmpty(smartApp.name)) {
                aiG.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                aiG.setName_show(smartApp.name);
            }
            aiG.setPortrait(smartApp.avatar);
        }
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aiQ = aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aiQ) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aiQ.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ, 0);
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

    public int[] aky() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aiQ = aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aiQ) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aiQ.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aiQ, 0);
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

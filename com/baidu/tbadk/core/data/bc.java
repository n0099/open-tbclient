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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.video.ActivityItemData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bc extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h, com.baidu.tbadk.core.util.af {
    private String address;
    private String aiF;
    private SpannableStringBuilder aiI;
    public int aiM;
    private int aiN;
    private int aiQ;
    private String aiT;
    private int aiU;
    private String aiV;
    private int aiX;
    private VideoInfo aiZ;
    private String aiu;
    private String aiv;
    private String ajC;
    private SkinInfo ajD;
    private boolean ajF;
    private String ajG;
    private boolean ajL;
    private boolean ajM;
    public long ajO;
    public String ajQ;
    private List<ReportInfo> ajT;
    private boolean ajZ;
    private bi aja;
    private AlaInfoData ajb;
    private long ajc;
    private n ajj;
    private LiveCoverStatus ajp;
    private long ajq;
    public TwZhiBoUser ajy;
    public List<TwAnchorProfitItem> ajz;
    private int akb;
    private long akd;
    private ae ake;
    public d akg;
    private MediaData akh;
    public int aki;
    public OriginalThreadInfo akk;
    private String ako;
    private String akp;
    private VideoInfo akq;
    private String akr;
    public OriginalForumInfo akt;
    public boolean aku;
    private String authorId;
    private boolean isLinkThread;
    public boolean isShareThread;
    private String latitude;
    private long mCreateTime;
    private String mFromType;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private String mUrl;
    private int post_num;
    public int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId aia = BdUniqueId.gen();
    public static final BdUniqueId aib = BdUniqueId.gen();
    public static final BdUniqueId aic = BdUniqueId.gen();
    public static final BdUniqueId aid = BdUniqueId.gen();
    public static final BdUniqueId aie = BdUniqueId.gen();
    public static final BdUniqueId aif = BdUniqueId.gen();
    public static final BdUniqueId aig = BdUniqueId.gen();
    public static final BdUniqueId aih = BdUniqueId.gen();
    public static final BdUniqueId aii = BdUniqueId.gen();
    public static final BdUniqueId aij = BdUniqueId.gen();
    public static final BdUniqueId aik = BdUniqueId.gen();
    public static final BdUniqueId ail = BdUniqueId.gen();
    public static AtomicBoolean aim = new AtomicBoolean(false);
    public static AtomicBoolean ain = new AtomicBoolean(false);
    public static AtomicBoolean aio = new AtomicBoolean(false);
    public static final BdUniqueId aip = BdUniqueId.gen();
    public static final BdUniqueId aiq = BdUniqueId.gen();
    private static HashMap<Point, Integer> ajk = new HashMap<>();
    private static HashMap<Integer, Integer> ajl = new HashMap<>();
    public static final BdUniqueId ajv = BdUniqueId.gen();
    public static final BdUniqueId ajw = BdUniqueId.gen();
    public static final BdUniqueId ajE = BdUniqueId.gen();
    private static HashMap<Point, Integer> ajU = new HashMap<>();
    private static SparseArray<o.a> ajV = new SparseArray<>(3);
    private int air = 0;
    private String ais = "1";
    public int ait = 1;
    private String aiP = null;
    private int aft = 0;
    public int ajd = 0;
    private String aje = "";
    private String ajm = "";
    public boolean ajP = true;
    public boolean ajW = false;
    public boolean ajX = false;
    private int ajY = -1;
    private SparseArray<String> agZ = null;
    public boolean akf = false;
    private int akn = 0;
    private boolean aks = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aiw = 0;
    private int aix = 0;
    private String last_time = null;
    private long aiy = 0;
    private int aiz = 0;
    private int aiA = 0;
    private int aiB = 0;
    private int aiC = 0;
    private bg aiD = new bg();
    private MetaData aiE = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aiK = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aiL = new ArrayList<>();
    private int aiG = 0;
    private int aiH = 0;
    private String ad_url = null;
    private String aiJ = null;
    private String from = null;
    private int aiO = 0;
    private PraiseData aiR = new PraiseData();
    private AnchorInfoData aiS = new AnchorInfoData();
    private long time = 0;
    private int aiW = 0;
    private ArrayList<a> ajg = new ArrayList<>();
    private bl ajh = null;
    private e aji = null;
    private int ajn = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aiY = new ArrayList<>();
    private boolean isHeadLive = false;
    private String ajo = null;
    private int ajf = 0;
    private boolean ajr = false;
    private boolean ajs = false;
    private int ajt = 0;
    private boolean aju = false;
    private int anchorLevel = 0;
    public int ajH = 0;
    public k ajI = new k();
    private List<PbContent> ajJ = new ArrayList();
    private List<PbContent> ajK = new ArrayList();
    private String category_name = null;
    private bb ajx = new bb();
    private ArrayList<com.baidu.tbadk.data.c> ajA = new ArrayList<>();
    private PushStatusData ajB = new PushStatusData();
    public boolean ajR = false;
    public int ajS = -1;
    private int aka = 0;
    private PostData akc = new PostData();
    private int ajN = 0;
    public int akj = 0;
    private String tieba_game_information_source = "";
    public String akm = "";
    public String akl = "";

    static {
        ajk.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        ajk.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        ajk.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        ajk.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        ajk.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        ajk.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        ajk.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        ajk.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        ajU.put(new Point(1, 1), Integer.valueOf(d.k.lottery_status_ing));
        ajU.put(new Point(1, 2), Integer.valueOf(d.k.lottery_status_over));
        ajU.put(new Point(1, 3), Integer.valueOf(d.k.lottery_status_off));
        ajU.put(new Point(1, 4), Integer.valueOf(d.k.lottery_status_not_start));
        ajU.put(new Point(2, 1), Integer.valueOf(d.k.share_picture_status_ing));
        ajU.put(new Point(2, 2), Integer.valueOf(d.k.share_picture_status_over));
        ajU.put(new Point(2, 3), Integer.valueOf(d.k.share_picture_status_off));
        ajU.put(new Point(2, 4), Integer.valueOf(d.k.share_picture_status_not_start));
        ajl.put(1, Integer.valueOf(d.f.label_interview_no));
        ajl.put(2, Integer.valueOf(d.f.label_interview_live));
        ajl.put(3, Integer.valueOf(d.f.label_interview_off));
        ajV.put(1, new o.a(d.k.interview_live_status_not_start, d.C0142d.cp_other_b, d.f.pic_dot_title_red));
        ajV.put(2, new o.a(d.k.interview_live_status_ing, d.C0142d.cp_other_c, d.f.pic_dot_title_green));
        ajV.put(3, new o.a(d.k.interview_live_status_over, d.C0142d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bc() {
        this.aiN = 0;
        this.aiX = 0;
        this.ajq = 0L;
        this.mUrl = "";
        this.ajC = "";
        this.aki = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.ajq = 0L;
        this.aiX = 0;
        this.aiN = 0;
        this.aki = 0;
        this.mUrl = "";
        this.ajC = "";
    }

    public boolean vc() {
        return this.aiN == 1;
    }

    public bb vd() {
        return this.ajx;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bO(int i) {
        this.anchorLevel = i;
    }

    public int ve() {
        return this.ajN;
    }

    public void bP(int i) {
        this.ajN = i;
    }

    public void bQ(int i) {
        this.ajt = i;
    }

    public int vf() {
        return this.ajt;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo vg() {
        return this.akq;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long vh() {
        return this.ajc;
    }

    public String vi() {
        return this.aiT;
    }

    public PraiseData vj() {
        return this.aiR;
    }

    public void a(PraiseData praiseData) {
        this.aiR = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String vk() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(String str) {
        this.ais = str;
    }

    public String getId() {
        return this.id;
    }

    public void dk(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.air = i;
    }

    public int vl() {
        return this.air;
    }

    public String vm() {
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

    public void v(List<PbContent> list) {
        this.ajJ = list;
    }

    public void w(List<PbContent> list) {
        this.ajK = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void bR(int i) {
        this.reply_num = i;
    }

    public int vn() {
        return this.reply_num;
    }

    public int vo() {
        return this.aix;
    }

    public void bS(int i) {
        this.aix = i;
    }

    public long vp() {
        return this.aiy;
    }

    public void q(long j) {
        this.aiy = j;
    }

    public int vq() {
        return this.aiA;
    }

    public int vr() {
        return this.aiz;
    }

    public void bT(int i) {
        this.aiz = i;
    }

    public int vs() {
        return this.aiB;
    }

    public void bU(int i) {
        this.aiB = i;
    }

    public int vt() {
        return this.aiC;
    }

    public List<PbContent> vu() {
        return this.ajJ;
    }

    public bg vv() {
        return this.aiD;
    }

    public MetaData vw() {
        return this.aiE;
    }

    public boolean vx() {
        return this.is_god != 0;
    }

    public boolean vy() {
        return this.is_god == 1;
    }

    public boolean vz() {
        return (this.aiE == null || this.aiE.getGodUserData() == null || this.aiE.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean vA() {
        return (this.aiE == null || this.aiE.getGodUserData() == null || this.aiE.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aiE = metaData;
    }

    public String vB() {
        return this.forum_name;
    }

    public void dp(String str) {
        this.forum_name = str;
    }

    public int vC() {
        return this.aiH;
    }

    public String vD() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aiJ;
    }

    public void dq(String str) {
        this.aiJ = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ajK == null || this.ajK.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ajK.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ajK.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ajJ == null || (size = this.ajJ.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ajJ.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString dr(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.ajK != null && (size = this.ajK.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajK.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bc.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bc.this.dv(pbContent.link);
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

    public int vE() {
        return this.aiO;
    }

    public void bV(int i) {
        this.aiO = i;
    }

    public String vF() {
        return this.aiP;
    }

    public void ds(String str) {
        this.aiP = str;
    }

    public ArrayList<MediaData> vG() {
        return this.aiK;
    }

    public ArrayList<a> vH() {
        return this.ajg;
    }

    public void l(ArrayList<a> arrayList) {
        this.ajg = arrayList;
    }

    public bl vI() {
        return this.ajh;
    }

    public e vJ() {
        return this.aji;
    }

    public ArrayList<VoiceData.VoiceModel> vK() {
        return this.aiL;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int vL() {
        return this.aiU;
    }

    public void bW(int i) {
        this.aiU = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String vM() {
        return this.aje;
    }

    public VideoInfo vN() {
        return this.aiZ;
    }

    public void a(AlaInfoData alaInfoData) {
        this.ajb = alaInfoData;
    }

    public AlaInfoData vO() {
        return this.ajb;
    }

    public PushStatusData vP() {
        return this.ajB;
    }

    public SkinInfo vQ() {
        return this.ajD;
    }

    public long vR() {
        return this.ajO;
    }

    public boolean vS() {
        return this.ajP;
    }

    public String vT() {
        return this.ajQ;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aiV = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aiN = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ajc = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aiw = threadInfo.repost_num.intValue();
                this.aix = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aiy = threadInfo.last_time_int.intValue();
                this.aiz = threadInfo.is_top.intValue();
                this.aiA = threadInfo.is_membertop.intValue();
                this.aiB = threadInfo.is_good.intValue();
                this.aiC = threadInfo.is_livepost.intValue();
                this.aiD.a(threadInfo.topic);
                this.aiE.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aiF = threadInfo.fname;
                this.aiG = threadInfo.has_commented.intValue();
                this.aiH = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aiZ = threadInfo.video_info;
                this.ajb = new AlaInfoData();
                this.ajb.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aiO = threadInfo.collect_status.intValue();
                this.aiP = threadInfo.collect_mark_pid;
                this.aiQ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aiT = threadInfo.first_post_id + "";
                this.aje = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aiU = threadInfo.is_ntitle.intValue();
                this.aiW = threadInfo.is_activity.intValue();
                this.aka = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.akb = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.akd = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aiX = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ajL = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ajJ = threadInfo.rich_title;
                this.ajK = threadInfo.rich_abstract;
                this.aiM = threadInfo.is_godthread_recommend.intValue();
                if ((this.aiE == null || this.aiE.getUserId() == null || this.aiE.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aiE = metaData;
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
                this.aiJ = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aiK.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aiZ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aja = new bi();
                    this.aja.a(threadInfo.video_channel_info);
                }
                List<Voice> list3 = threadInfo.voice_info;
                if (list3 != null) {
                    int size = list3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        Voice voice = list3.get(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = voice.voice_md5;
                        voiceModel.duration = voice.during_time.intValue() / 1000;
                        this.aiL.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ajg.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.ajh = new bl();
                    this.ajh.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aji = new e();
                    this.aji.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.ajj = new n();
                    this.ajj.a(threadInfo.cartoon_info);
                }
                this.aiR.setUserMap(this.userMap);
                this.aiR.parserProtobuf(threadInfo.zan);
                this.aiS.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aiR.setTitle(this.title);
                } else {
                    this.aiR.setTitle(this.aiJ);
                }
                this.ajm = threadInfo.livecover_src;
                this.ajn = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ajf = threadInfo.post_num.intValue();
                this.ajq = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.et(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gf(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aiY.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.ajo = noticeInfo.notice;
                    }
                    this.ajt = zhiBoInfoTW.copythread_remind.intValue();
                    this.ajr = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.ajs = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.ajm)) {
                        this.ajm = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.ajy = zhiBoInfoTW.user.tw_anchor_info;
                        this.ajz = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.ajp = threadInfo.twzhibo_info.livecover_status;
                    this.ajq = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aju = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ajx.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.ajA.add(cVar);
                    }
                }
                this.ajB.parserProtobuf(threadInfo.push_status);
                this.ajG = threadInfo.lego_card;
                this.ajD = threadInfo.skin_info;
                this.ajH = threadInfo.is_book_chapter.intValue();
                this.ajI.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.ajQ = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.ajO = threadInfo.last_read_pid.longValue();
                this.ajP = threadInfo.cheak_repeat.intValue() == 1;
                this.ajT = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.akc.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.w.z(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.agZ = sparseArray;
                }
                this.ajZ = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.ake = new ae();
                    this.ake.a(threadInfo.link_info);
                }
                this.akf = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.akg = new d();
                    this.akg.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.akh = new MediaData();
                    this.akh.parserProtobuf(threadInfo.pic_info);
                }
                this.ajN = threadInfo.is_called.intValue();
                this.aki = threadInfo.middle_page_num.intValue();
                this.akj = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.akl = threadInfo.star_rank_icon.icon_pic_url;
                    this.akm = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.akk = new OriginalThreadInfo();
                    this.akk.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.akk = new OriginalThreadInfo();
                    this.akk.parser(threadInfo.origin_thread_info);
                } else {
                    this.akk = null;
                }
                this.akn = threadInfo.is_topic.intValue();
                this.ako = threadInfo.topic_user_name;
                this.akp = threadInfo.topic_h5_url;
                this.akr = threadInfo.presentation_style;
                this.akt = OriginalForumInfo.parser(threadInfo.ori_forum_info);
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
                this.fid = jSONObject.optLong(ImageViewerConfig.FORUM_ID, 0L);
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.is_god = jSONObject.optInt("is_god");
                this.mCreateTime = jSONObject.optLong("create_time", 0L) * 1000;
                this.ajc = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aiw = jSONObject.optInt("repost_num", 0);
                this.aix = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aiy = jSONObject.optLong("last_time_int", 0L);
                this.aiz = jSONObject.optInt("is_top", 0);
                this.aiA = jSONObject.optInt("is_membertop", 0);
                this.aiB = jSONObject.optInt("is_good", 0);
                this.aiC = jSONObject.optInt("is_livepost", 0);
                this.aiD.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aiE.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aiF = this.forum_name;
                this.aiG = jSONObject.optInt("has_commented", 0);
                this.aiH = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aiO = jSONObject.optInt("collect_status");
                this.aiP = jSONObject.optString("collect_mark_pid");
                this.aiQ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aka = jSONObject.optInt("agree_num");
                this.akd = jSONObject.optLong("share_num");
                this.aiT = jSONObject.optString("first_post_id", "0");
                this.aje = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.aiU = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.akb = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ajx.parserJson(optJSONObject2);
                }
                if ((this.aiE == null || this.aiE.getUserId() == null) && this.userMap != null) {
                    this.aiE = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.ajb = new AlaInfoData();
                this.ajb.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aiJ = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aiK.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.aiL.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ajg.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.ajh = new bl();
                    this.ajh.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aji = new e();
                    this.aji.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.ajj = new n();
                    this.ajj.parserJson(optJSONObject6);
                }
                this.aiR.setUserMap(this.userMap);
                this.aiR.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aiS.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aiR.setTitle(this.title);
                } else {
                    this.aiR.setTitle(this.aiJ);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ajx.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ajA.add(cVar);
                    }
                }
                this.ajH = jSONObject.optInt("is_book_chapter", 0);
                this.ajI.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.ajQ = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.ajO = jSONObject.optLong("last_read_pid");
                this.ajP = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aja = new bi();
                    this.aja.p(optJSONObject8);
                }
                this.ajZ = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.ake = new ae();
                    this.ake.parserJson(optJSONObject9);
                }
                this.akf = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.akg = new d();
                    this.akg.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.akh = new MediaData();
                    this.akh.parserJson(optJSONObject11);
                }
                this.ajN = jSONObject.optInt("is_called", 0);
                this.aki = jSONObject.optInt("middle_page_num", 0);
                this.akj = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    builder.video_duration = new Integer(optJSONObject12.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject12.optInt("video_type", 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    this.aiZ = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.akk = new OriginalThreadInfo();
                        this.akk.parserJson(optJSONObject13);
                        return;
                    }
                    this.akk = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder vU() {
        return this.aiI;
    }

    public boolean vV() {
        return vr() != 0;
    }

    public int vW() {
        if (this.ajx != null) {
            long uY = this.ajx.uY();
            long uZ = this.ajx.uZ();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < uY) {
                return 1;
            }
            if (currentTimeMillis > uZ) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int vX() {
        if (vZ() && this.ajg.size() >= 1) {
            a aVar = this.ajg.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int tP = aVar.tP();
            int tQ = aVar.tQ();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < tP) {
                return 4;
            }
            return currentTimeMillis > tQ ? 2 : 1;
        }
        return -1;
    }

    public int vY() {
        if (!vZ() || this.ajg.size() < 1 || this.ajg.get(0) == null) {
            return -1;
        }
        return this.ajg.get(0).tO();
    }

    public boolean vZ() {
        return this.aiW == 1;
    }

    public String getActUrl() {
        return (!vZ() || this.ajg.size() < 1 || this.ajg.get(0) == null) ? "" : this.ajg.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dt(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(d.i.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(d.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0142d.cp_cont_f_1));
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

    private void d(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && wb()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (vr() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (vr() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (vt() == 1 || this.aiD.xb() != 0) {
                if (vd() != null && getThreadType() == 41) {
                    if (vW() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && wl()) {
                Integer num = ajl.get(Integer.valueOf(vW()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (vs() == 1 && !vV() && aie != getType() && aij != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.aiS != null && this.aiS.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (vC() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = ajk.get(new Point(vY(), vX()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (vI() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (vJ() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = dt(this.category_name);
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
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= arrayList.size()) {
                    break;
                }
                Bitmap cR = com.baidu.tbadk.core.util.am.cR(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ait));
                spannableString.setSpan(jVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(g + " "));
        if (a != null) {
            SpannableStringBuilder c = !z && vr() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aiI = spannableStringBuilder;
    }

    public boolean wa() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || vN() == null || vN().video_type.intValue() == 0) {
            return i == 1 && vN() != null && (vN().video_type.intValue() == 1 || vN().video_type.intValue() == 12 || vN().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap cR = com.baidu.tbadk.core.util.am.cR(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
        com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (vw() != null) {
            if (vw().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.he));
            } else if (vw().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(kVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder c(String str, ArrayList<o.a> arrayList) {
        if (wh() || !vx() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(d.k.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean wb() {
        return com.baidu.adp.lib.b.d.hv().aw("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.w.z(a(z, z2, z3, false)) > 0) {
            f(z, z3);
            return;
        }
        String g = g(this.title, false);
        SpannableString a = a(new SpannableString(g + " "));
        if (z) {
            spannableStringBuilder = a(g, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aiI = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> a = a(z, z2, z3, z4);
        if (a == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a2 = com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, a, false);
        if (a.size() > 0) {
            if (a2 == null) {
                a2 = new SpannableStringBuilder();
            }
            if (this.aiU == 1) {
                this.aiI = a2;
                return a2;
            }
        } else if (this.aiU == 1) {
            this.aiI = new SpannableStringBuilder();
            return a2;
        }
        if (spannableString != null) {
            a2.append((CharSequence) spannableString);
            return a2;
        } else if (a.size() > 0 || a2.length() == 0) {
            a2.append((CharSequence) str);
            return a2;
        } else {
            return a2;
        }
    }

    public void P(String str, String str2) {
        this.mUrl = str;
        this.ajC = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a w;
        com.baidu.adp.widget.ImageView.a w2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajC) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.IV().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.v(this.mUrl, 10)) && (w = com.baidu.tbadk.core.util.d.v.w(this.mUrl, 10)) != null) {
                bitmap = w.mZ();
                com.baidu.tbadk.imageManager.c.IV().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.IV().getBitmap(this.ajC);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.v(this.ajC, 10)) && (w2 = com.baidu.tbadk.core.util.d.v.w(this.ajC, 10)) != null) {
                bitmap2 = w2.mZ();
                com.baidu.tbadk.imageManager.c.IV().b(this.ajC, bitmap2);
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
                        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable);
                        lVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ait));
                        spannableString.setSpan(lVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.ig().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bc.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.IV().b(str2, aVar.mZ());
                    }
                }
            }, aic);
            com.baidu.adp.lib.f.c.ig().a(this.ajC, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bc.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.IV().b(str2, aVar.mZ());
                    }
                }
            }, aic);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.ajJ != null && this.ajJ.size() > 0) {
            int size = this.ajJ.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajJ.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bc.4
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bc.this.dv(pbContent.link);
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

    private String du(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData wc() {
        if (this.ajJ != null && this.ajJ.size() > 0) {
            int size = this.ajJ.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.ajJ.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && wh() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = du(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
            hVar.mLink = str;
            hVar.type = this.air;
            hVar.aLc = this.ais;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
        }
    }

    public void wd() {
        d(false, false);
    }

    public void we() {
        d(false, true);
    }

    public AnchorInfoData wf() {
        return this.aiS;
    }

    public boolean wg() {
        return this.threadType == 36;
    }

    public boolean wh() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> vG = vG();
        if (vG == null || vV()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= vG.size() || i2 >= 3) {
                break;
            }
            if (vG.get(i2) != null && vG.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(vG.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = vG.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = vG.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aiZ != null && !StringUtils.isNull(this.aiZ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aiZ.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aiE != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aiE.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean wi() {
        String userId;
        return this.aiE == null || (userId = this.aiE.getUserId()) == null || userId.equals("0");
    }

    private boolean wj() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        int vr = vr();
        if (this.aiZ != null && wO()) {
            return aiq;
        }
        if (this.ajb != null && this.threadType == 60) {
            return aih;
        }
        if (this.ajb != null && this.threadType == 49) {
            return aif;
        }
        if (this.threadType == 51) {
            return aig;
        }
        if (vr == 2 || vr == 1) {
            return aia;
        }
        if (this.aiZ != null && ws() && !wj()) {
            return aip;
        }
        if (this.aiZ != null && !wj()) {
            if (vz()) {
                return aij;
            }
            return aie;
        } else if (this.isShareThread) {
            return aii;
        } else {
            if (wk()) {
                return aim.get() ? ajw : aib;
            } else if (vZ() && vY() == 1) {
                return aim.get() ? ajE : aib;
            } else if (isLinkThread()) {
                return aic;
            } else {
                if (vz()) {
                    return aid;
                }
                if (this.akn == 1) {
                    return this.akq != null ? ail : aik;
                }
                return aib;
            }
        }
    }

    public boolean wk() {
        return vd() != null && getThreadType() == 41 && vt() == 1 && vW() == 2;
    }

    public void m(ArrayList<o> arrayList) {
        if (this.aiU == 1) {
            this.aft = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aft = 0;
        } else {
            this.aft = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.tY() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.tY().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aft = next.tZ();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean wl() {
        return this.threadType == 41;
    }

    public boolean wm() {
        return this.ajF;
    }

    public void as(boolean z) {
        this.ajF = z;
    }

    public String wn() {
        return this.ajG;
    }

    public n wo() {
        return this.ajj;
    }

    public boolean wp() {
        return vt() == 1 || vs() == 1 || vr() == 1 || vZ() || this.ajH == 1 || vz() || vJ() != null || vI() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || vy();
    }

    public void wq() {
        if (this.ajd == 0) {
            this.ajd = 1;
        }
    }

    public boolean wr() {
        return this.ajL;
    }

    public void at(boolean z) {
        this.ajR = z;
    }

    public boolean ws() {
        return this.ajR;
    }

    public void bX(int i) {
        this.ajS = i + 1;
    }

    public int wt() {
        return this.ajS;
    }

    public List<ReportInfo> wu() {
        return this.ajT;
    }

    public boolean wv() {
        return this.ajM;
    }

    public void au(boolean z) {
        this.ajM = z;
    }

    public bi ww() {
        return this.aja;
    }

    public void a(bi biVar) {
        this.aja = biVar;
    }

    public void bY(int i) {
        if (this.aja != null) {
            this.aja.mCurrentPage = i;
        }
    }

    public boolean wx() {
        return getThreadType() == 49;
    }

    public boolean wy() {
        return getThreadType() == 40;
    }

    public boolean wz() {
        return getThreadType() == 50;
    }

    public boolean wA() {
        return getThreadType() == 60;
    }

    public boolean wB() {
        return getThreadType() == 40 && ww() != null && ww().channelId > 0;
    }

    public int wC() {
        return this.ajY;
    }

    public void setSmartFrsPosition(int i) {
        this.ajY = i;
    }

    public SparseArray<String> uv() {
        return this.agZ;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agZ = sparseArray;
    }

    public String wD() {
        return this.mRecomSource;
    }

    public boolean wE() {
        return this.ajZ;
    }

    public int wF() {
        return this.aka;
    }

    public int wG() {
        return this.akb;
    }

    public void bZ(int i) {
        this.akb = i;
    }

    public void ca(int i) {
        this.aka = i;
    }

    public long wH() {
        return this.akd;
    }

    public void r(long j) {
        this.akd = j;
    }

    public PostData wI() {
        return this.akc;
    }

    public ae wJ() {
        return this.ake;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aiU == 1) {
            g = g(this.aiJ, true);
            a = dr(this.aiJ);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aiI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString dr;
        if (!StringUtils.isNull(this.title) && this.aiU != 1) {
            dr = a(new SpannableString(g(this.title, false) + " "));
        } else {
            dr = dr(this.aiJ);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dr);
        this.aiI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString wK() {
        if (this.aiU == 1) {
            return null;
        }
        return dr(this.aiJ);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean vx = vx();
        if (z2) {
            if (z) {
                if (vx && !wh()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if (vt() == 1 || getThreadType() == 33 || (vv() != null && vv().xb() != 0)) {
                    if (vd() != null && wl()) {
                        if (vW() == 2) {
                            arrayList.add(new o.a(d.k.interview_live));
                        }
                    } else if (!vx) {
                        arrayList.add(new o.a(d.k.photo_live_tips));
                    }
                }
                if (vr() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (vs() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (wl()) {
                    arrayList.add(ajV.get(vW()));
                }
                if (vZ()) {
                    Integer num = ajU.get(new Point(vY(), vX()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), d.C0142d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (vI() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0142d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (vx && vr() != 1 && !wh()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if ((vt() == 1 || getThreadType() == 33) && !wl() && !vx) {
                    arrayList.add(new o.a(d.k.photo_live_tips));
                }
                if (vs() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (vr() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (wl() && vd() != null && vW() == 2) {
                    arrayList.add(new o.a(d.k.interview_live));
                }
                if (vZ()) {
                    Integer num2 = ajU.get(new Point(vY(), vX()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), d.C0142d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (this.ajH == 1) {
                    arrayList.add(new o.a(d.k.card_tbread_text));
                }
                if (vJ() != null) {
                    arrayList.add(new o.a(d.k.send_app_code_gift, d.C0142d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (vI() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0142d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && wx()) {
                    arrayList.add(new o.a(d.k.ala_live));
                }
                if (wB()) {
                    arrayList.add(new o.a(d.k.frs_channel_tip));
                } else if (z3 && wz()) {
                    arrayList.add(new o.a(d.k.live_record));
                } else if (wy()) {
                    arrayList.add(new o.a(d.k.video_title_str));
                }
                if (z4) {
                    arrayList.add(new o.a(d.k.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void n(ArrayList<MediaData> arrayList) {
        this.aiK = arrayList;
    }

    public String wL() {
        return this.ako;
    }

    public void dw(String str) {
        this.ako = str;
    }

    public void wM() {
        this.akn = 1;
    }

    public boolean wN() {
        return this.akn == 1;
    }

    public boolean wO() {
        return this.akr.equals("worldcupvideo");
    }

    public String wP() {
        return this.aiu;
    }

    public void dx(String str) {
        this.aiu = str;
    }

    public String wQ() {
        return this.aiv;
    }

    public void dy(String str) {
        this.aiv = str;
    }

    public String wR() {
        return this.akp;
    }

    public void dz(String str) {
        this.akp = str;
    }

    public boolean wS() {
        return this.aks;
    }

    public void av(boolean z) {
        this.aks = z;
    }

    public void a(VideoInfo videoInfo) {
        this.akq = videoInfo;
    }

    public boolean wT() {
        return this.akt != null;
    }

    public String wU() {
        return this.aiF;
    }
}

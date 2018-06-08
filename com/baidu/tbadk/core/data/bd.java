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
import com.sina.weibo.sdk.constant.WBConstants;
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
public class bd extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h, com.baidu.tbadk.core.util.af {
    private String address;
    private String aiA;
    private int aiC;
    private VideoInfo aiE;
    private bj aiF;
    private AlaInfoData aiG;
    private long aiH;
    private n aiO;
    private LiveCoverStatus aiU;
    private long aiV;
    private String aib;
    private String aic;
    private SpannableStringBuilder ain;
    public int air;
    private int ais;
    private int aiv;
    private String aiy;
    private int aiz;
    private boolean ajE;
    private int ajG;
    private long ajI;
    private ae ajJ;
    public d ajL;
    private MediaData ajM;
    public int ajN;
    public OriginalThreadInfo ajP;
    private String ajT;
    private String ajU;
    private String ajV;
    public TwZhiBoUser ajd;
    public List<TwAnchorProfitItem> aje;
    private String ajh;
    private SkinInfo aji;
    private boolean ajk;
    private String ajl;
    private boolean ajq;
    private boolean ajr;
    public long ajt;
    public String ajv;
    private List<ReportInfo> ajy;
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
    public static final BdUniqueId ahI = BdUniqueId.gen();
    public static final BdUniqueId ahJ = BdUniqueId.gen();
    public static final BdUniqueId ahK = BdUniqueId.gen();
    public static final BdUniqueId ahL = BdUniqueId.gen();
    public static final BdUniqueId ahM = BdUniqueId.gen();
    public static final BdUniqueId ahN = BdUniqueId.gen();
    public static final BdUniqueId ahO = BdUniqueId.gen();
    public static final BdUniqueId ahP = BdUniqueId.gen();
    public static final BdUniqueId ahQ = BdUniqueId.gen();
    public static final BdUniqueId ahR = BdUniqueId.gen();
    public static final BdUniqueId ahS = BdUniqueId.gen();
    public static AtomicBoolean ahT = new AtomicBoolean(false);
    public static AtomicBoolean ahU = new AtomicBoolean(false);
    public static AtomicBoolean ahV = new AtomicBoolean(false);
    public static final BdUniqueId ahW = BdUniqueId.gen();
    public static final BdUniqueId ahX = BdUniqueId.gen();
    private static HashMap<Point, Integer> aiP = new HashMap<>();
    private static HashMap<Integer, Integer> aiQ = new HashMap<>();
    public static final BdUniqueId aja = BdUniqueId.gen();
    public static final BdUniqueId ajb = BdUniqueId.gen();
    public static final BdUniqueId ajj = BdUniqueId.gen();
    private static HashMap<Point, Integer> ajz = new HashMap<>();
    private static SparseArray<o.a> ajA = new SparseArray<>(3);
    private int ahY = 0;
    private String ahZ = "1";
    public int aia = 1;
    private String aiu = null;
    private int afe = 0;
    public int aiI = 0;
    private String aiJ = "";
    private String aiR = "";
    public boolean aju = true;
    public boolean ajB = false;
    public boolean ajC = false;
    private int ajD = -1;
    private SparseArray<String> agK = null;
    public boolean ajK = false;
    private int ajS = 0;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aid = 0;
    private int aie = 0;
    private String last_time = null;
    private long aif = 0;
    private int aig = 0;
    private int aih = 0;
    private int aii = 0;
    private bh aij = new bh();
    private MetaData aik = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aip = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aiq = new ArrayList<>();
    private int ail = 0;
    private int aim = 0;
    private String ad_url = null;
    private String aio = null;
    private String from = null;
    private int ait = 0;
    private PraiseData aiw = new PraiseData();
    private AnchorInfoData aix = new AnchorInfoData();
    private long time = 0;
    private int aiB = 0;
    private ArrayList<a> aiL = new ArrayList<>();
    private bm aiM = null;
    private e aiN = null;
    private int aiS = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aiD = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aiT = null;
    private int aiK = 0;
    private boolean aiW = false;
    private boolean aiX = false;
    private int aiY = 0;
    private boolean aiZ = false;
    private int anchorLevel = 0;
    public int ajm = 0;
    public k ajn = new k();
    private List<PbContent> ajo = new ArrayList();
    private List<PbContent> ajp = new ArrayList();
    private String category_name = null;
    private bb ajc = new bb();
    private ArrayList<com.baidu.tbadk.data.c> ajf = new ArrayList<>();
    private PushStatusData ajg = new PushStatusData();
    public boolean ajw = false;
    public int ajx = -1;
    private int ajF = 0;
    private PostData ajH = new PostData();
    private int ajs = 0;
    public int ajO = 0;
    private String tieba_game_information_source = "";
    public String ajR = "";
    public String ajQ = "";

    static {
        aiP.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        aiP.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        aiP.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        aiP.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        aiP.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        aiP.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        aiP.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        aiP.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        ajz.put(new Point(1, 1), Integer.valueOf(d.k.lottery_status_ing));
        ajz.put(new Point(1, 2), Integer.valueOf(d.k.lottery_status_over));
        ajz.put(new Point(1, 3), Integer.valueOf(d.k.lottery_status_off));
        ajz.put(new Point(1, 4), Integer.valueOf(d.k.lottery_status_not_start));
        ajz.put(new Point(2, 1), Integer.valueOf(d.k.share_picture_status_ing));
        ajz.put(new Point(2, 2), Integer.valueOf(d.k.share_picture_status_over));
        ajz.put(new Point(2, 3), Integer.valueOf(d.k.share_picture_status_off));
        ajz.put(new Point(2, 4), Integer.valueOf(d.k.share_picture_status_not_start));
        aiQ.put(1, Integer.valueOf(d.f.label_interview_no));
        aiQ.put(2, Integer.valueOf(d.f.label_interview_live));
        aiQ.put(3, Integer.valueOf(d.f.label_interview_off));
        ajA.put(1, new o.a(d.k.interview_live_status_not_start, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
        ajA.put(2, new o.a(d.k.interview_live_status_ing, d.C0141d.cp_other_c, d.f.pic_dot_title_green));
        ajA.put(3, new o.a(d.k.interview_live_status_over, d.C0141d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bd() {
        this.ais = 0;
        this.aiC = 0;
        this.aiV = 0L;
        this.mUrl = "";
        this.ajh = "";
        this.ajN = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.aiV = 0L;
        this.aiC = 0;
        this.ais = 0;
        this.ajN = 0;
        this.mUrl = "";
        this.ajh = "";
    }

    public boolean uU() {
        return this.ais == 1;
    }

    public bb uV() {
        return this.ajc;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int uW() {
        return this.ajs;
    }

    public void bO(int i) {
        this.ajs = i;
    }

    public void bP(int i) {
        this.aiY = i;
    }

    public int uX() {
        return this.aiY;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long uY() {
        return this.aiH;
    }

    public String uZ() {
        return this.aiy;
    }

    public PraiseData va() {
        return this.aiw;
    }

    public void a(PraiseData praiseData) {
        this.aiw = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String vb() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void dl(String str) {
        this.ahZ = str;
    }

    public String getId() {
        return this.id;
    }

    public void dh(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.ahY = i;
    }

    public int vc() {
        return this.ahY;
    }

    public String vd() {
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

    public void u(List<PbContent> list) {
        this.ajo = list;
    }

    public void v(List<PbContent> list) {
        this.ajp = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void bQ(int i) {
        this.reply_num = i;
    }

    public int ve() {
        return this.reply_num;
    }

    public int vf() {
        return this.aie;
    }

    public void bR(int i) {
        this.aie = i;
    }

    public long vg() {
        return this.aif;
    }

    public void q(long j) {
        this.aif = j;
    }

    public int vh() {
        return this.aig;
    }

    public void bS(int i) {
        this.aig = i;
    }

    public int vi() {
        return this.aih;
    }

    public void bT(int i) {
        this.aih = i;
    }

    public int vj() {
        return this.aii;
    }

    public List<PbContent> vk() {
        return this.ajo;
    }

    public bh vl() {
        return this.aij;
    }

    public MetaData vm() {
        return this.aik;
    }

    public boolean vn() {
        return this.is_god != 0;
    }

    public boolean vo() {
        return this.is_god == 1;
    }

    public boolean vp() {
        return (this.aik == null || this.aik.getGodUserData() == null || this.aik.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean vq() {
        return (this.aik == null || this.aik.getGodUserData() == null || this.aik.getGodUserData().getType() != 3) ? false : true;
    }

    public void a(MetaData metaData) {
        this.aik = metaData;
    }

    public String vr() {
        return this.forum_name;
    }

    public void dm(String str) {
        this.forum_name = str;
    }

    public int vs() {
        return this.aim;
    }

    public String vt() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aio;
    }

    public void dn(String str) {
        this.aio = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ajp == null || this.ajp.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ajp.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ajp.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ajo == null || (size = this.ajo.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ajo.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    /* renamed from: do  reason: not valid java name */
    public SpannableString m13do(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.ajp != null && (size = this.ajp.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajp.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bd.this.ds(pbContent.link);
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

    public int vu() {
        return this.ait;
    }

    public void bU(int i) {
        this.ait = i;
    }

    public String vv() {
        return this.aiu;
    }

    public void dp(String str) {
        this.aiu = str;
    }

    public ArrayList<MediaData> vw() {
        return this.aip;
    }

    public ArrayList<a> vx() {
        return this.aiL;
    }

    public void h(ArrayList<a> arrayList) {
        this.aiL = arrayList;
    }

    public bm vy() {
        return this.aiM;
    }

    public e vz() {
        return this.aiN;
    }

    public ArrayList<VoiceData.VoiceModel> vA() {
        return this.aiq;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int vB() {
        return this.aiz;
    }

    public void bV(int i) {
        this.aiz = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String vC() {
        return this.aiJ;
    }

    public VideoInfo vD() {
        return this.aiE;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aiG = alaInfoData;
    }

    public AlaInfoData vE() {
        return this.aiG;
    }

    public PushStatusData vF() {
        return this.ajg;
    }

    public SkinInfo vG() {
        return this.aji;
    }

    public long vH() {
        return this.ajt;
    }

    public boolean vI() {
        return this.aju;
    }

    public String vJ() {
        return this.ajv;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aiA = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.ais = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aiH = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aid = threadInfo.repost_num.intValue();
                this.aie = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aif = threadInfo.last_time_int.intValue();
                this.aig = threadInfo.is_top.intValue();
                this.aih = threadInfo.is_good.intValue();
                this.aii = threadInfo.is_livepost.intValue();
                this.aij.a(threadInfo.topic);
                this.aik.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.ail = threadInfo.has_commented.intValue();
                this.aim = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aiE = threadInfo.video_info;
                this.aiG = new AlaInfoData();
                this.aiG.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.ait = threadInfo.collect_status.intValue();
                this.aiu = threadInfo.collect_mark_pid;
                this.aiv = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aiy = threadInfo.first_post_id + "";
                this.aiJ = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aiz = threadInfo.is_ntitle.intValue();
                this.aiB = threadInfo.is_activity.intValue();
                this.ajF = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.ajG = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.ajI = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aiC = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ajq = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ajo = threadInfo.rich_title;
                this.ajp = threadInfo.rich_abstract;
                this.air = threadInfo.is_godthread_recommend.intValue();
                if ((this.aik == null || this.aik.getUserId() == null || this.aik.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aik = metaData;
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
                this.aio = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aip.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aiE = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aiF = new bj();
                    this.aiF.a(threadInfo.video_channel_info);
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
                        this.aiq.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aiL.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aiM = new bm();
                    this.aiM.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aiN = new e();
                    this.aiN.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aiO = new n();
                    this.aiO.a(threadInfo.cartoon_info);
                }
                this.aiw.setUserMap(this.userMap);
                this.aiw.parserProtobuf(threadInfo.zan);
                this.aix.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aiw.setTitle(this.title);
                } else {
                    this.aiw.setTitle(this.aio);
                }
                this.aiR = threadInfo.livecover_src;
                this.aiS = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aiK = threadInfo.post_num.intValue();
                this.aiV = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.es(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gb(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aiD.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aiT = noticeInfo.notice;
                    }
                    this.aiY = zhiBoInfoTW.copythread_remind.intValue();
                    this.aiW = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aiX = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aiR)) {
                        this.aiR = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.ajd = zhiBoInfoTW.user.tw_anchor_info;
                        this.aje = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aiU = threadInfo.twzhibo_info.livecover_status;
                    this.aiV = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aiZ = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.ajc.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.ajf.add(cVar);
                    }
                }
                this.ajg.parserProtobuf(threadInfo.push_status);
                this.ajl = threadInfo.lego_card;
                this.aji = threadInfo.skin_info;
                this.ajm = threadInfo.is_book_chapter.intValue();
                this.ajn.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.ajv = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.ajt = threadInfo.last_read_pid.longValue();
                this.aju = threadInfo.cheak_repeat.intValue() == 1;
                this.ajy = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.ajH.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.w.y(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.agK = sparseArray;
                }
                this.ajE = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.ajJ = new ae();
                    this.ajJ.a(threadInfo.link_info);
                }
                this.ajK = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.ajL = new d();
                    this.ajL.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ajM = new MediaData();
                    this.ajM.parserProtobuf(threadInfo.pic_info);
                }
                this.ajs = threadInfo.is_called.intValue();
                this.ajN = threadInfo.middle_page_num.intValue();
                this.ajO = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.ajQ = threadInfo.star_rank_icon.icon_pic_url;
                    this.ajR = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.ajP = new OriginalThreadInfo();
                    this.ajP.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.ajP = new OriginalThreadInfo();
                    this.ajP.parser(threadInfo.origin_thread_info);
                } else {
                    this.ajP = null;
                }
                this.ajS = threadInfo.is_topic.intValue();
                this.ajT = threadInfo.topic_user_name;
                this.ajU = threadInfo.topic_h5_url;
                this.ajV = threadInfo.presentation_style;
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
                this.mCreateTime = jSONObject.optLong(WBConstants.GAME_PARAMS_GAME_CREATE_TIME, 0L) * 1000;
                this.aiH = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aid = jSONObject.optInt("repost_num", 0);
                this.aie = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.aif = jSONObject.optLong("last_time_int", 0L);
                this.aig = jSONObject.optInt("is_top", 0);
                this.aih = jSONObject.optInt("is_good", 0);
                this.aii = jSONObject.optInt("is_livepost", 0);
                this.aij.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aik.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.ail = jSONObject.optInt("has_commented", 0);
                this.aim = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.ait = jSONObject.optInt("collect_status");
                this.aiu = jSONObject.optString("collect_mark_pid");
                this.aiv = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ajF = jSONObject.optInt("agree_num");
                this.ajI = jSONObject.optLong("share_num");
                this.aiy = jSONObject.optString("first_post_id", "0");
                this.aiJ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.aiz = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.ajG = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.ajc.parserJson(optJSONObject2);
                }
                if ((this.aik == null || this.aik.getUserId() == null) && this.userMap != null) {
                    this.aik = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aiG = new AlaInfoData();
                this.aiG.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aio = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aip.add(mediaData);
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
                        this.aiq.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aiL.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aiM = new bm();
                    this.aiM.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aiN = new e();
                    this.aiN.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aiO = new n();
                    this.aiO.parserJson(optJSONObject6);
                }
                this.aiw.setUserMap(this.userMap);
                this.aiw.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aix.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aiw.setTitle(this.title);
                } else {
                    this.aiw.setTitle(this.aio);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.ajc.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.ajf.add(cVar);
                    }
                }
                this.ajm = jSONObject.optInt("is_book_chapter", 0);
                this.ajn.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.ajv = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.ajt = jSONObject.optLong("last_read_pid");
                this.aju = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aiF = new bj();
                    this.aiF.p(optJSONObject8);
                }
                this.ajE = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.ajJ = new ae();
                    this.ajJ.parserJson(optJSONObject9);
                }
                this.ajK = jSONObject.optInt("is_partial_visible") == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.ajL = new d();
                    this.ajL.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.ajM = new MediaData();
                    this.ajM.parserJson(optJSONObject11);
                }
                this.ajs = jSONObject.optInt("is_called", 0);
                this.ajN = jSONObject.optInt("middle_page_num", 0);
                this.ajO = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aiE = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.ajP = new OriginalThreadInfo();
                        this.ajP.parserJson(optJSONObject13);
                        return;
                    }
                    this.ajP = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder vK() {
        return this.ain;
    }

    public boolean vL() {
        return vh() != 0;
    }

    public int vM() {
        if (this.ajc != null) {
            long uQ = this.ajc.uQ();
            long uR = this.ajc.uR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < uQ) {
                return 1;
            }
            if (currentTimeMillis > uR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int vN() {
        if (vP() && this.aiL.size() >= 1) {
            a aVar = this.aiL.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int tJ = aVar.tJ();
            int tK = aVar.tK();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < tJ) {
                return 4;
            }
            return currentTimeMillis > tK ? 2 : 1;
        }
        return -1;
    }

    public int vO() {
        if (!vP() || this.aiL.size() < 1 || this.aiL.get(0) == null) {
            return -1;
        }
        return this.aiL.get(0).tI();
    }

    public boolean vP() {
        return this.aiB == 1;
    }

    public String getActUrl() {
        return (!vP() || this.aiL.size() < 1 || this.aiL.get(0) == null) ? "" : this.aiL.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dq(String str) {
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0141d.cp_cont_f_1));
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
            if (getThreadType() == 42 && vR()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (vh() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (vh() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (vj() == 1 || this.aij.wO() != 0) {
                if (uV() != null && getThreadType() == 41) {
                    if (vM() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && wb()) {
                Integer num = aiQ.get(Integer.valueOf(vM()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (vi() == 1 && !vL() && ahM != getType() && ahR != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.aix != null && this.aix.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (vs() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = aiP.get(new Point(vO(), vN()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (vy() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (vz() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = dq(this.category_name);
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
                Bitmap cQ = com.baidu.tbadk.core.util.al.cQ(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aia));
                spannableString.setSpan(iVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && vh() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.ain = spannableStringBuilder;
    }

    public boolean vQ() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || vD() == null || vD().video_type.intValue() == 0) {
            return i == 1 && vD() != null && (vD().video_type.intValue() == 1 || vD().video_type.intValue() == 12 || vD().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap cQ = com.baidu.tbadk.core.util.al.cQ(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (vm() != null) {
            if (vm().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.he));
            } else if (vm().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.k.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(jVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder c(String str, ArrayList<o.a> arrayList) {
        if (vX() || !vn() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(d.k.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean vR() {
        return com.baidu.adp.lib.b.d.hv().aw("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.w.y(a(z, z2, z3, false)) > 0) {
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
        this.ain = spannableStringBuilder;
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
            if (this.aiz == 1) {
                this.ain = a2;
                return a2;
            }
        } else if (this.aiz == 1) {
            this.ain = new SpannableStringBuilder();
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
        this.ajh = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a w;
        com.baidu.adp.widget.ImageView.a w2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.ajh) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.ID().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.u.v(this.mUrl, 10)) && (w = com.baidu.tbadk.core.util.d.u.w(this.mUrl, 10)) != null) {
                bitmap = w.mZ();
                com.baidu.tbadk.imageManager.c.ID().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.ID().getBitmap(this.ajh);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.u.v(this.ajh, 10)) && (w2 = com.baidu.tbadk.core.util.d.u.w(this.ajh, 10)) != null) {
                bitmap2 = w2.mZ();
                com.baidu.tbadk.imageManager.c.ID().b(this.ajh, bitmap2);
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
                        com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                        kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aia));
                        spannableString.setSpan(kVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.ig().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bd.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.ID().b(str2, aVar.mZ());
                    }
                }
            }, ahK);
            com.baidu.adp.lib.f.c.ig().a(this.ajh, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bd.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.ID().b(str2, aVar.mZ());
                    }
                }
            }, ahK);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.ajo != null && this.ajo.size() > 0) {
            int size = this.ajo.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajo.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        if (vX()) {
                            if (pbContent.text != null) {
                                String dr = dr(pbContent.text);
                                a(spannableString, pbContent.text, i3);
                                spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, dr) { // from class: com.baidu.tbadk.core.data.bd.4
                                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        bd.this.ds(getLink());
                                    }
                                }, i3, pbContent.text.length() + i3, 33);
                            }
                        } else {
                            a(spannableString, pbContent.text, i3);
                            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bd.5
                                @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    bd.this.ds(pbContent.link);
                                }
                            }, i3, pbContent.text.length() + i3, 33);
                        }
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

    private String dr(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData vS() {
        if (this.ajo != null && this.ajo.size() > 0) {
            int size = this.ajo.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.ajo.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && vX() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = dr(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.h hVar = new com.baidu.tbadk.data.h();
            hVar.mLink = str;
            hVar.type = this.ahY;
            hVar.aKf = this.ahZ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
        }
    }

    public void vT() {
        d(false, false);
    }

    public void vU() {
        d(false, true);
    }

    public AnchorInfoData vV() {
        return this.aix;
    }

    public boolean vW() {
        return this.threadType == 36;
    }

    public boolean vX() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> vw = vw();
        if (vw == null || vL()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= vw.size() || i2 >= 3) {
                break;
            }
            if (vw.get(i2) != null && vw.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(vw.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = vw.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = vw.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aiE != null && !StringUtils.isNull(this.aiE.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aiE.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aik != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aik.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean vY() {
        String userId;
        return this.aik == null || (userId = this.aik.getUserId()) == null || userId.equals("0");
    }

    private boolean vZ() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        int vh = vh();
        if (this.aiE != null && wE()) {
            return ahX;
        }
        if (this.aiG != null && this.threadType == 60) {
            return ahP;
        }
        if (this.aiG != null && this.threadType == 49) {
            return ahN;
        }
        if (this.threadType == 51) {
            return ahO;
        }
        if (vh == 2 || vh == 1) {
            return ahI;
        }
        if (this.aiE != null && wi() && !vZ()) {
            return ahW;
        }
        if (this.aiE != null && !vZ()) {
            if (vp()) {
                return ahR;
            }
            return ahM;
        } else if (this.isShareThread) {
            return ahQ;
        } else {
            if (wa()) {
                return ahT.get() ? ajb : ahJ;
            } else if (vP() && vO() == 1) {
                return ahT.get() ? ajj : ahJ;
            } else if (isLinkThread()) {
                return ahK;
            } else {
                if (vp()) {
                    return ahL;
                }
                if (this.ajS == 1) {
                    return ahS;
                }
                return ahJ;
            }
        }
    }

    public boolean wa() {
        return uV() != null && getThreadType() == 41 && vj() == 1 && vM() == 2;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.aiz == 1) {
            this.afe = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.afe = 0;
        } else {
            this.afe = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.tS() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.tS().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.afe = next.tT();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean wb() {
        return this.threadType == 41;
    }

    public boolean wc() {
        return this.ajk;
    }

    public void ar(boolean z) {
        this.ajk = z;
    }

    public String wd() {
        return this.ajl;
    }

    public n we() {
        return this.aiO;
    }

    public boolean wf() {
        return vj() == 1 || vi() == 1 || vh() == 1 || vP() || this.ajm == 1 || vp() || vz() != null || vy() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || vo();
    }

    public void wg() {
        if (this.aiI == 0) {
            this.aiI = 1;
        }
    }

    public boolean wh() {
        return this.ajq;
    }

    public void as(boolean z) {
        this.ajw = z;
    }

    public boolean wi() {
        return this.ajw;
    }

    public void bW(int i) {
        this.ajx = i + 1;
    }

    public int wj() {
        return this.ajx;
    }

    public List<ReportInfo> wk() {
        return this.ajy;
    }

    public boolean wl() {
        return this.ajr;
    }

    public void at(boolean z) {
        this.ajr = z;
    }

    public bj wm() {
        return this.aiF;
    }

    public void a(bj bjVar) {
        this.aiF = bjVar;
    }

    public void bX(int i) {
        if (this.aiF != null) {
            this.aiF.mCurrentPage = i;
        }
    }

    public boolean wn() {
        return getThreadType() == 49;
    }

    public boolean wo() {
        return getThreadType() == 40;
    }

    public boolean wp() {
        return getThreadType() == 50;
    }

    public boolean wq() {
        return getThreadType() == 60;
    }

    public boolean wr() {
        return getThreadType() == 40 && wm() != null && wm().channelId > 0;
    }

    public int ws() {
        return this.ajD;
    }

    public void setSmartFrsPosition(int i) {
        this.ajD = i;
    }

    public SparseArray<String> up() {
        return this.agK;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agK = sparseArray;
    }

    public String wt() {
        return this.mRecomSource;
    }

    public boolean wu() {
        return this.ajE;
    }

    public int wv() {
        return this.ajF;
    }

    public int ww() {
        return this.ajG;
    }

    public void bY(int i) {
        this.ajG = i;
    }

    public void bZ(int i) {
        this.ajF = i;
    }

    public long wx() {
        return this.ajI;
    }

    public void r(long j) {
        this.ajI = j;
    }

    public PostData wy() {
        return this.ajH;
    }

    public ae wz() {
        return this.ajJ;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aiz == 1) {
            g = g(this.aio, true);
            a = m13do(this.aio);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.ain = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString m13do;
        if (!StringUtils.isNull(this.title) && this.aiz != 1) {
            m13do = a(new SpannableString(g(this.title, false) + " "));
        } else {
            m13do = m13do(this.aio);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m13do);
        this.ain = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString wA() {
        if (this.aiz == 1) {
            return null;
        }
        return m13do(this.aio);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean vn = vn();
        if (z2) {
            if (z) {
                if (vn && !vX()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if (vj() == 1 || getThreadType() == 33 || (vl() != null && vl().wO() != 0)) {
                    if (uV() != null && wb()) {
                        if (vM() == 2) {
                            arrayList.add(new o.a(d.k.interview_live));
                        }
                    } else if (!vn) {
                        arrayList.add(new o.a(d.k.photo_live_tips));
                    }
                }
                if (vh() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (vi() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (wb()) {
                    arrayList.add(ajA.get(vM()));
                }
                if (vP()) {
                    Integer num = ajz.get(new Point(vO(), vN()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (vy() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (vn && vh() != 1 && !vX()) {
                    arrayList.add(new o.a(d.k.god_title));
                }
                if ((vj() == 1 || getThreadType() == 33) && !wb() && !vn) {
                    arrayList.add(new o.a(d.k.photo_live_tips));
                }
                if (vi() == 1) {
                    arrayList.add(new o.a(d.k.good));
                }
                if (vh() == 1) {
                    arrayList.add(new o.a(d.k.top));
                }
                if (wb() && uV() != null && vM() == 2) {
                    arrayList.add(new o.a(d.k.interview_live));
                }
                if (vP()) {
                    Integer num2 = ajz.get(new Point(vO(), vN()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(d.k.card_promotion_text));
                    }
                }
                if (this.ajm == 1) {
                    arrayList.add(new o.a(d.k.card_tbread_text));
                }
                if (vz() != null) {
                    arrayList.add(new o.a(d.k.send_app_code_gift, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (vy() != null) {
                    arrayList.add(new o.a(d.k.card_promotion_text, d.C0141d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && wn()) {
                    arrayList.add(new o.a(d.k.ala_live));
                }
                if (wr()) {
                    arrayList.add(new o.a(d.k.frs_channel_tip));
                } else if (z3 && wp()) {
                    arrayList.add(new o.a(d.k.live_record));
                } else if (wo()) {
                    arrayList.add(new o.a(d.k.video_title_str));
                }
                if (z4) {
                    arrayList.add(new o.a(d.k.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void j(ArrayList<MediaData> arrayList) {
        this.aip = arrayList;
    }

    public String wB() {
        return this.ajT;
    }

    public void dt(String str) {
        this.ajT = str;
    }

    public void wC() {
        this.ajS = 1;
    }

    public boolean wD() {
        return this.ajS == 1;
    }

    public boolean wE() {
        return this.ajV.equals("worldcupvideo");
    }

    public String wF() {
        return this.aib;
    }

    public void du(String str) {
        this.aib = str;
    }

    public String wG() {
        return this.aic;
    }

    public void dv(String str) {
        this.aic = str;
    }

    public String wH() {
        return this.ajU;
    }

    public void dw(String str) {
        this.ajU = str;
    }
}

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
import com.baidu.tieba.f;
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
public class bb extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h, com.baidu.tbadk.core.util.af {
    private String address;
    private ay ahQ;
    private String ahR;
    private String ahS;
    private m aiG;
    private LiveCoverStatus aiM;
    private long aiN;
    public TwZhiBoUser aiV;
    public List<TwAnchorProfitItem> aiW;
    private String aiZ;
    private String aic;
    private SpannableStringBuilder aif;
    public int aij;
    private int aik;
    private int ain;
    private String aiq;
    private int air;
    private String ais;
    private int aiu;
    private VideoInfo aiw;
    private bh aix;
    private AlaInfoData aiy;
    private long aiz;
    private long ajA;
    private ad ajB;
    public d ajD;
    private MediaData ajE;
    public int ajF;
    public OriginalThreadInfo ajH;
    private String ajL;
    private String ajM;
    private VideoInfo ajN;
    private String ajO;
    public OriginalForumInfo ajQ;
    public boolean ajR;
    private String ajS;
    private boolean ajT;
    private SkinInfo aja;
    private boolean ajc;
    private String ajd;
    private boolean aji;
    private boolean ajj;
    public long ajl;
    public String ajn;
    private List<ReportInfo> ajq;
    private boolean ajw;
    private int ajy;
    private String authorId;
    public boolean isBigGie;
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
    public static final BdUniqueId ahw = BdUniqueId.gen();
    public static final BdUniqueId ahx = BdUniqueId.gen();
    public static final BdUniqueId ahy = BdUniqueId.gen();
    public static final BdUniqueId ahz = BdUniqueId.gen();
    public static final BdUniqueId ahA = BdUniqueId.gen();
    public static final BdUniqueId ahB = BdUniqueId.gen();
    public static final BdUniqueId ahC = BdUniqueId.gen();
    public static final BdUniqueId ahD = BdUniqueId.gen();
    public static final BdUniqueId ahE = BdUniqueId.gen();
    public static final BdUniqueId ahF = BdUniqueId.gen();
    public static final BdUniqueId ahG = BdUniqueId.gen();
    public static final BdUniqueId ahH = BdUniqueId.gen();
    public static AtomicBoolean ahI = new AtomicBoolean(false);
    public static AtomicBoolean ahJ = new AtomicBoolean(false);
    public static AtomicBoolean ahK = new AtomicBoolean(false);
    public static final BdUniqueId ahL = BdUniqueId.gen();
    public static final BdUniqueId ahM = BdUniqueId.gen();
    private static HashMap<Point, Integer> aiH = new HashMap<>();
    private static HashMap<Integer, Integer> aiI = new HashMap<>();
    public static final BdUniqueId aiS = BdUniqueId.gen();
    public static final BdUniqueId aiT = BdUniqueId.gen();
    public static final BdUniqueId ajb = BdUniqueId.gen();
    private static HashMap<Point, Integer> ajr = new HashMap<>();
    private static SparseArray<o.a> ajs = new SparseArray<>(3);
    private int ahN = 0;
    private String ahO = "1";
    public int ahP = 1;
    private String aim = null;
    private int aeN = 0;
    public int aiA = 0;
    private String aiB = "";
    private String aiJ = "";
    public boolean ajm = true;
    public boolean ajt = false;
    public boolean aju = false;
    private int ajv = -1;
    private SparseArray<String> agt = null;
    public boolean ajC = false;
    private int ajK = 0;
    private boolean ajP = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int ahT = 0;
    private int ahU = 0;
    private String last_time = null;
    private long ahV = 0;
    private int ahW = 0;
    private int ahX = 0;
    private int ahY = 0;
    private int ahZ = 0;
    private bf aia = new bf();
    private MetaData aib = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aih = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aii = new ArrayList<>();
    private int aid = 0;
    private int aie = 0;
    private String ad_url = null;
    private String aig = null;
    private String from = null;
    private int ail = 0;
    private PraiseData aio = new PraiseData();
    private AnchorInfoData aip = new AnchorInfoData();
    private long time = 0;
    private int ait = 0;
    private ArrayList<a> aiD = new ArrayList<>();
    private bk aiE = null;
    private e aiF = null;
    private int aiK = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aiv = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aiL = null;
    private int aiC = 0;
    private boolean aiO = false;
    private boolean aiP = false;
    private int aiQ = 0;
    private boolean aiR = false;
    private int anchorLevel = 0;
    public int aje = 0;
    public j ajf = new j();
    private List<PbContent> ajg = new ArrayList();
    private List<PbContent> ajh = new ArrayList();
    private String category_name = null;
    private ba aiU = new ba();
    private ArrayList<com.baidu.tbadk.data.c> aiX = new ArrayList<>();
    private PushStatusData aiY = new PushStatusData();
    public boolean ajo = false;
    public int ajp = -1;
    private int ajx = 0;
    private PostData ajz = new PostData();
    private int ajk = 0;
    public int ajG = 0;
    private String tieba_game_information_source = "";
    public String ajJ = "";
    public String ajI = "";

    static {
        aiH.put(new Point(1, 1), Integer.valueOf(f.C0146f.label_frs_lottery_ing));
        aiH.put(new Point(1, 2), Integer.valueOf(f.C0146f.label_frs_lottery_over));
        aiH.put(new Point(1, 3), Integer.valueOf(f.C0146f.label_frs_lottery_off));
        aiH.put(new Point(1, 4), Integer.valueOf(f.C0146f.label_frs_lottery_d));
        aiH.put(new Point(2, 1), Integer.valueOf(f.C0146f.label_frs_activity_shaiing));
        aiH.put(new Point(2, 2), Integer.valueOf(f.C0146f.label_frs_activity_shai_over));
        aiH.put(new Point(2, 3), Integer.valueOf(f.C0146f.label_frs_activity_shai_off));
        aiH.put(new Point(2, 4), Integer.valueOf(f.C0146f.label_frs_activity_shai_d));
        ajr.put(new Point(1, 1), Integer.valueOf(f.j.lottery_status_ing));
        ajr.put(new Point(1, 2), Integer.valueOf(f.j.lottery_status_over));
        ajr.put(new Point(1, 3), Integer.valueOf(f.j.lottery_status_off));
        ajr.put(new Point(1, 4), Integer.valueOf(f.j.lottery_status_not_start));
        ajr.put(new Point(2, 1), Integer.valueOf(f.j.share_picture_status_ing));
        ajr.put(new Point(2, 2), Integer.valueOf(f.j.share_picture_status_over));
        ajr.put(new Point(2, 3), Integer.valueOf(f.j.share_picture_status_off));
        ajr.put(new Point(2, 4), Integer.valueOf(f.j.share_picture_status_not_start));
        aiI.put(1, Integer.valueOf(f.C0146f.label_interview_no));
        aiI.put(2, Integer.valueOf(f.C0146f.label_interview_live));
        aiI.put(3, Integer.valueOf(f.C0146f.label_interview_off));
        ajs.put(1, new o.a(f.j.interview_live_status_not_start, f.d.cp_other_b, f.C0146f.pic_dot_title_red));
        ajs.put(2, new o.a(f.j.interview_live_status_ing, f.d.cp_other_c, f.C0146f.pic_dot_title_green));
        ajs.put(3, new o.a(f.j.interview_live_status_over, f.d.cp_other_d, f.C0146f.pic_dot_title_blue));
    }

    public bb() {
        this.aik = 0;
        this.aiu = 0;
        this.aiN = 0L;
        this.mUrl = "";
        this.aiZ = "";
        this.ajF = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.aiN = 0L;
        this.aiu = 0;
        this.aik = 0;
        this.ajF = 0;
        this.mUrl = "";
        this.aiZ = "";
        this.isBigGie = false;
    }

    public boolean uP() {
        return this.aik == 1;
    }

    public ba uQ() {
        return this.aiU;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bQ(int i) {
        this.anchorLevel = i;
    }

    public int uR() {
        return this.ajk;
    }

    public void bR(int i) {
        this.ajk = i;
    }

    public void bS(int i) {
        this.aiQ = i;
    }

    public int uS() {
        return this.aiQ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo uT() {
        return this.ajN;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long uU() {
        return this.aiz;
    }

    public String uV() {
        return this.aiq;
    }

    public PraiseData uW() {
        return this.aio;
    }

    public void a(PraiseData praiseData) {
        this.aio = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String uX() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void dl(String str) {
        this.ahO = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.ahN = i;
    }

    public int uY() {
        return this.ahN;
    }

    public String uZ() {
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
        this.ajg = list;
    }

    public void v(List<PbContent> list) {
        this.ajh = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void bT(int i) {
        this.reply_num = i;
    }

    public int va() {
        return this.reply_num;
    }

    public int vb() {
        return this.ahU;
    }

    public void bU(int i) {
        this.ahU = i;
    }

    public long vc() {
        return this.ahV;
    }

    public void q(long j) {
        this.ahV = j;
    }

    public int vd() {
        return this.ahX;
    }

    public int ve() {
        return this.ahW;
    }

    public void bV(int i) {
        this.ahW = i;
    }

    public int vf() {
        return this.ahY;
    }

    public void bW(int i) {
        this.ahY = i;
    }

    public int vg() {
        return this.ahZ;
    }

    public List<PbContent> vh() {
        return this.ajg;
    }

    public bf vi() {
        return this.aia;
    }

    public MetaData vj() {
        return this.aib;
    }

    public boolean vk() {
        return this.is_god != 0;
    }

    public boolean vl() {
        return this.is_god == 1;
    }

    public boolean vm() {
        return (this.aib == null || this.aib.getGodUserData() == null || this.aib.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean vn() {
        return (this.aib == null || this.aib.getGodUserData() == null || this.aib.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean vo() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.aib = metaData;
    }

    public String vp() {
        return this.forum_name;
    }

    public void dm(String str) {
        this.forum_name = str;
    }

    public int vq() {
        return this.aie;
    }

    public String vr() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aig;
    }

    public void dn(String str) {
        this.aig = str;
    }

    public String f(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.ajh == null || this.ajh.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.ajh.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.ajh.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.ajg == null || (size = this.ajg.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.ajg.get(i2);
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
        SpannableString spannableString = new SpannableString(f(str, true));
        if (this.ajh != null && (size = this.ajh.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajh.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bb.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bb.this.ds(pbContent.link);
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

    public int vs() {
        return this.ail;
    }

    public void bX(int i) {
        this.ail = i;
    }

    public String vt() {
        return this.aim;
    }

    public void dp(String str) {
        this.aim = str;
    }

    public ArrayList<MediaData> vu() {
        return this.aih;
    }

    public ArrayList<a> vv() {
        return this.aiD;
    }

    public void l(ArrayList<a> arrayList) {
        this.aiD = arrayList;
    }

    public bk vw() {
        return this.aiE;
    }

    public e vx() {
        return this.aiF;
    }

    public ArrayList<VoiceData.VoiceModel> vy() {
        return this.aii;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int vz() {
        return this.air;
    }

    public void bY(int i) {
        this.air = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String vA() {
        return this.aiB;
    }

    public VideoInfo vB() {
        return this.aiw;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aiy = alaInfoData;
    }

    public AlaInfoData vC() {
        return this.aiy;
    }

    public PushStatusData vD() {
        return this.aiY;
    }

    public SkinInfo vE() {
        return this.aja;
    }

    public long vF() {
        return this.ajl;
    }

    public boolean vG() {
        return this.ajm;
    }

    public String vH() {
        return this.ajn;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.ais = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aik = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aiz = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.ahT = threadInfo.repost_num.intValue();
                this.ahU = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.ahV = threadInfo.last_time_int.intValue();
                this.ahW = threadInfo.is_top.intValue();
                this.ahX = threadInfo.is_membertop.intValue();
                this.ahY = threadInfo.is_good.intValue();
                this.ahZ = threadInfo.is_livepost.intValue();
                this.aia.a(threadInfo.topic);
                this.aib.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aic = threadInfo.fname;
                this.aid = threadInfo.has_commented.intValue();
                this.aie = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aiw = threadInfo.video_info;
                this.aiy = new AlaInfoData();
                this.aiy.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.ail = threadInfo.collect_status.intValue();
                this.aim = threadInfo.collect_mark_pid;
                this.ain = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aiq = threadInfo.first_post_id + "";
                this.aiB = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.air = threadInfo.is_ntitle.intValue();
                this.ait = threadInfo.is_activity.intValue();
                this.ajx = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.ajy = threadInfo.agree.has_agree.intValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.ajA = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aiu = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aji = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.ajg = threadInfo.rich_title;
                this.ajh = threadInfo.rich_abstract;
                this.aij = threadInfo.is_godthread_recommend.intValue();
                if ((this.aib == null || this.aib.getUserId() == null || this.aib.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aib = metaData;
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
                this.aig = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aih.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aiw = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aix = new bh();
                    this.aix.a(threadInfo.video_channel_info);
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
                        this.aii.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aiD.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aiE = new bk();
                    this.aiE.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aiF = new e();
                    this.aiF.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aiG = new m();
                    this.aiG.a(threadInfo.cartoon_info);
                }
                this.aio.setUserMap(this.userMap);
                this.aio.parserProtobuf(threadInfo.zan);
                this.aip.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aio.setTitle(this.title);
                } else {
                    this.aio.setTitle(this.aig);
                }
                this.aiJ = threadInfo.livecover_src;
                this.aiK = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aiC = threadInfo.post_num.intValue();
                this.aiN = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.ev(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gd(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aiv.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aiL = noticeInfo.notice;
                    }
                    this.aiQ = zhiBoInfoTW.copythread_remind.intValue();
                    this.aiO = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aiP = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aiJ)) {
                        this.aiJ = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aiV = zhiBoInfoTW.user.tw_anchor_info;
                        this.aiW = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aiM = threadInfo.twzhibo_info.livecover_status;
                    this.aiN = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aiR = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aiU.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aiX.add(cVar);
                    }
                }
                this.aiY.parserProtobuf(threadInfo.push_status);
                this.ajd = threadInfo.lego_card;
                this.aja = threadInfo.skin_info;
                this.aje = threadInfo.is_book_chapter.intValue();
                this.ajf.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.ajn = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.ajl = threadInfo.last_read_pid.longValue();
                this.ajm = threadInfo.cheak_repeat.intValue() == 1;
                this.ajq = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.ajz.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.w.y(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.agt = sparseArray;
                }
                this.ajw = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.ajB = new ad();
                    this.ajB.a(threadInfo.link_info);
                }
                this.ajC = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.ajD = new d();
                    this.ajD.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ajE = new MediaData();
                    this.ajE.parserProtobuf(threadInfo.pic_info);
                }
                this.ajk = threadInfo.is_called.intValue();
                this.ajF = threadInfo.middle_page_num.intValue();
                this.ajG = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.ajI = threadInfo.star_rank_icon.icon_pic_url;
                    this.ajJ = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.ajH = new OriginalThreadInfo();
                    this.ajH.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.ajH = new OriginalThreadInfo();
                    this.ajH.parser(threadInfo.origin_thread_info);
                } else {
                    this.ajH = null;
                }
                this.ajK = threadInfo.is_topic.intValue();
                this.ajL = threadInfo.topic_user_name;
                this.ajM = threadInfo.topic_h5_url;
                this.ajO = threadInfo.presentation_style;
                this.ajQ = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.ajS = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.ahQ = new ay();
                    this.ahQ.parserProtobuf(threadInfo.forum_info);
                }
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
                this.aiz = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.ahT = jSONObject.optInt("repost_num", 0);
                this.ahU = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.ahV = jSONObject.optLong("last_time_int", 0L);
                this.ahW = jSONObject.optInt("is_top", 0);
                this.ahX = jSONObject.optInt("is_membertop", 0);
                this.ahY = jSONObject.optInt("is_good", 0);
                this.ahZ = jSONObject.optInt("is_livepost", 0);
                this.aia.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aib.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aic = this.forum_name;
                this.aid = jSONObject.optInt("has_commented", 0);
                this.aie = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.ail = jSONObject.optInt("collect_status");
                this.aim = jSONObject.optString("collect_mark_pid");
                this.ain = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.ajx = jSONObject.optInt("agree_num");
                this.ajA = jSONObject.optLong("share_num");
                this.aiq = jSONObject.optString("first_post_id", "0");
                this.aiB = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.air = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                if (jSONObject.optJSONObject("agree") != null) {
                    this.ajy = jSONObject.optJSONObject("agree").optInt("has_agree");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.aiU.parserJson(optJSONObject2);
                }
                if ((this.aib == null || this.aib.getUserId() == null) && this.userMap != null) {
                    this.aib = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aiy = new AlaInfoData();
                this.aiy.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aig = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aih.add(mediaData);
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
                        this.aii.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aiD.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.aiE = new bk();
                    this.aiE.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.aiF = new e();
                    this.aiF.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.aiG = new m();
                    this.aiG.parserJson(optJSONObject6);
                }
                this.aio.setUserMap(this.userMap);
                this.aio.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aip.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aio.setTitle(this.title);
                } else {
                    this.aio.setTitle(this.aig);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.aiU.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aiX.add(cVar);
                    }
                }
                this.aje = jSONObject.optInt("is_book_chapter", 0);
                this.ajf.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.ajn = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.ajl = jSONObject.optLong("last_read_pid");
                this.ajm = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.aix = new bh();
                    this.aix.o(optJSONObject8);
                }
                this.ajw = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.ajB = new ad();
                    this.ajB.parserJson(optJSONObject9);
                }
                this.ajC = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.ajD = new d();
                    this.ajD.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.ajE = new MediaData();
                    this.ajE.parserJson(optJSONObject11);
                }
                this.ajk = jSONObject.optInt("is_called", 0);
                this.ajF = jSONObject.optInt("middle_page_num", 0);
                this.ajG = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    builder.is_vertical = new Integer(optJSONObject12.optInt("is_vertical", 0));
                    this.aiw = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                        this.ajH = new OriginalThreadInfo();
                        this.ajH.parserJson(optJSONObject13);
                        return;
                    }
                    this.ajH = null;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder vI() {
        return this.aif;
    }

    public boolean vJ() {
        return ve() != 0;
    }

    public int vK() {
        if (this.aiU != null) {
            long uL = this.aiU.uL();
            long uM = this.aiU.uM();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < uL) {
                return 1;
            }
            if (currentTimeMillis > uM) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int vL() {
        if (vN() && this.aiD.size() >= 1) {
            a aVar = this.aiD.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int tA = aVar.tA();
            int tB = aVar.tB();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < tA) {
                return 4;
            }
            return currentTimeMillis > tB ? 2 : 1;
        }
        return -1;
    }

    public int vM() {
        if (!vN() || this.aiD.size() < 1 || this.aiD.get(0) == null) {
            return -1;
        }
        return this.aiD.get(0).tz();
    }

    public boolean vN() {
        return this.ait == 1;
    }

    public String getActUrl() {
        return (!vN() || this.aiD.size() < 1 || this.aiD.get(0) == null) ? "" : this.aiD.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dq(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(f.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(f.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(f.d.cp_cont_f_1));
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
        String f = f(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && vP()) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_convene));
            }
            if (ve() == 1) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_top));
            } else if (ve() == 2) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_notice));
            }
            if (vg() == 1 || this.aia.wS() != 0) {
                if (uQ() != null && getThreadType() == 41) {
                    if (vK() == 2) {
                        arrayList.add(Integer.valueOf(f.C0146f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(f.C0146f.icon_zhibo));
                }
            }
            if (z && vZ()) {
                Integer num = aiI.get(Integer.valueOf(vK()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (vf() == 1 && !vJ() && ahA != getType() && ahF != getType()) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_elite));
            }
            if (this.aip != null && this.aip.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_live_on));
            }
            if (vq() == 1) {
                arrayList.add(Integer.valueOf(f.C0146f.frs_post_ding));
            }
            Integer num2 = aiH.get(new Point(vM(), vL()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (vw() != null) {
                arrayList.add(Integer.valueOf(f.C0146f.tag_act));
            }
            if (vx() != null) {
                arrayList.add(Integer.valueOf(f.C0146f.icon_tag_giftsend));
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
                Bitmap cT = com.baidu.tbadk.core.util.am.cT(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                if (cT != null) {
                    bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ahP));
                spannableString.setSpan(jVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(f + " "));
        if (a != null) {
            SpannableStringBuilder c = !z && ve() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.aif = spannableStringBuilder;
    }

    public boolean vO() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || vB() == null || vB().video_type.intValue() == 0) {
            return i == 1 && vB() != null && (vB().video_type.intValue() == 1 || vB().video_type.intValue() == 12 || vB().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(f.e.ds8);
        Bitmap cT = com.baidu.tbadk.core.util.am.cT(f.C0146f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
        bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
        com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (vj() != null) {
            if (vj().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.he));
            } else if (vj().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(f.j.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(kVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder c(String str, ArrayList<o.a> arrayList) {
        if (vV() || !vk() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(f.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean vP() {
        return com.baidu.adp.lib.b.d.hv().ax("isConveneThreadOpen") == 1;
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
        String f = f(this.title, false);
        SpannableString a = a(new SpannableString(f + " "));
        if (z) {
            spannableStringBuilder = a(f, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aif = spannableStringBuilder;
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
            if (this.air == 1) {
                this.aif = a2;
                return a2;
            }
        } else if (this.air == 1) {
            this.aif = new SpannableStringBuilder();
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

    public void O(String str, String str2) {
        this.mUrl = str;
        this.aiZ = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a w;
        com.baidu.adp.widget.ImageView.a w2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aiZ) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.IQ().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.v(this.mUrl, 10)) && (w = com.baidu.tbadk.core.util.d.v.w(this.mUrl, 10)) != null) {
                bitmap = w.nb();
                com.baidu.tbadk.imageManager.c.IQ().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.IQ().getBitmap(this.aiZ);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.v(this.aiZ, 10)) && (w2 = com.baidu.tbadk.core.util.d.v.w(this.aiZ, 10)) != null) {
                bitmap2 = w2.nb();
                com.baidu.tbadk.imageManager.c.IQ().b(this.aiZ, bitmap2);
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
                        lVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.ahP));
                        spannableString.setSpan(lVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.ih().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.IQ().b(str2, aVar.nb());
                    }
                }
            }, ahy);
            com.baidu.adp.lib.f.c.ih().a(this.aiZ, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.IQ().b(str2, aVar.nb());
                    }
                }
            }, ahy);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.ajg != null && this.ajg.size() > 0) {
            int size = this.ajg.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.ajg.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bb.4
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bb.this.ds(pbContent.link);
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

    public ActivityItemData vQ() {
        if (this.ajg != null && this.ajg.size() > 0) {
            int size = this.ajg.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.ajg.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && vV() && pbContent.text != null && pbContent.text.length() >= 3) {
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
            hVar.type = this.ahN;
            hVar.aLf = this.ahO;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, hVar));
        }
    }

    public void vR() {
        d(false, false);
    }

    public void vS() {
        d(false, true);
    }

    public AnchorInfoData vT() {
        return this.aip;
    }

    public boolean vU() {
        return this.threadType == 36;
    }

    public boolean vV() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> vu = vu();
        if (vu == null || vJ()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= vu.size() || i2 >= 3) {
                break;
            }
            if (vu.get(i2) != null && vu.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(vu.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = vu.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = vu.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.aiw != null && !StringUtils.isNull(this.aiw.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aiw.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aib != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aib.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean vW() {
        String userId;
        return this.aib == null || (userId = this.aib.getUserId()) == null || userId.equals("0");
    }

    private boolean vX() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (wL()) {
            if (vB() != null) {
                return ahA;
            }
            return ahx;
        }
        int ve = ve();
        if (this.aiw != null && wC()) {
            return ahM;
        }
        if (this.aiy != null && this.threadType == 60) {
            return ahD;
        }
        if (this.aiy != null && this.threadType == 49) {
            return ahB;
        }
        if (this.threadType == 51) {
            return ahC;
        }
        if (ve == 2 || ve == 1) {
            return ahw;
        }
        if (this.aiw != null && wg() && !vX()) {
            return ahL;
        }
        if (this.aiw != null && !vX()) {
            if (vm()) {
                return ahF;
            }
            return ahA;
        } else if (this.isShareThread) {
            return ahE;
        } else {
            if (vY()) {
                return ahI.get() ? aiT : ahx;
            } else if (vN() && vM() == 1) {
                return ahI.get() ? ajb : ahx;
            } else if (isLinkThread()) {
                return ahy;
            } else {
                if (vm()) {
                    return ahz;
                }
                if (this.ajK == 1) {
                    return this.ajN != null ? ahH : ahG;
                }
                return ahx;
            }
        }
    }

    public boolean vY() {
        return uQ() != null && getThreadType() == 41 && vg() == 1 && vK() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.air == 1) {
            this.aeN = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aeN = 0;
        } else {
            this.aeN = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.tJ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.tJ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aeN = next.tK();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean vZ() {
        return this.threadType == 41;
    }

    public boolean wa() {
        return this.ajc;
    }

    public void aq(boolean z) {
        this.ajc = z;
    }

    public String wb() {
        return this.ajd;
    }

    public m wc() {
        return this.aiG;
    }

    public boolean wd() {
        return vg() == 1 || vf() == 1 || ve() == 1 || vN() || this.aje == 1 || vm() || vx() != null || vw() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || vl();
    }

    public void we() {
        if (this.aiA == 0) {
            this.aiA = 1;
        }
    }

    public boolean wf() {
        return this.aji;
    }

    public void ar(boolean z) {
        this.ajo = z;
    }

    public boolean wg() {
        return this.ajo;
    }

    public void bZ(int i) {
        this.ajp = i + 1;
    }

    public int wh() {
        return this.ajp;
    }

    public List<ReportInfo> wi() {
        return this.ajq;
    }

    public boolean wj() {
        return this.ajj;
    }

    public void as(boolean z) {
        this.ajj = z;
    }

    public bh wk() {
        return this.aix;
    }

    public void a(bh bhVar) {
        this.aix = bhVar;
    }

    public void ca(int i) {
        if (this.aix != null) {
            this.aix.mCurrentPage = i;
        }
    }

    public boolean wl() {
        return getThreadType() == 49;
    }

    public boolean wm() {
        return getThreadType() == 40;
    }

    public boolean wn() {
        return getThreadType() == 50;
    }

    public boolean wo() {
        return getThreadType() == 60;
    }

    public boolean wp() {
        return getThreadType() == 40 && wk() != null && wk().channelId > 0;
    }

    public int wq() {
        return this.ajv;
    }

    public void setSmartFrsPosition(int i) {
        this.ajv = i;
    }

    public SparseArray<String> uh() {
        return this.agt;
    }

    public void a(SparseArray<String> sparseArray) {
        this.agt = sparseArray;
    }

    public String wr() {
        return this.mRecomSource;
    }

    public boolean ws() {
        return this.ajw;
    }

    public int wt() {
        return this.ajx;
    }

    public int wu() {
        return this.ajy;
    }

    public void cb(int i) {
        this.ajy = i;
    }

    public void cc(int i) {
        this.ajx = i;
    }

    public long wv() {
        return this.ajA;
    }

    public void r(long j) {
        this.ajA = j;
    }

    public PostData ww() {
        return this.ajz;
    }

    public ad wx() {
        return this.ajB;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String f;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.air == 1) {
            f = f(this.aig, true);
            a = m13do(this.aig);
        } else {
            f = f(this.title, false);
            a = a(new SpannableString(f + " "));
        }
        if (z) {
            spannableStringBuilder = a(f, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aif = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder f(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder g(boolean z, boolean z2) {
        SpannableString m13do;
        if (!StringUtils.isNull(this.title) && this.air != 1) {
            m13do = a(new SpannableString(f(this.title, false) + " "));
        } else {
            m13do = m13do(this.aig);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m13do);
        this.aif = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString wy() {
        if (this.air == 1) {
            return null;
        }
        return m13do(this.aig);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean vk = vk();
        if (z2) {
            if (z) {
                if (vk && !vV()) {
                    arrayList.add(new o.a(f.j.god_title));
                }
                if (vg() == 1 || getThreadType() == 33 || (vi() != null && vi().wS() != 0)) {
                    if (uQ() != null && vZ()) {
                        if (vK() == 2) {
                            arrayList.add(new o.a(f.j.interview_live));
                        }
                    } else if (!vk) {
                        arrayList.add(new o.a(f.j.photo_live_tips));
                    }
                }
                if (ve() == 1) {
                    arrayList.add(new o.a(f.j.top));
                }
                if (vf() == 1) {
                    arrayList.add(new o.a(f.j.good));
                }
                if (vZ()) {
                    arrayList.add(ajs.get(vK()));
                }
                if (vN()) {
                    Integer num = ajr.get(new Point(vM(), vL()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), f.d.cp_other_b, f.C0146f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(f.j.card_promotion_text));
                    }
                }
                if (vw() != null) {
                    arrayList.add(new o.a(f.j.card_promotion_text, f.d.cp_other_b, f.C0146f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (vk && ve() != 1 && !vV()) {
                    arrayList.add(new o.a(f.j.god_title));
                }
                if ((vg() == 1 || getThreadType() == 33) && !vZ() && !vk) {
                    arrayList.add(new o.a(f.j.photo_live_tips));
                }
                if (vf() == 1) {
                    arrayList.add(new o.a(f.j.good));
                }
                if (ve() == 1) {
                    arrayList.add(new o.a(f.j.top));
                }
                if (vZ() && uQ() != null && vK() == 2) {
                    arrayList.add(new o.a(f.j.interview_live));
                }
                if (vN()) {
                    Integer num2 = ajr.get(new Point(vM(), vL()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), f.d.cp_other_b, f.C0146f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(f.j.card_promotion_text));
                    }
                }
                if (this.aje == 1) {
                    arrayList.add(new o.a(f.j.card_tbread_text));
                }
                if (vx() != null) {
                    arrayList.add(new o.a(f.j.send_app_code_gift, f.d.cp_other_b, f.C0146f.pic_dot_title_red));
                }
                if (vw() != null) {
                    arrayList.add(new o.a(f.j.card_promotion_text, f.d.cp_other_b, f.C0146f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && wl()) {
                    arrayList.add(new o.a(f.j.ala_live));
                }
                if (wp()) {
                    arrayList.add(new o.a(f.j.frs_channel_tip));
                } else if (z3 && wn()) {
                    arrayList.add(new o.a(f.j.live_record));
                } else if (wm()) {
                    arrayList.add(new o.a(f.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new o.a(f.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void n(ArrayList<MediaData> arrayList) {
        this.aih = arrayList;
    }

    public String wz() {
        return this.ajL;
    }

    public void dt(String str) {
        this.ajL = str;
    }

    public void wA() {
        this.ajK = 1;
    }

    public boolean wB() {
        return this.ajK == 1;
    }

    public boolean wC() {
        return this.ajO.equals("worldcupvideo");
    }

    public String wD() {
        return this.ahR;
    }

    public void du(String str) {
        this.ahR = str;
    }

    public String wE() {
        return this.ahS;
    }

    public void dv(String str) {
        this.ahS = str;
    }

    public String wF() {
        return this.ajM;
    }

    public void dw(String str) {
        this.ajM = str;
    }

    public boolean wG() {
        return this.ajP;
    }

    public void at(boolean z) {
        this.ajP = z;
    }

    public void a(VideoInfo videoInfo) {
        this.ajN = videoInfo;
    }

    public boolean wH() {
        return this.ajQ != null;
    }

    public String wI() {
        return this.aic;
    }

    public String wJ() {
        return this.ajS;
    }

    public ay wK() {
        return this.ahQ;
    }

    public boolean wL() {
        return this.ajT;
    }

    public void au(boolean z) {
        this.ajT = z;
    }
}

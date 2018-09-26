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
import com.baidu.sapi2.share.face.FaceLoginModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
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
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bb extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.e.a {
    private String address;
    private String akC;
    private SpannableStringBuilder akF;
    public int akJ;
    private int akK;
    private int akN;
    private String akQ;
    private int akR;
    private String akS;
    private int akU;
    private VideoInfo akW;
    private VideoDesc akX;
    private bh akY;
    private AlaInfoData akZ;
    private ay akq;
    private String akr;
    private String aks;
    private String alB;
    private SkinInfo alC;
    private boolean alE;
    private String alF;
    private boolean alK;
    private boolean alL;
    public long alN;
    public String alP;
    private List<ReportInfo> alS;
    private boolean alY;
    private long ala;
    private m alh;
    private LiveCoverStatus alo;
    private long alp;
    public TwZhiBoUser alx;
    public List<TwAnchorProfitItem> aly;
    private int amb;
    private int amc;
    private long ame;
    private ad amf;
    public d amh;
    private MediaData ami;
    public int amj;
    public OriginalThreadInfo aml;
    private String amp;
    private String amq;
    private VideoInfo amr;
    private String ams;
    public OriginalForumInfo amu;
    public boolean amv;
    private String amw;
    private boolean amx;
    private SmartApp amy;
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
    public static final BdUniqueId ajW = BdUniqueId.gen();
    public static final BdUniqueId ajX = BdUniqueId.gen();
    public static final BdUniqueId ajY = BdUniqueId.gen();
    public static final BdUniqueId ajZ = BdUniqueId.gen();
    public static final BdUniqueId aka = BdUniqueId.gen();
    public static final BdUniqueId akb = BdUniqueId.gen();
    public static final BdUniqueId akc = BdUniqueId.gen();
    public static final BdUniqueId akd = BdUniqueId.gen();
    public static final BdUniqueId ake = BdUniqueId.gen();
    public static final BdUniqueId akf = BdUniqueId.gen();
    public static final BdUniqueId akg = BdUniqueId.gen();
    public static final BdUniqueId akh = BdUniqueId.gen();
    public static AtomicBoolean aki = new AtomicBoolean(false);
    public static AtomicBoolean akj = new AtomicBoolean(false);
    public static AtomicBoolean akk = new AtomicBoolean(false);
    public static final BdUniqueId akl = BdUniqueId.gen();
    public static final BdUniqueId akm = BdUniqueId.gen();
    private static HashMap<Point, Integer> ali = new HashMap<>();
    private static HashMap<Integer, Integer> alj = new HashMap<>();
    public static final BdUniqueId alu = BdUniqueId.gen();
    public static final BdUniqueId alv = BdUniqueId.gen();
    public static final BdUniqueId alD = BdUniqueId.gen();
    private static HashMap<Point, Integer> alT = new HashMap<>();
    private static SparseArray<o.a> alU = new SparseArray<>(3);
    private int akn = 0;
    private String ako = "1";
    public int akp = 1;
    private String akM = null;
    private int aho = 0;
    public int alb = 0;
    private String alc = "";
    private String alk = "";
    public boolean alO = true;
    public boolean alV = false;
    public boolean alW = false;
    private int alX = -1;
    private SparseArray<String> aiT = null;
    public boolean amg = false;
    private int amo = 0;
    private boolean amt = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int akt = 0;
    private int aku = 0;
    private String last_time = null;
    private long akv = 0;
    private int akw = 0;
    private int akx = 0;
    private int aky = 0;
    private int akz = 0;
    private bf akA = new bf();
    private MetaData akB = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> akH = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> akI = new ArrayList<>();
    private int akD = 0;
    private int akE = 0;
    private String ad_url = null;
    private String akG = null;
    private String from = null;
    private int akL = 0;
    private PraiseData akO = new PraiseData();
    private AnchorInfoData akP = new AnchorInfoData();
    private long time = 0;
    private int akT = 0;
    private ArrayList<a> ale = new ArrayList<>();
    private bk alf = null;
    private e alg = null;
    private int alm = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> akV = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aln = null;
    private int ald = 0;
    private boolean alq = false;
    private boolean alr = false;
    private int als = 0;
    private boolean alt = false;
    private int anchorLevel = 0;
    public int alG = 0;
    public j alH = new j();
    private List<PbContent> alI = new ArrayList();
    private List<PbContent> alJ = new ArrayList();
    private String category_name = null;
    private ba alw = new ba();
    private ArrayList<com.baidu.tbadk.data.c> alz = new ArrayList<>();
    private PushStatusData alA = new PushStatusData();
    public boolean alQ = false;
    public int alR = -1;
    private long alZ = 0;
    private long ama = 0;
    private PostData amd = new PostData();
    private int alM = 0;
    public int amk = 0;
    private String tieba_game_information_source = "";
    public String amn = "";
    public String amm = "";

    static {
        ali.put(new Point(1, 1), Integer.valueOf(e.f.label_frs_lottery_ing));
        ali.put(new Point(1, 2), Integer.valueOf(e.f.label_frs_lottery_over));
        ali.put(new Point(1, 3), Integer.valueOf(e.f.label_frs_lottery_off));
        ali.put(new Point(1, 4), Integer.valueOf(e.f.label_frs_lottery_d));
        ali.put(new Point(2, 1), Integer.valueOf(e.f.label_frs_activity_shaiing));
        ali.put(new Point(2, 2), Integer.valueOf(e.f.label_frs_activity_shai_over));
        ali.put(new Point(2, 3), Integer.valueOf(e.f.label_frs_activity_shai_off));
        ali.put(new Point(2, 4), Integer.valueOf(e.f.label_frs_activity_shai_d));
        alT.put(new Point(1, 1), Integer.valueOf(e.j.lottery_status_ing));
        alT.put(new Point(1, 2), Integer.valueOf(e.j.lottery_status_over));
        alT.put(new Point(1, 3), Integer.valueOf(e.j.lottery_status_off));
        alT.put(new Point(1, 4), Integer.valueOf(e.j.lottery_status_not_start));
        alT.put(new Point(2, 1), Integer.valueOf(e.j.share_picture_status_ing));
        alT.put(new Point(2, 2), Integer.valueOf(e.j.share_picture_status_over));
        alT.put(new Point(2, 3), Integer.valueOf(e.j.share_picture_status_off));
        alT.put(new Point(2, 4), Integer.valueOf(e.j.share_picture_status_not_start));
        alj.put(1, Integer.valueOf(e.f.label_interview_no));
        alj.put(2, Integer.valueOf(e.f.label_interview_live));
        alj.put(3, Integer.valueOf(e.f.label_interview_off));
        alU.put(1, new o.a(e.j.interview_live_status_not_start, e.d.cp_other_b, e.f.pic_dot_title_red));
        alU.put(2, new o.a(e.j.interview_live_status_ing, e.d.cp_other_c, e.f.pic_dot_title_green));
        alU.put(3, new o.a(e.j.interview_live_status_over, e.d.cp_other_d, e.f.pic_dot_title_blue));
    }

    public bb() {
        this.akK = 0;
        this.akU = 0;
        this.alp = 0L;
        this.mUrl = "";
        this.alB = "";
        this.amj = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.alp = 0L;
        this.akU = 0;
        this.akK = 0;
        this.amj = 0;
        this.mUrl = "";
        this.alB = "";
        this.isBigGie = false;
    }

    public boolean vS() {
        return this.akK == 1;
    }

    public ba vT() {
        return this.alw;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bZ(int i) {
        this.anchorLevel = i;
    }

    public int vU() {
        return this.alM;
    }

    public void ca(int i) {
        this.alM = i;
    }

    public void cb(int i) {
        this.als = i;
    }

    public int vV() {
        return this.als;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo vW() {
        return this.amr;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long vX() {
        return this.ala;
    }

    public String vY() {
        return this.akQ;
    }

    public PraiseData vZ() {
        return this.akO;
    }

    public void a(PraiseData praiseData) {
        this.akO = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String wa() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void dD(String str) {
        this.ako = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.akn = i;
    }

    public int wb() {
        return this.akn;
    }

    public String wc() {
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
        this.alI = list;
    }

    public void v(List<PbContent> list) {
        this.alJ = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void cc(int i) {
        this.reply_num = i;
    }

    public int wd() {
        return this.reply_num;
    }

    public int we() {
        return this.aku;
    }

    public void cd(int i) {
        this.aku = i;
    }

    public long wf() {
        return this.akv;
    }

    public void s(long j) {
        this.akv = j;
    }

    public int wg() {
        return this.akx;
    }

    public int wh() {
        return this.akw;
    }

    public void ce(int i) {
        this.akw = i;
    }

    public int wi() {
        return this.aky;
    }

    public void cf(int i) {
        this.aky = i;
    }

    public int wj() {
        return this.akz;
    }

    public List<PbContent> wk() {
        return this.alI;
    }

    public bf wl() {
        return this.akA;
    }

    public MetaData wm() {
        return this.akB;
    }

    public boolean wn() {
        return this.is_god != 0;
    }

    public boolean wo() {
        return this.is_god == 1;
    }

    public boolean wp() {
        return (this.akB == null || this.akB.getGodUserData() == null || this.akB.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean wq() {
        return (this.akB == null || this.akB.getGodUserData() == null || this.akB.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean wr() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.akB = metaData;
    }

    public String ws() {
        return this.forum_name;
    }

    public void dE(String str) {
        this.forum_name = str;
    }

    public int wt() {
        return this.akE;
    }

    public String wu() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.akG;
    }

    public void dF(String str) {
        this.akG = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.alJ == null || this.alJ.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.alJ.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.alJ.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.alI == null || (size = this.alI.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.alI.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString dG(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.alJ != null && (size = this.alJ.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.alJ.get(i2);
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
                                bb.this.dK(pbContent.link);
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

    public int wv() {
        return this.akL;
    }

    public void cg(int i) {
        this.akL = i;
    }

    public String ww() {
        return this.akM;
    }

    public void dH(String str) {
        this.akM = str;
    }

    public ArrayList<MediaData> wx() {
        return this.akH;
    }

    public ArrayList<a> wy() {
        return this.ale;
    }

    public void l(ArrayList<a> arrayList) {
        this.ale = arrayList;
    }

    public bk wz() {
        return this.alf;
    }

    public e wA() {
        return this.alg;
    }

    public ArrayList<VoiceData.VoiceModel> wB() {
        return this.akI;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int wC() {
        return this.akR;
    }

    public void ch(int i) {
        this.akR = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String wD() {
        return this.alc;
    }

    public VideoInfo wE() {
        return this.akW;
    }

    public VideoDesc wF() {
        return this.akX;
    }

    public void a(AlaInfoData alaInfoData) {
        this.akZ = alaInfoData;
    }

    public AlaInfoData wG() {
        return this.akZ;
    }

    public PushStatusData wH() {
        return this.alA;
    }

    public SkinInfo wI() {
        return this.alC;
    }

    public long wJ() {
        return this.alN;
    }

    public boolean wK() {
        return this.alO;
    }

    public String wL() {
        return this.alP;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.akS = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.akK = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.ala = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.akt = threadInfo.repost_num.intValue();
                this.aku = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.akv = threadInfo.last_time_int.intValue();
                this.akw = threadInfo.is_top.intValue();
                this.akx = threadInfo.is_membertop.intValue();
                this.aky = threadInfo.is_good.intValue();
                this.akz = threadInfo.is_livepost.intValue();
                this.akA.a(threadInfo.topic);
                this.akB.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.akC = threadInfo.fname;
                this.akD = threadInfo.has_commented.intValue();
                this.akE = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.akW = threadInfo.video_info;
                this.akX = threadInfo.video_segment;
                this.akZ = new AlaInfoData();
                this.akZ.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.akL = threadInfo.collect_status.intValue();
                this.akM = threadInfo.collect_mark_pid;
                this.akN = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.akQ = threadInfo.first_post_id + "";
                this.alc = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.akR = threadInfo.is_ntitle.intValue();
                this.akT = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.amb = threadInfo.agree.has_agree.intValue();
                    this.amc = threadInfo.agree.agree_type.intValue();
                    this.alZ = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.ama = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.ame = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.akU = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.alK = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.alI = threadInfo.rich_title;
                this.alJ = threadInfo.rich_abstract;
                this.akJ = threadInfo.is_godthread_recommend.intValue();
                if ((this.akB == null || this.akB.getUserId() == null || this.akB.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.akB = metaData;
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
                this.akG = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.akH.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.akW = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.akY = new bh();
                    this.akY.a(threadInfo.video_channel_info);
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
                        this.akI.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.ale.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.alf = new bk();
                    this.alf.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.alg = new e();
                    this.alg.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.alh = new m();
                    this.alh.a(threadInfo.cartoon_info);
                }
                this.akO.setUserMap(this.userMap);
                this.akO.parserProtobuf(threadInfo.zan);
                this.akP.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.akO.setTitle(this.title);
                } else {
                    this.akO.setTitle(this.akG);
                }
                this.alk = threadInfo.livecover_src;
                this.alm = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.ald = threadInfo.post_num.intValue();
                this.alp = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.eH(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gA(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.akV.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aln = noticeInfo.notice;
                    }
                    this.als = zhiBoInfoTW.copythread_remind.intValue();
                    this.alq = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.alr = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.alk)) {
                        this.alk = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.alx = zhiBoInfoTW.user.tw_anchor_info;
                        this.aly = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.alo = threadInfo.twzhibo_info.livecover_status;
                    this.alp = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.alt = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.alw.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.alz.add(cVar);
                    }
                }
                this.alA.parserProtobuf(threadInfo.push_status);
                this.alF = threadInfo.lego_card;
                this.alC = threadInfo.skin_info;
                this.alG = threadInfo.is_book_chapter.intValue();
                this.alH.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.alP = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.alN = threadInfo.last_read_pid.longValue();
                this.alO = threadInfo.cheak_repeat.intValue() == 1;
                this.alS = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.amd.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.y(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aiT = sparseArray;
                }
                this.alY = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.amf = new ad();
                    this.amf.a(threadInfo.link_info);
                }
                this.amg = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.amh = new d();
                    this.amh.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ami = new MediaData();
                    this.ami.parserProtobuf(threadInfo.pic_info);
                }
                this.alM = threadInfo.is_called.intValue();
                this.amj = threadInfo.middle_page_num.intValue();
                this.amk = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.amm = threadInfo.star_rank_icon.icon_pic_url;
                    this.amn = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.aml = new OriginalThreadInfo();
                    this.aml.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.aml = new OriginalThreadInfo();
                    this.aml.parser(threadInfo.origin_thread_info);
                } else {
                    this.aml = null;
                }
                this.amo = threadInfo.is_topic.intValue();
                this.amp = threadInfo.topic_user_name;
                this.amq = threadInfo.topic_h5_url;
                this.ams = threadInfo.presentation_style;
                this.amu = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.amw = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.akq = new ay();
                    this.akq.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.amy = threadInfo.swan_info;
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
                this.ala = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.akt = jSONObject.optInt("repost_num", 0);
                this.aku = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.akv = jSONObject.optLong("last_time_int", 0L);
                this.akw = jSONObject.optInt("is_top", 0);
                this.akx = jSONObject.optInt("is_membertop", 0);
                this.aky = jSONObject.optInt("is_good", 0);
                this.akz = jSONObject.optInt("is_livepost", 0);
                this.akA.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.akB.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.akC = this.forum_name;
                this.akD = jSONObject.optInt("has_commented", 0);
                this.akE = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.akL = jSONObject.optInt("collect_status");
                this.akM = jSONObject.optString("collect_mark_pid");
                this.akN = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.alZ = jSONObject.optInt("agree_num");
                this.ame = jSONObject.optLong("share_num");
                this.akQ = jSONObject.optString("first_post_id", "0");
                this.alc = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.akR = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.amb = optJSONObject2.optInt("has_agree");
                    this.alZ = optJSONObject2.optInt("agree_num");
                    this.ama = optJSONObject2.optLong("disagree_num");
                    this.amc = optJSONObject2.optInt("agree_type");
                    if (this.alZ < 0) {
                        this.alZ = 0L;
                    }
                    if (this.ama < 0) {
                        this.ama = 0L;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.alw.parserJson(optJSONObject3);
                }
                if ((this.akB == null || this.akB.getUserId() == null) && this.userMap != null) {
                    this.akB = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.akZ = new AlaInfoData();
                this.akZ.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.akG = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.akH.add(mediaData);
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
                        this.akI.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.ale.add(aVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.alf = new bk();
                    this.alf.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.alg = new e();
                    this.alg.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.alh = new m();
                    this.alh.parserJson(optJSONObject7);
                }
                this.akO.setUserMap(this.userMap);
                this.akO.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.akP.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.akO.setTitle(this.title);
                } else {
                    this.akO.setTitle(this.akG);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.alw.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.alz.add(cVar);
                    }
                }
                this.alG = jSONObject.optInt("is_book_chapter", 0);
                this.alH.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.alP = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.alN = jSONObject.optLong("last_read_pid");
                this.alO = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.akY = new bh();
                    this.akY.v(optJSONObject9);
                }
                this.alY = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.amf = new ad();
                    this.amf.parserJson(optJSONObject10);
                }
                this.amg = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.amh = new d();
                    this.amh.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.ami = new MediaData();
                    this.ami.parserJson(optJSONObject12);
                }
                this.alM = jSONObject.optInt("is_called", 0);
                this.amj = jSONObject.optInt("middle_page_num", 0);
                this.amk = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject13 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject13 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject13.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject13.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject13.optString("video_md5");
                    builder.video_url = optJSONObject13.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    builder.video_duration = new Integer(optJSONObject13.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION, 0));
                    builder.video_width = new Integer(optJSONObject13.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject13.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject13.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject13.optInt("video_type", 0));
                    builder.thumbnail_url = optJSONObject13.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject13.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject13.optInt("is_vertical", 0));
                    this.akW = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.aml = new OriginalThreadInfo();
                        this.aml.parserJson(optJSONObject14);
                    } else {
                        this.aml = null;
                    }
                }
                JSONObject optJSONObject15 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject15 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject15.optString("avatar");
                    builder2.name = optJSONObject15.optString("name");
                    builder2._abstract = optJSONObject15.optString("abstract");
                    builder2.pic = optJSONObject15.optString("pic");
                    builder2.h5_url = optJSONObject15.optString("h5_url");
                    builder2.id = optJSONObject15.optString("id");
                    builder2.link = optJSONObject15.optString("link");
                    this.amy = builder2.build(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder wM() {
        return this.akF;
    }

    public boolean wN() {
        return wh() != 0;
    }

    public int wO() {
        if (this.alw != null) {
            long vO = this.alw.vO();
            long vP = this.alw.vP();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < vO) {
                return 1;
            }
            if (currentTimeMillis > vP) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int wP() {
        if (wR() && this.ale.size() >= 1) {
            a aVar = this.ale.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int uD = aVar.uD();
            int uE = aVar.uE();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < uD) {
                return 4;
            }
            return currentTimeMillis > uE ? 2 : 1;
        }
        return -1;
    }

    public int wQ() {
        if (!wR() || this.ale.size() < 1 || this.ale.get(0) == null) {
            return -1;
        }
        return this.ale.get(0).uC();
    }

    public boolean wR() {
        return this.akT == 1;
    }

    public String getActUrl() {
        return (!wR() || this.ale.size() < 1 || this.ale.get(0) == null) ? "" : this.ale.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dI(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(e.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(e.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(e.d.cp_cont_f_1));
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

    public SmartApp wS() {
        return this.amy;
    }

    private void f(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && wU()) {
                arrayList.add(Integer.valueOf(e.f.icon_convene));
            }
            if (wh() == 1) {
                arrayList.add(Integer.valueOf(e.f.icon_top));
            } else if (wh() == 2) {
                arrayList.add(Integer.valueOf(e.f.icon_notice));
            }
            if (wj() == 1 || this.akA.xZ() != 0) {
                if (vT() != null && getThreadType() == 41) {
                    if (wO() == 2) {
                        arrayList.add(Integer.valueOf(e.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(e.f.icon_zhibo));
                }
            }
            if (z && xe()) {
                Integer num = alj.get(Integer.valueOf(wO()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (wi() == 1 && !wN() && aka != getType() && akf != getType()) {
                arrayList.add(Integer.valueOf(e.f.icon_elite));
            }
            if (this.akP != null && this.akP.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(e.f.icon_live_on));
            }
            if (wt() == 1) {
                arrayList.add(Integer.valueOf(e.f.frs_post_ding));
            }
            Integer num2 = ali.get(new Point(wQ(), wP()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (wz() != null) {
                arrayList.add(Integer.valueOf(e.f.tag_act));
            }
            if (wA() != null) {
                arrayList.add(Integer.valueOf(e.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = dI(this.category_name);
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
                Bitmap dc = com.baidu.tbadk.core.util.al.dc(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dc);
                if (dc != null) {
                    bitmapDrawable.setBounds(0, 0, dc.getWidth(), dc.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.akp));
                spannableString.setSpan(mVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder d = !z && wh() == 1 ? null : d(a.toString(), null);
            if (d == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) d);
            }
        }
        this.akF = spannableStringBuilder;
    }

    public boolean wT() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || wE() == null || wE().video_type.intValue() == 0) {
            return i == 1 && wE() != null && (wE().video_type.intValue() == 1 || wE().video_type.intValue() == 12 || wE().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0141e.ds8);
        Bitmap dc = com.baidu.tbadk.core.util.al.dc(e.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(dc);
        bitmapDrawable.setBounds(0, 0, dc.getWidth(), dc.getHeight());
        com.baidu.tbadk.core.view.n nVar = new com.baidu.tbadk.core.view.n(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (wm() != null) {
            if (wm().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.he));
            } else if (wm().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(nVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableStringBuilder d(String str, ArrayList<o.a> arrayList) {
        if (xa() || !wn() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(e.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean wU() {
        return com.baidu.adp.lib.b.d.iB().aO("isConveneThreadOpen") == 1;
    }

    public void g(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.y(a(z, z2, z3, false)) > 0) {
            h(z, z3);
            return;
        }
        String g = g(this.title, false);
        SpannableString a = a(new SpannableString(g + " "));
        if (z) {
            spannableStringBuilder = a(g, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.akF = spannableStringBuilder;
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
            if (this.akR == 1) {
                this.akF = a2;
                return a2;
            }
        } else if (this.akR == 1) {
            this.akF = new SpannableStringBuilder();
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

    public void V(String str, String str2) {
        this.mUrl = str;
        this.alB = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a B;
        com.baidu.adp.widget.ImageView.a B2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.alB) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.Kg().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.A(this.mUrl, 10)) && (B = com.baidu.tbadk.core.util.d.v.B(this.mUrl, 10)) != null) {
                bitmap = B.oh();
                com.baidu.tbadk.imageManager.c.Kg().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.Kg().getBitmap(this.alB);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.A(this.alB, 10)) && (B2 = com.baidu.tbadk.core.util.d.v.B(this.alB, 10)) != null) {
                bitmap2 = B2.oh();
                com.baidu.tbadk.imageManager.c.Kg().b(this.alB, bitmap2);
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
                        com.baidu.tbadk.core.view.o oVar = new com.baidu.tbadk.core.view.o(bitmapDrawable);
                        oVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.akp));
                        spannableString.setSpan(oVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.jn().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Kg().b(str2, aVar.oh());
                    }
                }
            }, ajY);
            com.baidu.adp.lib.f.c.jn().a(this.alB, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Kg().b(str2, aVar.oh());
                    }
                }
            }, ajY);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.alI != null && this.alI.size() > 0) {
            int size = this.alI.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.alI.get(i2);
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
                                bb.this.dK(pbContent.link);
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

    private String dJ(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData wV() {
        if (this.alI != null && this.alI.size() > 0) {
            int size = this.alI.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.alI.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && xa() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = dJ(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
            iVar.mLink = str;
            iVar.type = this.akn;
            iVar.aOx = this.ako;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
        }
    }

    public void wW() {
        f(false, false);
    }

    public void wX() {
        f(false, true);
    }

    public AnchorInfoData wY() {
        return this.akP;
    }

    public boolean wZ() {
        return this.threadType == 36;
    }

    public boolean xa() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> wx = wx();
        if (wx == null || wN()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= wx.size() || i2 >= 3) {
                break;
            }
            if (wx.get(i2) != null && wx.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(wx.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = wx.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = wx.get(i2).getPicUrl();
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
        if (this.akW != null && !StringUtils.isNull(this.akW.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.akW.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.akB != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.akB.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean xb() {
        String userId;
        return this.akB == null || (userId = this.akB.getUserId()) == null || userId.equals("0");
    }

    private boolean xc() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (xS()) {
            if (wE() != null) {
                return aka;
            }
            return ajX;
        }
        int wh = wh();
        if (this.akW != null && xJ()) {
            return akm;
        }
        if (this.akZ != null && this.threadType == 60) {
            return akd;
        }
        if (this.akZ != null && this.threadType == 49) {
            return akb;
        }
        if (this.threadType == 51) {
            return akc;
        }
        if (wh == 2 || wh == 1) {
            return ajW;
        }
        if (this.akW != null && xl() && !xc()) {
            return akl;
        }
        if (this.akW != null && !xc()) {
            if (wp()) {
                return akf;
            }
            return aka;
        } else if (this.isShareThread) {
            return ake;
        } else {
            if (xd()) {
                return aki.get() ? alv : ajX;
            } else if (wR() && wQ() == 1) {
                return aki.get() ? alD : ajX;
            } else if (isLinkThread()) {
                return ajY;
            } else {
                if (wp()) {
                    return ajZ;
                }
                if (this.amo == 1) {
                    return this.amr != null ? akh : akg;
                }
                return ajX;
            }
        }
    }

    public boolean xd() {
        return vT() != null && getThreadType() == 41 && wj() == 1 && wO() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.akR == 1) {
            this.aho = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aho = 0;
        } else {
            this.aho = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.uM() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.uM().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aho = next.uN();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean xe() {
        return this.threadType == 41;
    }

    public boolean xf() {
        return this.alE;
    }

    public void az(boolean z) {
        this.alE = z;
    }

    public String xg() {
        return this.alF;
    }

    public m xh() {
        return this.alh;
    }

    public boolean xi() {
        return wj() == 1 || wi() == 1 || wh() == 1 || wR() || this.alG == 1 || wp() || wA() != null || wz() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || wo();
    }

    public void xj() {
        if (this.alb == 0) {
            this.alb = 1;
        }
    }

    public boolean xk() {
        return this.alK;
    }

    public void aA(boolean z) {
        this.alQ = z;
    }

    public boolean xl() {
        return this.alQ;
    }

    public void ci(int i) {
        this.alR = i + 1;
    }

    public int xm() {
        return this.alR;
    }

    public List<ReportInfo> xn() {
        return this.alS;
    }

    public boolean xo() {
        return this.alL;
    }

    public void aB(boolean z) {
        this.alL = z;
    }

    public bh xp() {
        return this.akY;
    }

    public void a(bh bhVar) {
        this.akY = bhVar;
    }

    public void cj(int i) {
        if (this.akY != null) {
            this.akY.mCurrentPage = i;
        }
    }

    public boolean xq() {
        return getThreadType() == 49;
    }

    public boolean xr() {
        return getThreadType() == 40;
    }

    public boolean xs() {
        return getThreadType() == 50;
    }

    public boolean xt() {
        return getThreadType() == 60;
    }

    public boolean xu() {
        return getThreadType() == 40 && xp() != null && xp().channelId > 0;
    }

    public int xv() {
        return this.alX;
    }

    public void setSmartFrsPosition(int i) {
        this.alX = i;
    }

    public SparseArray<String> vk() {
        return this.aiT;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aiT = sparseArray;
    }

    public String xw() {
        return this.mRecomSource;
    }

    public boolean xx() {
        return this.alY;
    }

    public long xy() {
        return this.alZ;
    }

    public long xz() {
        return this.ama;
    }

    public int xA() {
        return this.amb;
    }

    public int xB() {
        return this.amc;
    }

    public void ck(int i) {
        this.amb = i;
    }

    public void cl(int i) {
        this.alZ = i;
    }

    public void t(long j) {
        this.alZ = j;
    }

    public void u(long j) {
        this.ama = j;
    }

    public void cm(int i) {
        this.amc = i;
    }

    public long xC() {
        return this.ame;
    }

    public void v(long j) {
        this.ame = j;
    }

    public PostData xD() {
        return this.amd;
    }

    public ad xE() {
        return this.amf;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String g;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.akR == 1) {
            g = g(this.akG, true);
            a = dG(this.akG);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(g + " "));
        }
        if (z) {
            spannableStringBuilder = a(g, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.akF = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        SpannableString dG;
        if (!StringUtils.isNull(this.title) && this.akR != 1) {
            dG = a(new SpannableString(g(this.title, false) + " "));
        } else {
            dG = dG(this.akG);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dG);
        this.akF = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString xF() {
        if (this.akR == 1) {
            return null;
        }
        return dG(this.akG);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean wn = wn();
        if (z2) {
            if (z) {
                if (wn && !xa()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if (wj() == 1 || getThreadType() == 33 || (wl() != null && wl().xZ() != 0)) {
                    if (vT() != null && xe()) {
                        if (wO() == 2) {
                            arrayList.add(new o.a(e.j.interview_live));
                        }
                    } else if (!wn) {
                        arrayList.add(new o.a(e.j.photo_live_tips));
                    }
                }
                if (wh() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (wi() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (xe()) {
                    arrayList.add(alU.get(wO()));
                }
                if (wR()) {
                    Integer num = alT.get(new Point(wQ(), wP()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (wz() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (wn && wh() != 1 && !xa()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if ((wj() == 1 || getThreadType() == 33) && !xe() && !wn) {
                    arrayList.add(new o.a(e.j.photo_live_tips));
                }
                if (wi() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (wh() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (xe() && vT() != null && wO() == 2) {
                    arrayList.add(new o.a(e.j.interview_live));
                }
                if (wR()) {
                    Integer num2 = alT.get(new Point(wQ(), wP()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (this.alG == 1) {
                    arrayList.add(new o.a(e.j.card_tbread_text));
                }
                if (wA() != null) {
                    arrayList.add(new o.a(e.j.send_app_code_gift, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (wz() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && xq()) {
                    arrayList.add(new o.a(e.j.ala_live));
                }
                if (xu()) {
                    arrayList.add(new o.a(e.j.frs_channel_tip));
                } else if (z3 && xs()) {
                    arrayList.add(new o.a(e.j.live_record));
                } else if (xr()) {
                    arrayList.add(new o.a(e.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new o.a(e.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void n(ArrayList<MediaData> arrayList) {
        this.akH = arrayList;
    }

    public String xG() {
        return this.amp;
    }

    public void dL(String str) {
        this.amp = str;
    }

    public void xH() {
        this.amo = 1;
    }

    public boolean xI() {
        return this.amo == 1;
    }

    public boolean xJ() {
        return this.ams.equals("worldcupvideo");
    }

    public String xK() {
        return this.akr;
    }

    public void dM(String str) {
        this.akr = str;
    }

    public String xL() {
        return this.aks;
    }

    public void dN(String str) {
        this.aks = str;
    }

    public String xM() {
        return this.amq;
    }

    public void dO(String str) {
        this.amq = str;
    }

    public boolean xN() {
        return this.amt;
    }

    public void aC(boolean z) {
        this.amt = z;
    }

    public void a(VideoInfo videoInfo) {
        this.amr = videoInfo;
    }

    public boolean xO() {
        return this.amu != null;
    }

    public String xP() {
        return this.akC;
    }

    public String xQ() {
        return this.amw;
    }

    public ay xR() {
        return this.akq;
    }

    public boolean xS() {
        return this.amx;
    }

    public void aD(boolean z) {
        this.amx = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.akW != null) {
            return this.akW.video_url;
        }
        return null;
    }
}

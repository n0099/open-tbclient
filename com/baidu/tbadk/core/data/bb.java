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
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
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
    private String atA;
    private String atB;
    private String atL;
    private SpannableStringBuilder atO;
    public int atS;
    private int atT;
    private int atW;
    private String atZ;
    private ay atz;
    public TwZhiBoUser auF;
    public List<TwAnchorProfitItem> auG;
    private String auJ;
    private SkinInfo auK;
    private boolean auM;
    private String auN;
    private boolean auS;
    private boolean auT;
    public long auV;
    public String auX;
    private int aua;
    private String aub;
    private int aud;
    private VideoInfo auf;
    private VideoDesc aug;
    private bh auh;
    private AlaInfoData aui;
    private long auj;
    private m auq;
    private String authorId;
    private LiveCoverStatus auw;
    private long aux;
    private String avA;
    public OriginalForumInfo avC;
    public boolean avD;
    private String avE;
    private boolean avF;
    private SmartApp avG;
    private List<ReportInfo> ava;
    private boolean avg;
    private int avj;
    private int avk;
    private long avm;
    private ad avn;
    public d avp;
    private MediaData avq;
    public int avr;
    public OriginalThreadInfo avt;
    private String avx;
    private String avy;
    private VideoInfo avz;
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
    public static final BdUniqueId atf = BdUniqueId.gen();
    public static final BdUniqueId atg = BdUniqueId.gen();
    public static final BdUniqueId ath = BdUniqueId.gen();
    public static final BdUniqueId ati = BdUniqueId.gen();
    public static final BdUniqueId atj = BdUniqueId.gen();
    public static final BdUniqueId atk = BdUniqueId.gen();
    public static final BdUniqueId atl = BdUniqueId.gen();
    public static final BdUniqueId atm = BdUniqueId.gen();
    public static final BdUniqueId atn = BdUniqueId.gen();
    public static final BdUniqueId ato = BdUniqueId.gen();
    public static final BdUniqueId atp = BdUniqueId.gen();
    public static final BdUniqueId atq = BdUniqueId.gen();
    public static AtomicBoolean atr = new AtomicBoolean(false);
    public static AtomicBoolean ats = new AtomicBoolean(false);
    public static AtomicBoolean att = new AtomicBoolean(false);
    public static final BdUniqueId atu = BdUniqueId.gen();
    public static final BdUniqueId atv = BdUniqueId.gen();
    private static HashMap<Point, Integer> aur = new HashMap<>();
    private static HashMap<Integer, Integer> aus = new HashMap<>();
    public static final BdUniqueId auC = BdUniqueId.gen();
    public static final BdUniqueId auD = BdUniqueId.gen();
    public static final BdUniqueId auL = BdUniqueId.gen();
    private static HashMap<Point, Integer> avb = new HashMap<>();
    private static SparseArray<o.a> avc = new SparseArray<>(3);
    private int atw = 0;
    private String atx = "1";
    public int aty = 1;
    private String atV = null;
    private int aqy = 0;
    public int auk = 0;
    private String aul = "";
    private String aut = "";
    public boolean auW = true;
    public boolean avd = false;
    public boolean ave = false;
    private int avf = -1;
    private SparseArray<String> asc = null;
    public boolean avo = false;
    private int avw = 0;
    private boolean avB = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int atC = 0;
    private int atD = 0;
    private String last_time = null;
    private long atE = 0;
    private int atF = 0;
    private int atG = 0;
    private int atH = 0;
    private int atI = 0;
    private bf atJ = new bf();
    private MetaData atK = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> atQ = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> atR = new ArrayList<>();
    private int atM = 0;
    private int atN = 0;
    private String ad_url = null;
    private String atP = null;
    private String from = null;
    private int atU = 0;
    private PraiseData atX = new PraiseData();
    private AnchorInfoData atY = new AnchorInfoData();
    private long time = 0;
    private int auc = 0;
    private ArrayList<a> aun = new ArrayList<>();
    private bk auo = null;
    private e aup = null;
    private int auu = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aue = new ArrayList<>();
    private boolean isHeadLive = false;
    private String auv = null;
    private int aum = 0;
    private boolean auy = false;
    private boolean auz = false;
    private int auA = 0;
    private boolean auB = false;
    private int anchorLevel = 0;
    public int auO = 0;
    public j auP = new j();
    private List<PbContent> auQ = new ArrayList();
    private List<PbContent> auR = new ArrayList();
    private String category_name = null;
    private ba auE = new ba();
    private ArrayList<com.baidu.tbadk.data.c> auH = new ArrayList<>();
    private PushStatusData auI = new PushStatusData();
    public boolean auY = false;
    public int auZ = -1;
    private long avh = 0;
    private long avi = 0;
    private PostData avl = new PostData();
    private int auU = 0;
    public int avs = 0;
    private String tieba_game_information_source = "";
    public String avv = "";
    public String avu = "";

    static {
        aur.put(new Point(1, 1), Integer.valueOf(e.f.label_frs_lottery_ing));
        aur.put(new Point(1, 2), Integer.valueOf(e.f.label_frs_lottery_over));
        aur.put(new Point(1, 3), Integer.valueOf(e.f.label_frs_lottery_off));
        aur.put(new Point(1, 4), Integer.valueOf(e.f.label_frs_lottery_d));
        aur.put(new Point(2, 1), Integer.valueOf(e.f.label_frs_activity_shaiing));
        aur.put(new Point(2, 2), Integer.valueOf(e.f.label_frs_activity_shai_over));
        aur.put(new Point(2, 3), Integer.valueOf(e.f.label_frs_activity_shai_off));
        aur.put(new Point(2, 4), Integer.valueOf(e.f.label_frs_activity_shai_d));
        avb.put(new Point(1, 1), Integer.valueOf(e.j.lottery_status_ing));
        avb.put(new Point(1, 2), Integer.valueOf(e.j.lottery_status_over));
        avb.put(new Point(1, 3), Integer.valueOf(e.j.lottery_status_off));
        avb.put(new Point(1, 4), Integer.valueOf(e.j.lottery_status_not_start));
        avb.put(new Point(2, 1), Integer.valueOf(e.j.share_picture_status_ing));
        avb.put(new Point(2, 2), Integer.valueOf(e.j.share_picture_status_over));
        avb.put(new Point(2, 3), Integer.valueOf(e.j.share_picture_status_off));
        avb.put(new Point(2, 4), Integer.valueOf(e.j.share_picture_status_not_start));
        aus.put(1, Integer.valueOf(e.f.label_interview_no));
        aus.put(2, Integer.valueOf(e.f.label_interview_live));
        aus.put(3, Integer.valueOf(e.f.label_interview_off));
        avc.put(1, new o.a(e.j.interview_live_status_not_start, e.d.cp_other_b, e.f.pic_dot_title_red));
        avc.put(2, new o.a(e.j.interview_live_status_ing, e.d.cp_other_c, e.f.pic_dot_title_green));
        avc.put(3, new o.a(e.j.interview_live_status_over, e.d.cp_other_d, e.f.pic_dot_title_blue));
    }

    public bb() {
        this.atT = 0;
        this.aud = 0;
        this.aux = 0L;
        this.mUrl = "";
        this.auJ = "";
        this.avr = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.aux = 0L;
        this.aud = 0;
        this.atT = 0;
        this.avr = 0;
        this.mUrl = "";
        this.auJ = "";
        this.isBigGie = false;
    }

    public boolean zm() {
        return this.atT == 1;
    }

    public ba zn() {
        return this.auE;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void cM(int i) {
        this.anchorLevel = i;
    }

    public int zo() {
        return this.auU;
    }

    public void cN(int i) {
        this.auU = i;
    }

    public void cO(int i) {
        this.auA = i;
    }

    public int zp() {
        return this.auA;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo zq() {
        return this.avz;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long zr() {
        return this.auj;
    }

    public String zs() {
        return this.atZ;
    }

    public PraiseData zt() {
        return this.atX;
    }

    public void a(PraiseData praiseData) {
        this.atX = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String zu() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void el(String str) {
        this.atx = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.atw = i;
    }

    public int zv() {
        return this.atw;
    }

    public String zw() {
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

    public void D(List<PbContent> list) {
        this.auQ = list;
    }

    public void E(List<PbContent> list) {
        this.auR = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void cP(int i) {
        this.reply_num = i;
    }

    public int zx() {
        return this.reply_num;
    }

    public int zy() {
        return this.atD;
    }

    public void cQ(int i) {
        this.atD = i;
    }

    public long zz() {
        return this.atE;
    }

    public void B(long j) {
        this.atE = j;
    }

    public int zA() {
        return this.atG;
    }

    public int zB() {
        return this.atF;
    }

    public void cR(int i) {
        this.atF = i;
    }

    public int zC() {
        return this.atH;
    }

    public void cS(int i) {
        this.atH = i;
    }

    public int zD() {
        return this.atI;
    }

    public List<PbContent> zE() {
        return this.auQ;
    }

    public bf zF() {
        return this.atJ;
    }

    public MetaData zG() {
        return this.atK;
    }

    public boolean zH() {
        return this.is_god != 0;
    }

    public boolean zI() {
        return this.is_god == 1;
    }

    public boolean zJ() {
        return (this.atK == null || this.atK.getGodUserData() == null || this.atK.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean zK() {
        return (this.atK == null || this.atK.getGodUserData() == null || this.atK.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean zL() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.atK = metaData;
    }

    public String zM() {
        return this.forum_name;
    }

    public void em(String str) {
        this.forum_name = str;
    }

    public int zN() {
        return this.atN;
    }

    public String zO() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.atP;
    }

    public void en(String str) {
        this.atP = str;
    }

    public String o(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.auR == null || this.auR.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.auR.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.auR.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.auQ == null || (size = this.auQ.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.auQ.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString eo(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(o(str, true));
        if (this.auR != null && (size = this.auR.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.auR.get(i2);
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
                                bb.this.es(pbContent.link);
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

    public int zP() {
        return this.atU;
    }

    public void cT(int i) {
        this.atU = i;
    }

    public String zQ() {
        return this.atV;
    }

    public void ep(String str) {
        this.atV = str;
    }

    public ArrayList<MediaData> zR() {
        return this.atQ;
    }

    public ArrayList<a> zS() {
        return this.aun;
    }

    public void l(ArrayList<a> arrayList) {
        this.aun = arrayList;
    }

    public bk zT() {
        return this.auo;
    }

    public e zU() {
        return this.aup;
    }

    public ArrayList<VoiceData.VoiceModel> zV() {
        return this.atR;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int zW() {
        return this.aua;
    }

    public void cU(int i) {
        this.aua = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String zX() {
        return this.aul;
    }

    public VideoInfo zY() {
        return this.auf;
    }

    public VideoDesc zZ() {
        return this.aug;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aui = alaInfoData;
    }

    public AlaInfoData Aa() {
        return this.aui;
    }

    public PushStatusData Ab() {
        return this.auI;
    }

    public SkinInfo Ac() {
        return this.auK;
    }

    public long Ad() {
        return this.auV;
    }

    public boolean Ae() {
        return this.auW;
    }

    public String Af() {
        return this.auX;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aub = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.atT = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.auj = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.atC = threadInfo.repost_num.intValue();
                this.atD = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.atE = threadInfo.last_time_int.intValue();
                this.atF = threadInfo.is_top.intValue();
                this.atG = threadInfo.is_membertop.intValue();
                this.atH = threadInfo.is_good.intValue();
                this.atI = threadInfo.is_livepost.intValue();
                this.atJ.a(threadInfo.topic);
                this.atK.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.atL = threadInfo.fname;
                this.atM = threadInfo.has_commented.intValue();
                this.atN = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.auf = threadInfo.video_info;
                this.aug = threadInfo.video_segment;
                this.aui = new AlaInfoData();
                this.aui.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.atU = threadInfo.collect_status.intValue();
                this.atV = threadInfo.collect_mark_pid;
                this.atW = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.atZ = threadInfo.first_post_id + "";
                this.aul = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aua = threadInfo.is_ntitle.intValue();
                this.auc = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.avj = threadInfo.agree.has_agree.intValue();
                    this.avk = threadInfo.agree.agree_type.intValue();
                    this.avh = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.avi = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.avm = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aud = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.auS = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.auQ = threadInfo.rich_title;
                this.auR = threadInfo.rich_abstract;
                this.atS = threadInfo.is_godthread_recommend.intValue();
                if ((this.atK == null || this.atK.getUserId() == null || this.atK.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.atK = metaData;
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
                this.atP = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.atQ.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.auf = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.auh = new bh();
                    this.auh.a(threadInfo.video_channel_info);
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
                        this.atR.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aun.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.auo = new bk();
                    this.auo.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aup = new e();
                    this.aup.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.auq = new m();
                    this.auq.a(threadInfo.cartoon_info);
                }
                this.atX.setUserMap(this.userMap);
                this.atX.parserProtobuf(threadInfo.zan);
                this.atY.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.atX.setTitle(this.title);
                } else {
                    this.atX.setTitle(this.atP);
                }
                this.aut = threadInfo.livecover_src;
                this.auu = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aum = threadInfo.post_num.intValue();
                this.aux = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.fs(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.hh(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aue.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.auv = noticeInfo.notice;
                    }
                    this.auA = zhiBoInfoTW.copythread_remind.intValue();
                    this.auy = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.auz = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aut)) {
                        this.aut = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.auF = zhiBoInfoTW.user.tw_anchor_info;
                        this.auG = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.auw = threadInfo.twzhibo_info.livecover_status;
                    this.aux = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.auB = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.auE.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.auH.add(cVar);
                    }
                }
                this.auI.parserProtobuf(threadInfo.push_status);
                this.auN = threadInfo.lego_card;
                this.auK = threadInfo.skin_info;
                this.auO = threadInfo.is_book_chapter.intValue();
                this.auP.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.auX = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.auV = threadInfo.last_read_pid.longValue();
                this.auW = threadInfo.cheak_repeat.intValue() == 1;
                this.ava = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.avl.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.H(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.asc = sparseArray;
                }
                this.avg = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.avn = new ad();
                    this.avn.a(threadInfo.link_info);
                }
                this.avo = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.avp = new d();
                    this.avp.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.avq = new MediaData();
                    this.avq.parserProtobuf(threadInfo.pic_info);
                }
                this.auU = threadInfo.is_called.intValue();
                this.avr = threadInfo.middle_page_num.intValue();
                this.avs = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.avu = threadInfo.star_rank_icon.icon_pic_url;
                    this.avv = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.avt = new OriginalThreadInfo();
                    this.avt.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.avt = new OriginalThreadInfo();
                    this.avt.parser(threadInfo.origin_thread_info);
                } else {
                    this.avt = null;
                }
                this.avw = threadInfo.is_topic.intValue();
                this.avx = threadInfo.topic_user_name;
                this.avy = threadInfo.topic_h5_url;
                this.avA = threadInfo.presentation_style;
                this.avC = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.avE = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.atz = new ay();
                    this.atz.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.avG = threadInfo.swan_info;
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
                this.auj = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.atC = jSONObject.optInt("repost_num", 0);
                this.atD = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.atE = jSONObject.optLong("last_time_int", 0L);
                this.atF = jSONObject.optInt("is_top", 0);
                this.atG = jSONObject.optInt("is_membertop", 0);
                this.atH = jSONObject.optInt("is_good", 0);
                this.atI = jSONObject.optInt("is_livepost", 0);
                this.atJ.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.atK.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.atL = this.forum_name;
                this.atM = jSONObject.optInt("has_commented", 0);
                this.atN = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.atU = jSONObject.optInt("collect_status");
                this.atV = jSONObject.optString("collect_mark_pid");
                this.atW = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.avh = jSONObject.optInt("agree_num");
                this.avm = jSONObject.optLong("share_num");
                this.atZ = jSONObject.optString("first_post_id", "0");
                this.aul = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.aua = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.avj = optJSONObject2.optInt("has_agree");
                    this.avh = optJSONObject2.optInt("agree_num");
                    this.avi = optJSONObject2.optLong("disagree_num");
                    this.avk = optJSONObject2.optInt("agree_type");
                    if (this.avh < 0) {
                        this.avh = 0L;
                    }
                    if (this.avi < 0) {
                        this.avi = 0L;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.auE.parserJson(optJSONObject3);
                }
                if ((this.atK == null || this.atK.getUserId() == null) && this.userMap != null) {
                    this.atK = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aui = new AlaInfoData();
                this.aui.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.atP = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.atQ.add(mediaData);
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
                        this.atR.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aun.add(aVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.auo = new bk();
                    this.auo.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.aup = new e();
                    this.aup.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.auq = new m();
                    this.auq.parserJson(optJSONObject7);
                }
                this.atX.setUserMap(this.userMap);
                this.atX.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.atY.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.atX.setTitle(this.title);
                } else {
                    this.atX.setTitle(this.atP);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.auE.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.auH.add(cVar);
                    }
                }
                this.auO = jSONObject.optInt("is_book_chapter", 0);
                this.auP.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.auX = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.auV = jSONObject.optLong("last_read_pid");
                this.auW = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.auh = new bh();
                    this.auh.z(optJSONObject9);
                }
                this.avg = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.avn = new ad();
                    this.avn.parserJson(optJSONObject10);
                }
                this.avo = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.avp = new d();
                    this.avp.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.avq = new MediaData();
                    this.avq.parserJson(optJSONObject12);
                }
                this.auU = jSONObject.optInt("is_called", 0);
                this.avr = jSONObject.optInt("middle_page_num", 0);
                this.avs = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    builder.mcn_lead_page = new String(optJSONObject13.optString("mcn_lead_page"));
                    this.auf = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.avt = new OriginalThreadInfo();
                        this.avt.parserJson(optJSONObject14);
                    } else {
                        this.avt = null;
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
                    builder2.link = optJSONObject15.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
                    this.avG = builder2.build(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder Ag() {
        return this.atO;
    }

    public boolean Ah() {
        return zB() != 0;
    }

    public int Ai() {
        if (this.auE != null) {
            long zi = this.auE.zi();
            long zj = this.auE.zj();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < zi) {
                return 1;
            }
            if (currentTimeMillis > zj) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int Aj() {
        if (Al() && this.aun.size() >= 1) {
            a aVar = this.aun.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int xY = aVar.xY();
            int xZ = aVar.xZ();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < xY) {
                return 4;
            }
            return currentTimeMillis > xZ ? 2 : 1;
        }
        return -1;
    }

    public int Ak() {
        if (!Al() || this.aun.size() < 1 || this.aun.get(0) == null) {
            return -1;
        }
        return this.aun.get(0).xX();
    }

    public boolean Al() {
        return this.auc == 1;
    }

    public String getActUrl() {
        return (!Al() || this.aun.size() < 1 || this.aun.get(0) == null) ? "" : this.aun.get(0).getUrl();
    }

    private com.baidu.adp.widget.b eq(String str) {
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

    public SmartApp Am() {
        return this.avG;
    }

    private void f(boolean z, boolean z2) {
        SpannableString spannableString;
        String o = o(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && Ao()) {
                arrayList.add(Integer.valueOf(e.f.icon_convene));
            }
            if (zB() == 1) {
                arrayList.add(Integer.valueOf(e.f.icon_top));
            } else if (zB() == 2) {
                arrayList.add(Integer.valueOf(e.f.icon_notice));
            }
            if (zD() == 1 || this.atJ.Bt() != 0) {
                if (zn() != null && getThreadType() == 41) {
                    if (Ai() == 2) {
                        arrayList.add(Integer.valueOf(e.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(e.f.icon_zhibo));
                }
            }
            if (z && Ay()) {
                Integer num = aus.get(Integer.valueOf(Ai()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (zC() == 1 && !Ah() && atj != getType() && ato != getType()) {
                arrayList.add(Integer.valueOf(e.f.icon_elite));
            }
            if (this.atY != null && this.atY.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(e.f.icon_live_on));
            }
            if (zN() == 1) {
                arrayList.add(Integer.valueOf(e.f.frs_post_ding));
            }
            Integer num2 = aur.get(new Point(Ak(), Aj()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (zT() != null) {
                arrayList.add(Integer.valueOf(e.f.tag_act));
            }
            if (zU() != null) {
                arrayList.add(Integer.valueOf(e.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = eq(this.category_name);
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
                Bitmap dO = com.baidu.tbadk.core.util.al.dO(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                if (dO != null) {
                    bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aty));
                spannableString.setSpan(mVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(o + " "));
        if (a != null) {
            SpannableStringBuilder d = !z && zB() == 1 ? null : d(a.toString(), null);
            if (d == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) d);
            }
        }
        this.atO = spannableStringBuilder;
    }

    public boolean An() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || zY() == null || zY().video_type.intValue() == 0) {
            return i == 1 && zY() != null && (zY().video_type.intValue() == 1 || zY().video_type.intValue() == 12 || zY().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.ds8);
        Bitmap dO = com.baidu.tbadk.core.util.al.dO(e.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
        bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
        com.baidu.tbadk.core.view.n nVar = new com.baidu.tbadk.core.view.n(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (zG() != null) {
            if (zG().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.he));
            } else if (zG().getGender() == 2) {
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
        if (Au() || !zH() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(e.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean Ao() {
        return com.baidu.adp.lib.b.d.iQ().aO("isConveneThreadOpen") == 1;
    }

    public void g(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.H(b(z, z2, z3, false)) > 0) {
            h(z, z3);
            return;
        }
        String o = o(this.title, false);
        SpannableString a = a(new SpannableString(o + " "));
        if (z) {
            spannableStringBuilder = a(o, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.atO = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.aua == 1) {
                this.atO = a;
                return a;
            }
        } else if (this.aua == 1) {
            this.atO = new SpannableStringBuilder();
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

    public void al(String str, String str2) {
        this.mUrl = str;
        this.auJ = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a C;
        com.baidu.adp.widget.ImageView.a C2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.auJ) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.Nu().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.B(this.mUrl, 10)) && (C = com.baidu.tbadk.core.util.d.v.C(this.mUrl, 10)) != null) {
                bitmap = C.op();
                com.baidu.tbadk.imageManager.c.Nu().d(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.Nu().getBitmap(this.auJ);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.B(this.auJ, 10)) && (C2 = com.baidu.tbadk.core.util.d.v.C(this.auJ, 10)) != null) {
                bitmap2 = C2.op();
                com.baidu.tbadk.imageManager.c.Nu().d(this.auJ, bitmap2);
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
                        oVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aty));
                        spannableString.setSpan(oVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.jA().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Nu().d(str2, aVar.op());
                    }
                }
            }, ath);
            com.baidu.adp.lib.f.c.jA().a(this.auJ, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Nu().d(str2, aVar.op());
                    }
                }
            }, ath);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.auQ != null && this.auQ.size() > 0) {
            int size = this.auQ.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.auQ.get(i2);
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
                                bb.this.es(pbContent.link);
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

    private String er(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData Ap() {
        if (this.auQ != null && this.auQ.size() > 0) {
            int size = this.auQ.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.auQ.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && Au() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = er(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
            iVar.mLink = str;
            iVar.type = this.atw;
            iVar.aXm = this.atx;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
        }
    }

    public void Aq() {
        f(false, false);
    }

    public void Ar() {
        f(false, true);
    }

    public AnchorInfoData As() {
        return this.atY;
    }

    public boolean At() {
        return this.threadType == 36;
    }

    public boolean Au() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> zR = zR();
        if (zR == null || Ah()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zR.size() || i2 >= 3) {
                break;
            }
            if (zR.get(i2) != null && zR.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(zR.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = zR.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = zR.get(i2).getPicUrl();
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
        if (this.auf != null && !StringUtils.isNull(this.auf.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.auf.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.atK != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.atK.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean Av() {
        String userId;
        return this.atK == null || (userId = this.atK.getUserId()) == null || userId.equals("0");
    }

    private boolean Aw() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (Bm()) {
            if (zY() != null) {
                return atj;
            }
            return atg;
        }
        int zB = zB();
        if (this.auf != null && Bd()) {
            return atv;
        }
        if (this.aui != null && this.threadType == 60) {
            return atm;
        }
        if (this.aui != null && this.threadType == 49) {
            return atk;
        }
        if (this.threadType == 51) {
            return atl;
        }
        if (zB == 2 || zB == 1) {
            return atf;
        }
        if (this.auf != null && AF() && !Aw()) {
            return atu;
        }
        if (this.auf != null && !Aw()) {
            if (zJ()) {
                return ato;
            }
            return atj;
        } else if (this.isShareThread) {
            return atn;
        } else {
            if (Ax()) {
                return atr.get() ? auD : atg;
            } else if (Al() && Ak() == 1) {
                return atr.get() ? auL : atg;
            } else if (isLinkThread()) {
                return ath;
            } else {
                if (zJ()) {
                    return ati;
                }
                if (this.avw == 1) {
                    return this.avz != null ? atq : atp;
                }
                return atg;
            }
        }
    }

    public boolean Ax() {
        return zn() != null && getThreadType() == 41 && zD() == 1 && Ai() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.aua == 1) {
            this.aqy = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.aqy = 0;
        } else {
            this.aqy = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.yh() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.yh().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.aqy = next.yi();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean Ay() {
        return this.threadType == 41;
    }

    public boolean Az() {
        return this.auM;
    }

    public void ba(boolean z) {
        this.auM = z;
    }

    public String AA() {
        return this.auN;
    }

    public m AB() {
        return this.auq;
    }

    public boolean AC() {
        return zD() == 1 || zC() == 1 || zB() == 1 || Al() || this.auO == 1 || zJ() || zU() != null || zT() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zI();
    }

    public void AD() {
        if (this.auk == 0) {
            this.auk = 1;
        }
    }

    public boolean AE() {
        return this.auS;
    }

    public void bb(boolean z) {
        this.auY = z;
    }

    public boolean AF() {
        return this.auY;
    }

    public void cV(int i) {
        this.auZ = i + 1;
    }

    public int AG() {
        return this.auZ;
    }

    public List<ReportInfo> AH() {
        return this.ava;
    }

    public boolean AI() {
        return this.auT;
    }

    public void bc(boolean z) {
        this.auT = z;
    }

    public bh AJ() {
        return this.auh;
    }

    public void a(bh bhVar) {
        this.auh = bhVar;
    }

    public void setCurrentPage(int i) {
        if (this.auh != null) {
            this.auh.mCurrentPage = i;
        }
    }

    public boolean AK() {
        return getThreadType() == 49;
    }

    public boolean AL() {
        return getThreadType() == 40;
    }

    public boolean AM() {
        return getThreadType() == 50;
    }

    public boolean AN() {
        return getThreadType() == 60;
    }

    public boolean AO() {
        return getThreadType() == 40 && AJ() != null && AJ().channelId > 0;
    }

    public int AP() {
        return this.avf;
    }

    public void setSmartFrsPosition(int i) {
        this.avf = i;
    }

    public SparseArray<String> yF() {
        return this.asc;
    }

    public void a(SparseArray<String> sparseArray) {
        this.asc = sparseArray;
    }

    public String AQ() {
        return this.mRecomSource;
    }

    public boolean AR() {
        return this.avg;
    }

    public long AS() {
        return this.avh;
    }

    public long AT() {
        return this.avi;
    }

    public int AU() {
        return this.avj;
    }

    public int AV() {
        return this.avk;
    }

    public void cW(int i) {
        this.avj = i;
    }

    public void cX(int i) {
        this.avh = i;
    }

    public void C(long j) {
        this.avh = j;
    }

    public void D(long j) {
        this.avi = j;
    }

    public void cY(int i) {
        this.avk = i;
    }

    public long AW() {
        return this.avm;
    }

    public void E(long j) {
        this.avm = j;
    }

    public PostData AX() {
        return this.avl;
    }

    public ad AY() {
        return this.avn;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String o;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aua == 1) {
            o = o(this.atP, true);
            a = eo(this.atP);
        } else {
            o = o(this.title, false);
            a = a(new SpannableString(o + " "));
        }
        if (z) {
            spannableStringBuilder = a(o, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.atO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        SpannableString eo;
        if (!StringUtils.isNull(this.title) && this.aua != 1) {
            eo = a(new SpannableString(o(this.title, false) + " "));
        } else {
            eo = eo(this.atP);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(eo);
        this.atO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString AZ() {
        if (this.aua == 1) {
            return null;
        }
        return eo(this.atP);
    }

    private ArrayList<o.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean zH = zH();
        if (z2) {
            if (z) {
                if (zH && !Au()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if (zD() == 1 || getThreadType() == 33 || (zF() != null && zF().Bt() != 0)) {
                    if (zn() != null && Ay()) {
                        if (Ai() == 2) {
                            arrayList.add(new o.a(e.j.interview_live));
                        }
                    } else if (!zH) {
                        arrayList.add(new o.a(e.j.photo_live_tips));
                    }
                }
                if (zB() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (zC() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (Ay()) {
                    arrayList.add(avc.get(Ai()));
                }
                if (Al()) {
                    Integer num = avb.get(new Point(Ak(), Aj()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (zT() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (zH && zB() != 1 && !Au()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if ((zD() == 1 || getThreadType() == 33) && !Ay() && !zH) {
                    arrayList.add(new o.a(e.j.photo_live_tips));
                }
                if (zC() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (zB() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (Ay() && zn() != null && Ai() == 2) {
                    arrayList.add(new o.a(e.j.interview_live));
                }
                if (Al()) {
                    Integer num2 = avb.get(new Point(Ak(), Aj()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (this.auO == 1) {
                    arrayList.add(new o.a(e.j.card_tbread_text));
                }
                if (zU() != null) {
                    arrayList.add(new o.a(e.j.send_app_code_gift, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (zT() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && AK()) {
                    arrayList.add(new o.a(e.j.ala_live));
                }
                if (AO()) {
                    arrayList.add(new o.a(e.j.frs_channel_tip));
                } else if (z3 && AM()) {
                    arrayList.add(new o.a(e.j.live_record));
                } else if (AL()) {
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
        this.atQ = arrayList;
    }

    public String Ba() {
        return this.avx;
    }

    public void et(String str) {
        this.avx = str;
    }

    public void Bb() {
        this.avw = 1;
    }

    public boolean Bc() {
        return this.avw == 1;
    }

    public boolean Bd() {
        return this.avA.equals("worldcupvideo");
    }

    public String Be() {
        return this.atA;
    }

    public void eu(String str) {
        this.atA = str;
    }

    public String Bf() {
        return this.atB;
    }

    public void ev(String str) {
        this.atB = str;
    }

    public String Bg() {
        return this.avy;
    }

    public void ew(String str) {
        this.avy = str;
    }

    public boolean Bh() {
        return this.avB;
    }

    public void bd(boolean z) {
        this.avB = z;
    }

    public void a(VideoInfo videoInfo) {
        this.avz = videoInfo;
    }

    public boolean Bi() {
        return this.avC != null;
    }

    public String Bj() {
        return this.atL;
    }

    public String Bk() {
        return this.avE;
    }

    public ay Bl() {
        return this.atz;
    }

    public boolean Bm() {
        return this.avF;
    }

    public void be(boolean z) {
        this.avF = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.auf != null) {
            return this.auf.video_url;
        }
        return null;
    }
}

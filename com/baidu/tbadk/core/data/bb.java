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
    private String auB;
    private int auC;
    private String auD;
    private int auF;
    private VideoInfo auH;
    private VideoDesc auI;
    private bh auJ;
    private AlaInfoData auK;
    private long auL;
    private m auS;
    private LiveCoverStatus auY;
    private long auZ;
    private ay aub;
    private String auc;
    private String aud;
    private String aun;
    private SpannableStringBuilder auq;
    private String authorId;
    public int auu;
    private int auv;
    private int auy;
    private List<ReportInfo> avC;
    private boolean avI;
    private int avL;
    private int avM;
    private long avO;
    private ad avP;
    public d avR;
    private MediaData avS;
    public int avT;
    public OriginalThreadInfo avV;
    private String avZ;
    public TwZhiBoUser avh;
    public List<TwAnchorProfitItem> avi;
    private String avl;
    private SkinInfo avm;
    private boolean avo;
    private String avp;
    private boolean avu;
    private boolean avv;
    public long avx;
    public String avz;
    private String awa;
    private VideoInfo awb;
    private String awc;
    public OriginalForumInfo awe;
    public boolean awf;
    private String awg;
    private boolean awh;
    private SmartApp awi;
    public int awj;
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
    public static final BdUniqueId atH = BdUniqueId.gen();
    public static final BdUniqueId atI = BdUniqueId.gen();
    public static final BdUniqueId atJ = BdUniqueId.gen();
    public static final BdUniqueId atK = BdUniqueId.gen();
    public static final BdUniqueId atL = BdUniqueId.gen();
    public static final BdUniqueId atM = BdUniqueId.gen();
    public static final BdUniqueId atN = BdUniqueId.gen();
    public static final BdUniqueId atO = BdUniqueId.gen();
    public static final BdUniqueId atP = BdUniqueId.gen();
    public static final BdUniqueId atQ = BdUniqueId.gen();
    public static final BdUniqueId atR = BdUniqueId.gen();
    public static final BdUniqueId atS = BdUniqueId.gen();
    public static AtomicBoolean atT = new AtomicBoolean(false);
    public static AtomicBoolean atU = new AtomicBoolean(false);
    public static AtomicBoolean atV = new AtomicBoolean(false);
    public static final BdUniqueId atW = BdUniqueId.gen();
    public static final BdUniqueId atX = BdUniqueId.gen();
    private static HashMap<Point, Integer> auT = new HashMap<>();
    private static HashMap<Integer, Integer> auU = new HashMap<>();
    public static final BdUniqueId ave = BdUniqueId.gen();
    public static final BdUniqueId avf = BdUniqueId.gen();
    public static final BdUniqueId avn = BdUniqueId.gen();
    private static HashMap<Point, Integer> avD = new HashMap<>();
    private static SparseArray<o.a> avE = new SparseArray<>(3);
    private int atY = 0;
    private String atZ = "1";
    public int aua = 1;
    private String aux = null;
    private int ara = 0;
    public int auM = 0;
    private String auN = "";
    private String auV = "";
    public boolean avy = true;
    public boolean avF = false;
    public boolean avG = false;
    private int avH = -1;
    private SparseArray<String> asE = null;
    public boolean avQ = false;
    private int avY = 0;
    private boolean awd = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aue = 0;
    private int auf = 0;
    private String last_time = null;
    private long aug = 0;
    private int auh = 0;
    private int aui = 0;
    private int auj = 0;
    private int auk = 0;
    private bf aul = new bf();
    private MetaData aum = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aus = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aut = new ArrayList<>();
    private int auo = 0;
    private int aup = 0;
    private String ad_url = null;
    private String aur = null;
    private String from = null;
    private int auw = 0;
    private PraiseData auz = new PraiseData();
    private AnchorInfoData auA = new AnchorInfoData();
    private long time = 0;
    private int auE = 0;
    private ArrayList<a> auP = new ArrayList<>();
    private bk auQ = null;
    private e auR = null;
    private int auW = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> auG = new ArrayList<>();
    private boolean isHeadLive = false;
    private String auX = null;
    private int auO = 0;
    private boolean ava = false;
    private boolean avb = false;
    private int avc = 0;
    private boolean avd = false;
    private int anchorLevel = 0;
    public int avq = 0;
    public j avr = new j();
    private List<PbContent> avs = new ArrayList();
    private List<PbContent> avt = new ArrayList();
    private String category_name = null;
    private ba avg = new ba();
    private ArrayList<com.baidu.tbadk.data.c> avj = new ArrayList<>();
    private PushStatusData avk = new PushStatusData();
    public boolean avA = false;
    public int avB = -1;
    private long avJ = 0;
    private long avK = 0;
    private PostData avN = new PostData();
    private int avw = 0;
    public int avU = 0;
    private String tieba_game_information_source = "";
    public String avX = "";
    public String avW = "";

    static {
        auT.put(new Point(1, 1), Integer.valueOf(e.f.label_frs_lottery_ing));
        auT.put(new Point(1, 2), Integer.valueOf(e.f.label_frs_lottery_over));
        auT.put(new Point(1, 3), Integer.valueOf(e.f.label_frs_lottery_off));
        auT.put(new Point(1, 4), Integer.valueOf(e.f.label_frs_lottery_d));
        auT.put(new Point(2, 1), Integer.valueOf(e.f.label_frs_activity_shaiing));
        auT.put(new Point(2, 2), Integer.valueOf(e.f.label_frs_activity_shai_over));
        auT.put(new Point(2, 3), Integer.valueOf(e.f.label_frs_activity_shai_off));
        auT.put(new Point(2, 4), Integer.valueOf(e.f.label_frs_activity_shai_d));
        avD.put(new Point(1, 1), Integer.valueOf(e.j.lottery_status_ing));
        avD.put(new Point(1, 2), Integer.valueOf(e.j.lottery_status_over));
        avD.put(new Point(1, 3), Integer.valueOf(e.j.lottery_status_off));
        avD.put(new Point(1, 4), Integer.valueOf(e.j.lottery_status_not_start));
        avD.put(new Point(2, 1), Integer.valueOf(e.j.share_picture_status_ing));
        avD.put(new Point(2, 2), Integer.valueOf(e.j.share_picture_status_over));
        avD.put(new Point(2, 3), Integer.valueOf(e.j.share_picture_status_off));
        avD.put(new Point(2, 4), Integer.valueOf(e.j.share_picture_status_not_start));
        auU.put(1, Integer.valueOf(e.f.label_interview_no));
        auU.put(2, Integer.valueOf(e.f.label_interview_live));
        auU.put(3, Integer.valueOf(e.f.label_interview_off));
        avE.put(1, new o.a(e.j.interview_live_status_not_start, e.d.cp_other_b, e.f.pic_dot_title_red));
        avE.put(2, new o.a(e.j.interview_live_status_ing, e.d.cp_other_c, e.f.pic_dot_title_green));
        avE.put(3, new o.a(e.j.interview_live_status_over, e.d.cp_other_d, e.f.pic_dot_title_blue));
    }

    public bb() {
        this.auv = 0;
        this.auF = 0;
        this.auZ = 0L;
        this.mUrl = "";
        this.avl = "";
        this.avT = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.auZ = 0L;
        this.auF = 0;
        this.auv = 0;
        this.avT = 0;
        this.mUrl = "";
        this.avl = "";
        this.isBigGie = false;
    }

    public boolean zz() {
        return this.auv == 1;
    }

    public ba zA() {
        return this.avg;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void cM(int i) {
        this.anchorLevel = i;
    }

    public int zB() {
        return this.avw;
    }

    public void cN(int i) {
        this.avw = i;
    }

    public void cO(int i) {
        this.avc = i;
    }

    public int zC() {
        return this.avc;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo zD() {
        return this.awb;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long zE() {
        return this.auL;
    }

    public String zF() {
        return this.auB;
    }

    public PraiseData zG() {
        return this.auz;
    }

    public void a(PraiseData praiseData) {
        this.auz = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String zH() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void eu(String str) {
        this.atZ = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.atY = i;
    }

    public int zI() {
        return this.atY;
    }

    public String zJ() {
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
        this.avs = list;
    }

    public void E(List<PbContent> list) {
        this.avt = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void cP(int i) {
        this.reply_num = i;
    }

    public int zK() {
        return this.reply_num;
    }

    public int zL() {
        return this.auf;
    }

    public void cQ(int i) {
        this.auf = i;
    }

    public long zM() {
        return this.aug;
    }

    public void B(long j) {
        this.aug = j;
    }

    public int zN() {
        return this.aui;
    }

    public int zO() {
        return this.auh;
    }

    public void cR(int i) {
        this.auh = i;
    }

    public int zP() {
        return this.auj;
    }

    public void cS(int i) {
        this.auj = i;
    }

    public int zQ() {
        return this.auk;
    }

    public List<PbContent> zR() {
        return this.avs;
    }

    public bf zS() {
        return this.aul;
    }

    public MetaData zT() {
        return this.aum;
    }

    public boolean zU() {
        return this.is_god != 0;
    }

    public boolean zV() {
        return this.is_god == 1;
    }

    public boolean zW() {
        return (this.aum == null || this.aum.getGodUserData() == null || this.aum.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean zX() {
        return (this.aum == null || this.aum.getGodUserData() == null || this.aum.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean zY() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.aum = metaData;
    }

    public String zZ() {
        return this.forum_name;
    }

    public void ev(String str) {
        this.forum_name = str;
    }

    public int Aa() {
        return this.aup;
    }

    public String Ab() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aur;
    }

    public void ew(String str) {
        this.aur = str;
    }

    public String o(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.avt == null || this.avt.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.avt.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.avt.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.avs == null || (size = this.avs.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.avs.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString ex(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(o(str, true));
        if (this.avt != null && (size = this.avt.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.avt.get(i2);
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
                                bb.this.eB(pbContent.link);
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

    public int Ac() {
        return this.auw;
    }

    public void cT(int i) {
        this.auw = i;
    }

    public String Ad() {
        return this.aux;
    }

    public void ey(String str) {
        this.aux = str;
    }

    public ArrayList<MediaData> Ae() {
        return this.aus;
    }

    public ArrayList<a> Af() {
        return this.auP;
    }

    public void l(ArrayList<a> arrayList) {
        this.auP = arrayList;
    }

    public bk Ag() {
        return this.auQ;
    }

    public e Ah() {
        return this.auR;
    }

    public ArrayList<VoiceData.VoiceModel> Ai() {
        return this.aut;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int Aj() {
        return this.auC;
    }

    public void cU(int i) {
        this.auC = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String Ak() {
        return this.auN;
    }

    public VideoInfo Al() {
        return this.auH;
    }

    public VideoDesc Am() {
        return this.auI;
    }

    public void a(AlaInfoData alaInfoData) {
        this.auK = alaInfoData;
    }

    public AlaInfoData An() {
        return this.auK;
    }

    public PushStatusData Ao() {
        return this.avk;
    }

    public SkinInfo Ap() {
        return this.avm;
    }

    public long Aq() {
        return this.avx;
    }

    public boolean Ar() {
        return this.avy;
    }

    public String As() {
        return this.avz;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.auD = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.auv = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.auL = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aue = threadInfo.repost_num.intValue();
                this.auf = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aug = threadInfo.last_time_int.intValue();
                this.auh = threadInfo.is_top.intValue();
                this.aui = threadInfo.is_membertop.intValue();
                this.auj = threadInfo.is_good.intValue();
                this.auk = threadInfo.is_livepost.intValue();
                this.aul.a(threadInfo.topic);
                this.aum.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aun = threadInfo.fname;
                this.auo = threadInfo.has_commented.intValue();
                this.aup = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.auH = threadInfo.video_info;
                this.auI = threadInfo.video_segment;
                this.auK = new AlaInfoData();
                this.auK.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.auw = threadInfo.collect_status.intValue();
                this.aux = threadInfo.collect_mark_pid;
                this.auy = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.auB = threadInfo.first_post_id + "";
                this.auN = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.auC = threadInfo.is_ntitle.intValue();
                this.auE = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.avL = threadInfo.agree.has_agree.intValue();
                    this.avM = threadInfo.agree.agree_type.intValue();
                    this.avJ = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.avK = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.avO = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.auF = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.avu = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.avs = threadInfo.rich_title;
                this.avt = threadInfo.rich_abstract;
                this.auu = threadInfo.is_godthread_recommend.intValue();
                if ((this.aum == null || this.aum.getUserId() == null || this.aum.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aum = metaData;
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
                this.aur = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aus.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.auH = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.auJ = new bh();
                    this.auJ.a(threadInfo.video_channel_info);
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
                        this.aut.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.auP.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.auQ = new bk();
                    this.auQ.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.auR = new e();
                    this.auR.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.auS = new m();
                    this.auS.a(threadInfo.cartoon_info);
                }
                this.auz.setUserMap(this.userMap);
                this.auz.parserProtobuf(threadInfo.zan);
                this.auA.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.auz.setTitle(this.title);
                } else {
                    this.auz.setTitle(this.aur);
                }
                this.auV = threadInfo.livecover_src;
                this.auW = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.auO = threadInfo.post_num.intValue();
                this.auZ = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.ft(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.hw(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.auG.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.auX = noticeInfo.notice;
                    }
                    this.avc = zhiBoInfoTW.copythread_remind.intValue();
                    this.ava = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.avb = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.auV)) {
                        this.auV = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.avh = zhiBoInfoTW.user.tw_anchor_info;
                        this.avi = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.auY = threadInfo.twzhibo_info.livecover_status;
                    this.auZ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.avd = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.avg.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.avj.add(cVar);
                    }
                }
                this.avk.parserProtobuf(threadInfo.push_status);
                this.avp = threadInfo.lego_card;
                this.avm = threadInfo.skin_info;
                this.avq = threadInfo.is_book_chapter.intValue();
                this.avr.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.avz = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.avx = threadInfo.last_read_pid.longValue();
                this.avy = threadInfo.cheak_repeat.intValue() == 1;
                this.avC = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.avN.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.H(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.asE = sparseArray;
                }
                this.avI = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.avP = new ad();
                    this.avP.a(threadInfo.link_info);
                }
                this.avQ = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.avR = new d();
                    this.avR.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.avS = new MediaData();
                    this.avS.parserProtobuf(threadInfo.pic_info);
                }
                this.avw = threadInfo.is_called.intValue();
                this.avT = threadInfo.middle_page_num.intValue();
                this.avU = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.avW = threadInfo.star_rank_icon.icon_pic_url;
                    this.avX = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.avV = new OriginalThreadInfo();
                    this.avV.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.avV = new OriginalThreadInfo();
                    this.avV.parser(threadInfo.origin_thread_info);
                } else {
                    this.avV = null;
                }
                this.avY = threadInfo.is_topic.intValue();
                this.avZ = threadInfo.topic_user_name;
                this.awa = threadInfo.topic_h5_url;
                this.awc = threadInfo.presentation_style;
                this.awe = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.awg = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.aub = new ay();
                    this.aub.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.awi = threadInfo.swan_info;
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
                this.auL = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aue = jSONObject.optInt("repost_num", 0);
                this.auf = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.aug = jSONObject.optLong("last_time_int", 0L);
                this.auh = jSONObject.optInt("is_top", 0);
                this.aui = jSONObject.optInt("is_membertop", 0);
                this.auj = jSONObject.optInt("is_good", 0);
                this.auk = jSONObject.optInt("is_livepost", 0);
                this.aul.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aum.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aun = this.forum_name;
                this.auo = jSONObject.optInt("has_commented", 0);
                this.aup = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.auw = jSONObject.optInt("collect_status");
                this.aux = jSONObject.optString("collect_mark_pid");
                this.auy = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.avJ = jSONObject.optInt("agree_num");
                this.avO = jSONObject.optLong("share_num");
                this.auB = jSONObject.optString("first_post_id", "0");
                this.auN = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.auC = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.avL = optJSONObject2.optInt("has_agree");
                    this.avJ = optJSONObject2.optInt("agree_num");
                    this.avK = optJSONObject2.optLong("disagree_num");
                    this.avM = optJSONObject2.optInt("agree_type");
                    if (this.avJ < 0) {
                        this.avJ = 0L;
                    }
                    if (this.avK < 0) {
                        this.avK = 0L;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.avg.parserJson(optJSONObject3);
                }
                if ((this.aum == null || this.aum.getUserId() == null) && this.userMap != null) {
                    this.aum = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.auK = new AlaInfoData();
                this.auK.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aur = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aus.add(mediaData);
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
                        this.aut.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.auP.add(aVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.auQ = new bk();
                    this.auQ.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.auR = new e();
                    this.auR.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.auS = new m();
                    this.auS.parserJson(optJSONObject7);
                }
                this.auz.setUserMap(this.userMap);
                this.auz.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.auA.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.auz.setTitle(this.title);
                } else {
                    this.auz.setTitle(this.aur);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.avg.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.avj.add(cVar);
                    }
                }
                this.avq = jSONObject.optInt("is_book_chapter", 0);
                this.avr.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.avz = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.avx = jSONObject.optLong("last_read_pid");
                this.avy = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.auJ = new bh();
                    this.auJ.z(optJSONObject9);
                }
                this.avI = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.avP = new ad();
                    this.avP.parserJson(optJSONObject10);
                }
                this.avQ = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.avR = new d();
                    this.avR.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.avS = new MediaData();
                    this.avS.parserJson(optJSONObject12);
                }
                this.avw = jSONObject.optInt("is_called", 0);
                this.avT = jSONObject.optInt("middle_page_num", 0);
                this.avU = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.auH = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.avV = new OriginalThreadInfo();
                        this.avV.parserJson(optJSONObject14);
                    } else {
                        this.avV = null;
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
                    this.awi = builder2.build(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder At() {
        return this.auq;
    }

    public boolean Au() {
        return zO() != 0;
    }

    public int Av() {
        if (this.avg != null) {
            long zv = this.avg.zv();
            long zw = this.avg.zw();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < zv) {
                return 1;
            }
            if (currentTimeMillis > zw) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int Aw() {
        if (Ay() && this.auP.size() >= 1) {
            a aVar = this.auP.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int yl = aVar.yl();
            int ym = aVar.ym();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < yl) {
                return 4;
            }
            return currentTimeMillis > ym ? 2 : 1;
        }
        return -1;
    }

    public int Ax() {
        if (!Ay() || this.auP.size() < 1 || this.auP.get(0) == null) {
            return -1;
        }
        return this.auP.get(0).yk();
    }

    public boolean Ay() {
        return this.auE == 1;
    }

    public String getActUrl() {
        return (!Ay() || this.auP.size() < 1 || this.auP.get(0) == null) ? "" : this.auP.get(0).getUrl();
    }

    private com.baidu.adp.widget.b ez(String str) {
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

    public SmartApp Az() {
        return this.awi;
    }

    private void f(boolean z, boolean z2) {
        SpannableString spannableString;
        String o = o(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && AB()) {
                arrayList.add(Integer.valueOf(e.f.icon_convene));
            }
            if (zO() == 1) {
                arrayList.add(Integer.valueOf(e.f.icon_top));
            } else if (zO() == 2) {
                arrayList.add(Integer.valueOf(e.f.icon_notice));
            }
            if (zQ() == 1 || this.aul.BG() != 0) {
                if (zA() != null && getThreadType() == 41) {
                    if (Av() == 2) {
                        arrayList.add(Integer.valueOf(e.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(e.f.icon_zhibo));
                }
            }
            if (z && AL()) {
                Integer num = auU.get(Integer.valueOf(Av()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (zP() == 1 && !Au() && atL != getType() && atQ != getType()) {
                arrayList.add(Integer.valueOf(e.f.icon_elite));
            }
            if (this.auA != null && this.auA.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(e.f.icon_live_on));
            }
            if (Aa() == 1) {
                arrayList.add(Integer.valueOf(e.f.frs_post_ding));
            }
            Integer num2 = auT.get(new Point(Ax(), Aw()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (Ag() != null) {
                arrayList.add(Integer.valueOf(e.f.tag_act));
            }
            if (Ah() != null) {
                arrayList.add(Integer.valueOf(e.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = ez(this.category_name);
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
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aua));
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
            SpannableStringBuilder d = !z && zO() == 1 ? null : d(a.toString(), null);
            if (d == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) d);
            }
        }
        this.auq = spannableStringBuilder;
    }

    public boolean AA() {
        return false;
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
        if (zT() != null) {
            if (zT().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.he));
            } else if (zT().getGender() == 2) {
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
        if (AH() || !zU() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(e.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean AB() {
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
        this.auq = spannableStringBuilder;
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
            if (this.auC == 1) {
                this.auq = a;
                return a;
            }
        } else if (this.auC == 1) {
            this.auq = new SpannableStringBuilder();
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

    public void am(String str, String str2) {
        this.mUrl = str;
        this.avl = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a E;
        com.baidu.adp.widget.ImageView.a E2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.avl) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.NM().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.D(this.mUrl, 10)) && (E = com.baidu.tbadk.core.util.d.v.E(this.mUrl, 10)) != null) {
                bitmap = E.ot();
                com.baidu.tbadk.imageManager.c.NM().d(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.NM().getBitmap(this.avl);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.D(this.avl, 10)) && (E2 = com.baidu.tbadk.core.util.d.v.E(this.avl, 10)) != null) {
                bitmap2 = E2.ot();
                com.baidu.tbadk.imageManager.c.NM().d(this.avl, bitmap2);
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
                        oVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.aua));
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
                        com.baidu.tbadk.imageManager.c.NM().d(str2, aVar.ot());
                    }
                }
            }, atJ);
            com.baidu.adp.lib.f.c.jA().a(this.avl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.NM().d(str2, aVar.ot());
                    }
                }
            }, atJ);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.avs != null && this.avs.size() > 0) {
            int size = this.avs.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.avs.get(i2);
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
                                bb.this.eB(pbContent.link);
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

    private String eA(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData AC() {
        if (this.avs != null && this.avs.size() > 0) {
            int size = this.avs.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.avs.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && AH() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = eA(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.atY;
            kVar.aXZ = this.atZ;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void AD() {
        f(false, false);
    }

    public void AE() {
        f(false, true);
    }

    public AnchorInfoData AF() {
        return this.auA;
    }

    public boolean AG() {
        return this.threadType == 36;
    }

    public boolean AH() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> Ae = Ae();
        if (Ae == null || Au()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Ae.size() || i2 >= 3) {
                break;
            }
            if (Ae.get(i2) != null && Ae.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(Ae.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = Ae.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = Ae.get(i2).getPicUrl();
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
        if (this.auH != null && !StringUtils.isNull(this.auH.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.auH.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aum != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aum.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean AI() {
        String userId;
        return this.aum == null || (userId = this.aum.getUserId()) == null || userId.equals("0");
    }

    private boolean AJ() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (Bz()) {
            if (Al() != null) {
                return atL;
            }
            return atI;
        }
        int zO = zO();
        if (this.auH != null && Bq()) {
            return atX;
        }
        if (this.auK != null && this.threadType == 60) {
            return atO;
        }
        if (this.auK != null && this.threadType == 49) {
            return atM;
        }
        if (this.threadType == 51) {
            return atN;
        }
        if (zO == 2 || zO == 1) {
            return atH;
        }
        if (this.auH != null && AS() && !AJ()) {
            return atW;
        }
        if (this.auH != null && !AJ()) {
            if (zW()) {
                return atQ;
            }
            return atL;
        } else if (this.isShareThread) {
            return atP;
        } else {
            if (AK()) {
                return atT.get() ? avf : atI;
            } else if (Ay() && Ax() == 1) {
                return atT.get() ? avn : atI;
            } else if (isLinkThread()) {
                return atJ;
            } else {
                if (zW()) {
                    return atK;
                }
                if (this.avY == 1) {
                    return this.awb != null ? atS : atR;
                }
                return atI;
            }
        }
    }

    public boolean AK() {
        return zA() != null && getThreadType() == 41 && zQ() == 1 && Av() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.auC == 1) {
            this.ara = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.ara = 0;
        } else {
            this.ara = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.yu() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.yu().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.ara = next.yv();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean AL() {
        return this.threadType == 41;
    }

    public boolean AM() {
        return this.avo;
    }

    public void bb(boolean z) {
        this.avo = z;
    }

    public String AN() {
        return this.avp;
    }

    public m AO() {
        return this.auS;
    }

    public boolean AP() {
        return zQ() == 1 || zP() == 1 || zO() == 1 || Ay() || this.avq == 1 || zW() || Ah() != null || Ag() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || zV();
    }

    public void AQ() {
        if (this.auM == 0) {
            this.auM = 1;
        }
    }

    public boolean AR() {
        return this.avu;
    }

    public void bc(boolean z) {
        this.avA = z;
    }

    public boolean AS() {
        return this.avA;
    }

    public void cV(int i) {
        this.avB = i + 1;
    }

    public int AT() {
        return this.avB;
    }

    public List<ReportInfo> AU() {
        return this.avC;
    }

    public boolean AV() {
        return this.avv;
    }

    public void bd(boolean z) {
        this.avv = z;
    }

    public bh AW() {
        return this.auJ;
    }

    public void a(bh bhVar) {
        this.auJ = bhVar;
    }

    public void setCurrentPage(int i) {
        if (this.auJ != null) {
            this.auJ.mCurrentPage = i;
        }
    }

    public boolean AX() {
        return getThreadType() == 49;
    }

    public boolean AY() {
        return getThreadType() == 40;
    }

    public boolean AZ() {
        return getThreadType() == 50;
    }

    public boolean Ba() {
        return getThreadType() == 60;
    }

    public boolean Bb() {
        return getThreadType() == 40 && AW() != null && AW().channelId > 0;
    }

    public int Bc() {
        return this.avH;
    }

    public void setSmartFrsPosition(int i) {
        this.avH = i;
    }

    public SparseArray<String> yS() {
        return this.asE;
    }

    public void a(SparseArray<String> sparseArray) {
        this.asE = sparseArray;
    }

    public String Bd() {
        return this.mRecomSource;
    }

    public boolean Be() {
        return this.avI;
    }

    public long Bf() {
        return this.avJ;
    }

    public long Bg() {
        return this.avK;
    }

    public int Bh() {
        return this.avL;
    }

    public int Bi() {
        return this.avM;
    }

    public void cW(int i) {
        this.avL = i;
    }

    public void cX(int i) {
        this.avJ = i;
    }

    public void C(long j) {
        this.avJ = j;
    }

    public void D(long j) {
        this.avK = j;
    }

    public void cY(int i) {
        this.avM = i;
    }

    public long Bj() {
        return this.avO;
    }

    public void E(long j) {
        this.avO = j;
    }

    public PostData Bk() {
        return this.avN;
    }

    public ad Bl() {
        return this.avP;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String o;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.auC == 1) {
            o = o(this.aur, true);
            a = ex(this.aur);
        } else {
            o = o(this.title, false);
            a = a(new SpannableString(o + " "));
        }
        if (z) {
            spannableStringBuilder = a(o, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.auq = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        SpannableString ex;
        if (!StringUtils.isNull(this.title) && this.auC != 1) {
            ex = a(new SpannableString(o(this.title, false) + " "));
        } else {
            ex = ex(this.aur);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ex);
        this.auq = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString Bm() {
        if (this.auC == 1) {
            return null;
        }
        return ex(this.aur);
    }

    private ArrayList<o.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean zU = zU();
        if (z2) {
            if (z) {
                if (zU && !AH()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if (zQ() == 1 || getThreadType() == 33 || (zS() != null && zS().BG() != 0)) {
                    if (zA() != null && AL()) {
                        if (Av() == 2) {
                            arrayList.add(new o.a(e.j.interview_live));
                        }
                    } else if (!zU) {
                        arrayList.add(new o.a(e.j.photo_live_tips));
                    }
                }
                if (zO() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (zP() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (AL()) {
                    arrayList.add(avE.get(Av()));
                }
                if (Ay()) {
                    Integer num = avD.get(new Point(Ax(), Aw()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (Ag() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (zU && zO() != 1 && !AH()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if ((zQ() == 1 || getThreadType() == 33) && !AL() && !zU) {
                    arrayList.add(new o.a(e.j.photo_live_tips));
                }
                if (zP() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (zO() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (AL() && zA() != null && Av() == 2) {
                    arrayList.add(new o.a(e.j.interview_live));
                }
                if (Ay()) {
                    Integer num2 = avD.get(new Point(Ax(), Aw()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (this.avq == 1) {
                    arrayList.add(new o.a(e.j.card_tbread_text));
                }
                if (Ah() != null) {
                    arrayList.add(new o.a(e.j.send_app_code_gift, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (Ag() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && AX()) {
                    arrayList.add(new o.a(e.j.ala_live));
                }
                if (Bb()) {
                    arrayList.add(new o.a(e.j.frs_channel_tip));
                } else if (z3 && AZ()) {
                    arrayList.add(new o.a(e.j.live_record));
                } else if (AY()) {
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
        this.aus = arrayList;
    }

    public String Bn() {
        return this.avZ;
    }

    public void eC(String str) {
        this.avZ = str;
    }

    public void Bo() {
        this.avY = 1;
    }

    public boolean Bp() {
        return this.avY == 1;
    }

    public boolean Bq() {
        return this.awc.equals("worldcupvideo");
    }

    public String Br() {
        return this.auc;
    }

    public void eD(String str) {
        this.auc = str;
    }

    public String Bs() {
        return this.aud;
    }

    public void eE(String str) {
        this.aud = str;
    }

    public String Bt() {
        return this.awa;
    }

    public void eF(String str) {
        this.awa = str;
    }

    public boolean Bu() {
        return this.awd;
    }

    public void be(boolean z) {
        this.awd = z;
    }

    public void a(VideoInfo videoInfo) {
        this.awb = videoInfo;
    }

    public boolean Bv() {
        return this.awe != null;
    }

    public String Bw() {
        return this.aun;
    }

    public String Bx() {
        return this.awg;
    }

    public ay By() {
        return this.aub;
    }

    public boolean Bz() {
        return this.awh;
    }

    public void bf(boolean z) {
        this.awh = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.auH != null) {
            return this.auH.video_url;
        }
        return null;
    }
}

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
    private SpannableStringBuilder apB;
    public int apF;
    private int apG;
    private int apJ;
    private String apM;
    private int apN;
    private String apO;
    private int apQ;
    private VideoInfo apS;
    private VideoDesc apT;
    private bh apU;
    private AlaInfoData apV;
    private long apW;
    private ay apl;
    private String apm;
    private String apn;
    private String apy;
    private String aqA;
    private boolean aqF;
    private boolean aqG;
    public long aqI;
    public String aqK;
    private List<ReportInfo> aqN;
    private boolean aqT;
    private int aqW;
    private int aqX;
    private long aqZ;
    private m aqd;
    private LiveCoverStatus aqj;
    private long aqk;
    public TwZhiBoUser aqs;
    public List<TwAnchorProfitItem> aqt;
    private String aqw;
    private SkinInfo aqx;
    private boolean aqz;
    private ad ara;
    public d arc;
    private MediaData ard;
    public int are;
    public OriginalThreadInfo arg;
    private String ark;
    private String arl;
    private VideoInfo arm;
    private String arn;
    public OriginalForumInfo arp;
    public boolean arq;
    private String arr;
    private boolean ars;
    private SmartApp art;
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
    public static final BdUniqueId aoR = BdUniqueId.gen();
    public static final BdUniqueId aoS = BdUniqueId.gen();
    public static final BdUniqueId aoT = BdUniqueId.gen();
    public static final BdUniqueId aoU = BdUniqueId.gen();
    public static final BdUniqueId aoV = BdUniqueId.gen();
    public static final BdUniqueId aoW = BdUniqueId.gen();
    public static final BdUniqueId aoX = BdUniqueId.gen();
    public static final BdUniqueId aoY = BdUniqueId.gen();
    public static final BdUniqueId aoZ = BdUniqueId.gen();
    public static final BdUniqueId apa = BdUniqueId.gen();
    public static final BdUniqueId apb = BdUniqueId.gen();
    public static final BdUniqueId apc = BdUniqueId.gen();
    public static AtomicBoolean apd = new AtomicBoolean(false);
    public static AtomicBoolean ape = new AtomicBoolean(false);
    public static AtomicBoolean apf = new AtomicBoolean(false);
    public static final BdUniqueId apg = BdUniqueId.gen();
    public static final BdUniqueId aph = BdUniqueId.gen();
    private static HashMap<Point, Integer> aqe = new HashMap<>();
    private static HashMap<Integer, Integer> aqf = new HashMap<>();
    public static final BdUniqueId aqp = BdUniqueId.gen();
    public static final BdUniqueId aqq = BdUniqueId.gen();
    public static final BdUniqueId aqy = BdUniqueId.gen();
    private static HashMap<Point, Integer> aqO = new HashMap<>();
    private static SparseArray<o.a> aqP = new SparseArray<>(3);
    private int api = 0;
    private String apj = "1";
    public int apk = 1;
    private String apI = null;
    private int amk = 0;
    public int apX = 0;
    private String apY = "";
    private String aqg = "";
    public boolean aqJ = true;
    public boolean aqQ = false;
    public boolean aqR = false;
    private int aqS = -1;
    private SparseArray<String> anO = null;
    public boolean arb = false;
    private int arj = 0;
    private boolean aro = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int apo = 0;
    private int apq = 0;
    private String last_time = null;
    private long apr = 0;
    private int aps = 0;
    private int apt = 0;
    private int apu = 0;
    private int apv = 0;
    private bf apw = new bf();
    private MetaData apx = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> apD = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> apE = new ArrayList<>();
    private int apz = 0;
    private int apA = 0;
    private String ad_url = null;
    private String apC = null;
    private String from = null;
    private int apH = 0;
    private PraiseData apK = new PraiseData();
    private AnchorInfoData apL = new AnchorInfoData();
    private long time = 0;
    private int apP = 0;
    private ArrayList<a> aqa = new ArrayList<>();
    private bk aqb = null;
    private e aqc = null;
    private int aqh = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> apR = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aqi = null;
    private int apZ = 0;
    private boolean aql = false;
    private boolean aqm = false;
    private int aqn = 0;
    private boolean aqo = false;
    private int anchorLevel = 0;
    public int aqB = 0;
    public j aqC = new j();
    private List<PbContent> aqD = new ArrayList();
    private List<PbContent> aqE = new ArrayList();
    private String category_name = null;
    private ba aqr = new ba();
    private ArrayList<com.baidu.tbadk.data.c> aqu = new ArrayList<>();
    private PushStatusData aqv = new PushStatusData();
    public boolean aqL = false;
    public int aqM = -1;
    private long aqU = 0;
    private long aqV = 0;
    private PostData aqY = new PostData();
    private int aqH = 0;
    public int arf = 0;
    private String tieba_game_information_source = "";
    public String ari = "";
    public String arh = "";

    static {
        aqe.put(new Point(1, 1), Integer.valueOf(e.f.label_frs_lottery_ing));
        aqe.put(new Point(1, 2), Integer.valueOf(e.f.label_frs_lottery_over));
        aqe.put(new Point(1, 3), Integer.valueOf(e.f.label_frs_lottery_off));
        aqe.put(new Point(1, 4), Integer.valueOf(e.f.label_frs_lottery_d));
        aqe.put(new Point(2, 1), Integer.valueOf(e.f.label_frs_activity_shaiing));
        aqe.put(new Point(2, 2), Integer.valueOf(e.f.label_frs_activity_shai_over));
        aqe.put(new Point(2, 3), Integer.valueOf(e.f.label_frs_activity_shai_off));
        aqe.put(new Point(2, 4), Integer.valueOf(e.f.label_frs_activity_shai_d));
        aqO.put(new Point(1, 1), Integer.valueOf(e.j.lottery_status_ing));
        aqO.put(new Point(1, 2), Integer.valueOf(e.j.lottery_status_over));
        aqO.put(new Point(1, 3), Integer.valueOf(e.j.lottery_status_off));
        aqO.put(new Point(1, 4), Integer.valueOf(e.j.lottery_status_not_start));
        aqO.put(new Point(2, 1), Integer.valueOf(e.j.share_picture_status_ing));
        aqO.put(new Point(2, 2), Integer.valueOf(e.j.share_picture_status_over));
        aqO.put(new Point(2, 3), Integer.valueOf(e.j.share_picture_status_off));
        aqO.put(new Point(2, 4), Integer.valueOf(e.j.share_picture_status_not_start));
        aqf.put(1, Integer.valueOf(e.f.label_interview_no));
        aqf.put(2, Integer.valueOf(e.f.label_interview_live));
        aqf.put(3, Integer.valueOf(e.f.label_interview_off));
        aqP.put(1, new o.a(e.j.interview_live_status_not_start, e.d.cp_other_b, e.f.pic_dot_title_red));
        aqP.put(2, new o.a(e.j.interview_live_status_ing, e.d.cp_other_c, e.f.pic_dot_title_green));
        aqP.put(3, new o.a(e.j.interview_live_status_over, e.d.cp_other_d, e.f.pic_dot_title_blue));
    }

    public bb() {
        this.apG = 0;
        this.apQ = 0;
        this.aqk = 0L;
        this.mUrl = "";
        this.aqw = "";
        this.are = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.aqk = 0L;
        this.apQ = 0;
        this.apG = 0;
        this.are = 0;
        this.mUrl = "";
        this.aqw = "";
        this.isBigGie = false;
    }

    public boolean yb() {
        return this.apG == 1;
    }

    public ba yc() {
        return this.aqr;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void ck(int i) {
        this.anchorLevel = i;
    }

    public int yd() {
        return this.aqH;
    }

    public void cl(int i) {
        this.aqH = i;
    }

    public void cm(int i) {
        this.aqn = i;
    }

    public int ye() {
        return this.aqn;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo yf() {
        return this.arm;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long yg() {
        return this.apW;
    }

    public String yh() {
        return this.apM;
    }

    public PraiseData yi() {
        return this.apK;
    }

    public void a(PraiseData praiseData) {
        this.apK = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String yj() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void dT(String str) {
        this.apj = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.api = i;
    }

    public int yk() {
        return this.api;
    }

    public String yl() {
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

    public void E(List<PbContent> list) {
        this.aqD = list;
    }

    public void F(List<PbContent> list) {
        this.aqE = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void cn(int i) {
        this.reply_num = i;
    }

    public int ym() {
        return this.reply_num;
    }

    public int yn() {
        return this.apq;
    }

    public void co(int i) {
        this.apq = i;
    }

    public long yo() {
        return this.apr;
    }

    public void u(long j) {
        this.apr = j;
    }

    public int yp() {
        return this.apt;
    }

    public int yq() {
        return this.aps;
    }

    public void cp(int i) {
        this.aps = i;
    }

    public int yr() {
        return this.apu;
    }

    public void cq(int i) {
        this.apu = i;
    }

    public int ys() {
        return this.apv;
    }

    public List<PbContent> yt() {
        return this.aqD;
    }

    public bf yu() {
        return this.apw;
    }

    public MetaData yv() {
        return this.apx;
    }

    public boolean yw() {
        return this.is_god != 0;
    }

    public boolean yx() {
        return this.is_god == 1;
    }

    public boolean yy() {
        return (this.apx == null || this.apx.getGodUserData() == null || this.apx.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean yz() {
        return (this.apx == null || this.apx.getGodUserData() == null || this.apx.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean yA() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.apx = metaData;
    }

    public String yB() {
        return this.forum_name;
    }

    public void dU(String str) {
        this.forum_name = str;
    }

    public int yC() {
        return this.apA;
    }

    public String yD() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.apC;
    }

    public void dV(String str) {
        this.apC = str;
    }

    public String n(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.aqE == null || this.aqE.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.aqE.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.aqE.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.aqD == null || (size = this.aqD.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.aqD.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString dW(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(n(str, true));
        if (this.aqE != null && (size = this.aqE.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aqE.get(i2);
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
                                bb.this.ea(pbContent.link);
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

    public int yE() {
        return this.apH;
    }

    public void cr(int i) {
        this.apH = i;
    }

    public String yF() {
        return this.apI;
    }

    public void dX(String str) {
        this.apI = str;
    }

    public ArrayList<MediaData> yG() {
        return this.apD;
    }

    public ArrayList<a> yH() {
        return this.aqa;
    }

    public void l(ArrayList<a> arrayList) {
        this.aqa = arrayList;
    }

    public bk yI() {
        return this.aqb;
    }

    public e yJ() {
        return this.aqc;
    }

    public ArrayList<VoiceData.VoiceModel> yK() {
        return this.apE;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int yL() {
        return this.apN;
    }

    public void cs(int i) {
        this.apN = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String yM() {
        return this.apY;
    }

    public VideoInfo yN() {
        return this.apS;
    }

    public VideoDesc yO() {
        return this.apT;
    }

    public void a(AlaInfoData alaInfoData) {
        this.apV = alaInfoData;
    }

    public AlaInfoData yP() {
        return this.apV;
    }

    public PushStatusData yQ() {
        return this.aqv;
    }

    public SkinInfo yR() {
        return this.aqx;
    }

    public long yS() {
        return this.aqI;
    }

    public boolean yT() {
        return this.aqJ;
    }

    public String yU() {
        return this.aqK;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.apO = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.apG = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.apW = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.apo = threadInfo.repost_num.intValue();
                this.apq = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.apr = threadInfo.last_time_int.intValue();
                this.aps = threadInfo.is_top.intValue();
                this.apt = threadInfo.is_membertop.intValue();
                this.apu = threadInfo.is_good.intValue();
                this.apv = threadInfo.is_livepost.intValue();
                this.apw.a(threadInfo.topic);
                this.apx.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.apy = threadInfo.fname;
                this.apz = threadInfo.has_commented.intValue();
                this.apA = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.apS = threadInfo.video_info;
                this.apT = threadInfo.video_segment;
                this.apV = new AlaInfoData();
                this.apV.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.apH = threadInfo.collect_status.intValue();
                this.apI = threadInfo.collect_mark_pid;
                this.apJ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.apM = threadInfo.first_post_id + "";
                this.apY = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.apN = threadInfo.is_ntitle.intValue();
                this.apP = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.aqW = threadInfo.agree.has_agree.intValue();
                    this.aqX = threadInfo.agree.agree_type.intValue();
                    this.aqU = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.aqV = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.aqZ = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.apQ = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.aqF = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.aqD = threadInfo.rich_title;
                this.aqE = threadInfo.rich_abstract;
                this.apF = threadInfo.is_godthread_recommend.intValue();
                if ((this.apx == null || this.apx.getUserId() == null || this.apx.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.apx = metaData;
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
                this.apC = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.apD.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.apS = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.apU = new bh();
                    this.apU.a(threadInfo.video_channel_info);
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
                        this.apE.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aqa.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aqb = new bk();
                    this.aqb.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aqc = new e();
                    this.aqc.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aqd = new m();
                    this.aqd.a(threadInfo.cartoon_info);
                }
                this.apK.setUserMap(this.userMap);
                this.apK.parserProtobuf(threadInfo.zan);
                this.apL.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.apK.setTitle(this.title);
                } else {
                    this.apK.setTitle(this.apC);
                }
                this.aqg = threadInfo.livecover_src;
                this.aqh = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.apZ = threadInfo.post_num.intValue();
                this.aqk = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.eQ(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gO(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.apR.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aqi = noticeInfo.notice;
                    }
                    this.aqn = zhiBoInfoTW.copythread_remind.intValue();
                    this.aql = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aqm = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aqg)) {
                        this.aqg = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.aqs = zhiBoInfoTW.user.tw_anchor_info;
                        this.aqt = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aqj = threadInfo.twzhibo_info.livecover_status;
                    this.aqk = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.aqo = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.aqr.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.aqu.add(cVar);
                    }
                }
                this.aqv.parserProtobuf(threadInfo.push_status);
                this.aqA = threadInfo.lego_card;
                this.aqx = threadInfo.skin_info;
                this.aqB = threadInfo.is_book_chapter.intValue();
                this.aqC.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.aqK = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.aqI = threadInfo.last_read_pid.longValue();
                this.aqJ = threadInfo.cheak_repeat.intValue() == 1;
                this.aqN = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.aqY.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.I(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.anO = sparseArray;
                }
                this.aqT = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.ara = new ad();
                    this.ara.a(threadInfo.link_info);
                }
                this.arb = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.arc = new d();
                    this.arc.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.ard = new MediaData();
                    this.ard.parserProtobuf(threadInfo.pic_info);
                }
                this.aqH = threadInfo.is_called.intValue();
                this.are = threadInfo.middle_page_num.intValue();
                this.arf = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.arh = threadInfo.star_rank_icon.icon_pic_url;
                    this.ari = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.arg = new OriginalThreadInfo();
                    this.arg.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.arg = new OriginalThreadInfo();
                    this.arg.parser(threadInfo.origin_thread_info);
                } else {
                    this.arg = null;
                }
                this.arj = threadInfo.is_topic.intValue();
                this.ark = threadInfo.topic_user_name;
                this.arl = threadInfo.topic_h5_url;
                this.arn = threadInfo.presentation_style;
                this.arp = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.arr = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.apl = new ay();
                    this.apl.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.art = threadInfo.swan_info;
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
                this.apW = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.apo = jSONObject.optInt("repost_num", 0);
                this.apq = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.apr = jSONObject.optLong("last_time_int", 0L);
                this.aps = jSONObject.optInt("is_top", 0);
                this.apt = jSONObject.optInt("is_membertop", 0);
                this.apu = jSONObject.optInt("is_good", 0);
                this.apv = jSONObject.optInt("is_livepost", 0);
                this.apw.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.apx.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.apy = this.forum_name;
                this.apz = jSONObject.optInt("has_commented", 0);
                this.apA = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.apH = jSONObject.optInt("collect_status");
                this.apI = jSONObject.optString("collect_mark_pid");
                this.apJ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.aqU = jSONObject.optInt("agree_num");
                this.aqZ = jSONObject.optLong("share_num");
                this.apM = jSONObject.optString("first_post_id", "0");
                this.apY = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.apN = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.aqW = optJSONObject2.optInt("has_agree");
                    this.aqU = optJSONObject2.optInt("agree_num");
                    this.aqV = optJSONObject2.optLong("disagree_num");
                    this.aqX = optJSONObject2.optInt("agree_type");
                    if (this.aqU < 0) {
                        this.aqU = 0L;
                    }
                    if (this.aqV < 0) {
                        this.aqV = 0L;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.aqr.parserJson(optJSONObject3);
                }
                if ((this.apx == null || this.apx.getUserId() == null) && this.userMap != null) {
                    this.apx = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.apV = new AlaInfoData();
                this.apV.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.apC = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.apD.add(mediaData);
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
                        this.apE.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aqa.add(aVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.aqb = new bk();
                    this.aqb.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.aqc = new e();
                    this.aqc.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.aqd = new m();
                    this.aqd.parserJson(optJSONObject7);
                }
                this.apK.setUserMap(this.userMap);
                this.apK.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.apL.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.apK.setTitle(this.title);
                } else {
                    this.apK.setTitle(this.apC);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.aqr.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.aqu.add(cVar);
                    }
                }
                this.aqB = jSONObject.optInt("is_book_chapter", 0);
                this.aqC.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.aqK = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.aqI = jSONObject.optLong("last_read_pid");
                this.aqJ = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.apU = new bh();
                    this.apU.y(optJSONObject9);
                }
                this.aqT = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.ara = new ad();
                    this.ara.parserJson(optJSONObject10);
                }
                this.arb = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.arc = new d();
                    this.arc.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.ard = new MediaData();
                    this.ard.parserJson(optJSONObject12);
                }
                this.aqH = jSONObject.optInt("is_called", 0);
                this.are = jSONObject.optInt("middle_page_num", 0);
                this.arf = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.apS = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.arg = new OriginalThreadInfo();
                        this.arg.parserJson(optJSONObject14);
                    } else {
                        this.arg = null;
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
                    this.art = builder2.build(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder yV() {
        return this.apB;
    }

    public boolean yW() {
        return yq() != 0;
    }

    public int yX() {
        if (this.aqr != null) {
            long xX = this.aqr.xX();
            long xY = this.aqr.xY();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < xX) {
                return 1;
            }
            if (currentTimeMillis > xY) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int yY() {
        if (za() && this.aqa.size() >= 1) {
            a aVar = this.aqa.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int wM = aVar.wM();
            int wN = aVar.wN();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < wM) {
                return 4;
            }
            return currentTimeMillis > wN ? 2 : 1;
        }
        return -1;
    }

    public int yZ() {
        if (!za() || this.aqa.size() < 1 || this.aqa.get(0) == null) {
            return -1;
        }
        return this.aqa.get(0).wL();
    }

    public boolean za() {
        return this.apP == 1;
    }

    public String getActUrl() {
        return (!za() || this.aqa.size() < 1 || this.aqa.get(0) == null) ? "" : this.aqa.get(0).getUrl();
    }

    private com.baidu.adp.widget.b dY(String str) {
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

    public SmartApp zb() {
        return this.art;
    }

    private void f(boolean z, boolean z2) {
        SpannableString spannableString;
        String n = n(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && zd()) {
                arrayList.add(Integer.valueOf(e.f.icon_convene));
            }
            if (yq() == 1) {
                arrayList.add(Integer.valueOf(e.f.icon_top));
            } else if (yq() == 2) {
                arrayList.add(Integer.valueOf(e.f.icon_notice));
            }
            if (ys() == 1 || this.apw.Ai() != 0) {
                if (yc() != null && getThreadType() == 41) {
                    if (yX() == 2) {
                        arrayList.add(Integer.valueOf(e.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(e.f.icon_zhibo));
                }
            }
            if (z && zn()) {
                Integer num = aqf.get(Integer.valueOf(yX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (yr() == 1 && !yW() && aoV != getType() && apa != getType()) {
                arrayList.add(Integer.valueOf(e.f.icon_elite));
            }
            if (this.apL != null && this.apL.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(e.f.icon_live_on));
            }
            if (yC() == 1) {
                arrayList.add(Integer.valueOf(e.f.frs_post_ding));
            }
            Integer num2 = aqe.get(new Point(yZ(), yY()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (yI() != null) {
                arrayList.add(Integer.valueOf(e.f.tag_act));
            }
            if (yJ() != null) {
                arrayList.add(Integer.valueOf(e.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = dY(this.category_name);
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
                Bitmap dm = com.baidu.tbadk.core.util.al.dm(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dm);
                if (dm != null) {
                    bitmapDrawable.setBounds(0, 0, dm.getWidth(), dm.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.apk));
                spannableString.setSpan(mVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(n + " "));
        if (a != null) {
            SpannableStringBuilder d = !z && yq() == 1 ? null : d(a.toString(), null);
            if (d == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) d);
            }
        }
        this.apB = spannableStringBuilder;
    }

    public boolean zc() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || yN() == null || yN().video_type.intValue() == 0) {
            return i == 1 && yN() != null && (yN().video_type.intValue() == 1 || yN().video_type.intValue() == 12 || yN().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.ds8);
        Bitmap dm = com.baidu.tbadk.core.util.al.dm(e.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(dm);
        bitmapDrawable.setBounds(0, 0, dm.getWidth(), dm.getHeight());
        com.baidu.tbadk.core.view.n nVar = new com.baidu.tbadk.core.view.n(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (yv() != null) {
            if (yv().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.he));
            } else if (yv().getGender() == 2) {
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
        if (zj() || !yw() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(e.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zd() {
        return com.baidu.adp.lib.b.d.iR().aO("isConveneThreadOpen") == 1;
    }

    public void g(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.I(a(z, z2, z3, false)) > 0) {
            h(z, z3);
            return;
        }
        String n = n(this.title, false);
        SpannableString a = a(new SpannableString(n + " "));
        if (z) {
            spannableStringBuilder = a(n, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.apB = spannableStringBuilder;
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
            if (this.apN == 1) {
                this.apB = a2;
                return a2;
            }
        } else if (this.apN == 1) {
            this.apB = new SpannableStringBuilder();
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

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.aqw = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a C;
        com.baidu.adp.widget.ImageView.a C2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.aqw) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.Me().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.B(this.mUrl, 10)) && (C = com.baidu.tbadk.core.util.d.v.C(this.mUrl, 10)) != null) {
                bitmap = C.os();
                com.baidu.tbadk.imageManager.c.Me().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.Me().getBitmap(this.aqw);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.B(this.aqw, 10)) && (C2 = com.baidu.tbadk.core.util.d.v.C(this.aqw, 10)) != null) {
                bitmap2 = C2.os();
                com.baidu.tbadk.imageManager.c.Me().b(this.aqw, bitmap2);
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
                        oVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.apk));
                        spannableString.setSpan(oVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.jC().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Me().b(str2, aVar.os());
                    }
                }
            }, aoT);
            com.baidu.adp.lib.f.c.jC().a(this.aqw, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Me().b(str2, aVar.os());
                    }
                }
            }, aoT);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.aqD != null && this.aqD.size() > 0) {
            int size = this.aqD.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.aqD.get(i2);
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
                                bb.this.ea(pbContent.link);
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

    private String dZ(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData ze() {
        if (this.aqD != null && this.aqD.size() > 0) {
            int size = this.aqD.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.aqD.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && zj() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = dZ(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
            iVar.mLink = str;
            iVar.type = this.api;
            iVar.aSZ = this.apj;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
        }
    }

    public void zf() {
        f(false, false);
    }

    public void zg() {
        f(false, true);
    }

    public AnchorInfoData zh() {
        return this.apL;
    }

    public boolean zi() {
        return this.threadType == 36;
    }

    public boolean zj() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> yG = yG();
        if (yG == null || yW()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= yG.size() || i2 >= 3) {
                break;
            }
            if (yG.get(i2) != null && yG.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(yG.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = yG.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = yG.get(i2).getPicUrl();
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
        if (this.apS != null && !StringUtils.isNull(this.apS.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.apS.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.apx != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.apx.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean zk() {
        String userId;
        return this.apx == null || (userId = this.apx.getUserId()) == null || userId.equals("0");
    }

    private boolean zl() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (Ab()) {
            if (yN() != null) {
                return aoV;
            }
            return aoS;
        }
        int yq = yq();
        if (this.apS != null && zS()) {
            return aph;
        }
        if (this.apV != null && this.threadType == 60) {
            return aoY;
        }
        if (this.apV != null && this.threadType == 49) {
            return aoW;
        }
        if (this.threadType == 51) {
            return aoX;
        }
        if (yq == 2 || yq == 1) {
            return aoR;
        }
        if (this.apS != null && zu() && !zl()) {
            return apg;
        }
        if (this.apS != null && !zl()) {
            if (yy()) {
                return apa;
            }
            return aoV;
        } else if (this.isShareThread) {
            return aoZ;
        } else {
            if (zm()) {
                return apd.get() ? aqq : aoS;
            } else if (za() && yZ() == 1) {
                return apd.get() ? aqy : aoS;
            } else if (isLinkThread()) {
                return aoT;
            } else {
                if (yy()) {
                    return aoU;
                }
                if (this.arj == 1) {
                    return this.arm != null ? apc : apb;
                }
                return aoS;
            }
        }
    }

    public boolean zm() {
        return yc() != null && getThreadType() == 41 && ys() == 1 && yX() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.apN == 1) {
            this.amk = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.amk = 0;
        } else {
            this.amk = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.wV() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.wV().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.amk = next.wW();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean zn() {
        return this.threadType == 41;
    }

    public boolean zo() {
        return this.aqz;
    }

    public void aJ(boolean z) {
        this.aqz = z;
    }

    public String zp() {
        return this.aqA;
    }

    public m zq() {
        return this.aqd;
    }

    public boolean zr() {
        return ys() == 1 || yr() == 1 || yq() == 1 || za() || this.aqB == 1 || yy() || yJ() != null || yI() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || yx();
    }

    public void zs() {
        if (this.apX == 0) {
            this.apX = 1;
        }
    }

    public boolean zt() {
        return this.aqF;
    }

    public void aK(boolean z) {
        this.aqL = z;
    }

    public boolean zu() {
        return this.aqL;
    }

    public void ct(int i) {
        this.aqM = i + 1;
    }

    public int zv() {
        return this.aqM;
    }

    public List<ReportInfo> zw() {
        return this.aqN;
    }

    public boolean zx() {
        return this.aqG;
    }

    public void aL(boolean z) {
        this.aqG = z;
    }

    public bh zy() {
        return this.apU;
    }

    public void a(bh bhVar) {
        this.apU = bhVar;
    }

    public void setCurrentPage(int i) {
        if (this.apU != null) {
            this.apU.mCurrentPage = i;
        }
    }

    public boolean zz() {
        return getThreadType() == 49;
    }

    public boolean zA() {
        return getThreadType() == 40;
    }

    public boolean zB() {
        return getThreadType() == 50;
    }

    public boolean zC() {
        return getThreadType() == 60;
    }

    public boolean zD() {
        return getThreadType() == 40 && zy() != null && zy().channelId > 0;
    }

    public int zE() {
        return this.aqS;
    }

    public void setSmartFrsPosition(int i) {
        this.aqS = i;
    }

    public SparseArray<String> xt() {
        return this.anO;
    }

    public void a(SparseArray<String> sparseArray) {
        this.anO = sparseArray;
    }

    public String zF() {
        return this.mRecomSource;
    }

    public boolean zG() {
        return this.aqT;
    }

    public long zH() {
        return this.aqU;
    }

    public long zI() {
        return this.aqV;
    }

    public int zJ() {
        return this.aqW;
    }

    public int zK() {
        return this.aqX;
    }

    public void cu(int i) {
        this.aqW = i;
    }

    public void cv(int i) {
        this.aqU = i;
    }

    public void v(long j) {
        this.aqU = j;
    }

    public void w(long j) {
        this.aqV = j;
    }

    public void cw(int i) {
        this.aqX = i;
    }

    public long zL() {
        return this.aqZ;
    }

    public void x(long j) {
        this.aqZ = j;
    }

    public PostData zM() {
        return this.aqY;
    }

    public ad zN() {
        return this.ara;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String n;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.apN == 1) {
            n = n(this.apC, true);
            a = dW(this.apC);
        } else {
            n = n(this.title, false);
            a = a(new SpannableString(n + " "));
        }
        if (z) {
            spannableStringBuilder = a(n, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.apB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        SpannableString dW;
        if (!StringUtils.isNull(this.title) && this.apN != 1) {
            dW = a(new SpannableString(n(this.title, false) + " "));
        } else {
            dW = dW(this.apC);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dW);
        this.apB = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString zO() {
        if (this.apN == 1) {
            return null;
        }
        return dW(this.apC);
    }

    private ArrayList<o.a> a(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean yw = yw();
        if (z2) {
            if (z) {
                if (yw && !zj()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if (ys() == 1 || getThreadType() == 33 || (yu() != null && yu().Ai() != 0)) {
                    if (yc() != null && zn()) {
                        if (yX() == 2) {
                            arrayList.add(new o.a(e.j.interview_live));
                        }
                    } else if (!yw) {
                        arrayList.add(new o.a(e.j.photo_live_tips));
                    }
                }
                if (yq() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (yr() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (zn()) {
                    arrayList.add(aqP.get(yX()));
                }
                if (za()) {
                    Integer num = aqO.get(new Point(yZ(), yY()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (yI() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (yw && yq() != 1 && !zj()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if ((ys() == 1 || getThreadType() == 33) && !zn() && !yw) {
                    arrayList.add(new o.a(e.j.photo_live_tips));
                }
                if (yr() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (yq() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (zn() && yc() != null && yX() == 2) {
                    arrayList.add(new o.a(e.j.interview_live));
                }
                if (za()) {
                    Integer num2 = aqO.get(new Point(yZ(), yY()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (this.aqB == 1) {
                    arrayList.add(new o.a(e.j.card_tbread_text));
                }
                if (yJ() != null) {
                    arrayList.add(new o.a(e.j.send_app_code_gift, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (yI() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && zz()) {
                    arrayList.add(new o.a(e.j.ala_live));
                }
                if (zD()) {
                    arrayList.add(new o.a(e.j.frs_channel_tip));
                } else if (z3 && zB()) {
                    arrayList.add(new o.a(e.j.live_record));
                } else if (zA()) {
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
        this.apD = arrayList;
    }

    public String zP() {
        return this.ark;
    }

    public void eb(String str) {
        this.ark = str;
    }

    public void zQ() {
        this.arj = 1;
    }

    public boolean zR() {
        return this.arj == 1;
    }

    public boolean zS() {
        return this.arn.equals("worldcupvideo");
    }

    public String zT() {
        return this.apm;
    }

    public void ec(String str) {
        this.apm = str;
    }

    public String zU() {
        return this.apn;
    }

    public void ed(String str) {
        this.apn = str;
    }

    public String zV() {
        return this.arl;
    }

    public void ee(String str) {
        this.arl = str;
    }

    public boolean zW() {
        return this.aro;
    }

    public void aM(boolean z) {
        this.aro = z;
    }

    public void a(VideoInfo videoInfo) {
        this.arm = videoInfo;
    }

    public boolean zX() {
        return this.arp != null;
    }

    public String zY() {
        return this.apy;
    }

    public String zZ() {
        return this.arr;
    }

    public ay Aa() {
        return this.apl;
    }

    public boolean Ab() {
        return this.ars;
    }

    public void aN(boolean z) {
        this.ars = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.apS != null) {
            return this.apS.video_url;
        }
        return null;
    }
}

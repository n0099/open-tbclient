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
    private ay apZ;
    private int aqA;
    private String aqB;
    private int aqD;
    private VideoInfo aqF;
    private VideoDesc aqG;
    private bh aqH;
    private AlaInfoData aqI;
    private long aqJ;
    private m aqQ;
    private LiveCoverStatus aqW;
    private long aqX;
    private String aqa;
    private String aqb;
    private String aql;
    private SpannableStringBuilder aqo;
    public int aqs;
    private int aqt;
    private int aqw;
    private String aqz;
    private List<ReportInfo> arA;
    private boolean arG;
    private int arJ;
    private int arK;
    private long arM;
    private ad arN;
    public d arP;
    private MediaData arQ;
    public int arR;
    public OriginalThreadInfo arT;
    private String arX;
    private String arY;
    private VideoInfo arZ;
    public TwZhiBoUser arf;
    public List<TwAnchorProfitItem> arg;
    private String arj;
    private SkinInfo ark;
    private boolean arm;
    private String arn;
    private boolean ars;
    private boolean art;
    public long arv;
    public String arx;
    private String asa;
    public OriginalForumInfo asc;
    public boolean asd;
    private String ase;
    private boolean asf;
    private SmartApp asg;
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
    public static final BdUniqueId apF = BdUniqueId.gen();
    public static final BdUniqueId apG = BdUniqueId.gen();
    public static final BdUniqueId apH = BdUniqueId.gen();
    public static final BdUniqueId apI = BdUniqueId.gen();
    public static final BdUniqueId apJ = BdUniqueId.gen();
    public static final BdUniqueId apK = BdUniqueId.gen();
    public static final BdUniqueId apL = BdUniqueId.gen();
    public static final BdUniqueId apM = BdUniqueId.gen();
    public static final BdUniqueId apN = BdUniqueId.gen();
    public static final BdUniqueId apO = BdUniqueId.gen();
    public static final BdUniqueId apP = BdUniqueId.gen();
    public static final BdUniqueId apQ = BdUniqueId.gen();
    public static AtomicBoolean apR = new AtomicBoolean(false);
    public static AtomicBoolean apS = new AtomicBoolean(false);
    public static AtomicBoolean apT = new AtomicBoolean(false);
    public static final BdUniqueId apU = BdUniqueId.gen();
    public static final BdUniqueId apV = BdUniqueId.gen();
    private static HashMap<Point, Integer> aqR = new HashMap<>();
    private static HashMap<Integer, Integer> aqS = new HashMap<>();
    public static final BdUniqueId arc = BdUniqueId.gen();
    public static final BdUniqueId ard = BdUniqueId.gen();
    public static final BdUniqueId arl = BdUniqueId.gen();
    private static HashMap<Point, Integer> arB = new HashMap<>();
    private static SparseArray<o.a> arC = new SparseArray<>(3);
    private int apW = 0;
    private String apX = "1";
    public int apY = 1;
    private String aqv = null;
    private int amX = 0;
    public int aqK = 0;
    private String aqL = "";
    private String aqT = "";
    public boolean arw = true;
    public boolean arD = false;
    public boolean arE = false;
    private int arF = -1;
    private SparseArray<String> aoB = null;
    public boolean arO = false;
    private int arW = 0;
    private boolean asb = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int aqc = 0;
    private int aqd = 0;
    private String last_time = null;
    private long aqe = 0;
    private int aqf = 0;
    private int aqg = 0;
    private int aqh = 0;
    private int aqi = 0;
    private bf aqj = new bf();
    private MetaData aqk = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> aqq = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> aqr = new ArrayList<>();
    private int aqm = 0;
    private int aqn = 0;
    private String ad_url = null;
    private String aqp = null;
    private String from = null;
    private int aqu = 0;
    private PraiseData aqx = new PraiseData();
    private AnchorInfoData aqy = new AnchorInfoData();
    private long time = 0;
    private int aqC = 0;
    private ArrayList<a> aqN = new ArrayList<>();
    private bk aqO = null;
    private e aqP = null;
    private int aqU = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.b> aqE = new ArrayList<>();
    private boolean isHeadLive = false;
    private String aqV = null;
    private int aqM = 0;
    private boolean aqY = false;
    private boolean aqZ = false;
    private int ara = 0;
    private boolean arb = false;
    private int anchorLevel = 0;
    public int aro = 0;
    public j arp = new j();
    private List<PbContent> arq = new ArrayList();
    private List<PbContent> arr = new ArrayList();
    private String category_name = null;
    private ba are = new ba();
    private ArrayList<com.baidu.tbadk.data.c> arh = new ArrayList<>();
    private PushStatusData ari = new PushStatusData();
    public boolean ary = false;
    public int arz = -1;
    private long arH = 0;
    private long arI = 0;
    private PostData arL = new PostData();
    private int aru = 0;
    public int arS = 0;
    private String tieba_game_information_source = "";
    public String arV = "";
    public String arU = "";

    static {
        aqR.put(new Point(1, 1), Integer.valueOf(e.f.label_frs_lottery_ing));
        aqR.put(new Point(1, 2), Integer.valueOf(e.f.label_frs_lottery_over));
        aqR.put(new Point(1, 3), Integer.valueOf(e.f.label_frs_lottery_off));
        aqR.put(new Point(1, 4), Integer.valueOf(e.f.label_frs_lottery_d));
        aqR.put(new Point(2, 1), Integer.valueOf(e.f.label_frs_activity_shaiing));
        aqR.put(new Point(2, 2), Integer.valueOf(e.f.label_frs_activity_shai_over));
        aqR.put(new Point(2, 3), Integer.valueOf(e.f.label_frs_activity_shai_off));
        aqR.put(new Point(2, 4), Integer.valueOf(e.f.label_frs_activity_shai_d));
        arB.put(new Point(1, 1), Integer.valueOf(e.j.lottery_status_ing));
        arB.put(new Point(1, 2), Integer.valueOf(e.j.lottery_status_over));
        arB.put(new Point(1, 3), Integer.valueOf(e.j.lottery_status_off));
        arB.put(new Point(1, 4), Integer.valueOf(e.j.lottery_status_not_start));
        arB.put(new Point(2, 1), Integer.valueOf(e.j.share_picture_status_ing));
        arB.put(new Point(2, 2), Integer.valueOf(e.j.share_picture_status_over));
        arB.put(new Point(2, 3), Integer.valueOf(e.j.share_picture_status_off));
        arB.put(new Point(2, 4), Integer.valueOf(e.j.share_picture_status_not_start));
        aqS.put(1, Integer.valueOf(e.f.label_interview_no));
        aqS.put(2, Integer.valueOf(e.f.label_interview_live));
        aqS.put(3, Integer.valueOf(e.f.label_interview_off));
        arC.put(1, new o.a(e.j.interview_live_status_not_start, e.d.cp_other_b, e.f.pic_dot_title_red));
        arC.put(2, new o.a(e.j.interview_live_status_ing, e.d.cp_other_c, e.f.pic_dot_title_green));
        arC.put(3, new o.a(e.j.interview_live_status_over, e.d.cp_other_d, e.f.pic_dot_title_blue));
    }

    public bb() {
        this.aqt = 0;
        this.aqD = 0;
        this.aqX = 0L;
        this.mUrl = "";
        this.arj = "";
        this.arR = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.aqX = 0L;
        this.aqD = 0;
        this.aqt = 0;
        this.arR = 0;
        this.mUrl = "";
        this.arj = "";
        this.isBigGie = false;
    }

    public boolean yi() {
        return this.aqt == 1;
    }

    public ba yj() {
        return this.are;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void cy(int i) {
        this.anchorLevel = i;
    }

    public int yk() {
        return this.aru;
    }

    public void cz(int i) {
        this.aru = i;
    }

    public void cA(int i) {
        this.ara = i;
    }

    public int yl() {
        return this.ara;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo ym() {
        return this.arZ;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public long yn() {
        return this.aqJ;
    }

    public String yo() {
        return this.aqz;
    }

    public PraiseData yp() {
        return this.aqx;
    }

    public void a(PraiseData praiseData) {
        this.aqx = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String yq() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void dT(String str) {
        this.apX = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.apW = i;
    }

    public int yr() {
        return this.apW;
    }

    public String ys() {
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
        this.arq = list;
    }

    public void E(List<PbContent> list) {
        this.arr = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void cB(int i) {
        this.reply_num = i;
    }

    public int yt() {
        return this.reply_num;
    }

    public int yu() {
        return this.aqd;
    }

    public void cC(int i) {
        this.aqd = i;
    }

    public long yv() {
        return this.aqe;
    }

    public void w(long j) {
        this.aqe = j;
    }

    public int yw() {
        return this.aqg;
    }

    public int yx() {
        return this.aqf;
    }

    public void cD(int i) {
        this.aqf = i;
    }

    public int yy() {
        return this.aqh;
    }

    public void cE(int i) {
        this.aqh = i;
    }

    public int yz() {
        return this.aqi;
    }

    public List<PbContent> yA() {
        return this.arq;
    }

    public bf yB() {
        return this.aqj;
    }

    public MetaData yC() {
        return this.aqk;
    }

    public boolean yD() {
        return this.is_god != 0;
    }

    public boolean yE() {
        return this.is_god == 1;
    }

    public boolean yF() {
        return (this.aqk == null || this.aqk.getGodUserData() == null || this.aqk.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean yG() {
        return (this.aqk == null || this.aqk.getGodUserData() == null || this.aqk.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean yH() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.aqk = metaData;
    }

    public String yI() {
        return this.forum_name;
    }

    public void dU(String str) {
        this.forum_name = str;
    }

    public int yJ() {
        return this.aqn;
    }

    public String yK() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.aqp;
    }

    public void dV(String str) {
        this.aqp = str;
    }

    public String n(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.arr == null || this.arr.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.arr.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.arr.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.arq == null || (size = this.arq.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.arq.get(i2);
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
        if (this.arr != null && (size = this.arr.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.arr.get(i2);
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

    public int yL() {
        return this.aqu;
    }

    public void cF(int i) {
        this.aqu = i;
    }

    public String yM() {
        return this.aqv;
    }

    public void dX(String str) {
        this.aqv = str;
    }

    public ArrayList<MediaData> yN() {
        return this.aqq;
    }

    public ArrayList<a> yO() {
        return this.aqN;
    }

    public void l(ArrayList<a> arrayList) {
        this.aqN = arrayList;
    }

    public bk yP() {
        return this.aqO;
    }

    public e yQ() {
        return this.aqP;
    }

    public ArrayList<VoiceData.VoiceModel> yR() {
        return this.aqr;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int yS() {
        return this.aqA;
    }

    public void cG(int i) {
        this.aqA = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String yT() {
        return this.aqL;
    }

    public VideoInfo yU() {
        return this.aqF;
    }

    public VideoDesc yV() {
        return this.aqG;
    }

    public void a(AlaInfoData alaInfoData) {
        this.aqI = alaInfoData;
    }

    public AlaInfoData yW() {
        return this.aqI;
    }

    public PushStatusData yX() {
        return this.ari;
    }

    public SkinInfo yY() {
        return this.ark;
    }

    public long yZ() {
        return this.arv;
    }

    public boolean za() {
        return this.arw;
    }

    public String zb() {
        return this.arx;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.aqB = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.aqt = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.aqJ = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.aqc = threadInfo.repost_num.intValue();
                this.aqd = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.aqe = threadInfo.last_time_int.intValue();
                this.aqf = threadInfo.is_top.intValue();
                this.aqg = threadInfo.is_membertop.intValue();
                this.aqh = threadInfo.is_good.intValue();
                this.aqi = threadInfo.is_livepost.intValue();
                this.aqj.a(threadInfo.topic);
                this.aqk.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.aql = threadInfo.fname;
                this.aqm = threadInfo.has_commented.intValue();
                this.aqn = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.aqF = threadInfo.video_info;
                this.aqG = threadInfo.video_segment;
                this.aqI = new AlaInfoData();
                this.aqI.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.aqu = threadInfo.collect_status.intValue();
                this.aqv = threadInfo.collect_mark_pid;
                this.aqw = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.aqz = threadInfo.first_post_id + "";
                this.aqL = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.aqA = threadInfo.is_ntitle.intValue();
                this.aqC = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.arJ = threadInfo.agree.has_agree.intValue();
                    this.arK = threadInfo.agree.agree_type.intValue();
                    this.arH = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.arI = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.arM = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.aqD = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.ars = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.arq = threadInfo.rich_title;
                this.arr = threadInfo.rich_abstract;
                this.aqs = threadInfo.is_godthread_recommend.intValue();
                if ((this.aqk == null || this.aqk.getUserId() == null || this.aqk.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aqk = metaData;
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
                this.aqp = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.aqq.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.aqF = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.aqH = new bh();
                    this.aqH.a(threadInfo.video_channel_info);
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
                        this.aqr.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.aqN.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.aqO = new bk();
                    this.aqO.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.aqP = new e();
                    this.aqP.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.aqQ = new m();
                    this.aqQ.a(threadInfo.cartoon_info);
                }
                this.aqx.setUserMap(this.userMap);
                this.aqx.parserProtobuf(threadInfo.zan);
                this.aqy.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aqx.setTitle(this.title);
                } else {
                    this.aqx.setTitle(this.aqp);
                }
                this.aqT = threadInfo.livecover_src;
                this.aqU = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.aqM = threadInfo.post_num.intValue();
                this.aqX = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.b bVar = new com.baidu.tbadk.coreExtra.view.b();
                                bVar.fe(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                bVar.gP(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                bVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.aqE.add(bVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.aqV = noticeInfo.notice;
                    }
                    this.ara = zhiBoInfoTW.copythread_remind.intValue();
                    this.aqY = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.aqZ = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.aqT)) {
                        this.aqT = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.arf = zhiBoInfoTW.user.tw_anchor_info;
                        this.arg = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.aqW = threadInfo.twzhibo_info.livecover_status;
                    this.aqX = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.arb = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.are.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.arh.add(cVar);
                    }
                }
                this.ari.parserProtobuf(threadInfo.push_status);
                this.arn = threadInfo.lego_card;
                this.ark = threadInfo.skin_info;
                this.aro = threadInfo.is_book_chapter.intValue();
                this.arp.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.arx = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.arv = threadInfo.last_read_pid.longValue();
                this.arw = threadInfo.cheak_repeat.intValue() == 1;
                this.arA = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.arL.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.H(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.aoB = sparseArray;
                }
                this.arG = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.arN = new ad();
                    this.arN.a(threadInfo.link_info);
                }
                this.arO = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.arP = new d();
                    this.arP.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.arQ = new MediaData();
                    this.arQ.parserProtobuf(threadInfo.pic_info);
                }
                this.aru = threadInfo.is_called.intValue();
                this.arR = threadInfo.middle_page_num.intValue();
                this.arS = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.arU = threadInfo.star_rank_icon.icon_pic_url;
                    this.arV = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.arT = new OriginalThreadInfo();
                    this.arT.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.arT = new OriginalThreadInfo();
                    this.arT.parser(threadInfo.origin_thread_info);
                } else {
                    this.arT = null;
                }
                this.arW = threadInfo.is_topic.intValue();
                this.arX = threadInfo.topic_user_name;
                this.arY = threadInfo.topic_h5_url;
                this.asa = threadInfo.presentation_style;
                this.asc = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.ase = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.apZ = new ay();
                    this.apZ.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.asg = threadInfo.swan_info;
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
                this.aqJ = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.aqc = jSONObject.optInt("repost_num", 0);
                this.aqd = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.aqe = jSONObject.optLong("last_time_int", 0L);
                this.aqf = jSONObject.optInt("is_top", 0);
                this.aqg = jSONObject.optInt("is_membertop", 0);
                this.aqh = jSONObject.optInt("is_good", 0);
                this.aqi = jSONObject.optInt("is_livepost", 0);
                this.aqj.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.aqk.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.aql = this.forum_name;
                this.aqm = jSONObject.optInt("has_commented", 0);
                this.aqn = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.aqu = jSONObject.optInt("collect_status");
                this.aqv = jSONObject.optString("collect_mark_pid");
                this.aqw = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.arH = jSONObject.optInt("agree_num");
                this.arM = jSONObject.optLong("share_num");
                this.aqz = jSONObject.optString("first_post_id", "0");
                this.aqL = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.aqA = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.arJ = optJSONObject2.optInt("has_agree");
                    this.arH = optJSONObject2.optInt("agree_num");
                    this.arI = optJSONObject2.optLong("disagree_num");
                    this.arK = optJSONObject2.optInt("agree_type");
                    if (this.arH < 0) {
                        this.arH = 0L;
                    }
                    if (this.arI < 0) {
                        this.arI = 0L;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.are.parserJson(optJSONObject3);
                }
                if ((this.aqk == null || this.aqk.getUserId() == null) && this.userMap != null) {
                    this.aqk = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.aqI = new AlaInfoData();
                this.aqI.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.aqp = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.aqq.add(mediaData);
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
                        this.aqr.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.aqN.add(aVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.aqO = new bk();
                    this.aqO.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.aqP = new e();
                    this.aqP.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.aqQ = new m();
                    this.aqQ.parserJson(optJSONObject7);
                }
                this.aqx.setUserMap(this.userMap);
                this.aqx.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.aqy.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.aqx.setTitle(this.title);
                } else {
                    this.aqx.setTitle(this.aqp);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.are.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.arh.add(cVar);
                    }
                }
                this.aro = jSONObject.optInt("is_book_chapter", 0);
                this.arp.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.arx = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.arv = jSONObject.optLong("last_read_pid");
                this.arw = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.aqH = new bh();
                    this.aqH.y(optJSONObject9);
                }
                this.arG = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.arN = new ad();
                    this.arN.parserJson(optJSONObject10);
                }
                this.arO = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.arP = new d();
                    this.arP.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.arQ = new MediaData();
                    this.arQ.parserJson(optJSONObject12);
                }
                this.aru = jSONObject.optInt("is_called", 0);
                this.arR = jSONObject.optInt("middle_page_num", 0);
                this.arS = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.aqF = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.arT = new OriginalThreadInfo();
                        this.arT.parserJson(optJSONObject14);
                    } else {
                        this.arT = null;
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
                    this.asg = builder2.build(false);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder zc() {
        return this.aqo;
    }

    public boolean zd() {
        return yx() != 0;
    }

    public int ze() {
        if (this.are != null) {
            long ye = this.are.ye();
            long yf = this.are.yf();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ye) {
                return 1;
            }
            if (currentTimeMillis > yf) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int zf() {
        if (zh() && this.aqN.size() >= 1) {
            a aVar = this.aqN.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int wU = aVar.wU();
            int wV = aVar.wV();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < wU) {
                return 4;
            }
            return currentTimeMillis > wV ? 2 : 1;
        }
        return -1;
    }

    public int zg() {
        if (!zh() || this.aqN.size() < 1 || this.aqN.get(0) == null) {
            return -1;
        }
        return this.aqN.get(0).wT();
    }

    public boolean zh() {
        return this.aqC == 1;
    }

    public String getActUrl() {
        return (!zh() || this.aqN.size() < 1 || this.aqN.get(0) == null) ? "" : this.aqN.get(0).getUrl();
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

    public SmartApp zi() {
        return this.asg;
    }

    private void f(boolean z, boolean z2) {
        SpannableString spannableString;
        String n = n(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && zk()) {
                arrayList.add(Integer.valueOf(e.f.icon_convene));
            }
            if (yx() == 1) {
                arrayList.add(Integer.valueOf(e.f.icon_top));
            } else if (yx() == 2) {
                arrayList.add(Integer.valueOf(e.f.icon_notice));
            }
            if (yz() == 1 || this.aqj.Ap() != 0) {
                if (yj() != null && getThreadType() == 41) {
                    if (ze() == 2) {
                        arrayList.add(Integer.valueOf(e.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(e.f.icon_zhibo));
                }
            }
            if (z && zu()) {
                Integer num = aqS.get(Integer.valueOf(ze()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (yy() == 1 && !zd() && apJ != getType() && apO != getType()) {
                arrayList.add(Integer.valueOf(e.f.icon_elite));
            }
            if (this.aqy != null && this.aqy.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(e.f.icon_live_on));
            }
            if (yJ() == 1) {
                arrayList.add(Integer.valueOf(e.f.frs_post_ding));
            }
            Integer num2 = aqR.get(new Point(zg(), zf()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (yP() != null) {
                arrayList.add(Integer.valueOf(e.f.tag_act));
            }
            if (yQ() != null) {
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
                Bitmap dA = com.baidu.tbadk.core.util.al.dA(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(dA);
                if (dA != null) {
                    bitmapDrawable.setBounds(0, 0, dA.getWidth(), dA.getHeight());
                }
                com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.apY));
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
            SpannableStringBuilder d = !z && yx() == 1 ? null : d(a.toString(), null);
            if (d == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) d);
            }
        }
        this.aqo = spannableStringBuilder;
    }

    public boolean zj() {
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("nani_key_show_tail_video_type", -1);
        if (i != 0 || yU() == null || yU().video_type.intValue() == 0) {
            return i == 1 && yU() != null && (yU().video_type.intValue() == 1 || yU().video_type.intValue() == 12 || yU().video_type.intValue() == 13);
        }
        return true;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.ds8);
        Bitmap dA = com.baidu.tbadk.core.util.al.dA(e.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(dA);
        bitmapDrawable.setBounds(0, 0, dA.getWidth(), dA.getHeight());
        com.baidu.tbadk.core.view.n nVar = new com.baidu.tbadk.core.view.n(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (yC() != null) {
            if (yC().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(e.j.he));
            } else if (yC().getGender() == 2) {
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
        if (zq() || !yD() || com.baidu.adp.lib.util.k.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new o.a(e.j.god_title));
        }
        return com.baidu.tieba.card.o.a((Context) TbadkCoreApplication.getInst(), str, arrayList, true);
    }

    private boolean zk() {
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
        String n = n(this.title, false);
        SpannableString a = a(new SpannableString(n + " "));
        if (z) {
            spannableStringBuilder = a(n, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aqo = spannableStringBuilder;
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
            if (this.aqA == 1) {
                this.aqo = a;
                return a;
            }
        } else if (this.aqA == 1) {
            this.aqo = new SpannableStringBuilder();
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

    public void ai(String str, String str2) {
        this.mUrl = str;
        this.arj = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a C;
        com.baidu.adp.widget.ImageView.a C2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.arj) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.Mq().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.B(this.mUrl, 10)) && (C = com.baidu.tbadk.core.util.d.v.C(this.mUrl, 10)) != null) {
                bitmap = C.oq();
                com.baidu.tbadk.imageManager.c.Mq().b(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.Mq().getBitmap(this.arj);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.B(this.arj, 10)) && (C2 = com.baidu.tbadk.core.util.d.v.C(this.arj, 10)) != null) {
                bitmap2 = C2.oq();
                com.baidu.tbadk.imageManager.c.Mq().b(this.arj, bitmap2);
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
                        oVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.apY));
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
                        com.baidu.tbadk.imageManager.c.Mq().b(str2, aVar.oq());
                    }
                }
            }, apH);
            com.baidu.adp.lib.f.c.jA().a(this.arj, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bb.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.Mq().b(str2, aVar.oq());
                    }
                }
            }, apH);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.arq != null && this.arq.size() > 0) {
            int size = this.arq.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.arq.get(i2);
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

    public ActivityItemData zl() {
        if (this.arq != null && this.arq.size() > 0) {
            int size = this.arq.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.arq.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && zq() && pbContent.text != null && pbContent.text.length() >= 3) {
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
            iVar.type = this.apW;
            iVar.aTP = this.apX;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
        }
    }

    public void zm() {
        f(false, false);
    }

    public void zn() {
        f(false, true);
    }

    public AnchorInfoData zo() {
        return this.aqy;
    }

    public boolean zp() {
        return this.threadType == 36;
    }

    public boolean zq() {
        return this.threadType == 40 || this.threadType == 50;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> yN = yN();
        if (yN == null || zd()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= yN.size() || i2 >= 3) {
                break;
            }
            if (yN.get(i2) != null && yN.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(yN.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = yN.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = yN.get(i2).getPicUrl();
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
        if (this.aqF != null && !StringUtils.isNull(this.aqF.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.aqF.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.aqk != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.aqk.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean zr() {
        String userId;
        return this.aqk == null || (userId = this.aqk.getUserId()) == null || userId.equals("0");
    }

    private boolean zs() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (Ai()) {
            if (yU() != null) {
                return apJ;
            }
            return apG;
        }
        int yx = yx();
        if (this.aqF != null && zZ()) {
            return apV;
        }
        if (this.aqI != null && this.threadType == 60) {
            return apM;
        }
        if (this.aqI != null && this.threadType == 49) {
            return apK;
        }
        if (this.threadType == 51) {
            return apL;
        }
        if (yx == 2 || yx == 1) {
            return apF;
        }
        if (this.aqF != null && zB() && !zs()) {
            return apU;
        }
        if (this.aqF != null && !zs()) {
            if (yF()) {
                return apO;
            }
            return apJ;
        } else if (this.isShareThread) {
            return apN;
        } else {
            if (zt()) {
                return apR.get() ? ard : apG;
            } else if (zh() && zg() == 1) {
                return apR.get() ? arl : apG;
            } else if (isLinkThread()) {
                return apH;
            } else {
                if (yF()) {
                    return apI;
                }
                if (this.arW == 1) {
                    return this.arZ != null ? apQ : apP;
                }
                return apG;
            }
        }
    }

    public boolean zt() {
        return yj() != null && getThreadType() == 41 && yz() == 1 && ze() == 2;
    }

    public void m(ArrayList<n> arrayList) {
        if (this.aqA == 1) {
            this.amX = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.amX = 0;
        } else {
            this.amX = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.xd() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.xd().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.amX = next.xe();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean zu() {
        return this.threadType == 41;
    }

    public boolean zv() {
        return this.arm;
    }

    public void aZ(boolean z) {
        this.arm = z;
    }

    public String zw() {
        return this.arn;
    }

    public m zx() {
        return this.aqQ;
    }

    public boolean zy() {
        return yz() == 1 || yy() == 1 || yx() == 1 || zh() || this.aro == 1 || yF() || yQ() != null || yP() != null || !com.baidu.adp.lib.util.k.isEmpty(getCategory()) || yE();
    }

    public void zz() {
        if (this.aqK == 0) {
            this.aqK = 1;
        }
    }

    public boolean zA() {
        return this.ars;
    }

    public void ba(boolean z) {
        this.ary = z;
    }

    public boolean zB() {
        return this.ary;
    }

    public void cH(int i) {
        this.arz = i + 1;
    }

    public int zC() {
        return this.arz;
    }

    public List<ReportInfo> zD() {
        return this.arA;
    }

    public boolean zE() {
        return this.art;
    }

    public void bb(boolean z) {
        this.art = z;
    }

    public bh zF() {
        return this.aqH;
    }

    public void a(bh bhVar) {
        this.aqH = bhVar;
    }

    public void setCurrentPage(int i) {
        if (this.aqH != null) {
            this.aqH.mCurrentPage = i;
        }
    }

    public boolean zG() {
        return getThreadType() == 49;
    }

    public boolean zH() {
        return getThreadType() == 40;
    }

    public boolean zI() {
        return getThreadType() == 50;
    }

    public boolean zJ() {
        return getThreadType() == 60;
    }

    public boolean zK() {
        return getThreadType() == 40 && zF() != null && zF().channelId > 0;
    }

    public int zL() {
        return this.arF;
    }

    public void setSmartFrsPosition(int i) {
        this.arF = i;
    }

    public SparseArray<String> xB() {
        return this.aoB;
    }

    public void a(SparseArray<String> sparseArray) {
        this.aoB = sparseArray;
    }

    public String zM() {
        return this.mRecomSource;
    }

    public boolean zN() {
        return this.arG;
    }

    public long zO() {
        return this.arH;
    }

    public long zP() {
        return this.arI;
    }

    public int zQ() {
        return this.arJ;
    }

    public int zR() {
        return this.arK;
    }

    public void cI(int i) {
        this.arJ = i;
    }

    public void cJ(int i) {
        this.arH = i;
    }

    public void x(long j) {
        this.arH = j;
    }

    public void y(long j) {
        this.arI = j;
    }

    public void cK(int i) {
        this.arK = i;
    }

    public long zS() {
        return this.arM;
    }

    public void z(long j) {
        this.arM = j;
    }

    public PostData zT() {
        return this.arL;
    }

    public ad zU() {
        return this.arN;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String n;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.aqA == 1) {
            n = n(this.aqp, true);
            a = dW(this.aqp);
        } else {
            n = n(this.title, false);
            a = a(new SpannableString(n + " "));
        }
        if (z) {
            spannableStringBuilder = a(n, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.aqo = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder i(boolean z, boolean z2) {
        SpannableString dW;
        if (!StringUtils.isNull(this.title) && this.aqA != 1) {
            dW = a(new SpannableString(n(this.title, false) + " "));
        } else {
            dW = dW(this.aqp);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dW);
        this.aqo = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString zV() {
        if (this.aqA == 1) {
            return null;
        }
        return dW(this.aqp);
    }

    private ArrayList<o.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<o.a> arrayList = new ArrayList<>();
        boolean yD = yD();
        if (z2) {
            if (z) {
                if (yD && !zq()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if (yz() == 1 || getThreadType() == 33 || (yB() != null && yB().Ap() != 0)) {
                    if (yj() != null && zu()) {
                        if (ze() == 2) {
                            arrayList.add(new o.a(e.j.interview_live));
                        }
                    } else if (!yD) {
                        arrayList.add(new o.a(e.j.photo_live_tips));
                    }
                }
                if (yx() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (yy() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (zu()) {
                    arrayList.add(arC.get(ze()));
                }
                if (zh()) {
                    Integer num = arB.get(new Point(zg(), zf()));
                    if (num != null) {
                        arrayList.add(new o.a(num.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (yP() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
            } else {
                if (yD && yx() != 1 && !zq()) {
                    arrayList.add(new o.a(e.j.god_title));
                }
                if ((yz() == 1 || getThreadType() == 33) && !zu() && !yD) {
                    arrayList.add(new o.a(e.j.photo_live_tips));
                }
                if (yy() == 1) {
                    arrayList.add(new o.a(e.j.good));
                }
                if (yx() == 1) {
                    arrayList.add(new o.a(e.j.top));
                }
                if (zu() && yj() != null && ze() == 2) {
                    arrayList.add(new o.a(e.j.interview_live));
                }
                if (zh()) {
                    Integer num2 = arB.get(new Point(zg(), zf()));
                    if (num2 != null) {
                        arrayList.add(new o.a(num2.intValue(), e.d.cp_other_b, e.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new o.a(e.j.card_promotion_text));
                    }
                }
                if (this.aro == 1) {
                    arrayList.add(new o.a(e.j.card_tbread_text));
                }
                if (yQ() != null) {
                    arrayList.add(new o.a(e.j.send_app_code_gift, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (yP() != null) {
                    arrayList.add(new o.a(e.j.card_promotion_text, e.d.cp_other_b, e.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ao.isEmpty(getCategory())) {
                    arrayList.add(new o.a(getCategory()));
                }
                if (z3 && zG()) {
                    arrayList.add(new o.a(e.j.ala_live));
                }
                if (zK()) {
                    arrayList.add(new o.a(e.j.frs_channel_tip));
                } else if (z3 && zI()) {
                    arrayList.add(new o.a(e.j.live_record));
                } else if (zH()) {
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
        this.aqq = arrayList;
    }

    public String zW() {
        return this.arX;
    }

    public void eb(String str) {
        this.arX = str;
    }

    public void zX() {
        this.arW = 1;
    }

    public boolean zY() {
        return this.arW == 1;
    }

    public boolean zZ() {
        return this.asa.equals("worldcupvideo");
    }

    public String Aa() {
        return this.aqa;
    }

    public void ec(String str) {
        this.aqa = str;
    }

    public String Ab() {
        return this.aqb;
    }

    public void ed(String str) {
        this.aqb = str;
    }

    public String Ac() {
        return this.arY;
    }

    public void ee(String str) {
        this.arY = str;
    }

    public boolean Ad() {
        return this.asb;
    }

    public void bc(boolean z) {
        this.asb = z;
    }

    public void a(VideoInfo videoInfo) {
        this.arZ = videoInfo;
    }

    public boolean Ae() {
        return this.asc != null;
    }

    public String Af() {
        return this.aql;
    }

    public String Ag() {
        return this.ase;
    }

    public ay Ah() {
        return this.apZ;
    }

    public boolean Ai() {
        return this.asf;
    }

    public void bd(boolean z) {
        this.asf = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.aqF != null) {
            return this.aqF.video_url;
        }
        return null;
    }
}

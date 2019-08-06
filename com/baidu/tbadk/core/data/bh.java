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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
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
public class bh extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.e.a {
    private String address;
    private String authorId;
    private bd bJV;
    private String bJW;
    private String bJX;
    private VideoInfo bKB;
    private VideoDesc bKC;
    private bn bKD;
    private AlaInfoData bKE;
    private long bKF;
    private o bKN;
    private LiveCoverStatus bKT;
    private long bKU;
    private String bKh;
    private SpannableStringBuilder bKk;
    public int bKo;
    private int bKp;
    private int bKs;
    private String bKv;
    private int bKw;
    private String bKx;
    private int bKz;
    private List<ReportInfo> bLC;
    private boolean bLI;
    private int bLL;
    private int bLM;
    private long bLO;
    private af bLP;
    public f bLR;
    private MediaData bLS;
    public int bLT;
    public OriginalThreadInfo bLV;
    private TopicModule bLZ;
    public TwZhiBoUser bLc;
    public List<TwAnchorProfitItem> bLd;
    private String bLg;
    private SkinInfo bLh;
    private boolean bLj;
    private String bLk;
    private boolean bLq;
    private boolean bLr;
    public String bLt;
    public int bLu;
    public int bLv;
    public String bLw;
    public long bLx;
    public String bLz;
    private String bMa;
    private String bMb;
    private VideoInfo bMc;
    private String bMd;
    public OriginalForumInfo bMf;
    public boolean bMg;
    private String bMh;
    private boolean bMi;
    private SmartApp bMj;
    private String bMl;
    private String bMm;
    private String bMn;
    private SpannableStringBuilder bMo;
    private SpannableString bMp;
    private String bMq;
    private String bMr;
    public int bMs;
    public boolean bMt;
    public String bMu;
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
    public static final BdUniqueId bJn = BdUniqueId.gen();
    public static final BdUniqueId bJo = BdUniqueId.gen();
    public static final BdUniqueId bJp = BdUniqueId.gen();
    public static final BdUniqueId bJq = BdUniqueId.gen();
    public static final BdUniqueId bJr = BdUniqueId.gen();
    public static final BdUniqueId bJs = BdUniqueId.gen();
    public static final BdUniqueId bJt = BdUniqueId.gen();
    public static final BdUniqueId bJu = BdUniqueId.gen();
    public static final BdUniqueId bJv = BdUniqueId.gen();
    public static final BdUniqueId bJw = BdUniqueId.gen();
    public static final BdUniqueId bJx = BdUniqueId.gen();
    public static final BdUniqueId bJy = BdUniqueId.gen();
    public static final BdUniqueId bJz = BdUniqueId.gen();
    public static final BdUniqueId bJA = BdUniqueId.gen();
    public static final BdUniqueId bJB = BdUniqueId.gen();
    public static final BdUniqueId bJC = BdUniqueId.gen();
    public static final BdUniqueId bJD = BdUniqueId.gen();
    public static final BdUniqueId bJE = BdUniqueId.gen();
    public static final BdUniqueId bJF = BdUniqueId.gen();
    public static final BdUniqueId bJG = BdUniqueId.gen();
    public static final BdUniqueId bJH = BdUniqueId.gen();
    public static final BdUniqueId bJI = BdUniqueId.gen();
    public static final BdUniqueId bJJ = BdUniqueId.gen();
    public static final BdUniqueId bJK = BdUniqueId.gen();
    public static final BdUniqueId bJL = BdUniqueId.gen();
    public static final BdUniqueId bJM = BdUniqueId.gen();
    public static AtomicBoolean bJN = new AtomicBoolean(false);
    public static AtomicBoolean bJO = new AtomicBoolean(false);
    public static AtomicBoolean bJP = new AtomicBoolean(false);
    public static final BdUniqueId bJQ = BdUniqueId.gen();
    public static final BdUniqueId bJR = BdUniqueId.gen();
    private static HashMap<Point, Integer> bKO = new HashMap<>();
    private static HashMap<Integer, Integer> bKP = new HashMap<>();
    public static final BdUniqueId bKZ = BdUniqueId.gen();
    public static final BdUniqueId bLa = BdUniqueId.gen();
    public static final BdUniqueId bLi = BdUniqueId.gen();
    private static HashMap<Point, Integer> bLD = new HashMap<>();
    private static SparseArray<n.a> bLE = new SparseArray<>(3);
    public boolean bJb = false;
    public boolean bJc = false;
    public boolean bJd = false;
    public boolean bJe = false;
    public boolean bJf = false;
    public boolean bJg = false;
    public boolean bJh = false;
    private int bJS = 0;
    private String bJT = "1";
    public int bJU = 1;
    private String bKr = null;
    private int bGj = 0;
    public int bKG = 0;
    private String bKH = "";
    public boolean bKI = false;
    private String bKQ = "";
    public boolean bLy = true;
    public boolean bLF = false;
    public boolean bLG = false;
    private int bLH = -1;
    public SparseArray<String> bHM = null;
    public boolean bLQ = false;
    private int bLY = 0;
    private boolean bMe = false;
    private boolean bMk = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bJY = 0;
    private int bJZ = 0;
    private String last_time = null;
    private long bKa = 0;
    private int bKb = 0;
    private int bKc = 0;
    private int bKd = 0;
    private int bKe = 0;
    private bl bKf = new bl();
    private MetaData bKg = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bKm = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bKn = new ArrayList<>();
    private int bKi = 0;
    private int bKj = 0;
    private String ad_url = null;
    private String bKl = null;
    private String from = null;
    private int bKq = 0;
    private PraiseData bKt = new PraiseData();
    private AnchorInfoData bKu = new AnchorInfoData();
    private long time = 0;
    private int bKy = 0;
    private ArrayList<b> bKK = new ArrayList<>();
    private bq bKL = null;
    private g bKM = null;
    private int bKR = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bKA = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bKS = null;
    private int bKJ = 0;
    private boolean bKV = false;
    private boolean bKW = false;
    private int bKX = 0;
    private boolean bKY = false;
    private int anchorLevel = 0;
    public int bLl = 0;
    public l bLm = new l();
    private List<PbContent> bLn = new ArrayList();
    private List<PbContent> bLo = new ArrayList();
    private List<PbContent> bLp = new ArrayList();
    private String category_name = null;
    private bf bLb = new bf();
    private ArrayList<com.baidu.tbadk.data.c> bLe = new ArrayList<>();
    private PushStatusData bLf = new PushStatusData();
    public boolean bLA = false;
    public int bLB = -1;
    private long bLJ = 0;
    private long bLK = 0;
    private PostData bLN = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bLs = 0;
    public int bLU = 0;
    private String tieba_game_information_source = "";
    public String bLX = "";
    public String bLW = "";

    static {
        bKO.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        bKO.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        bKO.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        bKO.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        bKO.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        bKO.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        bKO.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        bKO.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        bLD.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        bLD.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        bLD.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        bLD.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        bLD.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        bLD.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        bLD.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        bLD.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        bKP.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        bKP.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        bKP.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        bLE.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        bLE.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        bLE.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_other_d, R.drawable.pic_dot_title_blue));
    }

    public bh() {
        this.bKp = 0;
        this.bKz = 0;
        this.bKU = 0L;
        this.mUrl = "";
        this.bLg = "";
        this.bLT = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bKU = 0L;
        this.bKz = 0;
        this.bKp = 0;
        this.bLT = 0;
        this.mUrl = "";
        this.bLg = "";
        this.isBigGie = false;
    }

    public String adW() {
        return this.bMl;
    }

    public String adX() {
        return this.bMm;
    }

    public void mx(String str) {
        this.bMm = str;
    }

    public String adY() {
        return this.bMn;
    }

    public SpannableStringBuilder adZ() {
        return this.bMo;
    }

    public SpannableString aea() {
        return this.bMp;
    }

    public String aeb() {
        return this.bMq;
    }

    public String aec() {
        return this.bMr;
    }

    public boolean aed() {
        return this.bKp == 1;
    }

    public bf aee() {
        return this.bLb;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void he(int i) {
        this.anchorLevel = i;
    }

    public int aef() {
        return this.bLs;
    }

    public void hf(int i) {
        this.bLs = i;
    }

    public void hg(int i) {
        this.bKX = i;
    }

    public int aeg() {
        return this.bKX;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aeh() {
        return this.bMc;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void aq(long j) {
        this.mCreateTime = j;
    }

    public long aei() {
        return this.bKF;
    }

    public String aej() {
        return this.bKv;
    }

    public PraiseData aek() {
        return this.bKt;
    }

    public void a(PraiseData praiseData) {
        this.bKt = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String ael() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void my(String str) {
        this.bJT = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void hh(int i) {
        this.bJS = i;
    }

    public int aem() {
        return this.bJS;
    }

    public String aen() {
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

    public List<PbContent> aeo() {
        return this.bLn;
    }

    public void U(List<PbContent> list) {
        this.bLo = list;
    }

    public void V(List<PbContent> list) {
        this.bLp = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hi(int i) {
        this.reply_num = i;
    }

    public int aep() {
        return this.reply_num;
    }

    public int aeq() {
        return this.bJZ;
    }

    public void hj(int i) {
        this.bJZ = i;
    }

    public long aer() {
        return this.bKa;
    }

    public void ar(long j) {
        this.bKa = j;
    }

    public int aes() {
        return this.bKc;
    }

    public int aet() {
        return this.bKb;
    }

    public void hk(int i) {
        this.bKb = i;
    }

    public int aeu() {
        return this.bKd;
    }

    public void hl(int i) {
        this.bKd = i;
    }

    public int aev() {
        return this.bKe;
    }

    public List<PbContent> aew() {
        return this.bLo;
    }

    public bl aex() {
        return this.bKf;
    }

    public MetaData aey() {
        return this.bKg;
    }

    public boolean aez() {
        return this.is_god != 0;
    }

    public boolean aeA() {
        return this.is_god == 1;
    }

    public boolean aeB() {
        return (this.bKg == null || this.bKg.getGodUserData() == null || this.bKg.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aeC() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bKg = metaData;
    }

    public String aeD() {
        return this.forum_name;
    }

    public void mz(String str) {
        this.forum_name = str;
    }

    public int aeE() {
        return this.bKj;
    }

    public String aeF() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bKl;
    }

    public void mA(String str) {
        this.bKl = str;
    }

    public String K(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bLp == null || this.bLp.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bLp.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bLp.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bLo == null || (size = this.bLo.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bLo.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString mB(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(K(str, true));
        if (this.bLp != null && (size = this.bLp.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLp.get(i2);
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
                                bh.this.mF(pbContent.link);
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

    public int aeG() {
        return this.bKq;
    }

    public void hm(int i) {
        this.bKq = i;
    }

    public String aeH() {
        return this.bKr;
    }

    public void mC(String str) {
        this.bKr = str;
    }

    public ArrayList<MediaData> aeI() {
        return this.bKm;
    }

    public ArrayList<b> aeJ() {
        return this.bKK;
    }

    public void q(ArrayList<b> arrayList) {
        this.bKK = arrayList;
    }

    public bq aeK() {
        return this.bKL;
    }

    public g aeL() {
        return this.bKM;
    }

    public ArrayList<VoiceData.VoiceModel> aeM() {
        return this.bKn;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aeN() {
        return this.bKw;
    }

    public void hn(int i) {
        this.bKw = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aeO() {
        return this.bKH;
    }

    public VideoInfo aeP() {
        return this.bKB;
    }

    public VideoDesc aeQ() {
        return this.bKC;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bKE = alaInfoData;
    }

    public AlaInfoData aeR() {
        return this.bKE;
    }

    public PushStatusData aeS() {
        return this.bLf;
    }

    public SkinInfo aeT() {
        return this.bLh;
    }

    public long aeU() {
        return this.bLx;
    }

    public boolean aeV() {
        return this.bLy;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acy() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acz() {
        return this.bLz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acA() {
        if (this.bHM == null || this.bHM.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acy().getTid());
        ajVar.setFid(acy().getFid());
        ajVar.b(this.bHM);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bKx = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bKp = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bKF = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bJY = threadInfo.repost_num.intValue();
                this.bJZ = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bKa = threadInfo.last_time_int.intValue();
                this.bKb = threadInfo.is_top.intValue();
                this.bKc = threadInfo.is_membertop.intValue();
                this.bKd = threadInfo.is_good.intValue();
                this.bKe = threadInfo.is_livepost.intValue();
                this.bKf.a(threadInfo.topic);
                this.bKg.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bKh = threadInfo.fname;
                this.bKi = threadInfo.has_commented.intValue();
                this.bKj = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bKB = threadInfo.video_info;
                this.bKC = threadInfo.video_segment;
                this.bKE = new AlaInfoData();
                this.bKE.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bKq = threadInfo.collect_status.intValue();
                this.bKr = threadInfo.collect_mark_pid;
                this.bKs = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bKv = threadInfo.first_post_id + "";
                this.bKH = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bKw = threadInfo.is_ntitle.intValue();
                this.bKy = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bLL = threadInfo.agree.has_agree.intValue();
                    this.bLM = threadInfo.agree.agree_type.intValue();
                    this.bLJ = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bLK = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bLJ;
                    this.agreeData.disAgreeNum = this.bLK;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bLO = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bKz = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bLq = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bLo = threadInfo.rich_title;
                this.bLn = threadInfo.first_post_content;
                this.bLp = threadInfo.rich_abstract;
                this.bKo = threadInfo.is_godthread_recommend.intValue();
                if ((this.bKg == null || this.bKg.getUserId() == null || this.bKg.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKg = metaData;
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
                this.bKl = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bKm.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bKB = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bKD = new bn();
                    this.bKD.a(threadInfo.video_channel_info);
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
                        this.bKn.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bKK.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bKL = new bq();
                    this.bKL.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bKM = new g();
                    this.bKM.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bKN = new o();
                    this.bKN.a(threadInfo.cartoon_info);
                }
                this.bKt.setUserMap(this.userMap);
                this.bKt.parserProtobuf(threadInfo.zan);
                this.bKu.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKt.setTitle(this.title);
                } else {
                    this.bKt.setTitle(this.bKl);
                }
                this.bKQ = threadInfo.livecover_src;
                this.bKR = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bKJ = threadInfo.post_num.intValue();
                this.bKU = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jV(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.pJ(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bKA.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bKS = noticeInfo.notice;
                    }
                    this.bKX = zhiBoInfoTW.copythread_remind.intValue();
                    this.bKV = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bKW = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bKQ)) {
                        this.bKQ = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bLc = zhiBoInfoTW.user.tw_anchor_info;
                        this.bLd = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bKT = threadInfo.twzhibo_info.livecover_status;
                    this.bKU = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bKY = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bLb.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bLe.add(cVar);
                    }
                }
                this.bLf.parserProtobuf(threadInfo.push_status);
                this.bLk = threadInfo.lego_card;
                this.bLh = threadInfo.skin_info;
                this.bLl = threadInfo.is_book_chapter.intValue();
                this.bLm.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bLz = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bLx = threadInfo.last_read_pid.longValue();
                this.bLy = threadInfo.cheak_repeat.intValue() == 1;
                this.bLC = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bLN.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.Z(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bHM = sparseArray;
                }
                this.bLI = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bLP = new af();
                    this.bLP.a(threadInfo.link_info);
                }
                this.bLQ = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bLR = new f();
                    this.bLR.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bLS = new MediaData();
                    this.bLS.parserProtobuf(threadInfo.pic_info);
                }
                this.bLs = threadInfo.is_called.intValue();
                this.bLT = threadInfo.middle_page_num.intValue();
                this.bLU = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bLW = threadInfo.star_rank_icon.icon_pic_url;
                    this.bLX = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bLV = new OriginalThreadInfo();
                    this.bLV.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bLV = new OriginalThreadInfo();
                    this.bLV.parser(threadInfo.origin_thread_info);
                } else {
                    this.bLV = null;
                }
                this.bLY = threadInfo.is_topic.intValue();
                this.bMa = threadInfo.topic_user_name;
                this.bMb = threadInfo.topic_h5_url;
                this.bLZ = threadInfo.topic_module;
                this.bMd = threadInfo.presentation_style;
                this.bMf = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bMh = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bJV = new bd();
                    this.bJV.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bMj = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMj, this);
                }
                this.bMu = threadInfo.t_share_img;
                aeW();
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
                this.bKF = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bJY = jSONObject.optInt("repost_num", 0);
                this.bJZ = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(com.baidu.sapi2.share.a.b.e);
                this.bKa = jSONObject.optLong("last_time_int", 0L);
                this.bKb = jSONObject.optInt("is_top", 0);
                this.bKc = jSONObject.optInt("is_membertop", 0);
                this.bKd = jSONObject.optInt("is_good", 0);
                this.bKe = jSONObject.optInt("is_livepost", 0);
                this.bKf.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bKg.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bKh = this.forum_name;
                this.bKi = jSONObject.optInt("has_commented", 0);
                this.bKj = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bKq = jSONObject.optInt("collect_status");
                this.bKr = jSONObject.optString("collect_mark_pid");
                this.bKs = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bLJ = jSONObject.optInt("agree_num");
                this.bLO = jSONObject.optLong("share_num");
                this.bKv = jSONObject.optString("first_post_id", "0");
                this.bKH = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bKw = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bLL = optJSONObject2.optInt("has_agree");
                    this.bLJ = optJSONObject2.optInt("agree_num");
                    this.bLK = optJSONObject2.optLong("disagree_num");
                    this.bLM = optJSONObject2.optInt("agree_type");
                    if (this.bLJ < 0) {
                        this.bLJ = 0L;
                    }
                    if (this.bLK < 0) {
                        this.bLK = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bLJ;
                    this.agreeData.disAgreeNum = this.bLK;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bLb.parserJson(optJSONObject3);
                }
                if ((this.bKg == null || this.bKg.getUserId() == null) && this.userMap != null) {
                    this.bKg = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bKE = new AlaInfoData();
                this.bKE.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bKl = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bKm.add(mediaData);
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
                        this.bKn.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bKK.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bKL = new bq();
                    this.bKL.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bKM = new g();
                    this.bKM.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bKN = new o();
                    this.bKN.parserJson(optJSONObject7);
                }
                this.bKt.setUserMap(this.userMap);
                this.bKt.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bKu.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKt.setTitle(this.title);
                } else {
                    this.bKt.setTitle(this.bKl);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bLb.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bLe.add(cVar);
                    }
                }
                this.bLl = jSONObject.optInt("is_book_chapter", 0);
                this.bLm.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bLz = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bLt = jSONObject.optString("recom_extra_img");
                this.bLw = jSONObject.optString("recom_extra_img_night");
                this.bLu = jSONObject.optInt("recom_extra_img_width", 0);
                this.bLv = jSONObject.optInt("recom_extra_img_height", 0);
                this.bLx = jSONObject.optLong("last_read_pid");
                this.bLy = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bKD = new bn();
                    this.bKD.aV(optJSONObject9);
                }
                this.bLI = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bLP = new af();
                    this.bLP.parserJson(optJSONObject10);
                }
                this.bLQ = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bLR = new f();
                    this.bLR.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bLS = new MediaData();
                    this.bLS.parserJson(optJSONObject12);
                }
                this.bLs = jSONObject.optInt("is_called", 0);
                this.bLT = jSONObject.optInt("middle_page_num", 0);
                this.bLU = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bKB = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bLV = new OriginalThreadInfo();
                        this.bLV.parserJson(optJSONObject14);
                    } else {
                        this.bLV = null;
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
                    this.bMj = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMj, this);
                }
                this.bMu = jSONObject.optString("t_share_img");
                aeW();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void aeW() {
        aeX();
        aeY();
        aeZ();
        afa();
        afb();
        afc();
        afd();
    }

    private void aeX() {
        if (!StringUtils.isNull(this.bKg.getName_show())) {
            this.bMl = com.baidu.tbadk.core.util.aq.j(this.bKg.getName_show(), 14, "...");
        }
    }

    private void aeY() {
        if (aeC()) {
            this.bMm = com.baidu.tbadk.core.util.aq.aE(aer() * 1000);
        } else if (agp()) {
            String aE = com.baidu.tbadk.core.util.aq.aE(aer() * 1000);
            if (com.baidu.tbadk.core.util.aq.nZ(aE)) {
                aE = com.baidu.tbadk.core.util.aq.aF(aer() * 1000);
            }
            this.bMm = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aE;
        } else {
            String aE2 = com.baidu.tbadk.core.util.aq.aE(aer() * 1000);
            if (com.baidu.tbadk.core.util.aq.nZ(aE2)) {
                aE2 = com.baidu.tbadk.core.util.aq.aF(aer() * 1000);
            }
            this.bMm = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aE2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bMm += " • " + getAddress();
        }
    }

    private void aeZ() {
        if (aeR() == null || aeR().share_info == null || aeR().share_info.share_user_count <= 0 || !afM() || (this.bLT > 0 && this.bLU == 0)) {
            this.bMn = null;
            return;
        }
        int i = aeR().share_info.share_user_count;
        if (i == 1) {
            this.bMn = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.bMn = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.aI(i)});
        }
    }

    private void afa() {
        this.bMo = afY();
    }

    private void afb() {
        this.bMp = afZ();
    }

    private void afc() {
        this.bMq = com.baidu.tbadk.core.util.aq.aF(aer() * 1000);
    }

    private void afd() {
        this.bMr = com.baidu.tbadk.core.util.aq.aF(aer());
    }

    public SpannableStringBuilder afe() {
        return this.bKk;
    }

    public boolean aff() {
        return aet() != 0;
    }

    public int afg() {
        if (this.bLb != null) {
            long adR = this.bLb.adR();
            long adS = this.bLb.adS();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < adR) {
                return 1;
            }
            if (currentTimeMillis > adS) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int afh() {
        if (afj() && this.bKK.size() >= 1) {
            b bVar = this.bKK.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int acD = bVar.acD();
            int acE = bVar.acE();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < acD) {
                return 4;
            }
            return currentTimeMillis > acE ? 2 : 1;
        }
        return -1;
    }

    public int afi() {
        if (!afj() || this.bKK.size() < 1 || this.bKK.get(0) == null) {
            return -1;
        }
        return this.bKK.get(0).acC();
    }

    public boolean afj() {
        return this.bKy == 1;
    }

    public String getActUrl() {
        return (!afj() || this.bKK.size() < 1 || this.bKK.get(0) == null) ? "" : this.bKK.get(0).getUrl();
    }

    private com.baidu.adp.widget.b mD(String str) {
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

    public SmartApp afk() {
        return this.bMj;
    }

    private void l(boolean z, boolean z2) {
        SpannableString spannableString;
        String K = K(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && afm()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aet() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aet() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aev() == 1 || this.bKf.agz() != 0) {
                if (aee() != null && getThreadType() == 41) {
                    if (afg() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && afy()) {
                Integer num = bKP.get(Integer.valueOf(afg()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aeu() == 1 && !aff() && bJC != getType() && bJH != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.bKu != null && this.bKu.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aeE() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = bKO.get(new Point(afi(), afh()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aeK() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aeL() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = mD(this.category_name);
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
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bitmap ij = com.baidu.tbadk.core.util.am.ij(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
                if (ij != null) {
                    bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bJU));
                spannableString.setSpan(kVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(K + " "));
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.bKk = spannableStringBuilder;
    }

    public boolean afl() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap ij = com.baidu.tbadk.core.util.am.ij(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ij);
        bitmapDrawable.setBounds(0, 0, ij.getWidth(), ij.getHeight());
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aey() != null) {
            if (aey().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aey().getGender() == 2) {
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

    private boolean afm() {
        return com.baidu.adp.lib.b.d.hS().az("isConveneThreadOpen") == 1;
    }

    public void m(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.Z(b(z, z2, z3, false)) > 0) {
            n(z, z3);
            return;
        }
        String K = K(this.title, false);
        SpannableString a = a(new SpannableString(K + " "));
        if (z) {
            spannableStringBuilder = a(K, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bKk = spannableStringBuilder;
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
            if (this.bKw == 1) {
                this.bKk = a;
                return a;
            }
        } else if (this.bKw == 1) {
            this.bKk = new SpannableStringBuilder();
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

    public void bC(String str, String str2) {
        this.mUrl = str;
        this.bLg = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a V;
        com.baidu.adp.widget.ImageView.a V2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLg) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.aty().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.U(this.mUrl, 10)) && (V = com.baidu.tbadk.core.util.d.v.V(this.mUrl, 10)) != null) {
                bitmap = V.nK();
                com.baidu.tbadk.imageManager.c.aty().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.aty().getBitmap(this.bLg);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.U(this.bLg, 10)) && (V2 = com.baidu.tbadk.core.util.d.v.V(this.bLg, 10)) != null) {
                bitmap2 = V2.nK();
                com.baidu.tbadk.imageManager.c.aty().e(this.bLg, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bJU));
                        spannableString.setSpan(mVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.iE().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.aty().e(str2, aVar.nK());
                    }
                }
            }, bJA);
            com.baidu.adp.lib.f.c.iE().a(this.bLg, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.aty().e(str2, aVar.nK());
                    }
                }
            }, bJA);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bLo != null && this.bLo.size() > 0) {
            int size = this.bLo.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLo.get(i2);
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
                                bh.this.mF(pbContent.link);
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

    private String mE(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData afn() {
        if (this.bLo != null && this.bLo.size() > 0) {
            int size = this.bLo.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bLo.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && afs() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = mE(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.bJS;
            kVar.cqZ = this.bJT;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void afo() {
        l(false, false);
    }

    public void afp() {
        l(false, true);
    }

    public AnchorInfoData afq() {
        return this.bKu;
    }

    public boolean afr() {
        return this.threadType == 36;
    }

    public boolean afs() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aft() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aeI = aeI();
        if (aeI == null || aff()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aeI.size() || i2 >= 3) {
                break;
            }
            if (aeI.get(i2) != null && aeI.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aeI.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aeI.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aeI.get(i2).getPicUrl();
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
        if (this.bKB != null && !StringUtils.isNull(this.bKB.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bKB.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bKg != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bKg.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean afu() {
        String userId;
        return this.bKg == null || (userId = this.bKg.getUserId()) == null || userId.equals("0");
    }

    public boolean afv() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (agm()) {
            if (aeP() != null) {
                return bJC;
            }
            return bJo;
        }
        int aet = aet();
        if (this.bLY == 1) {
            if (this.bLZ != null) {
                return bJz;
            }
            return this.bMc != null ? bJJ : bJI;
        } else if (this.bKB != null && agd()) {
            return bJR;
        } else {
            if (this.bKE != null && this.threadType == 60) {
                return bJF;
            }
            if (this.bKE != null && this.threadType == 49) {
                return bJD;
            }
            if (this.threadType == 51) {
                return bJE;
            }
            if (this.threadType == 63) {
                return bJK;
            }
            if (this.threadType == 64) {
                return bJL;
            }
            if (aet == 2 || aet == 1) {
                return bJn;
            }
            if (this.bKB != null && afE() && !afv()) {
                return bJQ;
            }
            if (this.bKB != null && !afv()) {
                if (aeB()) {
                    return bJH;
                }
                return bJC;
            } else if (this.isShareThread) {
                return bJG;
            } else {
                if (afx()) {
                    return bJN.get() ? bLa : bJo;
                } else if (afj() && afi() == 1) {
                    return bJN.get() ? bLi : bJo;
                } else if (isLinkThread()) {
                    return bJA;
                } else {
                    if (aeB()) {
                        return bJB;
                    }
                    if (this.bJb) {
                        return bJs;
                    }
                    if (this.bJc) {
                        return bJt;
                    }
                    if (this.bJd) {
                        return bJu;
                    }
                    if (this.bJe) {
                        return bJv;
                    }
                    if (this.bJf) {
                        return bJw;
                    }
                    if (this.bJg) {
                        return bJx;
                    }
                    if (this.bJh) {
                        return bJy;
                    }
                    if (this.bKI) {
                        int afw = afw();
                        if (afw == 1) {
                            return bJp;
                        }
                        if (afw == 2) {
                            return bJq;
                        }
                        if (afw > 2) {
                            return bJr;
                        }
                        return bJo;
                    }
                    return bJo;
                }
            }
        }
    }

    public int afw() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.aca().ace() || com.baidu.tbadk.core.util.v.Z(aeI()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aeI().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeI(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean afx() {
        return aee() != null && getThreadType() == 41 && aev() == 1 && afg() == 2;
    }

    public void r(ArrayList<p> arrayList) {
        if (this.bKw == 1) {
            this.bGj = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bGj = 0;
        } else {
            this.bGj = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.acK() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.acK().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bGj = next.acL();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean afy() {
        return this.threadType == 41;
    }

    public boolean afz() {
        return this.bLj;
    }

    public void dJ(boolean z) {
        this.bLj = z;
    }

    public String afA() {
        return this.bLk;
    }

    public o afB() {
        return this.bKN;
    }

    public void afC() {
        if (this.bKG == 0) {
            this.bKG = 1;
        }
    }

    public boolean afD() {
        return this.bLq;
    }

    public void dK(boolean z) {
        this.bLA = z;
    }

    public boolean afE() {
        return this.bLA;
    }

    public void ho(int i) {
        this.bLB = i + 1;
    }

    public int afF() {
        return this.bLB;
    }

    public List<ReportInfo> afG() {
        return this.bLC;
    }

    public boolean afH() {
        return this.bLr;
    }

    public void dL(boolean z) {
        this.bLr = z;
    }

    public bn afI() {
        return this.bKD;
    }

    public void a(bn bnVar) {
        this.bKD = bnVar;
    }

    public void setCurrentPage(int i) {
        if (this.bKD != null) {
            this.bKD.mCurrentPage = i;
        }
    }

    public boolean afJ() {
        return getThreadType() == 49;
    }

    public boolean afK() {
        return getThreadType() == 40;
    }

    public boolean afL() {
        return getThreadType() == 50;
    }

    public boolean afM() {
        return getThreadType() == 60;
    }

    public boolean afN() {
        return getThreadType() == 40 && afI() != null && afI().channelId > 0;
    }

    public int afO() {
        return this.bLH;
    }

    public void setSmartFrsPosition(int i) {
        this.bLH = i;
    }

    public SparseArray<String> adh() {
        return this.bHM;
    }

    public String afP() {
        return this.mRecomSource;
    }

    public boolean afQ() {
        return this.bLI;
    }

    public long afR() {
        return this.bLJ;
    }

    public long afS() {
        return this.bLK;
    }

    public int afT() {
        return this.bLL;
    }

    public int afU() {
        return this.bLM;
    }

    public void hp(int i) {
        this.bLL = i;
    }

    public void hq(int i) {
        this.bLJ = i;
    }

    public void as(long j) {
        this.bLJ = j;
    }

    public void at(long j) {
        this.bLK = j;
    }

    public void hr(int i) {
        this.bLM = i;
    }

    public long afV() {
        return this.bLO;
    }

    public void au(long j) {
        this.bLO = j;
    }

    public PostData afW() {
        return this.bLN;
    }

    public af afX() {
        return this.bLP;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String K;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bKw == 1) {
            K = K(this.bKl, true);
            a = mB(this.bKl);
        } else {
            K = K(this.title, false);
            a = a(new SpannableString(K + " "));
        }
        if (z) {
            spannableStringBuilder = a(K, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bKk = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder n(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder o(boolean z, boolean z2) {
        SpannableString mB;
        if (!StringUtils.isNull(this.title) && this.bKw != 1) {
            mB = a(new SpannableString(K(this.title, false) + " "));
        } else {
            mB = mB(this.bKl);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mB);
        this.bKk = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder afY() {
        if (StringUtils.isNull(this.title) || this.bKw == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(K(this.title, false) + " ")));
        this.bKk = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString afZ() {
        return mB(this.bKl);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean aez = aez();
        if (z2) {
            if (z) {
                if (aez && !afs()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (aev() == 1 || getThreadType() == 33 || (aex() != null && aex().agz() != 0)) {
                    if (aee() != null && afy()) {
                        if (afg() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!aez) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (afy()) {
                    arrayList.add(bLE.get(afg()));
                }
                if (afj()) {
                    Integer num = bLD.get(new Point(afi(), afh()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (aeK() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (aez && aet() != 1 && !afs()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((aev() == 1 || getThreadType() == 33) && !afy() && !aez) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (aeu() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (aet() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (afy() && aee() != null && afg() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (afj()) {
                    Integer num2 = bLD.get(new Point(afi(), afh()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.bLl == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (aeL() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aeK() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && afJ()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (afN()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && afL()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (afK()) {
                    arrayList.add(new n.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new n.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void s(ArrayList<MediaData> arrayList) {
        this.bKm = arrayList;
    }

    public String aga() {
        return this.bMa;
    }

    public void mG(String str) {
        this.bMa = str;
    }

    public void agb() {
        this.bLY = 1;
    }

    public boolean agc() {
        return this.bLY == 1;
    }

    public boolean agd() {
        return this.bMd.equals("worldcupvideo");
    }

    public String age() {
        return this.bJW;
    }

    public void mH(String str) {
        this.bJW = str;
    }

    public String agf() {
        return this.bJX;
    }

    public void mI(String str) {
        this.bJX = str;
    }

    public String agg() {
        return this.bMb;
    }

    public void mJ(String str) {
        this.bMb = str;
    }

    public boolean agh() {
        return this.bMe;
    }

    public void dM(boolean z) {
        this.bMe = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bMc = videoInfo;
    }

    public boolean agi() {
        return this.bMf != null;
    }

    public String agj() {
        return this.bKh;
    }

    public String agk() {
        return this.bMh;
    }

    public bd agl() {
        return this.bJV;
    }

    public boolean agm() {
        return this.bMi;
    }

    public void dN(boolean z) {
        this.bMi = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bKB != null) {
            return this.bKB.video_url;
        }
        return null;
    }

    public boolean agn() {
        return this.bMk;
    }

    public void dO(boolean z) {
        this.bMk = z;
    }

    public AgreeData ago() {
        return this.agreeData;
    }

    public boolean agp() {
        return this.bMt;
    }

    public void dP(boolean z) {
        this.bMt = z;
    }

    public TopicModule agq() {
        return this.bLZ;
    }

    public String getShareImageUrl() {
        return this.bMu;
    }

    void a(SmartApp smartApp, bh bhVar) {
        if (smartApp != null && bhVar != null) {
            MetaData aey = bhVar.aey();
            if (com.baidu.tbadk.core.util.aq.isEmpty(smartApp.name)) {
                aey.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                aey.setName_show(smartApp.name);
            }
            aey.setPortrait(smartApp.avatar);
        }
    }

    public int[] agr() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aeI = aeI();
        if (com.baidu.tbadk.core.i.aca().ace() && com.baidu.tbadk.core.util.v.Z(aeI) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aeI.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeI, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(aeI, 0);
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

    public int[] ags() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aeI = aeI();
        if (com.baidu.tbadk.core.i.aca().ace() && com.baidu.tbadk.core.util.v.Z(aeI) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aeI.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeI, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(aeI, 0);
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

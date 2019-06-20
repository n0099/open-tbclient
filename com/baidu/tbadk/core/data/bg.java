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
import com.baidu.sapi2.share.face.FaceLoginModel;
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
public class bg extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.e.a {
    private String address;
    private String authorId;
    private bc bIQ;
    private String bIR;
    private String bIS;
    private long bJA;
    private o bJI;
    private LiveCoverStatus bJO;
    private long bJP;
    public TwZhiBoUser bJX;
    public List<TwAnchorProfitItem> bJY;
    private String bJc;
    private SpannableStringBuilder bJf;
    public int bJj;
    private int bJk;
    private int bJn;
    private String bJq;
    private int bJr;
    private String bJs;
    private int bJu;
    private VideoInfo bJw;
    private VideoDesc bJx;
    private bm bJy;
    private AlaInfoData bJz;
    private boolean bKD;
    private int bKG;
    private int bKH;
    private long bKJ;
    private af bKK;
    public f bKM;
    private MediaData bKN;
    public int bKO;
    public OriginalThreadInfo bKQ;
    private TopicModule bKU;
    private String bKV;
    private String bKW;
    private VideoInfo bKX;
    private String bKY;
    private String bKb;
    private SkinInfo bKc;
    private boolean bKe;
    private String bKf;
    private boolean bKl;
    private boolean bKm;
    public String bKo;
    public int bKp;
    public int bKq;
    public String bKr;
    public long bKs;
    public String bKu;
    private List<ReportInfo> bKx;
    public OriginalForumInfo bLa;
    public boolean bLb;
    private String bLc;
    private boolean bLd;
    private SmartApp bLe;
    private String bLg;
    private String bLh;
    private String bLi;
    private SpannableStringBuilder bLj;
    private SpannableString bLk;
    private String bLl;
    private String bLm;
    public int bLn;
    public boolean bLo;
    public String bLp;
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
    public static final BdUniqueId bIi = BdUniqueId.gen();
    public static final BdUniqueId bIj = BdUniqueId.gen();
    public static final BdUniqueId bIk = BdUniqueId.gen();
    public static final BdUniqueId bIl = BdUniqueId.gen();
    public static final BdUniqueId bIm = BdUniqueId.gen();
    public static final BdUniqueId bIn = BdUniqueId.gen();
    public static final BdUniqueId bIo = BdUniqueId.gen();
    public static final BdUniqueId bIp = BdUniqueId.gen();
    public static final BdUniqueId bIq = BdUniqueId.gen();
    public static final BdUniqueId bIr = BdUniqueId.gen();
    public static final BdUniqueId bIs = BdUniqueId.gen();
    public static final BdUniqueId bIt = BdUniqueId.gen();
    public static final BdUniqueId bIu = BdUniqueId.gen();
    public static final BdUniqueId bIv = BdUniqueId.gen();
    public static final BdUniqueId bIw = BdUniqueId.gen();
    public static final BdUniqueId bIx = BdUniqueId.gen();
    public static final BdUniqueId bIy = BdUniqueId.gen();
    public static final BdUniqueId bIz = BdUniqueId.gen();
    public static final BdUniqueId bIA = BdUniqueId.gen();
    public static final BdUniqueId bIB = BdUniqueId.gen();
    public static final BdUniqueId bIC = BdUniqueId.gen();
    public static final BdUniqueId bID = BdUniqueId.gen();
    public static final BdUniqueId bIE = BdUniqueId.gen();
    public static final BdUniqueId bIF = BdUniqueId.gen();
    public static final BdUniqueId bIG = BdUniqueId.gen();
    public static final BdUniqueId bIH = BdUniqueId.gen();
    public static AtomicBoolean bII = new AtomicBoolean(false);
    public static AtomicBoolean bIJ = new AtomicBoolean(false);
    public static AtomicBoolean bIK = new AtomicBoolean(false);
    public static final BdUniqueId bIL = BdUniqueId.gen();
    public static final BdUniqueId bIM = BdUniqueId.gen();
    private static HashMap<Point, Integer> bJJ = new HashMap<>();
    private static HashMap<Integer, Integer> bJK = new HashMap<>();
    public static final BdUniqueId bJU = BdUniqueId.gen();
    public static final BdUniqueId bJV = BdUniqueId.gen();
    public static final BdUniqueId bKd = BdUniqueId.gen();
    private static HashMap<Point, Integer> bKy = new HashMap<>();
    private static SparseArray<n.a> bKz = new SparseArray<>(3);
    public boolean bHW = false;
    public boolean bHX = false;
    public boolean bHY = false;
    public boolean bHZ = false;
    public boolean bIa = false;
    public boolean bIb = false;
    public boolean bIc = false;
    private int bIN = 0;
    private String bIO = "1";
    public int bIP = 1;
    private String bJm = null;
    private int bFh = 0;
    public int bJB = 0;
    private String bJC = "";
    public boolean bJD = false;
    private String bJL = "";
    public boolean bKt = true;
    public boolean bKA = false;
    public boolean bKB = false;
    private int bKC = -1;
    public SparseArray<String> bGL = null;
    public boolean bKL = false;
    private int bKT = 0;
    private boolean bKZ = false;
    private boolean bLf = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bIT = 0;
    private int bIU = 0;
    private String last_time = null;
    private long bIV = 0;
    private int bIW = 0;
    private int bIX = 0;
    private int bIY = 0;
    private int bIZ = 0;
    private bk bJa = new bk();
    private MetaData bJb = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bJh = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bJi = new ArrayList<>();
    private int bJd = 0;
    private int bJe = 0;
    private String ad_url = null;
    private String bJg = null;
    private String from = null;
    private int bJl = 0;
    private PraiseData bJo = new PraiseData();
    private AnchorInfoData bJp = new AnchorInfoData();
    private long time = 0;
    private int bJt = 0;
    private ArrayList<b> bJF = new ArrayList<>();
    private bp bJG = null;
    private g bJH = null;
    private int bJM = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bJv = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bJN = null;
    private int bJE = 0;
    private boolean bJQ = false;
    private boolean bJR = false;
    private int bJS = 0;
    private boolean bJT = false;
    private int anchorLevel = 0;
    public int bKg = 0;
    public l bKh = new l();
    private List<PbContent> bKi = new ArrayList();
    private List<PbContent> bKj = new ArrayList();
    private List<PbContent> bKk = new ArrayList();
    private String category_name = null;
    private be bJW = new be();
    private ArrayList<com.baidu.tbadk.data.c> bJZ = new ArrayList<>();
    private PushStatusData bKa = new PushStatusData();
    public boolean bKv = false;
    public int bKw = -1;
    private long bKE = 0;
    private long bKF = 0;
    private PostData bKI = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bKn = 0;
    public int bKP = 0;
    private String tieba_game_information_source = "";
    public String bKS = "";
    public String bKR = "";

    static {
        bJJ.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        bJJ.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        bJJ.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        bJJ.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        bJJ.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        bJJ.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        bJJ.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        bJJ.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        bKy.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        bKy.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        bKy.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        bKy.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        bKy.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        bKy.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        bKy.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        bKy.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        bJK.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        bJK.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        bJK.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        bKz.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        bKz.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        bKz.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_other_d, R.drawable.pic_dot_title_blue));
    }

    public bg() {
        this.bJk = 0;
        this.bJu = 0;
        this.bJP = 0L;
        this.mUrl = "";
        this.bKb = "";
        this.bKO = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bJP = 0L;
        this.bJu = 0;
        this.bJk = 0;
        this.bKO = 0;
        this.mUrl = "";
        this.bKb = "";
        this.isBigGie = false;
    }

    public String acT() {
        return this.bLg;
    }

    public String acU() {
        return this.bLh;
    }

    public void mm(String str) {
        this.bLh = str;
    }

    public String acV() {
        return this.bLi;
    }

    public SpannableStringBuilder acW() {
        return this.bLj;
    }

    public SpannableString acX() {
        return this.bLk;
    }

    public String acY() {
        return this.bLl;
    }

    public String acZ() {
        return this.bLm;
    }

    public boolean ada() {
        return this.bJk == 1;
    }

    public be adb() {
        return this.bJW;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void gZ(int i) {
        this.anchorLevel = i;
    }

    public int adc() {
        return this.bKn;
    }

    public void ha(int i) {
        this.bKn = i;
    }

    public void hb(int i) {
        this.bJS = i;
    }

    public int add() {
        return this.bJS;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo ade() {
        return this.bKX;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void ap(long j) {
        this.mCreateTime = j;
    }

    public long adf() {
        return this.bJA;
    }

    public String adg() {
        return this.bJq;
    }

    public PraiseData adh() {
        return this.bJo;
    }

    public void a(PraiseData praiseData) {
        this.bJo = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String adi() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void mn(String str) {
        this.bIO = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.bIN = i;
    }

    public int adj() {
        return this.bIN;
    }

    public String adk() {
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

    public List<PbContent> adl() {
        return this.bKi;
    }

    public void U(List<PbContent> list) {
        this.bKj = list;
    }

    public void V(List<PbContent> list) {
        this.bKk = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hc(int i) {
        this.reply_num = i;
    }

    public int adm() {
        return this.reply_num;
    }

    public int adn() {
        return this.bIU;
    }

    public void hd(int i) {
        this.bIU = i;
    }

    public long ado() {
        return this.bIV;
    }

    public void aq(long j) {
        this.bIV = j;
    }

    public int adp() {
        return this.bIX;
    }

    public int adq() {
        return this.bIW;
    }

    public void he(int i) {
        this.bIW = i;
    }

    public int adr() {
        return this.bIY;
    }

    public void hf(int i) {
        this.bIY = i;
    }

    public int ads() {
        return this.bIZ;
    }

    public List<PbContent> adt() {
        return this.bKj;
    }

    public bk adu() {
        return this.bJa;
    }

    public MetaData adv() {
        return this.bJb;
    }

    public boolean adw() {
        return this.is_god != 0;
    }

    public boolean adx() {
        return this.is_god == 1;
    }

    public boolean ady() {
        return (this.bJb == null || this.bJb.getGodUserData() == null || this.bJb.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean adz() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bJb = metaData;
    }

    public String adA() {
        return this.forum_name;
    }

    public void mo(String str) {
        this.forum_name = str;
    }

    public int adB() {
        return this.bJe;
    }

    public String adC() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bJg;
    }

    public void mp(String str) {
        this.bJg = str;
    }

    public String J(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bKk == null || this.bKk.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bKk.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bKk.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bKj == null || (size = this.bKj.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bKj.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString mq(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(J(str, true));
        if (this.bKk != null && (size = this.bKk.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bKk.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 > spannableString.length()) {
                    break;
                } else {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bg.1
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bg.this.mu(pbContent.link);
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

    public int adD() {
        return this.bJl;
    }

    public void hg(int i) {
        this.bJl = i;
    }

    public String adE() {
        return this.bJm;
    }

    public void mr(String str) {
        this.bJm = str;
    }

    public ArrayList<MediaData> adF() {
        return this.bJh;
    }

    public ArrayList<b> adG() {
        return this.bJF;
    }

    public void q(ArrayList<b> arrayList) {
        this.bJF = arrayList;
    }

    public bp adH() {
        return this.bJG;
    }

    public g adI() {
        return this.bJH;
    }

    public ArrayList<VoiceData.VoiceModel> adJ() {
        return this.bJi;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int adK() {
        return this.bJr;
    }

    public void hh(int i) {
        this.bJr = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String adL() {
        return this.bJC;
    }

    public VideoInfo adM() {
        return this.bJw;
    }

    public VideoDesc adN() {
        return this.bJx;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bJz = alaInfoData;
    }

    public AlaInfoData adO() {
        return this.bJz;
    }

    public PushStatusData adP() {
        return this.bKa;
    }

    public SkinInfo adQ() {
        return this.bKc;
    }

    public long adR() {
        return this.bKs;
    }

    public boolean adS() {
        return this.bKt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg abv() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String abw() {
        return this.bKu;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj abx() {
        if (this.bGL == null || this.bGL.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(abv().getTid());
        ajVar.setFid(abv().getFid());
        ajVar.b(this.bGL);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bJs = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bJk = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bJA = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bIT = threadInfo.repost_num.intValue();
                this.bIU = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bIV = threadInfo.last_time_int.intValue();
                this.bIW = threadInfo.is_top.intValue();
                this.bIX = threadInfo.is_membertop.intValue();
                this.bIY = threadInfo.is_good.intValue();
                this.bIZ = threadInfo.is_livepost.intValue();
                this.bJa.a(threadInfo.topic);
                this.bJb.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bJc = threadInfo.fname;
                this.bJd = threadInfo.has_commented.intValue();
                this.bJe = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bJw = threadInfo.video_info;
                this.bJx = threadInfo.video_segment;
                this.bJz = new AlaInfoData();
                this.bJz.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bJl = threadInfo.collect_status.intValue();
                this.bJm = threadInfo.collect_mark_pid;
                this.bJn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bJq = threadInfo.first_post_id + "";
                this.bJC = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bJr = threadInfo.is_ntitle.intValue();
                this.bJt = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bKG = threadInfo.agree.has_agree.intValue();
                    this.bKH = threadInfo.agree.agree_type.intValue();
                    this.bKE = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bKF = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bKE;
                    this.agreeData.disAgreeNum = this.bKF;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bKJ = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bJu = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bKl = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bKj = threadInfo.rich_title;
                this.bKi = threadInfo.first_post_content;
                this.bKk = threadInfo.rich_abstract;
                this.bJj = threadInfo.is_godthread_recommend.intValue();
                if ((this.bJb == null || this.bJb.getUserId() == null || this.bJb.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bJb = metaData;
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
                this.bJg = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bJh.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bJw = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bJy = new bm();
                    this.bJy.a(threadInfo.video_channel_info);
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
                        this.bJi.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bJF.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bJG = new bp();
                    this.bJG.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bJH = new g();
                    this.bJH.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bJI = new o();
                    this.bJI.a(threadInfo.cartoon_info);
                }
                this.bJo.setUserMap(this.userMap);
                this.bJo.parserProtobuf(threadInfo.zan);
                this.bJp.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bJo.setTitle(this.title);
                } else {
                    this.bJo.setTitle(this.bJg);
                }
                this.bJL = threadInfo.livecover_src;
                this.bJM = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bJE = threadInfo.post_num.intValue();
                this.bJP = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jO(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.ps(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bJv.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bJN = noticeInfo.notice;
                    }
                    this.bJS = zhiBoInfoTW.copythread_remind.intValue();
                    this.bJQ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bJR = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bJL)) {
                        this.bJL = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bJX = zhiBoInfoTW.user.tw_anchor_info;
                        this.bJY = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bJO = threadInfo.twzhibo_info.livecover_status;
                    this.bJP = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bJT = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bJW.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bJZ.add(cVar);
                    }
                }
                this.bKa.parserProtobuf(threadInfo.push_status);
                this.bKf = threadInfo.lego_card;
                this.bKc = threadInfo.skin_info;
                this.bKg = threadInfo.is_book_chapter.intValue();
                this.bKh.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bKu = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bKs = threadInfo.last_read_pid.longValue();
                this.bKt = threadInfo.cheak_repeat.intValue() == 1;
                this.bKx = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bKI.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.Z(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bGL = sparseArray;
                }
                this.bKD = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bKK = new af();
                    this.bKK.a(threadInfo.link_info);
                }
                this.bKL = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bKM = new f();
                    this.bKM.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bKN = new MediaData();
                    this.bKN.parserProtobuf(threadInfo.pic_info);
                }
                this.bKn = threadInfo.is_called.intValue();
                this.bKO = threadInfo.middle_page_num.intValue();
                this.bKP = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bKR = threadInfo.star_rank_icon.icon_pic_url;
                    this.bKS = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bKQ = new OriginalThreadInfo();
                    this.bKQ.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bKQ = new OriginalThreadInfo();
                    this.bKQ.parser(threadInfo.origin_thread_info);
                } else {
                    this.bKQ = null;
                }
                this.bKT = threadInfo.is_topic.intValue();
                this.bKV = threadInfo.topic_user_name;
                this.bKW = threadInfo.topic_h5_url;
                this.bKU = threadInfo.topic_module;
                this.bKY = threadInfo.presentation_style;
                this.bLa = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bLc = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bIQ = new bc();
                    this.bIQ.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bLe = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bLe, this);
                }
                this.bLp = threadInfo.t_share_img;
                adT();
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
                this.bJA = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bIT = jSONObject.optInt("repost_num", 0);
                this.bIU = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.bIV = jSONObject.optLong("last_time_int", 0L);
                this.bIW = jSONObject.optInt("is_top", 0);
                this.bIX = jSONObject.optInt("is_membertop", 0);
                this.bIY = jSONObject.optInt("is_good", 0);
                this.bIZ = jSONObject.optInt("is_livepost", 0);
                this.bJa.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bJb.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bJc = this.forum_name;
                this.bJd = jSONObject.optInt("has_commented", 0);
                this.bJe = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bJl = jSONObject.optInt("collect_status");
                this.bJm = jSONObject.optString("collect_mark_pid");
                this.bJn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bKE = jSONObject.optInt("agree_num");
                this.bKJ = jSONObject.optLong("share_num");
                this.bJq = jSONObject.optString("first_post_id", "0");
                this.bJC = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bJr = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bKG = optJSONObject2.optInt("has_agree");
                    this.bKE = optJSONObject2.optInt("agree_num");
                    this.bKF = optJSONObject2.optLong("disagree_num");
                    this.bKH = optJSONObject2.optInt("agree_type");
                    if (this.bKE < 0) {
                        this.bKE = 0L;
                    }
                    if (this.bKF < 0) {
                        this.bKF = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bKE;
                    this.agreeData.disAgreeNum = this.bKF;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bJW.parserJson(optJSONObject3);
                }
                if ((this.bJb == null || this.bJb.getUserId() == null) && this.userMap != null) {
                    this.bJb = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bJz = new AlaInfoData();
                this.bJz.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bJg = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bJh.add(mediaData);
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
                        this.bJi.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bJF.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bJG = new bp();
                    this.bJG.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bJH = new g();
                    this.bJH.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bJI = new o();
                    this.bJI.parserJson(optJSONObject7);
                }
                this.bJo.setUserMap(this.userMap);
                this.bJo.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bJp.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bJo.setTitle(this.title);
                } else {
                    this.bJo.setTitle(this.bJg);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bJW.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bJZ.add(cVar);
                    }
                }
                this.bKg = jSONObject.optInt("is_book_chapter", 0);
                this.bKh.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bKu = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bKo = jSONObject.optString("recom_extra_img");
                this.bKr = jSONObject.optString("recom_extra_img_night");
                this.bKp = jSONObject.optInt("recom_extra_img_width", 0);
                this.bKq = jSONObject.optInt("recom_extra_img_height", 0);
                this.bKs = jSONObject.optLong("last_read_pid");
                this.bKt = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bJy = new bm();
                    this.bJy.aV(optJSONObject9);
                }
                this.bKD = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bKK = new af();
                    this.bKK.parserJson(optJSONObject10);
                }
                this.bKL = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bKM = new f();
                    this.bKM.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bKN = new MediaData();
                    this.bKN.parserJson(optJSONObject12);
                }
                this.bKn = jSONObject.optInt("is_called", 0);
                this.bKO = jSONObject.optInt("middle_page_num", 0);
                this.bKP = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bJw = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bKQ = new OriginalThreadInfo();
                        this.bKQ.parserJson(optJSONObject14);
                    } else {
                        this.bKQ = null;
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
                    this.bLe = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bLe, this);
                }
                this.bLp = jSONObject.optString("t_share_img");
                adT();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void adT() {
        adU();
        adV();
        adW();
        adX();
        adY();
        adZ();
        aea();
    }

    private void adU() {
        if (!StringUtils.isNull(this.bJb.getName_show())) {
            this.bLg = com.baidu.tbadk.core.util.ap.j(this.bJb.getName_show(), 14, "...");
        }
    }

    private void adV() {
        if (adz()) {
            this.bLh = com.baidu.tbadk.core.util.ap.aD(ado() * 1000);
        } else if (afm()) {
            String aD = com.baidu.tbadk.core.util.ap.aD(ado() * 1000);
            if (com.baidu.tbadk.core.util.ap.nM(aD)) {
                aD = com.baidu.tbadk.core.util.ap.aE(ado() * 1000);
            }
            this.bLh = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aD;
        } else {
            String aD2 = com.baidu.tbadk.core.util.ap.aD(ado() * 1000);
            if (com.baidu.tbadk.core.util.ap.nM(aD2)) {
                aD2 = com.baidu.tbadk.core.util.ap.aE(ado() * 1000);
            }
            this.bLh = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aD2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bLh += " • " + getAddress();
        }
    }

    private void adW() {
        if (adO() == null || adO().share_info == null || adO().share_info.share_user_count <= 0 || !aeJ() || (this.bKO > 0 && this.bKP == 0)) {
            this.bLi = null;
            return;
        }
        int i = adO().share_info.share_user_count;
        if (i == 1) {
            this.bLi = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.bLi = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.ap.aH(i)});
        }
    }

    private void adX() {
        this.bLj = aeV();
    }

    private void adY() {
        this.bLk = aeW();
    }

    private void adZ() {
        this.bLl = com.baidu.tbadk.core.util.ap.aE(ado() * 1000);
    }

    private void aea() {
        this.bLm = com.baidu.tbadk.core.util.ap.aE(ado());
    }

    public SpannableStringBuilder aeb() {
        return this.bJf;
    }

    public boolean aec() {
        return adq() != 0;
    }

    public int aed() {
        if (this.bJW != null) {
            long acO = this.bJW.acO();
            long acP = this.bJW.acP();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < acO) {
                return 1;
            }
            if (currentTimeMillis > acP) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aee() {
        if (aeg() && this.bJF.size() >= 1) {
            b bVar = this.bJF.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int abA = bVar.abA();
            int abB = bVar.abB();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < abA) {
                return 4;
            }
            return currentTimeMillis > abB ? 2 : 1;
        }
        return -1;
    }

    public int aef() {
        if (!aeg() || this.bJF.size() < 1 || this.bJF.get(0) == null) {
            return -1;
        }
        return this.bJF.get(0).abz();
    }

    public boolean aeg() {
        return this.bJt == 1;
    }

    public String getActUrl() {
        return (!aeg() || this.bJF.size() < 1 || this.bJF.get(0) == null) ? "" : this.bJF.get(0).getUrl();
    }

    private com.baidu.adp.widget.b ms(String str) {
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

    public SmartApp aeh() {
        return this.bLe;
    }

    private void j(boolean z, boolean z2) {
        SpannableString spannableString;
        String J = J(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aej()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (adq() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (adq() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (ads() == 1 || this.bJa.afv() != 0) {
                if (adb() != null && getThreadType() == 41) {
                    if (aed() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aev()) {
                Integer num = bJK.get(Integer.valueOf(aed()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (adr() == 1 && !aec() && bIx != getType() && bIC != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.bJp != null && this.bJp.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (adB() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = bJJ.get(new Point(aef(), aee()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (adH() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (adI() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = ms(this.category_name);
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
                Bitmap id = com.baidu.tbadk.core.util.al.id(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
                if (id != null) {
                    bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bIP));
                spannableString.setSpan(kVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(J + " "));
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.bJf = spannableStringBuilder;
    }

    public boolean aei() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap id = com.baidu.tbadk.core.util.al.id(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
        bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (adv() != null) {
            if (adv().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (adv().getGender() == 2) {
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

    private boolean aej() {
        return com.baidu.adp.lib.b.d.hI().ay("isConveneThreadOpen") == 1;
    }

    public void k(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.Z(b(z, z2, z3, false)) > 0) {
            l(z, z3);
            return;
        }
        String J = J(this.title, false);
        SpannableString a = a(new SpannableString(J + " "));
        if (z) {
            spannableStringBuilder = a(J, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bJf = spannableStringBuilder;
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
            if (this.bJr == 1) {
                this.bJf = a;
                return a;
            }
        } else if (this.bJr == 1) {
            this.bJf = new SpannableStringBuilder();
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
        this.bKb = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a V;
        com.baidu.adp.widget.ImageView.a V2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bKb) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.asp().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.U(this.mUrl, 10)) && (V = com.baidu.tbadk.core.util.d.v.V(this.mUrl, 10)) != null) {
                bitmap = V.ns();
                com.baidu.tbadk.imageManager.c.asp().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.asp().getBitmap(this.bKb);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.U(this.bKb, 10)) && (V2 = com.baidu.tbadk.core.util.d.v.V(this.bKb, 10)) != null) {
                bitmap2 = V2.ns();
                com.baidu.tbadk.imageManager.c.asp().e(this.bKb, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bIP));
                        spannableString.setSpan(mVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.iv().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.asp().e(str2, aVar.ns());
                    }
                }
            }, bIv);
            com.baidu.adp.lib.f.c.iv().a(this.bKb, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.asp().e(str2, aVar.ns());
                    }
                }
            }, bIv);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bKj != null && this.bKj.size() > 0) {
            int size = this.bKj.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bKj.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        a(spannableString, pbContent.text, i3);
                        spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(2, pbContent.link) { // from class: com.baidu.tbadk.core.data.bg.4
                            @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                            public void onClick(View view) {
                                bg.this.mu(pbContent.link);
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

    private String mt(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData aek() {
        if (this.bKj != null && this.bKj.size() > 0) {
            int size = this.bKj.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bKj.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aep() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = mt(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.bIN;
            kVar.cpG = this.bIO;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void ael() {
        j(false, false);
    }

    public void aem() {
        j(false, true);
    }

    public AnchorInfoData aen() {
        return this.bJp;
    }

    public boolean aeo() {
        return this.threadType == 36;
    }

    public boolean aep() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aeq() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> adF = adF();
        if (adF == null || aec()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= adF.size() || i2 >= 3) {
                break;
            }
            if (adF.get(i2) != null && adF.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(adF.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = adF.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = adF.get(i2).getPicUrl();
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
        if (this.bJw != null && !StringUtils.isNull(this.bJw.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bJw.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bJb != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bJb.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aer() {
        String userId;
        return this.bJb == null || (userId = this.bJb.getUserId()) == null || userId.equals("0");
    }

    public boolean aes() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (afj()) {
            if (adM() != null) {
                return bIx;
            }
            return bIj;
        }
        int adq = adq();
        if (this.bKT == 1) {
            if (this.bKU != null) {
                return bIu;
            }
            return this.bKX != null ? bIE : bID;
        } else if (this.bJw != null && afa()) {
            return bIM;
        } else {
            if (this.bJz != null && this.threadType == 60) {
                return bIA;
            }
            if (this.bJz != null && this.threadType == 49) {
                return bIy;
            }
            if (this.threadType == 51) {
                return bIz;
            }
            if (this.threadType == 63) {
                return bIF;
            }
            if (this.threadType == 64) {
                return bIG;
            }
            if (adq == 2 || adq == 1) {
                return bIi;
            }
            if (this.bJw != null && aeB() && !aes()) {
                return bIL;
            }
            if (this.bJw != null && !aes()) {
                if (ady()) {
                    return bIC;
                }
                return bIx;
            } else if (this.isShareThread) {
                return bIB;
            } else {
                if (aeu()) {
                    return bII.get() ? bJV : bIj;
                } else if (aeg() && aef() == 1) {
                    return bII.get() ? bKd : bIj;
                } else if (isLinkThread()) {
                    return bIv;
                } else {
                    if (ady()) {
                        return bIw;
                    }
                    if (this.bHW) {
                        return bIn;
                    }
                    if (this.bHX) {
                        return bIo;
                    }
                    if (this.bHY) {
                        return bIp;
                    }
                    if (this.bHZ) {
                        return bIq;
                    }
                    if (this.bIa) {
                        return bIr;
                    }
                    if (this.bIb) {
                        return bIs;
                    }
                    if (this.bIc) {
                        return bIt;
                    }
                    if (this.bJD) {
                        int aet = aet();
                        if (aet == 1) {
                            return bIk;
                        }
                        if (aet == 2) {
                            return bIl;
                        }
                        if (aet > 2) {
                            return bIm;
                        }
                        return bIj;
                    }
                    return bIj;
                }
            }
        }
    }

    public int aet() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.abb().abf() || com.baidu.tbadk.core.util.v.Z(adF()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < adF().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(adF(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aeu() {
        return adb() != null && getThreadType() == 41 && ads() == 1 && aed() == 2;
    }

    public void r(ArrayList<p> arrayList) {
        if (this.bJr == 1) {
            this.bFh = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bFh = 0;
        } else {
            this.bFh = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.abH() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.abH().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bFh = next.abI();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aev() {
        return this.threadType == 41;
    }

    public boolean aew() {
        return this.bKe;
    }

    public void dF(boolean z) {
        this.bKe = z;
    }

    public String aex() {
        return this.bKf;
    }

    public o aey() {
        return this.bJI;
    }

    public void aez() {
        if (this.bJB == 0) {
            this.bJB = 1;
        }
    }

    public boolean aeA() {
        return this.bKl;
    }

    public void dG(boolean z) {
        this.bKv = z;
    }

    public boolean aeB() {
        return this.bKv;
    }

    public void hi(int i) {
        this.bKw = i + 1;
    }

    public int aeC() {
        return this.bKw;
    }

    public List<ReportInfo> aeD() {
        return this.bKx;
    }

    public boolean aeE() {
        return this.bKm;
    }

    public void dH(boolean z) {
        this.bKm = z;
    }

    public bm aeF() {
        return this.bJy;
    }

    public void a(bm bmVar) {
        this.bJy = bmVar;
    }

    public void setCurrentPage(int i) {
        if (this.bJy != null) {
            this.bJy.mCurrentPage = i;
        }
    }

    public boolean aeG() {
        return getThreadType() == 49;
    }

    public boolean aeH() {
        return getThreadType() == 40;
    }

    public boolean aeI() {
        return getThreadType() == 50;
    }

    public boolean aeJ() {
        return getThreadType() == 60;
    }

    public boolean aeK() {
        return getThreadType() == 40 && aeF() != null && aeF().channelId > 0;
    }

    public int aeL() {
        return this.bKC;
    }

    public void setSmartFrsPosition(int i) {
        this.bKC = i;
    }

    public SparseArray<String> ace() {
        return this.bGL;
    }

    public String aeM() {
        return this.mRecomSource;
    }

    public boolean aeN() {
        return this.bKD;
    }

    public long aeO() {
        return this.bKE;
    }

    public long aeP() {
        return this.bKF;
    }

    public int aeQ() {
        return this.bKG;
    }

    public int aeR() {
        return this.bKH;
    }

    public void hj(int i) {
        this.bKG = i;
    }

    public void hk(int i) {
        this.bKE = i;
    }

    public void ar(long j) {
        this.bKE = j;
    }

    public void as(long j) {
        this.bKF = j;
    }

    public void hl(int i) {
        this.bKH = i;
    }

    public long aeS() {
        return this.bKJ;
    }

    public void at(long j) {
        this.bKJ = j;
    }

    public PostData aeT() {
        return this.bKI;
    }

    public af aeU() {
        return this.bKK;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String J;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bJr == 1) {
            J = J(this.bJg, true);
            a = mq(this.bJg);
        } else {
            J = J(this.title, false);
            a = a(new SpannableString(J + " "));
        }
        if (z) {
            spannableStringBuilder = a(J, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bJf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder l(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder m(boolean z, boolean z2) {
        SpannableString mq;
        if (!StringUtils.isNull(this.title) && this.bJr != 1) {
            mq = a(new SpannableString(J(this.title, false) + " "));
        } else {
            mq = mq(this.bJg);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mq);
        this.bJf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aeV() {
        if (StringUtils.isNull(this.title) || this.bJr == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(J(this.title, false) + " ")));
        this.bJf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString aeW() {
        return mq(this.bJg);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean adw = adw();
        if (z2) {
            if (z) {
                if (adw && !aep()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (ads() == 1 || getThreadType() == 33 || (adu() != null && adu().afv() != 0)) {
                    if (adb() != null && aev()) {
                        if (aed() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!adw) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (aev()) {
                    arrayList.add(bKz.get(aed()));
                }
                if (aeg()) {
                    Integer num = bKy.get(new Point(aef(), aee()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (adH() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (adw && adq() != 1 && !aep()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((ads() == 1 || getThreadType() == 33) && !aev() && !adw) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (adr() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (adq() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (aev() && adb() != null && aed() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (aeg()) {
                    Integer num2 = bKy.get(new Point(aef(), aee()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.bKg == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (adI() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (adH() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && aeG()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (aeK()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && aeI()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (aeH()) {
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
        this.bJh = arrayList;
    }

    public String aeX() {
        return this.bKV;
    }

    public void mv(String str) {
        this.bKV = str;
    }

    public void aeY() {
        this.bKT = 1;
    }

    public boolean aeZ() {
        return this.bKT == 1;
    }

    public boolean afa() {
        return this.bKY.equals("worldcupvideo");
    }

    public String afb() {
        return this.bIR;
    }

    public void mw(String str) {
        this.bIR = str;
    }

    public String afc() {
        return this.bIS;
    }

    public void mx(String str) {
        this.bIS = str;
    }

    public String afd() {
        return this.bKW;
    }

    public void my(String str) {
        this.bKW = str;
    }

    public boolean afe() {
        return this.bKZ;
    }

    public void dI(boolean z) {
        this.bKZ = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bKX = videoInfo;
    }

    public boolean aff() {
        return this.bLa != null;
    }

    public String afg() {
        return this.bJc;
    }

    public String afh() {
        return this.bLc;
    }

    public bc afi() {
        return this.bIQ;
    }

    public boolean afj() {
        return this.bLd;
    }

    public void dJ(boolean z) {
        this.bLd = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bJw != null) {
            return this.bJw.video_url;
        }
        return null;
    }

    public boolean afk() {
        return this.bLf;
    }

    public void dK(boolean z) {
        this.bLf = z;
    }

    public AgreeData afl() {
        return this.agreeData;
    }

    public boolean afm() {
        return this.bLo;
    }

    public void dL(boolean z) {
        this.bLo = z;
    }

    public TopicModule afn() {
        return this.bKU;
    }

    public String getShareImageUrl() {
        return this.bLp;
    }

    void a(SmartApp smartApp, bg bgVar) {
        if (smartApp != null && bgVar != null) {
            MetaData adv = bgVar.adv();
            if (com.baidu.tbadk.core.util.ap.isEmpty(smartApp.name)) {
                adv.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                adv.setName_show(smartApp.name);
            }
            adv.setPortrait(smartApp.avatar);
        }
    }

    public int[] afo() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> adF = adF();
        if (com.baidu.tbadk.core.i.abb().abf() && com.baidu.tbadk.core.util.v.Z(adF) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < adF.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(adF, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(adF, 0);
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
}

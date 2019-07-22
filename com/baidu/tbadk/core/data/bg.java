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
public class bg extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.e.a {
    private String address;
    private String authorId;
    private bc bJQ;
    private String bJR;
    private String bJS;
    private long bKA;
    private o bKI;
    private LiveCoverStatus bKO;
    private long bKP;
    public TwZhiBoUser bKX;
    public List<TwAnchorProfitItem> bKY;
    private String bKc;
    private SpannableStringBuilder bKf;
    public int bKj;
    private int bKk;
    private int bKn;
    private String bKq;
    private int bKr;
    private String bKs;
    private int bKu;
    private VideoInfo bKw;
    private VideoDesc bKx;
    private bm bKy;
    private AlaInfoData bKz;
    private boolean bLD;
    private int bLG;
    private int bLH;
    private long bLJ;
    private af bLK;
    public f bLM;
    private MediaData bLN;
    public int bLO;
    public OriginalThreadInfo bLQ;
    private TopicModule bLU;
    private String bLV;
    private String bLW;
    private VideoInfo bLX;
    private String bLY;
    private String bLb;
    private SkinInfo bLc;
    private boolean bLe;
    private String bLf;
    private boolean bLl;
    private boolean bLm;
    public String bLo;
    public int bLp;
    public int bLq;
    public String bLr;
    public long bLs;
    public String bLu;
    private List<ReportInfo> bLx;
    public OriginalForumInfo bMa;
    public boolean bMb;
    private String bMc;
    private boolean bMd;
    private SmartApp bMe;
    private String bMg;
    private String bMh;
    private String bMi;
    private SpannableStringBuilder bMj;
    private SpannableString bMk;
    private String bMl;
    private String bMm;
    public int bMn;
    public boolean bMo;
    public String bMp;
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
    public static final BdUniqueId bJi = BdUniqueId.gen();
    public static final BdUniqueId bJj = BdUniqueId.gen();
    public static final BdUniqueId bJk = BdUniqueId.gen();
    public static final BdUniqueId bJl = BdUniqueId.gen();
    public static final BdUniqueId bJm = BdUniqueId.gen();
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
    public static AtomicBoolean bJI = new AtomicBoolean(false);
    public static AtomicBoolean bJJ = new AtomicBoolean(false);
    public static AtomicBoolean bJK = new AtomicBoolean(false);
    public static final BdUniqueId bJL = BdUniqueId.gen();
    public static final BdUniqueId bJM = BdUniqueId.gen();
    private static HashMap<Point, Integer> bKJ = new HashMap<>();
    private static HashMap<Integer, Integer> bKK = new HashMap<>();
    public static final BdUniqueId bKU = BdUniqueId.gen();
    public static final BdUniqueId bKV = BdUniqueId.gen();
    public static final BdUniqueId bLd = BdUniqueId.gen();
    private static HashMap<Point, Integer> bLy = new HashMap<>();
    private static SparseArray<n.a> bLz = new SparseArray<>(3);
    public boolean bIW = false;
    public boolean bIX = false;
    public boolean bIY = false;
    public boolean bIZ = false;
    public boolean bJa = false;
    public boolean bJb = false;
    public boolean bJc = false;
    private int bJN = 0;
    private String bJO = "1";
    public int bJP = 1;
    private String bKm = null;
    private int bGi = 0;
    public int bKB = 0;
    private String bKC = "";
    public boolean bKD = false;
    private String bKL = "";
    public boolean bLt = true;
    public boolean bLA = false;
    public boolean bLB = false;
    private int bLC = -1;
    public SparseArray<String> bHL = null;
    public boolean bLL = false;
    private int bLT = 0;
    private boolean bLZ = false;
    private boolean bMf = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bJT = 0;
    private int bJU = 0;
    private String last_time = null;
    private long bJV = 0;
    private int bJW = 0;
    private int bJX = 0;
    private int bJY = 0;
    private int bJZ = 0;
    private bk bKa = new bk();
    private MetaData bKb = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bKh = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bKi = new ArrayList<>();
    private int bKd = 0;
    private int bKe = 0;
    private String ad_url = null;
    private String bKg = null;
    private String from = null;
    private int bKl = 0;
    private PraiseData bKo = new PraiseData();
    private AnchorInfoData bKp = new AnchorInfoData();
    private long time = 0;
    private int bKt = 0;
    private ArrayList<b> bKF = new ArrayList<>();
    private bp bKG = null;
    private g bKH = null;
    private int bKM = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bKv = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bKN = null;
    private int bKE = 0;
    private boolean bKQ = false;
    private boolean bKR = false;
    private int bKS = 0;
    private boolean bKT = false;
    private int anchorLevel = 0;
    public int bLg = 0;
    public l bLh = new l();
    private List<PbContent> bLi = new ArrayList();
    private List<PbContent> bLj = new ArrayList();
    private List<PbContent> bLk = new ArrayList();
    private String category_name = null;
    private be bKW = new be();
    private ArrayList<com.baidu.tbadk.data.c> bKZ = new ArrayList<>();
    private PushStatusData bLa = new PushStatusData();
    public boolean bLv = false;
    public int bLw = -1;
    private long bLE = 0;
    private long bLF = 0;
    private PostData bLI = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bLn = 0;
    public int bLP = 0;
    private String tieba_game_information_source = "";
    public String bLS = "";
    public String bLR = "";

    static {
        bKJ.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        bKJ.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        bKJ.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        bKJ.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        bKJ.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        bKJ.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        bKJ.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        bKJ.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        bLy.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        bLy.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        bLy.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        bLy.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        bLy.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        bLy.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        bLy.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        bLy.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        bKK.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        bKK.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        bKK.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        bLz.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        bLz.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        bLz.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_other_d, R.drawable.pic_dot_title_blue));
    }

    public bg() {
        this.bKk = 0;
        this.bKu = 0;
        this.bKP = 0L;
        this.mUrl = "";
        this.bLb = "";
        this.bLO = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bKP = 0L;
        this.bKu = 0;
        this.bKk = 0;
        this.bLO = 0;
        this.mUrl = "";
        this.bLb = "";
        this.isBigGie = false;
    }

    public String adV() {
        return this.bMg;
    }

    public String adW() {
        return this.bMh;
    }

    public void mx(String str) {
        this.bMh = str;
    }

    public String adX() {
        return this.bMi;
    }

    public SpannableStringBuilder adY() {
        return this.bMj;
    }

    public SpannableString adZ() {
        return this.bMk;
    }

    public String aea() {
        return this.bMl;
    }

    public String aeb() {
        return this.bMm;
    }

    public boolean aec() {
        return this.bKk == 1;
    }

    public be aed() {
        return this.bKW;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void he(int i) {
        this.anchorLevel = i;
    }

    public int aee() {
        return this.bLn;
    }

    public void hf(int i) {
        this.bLn = i;
    }

    public void hg(int i) {
        this.bKS = i;
    }

    public int aef() {
        return this.bKS;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aeg() {
        return this.bLX;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void aq(long j) {
        this.mCreateTime = j;
    }

    public long aeh() {
        return this.bKA;
    }

    public String aei() {
        return this.bKq;
    }

    public PraiseData aej() {
        return this.bKo;
    }

    public void a(PraiseData praiseData) {
        this.bKo = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aek() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void my(String str) {
        this.bJO = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void hh(int i) {
        this.bJN = i;
    }

    public int ael() {
        return this.bJN;
    }

    public String aem() {
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

    public List<PbContent> aen() {
        return this.bLi;
    }

    public void U(List<PbContent> list) {
        this.bLj = list;
    }

    public void V(List<PbContent> list) {
        this.bLk = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hi(int i) {
        this.reply_num = i;
    }

    public int aeo() {
        return this.reply_num;
    }

    public int aep() {
        return this.bJU;
    }

    public void hj(int i) {
        this.bJU = i;
    }

    public long aeq() {
        return this.bJV;
    }

    public void ar(long j) {
        this.bJV = j;
    }

    public int aer() {
        return this.bJX;
    }

    public int aes() {
        return this.bJW;
    }

    public void hk(int i) {
        this.bJW = i;
    }

    public int aet() {
        return this.bJY;
    }

    public void hl(int i) {
        this.bJY = i;
    }

    public int aeu() {
        return this.bJZ;
    }

    public List<PbContent> aev() {
        return this.bLj;
    }

    public bk aew() {
        return this.bKa;
    }

    public MetaData aex() {
        return this.bKb;
    }

    public boolean aey() {
        return this.is_god != 0;
    }

    public boolean aez() {
        return this.is_god == 1;
    }

    public boolean aeA() {
        return (this.bKb == null || this.bKb.getGodUserData() == null || this.bKb.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aeB() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bKb = metaData;
    }

    public String aeC() {
        return this.forum_name;
    }

    public void mz(String str) {
        this.forum_name = str;
    }

    public int aeD() {
        return this.bKe;
    }

    public String aeE() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bKg;
    }

    public void mA(String str) {
        this.bKg = str;
    }

    public String K(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bLk == null || this.bLk.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bLk.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bLk.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bLj == null || (size = this.bLj.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bLj.get(i2);
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
        if (this.bLk != null && (size = this.bLk.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLk.get(i2);
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
                                bg.this.mF(pbContent.link);
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

    public int aeF() {
        return this.bKl;
    }

    public void hm(int i) {
        this.bKl = i;
    }

    public String aeG() {
        return this.bKm;
    }

    public void mC(String str) {
        this.bKm = str;
    }

    public ArrayList<MediaData> aeH() {
        return this.bKh;
    }

    public ArrayList<b> aeI() {
        return this.bKF;
    }

    public void q(ArrayList<b> arrayList) {
        this.bKF = arrayList;
    }

    public bp aeJ() {
        return this.bKG;
    }

    public g aeK() {
        return this.bKH;
    }

    public ArrayList<VoiceData.VoiceModel> aeL() {
        return this.bKi;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aeM() {
        return this.bKr;
    }

    public void hn(int i) {
        this.bKr = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aeN() {
        return this.bKC;
    }

    public VideoInfo aeO() {
        return this.bKw;
    }

    public VideoDesc aeP() {
        return this.bKx;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bKz = alaInfoData;
    }

    public AlaInfoData aeQ() {
        return this.bKz;
    }

    public PushStatusData aeR() {
        return this.bLa;
    }

    public SkinInfo aeS() {
        return this.bLc;
    }

    public long aeT() {
        return this.bLs;
    }

    public boolean aeU() {
        return this.bLt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg acx() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acy() {
        return this.bLu;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acz() {
        if (this.bHL == null || this.bHL.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acx().getTid());
        ajVar.setFid(acx().getFid());
        ajVar.b(this.bHL);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bKs = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bKk = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bKA = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bJT = threadInfo.repost_num.intValue();
                this.bJU = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bJV = threadInfo.last_time_int.intValue();
                this.bJW = threadInfo.is_top.intValue();
                this.bJX = threadInfo.is_membertop.intValue();
                this.bJY = threadInfo.is_good.intValue();
                this.bJZ = threadInfo.is_livepost.intValue();
                this.bKa.a(threadInfo.topic);
                this.bKb.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bKc = threadInfo.fname;
                this.bKd = threadInfo.has_commented.intValue();
                this.bKe = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bKw = threadInfo.video_info;
                this.bKx = threadInfo.video_segment;
                this.bKz = new AlaInfoData();
                this.bKz.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bKl = threadInfo.collect_status.intValue();
                this.bKm = threadInfo.collect_mark_pid;
                this.bKn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bKq = threadInfo.first_post_id + "";
                this.bKC = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bKr = threadInfo.is_ntitle.intValue();
                this.bKt = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bLG = threadInfo.agree.has_agree.intValue();
                    this.bLH = threadInfo.agree.agree_type.intValue();
                    this.bLE = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bLF = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bLE;
                    this.agreeData.disAgreeNum = this.bLF;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bLJ = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bKu = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bLl = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bLj = threadInfo.rich_title;
                this.bLi = threadInfo.first_post_content;
                this.bLk = threadInfo.rich_abstract;
                this.bKj = threadInfo.is_godthread_recommend.intValue();
                if ((this.bKb == null || this.bKb.getUserId() == null || this.bKb.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKb = metaData;
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
                this.bKg = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bKh.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bKw = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bKy = new bm();
                    this.bKy.a(threadInfo.video_channel_info);
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
                        this.bKi.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bKF.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bKG = new bp();
                    this.bKG.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bKH = new g();
                    this.bKH.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bKI = new o();
                    this.bKI.a(threadInfo.cartoon_info);
                }
                this.bKo.setUserMap(this.userMap);
                this.bKo.parserProtobuf(threadInfo.zan);
                this.bKp.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKo.setTitle(this.title);
                } else {
                    this.bKo.setTitle(this.bKg);
                }
                this.bKL = threadInfo.livecover_src;
                this.bKM = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bKE = threadInfo.post_num.intValue();
                this.bKP = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jU(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.pJ(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bKv.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bKN = noticeInfo.notice;
                    }
                    this.bKS = zhiBoInfoTW.copythread_remind.intValue();
                    this.bKQ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bKR = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bKL)) {
                        this.bKL = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bKX = zhiBoInfoTW.user.tw_anchor_info;
                        this.bKY = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bKO = threadInfo.twzhibo_info.livecover_status;
                    this.bKP = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bKT = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bKW.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bKZ.add(cVar);
                    }
                }
                this.bLa.parserProtobuf(threadInfo.push_status);
                this.bLf = threadInfo.lego_card;
                this.bLc = threadInfo.skin_info;
                this.bLg = threadInfo.is_book_chapter.intValue();
                this.bLh.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bLu = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bLs = threadInfo.last_read_pid.longValue();
                this.bLt = threadInfo.cheak_repeat.intValue() == 1;
                this.bLx = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bLI.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.Z(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bHL = sparseArray;
                }
                this.bLD = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bLK = new af();
                    this.bLK.a(threadInfo.link_info);
                }
                this.bLL = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bLM = new f();
                    this.bLM.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bLN = new MediaData();
                    this.bLN.parserProtobuf(threadInfo.pic_info);
                }
                this.bLn = threadInfo.is_called.intValue();
                this.bLO = threadInfo.middle_page_num.intValue();
                this.bLP = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bLR = threadInfo.star_rank_icon.icon_pic_url;
                    this.bLS = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bLQ = new OriginalThreadInfo();
                    this.bLQ.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bLQ = new OriginalThreadInfo();
                    this.bLQ.parser(threadInfo.origin_thread_info);
                } else {
                    this.bLQ = null;
                }
                this.bLT = threadInfo.is_topic.intValue();
                this.bLV = threadInfo.topic_user_name;
                this.bLW = threadInfo.topic_h5_url;
                this.bLU = threadInfo.topic_module;
                this.bLY = threadInfo.presentation_style;
                this.bMa = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bMc = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bJQ = new bc();
                    this.bJQ.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bMe = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMe, this);
                }
                this.bMp = threadInfo.t_share_img;
                aeV();
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
                this.bKA = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bJT = jSONObject.optInt("repost_num", 0);
                this.bJU = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(com.baidu.sapi2.share.a.b.e);
                this.bJV = jSONObject.optLong("last_time_int", 0L);
                this.bJW = jSONObject.optInt("is_top", 0);
                this.bJX = jSONObject.optInt("is_membertop", 0);
                this.bJY = jSONObject.optInt("is_good", 0);
                this.bJZ = jSONObject.optInt("is_livepost", 0);
                this.bKa.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bKb.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bKc = this.forum_name;
                this.bKd = jSONObject.optInt("has_commented", 0);
                this.bKe = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bKl = jSONObject.optInt("collect_status");
                this.bKm = jSONObject.optString("collect_mark_pid");
                this.bKn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bLE = jSONObject.optInt("agree_num");
                this.bLJ = jSONObject.optLong("share_num");
                this.bKq = jSONObject.optString("first_post_id", "0");
                this.bKC = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bKr = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bLG = optJSONObject2.optInt("has_agree");
                    this.bLE = optJSONObject2.optInt("agree_num");
                    this.bLF = optJSONObject2.optLong("disagree_num");
                    this.bLH = optJSONObject2.optInt("agree_type");
                    if (this.bLE < 0) {
                        this.bLE = 0L;
                    }
                    if (this.bLF < 0) {
                        this.bLF = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bLE;
                    this.agreeData.disAgreeNum = this.bLF;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bKW.parserJson(optJSONObject3);
                }
                if ((this.bKb == null || this.bKb.getUserId() == null) && this.userMap != null) {
                    this.bKb = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bKz = new AlaInfoData();
                this.bKz.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bKg = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bKh.add(mediaData);
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
                        this.bKi.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bKF.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bKG = new bp();
                    this.bKG.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bKH = new g();
                    this.bKH.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bKI = new o();
                    this.bKI.parserJson(optJSONObject7);
                }
                this.bKo.setUserMap(this.userMap);
                this.bKo.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bKp.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKo.setTitle(this.title);
                } else {
                    this.bKo.setTitle(this.bKg);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bKW.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bKZ.add(cVar);
                    }
                }
                this.bLg = jSONObject.optInt("is_book_chapter", 0);
                this.bLh.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bLu = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bLo = jSONObject.optString("recom_extra_img");
                this.bLr = jSONObject.optString("recom_extra_img_night");
                this.bLp = jSONObject.optInt("recom_extra_img_width", 0);
                this.bLq = jSONObject.optInt("recom_extra_img_height", 0);
                this.bLs = jSONObject.optLong("last_read_pid");
                this.bLt = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bKy = new bm();
                    this.bKy.aV(optJSONObject9);
                }
                this.bLD = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bLK = new af();
                    this.bLK.parserJson(optJSONObject10);
                }
                this.bLL = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bLM = new f();
                    this.bLM.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bLN = new MediaData();
                    this.bLN.parserJson(optJSONObject12);
                }
                this.bLn = jSONObject.optInt("is_called", 0);
                this.bLO = jSONObject.optInt("middle_page_num", 0);
                this.bLP = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bKw = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bLQ = new OriginalThreadInfo();
                        this.bLQ.parserJson(optJSONObject14);
                    } else {
                        this.bLQ = null;
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
                    this.bMe = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMe, this);
                }
                this.bMp = jSONObject.optString("t_share_img");
                aeV();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void aeV() {
        aeW();
        aeX();
        aeY();
        aeZ();
        afa();
        afb();
        afc();
    }

    private void aeW() {
        if (!StringUtils.isNull(this.bKb.getName_show())) {
            this.bMg = com.baidu.tbadk.core.util.aq.j(this.bKb.getName_show(), 14, "...");
        }
    }

    private void aeX() {
        if (aeB()) {
            this.bMh = com.baidu.tbadk.core.util.aq.aE(aeq() * 1000);
        } else if (ago()) {
            String aE = com.baidu.tbadk.core.util.aq.aE(aeq() * 1000);
            if (com.baidu.tbadk.core.util.aq.nZ(aE)) {
                aE = com.baidu.tbadk.core.util.aq.aF(aeq() * 1000);
            }
            this.bMh = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aE;
        } else {
            String aE2 = com.baidu.tbadk.core.util.aq.aE(aeq() * 1000);
            if (com.baidu.tbadk.core.util.aq.nZ(aE2)) {
                aE2 = com.baidu.tbadk.core.util.aq.aF(aeq() * 1000);
            }
            this.bMh = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aE2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bMh += " • " + getAddress();
        }
    }

    private void aeY() {
        if (aeQ() == null || aeQ().share_info == null || aeQ().share_info.share_user_count <= 0 || !afL() || (this.bLO > 0 && this.bLP == 0)) {
            this.bMi = null;
            return;
        }
        int i = aeQ().share_info.share_user_count;
        if (i == 1) {
            this.bMi = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.bMi = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.aI(i)});
        }
    }

    private void aeZ() {
        this.bMj = afX();
    }

    private void afa() {
        this.bMk = afY();
    }

    private void afb() {
        this.bMl = com.baidu.tbadk.core.util.aq.aF(aeq() * 1000);
    }

    private void afc() {
        this.bMm = com.baidu.tbadk.core.util.aq.aF(aeq());
    }

    public SpannableStringBuilder afd() {
        return this.bKf;
    }

    public boolean afe() {
        return aes() != 0;
    }

    public int aff() {
        if (this.bKW != null) {
            long adQ = this.bKW.adQ();
            long adR = this.bKW.adR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < adQ) {
                return 1;
            }
            if (currentTimeMillis > adR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int afg() {
        if (afi() && this.bKF.size() >= 1) {
            b bVar = this.bKF.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int acC = bVar.acC();
            int acD = bVar.acD();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < acC) {
                return 4;
            }
            return currentTimeMillis > acD ? 2 : 1;
        }
        return -1;
    }

    public int afh() {
        if (!afi() || this.bKF.size() < 1 || this.bKF.get(0) == null) {
            return -1;
        }
        return this.bKF.get(0).acB();
    }

    public boolean afi() {
        return this.bKt == 1;
    }

    public String getActUrl() {
        return (!afi() || this.bKF.size() < 1 || this.bKF.get(0) == null) ? "" : this.bKF.get(0).getUrl();
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

    public SmartApp afj() {
        return this.bMe;
    }

    private void l(boolean z, boolean z2) {
        SpannableString spannableString;
        String K = K(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && afl()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aes() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aes() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aeu() == 1 || this.bKa.agx() != 0) {
                if (aed() != null && getThreadType() == 41) {
                    if (aff() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && afx()) {
                Integer num = bKK.get(Integer.valueOf(aff()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aet() == 1 && !afe() && bJx != getType() && bJC != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.bKp != null && this.bKp.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aeD() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = bKJ.get(new Point(afh(), afg()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aeJ() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aeK() != null) {
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
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bJP));
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
        this.bKf = spannableStringBuilder;
    }

    public boolean afk() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.ahO().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aex() != null) {
            if (aex().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aex().getGender() == 2) {
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

    private boolean afl() {
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
        this.bKf = spannableStringBuilder;
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
            if (this.bKr == 1) {
                this.bKf = a;
                return a;
            }
        } else if (this.bKr == 1) {
            this.bKf = new SpannableStringBuilder();
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
        this.bLb = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a V;
        com.baidu.adp.widget.ImageView.a V2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLb) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.atw().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.U(this.mUrl, 10)) && (V = com.baidu.tbadk.core.util.d.v.V(this.mUrl, 10)) != null) {
                bitmap = V.nK();
                com.baidu.tbadk.imageManager.c.atw().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.atw().getBitmap(this.bLb);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.U(this.bLb, 10)) && (V2 = com.baidu.tbadk.core.util.d.v.V(this.bLb, 10)) != null) {
                bitmap2 = V2.nK();
                com.baidu.tbadk.imageManager.c.atw().e(this.bLb, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bJP));
                        spannableString.setSpan(mVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.iE().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.atw().e(str2, aVar.nK());
                    }
                }
            }, bJv);
            com.baidu.adp.lib.f.c.iE().a(this.bLb, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.atw().e(str2, aVar.nK());
                    }
                }
            }, bJv);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bLj != null && this.bLj.size() > 0) {
            int size = this.bLj.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLj.get(i2);
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
                                bg.this.mF(pbContent.link);
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

    public ActivityItemData afm() {
        if (this.bLj != null && this.bLj.size() > 0) {
            int size = this.bLj.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bLj.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && afr() && pbContent.text != null && pbContent.text.length() >= 3) {
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
            kVar.type = this.bJN;
            kVar.cqS = this.bJO;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void afn() {
        l(false, false);
    }

    public void afo() {
        l(false, true);
    }

    public AnchorInfoData afp() {
        return this.bKp;
    }

    public boolean afq() {
        return this.threadType == 36;
    }

    public boolean afr() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean afs() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aeH = aeH();
        if (aeH == null || afe()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aeH.size() || i2 >= 3) {
                break;
            }
            if (aeH.get(i2) != null && aeH.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aeH.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aeH.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aeH.get(i2).getPicUrl();
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
        if (this.bKw != null && !StringUtils.isNull(this.bKw.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bKw.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bKb != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bKb.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aft() {
        String userId;
        return this.bKb == null || (userId = this.bKb.getUserId()) == null || userId.equals("0");
    }

    public boolean afu() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (agl()) {
            if (aeO() != null) {
                return bJx;
            }
            return bJj;
        }
        int aes = aes();
        if (this.bLT == 1) {
            if (this.bLU != null) {
                return bJu;
            }
            return this.bLX != null ? bJE : bJD;
        } else if (this.bKw != null && agc()) {
            return bJM;
        } else {
            if (this.bKz != null && this.threadType == 60) {
                return bJA;
            }
            if (this.bKz != null && this.threadType == 49) {
                return bJy;
            }
            if (this.threadType == 51) {
                return bJz;
            }
            if (this.threadType == 63) {
                return bJF;
            }
            if (this.threadType == 64) {
                return bJG;
            }
            if (aes == 2 || aes == 1) {
                return bJi;
            }
            if (this.bKw != null && afD() && !afu()) {
                return bJL;
            }
            if (this.bKw != null && !afu()) {
                if (aeA()) {
                    return bJC;
                }
                return bJx;
            } else if (this.isShareThread) {
                return bJB;
            } else {
                if (afw()) {
                    return bJI.get() ? bKV : bJj;
                } else if (afi() && afh() == 1) {
                    return bJI.get() ? bLd : bJj;
                } else if (isLinkThread()) {
                    return bJv;
                } else {
                    if (aeA()) {
                        return bJw;
                    }
                    if (this.bIW) {
                        return bJn;
                    }
                    if (this.bIX) {
                        return bJo;
                    }
                    if (this.bIY) {
                        return bJp;
                    }
                    if (this.bIZ) {
                        return bJq;
                    }
                    if (this.bJa) {
                        return bJr;
                    }
                    if (this.bJb) {
                        return bJs;
                    }
                    if (this.bJc) {
                        return bJt;
                    }
                    if (this.bKD) {
                        int afv = afv();
                        if (afv == 1) {
                            return bJk;
                        }
                        if (afv == 2) {
                            return bJl;
                        }
                        if (afv > 2) {
                            return bJm;
                        }
                        return bJj;
                    }
                    return bJj;
                }
            }
        }
    }

    public int afv() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.aca().ace() || com.baidu.tbadk.core.util.v.Z(aeH()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aeH().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeH(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean afw() {
        return aed() != null && getThreadType() == 41 && aeu() == 1 && aff() == 2;
    }

    public void r(ArrayList<p> arrayList) {
        if (this.bKr == 1) {
            this.bGi = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bGi = 0;
        } else {
            this.bGi = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.acJ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.acJ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bGi = next.acK();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean afx() {
        return this.threadType == 41;
    }

    public boolean afy() {
        return this.bLe;
    }

    public void dJ(boolean z) {
        this.bLe = z;
    }

    public String afz() {
        return this.bLf;
    }

    public o afA() {
        return this.bKI;
    }

    public void afB() {
        if (this.bKB == 0) {
            this.bKB = 1;
        }
    }

    public boolean afC() {
        return this.bLl;
    }

    public void dK(boolean z) {
        this.bLv = z;
    }

    public boolean afD() {
        return this.bLv;
    }

    public void ho(int i) {
        this.bLw = i + 1;
    }

    public int afE() {
        return this.bLw;
    }

    public List<ReportInfo> afF() {
        return this.bLx;
    }

    public boolean afG() {
        return this.bLm;
    }

    public void dL(boolean z) {
        this.bLm = z;
    }

    public bm afH() {
        return this.bKy;
    }

    public void a(bm bmVar) {
        this.bKy = bmVar;
    }

    public void setCurrentPage(int i) {
        if (this.bKy != null) {
            this.bKy.mCurrentPage = i;
        }
    }

    public boolean afI() {
        return getThreadType() == 49;
    }

    public boolean afJ() {
        return getThreadType() == 40;
    }

    public boolean afK() {
        return getThreadType() == 50;
    }

    public boolean afL() {
        return getThreadType() == 60;
    }

    public boolean afM() {
        return getThreadType() == 40 && afH() != null && afH().channelId > 0;
    }

    public int afN() {
        return this.bLC;
    }

    public void setSmartFrsPosition(int i) {
        this.bLC = i;
    }

    public SparseArray<String> adg() {
        return this.bHL;
    }

    public String afO() {
        return this.mRecomSource;
    }

    public boolean afP() {
        return this.bLD;
    }

    public long afQ() {
        return this.bLE;
    }

    public long afR() {
        return this.bLF;
    }

    public int afS() {
        return this.bLG;
    }

    public int afT() {
        return this.bLH;
    }

    public void hp(int i) {
        this.bLG = i;
    }

    public void hq(int i) {
        this.bLE = i;
    }

    public void as(long j) {
        this.bLE = j;
    }

    public void at(long j) {
        this.bLF = j;
    }

    public void hr(int i) {
        this.bLH = i;
    }

    public long afU() {
        return this.bLJ;
    }

    public void au(long j) {
        this.bLJ = j;
    }

    public PostData afV() {
        return this.bLI;
    }

    public af afW() {
        return this.bLK;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String K;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bKr == 1) {
            K = K(this.bKg, true);
            a = mB(this.bKg);
        } else {
            K = K(this.title, false);
            a = a(new SpannableString(K + " "));
        }
        if (z) {
            spannableStringBuilder = a(K, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bKf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder n(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder o(boolean z, boolean z2) {
        SpannableString mB;
        if (!StringUtils.isNull(this.title) && this.bKr != 1) {
            mB = a(new SpannableString(K(this.title, false) + " "));
        } else {
            mB = mB(this.bKg);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mB);
        this.bKf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder afX() {
        if (StringUtils.isNull(this.title) || this.bKr == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(K(this.title, false) + " ")));
        this.bKf = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString afY() {
        return mB(this.bKg);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean aey = aey();
        if (z2) {
            if (z) {
                if (aey && !afr()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (aeu() == 1 || getThreadType() == 33 || (aew() != null && aew().agx() != 0)) {
                    if (aed() != null && afx()) {
                        if (aff() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!aey) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (afx()) {
                    arrayList.add(bLz.get(aff()));
                }
                if (afi()) {
                    Integer num = bLy.get(new Point(afh(), afg()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (aeJ() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (aey && aes() != 1 && !afr()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((aeu() == 1 || getThreadType() == 33) && !afx() && !aey) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (aet() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (aes() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (afx() && aed() != null && aff() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (afi()) {
                    Integer num2 = bLy.get(new Point(afh(), afg()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.bLg == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (aeK() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aeJ() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && afI()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (afM()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && afK()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (afJ()) {
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
        this.bKh = arrayList;
    }

    public String afZ() {
        return this.bLV;
    }

    public void mG(String str) {
        this.bLV = str;
    }

    public void aga() {
        this.bLT = 1;
    }

    public boolean agb() {
        return this.bLT == 1;
    }

    public boolean agc() {
        return this.bLY.equals("worldcupvideo");
    }

    public String agd() {
        return this.bJR;
    }

    public void mH(String str) {
        this.bJR = str;
    }

    public String age() {
        return this.bJS;
    }

    public void mI(String str) {
        this.bJS = str;
    }

    public String agf() {
        return this.bLW;
    }

    public void mJ(String str) {
        this.bLW = str;
    }

    public boolean agg() {
        return this.bLZ;
    }

    public void dM(boolean z) {
        this.bLZ = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bLX = videoInfo;
    }

    public boolean agh() {
        return this.bMa != null;
    }

    public String agi() {
        return this.bKc;
    }

    public String agj() {
        return this.bMc;
    }

    public bc agk() {
        return this.bJQ;
    }

    public boolean agl() {
        return this.bMd;
    }

    public void dN(boolean z) {
        this.bMd = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bKw != null) {
            return this.bKw.video_url;
        }
        return null;
    }

    public boolean agm() {
        return this.bMf;
    }

    public void dO(boolean z) {
        this.bMf = z;
    }

    public AgreeData agn() {
        return this.agreeData;
    }

    public boolean ago() {
        return this.bMo;
    }

    public void dP(boolean z) {
        this.bMo = z;
    }

    public TopicModule agp() {
        return this.bLU;
    }

    public String getShareImageUrl() {
        return this.bMp;
    }

    void a(SmartApp smartApp, bg bgVar) {
        if (smartApp != null && bgVar != null) {
            MetaData aex = bgVar.aex();
            if (com.baidu.tbadk.core.util.aq.isEmpty(smartApp.name)) {
                aex.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                aex.setName_show(smartApp.name);
            }
            aex.setPortrait(smartApp.avatar);
        }
    }

    public int[] agq() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aeH = aeH();
        if (com.baidu.tbadk.core.i.aca().ace() && com.baidu.tbadk.core.util.v.Z(aeH) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aeH.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeH, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(aeH, 0);
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

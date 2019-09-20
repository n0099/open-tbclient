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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
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
public class bh extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String authorId;
    private String bKF;
    private SpannableStringBuilder bKI;
    public int bKM;
    private int bKN;
    private int bKQ;
    private String bKT;
    private int bKU;
    private String bKV;
    private int bKX;
    private VideoInfo bKZ;
    private bd bKt;
    private String bKu;
    private String bKv;
    public TwZhiBoUser bLA;
    public List<TwAnchorProfitItem> bLB;
    private String bLE;
    private SkinInfo bLF;
    private boolean bLH;
    private String bLI;
    private boolean bLO;
    private boolean bLP;
    public String bLR;
    public int bLS;
    public int bLT;
    public String bLU;
    public long bLV;
    public String bLX;
    private VideoDesc bLa;
    private bn bLb;
    private AlaInfoData bLc;
    private long bLd;
    private o bLl;
    private LiveCoverStatus bLr;
    private long bLs;
    private VideoInfo bMA;
    private String bMB;
    public OriginalForumInfo bMD;
    public boolean bME;
    private String bMF;
    private boolean bMG;
    private SmartApp bMH;
    private String bMJ;
    private String bMK;
    private String bML;
    private SpannableStringBuilder bMM;
    private SpannableString bMN;
    private String bMO;
    private String bMP;
    public int bMQ;
    public boolean bMR;
    public String bMS;
    private List<ReportInfo> bMa;
    private boolean bMg;
    private int bMj;
    private int bMk;
    private long bMm;
    private af bMn;
    public f bMp;
    private MediaData bMq;
    public int bMr;
    public OriginalThreadInfo bMt;
    private TopicModule bMx;
    private String bMy;
    private String bMz;
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
    public static final BdUniqueId bJL = BdUniqueId.gen();
    public static final BdUniqueId bJM = BdUniqueId.gen();
    public static final BdUniqueId bJN = BdUniqueId.gen();
    public static final BdUniqueId bJO = BdUniqueId.gen();
    public static final BdUniqueId bJP = BdUniqueId.gen();
    public static final BdUniqueId bJQ = BdUniqueId.gen();
    public static final BdUniqueId bJR = BdUniqueId.gen();
    public static final BdUniqueId bJS = BdUniqueId.gen();
    public static final BdUniqueId bJT = BdUniqueId.gen();
    public static final BdUniqueId bJU = BdUniqueId.gen();
    public static final BdUniqueId bJV = BdUniqueId.gen();
    public static final BdUniqueId bJW = BdUniqueId.gen();
    public static final BdUniqueId bJX = BdUniqueId.gen();
    public static final BdUniqueId bJY = BdUniqueId.gen();
    public static final BdUniqueId bJZ = BdUniqueId.gen();
    public static final BdUniqueId bKa = BdUniqueId.gen();
    public static final BdUniqueId bKb = BdUniqueId.gen();
    public static final BdUniqueId bKc = BdUniqueId.gen();
    public static final BdUniqueId bKd = BdUniqueId.gen();
    public static final BdUniqueId bKe = BdUniqueId.gen();
    public static final BdUniqueId bKf = BdUniqueId.gen();
    public static final BdUniqueId bKg = BdUniqueId.gen();
    public static final BdUniqueId bKh = BdUniqueId.gen();
    public static final BdUniqueId bKi = BdUniqueId.gen();
    public static final BdUniqueId bKj = BdUniqueId.gen();
    public static final BdUniqueId bKk = BdUniqueId.gen();
    public static AtomicBoolean bKl = new AtomicBoolean(false);
    public static AtomicBoolean bKm = new AtomicBoolean(false);
    public static AtomicBoolean bKn = new AtomicBoolean(false);
    public static final BdUniqueId bKo = BdUniqueId.gen();
    public static final BdUniqueId bKp = BdUniqueId.gen();
    private static HashMap<Point, Integer> bLm = new HashMap<>();
    private static HashMap<Integer, Integer> bLn = new HashMap<>();
    public static final BdUniqueId bLx = BdUniqueId.gen();
    public static final BdUniqueId bLy = BdUniqueId.gen();
    public static final BdUniqueId bLG = BdUniqueId.gen();
    private static HashMap<Point, Integer> bMb = new HashMap<>();
    private static SparseArray<n.a> bMc = new SparseArray<>(3);
    public boolean bJz = false;
    public boolean bJA = false;
    public boolean bJB = false;
    public boolean bJC = false;
    public boolean bJD = false;
    public boolean bJE = false;
    public boolean bJF = false;
    private int bKq = 0;
    private String bKr = "1";
    public int bKs = 1;
    private String bKP = null;
    private int bGH = 0;
    public int bLe = 0;
    private String bLf = "";
    public boolean bLg = false;
    private String bLo = "";
    public boolean bLW = true;
    public boolean bMd = false;
    public boolean bMe = false;
    private int bMf = -1;
    public SparseArray<String> bIk = null;
    public boolean bMo = false;
    private int bMw = 0;
    private boolean bMC = false;
    private boolean bMI = false;
    public boolean bMT = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bKw = 0;
    private int bKx = 0;
    private String last_time = null;
    private long bKy = 0;
    private int bKz = 0;
    private int bKA = 0;
    private int bKB = 0;
    private int bKC = 0;
    private bl bKD = new bl();
    private MetaData bKE = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bKK = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bKL = new ArrayList<>();
    private int bKG = 0;
    private int bKH = 0;
    private String ad_url = null;
    private String bKJ = null;
    private String from = null;
    private int bKO = 0;
    private PraiseData bKR = new PraiseData();
    private AnchorInfoData bKS = new AnchorInfoData();
    private long time = 0;
    private int bKW = 0;
    private ArrayList<b> bLi = new ArrayList<>();
    private bq bLj = null;
    private g bLk = null;
    private int bLp = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bKY = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bLq = null;
    private int bLh = 0;
    private boolean bLt = false;
    private boolean bLu = false;
    private int bLv = 0;
    private boolean bLw = false;
    private int anchorLevel = 0;
    public int bLJ = 0;
    public l bLK = new l();
    private List<PbContent> bLL = new ArrayList();
    private List<PbContent> bLM = new ArrayList();
    private List<PbContent> bLN = new ArrayList();
    private String category_name = null;
    private bf bLz = new bf();
    private ArrayList<com.baidu.tbadk.data.c> bLC = new ArrayList<>();
    private PushStatusData bLD = new PushStatusData();
    public boolean bLY = false;
    public int bLZ = -1;
    private long bMh = 0;
    private long bMi = 0;
    private PostData bMl = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bLQ = 0;
    public int bMs = 0;
    private String tieba_game_information_source = "";
    public String bMv = "";
    public String bMu = "";

    static {
        bLm.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        bLm.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        bLm.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        bLm.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        bLm.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        bLm.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        bLm.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        bLm.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        bMb.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        bMb.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        bMb.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        bMb.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        bMb.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        bMb.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        bMb.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        bMb.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        bLn.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        bLn.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        bLn.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        bMc.put(1, new n.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        bMc.put(2, new n.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        bMc.put(3, new n.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bh() {
        this.bKN = 0;
        this.bKX = 0;
        this.bLs = 0L;
        this.mUrl = "";
        this.bLE = "";
        this.bMr = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bLs = 0L;
        this.bKX = 0;
        this.bKN = 0;
        this.bMr = 0;
        this.mUrl = "";
        this.bLE = "";
        this.isBigGie = false;
    }

    public String aea() {
        return this.bMJ;
    }

    public String aeb() {
        return this.bMK;
    }

    public void mz(String str) {
        this.bMK = str;
    }

    public String aec() {
        return this.bML;
    }

    public SpannableStringBuilder aed() {
        return this.bMM;
    }

    public SpannableString aee() {
        return this.bMN;
    }

    public String aef() {
        return this.bMO;
    }

    public String aeg() {
        return this.bMP;
    }

    public boolean aeh() {
        return this.bKN == 1;
    }

    public bf aei() {
        return this.bLz;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void hf(int i) {
        this.anchorLevel = i;
    }

    public int aej() {
        return this.bLQ;
    }

    public void hg(int i) {
        this.bLQ = i;
    }

    public void hh(int i) {
        this.bLv = i;
    }

    public int aek() {
        return this.bLv;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo ael() {
        return this.bMA;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void aq(long j) {
        this.mCreateTime = j;
    }

    public long aem() {
        return this.bLd;
    }

    public String aen() {
        return this.bKT;
    }

    public PraiseData aeo() {
        return this.bKR;
    }

    public void a(PraiseData praiseData) {
        this.bKR = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aep() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void mA(String str) {
        this.bKr = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void hi(int i) {
        this.bKq = i;
    }

    public int aeq() {
        return this.bKq;
    }

    public String aer() {
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

    public List<PbContent> aes() {
        return this.bLL;
    }

    public void U(List<PbContent> list) {
        this.bLM = list;
    }

    public void V(List<PbContent> list) {
        this.bLN = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void hj(int i) {
        this.reply_num = i;
    }

    public int aet() {
        return this.reply_num;
    }

    public int aeu() {
        return this.bKx;
    }

    public void hk(int i) {
        this.bKx = i;
    }

    public long aev() {
        return this.bKy;
    }

    public void ar(long j) {
        this.bKy = j;
    }

    public int aew() {
        return this.bKA;
    }

    public int aex() {
        return this.bKz;
    }

    public void hl(int i) {
        this.bKz = i;
    }

    public int aey() {
        return this.bKB;
    }

    public void hm(int i) {
        this.bKB = i;
    }

    public int aez() {
        return this.bKC;
    }

    public List<PbContent> aeA() {
        return this.bLM;
    }

    public bl aeB() {
        return this.bKD;
    }

    public MetaData aeC() {
        return this.bKE;
    }

    public boolean aeD() {
        return this.is_god != 0;
    }

    public boolean aeE() {
        return this.is_god == 1;
    }

    public boolean aeF() {
        return (this.bKE == null || this.bKE.getGodUserData() == null || this.bKE.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aeG() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bKE = metaData;
    }

    public String aeH() {
        return this.forum_name;
    }

    public void mB(String str) {
        this.forum_name = str;
    }

    public int aeI() {
        return this.bKH;
    }

    public String aeJ() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bKJ;
    }

    public void mC(String str) {
        this.bKJ = str;
    }

    public String K(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bLN == null || this.bLN.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bLN.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bLN.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bLM == null || (size = this.bLM.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bLM.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString mD(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(K(str, true));
        if (this.bLN != null && (size = this.bLN.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLN.get(i2);
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
                                bh.this.mH(pbContent.link);
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

    public int aeK() {
        return this.bKO;
    }

    public void hn(int i) {
        this.bKO = i;
    }

    public String aeL() {
        return this.bKP;
    }

    public void mE(String str) {
        this.bKP = str;
    }

    public ArrayList<MediaData> aeM() {
        return this.bKK;
    }

    public ArrayList<b> aeN() {
        return this.bLi;
    }

    public void q(ArrayList<b> arrayList) {
        this.bLi = arrayList;
    }

    public bq aeO() {
        return this.bLj;
    }

    public g aeP() {
        return this.bLk;
    }

    public ArrayList<VoiceData.VoiceModel> aeQ() {
        return this.bKL;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aeR() {
        return this.bKU;
    }

    public void ho(int i) {
        this.bKU = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aeS() {
        return this.bLf;
    }

    public VideoInfo aeT() {
        return this.bKZ;
    }

    public VideoDesc aeU() {
        return this.bLa;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bLc = alaInfoData;
    }

    public AlaInfoData aeV() {
        return this.bLc;
    }

    public PushStatusData aeW() {
        return this.bLD;
    }

    public SkinInfo aeX() {
        return this.bLF;
    }

    public long aeY() {
        return this.bLV;
    }

    public boolean aeZ() {
        return this.bLW;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acC() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acD() {
        return this.bLX;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acE() {
        if (this.bIk == null || this.bIk.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acC().getTid());
        ajVar.setFid(acC().getFid());
        ajVar.b(this.bIk);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bKV = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bKN = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bLd = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bKw = threadInfo.repost_num.intValue();
                this.bKx = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bKy = threadInfo.last_time_int.intValue();
                this.bKz = threadInfo.is_top.intValue();
                this.bKA = threadInfo.is_membertop.intValue();
                this.bKB = threadInfo.is_good.intValue();
                this.bKC = threadInfo.is_livepost.intValue();
                this.bKD.a(threadInfo.topic);
                this.bKE.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bKF = threadInfo.fname;
                this.bKG = threadInfo.has_commented.intValue();
                this.bKH = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bKZ = threadInfo.video_info;
                this.bLa = threadInfo.video_segment;
                this.bLc = new AlaInfoData();
                this.bLc.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bKO = threadInfo.collect_status.intValue();
                this.bKP = threadInfo.collect_mark_pid;
                this.bKQ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bKT = threadInfo.first_post_id + "";
                this.bLf = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bKU = threadInfo.is_ntitle.intValue();
                this.bKW = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bMj = threadInfo.agree.has_agree.intValue();
                    this.bMk = threadInfo.agree.agree_type.intValue();
                    this.bMh = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bMi = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bMh;
                    this.agreeData.disAgreeNum = this.bMi;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bMm = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bKX = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bLO = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bLM = threadInfo.rich_title;
                this.bLL = threadInfo.first_post_content;
                this.bLN = threadInfo.rich_abstract;
                this.bKM = threadInfo.is_godthread_recommend.intValue();
                if ((this.bKE == null || this.bKE.getUserId() == null || this.bKE.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bKE = metaData;
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
                this.bKJ = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bKK.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bKZ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bLb = new bn();
                    this.bLb.a(threadInfo.video_channel_info);
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
                        this.bKL.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bLi.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bLj = new bq();
                    this.bLj.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bLk = new g();
                    this.bLk.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bLl = new o();
                    this.bLl.a(threadInfo.cartoon_info);
                }
                this.bKR.setUserMap(this.userMap);
                this.bKR.parserProtobuf(threadInfo.zan);
                this.bKS.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKR.setTitle(this.title);
                } else {
                    this.bKR.setTitle(this.bKJ);
                }
                this.bLo = threadInfo.livecover_src;
                this.bLp = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bLh = threadInfo.post_num.intValue();
                this.bLs = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jY(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.pU(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bKY.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bLq = noticeInfo.notice;
                    }
                    this.bLv = zhiBoInfoTW.copythread_remind.intValue();
                    this.bLt = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bLu = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bLo)) {
                        this.bLo = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bLA = zhiBoInfoTW.user.tw_anchor_info;
                        this.bLB = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bLr = threadInfo.twzhibo_info.livecover_status;
                    this.bLs = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bLw = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bLz.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bLC.add(cVar);
                    }
                }
                this.bLD.parserProtobuf(threadInfo.push_status);
                this.bLI = threadInfo.lego_card;
                this.bLF = threadInfo.skin_info;
                this.bLJ = threadInfo.is_book_chapter.intValue();
                this.bLK.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bLX = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bLV = threadInfo.last_read_pid.longValue();
                this.bLW = threadInfo.cheak_repeat.intValue() == 1;
                this.bMa = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bMl.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.Z(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bIk = sparseArray;
                }
                this.bMg = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bMn = new af();
                    this.bMn.a(threadInfo.link_info);
                }
                this.bMo = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bMp = new f();
                    this.bMp.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bMq = new MediaData();
                    this.bMq.parserProtobuf(threadInfo.pic_info);
                }
                this.bLQ = threadInfo.is_called.intValue();
                this.bMr = threadInfo.middle_page_num.intValue();
                this.bMs = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bMu = threadInfo.star_rank_icon.icon_pic_url;
                    this.bMv = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bMt = new OriginalThreadInfo();
                    this.bMt.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bMt = new OriginalThreadInfo();
                    this.bMt.parser(threadInfo.origin_thread_info);
                } else {
                    this.bMt = null;
                }
                this.bMw = threadInfo.is_topic.intValue();
                this.bMy = threadInfo.topic_user_name;
                this.bMz = threadInfo.topic_h5_url;
                this.bMx = threadInfo.topic_module;
                this.bMB = threadInfo.presentation_style;
                this.bMD = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bMF = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bKt = new bd();
                    this.bKt.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bMH = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMH, this);
                }
                this.bMS = threadInfo.t_share_img;
                afa();
                this.bMT = threadInfo.is_headlinepost.intValue() == 1;
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
                this.bLd = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bKw = jSONObject.optInt("repost_num", 0);
                this.bKx = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.bKy = jSONObject.optLong("last_time_int", 0L);
                this.bKz = jSONObject.optInt("is_top", 0);
                this.bKA = jSONObject.optInt("is_membertop", 0);
                this.bKB = jSONObject.optInt("is_good", 0);
                this.bKC = jSONObject.optInt("is_livepost", 0);
                this.bKD.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bKE.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bKF = this.forum_name;
                this.bKG = jSONObject.optInt("has_commented", 0);
                this.bKH = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bKO = jSONObject.optInt("collect_status");
                this.bKP = jSONObject.optString("collect_mark_pid");
                this.bKQ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bMh = jSONObject.optInt("agree_num");
                this.bMm = jSONObject.optLong("share_num");
                this.bKT = jSONObject.optString("first_post_id", "0");
                this.bLf = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.bKU = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bMj = optJSONObject2.optInt("has_agree");
                    this.bMh = optJSONObject2.optInt("agree_num");
                    this.bMi = optJSONObject2.optLong("disagree_num");
                    this.bMk = optJSONObject2.optInt("agree_type");
                    if (this.bMh < 0) {
                        this.bMh = 0L;
                    }
                    if (this.bMi < 0) {
                        this.bMi = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bMh;
                    this.agreeData.disAgreeNum = this.bMi;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bLz.parserJson(optJSONObject3);
                }
                if ((this.bKE == null || this.bKE.getUserId() == null) && this.userMap != null) {
                    this.bKE = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bLc = new AlaInfoData();
                this.bLc.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bKJ = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bKK.add(mediaData);
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
                        this.bKL.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bLi.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bLj = new bq();
                    this.bLj.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bLk = new g();
                    this.bLk.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bLl = new o();
                    this.bLl.parserJson(optJSONObject7);
                }
                this.bKR.setUserMap(this.userMap);
                this.bKR.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bKS.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bKR.setTitle(this.title);
                } else {
                    this.bKR.setTitle(this.bKJ);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bLz.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bLC.add(cVar);
                    }
                }
                this.bLJ = jSONObject.optInt("is_book_chapter", 0);
                this.bLK.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bLX = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bLR = jSONObject.optString("recom_extra_img");
                this.bLU = jSONObject.optString("recom_extra_img_night");
                this.bLS = jSONObject.optInt("recom_extra_img_width", 0);
                this.bLT = jSONObject.optInt("recom_extra_img_height", 0);
                this.bLV = jSONObject.optLong("last_read_pid");
                this.bLW = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bLb = new bn();
                    this.bLb.aV(optJSONObject9);
                }
                this.bMg = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bMn = new af();
                    this.bMn.parserJson(optJSONObject10);
                }
                this.bMo = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bMp = new f();
                    this.bMp.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bMq = new MediaData();
                    this.bMq.parserJson(optJSONObject12);
                }
                this.bLQ = jSONObject.optInt("is_called", 0);
                this.bMr = jSONObject.optInt("middle_page_num", 0);
                this.bMs = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject13 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject13 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject13.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject13.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject13.optString("video_md5");
                    builder.video_url = optJSONObject13.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject13.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject13.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject13.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject13.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject13.optInt("video_type", 0));
                    builder.thumbnail_url = optJSONObject13.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject13.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject13.optInt("is_vertical", 0));
                    builder.mcn_lead_page = new String(optJSONObject13.optString("mcn_lead_page"));
                    this.bKZ = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bMt = new OriginalThreadInfo();
                        this.bMt.parserJson(optJSONObject14);
                    } else {
                        this.bMt = null;
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
                    this.bMH = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bMH, this);
                }
                this.bMS = jSONObject.optString("t_share_img");
                afa();
                this.bMT = jSONObject.optInt("is_headlinepost", 0) == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void afa() {
        afb();
        afc();
        afd();
        afe();
        aff();
        afg();
        afh();
    }

    private void afb() {
        if (!StringUtils.isNull(this.bKE.getName_show())) {
            this.bMJ = com.baidu.tbadk.core.util.aq.j(this.bKE.getName_show(), 14, "...");
        }
    }

    private void afc() {
        if (aeG()) {
            this.bMK = com.baidu.tbadk.core.util.aq.aE(aev() * 1000);
        } else if (agt()) {
            String aE = com.baidu.tbadk.core.util.aq.aE(aev() * 1000);
            if (com.baidu.tbadk.core.util.aq.ob(aE)) {
                aE = com.baidu.tbadk.core.util.aq.aF(aev() * 1000);
            }
            this.bMK = TbadkCoreApplication.getInst().getApp().getString(R.string.post_when) + aE;
        } else {
            String aE2 = com.baidu.tbadk.core.util.aq.aE(aev() * 1000);
            if (com.baidu.tbadk.core.util.aq.ob(aE2)) {
                aE2 = com.baidu.tbadk.core.util.aq.aF(aev() * 1000);
            }
            this.bMK = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + aE2;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bMK += " • " + getAddress();
        }
    }

    private void afd() {
        if (aeV() == null || aeV().share_info == null || aeV().share_info.share_user_count <= 0 || !afQ() || (this.bMr > 0 && this.bMs == 0)) {
            this.bML = null;
            return;
        }
        int i = aeV().share_info.share_user_count;
        if (i == 1) {
            this.bML = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.bML = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.aI(i)});
        }
    }

    private void afe() {
        this.bMM = agc();
    }

    private void aff() {
        this.bMN = agd();
    }

    private void afg() {
        this.bMO = com.baidu.tbadk.core.util.aq.aF(aev() * 1000);
    }

    private void afh() {
        this.bMP = com.baidu.tbadk.core.util.aq.aF(aev());
    }

    public SpannableStringBuilder afi() {
        return this.bKI;
    }

    public boolean afj() {
        return aex() != 0;
    }

    public int afk() {
        if (this.bLz != null) {
            long adV = this.bLz.adV();
            long adW = this.bLz.adW();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < adV) {
                return 1;
            }
            if (currentTimeMillis > adW) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int afl() {
        if (afn() && this.bLi.size() >= 1) {
            b bVar = this.bLi.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int acH = bVar.acH();
            int acI = bVar.acI();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < acH) {
                return 4;
            }
            return currentTimeMillis > acI ? 2 : 1;
        }
        return -1;
    }

    public int afm() {
        if (!afn() || this.bLi.size() < 1 || this.bLi.get(0) == null) {
            return -1;
        }
        return this.bLi.get(0).acG();
    }

    public boolean afn() {
        return this.bKW == 1;
    }

    public String getActUrl() {
        return (!afn() || this.bLi.size() < 1 || this.bLi.get(0) == null) ? "" : this.bLi.get(0).getUrl();
    }

    private com.baidu.adp.widget.b mF(String str) {
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

    public SmartApp afo() {
        return this.bMH;
    }

    private void l(boolean z, boolean z2) {
        SpannableString spannableString;
        String K = K(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && afq()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aex() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aex() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aez() == 1 || this.bKD.agD() != 0) {
                if (aei() != null && getThreadType() == 41) {
                    if (afk() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && afC()) {
                Integer num = bLn.get(Integer.valueOf(afk()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aey() == 1 && !afj() && bKa != getType() && bKf != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.bKS != null && this.bKS.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aeI() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = bLm.get(new Point(afm(), afl()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aeO() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aeP() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = mF(this.category_name);
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
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bKs));
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
        this.bKI = spannableStringBuilder;
    }

    public boolean afp() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aeC() != null) {
            if (aeC().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aeC().getGender() == 2) {
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

    private boolean afq() {
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
        this.bKI = spannableStringBuilder;
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
            if (this.bKU == 1) {
                this.bKI = a;
                return a;
            }
        } else if (this.bKU == 1) {
            this.bKI = new SpannableStringBuilder();
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
        this.bLE = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a V;
        com.baidu.adp.widget.ImageView.a V2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bLE) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.atK().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.e.v.U(this.mUrl, 10)) && (V = com.baidu.tbadk.core.util.e.v.V(this.mUrl, 10)) != null) {
                bitmap = V.nK();
                com.baidu.tbadk.imageManager.c.atK().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.atK().getBitmap(this.bLE);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.e.v.U(this.bLE, 10)) && (V2 = com.baidu.tbadk.core.util.e.v.V(this.bLE, 10)) != null) {
                bitmap2 = V2.nK();
                com.baidu.tbadk.imageManager.c.atK().e(this.bLE, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bKs));
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
                        com.baidu.tbadk.imageManager.c.atK().e(str2, aVar.nK());
                    }
                }
            }, bJY);
            com.baidu.adp.lib.f.c.iE().a(this.bLE, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bh.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.atK().e(str2, aVar.nK());
                    }
                }
            }, bJY);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bLM != null && this.bLM.size() > 0) {
            int size = this.bLM.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bLM.get(i2);
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
                                bh.this.mH(pbContent.link);
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

    private String mG(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData afr() {
        if (this.bLM != null && this.bLM.size() > 0) {
            int size = this.bLM.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bLM.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && afw() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = mG(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.bKq;
            kVar.crU = this.bKr;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void afs() {
        l(false, false);
    }

    public void aft() {
        l(false, true);
    }

    public AnchorInfoData afu() {
        return this.bKS;
    }

    public boolean afv() {
        return this.threadType == 36;
    }

    public boolean afw() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean afx() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aeM = aeM();
        if (aeM == null || afj()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aeM.size() || i2 >= 3) {
                break;
            }
            if (aeM.get(i2) != null && aeM.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aeM.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aeM.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aeM.get(i2).getPicUrl();
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
        if (this.bKZ != null && !StringUtils.isNull(this.bKZ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bKZ.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bKE != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bKE.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean afy() {
        String userId;
        return this.bKE == null || (userId = this.bKE.getUserId()) == null || userId.equals("0");
    }

    public boolean afz() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (agq()) {
            if (aeT() != null) {
                return bKa;
            }
            return bJM;
        }
        int aex = aex();
        if (this.bMw == 1) {
            if (this.bMx != null) {
                return bJX;
            }
            return this.bMA != null ? bKh : bKg;
        } else if (this.bKZ != null && agh()) {
            return bKp;
        } else {
            if (this.bLc != null && this.threadType == 60) {
                return bKd;
            }
            if (this.bLc != null && this.threadType == 49) {
                return bKb;
            }
            if (this.threadType == 51) {
                return bKc;
            }
            if (this.threadType == 63) {
                return bKi;
            }
            if (this.threadType == 64) {
                return bKj;
            }
            if (aex == 2 || aex == 1) {
                return bJL;
            }
            if (this.bKZ != null && afI() && !afz()) {
                return bKo;
            }
            if (this.bKZ != null && !afz()) {
                if (aeF()) {
                    return bKf;
                }
                return bKa;
            } else if (this.isShareThread) {
                return bKe;
            } else {
                if (afB()) {
                    return bKl.get() ? bLy : bJM;
                } else if (afn() && afm() == 1) {
                    return bKl.get() ? bLG : bJM;
                } else if (isLinkThread()) {
                    return bJY;
                } else {
                    if (aeF()) {
                        return bJZ;
                    }
                    if (this.bJz) {
                        return bJQ;
                    }
                    if (this.bJA) {
                        return bJR;
                    }
                    if (this.bJB) {
                        return bJS;
                    }
                    if (this.bJC) {
                        return bJT;
                    }
                    if (this.bJD) {
                        return bJU;
                    }
                    if (this.bJE) {
                        return bJV;
                    }
                    if (this.bJF) {
                        return bJW;
                    }
                    if (this.bLg) {
                        int afA = afA();
                        if (afA == 1) {
                            return bJN;
                        }
                        if (afA == 2) {
                            return bJO;
                        }
                        if (afA > 2) {
                            return bJP;
                        }
                        return bJM;
                    }
                    return bJM;
                }
            }
        }
    }

    public int afA() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.ace().aci() || com.baidu.tbadk.core.util.v.Z(aeM()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aeM().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeM(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean afB() {
        return aei() != null && getThreadType() == 41 && aez() == 1 && afk() == 2;
    }

    public void r(ArrayList<p> arrayList) {
        if (this.bKU == 1) {
            this.bGH = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bGH = 0;
        } else {
            this.bGH = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.acO() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.acO().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bGH = next.acP();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean afC() {
        return this.threadType == 41;
    }

    public boolean afD() {
        return this.bLH;
    }

    public void dJ(boolean z) {
        this.bLH = z;
    }

    public String afE() {
        return this.bLI;
    }

    public o afF() {
        return this.bLl;
    }

    public void afG() {
        if (this.bLe == 0) {
            this.bLe = 1;
        }
    }

    public boolean afH() {
        return this.bLO;
    }

    public void dK(boolean z) {
        this.bLY = z;
    }

    public boolean afI() {
        return this.bLY;
    }

    public void hp(int i) {
        this.bLZ = i + 1;
    }

    public int afJ() {
        return this.bLZ;
    }

    public List<ReportInfo> afK() {
        return this.bMa;
    }

    public boolean afL() {
        return this.bLP;
    }

    public void dL(boolean z) {
        this.bLP = z;
    }

    public bn afM() {
        return this.bLb;
    }

    public void a(bn bnVar) {
        this.bLb = bnVar;
    }

    public void setCurrentPage(int i) {
        if (this.bLb != null) {
            this.bLb.mCurrentPage = i;
        }
    }

    public boolean afN() {
        return getThreadType() == 49;
    }

    public boolean afO() {
        return getThreadType() == 40;
    }

    public boolean afP() {
        return getThreadType() == 50;
    }

    public boolean afQ() {
        return getThreadType() == 60;
    }

    public boolean afR() {
        return getThreadType() == 40 && afM() != null && afM().channelId > 0;
    }

    public int afS() {
        return this.bMf;
    }

    public void setSmartFrsPosition(int i) {
        this.bMf = i;
    }

    public SparseArray<String> adl() {
        return this.bIk;
    }

    public String afT() {
        return this.mRecomSource;
    }

    public boolean afU() {
        return this.bMg;
    }

    public long afV() {
        return this.bMh;
    }

    public long afW() {
        return this.bMi;
    }

    public int afX() {
        return this.bMj;
    }

    public int afY() {
        return this.bMk;
    }

    public void hq(int i) {
        this.bMj = i;
    }

    public void hr(int i) {
        this.bMh = i;
    }

    public void as(long j) {
        this.bMh = j;
    }

    public void at(long j) {
        this.bMi = j;
    }

    public void hs(int i) {
        this.bMk = i;
    }

    public long afZ() {
        return this.bMm;
    }

    public void au(long j) {
        this.bMm = j;
    }

    public PostData aga() {
        return this.bMl;
    }

    public af agb() {
        return this.bMn;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String K;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bKU == 1) {
            K = K(this.bKJ, true);
            a = mD(this.bKJ);
        } else {
            K = K(this.title, false);
            a = a(new SpannableString(K + " "));
        }
        if (z) {
            spannableStringBuilder = a(K, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bKI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder n(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder o(boolean z, boolean z2) {
        SpannableString mD;
        if (!StringUtils.isNull(this.title) && this.bKU != 1) {
            mD = a(new SpannableString(K(this.title, false) + " "));
        } else {
            mD = mD(this.bKJ);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(mD);
        this.bKI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder agc() {
        if (StringUtils.isNull(this.title) || this.bKU == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(K(this.title, false) + " ")));
        this.bKI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString agd() {
        return mD(this.bKJ);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean aeD = aeD();
        if (z2) {
            if (z) {
                if (aeD && !afw()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if (aez() == 1 || getThreadType() == 33 || (aeB() != null && aeB().agD() != 0)) {
                    if (aei() != null && afC()) {
                        if (afk() == 2) {
                            arrayList.add(new n.a((int) R.string.interview_live));
                        }
                    } else if (!aeD) {
                        arrayList.add(new n.a((int) R.string.photo_live_tips));
                    }
                }
                if (afC()) {
                    arrayList.add(bMc.get(afk()));
                }
                if (afn()) {
                    Integer num = bMb.get(new Point(afm(), afl()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (aeO() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (aeD && aex() != 1 && !afw()) {
                    arrayList.add(new n.a((int) R.string.god_title));
                }
                if ((aez() == 1 || getThreadType() == 33) && !afC() && !aeD) {
                    arrayList.add(new n.a((int) R.string.photo_live_tips));
                }
                if (aey() == 1) {
                    arrayList.add(new n.a((int) R.string.good));
                }
                if (aex() == 1) {
                    arrayList.add(new n.a((int) R.string.top));
                }
                if (afC() && aei() != null && afk() == 2) {
                    arrayList.add(new n.a((int) R.string.interview_live));
                }
                if (afn()) {
                    Integer num2 = bMb.get(new Point(afm(), afl()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.bLJ == 1) {
                    arrayList.add(new n.a((int) R.string.card_tbread_text));
                }
                if (aeP() != null) {
                    arrayList.add(new n.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aeO() != null) {
                    arrayList.add(new n.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && afN()) {
                    arrayList.add(new n.a((int) R.string.ala_live));
                }
                if (afR()) {
                    arrayList.add(new n.a((int) R.string.frs_channel_tip));
                } else if (z3 && afP()) {
                    arrayList.add(new n.a((int) R.string.live_record));
                } else if (afO()) {
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
        this.bKK = arrayList;
    }

    public String age() {
        return this.bMy;
    }

    public void mI(String str) {
        this.bMy = str;
    }

    public void agf() {
        this.bMw = 1;
    }

    public boolean agg() {
        return this.bMw == 1;
    }

    public boolean agh() {
        return this.bMB.equals("worldcupvideo");
    }

    public String agi() {
        return this.bKu;
    }

    public void mJ(String str) {
        this.bKu = str;
    }

    public String agj() {
        return this.bKv;
    }

    public void mK(String str) {
        this.bKv = str;
    }

    public String agk() {
        return this.bMz;
    }

    public void mL(String str) {
        this.bMz = str;
    }

    public boolean agl() {
        return this.bMC;
    }

    public void dM(boolean z) {
        this.bMC = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bMA = videoInfo;
    }

    public boolean agm() {
        return this.bMD != null;
    }

    public String agn() {
        return this.bKF;
    }

    public String ago() {
        return this.bMF;
    }

    public bd agp() {
        return this.bKt;
    }

    public boolean agq() {
        return this.bMG;
    }

    public void dN(boolean z) {
        this.bMG = z;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.bKZ != null) {
            return this.bKZ.video_url;
        }
        return null;
    }

    public boolean agr() {
        return this.bMI;
    }

    public void dO(boolean z) {
        this.bMI = z;
    }

    public AgreeData ags() {
        return this.agreeData;
    }

    public boolean agt() {
        return this.bMR;
    }

    public void dP(boolean z) {
        this.bMR = z;
    }

    public TopicModule agu() {
        return this.bMx;
    }

    public String getShareImageUrl() {
        return this.bMS;
    }

    void a(SmartApp smartApp, bh bhVar) {
        if (smartApp != null && bhVar != null) {
            MetaData aeC = bhVar.aeC();
            if (com.baidu.tbadk.core.util.aq.isEmpty(smartApp.name)) {
                aeC.setName_show(TbadkCoreApplication.getInst().getString(R.string.ai_smart_app));
            } else {
                aeC.setName_show(smartApp.name);
            }
            aeC.setPortrait(smartApp.avatar);
        }
    }

    public int[] agv() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aeM = aeM();
        if (com.baidu.tbadk.core.i.ace().aci() && com.baidu.tbadk.core.util.v.Z(aeM) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aeM.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeM, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(aeM, 0);
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

    public int[] agw() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aeM = aeM();
        if (com.baidu.tbadk.core.i.ace().aci() && com.baidu.tbadk.core.util.v.Z(aeM) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aeM.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(aeM, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.c(aeM, 0);
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

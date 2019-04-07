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
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
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
    private String bBA;
    private String bBK;
    private SpannableStringBuilder bBN;
    public int bBR;
    private int bBS;
    private int bBV;
    private String bBY;
    private int bBZ;
    private bc bBy;
    private String bBz;
    public TwZhiBoUser bCF;
    public List<TwAnchorProfitItem> bCG;
    private String bCJ;
    private SkinInfo bCK;
    private boolean bCM;
    private String bCN;
    private boolean bCT;
    private boolean bCU;
    public String bCW;
    public int bCX;
    public int bCY;
    public String bCZ;
    private String bCa;
    private int bCc;
    private VideoInfo bCe;
    private VideoDesc bCf;
    private bm bCg;
    private AlaInfoData bCh;
    private long bCi;
    private o bCq;
    private LiveCoverStatus bCw;
    private long bCx;
    private String bDC;
    private String bDD;
    private VideoInfo bDE;
    private String bDF;
    public OriginalForumInfo bDH;
    public boolean bDI;
    private String bDJ;
    private boolean bDK;
    private SmartApp bDL;
    private String bDN;
    private String bDO;
    private String bDP;
    private SpannableStringBuilder bDQ;
    private SpannableString bDR;
    private String bDS;
    private String bDT;
    public int bDU;
    public long bDa;
    public String bDc;
    private List<ReportInfo> bDf;
    private boolean bDl;
    private int bDo;
    private int bDp;
    private long bDr;
    private af bDs;
    public f bDu;
    private MediaData bDv;
    public int bDw;
    public OriginalThreadInfo bDy;
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
    public static final BdUniqueId bAS = BdUniqueId.gen();
    public static final BdUniqueId bAT = BdUniqueId.gen();
    public static final BdUniqueId bAU = BdUniqueId.gen();
    public static final BdUniqueId bAV = BdUniqueId.gen();
    public static final BdUniqueId bAW = BdUniqueId.gen();
    public static final BdUniqueId bAX = BdUniqueId.gen();
    public static final BdUniqueId bAY = BdUniqueId.gen();
    public static final BdUniqueId bAZ = BdUniqueId.gen();
    public static final BdUniqueId bBa = BdUniqueId.gen();
    public static final BdUniqueId bBb = BdUniqueId.gen();
    public static final BdUniqueId bBc = BdUniqueId.gen();
    public static final BdUniqueId bBd = BdUniqueId.gen();
    public static final BdUniqueId bBe = BdUniqueId.gen();
    public static final BdUniqueId bBf = BdUniqueId.gen();
    public static final BdUniqueId bBg = BdUniqueId.gen();
    public static final BdUniqueId bBh = BdUniqueId.gen();
    public static final BdUniqueId bBi = BdUniqueId.gen();
    public static final BdUniqueId bBj = BdUniqueId.gen();
    public static final BdUniqueId bBk = BdUniqueId.gen();
    public static final BdUniqueId bBl = BdUniqueId.gen();
    public static final BdUniqueId bBm = BdUniqueId.gen();
    public static final BdUniqueId bBn = BdUniqueId.gen();
    public static final BdUniqueId bBo = BdUniqueId.gen();
    public static final BdUniqueId bBp = BdUniqueId.gen();
    public static AtomicBoolean bBq = new AtomicBoolean(false);
    public static AtomicBoolean bBr = new AtomicBoolean(false);
    public static AtomicBoolean bBs = new AtomicBoolean(false);
    public static final BdUniqueId bBt = BdUniqueId.gen();
    public static final BdUniqueId bBu = BdUniqueId.gen();
    private static HashMap<Point, Integer> bCr = new HashMap<>();
    private static HashMap<Integer, Integer> bCs = new HashMap<>();
    public static final BdUniqueId bCC = BdUniqueId.gen();
    public static final BdUniqueId bCD = BdUniqueId.gen();
    public static final BdUniqueId bCL = BdUniqueId.gen();
    private static HashMap<Point, Integer> bDg = new HashMap<>();
    private static SparseArray<n.a> bDh = new SparseArray<>(3);
    public boolean bAI = false;
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean bAM = false;
    public boolean bAN = false;
    public boolean bAO = false;
    private int bBv = 0;
    private String bBw = "1";
    public int bBx = 1;
    private String bBU = null;
    private int bxU = 0;
    public int bCj = 0;
    private String bCk = "";
    public boolean bCl = false;
    private String bCt = "";
    public boolean bDb = true;
    public boolean bDi = false;
    public boolean bDj = false;
    private int bDk = -1;
    public SparseArray<String> bzx = null;
    public boolean bDt = false;
    private int bDB = 0;
    private boolean bDG = false;
    private boolean bDM = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bBB = 0;
    private int bBC = 0;
    private String last_time = null;
    private long bBD = 0;
    private int bBE = 0;
    private int bBF = 0;
    private int bBG = 0;
    private int bBH = 0;
    private bk bBI = new bk();
    private MetaData bBJ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bBP = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bBQ = new ArrayList<>();
    private int bBL = 0;
    private int bBM = 0;
    private String ad_url = null;
    private String bBO = null;
    private String from = null;
    private int bBT = 0;
    private PraiseData bBW = new PraiseData();
    private AnchorInfoData bBX = new AnchorInfoData();
    private long time = 0;
    private int bCb = 0;
    private ArrayList<b> bCn = new ArrayList<>();
    private bp bCo = null;
    private g bCp = null;
    private int bCu = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bCd = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bCv = null;
    private int bCm = 0;
    private boolean bCy = false;
    private boolean bCz = false;
    private int bCA = 0;
    private boolean bCB = false;
    private int anchorLevel = 0;
    public int bCO = 0;
    public l bCP = new l();
    private List<PbContent> bCQ = new ArrayList();
    private List<PbContent> bCR = new ArrayList();
    private List<PbContent> bCS = new ArrayList();
    private String category_name = null;
    private be bCE = new be();
    private ArrayList<com.baidu.tbadk.data.c> bCH = new ArrayList<>();
    private PushStatusData bCI = new PushStatusData();
    public boolean bDd = false;
    public int bDe = -1;
    private long bDm = 0;
    private long bDn = 0;
    private PostData bDq = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bCV = 0;
    public int bDx = 0;
    private String tieba_game_information_source = "";
    public String bDA = "";
    public String bDz = "";

    static {
        bCr.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        bCr.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        bCr.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        bCr.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        bCr.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        bCr.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        bCr.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        bCr.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        bDg.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        bDg.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        bDg.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        bDg.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        bDg.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        bDg.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        bDg.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        bDg.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        bCs.put(1, Integer.valueOf(d.f.label_interview_no));
        bCs.put(2, Integer.valueOf(d.f.label_interview_live));
        bCs.put(3, Integer.valueOf(d.f.label_interview_off));
        bDh.put(1, new n.a(d.j.interview_live_status_not_start, d.C0277d.cp_other_b, d.f.pic_dot_title_red));
        bDh.put(2, new n.a(d.j.interview_live_status_ing, d.C0277d.cp_other_c, d.f.pic_dot_title_green));
        bDh.put(3, new n.a(d.j.interview_live_status_over, d.C0277d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bg() {
        this.bBS = 0;
        this.bCc = 0;
        this.bCx = 0L;
        this.mUrl = "";
        this.bCJ = "";
        this.bDw = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bCx = 0L;
        this.bCc = 0;
        this.bBS = 0;
        this.bDw = 0;
        this.mUrl = "";
        this.bCJ = "";
        this.isBigGie = false;
    }

    public String Ym() {
        return this.bDN;
    }

    public String Yn() {
        return this.bDO;
    }

    public void li(String str) {
        this.bDO = str;
    }

    public String Yo() {
        return this.bDP;
    }

    public SpannableStringBuilder Yp() {
        return this.bDQ;
    }

    public SpannableString Yq() {
        return this.bDR;
    }

    public String Yr() {
        return this.bDS;
    }

    public String Ys() {
        return this.bDT;
    }

    public boolean Yt() {
        return this.bBS == 1;
    }

    public be Yu() {
        return this.bCE;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void gn(int i) {
        this.anchorLevel = i;
    }

    public int Yv() {
        return this.bCV;
    }

    public void go(int i) {
        this.bCV = i;
    }

    public void gp(int i) {
        this.bCA = i;
    }

    public int Yw() {
        return this.bCA;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo Yx() {
        return this.bDE;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void ad(long j) {
        this.mCreateTime = j;
    }

    public long Yy() {
        return this.bCi;
    }

    public String Yz() {
        return this.bBY;
    }

    public PraiseData YA() {
        return this.bBW;
    }

    public void a(PraiseData praiseData) {
        this.bBW = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String YB() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void lj(String str) {
        this.bBw = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.bBv = i;
    }

    public int YC() {
        return this.bBv;
    }

    public String YD() {
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

    public List<PbContent> YE() {
        return this.bCQ;
    }

    public void N(List<PbContent> list) {
        this.bCR = list;
    }

    public void O(List<PbContent> list) {
        this.bCS = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void gq(int i) {
        this.reply_num = i;
    }

    public int YF() {
        return this.reply_num;
    }

    public int YG() {
        return this.bBC;
    }

    public void gr(int i) {
        this.bBC = i;
    }

    public long YH() {
        return this.bBD;
    }

    public void ae(long j) {
        this.bBD = j;
    }

    public int YI() {
        return this.bBF;
    }

    public int YJ() {
        return this.bBE;
    }

    public void gs(int i) {
        this.bBE = i;
    }

    public int YK() {
        return this.bBG;
    }

    public void gt(int i) {
        this.bBG = i;
    }

    public int YL() {
        return this.bBH;
    }

    public List<PbContent> YM() {
        return this.bCR;
    }

    public bk YN() {
        return this.bBI;
    }

    public MetaData YO() {
        return this.bBJ;
    }

    public boolean YP() {
        return this.is_god != 0;
    }

    public boolean YQ() {
        return this.is_god == 1;
    }

    public boolean YR() {
        return (this.bBJ == null || this.bBJ.getGodUserData() == null || this.bBJ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean YS() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bBJ = metaData;
    }

    public String YT() {
        return this.forum_name;
    }

    public void lk(String str) {
        this.forum_name = str;
    }

    public int YU() {
        return this.bBM;
    }

    public String YV() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bBO;
    }

    public void ll(String str) {
        this.bBO = str;
    }

    public String H(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bCS == null || this.bCS.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bCS.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bCS.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bCR == null || (size = this.bCR.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bCR.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString lm(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(H(str, true));
        if (this.bCS != null && (size = this.bCS.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCS.get(i2);
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
                                bg.this.lq(pbContent.link);
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

    public int YW() {
        return this.bBT;
    }

    public void gu(int i) {
        this.bBT = i;
    }

    public String YX() {
        return this.bBU;
    }

    public void ln(String str) {
        this.bBU = str;
    }

    public ArrayList<MediaData> YY() {
        return this.bBP;
    }

    public ArrayList<b> YZ() {
        return this.bCn;
    }

    public void n(ArrayList<b> arrayList) {
        this.bCn = arrayList;
    }

    public bp Za() {
        return this.bCo;
    }

    public g Zb() {
        return this.bCp;
    }

    public ArrayList<VoiceData.VoiceModel> Zc() {
        return this.bBQ;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int Zd() {
        return this.bBZ;
    }

    public void gv(int i) {
        this.bBZ = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String Ze() {
        return this.bCk;
    }

    public VideoInfo Zf() {
        return this.bCe;
    }

    public VideoDesc Zg() {
        return this.bCf;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bCh = alaInfoData;
    }

    public AlaInfoData Zh() {
        return this.bCh;
    }

    public PushStatusData Zi() {
        return this.bCI;
    }

    public SkinInfo Zj() {
        return this.bCK;
    }

    public long Zk() {
        return this.bDa;
    }

    public boolean Zl() {
        return this.bDb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WO() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        return this.bDc;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WQ() {
        if (this.bzx == null || this.bzx.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WO().getTid());
        ajVar.setFid(WO().getFid());
        ajVar.b(this.bzx);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bCa = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bBS = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bCi = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bBB = threadInfo.repost_num.intValue();
                this.bBC = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bBD = threadInfo.last_time_int.intValue();
                this.bBE = threadInfo.is_top.intValue();
                this.bBF = threadInfo.is_membertop.intValue();
                this.bBG = threadInfo.is_good.intValue();
                this.bBH = threadInfo.is_livepost.intValue();
                this.bBI.a(threadInfo.topic);
                this.bBJ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bBK = threadInfo.fname;
                this.bBL = threadInfo.has_commented.intValue();
                this.bBM = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bCe = threadInfo.video_info;
                this.bCf = threadInfo.video_segment;
                this.bCh = new AlaInfoData();
                this.bCh.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bBT = threadInfo.collect_status.intValue();
                this.bBU = threadInfo.collect_mark_pid;
                this.bBV = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bBY = threadInfo.first_post_id + "";
                this.bCk = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bBZ = threadInfo.is_ntitle.intValue();
                this.bCb = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bDo = threadInfo.agree.has_agree.intValue();
                    this.bDp = threadInfo.agree.agree_type.intValue();
                    this.bDm = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bDn = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bDm;
                    this.agreeData.disAgreeNum = this.bDn;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bDr = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bCc = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bCT = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bCR = threadInfo.rich_title;
                this.bCQ = threadInfo.first_post_content;
                this.bCS = threadInfo.rich_abstract;
                this.bBR = threadInfo.is_godthread_recommend.intValue();
                if ((this.bBJ == null || this.bBJ.getUserId() == null || this.bBJ.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBJ = metaData;
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
                this.bBO = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bBP.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bCe = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bCg = new bm();
                    this.bCg.a(threadInfo.video_channel_info);
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
                        this.bBQ.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bCn.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bCo = new bp();
                    this.bCo.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bCp = new g();
                    this.bCp.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bCq = new o();
                    this.bCq.a(threadInfo.cartoon_info);
                }
                this.bBW.setUserMap(this.userMap);
                this.bBW.parserProtobuf(threadInfo.zan);
                this.bBX.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBW.setTitle(this.title);
                } else {
                    this.bBW.setTitle(this.bBO);
                }
                this.bCt = threadInfo.livecover_src;
                this.bCu = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bCm = threadInfo.post_num.intValue();
                this.bCx = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.ja(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.ok(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bCd.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bCv = noticeInfo.notice;
                    }
                    this.bCA = zhiBoInfoTW.copythread_remind.intValue();
                    this.bCy = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bCz = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bCt)) {
                        this.bCt = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bCF = zhiBoInfoTW.user.tw_anchor_info;
                        this.bCG = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bCw = threadInfo.twzhibo_info.livecover_status;
                    this.bCx = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bCB = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bCE.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bCH.add(cVar);
                    }
                }
                this.bCI.parserProtobuf(threadInfo.push_status);
                this.bCN = threadInfo.lego_card;
                this.bCK = threadInfo.skin_info;
                this.bCO = threadInfo.is_book_chapter.intValue();
                this.bCP.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bDc = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bDa = threadInfo.last_read_pid.longValue();
                this.bDb = threadInfo.cheak_repeat.intValue() == 1;
                this.bDf = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bDq.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.S(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bzx = sparseArray;
                }
                this.bDl = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bDs = new af();
                    this.bDs.a(threadInfo.link_info);
                }
                this.bDt = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bDu = new f();
                    this.bDu.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bDv = new MediaData();
                    this.bDv.parserProtobuf(threadInfo.pic_info);
                }
                this.bCV = threadInfo.is_called.intValue();
                this.bDw = threadInfo.middle_page_num.intValue();
                this.bDx = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bDz = threadInfo.star_rank_icon.icon_pic_url;
                    this.bDA = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bDy = new OriginalThreadInfo();
                    this.bDy.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bDy = new OriginalThreadInfo();
                    this.bDy.parser(threadInfo.origin_thread_info);
                } else {
                    this.bDy = null;
                }
                this.bDB = threadInfo.is_topic.intValue();
                this.bDC = threadInfo.topic_user_name;
                this.bDD = threadInfo.topic_h5_url;
                this.bDF = threadInfo.presentation_style;
                this.bDH = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bDJ = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bBy = new bc();
                    this.bBy.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bDL = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDL, this);
                }
                Zm();
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
                this.bCi = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bBB = jSONObject.optInt("repost_num", 0);
                this.bBC = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.bBD = jSONObject.optLong("last_time_int", 0L);
                this.bBE = jSONObject.optInt("is_top", 0);
                this.bBF = jSONObject.optInt("is_membertop", 0);
                this.bBG = jSONObject.optInt("is_good", 0);
                this.bBH = jSONObject.optInt("is_livepost", 0);
                this.bBI.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bBJ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bBK = this.forum_name;
                this.bBL = jSONObject.optInt("has_commented", 0);
                this.bBM = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bBT = jSONObject.optInt("collect_status");
                this.bBU = jSONObject.optString("collect_mark_pid");
                this.bBV = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bDm = jSONObject.optInt("agree_num");
                this.bDr = jSONObject.optLong("share_num");
                this.bBY = jSONObject.optString("first_post_id", "0");
                this.bCk = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bBZ = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bDo = optJSONObject2.optInt("has_agree");
                    this.bDm = optJSONObject2.optInt("agree_num");
                    this.bDn = optJSONObject2.optLong("disagree_num");
                    this.bDp = optJSONObject2.optInt("agree_type");
                    if (this.bDm < 0) {
                        this.bDm = 0L;
                    }
                    if (this.bDn < 0) {
                        this.bDn = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bDm;
                    this.agreeData.disAgreeNum = this.bDn;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bCE.parserJson(optJSONObject3);
                }
                if ((this.bBJ == null || this.bBJ.getUserId() == null) && this.userMap != null) {
                    this.bBJ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bCh = new AlaInfoData();
                this.bCh.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bBO = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bBP.add(mediaData);
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
                        this.bBQ.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bCn.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bCo = new bp();
                    this.bCo.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bCp = new g();
                    this.bCp.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bCq = new o();
                    this.bCq.parserJson(optJSONObject7);
                }
                this.bBW.setUserMap(this.userMap);
                this.bBW.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bBX.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBW.setTitle(this.title);
                } else {
                    this.bBW.setTitle(this.bBO);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bCE.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bCH.add(cVar);
                    }
                }
                this.bCO = jSONObject.optInt("is_book_chapter", 0);
                this.bCP.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bDc = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bCW = jSONObject.optString("recom_extra_img");
                this.bCZ = jSONObject.optString("recom_extra_img_night");
                this.bCX = jSONObject.optInt("recom_extra_img_width", 0);
                this.bCY = jSONObject.optInt("recom_extra_img_height", 0);
                this.bDa = jSONObject.optLong("last_read_pid");
                this.bDb = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bCg = new bm();
                    this.bCg.aJ(optJSONObject9);
                }
                this.bDl = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bDs = new af();
                    this.bDs.parserJson(optJSONObject10);
                }
                this.bDt = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bDu = new f();
                    this.bDu.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bDv = new MediaData();
                    this.bDv.parserJson(optJSONObject12);
                }
                this.bCV = jSONObject.optInt("is_called", 0);
                this.bDw = jSONObject.optInt("middle_page_num", 0);
                this.bDx = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bCe = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bDy = new OriginalThreadInfo();
                        this.bDy.parserJson(optJSONObject14);
                    } else {
                        this.bDy = null;
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
                    this.bDL = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDL, this);
                }
                Zm();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Zm() {
        Zn();
        Zo();
        Zp();
        Zq();
        Zr();
        Zs();
        Zt();
    }

    private void Zn() {
        if (!StringUtils.isNull(this.bBJ.getName_show())) {
            this.bDN = com.baidu.tbadk.core.util.ap.g(this.bBJ.getName_show(), 14, "...");
        }
    }

    private void Zo() {
        if (YS()) {
            this.bDO = com.baidu.tbadk.core.util.ap.ap(YH() * 1000);
        } else {
            String ap = com.baidu.tbadk.core.util.ap.ap(YH() * 1000);
            if (com.baidu.tbadk.core.util.ap.mF(ap)) {
                ap = com.baidu.tbadk.core.util.ap.aq(YH() * 1000);
            }
            this.bDO = TbadkCoreApplication.getInst().getApp().getString(d.j.repley_when) + ap;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bDO += " • " + getAddress();
        }
    }

    private void Zp() {
        if (Zh() == null || Zh().share_info == null || Zh().share_info.share_user_count <= 0 || !aac() || (this.bDw > 0 && this.bDx == 0)) {
            this.bDP = null;
            return;
        }
        int i = Zh().share_info.share_user_count;
        if (i == 1) {
            this.bDP = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple);
        } else {
            this.bDP = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.ap.at(i)});
        }
    }

    private void Zq() {
        this.bDQ = aao();
    }

    private void Zr() {
        this.bDR = aap();
    }

    private void Zs() {
        this.bDS = com.baidu.tbadk.core.util.ap.aq(YH() * 1000);
    }

    private void Zt() {
        this.bDT = com.baidu.tbadk.core.util.ap.aq(YH());
    }

    public SpannableStringBuilder Zu() {
        return this.bBN;
    }

    public boolean Zv() {
        return YJ() != 0;
    }

    public int Zw() {
        if (this.bCE != null) {
            long Yh = this.bCE.Yh();
            long Yi = this.bCE.Yi();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < Yh) {
                return 1;
            }
            if (currentTimeMillis > Yi) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int Zx() {
        if (Zz() && this.bCn.size() >= 1) {
            b bVar = this.bCn.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int WT = bVar.WT();
            int WU = bVar.WU();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < WT) {
                return 4;
            }
            return currentTimeMillis > WU ? 2 : 1;
        }
        return -1;
    }

    public int Zy() {
        if (!Zz() || this.bCn.size() < 1 || this.bCn.get(0) == null) {
            return -1;
        }
        return this.bCn.get(0).WS();
    }

    public boolean Zz() {
        return this.bCb == 1;
    }

    public String getActUrl() {
        return (!Zz() || this.bCn.size() < 1 || this.bCn.get(0) == null) ? "" : this.bCn.get(0).getUrl();
    }

    private com.baidu.adp.widget.b lo(String str) {
        com.baidu.adp.widget.b bVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getApplicationContext()).inflate(d.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(d.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0277d.cp_cont_f_1));
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

    public SmartApp ZA() {
        return this.bDL;
    }

    private void j(boolean z, boolean z2) {
        SpannableString spannableString;
        String H = H(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && ZC()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (YJ() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (YJ() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (YL() == 1 || this.bBI.aaL() != 0) {
                if (Yu() != null && getThreadType() == 41) {
                    if (Zw() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && ZO()) {
                Integer num = bCs.get(Integer.valueOf(Zw()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (YK() == 1 && !Zv() && bBg != getType() && bBl != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.bBX != null && this.bBX.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (YU() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = bCr.get(new Point(Zy(), Zx()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (Za() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (Zb() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = lo(this.category_name);
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
                Bitmap hp = com.baidu.tbadk.core.util.al.hp(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(hp);
                if (hp != null) {
                    bitmapDrawable.setBounds(0, 0, hp.getWidth(), hp.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBx));
                spannableString.setSpan(kVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(H + " "));
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.bBN = spannableStringBuilder;
    }

    public boolean ZB() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap hp = com.baidu.tbadk.core.util.al.hp(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(hp);
        bitmapDrawable.setBounds(0, 0, hp.getWidth(), hp.getHeight());
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (YO() != null) {
            if (YO().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.he));
            } else if (YO().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(lVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean ZC() {
        return com.baidu.adp.lib.b.d.iQ().aO("isConveneThreadOpen") == 1;
    }

    public void k(boolean z, boolean z2) {
        b(z, z2, true);
    }

    public void b(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.S(b(z, z2, z3, false)) > 0) {
            l(z, z3);
            return;
        }
        String H = H(this.title, false);
        SpannableString a = a(new SpannableString(H + " "));
        if (z) {
            spannableStringBuilder = a(H, a, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bBN = spannableStringBuilder;
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
            if (this.bBZ == 1) {
                this.bBN = a;
                return a;
            }
        } else if (this.bBZ == 1) {
            this.bBN = new SpannableStringBuilder();
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

    public void bt(String str, String str2) {
        this.mUrl = str;
        this.bCJ = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a Z;
        com.baidu.adp.widget.ImageView.a Z2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCJ) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.anm().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.Y(this.mUrl, 10)) && (Z = com.baidu.tbadk.core.util.d.v.Z(this.mUrl, 10)) != null) {
                bitmap = Z.oy();
                com.baidu.tbadk.imageManager.c.anm().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.anm().getBitmap(this.bCJ);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.Y(this.bCJ, 10)) && (Z2 = com.baidu.tbadk.core.util.d.v.Z(this.bCJ, 10)) != null) {
                bitmap2 = Z2.oy();
                com.baidu.tbadk.imageManager.c.anm().e(this.bCJ, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBx));
                        spannableString.setSpan(mVar, i + i3, i + i3 + 1, 33);
                        i2++;
                    }
                }
                return;
            }
            com.baidu.adp.lib.f.c.jB().a(this.mUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass2) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.anm().e(str2, aVar.oy());
                    }
                }
            }, bBe);
            com.baidu.adp.lib.f.c.jB().a(this.bCJ, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.anm().e(str2, aVar.oy());
                    }
                }
            }, bBe);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bCR != null && this.bCR.size() > 0) {
            int size = this.bCR.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCR.get(i2);
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
                                bg.this.lq(pbContent.link);
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

    private String lp(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData ZD() {
        if (this.bCR != null && this.bCR.size() > 0) {
            int size = this.bCR.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bCR.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && ZI() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = lp(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.bBv;
            kVar.chw = this.bBw;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void ZE() {
        j(false, false);
    }

    public void ZF() {
        j(false, true);
    }

    public AnchorInfoData ZG() {
        return this.bBX;
    }

    public boolean ZH() {
        return this.threadType == 36;
    }

    public boolean ZI() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean ZJ() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> YY = YY();
        if (YY == null || Zv()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= YY.size() || i2 >= 3) {
                break;
            }
            if (YY.get(i2) != null && YY.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(YY.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = YY.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = YY.get(i2).getPicUrl();
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
        if (this.bCe != null && !StringUtils.isNull(this.bCe.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bCe.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bBJ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bBJ.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ZK() {
        String userId;
        return this.bBJ == null || (userId = this.bBJ.getUserId()) == null || userId.equals("0");
    }

    public boolean ZL() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aaC()) {
            if (Zf() != null) {
                return bBg;
            }
            return bAT;
        }
        int YJ = YJ();
        if (this.bCe != null && aat()) {
            return bBu;
        }
        if (this.bCh != null && this.threadType == 60) {
            return bBj;
        }
        if (this.bCh != null && this.threadType == 49) {
            return bBh;
        }
        if (this.threadType == 51) {
            return bBi;
        }
        if (this.threadType == 63) {
            return bBo;
        }
        if (this.threadType == 64) {
            return bBp;
        }
        if (YJ == 2 || YJ == 1) {
            return bAS;
        }
        if (this.bCe != null && ZU() && !ZL()) {
            return bBt;
        }
        if (this.bCe != null && !ZL()) {
            if (YR()) {
                return bBl;
            }
            return bBg;
        } else if (this.isShareThread) {
            return bBk;
        } else {
            if (ZN()) {
                return bBq.get() ? bCD : bAT;
            } else if (Zz() && Zy() == 1) {
                return bBq.get() ? bCL : bAT;
            } else if (isLinkThread()) {
                return bBe;
            } else {
                if (YR()) {
                    return bBf;
                }
                if (this.bDB == 1) {
                    return this.bDE != null ? bBn : bBm;
                } else if (this.bAI) {
                    return bAX;
                } else {
                    if (this.bAJ) {
                        return bAY;
                    }
                    if (this.bAK) {
                        return bAZ;
                    }
                    if (this.bAL) {
                        return bBa;
                    }
                    if (this.bAM) {
                        return bBb;
                    }
                    if (this.bAN) {
                        return bBc;
                    }
                    if (this.bAO) {
                        return bBd;
                    }
                    if (this.bCl) {
                        int ZM = ZM();
                        if (ZM == 1) {
                            return bAU;
                        }
                        if (ZM == 2) {
                            return bAV;
                        }
                        if (ZM > 2) {
                            return bAW;
                        }
                        return bAT;
                    }
                    return bAT;
                }
            }
        }
    }

    public int ZM() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.Wv().Wz() || com.baidu.tbadk.core.util.v.S(YY()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < YY().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(YY(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean ZN() {
        return Yu() != null && getThreadType() == 41 && YL() == 1 && Zw() == 2;
    }

    public void o(ArrayList<p> arrayList) {
        if (this.bBZ == 1) {
            this.bxU = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bxU = 0;
        } else {
            this.bxU = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.Xa() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.Xa().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bxU = next.Xb();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean ZO() {
        return this.threadType == 41;
    }

    public boolean ZP() {
        return this.bCM;
    }

    public void dk(boolean z) {
        this.bCM = z;
    }

    public String ZQ() {
        return this.bCN;
    }

    public o ZR() {
        return this.bCq;
    }

    public void ZS() {
        if (this.bCj == 0) {
            this.bCj = 1;
        }
    }

    public boolean ZT() {
        return this.bCT;
    }

    public void dl(boolean z) {
        this.bDd = z;
    }

    public boolean ZU() {
        return this.bDd;
    }

    public void gw(int i) {
        this.bDe = i + 1;
    }

    public int ZV() {
        return this.bDe;
    }

    public List<ReportInfo> ZW() {
        return this.bDf;
    }

    public boolean ZX() {
        return this.bCU;
    }

    public void dm(boolean z) {
        this.bCU = z;
    }

    public bm ZY() {
        return this.bCg;
    }

    public void a(bm bmVar) {
        this.bCg = bmVar;
    }

    public void setCurrentPage(int i) {
        if (this.bCg != null) {
            this.bCg.mCurrentPage = i;
        }
    }

    public boolean ZZ() {
        return getThreadType() == 49;
    }

    public boolean aaa() {
        return getThreadType() == 40;
    }

    public boolean aab() {
        return getThreadType() == 50;
    }

    public boolean aac() {
        return getThreadType() == 60;
    }

    public boolean aad() {
        return getThreadType() == 40 && ZY() != null && ZY().channelId > 0;
    }

    public int aae() {
        return this.bDk;
    }

    public void setSmartFrsPosition(int i) {
        this.bDk = i;
    }

    public SparseArray<String> Xx() {
        return this.bzx;
    }

    public String aaf() {
        return this.mRecomSource;
    }

    public boolean aag() {
        return this.bDl;
    }

    public long aah() {
        return this.bDm;
    }

    public long aai() {
        return this.bDn;
    }

    public int aaj() {
        return this.bDo;
    }

    public int aak() {
        return this.bDp;
    }

    public void gx(int i) {
        this.bDo = i;
    }

    public void gy(int i) {
        this.bDm = i;
    }

    public void af(long j) {
        this.bDm = j;
    }

    public void ag(long j) {
        this.bDn = j;
    }

    public void gz(int i) {
        this.bDp = i;
    }

    public long aal() {
        return this.bDr;
    }

    public void ah(long j) {
        this.bDr = j;
    }

    public PostData aam() {
        return this.bDq;
    }

    public af aan() {
        return this.bDs;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String H;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bBZ == 1) {
            H = H(this.bBO, true);
            a = lm(this.bBO);
        } else {
            H = H(this.title, false);
            a = a(new SpannableString(H + " "));
        }
        if (z) {
            spannableStringBuilder = a(H, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bBN = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder l(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder m(boolean z, boolean z2) {
        SpannableString lm;
        if (!StringUtils.isNull(this.title) && this.bBZ != 1) {
            lm = a(new SpannableString(H(this.title, false) + " "));
        } else {
            lm = lm(this.bBO);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(lm);
        this.bBN = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aao() {
        if (StringUtils.isNull(this.title) || this.bBZ == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(H(this.title, false) + " ")));
        this.bBN = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString aap() {
        return lm(this.bBO);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean YP = YP();
        if (z2) {
            if (z) {
                if (YP && !ZI()) {
                    arrayList.add(new n.a(d.j.god_title));
                }
                if (YL() == 1 || getThreadType() == 33 || (YN() != null && YN().aaL() != 0)) {
                    if (Yu() != null && ZO()) {
                        if (Zw() == 2) {
                            arrayList.add(new n.a(d.j.interview_live));
                        }
                    } else if (!YP) {
                        arrayList.add(new n.a(d.j.photo_live_tips));
                    }
                }
                if (ZO()) {
                    arrayList.add(bDh.get(Zw()));
                }
                if (Zz()) {
                    Integer num = bDg.get(new Point(Zy(), Zx()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(d.j.card_promotion_text));
                    }
                }
                if (Za() != null) {
                    arrayList.add(new n.a(d.j.card_promotion_text, d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (YP && YJ() != 1 && !ZI()) {
                    arrayList.add(new n.a(d.j.god_title));
                }
                if ((YL() == 1 || getThreadType() == 33) && !ZO() && !YP) {
                    arrayList.add(new n.a(d.j.photo_live_tips));
                }
                if (YK() == 1) {
                    arrayList.add(new n.a(d.j.good));
                }
                if (YJ() == 1) {
                    arrayList.add(new n.a(d.j.top));
                }
                if (ZO() && Yu() != null && Zw() == 2) {
                    arrayList.add(new n.a(d.j.interview_live));
                }
                if (Zz()) {
                    Integer num2 = bDg.get(new Point(Zy(), Zx()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(d.j.card_promotion_text));
                    }
                }
                if (this.bCO == 1) {
                    arrayList.add(new n.a(d.j.card_tbread_text));
                }
                if (Zb() != null) {
                    arrayList.add(new n.a(d.j.send_app_code_gift, d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (Za() != null) {
                    arrayList.add(new n.a(d.j.card_promotion_text, d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && ZZ()) {
                    arrayList.add(new n.a(d.j.ala_live));
                }
                if (aad()) {
                    arrayList.add(new n.a(d.j.frs_channel_tip));
                } else if (z3 && aab()) {
                    arrayList.add(new n.a(d.j.live_record));
                } else if (aaa()) {
                    arrayList.add(new n.a(d.j.video_title_str));
                }
                if (z4) {
                    arrayList.add(new n.a(d.j.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void p(ArrayList<MediaData> arrayList) {
        this.bBP = arrayList;
    }

    public String aaq() {
        return this.bDC;
    }

    public void lr(String str) {
        this.bDC = str;
    }

    public void aar() {
        this.bDB = 1;
    }

    public boolean aas() {
        return this.bDB == 1;
    }

    public boolean aat() {
        return this.bDF.equals("worldcupvideo");
    }

    public String aau() {
        return this.bBz;
    }

    public void ls(String str) {
        this.bBz = str;
    }

    public String aav() {
        return this.bBA;
    }

    public void lt(String str) {
        this.bBA = str;
    }

    public String aaw() {
        return this.bDD;
    }

    public void lu(String str) {
        this.bDD = str;
    }

    public boolean aax() {
        return this.bDG;
    }

    public void dn(boolean z) {
        this.bDG = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bDE = videoInfo;
    }

    public boolean aay() {
        return this.bDH != null;
    }

    public String aaz() {
        return this.bBK;
    }

    public String aaA() {
        return this.bDJ;
    }

    public bc aaB() {
        return this.bBy;
    }

    public boolean aaC() {
        return this.bDK;
    }

    /* renamed from: do  reason: not valid java name */
    public void m18do(boolean z) {
        this.bDK = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bCe != null) {
            return this.bCe.video_url;
        }
        return null;
    }

    public boolean aaD() {
        return this.bDM;
    }

    public void dp(boolean z) {
        this.bDM = z;
    }

    public AgreeData aaE() {
        return this.agreeData;
    }

    void a(SmartApp smartApp, bg bgVar) {
        if (smartApp != null && bgVar != null) {
            MetaData YO = bgVar.YO();
            if (com.baidu.tbadk.core.util.ap.isEmpty(smartApp.name)) {
                YO.setName_show(TbadkCoreApplication.getInst().getString(d.j.ai_smart_app));
            } else {
                YO.setName_show(smartApp.name);
            }
            YO.setPortrait(smartApp.avatar);
        }
    }
}

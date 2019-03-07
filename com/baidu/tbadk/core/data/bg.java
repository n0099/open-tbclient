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
    private String bBF;
    private SpannableStringBuilder bBI;
    public int bBM;
    private int bBN;
    private int bBQ;
    private String bBT;
    private int bBU;
    private String bBV;
    private int bBX;
    private VideoInfo bBZ;
    private bc bBt;
    private String bBu;
    private String bBv;
    public TwZhiBoUser bCA;
    public List<TwAnchorProfitItem> bCB;
    private String bCE;
    private SkinInfo bCF;
    private boolean bCH;
    private String bCI;
    private boolean bCO;
    private boolean bCP;
    public String bCR;
    public int bCS;
    public int bCT;
    public String bCU;
    public long bCV;
    public String bCX;
    private VideoDesc bCa;
    private bm bCb;
    private AlaInfoData bCc;
    private long bCd;
    private o bCl;
    private LiveCoverStatus bCr;
    private long bCs;
    private String bDA;
    public OriginalForumInfo bDC;
    public boolean bDD;
    private String bDE;
    private boolean bDF;
    private SmartApp bDG;
    private String bDI;
    private String bDJ;
    private String bDK;
    private SpannableStringBuilder bDL;
    private SpannableString bDM;
    private String bDN;
    private String bDO;
    public int bDP;
    private List<ReportInfo> bDa;
    private boolean bDg;
    private int bDj;
    private int bDk;
    private long bDm;
    private af bDn;
    public f bDp;
    private MediaData bDq;
    public int bDr;
    public OriginalThreadInfo bDt;
    private String bDx;
    private String bDy;
    private VideoInfo bDz;
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
    public static final BdUniqueId bAN = BdUniqueId.gen();
    public static final BdUniqueId bAO = BdUniqueId.gen();
    public static final BdUniqueId bAP = BdUniqueId.gen();
    public static final BdUniqueId bAQ = BdUniqueId.gen();
    public static final BdUniqueId bAR = BdUniqueId.gen();
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
    public static AtomicBoolean bBl = new AtomicBoolean(false);
    public static AtomicBoolean bBm = new AtomicBoolean(false);
    public static AtomicBoolean bBn = new AtomicBoolean(false);
    public static final BdUniqueId bBo = BdUniqueId.gen();
    public static final BdUniqueId bBp = BdUniqueId.gen();
    private static HashMap<Point, Integer> bCm = new HashMap<>();
    private static HashMap<Integer, Integer> bCn = new HashMap<>();
    public static final BdUniqueId bCx = BdUniqueId.gen();
    public static final BdUniqueId bCy = BdUniqueId.gen();
    public static final BdUniqueId bCG = BdUniqueId.gen();
    private static HashMap<Point, Integer> bDb = new HashMap<>();
    private static SparseArray<n.a> bDc = new SparseArray<>(3);
    public boolean bAD = false;
    public boolean bAE = false;
    public boolean bAF = false;
    public boolean bAG = false;
    public boolean bAH = false;
    public boolean bAI = false;
    public boolean bAJ = false;
    private int bBq = 0;
    private String bBr = "1";
    public int bBs = 1;
    private String bBP = null;
    private int bxP = 0;
    public int bCe = 0;
    private String bCf = "";
    public boolean bCg = false;
    private String bCo = "";
    public boolean bCW = true;
    public boolean bDd = false;
    public boolean bDe = false;
    private int bDf = -1;
    public SparseArray<String> bzs = null;
    public boolean bDo = false;
    private int bDw = 0;
    private boolean bDB = false;
    private boolean bDH = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bBw = 0;
    private int bBx = 0;
    private String last_time = null;
    private long bBy = 0;
    private int bBz = 0;
    private int bBA = 0;
    private int bBB = 0;
    private int bBC = 0;
    private bk bBD = new bk();
    private MetaData bBE = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bBK = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bBL = new ArrayList<>();
    private int bBG = 0;
    private int bBH = 0;
    private String ad_url = null;
    private String bBJ = null;
    private String from = null;
    private int bBO = 0;
    private PraiseData bBR = new PraiseData();
    private AnchorInfoData bBS = new AnchorInfoData();
    private long time = 0;
    private int bBW = 0;
    private ArrayList<b> bCi = new ArrayList<>();
    private bp bCj = null;
    private g bCk = null;
    private int bCp = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bBY = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bCq = null;
    private int bCh = 0;
    private boolean bCt = false;
    private boolean bCu = false;
    private int bCv = 0;
    private boolean bCw = false;
    private int anchorLevel = 0;
    public int bCJ = 0;
    public l bCK = new l();
    private List<PbContent> bCL = new ArrayList();
    private List<PbContent> bCM = new ArrayList();
    private List<PbContent> bCN = new ArrayList();
    private String category_name = null;
    private be bCz = new be();
    private ArrayList<com.baidu.tbadk.data.c> bCC = new ArrayList<>();
    private PushStatusData bCD = new PushStatusData();
    public boolean bCY = false;
    public int bCZ = -1;
    private long bDh = 0;
    private long bDi = 0;
    private PostData bDl = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bCQ = 0;
    public int bDs = 0;
    private String tieba_game_information_source = "";
    public String bDv = "";
    public String bDu = "";

    static {
        bCm.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        bCm.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        bCm.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        bCm.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        bCm.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        bCm.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        bCm.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        bCm.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        bDb.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        bDb.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        bDb.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        bDb.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        bDb.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        bDb.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        bDb.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        bDb.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        bCn.put(1, Integer.valueOf(d.f.label_interview_no));
        bCn.put(2, Integer.valueOf(d.f.label_interview_live));
        bCn.put(3, Integer.valueOf(d.f.label_interview_off));
        bDc.put(1, new n.a(d.j.interview_live_status_not_start, d.C0236d.cp_other_b, d.f.pic_dot_title_red));
        bDc.put(2, new n.a(d.j.interview_live_status_ing, d.C0236d.cp_other_c, d.f.pic_dot_title_green));
        bDc.put(3, new n.a(d.j.interview_live_status_over, d.C0236d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bg() {
        this.bBN = 0;
        this.bBX = 0;
        this.bCs = 0L;
        this.mUrl = "";
        this.bCE = "";
        this.bDr = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bCs = 0L;
        this.bBX = 0;
        this.bBN = 0;
        this.bDr = 0;
        this.mUrl = "";
        this.bCE = "";
        this.isBigGie = false;
    }

    public String Yp() {
        return this.bDI;
    }

    public String Yq() {
        return this.bDJ;
    }

    public void lh(String str) {
        this.bDJ = str;
    }

    public String Yr() {
        return this.bDK;
    }

    public SpannableStringBuilder Ys() {
        return this.bDL;
    }

    public SpannableString Yt() {
        return this.bDM;
    }

    public String Yu() {
        return this.bDN;
    }

    public String Yv() {
        return this.bDO;
    }

    public boolean Yw() {
        return this.bBN == 1;
    }

    public be Yx() {
        return this.bCz;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void go(int i) {
        this.anchorLevel = i;
    }

    public int Yy() {
        return this.bCQ;
    }

    public void gp(int i) {
        this.bCQ = i;
    }

    public void gq(int i) {
        this.bCv = i;
    }

    public int Yz() {
        return this.bCv;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo YA() {
        return this.bDz;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void ad(long j) {
        this.mCreateTime = j;
    }

    public long YB() {
        return this.bCd;
    }

    public String YC() {
        return this.bBT;
    }

    public PraiseData YD() {
        return this.bBR;
    }

    public void a(PraiseData praiseData) {
        this.bBR = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String YE() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public void li(String str) {
        this.bBr = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.bBq = i;
    }

    public int YF() {
        return this.bBq;
    }

    public String YG() {
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

    public List<PbContent> YH() {
        return this.bCL;
    }

    public void N(List<PbContent> list) {
        this.bCM = list;
    }

    public void O(List<PbContent> list) {
        this.bCN = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void gr(int i) {
        this.reply_num = i;
    }

    public int YI() {
        return this.reply_num;
    }

    public int YJ() {
        return this.bBx;
    }

    public void gs(int i) {
        this.bBx = i;
    }

    public long YK() {
        return this.bBy;
    }

    public void ae(long j) {
        this.bBy = j;
    }

    public int YL() {
        return this.bBA;
    }

    public int YM() {
        return this.bBz;
    }

    public void gt(int i) {
        this.bBz = i;
    }

    public int YN() {
        return this.bBB;
    }

    public void gu(int i) {
        this.bBB = i;
    }

    public int YO() {
        return this.bBC;
    }

    public List<PbContent> YP() {
        return this.bCM;
    }

    public bk YQ() {
        return this.bBD;
    }

    public MetaData YR() {
        return this.bBE;
    }

    public boolean YS() {
        return this.is_god != 0;
    }

    public boolean YT() {
        return this.is_god == 1;
    }

    public boolean YU() {
        return (this.bBE == null || this.bBE.getGodUserData() == null || this.bBE.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean YV() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bBE = metaData;
    }

    public String YW() {
        return this.forum_name;
    }

    public void lj(String str) {
        this.forum_name = str;
    }

    public int YX() {
        return this.bBH;
    }

    public String YY() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bBJ;
    }

    public void lk(String str) {
        this.bBJ = str;
    }

    public String H(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bCN == null || this.bCN.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bCN.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bCN.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bCM == null || (size = this.bCM.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bCM.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString ll(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(H(str, true));
        if (this.bCN != null && (size = this.bCN.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCN.get(i2);
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
                                bg.this.lp(pbContent.link);
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

    public int YZ() {
        return this.bBO;
    }

    public void gv(int i) {
        this.bBO = i;
    }

    public String Za() {
        return this.bBP;
    }

    public void lm(String str) {
        this.bBP = str;
    }

    public ArrayList<MediaData> Zb() {
        return this.bBK;
    }

    public ArrayList<b> Zc() {
        return this.bCi;
    }

    public void n(ArrayList<b> arrayList) {
        this.bCi = arrayList;
    }

    public bp Zd() {
        return this.bCj;
    }

    public g Ze() {
        return this.bCk;
    }

    public ArrayList<VoiceData.VoiceModel> Zf() {
        return this.bBL;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int Zg() {
        return this.bBU;
    }

    public void gw(int i) {
        this.bBU = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String Zh() {
        return this.bCf;
    }

    public VideoInfo Zi() {
        return this.bBZ;
    }

    public VideoDesc Zj() {
        return this.bCa;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bCc = alaInfoData;
    }

    public AlaInfoData Zk() {
        return this.bCc;
    }

    public PushStatusData Zl() {
        return this.bCD;
    }

    public SkinInfo Zm() {
        return this.bCF;
    }

    public long Zn() {
        return this.bCV;
    }

    public boolean Zo() {
        return this.bCW;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WR() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WS() {
        return this.bCX;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WT() {
        if (this.bzs == null || this.bzs.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WR().getTid());
        ajVar.setFid(WR().getFid());
        ajVar.b(this.bzs);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bBV = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bBN = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bCd = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bBw = threadInfo.repost_num.intValue();
                this.bBx = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bBy = threadInfo.last_time_int.intValue();
                this.bBz = threadInfo.is_top.intValue();
                this.bBA = threadInfo.is_membertop.intValue();
                this.bBB = threadInfo.is_good.intValue();
                this.bBC = threadInfo.is_livepost.intValue();
                this.bBD.a(threadInfo.topic);
                this.bBE.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bBF = threadInfo.fname;
                this.bBG = threadInfo.has_commented.intValue();
                this.bBH = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bBZ = threadInfo.video_info;
                this.bCa = threadInfo.video_segment;
                this.bCc = new AlaInfoData();
                this.bCc.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bBO = threadInfo.collect_status.intValue();
                this.bBP = threadInfo.collect_mark_pid;
                this.bBQ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bBT = threadInfo.first_post_id + "";
                this.bCf = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bBU = threadInfo.is_ntitle.intValue();
                this.bBW = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bDj = threadInfo.agree.has_agree.intValue();
                    this.bDk = threadInfo.agree.agree_type.intValue();
                    this.bDh = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bDi = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bDh;
                    this.agreeData.disAgreeNum = this.bDi;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bDm = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bBX = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bCO = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bCM = threadInfo.rich_title;
                this.bCL = threadInfo.first_post_content;
                this.bCN = threadInfo.rich_abstract;
                this.bBM = threadInfo.is_godthread_recommend.intValue();
                if ((this.bBE == null || this.bBE.getUserId() == null || this.bBE.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBE = metaData;
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
                this.bBJ = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bBK.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bBZ = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bCb = new bm();
                    this.bCb.a(threadInfo.video_channel_info);
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
                        this.bBL.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bCi.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bCj = new bp();
                    this.bCj.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bCk = new g();
                    this.bCk.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bCl = new o();
                    this.bCl.a(threadInfo.cartoon_info);
                }
                this.bBR.setUserMap(this.userMap);
                this.bBR.parserProtobuf(threadInfo.zan);
                this.bBS.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBR.setTitle(this.title);
                } else {
                    this.bBR.setTitle(this.bBJ);
                }
                this.bCo = threadInfo.livecover_src;
                this.bCp = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bCh = threadInfo.post_num.intValue();
                this.bCs = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.jb(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.oj(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.bBY.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bCq = noticeInfo.notice;
                    }
                    this.bCv = zhiBoInfoTW.copythread_remind.intValue();
                    this.bCt = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bCu = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bCo)) {
                        this.bCo = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bCA = zhiBoInfoTW.user.tw_anchor_info;
                        this.bCB = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bCr = threadInfo.twzhibo_info.livecover_status;
                    this.bCs = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bCw = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bCz.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bCC.add(cVar);
                    }
                }
                this.bCD.parserProtobuf(threadInfo.push_status);
                this.bCI = threadInfo.lego_card;
                this.bCF = threadInfo.skin_info;
                this.bCJ = threadInfo.is_book_chapter.intValue();
                this.bCK.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bCX = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bCV = threadInfo.last_read_pid.longValue();
                this.bCW = threadInfo.cheak_repeat.intValue() == 1;
                this.bDa = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bDl.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.S(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bzs = sparseArray;
                }
                this.bDg = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bDn = new af();
                    this.bDn.a(threadInfo.link_info);
                }
                this.bDo = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bDp = new f();
                    this.bDp.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bDq = new MediaData();
                    this.bDq.parserProtobuf(threadInfo.pic_info);
                }
                this.bCQ = threadInfo.is_called.intValue();
                this.bDr = threadInfo.middle_page_num.intValue();
                this.bDs = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bDu = threadInfo.star_rank_icon.icon_pic_url;
                    this.bDv = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bDt = new OriginalThreadInfo();
                    this.bDt.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bDt = new OriginalThreadInfo();
                    this.bDt.parser(threadInfo.origin_thread_info);
                } else {
                    this.bDt = null;
                }
                this.bDw = threadInfo.is_topic.intValue();
                this.bDx = threadInfo.topic_user_name;
                this.bDy = threadInfo.topic_h5_url;
                this.bDA = threadInfo.presentation_style;
                this.bDC = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bDE = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bBt = new bc();
                    this.bBt.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bDG = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDG, this);
                }
                Zp();
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
                this.bCd = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bBw = jSONObject.optInt("repost_num", 0);
                this.bBx = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.bBy = jSONObject.optLong("last_time_int", 0L);
                this.bBz = jSONObject.optInt("is_top", 0);
                this.bBA = jSONObject.optInt("is_membertop", 0);
                this.bBB = jSONObject.optInt("is_good", 0);
                this.bBC = jSONObject.optInt("is_livepost", 0);
                this.bBD.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bBE.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bBF = this.forum_name;
                this.bBG = jSONObject.optInt("has_commented", 0);
                this.bBH = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bBO = jSONObject.optInt("collect_status");
                this.bBP = jSONObject.optString("collect_mark_pid");
                this.bBQ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bDh = jSONObject.optInt("agree_num");
                this.bDm = jSONObject.optLong("share_num");
                this.bBT = jSONObject.optString("first_post_id", "0");
                this.bCf = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bBU = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bDj = optJSONObject2.optInt("has_agree");
                    this.bDh = optJSONObject2.optInt("agree_num");
                    this.bDi = optJSONObject2.optLong("disagree_num");
                    this.bDk = optJSONObject2.optInt("agree_type");
                    if (this.bDh < 0) {
                        this.bDh = 0L;
                    }
                    if (this.bDi < 0) {
                        this.bDi = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bDh;
                    this.agreeData.disAgreeNum = this.bDi;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bCz.parserJson(optJSONObject3);
                }
                if ((this.bBE == null || this.bBE.getUserId() == null) && this.userMap != null) {
                    this.bBE = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bCc = new AlaInfoData();
                this.bCc.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bBJ = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bBK.add(mediaData);
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
                        this.bBL.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bCi.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bCj = new bp();
                    this.bCj.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bCk = new g();
                    this.bCk.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bCl = new o();
                    this.bCl.parserJson(optJSONObject7);
                }
                this.bBR.setUserMap(this.userMap);
                this.bBR.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bBS.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBR.setTitle(this.title);
                } else {
                    this.bBR.setTitle(this.bBJ);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bCz.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bCC.add(cVar);
                    }
                }
                this.bCJ = jSONObject.optInt("is_book_chapter", 0);
                this.bCK.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bCX = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bCR = jSONObject.optString("recom_extra_img");
                this.bCU = jSONObject.optString("recom_extra_img_night");
                this.bCS = jSONObject.optInt("recom_extra_img_width", 0);
                this.bCT = jSONObject.optInt("recom_extra_img_height", 0);
                this.bCV = jSONObject.optLong("last_read_pid");
                this.bCW = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bCb = new bm();
                    this.bCb.aJ(optJSONObject9);
                }
                this.bDg = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bDn = new af();
                    this.bDn.parserJson(optJSONObject10);
                }
                this.bDo = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bDp = new f();
                    this.bDp.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bDq = new MediaData();
                    this.bDq.parserJson(optJSONObject12);
                }
                this.bCQ = jSONObject.optInt("is_called", 0);
                this.bDr = jSONObject.optInt("middle_page_num", 0);
                this.bDs = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bBZ = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bDt = new OriginalThreadInfo();
                        this.bDt.parserJson(optJSONObject14);
                    } else {
                        this.bDt = null;
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
                    this.bDG = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDG, this);
                }
                Zp();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Zp() {
        Zq();
        Zr();
        Zs();
        Zt();
        Zu();
        Zv();
        Zw();
    }

    private void Zq() {
        if (!StringUtils.isNull(this.bBE.getName_show())) {
            this.bDI = com.baidu.tbadk.core.util.ap.g(this.bBE.getName_show(), 14, "...");
        }
    }

    private void Zr() {
        if (YV()) {
            this.bDJ = com.baidu.tbadk.core.util.ap.ap(YK() * 1000);
        } else {
            String ap = com.baidu.tbadk.core.util.ap.ap(YK() * 1000);
            if (com.baidu.tbadk.core.util.ap.mE(ap)) {
                ap = com.baidu.tbadk.core.util.ap.aq(YK() * 1000);
            }
            this.bDJ = TbadkCoreApplication.getInst().getApp().getString(d.j.repley_when) + ap;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bDJ += " • " + getAddress();
        }
    }

    private void Zs() {
        if (Zk() == null || Zk().share_info == null || Zk().share_info.share_user_count <= 0 || !aaf() || (this.bDr > 0 && this.bDs == 0)) {
            this.bDK = null;
            return;
        }
        int i = Zk().share_info.share_user_count;
        if (i == 1) {
            this.bDK = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple);
        } else {
            this.bDK = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.ap.at(i)});
        }
    }

    private void Zt() {
        this.bDL = aar();
    }

    private void Zu() {
        this.bDM = aas();
    }

    private void Zv() {
        this.bDN = com.baidu.tbadk.core.util.ap.aq(YK() * 1000);
    }

    private void Zw() {
        this.bDO = com.baidu.tbadk.core.util.ap.aq(YK());
    }

    public SpannableStringBuilder Zx() {
        return this.bBI;
    }

    public boolean Zy() {
        return YM() != 0;
    }

    public int Zz() {
        if (this.bCz != null) {
            long Yk = this.bCz.Yk();
            long Yl = this.bCz.Yl();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < Yk) {
                return 1;
            }
            if (currentTimeMillis > Yl) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int ZA() {
        if (ZC() && this.bCi.size() >= 1) {
            b bVar = this.bCi.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int WW = bVar.WW();
            int WX = bVar.WX();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < WW) {
                return 4;
            }
            return currentTimeMillis > WX ? 2 : 1;
        }
        return -1;
    }

    public int ZB() {
        if (!ZC() || this.bCi.size() < 1 || this.bCi.get(0) == null) {
            return -1;
        }
        return this.bCi.get(0).WV();
    }

    public boolean ZC() {
        return this.bBW == 1;
    }

    public String getActUrl() {
        return (!ZC() || this.bCi.size() < 1 || this.bCi.get(0) == null) ? "" : this.bCi.get(0).getUrl();
    }

    private com.baidu.adp.widget.b ln(String str) {
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
            textView.setTextColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(d.C0236d.cp_cont_f_1));
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

    public SmartApp ZD() {
        return this.bDG;
    }

    private void j(boolean z, boolean z2) {
        SpannableString spannableString;
        String H = H(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && ZF()) {
                arrayList.add(Integer.valueOf(d.f.icon_convene));
            }
            if (YM() == 1) {
                arrayList.add(Integer.valueOf(d.f.icon_top));
            } else if (YM() == 2) {
                arrayList.add(Integer.valueOf(d.f.icon_notice));
            }
            if (YO() == 1 || this.bBD.aaO() != 0) {
                if (Yx() != null && getThreadType() == 41) {
                    if (Zz() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && ZR()) {
                Integer num = bCn.get(Integer.valueOf(Zz()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (YN() == 1 && !Zy() && bBb != getType() && bBg != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.bBS != null && this.bBS.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (YX() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = bCm.get(new Point(ZB(), ZA()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (Zd() != null) {
                arrayList.add(Integer.valueOf(d.f.tag_act));
            }
            if (Ze() != null) {
                arrayList.add(Integer.valueOf(d.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = ln(this.category_name);
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
                Bitmap hq = com.baidu.tbadk.core.util.al.hq(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(hq);
                if (hq != null) {
                    bitmapDrawable.setBounds(0, 0, hq.getWidth(), hq.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBs));
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
        this.bBI = spannableStringBuilder;
    }

    public boolean ZE() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds8);
        Bitmap hq = com.baidu.tbadk.core.util.al.hq(d.f.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(hq);
        bitmapDrawable.setBounds(0, 0, hq.getWidth(), hq.getHeight());
        com.baidu.tbadk.core.view.l lVar = new com.baidu.tbadk.core.view.l(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (YR() != null) {
            if (YR().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(d.j.he));
            } else if (YR().getGender() == 2) {
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

    private boolean ZF() {
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
        this.bBI = spannableStringBuilder;
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
            if (this.bBU == 1) {
                this.bBI = a;
                return a;
            }
        } else if (this.bBU == 1) {
            this.bBI = new SpannableStringBuilder();
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
        this.bCE = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a Z;
        com.baidu.adp.widget.ImageView.a Z2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCE) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.anq().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.Y(this.mUrl, 10)) && (Z = com.baidu.tbadk.core.util.d.v.Z(this.mUrl, 10)) != null) {
                bitmap = Z.oy();
                com.baidu.tbadk.imageManager.c.anq().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.anq().getBitmap(this.bCE);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.Y(this.bCE, 10)) && (Z2 = com.baidu.tbadk.core.util.d.v.Z(this.bCE, 10)) != null) {
                bitmap2 = Z2.oy();
                com.baidu.tbadk.imageManager.c.anq().e(this.bCE, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBs));
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
                        com.baidu.tbadk.imageManager.c.anq().e(str2, aVar.oy());
                    }
                }
            }, bAZ);
            com.baidu.adp.lib.f.c.jB().a(this.bCE, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.anq().e(str2, aVar.oy());
                    }
                }
            }, bAZ);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bCM != null && this.bCM.size() > 0) {
            int size = this.bCM.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCM.get(i2);
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
                                bg.this.lp(pbContent.link);
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

    private String lo(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public ActivityItemData ZG() {
        if (this.bCM != null && this.bCM.size() > 0) {
            int size = this.bCM.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bCM.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && ZL() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = lo(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
            kVar.mLink = str;
            kVar.type = this.bBq;
            kVar.chu = this.bBr;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, kVar));
        }
    }

    public void ZH() {
        j(false, false);
    }

    public void ZI() {
        j(false, true);
    }

    public AnchorInfoData ZJ() {
        return this.bBS;
    }

    public boolean ZK() {
        return this.threadType == 36;
    }

    public boolean ZL() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean ZM() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> Zb = Zb();
        if (Zb == null || Zy()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Zb.size() || i2 >= 3) {
                break;
            }
            if (Zb.get(i2) != null && Zb.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(Zb.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = Zb.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = Zb.get(i2).getPicUrl();
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
        if (this.bBZ != null && !StringUtils.isNull(this.bBZ.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bBZ.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bBE != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bBE.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ZN() {
        String userId;
        return this.bBE == null || (userId = this.bBE.getUserId()) == null || userId.equals("0");
    }

    public boolean ZO() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aaF()) {
            if (Zi() != null) {
                return bBb;
            }
            return bAO;
        }
        int YM = YM();
        if (this.bBZ != null && aaw()) {
            return bBp;
        }
        if (this.bCc != null && this.threadType == 60) {
            return bBe;
        }
        if (this.bCc != null && this.threadType == 49) {
            return bBc;
        }
        if (this.threadType == 51) {
            return bBd;
        }
        if (this.threadType == 63) {
            return bBj;
        }
        if (this.threadType == 64) {
            return bBk;
        }
        if (YM == 2 || YM == 1) {
            return bAN;
        }
        if (this.bBZ != null && ZX() && !ZO()) {
            return bBo;
        }
        if (this.bBZ != null && !ZO()) {
            if (YU()) {
                return bBg;
            }
            return bBb;
        } else if (this.isShareThread) {
            return bBf;
        } else {
            if (ZQ()) {
                return bBl.get() ? bCy : bAO;
            } else if (ZC() && ZB() == 1) {
                return bBl.get() ? bCG : bAO;
            } else if (isLinkThread()) {
                return bAZ;
            } else {
                if (YU()) {
                    return bBa;
                }
                if (this.bDw == 1) {
                    return this.bDz != null ? bBi : bBh;
                } else if (this.bAD) {
                    return bAS;
                } else {
                    if (this.bAE) {
                        return bAT;
                    }
                    if (this.bAF) {
                        return bAU;
                    }
                    if (this.bAG) {
                        return bAV;
                    }
                    if (this.bAH) {
                        return bAW;
                    }
                    if (this.bAI) {
                        return bAX;
                    }
                    if (this.bAJ) {
                        return bAY;
                    }
                    if (this.bCg) {
                        int ZP = ZP();
                        if (ZP == 1) {
                            return bAP;
                        }
                        if (ZP == 2) {
                            return bAQ;
                        }
                        if (ZP > 2) {
                            return bAR;
                        }
                        return bAO;
                    }
                    return bAO;
                }
            }
        }
    }

    public int ZP() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.Wy().WC() || com.baidu.tbadk.core.util.v.S(Zb()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < Zb().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.c(Zb(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean ZQ() {
        return Yx() != null && getThreadType() == 41 && YO() == 1 && Zz() == 2;
    }

    public void o(ArrayList<p> arrayList) {
        if (this.bBU == 1) {
            this.bxP = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bxP = 0;
        } else {
            this.bxP = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.Xd() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.Xd().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bxP = next.Xe();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean ZR() {
        return this.threadType == 41;
    }

    public boolean ZS() {
        return this.bCH;
    }

    public void dk(boolean z) {
        this.bCH = z;
    }

    public String ZT() {
        return this.bCI;
    }

    public o ZU() {
        return this.bCl;
    }

    public void ZV() {
        if (this.bCe == 0) {
            this.bCe = 1;
        }
    }

    public boolean ZW() {
        return this.bCO;
    }

    public void dl(boolean z) {
        this.bCY = z;
    }

    public boolean ZX() {
        return this.bCY;
    }

    public void gx(int i) {
        this.bCZ = i + 1;
    }

    public int ZY() {
        return this.bCZ;
    }

    public List<ReportInfo> ZZ() {
        return this.bDa;
    }

    public boolean aaa() {
        return this.bCP;
    }

    public void dm(boolean z) {
        this.bCP = z;
    }

    public bm aab() {
        return this.bCb;
    }

    public void a(bm bmVar) {
        this.bCb = bmVar;
    }

    public void setCurrentPage(int i) {
        if (this.bCb != null) {
            this.bCb.mCurrentPage = i;
        }
    }

    public boolean aac() {
        return getThreadType() == 49;
    }

    public boolean aad() {
        return getThreadType() == 40;
    }

    public boolean aae() {
        return getThreadType() == 50;
    }

    public boolean aaf() {
        return getThreadType() == 60;
    }

    public boolean aag() {
        return getThreadType() == 40 && aab() != null && aab().channelId > 0;
    }

    public int aah() {
        return this.bDf;
    }

    public void setSmartFrsPosition(int i) {
        this.bDf = i;
    }

    public SparseArray<String> XA() {
        return this.bzs;
    }

    public String aai() {
        return this.mRecomSource;
    }

    public boolean aaj() {
        return this.bDg;
    }

    public long aak() {
        return this.bDh;
    }

    public long aal() {
        return this.bDi;
    }

    public int aam() {
        return this.bDj;
    }

    public int aan() {
        return this.bDk;
    }

    public void gy(int i) {
        this.bDj = i;
    }

    public void gz(int i) {
        this.bDh = i;
    }

    public void af(long j) {
        this.bDh = j;
    }

    public void ag(long j) {
        this.bDi = j;
    }

    public void gA(int i) {
        this.bDk = i;
    }

    public long aao() {
        return this.bDm;
    }

    public void ah(long j) {
        this.bDm = j;
    }

    public PostData aap() {
        return this.bDl;
    }

    public af aaq() {
        return this.bDn;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String H;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bBU == 1) {
            H = H(this.bBJ, true);
            a = ll(this.bBJ);
        } else {
            H = H(this.title, false);
            a = a(new SpannableString(H + " "));
        }
        if (z) {
            spannableStringBuilder = a(H, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bBI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder l(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder m(boolean z, boolean z2) {
        SpannableString ll;
        if (!StringUtils.isNull(this.title) && this.bBU != 1) {
            ll = a(new SpannableString(H(this.title, false) + " "));
        } else {
            ll = ll(this.bBJ);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ll);
        this.bBI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aar() {
        if (StringUtils.isNull(this.title) || this.bBU == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(H(this.title, false) + " ")));
        this.bBI = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString aas() {
        return ll(this.bBJ);
    }

    private ArrayList<n.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<n.a> arrayList = new ArrayList<>();
        boolean YS = YS();
        if (z2) {
            if (z) {
                if (YS && !ZL()) {
                    arrayList.add(new n.a(d.j.god_title));
                }
                if (YO() == 1 || getThreadType() == 33 || (YQ() != null && YQ().aaO() != 0)) {
                    if (Yx() != null && ZR()) {
                        if (Zz() == 2) {
                            arrayList.add(new n.a(d.j.interview_live));
                        }
                    } else if (!YS) {
                        arrayList.add(new n.a(d.j.photo_live_tips));
                    }
                }
                if (ZR()) {
                    arrayList.add(bDc.get(Zz()));
                }
                if (ZC()) {
                    Integer num = bDb.get(new Point(ZB(), ZA()));
                    if (num != null) {
                        arrayList.add(new n.a(num.intValue(), d.C0236d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(d.j.card_promotion_text));
                    }
                }
                if (Zd() != null) {
                    arrayList.add(new n.a(d.j.card_promotion_text, d.C0236d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
            } else {
                if (YS && YM() != 1 && !ZL()) {
                    arrayList.add(new n.a(d.j.god_title));
                }
                if ((YO() == 1 || getThreadType() == 33) && !ZR() && !YS) {
                    arrayList.add(new n.a(d.j.photo_live_tips));
                }
                if (YN() == 1) {
                    arrayList.add(new n.a(d.j.good));
                }
                if (YM() == 1) {
                    arrayList.add(new n.a(d.j.top));
                }
                if (ZR() && Yx() != null && Zz() == 2) {
                    arrayList.add(new n.a(d.j.interview_live));
                }
                if (ZC()) {
                    Integer num2 = bDb.get(new Point(ZB(), ZA()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), d.C0236d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(d.j.card_promotion_text));
                    }
                }
                if (this.bCJ == 1) {
                    arrayList.add(new n.a(d.j.card_tbread_text));
                }
                if (Ze() != null) {
                    arrayList.add(new n.a(d.j.send_app_code_gift, d.C0236d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (Zd() != null) {
                    arrayList.add(new n.a(d.j.card_promotion_text, d.C0236d.cp_other_b, d.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ap.isEmpty(getCategory())) {
                    arrayList.add(new n.a(getCategory()));
                }
                if (z3 && aac()) {
                    arrayList.add(new n.a(d.j.ala_live));
                }
                if (aag()) {
                    arrayList.add(new n.a(d.j.frs_channel_tip));
                } else if (z3 && aae()) {
                    arrayList.add(new n.a(d.j.live_record));
                } else if (aad()) {
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
        this.bBK = arrayList;
    }

    public String aat() {
        return this.bDx;
    }

    public void lq(String str) {
        this.bDx = str;
    }

    public void aau() {
        this.bDw = 1;
    }

    public boolean aav() {
        return this.bDw == 1;
    }

    public boolean aaw() {
        return this.bDA.equals("worldcupvideo");
    }

    public String aax() {
        return this.bBu;
    }

    public void lr(String str) {
        this.bBu = str;
    }

    public String aay() {
        return this.bBv;
    }

    public void ls(String str) {
        this.bBv = str;
    }

    public String aaz() {
        return this.bDy;
    }

    public void lt(String str) {
        this.bDy = str;
    }

    public boolean aaA() {
        return this.bDB;
    }

    public void dn(boolean z) {
        this.bDB = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bDz = videoInfo;
    }

    public boolean aaB() {
        return this.bDC != null;
    }

    public String aaC() {
        return this.bBF;
    }

    public String aaD() {
        return this.bDE;
    }

    public bc aaE() {
        return this.bBt;
    }

    public boolean aaF() {
        return this.bDF;
    }

    /* renamed from: do  reason: not valid java name */
    public void m17do(boolean z) {
        this.bDF = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bBZ != null) {
            return this.bBZ.video_url;
        }
        return null;
    }

    public boolean aaG() {
        return this.bDH;
    }

    public void dp(boolean z) {
        this.bDH = z;
    }

    public AgreeData aaH() {
        return this.agreeData;
    }

    void a(SmartApp smartApp, bg bgVar) {
        if (smartApp != null && bgVar != null) {
            MetaData YR = bgVar.YR();
            if (com.baidu.tbadk.core.util.ap.isEmpty(smartApp.name)) {
                YR.setName_show(TbadkCoreApplication.getInst().getString(d.j.ai_smart_app));
            } else {
                YR.setName_show(smartApp.name);
            }
            YR.setPortrait(smartApp.avatar);
        }
    }
}

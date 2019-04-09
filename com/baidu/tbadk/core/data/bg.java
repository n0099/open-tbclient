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
    private String bBB;
    private String bBL;
    private SpannableStringBuilder bBO;
    public int bBS;
    private int bBT;
    private int bBW;
    private String bBZ;
    private bc bBz;
    public TwZhiBoUser bCG;
    public List<TwAnchorProfitItem> bCH;
    private String bCK;
    private SkinInfo bCL;
    private boolean bCN;
    private String bCO;
    private boolean bCU;
    private boolean bCV;
    public String bCX;
    public int bCY;
    public int bCZ;
    private int bCa;
    private String bCb;
    private int bCd;
    private VideoInfo bCf;
    private VideoDesc bCg;
    private bm bCh;
    private AlaInfoData bCi;
    private long bCj;
    private o bCr;
    private LiveCoverStatus bCx;
    private long bCy;
    private String bDD;
    private String bDE;
    private VideoInfo bDF;
    private String bDG;
    public OriginalForumInfo bDI;
    public boolean bDJ;
    private String bDK;
    private boolean bDL;
    private SmartApp bDM;
    private String bDO;
    private String bDP;
    private String bDQ;
    private SpannableStringBuilder bDR;
    private SpannableString bDS;
    private String bDT;
    private String bDU;
    public int bDV;
    public String bDa;
    public long bDb;
    public String bDd;
    private List<ReportInfo> bDg;
    private boolean bDm;
    private int bDp;
    private int bDq;
    private long bDs;
    private af bDt;
    public f bDv;
    private MediaData bDw;
    public int bDx;
    public OriginalThreadInfo bDz;
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
    public static final BdUniqueId bBq = BdUniqueId.gen();
    public static AtomicBoolean bBr = new AtomicBoolean(false);
    public static AtomicBoolean bBs = new AtomicBoolean(false);
    public static AtomicBoolean bBt = new AtomicBoolean(false);
    public static final BdUniqueId bBu = BdUniqueId.gen();
    public static final BdUniqueId bBv = BdUniqueId.gen();
    private static HashMap<Point, Integer> bCs = new HashMap<>();
    private static HashMap<Integer, Integer> bCt = new HashMap<>();
    public static final BdUniqueId bCD = BdUniqueId.gen();
    public static final BdUniqueId bCE = BdUniqueId.gen();
    public static final BdUniqueId bCM = BdUniqueId.gen();
    private static HashMap<Point, Integer> bDh = new HashMap<>();
    private static SparseArray<n.a> bDi = new SparseArray<>(3);
    public boolean bAJ = false;
    public boolean bAK = false;
    public boolean bAL = false;
    public boolean bAM = false;
    public boolean bAN = false;
    public boolean bAO = false;
    public boolean bAP = false;
    private int bBw = 0;
    private String bBx = "1";
    public int bBy = 1;
    private String bBV = null;
    private int bxV = 0;
    public int bCk = 0;
    private String bCl = "";
    public boolean bCm = false;
    private String bCu = "";
    public boolean bDc = true;
    public boolean bDj = false;
    public boolean bDk = false;
    private int bDl = -1;
    public SparseArray<String> bzy = null;
    public boolean bDu = false;
    private int bDC = 0;
    private boolean bDH = false;
    private boolean bDN = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int bBC = 0;
    private int bBD = 0;
    private String last_time = null;
    private long bBE = 0;
    private int bBF = 0;
    private int bBG = 0;
    private int bBH = 0;
    private int bBI = 0;
    private bk bBJ = new bk();
    private MetaData bBK = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> bBQ = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> bBR = new ArrayList<>();
    private int bBM = 0;
    private int bBN = 0;
    private String ad_url = null;
    private String bBP = null;
    private String from = null;
    private int bBU = 0;
    private PraiseData bBX = new PraiseData();
    private AnchorInfoData bBY = new AnchorInfoData();
    private long time = 0;
    private int bCc = 0;
    private ArrayList<b> bCo = new ArrayList<>();
    private bp bCp = null;
    private g bCq = null;
    private int bCv = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> bCe = new ArrayList<>();
    private boolean isHeadLive = false;
    private String bCw = null;
    private int bCn = 0;
    private boolean bCz = false;
    private boolean bCA = false;
    private int bCB = 0;
    private boolean bCC = false;
    private int anchorLevel = 0;
    public int bCP = 0;
    public l bCQ = new l();
    private List<PbContent> bCR = new ArrayList();
    private List<PbContent> bCS = new ArrayList();
    private List<PbContent> bCT = new ArrayList();
    private String category_name = null;
    private be bCF = new be();
    private ArrayList<com.baidu.tbadk.data.c> bCI = new ArrayList<>();
    private PushStatusData bCJ = new PushStatusData();
    public boolean bDe = false;
    public int bDf = -1;
    private long bDn = 0;
    private long bDo = 0;
    private PostData bDr = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int bCW = 0;
    public int bDy = 0;
    private String tieba_game_information_source = "";
    public String bDB = "";
    public String bDA = "";

    static {
        bCs.put(new Point(1, 1), Integer.valueOf(d.f.label_frs_lottery_ing));
        bCs.put(new Point(1, 2), Integer.valueOf(d.f.label_frs_lottery_over));
        bCs.put(new Point(1, 3), Integer.valueOf(d.f.label_frs_lottery_off));
        bCs.put(new Point(1, 4), Integer.valueOf(d.f.label_frs_lottery_d));
        bCs.put(new Point(2, 1), Integer.valueOf(d.f.label_frs_activity_shaiing));
        bCs.put(new Point(2, 2), Integer.valueOf(d.f.label_frs_activity_shai_over));
        bCs.put(new Point(2, 3), Integer.valueOf(d.f.label_frs_activity_shai_off));
        bCs.put(new Point(2, 4), Integer.valueOf(d.f.label_frs_activity_shai_d));
        bDh.put(new Point(1, 1), Integer.valueOf(d.j.lottery_status_ing));
        bDh.put(new Point(1, 2), Integer.valueOf(d.j.lottery_status_over));
        bDh.put(new Point(1, 3), Integer.valueOf(d.j.lottery_status_off));
        bDh.put(new Point(1, 4), Integer.valueOf(d.j.lottery_status_not_start));
        bDh.put(new Point(2, 1), Integer.valueOf(d.j.share_picture_status_ing));
        bDh.put(new Point(2, 2), Integer.valueOf(d.j.share_picture_status_over));
        bDh.put(new Point(2, 3), Integer.valueOf(d.j.share_picture_status_off));
        bDh.put(new Point(2, 4), Integer.valueOf(d.j.share_picture_status_not_start));
        bCt.put(1, Integer.valueOf(d.f.label_interview_no));
        bCt.put(2, Integer.valueOf(d.f.label_interview_live));
        bCt.put(3, Integer.valueOf(d.f.label_interview_off));
        bDi.put(1, new n.a(d.j.interview_live_status_not_start, d.C0277d.cp_other_b, d.f.pic_dot_title_red));
        bDi.put(2, new n.a(d.j.interview_live_status_ing, d.C0277d.cp_other_c, d.f.pic_dot_title_green));
        bDi.put(3, new n.a(d.j.interview_live_status_over, d.C0277d.cp_other_d, d.f.pic_dot_title_blue));
    }

    public bg() {
        this.bBT = 0;
        this.bCd = 0;
        this.bCy = 0L;
        this.mUrl = "";
        this.bCK = "";
        this.bDx = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.bCy = 0L;
        this.bCd = 0;
        this.bBT = 0;
        this.bDx = 0;
        this.mUrl = "";
        this.bCK = "";
        this.isBigGie = false;
    }

    public String Ym() {
        return this.bDO;
    }

    public String Yn() {
        return this.bDP;
    }

    public void li(String str) {
        this.bDP = str;
    }

    public String Yo() {
        return this.bDQ;
    }

    public SpannableStringBuilder Yp() {
        return this.bDR;
    }

    public SpannableString Yq() {
        return this.bDS;
    }

    public String Yr() {
        return this.bDT;
    }

    public String Ys() {
        return this.bDU;
    }

    public boolean Yt() {
        return this.bBT == 1;
    }

    public be Yu() {
        return this.bCF;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void gn(int i) {
        this.anchorLevel = i;
    }

    public int Yv() {
        return this.bCW;
    }

    public void go(int i) {
        this.bCW = i;
    }

    public void gp(int i) {
        this.bCB = i;
    }

    public int Yw() {
        return this.bCB;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo Yx() {
        return this.bDF;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void ad(long j) {
        this.mCreateTime = j;
    }

    public long Yy() {
        return this.bCj;
    }

    public String Yz() {
        return this.bBZ;
    }

    public PraiseData YA() {
        return this.bBX;
    }

    public void a(PraiseData praiseData) {
        this.bBX = praiseData;
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
        this.bBx = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setResource(int i) {
        this.bBw = i;
    }

    public int YC() {
        return this.bBw;
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
        return this.bCR;
    }

    public void N(List<PbContent> list) {
        this.bCS = list;
    }

    public void O(List<PbContent> list) {
        this.bCT = list;
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
        return this.bBD;
    }

    public void gr(int i) {
        this.bBD = i;
    }

    public long YH() {
        return this.bBE;
    }

    public void ae(long j) {
        this.bBE = j;
    }

    public int YI() {
        return this.bBG;
    }

    public int YJ() {
        return this.bBF;
    }

    public void gs(int i) {
        this.bBF = i;
    }

    public int YK() {
        return this.bBH;
    }

    public void gt(int i) {
        this.bBH = i;
    }

    public int YL() {
        return this.bBI;
    }

    public List<PbContent> YM() {
        return this.bCS;
    }

    public bk YN() {
        return this.bBJ;
    }

    public MetaData YO() {
        return this.bBK;
    }

    public boolean YP() {
        return this.is_god != 0;
    }

    public boolean YQ() {
        return this.is_god == 1;
    }

    public boolean YR() {
        return (this.bBK == null || this.bBK.getGodUserData() == null || this.bBK.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean YS() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.bBK = metaData;
    }

    public String YT() {
        return this.forum_name;
    }

    public void lk(String str) {
        this.forum_name = str;
    }

    public int YU() {
        return this.bBN;
    }

    public String YV() {
        return this.ad_url;
    }

    public String getAbstract() {
        return this.bBP;
    }

    public void ll(String str) {
        this.bBP = str;
    }

    public String H(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.bCT == null || this.bCT.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.bCT.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.bCT.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.bCS == null || (size = this.bCS.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.bCS.get(i2);
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
        if (this.bCT != null && (size = this.bCT.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCT.get(i2);
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
        return this.bBU;
    }

    public void gu(int i) {
        this.bBU = i;
    }

    public String YX() {
        return this.bBV;
    }

    public void ln(String str) {
        this.bBV = str;
    }

    public ArrayList<MediaData> YY() {
        return this.bBQ;
    }

    public ArrayList<b> YZ() {
        return this.bCo;
    }

    public void n(ArrayList<b> arrayList) {
        this.bCo = arrayList;
    }

    public bp Za() {
        return this.bCp;
    }

    public g Zb() {
        return this.bCq;
    }

    public ArrayList<VoiceData.VoiceModel> Zc() {
        return this.bBR;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int Zd() {
        return this.bCa;
    }

    public void gv(int i) {
        this.bCa = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String Ze() {
        return this.bCl;
    }

    public VideoInfo Zf() {
        return this.bCf;
    }

    public VideoDesc Zg() {
        return this.bCg;
    }

    public void a(AlaInfoData alaInfoData) {
        this.bCi = alaInfoData;
    }

    public AlaInfoData Zh() {
        return this.bCi;
    }

    public PushStatusData Zi() {
        return this.bCJ;
    }

    public SkinInfo Zj() {
        return this.bCL;
    }

    public long Zk() {
        return this.bDb;
    }

    public boolean Zl() {
        return this.bDc;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WO() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WP() {
        return this.bDd;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WQ() {
        if (this.bzy == null || this.bzy.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WO().getTid());
        ajVar.setFid(WO().getFid());
        ajVar.b(this.bzy);
        return ajVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.bCb = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.bBT = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.bCj = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.bBC = threadInfo.repost_num.intValue();
                this.bBD = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.bBE = threadInfo.last_time_int.intValue();
                this.bBF = threadInfo.is_top.intValue();
                this.bBG = threadInfo.is_membertop.intValue();
                this.bBH = threadInfo.is_good.intValue();
                this.bBI = threadInfo.is_livepost.intValue();
                this.bBJ.a(threadInfo.topic);
                this.bBK.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.bBL = threadInfo.fname;
                this.bBM = threadInfo.has_commented.intValue();
                this.bBN = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.bCf = threadInfo.video_info;
                this.bCg = threadInfo.video_segment;
                this.bCi = new AlaInfoData();
                this.bCi.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.bBU = threadInfo.collect_status.intValue();
                this.bBV = threadInfo.collect_mark_pid;
                this.bBW = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.bBZ = threadInfo.first_post_id + "";
                this.bCl = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.bCa = threadInfo.is_ntitle.intValue();
                this.bCc = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.bDp = threadInfo.agree.has_agree.intValue();
                    this.bDq = threadInfo.agree.agree_type.intValue();
                    this.bDn = threadInfo.agree.agree_num.longValue() > 0 ? threadInfo.agree.agree_num.longValue() : 0L;
                    this.bDo = threadInfo.agree.disagree_num.longValue() > 0 ? threadInfo.agree.disagree_num.longValue() : 0L;
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.agreeNum = this.bDn;
                    this.agreeData.disAgreeNum = this.bDo;
                    this.agreeData.agreeType = threadInfo.agree.agree_type == null ? 0 : threadInfo.agree.agree_type.intValue();
                    this.agreeData.hasAgree = threadInfo.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = threadInfo.agree.diff_agree_num == null ? 0L : threadInfo.agree.diff_agree_num.longValue();
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.bDs = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.bCd = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.bCU = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.bCS = threadInfo.rich_title;
                this.bCR = threadInfo.first_post_content;
                this.bCT = threadInfo.rich_abstract;
                this.bBS = threadInfo.is_godthread_recommend.intValue();
                if ((this.bBK == null || this.bBK.getUserId() == null || this.bBK.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBK = metaData;
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
                this.bBP = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    Log.d("cwli", "media.cout = " + list2.size());
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.bBQ.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.bCf = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.bCh = new bm();
                    this.bCh.a(threadInfo.video_channel_info);
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
                        this.bBR.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.bCo.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.bCp = new bp();
                    this.bCp.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.bCq = new g();
                    this.bCq.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.bCr = new o();
                    this.bCr.a(threadInfo.cartoon_info);
                }
                this.bBX.setUserMap(this.userMap);
                this.bBX.parserProtobuf(threadInfo.zan);
                this.bBY.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBX.setTitle(this.title);
                } else {
                    this.bBX.setTitle(this.bBP);
                }
                this.bCu = threadInfo.livecover_src;
                this.bCv = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.bCn = threadInfo.post_num.intValue();
                this.bCy = threadInfo.freq_num.longValue();
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
                                this.bCe.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.bCw = noticeInfo.notice;
                    }
                    this.bCB = zhiBoInfoTW.copythread_remind.intValue();
                    this.bCz = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.bCA = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.bCu)) {
                        this.bCu = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.bCG = zhiBoInfoTW.user.tw_anchor_info;
                        this.bCH = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.bCx = threadInfo.twzhibo_info.livecover_status;
                    this.bCy = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.bCC = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.bCF.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.bCI.add(cVar);
                    }
                }
                this.bCJ.parserProtobuf(threadInfo.push_status);
                this.bCO = threadInfo.lego_card;
                this.bCL = threadInfo.skin_info;
                this.bCP = threadInfo.is_book_chapter.intValue();
                this.bCQ.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.bDd = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.bDb = threadInfo.last_read_pid.longValue();
                this.bDc = threadInfo.cheak_repeat.intValue() == 1;
                this.bDg = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.bDr.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.S(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.bzy = sparseArray;
                }
                this.bDm = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.bDt = new af();
                    this.bDt.a(threadInfo.link_info);
                }
                this.bDu = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.bDv = new f();
                    this.bDv.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.bDw = new MediaData();
                    this.bDw.parserProtobuf(threadInfo.pic_info);
                }
                this.bCW = threadInfo.is_called.intValue();
                this.bDx = threadInfo.middle_page_num.intValue();
                this.bDy = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.bDA = threadInfo.star_rank_icon.icon_pic_url;
                    this.bDB = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.bDz = new OriginalThreadInfo();
                    this.bDz.parser(threadInfo.origin_thread_info);
                } else if (this.isShareThread) {
                    this.bDz = new OriginalThreadInfo();
                    this.bDz.parser(threadInfo.origin_thread_info);
                } else {
                    this.bDz = null;
                }
                this.bDC = threadInfo.is_topic.intValue();
                this.bDD = threadInfo.topic_user_name;
                this.bDE = threadInfo.topic_h5_url;
                this.bDG = threadInfo.presentation_style;
                this.bDI = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.bDK = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.bBz = new bc();
                    this.bBz.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.bDM = threadInfo.swan_info;
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDM, this);
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
                this.bCj = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.bBC = jSONObject.optInt("repost_num", 0);
                this.bBD = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME);
                this.bBE = jSONObject.optLong("last_time_int", 0L);
                this.bBF = jSONObject.optInt("is_top", 0);
                this.bBG = jSONObject.optInt("is_membertop", 0);
                this.bBH = jSONObject.optInt("is_good", 0);
                this.bBI = jSONObject.optInt("is_livepost", 0);
                this.bBJ.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.bBK.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.bBL = this.forum_name;
                this.bBM = jSONObject.optInt("has_commented", 0);
                this.bBN = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.bBU = jSONObject.optInt("collect_status");
                this.bBV = jSONObject.optString("collect_mark_pid");
                this.bBW = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.bDn = jSONObject.optInt("agree_num");
                this.bDs = jSONObject.optLong("share_num");
                this.bBZ = jSONObject.optString("first_post_id", "0");
                this.bCl = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.bCa = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    this.bDp = optJSONObject2.optInt("has_agree");
                    this.bDn = optJSONObject2.optInt("agree_num");
                    this.bDo = optJSONObject2.optLong("disagree_num");
                    this.bDq = optJSONObject2.optInt("agree_type");
                    if (this.bDn < 0) {
                        this.bDn = 0L;
                    }
                    if (this.bDo < 0) {
                        this.bDo = 0L;
                    }
                    this.agreeData.threadId = this.tid;
                    this.agreeData.agreeNum = this.bDn;
                    this.agreeData.disAgreeNum = this.bDo;
                    this.agreeData.agreeType = optJSONObject2.optInt("agree_type", 0);
                    this.agreeData.hasAgree = optJSONObject2.optLong("has_agree", 0L) == 1;
                    this.agreeData.diffAgreeNum = optJSONObject2.optLong("diff_agree_num", 0L);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject3 != null) {
                    this.bCF.parserJson(optJSONObject3);
                }
                if ((this.bBK == null || this.bBK.getUserId() == null) && this.userMap != null) {
                    this.bBK = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("author");
                if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString(Headers.LOCATION);
                }
                this.bCi = new AlaInfoData();
                this.bCi.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.bBP = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bBQ.add(mediaData);
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
                        this.bBR.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.bCo.add(bVar);
                    }
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject5 != null) {
                    this.bCp = new bp();
                    this.bCp.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("app_code");
                if (optJSONObject6 != null) {
                    this.bCq = new g();
                    this.bCq.parserJson(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject7 != null) {
                    this.bCr = new o();
                    this.bCr.parserJson(optJSONObject7);
                }
                this.bBX.setUserMap(this.userMap);
                this.bBX.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.bBY.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.bBX.setTitle(this.title);
                } else {
                    this.bBX.setTitle(this.bBP);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("task_info");
                if (optJSONObject8 != null) {
                    this.bCF.parserJson(optJSONObject8);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.bCI.add(cVar);
                    }
                }
                this.bCP = jSONObject.optInt("is_book_chapter", 0);
                this.bCQ.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.bDd = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.bCX = jSONObject.optString("recom_extra_img");
                this.bDa = jSONObject.optString("recom_extra_img_night");
                this.bCY = jSONObject.optInt("recom_extra_img_width", 0);
                this.bCZ = jSONObject.optInt("recom_extra_img_height", 0);
                this.bDb = jSONObject.optLong("last_read_pid");
                this.bDc = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject9 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject9 != null) {
                    this.bCh = new bm();
                    this.bCh.aJ(optJSONObject9);
                }
                this.bDm = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject10 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject10 != null) {
                    this.bDt = new af();
                    this.bDt.parserJson(optJSONObject10);
                }
                this.bDu = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject11 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject11 != null) {
                    this.bDv = new f();
                    this.bDv.parserJson(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject12 != null) {
                    this.bDw = new MediaData();
                    this.bDw.parserJson(optJSONObject12);
                }
                this.bCW = jSONObject.optInt("is_called", 0);
                this.bDx = jSONObject.optInt("middle_page_num", 0);
                this.bDy = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.bCf = builder.build(true);
                    this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                    if (this.isShareThread) {
                        JSONObject optJSONObject14 = jSONObject.optJSONObject("origin_thread_info");
                        this.bDz = new OriginalThreadInfo();
                        this.bDz.parserJson(optJSONObject14);
                    } else {
                        this.bDz = null;
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
                    this.bDM = builder2.build(false);
                }
                if (this.threadType == 63 || this.threadType == 64) {
                    a(this.bDM, this);
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
        if (!StringUtils.isNull(this.bBK.getName_show())) {
            this.bDO = com.baidu.tbadk.core.util.ap.g(this.bBK.getName_show(), 14, "...");
        }
    }

    private void Zo() {
        if (YS()) {
            this.bDP = com.baidu.tbadk.core.util.ap.ap(YH() * 1000);
        } else {
            String ap = com.baidu.tbadk.core.util.ap.ap(YH() * 1000);
            if (com.baidu.tbadk.core.util.ap.mF(ap)) {
                ap = com.baidu.tbadk.core.util.ap.aq(YH() * 1000);
            }
            this.bDP = TbadkCoreApplication.getInst().getApp().getString(d.j.repley_when) + ap;
        }
        if (!StringUtils.isNull(getAddress())) {
            this.bDP += " • " + getAddress();
        }
    }

    private void Zp() {
        if (Zh() == null || Zh().share_info == null || Zh().share_info.share_user_count <= 0 || !aac() || (this.bDx > 0 && this.bDy == 0)) {
            this.bDQ = null;
            return;
        }
        int i = Zh().share_info.share_user_count;
        if (i == 1) {
            this.bDQ = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label_simple);
        } else {
            this.bDQ = TbadkCoreApplication.getInst().getString(d.j.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.ap.at(i)});
        }
    }

    private void Zq() {
        this.bDR = aao();
    }

    private void Zr() {
        this.bDS = aap();
    }

    private void Zs() {
        this.bDT = com.baidu.tbadk.core.util.ap.aq(YH() * 1000);
    }

    private void Zt() {
        this.bDU = com.baidu.tbadk.core.util.ap.aq(YH());
    }

    public SpannableStringBuilder Zu() {
        return this.bBO;
    }

    public boolean Zv() {
        return YJ() != 0;
    }

    public int Zw() {
        if (this.bCF != null) {
            long Yh = this.bCF.Yh();
            long Yi = this.bCF.Yi();
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
        if (Zz() && this.bCo.size() >= 1) {
            b bVar = this.bCo.get(0);
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
        if (!Zz() || this.bCo.size() < 1 || this.bCo.get(0) == null) {
            return -1;
        }
        return this.bCo.get(0).WS();
    }

    public boolean Zz() {
        return this.bCc == 1;
    }

    public String getActUrl() {
        return (!Zz() || this.bCo.size() < 1 || this.bCo.get(0) == null) ? "" : this.bCo.get(0).getUrl();
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
        return this.bDM;
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
            if (YL() == 1 || this.bBJ.aaL() != 0) {
                if (Yu() != null && getThreadType() == 41) {
                    if (Zw() == 2) {
                        arrayList.add(Integer.valueOf(d.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(d.f.icon_zhibo));
                }
            }
            if (z && ZO()) {
                Integer num = bCt.get(Integer.valueOf(Zw()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (YK() == 1 && !Zv() && bBh != getType() && bBm != getType()) {
                arrayList.add(Integer.valueOf(d.f.icon_elite));
            }
            if (this.bBY != null && this.bBY.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(d.f.icon_live_on));
            }
            if (YU() == 1) {
                arrayList.add(Integer.valueOf(d.f.frs_post_ding));
            }
            Integer num2 = bCs.get(new Point(Zy(), Zx()));
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
                kVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBy));
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
        this.bBO = spannableStringBuilder;
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
        this.bBO = spannableStringBuilder;
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
            if (this.bCa == 1) {
                this.bBO = a;
                return a;
            }
        } else if (this.bCa == 1) {
            this.bBO = new SpannableStringBuilder();
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
        this.bCK = str2;
    }

    private void a(SpannableString spannableString, String str, int i) {
        com.baidu.adp.widget.ImageView.a Z;
        com.baidu.adp.widget.ImageView.a Z2;
        BitmapDrawable bitmapDrawable;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(this.bCK) && !StringUtils.isNull(str)) {
            Bitmap bitmap = com.baidu.tbadk.imageManager.c.anm().getBitmap(this.mUrl);
            if ((bitmap == null || !com.baidu.tbadk.core.util.d.v.Y(this.mUrl, 10)) && (Z = com.baidu.tbadk.core.util.d.v.Z(this.mUrl, 10)) != null) {
                bitmap = Z.oy();
                com.baidu.tbadk.imageManager.c.anm().e(this.mUrl, bitmap);
            }
            Bitmap bitmap2 = com.baidu.tbadk.imageManager.c.anm().getBitmap(this.bCK);
            if ((bitmap2 == null || !com.baidu.tbadk.core.util.d.v.Y(this.bCK, 10)) && (Z2 = com.baidu.tbadk.core.util.d.v.Z(this.bCK, 10)) != null) {
                bitmap2 = Z2.oy();
                com.baidu.tbadk.imageManager.c.anm().e(this.bCK, bitmap2);
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
                        mVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.bBy));
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
            }, bBf);
            com.baidu.adp.lib.f.c.jB().a(this.bCK, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.core.data.bg.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i4) {
                    super.onLoaded((AnonymousClass3) aVar, str2, i4);
                    if (aVar != null) {
                        com.baidu.tbadk.imageManager.c.anm().e(str2, aVar.oy());
                    }
                }
            }, bBf);
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.bCS != null && this.bCS.size() > 0) {
            int size = this.bCS.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                final PbContent pbContent = this.bCS.get(i2);
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
        if (this.bCS != null && this.bCS.size() > 0) {
            int size = this.bCS.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.bCS.get(i);
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
            kVar.type = this.bBw;
            kVar.chx = this.bBx;
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
        return this.bBY;
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
        if (this.bCf != null && !StringUtils.isNull(this.bCf.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.bCf.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.bBK != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bBK.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean ZK() {
        String userId;
        return this.bBK == null || (userId = this.bBK.getUserId()) == null || userId.equals("0");
    }

    public boolean ZL() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aaC()) {
            if (Zf() != null) {
                return bBh;
            }
            return bAU;
        }
        int YJ = YJ();
        if (this.bCf != null && aat()) {
            return bBv;
        }
        if (this.bCi != null && this.threadType == 60) {
            return bBk;
        }
        if (this.bCi != null && this.threadType == 49) {
            return bBi;
        }
        if (this.threadType == 51) {
            return bBj;
        }
        if (this.threadType == 63) {
            return bBp;
        }
        if (this.threadType == 64) {
            return bBq;
        }
        if (YJ == 2 || YJ == 1) {
            return bAT;
        }
        if (this.bCf != null && ZU() && !ZL()) {
            return bBu;
        }
        if (this.bCf != null && !ZL()) {
            if (YR()) {
                return bBm;
            }
            return bBh;
        } else if (this.isShareThread) {
            return bBl;
        } else {
            if (ZN()) {
                return bBr.get() ? bCE : bAU;
            } else if (Zz() && Zy() == 1) {
                return bBr.get() ? bCM : bAU;
            } else if (isLinkThread()) {
                return bBf;
            } else {
                if (YR()) {
                    return bBg;
                }
                if (this.bDC == 1) {
                    return this.bDF != null ? bBo : bBn;
                } else if (this.bAJ) {
                    return bAY;
                } else {
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
                    if (this.bAP) {
                        return bBe;
                    }
                    if (this.bCm) {
                        int ZM = ZM();
                        if (ZM == 1) {
                            return bAV;
                        }
                        if (ZM == 2) {
                            return bAW;
                        }
                        if (ZM > 2) {
                            return bAX;
                        }
                        return bAU;
                    }
                    return bAU;
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
        if (this.bCa == 1) {
            this.bxV = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.bxV = 0;
        } else {
            this.bxV = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.Xa() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.Xa().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.bxV = next.Xb();
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
        return this.bCN;
    }

    public void dk(boolean z) {
        this.bCN = z;
    }

    public String ZQ() {
        return this.bCO;
    }

    public o ZR() {
        return this.bCr;
    }

    public void ZS() {
        if (this.bCk == 0) {
            this.bCk = 1;
        }
    }

    public boolean ZT() {
        return this.bCU;
    }

    public void dl(boolean z) {
        this.bDe = z;
    }

    public boolean ZU() {
        return this.bDe;
    }

    public void gw(int i) {
        this.bDf = i + 1;
    }

    public int ZV() {
        return this.bDf;
    }

    public List<ReportInfo> ZW() {
        return this.bDg;
    }

    public boolean ZX() {
        return this.bCV;
    }

    public void dm(boolean z) {
        this.bCV = z;
    }

    public bm ZY() {
        return this.bCh;
    }

    public void a(bm bmVar) {
        this.bCh = bmVar;
    }

    public void setCurrentPage(int i) {
        if (this.bCh != null) {
            this.bCh.mCurrentPage = i;
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
        return this.bDl;
    }

    public void setSmartFrsPosition(int i) {
        this.bDl = i;
    }

    public SparseArray<String> Xx() {
        return this.bzy;
    }

    public String aaf() {
        return this.mRecomSource;
    }

    public boolean aag() {
        return this.bDm;
    }

    public long aah() {
        return this.bDn;
    }

    public long aai() {
        return this.bDo;
    }

    public int aaj() {
        return this.bDp;
    }

    public int aak() {
        return this.bDq;
    }

    public void gx(int i) {
        this.bDp = i;
    }

    public void gy(int i) {
        this.bDn = i;
    }

    public void af(long j) {
        this.bDn = j;
    }

    public void ag(long j) {
        this.bDo = j;
    }

    public void gz(int i) {
        this.bDq = i;
    }

    public long aal() {
        return this.bDs;
    }

    public void ah(long j) {
        this.bDs = j;
    }

    public PostData aam() {
        return this.bDr;
    }

    public af aan() {
        return this.bDt;
    }

    public SpannableStringBuilder c(boolean z, boolean z2, boolean z3) {
        String H;
        SpannableString a;
        SpannableStringBuilder spannableStringBuilder;
        if (this.bCa == 1) {
            H = H(this.bBP, true);
            a = lm(this.bBP);
        } else {
            H = H(this.title, false);
            a = a(new SpannableString(H + " "));
        }
        if (z) {
            spannableStringBuilder = a(H, a, z, true, z2, z3);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(a);
        }
        this.bBO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder l(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    public SpannableStringBuilder m(boolean z, boolean z2) {
        SpannableString lm;
        if (!StringUtils.isNull(this.title) && this.bCa != 1) {
            lm = a(new SpannableString(H(this.title, false) + " "));
        } else {
            lm = lm(this.bBP);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(lm);
        this.bBO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aao() {
        if (StringUtils.isNull(this.title) || this.bCa == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a(new SpannableString(H(this.title, false) + " ")));
        this.bBO = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableString aap() {
        return lm(this.bBP);
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
                    arrayList.add(bDi.get(Zw()));
                }
                if (Zz()) {
                    Integer num = bDh.get(new Point(Zy(), Zx()));
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
                    Integer num2 = bDh.get(new Point(Zy(), Zx()));
                    if (num2 != null) {
                        arrayList.add(new n.a(num2.intValue(), d.C0277d.cp_other_b, d.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new n.a(d.j.card_promotion_text));
                    }
                }
                if (this.bCP == 1) {
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
        this.bBQ = arrayList;
    }

    public String aaq() {
        return this.bDD;
    }

    public void lr(String str) {
        this.bDD = str;
    }

    public void aar() {
        this.bDC = 1;
    }

    public boolean aas() {
        return this.bDC == 1;
    }

    public boolean aat() {
        return this.bDG.equals("worldcupvideo");
    }

    public String aau() {
        return this.bBA;
    }

    public void ls(String str) {
        this.bBA = str;
    }

    public String aav() {
        return this.bBB;
    }

    public void lt(String str) {
        this.bBB = str;
    }

    public String aaw() {
        return this.bDE;
    }

    public void lu(String str) {
        this.bDE = str;
    }

    public boolean aax() {
        return this.bDH;
    }

    public void dn(boolean z) {
        this.bDH = z;
    }

    public void a(VideoInfo videoInfo) {
        this.bDF = videoInfo;
    }

    public boolean aay() {
        return this.bDI != null;
    }

    public String aaz() {
        return this.bBL;
    }

    public String aaA() {
        return this.bDK;
    }

    public bc aaB() {
        return this.bBz;
    }

    public boolean aaC() {
        return this.bDL;
    }

    /* renamed from: do  reason: not valid java name */
    public void m18do(boolean z) {
        this.bDL = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bCf != null) {
            return this.bCf.video_url;
        }
        return null;
    }

    public boolean aaD() {
        return this.bDN;
    }

    public void dp(boolean z) {
        this.bDN = z;
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

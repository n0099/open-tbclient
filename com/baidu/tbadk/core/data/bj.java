package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
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
public class bj extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.f.a {
    private String address;
    private String authorId;
    private String awC;
    public int cPT;
    private SpannableString cPZ;
    public int cSG;
    private int cSH;
    private int cSK;
    public int cSL;
    private String cSO;
    private String cSP;
    private int cSR;
    private VideoInfo cST;
    private VideoDesc cSU;
    private bq cSV;
    private AlaInfoData cSW;
    private long cSX;
    private int cSj;
    private SpannableStringBuilder cSo;
    private SpannableStringBuilder cSp;
    private bf cSq;
    private String cSr;
    private String cSs;
    private boolean cTA;
    private String cTB;
    private boolean cTE;
    public String cTG;
    public int cTH;
    public int cTI;
    public String cTJ;
    public String cTK;
    public long cTL;
    private List<ReportInfo> cTP;
    private boolean cTV;
    private long cTX;
    private ag cTY;
    private p cTf;
    private LiveCoverStatus cTl;
    private long cTm;
    public TwZhiBoUser cTt;
    public List<TwAnchorProfitItem> cTu;
    private SkinInfo cTy;
    private boolean cUC;
    private boolean cUD;
    private boolean cUE;
    public boolean cUF;
    public boolean cUG;
    public boolean cUH;
    public String cUI;
    private int cUJ;
    private String cUK;
    private int cUL;
    public String cUN;
    public f cUa;
    private MediaData cUb;
    public int cUc;
    public OriginalThreadInfo cUe;
    private TopicModule cUi;
    private String cUj;
    private String cUk;
    private VideoInfo cUl;
    private String cUm;
    public OriginalForumInfo cUo;
    public boolean cUp;
    private String cUq;
    private boolean cUr;
    private SmartApp cUs;
    private String cUu;
    private String cUv;
    private String cUw;
    private String cUx;
    private String cUy;
    public String cUz;
    public boolean isBigGie;
    private boolean isLinkThread;
    public boolean isPrivacy;
    public boolean isShareThread;
    private String latitude;
    private BaijiahaoData mBaijiahao;
    private long mCreateTime;
    public String mRecomAbTag;
    public String mRecomExtra;
    public String mRecomSource;
    public String mRecomWeight;
    private int mTabId;
    private String mTabName;
    public String noCommetStr;
    private int post_num;
    public int sortType;
    public int threadType;
    public String thread_share_link;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId cRw = BdUniqueId.gen();
    public static final BdUniqueId cRx = BdUniqueId.gen();
    public static final BdUniqueId cRy = BdUniqueId.gen();
    public static final BdUniqueId cRz = BdUniqueId.gen();
    public static final BdUniqueId cRA = BdUniqueId.gen();
    public static final BdUniqueId cRB = BdUniqueId.gen();
    public static final BdUniqueId cRC = BdUniqueId.gen();
    public static final BdUniqueId cRD = BdUniqueId.gen();
    public static final BdUniqueId cRE = BdUniqueId.gen();
    public static final BdUniqueId cRF = BdUniqueId.gen();
    public static final BdUniqueId cRG = BdUniqueId.gen();
    public static final BdUniqueId cRH = BdUniqueId.gen();
    public static final BdUniqueId cRI = BdUniqueId.gen();
    public static final BdUniqueId cRJ = BdUniqueId.gen();
    public static final BdUniqueId cRK = BdUniqueId.gen();
    public static final BdUniqueId cRL = BdUniqueId.gen();
    public static final BdUniqueId cRM = BdUniqueId.gen();
    public static final BdUniqueId cRN = BdUniqueId.gen();
    public static final BdUniqueId cRO = BdUniqueId.gen();
    public static final BdUniqueId cRP = BdUniqueId.gen();
    public static final BdUniqueId cRQ = BdUniqueId.gen();
    public static final BdUniqueId cRR = BdUniqueId.gen();
    public static final BdUniqueId cRS = BdUniqueId.gen();
    public static final BdUniqueId cRT = BdUniqueId.gen();
    public static final BdUniqueId cRU = BdUniqueId.gen();
    public static final BdUniqueId cRV = BdUniqueId.gen();
    public static final BdUniqueId cRW = BdUniqueId.gen();
    public static final BdUniqueId cRX = BdUniqueId.gen();
    public static final BdUniqueId cRY = BdUniqueId.gen();
    public static final BdUniqueId cRZ = BdUniqueId.gen();
    public static final BdUniqueId cSa = BdUniqueId.gen();
    public static AtomicBoolean cSb = new AtomicBoolean(false);
    public static AtomicBoolean cSc = new AtomicBoolean(false);
    public static AtomicBoolean cSd = new AtomicBoolean(false);
    public static final BdUniqueId cSe = BdUniqueId.gen();
    public static final BdUniqueId cSf = BdUniqueId.gen();
    private static HashMap<Point, Integer> cTg = new HashMap<>();
    private static HashMap<Integer, Integer> cTh = new HashMap<>();
    public static final BdUniqueId cTr = BdUniqueId.gen();
    public static final BdUniqueId cTz = BdUniqueId.gen();
    private static HashMap<Point, Integer> cTQ = new HashMap<>();
    private static SparseArray<l.a> cTR = new SparseArray<>(3);
    public boolean cRi = false;
    public boolean cRj = false;
    public boolean cRk = false;
    public boolean cRl = false;
    public boolean cRm = false;
    public boolean cRn = false;
    public boolean cRo = false;
    public boolean cRp = false;
    private int cSg = 0;
    private String cSh = "1";
    public int cSi = 1;
    private String cSJ = null;
    private int cOx = 0;
    public int cSY = 0;
    private String cSZ = "";
    public boolean cTa = false;
    private String cTi = "";
    public boolean cTM = true;
    public boolean cTS = false;
    public boolean cTT = false;
    private int cTU = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cTZ = false;
    private int cUh = 0;
    private boolean cUn = false;
    private boolean cUt = false;
    public boolean cUA = false;
    public boolean cUB = false;
    public boolean forbidComment = false;
    public boolean cUM = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cSt = 0;
    private int cSu = 0;
    private String last_time = null;
    private long cSv = 0;
    private int cSw = 0;
    private int cSx = 0;
    private int cSy = 0;
    private int cSz = 0;
    private bn cSA = new bn();
    private MetaData cSB = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cSE = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cSF = new ArrayList<>();
    private int cSC = 0;
    private int cSD = 0;
    private String ad_url = null;
    private String cSk = null;
    private String from = null;
    private int cSI = 0;
    private PraiseData cSM = new PraiseData();
    private AnchorInfoData cSN = new AnchorInfoData();
    private long time = 0;
    private int cSQ = 0;
    private ArrayList<b> cTc = new ArrayList<>();
    private bv cTd = null;
    private g cTe = null;
    private int cTj = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cSS = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cTk = null;
    private int cTb = 0;
    private boolean cTn = false;
    private boolean cTo = false;
    private int cTp = 0;
    private boolean cTq = false;
    private int anchorLevel = 0;
    public int cTC = 0;
    public m cTD = new m();
    private List<PbContent> cSn = new ArrayList();
    private List<PbContent> cSl = new ArrayList();
    private List<PbContent> cSm = new ArrayList();
    private String category_name = null;
    private bh cTs = new bh();
    private ArrayList<com.baidu.tbadk.data.c> cTv = new ArrayList<>();
    private PushStatusData cTw = new PushStatusData();
    public boolean cTN = false;
    public int cTO = -1;
    private PostData cTW = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cTF = 0;
    public int cUd = 0;
    private String tieba_game_information_source = "";
    public String cUg = "";
    public String cUf = "";
    public String mUrl = "";
    public String cTx = "";

    static {
        cTg.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        cTg.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        cTg.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        cTg.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        cTg.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        cTg.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        cTg.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        cTg.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cTQ.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cTQ.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cTQ.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cTQ.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cTQ.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cTQ.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cTQ.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cTQ.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cTh.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cTh.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cTh.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cTR.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cTR.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cTR.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.cSH = 0;
        this.cSR = 0;
        this.cTm = 0L;
        this.cUc = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cTm = 0L;
        this.cSR = 0;
        this.cSH = 0;
        this.cUc = 0;
        this.isBigGie = false;
    }

    public String aBP() {
        return this.cUu;
    }

    public String aBQ() {
        return this.cUv;
    }

    public void sD(String str) {
        this.cUv = str;
    }

    public String aBR() {
        return this.cUw;
    }

    public SpannableStringBuilder aBS() {
        return this.cSp;
    }

    public SpannableString aBT() {
        return this.cPZ;
    }

    public void a(SpannableString spannableString) {
        if (aCr() != null) {
            if (this.cSp != null) {
                this.cSp.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cPZ);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.cPZ = new SpannableString(spannableStringBuilder);
        }
    }

    public String aBU() {
        return this.cUx;
    }

    public String aBV() {
        return this.cUy;
    }

    public boolean aBW() {
        return this.cSH == 1;
    }

    public bh aBX() {
        return this.cTs;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jG(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.cSR;
    }

    public void jH(int i) {
        this.cTp = i;
    }

    public int aBY() {
        return this.cTp;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aBZ() {
        return this.cUl;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bu(long j) {
        this.mCreateTime = j;
    }

    public long aCa() {
        return this.cSX;
    }

    public String aCb() {
        return this.cSO;
    }

    public PraiseData aCc() {
        return this.cSM;
    }

    public void a(PraiseData praiseData) {
        this.cSM = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aCd() {
        return this.awC;
    }

    public void sE(String str) {
        this.awC = str;
    }

    public String aCe() {
        return this.cSh;
    }

    public void sF(String str) {
        this.cSh = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jI(int i) {
        this.cSg = i;
    }

    public int aCf() {
        return this.cSg;
    }

    public String aCg() {
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

    public List<PbContent> aCh() {
        return this.cSn;
    }

    public void aw(List<PbContent> list) {
        this.cSn = list;
    }

    public void ax(List<PbContent> list) {
        this.cSl = list;
    }

    public void ay(List<PbContent> list) {
        this.cSm = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void jJ(int i) {
        this.reply_num = i;
    }

    public int aCi() {
        return this.reply_num;
    }

    public int aCj() {
        return this.cSu;
    }

    public void jK(int i) {
        this.cSu = i;
    }

    public long aCk() {
        return this.cSv;
    }

    public void bv(long j) {
        this.cSv = j;
    }

    public int aCl() {
        return this.cSx;
    }

    public int aCm() {
        return this.cSw;
    }

    public void jL(int i) {
        this.cSw = i;
    }

    public int aCn() {
        return this.cSy;
    }

    public void jM(int i) {
        this.cSy = i;
    }

    public int aCo() {
        return this.cSz;
    }

    public List<PbContent> aCp() {
        return this.cSl;
    }

    public bn aCq() {
        return this.cSA;
    }

    public MetaData aCr() {
        return this.cSB;
    }

    public boolean aCs() {
        return this.is_god != 0;
    }

    public boolean aCt() {
        return this.is_god == 1;
    }

    public boolean aCu() {
        return (this.cSB == null || this.cSB.getGodUserData() == null || this.cSB.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aCv() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cSB = metaData;
    }

    public String aCw() {
        return this.forum_name;
    }

    public void sG(String str) {
        this.forum_name = str;
    }

    public int aCx() {
        return this.cSD;
    }

    public String aCy() {
        return this.ad_url;
    }

    public int aCz() {
        return this.cSI;
    }

    public void jN(int i) {
        this.cSI = i;
    }

    public String aCA() {
        return this.cSJ;
    }

    public void sH(String str) {
        this.cSJ = str;
    }

    public ArrayList<MediaData> aCB() {
        return this.cSE;
    }

    public ArrayList<b> aCC() {
        return this.cTc;
    }

    public void x(ArrayList<b> arrayList) {
        this.cTc = arrayList;
    }

    public bv aCD() {
        return this.cTd;
    }

    public g aCE() {
        return this.cTe;
    }

    public ArrayList<VoiceData.VoiceModel> aCF() {
        return this.cSF;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aCG() {
        return this.cSj;
    }

    public void jO(int i) {
        this.cSj = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aCH() {
        return this.cSZ;
    }

    public VideoInfo aCI() {
        return this.cST;
    }

    public void a(VideoInfo videoInfo) {
        this.cST = videoInfo;
    }

    public VideoDesc aCJ() {
        return this.cSU;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cSW = alaInfoData;
    }

    public AlaInfoData aCK() {
        return this.cSW;
    }

    public PushStatusData aCL() {
        return this.cTw;
    }

    public SkinInfo aCM() {
        return this.cTy;
    }

    public long aCN() {
        return this.cTL;
    }

    public boolean aCO() {
        return this.cTM;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAj() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAk() {
        return this.cTK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAl() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAj().getTid());
        alVar.setFid(aAj().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.cPS = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.cPT = this.cPT;
        alVar.cardType = aEp();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cSP = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cSH = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cSX = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cSt = threadInfo.repost_num.intValue();
                this.cSu = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cSv = threadInfo.last_time_int.intValue();
                this.cSw = threadInfo.is_top.intValue();
                this.cSx = threadInfo.is_membertop.intValue();
                this.cSy = threadInfo.is_good.intValue();
                this.cSz = threadInfo.is_livepost.intValue();
                this.cSA.a(threadInfo.topic);
                this.cSB.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cSC = threadInfo.has_commented.intValue();
                this.cSD = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cST = threadInfo.video_info;
                this.cSU = threadInfo.video_segment;
                this.cSW = new AlaInfoData();
                this.cSW.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cSI = threadInfo.collect_status.intValue();
                this.cSJ = threadInfo.collect_mark_pid;
                this.cSK = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cSL = threadInfo.thread_type.intValue();
                this.cSO = threadInfo.first_post_id + "";
                this.cSZ = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cSj = threadInfo.is_ntitle.intValue();
                this.cSQ = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cTX = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cSR = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cTE = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cSl = threadInfo.rich_title;
                this.cSn = threadInfo.first_post_content;
                this.cSm = threadInfo.rich_abstract;
                this.cSG = threadInfo.is_godthread_recommend.intValue();
                if ((this.cSB == null || this.cSB.getUserId() == null || this.cSB.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSB = metaData;
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
                this.cSk = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cSE.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cST = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cSV = new bq();
                    this.cSV.a(threadInfo.video_channel_info);
                }
                List<Voice> list3 = threadInfo.voice_info;
                if (list3 != null) {
                    int size = list3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        Voice voice = list3.get(i3);
                        voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                        voiceModel.voiceId = voice.voice_md5;
                        voiceModel.duration = voice.during_time.intValue() / 1000;
                        this.cSF.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cTc.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cTd = new bv();
                    this.cTd.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.cTe = new g();
                    this.cTe.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.cTf = new p();
                    this.cTf.a(threadInfo.cartoon_info);
                }
                this.cSM.setUserMap(this.userMap);
                this.cSM.parserProtobuf(threadInfo.zan);
                this.cSN.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSM.setTitle(this.title);
                } else {
                    this.cSM.setTitle(this.cSk);
                }
                this.cTi = threadInfo.livecover_src;
                this.cTj = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cTb = threadInfo.post_num.intValue();
                this.cTm = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.mb(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.uF(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cSS.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cTk = noticeInfo.notice;
                    }
                    this.cTp = zhiBoInfoTW.copythread_remind.intValue();
                    this.cTn = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cTo = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.cTi)) {
                        this.cTi = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cTt = zhiBoInfoTW.user.tw_anchor_info;
                        this.cTu = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cTl = threadInfo.twzhibo_info.livecover_status;
                    this.cTm = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cTq = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cTs.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cTv.add(cVar);
                    }
                }
                this.cTw.parserProtobuf(threadInfo.push_status);
                this.cTB = threadInfo.lego_card;
                this.cTy = threadInfo.skin_info;
                this.cTC = threadInfo.is_book_chapter.intValue();
                this.cTD.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cTK = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cTL = threadInfo.last_read_pid.longValue();
                this.cTM = threadInfo.cheak_repeat.intValue() == 1;
                this.cTP = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cTW.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.v.getCount(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.feedBackReasonMap = sparseArray;
                }
                this.cTV = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cTY = new ag();
                    this.cTY.a(threadInfo.link_info);
                }
                this.cTZ = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cUa = new f();
                    this.cUa.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cUb = new MediaData();
                    this.cUb.parserProtobuf(threadInfo.pic_info);
                }
                this.cTF = threadInfo.is_called.intValue();
                this.cUc = threadInfo.middle_page_num.intValue();
                this.cUd = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cUf = threadInfo.star_rank_icon.icon_pic_url;
                    this.cUg = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cUe = new OriginalThreadInfo();
                    this.cUe.a(threadInfo.origin_thread_info);
                } else {
                    this.cUe = null;
                    this.isShareThread = false;
                }
                this.cUh = threadInfo.is_topic.intValue();
                this.cUj = threadInfo.topic_user_name;
                this.cUk = threadInfo.topic_h5_url;
                this.cUi = threadInfo.topic_module;
                this.cUm = threadInfo.presentation_style;
                this.cUo = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cUq = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cSq = new bf();
                    this.cSq.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cUs = threadInfo.swan_info;
                }
                this.cUz = threadInfo.t_share_img;
                this.cUA = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.cUK = threadInfo.article_cover;
                this.cUL = threadInfo.bjh_content_tag.intValue();
                this.cUJ = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUM = threadInfo.is_s_card.intValue() == 1;
                this.cUN = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                aCP();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Deprecated
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
                this.cSX = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cSt = jSONObject.optInt("repost_num", 0);
                this.cSu = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cSv = jSONObject.optLong("last_time_int", 0L);
                this.cSw = jSONObject.optInt("is_top", 0);
                this.cSx = jSONObject.optInt("is_membertop", 0);
                this.cSy = jSONObject.optInt("is_good", 0);
                this.cSz = jSONObject.optInt("is_livepost", 0);
                this.cSA.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cSB.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cSC = jSONObject.optInt("has_commented", 0);
                this.cSD = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cSI = jSONObject.optInt("collect_status");
                this.cSJ = jSONObject.optString("collect_mark_pid");
                this.cSK = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cSL = jSONObject.optInt("thread_type");
                this.cTX = jSONObject.optLong("share_num");
                this.cSO = jSONObject.optString("first_post_id", "0");
                this.cSZ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cSj = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.cTs.parserJson(optJSONObject2);
                }
                if ((this.cSB == null || this.cSB.getUserId() == null) && this.userMap != null) {
                    this.cSB = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.cSW = new AlaInfoData();
                this.cSW.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.cSk = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cSE.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.cSF.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cTc.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.cTd = new bv();
                    this.cTd.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.cTe = new g();
                    this.cTe.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.cTf = new p();
                    this.cTf.parserJson(optJSONObject6);
                }
                this.cSM.setUserMap(this.userMap);
                this.cSM.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cSN.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSM.setTitle(this.title);
                } else {
                    this.cSM.setTitle(this.cSk);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.cTs.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cTv.add(cVar);
                    }
                }
                this.cTC = jSONObject.optInt("is_book_chapter", 0);
                this.cTD.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cTK = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cTG = jSONObject.optString("recom_extra_img");
                this.cTJ = jSONObject.optString("recom_extra_img_night");
                this.cTH = jSONObject.optInt("recom_extra_img_width", 0);
                this.cTI = jSONObject.optInt("recom_extra_img_height", 0);
                this.cTL = jSONObject.optLong("last_read_pid");
                this.cTM = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.cSV = new bq();
                    this.cSV.ci(optJSONObject8);
                }
                this.cTV = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.cTY = new ag();
                    this.cTY.parserJson(optJSONObject9);
                }
                this.cTZ = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.cUa = new f();
                    this.cUa.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.cUb = new MediaData();
                    this.cUb.parserJson(optJSONObject11);
                }
                this.cTF = jSONObject.optInt("is_called", 0);
                this.cUc = jSONObject.optInt("middle_page_num", 0);
                this.cUd = jSONObject.optInt("middle_page_pass_flag", 0);
                JSONObject optJSONObject12 = jSONObject.optJSONObject(WriteVideoActivityConfig.VIDEO_INFO);
                if (optJSONObject12 != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.thumbnail_width = new Integer(optJSONObject12.optInt("thumbnail_width", 0));
                    builder.thumbnail_height = new Integer(optJSONObject12.optInt("thumbnail_height", 0));
                    builder.video_md5 = optJSONObject12.optString("video_md5");
                    builder.video_url = optJSONObject12.optString("video_url");
                    builder.video_duration = new Integer(optJSONObject12.optInt("video_duration", 0));
                    builder.video_width = new Integer(optJSONObject12.optInt("video_width", 0));
                    builder.video_height = new Integer(optJSONObject12.optInt("video_height", 0));
                    builder.video_length = new Integer(optJSONObject12.optInt("video_size", 0));
                    builder.video_type = new Integer(optJSONObject12.optInt(LogConfig.LOG_VIDEO_TYPE, 0));
                    builder.thumbnail_url = optJSONObject12.optString("thumbnail_url");
                    builder.play_count = new Integer(optJSONObject12.optInt("play_count", 0));
                    builder.is_vertical = new Integer(optJSONObject12.optInt("is_vertical", 0));
                    builder.mcn_lead_page = new String(optJSONObject12.optString("mcn_lead_page"));
                    this.cST = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.cUe = new OriginalThreadInfo();
                        this.cUe.parserJson(optJSONObject13);
                    } else {
                        this.cUe = null;
                    }
                } else {
                    this.cUe = null;
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject14 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject14.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder2.name = optJSONObject14.optString("name");
                    builder2._abstract = optJSONObject14.optString("abstract");
                    builder2.pic = optJSONObject14.optString("pic");
                    builder2.h5_url = optJSONObject14.optString("h5_url");
                    builder2.id = optJSONObject14.optString("id");
                    builder2.link = optJSONObject14.optString("link");
                    this.cUs = builder2.build(false);
                }
                this.cUz = jSONObject.optString("t_share_img");
                this.cUA = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.cUJ = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.cUL = jSONObject.optInt("bjh_content_tag");
                this.cUK = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUM = jSONObject.optInt("is_s_card", 0) == 1;
                this.cUN = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                aCP();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aCP() {
        aCQ();
        aCR();
        aCT();
        aCU();
        aCV();
        aCW();
        aCX();
    }

    private void aCQ() {
        if (!StringUtils.isNull(this.cSB.getName_show())) {
            this.cUu = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cSB.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aCR() {
        if (aEm() || aEf()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String bD = com.baidu.tbadk.core.util.aq.bD(j);
                if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                    bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.cUv = bD;
            }
            String str = "";
            if (this.cSB != null && this.cSB.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.cSB.getBaijiahaoInfo().auth_desc)) {
                str = this.cSB.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.cUv) && !TextUtils.isEmpty(str)) {
                this.cUv += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.cUv = str;
                return;
            } else {
                return;
            }
        }
        if (aCv()) {
            long aCk = aCk() * 1000;
            if (aCk != 0) {
                this.cUv = com.baidu.tbadk.core.util.aq.bD(aCk);
            }
        } else {
            long aCk2 = 1000 * aCk();
            if (aCk2 != 0) {
                String bD2 = com.baidu.tbadk.core.util.aq.bD(aCk2);
                if (com.baidu.tbadk.core.util.aq.ty(bD2)) {
                    bD2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCk2);
                }
                this.cUv = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + bD2;
            }
        }
        if (!TextUtils.isEmpty(this.cUv) && !TextUtils.isEmpty(getAddress())) {
            this.cUv += " • " + getAddress();
        }
    }

    public void aCS() {
        if (!aEm() && !aEf()) {
            if (!aCv()) {
                long aCk = 1000 * aCk();
                if (aCk != 0) {
                    String bD = com.baidu.tbadk.core.util.aq.bD(aCk);
                    if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                        bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCk);
                    }
                    this.cUv = bD;
                }
            }
            if (!TextUtils.isEmpty(this.cUv) && !TextUtils.isEmpty(getAddress())) {
                this.cUv += " • " + getAddress();
            }
        }
    }

    private void aCT() {
        if (aCK() == null || aCK().share_info == null || aCK().share_info.share_user_count <= 0 || !aDH() || (this.cUc > 0 && this.cUd == 0)) {
            this.cUw = null;
            return;
        }
        int i = aCK().share_info.share_user_count;
        if (i == 1) {
            this.cUw = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cUw = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aCU() {
        this.cSp = aDl();
        com.baidu.tieba.card.l.a(this, this.cSp, true);
    }

    private void aCV() {
        this.cPZ = aDj();
    }

    private void aCW() {
        this.cUx = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCk() * 1000);
    }

    private void aCX() {
        this.cUy = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCk());
    }

    public SpannableStringBuilder aCY() {
        return this.cSo;
    }

    public boolean isTop() {
        return aCm() != 0;
    }

    public int aCZ() {
        if (this.cTs != null) {
            long aBK = this.cTs.aBK();
            long aBL = this.cTs.aBL();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aBK) {
                return 1;
            }
            if (currentTimeMillis > aBL) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aDa() {
        if (aDc() && this.cTc.size() >= 1) {
            b bVar = this.cTc.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aAo = bVar.aAo();
            int aAp = bVar.aAp();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aAo) {
                return 4;
            }
            return currentTimeMillis > aAp ? 2 : 1;
        }
        return -1;
    }

    public int aDb() {
        if (!aDc() || this.cTc.size() < 1 || this.cTc.get(0) == null) {
            return -1;
        }
        return this.cTc.get(0).aAn();
    }

    public boolean aDc() {
        return this.cSQ == 1;
    }

    public String getActUrl() {
        return (!aDc() || this.cTc.size() < 1 || this.cTc.get(0) == null) ? "" : this.cTc.get(0).getUrl();
    }

    private com.baidu.adp.widget.b sI(String str) {
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

    public SmartApp aDd() {
        return this.cUs;
    }

    private void s(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aDf()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aCm() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aCm() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aCo() == 1 || this.cSA.aEx() != 0) {
                if (aBX() != null && getThreadType() == 41) {
                    if (aCZ() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aDw()) {
                Integer num = cTh.get(Integer.valueOf(aCZ()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aCn() == 1 && !isTop() && cRN != getType() && cRV != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cSN != null && this.cSN.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aCx() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = cTg.get(new Point(aDb(), aDa()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aCD() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aCE() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = sI(this.category_name);
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
                spannableString = new SpannableString(sb2 + this.category_name + HanziToPinyin.Token.SEPARATOR);
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cSi));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aDg = aDg();
        if (aDg != null) {
            spannableStringBuilder.append((CharSequence) aDg);
        }
        this.cSo = spannableStringBuilder;
    }

    public boolean aDe() {
        return false;
    }

    public SpannableString a(ClickableSpan clickableSpan) {
        if (clickableSpan == null) {
            return null;
        }
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds8);
        Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(R.drawable.icon_card_video_jump);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aCr() != null) {
            if (aCr().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aCr().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(kVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean aDf() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void t(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            u(z, z3);
            return;
        }
        SpannableStringBuilder aDg = aDg();
        if (z) {
            spannableStringBuilder = a(aDg.toString(), aDg, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aDg);
        }
        this.cSo = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.l.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.cSj == 1) {
                this.cSo = a;
                return a;
            }
        } else if (this.cSj == 1) {
            this.cSo = new SpannableStringBuilder();
            return a;
        }
        if (spannableStringBuilder != null) {
            a.append((CharSequence) spannableStringBuilder);
            return a;
        } else if (b.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public void co(String str, String str2) {
        this.mUrl = str;
        this.cTx = str2;
    }

    public SpannableStringBuilder aDg() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cSl, this.title);
    }

    public SpannableStringBuilder aDh() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cSm, this.cSk);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aDi() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.cUM) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aDj() {
        SpannableStringBuilder aDh = aDh();
        com.baidu.tieba.card.l.a(this, aDh, false);
        return new SpannableString(aDh);
    }

    public SpannableString aDk() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cSn)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.cSn, this.cSk));
    }

    public String getAbstract() {
        return this.cSk;
    }

    public void sJ(String str) {
        this.cSk = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aDg;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.cSj == 1) {
            aDg = aDh();
            spannableStringBuilder = aDg.toString();
        } else {
            aDg = aDg();
            spannableStringBuilder = aDg.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aDg, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aDg);
        }
        this.cSo = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder u(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder v(boolean z, boolean z2) {
        SpannableStringBuilder aDh;
        if (!StringUtils.isNull(this.title) && this.cSj != 1) {
            aDh = aDg();
        } else {
            aDh = aDh();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDh);
        this.cSo = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aDl() {
        if (StringUtils.isNull(this.title) || this.cSj == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDg());
        this.cSo = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aBd() {
        if (this.cSl != null && this.cSl.size() > 0) {
            int size = this.cSl.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cSl.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aBe() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vN(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aDm() {
        s(false, false);
    }

    public void aDn() {
        s(false, true);
    }

    public AnchorInfoData aDo() {
        return this.cSN;
    }

    public boolean aDp() {
        return this.threadType == 36;
    }

    public boolean aBe() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aDq() {
        return this.threadType == 11 || this.cSK == 1;
    }

    public boolean aDr() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aCB = aCB();
        if (aCB == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aCB.size() || i2 >= 3) {
                break;
            }
            if (aCB.get(i2) != null && aCB.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aCB.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aCB.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aCB.get(i2).getPicUrl();
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
        if (this.cST != null && !StringUtils.isNull(this.cST.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cST.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cSB != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cSB.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aDs() {
        String userId;
        return this.cSB == null || (userId = this.cSB.getUserId()) == null || userId.equals("0");
    }

    public boolean aDt() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aEc()) {
            if (aCI() != null) {
                return cRN;
            }
            return cRx;
        }
        int aCm = aCm();
        if (this.cUh == 1) {
            if (this.cUi != null) {
                return cRJ;
            }
            return this.cUl != null ? cRX : cRW;
        } else if (this.cSW != null && this.threadType == 60) {
            return cRQ;
        } else {
            if (this.cSW != null && this.threadType == 49) {
                return cRO;
            }
            if (this.threadType == 51) {
                return cRP;
            }
            if (this.threadType == 63) {
                return cRY;
            }
            if (this.threadType == 64) {
                return cRZ;
            }
            if (aCm == 2 || aCm == 1) {
                return cRw;
            }
            if (this.cST != null && aDB() && !aDt()) {
                return cSe;
            }
            if (this.cST != null && !aDt()) {
                if (aCu()) {
                    return cRV;
                }
                return cRN;
            } else if (this.isShareThread && this.cUe != null) {
                if (this.cUe.cQa) {
                    if (this.cUe.videoInfo != null) {
                        return cRU;
                    }
                    if (this.cUe.aBg()) {
                        return cRT;
                    }
                    return cRS;
                }
                return cRR;
            } else if (aBg()) {
                return cRK;
            } else {
                if (aDv()) {
                    return cSb.get() ? cTr : cRx;
                } else if (aDc() && aDb() == 1) {
                    return cSb.get() ? cTz : cRx;
                } else if (isLinkThread()) {
                    return cRL;
                } else {
                    if (aCu()) {
                        return cRM;
                    }
                    if (this.cRi) {
                        return cRB;
                    }
                    if (this.cRj) {
                        return cRC;
                    }
                    if (this.cRk) {
                        return cRD;
                    }
                    if (this.cRl) {
                        return cRE;
                    }
                    if (this.cRm) {
                        return cRF;
                    }
                    if (this.cRo) {
                        return cRH;
                    }
                    if (this.cRp) {
                        return cRI;
                    }
                    if (this.cRn) {
                        return cRG;
                    }
                    if (this.cTa) {
                        int aDu = aDu();
                        if (aDu == 1) {
                            return cRy;
                        }
                        if (aDu == 2) {
                            return cRz;
                        }
                        if (aDu > 2) {
                            return cRA;
                        }
                        return cRx;
                    }
                    return cRx;
                }
            }
        }
    }

    public int aDu() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.azR().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aCB()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aCB().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aDv() {
        return aBX() != null && getThreadType() == 41 && aCo() == 1 && aCZ() == 2;
    }

    public void y(ArrayList<q> arrayList) {
        if (this.cSj == 1) {
            this.cOx = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.cOx = 0;
        } else {
            this.cOx = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.aAy() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aAy().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.cOx = next.aAz();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aDw() {
        return this.threadType == 41;
    }

    public boolean aDx() {
        return this.cTA;
    }

    public void fA(boolean z) {
        this.cTA = z;
    }

    public String aDy() {
        return this.cTB;
    }

    public p aDz() {
        return this.cTf;
    }

    public void aDA() {
        if (this.cSY == 0) {
            this.cSY = 1;
        }
    }

    public void fB(boolean z) {
        this.cTN = z;
    }

    public boolean aDB() {
        return this.cTN;
    }

    public void jP(int i) {
        this.cTO = i + 1;
    }

    public int aDC() {
        return this.cTO;
    }

    public boolean aDD() {
        return this.cUC;
    }

    public void fC(boolean z) {
        this.cUC = z;
    }

    public boolean aDE() {
        return getThreadType() == 49;
    }

    public boolean aDF() {
        return getThreadType() == 40;
    }

    public boolean aDG() {
        return getThreadType() == 50;
    }

    public boolean aDH() {
        return getThreadType() == 60;
    }

    public int aDI() {
        return this.cTU;
    }

    public void setSmartFrsPosition(int i) {
        this.cTU = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aDJ() {
        return this.mRecomSource;
    }

    public boolean aDK() {
        return this.cTV;
    }

    public long aDL() {
        return this.agreeData.agreeNum;
    }

    public long aDM() {
        return this.agreeData.disAgreeNum;
    }

    public int aDN() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aDO() {
        return this.agreeData.agreeType;
    }

    public void jQ(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void jR(int i) {
        this.agreeData.agreeNum = i;
    }

    public void bw(long j) {
        this.agreeData.agreeNum = j;
    }

    public void bx(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void jS(int i) {
        this.agreeData.agreeType = i;
    }

    public long aDP() {
        return this.cTX;
    }

    public void by(long j) {
        this.cTX = j;
    }

    public PostData aDQ() {
        return this.cTW;
    }

    public ag aDR() {
        return this.cTY;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean aCs = aCs();
        if (z2) {
            if (z) {
                if (aCs && !aBe()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (aCo() == 1 || getThreadType() == 33 || (aCq() != null && aCq().aEx() != 0)) {
                    if (aBX() != null && aDw()) {
                        if (aCZ() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!aCs) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aDw()) {
                    arrayList.add(cTR.get(aCZ()));
                }
                if (aDc()) {
                    Integer num = cTQ.get(new Point(aDb(), aDa()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aCD() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (aCs && aCm() != 1 && !aBe()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((aCo() == 1 || getThreadType() == 33) && !aDw() && !aCs) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (aCn() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (aCm() == 1) {
                    arrayList.add(new l.a((int) R.string.f1281top));
                }
                if (aDw() && aBX() != null && aCZ() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aDc()) {
                    Integer num2 = cTQ.get(new Point(aDb(), aDa()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cTC == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aCE() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aCD() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aDE()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aDG()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aDF()) {
                    arrayList.add(new l.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new l.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void z(ArrayList<MediaData> arrayList) {
        this.cSE = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.cSF = arrayList;
    }

    public String aDS() {
        return this.cUj;
    }

    public void sK(String str) {
        this.cUj = str;
    }

    public void aDT() {
        this.cUh = 1;
    }

    public boolean aDU() {
        return this.cUh == 1;
    }

    public boolean aDV() {
        return "worldcupvideo".equals(this.cUm);
    }

    public String aDW() {
        return this.cSr;
    }

    public void sL(String str) {
        this.cSr = str;
    }

    public String aDX() {
        return this.cSs;
    }

    public void sM(String str) {
        this.cSs = str;
    }

    public String aDY() {
        return this.cUk;
    }

    public void sN(String str) {
        this.cUk = str;
    }

    public boolean aDZ() {
        return this.cUn;
    }

    public void fD(boolean z) {
        this.cUn = z;
    }

    public void b(VideoInfo videoInfo) {
        this.cUl = videoInfo;
    }

    public boolean aEa() {
        return this.cUo != null;
    }

    public bf aEb() {
        return this.cSq;
    }

    public void a(bf bfVar) {
        this.cSq = bfVar;
    }

    public boolean aEc() {
        return this.cUr;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.cST != null) {
            return this.cST.video_url;
        }
        return null;
    }

    public boolean aEd() {
        return this.cUt;
    }

    public void fE(boolean z) {
        this.cUt = z;
    }

    public AgreeData aEe() {
        return this.agreeData;
    }

    public boolean aEf() {
        return this.cUD;
    }

    public void fF(boolean z) {
        this.cUD = z;
    }

    public boolean aEg() {
        return this.cUE;
    }

    public void fG(boolean z) {
        this.cUE = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aEh() {
        return this.cUi;
    }

    public String getShareImageUrl() {
        return this.cUz;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCB = aCB();
        if (com.baidu.tbadk.core.i.azR().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCB) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCB.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB, 0);
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

    public int[] aEi() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCB = aCB();
        if (com.baidu.tbadk.core.i.azR().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCB) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCB.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCB, 0);
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

    public boolean aEj() {
        return aEk() || aEl();
    }

    public boolean aBg() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aBh() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aEk() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aEl() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aEm() {
        if (this.mBaijiahao == null) {
            return false;
        }
        switch (this.mBaijiahao.oriUgcType) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public boolean isBjh() {
        return aEm();
    }

    public void jT(int i) {
        this.cUJ = i;
    }

    public int aEn() {
        return this.cUL;
    }

    public String aEo() {
        return this.cUK;
    }

    public void sO(String str) {
        this.cUK = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aEp() {
        if (aCt()) {
            return 4;
        }
        if (aDE() || aDG()) {
            return 3;
        }
        if (aBg()) {
            return 5;
        }
        if (aBh()) {
            return 6;
        }
        if (aEk()) {
            return 7;
        }
        if (aEl()) {
            return 8;
        }
        if (this.isShareThread && this.cUe != null) {
            return 9;
        }
        if (aDF()) {
            return 2;
        }
        return 1;
    }

    public int aEq() {
        if (aEl() || aEk()) {
            return 2;
        }
        if (aBg() || aBh()) {
            return 3;
        }
        return 1;
    }

    public int getTabId() {
        return this.mTabId;
    }

    public String getTabName() {
        return this.mTabName;
    }
}

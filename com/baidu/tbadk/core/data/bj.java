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
public class bj extends a implements com.baidu.adp.widget.ListView.m, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.g.a {
    private String address;
    private String authorId;
    private String awq;
    public int cPE;
    private SpannableString cPK;
    private int cRU;
    private SpannableStringBuilder cRZ;
    private String cSA;
    private int cSC;
    private VideoInfo cSE;
    private VideoDesc cSF;
    private bq cSG;
    private AlaInfoData cSH;
    private long cSI;
    private p cSQ;
    private LiveCoverStatus cSW;
    private long cSX;
    private SpannableStringBuilder cSa;
    private bf cSb;
    private String cSc;
    private String cSd;
    public int cSr;
    private int cSs;
    private int cSv;
    public int cSw;
    private String cSz;
    private List<ReportInfo> cTA;
    private boolean cTG;
    private long cTI;
    private ag cTJ;
    public f cTL;
    private MediaData cTM;
    public int cTN;
    public OriginalThreadInfo cTP;
    private TopicModule cTT;
    private String cTU;
    private String cTV;
    private VideoInfo cTW;
    private String cTX;
    public OriginalForumInfo cTZ;
    public TwZhiBoUser cTe;
    public List<TwAnchorProfitItem> cTf;
    private SkinInfo cTj;
    private boolean cTl;
    private String cTm;
    private boolean cTp;
    public String cTr;
    public int cTs;
    public int cTt;
    public String cTu;
    public String cTv;
    public long cTw;
    public boolean cUa;
    private String cUb;
    private boolean cUc;
    private SmartApp cUd;
    private String cUf;
    private String cUg;
    private String cUh;
    private String cUi;
    private String cUj;
    public String cUk;
    private boolean cUn;
    private boolean cUo;
    private boolean cUp;
    public boolean cUq;
    public boolean cUr;
    public boolean cUs;
    public String cUt;
    private int cUu;
    private String cUv;
    private int cUw;
    public String cUy;
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
    public String noCommetStr;
    private int post_num;
    public int sortType;
    public int threadType;
    public String thread_share_link;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId cRh = BdUniqueId.gen();
    public static final BdUniqueId cRi = BdUniqueId.gen();
    public static final BdUniqueId cRj = BdUniqueId.gen();
    public static final BdUniqueId cRk = BdUniqueId.gen();
    public static final BdUniqueId cRl = BdUniqueId.gen();
    public static final BdUniqueId cRm = BdUniqueId.gen();
    public static final BdUniqueId cRn = BdUniqueId.gen();
    public static final BdUniqueId cRo = BdUniqueId.gen();
    public static final BdUniqueId cRp = BdUniqueId.gen();
    public static final BdUniqueId cRq = BdUniqueId.gen();
    public static final BdUniqueId cRr = BdUniqueId.gen();
    public static final BdUniqueId cRs = BdUniqueId.gen();
    public static final BdUniqueId cRt = BdUniqueId.gen();
    public static final BdUniqueId cRu = BdUniqueId.gen();
    public static final BdUniqueId cRv = BdUniqueId.gen();
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
    public static AtomicBoolean cRM = new AtomicBoolean(false);
    public static AtomicBoolean cRN = new AtomicBoolean(false);
    public static AtomicBoolean cRO = new AtomicBoolean(false);
    public static final BdUniqueId cRP = BdUniqueId.gen();
    public static final BdUniqueId cRQ = BdUniqueId.gen();
    private static HashMap<Point, Integer> cSR = new HashMap<>();
    private static HashMap<Integer, Integer> cSS = new HashMap<>();
    public static final BdUniqueId cTc = BdUniqueId.gen();
    public static final BdUniqueId cTk = BdUniqueId.gen();
    private static HashMap<Point, Integer> cTB = new HashMap<>();
    private static SparseArray<l.a> cTC = new SparseArray<>(3);
    public boolean cQT = false;
    public boolean cQU = false;
    public boolean cQV = false;
    public boolean cQW = false;
    public boolean cQX = false;
    public boolean cQY = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    private int cRR = 0;
    private String cRS = "1";
    public int cRT = 1;
    private String cSu = null;
    private int cOi = 0;
    public int cSJ = 0;
    private String cSK = "";
    public boolean cSL = false;
    private String cST = "";
    public boolean cTx = true;
    public boolean cTD = false;
    public boolean cTE = false;
    private int cTF = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cTK = false;
    private int cTS = 0;
    private boolean cTY = false;
    private boolean cUe = false;
    public boolean cUl = false;
    public boolean cUm = false;
    public boolean forbidComment = false;
    public boolean cUx = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cSe = 0;
    private int cSf = 0;
    private String last_time = null;
    private long cSg = 0;
    private int cSh = 0;
    private int cSi = 0;
    private int cSj = 0;
    private int cSk = 0;
    private bn cSl = new bn();
    private MetaData cSm = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cSp = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cSq = new ArrayList<>();
    private int cSn = 0;
    private int cSo = 0;
    private String ad_url = null;
    private String cRV = null;
    private String from = null;
    private int cSt = 0;
    private PraiseData cSx = new PraiseData();
    private AnchorInfoData cSy = new AnchorInfoData();
    private long time = 0;
    private int cSB = 0;
    private ArrayList<b> cSN = new ArrayList<>();
    private bv cSO = null;
    private g cSP = null;
    private int cSU = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cSD = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cSV = null;
    private int cSM = 0;
    private boolean cSY = false;
    private boolean cSZ = false;
    private int cTa = 0;
    private boolean cTb = false;
    private int anchorLevel = 0;
    public int cTn = 0;
    public m cTo = new m();
    private List<PbContent> cRY = new ArrayList();
    private List<PbContent> cRW = new ArrayList();
    private List<PbContent> cRX = new ArrayList();
    private String category_name = null;
    private bh cTd = new bh();
    private ArrayList<com.baidu.tbadk.data.c> cTg = new ArrayList<>();
    private PushStatusData cTh = new PushStatusData();
    public boolean cTy = false;
    public int cTz = -1;
    private PostData cTH = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cTq = 0;
    public int cTO = 0;
    private String tieba_game_information_source = "";
    public String cTR = "";
    public String cTQ = "";
    public String mUrl = "";
    public String cTi = "";

    static {
        cSR.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        cSR.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        cSR.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        cSR.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        cSR.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        cSR.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        cSR.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        cSR.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cTB.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cTB.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cTB.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cTB.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cTB.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cTB.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cTB.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cTB.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cSS.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cSS.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cSS.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cTC.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cTC.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cTC.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.cSs = 0;
        this.cSC = 0;
        this.cSX = 0L;
        this.cTN = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cSX = 0L;
        this.cSC = 0;
        this.cSs = 0;
        this.cTN = 0;
        this.isBigGie = false;
    }

    public String aBK() {
        return this.cUf;
    }

    public String aBL() {
        return this.cUg;
    }

    public void sD(String str) {
        this.cUg = str;
    }

    public String aBM() {
        return this.cUh;
    }

    public SpannableStringBuilder aBN() {
        return this.cSa;
    }

    public SpannableString aBO() {
        return this.cPK;
    }

    public void a(SpannableString spannableString) {
        if (aCm() != null) {
            if (this.cSa != null) {
                this.cSa.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cPK);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.cPK = new SpannableString(spannableStringBuilder);
        }
    }

    public String aBP() {
        return this.cUi;
    }

    public String aBQ() {
        return this.cUj;
    }

    public boolean aBR() {
        return this.cSs == 1;
    }

    public bh aBS() {
        return this.cTd;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jG(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.cSC;
    }

    public void jH(int i) {
        this.cTa = i;
    }

    public int aBT() {
        return this.cTa;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aBU() {
        return this.cTW;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bu(long j) {
        this.mCreateTime = j;
    }

    public long aBV() {
        return this.cSI;
    }

    public String aBW() {
        return this.cSz;
    }

    public PraiseData aBX() {
        return this.cSx;
    }

    public void a(PraiseData praiseData) {
        this.cSx = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aBY() {
        return this.awq;
    }

    public void sE(String str) {
        this.awq = str;
    }

    public String aBZ() {
        return this.cRS;
    }

    public void sF(String str) {
        this.cRS = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jI(int i) {
        this.cRR = i;
    }

    public int aCa() {
        return this.cRR;
    }

    public String aCb() {
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

    public List<PbContent> aCc() {
        return this.cRY;
    }

    public void aw(List<PbContent> list) {
        this.cRY = list;
    }

    public void ax(List<PbContent> list) {
        this.cRW = list;
    }

    public void ay(List<PbContent> list) {
        this.cRX = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void jJ(int i) {
        this.reply_num = i;
    }

    public int aCd() {
        return this.reply_num;
    }

    public int aCe() {
        return this.cSf;
    }

    public void jK(int i) {
        this.cSf = i;
    }

    public long aCf() {
        return this.cSg;
    }

    public void bv(long j) {
        this.cSg = j;
    }

    public int aCg() {
        return this.cSi;
    }

    public int aCh() {
        return this.cSh;
    }

    public void jL(int i) {
        this.cSh = i;
    }

    public int aCi() {
        return this.cSj;
    }

    public void jM(int i) {
        this.cSj = i;
    }

    public int aCj() {
        return this.cSk;
    }

    public List<PbContent> aCk() {
        return this.cRW;
    }

    public bn aCl() {
        return this.cSl;
    }

    public MetaData aCm() {
        return this.cSm;
    }

    public boolean aCn() {
        return this.is_god != 0;
    }

    public boolean aCo() {
        return this.is_god == 1;
    }

    public boolean aCp() {
        return (this.cSm == null || this.cSm.getGodUserData() == null || this.cSm.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aCq() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cSm = metaData;
    }

    public String aCr() {
        return this.forum_name;
    }

    public void sG(String str) {
        this.forum_name = str;
    }

    public int aCs() {
        return this.cSo;
    }

    public String aCt() {
        return this.ad_url;
    }

    public int aCu() {
        return this.cSt;
    }

    public void jN(int i) {
        this.cSt = i;
    }

    public String aCv() {
        return this.cSu;
    }

    public void sH(String str) {
        this.cSu = str;
    }

    public ArrayList<MediaData> aCw() {
        return this.cSp;
    }

    public ArrayList<b> aCx() {
        return this.cSN;
    }

    public void x(ArrayList<b> arrayList) {
        this.cSN = arrayList;
    }

    public bv aCy() {
        return this.cSO;
    }

    public g aCz() {
        return this.cSP;
    }

    public ArrayList<VoiceData.VoiceModel> aCA() {
        return this.cSq;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aCB() {
        return this.cRU;
    }

    public void jO(int i) {
        this.cRU = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aCC() {
        return this.cSK;
    }

    public VideoInfo aCD() {
        return this.cSE;
    }

    public void a(VideoInfo videoInfo) {
        this.cSE = videoInfo;
    }

    public VideoDesc aCE() {
        return this.cSF;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cSH = alaInfoData;
    }

    public AlaInfoData aCF() {
        return this.cSH;
    }

    public PushStatusData aCG() {
        return this.cTh;
    }

    public SkinInfo aCH() {
        return this.cTj;
    }

    public long aCI() {
        return this.cTw;
    }

    public boolean aCJ() {
        return this.cTx;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAe() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAf() {
        return this.cTv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAg() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAe().getTid());
        alVar.setFid(aAe().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.cPD = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.cPE = this.cPE;
        alVar.cardType = aEj();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cSA = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cSs = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cSI = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cSe = threadInfo.repost_num.intValue();
                this.cSf = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cSg = threadInfo.last_time_int.intValue();
                this.cSh = threadInfo.is_top.intValue();
                this.cSi = threadInfo.is_membertop.intValue();
                this.cSj = threadInfo.is_good.intValue();
                this.cSk = threadInfo.is_livepost.intValue();
                this.cSl.a(threadInfo.topic);
                this.cSm.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cSn = threadInfo.has_commented.intValue();
                this.cSo = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cSE = threadInfo.video_info;
                this.cSF = threadInfo.video_segment;
                this.cSH = new AlaInfoData();
                this.cSH.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cSt = threadInfo.collect_status.intValue();
                this.cSu = threadInfo.collect_mark_pid;
                this.cSv = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cSw = threadInfo.thread_type.intValue();
                this.cSz = threadInfo.first_post_id + "";
                this.cSK = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cRU = threadInfo.is_ntitle.intValue();
                this.cSB = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cTI = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cSC = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cTp = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cRW = threadInfo.rich_title;
                this.cRY = threadInfo.first_post_content;
                this.cRX = threadInfo.rich_abstract;
                this.cSr = threadInfo.is_godthread_recommend.intValue();
                if ((this.cSm == null || this.cSm.getUserId() == null || this.cSm.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSm = metaData;
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
                this.cRV = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cSp.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cSE = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cSG = new bq();
                    this.cSG.a(threadInfo.video_channel_info);
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
                        this.cSq.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cSN.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cSO = new bv();
                    this.cSO.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.cSP = new g();
                    this.cSP.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.cSQ = new p();
                    this.cSQ.a(threadInfo.cartoon_info);
                }
                this.cSx.setUserMap(this.userMap);
                this.cSx.parserProtobuf(threadInfo.zan);
                this.cSy.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSx.setTitle(this.title);
                } else {
                    this.cSx.setTitle(this.cRV);
                }
                this.cST = threadInfo.livecover_src;
                this.cSU = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cSM = threadInfo.post_num.intValue();
                this.cSX = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.lZ(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.uE(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cSD.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cSV = noticeInfo.notice;
                    }
                    this.cTa = zhiBoInfoTW.copythread_remind.intValue();
                    this.cSY = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cSZ = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.cST)) {
                        this.cST = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cTe = zhiBoInfoTW.user.tw_anchor_info;
                        this.cTf = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cSW = threadInfo.twzhibo_info.livecover_status;
                    this.cSX = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cTb = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cTd.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cTg.add(cVar);
                    }
                }
                this.cTh.parserProtobuf(threadInfo.push_status);
                this.cTm = threadInfo.lego_card;
                this.cTj = threadInfo.skin_info;
                this.cTn = threadInfo.is_book_chapter.intValue();
                this.cTo.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cTv = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cTw = threadInfo.last_read_pid.longValue();
                this.cTx = threadInfo.cheak_repeat.intValue() == 1;
                this.cTA = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cTH.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.cTG = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cTJ = new ag();
                    this.cTJ.a(threadInfo.link_info);
                }
                this.cTK = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cTL = new f();
                    this.cTL.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cTM = new MediaData();
                    this.cTM.parserProtobuf(threadInfo.pic_info);
                }
                this.cTq = threadInfo.is_called.intValue();
                this.cTN = threadInfo.middle_page_num.intValue();
                this.cTO = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cTQ = threadInfo.star_rank_icon.icon_pic_url;
                    this.cTR = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cTP = new OriginalThreadInfo();
                    this.cTP.a(threadInfo.origin_thread_info);
                } else {
                    this.cTP = null;
                    this.isShareThread = false;
                }
                this.cTS = threadInfo.is_topic.intValue();
                this.cTU = threadInfo.topic_user_name;
                this.cTV = threadInfo.topic_h5_url;
                this.cTT = threadInfo.topic_module;
                this.cTX = threadInfo.presentation_style;
                this.cTZ = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cUb = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cSb = new bf();
                    this.cSb.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cUd = threadInfo.swan_info;
                }
                this.cUk = threadInfo.t_share_img;
                this.cUl = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.cUv = threadInfo.article_cover;
                this.cUw = threadInfo.bjh_content_tag.intValue();
                this.cUu = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUx = threadInfo.is_s_card.intValue() == 1;
                this.cUy = threadInfo.scard_packet_id;
                aCK();
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
                this.cSI = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cSe = jSONObject.optInt("repost_num", 0);
                this.cSf = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cSg = jSONObject.optLong("last_time_int", 0L);
                this.cSh = jSONObject.optInt("is_top", 0);
                this.cSi = jSONObject.optInt("is_membertop", 0);
                this.cSj = jSONObject.optInt("is_good", 0);
                this.cSk = jSONObject.optInt("is_livepost", 0);
                this.cSl.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cSm.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cSn = jSONObject.optInt("has_commented", 0);
                this.cSo = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cSt = jSONObject.optInt("collect_status");
                this.cSu = jSONObject.optString("collect_mark_pid");
                this.cSv = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cSw = jSONObject.optInt("thread_type");
                this.cTI = jSONObject.optLong("share_num");
                this.cSz = jSONObject.optString("first_post_id", "0");
                this.cSK = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cRU = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.cTd.parserJson(optJSONObject2);
                }
                if ((this.cSm == null || this.cSm.getUserId() == null) && this.userMap != null) {
                    this.cSm = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.cSH = new AlaInfoData();
                this.cSH.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.cRV = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cSp.add(mediaData);
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
                        this.cSq.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cSN.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.cSO = new bv();
                    this.cSO.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.cSP = new g();
                    this.cSP.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.cSQ = new p();
                    this.cSQ.parserJson(optJSONObject6);
                }
                this.cSx.setUserMap(this.userMap);
                this.cSx.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cSy.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSx.setTitle(this.title);
                } else {
                    this.cSx.setTitle(this.cRV);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.cTd.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cTg.add(cVar);
                    }
                }
                this.cTn = jSONObject.optInt("is_book_chapter", 0);
                this.cTo.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cTv = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cTr = jSONObject.optString("recom_extra_img");
                this.cTu = jSONObject.optString("recom_extra_img_night");
                this.cTs = jSONObject.optInt("recom_extra_img_width", 0);
                this.cTt = jSONObject.optInt("recom_extra_img_height", 0);
                this.cTw = jSONObject.optLong("last_read_pid");
                this.cTx = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.cSG = new bq();
                    this.cSG.ci(optJSONObject8);
                }
                this.cTG = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.cTJ = new ag();
                    this.cTJ.parserJson(optJSONObject9);
                }
                this.cTK = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.cTL = new f();
                    this.cTL.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.cTM = new MediaData();
                    this.cTM.parserJson(optJSONObject11);
                }
                this.cTq = jSONObject.optInt("is_called", 0);
                this.cTN = jSONObject.optInt("middle_page_num", 0);
                this.cTO = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.cSE = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.cTP = new OriginalThreadInfo();
                        this.cTP.parserJson(optJSONObject13);
                    } else {
                        this.cTP = null;
                    }
                } else {
                    this.cTP = null;
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
                    this.cUd = builder2.build(false);
                }
                this.cUk = jSONObject.optString("t_share_img");
                this.cUl = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.cUu = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.cUw = jSONObject.optInt("bjh_content_tag");
                this.cUv = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUx = jSONObject.optInt("is_s_card", 0) == 1;
                this.cUy = jSONObject.optString("scard_packet_id");
                aCK();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aCK() {
        aCL();
        aCM();
        aCO();
        aCP();
        aCQ();
        aCR();
        aCS();
    }

    private void aCL() {
        if (!StringUtils.isNull(this.cSm.getName_show())) {
            this.cUf = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cSm.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aCM() {
        if (aEg() || aDZ()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String bD = com.baidu.tbadk.core.util.aq.bD(j);
                if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                    bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.cUg = bD;
            }
            String str = "";
            if (this.cSm != null && this.cSm.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.cSm.getBaijiahaoInfo().auth_desc)) {
                str = this.cSm.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.cUg) && !TextUtils.isEmpty(str)) {
                this.cUg += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.cUg = str;
                return;
            } else {
                return;
            }
        }
        if (aCq()) {
            long aCf = aCf() * 1000;
            if (aCf != 0) {
                this.cUg = com.baidu.tbadk.core.util.aq.bD(aCf);
            }
        } else {
            long aCf2 = 1000 * aCf();
            if (aCf2 != 0) {
                String bD2 = com.baidu.tbadk.core.util.aq.bD(aCf2);
                if (com.baidu.tbadk.core.util.aq.ty(bD2)) {
                    bD2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCf2);
                }
                this.cUg = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + bD2;
            }
        }
        if (!TextUtils.isEmpty(this.cUg) && !TextUtils.isEmpty(getAddress())) {
            this.cUg += " • " + getAddress();
        }
    }

    public void aCN() {
        if (!aEg() && !aDZ()) {
            if (!aCq()) {
                long aCf = 1000 * aCf();
                if (aCf != 0) {
                    String bD = com.baidu.tbadk.core.util.aq.bD(aCf);
                    if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                        bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCf);
                    }
                    this.cUg = bD;
                }
            }
            if (!TextUtils.isEmpty(this.cUg) && !TextUtils.isEmpty(getAddress())) {
                this.cUg += " • " + getAddress();
            }
        }
    }

    private void aCO() {
        if (aCF() == null || aCF().share_info == null || aCF().share_info.share_user_count <= 0 || !aDB() || (this.cTN > 0 && this.cTO == 0)) {
            this.cUh = null;
            return;
        }
        int i = aCF().share_info.share_user_count;
        if (i == 1) {
            this.cUh = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cUh = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aCP() {
        this.cSa = aDg();
        com.baidu.tieba.card.l.a(this, this.cSa, true);
    }

    private void aCQ() {
        this.cPK = aDe();
    }

    private void aCR() {
        this.cUi = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCf() * 1000);
    }

    private void aCS() {
        this.cUj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCf());
    }

    public SpannableStringBuilder aCT() {
        return this.cRZ;
    }

    public boolean isTop() {
        return aCh() != 0;
    }

    public int aCU() {
        if (this.cTd != null) {
            long aBF = this.cTd.aBF();
            long aBG = this.cTd.aBG();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aBF) {
                return 1;
            }
            if (currentTimeMillis > aBG) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aCV() {
        if (aCX() && this.cSN.size() >= 1) {
            b bVar = this.cSN.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aAj = bVar.aAj();
            int aAk = bVar.aAk();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aAj) {
                return 4;
            }
            return currentTimeMillis > aAk ? 2 : 1;
        }
        return -1;
    }

    public int aCW() {
        if (!aCX() || this.cSN.size() < 1 || this.cSN.get(0) == null) {
            return -1;
        }
        return this.cSN.get(0).aAi();
    }

    public boolean aCX() {
        return this.cSB == 1;
    }

    public String getActUrl() {
        return (!aCX() || this.cSN.size() < 1 || this.cSN.get(0) == null) ? "" : this.cSN.get(0).getUrl();
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

    public SmartApp aCY() {
        return this.cUd;
    }

    private void r(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aDa()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aCh() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aCh() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aCj() == 1 || this.cSl.aEr() != 0) {
                if (aBS() != null && getThreadType() == 41) {
                    if (aCU() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aDq()) {
                Integer num = cSS.get(Integer.valueOf(aCU()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aCi() == 1 && !isTop() && cRy != getType() && cRG != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cSy != null && this.cSy.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aCs() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = cSR.get(new Point(aCW(), aCV()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aCy() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aCz() != null) {
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
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cRT));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aDb = aDb();
        if (aDb != null) {
            spannableStringBuilder.append((CharSequence) aDb);
        }
        this.cRZ = spannableStringBuilder;
    }

    public boolean aCZ() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aCm() != null) {
            if (aCm().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aCm().getGender() == 2) {
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

    private boolean aDa() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void s(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            t(z, z3);
            return;
        }
        SpannableStringBuilder aDb = aDb();
        if (z) {
            spannableStringBuilder = a(aDb.toString(), aDb, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aDb);
        }
        this.cRZ = spannableStringBuilder;
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
            if (this.cRU == 1) {
                this.cRZ = a;
                return a;
            }
        } else if (this.cRU == 1) {
            this.cRZ = new SpannableStringBuilder();
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

    public void cp(String str, String str2) {
        this.mUrl = str;
        this.cTi = str2;
    }

    public SpannableStringBuilder aDb() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cRW, this.title);
    }

    public SpannableStringBuilder aDc() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cRX, this.cRV);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aDd() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.cUx) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aDe() {
        SpannableStringBuilder aDc = aDc();
        com.baidu.tieba.card.l.a(this, aDc, false);
        return new SpannableString(aDc);
    }

    public SpannableString aDf() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cRY)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.cRY, this.cRV));
    }

    public String getAbstract() {
        return this.cRV;
    }

    public void sJ(String str) {
        this.cRV = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aDb;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.cRU == 1) {
            aDb = aDc();
            spannableStringBuilder = aDb.toString();
        } else {
            aDb = aDb();
            spannableStringBuilder = aDb.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aDb, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aDb);
        }
        this.cRZ = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder t(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder u(boolean z, boolean z2) {
        SpannableStringBuilder aDc;
        if (!StringUtils.isNull(this.title) && this.cRU != 1) {
            aDc = aDb();
        } else {
            aDc = aDc();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDc);
        this.cRZ = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aDg() {
        if (StringUtils.isNull(this.title) || this.cRU == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDb());
        this.cRZ = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aAY() {
        if (this.cRW != null && this.cRW.size() > 0) {
            int size = this.cRW.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cRW.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aAZ() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vL(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aDh() {
        r(false, false);
    }

    public void aDi() {
        r(false, true);
    }

    public AnchorInfoData aDj() {
        return this.cSy;
    }

    public boolean aDk() {
        return this.threadType == 36;
    }

    public boolean aAZ() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aDl() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aCw = aCw();
        if (aCw == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aCw.size() || i2 >= 3) {
                break;
            }
            if (aCw.get(i2) != null && aCw.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aCw.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aCw.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aCw.get(i2).getPicUrl();
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
        if (this.cSE != null && !StringUtils.isNull(this.cSE.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cSE.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cSm != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cSm.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aDm() {
        String userId;
        return this.cSm == null || (userId = this.cSm.getUserId()) == null || userId.equals("0");
    }

    public boolean aDn() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aDW()) {
            if (aCD() != null) {
                return cRy;
            }
            return cRi;
        }
        int aCh = aCh();
        if (this.cTS == 1) {
            if (this.cTT != null) {
                return cRu;
            }
            return this.cTW != null ? cRI : cRH;
        } else if (this.cSH != null && this.threadType == 60) {
            return cRB;
        } else {
            if (this.cSH != null && this.threadType == 49) {
                return cRz;
            }
            if (this.threadType == 51) {
                return cRA;
            }
            if (this.threadType == 63) {
                return cRJ;
            }
            if (this.threadType == 64) {
                return cRK;
            }
            if (aCh == 2 || aCh == 1) {
                return cRh;
            }
            if (this.cSE != null && aDv() && !aDn()) {
                return cRP;
            }
            if (this.cSE != null && !aDn()) {
                if (aCp()) {
                    return cRG;
                }
                return cRy;
            } else if (this.isShareThread && this.cTP != null) {
                if (this.cTP.cPL) {
                    if (this.cTP.videoInfo != null) {
                        return cRF;
                    }
                    if (this.cTP.aBb()) {
                        return cRE;
                    }
                    return cRD;
                }
                return cRC;
            } else if (aBb()) {
                return cRv;
            } else {
                if (aDp()) {
                    return cRM.get() ? cTc : cRi;
                } else if (aCX() && aCW() == 1) {
                    return cRM.get() ? cTk : cRi;
                } else if (isLinkThread()) {
                    return cRw;
                } else {
                    if (aCp()) {
                        return cRx;
                    }
                    if (this.cQT) {
                        return cRm;
                    }
                    if (this.cQU) {
                        return cRn;
                    }
                    if (this.cQV) {
                        return cRo;
                    }
                    if (this.cQW) {
                        return cRp;
                    }
                    if (this.cQX) {
                        return cRq;
                    }
                    if (this.cQZ) {
                        return cRs;
                    }
                    if (this.cRa) {
                        return cRt;
                    }
                    if (this.cQY) {
                        return cRr;
                    }
                    if (this.cSL) {
                        int aDo = aDo();
                        if (aDo == 1) {
                            return cRj;
                        }
                        if (aDo == 2) {
                            return cRk;
                        }
                        if (aDo > 2) {
                            return cRl;
                        }
                        return cRi;
                    }
                    return cRi;
                }
            }
        }
    }

    public int aDo() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.azM().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aCw()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aCw().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aDp() {
        return aBS() != null && getThreadType() == 41 && aCj() == 1 && aCU() == 2;
    }

    public void y(ArrayList<q> arrayList) {
        if (this.cRU == 1) {
            this.cOi = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.cOi = 0;
        } else {
            this.cOi = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.aAt() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aAt().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.cOi = next.aAu();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aDq() {
        return this.threadType == 41;
    }

    public boolean aDr() {
        return this.cTl;
    }

    public void fz(boolean z) {
        this.cTl = z;
    }

    public String aDs() {
        return this.cTm;
    }

    public p aDt() {
        return this.cSQ;
    }

    public void aDu() {
        if (this.cSJ == 0) {
            this.cSJ = 1;
        }
    }

    public void fA(boolean z) {
        this.cTy = z;
    }

    public boolean aDv() {
        return this.cTy;
    }

    public void jP(int i) {
        this.cTz = i + 1;
    }

    public int aDw() {
        return this.cTz;
    }

    public boolean aDx() {
        return this.cUn;
    }

    public void fB(boolean z) {
        this.cUn = z;
    }

    public boolean aDy() {
        return getThreadType() == 49;
    }

    public boolean aDz() {
        return getThreadType() == 40;
    }

    public boolean aDA() {
        return getThreadType() == 50;
    }

    public boolean aDB() {
        return getThreadType() == 60;
    }

    public int aDC() {
        return this.cTF;
    }

    public void setSmartFrsPosition(int i) {
        this.cTF = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aDD() {
        return this.mRecomSource;
    }

    public boolean aDE() {
        return this.cTG;
    }

    public long aDF() {
        return this.agreeData.agreeNum;
    }

    public long aDG() {
        return this.agreeData.disAgreeNum;
    }

    public int aDH() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aDI() {
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

    public long aDJ() {
        return this.cTI;
    }

    public void by(long j) {
        this.cTI = j;
    }

    public PostData aDK() {
        return this.cTH;
    }

    public ag aDL() {
        return this.cTJ;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean aCn = aCn();
        if (z2) {
            if (z) {
                if (aCn && !aAZ()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (aCj() == 1 || getThreadType() == 33 || (aCl() != null && aCl().aEr() != 0)) {
                    if (aBS() != null && aDq()) {
                        if (aCU() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!aCn) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aDq()) {
                    arrayList.add(cTC.get(aCU()));
                }
                if (aCX()) {
                    Integer num = cTB.get(new Point(aCW(), aCV()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aCy() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (aCn && aCh() != 1 && !aAZ()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((aCj() == 1 || getThreadType() == 33) && !aDq() && !aCn) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (aCi() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (aCh() == 1) {
                    arrayList.add(new l.a((int) R.string.f1282top));
                }
                if (aDq() && aBS() != null && aCU() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aCX()) {
                    Integer num2 = cTB.get(new Point(aCW(), aCV()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cTn == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aCz() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aCy() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aDy()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aDA()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aDz()) {
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
        this.cSp = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.cSq = arrayList;
    }

    public String aDM() {
        return this.cTU;
    }

    public void sK(String str) {
        this.cTU = str;
    }

    public void aDN() {
        this.cTS = 1;
    }

    public boolean aDO() {
        return this.cTS == 1;
    }

    public boolean aDP() {
        return "worldcupvideo".equals(this.cTX);
    }

    public String aDQ() {
        return this.cSc;
    }

    public void sL(String str) {
        this.cSc = str;
    }

    public String aDR() {
        return this.cSd;
    }

    public void sM(String str) {
        this.cSd = str;
    }

    public String aDS() {
        return this.cTV;
    }

    public void sN(String str) {
        this.cTV = str;
    }

    public boolean aDT() {
        return this.cTY;
    }

    public void fC(boolean z) {
        this.cTY = z;
    }

    public void b(VideoInfo videoInfo) {
        this.cTW = videoInfo;
    }

    public boolean aDU() {
        return this.cTZ != null;
    }

    public bf aDV() {
        return this.cSb;
    }

    public void a(bf bfVar) {
        this.cSb = bfVar;
    }

    public boolean aDW() {
        return this.cUc;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cSE != null) {
            return this.cSE.video_url;
        }
        return null;
    }

    public boolean aDX() {
        return this.cUe;
    }

    public void fD(boolean z) {
        this.cUe = z;
    }

    public AgreeData aDY() {
        return this.agreeData;
    }

    public boolean aDZ() {
        return this.cUo;
    }

    public void fE(boolean z) {
        this.cUo = z;
    }

    public boolean aEa() {
        return this.cUp;
    }

    public void fF(boolean z) {
        this.cUp = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aEb() {
        return this.cTT;
    }

    public String getShareImageUrl() {
        return this.cUk;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCw = aCw();
        if (com.baidu.tbadk.core.i.azM().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCw) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCw.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw, 0);
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

    public int[] aEc() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCw = aCw();
        if (com.baidu.tbadk.core.i.azM().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCw) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCw.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCw, 0);
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

    public boolean aEd() {
        return aEe() || aEf();
    }

    public boolean aBb() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aBc() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aEe() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aEf() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aEg() {
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
        return aEg();
    }

    public void jT(int i) {
        this.cUu = i;
    }

    public int aEh() {
        return this.cUw;
    }

    public String aEi() {
        return this.cUv;
    }

    public void sO(String str) {
        this.cUv = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aEj() {
        if (aCo()) {
            return 4;
        }
        if (aDy() || aDA()) {
            return 3;
        }
        if (aBb()) {
            return 5;
        }
        if (aBc()) {
            return 6;
        }
        if (aEe()) {
            return 7;
        }
        if (aEf()) {
            return 8;
        }
        if (this.isShareThread && this.cTP != null) {
            return 9;
        }
        if (aDz()) {
            return 2;
        }
        return 1;
    }

    public int aEk() {
        if (aEf() || aEe()) {
            return 2;
        }
        if (aBb() || aBc()) {
            return 3;
        }
        return 1;
    }
}

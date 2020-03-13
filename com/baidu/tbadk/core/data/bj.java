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
    private String aws;
    public int cPG;
    private SpannableString cPM;
    private int cRW;
    private String cSB;
    private String cSC;
    private int cSE;
    private VideoInfo cSG;
    private VideoDesc cSH;
    private bq cSI;
    private AlaInfoData cSJ;
    private long cSK;
    private p cSS;
    private LiveCoverStatus cSY;
    private long cSZ;
    private SpannableStringBuilder cSb;
    private SpannableStringBuilder cSc;
    private bf cSd;
    private String cSe;
    private String cSf;
    public int cSt;
    private int cSu;
    private int cSx;
    public int cSy;
    private List<ReportInfo> cTC;
    private boolean cTI;
    private long cTK;
    private ag cTL;
    public f cTN;
    private MediaData cTO;
    public int cTP;
    public OriginalThreadInfo cTR;
    private TopicModule cTV;
    private String cTW;
    private String cTX;
    private VideoInfo cTY;
    private String cTZ;
    public TwZhiBoUser cTg;
    public List<TwAnchorProfitItem> cTh;
    private SkinInfo cTl;
    private boolean cTn;
    private String cTo;
    private boolean cTr;
    public String cTt;
    public int cTu;
    public int cTv;
    public String cTw;
    public String cTx;
    public long cTy;
    public String cUA;
    public OriginalForumInfo cUb;
    public boolean cUc;
    private String cUd;
    private boolean cUe;
    private SmartApp cUf;
    private String cUh;
    private String cUi;
    private String cUj;
    private String cUk;
    private String cUl;
    public String cUm;
    private boolean cUp;
    private boolean cUq;
    private boolean cUr;
    public boolean cUs;
    public boolean cUt;
    public boolean cUu;
    public String cUv;
    private int cUw;
    private String cUx;
    private int cUy;
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
    public static final BdUniqueId cRM = BdUniqueId.gen();
    public static final BdUniqueId cRN = BdUniqueId.gen();
    public static AtomicBoolean cRO = new AtomicBoolean(false);
    public static AtomicBoolean cRP = new AtomicBoolean(false);
    public static AtomicBoolean cRQ = new AtomicBoolean(false);
    public static final BdUniqueId cRR = BdUniqueId.gen();
    public static final BdUniqueId cRS = BdUniqueId.gen();
    private static HashMap<Point, Integer> cST = new HashMap<>();
    private static HashMap<Integer, Integer> cSU = new HashMap<>();
    public static final BdUniqueId cTe = BdUniqueId.gen();
    public static final BdUniqueId cTm = BdUniqueId.gen();
    private static HashMap<Point, Integer> cTD = new HashMap<>();
    private static SparseArray<l.a> cTE = new SparseArray<>(3);
    public boolean cQV = false;
    public boolean cQW = false;
    public boolean cQX = false;
    public boolean cQY = false;
    public boolean cQZ = false;
    public boolean cRa = false;
    public boolean cRb = false;
    public boolean cRc = false;
    private int cRT = 0;
    private String cRU = "1";
    public int cRV = 1;
    private String cSw = null;
    private int cOk = 0;
    public int cSL = 0;
    private String cSM = "";
    public boolean cSN = false;
    private String cSV = "";
    public boolean cTz = true;
    public boolean cTF = false;
    public boolean cTG = false;
    private int cTH = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean cTM = false;
    private int cTU = 0;
    private boolean cUa = false;
    private boolean cUg = false;
    public boolean cUn = false;
    public boolean cUo = false;
    public boolean forbidComment = false;
    public boolean cUz = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int cSg = 0;
    private int cSh = 0;
    private String last_time = null;
    private long cSi = 0;
    private int cSj = 0;
    private int cSk = 0;
    private int cSl = 0;
    private int cSm = 0;
    private bn cSn = new bn();
    private MetaData cSo = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> cSr = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> cSs = new ArrayList<>();
    private int cSp = 0;
    private int cSq = 0;
    private String ad_url = null;
    private String cRX = null;
    private String from = null;
    private int cSv = 0;
    private PraiseData cSz = new PraiseData();
    private AnchorInfoData cSA = new AnchorInfoData();
    private long time = 0;
    private int cSD = 0;
    private ArrayList<b> cSP = new ArrayList<>();
    private bv cSQ = null;
    private g cSR = null;
    private int cSW = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.d> cSF = new ArrayList<>();
    private boolean isHeadLive = false;
    private String cSX = null;
    private int cSO = 0;
    private boolean cTa = false;
    private boolean cTb = false;
    private int cTc = 0;
    private boolean cTd = false;
    private int anchorLevel = 0;
    public int cTp = 0;
    public m cTq = new m();
    private List<PbContent> cSa = new ArrayList();
    private List<PbContent> cRY = new ArrayList();
    private List<PbContent> cRZ = new ArrayList();
    private String category_name = null;
    private bh cTf = new bh();
    private ArrayList<com.baidu.tbadk.data.c> cTi = new ArrayList<>();
    private PushStatusData cTj = new PushStatusData();
    public boolean cTA = false;
    public int cTB = -1;
    private PostData cTJ = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int cTs = 0;
    public int cTQ = 0;
    private String tieba_game_information_source = "";
    public String cTT = "";
    public String cTS = "";
    public String mUrl = "";
    public String cTk = "";

    static {
        cST.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        cST.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        cST.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        cST.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        cST.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        cST.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        cST.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        cST.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        cTD.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        cTD.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        cTD.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        cTD.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        cTD.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        cTD.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        cTD.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        cTD.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        cSU.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        cSU.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        cSU.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        cTE.put(1, new l.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        cTE.put(2, new l.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        cTE.put(3, new l.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bj() {
        this.cSu = 0;
        this.cSE = 0;
        this.cSZ = 0L;
        this.cTP = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.cSZ = 0L;
        this.cSE = 0;
        this.cSu = 0;
        this.cTP = 0;
        this.isBigGie = false;
    }

    public String aBM() {
        return this.cUh;
    }

    public String aBN() {
        return this.cUi;
    }

    public void sD(String str) {
        this.cUi = str;
    }

    public String aBO() {
        return this.cUj;
    }

    public SpannableStringBuilder aBP() {
        return this.cSc;
    }

    public SpannableString aBQ() {
        return this.cPM;
    }

    public void a(SpannableString spannableString) {
        if (aCo() != null) {
            if (this.cSc != null) {
                this.cSc.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.cPM);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.cPM = new SpannableString(spannableStringBuilder);
        }
    }

    public String aBR() {
        return this.cUk;
    }

    public String aBS() {
        return this.cUl;
    }

    public boolean aBT() {
        return this.cSu == 1;
    }

    public bh aBU() {
        return this.cTf;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void jG(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.cSE;
    }

    public void jH(int i) {
        this.cTc = i;
    }

    public int aBV() {
        return this.cTc;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aBW() {
        return this.cTY;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bu(long j) {
        this.mCreateTime = j;
    }

    public long aBX() {
        return this.cSK;
    }

    public String aBY() {
        return this.cSB;
    }

    public PraiseData aBZ() {
        return this.cSz;
    }

    public void a(PraiseData praiseData) {
        this.cSz = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aCa() {
        return this.aws;
    }

    public void sE(String str) {
        this.aws = str;
    }

    public String aCb() {
        return this.cRU;
    }

    public void sF(String str) {
        this.cRU = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void jI(int i) {
        this.cRT = i;
    }

    public int aCc() {
        return this.cRT;
    }

    public String aCd() {
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

    public List<PbContent> aCe() {
        return this.cSa;
    }

    public void aw(List<PbContent> list) {
        this.cSa = list;
    }

    public void ax(List<PbContent> list) {
        this.cRY = list;
    }

    public void ay(List<PbContent> list) {
        this.cRZ = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void jJ(int i) {
        this.reply_num = i;
    }

    public int aCf() {
        return this.reply_num;
    }

    public int aCg() {
        return this.cSh;
    }

    public void jK(int i) {
        this.cSh = i;
    }

    public long aCh() {
        return this.cSi;
    }

    public void bv(long j) {
        this.cSi = j;
    }

    public int aCi() {
        return this.cSk;
    }

    public int aCj() {
        return this.cSj;
    }

    public void jL(int i) {
        this.cSj = i;
    }

    public int aCk() {
        return this.cSl;
    }

    public void jM(int i) {
        this.cSl = i;
    }

    public int aCl() {
        return this.cSm;
    }

    public List<PbContent> aCm() {
        return this.cRY;
    }

    public bn aCn() {
        return this.cSn;
    }

    public MetaData aCo() {
        return this.cSo;
    }

    public boolean aCp() {
        return this.is_god != 0;
    }

    public boolean aCq() {
        return this.is_god == 1;
    }

    public boolean aCr() {
        return (this.cSo == null || this.cSo.getGodUserData() == null || this.cSo.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aCs() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.cSo = metaData;
    }

    public String aCt() {
        return this.forum_name;
    }

    public void sG(String str) {
        this.forum_name = str;
    }

    public int aCu() {
        return this.cSq;
    }

    public String aCv() {
        return this.ad_url;
    }

    public int aCw() {
        return this.cSv;
    }

    public void jN(int i) {
        this.cSv = i;
    }

    public String aCx() {
        return this.cSw;
    }

    public void sH(String str) {
        this.cSw = str;
    }

    public ArrayList<MediaData> aCy() {
        return this.cSr;
    }

    public ArrayList<b> aCz() {
        return this.cSP;
    }

    public void x(ArrayList<b> arrayList) {
        this.cSP = arrayList;
    }

    public bv aCA() {
        return this.cSQ;
    }

    public g aCB() {
        return this.cSR;
    }

    public ArrayList<VoiceData.VoiceModel> aCC() {
        return this.cSs;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aCD() {
        return this.cRW;
    }

    public void jO(int i) {
        this.cRW = i;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aCE() {
        return this.cSM;
    }

    public VideoInfo aCF() {
        return this.cSG;
    }

    public void a(VideoInfo videoInfo) {
        this.cSG = videoInfo;
    }

    public VideoDesc aCG() {
        return this.cSH;
    }

    public void a(AlaInfoData alaInfoData) {
        this.cSJ = alaInfoData;
    }

    public AlaInfoData aCH() {
        return this.cSJ;
    }

    public PushStatusData aCI() {
        return this.cTj;
    }

    public SkinInfo aCJ() {
        return this.cTl;
    }

    public long aCK() {
        return this.cTy;
    }

    public boolean aCL() {
        return this.cTz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        return this.cTx;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAg().getTid());
        alVar.setFid(aAg().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.cPF = this.mRecomAbTag;
        alVar.weight = this.mRecomWeight;
        alVar.extra = this.mRecomExtra;
        alVar.source = this.mRecomSource;
        alVar.cPG = this.cPG;
        alVar.cardType = aEl();
        return alVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.cSC = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.cSu = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.cSK = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.cSg = threadInfo.repost_num.intValue();
                this.cSh = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.cSi = threadInfo.last_time_int.intValue();
                this.cSj = threadInfo.is_top.intValue();
                this.cSk = threadInfo.is_membertop.intValue();
                this.cSl = threadInfo.is_good.intValue();
                this.cSm = threadInfo.is_livepost.intValue();
                this.cSn.a(threadInfo.topic);
                this.cSo.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.cSp = threadInfo.has_commented.intValue();
                this.cSq = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.cSG = threadInfo.video_info;
                this.cSH = threadInfo.video_segment;
                this.cSJ = new AlaInfoData();
                this.cSJ.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.cSv = threadInfo.collect_status.intValue();
                this.cSw = threadInfo.collect_mark_pid;
                this.cSx = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.cSy = threadInfo.thread_type.intValue();
                this.cSB = threadInfo.first_post_id + "";
                this.cSM = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.cRW = threadInfo.is_ntitle.intValue();
                this.cSD = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.cTK = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.cSE = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.cTr = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.cRY = threadInfo.rich_title;
                this.cSa = threadInfo.first_post_content;
                this.cRZ = threadInfo.rich_abstract;
                this.cSt = threadInfo.is_godthread_recommend.intValue();
                if ((this.cSo == null || this.cSo.getUserId() == null || this.cSo.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cSo = metaData;
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
                this.cRX = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.cSr.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.cSG = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.cSI = new bq();
                    this.cSI.a(threadInfo.video_channel_info);
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
                        this.cSs.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.cSP.add(bVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.cSQ = new bv();
                    this.cSQ.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.cSR = new g();
                    this.cSR.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.cSS = new p();
                    this.cSS.a(threadInfo.cartoon_info);
                }
                this.cSz.setUserMap(this.userMap);
                this.cSz.parserProtobuf(threadInfo.zan);
                this.cSA.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSz.setTitle(this.title);
                } else {
                    this.cSz.setTitle(this.cRX);
                }
                this.cSV = threadInfo.livecover_src;
                this.cSW = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.cSO = threadInfo.post_num.intValue();
                this.cSZ = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.d dVar = new com.baidu.tbadk.coreExtra.view.d();
                                dVar.lZ(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                dVar.uF(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                dVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.cSF.add(dVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.cSX = noticeInfo.notice;
                    }
                    this.cTc = zhiBoInfoTW.copythread_remind.intValue();
                    this.cTa = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.cTb = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.cSV)) {
                        this.cSV = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.cTg = zhiBoInfoTW.user.tw_anchor_info;
                        this.cTh = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.cSY = threadInfo.twzhibo_info.livecover_status;
                    this.cSZ = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.cTd = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.cTf.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(threadInfo.ext_tails.get(i6));
                        this.cTi.add(cVar);
                    }
                }
                this.cTj.parserProtobuf(threadInfo.push_status);
                this.cTo = threadInfo.lego_card;
                this.cTl = threadInfo.skin_info;
                this.cTp = threadInfo.is_book_chapter.intValue();
                this.cTq.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.cTx = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.cTy = threadInfo.last_read_pid.longValue();
                this.cTz = threadInfo.cheak_repeat.intValue() == 1;
                this.cTC = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.cTJ.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.cTI = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.cTL = new ag();
                    this.cTL.a(threadInfo.link_info);
                }
                this.cTM = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.cTN = new f();
                    this.cTN.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.cTO = new MediaData();
                    this.cTO.parserProtobuf(threadInfo.pic_info);
                }
                this.cTs = threadInfo.is_called.intValue();
                this.cTP = threadInfo.middle_page_num.intValue();
                this.cTQ = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.cTS = threadInfo.star_rank_icon.icon_pic_url;
                    this.cTT = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.cTR = new OriginalThreadInfo();
                    this.cTR.a(threadInfo.origin_thread_info);
                } else {
                    this.cTR = null;
                    this.isShareThread = false;
                }
                this.cTU = threadInfo.is_topic.intValue();
                this.cTW = threadInfo.topic_user_name;
                this.cTX = threadInfo.topic_h5_url;
                this.cTV = threadInfo.topic_module;
                this.cTZ = threadInfo.presentation_style;
                this.cUb = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.cUd = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.cSd = new bf();
                    this.cSd.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.cUf = threadInfo.swan_info;
                }
                this.cUm = threadInfo.t_share_img;
                this.cUn = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.cUx = threadInfo.article_cover;
                this.cUy = threadInfo.bjh_content_tag.intValue();
                this.cUw = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUz = threadInfo.is_s_card.intValue() == 1;
                this.cUA = threadInfo.scard_packet_id;
                aCM();
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
                this.cSK = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.cSg = jSONObject.optInt("repost_num", 0);
                this.cSh = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.cSi = jSONObject.optLong("last_time_int", 0L);
                this.cSj = jSONObject.optInt("is_top", 0);
                this.cSk = jSONObject.optInt("is_membertop", 0);
                this.cSl = jSONObject.optInt("is_good", 0);
                this.cSm = jSONObject.optInt("is_livepost", 0);
                this.cSn.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.cSo.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.cSp = jSONObject.optInt("has_commented", 0);
                this.cSq = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.cSv = jSONObject.optInt("collect_status");
                this.cSw = jSONObject.optString("collect_mark_pid");
                this.cSx = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.cSy = jSONObject.optInt("thread_type");
                this.cTK = jSONObject.optLong("share_num");
                this.cSB = jSONObject.optString("first_post_id", "0");
                this.cSM = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.cRW = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.cTf.parserJson(optJSONObject2);
                }
                if ((this.cSo == null || this.cSo.getUserId() == null) && this.userMap != null) {
                    this.cSo = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.cSJ = new AlaInfoData();
                this.cSJ.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.cRX = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cSr.add(mediaData);
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
                        this.cSs.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.cSP.add(bVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.cSQ = new bv();
                    this.cSQ.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.cSR = new g();
                    this.cSR.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.cSS = new p();
                    this.cSS.parserJson(optJSONObject6);
                }
                this.cSz.setUserMap(this.userMap);
                this.cSz.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.cSA.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.cSz.setTitle(this.title);
                } else {
                    this.cSz.setTitle(this.cRX);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.cTf.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.cTi.add(cVar);
                    }
                }
                this.cTp = jSONObject.optInt("is_book_chapter", 0);
                this.cTq.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString("recom_source");
                this.cTx = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.cTt = jSONObject.optString("recom_extra_img");
                this.cTw = jSONObject.optString("recom_extra_img_night");
                this.cTu = jSONObject.optInt("recom_extra_img_width", 0);
                this.cTv = jSONObject.optInt("recom_extra_img_height", 0);
                this.cTy = jSONObject.optLong("last_read_pid");
                this.cTz = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.cSI = new bq();
                    this.cSI.ci(optJSONObject8);
                }
                this.cTI = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.cTL = new ag();
                    this.cTL.parserJson(optJSONObject9);
                }
                this.cTM = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.cTN = new f();
                    this.cTN.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.cTO = new MediaData();
                    this.cTO.parserJson(optJSONObject11);
                }
                this.cTs = jSONObject.optInt("is_called", 0);
                this.cTP = jSONObject.optInt("middle_page_num", 0);
                this.cTQ = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.cSG = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.cTR = new OriginalThreadInfo();
                        this.cTR.parserJson(optJSONObject13);
                    } else {
                        this.cTR = null;
                    }
                } else {
                    this.cTR = null;
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
                    this.cUf = builder2.build(false);
                }
                this.cUm = jSONObject.optString("t_share_img");
                this.cUn = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.cUw = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.cUy = jSONObject.optInt("bjh_content_tag");
                this.cUx = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.cUz = jSONObject.optInt("is_s_card", 0) == 1;
                this.cUA = jSONObject.optString("scard_packet_id");
                aCM();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aCM() {
        aCN();
        aCO();
        aCQ();
        aCR();
        aCS();
        aCT();
        aCU();
    }

    private void aCN() {
        if (!StringUtils.isNull(this.cSo.getName_show())) {
            this.cUh = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.cSo.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aCO() {
        if (aEi() || aEb()) {
            long j = this.mCreateTime;
            if (j != 0) {
                String bD = com.baidu.tbadk.core.util.aq.bD(j);
                if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                    bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.cUi = bD;
            }
            String str = "";
            if (this.cSo != null && this.cSo.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.cSo.getBaijiahaoInfo().auth_desc)) {
                str = this.cSo.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.cUi) && !TextUtils.isEmpty(str)) {
                this.cUi += "   " + str;
                return;
            } else if (!TextUtils.isEmpty(str)) {
                this.cUi = str;
                return;
            } else {
                return;
            }
        }
        if (aCs()) {
            long aCh = aCh() * 1000;
            if (aCh != 0) {
                this.cUi = com.baidu.tbadk.core.util.aq.bD(aCh);
            }
        } else {
            long aCh2 = 1000 * aCh();
            if (aCh2 != 0) {
                String bD2 = com.baidu.tbadk.core.util.aq.bD(aCh2);
                if (com.baidu.tbadk.core.util.aq.ty(bD2)) {
                    bD2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCh2);
                }
                this.cUi = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + bD2;
            }
        }
        if (!TextUtils.isEmpty(this.cUi) && !TextUtils.isEmpty(getAddress())) {
            this.cUi += " • " + getAddress();
        }
    }

    public void aCP() {
        if (!aEi() && !aEb()) {
            if (!aCs()) {
                long aCh = 1000 * aCh();
                if (aCh != 0) {
                    String bD = com.baidu.tbadk.core.util.aq.bD(aCh);
                    if (com.baidu.tbadk.core.util.aq.ty(bD)) {
                        bD = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCh);
                    }
                    this.cUi = bD;
                }
            }
            if (!TextUtils.isEmpty(this.cUi) && !TextUtils.isEmpty(getAddress())) {
                this.cUi += " • " + getAddress();
            }
        }
    }

    private void aCQ() {
        if (aCH() == null || aCH().share_info == null || aCH().share_info.share_user_count <= 0 || !aDD() || (this.cTP > 0 && this.cTQ == 0)) {
            this.cUj = null;
            return;
        }
        int i = aCH().share_info.share_user_count;
        if (i == 1) {
            this.cUj = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.cUj = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aCR() {
        this.cSc = aDi();
        com.baidu.tieba.card.l.a(this, this.cSc, true);
    }

    private void aCS() {
        this.cPM = aDg();
    }

    private void aCT() {
        this.cUk = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCh() * 1000);
    }

    private void aCU() {
        this.cUl = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aCh());
    }

    public SpannableStringBuilder aCV() {
        return this.cSb;
    }

    public boolean isTop() {
        return aCj() != 0;
    }

    public int aCW() {
        if (this.cTf != null) {
            long aBH = this.cTf.aBH();
            long aBI = this.cTf.aBI();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aBH) {
                return 1;
            }
            if (currentTimeMillis > aBI) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aCX() {
        if (aCZ() && this.cSP.size() >= 1) {
            b bVar = this.cSP.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aAl = bVar.aAl();
            int aAm = bVar.aAm();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aAl) {
                return 4;
            }
            return currentTimeMillis > aAm ? 2 : 1;
        }
        return -1;
    }

    public int aCY() {
        if (!aCZ() || this.cSP.size() < 1 || this.cSP.get(0) == null) {
            return -1;
        }
        return this.cSP.get(0).aAk();
    }

    public boolean aCZ() {
        return this.cSD == 1;
    }

    public String getActUrl() {
        return (!aCZ() || this.cSP.size() < 1 || this.cSP.get(0) == null) ? "" : this.cSP.get(0).getUrl();
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

    public SmartApp aDa() {
        return this.cUf;
    }

    private void s(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aDc()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aCj() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aCj() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aCl() == 1 || this.cSn.aEt() != 0) {
                if (aBU() != null && getThreadType() == 41) {
                    if (aCW() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aDs()) {
                Integer num = cSU.get(Integer.valueOf(aCW()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aCk() == 1 && !isTop() && cRA != getType() && cRI != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.cSA != null && this.cSA.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aCu() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = cST.get(new Point(aCY(), aCX()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aCA() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aCB() != null) {
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
                jVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.cRV));
                spannableString.setSpan(jVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aDd = aDd();
        if (aDd != null) {
            spannableStringBuilder.append((CharSequence) aDd);
        }
        this.cSb = spannableStringBuilder;
    }

    public boolean aDb() {
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
        String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aCo() != null) {
            if (aCo().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aCo().getGender() == 2) {
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

    private boolean aDc() {
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
        SpannableStringBuilder aDd = aDd();
        if (z) {
            spannableStringBuilder = a(aDd.toString(), aDd, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aDd);
        }
        this.cSb = spannableStringBuilder;
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
            if (this.cRW == 1) {
                this.cSb = a;
                return a;
            }
        } else if (this.cRW == 1) {
            this.cSb = new SpannableStringBuilder();
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
        this.cTk = str2;
    }

    public SpannableStringBuilder aDd() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cRY, this.title);
    }

    public SpannableStringBuilder aDe() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.cRZ, this.cRX);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aDf() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.cUz) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aDg() {
        SpannableStringBuilder aDe = aDe();
        com.baidu.tieba.card.l.a(this, aDe, false);
        return new SpannableString(aDe);
    }

    public SpannableString aDh() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.cSa)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.cSa, this.cRX));
    }

    public String getAbstract() {
        return this.cRX;
    }

    public void sJ(String str) {
        this.cRX = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aDd;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.cRW == 1) {
            aDd = aDe();
            spannableStringBuilder = aDd.toString();
        } else {
            aDd = aDd();
            spannableStringBuilder = aDd.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aDd, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aDd);
        }
        this.cSb = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder u(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder v(boolean z, boolean z2) {
        SpannableStringBuilder aDe;
        if (!StringUtils.isNull(this.title) && this.cRW != 1) {
            aDe = aDd();
        } else {
            aDe = aDe();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDe);
        this.cSb = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aDi() {
        if (StringUtils.isNull(this.title) || this.cRW == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aDd());
        this.cSb = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aBa() {
        if (this.cRY != null && this.cRY.size() > 0) {
            int size = this.cRY.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.cRY.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aBb() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.vM(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aDj() {
        s(false, false);
    }

    public void aDk() {
        s(false, true);
    }

    public AnchorInfoData aDl() {
        return this.cSA;
    }

    public boolean aDm() {
        return this.threadType == 36;
    }

    public boolean aBb() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aDn() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aCy = aCy();
        if (aCy == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aCy.size() || i2 >= 3) {
                break;
            }
            if (aCy.get(i2) != null && aCy.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aCy.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aCy.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aCy.get(i2).getPicUrl();
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
        if (this.cSG != null && !StringUtils.isNull(this.cSG.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.cSG.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.cSo != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.cSo.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aDo() {
        String userId;
        return this.cSo == null || (userId = this.cSo.getUserId()) == null || userId.equals("0");
    }

    public boolean aDp() {
        return this.threadType == 41;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (aDY()) {
            if (aCF() != null) {
                return cRA;
            }
            return cRk;
        }
        int aCj = aCj();
        if (this.cTU == 1) {
            if (this.cTV != null) {
                return cRw;
            }
            return this.cTY != null ? cRK : cRJ;
        } else if (this.cSJ != null && this.threadType == 60) {
            return cRD;
        } else {
            if (this.cSJ != null && this.threadType == 49) {
                return cRB;
            }
            if (this.threadType == 51) {
                return cRC;
            }
            if (this.threadType == 63) {
                return cRL;
            }
            if (this.threadType == 64) {
                return cRM;
            }
            if (aCj == 2 || aCj == 1) {
                return cRj;
            }
            if (this.cSG != null && aDx() && !aDp()) {
                return cRR;
            }
            if (this.cSG != null && !aDp()) {
                if (aCr()) {
                    return cRI;
                }
                return cRA;
            } else if (this.isShareThread && this.cTR != null) {
                if (this.cTR.cPN) {
                    if (this.cTR.videoInfo != null) {
                        return cRH;
                    }
                    if (this.cTR.aBd()) {
                        return cRG;
                    }
                    return cRF;
                }
                return cRE;
            } else if (aBd()) {
                return cRx;
            } else {
                if (aDr()) {
                    return cRO.get() ? cTe : cRk;
                } else if (aCZ() && aCY() == 1) {
                    return cRO.get() ? cTm : cRk;
                } else if (isLinkThread()) {
                    return cRy;
                } else {
                    if (aCr()) {
                        return cRz;
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
                    if (this.cQY) {
                        return cRr;
                    }
                    if (this.cQZ) {
                        return cRs;
                    }
                    if (this.cRb) {
                        return cRu;
                    }
                    if (this.cRc) {
                        return cRv;
                    }
                    if (this.cRa) {
                        return cRt;
                    }
                    if (this.cSN) {
                        int aDq = aDq();
                        if (aDq == 1) {
                            return cRl;
                        }
                        if (aDq == 2) {
                            return cRm;
                        }
                        if (aDq > 2) {
                            return cRn;
                        }
                        return cRk;
                    }
                    return cRk;
                }
            }
        }
    }

    public int aDq() {
        int i = 0;
        if (!com.baidu.tbadk.core.i.azO().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aCy()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aCy().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aDr() {
        return aBU() != null && getThreadType() == 41 && aCl() == 1 && aCW() == 2;
    }

    public void y(ArrayList<q> arrayList) {
        if (this.cRW == 1) {
            this.cOk = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.cOk = 0;
        } else {
            this.cOk = 0;
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next != null && next.aAv() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aAv().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.cOk = next.aAw();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aDs() {
        return this.threadType == 41;
    }

    public boolean aDt() {
        return this.cTn;
    }

    public void fz(boolean z) {
        this.cTn = z;
    }

    public String aDu() {
        return this.cTo;
    }

    public p aDv() {
        return this.cSS;
    }

    public void aDw() {
        if (this.cSL == 0) {
            this.cSL = 1;
        }
    }

    public void fA(boolean z) {
        this.cTA = z;
    }

    public boolean aDx() {
        return this.cTA;
    }

    public void jP(int i) {
        this.cTB = i + 1;
    }

    public int aDy() {
        return this.cTB;
    }

    public boolean aDz() {
        return this.cUp;
    }

    public void fB(boolean z) {
        this.cUp = z;
    }

    public boolean aDA() {
        return getThreadType() == 49;
    }

    public boolean aDB() {
        return getThreadType() == 40;
    }

    public boolean aDC() {
        return getThreadType() == 50;
    }

    public boolean aDD() {
        return getThreadType() == 60;
    }

    public int aDE() {
        return this.cTH;
    }

    public void setSmartFrsPosition(int i) {
        this.cTH = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aDF() {
        return this.mRecomSource;
    }

    public boolean aDG() {
        return this.cTI;
    }

    public long aDH() {
        return this.agreeData.agreeNum;
    }

    public long aDI() {
        return this.agreeData.disAgreeNum;
    }

    public int aDJ() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aDK() {
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

    public long aDL() {
        return this.cTK;
    }

    public void by(long j) {
        this.cTK = j;
    }

    public PostData aDM() {
        return this.cTJ;
    }

    public ag aDN() {
        return this.cTL;
    }

    private ArrayList<l.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<l.a> arrayList = new ArrayList<>();
        boolean aCp = aCp();
        if (z2) {
            if (z) {
                if (aCp && !aBb()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if (aCl() == 1 || getThreadType() == 33 || (aCn() != null && aCn().aEt() != 0)) {
                    if (aBU() != null && aDs()) {
                        if (aCW() == 2) {
                            arrayList.add(new l.a((int) R.string.interview_live));
                        }
                    } else if (!aCp) {
                        arrayList.add(new l.a((int) R.string.photo_live_tips));
                    }
                }
                if (aDs()) {
                    arrayList.add(cTE.get(aCW()));
                }
                if (aCZ()) {
                    Integer num = cTD.get(new Point(aCY(), aCX()));
                    if (num != null) {
                        arrayList.add(new l.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (aCA() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
            } else {
                if (aCp && aCj() != 1 && !aBb()) {
                    arrayList.add(new l.a((int) R.string.god_title));
                }
                if ((aCl() == 1 || getThreadType() == 33) && !aDs() && !aCp) {
                    arrayList.add(new l.a((int) R.string.photo_live_tips));
                }
                if (aCk() == 1) {
                    arrayList.add(new l.a((int) R.string.good));
                }
                if (aCj() == 1) {
                    arrayList.add(new l.a((int) R.string.f1281top));
                }
                if (aDs() && aBU() != null && aCW() == 2) {
                    arrayList.add(new l.a((int) R.string.interview_live));
                }
                if (aCZ()) {
                    Integer num2 = cTD.get(new Point(aCY(), aCX()));
                    if (num2 != null) {
                        arrayList.add(new l.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new l.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.cTp == 1) {
                    arrayList.add(new l.a((int) R.string.card_tbread_text));
                }
                if (aCB() != null) {
                    arrayList.add(new l.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aCA() != null) {
                    arrayList.add(new l.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new l.a(getCategory()));
                }
                if (z3 && aDA()) {
                    arrayList.add(new l.a((int) R.string.ala_live));
                }
                if (z3 && aDC()) {
                    arrayList.add(new l.a((int) R.string.live_record));
                } else if (aDB()) {
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
        this.cSr = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.cSs = arrayList;
    }

    public String aDO() {
        return this.cTW;
    }

    public void sK(String str) {
        this.cTW = str;
    }

    public void aDP() {
        this.cTU = 1;
    }

    public boolean aDQ() {
        return this.cTU == 1;
    }

    public boolean aDR() {
        return "worldcupvideo".equals(this.cTZ);
    }

    public String aDS() {
        return this.cSe;
    }

    public void sL(String str) {
        this.cSe = str;
    }

    public String aDT() {
        return this.cSf;
    }

    public void sM(String str) {
        this.cSf = str;
    }

    public String aDU() {
        return this.cTX;
    }

    public void sN(String str) {
        this.cTX = str;
    }

    public boolean aDV() {
        return this.cUa;
    }

    public void fC(boolean z) {
        this.cUa = z;
    }

    public void b(VideoInfo videoInfo) {
        this.cTY = videoInfo;
    }

    public boolean aDW() {
        return this.cUb != null;
    }

    public bf aDX() {
        return this.cSd;
    }

    public void a(bf bfVar) {
        this.cSd = bfVar;
    }

    public boolean aDY() {
        return this.cUe;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.cSG != null) {
            return this.cSG.video_url;
        }
        return null;
    }

    public boolean aDZ() {
        return this.cUg;
    }

    public void fD(boolean z) {
        this.cUg = z;
    }

    public AgreeData aEa() {
        return this.agreeData;
    }

    public boolean aEb() {
        return this.cUq;
    }

    public void fE(boolean z) {
        this.cUq = z;
    }

    public boolean aEc() {
        return this.cUr;
    }

    public void fF(boolean z) {
        this.cUr = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aEd() {
        return this.cTV;
    }

    public String getShareImageUrl() {
        return this.cUm;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCy = aCy();
        if (com.baidu.tbadk.core.i.azO().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCy) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCy.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy, 0);
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

    public int[] aEe() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aCy = aCy();
        if (com.baidu.tbadk.core.i.azO().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aCy) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aCy.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aCy, 0);
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

    public boolean aEf() {
        return aEg() || aEh();
    }

    public boolean aBd() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aBe() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aEg() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aEh() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aEi() {
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
        return aEi();
    }

    public void jT(int i) {
        this.cUw = i;
    }

    public int aEj() {
        return this.cUy;
    }

    public String aEk() {
        return this.cUx;
    }

    public void sO(String str) {
        this.cUx = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aEl() {
        if (aCq()) {
            return 4;
        }
        if (aDA() || aDC()) {
            return 3;
        }
        if (aBd()) {
            return 5;
        }
        if (aBe()) {
            return 6;
        }
        if (aEg()) {
            return 7;
        }
        if (aEh()) {
            return 8;
        }
        if (this.isShareThread && this.cTR != null) {
            return 9;
        }
        if (aDB()) {
            return 2;
        }
        return 1;
    }

    public int aEm() {
        if (aEh() || aEg()) {
            return 2;
        }
        if (aBd() || aBe()) {
            return 3;
        }
        return 1;
    }
}

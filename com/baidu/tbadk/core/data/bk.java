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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.switchs.ConveneThreadOpenSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
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
public class bk extends AbsThreadDataSupport implements com.baidu.adp.widget.ListView.o, com.baidu.tbadk.core.util.ae, com.baidu.tbadk.core.util.f.a {
    private String aWu;
    private String address;
    private String authorId;
    public int dDb;
    private SpannableString dDh;
    private String dFA;
    public int dFO;
    private int dFP;
    private int dFS;
    public int dFT;
    private String dFW;
    private String dFX;
    private int dFZ;
    private int dFr;
    private SpannableStringBuilder dFw;
    private SpannableStringBuilder dFx;
    private bg dFy;
    private String dFz;
    public TwZhiBoUser dGB;
    public List<TwAnchorProfitItem> dGC;
    private SkinInfo dGG;
    private boolean dGI;
    private String dGJ;
    private boolean dGM;
    public String dGO;
    public int dGP;
    public int dGQ;
    public String dGR;
    public String dGS;
    public long dGT;
    private List<ReportInfo> dGX;
    private VideoInfo dGb;
    private VideoDesc dGc;
    private br dGd;
    private AlaInfoData dGe;
    private long dGf;
    private o dGn;
    private LiveCoverStatus dGt;
    private long dGu;
    private SmartApp dHA;
    private String dHC;
    private String dHD;
    private String dHE;
    private String dHF;
    private String dHG;
    public String dHH;
    private boolean dHK;
    private boolean dHL;
    public boolean dHM;
    public boolean dHN;
    public boolean dHO;
    public boolean dHP;
    public String dHQ;
    private int dHR;
    private String dHS;
    private int dHT;
    public String dHV;
    private String dHW;
    private ThreadInfo dHX;
    private boolean dHd;
    private long dHf;
    private af dHg;
    public e dHi;
    private MediaData dHj;
    public int dHk;
    public OriginalThreadInfo dHm;
    private TopicModule dHq;
    private String dHr;
    private String dHs;
    private VideoInfo dHt;
    private String dHu;
    public OriginalForumInfo dHw;
    public boolean dHx;
    private String dHy;
    private boolean dHz;
    public boolean isBigGie;
    private boolean isLinkThread;
    public boolean isPrivacy;
    public boolean isShareThread;
    private String latitude;
    private BaijiahaoData mBaijiahao;
    private long mCreateTime;
    private String mNid;
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
    public static final BdUniqueId dED = BdUniqueId.gen();
    public static final BdUniqueId dEE = BdUniqueId.gen();
    public static final BdUniqueId dEF = BdUniqueId.gen();
    public static final BdUniqueId dEG = BdUniqueId.gen();
    public static final BdUniqueId dEH = BdUniqueId.gen();
    public static final BdUniqueId dEI = BdUniqueId.gen();
    public static final BdUniqueId dEJ = BdUniqueId.gen();
    public static final BdUniqueId dEK = BdUniqueId.gen();
    public static final BdUniqueId dEL = BdUniqueId.gen();
    public static final BdUniqueId dEM = BdUniqueId.gen();
    public static final BdUniqueId dEN = BdUniqueId.gen();
    public static final BdUniqueId dEO = BdUniqueId.gen();
    public static final BdUniqueId dEP = BdUniqueId.gen();
    public static final BdUniqueId dEQ = BdUniqueId.gen();
    public static final BdUniqueId dER = BdUniqueId.gen();
    public static final BdUniqueId dES = BdUniqueId.gen();
    public static final BdUniqueId dET = BdUniqueId.gen();
    public static final BdUniqueId dEU = BdUniqueId.gen();
    public static final BdUniqueId dEV = BdUniqueId.gen();
    public static final BdUniqueId dEW = BdUniqueId.gen();
    public static final BdUniqueId dEX = BdUniqueId.gen();
    public static final BdUniqueId dEY = BdUniqueId.gen();
    public static final BdUniqueId dEZ = BdUniqueId.gen();
    public static final BdUniqueId dFa = BdUniqueId.gen();
    public static final BdUniqueId dFb = BdUniqueId.gen();
    public static final BdUniqueId dFc = BdUniqueId.gen();
    public static final BdUniqueId dFd = BdUniqueId.gen();
    public static final BdUniqueId dFe = BdUniqueId.gen();
    public static final BdUniqueId dFf = BdUniqueId.gen();
    public static final BdUniqueId dFg = BdUniqueId.gen();
    public static final BdUniqueId dFh = BdUniqueId.gen();
    public static final BdUniqueId dFi = BdUniqueId.gen();
    public static AtomicBoolean dFj = new AtomicBoolean(false);
    public static AtomicBoolean dFk = new AtomicBoolean(false);
    public static AtomicBoolean dFl = new AtomicBoolean(false);
    public static final BdUniqueId dFm = BdUniqueId.gen();
    public static final BdUniqueId dFn = BdUniqueId.gen();
    private static HashMap<Point, Integer> dGo = new HashMap<>();
    private static HashMap<Integer, Integer> dGp = new HashMap<>();
    public static final BdUniqueId dGz = BdUniqueId.gen();
    public static final BdUniqueId dGH = BdUniqueId.gen();
    private static HashMap<Point, Integer> dGY = new HashMap<>();
    private static SparseArray<m.a> dGZ = new SparseArray<>(3);
    public boolean dEo = false;
    public boolean dEp = false;
    public boolean dEq = false;
    public boolean dEr = false;
    public boolean dEs = false;
    public boolean dEt = false;
    public boolean dEu = false;
    public boolean dEv = false;
    private int dFo = 0;
    private String dFp = "1";
    public int dFq = 1;
    private String dFR = null;
    private int dBH = 0;
    public int dGg = 0;
    private String dGh = "";
    public boolean dGi = false;
    private String dGq = "";
    public boolean dGU = true;
    public boolean dHa = false;
    public boolean dHb = false;
    private int dHc = -1;
    public SparseArray<String> feedBackReasonMap = null;
    public boolean dHh = false;
    private int dHp = 0;
    private boolean dHv = false;
    private boolean dHB = false;
    public boolean dHI = false;
    public boolean dHJ = false;
    public boolean forbidComment = false;
    public boolean dHU = false;
    private String id = null;
    public String tid = null;
    private long fid = 0;
    private String title = null;
    private int is_god = 0;
    private int reply_num = 0;
    private int dFB = 0;
    private int dFC = 0;
    private String last_time = null;
    private long dFD = 0;
    private int dFE = 0;
    private int dFF = 0;
    private int dFG = 0;
    private int dFH = 0;
    private bo dFI = new bo();
    private MetaData dFJ = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> dFM = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> dFN = new ArrayList<>();
    private int dFK = 0;
    private int dFL = 0;
    private String ad_url = null;
    private String dFs = null;
    private String from = null;
    private int dFQ = 0;
    private PraiseData dFU = new PraiseData();
    private AnchorInfoData dFV = new AnchorInfoData();
    private long time = 0;
    private int dFY = 0;
    private ArrayList<a> dGk = new ArrayList<>();
    private bw dGl = null;
    private f dGm = null;
    private int dGr = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.c> dGa = new ArrayList<>();
    private boolean isHeadLive = false;
    private String dGs = null;
    private int dGj = 0;
    private boolean dGv = false;
    private boolean dGw = false;
    private int dGx = 0;
    private boolean dGy = false;
    private int anchorLevel = 0;
    public int dGK = 0;
    public l dGL = new l();
    private List<PbContent> dFv = new ArrayList();
    private List<PbContent> dFt = new ArrayList();
    private List<PbContent> dFu = new ArrayList();
    private String category_name = null;
    private bi dGA = new bi();
    private ArrayList<com.baidu.tbadk.data.c> dGD = new ArrayList<>();
    private PushStatusData dGE = new PushStatusData();
    public boolean dGV = false;
    public int dGW = -1;
    private PostData dHe = new PostData();
    private AgreeData agreeData = new AgreeData();
    private int dGN = 0;
    public int dHl = 0;
    private String tieba_game_information_source = "";
    public String dHo = "";
    public String dHn = "";
    public String mUrl = "";
    public String dGF = "";

    static {
        dGo.put(new Point(1, 1), Integer.valueOf((int) R.drawable.label_frs_lottery_ing));
        dGo.put(new Point(1, 2), Integer.valueOf((int) R.drawable.label_frs_lottery_over));
        dGo.put(new Point(1, 3), Integer.valueOf((int) R.drawable.label_frs_lottery_off));
        dGo.put(new Point(1, 4), Integer.valueOf((int) R.drawable.label_frs_lottery_d));
        dGo.put(new Point(2, 1), Integer.valueOf((int) R.drawable.label_frs_activity_shaiing));
        dGo.put(new Point(2, 2), Integer.valueOf((int) R.drawable.label_frs_activity_shai_over));
        dGo.put(new Point(2, 3), Integer.valueOf((int) R.drawable.label_frs_activity_shai_off));
        dGo.put(new Point(2, 4), Integer.valueOf((int) R.drawable.label_frs_activity_shai_d));
        dGY.put(new Point(1, 1), Integer.valueOf((int) R.string.lottery_status_ing));
        dGY.put(new Point(1, 2), Integer.valueOf((int) R.string.lottery_status_over));
        dGY.put(new Point(1, 3), Integer.valueOf((int) R.string.lottery_status_off));
        dGY.put(new Point(1, 4), Integer.valueOf((int) R.string.lottery_status_not_start));
        dGY.put(new Point(2, 1), Integer.valueOf((int) R.string.share_picture_status_ing));
        dGY.put(new Point(2, 2), Integer.valueOf((int) R.string.share_picture_status_over));
        dGY.put(new Point(2, 3), Integer.valueOf((int) R.string.share_picture_status_off));
        dGY.put(new Point(2, 4), Integer.valueOf((int) R.string.share_picture_status_not_start));
        dGp.put(1, Integer.valueOf((int) R.drawable.label_interview_no));
        dGp.put(2, Integer.valueOf((int) R.drawable.label_interview_live));
        dGp.put(3, Integer.valueOf((int) R.drawable.label_interview_off));
        dGZ.put(1, new m.a(R.string.interview_live_status_not_start, R.color.cp_other_b, R.drawable.pic_dot_title_red));
        dGZ.put(2, new m.a(R.string.interview_live_status_ing, R.color.cp_other_c, R.drawable.pic_dot_title_green));
        dGZ.put(3, new m.a(R.string.interview_live_status_over, R.color.cp_link_tip_b, R.drawable.pic_dot_title_blue));
    }

    public bk() {
        this.dFP = 0;
        this.dFZ = 0;
        this.dGu = 0L;
        this.dHk = 0;
        this.isBigGie = false;
        this.post_num = 0;
        this.post_num = 0;
        this.dGu = 0L;
        this.dFZ = 0;
        this.dFP = 0;
        this.dHk = 0;
        this.isBigGie = false;
    }

    public String aPV() {
        return this.dHC;
    }

    public String aPW() {
        return this.dHD;
    }

    public void vz(String str) {
        this.dHD = str;
    }

    public String aPX() {
        return this.dHE;
    }

    public SpannableStringBuilder aPY() {
        return this.dFx;
    }

    public SpannableString aPZ() {
        return this.dDh;
    }

    public void a(SpannableString spannableString) {
        if (aQx() != null) {
            if (this.dFx != null) {
                this.dFx.insert(0, (CharSequence) spannableString);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.dDh);
            spannableStringBuilder.insert(0, (CharSequence) spannableString);
            this.dDh = new SpannableString(spannableStringBuilder);
        }
    }

    public String aQa() {
        return this.dHF;
    }

    public String aQb() {
        return this.dHG;
    }

    public boolean aQc() {
        return this.dFP == 1;
    }

    public bi aQd() {
        return this.dGA;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void kp(int i) {
        this.anchorLevel = i;
    }

    public int getOperatorFlag() {
        return this.dFZ;
    }

    public void kq(int i) {
        this.dGx = i;
    }

    public int aQe() {
        return this.dGx;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public VideoInfo aQf() {
        return this.dHt;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public void bZ(long j) {
        this.mCreateTime = j;
    }

    public long aQg() {
        return this.dGf;
    }

    public String aQh() {
        return this.dFW;
    }

    public PraiseData aQi() {
        return this.dFU;
    }

    public void a(PraiseData praiseData) {
        this.dFU = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String aQj() {
        return this.aWu;
    }

    public void vA(String str) {
        this.aWu = str;
    }

    public String aQk() {
        return this.dFp;
    }

    public void vB(String str) {
        this.dFp = str;
    }

    public String getId() {
        return this.id;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void kr(int i) {
        this.dFo = i;
    }

    public int aQl() {
        return this.dFo;
    }

    public String aQm() {
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

    public List<PbContent> aQn() {
        return this.dFv;
    }

    public void aA(List<PbContent> list) {
        this.dFv = list;
    }

    public void aB(List<PbContent> list) {
        this.dFt = list;
    }

    public void aC(List<PbContent> list) {
        this.dFu = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void ks(int i) {
        this.reply_num = i;
    }

    public int aQo() {
        return this.reply_num;
    }

    public int aQp() {
        return this.dFC;
    }

    public void kt(int i) {
        this.dFC = i;
    }

    public long aQq() {
        return this.dFD;
    }

    public void ca(long j) {
        this.dFD = j;
    }

    public int aQr() {
        return this.dFF;
    }

    public int aQs() {
        return this.dFE;
    }

    public void ku(int i) {
        this.dFE = i;
    }

    public int aQt() {
        return this.dFG;
    }

    public void kv(int i) {
        this.dFG = i;
    }

    public int aQu() {
        return this.dFH;
    }

    public List<PbContent> aQv() {
        return this.dFt;
    }

    public bo aQw() {
        return this.dFI;
    }

    public MetaData aQx() {
        return this.dFJ;
    }

    public boolean aQy() {
        return this.is_god != 0;
    }

    public boolean aQz() {
        return this.is_god == 1;
    }

    public boolean aQA() {
        return (this.dFJ == null || this.dFJ.getGodUserData() == null || this.dFJ.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean aQB() {
        return this.isBigGie;
    }

    public void a(MetaData metaData) {
        this.dFJ = metaData;
    }

    public String aQC() {
        return this.forum_name;
    }

    public void vC(String str) {
        this.forum_name = str;
    }

    public int aQD() {
        return this.dFL;
    }

    public String aQE() {
        return this.ad_url;
    }

    public int aQF() {
        return this.dFQ;
    }

    public void kw(int i) {
        this.dFQ = i;
    }

    public String aQG() {
        return this.dFR;
    }

    public void vD(String str) {
        this.dFR = str;
    }

    public ArrayList<MediaData> aQH() {
        return this.dFM;
    }

    public ArrayList<a> aQI() {
        return this.dGk;
    }

    public void x(ArrayList<a> arrayList) {
        this.dGk = arrayList;
    }

    public bw aQJ() {
        return this.dGl;
    }

    public f aQK() {
        return this.dGm;
    }

    public ArrayList<VoiceData.VoiceModel> aQL() {
        return this.dFN;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int aQM() {
        return this.dFr;
    }

    public void kx(int i) {
        this.dFr = i;
    }

    public String aQN() {
        return this.latitude;
    }

    public String aQO() {
        return this.dFX;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String aQP() {
        return this.dGh;
    }

    public VideoInfo aQQ() {
        return this.dGb;
    }

    public void a(VideoInfo videoInfo) {
        this.dGb = videoInfo;
    }

    public VideoDesc aQR() {
        return this.dGc;
    }

    public void a(AlaInfoData alaInfoData) {
        this.dGe = alaInfoData;
    }

    public AlaInfoData aQS() {
        return this.dGe;
    }

    public PushStatusData aQT() {
        return this.dGE;
    }

    public SkinInfo aQU() {
        return this.dGG;
    }

    public long aQV() {
        return this.dGT;
    }

    public boolean aQW() {
        return this.dGU;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
        return this;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aOj() {
        return this.dGS;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        if (this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ak akVar = new ak();
        akVar.setTid(aOi().getTid());
        akVar.setFid(aOi().getFid());
        akVar.setNid(aOi().getNid());
        akVar.setFeedBackReasonMap(this.feedBackReasonMap);
        akVar.abTag = this.mRecomAbTag;
        akVar.weight = this.mRecomWeight;
        akVar.extra = this.mRecomExtra;
        akVar.source = this.mRecomSource;
        akVar.dDb = this.dDb;
        akVar.cardType = aSA();
        return akVar;
    }

    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.dFX = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.dFP = threadInfo.is_tbread_dispatch.intValue();
                this.id = threadInfo.id + "";
                this.tid = threadInfo.tid + "";
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.is_god = threadInfo.is_god.intValue();
                this.mCreateTime = threadInfo.create_time.intValue() * 1000;
                this.dGf = threadInfo.audit_time.longValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.dFB = threadInfo.repost_num.intValue();
                this.dFC = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.dFD = threadInfo.last_time_int.intValue();
                this.dFE = threadInfo.is_top.intValue();
                this.dFF = threadInfo.is_membertop.intValue();
                this.dFG = threadInfo.is_good.intValue();
                this.dFH = threadInfo.is_livepost.intValue();
                this.dFI.a(threadInfo.topic);
                this.dFJ.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.dFK = threadInfo.has_commented.intValue();
                this.dFL = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.dGb = threadInfo.video_info;
                this.dGc = threadInfo.video_segment;
                this.dGe = new AlaInfoData();
                this.dGe.parserProtobuf(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.dFQ = threadInfo.collect_status.intValue();
                this.dFR = threadInfo.collect_mark_pid;
                this.dFS = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.dFT = threadInfo.thread_type.intValue();
                this.dFW = threadInfo.first_post_id + "";
                this.dGh = threadInfo.post_id + "";
                this.time = threadInfo.time.intValue() * 1000;
                this.dFr = threadInfo.is_ntitle.intValue();
                this.dFY = threadInfo.is_activity.intValue();
                if (threadInfo.agree != null) {
                    this.agreeData.threadId = threadInfo.id == null ? "" : String.valueOf(threadInfo.id);
                    this.agreeData.parseProtobuf(threadInfo.agree);
                }
                if (!StringUtils.isNull(threadInfo.tieba_game_information_source)) {
                    this.tieba_game_information_source = threadInfo.tieba_game_information_source;
                } else {
                    this.tieba_game_information_source = "";
                }
                this.dHf = threadInfo.share_num.longValue();
                this.category_name = threadInfo.category_name;
                this.dFZ = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.dGM = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.dFt = threadInfo.rich_title;
                this.dFv = threadInfo.first_post_content;
                this.dFu = threadInfo.rich_abstract;
                this.dFO = threadInfo.is_godthread_recommend.intValue();
                if ((this.dFJ == null || this.dFJ.getUserId() == null || this.dFJ.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.dFJ = metaData;
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
                this.dFs = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.dFM.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.dGb = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.dGd = new br();
                    this.dGd.a(threadInfo.video_channel_info);
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
                        this.dFN.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.dGk.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.dGl = new bw();
                    this.dGl.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.dGm = new f();
                    this.dGm.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.dGn = new o();
                    this.dGn.a(threadInfo.cartoon_info);
                }
                this.dFU.setUserMap(this.userMap);
                this.dFU.parserProtobuf(threadInfo.zan);
                this.dFV.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dFU.setTitle(this.title);
                } else {
                    this.dFU.setTitle(this.dFs);
                }
                this.dGq = threadInfo.livecover_src;
                this.dGr = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.dGj = threadInfo.post_num.intValue();
                this.dGu = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.c cVar = new com.baidu.tbadk.coreExtra.view.c();
                                cVar.mR(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                cVar.xC(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                cVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.dGa.add(cVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.dGs = noticeInfo.notice;
                    }
                    this.dGx = zhiBoInfoTW.copythread_remind.intValue();
                    this.dGv = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.dGw = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.dGq)) {
                        this.dGq = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.dGB = zhiBoInfoTW.user.tw_anchor_info;
                        this.dGC = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.dGt = threadInfo.twzhibo_info.livecover_status;
                    this.dGu = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.dGy = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.dGA.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.c cVar2 = new com.baidu.tbadk.data.c();
                        cVar2.a(threadInfo.ext_tails.get(i6));
                        this.dGD.add(cVar2);
                    }
                }
                this.dGE.parserProtobuf(threadInfo.push_status);
                this.dGJ = threadInfo.lego_card;
                this.dGG = threadInfo.skin_info;
                this.dGK = threadInfo.is_book_chapter.intValue();
                this.dGL.a(threadInfo.book_chapter);
                this.mRecomSource = threadInfo.recom_source;
                this.dGS = threadInfo.recom_reason;
                this.mRecomWeight = threadInfo.recom_weight;
                this.mRecomAbTag = threadInfo.ab_tag;
                this.mRecomExtra = threadInfo.recom_extra;
                this.dGT = threadInfo.last_read_pid.longValue();
                this.dGU = threadInfo.cheak_repeat.intValue() == 1;
                this.dGX = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.dHe.a(threadInfo.top_agree_post, TbadkCoreApplication.getInst().getApplicationContext());
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
                this.dHd = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.dHg = new af();
                    this.dHg.a(threadInfo.link_info);
                }
                this.dHh = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.dHi = new e();
                    this.dHi.a(threadInfo.activity_info);
                }
                if (threadInfo.pic_info != null) {
                    this.dHj = new MediaData();
                    this.dHj.parserProtobuf(threadInfo.pic_info);
                }
                this.dGN = threadInfo.is_called.intValue();
                this.dHk = threadInfo.middle_page_num.intValue();
                this.dHl = threadInfo.middle_page_pass_flag.intValue();
                this.isShareThread = threadInfo.is_share_thread.intValue() == 1;
                if (threadInfo.star_rank_icon != null) {
                    this.dHn = threadInfo.star_rank_icon.icon_pic_url;
                    this.dHo = threadInfo.star_rank_icon.icon_link;
                }
                if (threadInfo.origin_thread_info != null) {
                    this.dHm = new OriginalThreadInfo();
                    this.dHm.a(threadInfo.origin_thread_info);
                } else {
                    this.dHm = null;
                    this.isShareThread = false;
                }
                this.dHp = threadInfo.is_topic.intValue();
                this.dHr = threadInfo.topic_user_name;
                this.dHs = threadInfo.topic_h5_url;
                this.dHq = threadInfo.topic_module;
                this.dHu = threadInfo.presentation_style;
                this.dHw = OriginalForumInfo.parser(threadInfo.ori_forum_info);
                this.dHy = threadInfo.daily_paper_time;
                this.isBigGie = threadInfo.is_videobiggie_recomthread.intValue() == 1;
                if (threadInfo.forum_info != null) {
                    this.dFy = new bg();
                    this.dFy.parserProtobuf(threadInfo.forum_info);
                }
                if (threadInfo.swan_info != null) {
                    this.dHA = threadInfo.swan_info;
                }
                this.dHH = threadInfo.t_share_img;
                this.mNid = threadInfo.nid;
                this.dHI = threadInfo.is_headlinepost.intValue() == 1;
                this.thread_share_link = threadInfo.thread_share_link;
                this.dHS = threadInfo.article_cover;
                this.dHT = threadInfo.bjh_content_tag.intValue();
                this.dHR = threadInfo.is_bjh.intValue();
                if (threadInfo.baijiahao != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseProto(threadInfo.baijiahao);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dHU = threadInfo.is_s_card.intValue() == 1;
                this.dHV = threadInfo.scard_packet_id;
                this.mTabId = threadInfo.tab_id.intValue();
                this.mTabName = threadInfo.tab_name;
                this.dHW = threadInfo.wonderful_post_info;
                aQX();
                this.forbidComment = threadInfo.if_comment.intValue() == 1;
                this.noCommetStr = threadInfo.if_comment_info;
                this.dHX = threadInfo;
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
                this.dGf = jSONObject.optLong("audit_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.dFB = jSONObject.optInt("repost_num", 0);
                this.dFC = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.dFD = jSONObject.optLong("last_time_int", 0L);
                this.dFE = jSONObject.optInt("is_top", 0);
                this.dFF = jSONObject.optInt("is_membertop", 0);
                this.dFG = jSONObject.optInt("is_good", 0);
                this.dFH = jSONObject.optInt("is_livepost", 0);
                this.dFI.parserJson(jSONObject.optJSONObject(UgcConstant.TOPIC));
                this.authorId = jSONObject.optString("author_id");
                this.dFJ.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString("fname");
                this.dFK = jSONObject.optInt("has_commented", 0);
                this.dFL = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.dFQ = jSONObject.optInt("collect_status");
                this.dFR = jSONObject.optString("collect_mark_pid");
                this.dFS = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.dFT = jSONObject.optInt("thread_type");
                this.dHf = jSONObject.optLong("share_num");
                this.dFW = jSONObject.optString("first_post_id", "0");
                this.dGh = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.dFr = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                this.tieba_game_information_source = jSONObject.optString("tieba_game_information_source", "");
                this.agreeData.parseJson(jSONObject.optJSONObject("agree"));
                this.agreeData.threadId = this.tid;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.dGA.parserJson(optJSONObject2);
                }
                if ((this.dFJ == null || this.dFJ.getUserId() == null) && this.userMap != null) {
                    this.dFJ = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.dGe = new AlaInfoData();
                this.dGe.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.dFs = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.dFM.add(mediaData);
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
                        this.dFN.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.dGk.add(aVar);
                    }
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("yule_post_activity");
                if (optJSONObject4 != null) {
                    this.dGl = new bw();
                    this.dGl.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("app_code");
                if (optJSONObject5 != null) {
                    this.dGm = new f();
                    this.dGm.parserJson(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("cartoon_info");
                if (optJSONObject6 != null) {
                    this.dGn = new o();
                    this.dGn.parserJson(optJSONObject6);
                }
                this.dFU.setUserMap(this.userMap);
                this.dFU.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.dFV.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.dFU.setTitle(this.title);
                } else {
                    this.dFU.setTitle(this.dFs);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("task_info");
                if (optJSONObject7 != null) {
                    this.dGA.parserJson(optJSONObject7);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.dGD.add(cVar);
                    }
                }
                this.dGK = jSONObject.optInt("is_book_chapter", 0);
                this.dGL.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.mRecomSource = jSONObject.optString(IntentConfig.RECOM_SOURCE);
                this.dGS = jSONObject.optString("recom_reason");
                this.mRecomWeight = jSONObject.optString("recom_weight");
                this.mRecomExtra = jSONObject.optString("recom_extra");
                this.dGO = jSONObject.optString("recom_extra_img");
                this.dGR = jSONObject.optString("recom_extra_img_night");
                this.dGP = jSONObject.optInt("recom_extra_img_width", 0);
                this.dGQ = jSONObject.optInt("recom_extra_img_height", 0);
                this.dGT = jSONObject.optLong("last_read_pid");
                this.dGU = jSONObject.optInt("cheak_repeat") == 1;
                JSONObject optJSONObject8 = jSONObject.optJSONObject("video_channel_info");
                if (optJSONObject8 != null) {
                    this.dGd = new br();
                    this.dGd.cz(optJSONObject8);
                }
                this.dHd = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                JSONObject optJSONObject9 = jSONObject.optJSONObject("link_info");
                if (this.isLinkThread && optJSONObject9 != null) {
                    this.dHg = new af();
                    this.dHg.parserJson(optJSONObject9);
                }
                this.dHh = jSONObject.optInt("is_partial_visible") == 1;
                this.isBigGie = jSONObject.optInt("is_videobiggie_recomthread", 0) == 1;
                JSONObject optJSONObject10 = jSONObject.optJSONObject("activity_info");
                if (optJSONObject10 != null) {
                    this.dHi = new e();
                    this.dHi.parserJson(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("pic_info");
                if (optJSONObject11 != null) {
                    this.dHj = new MediaData();
                    this.dHj.parserJson(optJSONObject11);
                }
                this.dGN = jSONObject.optInt("is_called", 0);
                this.dHk = jSONObject.optInt("middle_page_num", 0);
                this.dHl = jSONObject.optInt("middle_page_pass_flag", 0);
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
                    this.dGb = builder.build(true);
                }
                this.isShareThread = jSONObject.optInt("is_share_thread", 0) == 1;
                if (this.isShareThread) {
                    JSONObject optJSONObject13 = jSONObject.optJSONObject("origin_thread_info");
                    if (optJSONObject13 != null) {
                        this.dHm = new OriginalThreadInfo();
                        this.dHm.parserJson(optJSONObject13);
                    } else {
                        this.dHm = null;
                    }
                } else {
                    this.dHm = null;
                }
                JSONObject optJSONObject14 = jSONObject.optJSONObject("swan_info");
                if (optJSONObject14 != null) {
                    SmartApp.Builder builder2 = new SmartApp.Builder();
                    builder2.avatar = optJSONObject14.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                    builder2.name = optJSONObject14.optString("name");
                    builder2._abstract = optJSONObject14.optString("abstract");
                    builder2.pic = optJSONObject14.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                    builder2.h5_url = optJSONObject14.optString("h5_url");
                    builder2.id = optJSONObject14.optString("id");
                    builder2.link = optJSONObject14.optString("link");
                    this.dHA = builder2.build(false);
                }
                this.dHH = jSONObject.optString("t_share_img");
                this.mNid = jSONObject.optString("nid");
                this.dHI = jSONObject.optInt("is_headlinepost", 0) == 1;
                this.dHR = jSONObject.optInt(ImageViewerConfig.IS_BJH);
                this.dHT = jSONObject.optInt("bjh_content_tag");
                this.dHS = jSONObject.optString("article_cover");
                JSONObject optJSONObject15 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject15 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject15);
                    this.agreeData.baijiahaoData = this.mBaijiahao;
                }
                this.dHU = jSONObject.optInt("is_s_card", 0) == 1;
                this.dHV = jSONObject.optString("scard_packet_id");
                this.mTabId = jSONObject.optInt("tab_id");
                this.mTabName = jSONObject.optString("tab_name");
                this.dHW = jSONObject.optString("wonderful_post_info");
                aQX();
                this.forbidComment = jSONObject.optInt("if_comment", 0) == 1;
                this.noCommetStr = jSONObject.optString("if_comment_info");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void aQX() {
        aQY();
        aRa();
        aRd();
        aRe();
        aRf();
        aRg();
        aRh();
    }

    private void aQY() {
        if (!StringUtils.isNull(this.dFJ.getName_show())) {
            this.dHC = com.baidu.tbadk.core.util.aq.cutChineseAndEnglishWithSuffix(this.dFJ.getName_show(), 14, StringHelper.STRING_MORE);
        }
    }

    private void aQZ() {
        if (this.dGe != null) {
            if (this.dGe.openRecomDuration == 1 && this.mCreateTime > 0) {
                String ck = com.baidu.tbadk.core.util.aq.ck(this.mCreateTime);
                if (!StringUtils.isNull(ck)) {
                    this.dHD = ck;
                }
            }
            if (this.dGe.openRecomFans == 1) {
                int i = 0;
                if (this.dGe != null && this.dGe.user_info != null) {
                    i = this.dGe.user_info.anchor_fans;
                }
                if (!TextUtils.isEmpty(this.dHD) && i > 0) {
                    this.dHD += "   " + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + " " + com.baidu.tbadk.core.util.aq.cm(i);
                } else if (i > 0) {
                    this.dHD = TbadkCoreApplication.getInst().getResources().getString(R.string.ala_card_anchor_fans) + com.baidu.tbadk.core.util.aq.cm(i);
                }
            }
        }
    }

    private void aRa() {
        if (aSx() || (aSq() && getType() != dEW)) {
            long j = this.mCreateTime;
            if (j != 0) {
                String cj = com.baidu.tbadk.core.util.aq.cj(j);
                if (com.baidu.tbadk.core.util.aq.wu(cj)) {
                    cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j);
                }
                this.dHD = cj;
            }
            String str = "";
            if (this.dFJ != null && this.dFJ.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.dFJ.getBaijiahaoInfo().auth_desc)) {
                str = this.dFJ.getBaijiahaoInfo().auth_desc;
            }
            if (!TextUtils.isEmpty(this.dHD) && !TextUtils.isEmpty(str)) {
                this.dHD += "   " + str;
            } else if (!TextUtils.isEmpty(str)) {
                this.dHD = str;
            } else if (aSD()) {
                aRb();
            }
        } else if (getType() == dEW) {
            aQZ();
        } else {
            if (aQB()) {
                long aQq = aQq() * 1000;
                if (aQq != 0) {
                    this.dHD = com.baidu.tbadk.core.util.aq.cj(aQq);
                }
            } else {
                long aQq2 = 1000 * aQq();
                if (aQq2 != 0) {
                    String cj2 = com.baidu.tbadk.core.util.aq.cj(aQq2);
                    if (com.baidu.tbadk.core.util.aq.wu(cj2)) {
                        cj2 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aQq2);
                    }
                    this.dHD = TbadkCoreApplication.getInst().getApp().getString(R.string.repley_when) + cj2;
                } else {
                    long j2 = this.mCreateTime;
                    String cj3 = com.baidu.tbadk.core.util.aq.cj(j2);
                    if (com.baidu.tbadk.core.util.aq.wu(cj3)) {
                        cj3 = com.baidu.tbadk.core.util.aq.getFormatTimeShort(j2);
                    }
                    this.dHD = cj3;
                }
            }
            if (aSD()) {
                aRb();
            }
            if (!TextUtils.isEmpty(this.dHD) && !TextUtils.isEmpty(getAddress())) {
                this.dHD += " • " + getAddress();
            }
        }
    }

    private void aRb() {
        if (aSD() && !TextUtils.isEmpty(this.dFJ.getNewGodData().getFieldName())) {
            if (!TextUtils.isEmpty(this.dHD)) {
                this.dHD += "   " + this.dFJ.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            } else {
                this.dHD = this.dFJ.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            }
        }
    }

    public void aRc() {
        if (!aSx() && !aSq()) {
            if (!aQB()) {
                long aQq = 1000 * aQq();
                if (aQq != 0) {
                    String cj = com.baidu.tbadk.core.util.aq.cj(aQq);
                    if (com.baidu.tbadk.core.util.aq.wu(cj)) {
                        cj = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aQq);
                    }
                    this.dHD = cj;
                }
            }
            if (aSD()) {
                aRb();
            }
            if (!TextUtils.isEmpty(this.dHD) && !TextUtils.isEmpty(getAddress())) {
                this.dHD += " • " + getAddress();
            }
        }
    }

    private void aRd() {
        if (aQS() == null || aQS().share_info == null || aQS().share_info.share_user_count <= 0 || !aRS() || (this.dHk > 0 && this.dHl == 0)) {
            this.dHE = null;
            return;
        }
        int i = aQS().share_info.share_user_count;
        if (i == 1) {
            this.dHE = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple);
        } else {
            this.dHE = TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{com.baidu.tbadk.core.util.aq.numberUniform(i)});
        }
    }

    private void aRe() {
        this.dFx = aRv();
        com.baidu.tieba.card.m.a(this, this.dFx, true);
    }

    private void aRf() {
        this.dDh = aRt();
    }

    private void aRg() {
        this.dHF = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aQq() * 1000);
    }

    private void aRh() {
        this.dHG = com.baidu.tbadk.core.util.aq.getFormatTimeShort(aQq());
    }

    public SpannableStringBuilder aRi() {
        return this.dFw;
    }

    public boolean isTop() {
        return aQs() != 0;
    }

    public int aRj() {
        if (this.dGA != null) {
            long aPQ = this.dGA.aPQ();
            long aPR = this.dGA.aPR();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < aPQ) {
                return 1;
            }
            if (currentTimeMillis > aPR) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int aRk() {
        if (aRm() && this.dGk.size() >= 1) {
            a aVar = this.dGk.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int aOu = aVar.aOu();
            int aOv = aVar.aOv();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < aOu) {
                return 4;
            }
            return currentTimeMillis > aOv ? 2 : 1;
        }
        return -1;
    }

    public int aRl() {
        if (!aRm() || this.dGk.size() < 1 || this.dGk.get(0) == null) {
            return -1;
        }
        return this.dGk.get(0).aOt();
    }

    public boolean aRm() {
        return this.dFY == 1;
    }

    public String getActUrl() {
        return (!aRm() || this.dGk.size() < 1 || this.dGk.get(0) == null) ? "" : this.dGk.get(0).getUrl();
    }

    private com.baidu.adp.widget.b vE(String str) {
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

    public SmartApp aRn() {
        return this.dHA;
    }

    private void u(boolean z, boolean z2) {
        SpannableString spannableString;
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.b bVar = null;
        if (!z2) {
            if (getThreadType() == 42 && aRp()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_convene));
            }
            if (aQs() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            } else if (aQs() == 2) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
            }
            if (aQu() == 1 || this.dFI.aSK() != 0) {
                if (aQd() != null && getThreadType() == 41) {
                    if (aRj() == 2) {
                        arrayList.add(Integer.valueOf((int) R.drawable.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_zhibo));
                }
            }
            if (z && aRG()) {
                Integer num = dGp.get(Integer.valueOf(aRj()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (aQt() == 1 && !isTop() && dEV != getType() && dFd != getType()) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (this.dFV != null && this.dFV.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_live_on));
            }
            if (aQD() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            Integer num2 = dGo.get(new Point(aRl(), aRk()));
            if (num2 != null) {
                arrayList.add(num2);
            }
            if (aQJ() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.tag_act));
            }
            if (aQK() != null) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.k.isEmpty(this.category_name)) {
                bVar = vE(this.category_name);
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
                Bitmap bitmap = com.baidu.tbadk.core.util.am.getBitmap(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApplicationContext(), this.dFq));
                spannableString.setSpan(iVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (bVar != null) {
                spannableString.setSpan(bVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableStringBuilder aRq = aRq();
        if (aRq != null) {
            spannableStringBuilder.append((CharSequence) aRq);
        }
        this.dFw = spannableStringBuilder;
    }

    public boolean aRo() {
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
        com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable, -100, dimensionPixelOffset, dimensionPixelOffset);
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("nani_key_show_tail_txt", TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix));
        if (StringUtils.isNull(string)) {
            string = TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.nani_tail_default_postfix);
        }
        StringBuilder sb = new StringBuilder(string);
        if (aQx() != null) {
            if (aQx().getGender() == 1) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.he));
            } else if (aQx().getGender() == 2) {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.she));
            } else {
                sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
            }
        } else {
            sb.insert(0, TbadkCoreApplication.getInst().getApplicationContext().getString(R.string.ta));
        }
        sb.insert(0, "[icon]");
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(jVar, 0, "[icon]".length(), 17);
        spannableString.setSpan(clickableSpan, "[icon]".length(), spannableString.length(), 17);
        return spannableString;
    }

    private boolean aRp() {
        return SwitchManager.getInstance().findType(ConveneThreadOpenSwitch.KEY) == 1;
    }

    public void v(boolean z, boolean z2) {
        c(z, z2, true);
    }

    public void c(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder spannableStringBuilder;
        if (com.baidu.tbadk.core.util.v.getCount(b(z, z2, z3, false)) > 0) {
            w(z, z3);
            return;
        }
        SpannableStringBuilder aRq = aRq();
        if (z) {
            spannableStringBuilder = a(aRq.toString(), aRq, z, z2, z3, false);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(aRq);
        }
        this.dFw = spannableStringBuilder;
    }

    private SpannableStringBuilder a(String str, SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> b = b(z, z2, z3, z4);
        if (b == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.m.a((Context) TbadkCoreApplication.getInst(), str, b, false);
        if (b.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.dFr == 1) {
                this.dFw = a;
                return a;
            }
        } else if (this.dFr == 1) {
            this.dFw = new SpannableStringBuilder();
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

    public void cY(String str, String str2) {
        this.mUrl = str;
        this.dGF = str2;
    }

    public SpannableStringBuilder aRq() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dFt, this.title);
    }

    public SpannableStringBuilder aRr() {
        return com.baidu.tbadk.widget.richText.e.a(this, this.dFu, this.dFs);
    }

    public ArrayList<com.baidu.tbadk.widget.richText.b> aRs() {
        ArrayList<com.baidu.tbadk.widget.richText.b> arrayList = new ArrayList<>();
        if (this.dHU) {
            arrayList.add(new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getResources().getString(R.string.s_card_package_icon)));
        }
        return arrayList;
    }

    public SpannableString aRt() {
        SpannableStringBuilder aRr = aRr();
        com.baidu.tieba.card.m.a(this, aRr, false);
        return new SpannableString(aRr);
    }

    public SpannableString aRu() {
        if (com.baidu.tbadk.core.util.v.isEmpty(this.dFv)) {
            return null;
        }
        return new SpannableString(com.baidu.tbadk.widget.richText.e.a(this, this.dFv, this.dFs));
    }

    public String getAbstract() {
        return this.dFs;
    }

    public void vF(String str) {
        this.dFs = str;
    }

    public SpannableStringBuilder d(boolean z, boolean z2, boolean z3) {
        SpannableStringBuilder aRq;
        String spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        if (this.dFr == 1) {
            aRq = aRr();
            spannableStringBuilder = aRq.toString();
        } else {
            aRq = aRq();
            spannableStringBuilder = aRq.toString();
        }
        if (z) {
            spannableStringBuilder2 = a(spannableStringBuilder, aRq, z, true, z2, z3);
        } else {
            spannableStringBuilder2 = new SpannableStringBuilder(aRq);
        }
        this.dFw = spannableStringBuilder2;
        return spannableStringBuilder2;
    }

    public SpannableStringBuilder w(boolean z, boolean z2) {
        return d(z, z2, false);
    }

    public SpannableStringBuilder x(boolean z, boolean z2) {
        SpannableStringBuilder aRr;
        if (!StringUtils.isNull(this.title) && this.dFr != 1) {
            aRr = aRq();
        } else {
            aRr = aRr();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aRr);
        this.dFw = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public SpannableStringBuilder aRv() {
        if (StringUtils.isNull(this.title) || this.dFr == 1) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aRq());
        this.dFw = spannableStringBuilder;
        return spannableStringBuilder;
    }

    public ActivityItemData aPj() {
        if (this.dFt != null && this.dFt.size() > 0) {
            int size = this.dFt.size();
            for (int i = 0; i < size; i++) {
                PbContent pbContent = this.dFt.get(i);
                if (pbContent != null && !TextUtils.isEmpty(pbContent.text) && 18 == pbContent.type.intValue() && aPk() && pbContent.text != null && pbContent.text.length() >= 3) {
                    ActivityItemData activityItemData = new ActivityItemData();
                    activityItemData.link_url = com.baidu.tbadk.plugins.b.yL(pbContent.text);
                    activityItemData.activity_name = pbContent.text.substring(1, pbContent.text.length() - 2);
                    return activityItemData;
                }
            }
        }
        return null;
    }

    public void aRw() {
        u(false, false);
    }

    public void aRx() {
        u(false, true);
    }

    public AnchorInfoData aRy() {
        return this.dFV;
    }

    public boolean aRz() {
        return this.threadType == 36;
    }

    public boolean aPk() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public boolean aRA() {
        return this.threadType == 11 || this.dFS == 1;
    }

    public boolean aRB() {
        return this.threadType == 63 || this.threadType == 64;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> aQH = aQH();
        if (aQH == null || isTop()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aQH.size() || i2 >= 3) {
                break;
            }
            if (aQH.get(i2) != null && aQH.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(aQH.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = aQH.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = aQH.get(i2).getPicUrl();
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
        if (this.dGb != null && !StringUtils.isNull(this.dGb.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.dGb.thumbnail_url;
            preLoadImageInfo2.procType = 10;
            preLoadImageInfo2.preloadType = 1;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.dFJ != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.dFJ.getPortrait();
            preLoadImageInfo3.procType = 28;
            preLoadImageInfo3.preloadType = 3;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean aRC() {
        String userId;
        return this.dFJ == null || (userId = this.dFJ.getUserId()) == null || userId.equals("0");
    }

    public boolean aRD() {
        return this.threadType == 41;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (aSn()) {
            if (aQQ() != null) {
                return dEV;
            }
            return dEE;
        }
        int aQs = aQs();
        if (this.dHp == 1) {
            if (this.dHq != null) {
                return dEQ;
            }
            return this.dHt != null ? dFf : dFe;
        } else if (this.dGe != null && this.threadType == 60) {
            return dEY;
        } else {
            if (this.dGe != null && this.threadType == 49) {
                return dEW;
            }
            if (this.threadType == 51) {
                return dEX;
            }
            if (this.threadType == 63) {
                return dFg;
            }
            if (this.threadType == 64) {
                return dFh;
            }
            if (aQs == 2 || aQs == 1) {
                return dED;
            }
            if (this.dGb != null && aRL() && !aRD()) {
                return dFm;
            }
            if (this.dGb != null && !aRD()) {
                if (aQA()) {
                    return dFd;
                }
                return dEV;
            } else if (this.isShareThread && this.dHm != null) {
                if (this.dHm.dDi) {
                    if (this.dHm.videoInfo != null) {
                        return dFc;
                    }
                    if (this.dHm.aPm()) {
                        return dFb;
                    }
                    return dFa;
                }
                return dEZ;
            } else if (aPm()) {
                return dER;
            } else {
                if (aRF()) {
                    return dFj.get() ? dGz : dEE;
                } else if (aRm() && aRl() == 1) {
                    return dFj.get() ? dGH : dEE;
                } else if (isLinkThread()) {
                    return dET;
                } else {
                    if (aQA()) {
                        return dEU;
                    }
                    if (this.dEo) {
                        return dEI;
                    }
                    if (this.dEp) {
                        return dEJ;
                    }
                    if (this.dEq) {
                        return dEK;
                    }
                    if (this.dEr) {
                        return dEL;
                    }
                    if (this.dEs) {
                        return dEM;
                    }
                    if (this.dEu) {
                        return dEO;
                    }
                    if (this.dEv) {
                        return dEP;
                    }
                    if (this.dEt) {
                        return dEN;
                    }
                    if (this.dGi) {
                        int aRE = aRE();
                        if (aRE == 1) {
                            return dEF;
                        }
                        if (aRE == 2) {
                            return dEG;
                        }
                        if (aRE > 2) {
                            return dEH;
                        }
                        return dEE;
                    }
                    return dEE;
                }
            }
        }
    }

    public int aRE() {
        int i = 0;
        if (!com.baidu.tbadk.core.k.aNQ().isShowImages() || com.baidu.tbadk.core.util.v.getCount(aQH()) == 0) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 < aQH().size()) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH(), i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            } else {
                return linkedList.size();
            }
        }
    }

    public boolean aRF() {
        return aQd() != null && getThreadType() == 41 && aQu() == 1 && aRj() == 2;
    }

    public void y(ArrayList<p> arrayList) {
        if (this.dFr == 1) {
            this.dBH = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.dBH = 0;
        } else {
            this.dBH = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.aOE() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.aOE().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.dBH = next.aOF();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean aRG() {
        return this.threadType == 41;
    }

    public boolean aRH() {
        return this.dGI;
    }

    public void gP(boolean z) {
        this.dGI = z;
    }

    public String aRI() {
        return this.dGJ;
    }

    public o aRJ() {
        return this.dGn;
    }

    public void aRK() {
        if (this.dGg == 0) {
            this.dGg = 1;
        }
    }

    public void gQ(boolean z) {
        this.dGV = z;
    }

    public boolean aRL() {
        return this.dGV;
    }

    public void ky(int i) {
        this.dGW = i + 1;
    }

    public int aRM() {
        return this.dGW;
    }

    public boolean aRN() {
        return this.dHK;
    }

    public void gR(boolean z) {
        this.dHK = z;
    }

    public br aRO() {
        return this.dGd;
    }

    public boolean aRP() {
        return getThreadType() == 49;
    }

    public boolean aRQ() {
        return getThreadType() == 40;
    }

    public boolean aRR() {
        return getThreadType() == 50;
    }

    public boolean aRS() {
        return getThreadType() == 60;
    }

    public int aRT() {
        return this.dHc;
    }

    public void setSmartFrsPosition(int i) {
        this.dHc = i;
    }

    public SparseArray<String> getFeedBackReasonMap() {
        return this.feedBackReasonMap;
    }

    public String aRU() {
        return this.mRecomSource;
    }

    public boolean aRV() {
        return this.dHd;
    }

    public long aRW() {
        return this.agreeData.agreeNum;
    }

    public long aRX() {
        return this.agreeData.disAgreeNum;
    }

    public int aRY() {
        return this.agreeData.hasAgree ? 1 : 0;
    }

    public int aRZ() {
        return this.agreeData.agreeType;
    }

    public void kz(int i) {
        this.agreeData.hasAgree = i == 1;
    }

    public void kA(int i) {
        this.agreeData.agreeNum = i;
    }

    public void cb(long j) {
        this.agreeData.agreeNum = j;
    }

    public void cc(long j) {
        this.agreeData.diffAgreeNum = j;
    }

    public void kB(int i) {
        this.agreeData.agreeType = i;
    }

    public long aSa() {
        return this.dHf;
    }

    public void cd(long j) {
        this.dHf = j;
    }

    public PostData aSb() {
        return this.dHe;
    }

    public af aSc() {
        return this.dHg;
    }

    private ArrayList<m.a> b(boolean z, boolean z2, boolean z3, boolean z4) {
        ArrayList<m.a> arrayList = new ArrayList<>();
        boolean aQy = aQy();
        if (z2) {
            if (z) {
                if (aQy && !aPk()) {
                    arrayList.add(new m.a((int) R.string.god_title));
                }
                if (aQu() == 1 || getThreadType() == 33 || (aQw() != null && aQw().aSK() != 0)) {
                    if (aQd() != null && aRG()) {
                        if (aRj() == 2) {
                            arrayList.add(new m.a((int) R.string.interview_live));
                        }
                    } else if (!aQy) {
                        arrayList.add(new m.a((int) R.string.photo_live_tips));
                    }
                }
                if (aRG()) {
                    arrayList.add(dGZ.get(aRj()));
                }
                if (aRm()) {
                    Integer num = dGY.get(new Point(aRl(), aRk()));
                    if (num != null) {
                        arrayList.add(new m.a(num.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a((int) R.string.card_promotion_text));
                    }
                }
                if (aQJ() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
            } else {
                if (aQy && aQs() != 1 && !aPk()) {
                    arrayList.add(new m.a((int) R.string.god_title));
                }
                if ((aQu() == 1 || getThreadType() == 33) && !aRG() && !aQy) {
                    arrayList.add(new m.a((int) R.string.photo_live_tips));
                }
                if (aQt() == 1) {
                    arrayList.add(new m.a((int) R.string.good));
                }
                if (aQs() == 1) {
                    arrayList.add(new m.a((int) R.string.f1281top));
                }
                if (aRG() && aQd() != null && aRj() == 2) {
                    arrayList.add(new m.a((int) R.string.interview_live));
                }
                if (aRm()) {
                    Integer num2 = dGY.get(new Point(aRl(), aRk()));
                    if (num2 != null) {
                        arrayList.add(new m.a(num2.intValue(), R.color.cp_other_b, R.drawable.pic_dot_title_red));
                    } else {
                        arrayList.add(new m.a((int) R.string.card_promotion_text));
                    }
                }
                if (this.dGK == 1) {
                    arrayList.add(new m.a((int) R.string.card_tbread_text));
                }
                if (aQK() != null) {
                    arrayList.add(new m.a(R.string.send_app_code_gift, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (aQJ() != null) {
                    arrayList.add(new m.a(R.string.card_promotion_text, R.color.cp_other_b, R.drawable.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aq.isEmpty(getCategory())) {
                    arrayList.add(new m.a(getCategory()));
                }
                if (z3 && aRP()) {
                    arrayList.add(new m.a((int) R.string.ala_live));
                }
                if (z3 && aRR()) {
                    arrayList.add(new m.a((int) R.string.live_record));
                } else if (aRQ()) {
                    arrayList.add(new m.a((int) R.string.video_title_str));
                }
                if (z4) {
                    arrayList.add(new m.a((int) R.string.video_review_state));
                }
            }
        }
        return arrayList;
    }

    public void z(ArrayList<MediaData> arrayList) {
        this.dFM = arrayList;
    }

    public void A(ArrayList<VoiceData.VoiceModel> arrayList) {
        this.dFN = arrayList;
    }

    public String aSd() {
        return this.dHr;
    }

    public void vG(String str) {
        this.dHr = str;
    }

    public void aSe() {
        this.dHp = 1;
    }

    public boolean aSf() {
        return this.dHp == 1;
    }

    public boolean aSg() {
        return "worldcupvideo".equals(this.dHu);
    }

    public String aSh() {
        return this.dFz;
    }

    public void vH(String str) {
        this.dFz = str;
    }

    public String aSi() {
        return this.dFA;
    }

    public void vI(String str) {
        this.dFA = str;
    }

    public String aSj() {
        return this.dHs;
    }

    public void vJ(String str) {
        this.dHs = str;
    }

    public boolean aSk() {
        return this.dHv;
    }

    public void gS(boolean z) {
        this.dHv = z;
    }

    public void b(VideoInfo videoInfo) {
        this.dHt = videoInfo;
    }

    public boolean aSl() {
        return this.dHw != null;
    }

    public bg aSm() {
        return this.dFy;
    }

    public void a(bg bgVar) {
        this.dFy = bgVar;
    }

    public boolean aSn() {
        return this.dHz;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dGb != null) {
            return this.dGb.video_url;
        }
        return null;
    }

    public boolean aSo() {
        return this.dHB;
    }

    public void gT(boolean z) {
        this.dHB = z;
    }

    public AgreeData aSp() {
        return this.agreeData;
    }

    public boolean aSq() {
        return this.dHN;
    }

    public void gU(boolean z) {
        this.dHN = z;
    }

    public boolean aSr() {
        return this.dHL;
    }

    public void gV(boolean z) {
        this.dHL = z;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public TopicModule aSs() {
        return this.dHq;
    }

    public String getShareImageUrl() {
        return this.dHH;
    }

    public int[] getImageWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aQH = aQH();
        if (com.baidu.tbadk.core.k.aNQ().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aQH) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aQH.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH, 0);
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

    public int[] aSt() {
        int i;
        int[] iArr = new int[2];
        int size = View.MeasureSpec.getSize(com.baidu.adp.lib.util.l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i2 = (int) ((size - (dimensionPixelSize * 2)) / 3.0f);
        ArrayList<MediaData> aQH = aQH();
        if (com.baidu.tbadk.core.k.aNQ().isShowImages() && com.baidu.tbadk.core.util.v.getCount(aQH) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < aQH.size(); i3++) {
                MediaData mediaData = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH, i3);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
        }
        MediaData mediaData2 = (MediaData) com.baidu.tbadk.core.util.v.getItem(aQH, 0);
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

    public boolean aSu() {
        return aSv() || aSw();
    }

    public boolean aPm() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 1;
    }

    public boolean aPn() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 2;
    }

    public boolean aSv() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 3;
    }

    public boolean aSw() {
        return this.mBaijiahao != null && this.mBaijiahao.oriUgcType == 4;
    }

    public boolean aSx() {
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
        return aSx();
    }

    public void kC(int i) {
        this.dHR = i;
    }

    public int aSy() {
        return this.dHT;
    }

    public String aSz() {
        return this.dHS;
    }

    public void vK(String str) {
        this.dHS = str;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        this.mBaijiahao = baijiahaoData;
    }

    public int aSA() {
        if (aQz()) {
            return 4;
        }
        if (aRP() || aRR()) {
            return 3;
        }
        if (aPm()) {
            return 5;
        }
        if (aPn()) {
            return 6;
        }
        if (aSv()) {
            return 7;
        }
        if (aSw()) {
            return 8;
        }
        if (this.isShareThread && this.dHm != null) {
            return 9;
        }
        if (aRQ()) {
            return 2;
        }
        return 1;
    }

    public int aSB() {
        if (aSw() || aSv()) {
            return 2;
        }
        if (aPm() || aPn()) {
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

    public String aSC() {
        return this.dHW;
    }

    public String getNid() {
        return this.mNid;
    }

    public boolean aSD() {
        return this.dFJ != null && this.dFJ.isNewGod();
    }
}

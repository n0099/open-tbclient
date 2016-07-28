package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PollInfo;
import tbclient.SkinInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class be extends com.baidu.tieba.card.a.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.al {
    public TwZhiBoUser OO;
    public List<TwAnchorProfitItem> OP;
    private SpannableString QV;
    public int QZ;
    private bf RH;
    private SkinInfo RK;
    private boolean RM;
    public DealInfoData RO;
    private String RP;
    public String RT;
    public String RU;
    public String RV;
    public long RW;
    public boolean RX;
    public String RY;
    private int Rb;
    private String Re;
    private int Rf;
    private String Rg;
    private int Ri;
    private VideoInfo Rk;
    private long Rl;
    private m Rr;
    private LiveCoverStatus Rx;
    private int Ry;
    private String address;
    private String authorId;
    public boolean isDeal;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId QA = BdUniqueId.gen();
    public static final BdUniqueId TYPE_NORMAL = BdUniqueId.gen();
    public static final BdUniqueId QB = BdUniqueId.gen();
    public static final BdUniqueId QC = BdUniqueId.gen();
    public static final BdUniqueId QD = BdUniqueId.gen();
    public static final BdUniqueId QE = BdUniqueId.gen();
    public static AtomicBoolean QF = new AtomicBoolean(false);
    public static final BdUniqueId QG = BdUniqueId.gen();
    public static final BdUniqueId QH = BdUniqueId.gen();
    public static final BdUniqueId QI = BdUniqueId.gen();
    private static HashMap<Point, Integer> Rs = new HashMap<>();
    private static HashMap<Integer, Integer> Rt = new HashMap<>();
    public static final BdUniqueId RE = BdUniqueId.gen();
    public static final BdUniqueId RF = BdUniqueId.gen();
    public static final BdUniqueId RL = BdUniqueId.gen();
    public int QJ = 1;
    private String Ra = null;
    private int NK = 0;
    private String Rm = "";
    private String Ru = "";
    private String id = null;
    private String QK = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int QL = 0;
    private int QM = 0;
    private String last_time = null;
    private long QN = 0;
    private int QO = 0;
    private int QP = 0;
    private int QR = 0;
    private bi QS = new bi();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> QX = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> QY = new ArrayList<>();
    private int QT = 0;
    private int QU = 0;
    private String ad_url = null;
    private String QW = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData Rc = new PraiseData();
    private AnchorInfoData Rd = new AnchorInfoData();
    private long time = 0;
    private int Rh = 0;
    private ArrayList<a> Ro = new ArrayList<>();
    private bm Rp = null;
    private c Rq = null;
    private int Rv = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Rj = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Rw = null;
    private int Rn = 0;
    private PollInfo Rz = null;
    private boolean RA = false;
    private boolean RB = false;
    private int RC = 0;
    private boolean RD = false;
    private int anchorLevel = 0;
    public int RQ = 0;
    public j RR = new j();
    private String category_name = null;
    private bc RG = new bc();
    private ArrayList<com.baidu.tbadk.data.b> RI = new ArrayList<>();
    private PushStatusData RJ = new PushStatusData();

    static {
        Rs.put(new Point(1, 1), Integer.valueOf(u.f.label_frs_lottery_ing));
        Rs.put(new Point(1, 2), Integer.valueOf(u.f.label_frs_lottery_over));
        Rs.put(new Point(1, 3), Integer.valueOf(u.f.label_frs_lottery_off));
        Rs.put(new Point(1, 4), Integer.valueOf(u.f.label_frs_lottery_d));
        Rs.put(new Point(2, 1), Integer.valueOf(u.f.label_frs_activity_shaiing));
        Rs.put(new Point(2, 2), Integer.valueOf(u.f.label_frs_activity_shai_over));
        Rs.put(new Point(2, 3), Integer.valueOf(u.f.label_frs_activity_shai_off));
        Rs.put(new Point(2, 4), Integer.valueOf(u.f.label_frs_activity_shai_d));
        Rt.put(1, Integer.valueOf(u.f.label_interview_no));
        Rt.put(2, Integer.valueOf(u.f.label_interview_live));
        Rt.put(3, Integer.valueOf(u.f.label_interview_off));
    }

    public be() {
        this.Ri = 0;
        this.Ry = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Ry = 0;
        this.Ri = 0;
    }

    public bc qh() {
        return this.RG;
    }

    public bf qi() {
        return this.RH;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int qj() {
        return this.Ri;
    }

    public boolean qk() {
        return this.RD;
    }

    public boolean ql() {
        return this.RA;
    }

    public boolean qm() {
        return this.RB;
    }

    public void bG(int i) {
        this.RC = i;
    }

    public int qn() {
        return this.RC;
    }

    public PollInfo qo() {
        return this.Rz;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Rl;
    }

    public PraiseData qp() {
        return this.Rc;
    }

    public void a(PraiseData praiseData) {
        this.Rc = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cr(String str) {
        this.QK = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.QK) || "0".equals(this.QK)) ? this.id : this.QK;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String qq() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void bH(int i) {
        this.reply_num = i;
    }

    public int qr() {
        return this.reply_num;
    }

    public long qs() {
        return this.QN;
    }

    public void p(long j) {
        this.QN = j;
    }

    public int qt() {
        return this.QO;
    }

    public void bI(int i) {
        this.QO = i;
    }

    public int qu() {
        return this.QP;
    }

    public void bJ(int i) {
        this.QP = i;
    }

    public int qv() {
        return this.QR;
    }

    public bi qw() {
        return this.QS;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData qx() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean qy() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean qz() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean qA() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return true;
        }
        return (this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String getForum_name() {
        return this.forum_name;
    }

    public void setForum_name(String str) {
        this.forum_name = str;
    }

    public int qB() {
        return this.QU;
    }

    public String qC() {
        return this.ad_url;
    }

    public String qD() {
        return this.QW;
    }

    public void cs(String str) {
        this.QW = str;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String qE() {
        return this.Ra;
    }

    public void ct(String str) {
        this.Ra = str;
    }

    public ArrayList<MediaData> qF() {
        return this.QX;
    }

    public ArrayList<a> qG() {
        return this.Ro;
    }

    public void i(ArrayList<a> arrayList) {
        this.Ro = arrayList;
    }

    public bm qH() {
        return this.Rp;
    }

    public c qI() {
        return this.Rq;
    }

    public ArrayList<VoiceData.VoiceModel> qJ() {
        return this.QY;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int qK() {
        return this.Rf;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String qL() {
        return this.Rm;
    }

    public VideoInfo qM() {
        return this.Rk;
    }

    public String getPhotoLiveCover() {
        return this.Ru;
    }

    public void setPhotoLiveCover(String str) {
        this.Ru = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> qN() {
        return this.Rj;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Rj.clear();
        this.Rj.addAll(arrayList);
    }

    public String getNotice() {
        return this.Rw;
    }

    public PushStatusData qO() {
        return this.RJ;
    }

    public SkinInfo qP() {
        return this.RK;
    }

    public long qQ() {
        return this.RW;
    }

    public boolean qR() {
        return this.RX;
    }

    public String qS() {
        return this.RY;
    }

    public boolean qT() {
        return "9090".equals(this.RT);
    }

    public boolean qU() {
        return "9020".equals(this.RT);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0022: IGET  (r3v2 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0033: IGET  (r3v3 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00e9: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00fa: IGET  (r3v11 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Rg = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.QK = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Rl = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.QL = threadInfo.repost_num.intValue();
                this.QM = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.QN = threadInfo.last_time_int.intValue();
                this.QO = threadInfo.is_top.intValue();
                this.QP = threadInfo.is_good.intValue();
                this.QR = threadInfo.is_livepost.intValue();
                this.QS.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.QT = threadInfo.has_commented.intValue();
                this.QU = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Rk = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Ra = threadInfo.collect_mark_pid;
                this.Rb = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Re = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Rm = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Rf = threadInfo.is_ntitle.intValue();
                this.Rh = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Ri = threadInfo.operator_flag.intValue();
                this.QZ = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (EcommSwitchStatic.Fr()) {
                    this.isDeal = threadInfo.is_deal.intValue() == 1;
                    if (threadInfo.deal_info != null) {
                        this.RO = new DealInfoData();
                        this.RO.parserProtobuf(threadInfo.deal_info);
                    }
                }
                StringBuilder sb = new StringBuilder();
                List<Abstract> list = threadInfo._abstract;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null) {
                            if (list.get(i).type.intValue() == 0) {
                                sb.append(list.get(i).text);
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.QW = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.QX.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Rk = threadInfo.video_info;
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
                        this.QY.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Ro.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Rp = new bm();
                    this.Rp.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Rq = new c();
                    this.Rq.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Rr = new m();
                    this.Rr.a(threadInfo.cartoon_info);
                }
                this.Rc.setUserMap(this.userMap);
                this.Rc.parserProtobuf(threadInfo.zan);
                this.Rd.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Rc.setTitle(this.title);
                } else {
                    this.Rc.setTitle(this.QW);
                }
                this.Ru = threadInfo.livecover_src;
                this.Rv = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Rn = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.dR(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Rj.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Rw = noticeInfo.notice;
                    }
                    this.RC = zhiBoInfoTW.copythread_remind.intValue();
                    this.RA = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.RB = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Ru)) {
                        this.Ru = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.OO = zhiBoInfoTW.user.tw_anchor_info;
                        this.OP = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Rx = threadInfo.twzhibo_info.livecover_status;
                    this.Ry = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Rz = threadInfo.poll_info;
                this.RD = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.RG.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.RH = new bf();
                    this.RH.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.RI.add(bVar);
                    }
                }
                this.RJ.parserProtobuf(threadInfo.push_status);
                this.RP = threadInfo.lego_card;
                this.RK = threadInfo.skin_info;
                this.RQ = threadInfo.is_book_chapter.intValue();
                this.RR.a(threadInfo.book_chapter);
                this.RT = threadInfo.recom_source;
                this.RU = threadInfo.recom_weight;
                this.RV = threadInfo.ab_tag;
                this.RW = threadInfo.last_read_pid.longValue();
                this.RX = threadInfo.cheak_repeat.intValue() == 1;
                this.RY = threadInfo.recom_reason;
            } catch (Exception e) {
                Log.e("threadData", "ex: " + e.getMessage());
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.QK = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.Rl = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.QL = jSONObject.optInt("repost_num", 0);
                this.QM = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.QN = jSONObject.optLong("last_time_int", 0L);
                this.QO = jSONObject.optInt("is_top", 0);
                this.QP = jSONObject.optInt("is_good", 0);
                this.QR = jSONObject.optInt("is_livepost", 0);
                this.QS.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.QT = jSONObject.optInt("has_commented", 0);
                this.QU = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Ra = jSONObject.optString("collect_mark_pid");
                this.Rb = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.Re = jSONObject.optString("first_post_id", "0");
                this.Rm = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Rf = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                sb.append(optJSONArray.getJSONObject(i).optString("text"));
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.QW = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.QX.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject2.optString("voice_md5");
                        voiceModel.duration = jSONObject2.optInt("during_time") / 1000;
                        this.QY.add(voiceModel);
                    }
                }
                if (EcommSwitchStatic.Fr() && jSONObject != null) {
                    this.RO = new DealInfoData();
                    this.RO.parserJson(jSONObject);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Ro.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Rp = new bm();
                    this.Rp.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Rq = new c();
                    this.Rq.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Rr = new m();
                    this.Rr.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.Rc.setUserMap(this.userMap);
                this.Rc.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Rd.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Rc.setTitle(this.title);
                } else {
                    this.Rc.setTitle(this.QW);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.RG.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.RI.add(bVar);
                    }
                }
                this.RQ = jSONObject.optInt("is_book_chapter", 0);
                this.RR.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.RT = jSONObject.optString("recom_source");
                this.RW = jSONObject.optLong("last_read_pid");
                this.RX = jSONObject.optInt("cheak_repeat") == 1;
                this.RY = jSONObject.optString("recom_reason");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString qV() {
        return this.QV;
    }

    public boolean qW() {
        return qt() != 0;
    }

    public int qX() {
        if (this.RG != null) {
            long qb = this.RG.qb();
            long qc = this.RG.qc();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qb) {
                return 1;
            }
            if (currentTimeMillis > qc) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int qY() {
        if (ra() && this.Ro.size() >= 1) {
            a aVar = this.Ro.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int oc = aVar.oc();
            int od = aVar.od();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < oc) {
                return 4;
            }
            return currentTimeMillis > od ? 2 : 1;
        }
        return -1;
    }

    public int qZ() {
        if (!ra() || this.Ro.size() < 1 || this.Ro.get(0) == null) {
            return -1;
        }
        return this.Ro.get(0).ob();
    }

    public boolean ra() {
        return this.Rh == 1;
    }

    public String rb() {
        return (!ra() || this.Ro.size() < 1 || this.Ro.get(0) == null) ? "" : this.Ro.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cu(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m10getInst().getApplicationContext()).inflate(u.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(u.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m10getInst().getApplicationContext().getResources().getColor(u.d.cp_cont_f_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                dVar = new com.baidu.adp.widget.d(bitmapDrawable, 1);
            } else {
                dVar = null;
            }
            return dVar;
        }
        return null;
    }

    private void an(boolean z) {
        com.baidu.adp.widget.d dVar;
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getThreadType() == 42 && rc()) {
                arrayList.add(Integer.valueOf(u.f.icon_convene));
            }
            if (qt() == 1) {
                arrayList.add(Integer.valueOf(u.f.icon_top));
            } else if (qt() == 2) {
                arrayList.add(Integer.valueOf(u.f.icon_notice));
            }
            if (qv() == 1 || this.QS.rF() != 0) {
                if (qh() != null && getThreadType() == 41) {
                    if (qX() == 2) {
                        arrayList.add(Integer.valueOf(u.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(u.f.icon_zhibo));
                }
            }
            if (z && rn()) {
                Integer num = Rt.get(Integer.valueOf(qX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (qu() == 1 && !qW()) {
                arrayList.add(Integer.valueOf(u.f.icon_elite));
            }
            if (getType() == QG || getType() == QH) {
                arrayList.add(Integer.valueOf(u.f.icon_vote_blue));
            }
            if (this.Rb == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(u.f.icon_voice));
            }
            if (this.Rd != null && this.Rd.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(u.f.icon_live_on));
            }
            if (qB() == 1) {
                arrayList.add(Integer.valueOf(u.f.frs_post_ding));
            }
            if (!z && qZ() == 2) {
                arrayList.add(Integer.valueOf(u.f.label_frs_activity_shai));
            } else {
                Integer num2 = Rs.get(new Point(qZ(), qY()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (qH() != null) {
                arrayList.add(Integer.valueOf(u.f.tag_act));
            }
            if (qI() != null) {
                arrayList.add(Integer.valueOf(u.f.icon_tag_giftsend));
            }
            if (com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = null;
            } else {
                dVar = cu(this.category_name);
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                String sb2 = sb.toString();
                if (dVar != null) {
                    spannableString = new SpannableString(String.valueOf(sb2) + this.category_name + " " + this.title);
                } else {
                    spannableString = new SpannableString(String.valueOf(sb2) + this.title);
                }
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap cA = com.baidu.tbadk.core.util.av.cA(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
                    if (cA != null) {
                        bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
                    }
                    com.baidu.tbadk.core.view.ah ahVar = new com.baidu.tbadk.core.view.ah(bitmapDrawable);
                    ahVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m10getInst().getApplicationContext(), this.QJ));
                    spannableString.setSpan(ahVar, i2, i2 + 1, 33);
                    i2 += 2;
                }
                if (dVar != null) {
                    spannableString.setSpan(dVar, i2, this.category_name.length() + i2, 33);
                }
            } else if (dVar != null) {
                spannableString = new SpannableString(String.valueOf(this.category_name) + " " + this.title);
                spannableString.setSpan(dVar, 0, this.category_name.length() + 0, 33);
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.QV = spannableString;
        }
    }

    private boolean rc() {
        return com.baidu.adp.lib.c.e.cS().ab("isConveneThreadOpen") == 1;
    }

    public void rd() {
        an(false);
    }

    public void re() {
        an(true);
    }

    public AnchorInfoData rf() {
        return this.Rd;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean rg() {
        return this.threadType == 36;
    }

    public boolean rh() {
        return this.threadType == 40;
    }

    public boolean ri() {
        return this.threadType == 11 || this.Rb == 1;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int rj() {
        return this.Rn;
    }

    public void bK(int i) {
        this.Rn = i;
    }

    public int rk() {
        return this.Ry;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<com.baidu.tbadk.core.util.ak> getImages() {
        ArrayList<MediaData> qF = qF();
        if (qF == null || qW()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ak> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= qF.size() || i2 >= 3) {
                break;
            }
            if (qF.get(i2) != null && qF.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                if (!StringUtils.isNull(qF.get(i2).getThumbnails_url())) {
                    akVar.imgUrl = qF.get(i2).getThumbnails_url();
                } else {
                    akVar.imgUrl = qF.get(i2).getPicUrl();
                }
                akVar.Yd = 13;
                arrayList.add(akVar);
            }
            i = i2 + 1;
        }
        if (this.Rk != null && !StringUtils.isNull(this.Rk.thumbnail_url)) {
            com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
            akVar2.imgUrl = this.Rk.thumbnail_url;
            akVar2.Yd = 13;
            arrayList.add(akVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ak akVar3 = new com.baidu.tbadk.core.util.ak();
            akVar3.imgUrl = this.author.getPortrait();
            akVar3.Yd = 28;
            arrayList.add(akVar3);
        }
        return arrayList;
    }

    public boolean rl() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int qt = qt();
        if (qt == 2 || qt == 1) {
            return QA;
        }
        if (this.isDeal && this.RO != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            return QE;
        }
        if (this.Rk != null) {
            if (qy()) {
                return QD;
            }
            return QC;
        } else if (qo() != null && getThreadType() == 36 && qo().type.intValue() == 2) {
            return QG;
        } else {
            if (qo() != null && getThreadType() == 36 && qo().type.intValue() == 1) {
                return QH;
            }
            if (qh() != null && getThreadType() == 41 && qv() == 1 && qX() == 2) {
                return QF.get() ? RF : TYPE_NORMAL;
            } else if (ra() && qZ() == 1) {
                return QF.get() ? RL : TYPE_NORMAL;
            } else if (qi() != null && !TextUtils.isEmpty(qi().getActivityName())) {
                return QI;
            } else {
                if (ra() && qZ() == 2) {
                    return QF.get() ? RE : TYPE_NORMAL;
                } else if (qy()) {
                    return QB;
                } else {
                    return TYPE_NORMAL;
                }
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus rm() {
        return this.Rx;
    }

    public List<TwAnchorProfitItem> oZ() {
        return this.OP;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.Rf == 1) {
            this.NK = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.NK = 0;
        } else {
            this.NK = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.ox() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.ox().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.NK = next.oy();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean rn() {
        return this.threadType == 41;
    }

    public boolean ro() {
        return this.threadType == 48;
    }

    public boolean rp() {
        return this.RM;
    }

    public void ao(boolean z) {
        this.RM = z;
    }

    public String rq() {
        return this.RP;
    }

    public m rr() {
        return this.Rr;
    }

    public DealInfoData rs() {
        return this.RO;
    }
}

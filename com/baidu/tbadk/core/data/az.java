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
import com.baidu.tbadk.coreExtra.view.n;
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
public class az extends com.baidu.tieba.card.a.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.al {
    public TwZhiBoUser OA;
    public List<TwAnchorProfitItem> OB;
    private int QB;
    private int QC;
    private String QD;
    private int QF;
    private VideoInfo QH;
    private long QI;
    private l QO;
    private LiveCoverStatus QV;
    private int QW;
    private SpannableString Qw;
    public int Qz;
    private ba Rf;
    private SkinInfo Ri;
    private boolean Rk;
    public DealInfoData Rl;
    private String Rm;
    private String address;
    private String authorId;
    private String first_post_id;
    public boolean isDeal;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Qf = BdUniqueId.gen();
    public static final BdUniqueId TYPE_NORMAL = BdUniqueId.gen();
    public static final BdUniqueId Qg = BdUniqueId.gen();
    public static final BdUniqueId Qh = BdUniqueId.gen();
    public static final BdUniqueId Qi = BdUniqueId.gen();
    public static final BdUniqueId Qj = BdUniqueId.gen();
    public static AtomicBoolean Qk = new AtomicBoolean(false);
    public static final BdUniqueId Ql = BdUniqueId.gen();
    public static final BdUniqueId Qm = BdUniqueId.gen();
    public static final BdUniqueId Qn = BdUniqueId.gen();
    private static HashMap<Point, Integer> QP = new HashMap<>();
    private static HashMap<Integer, Integer> QR = new HashMap<>();
    public static final BdUniqueId Rc = BdUniqueId.gen();
    public static final BdUniqueId Rd = BdUniqueId.gen();
    public static final BdUniqueId Rj = BdUniqueId.gen();
    public int Qo = 1;
    private String QA = null;
    private int ND = 0;
    private String QJ = "";
    private String QS = "";
    private String id = null;
    private String tid = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Qp = 0;
    private int Qq = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Qr = 0;
    private bd Qs = new bd();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Qx = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Qy = new ArrayList<>();
    private int Qt = 0;
    private int Qu = 0;
    private String Qv = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int QE = 0;
    private ArrayList<a> QL = new ArrayList<>();
    private bh QM = null;
    private c QN = null;
    private int QT = 0;
    private ArrayList<n> QG = new ArrayList<>();
    private boolean isHeadLive = false;
    private String QU = null;
    private int QK = 0;
    private PollInfo QX = null;
    private boolean QY = false;
    private boolean QZ = false;
    private int Ra = 0;
    private boolean Rb = false;
    private int anchorLevel = 0;
    public int Rn = 0;
    public i Ro = new i();
    private String category_name = null;
    private ax Re = new ax();
    private ArrayList<com.baidu.tbadk.data.b> Rg = new ArrayList<>();
    private PushStatusData Rh = new PushStatusData();

    static {
        QP.put(new Point(1, 1), Integer.valueOf(u.f.label_frs_lottery_ing));
        QP.put(new Point(1, 2), Integer.valueOf(u.f.label_frs_lottery_over));
        QP.put(new Point(1, 3), Integer.valueOf(u.f.label_frs_lottery_off));
        QP.put(new Point(1, 4), Integer.valueOf(u.f.label_frs_lottery_d));
        QP.put(new Point(2, 1), Integer.valueOf(u.f.label_frs_activity_shaiing));
        QP.put(new Point(2, 2), Integer.valueOf(u.f.label_frs_activity_shai_over));
        QP.put(new Point(2, 3), Integer.valueOf(u.f.label_frs_activity_shai_off));
        QP.put(new Point(2, 4), Integer.valueOf(u.f.label_frs_activity_shai_d));
        QR.put(1, Integer.valueOf(u.f.label_interview_no));
        QR.put(2, Integer.valueOf(u.f.label_interview_live));
        QR.put(3, Integer.valueOf(u.f.label_interview_off));
    }

    public az() {
        this.QF = 0;
        this.QW = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.QW = 0;
        this.QF = 0;
    }

    public ax qy() {
        return this.Re;
    }

    public ba qz() {
        return this.Rf;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int qA() {
        return this.QF;
    }

    public boolean qB() {
        return this.Rb;
    }

    public boolean qC() {
        return this.QY;
    }

    public boolean qD() {
        return this.QZ;
    }

    public void bH(int i) {
        this.Ra = i;
    }

    public int qE() {
        return this.Ra;
    }

    public PollInfo qF() {
        return this.QX;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.QI;
    }

    public PraiseData getPraise() {
        return this.praise;
    }

    public void setPraise(PraiseData praiseData) {
        this.praise = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cr(String str) {
        this.tid = str;
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

    public String qG() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setReply_num(int i) {
        this.reply_num = i;
    }

    public int getReply_num() {
        return this.reply_num;
    }

    public long getLast_time_int() {
        return this.last_time_int;
    }

    public void u(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bI(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bJ(int i) {
        this.is_good = i;
    }

    public int qH() {
        return this.Qr;
    }

    public bd qI() {
        return this.Qs;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public boolean qJ() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean qK() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean qL() {
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

    public int qM() {
        return this.Qu;
    }

    public String qN() {
        return this.Qv;
    }

    public String qO() {
        return this.abstract_text;
    }

    public void cs(String str) {
        this.abstract_text = str;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String qP() {
        return this.QA;
    }

    public void ct(String str) {
        this.QA = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Qx;
    }

    public ArrayList<a> qQ() {
        return this.QL;
    }

    public void h(ArrayList<a> arrayList) {
        this.QL = arrayList;
    }

    public bh qR() {
        return this.QM;
    }

    public c qS() {
        return this.QN;
    }

    public ArrayList<VoiceData.VoiceModel> qT() {
        return this.Qy;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int qU() {
        return this.QC;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String qV() {
        return this.QJ;
    }

    public VideoInfo qW() {
        return this.QH;
    }

    public String getPhotoLiveCover() {
        return this.QS;
    }

    public void setPhotoLiveCover(String str) {
        this.QS = str;
    }

    public ArrayList<n> qX() {
        return this.QG;
    }

    public void setExpressionDatas(ArrayList<n> arrayList) {
        this.QG.clear();
        this.QG.addAll(arrayList);
    }

    public String getNotice() {
        return this.QU;
    }

    public PushStatusData qY() {
        return this.Rh;
    }

    public SkinInfo qZ() {
        return this.Ri;
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
                    this.QD = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.QI = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Qp = threadInfo.repost_num.intValue();
                this.Qq = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Qr = threadInfo.is_livepost.intValue();
                this.Qs.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Qt = threadInfo.has_commented.intValue();
                this.Qu = threadInfo.show_commented.intValue();
                this.Qv = threadInfo.click_url;
                this.QH = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.QA = threadInfo.collect_mark_pid;
                this.QB = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.QJ = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.QC = threadInfo.is_ntitle.intValue();
                this.QE = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.QF = threadInfo.operator_flag.intValue();
                this.Qz = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (EcommSwitchStatic.Fq()) {
                    this.isDeal = threadInfo.is_deal.intValue() == 1;
                    if (threadInfo.deal_info != null) {
                        this.Rl = new DealInfoData();
                        this.Rl.parserProtobuf(threadInfo.deal_info);
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
                this.abstract_text = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Qx.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.QH = threadInfo.video_info;
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
                        this.Qy.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.QL.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.QM = new bh();
                    this.QM.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.QN = new c();
                    this.QN.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.QO = new l();
                    this.QO.a(threadInfo.cartoon_info);
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                this.QS = threadInfo.livecover_src;
                this.QT = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.QK = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                n nVar = new n();
                                nVar.dR(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.QG.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.QU = noticeInfo.notice;
                    }
                    this.Ra = zhiBoInfoTW.copythread_remind.intValue();
                    this.QY = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.QZ = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.QS)) {
                        this.QS = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.OA = zhiBoInfoTW.user.tw_anchor_info;
                        this.OB = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.QV = threadInfo.twzhibo_info.livecover_status;
                    this.QW = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.QX = threadInfo.poll_info;
                this.Rb = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Re.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.Rf = new ba();
                    this.Rf.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.Rg.add(bVar);
                    }
                }
                this.Rh.parserProtobuf(threadInfo.push_status);
                this.Rm = threadInfo.lego_card;
                this.Ri = threadInfo.skin_info;
                this.Rn = threadInfo.is_book_chapter.intValue();
                this.Ro.a(threadInfo.book_chapter);
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
                this.tid = jSONObject.optString("tid");
                this.title = jSONObject.optString("title");
                this.QI = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Qp = jSONObject.optInt("repost_num", 0);
                this.Qq = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt("is_top", 0);
                this.is_good = jSONObject.optInt("is_good", 0);
                this.Qr = jSONObject.optInt("is_livepost", 0);
                this.Qs.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Qt = jSONObject.optInt("has_commented", 0);
                this.Qu = jSONObject.optInt("show_commented", 0);
                this.Qv = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.QA = jSONObject.optString("collect_mark_pid");
                this.QB = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.QJ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.QC = jSONObject.optInt("is_ntitle");
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
                this.abstract_text = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Qx.add(mediaData);
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
                        this.Qy.add(voiceModel);
                    }
                }
                if (EcommSwitchStatic.Fq() && jSONObject != null) {
                    this.Rl = new DealInfoData();
                    this.Rl.parserJson(jSONObject);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.QL.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.QM = new bh();
                    this.QM.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.QN = new c();
                    this.QN.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.QO = new l();
                    this.QO.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.Re.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Rg.add(bVar);
                    }
                }
                this.Rn = jSONObject.optInt("is_book_chapter", 0);
                this.Ro.parserJson(jSONObject.optJSONObject("book_chapter"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString getSpan_str() {
        return this.Qw;
    }

    public boolean ra() {
        return getIs_top() != 0;
    }

    public int rb() {
        if (this.Re != null) {
            long qs = this.Re.qs();
            long qt = this.Re.qt();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qs) {
                return 1;
            }
            if (currentTimeMillis > qt) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rc() {
        if (re() && this.QL.size() >= 1) {
            a aVar = this.QL.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int on = aVar.on();
            int oo = aVar.oo();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < on) {
                return 4;
            }
            return currentTimeMillis > oo ? 2 : 1;
        }
        return -1;
    }

    public int rd() {
        if (!re() || this.QL.size() < 1 || this.QL.get(0) == null) {
            return -1;
        }
        return this.QL.get(0).om();
    }

    public boolean re() {
        return this.QE == 1;
    }

    public String rf() {
        return (!re() || this.QL.size() < 1 || this.QL.get(0) == null) ? "" : this.QL.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cu(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(u.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(u.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(u.d.cp_cont_f_1));
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

    private void al(boolean z) {
        com.baidu.adp.widget.d dVar;
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getThreadType() == 42 && rg()) {
                arrayList.add(Integer.valueOf(u.f.icon_convene));
            }
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(u.f.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(u.f.icon_notice));
            }
            if (qH() == 1 || this.Qs.rG() != 0) {
                if (qy() != null && getThreadType() == 41) {
                    if (rb() == 2) {
                        arrayList.add(Integer.valueOf(u.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(u.f.icon_zhibo));
                }
            }
            if (z && rp()) {
                Integer num = QR.get(Integer.valueOf(rb()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (getIs_good() == 1 && !ra()) {
                arrayList.add(Integer.valueOf(u.f.icon_elite));
            }
            if (getType() == Ql || getType() == Qm) {
                arrayList.add(Integer.valueOf(u.f.icon_vote_blue));
            }
            if (this.QB == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(u.f.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(u.f.icon_live_on));
            }
            if (qM() == 1) {
                arrayList.add(Integer.valueOf(u.f.frs_post_ding));
            }
            if (!z && rd() == 2) {
                arrayList.add(Integer.valueOf(u.f.label_frs_activity_shai));
            } else {
                Integer num2 = QP.get(new Point(rd(), rc()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (qR() != null) {
                arrayList.add(Integer.valueOf(u.f.tag_act));
            }
            if (qS() != null) {
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
                    ahVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.Qo));
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
            this.Qw = spannableString;
        }
    }

    private boolean rg() {
        return com.baidu.adp.lib.c.e.cT().Z("isConveneThreadOpen") == 1;
    }

    public void parser_title() {
        al(false);
    }

    public void rh() {
        al(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean ri() {
        return this.threadType == 36;
    }

    public boolean rj() {
        return this.threadType == 40;
    }

    public boolean rk() {
        return this.threadType == 11 || this.QB == 1;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int rl() {
        return this.QK;
    }

    public void bK(int i) {
        this.QK = i;
    }

    public int rm() {
        return this.QW;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<com.baidu.tbadk.core.util.ak> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || ra()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ak> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2) != null && medias.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                if (!StringUtils.isNull(medias.get(i2).getThumbnails_url())) {
                    akVar.imgUrl = medias.get(i2).getThumbnails_url();
                } else {
                    akVar.imgUrl = medias.get(i2).getPicUrl();
                }
                akVar.Xu = 13;
                arrayList.add(akVar);
            }
            i = i2 + 1;
        }
        if (this.QH != null && !StringUtils.isNull(this.QH.thumbnail_url)) {
            com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
            akVar2.imgUrl = this.QH.thumbnail_url;
            akVar2.Xu = 13;
            arrayList.add(akVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ak akVar3 = new com.baidu.tbadk.core.util.ak();
            akVar3.imgUrl = this.author.getPortrait();
            akVar3.Xu = 28;
            arrayList.add(akVar3);
        }
        return arrayList;
    }

    public boolean rn() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return Qf;
        }
        if (this.isDeal && this.Rl != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            return Qj;
        }
        if (this.QH != null) {
            if (qJ()) {
                return Qi;
            }
            return Qh;
        } else if (qF() != null && getThreadType() == 36 && qF().type.intValue() == 2) {
            return Ql;
        } else {
            if (qF() != null && getThreadType() == 36 && qF().type.intValue() == 1) {
                return Qm;
            }
            if (qy() != null && getThreadType() == 41 && qH() == 1 && rb() == 2) {
                return Qk.get() ? Rd : TYPE_NORMAL;
            } else if (re() && rd() == 1) {
                return Qk.get() ? Rj : TYPE_NORMAL;
            } else if (qz() != null && !TextUtils.isEmpty(qz().getActivityName())) {
                return Qn;
            } else {
                if (re() && rd() == 2) {
                    return Qk.get() ? Rc : TYPE_NORMAL;
                } else if (qJ()) {
                    return Qg;
                } else {
                    return TYPE_NORMAL;
                }
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus ro() {
        return this.QV;
    }

    public List<TwAnchorProfitItem> pq() {
        return this.OB;
    }

    public void i(ArrayList<m> arrayList) {
        if (this.QC == 1) {
            this.ND = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.ND = 0;
        } else {
            this.ND = 0;
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next != null && next.oI() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.oI().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.ND = next.oJ();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean rp() {
        return this.threadType == 41;
    }

    public boolean rq() {
        return this.Rk;
    }

    public void am(boolean z) {
        this.Rk = z;
    }

    public String rr() {
        return this.Rm;
    }

    public l rs() {
        return this.QO;
    }

    public DealInfoData rt() {
        return this.Rl;
    }
}

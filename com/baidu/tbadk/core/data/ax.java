package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PollInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class ax extends com.baidu.tieba.card.a.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ak {
    public TwZhiBoUser OA;
    public List<TwAnchorProfitItem> OB;
    private k QA;
    private LiveCoverStatus QG;
    private int QH;
    private ay QR;
    private boolean QV;
    private String QW;
    private SpannableString Qi;
    public int Ql;
    private int Qn;
    private int Qo;
    private String Qp;
    private int Qr;
    private VideoInfo Qt;
    private long Qu;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId PT = BdUniqueId.gen();
    public static final BdUniqueId TYPE_NORMAL = BdUniqueId.gen();
    public static final BdUniqueId PU = BdUniqueId.gen();
    public static final BdUniqueId PV = BdUniqueId.gen();
    public static final BdUniqueId PW = BdUniqueId.gen();
    public static final BdUniqueId PX = BdUniqueId.gen();
    public static final BdUniqueId PY = BdUniqueId.gen();
    public static final BdUniqueId PZ = BdUniqueId.gen();
    private static HashMap<Point, Integer> QB = new HashMap<>();
    private static HashMap<Integer, Integer> QC = new HashMap<>();
    public static final BdUniqueId QN = BdUniqueId.gen();
    public static final BdUniqueId QO = BdUniqueId.gen();
    public static final BdUniqueId QU = BdUniqueId.gen();
    public int Qa = 1;
    private String Qm = null;
    private int NE = 0;
    private String Qv = "";
    private String QD = "";
    private String id = null;
    private String tid = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Qb = 0;
    private int Qc = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Qd = 0;
    private bb Qe = new bb();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Qj = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Qk = new ArrayList<>();
    private int Qf = 0;
    private int Qg = 0;
    private String Qh = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int Qq = 0;
    private ArrayList<a> Qx = new ArrayList<>();
    private bf Qy = null;
    private d Qz = null;
    private int QE = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Qs = new ArrayList<>();
    private boolean isHeadLive = false;
    private String QF = null;
    private int Qw = 0;
    private PollInfo QI = null;
    private boolean QJ = false;
    private boolean QK = false;
    private int QL = 0;
    private boolean QM = false;
    private int anchorLevel = 0;
    private String category_name = null;
    private av QP = new av();
    private ArrayList<com.baidu.tbadk.data.b> QS = new ArrayList<>();
    private ai QT = new ai();

    static {
        QB.put(new Point(1, 1), Integer.valueOf(t.f.label_frs_lottery_ing));
        QB.put(new Point(1, 2), Integer.valueOf(t.f.label_frs_lottery_over));
        QB.put(new Point(1, 3), Integer.valueOf(t.f.label_frs_lottery_off));
        QB.put(new Point(1, 4), Integer.valueOf(t.f.label_frs_lottery_d));
        QB.put(new Point(2, 1), Integer.valueOf(t.f.label_frs_activity_shaiing));
        QB.put(new Point(2, 2), Integer.valueOf(t.f.label_frs_activity_shai_over));
        QB.put(new Point(2, 3), Integer.valueOf(t.f.label_frs_activity_shai_off));
        QB.put(new Point(2, 4), Integer.valueOf(t.f.label_frs_activity_shai_d));
        QC.put(1, Integer.valueOf(t.f.label_interview_no));
        QC.put(2, Integer.valueOf(t.f.label_interview_live));
        QC.put(3, Integer.valueOf(t.f.label_interview_off));
    }

    public ax() {
        this.Qr = 0;
        this.QH = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.QH = 0;
        this.Qr = 0;
    }

    public av qF() {
        return this.QP;
    }

    public ay qG() {
        return this.QR;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int qH() {
        return this.Qr;
    }

    public boolean qI() {
        return this.QM;
    }

    public boolean qJ() {
        return this.QJ;
    }

    public boolean qK() {
        return this.QK;
    }

    public void bG(int i) {
        this.QL = i;
    }

    public int qL() {
        return this.QL;
    }

    public PollInfo qM() {
        return this.QI;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Qu;
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
        return this.tid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
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

    public void bH(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bI(int i) {
        this.is_good = i;
    }

    public int qN() {
        return this.Qd;
    }

    public bb qO() {
        return this.Qe;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public boolean qP() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String qQ() {
        return this.forum_name;
    }

    public void cs(String str) {
        this.forum_name = str;
    }

    public int qR() {
        return this.Qg;
    }

    public String qS() {
        return this.Qh;
    }

    public String qT() {
        return this.abstract_text;
    }

    public void ct(String str) {
        this.abstract_text = str;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String qU() {
        return this.Qm;
    }

    public void cu(String str) {
        this.Qm = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Qj;
    }

    public ArrayList<a> qV() {
        return this.Qx;
    }

    public void h(ArrayList<a> arrayList) {
        this.Qx = arrayList;
    }

    public bf qW() {
        return this.Qy;
    }

    public d qX() {
        return this.Qz;
    }

    public ArrayList<VoiceData.VoiceModel> qY() {
        return this.Qk;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int qZ() {
        return this.Qo;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String ra() {
        return this.Qv;
    }

    public VideoInfo rb() {
        return this.Qt;
    }

    public String getPhotoLiveCover() {
        return this.QD;
    }

    public void setPhotoLiveCover(String str) {
        this.QD = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rc() {
        return this.Qs;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Qs.clear();
        this.Qs.addAll(arrayList);
    }

    public String getNotice() {
        return this.QF;
    }

    public ai rd() {
        return this.QT;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0022: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0033: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00e9: IGET  (r3v8 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00fa: IGET  (r3v9 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Qp = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Qu = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Qb = threadInfo.repost_num.intValue();
                this.Qc = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Qd = threadInfo.is_livepost.intValue();
                this.Qe.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Qf = threadInfo.has_commented.intValue();
                this.Qg = threadInfo.show_commented.intValue();
                this.Qh = threadInfo.click_url;
                this.Qt = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Qm = threadInfo.collect_mark_pid;
                this.Qn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Qv = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Qo = threadInfo.is_ntitle.intValue();
                this.Qq = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Qr = threadInfo.operator_flag.intValue();
                this.Ql = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
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
                        this.Qj.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Qt = threadInfo.video_info;
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
                        this.Qk.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Qx.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Qy = new bf();
                    this.Qy.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Qz = new d();
                    this.Qz.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.QA = new k();
                    this.QA.a(threadInfo.cartoon_info);
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                this.QD = threadInfo.livecover_src;
                this.QE = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Qw = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.dP(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Qs.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.QF = noticeInfo.notice;
                    }
                    this.QL = zhiBoInfoTW.copythread_remind.intValue();
                    this.QJ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.QK = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.QD)) {
                        this.QD = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.OA = zhiBoInfoTW.user.tw_anchor_info;
                        this.OB = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.QG = threadInfo.twzhibo_info.livecover_status;
                    this.QH = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.QI = threadInfo.poll_info;
                this.QM = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.QP.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.QR = new ay();
                    this.QR.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.QS.add(bVar);
                    }
                }
                this.QT.a(threadInfo.push_status);
                this.QW = threadInfo.lego_card;
            } catch (Exception e) {
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
                this.Qu = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Qb = jSONObject.optInt("repost_num", 0);
                this.Qc = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Qd = jSONObject.optInt("is_livepost", 0);
                this.Qe.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Qf = jSONObject.optInt("has_commented", 0);
                this.Qg = jSONObject.optInt("show_commented", 0);
                this.Qh = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Qm = jSONObject.optString("collect_mark_pid");
                this.Qn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.Qv = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Qo = jSONObject.optInt("is_ntitle");
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
                        this.Qj.add(mediaData);
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
                        this.Qk.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Qx.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Qy = new bf();
                    this.Qy.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Qz = new d();
                    this.Qz.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.QA = new k();
                    this.QA.parserJson(jSONObject.optJSONObject("cartoon_info"));
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
                    this.QP.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.QS.add(bVar);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString getSpan_str() {
        return this.Qi;
    }

    public boolean re() {
        return getIs_top() != 0;
    }

    public int rf() {
        if (this.QP != null) {
            long qy = this.QP.qy();
            long qz = this.QP.qz();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qy) {
                return 1;
            }
            if (currentTimeMillis > qz) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rg() {
        if (ri() && this.Qx.size() >= 1) {
            a aVar = this.Qx.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int os = aVar.os();
            int ot = aVar.ot();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < os) {
                return 4;
            }
            return currentTimeMillis > ot ? 2 : 1;
        }
        return -1;
    }

    public int rh() {
        if (!ri() || this.Qx.size() < 1 || this.Qx.get(0) == null) {
            return -1;
        }
        return this.Qx.get(0).or();
    }

    public boolean ri() {
        return this.Qq == 1;
    }

    public String rj() {
        return (!ri() || this.Qx.size() < 1 || this.Qx.get(0) == null) ? "" : this.Qx.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cv(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m11getInst().getApplicationContext()).inflate(t.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(t.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m11getInst().getApplicationContext().getResources().getColor(t.d.cp_cont_f_1));
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
            if (getThreadType() == 42 && rk()) {
                arrayList.add(Integer.valueOf(t.f.icon_convene));
            }
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(t.f.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(t.f.icon_notice));
            }
            if (qN() == 1 || this.Qe.rJ() != 0) {
                if (qF() != null && getThreadType() == 41) {
                    if (rf() == 2) {
                        arrayList.add(Integer.valueOf(t.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(t.f.icon_zhibo));
                }
            }
            if (z && rt()) {
                Integer num = QC.get(Integer.valueOf(rf()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (getIs_good() == 1 && !re()) {
                arrayList.add(Integer.valueOf(t.f.icon_elite));
            }
            if (getType() == PX || getType() == PY) {
                arrayList.add(Integer.valueOf(t.f.icon_vote_blue));
            }
            if (this.Qn == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(t.f.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(t.f.icon_live_on));
            }
            if (qR() == 1) {
                arrayList.add(Integer.valueOf(t.f.frs_post_ding));
            }
            if (!z && rh() == 2) {
                arrayList.add(Integer.valueOf(t.f.label_frs_activity_shai));
            } else {
                Integer num2 = QB.get(new Point(rh(), rg()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (qW() != null) {
                arrayList.add(Integer.valueOf(t.f.tag_act));
            }
            if (qX() != null) {
                arrayList.add(Integer.valueOf(t.f.icon_tag_giftsend));
            }
            if (com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = null;
            } else {
                dVar = cv(this.category_name);
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
                    Bitmap cz = com.baidu.tbadk.core.util.at.cz(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cz);
                    if (cz != null) {
                        bitmapDrawable.setBounds(0, 0, cz.getWidth(), cz.getHeight());
                    }
                    com.baidu.tbadk.core.view.ah ahVar = new com.baidu.tbadk.core.view.ah(bitmapDrawable);
                    ahVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApplicationContext(), this.Qa));
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
            this.Qi = spannableString;
        }
    }

    private boolean rk() {
        return com.baidu.adp.lib.c.e.cS().Z("isConveneThreadOpen") == 1;
    }

    public void parser_title() {
        an(false);
    }

    public void rl() {
        an(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean rm() {
        return this.threadType == 36;
    }

    public boolean rn() {
        return this.threadType == 40;
    }

    public boolean ro() {
        return this.threadType == 11 || this.Qn == 1;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int rp() {
        return this.Qw;
    }

    public void bJ(int i) {
        this.Qw = i;
    }

    public int rq() {
        return this.QH;
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<com.baidu.tbadk.core.util.aj> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || re()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.aj> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.aj ajVar = new com.baidu.tbadk.core.util.aj();
                ajVar.imgUrl = medias.get(i2).getPicUrl();
                ajVar.Xc = 13;
                arrayList.add(ajVar);
            }
            i = i2 + 1;
        }
        if (this.Qt != null && !StringUtils.isNull(this.Qt.thumbnail_url)) {
            com.baidu.tbadk.core.util.aj ajVar2 = new com.baidu.tbadk.core.util.aj();
            ajVar2.imgUrl = this.Qt.thumbnail_url;
            ajVar2.Xc = 13;
            arrayList.add(ajVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.aj ajVar3 = new com.baidu.tbadk.core.util.aj();
            ajVar3.imgUrl = this.author.getPortrait();
            ajVar3.Xc = 28;
            arrayList.add(ajVar3);
        }
        return arrayList;
    }

    public boolean rr() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return PT;
        }
        if (this.Qt != null) {
            if (qP()) {
                return PW;
            }
            return PV;
        } else if (qM() != null && getThreadType() == 36 && qM().type.intValue() == 2) {
            return PX;
        } else {
            if (qM() != null && getThreadType() == 36 && qM().type.intValue() == 1) {
                return PY;
            }
            if (qF() != null && getThreadType() == 41 && qN() == 1 && rf() == 2) {
                return QO;
            }
            if (ri() && rh() == 1) {
                return QU;
            }
            if (qG() != null && !TextUtils.isEmpty(qG().getActivityName())) {
                return PZ;
            }
            if (ri() && rh() == 2) {
                return QN;
            }
            if (qP()) {
                return PU;
            }
            return TYPE_NORMAL;
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus rs() {
        return this.QG;
    }

    public List<TwAnchorProfitItem> px() {
        return this.OB;
    }

    public void i(ArrayList<l> arrayList) {
        if (this.Qo == 1) {
            this.NE = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.NE = 0;
        } else {
            this.NE = 0;
            Iterator<l> it = arrayList.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null && next.oQ() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.oQ().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.NE = next.oR();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean rt() {
        return this.threadType == 41;
    }

    public boolean ru() {
        return this.QV;
    }

    public void ao(boolean z) {
        this.QV = z;
    }

    public k rv() {
        return this.QA;
    }
}

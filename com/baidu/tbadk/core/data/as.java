package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
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
public class as implements com.baidu.adp.widget.ListView.u, com.baidu.tbadk.core.util.ak {
    public static final BdUniqueId UV = BdUniqueId.gen();
    public static final BdUniqueId UW = BdUniqueId.gen();
    public static final BdUniqueId UX = BdUniqueId.gen();
    public static final BdUniqueId UY = BdUniqueId.gen();
    public static final BdUniqueId UZ = BdUniqueId.gen();
    private static HashMap<Point, Integer> VB = new HashMap<>();
    private static HashMap<Integer, Integer> VC = new HashMap<>();
    public static final BdUniqueId VN = BdUniqueId.gen();
    public static final BdUniqueId VR = BdUniqueId.gen();
    public TwZhiBoUser TM;
    public List<TwAnchorProfitItem> TO;
    private k VA;
    private LiveCoverStatus VG;
    private int VH;
    private boolean VS;
    private SpannableString Vi;
    public int Vl;
    private int Vn;
    private int Vo;
    private String Vp;
    private int Vr;
    private VideoInfo Vt;
    private long Vu;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int Va = 1;
    private String Vm = null;
    private int SS = 0;
    private String Vv = "";
    private String VD = "";
    private String id = null;
    private String tid = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Vb = 0;
    private int Vc = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Vd = 0;
    private av Ve = new av();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Vj = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Vk = new ArrayList<>();
    private int Vf = 0;
    private int Vg = 0;
    private String Vh = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int Vq = 0;
    private ArrayList<a> Vx = new ArrayList<>();
    private az Vy = null;
    private d Vz = null;
    private int VE = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Vs = new ArrayList<>();
    private boolean isHeadLive = false;
    private String VF = null;
    private int Vw = 0;
    private PollInfo VI = null;
    private boolean VJ = false;
    private boolean VK = false;
    private int VL = 0;
    private boolean VM = false;
    private int anchorLevel = 0;
    private String category_name = null;
    private aq VO = new aq();
    private ArrayList<com.baidu.tbadk.data.a> VP = new ArrayList<>();
    private ag VQ = new ag();

    static {
        VB.put(new Point(1, 1), Integer.valueOf(t.f.label_frs_lottery_ing));
        VB.put(new Point(1, 2), Integer.valueOf(t.f.label_frs_lottery_over));
        VB.put(new Point(1, 3), Integer.valueOf(t.f.label_frs_lottery_off));
        VB.put(new Point(1, 4), Integer.valueOf(t.f.label_frs_lottery_d));
        VB.put(new Point(2, 1), Integer.valueOf(t.f.label_frs_activity_shaiing));
        VB.put(new Point(2, 2), Integer.valueOf(t.f.label_frs_activity_shai_over));
        VB.put(new Point(2, 3), Integer.valueOf(t.f.label_frs_activity_shai_off));
        VB.put(new Point(2, 4), Integer.valueOf(t.f.label_frs_activity_shai_d));
        VC.put(1, Integer.valueOf(t.f.label_interview_no));
        VC.put(2, Integer.valueOf(t.f.label_interview_live));
        VC.put(3, Integer.valueOf(t.f.label_interview_off));
    }

    public as() {
        this.Vr = 0;
        this.VH = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.VH = 0;
        this.Vr = 0;
    }

    public aq tg() {
        return this.VO;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int th() {
        return this.Vr;
    }

    public boolean ti() {
        return this.VM;
    }

    public boolean tj() {
        return this.VJ;
    }

    public boolean tk() {
        return this.VK;
    }

    public void bV(int i) {
        this.VL = i;
    }

    public int tl() {
        return this.VL;
    }

    public PollInfo tm() {
        return this.VI;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Vu;
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

    public void cu(String str) {
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

    public void s(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bW(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bX(int i) {
        this.is_good = i;
    }

    public int tn() {
        return this.Vd;
    }

    public av tp() {
        return this.Ve;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public boolean tq() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String tr() {
        return this.forum_name;
    }

    public void cv(String str) {
        this.forum_name = str;
    }

    public int ts() {
        return this.Vg;
    }

    public String tt() {
        return this.Vh;
    }

    public String tu() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String tv() {
        return this.Vm;
    }

    public void cw(String str) {
        this.Vm = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Vj;
    }

    public ArrayList<a> tw() {
        return this.Vx;
    }

    public void h(ArrayList<a> arrayList) {
        this.Vx = arrayList;
    }

    public az tx() {
        return this.Vy;
    }

    public d ty() {
        return this.Vz;
    }

    public ArrayList<VoiceData.VoiceModel> tz() {
        return this.Vk;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int tA() {
        return this.Vo;
    }

    public String getAddress() {
        return this.address;
    }

    public String tB() {
        return this.Vv;
    }

    public VideoInfo tC() {
        return this.Vt;
    }

    public String getPhotoLiveCover() {
        return this.VD;
    }

    public void setPhotoLiveCover(String str) {
        this.VD = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> tD() {
        return this.Vs;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Vs.clear();
        this.Vs.addAll(arrayList);
    }

    public String getNotice() {
        return this.VF;
    }

    public ag tE() {
        return this.VQ;
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
                    this.Vp = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Vu = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Vb = threadInfo.repost_num.intValue();
                this.Vc = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Vd = threadInfo.is_livepost.intValue();
                this.Ve.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Vf = threadInfo.has_commented.intValue();
                this.Vg = threadInfo.show_commented.intValue();
                this.Vh = threadInfo.click_url;
                this.Vt = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Vm = threadInfo.collect_mark_pid;
                this.Vn = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Vv = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Vo = threadInfo.is_ntitle.intValue();
                this.Vq = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Vr = threadInfo.operator_flag.intValue();
                this.Vl = threadInfo.is_godthread_recommend.intValue();
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
                        this.Vj.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Vt = threadInfo.video_info;
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
                        this.Vk.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Vx.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Vy = new az();
                    this.Vy.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Vz = new d();
                    this.Vz.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.VA = new k();
                    this.VA.a(threadInfo.cartoon_info);
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                this.VD = threadInfo.livecover_src;
                this.VE = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Vw = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.ek(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Vs.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.VF = noticeInfo.notice;
                    }
                    this.VL = zhiBoInfoTW.copythread_remind.intValue();
                    this.VJ = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.VK = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (!StringUtils.isNull(zhiBoInfoTW.livecover_src)) {
                        this.VD = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.TM = zhiBoInfoTW.user.tw_anchor_info;
                        this.TO = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.VG = threadInfo.twzhibo_info.livecover_status;
                    this.VH = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.VI = threadInfo.poll_info;
                this.VM = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.VO.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.a(threadInfo.ext_tails.get(i6));
                        this.VP.add(aVar2);
                    }
                }
                this.VQ.a(threadInfo.push_status);
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
                this.Vu = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Vb = jSONObject.optInt("repost_num", 0);
                this.Vc = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Vd = jSONObject.optInt("is_livepost", 0);
                this.Ve.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Vf = jSONObject.optInt("has_commented", 0);
                this.Vg = jSONObject.optInt("show_commented", 0);
                this.Vh = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Vm = jSONObject.optString("collect_mark_pid");
                this.Vn = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.Vv = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Vo = jSONObject.optInt("is_ntitle");
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
                        this.Vj.add(mediaData);
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
                        this.Vk.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Vx.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Vy = new az();
                    this.Vy.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Vz = new d();
                    this.Vz.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.VA = new k();
                    this.VA.parserJson(jSONObject.optJSONObject("cartoon_info"));
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
                    this.VO.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.a aVar2 = new com.baidu.tbadk.data.a();
                        aVar2.parserJson(optJSONArray5.getJSONObject(i5));
                        this.VP.add(aVar2);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString getSpan_str() {
        return this.Vi;
    }

    public boolean tF() {
        return getIs_top() != 0;
    }

    public int tG() {
        if (this.VO != null) {
            long sZ = this.VO.sZ();
            long ta = this.VO.ta();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < sZ) {
                return 1;
            }
            if (currentTimeMillis > ta) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int tH() {
        if (tJ() && this.Vx.size() >= 1) {
            a aVar = this.Vx.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int qV = aVar.qV();
            int qW = aVar.qW();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < qV) {
                return 4;
            }
            return currentTimeMillis > qW ? 2 : 1;
        }
        return -1;
    }

    public int tI() {
        if (!tJ() || this.Vx.size() < 1 || this.Vx.get(0) == null) {
            return -1;
        }
        return this.Vx.get(0).qU();
    }

    public boolean tJ() {
        return this.Vq == 1;
    }

    public String tK() {
        return (!tJ() || this.Vx.size() < 1 || this.Vx.get(0) == null) ? "" : this.Vx.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cx(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m411getInst().getApplicationContext()).inflate(t.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(t.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m411getInst().getApplicationContext().getResources().getColor(t.d.cp_cont_f_1));
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

    private void ak(boolean z) {
        com.baidu.adp.widget.d dVar;
        SpannableString spannableString;
        if (this.title != null && this.Vi == null) {
            ArrayList arrayList = new ArrayList();
            if (getThreadType() == 42 && tL()) {
                arrayList.add(Integer.valueOf(t.f.icon_convene));
            }
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(t.f.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(t.f.icon_notice));
            }
            if (tn() == 1 || this.Ve.ud() != 0) {
                if (tg() != null && getThreadType() == 41) {
                    if (tG() == 2) {
                        arrayList.add(Integer.valueOf(t.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(t.f.icon_zhibo));
                }
            }
            if (z && tU()) {
                Integer num = VC.get(Integer.valueOf(tG()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (getIs_good() == 1 && !tF()) {
                arrayList.add(Integer.valueOf(t.f.icon_elite));
            }
            if (getType() == UY || getType() == UZ) {
                arrayList.add(Integer.valueOf(t.f.icon_vote_blue));
            }
            if (this.Vn == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(t.f.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(t.f.icon_live_on));
            }
            if (ts() == 1) {
                arrayList.add(Integer.valueOf(t.f.frs_post_ding));
            }
            if (!z && tI() == 2) {
                arrayList.add(Integer.valueOf(t.f.label_frs_activity_shai));
            } else {
                Integer num2 = VB.get(new Point(tI(), tH()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (tx() != null) {
                arrayList.add(Integer.valueOf(t.f.tag_act));
            }
            if (ty() != null) {
                arrayList.add(Integer.valueOf(t.f.icon_tag_giftsend));
            }
            if (com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = null;
            } else {
                dVar = cx(this.category_name);
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
                    Bitmap cR = com.baidu.tbadk.core.util.at.cR(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                    if (cR != null) {
                        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                    }
                    com.baidu.tbadk.core.view.af afVar = new com.baidu.tbadk.core.view.af(bitmapDrawable);
                    afVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApplicationContext(), this.Va));
                    spannableString.setSpan(afVar, i2, i2 + 1, 33);
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
            this.Vi = spannableString;
        }
    }

    private boolean tL() {
        return com.baidu.adp.lib.c.e.gE().ai("isConveneThreadOpen") == 1;
    }

    public void parser_title() {
        ak(false);
    }

    public void tM() {
        ak(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean tN() {
        return this.threadType == 36;
    }

    public boolean tO() {
        return this.threadType == 40;
    }

    public boolean tP() {
        return this.threadType == 11 || this.Vn == 1;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int tQ() {
        return this.Vw;
    }

    public void bY(int i) {
        this.Vw = i;
    }

    public int tR() {
        return this.VH;
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<com.baidu.tbadk.core.util.aj> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || tF()) {
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
                ajVar.abD = 13;
                arrayList.add(ajVar);
            }
            i = i2 + 1;
        }
        if (this.Vt != null && !StringUtils.isNull(this.Vt.thumbnail_url)) {
            com.baidu.tbadk.core.util.aj ajVar2 = new com.baidu.tbadk.core.util.aj();
            ajVar2.imgUrl = this.Vt.thumbnail_url;
            ajVar2.abD = 13;
            arrayList.add(ajVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.aj ajVar3 = new com.baidu.tbadk.core.util.aj();
            ajVar3.imgUrl = this.author.getPortrait();
            ajVar3.abD = 28;
            arrayList.add(ajVar3);
        }
        return arrayList;
    }

    public boolean tS() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return UV;
        }
        if (this.Vt != null) {
            return UX;
        }
        if (tm() != null && getThreadType() == 36 && tm().type.intValue() == 2) {
            return UY;
        }
        if (tm() != null && getThreadType() == 36 && tm().type.intValue() == 1) {
            return UZ;
        }
        if (tg() != null && getThreadType() == 41 && tn() == 1 && tG() == 2) {
            return VN;
        }
        if (tJ() && tI() == 1) {
            return VR;
        }
        return UW;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus tT() {
        return this.VG;
    }

    public List<TwAnchorProfitItem> se() {
        return this.TO;
    }

    public void i(ArrayList<l> arrayList) {
        if (this.Vo == 1) {
            this.SS = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.SS = 0;
        } else {
            this.SS = 0;
            Iterator<l> it = arrayList.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (next != null && next.rw() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rw().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.SS = next.rx();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean tU() {
        return this.threadType == 41;
    }

    public boolean tV() {
        return this.VS;
    }

    public void al(boolean z) {
        this.VS = z;
    }

    public k tW() {
        return this.VA;
    }
}

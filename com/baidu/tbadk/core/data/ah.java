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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ar;
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
public class ah implements com.baidu.adp.widget.ListView.u, com.baidu.tbadk.core.util.ai {
    public static final BdUniqueId WF = BdUniqueId.gen();
    public static final BdUniqueId WG = BdUniqueId.gen();
    public static final BdUniqueId WH = BdUniqueId.gen();
    public static final BdUniqueId WI = BdUniqueId.gen();
    public static final BdUniqueId WJ = BdUniqueId.gen();
    private static HashMap<Point, Integer> Xk = new HashMap<>();
    private static HashMap<Integer, Integer> Xl = new HashMap<>();
    public static final BdUniqueId Xw = BdUniqueId.gen();
    public TwZhiBoUser VJ;
    public List<TwAnchorProfitItem> VK;
    private SpannableString WS;
    public int WV;
    private int WX;
    private int WY;
    private String WZ;
    private int Xb;
    private VideoInfo Xd;
    private long Xe;
    private LiveCoverStatus Xp;
    private int Xq;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int WK = 1;
    private String WW = null;
    private int Vi = 0;
    private String Xf = "";
    private String Xm = "";
    private String id = null;
    private String tid = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int WL = 0;
    private int WM = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int WN = 0;
    private ak WO = new ak();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> WT = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> WU = new ArrayList<>();
    private int WP = 0;
    private int WQ = 0;
    private String WR = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int Xa = 0;
    private ArrayList<a> Xh = new ArrayList<>();
    private ao Xi = null;
    private d Xj = null;
    private int Xn = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Xc = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Xo = null;
    private int Xg = 0;
    private PollInfo Xr = null;
    private boolean Xs = false;
    private boolean Xt = false;
    private int Xu = 0;
    private boolean Xv = false;
    private int anchorLevel = 0;
    private String category_name = null;
    private af Xx = new af();

    static {
        Xk.put(new Point(1, 1), Integer.valueOf(t.f.label_frs_lottery_ing));
        Xk.put(new Point(1, 2), Integer.valueOf(t.f.label_frs_lottery_over));
        Xk.put(new Point(1, 3), Integer.valueOf(t.f.label_frs_lottery_off));
        Xk.put(new Point(1, 4), Integer.valueOf(t.f.label_frs_lottery_d));
        Xk.put(new Point(2, 1), Integer.valueOf(t.f.label_frs_activity_shaiing));
        Xk.put(new Point(2, 2), Integer.valueOf(t.f.label_frs_activity_shai_over));
        Xk.put(new Point(2, 3), Integer.valueOf(t.f.label_frs_activity_shai_off));
        Xk.put(new Point(2, 4), Integer.valueOf(t.f.label_frs_activity_shai_d));
        Xl.put(1, Integer.valueOf(t.f.label_interview_no));
        Xl.put(2, Integer.valueOf(t.f.label_interview_live));
        Xl.put(3, Integer.valueOf(t.f.label_interview_off));
    }

    public ah() {
        this.Xb = 0;
        this.Xq = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Xq = 0;
        this.Xb = 0;
    }

    public af te() {
        return this.Xx;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int tf() {
        return this.Xb;
    }

    public boolean tg() {
        return this.Xv;
    }

    public boolean th() {
        return this.Xs;
    }

    public boolean ti() {
        return this.Xt;
    }

    public void bT(int i) {
        this.Xu = i;
    }

    public int tj() {
        return this.Xu;
    }

    public PollInfo tk() {
        return this.Xr;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Xe;
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

    public void cw(String str) {
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

    public void r(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bU(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bV(int i) {
        this.is_good = i;
    }

    public int tl() {
        return this.WN;
    }

    public ak tm() {
        return this.WO;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String tn() {
        return this.forum_name;
    }

    public void cx(String str) {
        this.forum_name = str;
    }

    public int tp() {
        return this.WQ;
    }

    public String tq() {
        return this.WR;
    }

    public String tr() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String ts() {
        return this.WW;
    }

    public void cy(String str) {
        this.WW = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.WT;
    }

    public ArrayList<a> tt() {
        return this.Xh;
    }

    public void k(ArrayList<a> arrayList) {
        this.Xh = arrayList;
    }

    public ao tu() {
        return this.Xi;
    }

    public d tv() {
        return this.Xj;
    }

    public ArrayList<VoiceData.VoiceModel> tw() {
        return this.WU;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int tx() {
        return this.WY;
    }

    public String getAddress() {
        return this.address;
    }

    public String ty() {
        return this.Xf;
    }

    public VideoInfo tz() {
        return this.Xd;
    }

    public String getPhotoLiveCover() {
        return this.Xm;
    }

    public void setPhotoLiveCover(String str) {
        this.Xm = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> tA() {
        return this.Xc;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Xc.clear();
        this.Xc.addAll(arrayList);
    }

    public String getNotice() {
        return this.Xo;
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
                    this.WZ = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Xe = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.WL = threadInfo.repost_num.intValue();
                this.WM = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.WN = threadInfo.is_livepost.intValue();
                this.WO.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.WP = threadInfo.has_commented.intValue();
                this.WQ = threadInfo.show_commented.intValue();
                this.WR = threadInfo.click_url;
                this.Xd = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.WW = threadInfo.collect_mark_pid;
                this.WX = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Xf = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.WY = threadInfo.is_ntitle.intValue();
                this.Xa = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Xb = threadInfo.operator_flag.intValue();
                this.WV = threadInfo.is_godthread_recommend.intValue();
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
                        this.WT.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Xd = threadInfo.video_info;
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
                        this.WU.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Xh.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Xi = new ao();
                    this.Xi.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Xj = new d();
                    this.Xj.a(threadInfo.app_code);
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                this.Xm = threadInfo.livecover_src;
                this.Xn = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Xg = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.eh(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Xc.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Xo = noticeInfo.notice;
                    }
                    this.Xu = zhiBoInfoTW.copythread_remind.intValue();
                    this.Xs = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Xt = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (!StringUtils.isNull(zhiBoInfoTW.livecover_src)) {
                        this.Xm = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.VJ = zhiBoInfoTW.user.tw_anchor_info;
                        this.VK = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Xp = threadInfo.twzhibo_info.livecover_status;
                    this.Xq = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Xr = threadInfo.poll_info;
                this.Xv = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Xx.a(threadInfo.task_info);
                }
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
                this.Xe = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.WL = jSONObject.optInt("repost_num", 0);
                this.WM = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.WN = jSONObject.optInt("is_livepost", 0);
                this.WO.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.WP = jSONObject.optInt("has_commented", 0);
                this.WQ = jSONObject.optInt("show_commented", 0);
                this.WR = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.WW = jSONObject.optString("collect_mark_pid");
                this.WX = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.Xf = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.WY = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString("category_name");
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
                        this.WT.add(mediaData);
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
                        this.WU.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Xh.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Xi = new ao();
                    this.Xi.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Xj = new d();
                    this.Xj.parserJson(jSONObject.optJSONObject("app_code"));
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
                    this.Xx.parserJson(optJSONObject);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString getSpan_str() {
        return this.WS;
    }

    public boolean tB() {
        return getIs_top() != 0;
    }

    public int tC() {
        if (this.Xx != null) {
            long sY = this.Xx.sY();
            long sZ = this.Xx.sZ();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < sY) {
                return 1;
            }
            if (currentTimeMillis > sZ) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int tD() {
        if (tF() && this.Xh.size() >= 1) {
            a aVar = this.Xh.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int rE = aVar.rE();
            int rF = aVar.rF();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < rE) {
                return 4;
            }
            return currentTimeMillis > rF ? 2 : 1;
        }
        return -1;
    }

    public int tE() {
        if (!tF() || this.Xh.size() < 1 || this.Xh.get(0) == null) {
            return -1;
        }
        return this.Xh.get(0).rD();
    }

    public boolean tF() {
        return this.Xa == 1;
    }

    public String tG() {
        return (!tF() || this.Xh.size() < 1 || this.Xh.get(0) == null) ? "" : this.Xh.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cz(String str) {
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

    private void ai(boolean z) {
        com.baidu.adp.widget.d dVar;
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(t.f.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(t.f.icon_notice));
            }
            if (tl() == 1 || this.WO.tX() != 0) {
                if (te() != null && getThreadType() == 41) {
                    if (tC() == 2) {
                        arrayList.add(Integer.valueOf(t.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(t.f.icon_zhibo));
                }
            }
            if (z && tP()) {
                Integer num = Xl.get(Integer.valueOf(tC()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (getIs_good() == 1 && !tB()) {
                arrayList.add(Integer.valueOf(t.f.icon_elite));
            }
            if (getType() == WI || getType() == WJ) {
                arrayList.add(Integer.valueOf(t.f.icon_vote_blue));
            }
            if (this.WX == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(t.f.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(t.f.icon_live_on));
            }
            if (tp() == 1) {
                arrayList.add(Integer.valueOf(t.f.frs_post_ding));
            }
            if (z) {
                Integer num2 = Xk.get(new Point(tE(), tD()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            } else if (tE() == 1) {
                arrayList.add(Integer.valueOf(t.f.label_frs_lottery));
            } else if (tE() == 2) {
                arrayList.add(Integer.valueOf(t.f.label_frs_activity_shai));
            }
            if (tu() != null) {
                arrayList.add(Integer.valueOf(t.f.tag_act));
            }
            if (tv() != null) {
                arrayList.add(Integer.valueOf(t.f.icon_tag_giftsend));
            }
            if (com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = null;
            } else {
                dVar = cz(this.category_name);
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
                    Bitmap cO = ar.cO(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                    if (cO != null) {
                        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                    }
                    com.baidu.tbadk.core.view.y yVar = new com.baidu.tbadk.core.view.y(bitmapDrawable);
                    yVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApplicationContext(), this.WK));
                    spannableString.setSpan(yVar, i2, i2 + 1, 33);
                    i2 += 2;
                }
                if (dVar != null) {
                    spannableString.setSpan(dVar, i2, this.category_name.length() + i2, 33);
                    int length = this.category_name.length() + 1 + i2;
                }
            } else if (dVar != null) {
                spannableString = new SpannableString(String.valueOf(this.category_name) + " " + this.title);
                spannableString.setSpan(dVar, 0, this.category_name.length() + 0, 33);
                int length2 = this.category_name.length() + 1 + 0;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.WS = spannableString;
        }
    }

    public void parser_title() {
        ai(false);
    }

    public void tH() {
        ai(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean tI() {
        return this.threadType == 36;
    }

    public boolean tJ() {
        return this.threadType == 40;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int tK() {
        return this.Xg;
    }

    public void bW(int i) {
        this.Xg = i;
    }

    public int tL() {
        return this.Xq;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || tB()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ah> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ah ahVar = new com.baidu.tbadk.core.util.ah();
                ahVar.imgUrl = medias.get(i2).getPicUrl();
                ahVar.acq = 13;
                arrayList.add(ahVar);
            }
            i = i2 + 1;
        }
        if (this.Xd != null && !StringUtils.isNull(this.Xd.thumbnail_url)) {
            com.baidu.tbadk.core.util.ah ahVar2 = new com.baidu.tbadk.core.util.ah();
            ahVar2.imgUrl = this.Xd.thumbnail_url;
            ahVar2.acq = 13;
            arrayList.add(ahVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ah ahVar3 = new com.baidu.tbadk.core.util.ah();
            ahVar3.imgUrl = this.author.getPortrait();
            ahVar3.acq = 28;
            arrayList.add(ahVar3);
        }
        return arrayList;
    }

    public boolean tM() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return WF;
        }
        if (this.Xd != null) {
            return WH;
        }
        if (tk() != null && getThreadType() == 36 && tk().type.intValue() == 2) {
            return WI;
        }
        if (tk() != null && getThreadType() == 36 && tk().type.intValue() == 1) {
            return WJ;
        }
        if (te() != null && getThreadType() == 41 && tl() == 1 && tC() == 2) {
            return Xw;
        }
        return WG;
    }

    public int tN() {
        return this.Vi;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus tO() {
        return this.Xp;
    }

    public List<TwAnchorProfitItem> sn() {
        return this.VK;
    }

    public void l(ArrayList<i> arrayList) {
        if (this.WY == 1) {
            this.Vi = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vi = 0;
        } else {
            this.Vi = 0;
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && next.rU() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rU().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vi = next.rV();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean tP() {
        return this.threadType == 41;
    }
}

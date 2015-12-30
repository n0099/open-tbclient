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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.n;
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
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class z implements com.baidu.adp.widget.ListView.u, aj {
    public static final BdUniqueId WB = BdUniqueId.gen();
    public static final BdUniqueId WC = BdUniqueId.gen();
    public static final BdUniqueId WD = BdUniqueId.gen();
    public static final BdUniqueId WE = BdUniqueId.gen();
    public static final BdUniqueId WF = BdUniqueId.gen();
    private static HashMap<Point, Integer> Xe = new HashMap<>();
    private SpannableString WP;
    private int WT;
    private int WU;
    private String WV;
    private int WX;
    private VideoInfo WZ;
    private long Xa;
    private LiveCoverStatus Xi;
    private int Xj;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int WG = 1;
    private String WS = null;
    private int Vx = 0;
    private String Xb = "";
    private String Xf = "";
    private String id = null;
    private String tid = null;
    private long WH = 0;
    private String title = null;
    private int reply_num = 0;
    private int WI = 0;
    private int WJ = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int WK = 0;
    private ac WL = new ac();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> WQ = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> WR = new ArrayList<>();
    private int WM = 0;
    private int WN = 0;
    private String WO = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int WW = 0;
    private ArrayList<a> Xd = new ArrayList<>();
    private int Xg = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.o> WY = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Xh = null;
    private int Xc = 0;
    private PollInfo Xk = null;
    private boolean Xl = false;
    private boolean Xm = false;
    private int Xn = 0;
    private boolean Xo = false;
    private int anchorLevel = 0;
    private String category_name = null;

    static {
        Xe.put(new Point(1, 1), Integer.valueOf(n.f.label_frs_lottery_ing));
        Xe.put(new Point(1, 2), Integer.valueOf(n.f.label_frs_lottery_over));
        Xe.put(new Point(1, 3), Integer.valueOf(n.f.label_frs_lottery_off));
        Xe.put(new Point(1, 4), Integer.valueOf(n.f.label_frs_lottery_d));
        Xe.put(new Point(2, 1), Integer.valueOf(n.f.label_frs_activity_shaiing));
        Xe.put(new Point(2, 2), Integer.valueOf(n.f.label_frs_activity_shai_over));
        Xe.put(new Point(2, 3), Integer.valueOf(n.f.label_frs_activity_shai_off));
        Xe.put(new Point(2, 4), Integer.valueOf(n.f.label_frs_activity_shai_d));
    }

    public z() {
        this.WX = 0;
        this.Xj = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Xj = 0;
        this.WX = 0;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int sm() {
        return this.WX;
    }

    public boolean sn() {
        return this.Xo;
    }

    public boolean so() {
        return this.Xl;
    }

    public boolean sp() {
        return this.Xm;
    }

    public void bB(int i) {
        this.Xn = i;
    }

    public int sq() {
        return this.Xn;
    }

    public PollInfo sr() {
        return this.Xk;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Xa;
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

    public void cx(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void p(long j) {
        this.WH = j;
    }

    public long ss() {
        return this.WH;
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

    public void q(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bC(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bD(int i) {
        this.is_good = i;
    }

    public int st() {
        return this.WK;
    }

    public ac su() {
        return this.WL;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String sv() {
        return this.forum_name;
    }

    public void cy(String str) {
        this.forum_name = str;
    }

    public int sw() {
        return this.WN;
    }

    public String sx() {
        return this.WO;
    }

    public String sy() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String sz() {
        return this.WS;
    }

    public void cz(String str) {
        this.WS = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.WQ;
    }

    public ArrayList<a> sA() {
        return this.Xd;
    }

    public void j(ArrayList<a> arrayList) {
        this.Xd = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> sB() {
        return this.WR;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sC() {
        return this.WU;
    }

    public String getAddress() {
        return this.address;
    }

    public String sD() {
        return this.Xb;
    }

    public VideoInfo sE() {
        return this.WZ;
    }

    public String getPhotoLiveCover() {
        return this.Xf;
    }

    public void setPhotoLiveCover(String str) {
        this.Xf = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.o> sF() {
        return this.WY;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        this.WY.clear();
        this.WY.addAll(arrayList);
    }

    public String getNotice() {
        return this.Xh;
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
                    this.WV = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.WH = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Xa = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.WI = threadInfo.repost_num.intValue();
                this.WJ = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.WK = threadInfo.is_livepost.intValue();
                this.WL.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.WM = threadInfo.has_commented.intValue();
                this.WN = threadInfo.show_commented.intValue();
                this.WO = threadInfo.click_url;
                this.WZ = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.WS = threadInfo.collect_mark_pid;
                this.WT = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Xb = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.WU = threadInfo.is_ntitle.intValue();
                this.WW = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.WX = threadInfo.operator_flag.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
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
                        this.WQ.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.WZ = threadInfo.video_info;
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
                        this.WR.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Xd.add(aVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
                this.Xf = threadInfo.livecover_src;
                this.Xg = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Xc = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                                oVar.dM(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                oVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                oVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.WY.add(oVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Xh = noticeInfo.notice;
                    }
                    this.Xn = zhiBoInfoTW.copythread_remind.intValue();
                    this.Xl = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Xm = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (!StringUtils.isNull(zhiBoInfoTW.livecover_src)) {
                        this.Xf = zhiBoInfoTW.livecover_src;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Xi = threadInfo.twzhibo_info.livecover_status;
                    this.Xj = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Xk = threadInfo.poll_info;
                this.Xo = threadInfo.is_copythread.intValue() == 1;
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
                this.Xa = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.WI = jSONObject.optInt("repost_num", 0);
                this.WJ = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.WK = jSONObject.optInt("is_livepost", 0);
                this.WL.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.WM = jSONObject.optInt("has_commented", 0);
                this.WN = jSONObject.optInt("show_commented", 0);
                this.WO = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.WS = jSONObject.optString("collect_mark_pid");
                this.WT = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt(PbActivityConfig.KEY_THREAD_TYPE);
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.Xb = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.WU = jSONObject.optInt("is_ntitle");
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
                        this.WQ.add(mediaData);
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
                        this.WR.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Xd.add(aVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString getSpan_str() {
        return this.WP;
    }

    public boolean sG() {
        return getIs_top() != 0;
    }

    public int sH() {
        if (sJ() && this.Xd.size() >= 1) {
            a aVar = this.Xd.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int rh = aVar.rh();
            int ri = aVar.ri();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < rh) {
                return 4;
            }
            return currentTimeMillis > ri ? 2 : 1;
        }
        return -1;
    }

    public int sI() {
        if (!sJ() || this.Xd.size() < 1 || this.Xd.get(0) == null) {
            return -1;
        }
        return this.Xd.get(0).rg();
    }

    public boolean sJ() {
        return this.WW == 1;
    }

    public String sK() {
        return (!sJ() || this.Xd.size() < 1 || this.Xd.get(0) == null) ? "" : this.Xd.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cA(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m411getInst().getApplicationContext()).inflate(n.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(n.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m411getInst().getApplicationContext().getResources().getColor(n.d.cp_cont_f_1));
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

    private void ah(boolean z) {
        com.baidu.adp.widget.d dVar;
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(n.f.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(n.f.icon_notice));
            }
            if (st() == 1 || this.WL.sZ() != 0) {
                arrayList.add(Integer.valueOf(n.f.icon_zhibo));
            }
            if (getIs_good() == 1 && !sG()) {
                arrayList.add(Integer.valueOf(n.f.icon_elite));
            }
            if (getType() == WE || getType() == WF) {
                arrayList.add(Integer.valueOf(n.f.icon_vote_blue));
            }
            if (this.WT == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(n.f.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(n.f.icon_live_on));
            }
            if (sw() == 1) {
                arrayList.add(Integer.valueOf(n.f.frs_post_ding));
            }
            if (z) {
                if (getThreadType() == 40) {
                    arrayList.add(Integer.valueOf(n.f.icon_thread_video));
                }
            } else if (this.WZ != null) {
                arrayList.add(Integer.valueOf(n.f.icon_thread_video));
            }
            if (z) {
                Integer num = Xe.get(new Point(sI(), sH()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (sI() == 1) {
                arrayList.add(Integer.valueOf(n.f.label_frs_lottery));
            } else if (sI() == 2) {
                arrayList.add(Integer.valueOf(n.f.label_frs_activity_shai));
            }
            if (com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = null;
            } else {
                dVar = cA(this.category_name);
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
                    Bitmap cx = as.cx(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
                    if (cx != null) {
                        bitmapDrawable.setBounds(0, 0, cx.getWidth(), cx.getHeight());
                    }
                    com.baidu.tbadk.core.view.y yVar = new com.baidu.tbadk.core.view.y(bitmapDrawable);
                    yVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApplicationContext(), this.WG));
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
            this.WP = spannableString;
        }
    }

    public void parser_title() {
        ah(false);
    }

    public void sL() {
        ah(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sM() {
        return this.threadType == 36;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sN() {
        return this.Xc;
    }

    public void bE(int i) {
        this.Xc = i;
    }

    public int sO() {
        return this.Xj;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || sG()) {
            return null;
        }
        ArrayList<ai> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                ai aiVar = new ai();
                aiVar.Xp = medias.get(i2).getPicUrl();
                aiVar.abU = 13;
                arrayList.add(aiVar);
            }
            i = i2 + 1;
        }
        if (this.WZ != null && !StringUtils.isNull(this.WZ.thumbnail_url)) {
            ai aiVar2 = new ai();
            aiVar2.Xp = this.WZ.thumbnail_url;
            aiVar2.abU = 13;
            arrayList.add(aiVar2);
        }
        if (this.author != null) {
            ai aiVar3 = new ai();
            aiVar3.Xp = this.author.getPortrait();
            aiVar3.abU = 28;
            arrayList.add(aiVar3);
        }
        return arrayList;
    }

    public boolean sP() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return WB;
        }
        if (this.WZ != null) {
            return WD;
        }
        if (sr() != null && getThreadType() == 36 && sr().type.intValue() == 2) {
            return WE;
        }
        if (sr() != null && getThreadType() == 36 && sr().type.intValue() == 1) {
            return WF;
        }
        return WC;
    }

    public int sQ() {
        return this.Vx;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sR() {
        return this.Xi;
    }

    public void k(ArrayList<g> arrayList) {
        if (this.WU == 1) {
            this.Vx = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Vx = 0;
        } else {
            this.Vx = 0;
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && next.rq() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rq().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Vx = next.rr();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

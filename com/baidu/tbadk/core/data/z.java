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
    private LiveCoverStatus WH;
    private int WI;
    private SpannableString Wo;
    private int Ws;
    private int Wt;
    private String Wu;
    private int Ww;
    private VideoInfo Wy;
    private long Wz;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Wb = BdUniqueId.gen();
    public static final BdUniqueId Wc = BdUniqueId.gen();
    public static final BdUniqueId Wd = BdUniqueId.gen();
    public static final BdUniqueId We = BdUniqueId.gen();
    public static final BdUniqueId Wf = BdUniqueId.gen();
    private static HashMap<Point, Integer> WD = new HashMap<>();
    private String Wr = null;
    private int UX = 0;
    private String WA = "";
    private String WE = "";
    private String id = null;
    private String tid = null;
    private long Wg = 0;
    private String title = null;
    private int reply_num = 0;
    private int Wh = 0;
    private int Wi = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Wj = 0;
    private ac Wk = new ac();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Wp = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Wq = new ArrayList<>();
    private int Wl = 0;
    private int Wm = 0;
    private String Wn = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int Wv = 0;
    private ArrayList<a> WC = new ArrayList<>();
    private int WF = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.o> Wx = new ArrayList<>();
    private boolean isHeadLive = false;
    private String WG = null;
    private int WB = 0;
    private PollInfo WJ = null;
    private boolean WK = false;
    private int WL = 0;
    private boolean WM = false;
    private int anchorLevel = 0;
    private String category_name = null;

    static {
        WD.put(new Point(1, 1), Integer.valueOf(n.e.label_frs_lottery_ing));
        WD.put(new Point(1, 2), Integer.valueOf(n.e.label_frs_lottery_over));
        WD.put(new Point(1, 3), Integer.valueOf(n.e.label_frs_lottery_off));
        WD.put(new Point(1, 4), Integer.valueOf(n.e.label_frs_lottery_d));
        WD.put(new Point(2, 1), Integer.valueOf(n.e.label_frs_activity_shaiing));
        WD.put(new Point(2, 2), Integer.valueOf(n.e.label_frs_activity_shai_over));
        WD.put(new Point(2, 3), Integer.valueOf(n.e.label_frs_activity_shai_off));
        WD.put(new Point(2, 4), Integer.valueOf(n.e.label_frs_activity_shai_d));
    }

    public z() {
        this.Ww = 0;
        this.WI = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.WI = 0;
        this.Ww = 0;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public int sD() {
        return this.Ww;
    }

    public boolean sE() {
        return this.WM;
    }

    public boolean sF() {
        return this.WK;
    }

    public void bI(int i) {
        this.WL = i;
    }

    public int sG() {
        return this.WL;
    }

    public PollInfo sH() {
        return this.WJ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Wz;
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

    public void p(long j) {
        this.Wg = j;
    }

    public long sI() {
        return this.Wg;
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

    public void bJ(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bK(int i) {
        this.is_good = i;
    }

    public int sJ() {
        return this.Wj;
    }

    public ac sK() {
        return this.Wk;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String sL() {
        return this.forum_name;
    }

    public void cv(String str) {
        this.forum_name = str;
    }

    public int sM() {
        return this.Wm;
    }

    public String sN() {
        return this.Wn;
    }

    public String sO() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String sP() {
        return this.Wr;
    }

    public void cw(String str) {
        this.Wr = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Wp;
    }

    public ArrayList<a> sQ() {
        return this.WC;
    }

    public void j(ArrayList<a> arrayList) {
        this.WC = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> sR() {
        return this.Wq;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sS() {
        return this.Wt;
    }

    public String getAddress() {
        return this.address;
    }

    public String sT() {
        return this.WA;
    }

    public VideoInfo sU() {
        return this.Wy;
    }

    public String getPhotoLiveCover() {
        return this.WE;
    }

    public void setPhotoLiveCover(String str) {
        this.WE = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.o> sV() {
        return this.Wx;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        this.Wx.clear();
        this.Wx.addAll(arrayList);
    }

    public String getNotice() {
        return this.WG;
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
                    this.Wu = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.Wg = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Wz = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Wh = threadInfo.repost_num.intValue();
                this.Wi = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Wj = threadInfo.is_livepost.intValue();
                this.Wk.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Wl = threadInfo.has_commented.intValue();
                this.Wm = threadInfo.show_commented.intValue();
                this.Wn = threadInfo.click_url;
                this.Wy = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Wr = threadInfo.collect_mark_pid;
                this.Ws = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.WA = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Wt = threadInfo.is_ntitle.intValue();
                this.Wv = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Ww = threadInfo.operator_flag.intValue();
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
                        this.Wp.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Wy = threadInfo.video_info;
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
                        this.Wq.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.WC.add(aVar);
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
                this.WE = threadInfo.livecover_src;
                this.WF = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.WB = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                                oVar.dS(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                oVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                oVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Wx.add(oVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.WG = noticeInfo.notice;
                    }
                    this.WL = zhiBoInfoTW.copythread_remind.intValue();
                    this.WK = zhiBoInfoTW.is_copytwzhibo.intValue() == 1;
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.WH = threadInfo.twzhibo_info.livecover_status;
                    this.WI = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.WJ = threadInfo.poll_info;
                this.WM = threadInfo.is_copythread.intValue() == 1;
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
                this.Wz = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Wh = jSONObject.optInt("repost_num", 0);
                this.Wi = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Wj = jSONObject.optInt("is_livepost", 0);
                this.Wk.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Wl = jSONObject.optInt("has_commented", 0);
                this.Wm = jSONObject.optInt("show_commented", 0);
                this.Wn = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Wr = jSONObject.optString("collect_mark_pid");
                this.Ws = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.WA = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Wt = jSONObject.optInt("is_ntitle");
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
                        this.Wp.add(mediaData);
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
                        this.Wq.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.WC.add(aVar);
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
        return this.Wo;
    }

    public boolean sW() {
        return getIs_top() != 0;
    }

    public int sX() {
        if (sZ() && this.WC.size() >= 1) {
            a aVar = this.WC.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int ry = aVar.ry();
            int rz = aVar.rz();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < ry) {
                return 4;
            }
            return currentTimeMillis > rz ? 2 : 1;
        }
        return -1;
    }

    public int sY() {
        if (!sZ() || this.WC.size() < 1 || this.WC.get(0) == null) {
            return -1;
        }
        return this.WC.get(0).rx();
    }

    public boolean sZ() {
        return this.Wv == 1;
    }

    public String ta() {
        return (!sZ() || this.WC.size() < 1 || this.WC.get(0) == null) ? "" : this.WC.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cx(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m411getInst().getApplicationContext()).inflate(n.g.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(n.f.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m411getInst().getApplicationContext().getResources().getColor(n.c.cp_cont_f_1));
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
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(n.e.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(n.e.icon_notice));
            }
            if (sJ() == 1 || this.Wk.tp() != 0) {
                arrayList.add(Integer.valueOf(n.e.icon_zhibo));
            }
            if (getIs_good() == 1 && !sW()) {
                arrayList.add(Integer.valueOf(n.e.icon_elite));
            }
            if (getType() == We || getType() == Wf) {
                arrayList.add(Integer.valueOf(n.e.icon_vote_blue));
            }
            if (this.Ws == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(n.e.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(n.e.icon_live_on));
            }
            if (sM() == 1) {
                arrayList.add(Integer.valueOf(n.e.frs_post_ding));
            }
            if (z) {
                if (getThreadType() == 40) {
                    arrayList.add(Integer.valueOf(n.e.icon_thread_video));
                }
            } else if (this.Wy != null) {
                arrayList.add(Integer.valueOf(n.e.icon_thread_video));
            }
            if (z) {
                Integer num = WD.get(new Point(sY(), sX()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (sY() == 1) {
                arrayList.add(Integer.valueOf(n.e.label_frs_lottery));
            } else if (sY() == 2) {
                arrayList.add(Integer.valueOf(n.e.label_frs_activity_shai));
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
                    Bitmap cE = as.cE(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
                    if (cE != null) {
                        bitmapDrawable.setBounds(0, 0, cE.getWidth(), cE.getHeight());
                    }
                    com.baidu.adp.widget.d dVar2 = new com.baidu.adp.widget.d(bitmapDrawable, 1);
                    dVar2.setOffset(2);
                    spannableString.setSpan(dVar2, i2, i2 + 1, 33);
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
            this.Wo = spannableString;
        }
    }

    public void parser_title() {
        ak(false);
    }

    public void tb() {
        ak(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean tc() {
        return this.threadType == 36;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int td() {
        return this.WB;
    }

    public void bL(int i) {
        this.WB = i;
    }

    public int te() {
        return this.WI;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<ai> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || sW()) {
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
                aiVar.WN = medias.get(i2).getPicUrl();
                aiVar.abp = 13;
                arrayList.add(aiVar);
            }
            i = i2 + 1;
        }
        if (this.Wy != null && !StringUtils.isNull(this.Wy.thumbnail_url)) {
            ai aiVar2 = new ai();
            aiVar2.WN = this.Wy.thumbnail_url;
            aiVar2.abp = 13;
            arrayList.add(aiVar2);
        }
        if (this.author != null) {
            ai aiVar3 = new ai();
            aiVar3.WN = this.author.getPortrait();
            aiVar3.abp = 28;
            arrayList.add(aiVar3);
        }
        return arrayList;
    }

    public boolean tf() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return Wb;
        }
        if (this.Wy != null) {
            return Wd;
        }
        if (sH() != null && getThreadType() == 36 && sH().type.intValue() == 2) {
            return We;
        }
        if (sH() != null && getThreadType() == 36 && sH().type.intValue() == 1) {
            return Wf;
        }
        return Wc;
    }

    public int tg() {
        return this.UX;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus th() {
        return this.WH;
    }

    public void k(ArrayList<g> arrayList) {
        if (this.Wt == 1) {
            this.UX = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.UX = 0;
        } else {
            this.UX = 0;
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && next.rH() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rH().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.UX = next.rI();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

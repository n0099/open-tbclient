package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import com.baidu.tieba.mention.FeedData;
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
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class v implements com.baidu.adp.widget.ListView.u, ae {
    private SpannableString VD;
    private MediaData VG;
    private int VI;
    private int VJ;
    private String VK;
    private long VN;
    private LiveCoverStatus VV;
    private int VW;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Vr = BdUniqueId.gen();
    public static final BdUniqueId Vs = BdUniqueId.gen();
    public static final BdUniqueId Vt = BdUniqueId.gen();
    public static final BdUniqueId Vu = BdUniqueId.gen();
    public static final BdUniqueId Vv = BdUniqueId.gen();
    private static HashMap<Point, Integer> VR = new HashMap<>();
    private String VH = null;
    private int UD = 0;
    private String VO = "";
    private String VS = "";
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int Vw = 0;
    private int Vx = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Vy = 0;
    private y Vz = new y();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> VE = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> VF = new ArrayList<>();
    private int VA = 0;
    private int VB = 0;
    private String VC = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int VL = 0;
    private ArrayList<a> VQ = new ArrayList<>();
    private int VT = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.o> VM = new ArrayList<>();
    private boolean isHeadLive = false;
    private String VU = null;
    private int VP = 0;
    private PollInfo VX = null;

    static {
        VR.put(new Point(1, 1), Integer.valueOf(i.e.label_frs_lottery_ing));
        VR.put(new Point(1, 2), Integer.valueOf(i.e.label_frs_lottery_over));
        VR.put(new Point(1, 3), Integer.valueOf(i.e.label_frs_lottery_off));
        VR.put(new Point(1, 4), Integer.valueOf(i.e.label_frs_lottery_d));
        VR.put(new Point(2, 1), Integer.valueOf(i.e.label_frs_activity_shaiing));
        VR.put(new Point(2, 2), Integer.valueOf(i.e.label_frs_activity_shai_over));
        VR.put(new Point(2, 3), Integer.valueOf(i.e.label_frs_activity_shai_off));
        VR.put(new Point(2, 4), Integer.valueOf(i.e.label_frs_activity_shai_d));
    }

    public v() {
        this.VW = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.VW = 0;
    }

    public PollInfo sg() {
        return this.VX;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.VN;
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

    public void cm(String str) {
        this.tid = str;
    }

    public String getTid() {
        return this.tid;
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

    public void m(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bA(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bB(int i) {
        this.is_good = i;
    }

    public int sh() {
        return this.Vy;
    }

    public y si() {
        return this.Vz;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String sj() {
        return this.forum_name;
    }

    public void cn(String str) {
        this.forum_name = str;
    }

    public int sk() {
        return this.VB;
    }

    public String sl() {
        return this.VC;
    }

    public String sm() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String sn() {
        return this.VH;
    }

    public void co(String str) {
        this.VH = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.VE;
    }

    public ArrayList<a> so() {
        return this.VQ;
    }

    public void i(ArrayList<a> arrayList) {
        this.VQ = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> sp() {
        return this.VF;
    }

    public int sq() {
        return this.threadType;
    }

    public void bC(int i) {
        this.threadType = i;
    }

    public int sr() {
        return this.VJ;
    }

    public String getAddress() {
        return this.address;
    }

    public String ss() {
        return this.VO;
    }

    public MediaData st() {
        return this.VG;
    }

    public String getPhotoLiveCover() {
        return this.VS;
    }

    public void setPhotoLiveCover(String str) {
        this.VS = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.o> su() {
        return this.VM;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        this.VM.clear();
        this.VM.addAll(arrayList);
    }

    public String getNotice() {
        return this.VU;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0022: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0033: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00dd: IGET  (r3v7 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00ee: IGET  (r3v8 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.VK = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.VN = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Vw = threadInfo.repost_num.intValue();
                this.Vx = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Vy = threadInfo.is_livepost.intValue();
                this.Vz.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.VA = threadInfo.has_commented.intValue();
                this.VB = threadInfo.show_commented.intValue();
                this.VC = threadInfo.click_url;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.VH = threadInfo.collect_mark_pid;
                this.VI = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.VO = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.VJ = threadInfo.is_ntitle.intValue();
                this.VL = threadInfo.is_activity.intValue();
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
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list2.size()) {
                            break;
                        }
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        if (mediaData.isXiaoying()) {
                            this.VG = mediaData;
                            break;
                        } else {
                            this.VE.add(mediaData);
                            i2++;
                        }
                    }
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
                        this.VF.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.VQ.add(aVar);
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
                this.VS = threadInfo.livecover_src;
                this.VT = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.VP = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.o oVar = new com.baidu.tbadk.coreExtra.view.o();
                                oVar.dD(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                oVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                oVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.VM.add(oVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.VU = noticeInfo.notice;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.VV = threadInfo.twzhibo_info.livecover_status;
                    this.VW = threadInfo.twzhibo_info.freq_num.intValue();
                }
                this.VX = threadInfo.poll_info;
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
                this.VN = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Vw = jSONObject.optInt("repost_num", 0);
                this.Vx = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Vy = jSONObject.optInt("is_livepost", 0);
                this.Vz.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.VA = jSONObject.optInt("has_commented", 0);
                this.VB = jSONObject.optInt("show_commented", 0);
                this.VC = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.VH = jSONObject.optString("collect_mark_pid");
                this.VI = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.VO = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.VJ = jSONObject.optInt("is_ntitle");
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
                        this.VE.add(mediaData);
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
                        this.VF.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.VQ.add(aVar);
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
        return this.VD;
    }

    public boolean sv() {
        return getIs_top() != 0;
    }

    public int sw() {
        if (sy() && this.VQ.size() >= 1) {
            a aVar = this.VQ.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int rm = aVar.rm();
            int rn = aVar.rn();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < rm) {
                return 4;
            }
            return currentTimeMillis > rn ? 2 : 1;
        }
        return -1;
    }

    public int sx() {
        if (!sy() || this.VQ.size() < 1 || this.VQ.get(0) == null) {
            return -1;
        }
        return this.VQ.get(0).rl();
    }

    public boolean sy() {
        return this.VL == 1;
    }

    public String sz() {
        return (!sy() || this.VQ.size() < 1 || this.VQ.get(0) == null) ? "" : this.VQ.get(0).getUrl();
    }

    private void ai(boolean z) {
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(i.e.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(i.e.icon_notice));
            }
            if (sh() == 1 || this.Vz.sL() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_zhibo));
            }
            if (getIs_good() == 1 && !sv()) {
                arrayList.add(Integer.valueOf(i.e.icon_elite));
            }
            if (getType() == Vu || getType() == Vv) {
                arrayList.add(Integer.valueOf(i.e.icon_vote_blue));
            }
            if (this.VI == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(i.e.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_live_on));
            }
            if (sk() == 1) {
                arrayList.add(Integer.valueOf(i.e.frs_post_ding));
            }
            if (z) {
                Integer num = VR.get(new Point(sx(), sw()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (sx() == 1) {
                arrayList.add(Integer.valueOf(i.e.label_frs_lottery));
            } else if (sx() == 2) {
                arrayList.add(Integer.valueOf(i.e.label_frs_activity_shai));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.title);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap cw = am.cw(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
                    if (cw != null) {
                        bitmapDrawable.setBounds(0, 0, cw.getWidth(), cw.getHeight());
                    }
                    com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(bitmapDrawable, 1);
                    dVar.setOffset(2);
                    spannableString2.setSpan(dVar, i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.VD = spannableString;
        }
    }

    public void parser_title() {
        ai(false);
    }

    public void sA() {
        ai(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sB() {
        return this.threadType == 36;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sC() {
        return this.VP;
    }

    public void bD(int i) {
        this.VP = i;
    }

    public int sD() {
        return this.VW;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || sv()) {
            return null;
        }
        ArrayList<ad> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                ad adVar = new ad();
                adVar.VY = medias.get(i2).getPicUrl();
                adVar.aax = 13;
                arrayList.add(adVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            ad adVar2 = new ad();
            adVar2.VY = this.author.getPortrait();
            adVar2.aax = 28;
            arrayList.add(adVar2);
        }
        return arrayList;
    }

    public boolean sE() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return Vr;
        }
        if (this.VG != null) {
            return Vt;
        }
        if (sg() != null && sq() == 36 && sg().type.intValue() == 2) {
            return Vu;
        }
        if (sg() != null && sq() == 36 && sg().type.intValue() == 1) {
            return Vv;
        }
        return Vs;
    }

    public int sF() {
        return this.UD;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sG() {
        return this.VV;
    }

    public void j(ArrayList<f> arrayList) {
        if (this.VJ == 1) {
            this.UD = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.UD = 0;
        } else {
            this.UD = 0;
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null && next.rv() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rv().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.UD = next.rw();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.an;
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
public class w implements com.baidu.adp.widget.ListView.u, ae {
    private SpannableString VF;
    private MediaData VI;
    private int VK;
    private int VL;
    private String VM;
    private long VP;
    private LiveCoverStatus VX;
    private int VY;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Vt = BdUniqueId.gen();
    public static final BdUniqueId Vu = BdUniqueId.gen();
    public static final BdUniqueId Vv = BdUniqueId.gen();
    public static final BdUniqueId Vw = BdUniqueId.gen();
    public static final BdUniqueId Vx = BdUniqueId.gen();
    private static HashMap<Point, Integer> VT = new HashMap<>();
    private String VJ = null;
    private int UF = 0;
    private String VQ = "";
    private String VU = "";
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int Vy = 0;
    private int Vz = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int VA = 0;
    private z VB = new z();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> VG = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> VH = new ArrayList<>();
    private int VC = 0;
    private int VD = 0;
    private String VE = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int VN = 0;
    private ArrayList<a> VS = new ArrayList<>();
    private int VV = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.o> VO = new ArrayList<>();
    private boolean isHeadLive = false;
    private String VW = null;
    private int VR = 0;
    private PollInfo VZ = null;

    static {
        VT.put(new Point(1, 1), Integer.valueOf(i.e.label_frs_lottery_ing));
        VT.put(new Point(1, 2), Integer.valueOf(i.e.label_frs_lottery_over));
        VT.put(new Point(1, 3), Integer.valueOf(i.e.label_frs_lottery_off));
        VT.put(new Point(1, 4), Integer.valueOf(i.e.label_frs_lottery_d));
        VT.put(new Point(2, 1), Integer.valueOf(i.e.label_frs_activity_shaiing));
        VT.put(new Point(2, 2), Integer.valueOf(i.e.label_frs_activity_shai_over));
        VT.put(new Point(2, 3), Integer.valueOf(i.e.label_frs_activity_shai_off));
        VT.put(new Point(2, 4), Integer.valueOf(i.e.label_frs_activity_shai_d));
    }

    public w() {
        this.VY = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.VY = 0;
    }

    public PollInfo sd() {
        return this.VZ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.VP;
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

    public void cn(String str) {
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

    public void k(long j) {
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

    public int se() {
        return this.VA;
    }

    public z sf() {
        return this.VB;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String sg() {
        return this.forum_name;
    }

    public void co(String str) {
        this.forum_name = str;
    }

    public int sh() {
        return this.VD;
    }

    public String si() {
        return this.VE;
    }

    public String sj() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String sk() {
        return this.VJ;
    }

    public void cp(String str) {
        this.VJ = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.VG;
    }

    public ArrayList<a> sl() {
        return this.VS;
    }

    public void i(ArrayList<a> arrayList) {
        this.VS = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> sm() {
        return this.VH;
    }

    public int sn() {
        return this.threadType;
    }

    public void bC(int i) {
        this.threadType = i;
    }

    public int so() {
        return this.VL;
    }

    public String getAddress() {
        return this.address;
    }

    public String sp() {
        return this.VQ;
    }

    public MediaData sq() {
        return this.VI;
    }

    public String getPhotoLiveCover() {
        return this.VU;
    }

    public void setPhotoLiveCover(String str) {
        this.VU = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.o> sr() {
        return this.VO;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.o> arrayList) {
        this.VO.clear();
        this.VO.addAll(arrayList);
    }

    public String getNotice() {
        return this.VW;
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
                    this.VM = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.VP = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Vy = threadInfo.repost_num.intValue();
                this.Vz = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.VA = threadInfo.is_livepost.intValue();
                this.VB.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.VC = threadInfo.has_commented.intValue();
                this.VD = threadInfo.show_commented.intValue();
                this.VE = threadInfo.click_url;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.VJ = threadInfo.collect_mark_pid;
                this.VK = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.VQ = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.VL = threadInfo.is_ntitle.intValue();
                this.VN = threadInfo.is_activity.intValue();
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
                            this.VI = mediaData;
                            break;
                        } else {
                            this.VG.add(mediaData);
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
                        this.VH.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.VS.add(aVar);
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
                this.VU = threadInfo.livecover_src;
                this.VV = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.VR = threadInfo.post_num.intValue();
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
                                this.VO.add(oVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.VW = noticeInfo.notice;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.VX = threadInfo.twzhibo_info.livecover_status;
                    this.VY = threadInfo.twzhibo_info.freq_num.intValue();
                }
                this.VZ = threadInfo.poll_info;
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
                this.VP = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Vy = jSONObject.optInt("repost_num", 0);
                this.Vz = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.VA = jSONObject.optInt("is_livepost", 0);
                this.VB.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.VC = jSONObject.optInt("has_commented", 0);
                this.VD = jSONObject.optInt("show_commented", 0);
                this.VE = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.VJ = jSONObject.optString("collect_mark_pid");
                this.VK = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.VQ = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.VL = jSONObject.optInt("is_ntitle");
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
                        this.VG.add(mediaData);
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
                        this.VH.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.VS.add(aVar);
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
        return this.VF;
    }

    public boolean ss() {
        return getIs_top() != 0;
    }

    public int st() {
        if (sv() && this.VS.size() >= 1) {
            a aVar = this.VS.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int rj = aVar.rj();
            int rk = aVar.rk();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < rj) {
                return 4;
            }
            return currentTimeMillis > rk ? 2 : 1;
        }
        return -1;
    }

    public int su() {
        if (!sv() || this.VS.size() < 1 || this.VS.get(0) == null) {
            return -1;
        }
        return this.VS.get(0).ri();
    }

    public boolean sv() {
        return this.VN == 1;
    }

    public String sw() {
        return (!sv() || this.VS.size() < 1 || this.VS.get(0) == null) ? "" : this.VS.get(0).getUrl();
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
            if (se() == 1 || this.VB.sI() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_zhibo));
            }
            if (getIs_good() == 1 && !ss()) {
                arrayList.add(Integer.valueOf(i.e.icon_elite));
            }
            if (getType() == Vw || getType() == Vx) {
                arrayList.add(Integer.valueOf(i.e.icon_vote_blue));
            }
            if (this.VK == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(i.e.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_live_on));
            }
            if (sh() == 1) {
                arrayList.add(Integer.valueOf(i.e.frs_post_ding));
            }
            if (z) {
                Integer num = VT.get(new Point(su(), st()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (su() == 1) {
                arrayList.add(Integer.valueOf(i.e.label_frs_lottery));
            } else if (su() == 2) {
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
                    Bitmap cw = an.cw(((Integer) arrayList.get(i3)).intValue());
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
            this.VF = spannableString;
        }
    }

    public void parser_title() {
        ai(false);
    }

    public void sx() {
        ai(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sy() {
        return this.threadType == 36;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sz() {
        return this.VR;
    }

    public void bD(int i) {
        this.VR = i;
    }

    public int sA() {
        return this.VY;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || ss()) {
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
                adVar.Wa = medias.get(i2).getPicUrl();
                adVar.aaz = 13;
                arrayList.add(adVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            ad adVar2 = new ad();
            adVar2.Wa = this.author.getPortrait();
            adVar2.aaz = 28;
            arrayList.add(adVar2);
        }
        return arrayList;
    }

    public boolean sB() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return Vt;
        }
        if (this.VI != null) {
            return Vv;
        }
        if (sd() != null && sn() == 36 && sd().type.intValue() == 2) {
            return Vw;
        }
        if (sd() != null && sn() == 36 && sd().type.intValue() == 1) {
            return Vx;
        }
        return Vu;
    }

    public int sC() {
        return this.UF;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sD() {
        return this.VX;
    }

    public void j(ArrayList<g> arrayList) {
        if (this.VL == 1) {
            this.UF = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.UF = 0;
        } else {
            this.UF = 0;
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && next.rs() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rs().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.UF = next.rt();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.al;
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
import tbclient.ThreadInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class x implements com.baidu.adp.widget.ListView.u, ad {
    public static final BdUniqueId VD = BdUniqueId.gen();
    public static final BdUniqueId VE = BdUniqueId.gen();
    public static final BdUniqueId VF = BdUniqueId.gen();
    private static HashMap<Point, Integer> Wb = new HashMap<>();
    private SpannableString VN;
    private MediaData VQ;
    private int VS;
    private int VT;
    private String VU;
    private long VX;
    private String We;
    private LiveCoverStatus Wf;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    private String VR = null;
    private int UO = 0;
    private String VY = "";
    private String Wc = "";
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int VG = 0;
    private int VH = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int VI = 0;
    private aa VJ = new aa();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> VO = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> VP = new ArrayList<>();
    private int VK = 0;
    private int VL = 0;
    private String VM = null;
    private String abstract_text = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int VV = 0;
    private ArrayList<b> Wa = new ArrayList<>();
    private int Wd = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.p> VW = new ArrayList<>();
    private boolean isHeadLive = false;
    private int VZ = 0;

    static {
        Wb.put(new Point(1, 1), Integer.valueOf(i.e.label_frs_lottery_ing));
        Wb.put(new Point(1, 2), Integer.valueOf(i.e.label_frs_lottery_over));
        Wb.put(new Point(1, 3), Integer.valueOf(i.e.label_frs_lottery_off));
        Wb.put(new Point(1, 4), Integer.valueOf(i.e.label_frs_lottery_d));
        Wb.put(new Point(2, 1), Integer.valueOf(i.e.label_frs_activity_shaiing));
        Wb.put(new Point(2, 2), Integer.valueOf(i.e.label_frs_activity_shai_over));
        Wb.put(new Point(2, 3), Integer.valueOf(i.e.label_frs_activity_shai_off));
        Wb.put(new Point(2, 4), Integer.valueOf(i.e.label_frs_activity_shai_d));
    }

    public x() {
        this.post_num = 0;
        this.We = null;
        this.post_num = 0;
        this.We = null;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.VX;
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

    public int sm() {
        return this.VI;
    }

    public aa sn() {
        return this.VJ;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String so() {
        return this.forum_name;
    }

    public void cn(String str) {
        this.forum_name = str;
    }

    public int sp() {
        return this.VL;
    }

    public String sq() {
        return this.VM;
    }

    public String sr() {
        return this.abstract_text;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String ss() {
        return this.VR;
    }

    public void co(String str) {
        this.VR = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.VO;
    }

    public ArrayList<b> st() {
        return this.Wa;
    }

    public void i(ArrayList<b> arrayList) {
        this.Wa = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> su() {
        return this.VP;
    }

    public int sv() {
        return this.threadType;
    }

    public void bC(int i) {
        this.threadType = i;
    }

    public int sw() {
        return this.VT;
    }

    public String getAddress() {
        return this.address;
    }

    public String sx() {
        return this.VY;
    }

    public MediaData sy() {
        return this.VQ;
    }

    public String getPhotoLiveCover() {
        return this.Wc;
    }

    public void setPhotoLiveCover(String str) {
        this.Wc = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.p> sz() {
        return this.VW;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.p> arrayList) {
        this.VW.clear();
        this.VW.addAll(arrayList);
    }

    public String getNotice() {
        return this.We;
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
                    this.VU = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.VX = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.VG = threadInfo.repost_num.intValue();
                this.VH = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.VI = threadInfo.is_livepost.intValue();
                this.VJ.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.VK = threadInfo.has_commented.intValue();
                this.VL = threadInfo.show_commented.intValue();
                this.VM = threadInfo.click_url;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.VR = threadInfo.collect_mark_pid;
                this.VS = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.VY = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.VT = threadInfo.is_ntitle.intValue();
                this.VV = threadInfo.is_activity.intValue();
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
                            this.VQ = mediaData;
                            break;
                        } else {
                            this.VO.add(mediaData);
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
                        this.VP.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.Wa.add(bVar);
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
                this.Wc = threadInfo.livecover_src;
                this.Wd = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.VZ = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.p pVar = new com.baidu.tbadk.coreExtra.view.p();
                                pVar.dC(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                pVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                pVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.VW.add(pVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.We = noticeInfo.notice;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Wf = threadInfo.twzhibo_info.livecover_status;
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
                this.VX = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.VG = jSONObject.optInt("repost_num", 0);
                this.VH = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.VI = jSONObject.optInt("is_livepost", 0);
                this.VJ.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.VK = jSONObject.optInt("has_commented", 0);
                this.VL = jSONObject.optInt("show_commented", 0);
                this.VM = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.VR = jSONObject.optString("collect_mark_pid");
                this.VS = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.VY = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.VT = jSONObject.optInt("is_ntitle");
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
                        this.VO.add(mediaData);
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
                        this.VP.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Wa.add(bVar);
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
        return this.VN;
    }

    public boolean sA() {
        return getIs_top() != 0;
    }

    public int sB() {
        if (sD() && this.Wa.size() >= 1) {
            b bVar = this.Wa.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int rr = bVar.rr();
            int rs = bVar.rs();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < rr) {
                return 4;
            }
            return currentTimeMillis > rs ? 2 : 1;
        }
        return -1;
    }

    public int sC() {
        if (!sD() || this.Wa.size() < 1 || this.Wa.get(0) == null) {
            return -1;
        }
        return this.Wa.get(0).rq();
    }

    public boolean sD() {
        return this.VV == 1;
    }

    public String sE() {
        return (!sD() || this.Wa.size() < 1 || this.Wa.get(0) == null) ? "" : this.Wa.get(0).getUrl();
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
            if (sm() == 1 || this.VJ.sO() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_zhibo));
            }
            if (getIs_good() == 1 && !sA()) {
                arrayList.add(Integer.valueOf(i.e.icon_elite));
            }
            if (this.VS == 1 || this.threadType == 11) {
                arrayList.add(Integer.valueOf(i.e.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(i.e.icon_live_on));
            }
            if (sp() == 1) {
                arrayList.add(Integer.valueOf(i.e.frs_post_ding));
            }
            if (z) {
                Integer num = Wb.get(new Point(sC(), sB()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (sC() == 1) {
                arrayList.add(Integer.valueOf(i.e.label_frs_lottery));
            } else if (sC() == 2) {
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
                    Bitmap cu = al.cu(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cu);
                    if (cu != null) {
                        bitmapDrawable.setBounds(0, 0, cu.getWidth(), cu.getHeight());
                    }
                    spannableString2.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.VN = spannableString;
        }
    }

    public void parser_title() {
        ai(false);
    }

    public void sF() {
        ai(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sG() {
        return this.VZ;
    }

    public void bD(int i) {
        this.VZ = i;
    }

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<ac> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || sA()) {
            return null;
        }
        ArrayList<ac> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                ac acVar = new ac();
                acVar.Wg = medias.get(i2).getPicUrl();
                acVar.aaD = 13;
                arrayList.add(acVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            ac acVar2 = new ac();
            acVar2.Wg = this.author.getPortrait();
            acVar2.aaD = 28;
            arrayList.add(acVar2);
        }
        return arrayList;
    }

    public boolean sH() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        int is_top = getIs_top();
        if (is_top == 2 || is_top == 1) {
            return VD;
        }
        if (this.VQ != null) {
            return VF;
        }
        return VE;
    }

    public int sI() {
        return this.UO;
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sJ() {
        return this.Wf;
    }

    public void j(ArrayList<g> arrayList) {
        if (this.VT == 1) {
            this.UO = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.UO = 0;
        } else {
            this.UO = 0;
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && next.rA() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.rA().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.UO = next.rB();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

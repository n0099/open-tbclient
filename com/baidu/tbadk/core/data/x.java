package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.am;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.mention.FeedData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.Media;
import tbclient.ThreadInfo;
import tbclient.Voice;
/* loaded from: classes.dex */
public class x implements am, au {
    public static final BdUniqueId ED = BdUniqueId.gen();
    public static final BdUniqueId EE = BdUniqueId.gen();
    private static HashMap<Point, Integer> EZ = new HashMap<>();
    private SpannableString EM;
    private int ER;
    private int ES;
    private int ET;
    private String EU;
    private long EW;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private HashMap<String, MetaData> userMap;
    private String EQ = null;
    private String EX = "";
    private int DS = 0;
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int EF = 0;
    private int EG = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int EH = 0;
    private aa EI = new aa();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> EN = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> EO = new ArrayList<>();
    private int EJ = 0;
    private int EK = 0;
    private String EL = null;
    private String abstract_text = null;
    private String from = null;
    private int EP = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int EV = 0;
    private ArrayList<b> EY = new ArrayList<>();

    static {
        EZ.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.v.label_frs_lottery_ing));
        EZ.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.v.label_frs_lottery_over));
        EZ.put(new Point(1, 3), Integer.valueOf(com.baidu.tieba.v.label_frs_lottery_off));
        EZ.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.v.label_frs_lottery_d));
        EZ.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.v.label_frs_activity_shaiing));
        EZ.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.v.label_frs_activity_shai_over));
        EZ.put(new Point(2, 3), Integer.valueOf(com.baidu.tieba.v.label_frs_activity_shai_off));
        EZ.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.v.label_frs_activity_shai_d));
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.EW;
    }

    public String getFirst_post_id() {
        return this.first_post_id;
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

    public void bQ(String str) {
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

    public void l(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void bu(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bv(int i) {
        this.is_good = i;
    }

    public int ns() {
        return this.EH;
    }

    public aa nt() {
        return this.EI;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String nu() {
        return this.forum_name;
    }

    public int nv() {
        return this.EK;
    }

    public String nw() {
        return this.EL;
    }

    public String nx() {
        return this.abstract_text;
    }

    public int ny() {
        return this.EP;
    }

    public void bw(int i) {
        this.EP = i;
    }

    public String nz() {
        return this.EQ;
    }

    public void bR(String str) {
        this.EQ = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.EN;
    }

    public ArrayList<b> nA() {
        return this.EY;
    }

    public void p(ArrayList<b> arrayList) {
        this.EY = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> nB() {
        return this.EO;
    }

    public int nC() {
        return this.ET;
    }

    public String nD() {
        return this.latitude;
    }

    public String nE() {
        return this.EU;
    }

    public String getAddress() {
        return this.address;
    }

    public String nF() {
        return this.EX;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0021: IGET  (r2v0 java.lang.Long A[REMOVE]) = (r8v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0032: IGET  (r2v1 java.lang.Long A[REMOVE]) = (r8v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00dc: IGET  (r2v7 java.lang.Long A[REMOVE]) = (r8v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00ed: IGET  (r2v8 java.lang.Long A[REMOVE]) = (r8v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.EU = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.EW = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.EF = threadInfo.repost_num.intValue();
                this.EG = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.EH = threadInfo.is_livepost.intValue();
                this.EI.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.EJ = threadInfo.has_commented.intValue();
                this.EK = threadInfo.show_commented.intValue();
                this.EL = threadInfo.click_url;
                this.from = threadInfo.from;
                this.EP = threadInfo.collect_status.intValue();
                this.EQ = threadInfo.collect_mark_pid;
                this.ER = threadInfo.is_voice_thread.intValue();
                this.ES = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.EX = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.ET = threadInfo.is_ntitle.intValue();
                this.EV = threadInfo.is_activity.intValue();
                if ((this.author == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
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
                        this.EN.add(mediaData);
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
                        this.EO.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.EY.add(bVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
                    this.praise.setTitle(this.title);
                } else {
                    this.praise.setTitle(this.abstract_text);
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
                this.EW = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.EF = jSONObject.optInt("repost_num", 0);
                this.EG = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.EH = jSONObject.optInt("is_livepost", 0);
                this.EI.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.EJ = jSONObject.optInt("has_commented", 0);
                this.EK = jSONObject.optInt("show_commented", 0);
                this.EL = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.EP = jSONObject.optInt("collect_status");
                this.EQ = jSONObject.optString("collect_mark_pid");
                this.ER = jSONObject.optInt("is_voice_thread");
                this.ES = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.EX = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.ET = jSONObject.optInt("is_ntitle");
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
                        this.EN.add(mediaData);
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
                        this.EO.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.EY.add(bVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.k.isEmpty(this.title)) {
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
        return this.EM;
    }

    public boolean nG() {
        return getIs_top() != 0;
    }

    public int nH() {
        if (nJ() && this.EY.size() >= 1) {
            b bVar = this.EY.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int mr = bVar.mr();
            int ms = bVar.ms();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < mr) {
                return 4;
            }
            return currentTimeMillis > ms ? 2 : 1;
        }
        return -1;
    }

    public int nI() {
        if (!nJ() || this.EY.size() < 1 || this.EY.get(0) == null) {
            return -1;
        }
        return this.EY.get(0).mq();
    }

    public boolean nJ() {
        return this.EV == 1;
    }

    public String nK() {
        return (!nJ() || this.EY.size() < 1 || this.EY.get(0) == null) ? "" : this.EY.get(0).getUrl();
    }

    private void ag(boolean z) {
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_notice));
            }
            if (ns() == 1 || this.EI.nS() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_live));
            }
            if (getIs_good() == 1 && !nG()) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_elite));
            }
            if (this.ER == 1 || this.ES == 11) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.icon_live_on));
            }
            if (nv() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.frs_post_ding));
            }
            if (z) {
                Integer num = EZ.get(new Point(nI(), nH()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (nI() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.label_frs_lottery));
            } else if (nI() == 2) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.v.label_frs_activity_shai));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.title);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap ce = bc.ce(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ce);
                    if (ce != null) {
                        bitmapDrawable.setBounds(0, 0, ce.getWidth(), ce.getHeight());
                    }
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.EM = spannableString;
        }
    }

    public void parser_title() {
        ag(false);
    }

    public void nL() {
        ag(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || nG()) {
            return null;
        }
        ArrayList<at> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                at atVar = new at();
                atVar.Fa = medias.get(i2).getPicUrl();
                atVar.Jn = 13;
                arrayList.add(atVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            at atVar2 = new at();
            atVar2.Fa = this.author.getPortrait();
            atVar2.Jn = 28;
            arrayList.add(atVar2);
        }
        return arrayList;
    }

    public boolean nM() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.am
    public BdUniqueId js() {
        return (getIs_top() == 2 || getIs_top() == 1) ? ED : EE;
    }

    public int nN() {
        return this.DS;
    }

    public void q(ArrayList<i> arrayList) {
        if (this.ET == 1) {
            this.DS = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.DS = 0;
        } else {
            this.DS = 0;
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && next.mI() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.mI().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.DS = next.mJ();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

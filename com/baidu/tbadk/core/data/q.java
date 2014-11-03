package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.al;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Media;
import tbclient.ThreadInfo;
import tbclient.Voice;
/* loaded from: classes.dex */
public class q implements al, at {
    public static final BdUniqueId An = BdUniqueId.gen();
    public static final BdUniqueId Ao = BdUniqueId.gen();
    private int AB;
    private int AC;
    private int AD;
    private String AE;
    private String AF;
    private long AG;
    private SpannableString Aw;
    private String address;
    private String authorId;
    private String first_post_id;
    private HashMap<String, MetaData> userMap;
    private String AA = null;
    private String AH = "";
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int Ap = 0;
    private int Aq = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Ar = 0;
    private t As = new t();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Ax = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Ay = new ArrayList<>();
    private int At = 0;
    private int Au = 0;
    private String Av = null;
    private String abstract_text = null;
    private String from = null;
    private int Az = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.AG;
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

    public void ba(String str) {
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

    public void h(long j) {
        this.last_time_int = j;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void aT(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void aU(int i) {
        this.is_good = i;
    }

    public int kw() {
        return this.Ar;
    }

    public t kx() {
        return this.As;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public String ky() {
        return this.forum_name;
    }

    public int kz() {
        return this.Au;
    }

    public String kA() {
        return this.Av;
    }

    public String kB() {
        return this.abstract_text;
    }

    public int kC() {
        return this.Az;
    }

    public void aV(int i) {
        this.Az = i;
    }

    public String kD() {
        return this.AA;
    }

    public void bb(String str) {
        this.AA = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Ax;
    }

    public ArrayList<VoiceData.VoiceModel> kE() {
        return this.Ay;
    }

    public int kF() {
        return this.AD;
    }

    public String getAddress() {
        return this.address;
    }

    public String kG() {
        return this.AH;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0021: IGET  (r2v0 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0032: IGET  (r2v1 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00dc: IGET  (r2v7 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00ed: IGET  (r2v8 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.AE = threadInfo.location.lat;
                    this.AF = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.AG = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Ap = threadInfo.repost_num.intValue();
                this.Aq = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Ar = threadInfo.is_livepost.intValue();
                this.As.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.At = threadInfo.has_commented.intValue();
                this.Au = threadInfo.show_commented.intValue();
                this.Av = threadInfo.click_url;
                this.from = threadInfo.from;
                this.Az = threadInfo.collect_status.intValue();
                this.AA = threadInfo.collect_mark_pid;
                this.AB = threadInfo.is_voice_thread.intValue();
                this.AC = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.AH = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.AD = threadInfo.is_ntitle.intValue();
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
                        this.Ax.add(mediaData);
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
                        this.Ay.add(voiceModel);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.l.aA(this.title)) {
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
                this.AG = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Ap = jSONObject.optInt("repost_num", 0);
                this.Aq = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Ar = jSONObject.optInt("is_livepost", 0);
                this.As.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.At = jSONObject.optInt("has_commented", 0);
                this.Au = jSONObject.optInt("show_commented", 0);
                this.Av = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.Az = jSONObject.optInt("collect_status");
                this.AA = jSONObject.optString("collect_mark_pid");
                this.AB = jSONObject.optInt("is_voice_thread");
                this.AC = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", "0");
                this.AH = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.AD = jSONObject.optInt("is_ntitle");
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
                        this.Ax.add(mediaData);
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
                        this.Ay.add(voiceModel);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.l.aA(this.title)) {
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
        return this.Aw;
    }

    public boolean kH() {
        return getIs_top() != 0;
    }

    public void parser_title() {
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_notice));
            }
            if (kw() == 1 || this.As.kP() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live));
            }
            if (getIs_good() == 1 && !kH()) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_elite));
            }
            if (this.AB == 1 || this.AC == 11) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live_on));
            }
            if (kz() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.frs_post_ding));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.title);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap bA = aw.bA(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bA);
                    if (bA != null) {
                        bitmapDrawable.setBounds(0, 0, bA.getWidth(), bA.getHeight());
                    }
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.Aw = spannableString;
        }
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<as> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || kH()) {
            return null;
        }
        ArrayList<as> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                as asVar = new as();
                asVar.AI = medias.get(i2).getPicUrl();
                asVar.ES = 13;
                arrayList.add(asVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            as asVar2 = new as();
            asVar2.AI = this.author.getPortrait();
            asVar2.ES = 12;
            arrayList.add(asVar2);
        }
        return arrayList;
    }

    public boolean kI() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return (getIs_top() == 2 || getIs_top() == 1) ? An : Ao;
    }
}

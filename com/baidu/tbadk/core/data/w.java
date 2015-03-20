package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ai;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.game.GameInfoData;
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
public class w implements ai, as {
    private int QB;
    private int QC;
    private int QD;
    private String QE;
    private long QG;
    private SpannableString Qv;
    private String address;
    private String authorId;
    private String first_post_id;
    private String latitude;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Qm = BdUniqueId.gen();
    public static final BdUniqueId Qn = BdUniqueId.gen();
    private static HashMap<Point, Integer> QJ = new HashMap<>();
    private String Qz = null;
    private int PD = 0;
    private String QH = "";
    private String id = null;
    private String tid = null;
    private String title = null;
    private int reply_num = 0;
    private int Qo = 0;
    private int Qp = 0;
    private String last_time = null;
    private long last_time_int = 0;
    private int is_top = 0;
    private int is_good = 0;
    private int Qq = 0;
    private z Qr = new z();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Qw = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Qx = new ArrayList<>();
    private int Qs = 0;
    private int Qt = 0;
    private String Qu = null;
    private String abstract_text = null;
    private String from = null;
    private int Qy = 0;
    private PraiseData praise = new PraiseData();
    private AnchorInfoData anchorInfoData = new AnchorInfoData();
    private long time = 0;
    private int QF = 0;
    private ArrayList<b> QI = new ArrayList<>();

    static {
        QJ.put(new Point(1, 1), Integer.valueOf(com.baidu.tieba.u.label_frs_lottery_ing));
        QJ.put(new Point(1, 2), Integer.valueOf(com.baidu.tieba.u.label_frs_lottery_over));
        QJ.put(new Point(1, 3), Integer.valueOf(com.baidu.tieba.u.label_frs_lottery_off));
        QJ.put(new Point(1, 4), Integer.valueOf(com.baidu.tieba.u.label_frs_lottery_d));
        QJ.put(new Point(2, 1), Integer.valueOf(com.baidu.tieba.u.label_frs_activity_shaiing));
        QJ.put(new Point(2, 2), Integer.valueOf(com.baidu.tieba.u.label_frs_activity_shai_over));
        QJ.put(new Point(2, 3), Integer.valueOf(com.baidu.tieba.u.label_frs_activity_shai_off));
        QJ.put(new Point(2, 4), Integer.valueOf(com.baidu.tieba.u.label_frs_activity_shai_d));
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.QG;
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

    public void bU(String str) {
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

    public void bt(int i) {
        this.is_top = i;
    }

    public int getIs_good() {
        return this.is_good;
    }

    public void bu(int i) {
        this.is_good = i;
    }

    public int qC() {
        return this.Qq;
    }

    public z qD() {
        return this.Qr;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public int qE() {
        return this.Qt;
    }

    public String qF() {
        return this.Qu;
    }

    public String qG() {
        return this.abstract_text;
    }

    public int qH() {
        return this.Qy;
    }

    public void bv(int i) {
        this.Qy = i;
    }

    public String qI() {
        return this.Qz;
    }

    public void bV(String str) {
        this.Qz = str;
    }

    public ArrayList<MediaData> getMedias() {
        return this.Qw;
    }

    public ArrayList<b> qJ() {
        return this.QI;
    }

    public void l(ArrayList<b> arrayList) {
        this.QI = arrayList;
    }

    public ArrayList<VoiceData.VoiceModel> qK() {
        return this.Qx;
    }

    public int qL() {
        return this.QD;
    }

    public String getAddress() {
        return this.address;
    }

    public String qM() {
        return this.QH;
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
                    this.QE = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.tid = new StringBuilder().append(threadInfo.tid).toString();
                this.title = threadInfo.title;
                this.QG = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Qo = threadInfo.repost_num.intValue();
                this.Qp = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.last_time_int = threadInfo.last_time_int.intValue();
                this.is_top = threadInfo.is_top.intValue();
                this.is_good = threadInfo.is_good.intValue();
                this.Qq = threadInfo.is_livepost.intValue();
                this.Qr.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Qs = threadInfo.has_commented.intValue();
                this.Qt = threadInfo.show_commented.intValue();
                this.Qu = threadInfo.click_url;
                this.from = threadInfo.from;
                this.Qy = threadInfo.collect_status.intValue();
                this.Qz = threadInfo.collect_mark_pid;
                this.QB = threadInfo.is_voice_thread.intValue();
                this.QC = threadInfo.thread_type.intValue();
                this.first_post_id = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.QH = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.QD = threadInfo.is_ntitle.intValue();
                this.QF = threadInfo.is_activity.intValue();
                if ((this.author == null || this.author.getUserId().equals(GameInfoData.NOT_FROM_DETAIL)) && this.authorId != null && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL) && (metaData = this.userMap.get(this.authorId)) != null) {
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
                        this.Qw.add(mediaData);
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
                        this.Qx.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        b bVar = new b();
                        bVar.a(list4.get(i4));
                        this.QI.add(bVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(threadInfo.zan);
                this.anchorInfoData.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.m.isEmpty(this.title)) {
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
                this.QG = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Qo = jSONObject.optInt("repost_num", 0);
                this.Qp = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.last_time_int = jSONObject.optLong("last_time_int", 0L);
                this.is_top = jSONObject.optInt(PbActivityConfig.KEY_IS_TOP, 0);
                this.is_good = jSONObject.optInt(PbActivityConfig.KEY_IS_GOOD, 0);
                this.Qq = jSONObject.optInt("is_livepost", 0);
                this.Qr.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Qs = jSONObject.optInt("has_commented", 0);
                this.Qt = jSONObject.optInt("show_commented", 0);
                this.Qu = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.Qy = jSONObject.optInt("collect_status");
                this.Qz = jSONObject.optString("collect_mark_pid");
                this.QB = jSONObject.optInt("is_voice_thread");
                this.QC = jSONObject.optInt("thread_type");
                this.first_post_id = jSONObject.optString("first_post_id", GameInfoData.NOT_FROM_DETAIL);
                this.QH = jSONObject.optString("post_id", GameInfoData.NOT_FROM_DETAIL);
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.QD = jSONObject.optInt("is_ntitle");
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
                        this.Qw.add(mediaData);
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
                        this.Qx.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.QI.add(bVar);
                    }
                }
                this.praise.setUserMap(this.userMap);
                this.praise.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.anchorInfoData.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.m.isEmpty(this.title)) {
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
        return this.Qv;
    }

    public boolean qN() {
        return getIs_top() != 0;
    }

    public int qO() {
        if (qQ() && this.QI.size() >= 1) {
            b bVar = this.QI.get(0);
            int status = bVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pL = bVar.pL();
            int pM = bVar.pM();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pL) {
                return 4;
            }
            return currentTimeMillis > pM ? 2 : 1;
        }
        return -1;
    }

    public int qP() {
        if (!qQ() || this.QI.size() < 1 || this.QI.get(0) == null) {
            return -1;
        }
        return this.QI.get(0).pK();
    }

    public boolean qQ() {
        return this.QF == 1;
    }

    public String qR() {
        return (!qQ() || this.QI.size() < 1 || this.QI.get(0) == null) ? "" : this.QI.get(0).getUrl();
    }

    private void ab(boolean z) {
        SpannableString spannableString;
        if (this.title != null) {
            ArrayList arrayList = new ArrayList();
            if (getIs_top() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_top));
            } else if (getIs_top() == 2) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_notice));
            }
            if (qC() == 1 || this.Qr.qZ() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live));
            }
            if (getIs_good() == 1 && !qN()) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_elite));
            }
            if (this.QB == 1 || this.QC == 11) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice));
            }
            if (this.anchorInfoData != null && this.anchorInfoData.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live_on));
            }
            if (qE() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.frs_post_ding));
            }
            if (z) {
                Integer num = QJ.get(new Point(qP(), qO()));
                if (num != null) {
                    arrayList.add(num);
                }
            } else if (qP() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.label_frs_lottery));
            } else if (qP() == 2) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.label_frs_activity_shai));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.title);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap cg = ba.cg(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cg);
                    if (cg != null) {
                        bitmapDrawable.setBounds(0, 0, cg.getWidth(), cg.getHeight());
                    }
                    spannableString2.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.title);
            }
            this.Qv = spannableString;
        }
    }

    public void parser_title() {
        ab(false);
    }

    public void qS() {
        ab(true);
    }

    public AnchorInfoData getAnchorInfoData() {
        return this.anchorInfoData;
    }

    @Override // com.baidu.tbadk.core.util.as
    public ArrayList<ar> getImages() {
        ArrayList<MediaData> medias = getMedias();
        if (medias == null || qN()) {
            return null;
        }
        ArrayList<ar> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= medias.size() || i2 >= 3) {
                break;
            }
            if (medias.get(i2).getType() == 3) {
                ar arVar = new ar();
                arVar.QK = medias.get(i2).getPicUrl();
                arVar.UU = 13;
                arrayList.add(arVar);
            }
            i = i2 + 1;
        }
        if (this.author != null) {
            ar arVar2 = new ar();
            arVar2.QK = this.author.getPortrait();
            arVar2.UU = 28;
            arrayList.add(arVar2);
        }
        return arrayList;
    }

    public boolean qT() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals(GameInfoData.NOT_FROM_DETAIL);
    }

    @Override // com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return (getIs_top() == 2 || getIs_top() == 1) ? Qm : Qn;
    }

    public int qU() {
        return this.PD;
    }

    public void m(ArrayList<i> arrayList) {
        if (this.QD == 1) {
            this.PD = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.PD = 0;
        } else {
            this.PD = 0;
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && next.pW() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pW().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.PD = next.pX();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

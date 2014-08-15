package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.Media;
import tbclient.ThreadInfo;
import tbclient.Voice;
/* loaded from: classes.dex */
public class n implements av {
    private int A;
    private String D;
    private int F;
    private HashMap<String, MetaData> G;
    private long H;
    private String m;
    private SpannableString s;
    private int z;
    private String y = null;
    private String I = "";
    private String a = null;
    private String b = null;
    private String c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private String g = null;
    private long h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private p l = new p();
    private MetaData n = new MetaData();
    private String o = null;
    ArrayList<MediaData> u = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> v = new ArrayList<>();
    private int p = 0;
    private int q = 0;
    private String r = null;
    private String t = null;
    private String w = null;
    private int x = 0;
    private PraiseData B = new PraiseData();
    private AnchorInfoData C = new AnchorInfoData();
    private long E = 0;

    public HashMap<String, MetaData> d() {
        return this.G;
    }

    public void a(HashMap<String, MetaData> hashMap) {
        this.G = hashMap;
    }

    public long e() {
        return this.H;
    }

    public String f() {
        return this.D;
    }

    public PraiseData g() {
        return this.B;
    }

    public void a(PraiseData praiseData) {
        this.B = praiseData;
    }

    public void a(String str) {
        this.a = str;
    }

    public String h() {
        return this.a;
    }

    public void b(String str) {
        this.b = str;
    }

    public String i() {
        return this.b;
    }

    public void c(String str) {
        this.c = str;
    }

    public String j() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }

    public int k() {
        return this.d;
    }

    public long l() {
        return this.h;
    }

    public void a(long j) {
        this.h = j;
    }

    public int m() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public int n() {
        return this.j;
    }

    public void c(int i) {
        this.j = i;
    }

    public int o() {
        return this.k;
    }

    public p p() {
        return this.l;
    }

    public MetaData q() {
        return this.n;
    }

    public String r() {
        return this.o;
    }

    public int s() {
        return this.q;
    }

    public String t() {
        return this.r;
    }

    public String u() {
        return this.t;
    }

    public int v() {
        return this.x;
    }

    public void d(int i) {
        this.x = i;
    }

    public String w() {
        return this.y;
    }

    public void d(String str) {
        this.y = str;
    }

    public ArrayList<MediaData> x() {
        return this.u;
    }

    public ArrayList<VoiceData.VoiceModel> y() {
        return this.v;
    }

    public int z() {
        return this.F;
    }

    public String A() {
        return this.I;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0009: IGET  (r2v0 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x001a: IGET  (r2v1 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00c5: IGET  (r2v6 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00d6: IGET  (r2v7 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                this.a = new StringBuilder().append(threadInfo.id).toString();
                this.b = new StringBuilder().append(threadInfo.tid).toString();
                this.c = threadInfo.title;
                this.H = threadInfo.create_time.intValue() * 1000;
                this.d = threadInfo.reply_num.intValue();
                this.e = threadInfo.repost_num.intValue();
                this.f = threadInfo.view_num.intValue();
                this.g = threadInfo.last_time;
                this.h = threadInfo.last_time_int.intValue();
                this.i = threadInfo.is_top.intValue();
                this.j = threadInfo.is_good.intValue();
                this.k = threadInfo.is_livepost.intValue();
                this.l.a(threadInfo.topic);
                this.n.parserProtobuf(threadInfo.author);
                this.m = threadInfo.author_id.toString();
                this.o = threadInfo.fname;
                this.p = threadInfo.has_commented.intValue();
                this.q = threadInfo.show_commented.intValue();
                this.r = threadInfo.click_url;
                this.w = threadInfo.from;
                this.x = threadInfo.collect_status.intValue();
                this.y = threadInfo.collect_mark_pid;
                this.z = threadInfo.is_voice_thread.intValue();
                this.A = threadInfo.thread_type.intValue();
                this.D = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.I = new StringBuilder().append(threadInfo.post_id).toString();
                this.E = threadInfo.time.intValue() * 1000;
                this.F = threadInfo.is_ntitle.intValue();
                if ((this.n == null || this.n.getUserId().equals("0")) && this.m != null && !this.m.equals("0") && (metaData = this.G.get(this.m)) != null) {
                    this.n = metaData;
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
                this.t = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.u.add(mediaData);
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
                        this.v.add(voiceModel);
                    }
                }
                this.B.setUserMap(this.G);
                this.B.parserProtobuf(threadInfo.zan);
                this.C.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.i.c(this.c)) {
                    this.B.setTitle(this.c);
                } else {
                    this.B.setTitle(this.t);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString("tid");
                this.c = jSONObject.optString("title");
                this.H = jSONObject.optLong("create_time", 0L) * 1000;
                this.d = jSONObject.optInt("reply_num", 0);
                this.e = jSONObject.optInt("repost_num", 0);
                this.f = jSONObject.optInt("view_num", 0);
                this.g = jSONObject.optString("last_time");
                this.h = jSONObject.optLong("last_time_int", 0L);
                this.i = jSONObject.optInt("is_top", 0);
                this.j = jSONObject.optInt("is_good", 0);
                this.k = jSONObject.optInt("is_livepost", 0);
                this.l.a(jSONObject.optJSONObject("topic"));
                this.m = jSONObject.optString("author_id");
                this.n.parserJson(jSONObject.optJSONObject("author"));
                this.o = jSONObject.optString("fname");
                this.p = jSONObject.optInt("has_commented", 0);
                this.q = jSONObject.optInt("show_commented", 0);
                this.r = jSONObject.optString("click_url");
                this.w = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FROM);
                this.x = jSONObject.optInt("collect_status");
                this.y = jSONObject.optString("collect_mark_pid");
                this.z = jSONObject.optInt("is_voice_thread");
                this.A = jSONObject.optInt("thread_type");
                this.D = jSONObject.optString("first_post_id", "0");
                this.I = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID, "0");
                this.E = jSONObject.optLong("time", 0L) * 1000;
                this.F = jSONObject.optInt("is_ntitle");
                if (this.n == null || this.n.getUserId() == null) {
                    this.n = this.G.get(this.m);
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
                this.t = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.u.add(mediaData);
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
                        this.v.add(voiceModel);
                    }
                }
                this.B.setUserMap(this.G);
                this.B.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.C.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.i.c(this.c)) {
                    this.B.setTitle(this.c);
                } else {
                    this.B.setTitle(this.t);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableString B() {
        return this.s;
    }

    public boolean C() {
        return m() != 0;
    }

    public void D() {
        SpannableString spannableString;
        if (this.c != null) {
            ArrayList arrayList = new ArrayList();
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (m() == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_top_1));
                } else if (m() == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_notice_1));
                }
                if (o() == 1 || this.l.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_live_1));
                }
                if (n() == 1 && !C()) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_elite_1));
                }
                if (this.z == 1 || this.A == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_voice_1));
                }
                if (this.C != null && this.C.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_live_on_1));
                }
            } else {
                if (m() == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_top));
                } else if (m() == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_notice));
                }
                if (o() == 1 || this.l.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_live));
                }
                if (n() == 1 && !C()) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_elite));
                }
                if (this.z == 1 || this.A == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_voice));
                }
                if (this.C != null && this.C.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.t.icon_live_on));
                }
            }
            if (s() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.t.frs_post_ding));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.c);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                    bitmapDrawable.setBounds(0, 0, a.getWidth(), a.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.c);
            }
            this.s = spannableString;
        }
    }

    public AnchorInfoData E() {
        return this.C;
    }

    @Override // com.baidu.tbadk.core.util.av
    public LinkedList<au> getImages() {
        ArrayList<MediaData> x = x();
        if (x == null || C()) {
            return null;
        }
        LinkedList<au> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= x.size() || i2 >= 3) {
                break;
            }
            if (x.get(i2).getType() == 3) {
                au auVar = new au();
                auVar.a = x.get(i2).getPicUrl();
                auVar.d = 13;
                linkedList.add(auVar);
            }
            i = i2 + 1;
        }
        if (this.n != null) {
            au auVar2 = new au();
            auVar2.a = this.n.getPortrait();
            auVar2.d = 12;
            linkedList.add(auVar2);
        }
        return linkedList;
    }
}

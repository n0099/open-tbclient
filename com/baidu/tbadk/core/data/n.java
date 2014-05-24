package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
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
public class n extends com.baidu.tbadk.core.util.a {
    private int A;
    private String D;
    private int F;
    private HashMap<String, MetaData> G;
    private long H;
    private String o;
    private SpannableString u;
    private int z;
    private String y = null;
    private String I = "";
    private String c = null;
    private String d = null;
    private String e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private long j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private p n = new p();
    private MetaData p = new MetaData();
    private String q = null;
    ArrayList<j> a = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> b = new ArrayList<>();
    private int r = 0;
    private int s = 0;
    private String t = null;
    private String v = null;
    private String w = null;
    private int x = 0;
    private PraiseData B = new PraiseData();
    private AnchorInfoData C = new AnchorInfoData();
    private long E = 0;

    public HashMap<String, MetaData> l() {
        return this.G;
    }

    public void a(HashMap<String, MetaData> hashMap) {
        this.G = hashMap;
    }

    public long m() {
        return this.H;
    }

    public String n() {
        return this.D;
    }

    public PraiseData o() {
        return this.B;
    }

    public void a(PraiseData praiseData) {
        this.B = praiseData;
    }

    public void a(String str) {
        this.c = str;
    }

    public String p() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String q() {
        return this.d;
    }

    public void c(String str) {
        this.e = str;
    }

    public String r() {
        return this.e;
    }

    public void b(int i) {
        this.f = i;
    }

    public int s() {
        return this.f;
    }

    public long t() {
        return this.j;
    }

    public void a(long j) {
        this.j = j;
    }

    public int u() {
        return this.k;
    }

    public void c(int i) {
        this.k = i;
    }

    public int v() {
        return this.l;
    }

    public void d(int i) {
        this.l = i;
    }

    public int w() {
        return this.m;
    }

    public p x() {
        return this.n;
    }

    public MetaData y() {
        return this.p;
    }

    public String z() {
        return this.q;
    }

    public int A() {
        return this.s;
    }

    public String B() {
        return this.t;
    }

    public String C() {
        return this.v;
    }

    public int D() {
        return this.x;
    }

    public void e(int i) {
        this.x = i;
    }

    public String E() {
        return this.y;
    }

    public void d(String str) {
        this.y = str;
    }

    public ArrayList<j> F() {
        return this.a;
    }

    public ArrayList<VoiceData.VoiceModel> G() {
        return this.b;
    }

    public int H() {
        return this.F;
    }

    public String I() {
        return this.I;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0009: IGET  (r2v1 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x001a: IGET  (r2v2 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00c5: IGET  (r2v7 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00d6: IGET  (r2v8 java.lang.Long A[REMOVE]) = (r7v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                this.c = new StringBuilder().append(threadInfo.id).toString();
                this.d = new StringBuilder().append(threadInfo.tid).toString();
                this.e = threadInfo.title;
                this.H = threadInfo.create_time.intValue() * LocationClientOption.MIN_SCAN_SPAN;
                this.f = threadInfo.reply_num.intValue();
                this.g = threadInfo.repost_num.intValue();
                this.h = threadInfo.view_num.intValue();
                this.i = threadInfo.last_time;
                this.j = threadInfo.last_time_int.intValue();
                this.k = threadInfo.is_top.intValue();
                this.l = threadInfo.is_good.intValue();
                this.m = threadInfo.is_livepost.intValue();
                this.n.a(threadInfo.topic);
                this.p.parserProtobuf(threadInfo.author);
                this.o = threadInfo.author_id.toString();
                this.q = threadInfo.fname;
                this.r = threadInfo.has_commented.intValue();
                this.s = threadInfo.show_commented.intValue();
                this.t = threadInfo.click_url;
                this.w = threadInfo.from;
                this.x = threadInfo.collect_status.intValue();
                this.y = threadInfo.collect_mark_pid;
                this.z = threadInfo.is_voice_thread.intValue();
                this.A = threadInfo.thread_type.intValue();
                this.D = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.I = new StringBuilder().append(threadInfo.post_id).toString();
                this.E = threadInfo.time.intValue() * LocationClientOption.MIN_SCAN_SPAN;
                this.F = threadInfo.is_ntitle.intValue();
                if ((this.p == null || this.p.getUserId().equals("0")) && this.o != null && !this.o.equals("0") && (metaData = this.G.get(this.o)) != null) {
                    this.p = metaData;
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
                this.v = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        j jVar = new j();
                        jVar.a(list2.get(i2));
                        this.a.add(jVar);
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
                        voiceModel.duration = voice.during_time.intValue() / LocationClientOption.MIN_SCAN_SPAN;
                        this.b.add(voiceModel);
                    }
                }
                this.B.setUserMap(this.G);
                this.B.parserProtobuf(threadInfo.zan);
                this.C.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.b(this.e)) {
                    this.B.setTitle(this.e);
                } else {
                    this.B.setTitle(this.v);
                }
            } catch (Exception e) {
                BdLog.e("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optString("id");
                this.d = jSONObject.optString("tid");
                this.e = jSONObject.optString("title");
                this.H = jSONObject.optLong("create_time", 0L) * 1000;
                this.f = jSONObject.optInt("reply_num", 0);
                this.g = jSONObject.optInt("repost_num", 0);
                this.h = jSONObject.optInt("view_num", 0);
                this.i = jSONObject.optString("last_time");
                this.j = jSONObject.optLong("last_time_int", 0L);
                this.k = jSONObject.optInt("is_top", 0);
                this.l = jSONObject.optInt("is_good", 0);
                this.m = jSONObject.optInt("is_livepost", 0);
                this.n.a(jSONObject.optJSONObject("topic"));
                this.o = jSONObject.optString("author_id");
                this.p.parserJson(jSONObject.optJSONObject("author"));
                this.q = jSONObject.optString("fname");
                this.r = jSONObject.optInt("has_commented", 0);
                this.s = jSONObject.optInt("show_commented", 0);
                this.t = jSONObject.optString("click_url");
                this.w = jSONObject.optString("from");
                this.x = jSONObject.optInt("collect_status");
                this.y = jSONObject.optString("collect_mark_pid");
                this.z = jSONObject.optInt("is_voice_thread");
                this.A = jSONObject.optInt("thread_type");
                this.D = jSONObject.optString("first_post_id", "0");
                this.I = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID, "0");
                this.E = jSONObject.optLong("time", 0L) * 1000;
                this.F = jSONObject.optInt("is_ntitle");
                if (this.p == null || this.p.getUserId() == null) {
                    this.p = this.G.get(this.o);
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
                this.v = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        j jVar = new j();
                        jVar.a(optJSONArray2.getJSONObject(i2));
                        this.a.add(jVar);
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
                        voiceModel.duration = jSONObject2.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.b.add(voiceModel);
                    }
                }
                this.B.setUserMap(this.G);
                this.B.parserJson(jSONObject.optJSONObject("zan"));
                this.C.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.b(this.e)) {
                    this.B.setTitle(this.e);
                } else {
                    this.B.setTitle(this.v);
                }
            } catch (Exception e) {
                BdLog.e("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public SpannableString J() {
        return this.u;
    }

    public boolean K() {
        return u() != 0;
    }

    public void L() {
        SpannableString spannableString;
        if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (u() == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_top_1));
                } else if (u() == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_notice_1));
                }
                if (w() == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live_1));
                }
                if (v() == 1 && !K()) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_elite_1));
                }
                if (this.z == 1 || this.A == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice_1));
                }
                if (this.C != null && this.C.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live_on_1));
                }
            } else {
                if (u() == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_top));
                } else if (u() == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_notice));
                }
                if (w() == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live));
                }
                if (v() == 1 && !K()) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_elite));
                }
                if (this.z == 1 || this.A == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice));
                }
                if (this.C != null && this.C.getGroup_id() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_live_on));
                }
            }
            if (A() == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.frs_post_ding));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.e);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap a = com.baidu.tbadk.core.util.g.a(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                    bitmapDrawable.setBounds(0, 0, a.getWidth(), a.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.e);
            }
            this.u = spannableString;
        }
    }

    public AnchorInfoData M() {
        return this.C;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        ArrayList<j> F = F();
        if (F == null || K()) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= F.size() || i2 >= 3) {
                break;
            }
            if (F.get(i2).b() == 3) {
                linkedList.add(F.get(i2).c());
            }
            i = i2 + 1;
        }
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getPhotoUrl() {
        if (this.p == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        if (this.p != null) {
            linkedList.add(this.p.getPortrait());
            return linkedList;
        }
        return linkedList;
    }
}

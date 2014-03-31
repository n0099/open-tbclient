package com.baidu.tbadk.core.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.core.util.a {
    private String B;
    private int E;
    private long F;
    private SpannableString t;
    private int y;
    private int z;
    private String x = null;
    private String G = "";
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
    private q n = new q();
    private MetaData o = new MetaData();
    private String p = null;
    ArrayList<j> a = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> b = new ArrayList<>();
    private int q = 0;
    private int r = 0;
    private String s = null;
    private String u = null;
    private String v = null;
    private int w = 0;
    private PraiseData A = new PraiseData();
    private ArrayList<FrsPostListData> C = new ArrayList<>();
    private long D = 0;

    public final ArrayList<FrsPostListData> h() {
        return this.C;
    }

    public final long i() {
        return this.F;
    }

    public final String j() {
        return this.B;
    }

    public final PraiseData k() {
        return this.A;
    }

    public final void a(PraiseData praiseData) {
        this.A = praiseData;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String l() {
        return this.c;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String m() {
        return this.d;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final String n() {
        return this.e;
    }

    public final void b(int i) {
        this.f = i;
    }

    public final int o() {
        return this.f;
    }

    public final long p() {
        return this.j;
    }

    public final void a(long j) {
        this.j = j;
    }

    public final int q() {
        return this.k;
    }

    public final void c(int i) {
        this.k = i;
    }

    public final int r() {
        return this.l;
    }

    public final void d(int i) {
        this.l = i;
    }

    public final q s() {
        return this.n;
    }

    public final MetaData t() {
        return this.o;
    }

    public final String u() {
        return this.p;
    }

    public final String v() {
        return this.s;
    }

    public final String w() {
        return this.u;
    }

    public final int x() {
        return this.w;
    }

    public final void e(int i) {
        this.w = i;
    }

    public final String y() {
        return this.x;
    }

    public final void d(String str) {
        this.x = str;
    }

    public final ArrayList<j> z() {
        return this.a;
    }

    public final ArrayList<VoiceData.VoiceModel> A() {
        return this.b;
    }

    public final int B() {
        return this.E;
    }

    public final String C() {
        return this.G;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optString("id");
                this.d = jSONObject.optString("tid");
                this.e = jSONObject.optString("title");
                this.F = jSONObject.optLong("create_time", 0L) * 1000;
                this.f = jSONObject.optInt("reply_num", 0);
                this.g = jSONObject.optInt("repost_num", 0);
                this.h = jSONObject.optInt("view_num", 0);
                this.i = jSONObject.optString("last_time");
                this.j = jSONObject.optLong("last_time_int", 0L);
                this.k = jSONObject.optInt("is_top", 0);
                this.l = jSONObject.optInt("is_good", 0);
                this.m = jSONObject.optInt("is_livepost", 0);
                this.n.a(jSONObject.optJSONObject("topic"));
                this.o.parserJson(jSONObject.optJSONObject("author"));
                this.p = jSONObject.optString("fname");
                this.q = jSONObject.optInt("has_commented", 0);
                this.r = jSONObject.optInt("show_commented", 0);
                this.s = jSONObject.optString("click_url");
                this.v = jSONObject.optString("from");
                this.w = jSONObject.optInt("collect_status");
                this.x = jSONObject.optString("collect_mark_pid");
                this.y = jSONObject.optInt("is_voice_thread");
                this.z = jSONObject.optInt("thread_type");
                this.B = jSONObject.optString("first_post_id", "0");
                this.G = jSONObject.optString("post_id", "0");
                this.D = jSONObject.optLong("time", 0L) * 1000;
                this.E = jSONObject.optInt("is_ntitle");
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
                this.u = sb.toString();
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
                this.A.parserJson(jSONObject.optJSONObject("zan"));
                JSONArray optJSONArray4 = jSONObject.optJSONArray("post_list");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        FrsPostListData frsPostListData = new FrsPostListData();
                        frsPostListData.parserJson(optJSONArray4.getJSONObject(i4));
                        this.C.add(frsPostListData);
                    }
                }
                if (!com.baidu.adp.lib.util.h.b(this.e)) {
                    this.A.setTitle(this.e);
                } else {
                    this.A.setTitle(this.u);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final SpannableString D() {
        return this.t;
    }

    private boolean a() {
        return this.k != 0;
    }

    public final void E() {
        SpannableString spannableString;
        if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            if (TbadkApplication.j().l() == 1) {
                if (this.k == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_top_1));
                } else if (this.k == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_notice_1));
                }
                if (this.m == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_live_1));
                }
                if (this.l == 1 && !a()) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_elite_1));
                }
                if (this.y == 1 || this.z == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_voice_1));
                }
            } else {
                if (this.k == 1) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_top));
                } else if (this.k == 2) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_notice));
                }
                if (this.m == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_live));
                }
                if (this.l == 1 && !a()) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_elite));
                }
                if (this.y == 1 || this.z == 11) {
                    arrayList.add(Integer.valueOf(com.baidu.tbadk.i.icon_voice));
                }
            }
            if (this.r == 1) {
                arrayList.add(Integer.valueOf(com.baidu.tbadk.i.frs_post_ding));
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
            this.t = spannableString;
        }
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public LinkedList<String> getImageUrl() {
        ArrayList<j> arrayList = this.a;
        if (arrayList == null || a()) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < arrayList.size() && i < 3; i++) {
            if (arrayList.get(i).b() == 3) {
                linkedList.add(arrayList.get(i).c());
            }
        }
        if (this.C != null && this.C.size() > 0) {
            Iterator<FrsPostListData> it = this.C.iterator();
            while (it.hasNext()) {
                ArrayList<j> arrayList2 = it.next().getmMedias();
                for (int i2 = 0; i2 < arrayList2.size() && i2 < 3; i2++) {
                    if (arrayList2.get(i2).b() == 3) {
                        linkedList.add(arrayList2.get(i2).c());
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ab
    public LinkedList<String> getPhotoUrl() {
        if (this.o == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        if (this.o != null) {
            linkedList.add(this.o.getPortrait());
        }
        if (this.A != null && this.A.getUser() != null && this.A.getUser().size() > 0) {
            Iterator<MetaData> it = this.A.getUser().iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().getPortrait());
            }
        }
        return linkedList;
    }
}

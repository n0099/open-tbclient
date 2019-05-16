package com.baidu.swan.game.ad.a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.ubc.UBC;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.baidu.swan.game.ad.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: m */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: eN */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    private long A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private long G;
    private String a;
    private String b;
    private Set<String> bcK;
    private Set<String> bcL;
    private Set<String> bcM;
    private Set<String> bcN;
    private Set<String> bcO;
    private Set<String> bcP;
    private JSONObject bcQ;
    private Set<String> c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;
    private String j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String x;
    private String y;
    private String z;

    @SuppressLint({"DefaultLocale"})
    public a(JSONObject jSONObject) {
        this.b = LivenessStat.TYPE_STRING_DEFAULT;
        this.c = new HashSet();
        this.m = 0;
        this.n = 0;
        this.bcK = new HashSet();
        this.bcL = new HashSet();
        this.bcM = new HashSet();
        this.bcN = new HashSet();
        this.bcO = new HashSet();
        this.bcP = new HashSet();
        this.bcQ = jSONObject;
        try {
            this.G = System.currentTimeMillis();
            this.a = jSONObject.optString("qk", "");
            this.b = jSONObject.optString("id", LivenessStat.TYPE_STRING_DEFAULT);
            String optString = jSONObject.optString("winurl", "");
            if (!TextUtils.isEmpty(optString)) {
                this.c.add(optString);
            }
            this.d = jSONObject.optString("tit", "");
            this.e = jSONObject.optString("desc", "");
            this.f = jSONObject.optString("icon", "");
            this.g = jSONObject.optString("type");
            this.h = jSONObject.optInt(SocialConstants.PARAM_ACT);
            this.i = jSONObject.optInt("anti_tag");
            this.j = jSONObject.optString("curl", "");
            this.k = jSONObject.optString("w_picurl", "");
            this.l = jSONObject.optString("vurl", "");
            this.m = jSONObject.optInt(Config.DEVICE_WIDTH, 0);
            this.n = jSONObject.optInt("h", 0);
            this.o = jSONObject.optInt(UBC.CONTENT_KEY_DURATION, 0);
            this.p = jSONObject.optInt("closetype", 0);
            this.q = jSONObject.optInt("expiration", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("monitors");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("s")) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            a(optJSONArray.optString(i));
                        }
                    } else if (next.equals("vskip")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            d(optJSONArray2.optString(i2));
                        }
                    } else if (next.equals("vstart")) {
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray(next);
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            c(optJSONArray3.optString(i3));
                        }
                    } else if (next.equals("vclose")) {
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray(next);
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            e(optJSONArray4.optString(i4));
                        }
                    } else if (next.equals("click")) {
                        JSONArray optJSONArray5 = optJSONObject.optJSONArray(next);
                        for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                            f(optJSONArray5.optString(i5));
                        }
                    } else if (next.equals("c")) {
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(next);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            b(optJSONArray6.optString(i6));
                        }
                    }
                }
            }
            this.x = jSONObject.optString("appname", "");
            this.y = jSONObject.optString(PushConstants.URI_PACKAGE_NAME, "");
            this.z = jSONObject.optString("apk_name", "");
            this.A = jSONObject.optLong("sz", 0L);
            if (jSONObject.optJSONObject("apo") != null) {
                this.B = jSONObject.optString("page", "");
                this.C = jSONObject.optString("version", "");
                this.D = jSONObject.optString("fallback", "");
                this.E = jSONObject.optString("fb_act", "");
            }
            this.F = this.a + "_" + new Random().nextLong() + System.currentTimeMillis() + "|";
        } catch (Exception e) {
        }
    }

    private a(Parcel parcel) {
        this.b = LivenessStat.TYPE_STRING_DEFAULT;
        this.c = new HashSet();
        this.m = 0;
        this.n = 0;
        this.bcK = new HashSet();
        this.bcL = new HashSet();
        this.bcM = new HashSet();
        this.bcN = new HashSet();
        this.bcO = new HashSet();
        this.bcP = new HashSet();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readLong();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeLong(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.k;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.l;
    }

    public String f() {
        return this.j;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.x;
    }

    public long i() {
        return this.G;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int j() {
        return this.q;
    }

    public List<String> k() {
        return new ArrayList(this.c);
    }

    public List<String> l() {
        return new ArrayList(this.bcK);
    }

    public List<String> PN() {
        return new ArrayList(this.bcL);
    }

    public List<String> PO() {
        return new ArrayList(this.bcM);
    }

    public List<String> o() {
        return new ArrayList(this.bcN);
    }

    public List<String> p() {
        return new ArrayList(this.bcO);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcK.add(str);
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcL.add(str);
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcM.add(str);
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bcN.add(str);
        }
    }

    private void e(String str) {
        if (str != null && !str.equals("")) {
            this.bcO.add(str);
        }
    }

    private void f(String str) {
        if (str != null && !str.equals("")) {
            this.bcP.add(str);
        }
    }
}

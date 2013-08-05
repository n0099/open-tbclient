package com.baidu.android.nebula.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private r f538a;
    private String b;
    private String c;
    private long d;
    private int e;

    public u() {
        this.f538a = r.UNKNOWN;
        this.d = -1L;
    }

    public u(JSONObject jSONObject) {
        this.f538a = r.UNKNOWN;
        this.d = -1L;
        try {
            this.c = jSONObject.getString("PackageName");
            this.e = jSONObject.getInt("VersionCode");
            this.d = jSONObject.getLong("Signmd5");
        } catch (JSONException e) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(u uVar) {
        boolean z = this.c != null && this.c.equals(uVar.c);
        boolean z2 = this.e == uVar.e;
        boolean z3 = this.d == uVar.d;
        if (z) {
            return (z2 && z3) ? 0 : 1;
        }
        return -1;
    }

    public long a(Context context) {
        PackageInfo a2;
        if (this.d == -1 && (a2 = f.a(context, this.c)) != null) {
            this.d = f.a(f.a(a2.signatures[0].toCharsString().getBytes()));
        }
        return this.d;
    }

    public r a() {
        return this.f538a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(r rVar) {
        this.f538a = rVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.c;
    }

    public JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("PackageName", b());
            jSONObject.put("VersionCode", c());
            if (context != null) {
                jSONObject.put("Signmd5", a(context));
            } else {
                jSONObject.put("Signmd5", this.d);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void b(String str) {
        this.c = str;
    }

    public int c() {
        return this.e;
    }

    public JSONObject d() {
        return b((Context) null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("[key=").append(this.b).append("]packagename=").append(this.c).append("]mOperationCode=").append(this.f538a).append("]versioncode=").append(this.e).append("]signmd5=").append(this.d).append("]]");
        return sb.toString();
    }
}

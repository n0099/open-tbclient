package com.baidu.mobads.g;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements Parcelable {
    public static final Parcelable.Creator<e> a = new f();
    private JSONObject b;
    private double c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(Parcel parcel, f fVar) {
        this(parcel);
    }

    public e(String str) {
        try {
            this.b = new JSONObject(str);
            this.c = this.b.getDouble("version");
            this.d = this.b.getString("url");
            this.e = this.b.getString("sign");
            this.h = 1;
            this.f = "";
            this.g = 0;
        } catch (JSONException e) {
            this.h = 0;
        }
        this.h = c() == null ? 0 : 1;
    }

    public e(e eVar, String str, Boolean bool) {
        this.c = eVar.b();
        this.d = eVar.c();
        this.e = eVar.d();
        this.h = eVar.a().booleanValue() ? 1 : 0;
        this.f = str;
        this.g = bool.booleanValue() ? 1 : 0;
    }

    private e(Parcel parcel) {
        this.e = parcel.readString();
        this.h = parcel.readInt();
        this.d = parcel.readString();
        this.c = parcel.readDouble();
        this.f = parcel.readString();
        this.g = parcel.readInt();
    }

    public Boolean a() {
        return Boolean.valueOf(this.h == 1);
    }

    public double b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeInt(this.h);
        parcel.writeString(this.d);
        parcel.writeDouble(this.c);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
    }
}

package com.baidu.mobads.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static final Parcelable.Creator<e> f8271a = new f();

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f8272b;

    /* renamed from: c  reason: collision with root package name */
    public double f8273c;

    /* renamed from: d  reason: collision with root package name */
    public String f8274d;

    /* renamed from: e  reason: collision with root package name */
    public String f8275e;

    /* renamed from: f  reason: collision with root package name */
    public String f8276f;

    /* renamed from: g  reason: collision with root package name */
    public int f8277g;

    /* renamed from: h  reason: collision with root package name */
    public int f8278h;

    public /* synthetic */ e(Parcel parcel, f fVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f8278h == 1);
    }

    public double b() {
        return this.f8273c;
    }

    public String c() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().replaceURLWithSupportProtocol(this.f8274d);
    }

    public String d() {
        return this.f8275e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f8276f;
    }

    public String toString() {
        return this.f8272b.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8275e);
        parcel.writeInt(this.f8278h);
        parcel.writeString(this.f8274d);
        parcel.writeDouble(this.f8273c);
        parcel.writeString(this.f8276f);
        parcel.writeInt(this.f8277g);
    }

    public e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8272b = jSONObject;
            this.f8273c = jSONObject.getDouble("version");
            this.f8274d = this.f8272b.getString("url");
            this.f8275e = this.f8272b.getString("sign");
            this.f8278h = 1;
            this.f8276f = "";
            this.f8277g = 0;
        } catch (JSONException unused) {
            this.f8278h = 0;
        }
        this.f8278h = c() == null ? 0 : 1;
    }

    public e(e eVar, String str, Boolean bool) {
        this.f8273c = eVar.b();
        this.f8274d = eVar.c();
        this.f8275e = eVar.d();
        this.f8278h = eVar.a().booleanValue() ? 1 : 0;
        this.f8276f = str;
        this.f8277g = bool.booleanValue() ? 1 : 0;
    }

    public e(Parcel parcel) {
        this.f8275e = parcel.readString();
        this.f8278h = parcel.readInt();
        this.f8274d = parcel.readString();
        this.f8273c = parcel.readDouble();
        this.f8276f = parcel.readString();
        this.f8277g = parcel.readInt();
    }
}

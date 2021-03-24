package com.baidu.mobads.g;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public static final Parcelable.Creator<e> f8270a = new f();

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f8271b;

    /* renamed from: c  reason: collision with root package name */
    public double f8272c;

    /* renamed from: d  reason: collision with root package name */
    public String f8273d;

    /* renamed from: e  reason: collision with root package name */
    public String f8274e;

    /* renamed from: f  reason: collision with root package name */
    public String f8275f;

    /* renamed from: g  reason: collision with root package name */
    public int f8276g;

    /* renamed from: h  reason: collision with root package name */
    public int f8277h;

    public /* synthetic */ e(Parcel parcel, f fVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f8277h == 1);
    }

    public double b() {
        return this.f8272c;
    }

    public String c() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls().replaceURLWithSupportProtocol(this.f8273d);
    }

    public String d() {
        return this.f8274e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f8275f;
    }

    public String toString() {
        return this.f8271b.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8274e);
        parcel.writeInt(this.f8277h);
        parcel.writeString(this.f8273d);
        parcel.writeDouble(this.f8272c);
        parcel.writeString(this.f8275f);
        parcel.writeInt(this.f8276g);
    }

    public e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8271b = jSONObject;
            this.f8272c = jSONObject.getDouble("version");
            this.f8273d = this.f8271b.getString("url");
            this.f8274e = this.f8271b.getString("sign");
            this.f8277h = 1;
            this.f8275f = "";
            this.f8276g = 0;
        } catch (JSONException unused) {
            this.f8277h = 0;
        }
        this.f8277h = c() == null ? 0 : 1;
    }

    public e(e eVar, String str, Boolean bool) {
        this.f8272c = eVar.b();
        this.f8273d = eVar.c();
        this.f8274e = eVar.d();
        this.f8277h = eVar.a().booleanValue() ? 1 : 0;
        this.f8275f = str;
        this.f8276g = bool.booleanValue() ? 1 : 0;
    }

    public e(Parcel parcel) {
        this.f8274e = parcel.readString();
        this.f8277h = parcel.readInt();
        this.f8273d = parcel.readString();
        this.f8272c = parcel.readDouble();
        this.f8275f = parcel.readString();
        this.f8276g = parcel.readInt();
    }
}

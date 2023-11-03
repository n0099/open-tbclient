package com.baidu.android.pushservice.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.pushservice.w.k;
/* loaded from: classes.dex */
public class LocalPushMsg implements Parcelable {
    public static final Parcelable.Creator<LocalPushMsg> CREATOR = new a();
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final String f;
    public final String g;
    public final long h;
    public String i;
    public byte[] j;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<LocalPushMsg> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocalPushMsg createFromParcel(Parcel parcel) {
            return new LocalPushMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocalPushMsg[] newArray(int i) {
            return new LocalPushMsg[i];
        }
    }

    public LocalPushMsg(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readLong();
        this.i = parcel.readString();
        parcel.readByteArray(this.j);
    }

    public LocalPushMsg(k kVar, String str) {
        this.a = kVar.a();
        this.b = kVar.h();
        this.c = kVar.i();
        this.d = kVar.q();
        this.e = kVar.e();
        this.f = kVar.p();
        this.g = kVar.b();
        this.h = kVar.c();
        this.i = str;
        this.j = kVar.n();
    }

    public LocalPushMsg(String str, String str2, int i, int i2, long j, String str3, String str4, long j2, String str5, byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = str3;
        this.g = str4;
        this.h = j2;
        this.i = str5;
        this.j = bArr;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.g;
    }

    public long c() {
        return this.h;
    }

    public long d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.c;
    }

    public byte[] i() {
        return this.j;
    }

    public String j() {
        return this.f;
    }

    public String toString() {
        return "LocalPushMsg{mAppId='" + this.a + "', mMsgId='" + this.b + "', mNotifyId=" + this.c + ", mMsgType=" + this.d + ", mIntervalTime=" + this.e + ", mStartTime='" + this.f + "', mEndTime='" + this.g + "', mExpireTime=" + this.h + ", mMsgBody='" + this.i + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeString(this.i);
        parcel.writeByteArray(this.j);
    }
}

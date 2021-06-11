package com.baidu.sofire.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CallArgs implements Parcelable {
    public static final Parcelable.Creator<CallArgs> CREATOR = new Parcelable.Creator<CallArgs>() { // from class: com.baidu.sofire.core.CallArgs.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CallArgs createFromParcel(Parcel parcel) {
            return new CallArgs(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CallArgs[] newArray(int i2) {
            return new CallArgs[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f10162a;

    /* renamed from: b  reason: collision with root package name */
    public int f10163b;

    /* renamed from: c  reason: collision with root package name */
    public String f10164c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f10165d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f10166e;

    /* renamed from: f  reason: collision with root package name */
    public Object f10167f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10162a);
        parcel.writeInt(this.f10163b);
        parcel.writeString(this.f10164c);
        parcel.writeArray(this.f10166e);
        parcel.writeArray(this.f10165d);
        parcel.writeValue(this.f10167f);
    }

    public CallArgs(Parcel parcel) {
        this.f10162a = parcel.readInt();
        this.f10163b = parcel.readInt();
        this.f10164c = parcel.readString();
        this.f10166e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10165d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10167f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}

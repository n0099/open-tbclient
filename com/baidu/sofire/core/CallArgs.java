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
    public int f10100a;

    /* renamed from: b  reason: collision with root package name */
    public int f10101b;

    /* renamed from: c  reason: collision with root package name */
    public String f10102c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f10103d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f10104e;

    /* renamed from: f  reason: collision with root package name */
    public Object f10105f;

    public CallArgs() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f10100a);
        parcel.writeInt(this.f10101b);
        parcel.writeString(this.f10102c);
        parcel.writeArray(this.f10104e);
        parcel.writeArray(this.f10103d);
        parcel.writeValue(this.f10105f);
    }

    public CallArgs(Parcel parcel) {
        this.f10100a = parcel.readInt();
        this.f10101b = parcel.readInt();
        this.f10102c = parcel.readString();
        this.f10104e = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10103d = parcel.readArray(CallArgs.class.getClassLoader());
        this.f10105f = parcel.readValue(CallArgs.class.getClassLoader());
    }
}
